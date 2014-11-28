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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * 
 * @author BLR Team
 *
 */

public interface LoginPopUpCBundle extends ClientBundle{
	
	static final LoginPopUpCBundle INSTANCE = GWT.create(LoginPopUpCBundle.class);
	
	@NotStrict
	@Source("res_loginpopup1.css")
	LoginPopUpCss getResponsiveStyle();
	
	@NotStrict
	@Source("res_loginpopup2.css")
	LoginPopUpCss getResponsive1Style();

	@NotStrict
	@Source("res_loginpopup3.css")
	LoginPopUpCss getResponsive2Style();
	
	@NotStrict
	@Source("res_loginpopup4.css")
	LoginPopUpCss getResponsive3Style();
	
	@NotStrict
	@Source("res_loginpopup5.css")
	LoginPopUpCss getResponsive4Style();
	
	@NotStrict
	@Source("res_loginpopup6.css")
	LoginPopUpCss getResponsive5Style();
	
	@NotStrict
	@Source("res_loginpopup7.css")
	LoginPopUpCss getResponsive6Style();
	
	
	public interface LoginPopUpCss extends CssResource{
		
	String LoginpopupMain();
	String LoginpopupInner();
	String LoginpopupHeader();
	String LoginpopupContent();
	String LoginPopUpgreen();
	String PopupMainV1Small();
	String LoginPopUpgreensmall();
	String subheader();
	String signInContainer();
	String gConnectButton();
	String divider();
	String dividerText();
	String logInput();
	@ClassName("form-control")
	String form_control();
	String forgotPasswordLink();
	String loginPopupbtnContainer();
	String haveAccount();
	String haveAccountContainer();
	String closeContainer();
	String closeButton();
	String whyGoogle();
	String questionHover();
	String lblDontHaveGoogleAccount();
	String processing();
	String loginPopupGlassStyle();
	String  lnkSignUpWithEmail();
	String subjectOptionSS();
	String  policyTextLine();
	String privacyLinkText();
	String paragraph();
	String popupInnerGrey();
	String contactUs();
	String forgotPasswordText();
	String  forgotPasswordDescription();
	String roleOption();
	String roleOptionImage();
	String Grades();
	String PopupMainSmall();
	String lblCollectionProgress();
	String forgotPasswordButtonContainer();
	String primary();
	String policyTextHeade();
	String PopupInner();
	@ClassName("SignUp-h2")
	String SignUp_h2();
	String courseContainer();
	String subjectOptionScience();
	String  leaveRegistrationButtonContainer();
	String otherRole();
	String PopupContent();
	@ClassName("SignUp-green-h1")
	String SignUp_green_h1();
	String  termsTextLine();
	String lastUpdated();
	String leaveRegistrationBottomContainer();
	String popupgreyFooter();
	String  forgotPasswordTextBoxContainer();
	String  termsOfUserMessageText();
	String privacyCloseButton();
	String popupgreenHeader();
	String sampleReportSliderHolder();
	String courseOption();
	String teacherRole();
	String  active();
	String studentRole();
	String popupContentLeaveRegistration();
	String popupFooter();
	String subjectOptionMath();
	String subjectOptionELA();
	String  secondary();
	String  selectGrades();
	String greyBGContainer();
	String popupInnerLeaveReg();
	String subjectOption();
	String PopupMainMedium();
	String parentRole();
	String  SliderHolderPrev();
	String title();
	String popupContentGrey();
	String leaveRegistarionFooterText();
	String selectCourses();
	String popupContentforgotPassword();
	String SliderHolderNext();
	String popupInnerforgotPassword();
	String inputGroup();
	String lblCollectionProgressDetails();
	String userInfoContainer();
	String PopupMainLarge();
	String popupContentScroll();
	String roleLabel();
	String GreenHeader();
	String termsSubTitle();
	String noOverflow();
	String  popupgreyHeader();
	String textContentDiv();
	String  disabled();
	String teacherRoleSelected();
	String studentRoleSelected();
	String parentRoleSelected();
	String otherRoleSelected();
	String forgotPasswordErrorMessage();
	String sceinceActive();
	String mathActive();
	String ssActive();
	String elaActive();
	String subj();
	@ClassName("menu-icon")
	String menu_icon();
	String activeGrade();
	String collectionSelected();
	String PopupMainVVSmall();
	String PopupMainVSmall();
	String shareSelection();
	String sharenEmbedContainer();
	String addButtonContainer();
	String actionField();
	String contentDesc();
	String dontWorrkText();
	String popupcornerBg();
	String overRideBlueButton();
	String collectionFormCancelButton();
	String whatNew();
	String whatLeft();
	String whatRight();
	String improveGooruDesc();
	String borderLeft();
	String improveGooruDescriptionx();
	String improveGooruLinkDesc();
	String improveGooruSubHeading();
	String improveGooruBlueText();
	String improveGooruBlueTextDesc();
	String collectionSel();
	String lables();
	String assignContainer();
	String addSelection();
	String emailSelection();
	String loginShareContainer();
	String formViewButtonContainer();
	@ClassName("AddTagesPopup-levelType")
	String  AddTagesPopup_levelType();
	@ClassName("AddTagesPopup-okcancel")
	String  AddTagesPopup_okcancel();
	@ClassName("AddTagesPopup-li")
	String AddTagesPopup_li();
	@ClassName("AddTagesPopup-levelnumbers")
	String AddTagesPopup_levelnumbers();
	String standardsCont();
	@ClassName("AddTagesPopup-h5")
	String AddTagesPopup_h5();
	String addTagsContent();
	String addQuestionStandard();
	@ClassName("AddTagesPopup-selected")
	String AddTagesPopup_selected();
	String emailContainer();
	String lblNoteTxt();
	String classPageEmailButtonCancel();
	String PopupMainExtraLarge();
	String standarBodyContainer();
	String scrollBar();
	String listGroup();
	String reviewsContent();
	String rHeader();
	String panelRatingLabels();
	String ratingLabel();
	String panelRatingValues();
	String bar();
	String count();
	String reviewContainer();
	String reviewContainerHeader();
	String review();
	String date();
	String ratingStars();
	String childInputGroup();
	String parentsAccount();
	String contentDescr();
	String orContainerDown();
	String childUserInfoContainer();
	String firstInputGroup();
	
	}
	@NotStrict
	@Source("Newlogin-popup.css")
	LoginPopUpCss css();

	
	
}

