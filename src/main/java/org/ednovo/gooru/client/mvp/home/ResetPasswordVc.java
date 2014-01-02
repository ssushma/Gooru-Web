/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.home;

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ResetPasswordVc.java
 *
 * @description : Related to reset password popup.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ResetPasswordVc extends Composite implements MessageProperties {
	
	private static ResetPasswordVcUiBinder uiBinder = GWT
			.create(ResetPasswordVcUiBinder.class);

	interface ResetPasswordVcUiBinder extends UiBinder<Widget, ResetPasswordVc> {
	}

	@UiField
	Anchor resetPwdCancelAnr;

	@UiField
	BlueButtonUc sendMailBtnUc;

	@UiField
	TextBox resetConfirmPwdTxtBox;

	@UiField
	TextBox resetNewPwdTxtBox;

	@UiField
	ErrorLabelUc confirmPwdValidationUc;

	@UiField
	ErrorLabelUc newPwdValidationUc;

	private String resetToken;

	private AppPopUp appPopUp;
	
	private static final String PASSWORD_PATTERN = "[0-9]|[$@!#*%^/[/]}{()_&-+=.,<>;\\|]";

	/**
	 * Class constructor , create reset password popup and assign password reset token
	 * @param resetToken password token 
	 */
	public ResetPasswordVc(String resetToken) {
		appPopUp = new AppPopUp();
		this.resetToken = resetToken;
		appPopUp.setContent(GL0062, uiBinder.createAndBindUi(this));
		//appPopUp.addStyleName(HomeCBundle.INSTANCE.css().resetPasswordPopup());
		appPopUp.show();
		appPopUp.center();
		resetConfirmPwdTxtBox.getElement().setPropertyString("type", "password");
		resetNewPwdTxtBox.getElement().setPropertyString("type", "password");
		resetConfirmPwdTxtBox.getElement().setId("txtConfirmPwd");
		resetNewPwdTxtBox.getElement().setId("txtNewPwd");
		newPwdValidationUc.setStyleName(HomeCBundle.INSTANCE.css()
				.passwordErrorLabel());
		newPwdValidationUc.setVisible(false);
		confirmPwdValidationUc.setStyleName(HomeCBundle.INSTANCE.css()
				.passwordErrorLabel());
		confirmPwdValidationUc.setVisible(false);
		sendMailBtnUc.getElement().setId("btnSave");
		resetPwdCancelAnr.getElement().setId("lnkCancel");
		//resetNewPwd.addBlurHandler(new OnPasswordBlur());
		//resetConfirmPwd.addBlurHandler(new OnPasswordBlur());
		resetNewPwdTxtBox.addFocusHandler(new OnNewPasswordFocus());
		resetConfirmPwdTxtBox.addFocusHandler(new OnConfirmPasswordFocus());
		Window.enableScrolling(false);
		AppClientFactory.getEventBus().fireEvent(new SetHeaderZIndexEvent(99, false));
	}

	/**
	 * Check the password reset token has expired or not if not create success popup with their user name
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("sendMailBtnUc")
	public void onCancelClick(ClickEvent clickEvent) {
		if (validatePassword()) {
			AppClientFactory.getInjector().getUserService().resetCredential(this.getresetConfirmPwd(), resetToken,new SimpleAsyncCallback<Map<String, Object>>() {

				@Override
				public void onSuccess(Map<String, Object> result) {
		
					if (result != null && result.containsKey("username") && result.get("username").toString().length() > 0) {
						new ResetPwdSuccessVc(result.get("username").toString());
						
					}
					if (result != null && result.containsKey("tokenExpired") && result.get("tokenExpired") != null && result.get("tokenExpired").toString().length() > 0) {
						new AlertContentUc("Oops", StringUtil.generateMessage(GL0100, ""));
					}
					appPopUp.hide();
					Window.enableScrolling(true);
					AppClientFactory.getEventBus().fireEvent(new SetHeaderZIndexEvent(0, true));
				}
			});
		}
	}

	/**
	 * Takes to reset password link
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("resetPwdCancelAnr")
	public void onFormSubmit(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		AppClientFactory.getEventBus().fireEvent(new SetHeaderZIndexEvent(0, true));
		appPopUp.hide();
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
	}

	/**
	 * @return {@link BlueButtonUc} widget
	 *//*
	protected BlueButtonUc getConfirmationButton() {
		return sendMailBtnUc;
	}

	protected boolean hasValidateData() {
		return true;
	}
*/
	/**
	 * @return password 
	 */
	protected String getresetConfirmPwd() {
		return resetConfirmPwdTxtBox.getText();
	}

	/**
	 * Validate the password , that contain all requirement of password text
	 * @return true or false 
	 */
	public boolean validatePassword() {
		String newPassword = resetNewPwdTxtBox.getText();
		String confirmPassword = resetConfirmPwdTxtBox.getText();
		boolean isValid = true;
		try {
			RegExp reg = RegExp.compile(PASSWORD_PATTERN, "gi");
			boolean pwdChck =reg.test(newPassword);

			if ((newPassword == null || (newPassword != null && newPassword
					.isEmpty()))) {
				newPwdValidationUc.setVisible(true);
				resetNewPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				newPwdValidationUc.setText(StringUtil.generateMessage(GL0070,
						"Password"));
				isValid = false;
			}

			else if ((confirmPassword == null || (confirmPassword != null && confirmPassword
					.isEmpty()))) {
				confirmPwdValidationUc.setVisible(true);
				resetConfirmPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				confirmPwdValidationUc.setText(StringUtil.generateMessage(GL0070,
						"Confirm Password"));
				isValid = false;
			}
			
			else if (newPassword.length() > 0 && newPassword.length() < 5) {
				newPwdValidationUc.setVisible(true);
				resetNewPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				newPwdValidationUc.setText(StringUtil.generateMessage(GL0071,
						"Password", "5"));
				isValid = false;
			}
			
			else if (newPassword != null && newPassword.length() >= 14) {
				resetNewPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				newPwdValidationUc.setText(StringUtil.generateMessage(GL0072, "Password", "<= 14"));
				newPwdValidationUc.setVisible(true);
				isValid = false;
			}

			
			else if (!pwdChck) {
				resetNewPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				newPwdValidationUc.setText(StringUtil.generateMessage(GL0073,"Password"));
				newPwdValidationUc.setVisible(true);
				isValid = false;
			}
			
			

			else if ((!confirmPassword.equals(newPassword))) {
				confirmPwdValidationUc.setVisible(true);
				resetConfirmPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				confirmPwdValidationUc.setText(StringUtil.generateMessage(GL0069,
						"Passwords"));
				isValid = false;
			}

			else if ((newPassword != null && !newPassword.isEmpty())
					&& !pwdChck && newPassword.length() > 5
					&& newPassword.length() <= 14
					&& !newPassword.equalsIgnoreCase("PASSWORD")) {
				newPwdValidationUc.setVisible(true);
				resetNewPwdTxtBox.addStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
				newPwdValidationUc.setText(StringUtil.generateMessage(GL0073,"Password"));
				isValid = false;
			}

		} catch (Exception e) {

		}
		return isValid;
	}
/*
	private class OnPasswordBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			validatePassword();
		}
	}*/

	/**
	 * @author Search Team
	 * Focus on new password text box 
	 *
	 */
	private class OnNewPasswordFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			if (newPwdValidationUc.isVisible()) {
				newPwdValidationUc.setVisible(false);
				resetNewPwdTxtBox.removeStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
			}
		}
	}

	/**
	 * @author Search Team
	 * Focus on confirm password text box 
	 *
	 */
	private class OnConfirmPasswordFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			if (confirmPwdValidationUc.isVisible()) {
				confirmPwdValidationUc.setVisible(false);
				resetConfirmPwdTxtBox.removeStyleName(HomeCBundle.INSTANCE.css()
						.resetPwdTextError());
			}
		}
	}

}
