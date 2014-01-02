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
package org.ednovo.gooru.client.mvp.authentication.uc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.home.register.NewRegisterCBundle;
import org.ednovo.gooru.client.mvp.home.register.ParentRegisterVc;
import org.ednovo.gooru.client.mvp.home.register.RegistrationConfirmationVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.DateBoxUc;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Clear;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

	/**
	 * 
	 * @fileName : CreateAccountUc.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
public abstract class CreateAccountUc extends PopupPanel implements MessageProperties{

	@UiField(provided = true)
	SignUpCBundle res;

	@UiTemplate("CreateAccountUc.ui.xml")
	interface Binder extends UiBinder<Widget, CreateAccountUc> {

	}

	private static final Binder binder = GWT.create(Binder.class);

	@UiField
	Label lblPleaseFill, lblPickWisely, lblQuestionMark, lblWhyEnterBirthday,
			lblWhyEnterBirthdayDesc, lblNameTooltipContent,
			lblEmailTooltipContent, lblPasswordTooltipContent;

	@UiField
	Label lblTeacher, lblStudent, lblParent, lblOther, lblPleaseWait,
			lblQuestionMarkNeedParentAccount, lblWhyNeedParent,
			lblWhyNeedParentDesc;

	@UiField
	TextBoxWithPlaceholder txtChooseUsername, txtFirstName, txtLastName,
			txtChooseEmail, txtChoosePassword, txtConfirmPassword;

	@UiField
	Anchor ancCopyRight, ancTermsAndPrivacy, ancPrivacy;

	@UiField
	Button btnSignUp;

	@UiField
	HTMLPanel rdTeacher, rdStudent, rdParent, rdOther, panelOther, panelTeacher, panelStudent, panelParent;

	@UiField
	HTMLPanel panelUserNamePopUp, panelPublic, panelEmail, panelPassword;

	@UiField
	HTMLEventPanel panelDataOfBirth;

	@UiField
	SimplePanel sPanelDateOfBirth;

	@UiField
	HTMLPanel panelBelowThirteen, panelAboveThirteen, tootltipContainer;

	@UiField
	ErrorLabelUc dateValidationUc, passwordValidUc, lblSelectRole,
			userNameValidUc, parentEmailValidUc, emailValidUc, firstNameValidUc, lastNameValidUc;

	@UiField
	Label lblNeedParentsAccount;
	@UiField
	Label lblMyParentHasGooruAccount;
	@UiField
	TextBoxWithPlaceholder txtParentEmailId;
	@UiField
	Label lblOr;
	@UiField
	Label lblMyParentDontHaveAccount;
	@UiField
	Label lblGetCorrectEmail;
	@UiField
	Anchor ancParentRegister;
	@UiField
	InlineLabel lblAgree;

	ParentRegisterVc parentRegisterVc = null;

	private DateBoxUc dateBoxUc;

	RadioButton rbTeacher;
	RadioButton rbStudent;
	RadioButton rbParent;
	RadioButton rbOther;

	private String dob;

	private String selectedRole = null;

	private String homeEndPoint = null;

	boolean isAvailable = false;

	boolean underThirtheen = false;

	/*boolean isEmailAvailable = true;*/

	private static final String LOGIN_YOUR_EXISTING_ACCOUNT = MessageProperties.GL0214;

	private static final String PWD_PATTERN = "[0-9]|[$@!#*%^/[/]}{()_&-+=.,<>;\\|]";

	private static final String PARENT = "Parent";

	private static final String BIRTH_DAY = "birthday";

	private static final String GOORU_UID = "gooruUid";

	private static final String ACCOUNT_TYPE = "accountType";

	private static final String DATE_OF_BIRTH = "dateOfBirth";

	private static final String FIRST_NAME = "firstName";

	private static final String USER_NAME = "username";

	private static final String PASSWORD = "password";

	private static final String EMAIL_ID = "emailId";

	private static final String ORGANIZATION_CODE = "organizationCode";

	private static final String LAST_NAME = "lastName";

	private static final String GOORU = "gooru";

	String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	String USER_NAME_REGEX = "[A-Za-z0-9^]*";
	// private static final String PWD_VALUE = "041299";

	// private static final String AT_SYMBOL = "@";

	// private static final String NON_SYMBOL = "NonParent";

	String account = null;

	boolean isValidEmailId = false;
	boolean isValidUserName = false;
	
	String privateGooruUId = null;

	/**
	 * Class constructor , to create Almost done popup
	 * 
	 * @param userEmail
	 * @param user
	 *            {@link UserDo}
	 */

	@SuppressWarnings("unchecked")
	public CreateAccountUc() {
		super(false);

		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);

		this.center();
		account = AppClientFactory.getPlaceManager().getRequestParameter(
				"account") != null ? AppClientFactory.getPlaceManager()
				.getRequestParameter("account") : null;

		setUiAndIds();

		dateBoxUc = new DateBoxUc(true, true, false);
		sPanelDateOfBirth.add(dateBoxUc);

		dateBoxUc.getDateBox().addFocusHandler(new OnDateFocus());
		dateBoxUc.getDateBox().addBlurHandler(new OnDateBlur());
		dateBoxUc.addDomHandler(new OnDateFocus(), FocusEvent.getType());
		dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());
		
		
		this.getElement().getStyle().setBackgroundColor("transparent");

		dateValidationUc.setVisible(false);
		passwordValidUc.setVisible(false);
		userNameValidUc.setVisible(false);
		emailValidUc.setVisible(false);

		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));

		AppClientFactory.getInjector().getSearchService()
				.getHomeEndPointUrl(new SimpleAsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						homeEndPoint = result;
					}
				});
		
		RootPanel.get().addDomHandler(new DateValueChange(), ClickEvent.getType());
	}

	public abstract void OpenTermsPrivacy();

	public abstract void OpenCopyRight();

	public abstract void OpenPrivacy();

	public abstract void CreateUser(String data, String loginData);

	/**
	 * 
	 * @function toggleButtons 
	 * This method is used to hide pleasewait label and to show signup button.
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 */
	public void toggleButtons(){
		lblPleaseWait.setVisible(false);
		btnSignUp.setVisible(true);
	}
	/**
	 * 
	 * @function onClickParentRegister 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to pass parameters to home on clicking of ParentRegister.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 */
	@UiHandler("ancParentRegister")
	public void onClickParentRegister(ClickEvent event) {
		MixpanelUtil.register_as_a_parent();
		closePoup();
		Map<String, String> params = new HashMap<String, String>();
		params.put("callback", "signup");
		params.put("type", "3");
		params.put("account", "parent");

		// String dob =
		// AppClientFactory.getPlaceManager().getRequestParameter("dob");
		// String userName =
		// AppClientFactory.getPlaceManager().getRequestParameter("userName");
		String dob = dateBoxUc.getDateBox().getText().toString().trim()
				.replaceAll("\\/", "D");
		String userName = txtChooseUsername.getText();

		if (dob != null) {
			params.put("dob", dob);
		}
		if (userName != null) {
			params.put("userName", userName);
		}
		AppClientFactory.getPlaceManager()
				.revealPlace(PlaceTokens.HOME, params);
	}

	/**
	 * Added click handler for showing Terms and Policy popup in footer
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 **/
	@UiHandler("ancTermsAndPrivacy")
	public void onClickTermsPrivacy(ClickEvent event) {
		OpenPrivacy();
	}

	/**
	 * Added click handler for showing copy right popup in footer
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 * 
	 **/
	@UiHandler("ancCopyRight")
	public void onClickCopyRight(ClickEvent event) {
		OpenCopyRight();
	}
	/**
	 * 
	 * @function onClickancPrivacy 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :Added click handler for showing privacy policy popup in footer
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("ancPrivacy")
	public void onClickancPrivacy(ClickEvent event) {
		OpenTermsPrivacy();
	}
	/**
	 * 
	 * @function onClickSignUp 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :This method is to get all the data when signup button is clicked.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 *
	 */
	@UiHandler("btnSignUp")
	public void onClickSignUp(ClickEvent event) {

		String userName = txtChooseUsername.getText().trim();
		String firstName = txtFirstName.getText().trim();
		String lastName = txtLastName.getText().trim();
		String emilId = txtChooseEmail.getText().trim();
		String password = txtChoosePassword.getText().trim();
		String confirmPassword = txtConfirmPassword.getText().trim();
		String dob = dateBoxUc.getDateBox().getValue().trim();
		String parentEmailId = txtParentEmailId.getText().trim();

		lblPleaseWait.setVisible(true);
		btnSignUp.setVisible(false);
		if (validateUserInput()) {
			lblPleaseWait.setVisible(true);
			btnSignUp.setVisible(false);
			if (!underThirtheen) {
				MixpanelUtil.sign_up_over_Thrteen();
				JSONObject userCreate = new JSONObject();
				JSONObject user = new JSONObject();

				user.put(FIRST_NAME, new JSONString(firstName));
				user.put(LAST_NAME, new JSONString(lastName));
				user.put(USER_NAME, new JSONString(userName));
				user.put(EMAIL_ID, new JSONString(emilId));

				JSONObject organization = new JSONObject();
				organization.put(ORGANIZATION_CODE, new JSONString(GOORU));
				user.put("organization", organization);

				// userCreate.put("gender", new JSONString("Male"));
				userCreate.put(PASSWORD, new JSONString(password));
				userCreate.put("gooruBaseUrl", new JSONString(homeEndPoint));
				userCreate.put("role", new JSONString(selectedRole));
				userCreate.put("dateOfBirth", new JSONString(dob));

				userCreate.put("user", user);

				JSONObject login = new JSONObject();
				login.put("username", new JSONString(userName));
				login.put("password", new JSONString(password));

				CreateUser(userCreate.toString(), login.toString());
			} else {
				MixpanelUtil.continue_Child_registration();
				closePoup();
				Map<String, String> params = new HashMap<String, String>();
				params.put("callback", "registerChild");
				params.put("type", "4");
				params.put("privateGooruUId", AppClientFactory.isAnonymous() ? privateGooruUId : AppClientFactory.getLoggedInUser().getGooruUId());
				
				if (dob != null) {
					params.put("dob", dob);
				}
				if (userName != null) {
					params.put("userName", userName);
				}
				if(parentEmailId!=null){
					params.put("emailId",parentEmailId);
				}
				AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );
			}
		} else {
			toggleButtons();
		}
	}
	/**
	 * 
	 * @function validateUserInput 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to validate the user input data.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public boolean validateUserInput() {
		boolean isValid = true;
		lblPleaseWait.setVisible(true);
		btnSignUp.setVisible(false);

		String userName = txtChooseUsername.getText().trim();
		String dob = dateBoxUc.getDateBox().getValue().trim();
		String parentEmailId = txtParentEmailId.getText().trim();
		if (!underThirtheen) {
			String firstName = txtFirstName.getText().trim();
			String lastName = txtLastName.getText().trim();
			String emilId = txtChooseEmail.getText().trim();
			String password = txtChoosePassword.getText().trim();
			String confirmPassword = txtConfirmPassword.getText().trim();

			// TODO Validate all Fields are not null
			
			// TODO Validate password fields
			try {
				RegExp reg = RegExp.compile(PWD_PATTERN, "gi");
				if (password == null || (password != null && password.isEmpty())) {
					txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
					passwordValidUc.setText(StringUtil.generateMessage(GL0070, "Password"));
					passwordValidUc.setVisible(true);
					isValid = false;
				}
				if (!password.equalsIgnoreCase("") && password.length() > 0 && password.length() < 5) {
					txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
					passwordValidUc.setText(StringUtil.generateMessage(GL0071, "Password", "5"));
					passwordValidUc.setVisible(true);
					isValid = false;
				}
				if (!password.equalsIgnoreCase("") && password.length() >= 14) {
					txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
					passwordValidUc.setText(StringUtil.generateMessage(GL0072, "Password", "<= 14"));
					passwordValidUc.setVisible(true);
					isValid = false;
				}
				if (password.equalsIgnoreCase("PASSWORD")) {
					txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
					passwordValidUc.setText(StringUtil.generateMessage(GL0076, "Password"));
					passwordValidUc.setVisible(true);
					isValid = false;
				}
				if ((!password.equalsIgnoreCase("") && !password.isEmpty()) && !reg.test(password) && password.length() >= 5 && password.length() <= 14 && !password.equalsIgnoreCase("PASSWORD")) {
					txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
					passwordValidUc.setText(StringUtil.generateMessage(GL0073, "Password"));
					passwordValidUc.getElement().getStyle().setWidth(340, Unit.PX);
					passwordValidUc.getElement().getStyle().setMarginLeft(0, Unit.PX);
					passwordValidUc.setVisible(true);
					isValid = false;
				}
			} catch (Exception e) {
			}
			
			if (userName.equalsIgnoreCase("") || userName == null) {
				txtChooseUsername.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			} else {
				// TODO Validate UserName is already Exists or Not
				// if (checkUserAvailability(userName, "byUsername")) {
				// txtChooseUsername.addStyleName(res.css().errorMsgDisplay());
				// userNameValidUc.setVisible(true);
				// isValid = false;
				// }
				if (isValidUserName)
					isValid = !isValidUserName;
			}
			if (dob.equalsIgnoreCase("") || dob == null || dob.isEmpty()
					|| !dateBoxUc.hasValidateDate()) {
				dateBoxUc.getDateBox()
						.addStyleName(res.css().errorMsgDisplay());
				// dateValidationUc.setVisible(true);
				isValid = false;
			} else {
				dateBoxUc.getDateBox().removeStyleName(
						res.css().errorMsgDisplay());
				isValid = true;
			}
			if (firstName.equalsIgnoreCase("") || firstName == null) {
				txtFirstName.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			}
			if (firstName.length() > 20) {
				txtFirstName.getElement().addClassName(res.css().errorMsgDisplay());
				firstNameValidUc.setText(StringUtil.generateMessage(GL0072, "First name", "<=20"));
				firstNameValidUc.setVisible(true);
				isValid = false;
			}
			
			
			if (lastName.equalsIgnoreCase("") || lastName == null) {
				txtLastName.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			}
			if (lastName.length() > 20) {
				lastNameValidUc.getElement().addClassName(res.css().errorMsgDisplay());
				lastNameValidUc.setText(StringUtil.generateMessage(GL0072, "Last name", "<= 20"));
				lastNameValidUc.setVisible(true);
				isValid = false;
			}
			
			if (emilId.equalsIgnoreCase("") || emilId == null) {
				txtChooseEmail.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			} else {
				// TODO Validate Email Id is already registered or not
				if (isValidEmailId)
					isValid = !isValidEmailId;
			}
			if (password.equalsIgnoreCase("") || password == null) {
				txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			}
			if (confirmPassword.equalsIgnoreCase("") || confirmPassword == null) {
				txtConfirmPassword.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			}

			// TODO Validate Password fields are match each other.
			if (!password.equalsIgnoreCase(confirmPassword)) {
				txtConfirmPassword.addStyleName(res.css().errorMsgDisplay());
				txtChoosePassword.addStyleName(res.css().errorMsgDisplay());
				passwordValidUc.setText(MessageProperties.GL0446);
				passwordValidUc.setVisible(true);
				isValid = false;
			}

			// TODO Validate Date of Birth
			if (dateBoxUc.hasValidateDate()) {
				// TODO Check age
				Date date = dateBoxUc.getValue();
				int age = getAge(date);

				// TODO if <13 then open parent registration
				if (age < 13) {

					isValid = false;
				}
				// else continue.
			}
			// TODO Validate Whether is Seleted or not
			if (selectedRole == null) {
				lblSelectRole.addStyleName(res.css().error());
				lblSelectRole.setVisible(true);
				isValid = false;
			}

			// TODO Support Password Regx
			RegExp reg = RegExp.compile(PWD_PATTERN, "gi");
			if (!reg.test(password) && password.length() >= 5
					&& password.length() <= 14) {
				passwordValidUc.setText(StringUtil.generateMessage(
						MessageProperties.GL0073, "Password"));
				passwordValidUc.setVisible(true);
				isValid = false;
			}

		} else {
			// TODO Validation different components for age < 13
			parentEmailValidUc.getElement().getStyle()
					.setMarginLeft(54, Unit.PX);
			parentEmailValidUc.getElement().getStyle().setClear(Clear.NONE);

			if (parentEmailId.equalsIgnoreCase("") || parentEmailId == null) {
				txtParentEmailId.addStyleName(res.css().errorMsgDisplay());
				parentEmailValidUc.setText(MessageProperties.GL0463);

				isValid = false;
			}
			if (!parentEmailId.equalsIgnoreCase("") || parentEmailId != null) {

				Boolean from = parentEmailId.matches(EMAIL_REGEX);
				if (from) {
					if (isValidEmailId) {
						// Found user as registered user in gooru
						txtParentEmailId.removeStyleName(res.css()
								.errorMsgDisplay());
						parentEmailValidUc.setVisible(false);
						lblGetCorrectEmail.setVisible(true);
						isValid = true;
					} else {
						// Found user is not registered user in gooru
						txtParentEmailId.addStyleName(res.css()
								.errorMsgDisplay());
						parentEmailValidUc.setText(MessageProperties.GL0465);
						parentEmailValidUc.getElement().getStyle().setWidth(340, Unit.PX);
						parentEmailValidUc.getElement().getStyle().setMarginLeft(0, Unit.PX);
						parentEmailValidUc.setVisible(true);
						lblGetCorrectEmail.setVisible(false);
						isValid = false;
					}
				} else {
					// lblGetCorrectEmail.setVisible(false);
					txtParentEmailId.addStyleName(res.css().errorMsgDisplay());
					parentEmailValidUc.setText(MessageProperties.GL0464);
					isValid = false;
				}
			}
			if (userName.equalsIgnoreCase("") || userName == null) {
				txtChooseUsername.addStyleName(res.css().errorMsgDisplay());
				isValid = false;
			} else {
				if (isValidUserName) {
					txtChooseUsername.addStyleName(res.css().errorMsgDisplay());
					userNameValidUc.setVisible(true);
					isValid = false;
				}
				
			}

		}
		return isValid;
	}
    /**
     * 
     * @function setUiAndIds 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This method is used to set the data in popup by hetting the data from message properties file.
     * 
     * 
     * @parm(s) : 
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
	private void setUiAndIds() {
		if (account != null) {
			lblPleaseFill.setText(MessageProperties.GL0471);
			lblPleaseFill.getElement().getStyle().setColor("#000000");
			lblPleaseFill.getElement().getStyle().setFontSize(18, Unit.PX);
		} else {
			lblPleaseFill.setText(MessageProperties.GL0409);
			lblPleaseFill.getElement().getStyle().clearColor();
			lblPleaseFill.getElement().getStyle().clearFontSize();
		}
		lblPickWisely.setText(MessageProperties.GL0410);
		lblQuestionMark.setText(MessageProperties.GL_SPL_QUESTION);
		lblWhyEnterBirthday.setText(MessageProperties.GL0411
				+ MessageProperties.GL_SPL_QUESTION);
		lblWhyEnterBirthdayDesc.setText(MessageProperties.GL0412);
		lblNameTooltipContent.setText(MessageProperties.GL0413);
		lblEmailTooltipContent.setText(MessageProperties.GL0414);
		lblPasswordTooltipContent.setText(MessageProperties.GL0415);
		lblPleaseWait.setText(MessageProperties.GL0339);

		lblTeacher.setText(MessageProperties.GL0416);
		lblStudent.setText(MessageProperties.GL0417);
		lblParent.setText(MessageProperties.GL0418);
		lblOther.setText(MessageProperties.GL0419);
		lblAgree.setText(MessageProperties.GL0420);

		txtChooseUsername.setPlaceholder(MessageProperties.GL0423);
		txtChooseUsername.setMaxLength(20);
		txtFirstName.setPlaceholder(MessageProperties.GL0424);
		txtLastName.setPlaceholder(MessageProperties.GL0425);
		txtChooseEmail.setPlaceholder(MessageProperties.GL0426);
		txtChoosePassword.setPlaceholder(MessageProperties.GL0204);
		txtChoosePassword.setMaxLength(14);
		txtConfirmPassword.setPlaceholder(MessageProperties.GL0427);
		txtConfirmPassword.setMaxLength(14);

		txtChooseUsername.addKeyUpHandler(new OnKeyUpHandler());
		txtFirstName.addKeyUpHandler(new OnKeyUpHandler());
		txtLastName.addKeyUpHandler(new OnKeyUpHandler());
		txtChooseEmail.addKeyUpHandler(new OnKeyUpHandler());
		txtChoosePassword.addKeyUpHandler(new OnKeyUpHandler());
		txtConfirmPassword.addKeyUpHandler(new OnKeyUpHandler());

		txtChooseUsername.addBlurHandler(new OnBlurHandler());
		txtChooseEmail.addBlurHandler(new OnBlurHandler());
		txtParentEmailId.addBlurHandler(new OnBlurHandler());
		txtParentEmailId.addKeyUpHandler(new OnKeyUpHandler());

		txtChooseUsername.addMouseOverHandler(new OnMouseOver());
		txtFirstName.addMouseOverHandler(new OnMouseOver());
		txtLastName.addMouseOverHandler(new OnMouseOver());
		txtChooseEmail.addMouseOverHandler(new OnMouseOver());
		txtChoosePassword.addMouseOverHandler(new OnMouseOver());
		txtConfirmPassword.addMouseOverHandler(new OnMouseOver());
		panelDataOfBirth.addMouseOverHandler(new OnMouseOver());
		lblQuestionMarkNeedParentAccount.addMouseOverHandler(new OnMouseOver());

		txtChooseUsername.addMouseOutHandler(new OnMouseOut());
		txtFirstName.addMouseOutHandler(new OnMouseOut());
		txtLastName.addMouseOutHandler(new OnMouseOut());
		txtChooseEmail.addMouseOutHandler(new OnMouseOut());
		txtChoosePassword.addMouseOutHandler(new OnMouseOut());
		txtConfirmPassword.addMouseOutHandler(new OnMouseOut());
		panelDataOfBirth.addMouseOutHandler(new OnMouseOut());
		lblQuestionMarkNeedParentAccount.addMouseOutHandler(new OnMouseOut());

		txtFirstName.setMaxLength(20);
		txtLastName.setMaxLength(20);		
		
		panelUserNamePopUp.setVisible(false);
		panelPublic.setVisible(false);
		panelEmail.setVisible(false);
		panelPassword.setVisible(false);
		lblPleaseWait.setVisible(false);

		ancCopyRight.setText(MessageProperties.GL0421 + ",");
		ancTermsAndPrivacy.setText(MessageProperties.GL0422);
		ancPrivacy.setText(MessageProperties.GL0452);
		btnSignUp.setText(MessageProperties.GL0186);
		btnSignUp.getElement().setId("btnSignUp");
		btnSignUp.setEnabled(false);
		btnSignUp.getElement().addClassName("disabled");

		lblNeedParentsAccount.setText(MessageProperties.GL0455);
		lblMyParentHasGooruAccount.setText(MessageProperties.GL0456);
		txtParentEmailId.setPlaceholder(MessageProperties.GL0457);
		lblOr.setText(MessageProperties.GL0466);
		lblMyParentDontHaveAccount.setText(MessageProperties.GL0458);
		ancParentRegister.setText(MessageProperties.GL0459);
		lblQuestionMarkNeedParentAccount
				.setText(MessageProperties.GL_SPL_QUESTION);
		lblWhyNeedParentDesc.setText(MessageProperties.GL0461);
		lblWhyNeedParent.setText(MessageProperties.GL0462
				+ MessageProperties.GL_SPL_QUESTION);
		tootltipContainer.getElement().setAttribute("style", "left:311px");

		panelBelowThirteen.setVisible(false);
		panelAboveThirteen.setVisible(true);

		lblSelectRole.setVisible(false);
		lblGetCorrectEmail.setVisible(false);

		dateValidationUc.setText(StringUtil.generateMessage(
				MessageProperties.GL0082, BIRTH_DAY));

		rbTeacher = new RadioButton("roleOption", "");
		rbStudent = new RadioButton("roleOption", "");
		rbParent = new RadioButton("roleOption", "");
		rbOther = new RadioButton("roleOption", "");
		
		rbTeacher.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.select_teacher();
				selectedRole = "teacher";
				lblSelectRole.setVisible(false);
				if (rbTeacher.getValue()){
					//Remove normal and Set Selected Image
					panelTeacher.getElement().addClassName(res.css().teacherRoleSelected());
				}
				//Remove selected image and set normal
				panelOther.getElement().removeClassName(res.css().otherRoleSelected());
//				panelTeacher.getElement().removeClassName(res.css().teacherRoleSelected());
				panelStudent.getElement().removeClassName(res.css().studentRoleSelected());
				panelParent.getElement().removeClassName(res.css().parentRoleSelected());
			}
		});
		rbStudent.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.select_student();
				selectedRole = "student";
				lblSelectRole.setVisible(false);
				if (rbStudent.getValue()){
					//Remove normal and Set Selected Image
					panelStudent.getElement().addClassName(res.css().studentRoleSelected());
				}
				//Remove selected image and set normal
				panelOther.getElement().removeClassName(res.css().otherRoleSelected());
				panelTeacher.getElement().removeClassName(res.css().teacherRoleSelected());
//				panelStudent.getElement().removeClassName(res.css().studentRoleSelected());
				panelParent.getElement().removeClassName(res.css().parentRoleSelected());
			}
		});
		rbParent.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.select_parent();
				selectedRole = "parent";
				lblSelectRole.setVisible(false);
				if (rbParent.getValue()){
					//Remove normal and Set Selected Image
					panelParent.getElement().addClassName(res.css().parentRoleSelected());
				}
				//Remove selected image and set normal
				panelOther.getElement().removeClassName(res.css().otherRoleSelected());
				panelTeacher.getElement().removeClassName(res.css().teacherRoleSelected());
				panelStudent.getElement().removeClassName(res.css().studentRoleSelected());
				//panelParent.getElement().removeClassName(res.css().parentRoleSelected());
			}
		});
		rbOther.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.select_other();
				selectedRole = "other";
				lblSelectRole.setVisible(false);
				if (rbOther.getValue()){
					//Remove normal and Set Selected Image
					panelOther.getElement().addClassName(res.css().otherRoleSelected());
				}
				//Remove selected image and set normal
				//panelOther.getElement().removeClassName(res.css().otherRoleSelected());
				panelTeacher.getElement().removeClassName(res.css().teacherRoleSelected());
				panelStudent.getElement().removeClassName(res.css().studentRoleSelected());
				panelParent.getElement().removeClassName(res.css().parentRoleSelected());
			}
		});

		rdTeacher.add(rbTeacher);
		rdStudent.add(rbStudent);
		rdParent.add(rbParent);
		rdOther.add(rbOther);

		if (account != null && account.equalsIgnoreCase("parent")) {
			rbParent.setChecked(true);
			selectedRole = "parent";
		} else {
			rbParent.setChecked(false);
			selectedRole = null;
		}

	}
	  /**
	   * 
	   * @fileName : CreateAccountUc.java
	   *
	   * @description : This method is used to show panel's based on username/DOB/Password on Mouse Over
	   *
	   *
	   * @version : 1.0
	   *
	   * @date: 26-Dec-2013
	   *
	   * @Author : Gooru Team
	   *
	   * @Reviewer: Gooru Team
	   */
	private class OnMouseOver implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {

			if (event.getSource() == txtChooseUsername
					|| event.getSource() == panelDataOfBirth) {
				panelUserNamePopUp.setVisible(true);
			} else if (event.getSource() == txtFirstName
					|| event.getSource() == txtLastName) {
				panelPublic.setVisible(true);
			} else if (event.getSource() == txtChooseEmail) {
				panelEmail.setVisible(true);
			} else if (event.getSource() == txtChoosePassword
					|| event.getSource() == txtConfirmPassword) {
				panelPassword.setVisible(true);
			}
		}
	}
    /**
     * 
     * @fileName : CreateAccountUc.java
     *
     * @description : This method is used to hide panel's based on  on Mouse Out handler.
     *
     *
     * @version : 1.0
     *
     * @date: 26-Dec-2013
     *
     * @Author : Gooru Team
     *
     * @Reviewer: Gooru Team
     */
	private class OnMouseOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			panelUserNamePopUp.setVisible(false);
			panelPublic.setVisible(false);
			panelEmail.setVisible(false);
			panelPassword.setVisible(false);
		}

	}
    /**
     * 
     * @fileName : CreateAccountUc.java
     *
     * @description : This method is used to display validation if we enter the wrong data on Blur handler
     *
     *
     * @version : 1.0
     *
     * @date: 26-Dec-2013
     *
     * @Author : Gooru Team
     *
     * @Reviewer: Gooru Team
     */
	private class OnBlurHandler implements BlurHandler {

		@Override
		public void onBlur(BlurEvent event) {
			btnSignUp.setEnabled(false);
			btnSignUp.getElement().addClassName("disabled");
			
			if (event.getSource() == txtChooseEmail
					&& txtChooseEmail.getText() != null
					&& !txtChooseEmail.getText().equalsIgnoreCase("")) {
				boolean isValidFrom = txtChooseEmail.getText().matches(EMAIL_REGEX);
				if (isValidFrom) {
					isValidEmailId = checkUserAvailability(
							txtChooseEmail.getText(), "byEmailid");
					emailValidUc.setVisible(false);
					txtChooseEmail.removeStyleName(res.css().errorMsgDisplay());
				} else {
					txtChooseEmail.addStyleName(res.css().errorMsgDisplay());
					emailValidUc.addStyleName(res.css().errorLbl());
					emailValidUc.setText(MessageProperties.GL0464);
					emailValidUc.setVisible(true);
				}
			} else if (event.getSource() == txtChooseUsername
					&& txtChooseUsername.getText() != null
					&& !txtChooseUsername.getText().equalsIgnoreCase("")) {
					if (txtChooseUsername.getText().length() <=4 || txtChooseUsername.getText().length() >=20){
						userNameValidUc.addStyleName(res.css().errorLbl());
						userNameValidUc.setText(MessageProperties.GL0473);
						userNameValidUc.setVisible(true);
						isValidUserName = false;
					}
					else{
						isValidUserName = checkUserAvailability(
							txtChooseUsername.getText(), "byUsername");
					}
					Boolean userNameValidate = txtChooseUsername.getText().matches(USER_NAME_REGEX);
					if(!userNameValidate){
						userNameValidUc.addStyleName(res.css().errorLbl());
						userNameValidUc.setText(MessageProperties.GL0475);
						userNameValidUc.setVisible(true);
						isValidUserName = false;	
					}
			} else if (event.getSource() == txtParentEmailId
					&& txtParentEmailId.getText() != null
					&& !txtParentEmailId.getText().equalsIgnoreCase("")) {
				isValidEmailId = checkUserRegisteredWithGooru(
						txtParentEmailId.getText(), "byEmailid");
			}
		}
	}
    /**
     * 
     * @fileName : CreateAccountUc.java
     *
     * @description : This method is used to display validation if we enter the wrong data on key up handler
     *
     *
     * @version : 1.0
     *
     * @date: 26-Dec-2013
     *
     * @Author : Gooru Team
     *
     * @Reviewer: Gooru Team
     */
	private class OnKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			passwordValidUc.setVisible(false);
			if (event.getSource() == txtChooseUsername) {
				txtChooseUsername.removeStyleName(res.css().errorMsgDisplay());
				userNameValidUc.setText("");
				userNameValidUc.setVisible(false);
			} else if (event.getSource() == txtFirstName) {
				txtFirstName.removeStyleName(res.css().errorMsgDisplay());
			} else if (event.getSource() == txtLastName) {
				txtLastName.removeStyleName(res.css().errorMsgDisplay());
			} else if (event.getSource() == txtChooseEmail) {
				txtChooseEmail.removeStyleName(res.css().errorMsgDisplay());
				emailValidUc.setVisible(false);
			} else if (event.getSource() == txtChoosePassword) {
				txtChoosePassword.removeStyleName(res.css().errorMsgDisplay());
			} else if (event.getSource() == txtConfirmPassword) {
				txtConfirmPassword.removeStyleName(res.css().errorMsgDisplay());
			} else if (event.getSource() == txtParentEmailId) {
				txtParentEmailId.removeStyleName(res.css().errorMsgDisplay());
				parentEmailValidUc.setVisible(false);
			}
		}

	}

	/**
	 * Checks the availability of user name, entered by User.
	 * 
	 * @param userName
	 * @param type
	 * 
	 */
	public boolean checkUserAvailability(String userName, final String type) {

		AppClientFactory.getInjector().getUserService()
				.getEmailId(userName, type, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo result) {
						isAvailable = result.isAvailability();
						if (type.equalsIgnoreCase("byEmailid") && isAvailable) {
							privateGooruUId = result.getGooruUId();
							isValidEmailId = result.isAvailability();
							txtChooseEmail.addStyleName(res.css()
									.errorMsgDisplay());
							emailValidUc.addStyleName(res.css().errorLbl());
							emailValidUc.setText(MessageProperties.GL0447);
							emailValidUc.setVisible(true);
						}else if (type.equalsIgnoreCase("byEmailid") && !isAvailable){
							isValidEmailId = result.isAvailability();
						}
						if (type.equalsIgnoreCase("byUsername") && isAvailable) {
							isValidUserName = result.isAvailability();
							txtChooseUsername.addStyleName(res.css()
									.errorMsgDisplay());
							userNameValidUc.addStyleName(res.css().errorLbl());
							userNameValidUc.setText(MessageProperties.GL0444);
							userNameValidUc.setVisible(true);
						}else if (type.equalsIgnoreCase("byUsername") && !isAvailable) {
							isValidUserName = result.isAvailability();
						}
						if (isValidEmailId==false && isValidUserName==false){
							btnSignUp.setEnabled(true);
							btnSignUp.getElement().removeClassName("disabled");
						}
						if (underThirtheen){
							if (isValidEmailId==true && isValidUserName==false){
								btnSignUp.setEnabled(true);
								btnSignUp.getElement().removeClassName("disabled");
							}
						}
						
					}
				});
		
		return isAvailable;
	}

	/**
	 * Checks the availability of user name, entered by User.
	 * 
	 * @param userName
	 * @param type
	 * 
	 */
	public boolean checkUserRegisteredWithGooru(String userName,
			final String type) {
		AppClientFactory.getInjector().getUserService()
				.getEmailId(userName, type, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo result) {
						isValidEmailId = result.isAvailability();
						privateGooruUId = result.getGooruUId();
						if (isValidEmailId) {
							// Found user as registered user in gooru
							lblGetCorrectEmail.setVisible(true);
							txtParentEmailId.removeStyleName(res.css()
									.errorMsgDisplay());
							parentEmailValidUc.setVisible(false);
							lblGetCorrectEmail.setVisible(true);
							btnSignUp.setEnabled(true);
							btnSignUp.getElement().removeClassName("disabled");
						} else {
							// Found user is not registered user in gooru
							parentEmailValidUc.getElement().getStyle()
									.setMarginLeft(54, Unit.PX);
							parentEmailValidUc.getElement().getStyle()
									.setClear(Clear.NONE);
							parentEmailValidUc.getElement().getStyle().setWidth(197, Unit.PX);
							txtParentEmailId.addStyleName(res.css()
									.errorMsgDisplay());
							parentEmailValidUc
									.setText(MessageProperties.GL0465);
							parentEmailValidUc.setVisible(true);
							lblGetCorrectEmail.setVisible(false);
						}
					}
				});
			return isValidEmailId;
	}
    /**
     * 
     * @fileName : CreateAccountUc.java
     *
     * @description : This method is used to get age on DOB calucation and if age is lessthan 13 it will enable  panelBelowThirteen and disable panelAboveThirteen. 
     *
     *
     * @version : 1.0
     *
     * @date: 26-Dec-2013
     *
     * @Author : Gooru Team
     *
     * @Reviewer: Gooru Team
     */
	private class DateValueChange implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox()
					.getText().isEmpty())
					&& dateBoxUc.hasValidateDate()) {

				Date date = dateBoxUc.getValue();
				int age = getAge(date);
				if (age < 13) {
					MixpanelUtil.create_Child_account();
					dob = dateBoxUc.getDate();
					// TODO set the parent user details.
					underThirtheen = true;
					panelBelowThirteen.setVisible(true);
					if (panelAboveThirteen.isVisible()) {
						btnSignUp.setText(MessageProperties.GL0460);
					}
					panelAboveThirteen.setVisible(false);
				}
			} else {
//				dateBoxUc.getDatePickerUc().hide();
			}
		}
		
	}
	/**
	 * 
	 * @fileName : CreateAccountUc.java
	 *
	 * @description : This method is used to hide the date validations on focus.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnDateFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			dateBoxUc.removeStyleName(NewRegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					NewRegisterCBundle.INSTANCE.css().gooruDateError());
			if (dateValidationUc.isVisible()) {
				dateValidationUc.setVisible(false);
			}

		}
	}
    /**
     * 
     * @fileName : CreateAccountUc.java
     *
     * @description : Based on age it will dispaly Date validations
     *
     *
     * @version : 1.0
     *
     * @date: 26-Dec-2013
     *
     * @Author : Gooru Team
     *
     * @Reviewer: Gooru Team
     */
	private class OnDoneClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			dateBoxUc.getDateBox().removeStyleName(res.css().errorMsgDisplay());
			if (dateBoxUc.dateValidation()) {
				if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox()
						.getText().isEmpty())
						&& dateBoxUc.hasValidateDate()) {
						Date date = dateBoxUc.getValue();
						int age = getAge(date);
						if (age < 13) {
							if (account != null && !underThirtheen){
								dateValidationUc.setText(MessageProperties.GL0503);
								dateValidationUc.setVisible(true);
								isValidUserName = false;
							}else{
								MixpanelUtil.create_Child_account();
								dob = dateBoxUc.getDate();
								// TODO set the parent user details.
								underThirtheen = true;
								panelBelowThirteen.setVisible(true);
								if (panelAboveThirteen.isVisible()) {
									btnSignUp.setText(MessageProperties.GL0460);
								}
								panelAboveThirteen.setVisible(false);
							}
						}
					
				} else {
					dateBoxUc.getDatePickerUc().hide();
				}
			}
		}
	}
	/**
	 * 
	 * @fileName : CreateAccountUc.java
	 *
	 * @description : Based on age it will dispaly Date validations on mose blur handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnDateBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			dateBoxUc.removeStyleName(NewRegisterCBundle.INSTANCE.css()
					.gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					NewRegisterCBundle.INSTANCE.css().gooruDateError());
			if (dateBoxUc.getValue() != null){
				Date date = dateBoxUc.getValue();
				int age = getAge(date);
				if (age < 13) {
					if (account != null && !underThirtheen){
						dateValidationUc.setText(MessageProperties.GL0503);
						dateValidationUc.setVisible(true);
						isValidUserName = false;
					}else{
						MixpanelUtil.create_Child_account();
						dob = dateBoxUc.getDate();
						// TODO set the parent user details.
						underThirtheen = true;
						panelBelowThirteen.setVisible(true);
						if (panelAboveThirteen.isVisible()) {
							btnSignUp.setText(MessageProperties.GL0460);
						}
						panelAboveThirteen.setVisible(false);
					}
				}
			}
		}
	}
    /**
     * 
     * @function getAge 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This method is used to calculate age on DOB.
     * 
     * 
     * @parm(s) : @param birthDate
     * @parm(s) : @return
     * 
     * @return : int
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
	private int getAge(Date birthDate) {
		if (birthDate != null) {
			long ageInMillis = new Date().getTime() - birthDate.getTime();
			Date age = new Date(ageInMillis);
			return age.getYear() - 70;
		} else {
			return 0;
		}
	}

	/**
	 * Checks user availability with user email id and user account type
	 * 
	 * @param accountType
	 *            user account type nonParent, parent, child
	 * @param isValid
	 *            true if email id satisfy the condition else false
	 * @param emailId
	 *            of the user that is mandatory to check availability
	 */
	private void checkAvailability(final String accountType, boolean isValid,
			final String emailId) {
		if (isValid) {
			try {
				AppClientFactory.getInjector().getUserService()
						.getEmailId(emailId, new SimpleAsyncCallback<UserDo>() {
							@Override
							public void onSuccess(UserDo user) {
								MixpanelUtil.Click_Go_Register_popup();
								validateAvailability(user, accountType, emailId);
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate the user availability after check availability calls, validate
	 * the email id already has been taken by some one and validate the confirm
	 * status of user account If emailId already has been taken by some one it
	 * brings alert popup
	 * 
	 * @param user
	 *            instance of {@link UserDo} which has user all user info
	 * @param accountType
	 *            of user
	 * @param emailId
	 *            of user
	 */
	private void validateAvailability(UserDo user, String accountType,
			String emailId) {
		if (!user.isAvailability() && user.getConfirmStatus() == 0) {
			this.hide();
			if (parentRegisterVc != null) {
				parentRegisterVc.getPopupPanel().hide();
			}
			new RegistrationConfirmationVc();
			// registerUser(accountType, emailId, dob);
		} else if (user.isAvailability() && user.getConfirmStatus() == 0) {
			this.hide();
			Map<String, String> params = new HashMap<String, String>();
			params.put(GOORU_UID, user.getGooruUId());
			params.put(ACCOUNT_TYPE, accountType);
			sendConfirmationMail(params);
			new AlertContentUc(MessageProperties.GL0065,
					MessageProperties.GL0092);

		} else if (user.isAvailability() && user.getConfirmStatus() == 1) {
			if (!accountType.equalsIgnoreCase(PARENT)) {
				new AlertContentUc(MessageProperties.GL0065,
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
	 * Send confirmation mail to user after successful registration
	 * 
	 * @param params
	 *            contains emailId, accountType, dataOfBirth
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

	public abstract void closePoup();
}
