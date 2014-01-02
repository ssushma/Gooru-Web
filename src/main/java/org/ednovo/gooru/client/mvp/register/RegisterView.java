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
package org.ednovo.gooru.client.mvp.register;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.register.ParentRegisterVc;
import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;
import org.ednovo.gooru.client.mvp.home.register.RegistrationConfirmationVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.DateBoxUc;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * This file is used to register a new user after check availability and validation  
 */
public class RegisterView extends BasePopupViewWithHandlers<RegisterUiHandlers> implements IsRegisterView, MessageProperties {


	private static final String REGISTER_HEADER = "Register";

	@UiField(provided = true)
	RegisterCBundle res;

	private AppPopUp appPopUp;
	
	@UiField
	TextBox emailIdTxtBox;

	@UiField
	Anchor cancelAnr;

	@UiField
	BlueButtonUc goBtnUc;

	@UiField
	ErrorLabelUc dateValidationUc;

	@UiField
	ErrorLabelUc emailValidationUc;

	@UiField
	SimplePanel dateSimPanel;

	private DateBoxUc dateBoxUc;

	protected UserDo userDo;

	private ParentRegisterVc parentRegisterVc;

	private SimpleAsyncCallback<UserDo> registerAsyncCallback;

	private String dob;
	
	private static final String LOGIN_YOUR_EXISTING_ACCOUNT = "The email address specified already exists with in Gooru. Please use sign-in to log in to your existing account.";
	
	private static final String PARENT = "Parent";
	
	private static final String EMAIL = "email";
	
	private static final String BIRTH_DAY = "birthday";
	
	private static final String GOORU_UID = "gooruUid";
	
	private static final String ACCOUNT_TYPE = "accountType";
	
	private static final String DATE_OF_BIRTH = "dateOfBirth";
	
	private static final String FIRST_NAME = "firstName";
	
	private static final String FIRSTNAME = "firstname";
	
	private static final String USER_NAME = "userName";
	
	private static final String PASSWORD = "password";
	
	private static final String EMAIL_ID = "emailId";
	
	private static final String ORGANIZATION_CODE = "organizationCode";
	
	private static final String CHILD_DOB = "childDOB";
	
	private static final String LAST_NAME = "lastName";
	
	private static final String LASTNAME = "lastname";
	
	private static final String GOORU = "gooru";
	
	private static final String PWD_VALUE = "041299";
	
	private static final String AT_SYMBOL = "@";
	
	private static final String NON_SYMBOL = "NonParent";

	
	
	private static RegisterViewUiBinder uiBinder = GWT.create(RegisterViewUiBinder.class);

	interface RegisterViewUiBinder extends UiBinder<Widget, RegisterView> {
	}

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public RegisterView(EventBus eventBus) {
		
		super(eventBus);
		hideFromPopup(true);
		this.res = RegisterCBundle.INSTANCE;
		res.css().ensureInjected();
		
		appPopUp = new AppPopUp();
		
		appPopUp.setContent(REGISTER_HEADER, uiBinder.createAndBindUi(this));
		appPopUp.setStyleName(RegisterCBundle.INSTANCE.css().registerPopupStyle());
		RegisterCBundle.INSTANCE.css().ensureInjected();

		dateBoxUc = new DateBoxUc(true,false,false);
		dateSimPanel.add(dateBoxUc);
		dateValidationUc.setStyleName(RegisterCBundle.INSTANCE.css()
				.registerErrorLabel());
		emailValidationUc.setStyleName(RegisterCBundle.INSTANCE.css()
				.registerErrorLabel());
		emailIdTxtBox.setStyleName(RegisterCBundle.INSTANCE.css().emailTxtBox());
		dateBoxUc.getDateBox().addFocusHandler(new OnDateFocus());
		dateBoxUc.getDateBox().addBlurHandler(new OnDateBlur());
		dateBoxUc.addDomHandler(new OnDateFocus(), FocusEvent.getType());
		emailIdTxtBox.addFocusHandler(new OnEmailFocus());
		emailIdTxtBox.addBlurHandler(new OnEmailBlur());

		dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());
		
		emailValidationUc.setVisible(false);
		dateValidationUc.setVisible(false);
		
		this.setAutoHideOnNavigationEventEnabled(true);
	    
		appPopUp.setGlassEnabled(true);
		appPopUp.setAutoHideEnabled(true);
		appPopUp.setAutoHideOnHistoryEventsEnabled(false);
		this.center();
		/*GlassPanel glassPanel = new GlassPanel
				(true);
		glassPanel.setStyleName("gwt-PopupPanelGlass");
		RootPanel.get().add(glassPanel,0,0);*/
	}

	/**
	 * It will return the representation of a view as the widget
	 */
	@Override
	public Widget asWidget() {
		return appPopUp;
	}
	/**
	 * To get the place tokens.
	 */
	@Override
	protected String getDefaultView() {
		return PlaceTokens.HOME;
	}
	/**
	 * Cancel the register popup
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("cancelAnr")
	public void onCancelClick(ClickEvent clickEvent) {
	
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
	}

	
	/**
	 * if ok button is clicked it calls the user check availability method 
	 * @param event instance of {@link ClickEvent}
	 */
	@UiHandler("goBtnUc")
	public void onGoClick(ClickEvent event) {
		checkAvailability(NON_SYMBOL, hasValidateData(), emailIdTxtBox.getText());
	}

	/**
	 * Checks user availability with user email id and user account type  
	 * 
	 * @param accountType user account type nonParent, parent, child
	 * @param isValid true if email id satisfy the condition else false
	 * @param emailId of the user that is mandatory to check availability   
	 */
	private void checkAvailability(final String accountType, boolean isValid,
			final String emailId) {
		if (isValid) {
			try {
				AppClientFactory
						.getInjector()
						.getUserService()
						.getEmailId(emailId,
								new SimpleAsyncCallback<UserDo>() {
									@Override
									public void onSuccess(UserDo user) {
										validateAvailability(user, accountType,
												emailId);
									}
								});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Send confirmation mail to user after successful registration
	 * @param params  contains emailId, accountType, dataOfBirth 
	 */
	private void sendConfirmationMail(Map<String, String> params) {

		AppClientFactory
				.getInjector()
				.getUserService()
				.resendConfirmationMail(params,
						new SimpleAsyncCallback<Object>() {
							@Override
							public void onSuccess(Object result) {
								if (parentRegisterVc != null) {
									parentRegisterVc.getPopupPanel().hide();
								}
							}
						});
	}

	/**
	 * validate the user availability after check availability calls,
	 * validate the email id already has been taken by some one and validate the confirm status of user account
	 * If emailId already has been taken by some one it brings alert popup
	 * 
	 * @param user instance of {@link UserDo} which has user all user info
	 * @param accountType of user 
	 * @param emailId of user
	 */
	private void validateAvailability(UserDo user, String accountType,
			String emailId) {
		if (!user.isAvailability() && user.getConfirmStatus() == 0) {
			this.hide();
			if (parentRegisterVc != null) {
				parentRegisterVc.getPopupPanel().hide();
			}
			new RegistrationConfirmationVc();
			registerUser(accountType, emailId, dob);
		} else if (user.isAvailability() && user.getConfirmStatus() == 0) {
			this.hide();
			Map<String, String> params = new HashMap<String, String>();
			params.put(GOORU_UID, user.getGooruUId());
			params.put(ACCOUNT_TYPE, accountType);
			sendConfirmationMail(params);
			new AlertContentUc(
					GL0065,
					GL0092);

		} else if (user.isAvailability() && user.getConfirmStatus() == 1) {
			if (!accountType.equalsIgnoreCase(PARENT)) {
				new AlertContentUc(
						GL0065,
						LOGIN_YOUR_EXISTING_ACCOUNT);
			} else {
				Map<String, String> params = new HashMap<String, String>();
				params.put(GOORU_UID, user.getGooruUId());
				params.put(ACCOUNT_TYPE, accountType);
				params.put(DATE_OF_BIRTH, dob);
				sendConfirmationMail(params);
				if (parentRegisterVc != null) {
					parentRegisterVc.getPopupPanel().hide();
				}
				new RegistrationConfirmationVc();
			}
		}
	}

	/**
	 * Register a new user after check availability and validation  
	 * @param accountType of user 
	 * @param email of user
	 * @param dob of user
	 */
	private void registerUser(String accountType, String email, String dob) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(FIRST_NAME, FIRSTNAME);
		params.put(LAST_NAME, LASTNAME);
		params.put(USER_NAME, email);
		params.put(ACCOUNT_TYPE, accountType);
		params.put(DATE_OF_BIRTH, dob);
		if (accountType.equalsIgnoreCase(PARENT)) {
			params.put(CHILD_DOB, dob);
		}
		params.put(PASSWORD, PWD_VALUE);
		params.put(EMAIL_ID, email);
		params.put(ORGANIZATION_CODE, GOORU);
		AppClientFactory.getInjector().getUserService()
				.registerUser(params, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo user) {
					}
				});
	}

	/**
	 * Validate emailId and dateOfBirth 
	 * @return true if emailId,dateOfBirth are satisfy the condition else false
	 */
	private boolean hasValidateData() {
		String email = emailIdTxtBox.getText();
		dob = dateBoxUc.getDateBox().getText();
		boolean isValid = true;
		if ((email == null || (email != null && email.isEmpty()))
				&& (dob == null || (dob != null && dob.isEmpty()))) {
			emailValidationUc
					.setText(StringUtil.generateMessage(GL0082, EMAIL));
			emailValidationUc.setVisible(true);
			dateValidationUc.setText(StringUtil.generateMessage(GL0082,
					BIRTH_DAY));
			dateValidationUc.setVisible(true);
			dateBoxUc.addStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().addStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			isValid = false;
		}
		if (email == null || (email != null && email.isEmpty())) {
			emailValidationUc.setVisible(true);
			emailValidationUc
					.setText(StringUtil.generateMessage(GL0082, EMAIL));
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			isValid = false;
		}
		if (dob == null || (dob != null && dob.isEmpty())) {
			dateBoxUc.addStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().addStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
			dateValidationUc.setText(StringUtil.generateMessage(GL0082,
					BIRTH_DAY));
			dateValidationUc.setVisible(true);
			isValid = false;
		}
		if ((email != null && !email.isEmpty()) && !email.contains(AT_SYMBOL)) {
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			emailValidationUc.setVisible(true);
			emailValidationUc
					.setText(StringUtil.generateMessage(GL0067, EMAIL));
			isValid = false;
		}
		if (((email != null && !email.isEmpty()) && !email.contains(AT_SYMBOL))
				&& (dob == null || (dob != null && dob.isEmpty()))) {
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			dateBoxUc.addStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().addStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
			emailValidationUc
					.setText(StringUtil.generateMessage(GL0067, EMAIL));
			emailValidationUc.setVisible(true);
			dateValidationUc.setVisible(true);
			isValid = false;
		}
		return isValid;
	}
	/**
	 * 
	 * @fileName : RegisterView.java
	 *
	 * @description : Date Focus handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 31-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnDateFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			dateBoxUc.removeStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
			if (dateValidationUc.isVisible()) {
				dateValidationUc.setVisible(false);
			}

		}
	}
	/**
	 * 
	 * @fileName : RegisterView.java
	 *
	 * @description : To validate parentRegisterVc on Done Click handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 31-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnDoneClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox().getText()
					.isEmpty()) && dateBoxUc.hasValidateDate()) {
				Date date = dateBoxUc.getValue();
				int age = getAge(date);
				if (age < 13) {
					dob = dateBoxUc.getDate();
					hide();
					parentRegisterVc = new ParentRegisterVc();
					parentRegisterVc.getConfirmationButton().addClickHandler(
							new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									checkAvailability(PARENT,
											parentRegisterVc.hasValidateData(),
											parentRegisterVc.getParentEmailId());
								}
							});
				}
			} else {
				dateBoxUc.getDatePickerUc().hide();
			}
		}
	}
	/**
	 * 
	 * @fileName : RegisterView.java
	 *
	 * @description : Date blur handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 31-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnDateBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			dateBoxUc.removeStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
		}
	}
	/**
	 * 
	 * @fileName : RegisterView.java
	 *
	 * @description : Email focus handler
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 31-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnEmailFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			if (emailValidationUc.isVisible()) {
				emailValidationUc.setVisible(false);
			}
			emailIdTxtBox.removeStyleName(RegisterCBundle.INSTANCE.css()
					.errorBoxStyle());
		}
	}
	/**
	 * 
	 * @fileName : RegisterView.java
	 *
	 * @description : Email blur handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 31-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnEmailBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			hasValidateData();
		}
	}

	/**
	 * @return {@link UserDo} instance
	 */
	public UserDo getUserDo() {
		return userDo;
	}
	/**
	 * 
	 * @function getRegisterAsyncCallback 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns SimpleAsyncCallback
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<UserDo> getRegisterAsyncCallback() {
		return registerAsyncCallback;
	}
	/**
	 * 
	 * @function setRegisterAsyncCallback 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :setter for registerAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param registerAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setRegisterAsyncCallback(
			SimpleAsyncCallback<UserDo> registerAsyncCallback) {
		this.registerAsyncCallback = registerAsyncCallback;
	}
	
	/**
	 * Calculate the age from entered dataOfbirth
	 * @param birthDate to validate the age
	 * @return age
	 */
	private int getAge(Date birthDate){
		long ageInMillis = new Date().getTime() - birthDate.getTime();
		Date age = new Date(ageInMillis);
		return age.getYear()- 70;
	}
	/**
	 * This is used to clear the data.
	 */
	@Override
	public void clearAll() {
		emailIdTxtBox.setText(null);	
		emailIdTxtBox.setFocus(true);	
		dateBoxUc.getDateBox().setText(null);
		dateBoxUc.getDateBox().setFocus(true);
		emailIdTxtBox.removeStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
	    dateValidationUc.setVisible(false);
		emailValidationUc.setVisible(false);
		
	}
	
	
}
