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
package org.ednovo.gooru.client.util;


public class MixpanelUtil {

	//Mixpanel Init
	/*
	private final static String
	Gooru_Test =
	     "(function(c,a){window.mixpanel=a;var b,d,h,e;b=c.createElement('script');"
	    +"b.type='text/javascript';b.async=!0;b.src=('https:'===c.location.protocol?'https:':'http:')+"
	    +"'//cdn.mxpnl.com/libs/mixpanel-2.2.min.js';d=c.getElementsByTagName('script')[0];"
	    +"d.parentNode.insertBefore(b,d);a._i=[];a.init=function(b,c,f){function d(a,b){"
	    +"var c=b.split('.');2==c.length&&(a=a[c[0]],b=c[1]);a[b]=function(){a.push([b].concat("
	    +"Array.prototype.slice.call(arguments,0)))}}var g=a;'undefined'!==typeof f?g=a[f]=[]:"
	    +"f='mixpanel';g.people=g.people||[];h=['disable','track','track_pageview','track_links',"
	    +"'track_forms','register','register_once','unregister','identify','alias','name_tag','set_config',"
	    +"'people.set','people.set_once','people.increment','people.track_charge','people.append'];"
	    +"for(e=0;e<h.length;e++)d(g,h[e]);a._i.push([b,c,f])};a.__SV=1.2;})(document,window.mixpanel||[]);"
	    +"mixpanel.init('a9c35657dfd3d125f7bc3cb663482cba');mixpanel.track(document.title, {'page name' : document.title, 'url' : window.location.pathname,'referrer': document.referrer},function() { });";

	public static void trackPageInit(String pageName)
	{
		if(Document.get().getElementById("mixpanel_header")!=null) return;
		Element head = Document.get().getElementsByTagName("head").getItem(0);
		ScriptElement sce = Document.get().createScriptElement();
	    sce.setType("text/javascript");
	    sce.setId("mixpanel_header");
	    sce.setInnerText(Gooru_Test.replaceAll("<Landing_Page>", pageName));
	    head.appendChild(sce);
	}
	 */


	public static native void Arrive_Landing_Page() /*-{
		$wnd.mixpanel.track("Arrive_Landing_Page",{},function() { });
	}-*/;

	//Study
	//Click_Study_LandingPage();
	public static native void Click_Study_LandingPage() /*-{
	$wnd.mixpanel.track("Click_Study_LandingPage",{},function() { });
	}-*/;

	// Register
	public static native void Arrive_Register_popup() /*-{
		$wnd.mixpanel.track("Arrive_ Register_popup",{},function() { });
	}-*/;

	public static native void Click_Gmail_SignIn(String Location) /*-{
	$wnd.mixpanel.track("Click_Gmail_SignIn_"+Location,{},function() { });
	}-*/;

	public static native void Click_OK_AlmostDone() /*-{
	$wnd.mixpanel.track("Click_OK_Register_AlmostDone",{},function() { });
	}-*/;

	public static native void Arrive_AlmostDone_Popup() /*-{
	$wnd.mixpanel.track("Arrive_AlmostDone_Popup",{},function() { });
	}-*/;

	public static native void Click_Go_Register_popup() /*-{
	$wnd.mixpanel.track("Click_Go_Register_popup",{},function() { });
	}-*/;
	//=============================================================================

	//Classpage:
	public static native void Click_Teach_LandingPage() /*-{
	$wnd.mixpanel.track("Click_Teach_LandingPage",{},function() { });
	}-*/;

	public static native void Click_Add_NewClasspage() /*-{
	$wnd.mixpanel.track("Click_+NewClasspage",{},function() { });
	}-*/;

	public static native void Create_NewClasspage() /*-{
	$wnd.mixpanel.track("Create_NewClasspage_Success",{},function() { });
	}-*/;

	public static native void Click_Open_Teachpage() /*-{
	$wnd.mixpanel.track("Click_Open_Teachpage",{},function() { });
	}-*/;

	public static native void Click_StudentView_Teachpage() /*-{
	$wnd.mixpanel.track("Click_StudentView_Teachpage",{},function() { });
	}-*/;

	public static native void Click_StudentView_Classpage() /*-{
	$wnd.mixpanel.track("Click_StudentView_Classpage",{},function() { });
	}-*/;

	public static native void Click_Add_NewAssignment() /*-{
	$wnd.mixpanel.track("Click_+NewAssignment",{},function() { });
	}-*/;

	public static native void Click_Share_Classpage() /*-{
	$wnd.mixpanel.track("Click_Share_Classpage",{},function() { });
	}-*/;

	public static native void Click_AssignmentTab_Classpage() /*-{
	$wnd.mixpanel.track("Click_AssignmentTab_Classpage",{},function() { });
	}-*/;

	public static native void Create_Assignment_Success() /*-{
	$wnd.mixpanel.track("Create_Assignment_Success",{},function() { });
	}-*/;
	//=============================================================================

	//Search
	public static native void Perform_Search(String term,String Location) /*-{
	$wnd.mixpanel.track("Perform_Search",{'search term':term},function() { });
	}-*/;

	public static native void Click_Discover_LandingPage() /*-{
	$wnd.mixpanel.track("Click_Discover_LandingPage",{},function() { });
	}-*/;

	//SearchRootView--after Landing Page Search
	public static native void Show_Collection_Search_Results() /*-{
	$wnd.mixpanel.track("Show_Collection_Search_Results",{},function() { });
	}-*/;

	public static native void Show_Resource_Search_Results() /*-{
	$wnd.mixpanel.track("Show_Resource_Search_Results",{},function() { });
	}-*/;

	//Assign
	public static native void Click_Assign_CollectionEdit() /*-{
    $wnd.mixpanel.track("Click_Assign_CollectionEdit",{},function() { });
    }-*/;
	public static native void Click_Assign_Click() /*-{
    $wnd.mixpanel.track("Click_Assign_Click",{},function() { });
    $wnd.mixpanel.track("Click_Assign_TotalCount",{},function() { });
	}-*/;

	//Collection
	public static native void Click_Share_CollectionEdit() /*-{
    $wnd.mixpanel.track("Click_Share_CollectionEdit",{},function() { });
    $wnd.mixpanel.track("Click_Share_TotalCount",{},function() { });
	}-*/;

	public static native void Click_Info_CollectionEdit() /*-{
    $wnd.mixpanel.track("Click_Info_CollectionEdit",{},function() { });
	}-*/;

	public static native void Click_Username()/*-{
    $wnd.mixpanel.track("Click_Username",{},function() { });
	}-*/;

	public static native void Click_Resource_Username()/*-{
    $wnd.mixpanel.track("Click_Resource_Username",{},function() { });
	}-*/;

	//Click_Resource_CollectionEdit
	public static native void Click_Resource_CollectionEdit() /*-{
    $wnd.mixpanel.track("Click_Resource_CollectionEdit",{},function() { });
	}-*/;

	public static native void Click_Organize_LandingPage() /*-{
	$wnd.mixpanel.track("Click_Organize_LandingPage",{},function() { });
	}-*/;

	public static native void Edit_This_Collection() /*-{
	$wnd.mixpanel.track("Edit_This_Collection",{},function() { });
	}-*/;

	public static native void Expand_CollectionPanel() /*-{
	$wnd.mixpanel.track("Expand_CollectionPanel",{},function() { });
	}-*/;

	public static native void Preview_Collection_From_Search(String Location) /*-{
	$wnd.mixpanel.track("Preview_Collection_From_Search",{},function() { });
	}-*/;

	public static native void Preview_Collection_From_CollectionEdit() /*-{
	$wnd.mixpanel.track("Preview_Collection_From_CollectionEdit",{},function() { });
	}-*/;

	public static native void Click_Add_NewCollection() /*-{
	$wnd.mixpanel.track("Click_+NewCollection",{},function() { });
	}-*/;

	public static native void Create_EmptyCollection() /*-{
	$wnd.mixpanel.track("Create_EmptyCollection_Success",{},function() { });
	}-*/;

	public static native void Drag_Collection_FromSearchResultToFolder() /*-{
	$wnd.mixpanel.track("Drag_Collection_FromSearchResultToFolder",{},function() { });
	}-*/;
	//

	//Resource
	public static native void Click_Edit_Narration_Update() /*-{
	$wnd.mixpanel.track("Click_Edit_Narration_Update",{},function() { });
	}-*/;

	public static native void Click_Edit_Narration() /*-{
	$wnd.mixpanel.track("Click_Edit_Narration",{},function() { });
	}-*/;

	public static native void Preview_Resource_From_Search(String Location) /*-{
	$wnd.mixpanel.track("Preview_Resource_From_Search",{},function() { });
	}-*/;

	public static native void Click_Add_NewResource() /*-{
	$wnd.mixpanel.track("Click_+NewResource",{},function() { });
	}-*/;

	public static native void Create_NewResource() /*-{
	$wnd.mixpanel.track("Create_NewResource_Success",{},function() { });
	}-*/;

	public static native void Drag_Resource_FromSearchResultToCollection() /*-{
	$wnd.mixpanel.track("Drag_Resource_FromSearchResultToCollection",{},function() { });
	}-*/;

	public static native void Drag_Resource_FromSearchResultToNewCollection() /*-{
	$wnd.mixpanel.track("Drag_Resource_FromSearchResultToNewCollection",{},function() { });
	}-*/;
	//=========================================================================

	//Featured Collection
	public static native void Click_FeaturedCollection() /*-{
	$wnd.mixpanel.track("Click_FeaturedCollection",{},function() { });
	}-*/;
	//=========================================================================

	//Share after Search
	public static native void Click_Share() /*-{
    $wnd.mixpanel.track("Click_Share_SearchResult",{},function() { });
    $wnd.mixpanel.track("Click_Share_TotalCount",{},function() { });
	}-*/;

	public static native void Click_moreInfo() /*-{
    $wnd.mixpanel.track("Click_moreInfo_SearchResult",{},function() { });
	}-*/;

	//==========================================================================

	//	Resource-->Register
	public static native void Arrive_ResourceRegisterPopup() /*-{
	$wnd.mixpanel.track("Arrive_ResourceRegisterPopup",{'referrer': document.referrer},function() { });
	}-*/;

	public static native void Click_SignMeUp_ResourceRegisterPopup() /*-{
	$wnd.mixpanel.track("Click_SignMeUp_ResourceRegisterPopup",{},function() { });
	}-*/;

	public static native void Click_HaveAnAccount_ResourceRegisterPopup() /*-{
	$wnd.mixpanel.track("Click_HaveAnAccount_ResourceRegisterPopup",{},function() { });
	}-*/;
	//==========================================================


	//Settings
	public static native void Loading_SettingsPage()/*-{
    $wnd.mixpanel.track("Loading_SettingsPage",{},function() { });
	}-*/;
	public static native void Click_Profile_On()/*-{
    $wnd.mixpanel.track("Click_Profile_On",{},function() { });
	}-*/;
	public static native void Click_Profile_Off()/*-{
    $wnd.mixpanel.track("Click_Profile_Off",{},function() { });
	}-*/;
	public static native void Click_On_Save()/*-{
    $wnd.mixpanel.track("Click_On_Save",{},function() { });
	}-*/;
	public static native void Click_On_SeemyPage()/*-{
    $wnd.mixpanel.track("Click_On_SeemyPage",{},function() { });
	}-*/;
	//=======================================================
	//Regular User Profile Page
	public static native void Click_On_Collection()/*-{
    $wnd.mixpanel.track("Click_On_Collection",{},function() { });
	}-*/;
	public static native void Preview_Collection_From_Profile(String Location) /*-{
	$wnd.mixpanel.track("Preview_Collection_From_Profile",{},function() { });
	}-*/;
	public static native void Preview_Resource_From_Profile(String Location)/*-{
    $wnd.mixpanel.track("Preview_Resource_From_Profile",{},function() { });
	}-*/;
	public static native void Click_On_ProfileShare()/*-{
    $wnd.mixpanel.track("Click_On_ProfileShare",{},function() { });
	}-*/;

	//=======================================================
	//Special User Profile Page
	public static native void Click_On_Folder()/*-{
    $wnd.mixpanel.track("Click_On_Folder",{},function() { });
	}-*/;
	public static native void Click_On_Open()/*-{
    $wnd.mixpanel.track("Click_On_Open",{},function() { });
	}-*/;

	//////// Mix Panel events for release-5.6 //////////////////
	//Collection Search Results
	public static native void Drag_Collection()/*-{
    $wnd.mixpanel.track("Drag_Collection",{},function() { });
	}-*/;
	public static native void Drag_Action()/*-{
    $wnd.mixpanel.track("Drag_Action",{},function() { });
	}-*/;
	//Resource Search Results
	public static native void Drag_Resource()/*-{
	$wnd.mixpanel.track("Drag_Resource",{},function() { });
	}-*/;
	public static native void Drag_ResourceAction()/*-{
	$wnd.mixpanel.track("Drag_ResourceAction",{},function() { });
	 }-*/;

	// Landing Page
	public static native void Loading_ToolTip()/*-{
	$wnd.mixpanel.track("Loading_ToolTip",{},function() { });
	}-*/;
	public static native void Click_OnToolTipSearch()/*-{
   	$wnd.mixpanel.track("Click_OnToolTipSearch",{},function() { });
   	}-*/;
	//First time search results
	public static native void Loading_SearchPopUp()/*-{
   	$wnd.mixpanel.track("Loading_SearchPopUp",{},function() { });
   	}-*/;
	public static native void Click_OnResources()/*-{
   	$wnd.mixpanel.track("Click_OnResources",{},function() { });
   	}-*/;
	public static native void Click_OnCollections()/*-{
   	$wnd.mixpanel.track("Click_OnCollections",{},function() { });
   	}-*/;
	public static native void ClickWelcomeSearchPopUpOutsideFromSearchResults()/*-{
   	$wnd.mixpanel.track("ClickWelcomeSearchPopUpOutsideFromSearchResults",{},function() { });
   	}-*/;

	//First time open a collection player
	public static native void Click_OK()/*-{
   	$wnd.mixpanel.track("Click_OK",{},function() { });
   	}-*/;
	public static native void Click_OutsidePopUp()/*-{
   	$wnd.mixpanel.track("Click_OutsidePopUp",{},function() { });
   	}-*/;
	//Registration popups

	public static native void ClickSignupDraggingResouerceFromSearchResults()/*-{
   	$wnd.mixpanel.track("ClickSignupDraggingResouerceFromSearchResults",{},function() { });
   	}-*/;
	public static native void ClickSignUpToSavingCollection()/*-{
   	$wnd.mixpanel.track("ClickSignUpToSavingCollection",{},function() { });
   	}-*/;
	public static native void ClickSignUpFromCollectionPlayer()/*-{
   	$wnd.mixpanel.track("ClickSignUpFromCollectionPlayer",{},function() { });
   	}-*/;
	public static native void ClickSignUpFromResourcePlayer()/*-{
   	$wnd.mixpanel.track("ClickSignUpFromResourcePlayer",{},function() { });
   	}-*/;

	// Search Results From TakeTourBox
	public static native void Click_OnSignMeUp()/*-{
   	$wnd.mixpanel.track("Click_OnSignMeUp",{},function() {});
   	}-*/;
	public static native void Click_OnTakeaTour()/*-{
   	$wnd.mixpanel.track("Click_OnTakeaTour",{},function() { });
   	}-*/;
	public static native void Click_OnClose()/*-{
   	$wnd.mixpanel.track("Click_OnClose",{},function() { });
   	}-*/;

	//Collection Edit - Add Resource
	public static native void Click_On_AddResource()/*-{
   	$wnd.mixpanel.track("Click_On_AddResource",{},function() { });
   	}-*/;
	public static native void Click_On_AddQuestion()/*-{
   	$wnd.mixpanel.track("Click_On_AddQuestion",{},function() { });
   	}-*/;
	public static native void Click_On_ViewAllResults()/*-{
   	$wnd.mixpanel.track("Click_On_ViewAllResults",{},function() { });
   	}-*/;
	public static native void Perform_Search()/*-{
   	$wnd.mixpanel.track("Perform_Search",{},function() { });
   	}-*/;
	public static native void AddResourceByUrl()/*-{
   	$wnd.mixpanel.track("AddResourceByUrl",{},function() { });
   	}-*/;
	public static native void AddQuestion()/*-{
   	$wnd.mixpanel.track("AddQuestion",{},function() { });
   	}-*/;
	public static native void Click_On_AssignTab()/*-{
   	$wnd.mixpanel.track("Click_On_AssignTab",{},function() { });
   	}-*/;
	public static native void Click_On_Assign()/*-{
   	$wnd.mixpanel.track("Click_On_Assign",{},function() { });
   	}-*/;

	//On My ProfilePage
	public static native void Click_On_UserName()/*-{
   	$wnd.mixpanel.track("Click_On_UserName",{},function() { });
   	}-*/;
	public static native void ClickOnEditMyPageFromProfilePage()/*-{
   	$wnd.mixpanel.track("ClickOnEditMyPageFromProfilePage",{},function() { });
   	}-*/;
	public static native void Click_On_FaceBook()/*-{
   	$wnd.mixpanel.track("Click_On_FaceBook",{},function() { });
   	}-*/;
	public static native void Click_On_Twitter()/*-{
   	$wnd.mixpanel.track("Click_On_Twitter",{},function() { });
   	}-*/;
	public static native void Click_On_Email()/*-{
   	$wnd.mixpanel.track("Click_On_Email",{},function() { });
   	}-*/;
	///In Edit Mode
	public static native void Click_On_EditMyImage()/*-{
   	$wnd.mixpanel.track("Click_On_EditMyImage",{},function() { });
   	}-*/;
	public static native void EditCourseOrGradeFromProfilePage()/*-{
   	$wnd.mixpanel.track("EditCourseOrGradeFromProfilePage",{},function() { });
   	}-*/;
	public static native void EditDescriptionFromProfilePage()/*-{
   	$wnd.mixpanel.track("EditDescriptionFromProfilePage",{},function() { });
   	}-*/;
	public static native void Click_On()/*-{
   	$wnd.mixpanel.track("Click_On",{},function() { });
   	}-*/;
	public static native void Click_Off()/*-{
   	$wnd.mixpanel.track("Click_Off",{},function() { });
   	}-*/;
	//Header
	public static native void Click_On_Support()/*-{
   	$wnd.mixpanel.track("Click_On_Support",{},function() { });
   	}-*/;
	public static native void Click_On_FeedBack()/*-{
   	$wnd.mixpanel.track("Click_On_FeedBack",{},function() { });
   	}-*/;
	public static native void Click_On_GooruGuide()/*-{
   	$wnd.mixpanel.track("Click_On_GooruGuide",{},function() { });
   	}-*/;
	public static native void Click_On_ClassicGooru()/*-{
   	$wnd.mixpanel.track("Click_On_ClassicGooru",{},function() { });
   	}-*/;
	public static native void Click_On_Help()/*-{
   	$wnd.mixpanel.track("Click_On_Help",{},function() { });
   	}-*/;
	public static native void Perform_Search_FromTeach()/*-{
   	$wnd.mixpanel.track("Perform_Search_FromTeach",{},function() { });
   	}-*/;
	public static native void Perform_Search_FromOrganize()/*-{
   	$wnd.mixpanel.track("Perform_Search_FromOrganize",{},function() { });
   	}-*/;

	////Mix Panel events for release-5.7////
	//Resource Search Results
	public static native void Click_Facebook_FromResource()/*-{
   	$wnd.mixpanel.track("Click_Facebook_FromResource",{},function() { });
   	}-*/;
	public static native void Click_Twitter_FromResource()/*-{
   	$wnd.mixpanel.track("Click_Twitter_FromResource",{},function() { });
   	}-*/;
	public static native void Click_Email_FromResource()/*-{
   	$wnd.mixpanel.track("Click_Email_FromResource",{},function() { });
   	}-*/;
	//Collection Search Results
	public static native void Click_Facebook_FromCollection()/*-{
   	$wnd.mixpanel.track("Click_Facebook_FromCollection",{},function() { });
   	}-*/;
	public static native void Click_Twitter_FromCollection()/*-{
   	$wnd.mixpanel.track("Click_Twitter_FromCollection",{},function() { });
   	}-*/;
	public static native void Click_Email_FromCollection()/*-{
   	$wnd.mixpanel.track("Click_Email_FromCollection",{},function() { });
   	}-*/;

	// Collection Edit - Image
	public static native void ClickOnEditImageFromCollectionEdit()/*-{
   	$wnd.mixpanel.track("ClickOnEditImageFromCollectionEdit",{},function() { });
   	}-*/;
	public static native void AddImageByUrlOntheWeb()/*-{
   	$wnd.mixpanel.track("AddImageByUrlOntheWeb",{},function() { });
   	}-*/;
	public static native void AddImageFromMyComputer()/*-{
   	$wnd.mixpanel.track("AddImageFromMyComputer",{},function() { });
   	}-*/;
	//Collectionplayer 
	public static native void ClickFacebookFromShareInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickFacebookFromShareInCollectionplayer",{},function() { });
   	}-*/;
	public static native void ClickFacebookFromSummaryPageInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickFacebookFromSummaryPageInCollectionplayer",{},function() { });
   	}-*/;
	public static native void ClickEmailFromShareInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickEmailFromShareInCollectionplayer",{},function() { });
   	}-*/;
	public static native void ClickEmailFromSummaryPageInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickEmailFromSummaryPageInCollectionplayer",{},function() { });
   	}-*/;
	public static native void ClickTwitterFromShareInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickTwitterFromShareInCollectionplayer",{},function() { });
   	}-*/;
	public static native void ClickTwitterFromSummaryPageInCollectionplayer()/*-{
   	$wnd.mixpanel.track("ClickTwitterFromSummaryPageInCollectionplayer",{},function() { });
   	}-*/;

	// Classpage Openning Gooru Guide
	public static native void Click_GooruGuide_From_Classpage() /*-{
    $wnd.mixpanel.track("Click_GooruGuide_From_Classpage",{},function() { });
    $wnd.mixpanel.track("Click_GooruGuide_From_Classpage_TotalCount",{},function() { });
	}-*/;
	//LandingPage  SearchSection
	public static native void SelectGradeFromSearchFilter()/*-{
   	$wnd.mixpanel.track("SelectGradeFromSearchFilter",{},function() { });
   	}-*/;
	public static native void SelectStandardFromSearchFilter()/*-{
   	$wnd.mixpanel.track("SelectStandardFromSearchFilter",{},function() { });
   	}-*/;
	public static native void ClickOnTeachersPicks()/*-{
   	$wnd.mixpanel.track("ClickOnTeachersPicks",{},function() { });
   	}-*/;
	public static native void ClickOnHowToUseGooru()/*-{
   	$wnd.mixpanel.track("ClickOnHowToUseGooru",{},function() { });
   	}-*/;
	public static native void ClickOnGooruInTheClassRoom()/*-{
   	$wnd.mixpanel.track("ClickOnGooruInTheClassRoom",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromLandingpage()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromLandingPage",{},function() { });
   	}-*/;

	//Teacher's Picks
	public static native void ClickOnFeatured()/*-{
   	$wnd.mixpanel.track("ClickOnFeatured",{},function() { });
   	}-*/;
	public static native void ClickOnMathTab()/*-{
   	$wnd.mixpanel.track("ClickOnMathTab",{},function() { });
   	}-*/;
	public static native void ClickOnScienceTab()/*-{
   	$wnd.mixpanel.track("ClickOnScienceTab",{},function() { });
   	}-*/;
	public static native void ClickOnSocialSciencesTab()/*-{
   	$wnd.mixpanel.track("ClickOnSocialSciencesTab",{},function() { });
   	}-*/;
	public static native void ClickOnLanguageArtsTab()/*-{
   	$wnd.mixpanel.track("ClickOnLanguageArtsTab",{},function() { });
   	}-*/;
	public static native void ClickTheCollectionsFromLandingPage()/*-{
   	$wnd.mixpanel.track("ClickTheCollectionsFromLandingPage",{},function() { });
   	}-*/;
	public static native void ClickOnTheUsernameFromLandingPage()/*-{
   	$wnd.mixpanel.track("ClickOnTheUsernameFromLandingPage",{},function() { });
   	}-*/;

	//What Gooru Provides
	public static native void ClickOnVideo()/*-{
   	$wnd.mixpanel.track("ClickOnVideo",{},function() { });
   	}-*/;
	public static native void ClickOnAboutGooruLearningOrg()/*-{
   	$wnd.mixpanel.track("ClickOnAboutGooruLearningOrg",{},function() { });
   	}-*/;

	//Gooru in the Classroom
	public static native void ClickOnBlendedLearning()/*-{
   	$wnd.mixpanel.track("ClickOnBlendedLearning",{},function() { });
   	}-*/;
	public static native void ClickOnBlendedLearningCollection()/*-{
   	$wnd.mixpanel.track("ClickOnBlendedLearningCollection",{},function() { });
   	}-*/;
	public static native void ClickOnFlippedClassRoom()/*-{
   	$wnd.mixpanel.track("ClickOnFlippedClassRoom",{},function() { });
   	}-*/;
	public static native void ClickOnFlippedClassRoomCollection()/*-{
   	$wnd.mixpanel.track("ClickOnFlippedClassRoomCollection",{},function() { });
   	}-*/;
	public static native void ClickOnAssesments()/*-{
   	$wnd.mixpanel.track("ClickOnAssesments",{},function() { });
   	}-*/;
	public static native void ClickOnAssesmentsCollection()/*-{
   	$wnd.mixpanel.track("ClickOnAssesmentsCollection",{},function() { });
   	}-*/;
	public static native void ClickOnProjectBasedLearning()/*-{
   	$wnd.mixpanel.track("ClickOnProjectBasedLearning",{},function() { });
   	}-*/;
	public static native void ClickOnProjectBasedLearningCollection()/*-{
   	$wnd.mixpanel.track("ClickOnProjectBasedLearningCollection",{},function() { });
   	}-*/;
	public static native void ClickOnEnrichedInstruction()/*-{
   	$wnd.mixpanel.track("ClickOnEnrichedInstruction",{},function() { });
   	}-*/;
	public static native void ClickOnEnrichedInstructionCollection()/*-{
   	$wnd.mixpanel.track("ClickOnEnrichedInstructionCollection",{},function() { });
   	}-*/;



	//Get Started
	public static native void ClickOnSearch()/*-{
   	$wnd.mixpanel.track("ClickOnSearch",{},function() { });
   	}-*/;
	public static native void ClickOnCreate()/*-{
   	$wnd.mixpanel.track("ClickOnCreate",{},function() { });
   	}-*/;
	public static native void ClickOnSignUp()/*-{
   	$wnd.mixpanel.track("ClickOnSignUp",{},function() { });
   	}-*/;

	//ClassPages
	public static native void ClickOnEditImage()/*-{
   	$wnd.mixpanel.track("ClickOnEditImage",{},function() { });
   	}-*/;
	public static native void SuccessfullyAddtheImageFromClasspage()/*-{
   	$wnd.mixpanel.track("SuccessfullyAddtheImageFromClasspage",{},function() { });
   	}-*/;
	public static native void ClickOnNewClassPage()/*-{
   	$wnd.mixpanel.track("ClickOnNewClassPage",{},function() { });
   	}-*/;

	//Header
	public static native void ClickOnStudyNow()/*-{
   	$wnd.mixpanel.track("ClickOnStudyNow",{},function() { });
   	}-*/;

	//GooruGuide
	public static native void ClickOnGooruGuideFromLandingPage()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromLandingPage",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromCollectionSearch()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromCollectionSearch",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromResourceSearch()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromResourceSearch",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromOrganize()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromOrganize",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromTeachTab()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromTeachTab",{},function() { });
   	}-*/;
	public static native void ClickOnGooruGuideFromStudyTab()/*-{
   	$wnd.mixpanel.track("ClickOnGooruGuideFromStudyTab",{},function() { });
   	}-*/;
	//======================================================================
	//New Question Pop-up
	public static native void ClickAddOnMultipleChoiceTabFromCollectionEdit()/*-{
   	$wnd.mixpanel.track("Question_Create_MC",{},function() { });
   	}-*/;
	public static native void ClickAddOnTrueOrFalseTabFromCollectionEdit()/*-{
   	$wnd.mixpanel.track("Question_Create_TF",{},function() { });
   	}-*/;
	public static native void ClickAddOnOpenEndedTabFromCollectionEdit()/*-{
   	$wnd.mixpanel.track("Question_Create_OE",{},function() { });
   	}-*/;
	//======================================================================
	//[Collection Edit] edit the buttons
	public static native void Organize_Click_Preview()/*-{
   	$wnd.mixpanel.track("Organize_Click_Preview",{},function() { });
   	}-*/;
	public static native void Organize_Click_Collection_Copy()/*-{
   	$wnd.mixpanel.track("Organize_Click_Collection_Copy",{},function() { });
   	}-*/;
	public static native void Organize_Click_Collection_Delete()/*-{
   	$wnd.mixpanel.track("Organize_Click_Collection_Delete",{},function() { });
   	}-*/;
	//[Upload-Create] As a user, I can upload a file as a resource to my collection
	public static native void Add_Resource_Click_Computer()/*-{
   	$wnd.mixpanel.track("Add_Resource_Click_Computer",{},function() { });
   	}-*/;
	public static native void Add_Resource_Computer_Success()/*-{
   	$wnd.mixpanel.track("Add_Resource_Computer_Success",{},function() { });
   	}-*/;
	//[Upload-Edit] As a user, I can edit a file i uploaded (if it’s private)
	public static native void Resource_Action_Edit_Info()/*-{
   	$wnd.mixpanel.track("Resource_Action_Edit_Info",{},function() { });
   	}-*/;
	public static native void Resource_Edit_Info_Success()/*-{
   	$wnd.mixpanel.track("Resource_Edit_Info_Success",{},function() { });
   	}-*/;
	//[Visibility] Users need to get confirmation pop-ups when they change their visibility status
	public static native void Organize_Visibility_Public ()/*-{
   	$wnd.mixpanel.track("Organize_Visibility_Public",{},function() { });
   	}-*/;
	public static native void Organize_Visibility_Private()/*-{
   	$wnd.mixpanel.track("Organize_Visibility_Private",{},function() { });
   	}-*/;
	public static native void Organize_Visibility_Shareable()/*-{
   	$wnd.mixpanel.track("Organize_Visibility_Shareable",{},function() { });
   	}-*/;
	//[Share] Direct Link for accessing Collections (other than bit.ly link)
	public static native void Share_direct_collection_edit()/*-{
   	$wnd.mixpanel.track("Share_direct_collection_edit",{},function() { });
   	}-*/;
	public static native void Share_direct_search()/*-{
   	$wnd.mixpanel.track("Share_direct_search",{},function() { });
   	}-*/;
	//[Change Email] User can change email from settings
	public static native void Settings_email_change_saved()/*-{
   	$wnd.mixpanel.track("Settings_email_change_saved",{},function() { });
   	}-*/;
	public static native void Settings_educational_info_saved()/*-{
   	$wnd.mixpanel.track("Settings_educational_info_saved",{},function() { });
   	}-*/;
	//[Multiple Answer] Add another question type called “Multiple Answer”
	public static native void successfullyaddaMAquestiontype()/*-{
   	$wnd.mixpanel.track("Question_Create_MA",{},function() { });
   	}-*/;
	//[No Results] Need to add suggested content
	public static native void Search_No_Results()/*-{
   	$wnd.mixpanel.track("Search_No_Results",{},function() { });
   	}-*/;
	public static native void Search_No_Results_Click_Resource()/*-{
   	$wnd.mixpanel.track("Search_No_Results_Click_Resource",{},function() { });
   	}-*/;
	public static native void Search_No_Results_Click_Collection()/*-{
   	$wnd.mixpanel.track("Search_No_Results_Click_Collection",{},function() { });
   	}-*/;
	//[Registration] Overview of registration redesign
	//Accessing the sign up pop-up
	public static native void ClickSignUpButtonFromTheHeader()/*-{
   	$wnd.mixpanel.track("ClickSignUpButtonFromTheHeader",{},function() { });
   	}-*/;
	//Gmail Connect
	public static native void ClickSignInWithGoogleButtonFromSignUpPopUP()/*-{
   	$wnd.mixpanel.track("ClickSignInWithGoogleButtonFromSignUpPopUP",{},function() { });
   	}-*/;
	public static native void SelectTeacherRadioButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("SelectTeacherRadioButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void SelectStudentRadioButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("SelectStudentRadioButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void SelectParentRadioButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("SelectParentRadioButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void SelectOtherRadioButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("SelectOtherRadioButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSubmitButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickSubmitButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSearchFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickSearchFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickCreateFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickCreateFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickTeachFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickTeachFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickCloseButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickCloseButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSignUpPopUpOutside()/*-{
   	$wnd.mixpanel.track("ClickSignUpPopUpOutside",{},function() { });
   	}-*/;
	//SSO sign up
	public static native void SeeTheSSOSignUpPopUp()/*-{
   	$wnd.mixpanel.track("SeeTheSSOSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSearchFromSSOSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickSearchFromSSOSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickCreateFromSSOSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickCreateFromSSOSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickTeachFromSSOSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickTeachFromSSOSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickCloseButtonFromSSOSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickCloseButtonFromSSOSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSSOSignUpPopUpOutside()/*-{
   	$wnd.mixpanel.track("ClickSSOSignUpPopUpOutside",{},function() { });
   	}-*/;
	//regular sign up
	public static native void ClickSignUpWithYourEmailAddress()/*-{
   	$wnd.mixpanel.track("ClickSignUpWithYourEmailAddress",{},function() { });
   	}-*/;
	public static native void SelectTeacherRadioButton()/*-{
   	$wnd.mixpanel.track("SelectTeacherRadioButton",{},function() { });
   	}-*/;
	public static native void SelectStudentRadioButton()/*-{
   	$wnd.mixpanel.track("SelectStudentRadioButton",{},function() { });
   	}-*/;
	public static native void SelectParentRadioButton()/*-{
   	$wnd.mixpanel.track("SelectParentRadioButton",{},function() { });
   	}-*/;
	public static native void SelectOtherRadioButton()/*-{
   	$wnd.mixpanel.track("SelectOtherRadioButton",{},function() { });
   	}-*/;
	public static native void ClickSignUpButton()/*-{
   	$wnd.mixpanel.track("ClickSignUpButton",{},function() { });
   	}-*/;
	public static native void ClickSkipButton()/*-{
   	$wnd.mixpanel.track("ClickSkipButton",{},function() { });
   	}-*/;
	public static native void ClickSubmitButton()/*-{
   	$wnd.mixpanel.track("ClickSubmitButton",{},function() { });
   	}-*/;
	public static native void ClickSearchButton()/*-{
   	$wnd.mixpanel.track("ClickSearchButton",{},function() { });
   	}-*/;
	public static native void ClickCreateButton()/*-{
   	$wnd.mixpanel.track("ClickCreateButton",{},function() { });
   	}-*/;
	public static native void ClickTeachButton()/*-{
   	$wnd.mixpanel.track("ClickTeachButton",{},function() { });
   	}-*/;
	public static native void ClickCloseButton()/*-{
   	$wnd.mixpanel.track("ClickCloseButton",{},function() { });
   	}-*/;
	public static native void ClickSignUppopupOutside()/*-{
   	$wnd.mixpanel.track("ClickSignUppopupOutside",{},function() { });
   	}-*/;
	public static native void ClickHereToRegisterAsaParentFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickHereToRegisterAsaParentFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickContinueButtonFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickContinueButtonFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSubmitButtonAfterEnterPasswordFromSignUpPopUp()/*-{
   	$wnd.mixpanel.track("ClickSubmitButtonAfterEnterPasswordFromSignUpPopUp",{},function() { });
   	}-*/;
	public static native void ClickSkipButtonFromGradeorCoursePage()/*-{
   	$wnd.mixpanel.track("ClickSkipButtonFromGradeorCoursePage",{},function() { });
   	}-*/;
	public static native void ClickSubmitButtonFromGradeorCoursePage()/*-{
   	$wnd.mixpanel.track("ClickSubmitButtonFromGradeorCoursePage",{},function() { });
   	}-*/;
	public static native void ClickOnSearchButton()/*-{
   	$wnd.mixpanel.track("ClickOnSearchButton",{},function() { });
   	}-*/;
	public static native void ClickOnCreateButton()/*-{
   	$wnd.mixpanel.track("ClickOnCreateButton",{},function() { });
   	}-*/;
	public static native void ClickOnTeachButton()/*-{
   	$wnd.mixpanel.track("ClickOnTeachButton",{},function() { });
   	}-*/;
	public static native void ClickOnCloseButton()/*-{
   	$wnd.mixpanel.track("ClickOnCloseButton",{},function() { });
   	}-*/;
	public static native void ClickOutSidePopUp()/*-{
   	$wnd.mixpanel.track("ClickOutSidePopUp",{},function() { });
   	}-*/;
	public static native void ClickCreateAnAccountForYourChild()/*-{
   	$wnd.mixpanel.track("ClickCreateAnAccountForYourChild",{},function() { });
   	}-*/;
	//[Organize] add start/stop time/page outside of narration + edit dropdown
	public static native void Organize_Click_Edit_Narration()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Narration",{},function() { });
   	}-*/;
	public static native void Organize_Click_Edit_Narration_Update()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Narration_Update",{},function() { });
   	}-*/;
	public static native void Organize_Click_Edit_Start_Time()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Start_Time",{},function() { });
   	}-*/;
	public static native void Organize_Click_Edit_Start_Time_Update()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Start_Time_Update",{},function() { });
   	}-*/;
	public static native void Organize_Click_Edit_Start_Page()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Start_Page",{},function() { });
   	}-*/;
	public static native void Organize_Click_Edit_Start_Page_Update()/*-{
   	$wnd.mixpanel.track("Organize_Click_Edit_Start_Page_Update",{},function() { });
   	}-*/;
	//[Registration-MP] Flow for Milepost Users
	public static native void Registration_Milepost_arrive()/*-{
   	$wnd.mixpanel.track("Registration_Milepost_arrive",{},function() { });
   	}-*/;
	public static native void Registration_Milepost_click_submit()/*-{
   	$wnd.mixpanel.track("Registration_Milepost_click_submit",{},function() { });
   	}-*/;
	//[Registration-SSO] Flow for SSO Users
	public static native void Registration_SSO_arrive()/*-{
   	$wnd.mixpanel.track("Registration_SSO_arrive",{},function() { });
   	}-*/;
	public static native void Registration_SSO_click_submit()/*-{
   	$wnd.mixpanel.track("Registration_SSO_click_submit",{},function() { });
   	}-*/;
	//[Registration-Gmail] Flow for Gmail connect users
	public static native void Registration_Click_Google()/*-{
   	$wnd.mixpanel.track("Registration_SSO_arrive",{},function() { });
   	}-*/;
	public static native void Registration_Click_Google_Submit()/*-{
   	$wnd.mixpanel.track("Registration_Click_Google_Submit",{},function() { });
   	}-*/;
	//[Registration-regular] Flow for Regular users
	public static native void Registration_Click_Signup(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Google_Submit"+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_from_Login(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_from_Login"+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_Landing(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Landing"+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_Signup_link_Email(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Signup_link_Email"+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_Signup_Email_success(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Signup_Email_success"+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_Signup_Email_Interest_Skip(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Signup_Email_Interest_Skip "+Location,{},function() { });
   	}-*/;
	public static native void Registration_Click_Signup_Email_Interest_Submit(String Location)/*-{
   	$wnd.mixpanel.track("Registration_Click_Signup_Email_Interest_Submit"+Location,{},function() { });
   	}-*/;
	//Registration-Under13] Flow for Users under 13 with parent account
	public static native void Registration_arrive_under13()/*-{
   	$wnd.mixpanel.track("Registration_arrive_under13",{},function() { });
   	}-*/;
	public static native void Registration_under13_parent_success()/*-{
   	$wnd.mixpanel.track("Registration_under13_parent_success",{},function() { });
   	}-*/;
	//[Registration-Under13] Flow for Users under 13 without parent account - via email
	public static native void Registration_under13_parent_creates_email_account()/*-{
   	$wnd.mixpanel.track("Registration_under13_parent_creates_email_account",{},function() { });
   	}-*/;
	//[Registration-Under13] Flow for Users under 13 without parent account - via gmail
	public static native void Registration_under13_parent_creates_google_account()/*-{
   	$wnd.mixpanel.track("Registration_under13_parent_creates_google_account",{},function() { });
   	}-*/;
	//[Registration-Turns13] Flow for Users who turn 13
	public static native void Registration_turns13()/*-{
   	$wnd.mixpanel.track("Registration_turns13",{},function() { });
   	}-*/;
	public static native void Registration_turns13_submit_email()/*-{
   	$wnd.mixpanel.track("Registration_turns13_submit_email",{},function() { });
   	}-*/;
	public static native void Registration_turns13_submit_profile()/*-{
   	$wnd.mixpanel.track("Registration_turns13_submit_profile",{},function() { });
   	}-*/;
	//[Registration - misc pop-ups] Misc pop-ups during registration
	public static native void Registration_login()/*-{
   	$wnd.mixpanel.track("Registration_login",{},function() { });
   	}-*/;
	public static native void Registration_login_success()/*-{
   	$wnd.mixpanel.track("Registration_login_success",{},function() { });
   	}-*/;
	//[Rich Text] make rich text small button
	public static native void Rich_Text_Click()/*-{
   	$wnd.mixpanel.track("Rich_Text_Click",{},function() { });
   	}-*/;
	public static native void Rich_Text_Added()/*-{
   	$wnd.mixpanel.track("Rich_Text_Added",{},function() { });
   	}-*/;
	//
	public static native void Open_ResourceRigisterPopUp_After_7Times_Viewed(String Location)/*-{
   	$wnd.mixpanel.track("Open_ResourceRigisterPopUp_After_7Times_Viewed"+Location,{},function() { });
   	}-*/;
	//For marketing popup
	public static native void New_in_Gooru_x()/*-{
   	$wnd.mixpanel.track("New_in_Gooru_x",{},function() { });
   	}-*/;
	public static native void New_in_Gooru_FIB_link()/*-{
   	$wnd.mixpanel.track("New_in_Gooru_FIB_link",{},function() { });
   	}-*/;
	public static native void New_in_Gooru_MOS_link()/*-{
   	$wnd.mixpanel.track("New_in_Gooru_MOS_link",{},function() { });
   	}-*/;

	public static native void New_in_Gooru_5_10_Views()/*-{
   	$wnd.mixpanel.track("New_in_Gooru_5.10_Views",{},function() { });
   	}-*/;

	/* MOS*/
	public static native void MOS_Filter(String type)/*-{
   	$wnd.mixpanel.track("MOS_Filter_"+type,{},function() { });
   	}-*/;

	public static native void MOS_New_Collection_Checkbox(String type)/*-{
   	$wnd.mixpanel.track("MOS_New_Collection_Checkbox_"+type,{},function() { });
   	}-*/;

	public static native void MOS_New_Collection_Player_Checkbox(String type)/*-{
   	$wnd.mixpanel.track("MOS_New_Collection_Player_Checkbox_"+type,{},function() { });
   	}-*/;

	public static native void MOS_Info_Checkbox(String type)/*-{
   	$wnd.mixpanel.track("MOS_Info_Checkbox_"+type,{},function() { });
   	}-*/;

	public static native void Landing_Page_video()/*-{
   	$wnd.mixpanel.track("Landing_Page_video",{},function() { });
   	}-*/;
	//For create FIB
	public static native void question_Create_FIB_success()/*-{
   		$wnd.mixpanel.track("Question_Create_FIB_success",{},function() { });
   	}-*/;

	//For creating blanks.
	public static native void fib_Mark_as_blank()/*-{
		$wnd.mixpanel.track("FIB_mark_as_blank",{},function() { });
	}-*/;
	public static native void Search_autocomplete_select()/*-{
	$wnd.mixpanel.track("Search_autocomplete_select",{},function() { });
	}-*/;

	/**
	 * 
	 * @function Regular_User_Logged_In 
	 * 
	 * @created_date : Dec 3, 2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * @version : 5.11
	 *
	 *
	 */
	public static native void Regular_User_Logged_In()/*-{
	$wnd.mixpanel.track("Regular_User_Logged_In",{},function() { });
	}-*/;

	public static native void sign_up_from_dragging_resource()/*-{
  	$wnd.mixpanel.track("Sign_up_from_dragging_resource",{},function() { });
  	}-*/;

	public static native void sign_up_from_saving_a_collection()/*-{
  	$wnd.mixpanel.track("Sign_up_from_saving_a_collection",{},function() { });
  	}-*/;

	public static native void select_teacher()/*-{
  	$wnd.mixpanel.track("Select_teacher",{},function() { });
  	}-*/;

	public static native void select_student()/*-{
  	$wnd.mixpanel.track("Select_student",{},function() { });
  	}-*/;

	public static native void select_parent()/*-{
  	$wnd.mixpanel.track("Select_parent",{},function() { });
  	}-*/;

	public static native void select_other()/*-{
  	$wnd.mixpanel.track("Select_other",{},function() { });
  	}-*/;

	public static native void  sign_up_with_your_email()/*-{
  	$wnd.mixpanel.track("Sign_up_with_your_email",{},function() { });
  	}-*/;

	public static native void sign_up_over_Thrteen()/*-{
  	$wnd.mixpanel.track("Sign_up_over_Thrteen",{},function() { });
  	}-*/;

	public static native void skip_grade_course()/*-{
  	$wnd.mixpanel.track("Skip_grade_course",{},function() { });
  	}-*/;

	public static native void submit_grade_course()/*-{
  	$wnd.mixpanel.track("Submit_grade_course",{},function() { });
  	}-*/;

	public static native void close_signUp()/*-{
  	$wnd.mixpanel.track("Close_signUp",{},function() { });
  	}-*/;

	public static native void register_as_a_parent()/*-{
  	$wnd.mixpanel.track("Register_as_a_parent",{},function() { });
  	}-*/;

	public static native void continue_Child_registration()/*-{
  	$wnd.mixpanel.track("Continue_Child_registration",{},function() { });
  	}-*/;

	public static native void sign_up_Child_registration()/*-{
  	$wnd.mixpanel.track("Sign_up_Child_registration",{},function() { });
  	}-*/;

	public static native void continue_registration()/*-{
  	$wnd.mixpanel.track("Continue_registration",{},function() { });
  	}-*/;

	public static native void create_Child_account()/*-{
  	$wnd.mixpanel.track("Create_Child_account",{},function() { });
  	}-*/;

	public static native void mixpanelEvent(String methodName) /*-{
	$wnd.mixpanel.track(methodName,{},function() { });
	}-*/;

	//--------------------------------   CP events  --------------------------------------------------------------//

	//test
	public static native void startStudyCollection() /*-{
    $wnd.mixpanel.track("Start_StudyCollection",{},function() {});
    }-*/;


	public static native void clickShareCollection(String Location) /*-{
    $wnd.mixpanel.track("Click_Share_"+Location,{},function() {});
    $wnd.mixpanel.track("Click_Share_TotalCount",{},function() {});
    }-*/;


	public static native void clickNavigation(String Location) /*-{
    $wnd.mixpanel.track("Click_Navigation_"+Location,{},function() {});
    }-*/;


	public static native void clickInfo(String Location) /*-{
    $wnd.mixpanel.track("Click_Info_"+Location,{},function() {});
    }-*/;


	public static native void ClickNarration(String Location) /*-{
    $wnd.mixpanel.track("Click_Narration_"+Location,{},function() {});
    }-*/;


	public static native void arriveCollectionEndpage() /*-{
    $wnd.mixpanel.track("Arrive_CollectionEndPage",{},function() {});
    }-*/;


	public static native void Click_On_CollectionPlayerUsername()/*-{
	$wnd.mixpanel.track("Click_On_CollectionPlayer_Username",{},function() {});
	}-*/;

	public static native void Click_On_CollectionPlayerInfoUsername()/*-{
	$wnd.mixpanel.track("Click_On_CollectionPlayer_InfoUsername",{},function() {});
	}-*/;

	////Mix Panel events for release-5.6/////

	/// Adding Collection from player
	
	public static native void Click_ViewthiscollectioninyourWorkspace()/*-{
   	$wnd.mixpanel.track("Click_ViewthiscollectioninyourWorkspace",{},function() {});
   	}-*/;

	////Mix Panel events for release-5.7/////
	
	public static native void OpenShare()/*-{
    $wnd.mixpanel.track("OpenShare",{},function() {});
    }-*/;

	public static native void OpenInfo()/*-{
    $wnd.mixpanel.track("OpenInfo",{},function() {});
    }-*/;

	public static native void CloseNarration()/*-{
    $wnd.mixpanel.track("CloseNarration",{},function() {});
    }-*/;

	////Mix Panel events for release-5.8/////
	//users can print summary page

	public static native void ClickPrintButtonFromSummaryPageInCollectionPlayer()/*-{
    $wnd.mixpanel.track("ClickPrintButtonFromSummaryPageInCollectionPlayer",{},function() {});
    }-*/;

	//users can email summary page

	public static native void ClickEmailButtonFromSummaryPageInCollectionPlayer()/*-{
    $wnd.mixpanel.track("ClickEmailButtonFromSummaryPageInCollectionPlayer",{},function() {});
    }-*/;

	//Open ended questions need to play in the player
	public static native void ClickOpenEndedQuestionSubmitButtonFromCollectionPlayer()/*-{
    $wnd.mixpanel.track("ClickOpenEndedQuestionSubmitButtonFromCollectionPlayer",{},function() {});
    }-*/;

	//[Share] Direct Link for accessing Collections (other than bit.ly link)

	public static native void Share_direct_player()/*-{
    $wnd.mixpanel.track("Share_direct_player",{},function() {});
    }-*/;

	public static native void Share_direct_player_end()/*-{
    $wnd.mixpanel.track("Share_direct_player_end",{},function() {});
    }-*/;
	
	//--------------------------------   RP events  --------------------------------------------------------------//
	
	 public static native void clickShareResource(String Location) /*-{
	    $wnd.mixpanel.track("Click_Share_"+Location,{},function() { });
	    $wnd.mixpanel.track("Click_Share_TotalCount",{},function() { });
 	}-*/;
	 
	 public static native void ClickOpenEndedQuestionSubmitButtonFromResourcePlayer()/*-{
	 $wnd.mixpanel.track("ClickOpenEndedQuestionSubmitButtonFromResourcePlayer",{},function() {});
	 }-*/;
	
	

	//--------------------------------    5.12 Players events  --------------------------------------------------------------//

	public static native void Preview_Click_Resource()/*-{
  	$wnd.mixpanel.track("Preview_Click_Resource",{},function() { });
  	}-*/;

	public static native void Player_Click_Add()/*-{
  	$wnd.mixpanel.track("Player_Click_Add",{},function() { });
  	}-*/;

	public static native void Preview_Player_Click_Related_Concept()/*-{
  	$wnd.mixpanel.track("Preview_Player_Click_Related_Concept",{},function() { });
  	}-*/;

	public static native void Preview_Author_Comments()/*-{
  	$wnd.mixpanel.track("Preview_Author_Comments",{},function() { });
  	}-*/;

	public static native void Preview_User_Comments()/*-{
  	$wnd.mixpanel.track("Preview_User_Comments",{},function() { });
  	}-*/;


	public static native void Preview_Player_Click_Preview()/*-{
  	$wnd.mixpanel.track("Preview_Player_Click_Preview",{},function() { });
  	}-*/;

	public static native void Preview_Click_Assign()/*-{
  	$wnd.mixpanel.track("Preview_Click_Assign",{},function() { });
  	}-*/;

	public static native void Preview_Click_Assign_successful()/*-{
  	$wnd.mixpanel.track("Preview_Click_Assign_successful",{},function() { });
  	}-*/;

	public static native void Preview_Click_Customize()/*-{
  	$wnd.mixpanel.track("Preview_Click_Customize",{},function() { });
  	}-*/;

	public static native void Preview_Click_Customize_successful()/*-{
  	$wnd.mixpanel.track("Preview_Click_Customize_successful",{},function() { });
  	}-*/;

	public static native void Preview_Click_Share()/*-{
  	$wnd.mixpanel.track("Preview_Click_Share",{},function() { });
  	}-*/;

	public static native void Preview_Player_Reach_End()/*-{
  	$wnd.mixpanel.track("Preview_Player_Reach_End",{},function() { });
  	}-*/;

	public static native void Study_Player_Reach_End()/*-{
  	$wnd.mixpanel.track("Study_Player_Reach_End",{},function() { });
  	}-*/;

	public static native void Player_Click_Linked_Out_Resource()/*-{
  	$wnd.mixpanel.track("Player_Click_Linked_Out_Resource",{},function() { });
  	}-*/;


	public static native void setIdentity(String userName, String emailId, String role, String createdDate, String firstLastName, String clientIpAddress)/*-{
		$wnd.mixpanel.identify(emailId);
		$wnd.mixpanel.people.set({
			"$name": ""+firstLastName,    // only special properties need the $
			"$email": ""+emailId,    // only special properties need the $
    		"$created": ""+createdDate,
    		"$last_login": new Date(),         // properties can be dates...
    		"$role": ""+role,
    		"$username": ""+userName,
    		"$clientIpAddress":""+clientIpAddress,
    		"$version":"6.1"
		});
	}-*/;
	public static native String getIP() /*-{
    	return $wnd._ipAddress;
	}-*/;
}
