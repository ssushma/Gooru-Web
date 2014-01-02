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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.ForgotPwdSuccessVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.CloseLabelSetting;
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

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;
/**
 * 
 * @fileName : UserSettingsView.java
 *
 * @description : This file deals with User Settings.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class UserSettingsView extends BaseViewWithHandlers<UserSettingsUiHandlers> implements IsUserSettingsView{
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
	
	@UiField HTMLEventPanel pencilTextAreaImage,plAccount,plSecurity,plEducation,plContact,profileDescriptionlabel,biographyCancelButton;
	@UiField HTMLPanel userAccount,userSecurity,userEducation,userContact,accountMiniusArrow,securityMiniusArrow,educationalMiniusArrow,contactMiniusArrow;
	@UiField Label aboutUsCharacterValidation,lbMale,lbFemale,lbOther,lbShare,lbRole,lbName,lbUserName,lbUName,forgetPassword,forgetPasswordMsg;
	@UiField HTMLPanel aboutUsContainer;
	//@UiField TextBox tbLastName,tbFirstName;
	@UiField Button settingsSaveButton,profileOnButton,profileOffButton, btnSave, btnSeeMyProfile;
	@UiField HTMLPanel radioButtonContainer;
	@UiField UserSettingStyle Settings;
	@UiField Label courseLabel,courseMaxMsg,courseLbl,gradeLbl,SavingTextLabel,EduSavingTextLabel;
	@UiField FlowPanel KinderGarten,gradeTopList,gradeMiddleList,higherEducation,courseData,collectionCourseLstPanel,coursesPanel,collectionCourseDefaultLstPanel;
	@UiField Label uploadProfilImageButton,accountSavingTextLabel;
	@UiField Label charLimitFNameLbl,emailTextConfirmation,lblgender;
	@UiField FocusPanel noAboutUsContainer;
	@UiField HTMLEventPanel profileImageContainer,userCoursePopup;
	@UiField Image uploadProfileImage;
	@UiField HTMLPanel editButtonContainerAccount,editButtonContainerEdu,editButtonContainerContact,buttonContainer,emailbuttonContainer,EduInfoButtonContainer,gradeContainer,DefaultGardeContainer,courseContainer;
	@UiField Button editButtonAccount,editButtonEdu,editButtonContact,settingCancelButton,emailCancelButton,emailSaveButton,eduInfoCancelButton,eduInfoSaveButton;
	
	@UiField Label lblPleaseWait;
	
	private ProfileDo profileDo;
	private static String USER_META_ACTIVE_FLAG = "1";
	private static String NONE_ADDED = "(none added)";
	private GroupedListBox collectionCourseLst;
	HTML defaultCoursePanel;
	private SettingDo settingDo;
	
	private AlertContentUc alertContentUc;
	
	private ForgotPwdSuccessVc forgotPwdSuccessVc;
	String gooruUid="";
	boolean enableEdit = false;
	boolean enableEditFirstName = false;	
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
	/**
	 * Class Constructor.
	 */
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
		
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : EditImage click handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class onEditImageName implements ClickHandler
	{

		@Override
		public void onClick(ClickEvent event) {
			buttonContainer.setVisible(true);
			editButtonAccount.setVisible(false);
			tbFirstNameUcLabel.switchToEdit();
			tbLastNameUcLabel.switchToEdit();
			radioButtonContainer.setVisible(true);
			lblgender.setVisible(false);
			emailbuttonContainer.setVisible(false);
			EduInfoButtonContainer.setVisible(false);
			lbEmail.cancel();
			editButtonContact.setVisible(!isChildAccount);
			editButtonEdu.setVisible(true);
			gradeContainer.setVisible(false);
			DefaultGardeContainer.setVisible(true);
			collectionCourseDefaultLstPanel.setVisible(true);
			courseContainer.setVisible(false);
			
		}
		
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : Edit email click handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
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
		
		
		}
		
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : EducationInfo click handler
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
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
			editButtonContact.setVisible(true);
			editButtonContact.setVisible(!isChildAccount);
			radioButtonContainer.setVisible(false);
			lblgender.setVisible(true);
			editButtonAccount.setVisible(true);
			
			
		}
		
	}
	/**
	 * 
	 * @function OnClickSaveButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :UIHandler for settingsSaveButton.
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
			getUiHandlers().saveSettingsInformation();
			
		}
		
	
	}
	/**
	 * 
	 * @function OnClickCancelSettingpage 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :UIHandler for settingCancelButton
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
	
	
	}
	/**
	 * 
	 * @function onClickEmailSaveButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : UIHandler for emailSaveButton.
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
	@UiHandler("emailSaveButton")
	public void onClickEmailSaveButton(ClickEvent event) {
		MixpanelUtil.Settings_email_change_saved();
		lbEmail.switchToLabel();
		
	}
	/**
	 * 
	 * @function onClickEmailCancelButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :UIHandler for emailCancelButton.
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
	@UiHandler("emailCancelButton")
	public void onClickEmailCancelButton(ClickEvent event) {
		lbEmail.cancel();
		emailbuttonContainer.setVisible(false);
		editButtonContact.setVisible(true);
		
	}
	/**
	 * 
	 * @function onClickEduInfoSaveButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : UIHandler for eduInfoSaveButton.
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
	/**
	 * 
	 * @function onClickEduInfoCancelButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : UIHandler for eduInfoCancelButton.
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
	@UiHandler("eduInfoCancelButton")
	public void onClickEduInfoCancelButton(ClickEvent event) {
		gradeContainer.setVisible(false);
		EduInfoButtonContainer.setVisible(false);
		editButtonEdu.setVisible(true);
		DefaultGardeContainer.setVisible(true);
		collectionCourseDefaultLstPanel.setVisible(true);
		courseContainer.setVisible(false);
		
	}
	/**
	 * returns forgetPassword.
	 */
	public Label getForgetPassword() {
		return forgetPassword;
	}
	/**
	 * returns forgetPasswordMsg.
	 */
	public Label getForgetPasswordMsg() {
		return forgetPasswordMsg;
	}
	/**
	 * returns plAccount.
	 */
	public HTMLEventPanel getPlAccount() {
		return plAccount;
	}
	/**
	 * returns userAccount.
	 */
	public HTMLPanel getUserAccount() {
		return userAccount;
	}
	/**
	 * returns accountMiniusArrow.
	 */
	public HTMLPanel getInfoArrow() {
		return accountMiniusArrow;
	}
	/**
	 * returns plSecurity.
	 */
	public HTMLEventPanel getPlSecurity() {
		return plSecurity;
	}
	/**
	 * returns userSecurity.
	 */
	public HTMLPanel getUserSecurity() {
		return userSecurity;
	}
	/**
	 * returns securityMiniusArrow.
	 */
	public HTMLPanel getSecurityMiniusArrow() {
		return securityMiniusArrow;
	}
	/**
	 * returns lbMale
	 */
	public Label getLbMale() {
		return lbMale;
	}
	/**
	 * returns lbFemale
	 */
	public Label getLbFemale() {
		return lbFemale;
	}
	/**
	 * returns lbOther.
	 */
	public Label getLbOther() {
		return lbOther;
	}
	/**
	 * returns lbShare.
	 */
	public Label getLbShare() {
		return lbShare;
	}
	/**
	 * returns plEducation.
	 */
	public HTMLEventPanel getPlEducation() {
		return plEducation;
	}
	/**
	 * returns plContact.
	 */
	public HTMLEventPanel getPlContact() {
		return plContact;
	}
	/**
	 * returns userEducation.
	 */
	public HTMLPanel getUserEducation() {
		return userEducation;
	}
	/**
	 * returns userContact.
	 */
	public HTMLPanel getUserContact() {
		return userContact;
	}
	/**
	 * returns accountMiniusArrow.
	 */
	public HTMLPanel getAccountMiniusArrow() {
		return accountMiniusArrow;
	}
	/**
	 * returns educationalMiniusArrow.
	 */
	public HTMLPanel getEducationalMiniusArrow() {
		return educationalMiniusArrow;
	}
	/**
	 * returns contactMiniusArrow.
	 */
	public HTMLPanel getContactMiniusArrow() {
		return contactMiniusArrow;
	}
	/**
	 * returns lbEmail.
	 */
	public SettingEmailEditLabelUc getLbEmail() {
		return lbEmail;
	}
	/**
	 * returns lbRole.
	 */
	public Label getLbRole() {
		return lbRole;
	}
	/**
	 * returns lbName.
	 */
	public Label getLbName() {
		return lbName;
	}
	/**
	 * returns lbUserName.
	 */
	public Label getLbUserName() {
		return lbUserName;
	}
	/**
	 * returns lbUName.
	 */
	public Label getLbUName() {
		return lbUName;
	}
	
	/** closeAllOpenedPopUp
	 * To set the title based on Role 
	 */
	@Override
	public void setData(SettingDo settingDo) {
		String role=settingDo.getUserType();
		gooruUid=settingDo.getUser().getGooruUId();
		if(role != null){
			if(role.equalsIgnoreCase("Teacher")){
				gradeLbl.setText("What grade(s) do u teach?");
				courseLbl.setText("What course(s) do u teach?");
			}
			else if(role.equalsIgnoreCase("Student")){
				gradeLbl.setText("What grade are you in?");
				courseLbl.setText("Select the course(s) you are taking");
			}
			else{
				gradeLbl.setText("Select grade(s) that you are interested in");
				courseLbl.setText("Select course(s) which you are interested in");
			}
		}
		else{
			if(settingDo.getUser().getAccountTypeId() == 2){
				gradeLbl.setText("What grade are you in?");
				courseLbl.setText("Select the course(s) you are taking");
			}
			
		}
		
		
	}
	/**
	 * 
	 * @function onForgotPwdClicked 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : UIHandler for forgetPassword.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
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
						alertContentUc=new AlertContentUc("Oops!", (String) result.get("error"));
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
	/**
	 * returns the selected radio button.
	 */
	public String getSelectedButton(){
		return Settings.radioButtonSelected();
	}
	/**
	 * This is used to get the radio button.
	 */
	public String getRadioButton(){
		return Settings.radio();
	}
	/**
	 * This is used to clear the panels.
	 */
	@Override
	public void clearPanels() {
		
		tbFirstNameUcLabel.setText("");
		lbUName.setText("");
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
	/**
	 * Returns profileOnButton.
	 */
	@Override
	public Button getprofileOnButton() {
		profileOnButton.setStyleName(Settings.publicProfileOnButtonActive());
		profileOnButton.removeStyleName(Settings.publicProfileOnButtonDeActive());
		profileOffButton.setStyleName(Settings.publicProfileOffButtonsDeActive());
		profileOffButton.removeStyleName(Settings.publicProfileOffButtonsActive());
		return profileOnButton;
	}
	/**
	 * Returns profileOffButton.
	 */
	@Override
	public Button getProfileOffButton() {
		profileOffButton.setStyleName(Settings.publicProfileOffButtonsActive());
		profileOffButton.removeStyleName(Settings.publicProfileOffButtonsDeActive());
		profileOnButton.setStyleName(Settings.publicProfileOnButtonDeActive());
		profileOnButton.removeStyleName(Settings.publicProfileOnButtonActive());
	
		return profileOffButton;
	}
	/**
	 * returns profileTextArea.
	 */
	@Override
	public ProfileBiographyEditUC getProfileBiographyEditUC() {
		return profileTextArea;
	}
	/**
	 * returns aboutUsContainer
	 */
	@Override
	public HTMLPanel getAboutUsContainer() {
		return aboutUsContainer;
	}
	/**
	 * To get seeMyPageButton.
	 */
	@Override
	public Button getSeeMyPageButton() {
	return btnSeeMyProfile;
	}
	/**
	 * returns noAboutUsContainer.
	 */
	@Override
	public FocusPanel noAboutUsContainer() {
		return noAboutUsContainer;
	}
	/**
	 * returns biographyCancelButton.
	 */
	@Override
	public HTMLEventPanel getBiographyCancelButton() {
		return biographyCancelButton;
	}
	/**
	 * returns aboutUsCharacterValidation.
	 */
	@Override
	public Label getaboutUsCharacterValidation() {
		return aboutUsCharacterValidation;
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : This is used to UploadProfileImage.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	
	private class UploadProfileImage implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.NONE);
			getUiHandlers().showUploadProfileImageWidget();
		}
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : This is used to set the profile default image.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class ProfileDefaultImage implements ErrorHandler{
		@Override
		public void onError(ErrorEvent event) {
			uploadProfileImage.setUrl(PROFILE_DEFAULT_IMAGE);
			try{
				uploadProfileImage.setAltText(settingDo.getUser().getUsername());
				uploadProfileImage.setTitle(settingDo.getUser().getUsername());
			}catch(Exception exception){

			}
		}
	}
	/**
	 * This method is used to set image url for profile image.
	 */
	@Override
	public void setUserProfileImageUrl(String imageUrl) {
		double randomNumber=Math.random();
		uploadProfileImage.setUrl(imageUrl+"?p="+randomNumber);
		try{
			uploadProfileImage.setAltText(settingDo.getUser().getUsername());
			uploadProfileImage.setTitle(settingDo.getUser().getUsername());
		}catch(Exception exception){

		}
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : This is used to Show UploadImageButton.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class ShowUploadImageButton implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.BLOCK);
		}
		
	}
	/**
	 * 
	 * @fileName : UserSettingsView.java
	 *
	 * @description : This is used to hide uploadProfilImageButton.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class HideUploadImageButton implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			uploadProfilImageButton.getElement().getStyle().setDisplay(Display.NONE);
		}
		
	}
	/**
	 * This is used to set profile data.
	 */
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
		
		KinderGarten.add(new ProfilePageGradeLabel("Kindergarten", profileDo));
		higherEducation.add(new ProfilePageGradeLabel("Higher Education",profileDo));
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
					alertContentUc=	new AlertContentUc("Oops", "Please add different courses");
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
	/**
	 * This is used to disable content and to set id for content.
	 */
	@Override
	public void disableContentAndSetOldContent(String aboutMe) {
	}
	/**
	 * returns tbLastNameUcLabel.
	 */
	@Override
	public SettingLastNameEditLabelUC getTbLastName() {
		return tbLastNameUcLabel;
	}
	/**
	 * returns tbFirstNameUcLabel.
	 */
	@Override
	public SettingEditLabelUc getTbFirstName() {
		return tbFirstNameUcLabel;
	}
	/**
	 * returns SavingTextLabel.
	 */
	@Override
	public Label getSavingTextLabel() {
		return SavingTextLabel;
	}
	/**
	 * returns editButtonContact.
	 */
	@Override
	public Button getEditEmailButton() {
		return editButtonContact;
	}
	/**
	 * returns emailTextConfirmation.
	 */
	@Override
	public Label getEmailTextConfirmation() {
		return emailTextConfirmation;
	}
	/**
	 * returns lblgender.
	 */
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
	/**
	 * returns accountSavingTextLabel.
	 */
	@Override
	public Label getAccountSavingText() {
		return accountSavingTextLabel;
	}
	/**
	 * returns editButtonAccount.
	 */
	@Override
	public Button getEditButtonAccount() {
		return editButtonAccount;
	}
	
	
	
}
	
