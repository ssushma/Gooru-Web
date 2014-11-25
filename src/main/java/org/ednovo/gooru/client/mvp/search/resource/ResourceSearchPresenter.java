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
package org.ednovo.gooru.client.mvp.search.resource;

import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.rating.RatingAndReviewPopupPresenter;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsInSearchEvent;
import org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerPresenter;
import org.ednovo.gooru.client.mvp.search.AnalyticsInfoContainerPresenter;
import org.ednovo.gooru.client.mvp.search.IsSearchView;
import org.ednovo.gooru.client.mvp.search.SearchUiHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.RefreshDisclosurePanelEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.RefreshDisclosurePanelHandler;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * @author Search Team
 * 
 */
public class ResourceSearchPresenter extends AbstractSearchPresenter<ResourceSearchResultDo, CollectionSearchResultDo, IsResourceSearchView, ResourceSearchPresenter.IsResourceSearchProxy> implements SearchUiHandlers,RefreshDisclosurePanelHandler {
	
	private RatingAndReviewPopupPresenter ratingAndReviewPopup;
	
	private AddResourceContainerPresenter addResourceContainerPresenter;
	
	CollectionFormInPlayPresenter collectionFormInPlayPresenter;
	
	private	AnalyticsInfoContainerPresenter analyticsInfoContainerPresenter;
	
	AddStandardsPresenter addStandardsPresenter = null;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.RESOURCE_SEARCH)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsResourceSearchProxy extends ProxyPlace<ResourceSearchPresenter> {
	}

	/**
	 * Class constructor
	 *  
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public ResourceSearchPresenter(IsResourceSearchView view, IsResourceSearchProxy proxy,SignUpPresenter signUpViewPresenter,RatingAndReviewPopupPresenter ratingAndReviewPopup,
			AddResourceContainerPresenter addResourceContainerPresenter,CollectionFormInPlayPresenter collectionFormInPlayPresenter, AddStandardsPresenter addStandardsPresenter,AnalyticsInfoContainerPresenter analyticsInfoContainerPresenter) {
		super(view, proxy, signUpViewPresenter,addStandardsPresenter);
		this.ratingAndReviewPopup=ratingAndReviewPopup;
		this.addStandardsPresenter = addStandardsPresenter;
		this.addResourceContainerPresenter=addResourceContainerPresenter;
		this.collectionFormInPlayPresenter= collectionFormInPlayPresenter;
		this.analyticsInfoContainerPresenter = analyticsInfoContainerPresenter;
		getView().setUiHandlers(this);
		addRegisteredHandler(UpdateRatingsInSearchEvent.TYPE,this);
		addRegisteredHandler(RefreshDisclosurePanelEvent.TYPE, this);
	}

//	@Override
//	protected void onReset() {
//		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
//	}
/*	@Override
	protected void onReveal() {
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
*/	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}

	@Override
	protected Map<String, String> getSearchFilters() {
		Map<String, String> filters = super.getSearchFilters();
		String source = getPlaceManager().getRequestParameter(IsSearchView.PUBLISHER_FLT);
		if (source != null) {
			filters.put(IsSearchView.PUBLISHER_FLT, source);
		}
		String aggregator = getPlaceManager().getRequestParameter(IsSearchView.AGGREGATOR_FLT);
		if (aggregator != null) {
			filters.put(IsSearchView.AGGREGATOR_FLT, aggregator);
		}
		return filters;
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.RESOURCE_SEARCH;
	}	

	@Override
	protected void requestSearch(SearchDo<ResourceSearchResultDo> searchDo, SearchAsyncCallback<SearchDo<ResourceSearchResultDo>> searchAsyncCallback) {
		if (getPlaceManager().getRequestParameter("callback") != null && getPlaceManager().getRequestParameter("callback").equalsIgnoreCase("signup")){
			
		}else{
			Window.enableScrolling(true);
		}
		if (getSearchDo().getSearchQuery().trim().equals(ALL) && !AppClientFactory.isContentAdmin()) {
			return;
		}
		getSearchService().getResourceSearchResults(searchDo, searchAsyncCallback);
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		
		String message = Cookies.getCookie("SearchResultpopup");
	    if (message==null)
	    	message="";
		 if(!message.equalsIgnoreCase("viewed")&& AppClientFactory.isAnonymous()){
			 Cookies.setCookie("SearchResultpopup","viewed");
			 AppClientFactory.setEnableScroll(false);
	    }

	}
	public void showRatingAndReviewPopup(ResourceSearchResultDo searchResultDo){
		Window.enableScrolling(false);
		ratingAndReviewPopup.displayPopup(searchResultDo.getResourceTitle(), searchResultDo.getGooruOid(),null);
		addToPopupSlot(ratingAndReviewPopup);
	}

	@Override
	public void updateRatingInSearch(ResourceSearchResultDo searchResultDo) {
		showRatingAndReviewPopup(searchResultDo);
	}


	@Override
	public AddResourceContainerPresenter getAddResourceContainerPresenter() {
		return addResourceContainerPresenter;
	}

	@Override
	public void showAddResourceToShelfView(SimplePanel addResourceContainerPanel,ResourceSearchResultDo searchResultDo,String Type) {
		addResourceContainerPanel.clear();
		addResourceContainerPresenter.removePlayerStyle();
		addResourceContainerPresenter.getUserShelfData(searchResultDo,Type);
		addResourceContainerPresenter.cleartheSelecteGooruOid();
		addResourceContainerPresenter.SetDefaultMyCollections();
		addResourceContainerPanel.setWidget(addResourceContainerPresenter.getWidget());
		addResourceContainerPresenter.getAddButton().addClickHandler(new ShowNewCollectionWidget(searchResultDo.getGooruOid()));
		
	}
	public class ShowNewCollectionWidget implements ClickHandler{
		private String resourceId;
		ShowNewCollectionWidget(String resourceId){
			this.resourceId=resourceId;
		}
		@Override
		public void onClick(ClickEvent event) {
			addToPopupSlot(collectionFormInPlayPresenter);
			collectionFormInPlayPresenter.setResourceUid(resourceId);
		}
	}
	@Override
	public void showAddCollectionToShelfView(SimplePanel addResourceContainerPanel,CollectionSearchResultDo collectionsearchResultDo,String searchType) {
		
	}

	@Override
	public void refreshDisclosurePanelinSearch(String collectionId) {
		addResourceContainerPresenter.clearData();
		addResourceContainerPresenter.getfolderTreePanel().clear();
		addResourceContainerPresenter.getWorkspaceData(0, 20, false, "resource");
	}

	@Override
	public void showAndHideDisclosurePanelOnCLick(
			final DisclosurePanel DisclosurePanelClose) {
		// TODO Auto-generated method stub
		addResourceContainerPresenter.getCancelButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				DisclosurePanelClose.setOpen(false);
			}
		});
	}

	@Override
	public void setAnalyticsTabData(SimplePanel addResourceContainerPanel,
			ResourceSearchResultDo searchResultDo, String type) {
		// TODO Auto-generated method stub
		addResourceContainerPanel.clear();
		analyticsInfoContainerPresenter.setAnalyticsResourcesData(searchResultDo);
		addResourceContainerPanel.setWidget(analyticsInfoContainerPresenter.getWidget());
	}

	@Override
	public void setAnalyticsTabDataForCollections(
			SimplePanel addResourceContainerPanel,
			CollectionSearchResultDo searchResultDo, String type) {
		// TODO Auto-generated method stub
		
	}
}
