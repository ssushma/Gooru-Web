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

package org.ednovo.gooru.client.mvp.search.resource;

import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter;
import org.ednovo.gooru.client.mvp.search.IsSearchView;
import org.ednovo.gooru.client.mvp.search.SearchUiHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * 
 * @fileName : ResourceSearchPresenter.java
 *
 * @description : This is used to get the resource search results.
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
public class ResourceSearchPresenter extends AbstractSearchPresenter<ResourceSearchResultDo, CollectionSearchResultDo, IsResourceSearchView, ResourceSearchPresenter.IsResourceSearchProxy> implements SearchUiHandlers {

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
	public ResourceSearchPresenter(IsResourceSearchView view, IsResourceSearchProxy proxy,SignUpPresenter signUpViewPresenter) {
		super(view, proxy, signUpViewPresenter);
		getView().setUiHandlers(this);
	}

//	@Override
//	protected void onReset() {
//		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
//	}
/*	@Override
	protected void onReveal() {
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
*/	
	/**
	 * This is used to get the parameters from url.
	 */
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}
	/**
	 * This is used to get search filters.
	 */
	@Override
	protected Map<String, String> getSearchFilters() {
		Map<String, String> filters = super.getSearchFilters();
		String source = getPlaceManager().getRequestParameter(IsSearchView.SOURCE_FLT);
		if (source != null) {
			filters.put(IsSearchView.SOURCE_FLT, source);
		}
		return filters;
	}
	/**
	 * This is used to get the place token.
	 */
	@Override
	public String getViewToken() {
		return PlaceTokens.RESOURCE_SEARCH;
	}	
	/**
	 * This is used to get the resource search results.
	 */
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
}
