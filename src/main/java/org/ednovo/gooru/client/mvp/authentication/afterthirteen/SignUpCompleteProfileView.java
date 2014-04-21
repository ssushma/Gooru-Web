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

import org.ednovo.gooru.client.PlaceTokens;
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
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewCloseHandler;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class SignUpCompleteProfileView extends
		PopupViewWithUiHandlers<SignUpCompleteProfileUiHandler> implements
		IsSignUpCompleteProfile,MessageProperties {

	private static SignUpCompleteProfileViewUiBinder uiBinder = GWT
			.create(SignUpCompleteProfileViewUiBinder.class);

	interface SignUpCompleteProfileViewUiBinder extends
			UiBinder<Widget, SignUpCompleteProfileView> {
	}

	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblHeading, lblSubHeading, lblchangePassword,
			userName,lblUpdating,quriesText,pleaseContactText;
	@UiField
	Image profileImage;
	@UiField Anchor supportLink;
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

	@Inject
	public SignUpCompleteProfileView(EventBus eventBus) {
		super(eventBus);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
	}

	@Override
	public void displayView() {
		appPopUp = new AppPopUp(GL0697);
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		/*appPopUp.setStyleName(RegisterCBundle.INSTANCE.css()
				.registerPopupStyle());
*/
		appPopUp.setGlassEnabled(true);
		appPopUp.addStyleName(SignUpCBundle.INSTANCE.css().popupBackground());
		appPopUp.setGlassStyleName(SignUpCBundle.INSTANCE.css().signUpPopUpGlassCss());
		//appPopUp.setAutoHideOnHistoryEventsEnabled(false);

		//appPopUp.getElement().getStyle().setZIndex(99);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
	//	appPopUp.getElement().getStyle().setBackgroundColor("transparent");
		
		
		setUiAndIds();
		appPopUp.center();
	}

	public void setUiAndIds() {
		lblTitle.setText(GL0481
				+ GL_SPL_EXCLAMATION);
		lblHeading.setText(GL0492
				+ GL_SPL_EXCLAMATION);
		lblSubHeading.setText(GL0493);
		profileImage.setUrl("images/signup/user.png");
		lblchangePassword.setText(GL0494);
		txtFirstName.setPlaceholder(GL1140);
		txtlastName.setPlaceholder(GL1141);
		txtAreaAbout.getElement().setAttribute("placeholder",
				GL1142);
		txtPassword.setPlaceholder(GL1143);
		txtConfirmPassword.setPlaceholder(GL1144);
		btnUpdateProfileLater.setText(GL0495);
		btnSubmit.setText(GL0486);
		btnSubmit.getElement().setId("btnSubmit");
		btnUpdateProfileLater.getElement().setId("btnUpdateProfileLater");
		passwordContainer.setVisible(false);
		btnEditImage.setText(GL0138);
		btnEditImage.getElement().setId("btnEditImage");
		btnSubmit.getElement().setAttribute("style", "margin-left: 10px");
		userName.setText(AppClientFactory.getLoggedInUser().getUsername());
		quriesText.setText(GL1139+GL_GRR_COMMA);
		pleaseContactText.setText(GL1145);
		pleaseContactText.getElement().setAttribute("style", "width: 80%;position: absolute;");
		supportLink.setText(GL0299);
		supportLink.setHref(GL1055);
		supportLink.getElement().setAttribute("style","margin-left:100px;");
		passwordValidUc.setVisible(false);
		lblUpdating.setVisible(false);
		profileImage.setWidth("96px");
		profileImage.setHeight("98px");
		txtPassword.addKeyUpHandler(new OnKeyUpHandler());
		txtFirstName.addKeyUpHandler(new OnKeyUpHandler());
		txtlastName.addKeyUpHandler(new OnKeyUpHandler());
		txtConfirmPassword.addKeyUpHandler(new OnKeyUpHandler());
	}

	@UiHandler("lblCancel")
	public void onClickLblCancel(ClickEvent event) {
		MixpanelUtil.close_signUp();
		Window.enableScrolling(true);
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
			
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
		
	}

	@UiHandler("lblchangePassword")
	public void onClicklblchangePassword(ClickEvent event) {
		passwordContainer.setVisible(true);
	}

	@UiHandler("btnEditImage")
	public void onClickbtnEditImage(ClickEvent event) {
		getUiHandlers().showUploadProfileImageWidget();
	}

	@UiHandler("btnSubmit")
	public void onClickbtnSubmit(ClickEvent event) {
		if (validateUserInput()) {
			MixpanelUtil.Registration_turns13_submit_profile();
			appPopUp.hide();
			lblUpdating.setText(GL1138);
			lblUpdating.setVisible(true);
			btnSubmit.setVisible(false);
			getUiHandlers().updateProfile(txtFirstName.getText(),
					txtlastName.getText(), txtAreaAbout.getText(),txtConfirmPassword.getText()
			);
			
		}
	}

	@UiHandler("btnUpdateProfileLater")
	public void onClickbtnUpdateProfileLater(ClickEvent event) {
		appPopUp.hide();
		SignUpDontWorryView signUpDontWorryView = new SignUpDontWorryView();
		signUpDontWorryView.show();
		
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void center() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAutoHideOnNavigationEventEnabled(boolean autoHide) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCloseHandler(PopupViewCloseHandler popupViewCloseHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(int left, int top) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub

	}

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
						GL0071, "Password", "5"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
			if (!password.equalsIgnoreCase("") && password.length() >= 14) {
				txtPassword.addStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setText(StringUtil.generateMessage(
						GL0072, "Password", "<= 14"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
			 if (password.equalsIgnoreCase("PASSWORD")) {
			  txtPassword.addStyleName(res.css().errorMsgDisplay());
			  passwordValidUc
			  .setText(StringUtil.generateMessage(GL0076,
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
						GL0073, "Password"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}
		} catch (Exception e) {
		}
		RegExp reg = RegExp.compile(PWD_PATTERN, "gi");
		if (firstName.length() > 20) {
			txtFirstName.getElement().addClassName(res.css().errorMsgDisplay());
			firstNameValidUc.setText(StringUtil.generateMessage(
					GL0072, "First name", "<=20"));
			firstNameValidUc.setVisible(true);
			isValid = false;
		}

		 if (lastName.length() > 20) {
			txtlastName.getElement().addClassName(res.css().errorMsgDisplay());
			lastNameValidUc.setText(StringUtil.generateMessage(
					GL0072, "Last name", "<= 20"));
			lastNameValidUc.setVisible(true);
			isValid = false;
		}

		 if (!password.equalsIgnoreCase(confirmPassword)) {
			txtConfirmPassword.addStyleName(res.css().errorMsgDisplay());
			txtPassword.addStyleName(res.css().errorMsgDisplay());
			passwordValidUc.setText(GL0446);
			passwordValidUc.setVisible(true);
			isValid = false;
		}
		 if (!reg.test(password) && password.length() >= 5
				&& password.length() <= 14) {
			passwordValidUc.setText(StringUtil.generateMessage(
					GL0073, "Password"));
			passwordValidUc.setVisible(true);
			isValid = false;
		}
		 return isValid;
	}

	@Override
	public Label getUpdateButton() {
		return lblUpdating;
	}
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
