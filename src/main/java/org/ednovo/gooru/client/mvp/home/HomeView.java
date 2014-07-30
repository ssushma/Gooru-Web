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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;
import org.ednovo.gooru.client.mvp.home.register.RegisterVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.library.SubjectDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Search Team
` * 
 */
public class HomeView extends BaseViewWithHandlers<HomeUiHandlers> implements IsHomeView {

	@UiField HTMLPanel gooruPanel, panelLandingPage, contributorsContainer;
	@UiField Button btnSignUp, btnMoreOnCollections;
	@UiField Label lblHeading, lblSubHeading; 
	@UiField TextBoxWithPlaceholder txtSearch;
	@UiField Button btnSearch;
	@UiField Anchor achLearn;
	LibraryView libraryView = null;
	
	Map<String, String> allSubject = new HashMap<String, String>();
	Map<String, String> allCourse  = new HashMap<String, String>();
	
	
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 */
	public HomeView() {		
		setWidget(uiBinder.createAndBindUi(this));
		gooruPanel.getElement().setId("gooruPanel");

		panelLandingPage.setVisible(true);
		gooruPanel.setVisible(false);
		setIds();
		
		
		generateSubjectsData();
		generateCourseData();
		
//		InternalServerErrorPopupViewVc error = new InternalServerErrorPopupViewVc() {
//		};
//		error.show();

	}
	/**
	 * @function generateCourseData 
	 * 
	 * @created_date : Jul 29, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void generateCourseData() {
		
	}
	/**
	 * @function generateSubjectsData 
	 * 
	 * @created_date : Jul 29, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void generateSubjectsData() {	
		List<SubjectDo> subList = new ArrayList<SubjectDo>();
		
		for (int i=0; i<4; i++){
//			Subject 
		}
		
		
		allSubject.put("Science", "20001");
		allSubject.put("Language Arts", "30186");
		allSubject.put("Math", "20002");
		allSubject.put("Social Sciences", "25681");
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == getUiHandlers().getContributorsSlot()){
			contributorsContainer.add(content);
		}
	}
	

	/**
	 * @function setIds 
	 * 
	 * @created_date : Jul 28, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void setIds() {
		StringUtil.setAttributes(btnSignUp.getElement(), "btnSignUp", i18n.GL0186(), i18n.GL0186());
		StringUtil.setAttributes(btnSearch.getElement(), "btnSearch", i18n.GL0176(), i18n.GL0176());
				
		StringUtil.setAttributes(lblHeading.getElement(), "lblHeading", i18n.GL2046(), i18n.GL2046());
		StringUtil.setAttributes(lblSubHeading.getElement(), "lblSubHeading", i18n.GL2047(), i18n.GL2047());
		
		Window.enableScrolling(true);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.gin.BaseViewWithHandlers#onLoad()
	 */
	@Override
	public void onLoad() {
				
	}
	
	@Override
	public void resetPassword(String resetToken) {
		new ResetPasswordVc(resetToken);
		
	}
	
	@Override
	public void registerPopup() {
		RegisterVc registerVc = new RegisterVc();
		registerVc.show();
		registerVc.center();
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.home.IsHomeView#loadFeaturedContributors()
	 */
	@Override
	public void loadFeaturedContributors(String callBack, String placeToken) {
//		libraryView.loadContributorsPage(callBack,placeToken);
	}
	
	@UiHandler("btnSignUp")
	public void onClickSignUp(ClickEvent event){
		Map<String, String> map = StringUtil.splitQuery(Window.Location
				.getHref());
		map.put("callback", "signup");
		map.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				AppClientFactory.getCurrentPlaceToken(), map);
	}
	
	@UiHandler("btnSearch")
	public void onClickSearch(ClickEvent event){

//		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		if (getEditSearchTxtBox().getText() != null
				&& getEditSearchTxtBox().getText().length() > 0) {
			savePlaceRequest();
			MixpanelUtil.Perform_Search(getEditSearchTxtBox().getText().trim()
					.toLowerCase(), "LandingPage");
			Map<String, String> params = new HashMap<String, String>();
			params = updateParams(params);
			if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.COLLECTION_SEARCH, params);
			}else{
				String queryVal = params.get("query");
				//queryVal = queryVal.replaceAll("%5C1", "&");
				Map<String, String> map = params;
				map.put("query", queryVal);	
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.RESOURCE_SEARCH, map);
			}
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.NONE));
//			getEditSearchTxtBox().hideSuggestionList();
		}
		
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.HOME)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage");
			if(AppClientFactory.isAnonymous()){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage_Loggedout");
			}else{	
				MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage_Loggedin");
			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("courseId")!=null){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromCoursePage");
			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("page")!=null && AppClientFactory.getPlaceManager().getRequestParameter("page").equalsIgnoreCase("featured-contributors")){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromContributorsPage");
			}
		}
//		if(hasAutoSelected){
//			MixpanelUtil.mixpanelEvent("Select_Autocomplete_Search");
//		}
		
	
	}
	/**
	 * @function getEditSearchTxtBox 
	 * 
	 * @created_date : Jul 29, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @return
	 * 
	 * @return : TextBoxWithPlaceholder
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private TextBoxWithPlaceholder getEditSearchTxtBox() {
		return txtSearch;
	}

	public void savePlaceRequest(){
		String currentPlaceToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(currentPlaceToken.equals(PlaceTokens.COLLECTION_SEARCH)||currentPlaceToken.equals(PlaceTokens.RESOURCE_SEARCH)){
		}else{
			AppClientFactory.getPlaceManager().setSearchMovedPlaceRequest(AppClientFactory.getPlaceManager().getCurrentPlaceRequest());
		}
	}

	/**
	 * Set pagination for search
	 * 
	 * @param params
	 *            variable for Map<String,String>
	 * @return pagination values
	 */
	public Map<String, String> updateParams(Map<String, String> params) {
		params.put("category", "All");
		params.put("query", getEditSearchText());
		params.put("pageNum", "1");
		params.put("pageSize", "8");
		return params;
	}
	/**
	 * @return search keyword
	 */
	public String getEditSearchText() {
		String searchText = getEditSearchTxtBox().getText();
		if (searchText != null && searchText.length() > 0) {
			return searchText;
		} else {
			return null;
		}
	}
	
	@UiHandler("btnMoreOnCollections")
	public void onClickMoreOnCollections(ClickEvent event){
		AppClientFactory.setPreviousPlaceRequest(AppClientFactory
				.getPlaceManager().getCurrentPlaceRequest());
		Storage stockStore = Storage.getLocalStorageIfSupported();

		if (stockStore != null) {
			stockStore.setItem("tabKey", "resourceTab");
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF);
	}
	
	@UiHandler("btnMoreOnClasses")
	public void onClickMoreOnClasses(ClickEvent event){
		if (!AppClientFactory.isAnonymous()){
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME);
		} else {
			AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
		}
	}
	@UiHandler("achLearn")
	public void onClickLearn(ClickEvent event){
		int scrollTop =0;
		try{
			scrollTop = Document.get().getElementById("getStarted").getAbsoluteTop();
		}catch(Exception e){
			
		}
		
		Window.scrollTo(0, scrollTop-40);
	}
}


