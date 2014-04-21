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
package org.ednovo.gooru.client.mvp.settings;
/**


*
* @description : 
*
* @version :1.0
*
* @date: APR 19 2013
   	
* @Author Gooru Team
* 
* Reviewer Gooru Team
*
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.ForgotPwdSuccessVc;
import org.ednovo.gooru.client.mvp.home.library.events.StandardPreferenceSettingEvent;
import org.ednovo.gooru.client.mvp.home.library.events.StandardPreferenceSettingHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.CloseLabelSetting;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.uc.ProfileBiographyEditUC;
import org.ednovo.gooru.client.uc.ProfilePageGradeLabel;
import org.ednovo.gooru.client.uc.SettingEditLabelUc;
import org.ednovo.gooru.client.uc.SettingEmailEditLabelUc;
import org.ednovo.gooru.client.uc.SettingLastNameEditLabelUC;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.V2UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

public class UserSettingsView extends BaseViewWithHandlers<UserSettingsUiHandlers> implements IsUserSettingsView,MessageProperties{
	private static UserSettingsViewUiBinder uiBinder = GWT
			.create(UserSettingsViewUiBinder.class);

	interface UserSettingsViewUiBinder extends
			UiBinder<Widget, UserSettingsView> {

	}

	boolean isChildAccount = false;
	
	//private final Widget widget;
	private static final String PROFILE_DEFAULT_IMAGE="./images/settings/setting-user-image.png";
	
	@UiField(provided = false)
	ProfileBiographyEditUC profileTextArea;
	
	@UiField(provided = true)
	SettingEditLabelUc tbFirstNameUcLabel;
	
	@UiField(provided = true)
	SettingLastNameEditLabelUC tbLastNameUcLabel;
	
	@UiField(provided = true)
	SettingEmailEditLabelUc lbEmail;
		
	@UiField HTMLEventPanel pencilTextAreaImage,plAccount,plSecurity,plEducation,plContact,profileDescriptionlabel,biographyCancelButton,panelStandards;
	@UiField HTMLPanel userAccount,userSecurity,userEducation,userContact,accountMiniusArrow,securityMiniusArrow,educationalMiniusArrow,contactMiniusArrow,standardsText,standardsSaveCancelButtonContainer,userStandardDefaultView,userStandardEditView,userStandardTextPanel;
	@UiField Label aboutUsCharacterValidation,lbMale,lbFemale,lbOther,lbShare,lbRole,lbName,lbUserName,lbUName,forgetPassword,forgetPasswordMsg;
	@UiField HTMLPanel aboutUsContainer,profilePageText,aboutUsText,accountText,usernameText,nametext,genderText,securityText,settingsinfoText, panelHelp;
	//@UiField TextBox tbLastName,tbFirstName;
	@UiField Button settingsSaveButton,profileOnButton,profileOffButton, btnSave, btnSeeMyProfile;
	@UiField HTMLPanel radioButtonContainer,settingsText,appearText,emailtext;
	@UiField UserSettingStyle Settings;
	@UiField Label courseLabel,courseMaxMsg,courseLbl,gradeLbl,SavingTextLabel,EduSavingTextLabel,lbMaleText,lbFemaleText,lbOtherText;
	@UiField FlowPanel KinderGarten,gradeTopList,gradeMiddleList,higherEducation,courseData,collectionCourseLstPanel,coursesPanel,collectionCourseDefaultLstPanel;
	@UiField Label uploadProfilImageButton,accountSavingTextLabel,notToShareText,gradeText;
	@UiField Label charLimitFNameLbl,emailTextConfirmation,lblgender,email,roleText;
	@UiField FocusPanel noAboutUsContainer;
	@UiField HTMLEventPanel profileImageContainer,userCoursePopup;
	@UiField Image uploadProfileImage;
	@UiField HTMLPanel editButtonContainerAccount,editButtonContainerEdu,editButtonContainerContact,buttonContainer,emailbuttonContainer,EduInfoButtonContainer,gradeContainer,DefaultGardeContainer,courseContainer, panelToolTipContent,panelTooltipContainer;
	@UiField Button editButtonAccount,editButtonEdu,editButtonContact,settingCancelButton,emailCancelButton,emailSaveButton,eduInfoCancelButton,eduInfoSaveButton,standardsSaveButton,standardsCancelButton,standardsEditButton;
	
	@UiField Label lblPleaseWait,lblCommonCore,lblCaliforniaScience,description,standardSavingTextLabel,lblTexas,lblUserMessage;
	
	@UiField HTML htmlToolTipDesc;
	@UiField TextBox txtUserName;
	@UiField ErrorLabelUc userNameValidationUc;
	@UiField HTMLPanel emailPanel;
	boolean isValidUserName=false;
	boolean isAvailable = false;
	boolean isProfanityCleared=false;
	boolean isUserNameChanged = false;
	
	String USER_NAME_REGEX = "[A-Za-z0-9^]*";
	
	private static String BY_USERNAME = "username";
	private static String DISABLED = "disabled";
	
	private ProfileDo profileDo;
	private static String USER_META_ACTIVE_FLAG = "1";
	private static String NONE_ADDED = GL1476;
	private GroupedListBox collectionCourseLst;
	HTML defaultCoursePanel;
	private SettingDo settingDo;
	private V2UserDo v2userDo;
	private AlertContentUc alertContentUc;
	
	private ForgotPwdSuccessVc forgotPwdSuccessVc;
	String gooruUid="";
	boolean enableEdit = false;
	boolean enableEditFirstName = false;
	
	CheckBox commonCoreChk = new CheckBox();
	CheckBox californiaStandChk = new CheckBox();
	CheckBox texasChk = new CheckBox();
	String USER_TAXONOMY_ROOT_CODE="user_taxonomy_root_code";
	List<String> userStandardPrefcode=new ArrayList<String>();
	
	/** 
	 * This method is to get the settingDo
	 */
	public SettingDo getSettingDo() {
		return settingDo;
	}
 
	/** 
	 * This method is to set the settingDo
	 */
	public void setSettingDo(SettingDo settingDo) {
		this.settingDo = settingDo;
	}
	
	private String[] gendersArray=new String[]{"Male","Female","Others","Prefer not to share"};
	
	

	public interface Binder extends UiBinder<Widget, UserSettingsView> {
	}

	@Inject
	public UserSettingsView() {

		//widget = binder.createAndBindUi(this);
		tbLastNameUcLabel=new SettingLastNameEditLabelUC(){
			
			@Override
			public void onEditDisabled(String text) {
				enableEdit=true;
				//getUiHandlers().saveSettingsInformation();
			}
			
			public void checkCharacterLimit(String text) {
				//	titleAlertMessageLbl.setText(MessageProperties.GL0143);
					if (text.length() >= 25) {
						charLimitFNameLbl.setVisible(true);	
					} else {
						charLimitFNameLbl.setVisible(false);	
					}
					
				}
			
		};
		
		tbFirstNameUcLabel=new SettingEditLabelUc(){
			@Override
			public void onEditDisabled(String text) {
				enableEditFirstName = true;
		
			}
			public void checkCharacterLimit(String text) {
			//	titleAlertMessageLbl.setText(MessageProperties.GL0143);
				if (text.length() >= 25) {
					charLimitFNameLbl.setVisible(true);	
				} else {
					charLimitFNameLbl.setVisible(false);	
				}
				
			}
			
		};
		
		lbEmail=new SettingEmailEditLabelUc(){
			@Override
			public void onEditDisabled(String text) {
				editButtonContact.setVisible(false);
				emailbuttonContainer.setVisible(false);
				getUiHandlers().saveEmail(false);
				
			}
		
			
		};
		
		
		
		setWidget(uiBinder.createAndBindUi(this));
		CollectionCBundle.INSTANCE.css().ensureInjected();
		
		MixpanelUtil.Loading_SettingsPage();
		courseData.getElement().getStyle().setWidth(324, Unit.PX);
		settingsText.getElement().setInnerHTML(GL0192);
		uploadProfilImageButton.setText(GL0800);
		profilePageText.getElement().setInnerHTML(GL0801);
		profileOnButton.setText(GL0802);
		profileOffButton.setText(GL0803);
		aboutUsText.getElement().setInnerHTML(GL0804);
		appearText.getElement().setInnerHTML(GL0805);
		aboutUsCharacterValidation.setText(GL0143);
		btnSave.setText(GL0141);
		biographyCancelButton.getElement().setInnerHTML(GL0142);
		btnSeeMyProfile.setText(GL0806);
		accountText.getElement().setInnerHTML(GL0807);
		accountSavingTextLabel.setText(GL0808);
		editButtonAccount.setText(GL0140);
		settingCancelButton.setText(GL0142);
		settingsSaveButton.setText(GL0141);
		usernameText.getElement().setInnerHTML(GL0652);
		nametext.getElement().setInnerHTML(GL0649);
		uploadProfileImage.setTitle(GL0823);
		uploadProfileImage.setAltText(GL0823);
		//GL0823
		charLimitFNameLbl.setText(GL0143);
		genderText.getElement().setInnerHTML(GL0809+GL_SPL_SEMICOLON);
		lbMaleText.setText(GL0810);
		lbFemaleText.setText(GL0811);
		lbOtherText.setText(GL0419);
		notToShareText.setText(GL0812);
		emailtext.getElement().setInnerHTML(GL0212);
		SavingTextLabel.setText(GL0808);
		editButtonContact.setText(GL0140);
		emailCancelButton.setText(GL0142);
		emailSaveButton.setText(GL0141);
		email.setText(GL0212+GL_SPL_SEMICOLON);
		emailTextConfirmation.setText(GL0813);
		securityText.getElement().setInnerHTML(GL0814);
		forgetPasswordMsg.setText(GL0815);
		forgetPassword.setText(" "+GL0816);
		lblPleaseWait.setText(GL0339);
		settingsinfoText.getElement().setInnerHTML(GL0817);
		EduSavingTextLabel.setText(GL0808);
		editButtonEdu.setText(GL0140);
		eduInfoCancelButton.setText(GL0142);
		eduInfoSaveButton.setText(GL0141);
		roleText.setText(" "+GL0818);
		gradeText.setText(GL0819);
		gradeLbl.setText(GL0820);
		courseLabel.setText(GL0821);
		courseLbl.setText(GL0820);
		courseMaxMsg.setText(GL0822);
		htmlToolTipDesc.setHTML(GL1539);
		panelToolTipContent.getElement().getStyle().setWidth(247, Unit.PX);
		panelTooltipContainer.getElement().getStyle().setWidth(277, Unit.PX);
		panelTooltipContainer.getElement().getStyle().setLeft(-127, Unit.PX);
		emailPanel.setVisible(true);
		//GL0820
		//For 5.9 release
		editButtonAccount.addClickHandler(new onEditImageName());
		editButtonContact.addClickHandler(new onEditForEmail());
		lbShare.getElement().setId("rdShare");
		lbOther.getElement().setId("rdOther");
		lbMale.getElement().setId("rdMale");
		lbFemale.getElement().setId("rdFemale");
		forgetPassword.getElement().setId("lblForgetPassword");
		emailSaveButton.getElement().setId("btnSaveEmail");
		emailCancelButton.getElement().setId("btnCancelEmail");
		editButtonContact.getElement().setId("btnEditEmail");
		editButtonAccount.getElement().setId("btnEditAccount");
		settingCancelButton.getElement().setId("btnCancelAccount");
		settingsSaveButton.getElement().setId("btnSaveAccount");
		editButtonEdu.getElement().setId("btnEdit");
		eduInfoCancelButton.getElement().setId("btnCancel");
		eduInfoSaveButton.getElement().setId("btnSave");
		editButtonEdu.addClickHandler(new onEducationInfo());
		emailbuttonContainer.setVisible(false);		
		charLimitFNameLbl.setVisible(false);
		SavingTextLabel.setVisible(false);
		emailTextConfirmation.setVisible(false);
		EduInfoButtonContainer.setVisible(false);
		gradeContainer.setVisible(false);
		courseContainer.setVisible(false);
		radioButtonContainer.setVisible(false);
		accountSavingTextLabel.setVisible(false);
		EduSavingTextLabel.setVisible(false);
		txtUserName.setVisible(false);
		txtUserName.getElement().getStyle().setMarginLeft(5, Unit.PX);
		panelHelp.setVisible(false);
		txtUserName.getElement().setAttribute("maxlength", "20");
		//end
		getForgetPassword().setVisible(false);
		getForgetPasswordMsg().setVisible(false); 
		aboutUsCharacterValidation.setVisible(false);
		
		noAboutUsContainer.setVisible(false);
		profileTextArea.getBiographyEditImage().setVisible(false);
		profileTextArea.getBiographyEditImage().getElement().setAttribute("style", "none");
		btnSave.setVisible(false);
		biographyCancelButton.setVisible(false);
		pencilTextAreaImage.setVisible(false);
		buttonContainer.setVisible(false);
		uploadProfilImageButton.getElement().setId("lblUploadProfilImage");
		uploadProfilImageButton.addClickHandler(new UploadProfileImage());
		uploadProfileImage.addErrorHandler(new ProfileDefaultImage());
		profileImageContainer.addMouseOverHandler(new ShowUploadImageButton());
		profileImageContainer.addMouseOutHandler(new HideUploadImageButton());
		aboutUsContainer.setVisible(false);
		coursesPanel.clear();
		
		lblPleaseWait.setVisible(false);
		
		txtUserName.addBlurHandler(new OnBlurHandler());
		clearErrorMessage();
		txtUserName.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				clearErrorMessage();
				if (txtUserName.getText().length() <4 || txtUserName.getText().length() >20){
					setErrorMessage(GL0473);
				}
			}
		});
		//added in 6.1
		standardsEditButton.setText(GL0140);
		standardsSaveButton.setText(GL0141);
		standardsCancelButton.setText(GL0142);
		standardsText.getElement().setInnerHTML(GL1559);
		standardsSaveCancelButtonContainer.setVisible(false);
		lblCommonCore.setText(GL1560);
		
		lblCaliforniaScience.setText(GL1561);
		lblTexas.setText(GL1562);
		description.setText(GL1583);
		userStandardEditView.setVisible(false);
		userStandardTextPanel.add(commonCoreChk);
		userStandardTextPanel.add(californiaStandChk);
		userStandardTextPanel.add(texasChk);
		commonCoreChk.setText(GL1560);
		commonCoreChk.setName("27787,24146");
		californiaStandChk.setText(GL1561);
		californiaStandChk.setName("30424,42236,42237");
		texasChk.setText(GL1562);
		texasChk.setName("72168");
		commonCoreChk.setStyleName(Settings.standardsCheckBox());
		californiaStandChk.setStyleName(Settings.standardsCheckBox());
		texasChk.setStyleName(Settings.standardsCheckBox());
		standardSavingTextLabel.setText("");
		standardsEditButton.setVisible(true);
		userStandardDefaultView.setVisible(true);
		lblTexas.setVisible(false);
		lblCaliforniaScience.setVisible(false);
		lblCommonCore.setVisible(false);
		lblUserMessage.setText(GL1476);
		lblUserMessage.setVisible(false);
		commonCoreChk.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(commonCoreChk.isChecked()||californiaStandChk.isChecked()||texasChk.isChecked())
				{
					standardsSaveButton.setEnabled(true);
					standardsSaveButton.getElement().removeClassName("disabled");
				}
				
			}
		});
		californiaStandChk.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						if(commonCoreChk.isChecked()||californiaStandChk.isChecked()||texasChk.isChecked())
						{
							standardsSaveButton.setEnabled(true);
							standardsSaveButton.getElement().removeClassName("disabled");
						}
					}
				});
		texasChk.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(commonCoreChk.isChecked()||californiaStandChk.isChecked()||texasChk.isChecked())
					{
						standardsSaveButton.setEnabled(true);
						standardsSaveButton.getElement().removeClassName("disabled");
					}
					
					
				}
			});
		AppClientFactory.getEventBus().addHandler(StandardPreferenceSettingEvent.TYPE, standardPreferenceSettingHandler);
	}
	StandardPreferenceSettingHandler standardPreferenceSettingHandler= new StandardPreferenceSettingHandler(){
		@Override
		public List<String> getCode(List<String> standPrefCode) {
			userStandardPrefcode.clear();
			if(standPrefCode!=null){
				userStandardPrefcode.addAll(standPrefCode);
			}
			getUserCodeId(userStandardPrefcode);
				return standPrefCode;
			
			}
	};
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: Mar 14, 2014
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer:
	 */
	private class OnBlurHandler implements BlurHandler {

		@Override
		public void onBlur(BlurEvent event) {
			
			if (txtUserName.getText().equalsIgnoreCase(lbUName.getText().trim())){
				isUserNameChanged = false;
				clearErrorMessage();
				enableAccSaveButton();
				return;
			}
			isUserNameChanged = true;
			disableAccSaveButton();
			
			 if (event.getSource() == txtUserName
					&& txtUserName.getText()!= null
					&& !txtUserName.getText().equalsIgnoreCase("")) {
								
				boolean userNameValidate = txtUserName.getText().matches(USER_NAME_REGEX);
				/// Words are clear then continue the next steps
				if(!userNameValidate){
					if (txtUserName.isVisible()){
						if (txtUserName.getText().contains(" ")){
							setErrorMessage(GL1635);
						}else{
							setErrorMessage(GL0475);
						}
					}
						
				}else if (txtUserName.getText().length() <4 || txtUserName.getText().length() >20){
					if (txtUserName.isVisible())
						setErrorMessage(GL0473);
				}else{
					// Check for profanity for user name
					if (txtUserName.isVisible())
						checkProfanity(txtUserName.getText().trim());
				}
			} 
		}
	}
	/**
	 * 
	 * @function checkProfanity 
	 * 
	 * @created_date : Mar 14, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param inputString
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void checkProfanity(String inputString){
		disableAccSaveButton();
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", inputString);
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				isProfanityCleared = !value;
				if (value){
					if (txtUserName.isVisible()){
						setErrorMessage(GL0554);
						disableAccSaveButton();
					}
				}else{
					if (txtUserName.isVisible()){
//						enableAccSaveButton();
						clearErrorMessage();
						
						isValidUserName = checkUserAvailability(txtUserName.getText().trim(), BY_USERNAME);
					}
				}
			}
		});		
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
						if (type.equalsIgnoreCase(BY_USERNAME) && isAvailable) {
							isValidUserName = result.isAvailability();
							if (txtUserName.isVisible()){
								setErrorMessage(GL0444);
							
								disableAccSaveButton();
							}

						}else if (type.equalsIgnoreCase(BY_USERNAME) && !isAvailable) {
							if (txtUserName.isVisible()){
								isValidUserName = result.isAvailability();
								
								clearErrorMessage();
								enableAccSaveButton();
							}
						}
					}
				});
		return isAvailable;
	}
	private class onEditImageName implements ClickHandler
	{

		@Override
		public void onClick(ClickEvent event) {
			buttonContainer.setVisible(true);
			editButtonAccount.setVisible(false);
			tbFirstNameUcLabel.switchToEdit();
			tbLastNameUcLabel.switchToEdit();
			lbUName.setVisible(false);
			txtUserName.setVisible(true);
			panelHelp.setVisible(true);
			radioButtonContainer.setVisible(true);
			lblgender.setVisible(false);
			emailbuttonContainer.setVisible(false);
			EduInfoButtonContainer.setVisible(false);
			lbEmail.cancel();
			if(!AppClientFactory.loggedInUser.getLoginType().trim().equalsIgnoreCase("apps")){
				editButtonContact.setVisible(!isChildAccount);
			}
			editButtonEdu.setVisible(true);
			gradeContainer.setVisible(false);
			DefaultGardeContainer.setVisible(true);
			collectionCourseDefaultLstPanel.setVisible(true);
			courseContainer.setVisible(false);
			
			
			txtUserName.setText(lbUName.getText());
			txtUserName.setFocus(true);
//			disableAccSaveButton();
			
			clearErrorMessage();
		}
		
	}
	private class onEditForEmail implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			emailbuttonContainer.setVisible(true);
			//editButtonContact.setVisible(false);
			lbEmail.switchToEdit();
			buttonContainer.setVisible(false);
			EduInfoButtonContainer.setVisible(false);
			tbFirstNameUcLabel.switchToLabel();
			tbLastNameUcLabel.switchToLabel();
			editButtonEdu.setVisible(true);
			editButtonContact.setVisible(!isChildAccount);
			radioButtonContainer.setVisible(false);
			lblgender.setVisible(true);
			editButtonAccount.setVisible(true);
			gradeContainer.setVisible(false);
			DefaultGardeContainer.setVisible(true);
			collectionCourseDefaultLstPanel.setVisible(true);
			courseContainer.setVisible(false);
		
		
			lbUName.setVisible(true);
			txtUserName.setVisible(false);
			panelHelp.setVisible(false);
			clearErrorMessage();
		}
		
	}
	private class onEducationInfo implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			EduInfoButtonContainer.setVisible(true);
			editButtonEdu.setVisible(false);
			gradeContainer.setVisible(true);
			DefaultGardeContainer.setVisible(false);
			collectionCourseDefaultLstPanel.setVisible(false);
			courseContainer.setVisible(true);
			buttonContainer.setVisible(false);
			emailbuttonContainer.setVisible(false);
			lbEmail.cancel();
			tbFirstNameUcLabel.switchToLabel();
			tbLastNameUcLabel.switchToLabel();
			
			if(!AppClientFactory.loggedInUser.getLoginType().trim().equalsIgnoreCase("apps")){
				//editButtonContact.setVisible(true);
				editButtonContact.setVisible(!isChildAccount);
			}
			radioButtonContainer.setVisible(false);
			lblgender.setVisible(true);
			editButtonAccount.setVisible(true);
			
			lbUName.setVisible(true);
			txtUserName.setVisible(false);
			panelHelp.setVisible(false);
			clearErrorMessage();
		}
		
	}
	@UiHandler("settingsSaveButton")
	public void OnClickSaveButton(ClickEvent event) {
		
		tbLastNameUcLabel.switchToLabel();
		tbFirstNameUcLabel.switchToLabel();
		if(enableEdit && enableEditFirstName){
			enableEdit=false;
			enableEditFirstName=false;
			buttonContainer.setVisible(false);
			editButtonAccount.setVisible(false);
			radioButtonContainer.setVisible(false);
			lblgender.setVisible(true);
			charLimitFNameLbl.setVisible(false);
			accountSavingTextLabel.setVisible(true);
			
			lbUName.setVisible(true);
			lbUName.setText(txtUserName.getText());
			txtUserName.setVisible(false);
			panelHelp.setVisible(false);
			
			getUiHandlers().saveSettingsInformation();
			
		}
		
	
	}
	@UiHandler("settingCancelButton")
	public void OnClickCancelSettingpage(ClickEvent event) {
		tbFirstNameUcLabel.cancel();
		tbLastNameUcLabel.cancel();
		enableEdit=false;
		enableEditFirstName=false;
		buttonContainer.setVisible(false);
		editButtonAccount.setVisible(true);
		radioButtonContainer.setVisible(false);
		lblgender.setVisible(true);
		charLimitFNameLbl.setVisible(false);
		lbUName.setVisible(true);
		txtUserName.setVisible(false);
		panelHelp.setVisible(false);
		txtUserName.setText(lbUName.getText());
		if(!AppClientFactory.loggedInUser.getLoginType().trim().equalsIgnoreCase("apps")&& AppClientFactory.loggedInUser.getAccountTypeId()!=2){
			editButtonContact.setVisible(true);
		}
		clearErrorMessage();
		
	}
	@UiHandler("emailSaveButton")
	public void onClickEmailSaveButton(ClickEvent event) {
		MixpanelUtil.Settings_email_change_saved();
		lbEmail.switchToLabel();
		
	}
	@UiHandler("emailCancelButton")
	public void onClickEmailCancelButton(ClickEvent event) {
		lbEmail.cancel();
		emailbuttonContainer.setVisible(false);
		editButtonContact.setVisible(true);
		
		clearErrorMessage();
		
	}
	@UiHandler("eduInfoSaveButton")
	public void onClickEduInfoSaveButton(ClickEvent event) {
		MixpanelUtil.Settings_educational_info_saved();
		gradeContainer.setVisible(false);
		DefaultGardeContainer.setVisible(true);
		EduInfoButtonContainer.setVisible(false);
		editButtonEdu.setVisible(true);
		collectionCourseDefaultLstPanel.setVisible(true);
		courseContainer.setVisible(false);
		EduSavingTextLabel.setVisible(true);
		editButtonEdu.setVisible(false);
		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(gooruUid, USER_META_ACTIVE_FLAG, new SimpleAsyncCallback<ProfileDo>() {

			@Override
			public void onSuccess(ProfileDo profileObj) {
				setProfileData(profileObj);
				EduSavingTextLabel.setVisible(false);
				editButtonEdu.setVisible(true);
			}
			
		});
		
		}
	@UiHandler("eduInfoCancelButton")
	public void onClickEduInfoCancelButton(ClickEvent event) {
		gradeContainer.setVisible(false);
		EduInfoButtonContainer.setVisible(false);
		editButtonEdu.setVisible(true);
		DefaultGardeContainer.setVisible(true);
		collectionCourseDefaultLstPanel.setVisible(true);
		courseContainer.setVisible(false);
		
		clearErrorMessage();
	}
	
	public Label getForgetPassword() {
		return forgetPassword;
	}
	
	public Label getForgetPasswordMsg() {
		return forgetPasswordMsg;
	}
	
	public HTMLEventPanel getPlAccount() {
		return plAccount;
	}

	public HTMLPanel getUserAccount() {
		return userAccount;
	}

	public HTMLPanel getInfoArrow() {
		return accountMiniusArrow;
	}

	
	public HTMLEventPanel getPlSecurity() {
		return plSecurity;
	}

	public HTMLPanel getUserSecurity() {
		return userSecurity;
	}


	public HTMLPanel getSecurityMiniusArrow() {
		return securityMiniusArrow;
	}

	public Label getLbMale() {
		return lbMale;
	}

	public Label getLbFemale() {
		return lbFemale;
	}

	public Label getLbOther() {
		return lbOther;
	}

	public Label getLbShare() {
		return lbShare;
	}

	public HTMLEventPanel getPlEducation() {
		return plEducation;
	}

	public HTMLEventPanel getPlContact() {
		return plContact;
	}

	public HTMLPanel getUserEducation() {
		return userEducation;
	}

	public HTMLPanel getUserContact() {
		return userContact;
	}

	public HTMLPanel getAccountMiniusArrow() {
		return accountMiniusArrow;
	}


	public HTMLPanel getEducationalMiniusArrow() {
		return educationalMiniusArrow;
	}

	

	public HTMLPanel getContactMiniusArrow() {
		return contactMiniusArrow;
	}

	public SettingEmailEditLabelUc getLbEmail() {
		return lbEmail;
	}

	public Label getLbRole() {
		return lbRole;
	}

	

	public Label getLbName() {
		return lbName;
	}

	public Label getLbUserName() {
		return lbUserName;
	}
    
	public Label getLbUName() {
		return lbUName;
	}
	/** 
	 * This method is to get the txtUserName
	 */
	@Override
	public TextBox getTxtUserName() {
		return txtUserName;
	}

	/** 
	 * This method is to set the txtUserName
	 */
	public void setTxtUserName(TextBox txtUserName) {
		this.txtUserName = txtUserName;
	}
	/*closeAllOpenedPopUp
	 * To set the title based on Role 
	 */
	@Override
	public void setData(SettingDo settingDo) {
//		String role=settingDo.getUserType();
//		gooruUid=settingDo.getUser().getGooruUId();
//		if(role != null){
//			if(role.equalsIgnoreCase("Teacher")){
//				gradeLbl.setText(GL1477);
//				courseLbl.setText(GL1478);
//			}
//			else if(role.equalsIgnoreCase("Student")){
//				gradeLbl.setText(GL1479);
//				courseLbl.setText(GL1480);
//			}
//			else{
//				gradeLbl.setText(GL1481);
//				courseLbl.setText(GL1482);
//			}
//		}
//		else{
//			if(settingDo.getUser().getAccountTypeId() == 2){
//				gradeLbl.setText(GL1479);
//				courseLbl.setText(GL1480);
//			}
//			
//		}
		
		
	}
	/*closeAllOpenedPopUp
	 * To set the title based on Role 
	 */
	@Override
	public void setData(V2UserDo v2userDo) {
		this.v2userDo = v2userDo;
		String role=v2userDo.getUserType();
		gooruUid=v2userDo.getUser().getGooruUId();
		if(role != null){
			if(role.equalsIgnoreCase("Teacher")){
				gradeLbl.setText(GL1477);
				courseLbl.setText(GL1478);
			}
			else if(role.equalsIgnoreCase("Student")){
				gradeLbl.setText(GL1479);
				courseLbl.setText(GL1480);
			}
			else{
				gradeLbl.setText(GL1481);
				courseLbl.setText(GL1482);
			}
		}
		else{
			if(v2userDo.getUser().getAccountTypeId() == 2){
				gradeLbl.setText(GL1479);
				courseLbl.setText(GL1480);
			}
			
		}
		
		
	}
	@UiHandler("forgetPassword")
	public void onForgotPwdClicked(ClickEvent clickEvent) {
		if(lbEmail.getText()!=null){
			lblPleaseWait.setVisible(true);
			forgetPassword.setVisible(false);
			AppClientFactory.getInjector().getUserService().forgotPassword(lbEmail.getText(), new SimpleAsyncCallback<Map<String, Object>>() {
					@Override
					public void onSuccess(Map<String, Object> result) {
						lblPleaseWait.setVisible(false);
						forgetPassword.setVisible(true);
					if (result != null && result.containsKey("error") && result.get("error").toString().length() > 0) {
						alertContentUc=new AlertContentUc(GL0061, (String) result.get("error"));
						return;
					}
					if (result != null && result.containsKey("gooruUid") && result.get("gooruUid").toString().length() > 0) {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						forgotPwdSuccessVc=new ForgotPwdSuccessVc();
						forgotPwdSuccessVc.center();
					}
				}
		
			});
		}
	}
	
	public String getSelectedButton(){
		return Settings.radioButtonSelected();
	}
	public String getRadioButton(){
		return Settings.radio();
	}

	@Override
	public void clearPanels() {
		
		tbFirstNameUcLabel.setText("");
		lbUName.setText("");
		txtUserName.setText("");
		panelHelp.setVisible(false);
		tbLastNameUcLabel.setText("");
		lbRole.setText("");
		lbUserName.setText("");
		lbName.setText("");
		lbEmail.setText("");
		profileTextArea.setText("");
		contactMiniusArrow.getElement().getStyle().setDisplay(Display.NONE);
		educationalMiniusArrow.getElement().getStyle().setDisplay(Display.NONE);
		securityMiniusArrow.getElement().getStyle().setDisplay(Display.NONE);
		accountMiniusArrow.getElement().getStyle().setDisplay(Display.NONE);
		
	    userAccount.getElement().getStyle().setDisplay(Display.BLOCK);
	    userContact.getElement().getStyle().setDisplay(Display.BLOCK);
	    userEducation.getElement().getStyle().setDisplay(Display.BLOCK);
	    userSecurity.getElement().getStyle().setDisplay(Display.BLOCK);
	    lbMale.setStyleName(getRadioButton());
	    lbFemale.setStyleName(getRadioButton());
	    lbOther.setStyleName(getRadioButton());
	    lbShare.setStyleName(getRadioButton());
	}

	@Override
	public Button getprofileOnButton() {
		profileOnButton.setStyleName(Settings.publicProfileOnButtonActive());
		profileOnButton.removeStyleName(Settings.publicProfileOnButtonDeActive());
		profileOffButton.setStyleName(Settings.publicProfileOffButtonsDeActive());
		profileOffButton.removeStyleName(Settings.publicProfileOffButtonsActive());
		return profileOnButton;
	}

	@Override
	public Button getProfileOffButton() {
		profileOffButton.setStyleName(Settings.publicProfileOffButtonsActive());
		profileOffButton.removeStyleName(Settings.publicProfileOffButtonsDeActive());
		profileOnButton.setStyleName(Settings.publicProfileOnButtonDeActive());
		profileOnButton.removeStyleName(Settings.publicProfileOnButtonActive());
	
		return profileOffButton;
	}

	@Override
	public ProfileBiographyEditUC getProfileBiographyEditUC() {
		return profileTextArea;
	}

	@Override
	public HTMLPanel getAboutUsContainer() {
		return aboutUsContainer;
	}

	@Override
	public Button getSeeMyPageButton() {
	return btnSeeMyProfile;
	}

	
	@Override
	public FocusPanel noAboutUsContainer() {
		return noAboutUsContainer;
	}

	@Override
	public HTMLEventPanel getBiographyCancelButton() {
		return biographyCancelButton;
	}

	@Override
	public Label getaboutUsCharacterValidation() {
		return aboutUsCharacterValidation;
	}
	
	
	private class UploadProfileImage implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.NONE);
			getUiHandlers().showUploadProfileImageWidget();
		}
	}
	
	private class ProfileDefaultImage implements ErrorHandler{
		@Override
		public void onError(ErrorEvent event) {
			uploadProfileImage.setUrl(PROFILE_DEFAULT_IMAGE);
			try{
				
				uploadProfileImage.setAltText(v2userDo.getUser().getUsername());
				uploadProfileImage.setTitle(v2userDo.getUser().getUsername());
			}catch(Exception exception){

			}
		}
	}

	@Override
	public void setUserProfileImageUrl(String imageUrl) {
		double randomNumber=Math.random();
		uploadProfileImage.setUrl(imageUrl+"?p="+randomNumber);
		try{
			uploadProfileImage.setAltText(v2userDo.getUser().getUsername());
			uploadProfileImage.setTitle(v2userDo.getUser().getUsername());
		}catch(Exception exception){

		}

	}
	private class ShowUploadImageButton implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.BLOCK);
		}
		
	}
	private class HideUploadImageButton implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.NONE);
		}
		
	}

	@Override
	public void setProfileData(ProfileDo profileDo) {
		uploadProfileImage.setUrl(profileDo.getUser().getProfileImageUrl() + "?p="+ Math.random());
		setGradeList(profileDo.getGrade(), profileDo);
		Set<ProfileCodeDo> codeDo = profileDo.getCourses();
		coursesPanel.clear();
		
		
		collectionCourseDefaultLstPanel.clear();
		for (ProfileCodeDo code : codeDo) {
			coursesPanel.add(createCourseLabel(code.getCode().getLabel(), code.getCode().getCodeId() + ""));
			//collectionCourseDefaultLstPanel.add(createCourseLabel(code.getCode().getLabel(), code.getCode().getCodeId() + ""));
			defaultCoursePanel=new HTML(code.getCode().getLabel());
			collectionCourseDefaultLstPanel.add(defaultCoursePanel);
			defaultCoursePanel.setStyleName(Settings.deafaultCourse());
			
		}
		if(profileDo.getCourses().size()==0){
			Label defaultCourseLabel=new Label();
			defaultCourseLabel.setStyleName(Settings.defaultTextcss());
			defaultCourseLabel.getElement().setAttribute("style","margin-left: 0px !important");
			defaultCourseLabel.setText(NONE_ADDED);
			collectionCourseDefaultLstPanel.add(defaultCourseLabel);
		}
		
	}
	
	/**
	 * separate the view according to grade level of the user
	 */
	public void setGradeList(String grades, ProfileDo profileDo) {
		
		if(grades!=null){
		DefaultGardeContainer.clear();
		//For short
		List<Integer> listI = new ArrayList<Integer>();
		List<String> listS = new ArrayList<String>();

		List<Object> listO = new ArrayList<Object>();
		String[] newst = grades.split(",");

		for (int i = 0; i < newst.length; i++) {
			try {
				int k = Integer.parseInt(newst[i]);
				listI.add(k);
			} catch (Exception e) {
				listS.add(newst[i]);
			}
		}
		Collections.sort(listS, Collections.reverseOrder());

		Collections.sort(listI);
		if (listS.contains("Kindergarten")
				&& listS.contains("Higher Education")) {
			listO.add("Kindergarten");
			listO.addAll(listI);
			listO.add("Higher Education");
		} else if (listS.contains("Kindergarten")) {
			listO.add("Kindergarten");
			listO.addAll(listI);
		} else if (listS.contains("Higher Education")) {
			listO.addAll(listI);
			listO.add("Higher Education");
		} else {
			listO.addAll(listI);
		}

		StringBuilder sortedGrade = new StringBuilder();
		for (Object obj : listO) {

			sortedGrade.append(obj.toString());
			Label gradeLabel=new Label(obj.toString());
			gradeLabel.setStyleName(CollectionCBundle.INSTANCE.css().settingPageDefaultGrade());
			gradeLabel.getElement().setAttribute("selected", "selected");
			DefaultGardeContainer.add(gradeLabel);
		}
		}
		else
		{
			DefaultGardeContainer.clear();
			Label defaulTextLabel=new Label();
			defaulTextLabel.setStyleName(Settings.defaultTextcss());
			defaulTextLabel.setText(NONE_ADDED);
			DefaultGardeContainer.add(defaulTextLabel);
			
		}
				
		KinderGarten.clear();
		higherEducation.clear();
		gradeTopList.clear();
		gradeMiddleList.clear();
		
		KinderGarten.add(new ProfilePageGradeLabel(GL0850, profileDo));
		higherEducation.add(new ProfilePageGradeLabel(GL0169,profileDo));
		for (int i = 1; i <= 12; i++) {
			if (i <= 6) {
				gradeTopList.add(new ProfilePageGradeLabel(i + "", profileDo));
				
			}
			if (i >= 7) {
				gradeMiddleList.add(new ProfilePageGradeLabel(i + "", profileDo));
				
			}
		}
	}
	
	
	/**
	 * New course is created for User
	 * 
	 * @param courseLabel
	 *            the course of the label widget which is used to get all
	 *            courses
	 * @param courseCode
	 *            the course of the course code, an absolute course code will be
	 *            used to create a new course
	 * @return the label of all course created for the User.
	 */
	protected CloseLabelSetting createCourseLabel(final String courseLabel,
			final String courseCode) {
		return new CloseLabelSetting(courseLabel) {

			@Override
			public void onCloseLabelClick(ClickEvent event) {
				this.removeFromParent();
				CodeDo codeDo = new CodeDo();
				codeDo.setCodeId(Integer.parseInt(courseCode));
				getUiHandlers().deleteCourse(codeDo);
			}
		};
	}
	/**
	 * Set courses to the ListBox
	 * 
	 * @param libraryCode 
	 *          To set library code for all courses.  
	 */
	@Override
	public void setCourseList(List<LibraryCodeDo> libraryCode) {
		collectionCourseLst = new GroupedListBox();
		collectionCourseLst.addStyleName(CollectionCBundle.INSTANCE.css()
				.infoTextBox());
		collectionCourseLst.addItem(" What course(s) do you teach? ", "-1");
		if (libraryCode != null) {
			for (LibraryCodeDo libraryCodeDo : libraryCode) {
				for (LibraryCodeDo liCodeDo : libraryCodeDo.getNode()) {
					collectionCourseLst.addItem(libraryCodeDo.getLabel() + "|"
							+ liCodeDo.getLabel(), liCodeDo.getCodeId() + "");
				}
			}
		}
		collectionCourseLstPanel.clear();
		collectionCourseLstPanel.add(collectionCourseLst);
		
		collectionCourseLst.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				addCourseEvent();
			}
		});
			
	}
	
	/**
	 * Adding new course , will check it has more than five
	 * courses and the selected course is repeated or not
	 * 
	 */
	
	private void addCourseEvent() {
			if (coursesPanel.getWidgetCount() < 5) {
				final String courseCodeLabel = collectionCourseLst
						.getItemText(collectionCourseLst.getSelectedIndex());
				final String courseCode = collectionCourseLst
						.getValue(collectionCourseLst.getSelectedIndex());
				if (collectionCourseLst.getSelectedIndex() == 0) {
					return;
				}
				if (validateCourse(courseCodeLabel) && courseCode != null) {
					alertContentUc=	new AlertContentUc(GL1089, GL1090);
				} else {
					Set<ProfileCodeDo> profileCodeDoSet = new HashSet<ProfileCodeDo>();
					ProfileCodeDo profileCodeDo = new ProfileCodeDo();
					CodeDo codeDo = new CodeDo();
					codeDo.setCodeId(Integer.parseInt(courseCode));
					profileCodeDo.setCode(codeDo);
					profileCodeDoSet.add(profileCodeDo);
					getUiHandlers().addCourse(profileCodeDoSet);
					coursesPanel.add(createCourseLabel(courseCodeLabel, courseCode));
					collectionCourseLst.setSelectedIndex(0);
				}
				courseMaxHide();
			} else {
				courseMaxShow();
			}
		
	}
	
	
	/**
	 * Will check it ,the selected course is repeated or not
	 * 
	 * @param course
	 *            to validate with already added course
	 * @return true if repeated course is selected or false
	 */
	protected boolean validateCourse(String course) {
		for (Widget widget : coursesPanel) {
			if (course.equals(((CloseLabelSetting) widget).getSourceText())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * to hide message if course exceeds less than five
	 */
	public void courseMaxHide() {
		courseData.setStyleName(CollectionCBundle.INSTANCE.css().floatLeft());
		collectionCourseLst.setStyleName(CollectionCBundle.INSTANCE.css()
				.infoTextBox());
		/*addCourseBtn.setStyleName(CollectionCBundle.INSTANCE.css()
				.infoAddButton());*/
		courseMaxMsg.setStyleName(CollectionCBundle.INSTANCE.css()
				.courseMaxMsg());
		courseMaxMsg.getElement().getStyle().setFloat(Float.LEFT);
	}
	
	/**
	 * to display message if course exceeds more than five
	 */
	public void courseMaxShow() {
		courseMaxMsg.setStyleName(CollectionCBundle.INSTANCE.css().profileCourseMaxMsgShow());
		new FadeInAndOut(courseMaxMsg.getElement(), 10000, 10000);
	}

	@Override
	public void closeAllOpenedPopUp() {
		/*if(savePopup!=null && savePopup.isShowing()){
			savePopup.hide();
		}
	*/	if(alertContentUc!=null){
			alertContentUc.getAlertBox().hide();
		}
		if(forgotPwdSuccessVc!=null){
			forgotPwdSuccessVc.hide();
		}
	}

	@Override
	public void disableContentAndSetOldContent(String aboutMe) {
	
		
	}

	@Override
	public SettingLastNameEditLabelUC getTbLastName() {
		 
		return tbLastNameUcLabel;
	}

	@Override
	public SettingEditLabelUc getTbFirstName() {
		return tbFirstNameUcLabel;
	}

	@Override
	public Label getSavingTextLabel() {
		return SavingTextLabel;
	}

	@Override
	public Button getEditEmailButton() {
		return editButtonContact;
	}

	@Override
	public Label getEmailTextConfirmation() {
		return emailTextConfirmation;
	}
	

	@Override
	public Label getGenderText() {
		return lblgender;
	}

	/** 
	 * This method is to get the isChildAccount
	 */
	public boolean isChildAccount() {
		return isChildAccount;
	}

	/** 
	 * This method is to set the isChildAccount
	 */
	@Override
	public void setChildAccount(boolean isChildAccount) {
		this.isChildAccount = isChildAccount;
	}

	@Override
	public Label getAccountSavingText() {
		return accountSavingTextLabel;
	}

	@Override
	public Button getEditButtonAccount() {
		return editButtonAccount;
	}
	
	private void setErrorMessage(String errorMessage){
		userNameValidationUc.getElement().getStyle().setMarginLeft(85, Unit.PX);
		userNameValidationUc.getElement().getStyle().setLineHeight(120, Unit.PCT);
		userNameValidationUc.getElement().getStyle().setWidth(300, Unit.PX);
		userNameValidationUc.getElement().getStyle().setFontSize(12, Unit.PX);
		userNameValidationUc.setVisible(true);
		userNameValidationUc.addStyleName("errorMessage");
		userNameValidationUc.setText(errorMessage);
		
		txtUserName.getElement().getStyle().setBorderColor("orange");
	}
	
	private void clearErrorMessage(){
		userNameValidationUc.setVisible(false);
		userNameValidationUc.getElement().getStyle().setLineHeight(0, Unit.PCT);
		txtUserName.getElement().getStyle().clearBackgroundColor();
		txtUserName.getElement().getStyle().setBorderColor("#ccc");
		
	}
	
	private void disableAccSaveButton(){
		settingsSaveButton.getElement().addClassName(DISABLED);
		settingsSaveButton.setEnabled(false);
	}
	
	private void enableAccSaveButton(){
		settingsSaveButton.getElement().removeClassName(DISABLED);
		settingsSaveButton.setEnabled(true);
	}

	/** 
	 * This method is to get the isUserNameChanged
	 */
	@Override
	public boolean isUserNameChanged() {
		return isUserNameChanged;
	}

	/** 
	 * This method is to set the isUserNameChanged
	 */
	public void setUserNameChanged(boolean isUserNameChanged) {
		this.isUserNameChanged = isUserNameChanged;
	}

	/** 
	 * This method is to get the isValidUserName
	 */
	@Override
	public boolean isValidUserName() {
		return isValidUserName;
	}

	/** 
	 * This method is to set the isValidUserName
	 */
	public void setValidUserName(boolean isValidUserName) {
		this.isValidUserName = isValidUserName;
	}

	@Override
	public void hideuserDetailsContainerOnClickOfTab() {
		buttonContainer.setVisible(false);
		editButtonAccount.setVisible(true);
		tbFirstNameUcLabel.switchToLabel();
		tbLastNameUcLabel.switchToLabel();
		lbUName.setVisible(true);
		
	}
	@UiHandler("standardsEditButton")
	public void onClickOfstandardsEditButton(ClickEvent event)
	{
		standardsSaveCancelButtonContainer.setVisible(true);
		standardsEditButton.setVisible(false);
		userStandardEditView.setVisible(true);
		userStandardDefaultView.setVisible(false);
	}
	public String getcheckedValue(){
		String codeId = "";
		if(commonCoreChk.isChecked()){
			if(codeId!=""){
				codeId=codeId+","+commonCoreChk.getName();
			}
			else
			{
				codeId=codeId+commonCoreChk.getName();	
			}
		}
		else
		{
			
		}
		if(californiaStandChk.isChecked())
		{
			if(codeId!=""){
				codeId=codeId+","+californiaStandChk.getName();	
			}
			else
			{
				codeId=codeId+californiaStandChk.getName();	
			}
		}
		if(texasChk.isChecked())
		{
			if(codeId!=""){
				codeId=codeId+","+texasChk.getName();	
			}
			else
			{
				codeId=codeId+texasChk.getName();	
			}
		}
		return codeId;
	}
	@UiHandler("standardsSaveButton")
	public void onClickOfstandardsSaveButton(ClickEvent event)
	{
	
		if(commonCoreChk.isChecked() || californiaStandChk.isChecked() || texasChk.isChecked()){
			getUiHandlers().updatePartyCustomField(USER_TAXONOMY_ROOT_CODE,getcheckedValue());
		}
		if(userStandardPrefcode!=null){
		if(!commonCoreChk.isChecked() && !californiaStandChk.isChecked() && !texasChk.isChecked()){
				standardsSaveButton.setEnabled(true);
				standardsSaveButton.getElement().removeClassName("disabled");
				UserSettingStandardDeleteView userSettingStandardDeleteView = new UserSettingStandardDeleteView(gooruUid,standardsEditButton,standardsSaveCancelButtonContainer,standardSavingTextLabel);
			   	userSettingStandardDeleteView.show();
				userSettingStandardDeleteView.center();
				userStandardEditView.setVisible(false);
				userStandardDefaultView.setVisible(true);
			}
		}
		else
		{
			if(!commonCoreChk.isChecked() && !californiaStandChk.isChecked() && !texasChk.isChecked()){
				standardsSaveButton.setEnabled(false);
				standardsSaveButton.getElement().addClassName("disabled");
			}
		}
	
		
	}
	@UiHandler("standardsCancelButton")
	public void onClickOfstandardsCancelButton(ClickEvent event)
	{
		standardsSaveCancelButtonContainer.setVisible(false);
		standardsEditButton.setVisible(true);
		userStandardEditView.setVisible(false);
		userStandardDefaultView.setVisible(true);
		getUserCodeId(userStandardPrefcode);
	
	}

	@Override
	public void getUserCodeId(List<String> list) {
		standardsSaveCancelButtonContainer.setVisible(false);
		standardsEditButton.setVisible(true);
		userStandardEditView.setVisible(false);
		userStandardDefaultView.setVisible(true);
		if(list!=null){
			if(list.size()!=0){
			lblUserMessage.setVisible(false);
			standardsSaveButton.setEnabled(true);
			standardsSaveButton.getElement().removeClassName("disabled");
			if(list.contains("CCSS")){
				commonCoreChk.setChecked(true);
				lblCommonCore.setVisible(true);
			}
			else
			{
				lblCommonCore.setVisible(false);
				commonCoreChk.setChecked(false);
			}
			if(list.contains("CASK5")){
				californiaStandChk.setChecked(true);
				lblCaliforniaScience.setVisible(true);
			}
			else
			{
				lblCaliforniaScience.setVisible(false);
				californiaStandChk.setChecked(false);
			}
			if(list.contains("TEXAS")||list.contains("TEKS")){
				texasChk.setChecked(true);
				lblTexas.setVisible(true);
			}
			else
			{
				texasChk.setChecked(false);
				lblTexas.setVisible(false);
				
			}
		
		}else{
			lblCommonCore.setVisible(false);	
			lblCaliforniaScience.setVisible(false);
			lblTexas.setVisible(false);
			lblUserMessage.setVisible(true);
			standardsSaveButton.setEnabled(false);
			standardsSaveButton.getElement().addClassName("disabled");
			texasChk.setChecked(false);
			californiaStandChk.setChecked(false);
			commonCoreChk.setChecked(false);	
		}
		}
		else
		{
			lblCommonCore.setVisible(false);	
			lblCaliforniaScience.setVisible(false);
			lblTexas.setVisible(false);
			lblUserMessage.setVisible(true);
			standardsSaveButton.setEnabled(false);
			standardsSaveButton.getElement().addClassName("disabled");
			texasChk.setChecked(false);
			californiaStandChk.setChecked(false);
			commonCoreChk.setChecked(false);
		}
			
	}

	@Override
	public Label getStandardSavingTextLabel() {
		return standardSavingTextLabel;
	}

	@Override
	public HTMLPanel getstandardsSaveCancelButtonContainer() {
		return standardsSaveCancelButtonContainer;
	}

	@Override
	public HTMLPanel getuserStandardEditView() {
		return userStandardEditView;
	}

	@Override
	public Button getstandardsEditButton() {
		return standardsEditButton;
	}

	@Override
	public HTMLPanel getuserStandardDefaultView() {
		return userStandardDefaultView;
	}

	@Override
	public void hideEmailContainer() {
		emailPanel.setVisible(false);
	}
	
}