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
/**
 * 
 */
package org.ednovo.gooru.client.mvp.gsearch.resource;

import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.gsearch.GooruSearchUiHandlers;
import org.ednovo.gooru.client.mvp.gsearch.SearchAbstractPresenter;
import org.ednovo.gooru.client.mvp.gsearch.SearchMainPresenter;
import org.ednovo.gooru.client.mvp.gsearch.ViewMorePopup.ViewMorePeoplePresenter;
import org.ednovo.gooru.client.mvp.gsearch.addResourcePopup.SearchAddResourceToCollectionPresenter;
import org.ednovo.gooru.client.mvp.gsearch.util.GooruGradesPresenter;
import org.ednovo.gooru.client.mvp.rating.RatingAndReviewPopupPresenter;
import org.ednovo.gooru.client.mvp.search.IsSearchView;
import org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyPresenter;
import org.ednovo.gooru.client.mvp.search.collection.RefreshDisclosurePanelForFoldersEventHandler;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.service.SearchServiceAsync;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
/**
 * @fileName : SearchResourcePresenter.java
 *
 * @description : 
 *
 * @version : 1.3
 *
 * @date: 10-04-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public class SearchResourcePresenter extends SearchAbstractPresenter<ResourceSearchResultDo, CollectionSearchResultDo, IsSearchResourceView, SearchResourcePresenter.IsSearchResourceProxy> implements GooruSearchUiHandlers,RefreshDisclosurePanelForFoldersEventHandler {

	@Inject
	private SearchServiceAsync searchService;
	
	AddStandardsPresenter addStandardsPresenter = null;

	AddCenturyPresenter addCenturyPresenter;
	
	GooruGradesPresenter gooruGradesPresenter;
	
	SearchAddResourceToCollectionPresenter searchAddResourceToCollectionPresenter = null;
	
	ViewMorePeoplePresenter viewmorePeoplePresenter = null;
	
	CollectionFormInPlayPresenter collectionFormInPlayPresenter;
	
	RatingAndReviewPopupPresenter ratingAndReviewPopup;
	
	AppPopUp appPopUp=new AppPopUp();
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.SEARCH_RESOURCE)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsSearchResourceProxy extends ProxyPlace<SearchResourcePresenter> {
	}

	@Inject
	public SearchResourcePresenter(IsSearchResourceView view, IsSearchResourceProxy proxy,SignUpPresenter signUpViewPresenter,AddStandardsPresenter addStandardsPresenter,AddCenturyPresenter addCenturyPresenter,GooruGradesPresenter gooruGradesPresenter,SearchAddResourceToCollectionPresenter searchAddResourceToCollectionPresenter,CollectionFormInPlayPresenter collectionFormInPlayPresenter,ViewMorePeoplePresenter viewmorePeoplePresenter,RatingAndReviewPopupPresenter ratingAndReviewPopup) {
		super(view, proxy, signUpViewPresenter,addStandardsPresenter,addCenturyPresenter,gooruGradesPresenter,searchAddResourceToCollectionPresenter,viewmorePeoplePresenter);
		this.addStandardsPresenter = addStandardsPresenter;
		this.ratingAndReviewPopup=ratingAndReviewPopup;
		this.addCenturyPresenter=addCenturyPresenter;
		this.gooruGradesPresenter=gooruGradesPresenter;
		this.searchAddResourceToCollectionPresenter=searchAddResourceToCollectionPresenter;
		this.collectionFormInPlayPresenter=collectionFormInPlayPresenter;
		this.viewmorePeoplePresenter = viewmorePeoplePresenter;
		getView().setUiHandlers(this);
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.SEARCH_RESOURCE;
	}
	
	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, SearchMainPresenter.TYPE_VIEW, this);
	}

	@Override
	protected void onReveal() {
		super.onReveal();
	}
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		
	}
	@Override
	protected void onReset() {
		super.onReset();
	}
	
	@Override
	public void onBind() {
		super.onBind();
	}

	public SearchServiceAsync getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchServiceAsync searchService) {
		this.searchService = searchService;
	}
	@Override
	public void refreshDisclosurePanelForFoldersinSearch(String collectionId) {
		
	}
		
	@Override
	public void getCollectionSearchResultsOnPageWise(String query,int pageNumber, int pageSize) {
		getSearchDo().setPageNum(pageNumber);
		getSearchDo().setPageSize(pageSize);
		getSearchService().getResourceSearchResults(getSearchDo(),getSearchAsyncCallback());
	}
	
	/**
	 * @return search filters as Map value
	 */
	@Override
	protected Map<String, String> getSearchFilters() {
		Map<String, String> filters = super.getSearchFilters();
		String author = getPlaceManager().getRequestParameter(IsSearchView.OWNER_FLT);
		if (author != null) {
			filters.put(IsSearchView.OWNER_FLT, author);
		}
		return filters;
	}
	@Override
	protected void requestSearch(SearchDo<ResourceSearchResultDo> searchDo,SearchAsyncCallback<SearchDo<ResourceSearchResultDo>> searchAsyncCallback) {
		getSearchDo().setPageSize(9);
		getSearchService().getResourceSearchResults(searchDo, searchAsyncCallback);
	}

	@Override
	public void displayAddResourcePoup(ResourceSearchResultDo resourceSearchResultDo) {
		searchAddResourceToCollectionPresenter.getUserShelfData(resourceSearchResultDo,"resoruce");
		searchAddResourceToCollectionPresenter.getAddButton().addClickHandler(new ShowNewCollectionWidget(resourceSearchResultDo.getGooruOid()));
		addToPopupSlot(searchAddResourceToCollectionPresenter);
	}
	@Override
	public void displayUsersList(ResourceSearchResultDo resourceSearchResultDo) {
		viewmorePeoplePresenter.getResourceDataByResource(resourceSearchResultDo,"resoruce");
		//viewmorePeoplePresenter.getAddButton().addClickHandler(new ShowNewCollectionWidget(resourceSearchResultDo.getGooruOid()));
		addToPopupSlot(viewmorePeoplePresenter);
	}
	public class ShowNewCollectionWidget implements ClickHandler{
		private String resourceId;
		public ShowNewCollectionWidget(String resourceId){
			this.resourceId=resourceId;
		}
		@Override
		public void onClick(ClickEvent event) {
			searchAddResourceToCollectionPresenter.hidePopup();
			addToPopupSlot(collectionFormInPlayPresenter);
			collectionFormInPlayPresenter.setResourceUid(resourceId);
		}
	}
	
	public void showRatingAndReviewPopup(ResourceSearchResultDo searchResultDo){
		Window.enableScrolling(false);
		ratingAndReviewPopup.displayPopup(searchResultDo.getResourceTitle(), searchResultDo.getGooruOid(),null);
		addToPopupSlot(ratingAndReviewPopup);
	}

	@Override
	public void displayRemixForCollectionsPoup(
			CollectionSearchResultDo collectionsearchResultDo) {
		// TODO Auto-generated method stub
		
	}
}
