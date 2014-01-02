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



import java.util.List;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.uc.ProfileBiographyEditUC;
import org.ednovo.gooru.client.uc.SettingEditLabelUc;
import org.ednovo.gooru.client.uc.SettingEmailEditLabelUc;
import org.ednovo.gooru.client.uc.SettingLastNameEditLabelUC;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.SettingDo;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
/**
 * 
 * @fileName : IsUserSettingsView.java
 *
 * @description : This file is the interface for UserSettingsView.java
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
public interface IsUserSettingsView extends IsViewWithHandlers<UserSettingsUiHandlers>{

	
	public HTMLEventPanel getPlAccount();
	public HTMLPanel getUserAccount();
	public HTMLPanel getInfoArrow();
	/*public HTMLPanel getExpandArrow();*/
	public HTMLEventPanel getPlSecurity();
	public HTMLPanel getUserSecurity();
	/*public HTMLPanel getSecurityExpandArrow();*/
	public HTMLPanel getSecurityMiniusArrow();
	public Label getLbMale();
	public Label getLbFemale();
	public Label getLbOther();
	public Label getLbShare();
	public Label getForgetPassword();
	public Label getForgetPasswordMsg();
	public HTMLEventPanel getPlEducation();
	public HTMLEventPanel getPlContact(); 
	public HTMLPanel getUserEducation();
	public HTMLPanel getUserContact();
	public HTMLPanel getAccountMiniusArrow(); 
	/*public HTMLPanel getAccountExpandArrow();*/
	public HTMLPanel getEducationalMiniusArrow(); 
	/*public HTMLPanel getEducationalExpandArrow(); */
	/*public HTMLPanel getContactExpandArrow(); */
	public HTMLPanel getContactMiniusArrow(); 
	public SettingEmailEditLabelUc getLbEmail();
	public Label getLbRole();
	public SettingLastNameEditLabelUC getTbLastName();
	public SettingEditLabelUc getTbFirstName();
	public Label getLbName();
	public Label getLbUserName();
	public String getSelectedButton();
	public String getRadioButton();
	public Label getLbUName();
	public void clearPanels();
	public Button getprofileOnButton();
	public Button getProfileOffButton();
	public ProfileBiographyEditUC getProfileBiographyEditUC(); 
	public HTMLPanel getAboutUsContainer();
	public Button getSeeMyPageButton();
	public void setUserProfileImageUrl(String imageUrl);
	public FocusPanel noAboutUsContainer();
	public HTMLEventPanel getBiographyCancelButton();
	public Label getaboutUsCharacterValidation();
	
	public void disableContentAndSetOldContent(String aboutMe);
	
	public void setSettingDo(SettingDo settingDo);
	
	void setProfileData(ProfileDo profileDo);
	
	void setCourseList(List<LibraryCodeDo> libraryCode);
	
	public SettingDo getSettingDo();
	
	void setData(SettingDo settingDo);
	public void closeAllOpenedPopUp();
	public Label getSavingTextLabel();
	public Button getEditEmailButton();
	public Label getEmailTextConfirmation();
	public Label getGenderText();

	void setChildAccount(boolean isChildAccount);
	
	public Label getAccountSavingText();
	
	public Button getEditButtonAccount();
}
