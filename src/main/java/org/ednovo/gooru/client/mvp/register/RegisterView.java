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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.user.UserDo;
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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class RegisterView extends BasePopupViewWithHandlers<RegisterUiHandlers> implements IsRegisterView {


	@UiField(provided = true)
	RegisterCBundle res;
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

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
	
	@UiField Label betaText,birthdayLbl,emailLbl;
	@UiField FlowPanel buttonContainer;

	private DateBoxUc dateBoxUc;

	protected UserDo userDo;

	private ParentRegisterVc parentRegisterVc;

	private SimpleAsyncCallback<UserDo> registerAsyncCallback;

	private String dob;
	
	private static final String LOGIN_YOUR_EXISTING_ACCOUNT = i18n.GL0214();
	
	private static final String REGISTER_HEADER = i18n.GL1203();
	
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
		birthdayLbl.setText(i18n.GL0211());
		birthdayLbl.getElement().setId("lblBirthdayLbl");
		birthdayLbl.getElement().setAttribute("alt",i18n.GL0211());
		birthdayLbl.getElement().setAttribute("title",i18n.GL0211());
		
		emailLbl.setText(i18n.GL0426());
		emailLbl.getElement().setId("lblEmailLbl");
		emailLbl.getElement().setAttribute("alt",i18n.GL0426());
		emailLbl.getElement().setAttribute("title",i18n.GL0426());
		
		goBtnUc.setText(i18n.GL0213());
		goBtnUc.getElement().setId("btnGoBtnUc");
		goBtnUc.getElement().setAttribute("alt",i18n.GL0213());
		goBtnUc.getElement().setAttribute("title",i18n.GL0213());
		
		cancelAnr.setText(i18n.GL0142());
		cancelAnr.getElement().setId("lnkCancelAnr");
		cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
		cancelAnr.getElement().setAttribute("title",i18n.GL0142());
		
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
		StringUtil.setAttributes(emailIdTxtBox, true);
		dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());
		
		emailValidationUc.setVisible(false);
		dateValidationUc.setVisible(false);
		
		
		betaText.getElement().setId("lblBetaText");
		dateSimPanel.getElement().setId("spnlDateSimPanel");
		dateValidationUc.getElement().setId("errlblDateValidationUc");
		emailIdTxtBox.getElement().setId("txtEmailIdTxtBox");
		emailValidationUc.getElement().setId("errlblEmailValidationUc");
		buttonContainer.getElement().setId("fpnlButtonContainer");
		
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


	@Override
	public Widget asWidget() {
		return appPopUp;
	}

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
					i18n.GL0065(),
					i18n.GL0092());

		} else if (user.isAvailability() && user.getConfirmStatus() == 1) {
			if (!accountType.equalsIgnoreCase(PARENT)) {
				new AlertContentUc(
						i18n.GL0065(),
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
					.setText(StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			emailValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			emailValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			
			emailValidationUc.setVisible(true);
			dateValidationUc.setText(StringUtil.generateMessage(i18n.GL0082(),
					BIRTH_DAY));
			dateValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0082(),
					BIRTH_DAY));
			dateValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0082(),
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
					.setText(StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			emailValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			emailValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0082(), EMAIL));
			
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			isValid = false;
		}
		if (dob == null || (dob != null && dob.isEmpty())) {
			dateBoxUc.addStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().addStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
			dateValidationUc.setText(StringUtil.generateMessage(i18n.GL0082(),
					BIRTH_DAY));
			dateValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0082(),
					BIRTH_DAY));
			dateValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0082(),
					BIRTH_DAY));
			dateValidationUc.setVisible(true);
			isValid = false;
		}
		if ((email != null && !email.isEmpty()) && !email.contains(AT_SYMBOL)) {
			emailIdTxtBox.addStyleName(RegisterCBundle.INSTANCE.css().errorBoxStyle());
			emailValidationUc.setVisible(true);
			emailValidationUc
					.setText(StringUtil.generateMessage(i18n.GL0067(), EMAIL));
			emailValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0067(), EMAIL));
			emailValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0067(), EMAIL));
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
					.setText(StringUtil.generateMessage(i18n.GL0067(), EMAIL));
			emailValidationUc.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0067(), EMAIL));
			emailValidationUc.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0067(), EMAIL));
			emailValidationUc.setVisible(true);
			dateValidationUc.setVisible(true);
			isValid = false;
		}
		return isValid;
	}

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

	private class OnDateBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			dateBoxUc.removeStyleName(RegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					RegisterCBundle.INSTANCE.css().gooruDateError());
		}
	}

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

	public SimpleAsyncCallback<UserDo> getRegisterAsyncCallback() {
		return registerAsyncCallback;
	}

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
