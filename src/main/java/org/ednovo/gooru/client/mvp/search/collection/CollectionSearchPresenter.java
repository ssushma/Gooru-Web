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
package org.ednovo.gooru.client.mvp.search.collection;

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
public class CollectionSearchPresenter extends AbstractSearchPresenter<CollectionSearchResultDo, ResourceSearchResultDo, IsCollectionSearchView, CollectionSearchPresenter.IsCollectionSearchProxy> implements SearchUiHandlers {

	@ProxyCodeSplit
	@NameToken(PlaceTokens.COLLECTION_SEARCH)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsCollectionSearchProxy extends ProxyPlace<CollectionSearchPresenter> {
	}

	/**
	 * Class constructor
	 * 
	 * @param view
	 *            {@link View}
	 * @param proxy
	 *            {@link Proxy}
	 */
	@Inject
	public CollectionSearchPresenter(IsCollectionSearchView view, IsCollectionSearchProxy proxy, SignUpPresenter signUpViewPresenter) {
		super(view, proxy, signUpViewPresenter);
		getView().setUiHandlers(this);
	}

//	@Override
//	protected void onReset() {
//		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
//	}
//	
/*	@Override
	protected void onReveal() {
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
*/	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		
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
	public String getViewToken() {
		return PlaceTokens.COLLECTION_SEARCH;
	}

	@Override
	protected void requestSearch(SearchDo<CollectionSearchResultDo> searchDo, SearchAsyncCallback<SearchDo<CollectionSearchResultDo>> searchAsyncCallback) {
		getSearchService().getCollectionSearchResults(searchDo, searchAsyncCallback);
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));

	}

/*	@Override
	public void showRatingAndReviewPopup() {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void showRatingAndReviewPopup(ResourceSearchResultDo searchResultDo) {
		// TODO Auto-generated method stub
		
	}
}
