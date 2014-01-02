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
package org.ednovo.gooru.client.mvp.authentication.afterthirteen;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.authentication.uc.SignUpDontWorryView;
import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewCloseHandler;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
/**
 * 
 * @fileName : SignUpCompleteProfileView.java
 *
 * @description : This is the view for Signup complete popup.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SignUpCompleteProfileView extends
		PopupViewWithUiHandlers<SignUpCompleteProfileUiHandler> implements
		IsSignUpCompleteProfile {

	private static SignUpCompleteProfileViewUiBinder uiBinder = GWT
			.create(SignUpCompleteProfileViewUiBinder.class);

	interface SignUpCompleteProfileViewUiBinder extends
			UiBinder<Widget, SignUpCompleteProfileView> {
	}

	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblHeading, lblSubHeading, lblchangePassword,
			userName,lblUpdating;
	@UiField
	Image profileImage;
	@UiField
	TextBoxWithPlaceholder txtFirstName, txtlastName, txtPassword,
			txtConfirmPassword;
	@UiField
	TextArea txtAreaAbout;
	@UiField
	Button btnUpdateProfileLater, btnSubmit, btnEditImage;
	@UiField
	HTMLPanel passwordContainer;
	@UiField
	ErrorLabelUc lastNameValidUc, firstNameValidUc, passwordValidUc;
	private AppPopUp appPopUp;
	private static final String PWD_PATTERN = "[0-9]|[$@!#*%^/[/]}{()_&-+=.,<>;\\|]";
	/**
	 * Parameterized constructor for injecting the css and other resources.
	 * @param eventBus
	 */
	@Inject
	public SignUpCompleteProfileView(EventBus eventBus) {
		super(eventBus);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
	}
	/**
	 * This method is used to display the ppopup
	 */
	@Override
	public void displayView() {
		appPopUp = new AppPopUp("NoHeader");
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		appPopUp.setStyleName(RegisterCBundle.INSTANCE.css()
				.registerPopupStyle());

		appPopUp.setGlassEnabled(true);
		appPopUp.setAutoHideOnHistoryEventsEnabled(false);

		appPopUp.getElement().getStyle().setZIndex(99);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		appPopUp.getElement().getStyle().setBackgroundColor("transparent");
		setUiAndIds();
		appPopUp.center();
	}
	/**
	 * 
	 * @function setUiAndIds 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This will set the images and ID's for the fields.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setUiAndIds() {
		lblTitle.setText(MessageProperties.GL0481
				+ MessageProperties.GL_SPL_EXCLAMATION);
		lblHeading.setText(MessageProperties.GL0492
				+ MessageProperties.GL_SPL_EXCLAMATION);
		lblSubHeading.setText(MessageProperties.GL0493);
		profileImage.setUrl("images/signup/user.png");
		lblchangePassword.setText(MessageProperties.GL0494);
		txtFirstName.setPlaceholder("First name (optional)");
		txtlastName.setPlaceholder("Last name (optional)");
		txtAreaAbout.getElement().setAttribute("placeholder",
				"Tell us more about yourself! (optional)");
		txtPassword.setPlaceholder("New password (optional)");
		txtConfirmPassword.setPlaceholder("Confirm New password");
		btnUpdateProfileLater.setText(MessageProperties.GL0495);
		btnSubmit.setText(MessageProperties.GL0486);
		btnSubmit.getElement().setId("btnSubmit");
		btnUpdateProfileLater.getElement().setId("btnUpdateProfileLater");
		passwordContainer.setVisible(false);
		btnEditImage.setText(MessageProperties.GL0138);
		btnEditImage.getElement().setId("btnEditImage");
		btnSubmit.getElement().setAttribute("style", "margin-left: 10px");
		userName.setText(AppClientFactory.getLoggedInUser().getUsername());
		passwordValidUc.setVisible(false);
		lblUpdating.setVisible(false);
		profileImage.setWidth("96px");
		profileImage.setHeight("98px");
		txtPassword.addKeyUpHandler(new OnKeyUpHandler());
		txtFirstName.addKeyUpHandler(new OnKeyUpHandler());
		txtlastName.addKeyUpHandler(new OnKeyUpHandler());
		txtConfirmPassword.addKeyUpHandler(new OnKeyUpHandler());
	}
	/**
	 * @function onClickLblCancel 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of cancel.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblCancel")
	public void onClickLblCancel(ClickEvent event) {
		MixpanelUtil.close_signUp();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		appPopUp.hide();
		
	}
	/**
	 * 
	 * @function onClicklblchangePassword 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of change password.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("lblchangePassword")
	public void onClicklblchangePassword(ClickEvent event) {
		passwordContainer.setVisible(true);
	}
	/**
	 * 
	 * @function onClicklblchangePassword 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of edit image.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("btnEditImage")
	public void onClickbtnEditImage(ClickEvent event) {
		getUiHandlers().showUploadProfileImageWidget();
	}
	/**
	 * 
	 * @function onClicklblchangePassword 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of submit button.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("btnSubmit")
	public void onClickbtnSubmit(ClickEvent event) {
		if (validateUserInput()) {
			MixpanelUtil.Registration_turns13_submit_profile();
			appPopUp.hide();
			lblUpdating.setVisible(true);
			btnSubmit.setVisible(false);
			getUiHandlers().updateProfile(txtFirstName.getText(),
					txtlastName.getText(), txtAreaAbout.getText(),txtConfirmPassword.getText()
			);
			
		}
	}
	/**
	 * 
	 * @function onClicklblchangePassword 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of Update Profile Later button.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("btnUpdateProfileLater")
	public void onClickbtnUpdateProfileLater(ClickEvent event) {
		appPopUp.hide();
		SignUpDontWorryView signUpDontWorryView = new SignUpDontWorryView();
		signUpDontWorryView.show();
		
	}
	/**
	 * Which is responsible for returning the widget corresponding to that view
	 */
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void center() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void setAutoHideOnNavigationEventEnabled(boolean autoHide) {

	}

	@Override
	public void setCloseHandler(PopupViewCloseHandler popupViewCloseHandler) {

	}

	@Override
	public void setPosition(int left, int top) {

	}

	@Override
	public void show() {

	}

	@Override
	public void addToSlot(Object slot, Widget content) {

	}

	@Override
	public void removeFromSlot(Object slot, Widget content) {

	}

	@Override
	public void setInSlot(Object slot, Widget content) {

	}

	@Override
	public void reset() {

	}

	@Override
	public void onLoad() {

	}

	@Override
	public void onUnload() {

	}
	/**
	 * This method is used to set the updated user profile i
	 */
	@Override
	public void setUpdateProfileImage(String imageUrl) {
		profileImage.setUrl(imageUrl + "?" + Math.random());
		profileImage.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent event) {
				profileImage.setUrl("images/signup/user.png");
				
			}
		});
	}
	/**
	 * 
	 * @function validateUserInput 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used for validations.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public boolean validateUserInput() {
		String firstName = txtFirstName.getText().trim();
		String lastName = txtlastName.getText().trim();
		String password = txtPassword.getText().trim();
		boolean isValid = true;
		String confirmPassword = txtConfirmPassword.getText().trim();
		
		// TODO Validate password fields
		try {
			RegExp reg = RegExp.compile(PWD_PATTERN, "gi");
			if (!password.equalsIgnoreCase("") && password.length() < 5) {
				txtPassword.addStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setText(StringUtil.generateMessage(
						MessageProperties.GL0071, "Password", "5"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
			if (!password.equalsIgnoreCase("") && password.length() >= 14) {
				txtPassword.addStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setText(StringUtil.generateMessage(
						MessageProperties.GL0072, "Password", "<= 14"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
			 if (password.equalsIgnoreCase("PASSWORD")) {
			  txtPassword.addStyleName(res.css().errorMsgDisplay());
			  passwordValidUc
			  .setText(StringUtil.generateMessage(MessageProperties.GL0076,
			  "Password"));
			  passwordValidUc.setVisible(true); 
			  isValid = false;
			  }
			 
			 if ((!password.equalsIgnoreCase("") && !password.isEmpty())
					&& !reg.test(password) && password.length() >= 5
					&& password.length() <= 14
					&& !password.equalsIgnoreCase("PASSWORD")) {
				txtPassword.addStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setText(StringUtil.generateMessage(
						MessageProperties.GL0073, "Password"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
		} catch (Exception e) {
		}
		RegExp reg = RegExp.compile(PWD_PATTERN, "gi");
		if (firstName.length() > 20) {
			txtFirstName.getElement().addClassName(res.css().errorMsgDisplay());
			firstNameValidUc.setText(StringUtil.generateMessage(
					MessageProperties.GL0072, "First name", "<=20"));
			firstNameValidUc.setVisible(true);
			isValid = false;
		}

		 if (lastName.length() > 20) {
			txtlastName.getElement().addClassName(res.css().errorMsgDisplay());
			lastNameValidUc.setText(StringUtil.generateMessage(
					MessageProperties.GL0072, "Last name", "<= 20"));
			lastNameValidUc.setVisible(true);
			isValid = false;
		}

		 if (!password.equalsIgnoreCase(confirmPassword)) {
			txtConfirmPassword.addStyleName(res.css().errorMsgDisplay());
			txtPassword.addStyleName(res.css().errorMsgDisplay());
			passwordValidUc.setText(MessageProperties.GL0446);
			passwordValidUc.setVisible(true);
			isValid = false;
		}
		 if (!reg.test(password) && password.length() >= 5
				&& password.length() <= 14) {
			passwordValidUc.setText(StringUtil.generateMessage(
					MessageProperties.GL0073, "Password"));
			passwordValidUc.setVisible(true);
			isValid = false;
		}
		 return isValid;
	}
	/**
	 * This method is used to get the update label.
	 */
	@Override
	public Label getUpdateButton() {
		return lblUpdating;
	}
	/**
	 * 
	 * @fileName : SignUpCompleteProfileView.java
	 *
	 * @description : This inner class is used to handle the keyup handlers.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			passwordValidUc.setVisible(false);
			if (event.getSource() == txtFirstName) {
				txtFirstName.removeStyleName(res.css().errorMsgDisplay());
				firstNameValidUc.setVisible(false);
			} else if (event.getSource() == txtlastName) {
				txtlastName.removeStyleName(res.css().errorMsgDisplay());
				lastNameValidUc.setVisible(false);
			} else if (event.getSource() == txtPassword) {
				txtPassword.removeStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setVisible(false);
			} else if (event.getSource() == txtConfirmPassword) {
				txtConfirmPassword.removeStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setVisible(false);
			} 
		}

	}

}
