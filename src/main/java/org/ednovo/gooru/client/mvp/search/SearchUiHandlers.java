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
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsInSearchHandler;
import org.ednovo.gooru.client.mvp.search.event.AggregatorSuggestionEventHandler;
import org.ednovo.gooru.client.mvp.search.event.ConsumeShelfCollectionsHandler;
import org.ednovo.gooru.client.mvp.search.event.RefreshSearchHandler;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropHandler;
import org.ednovo.gooru.client.mvp.search.event.SearchHandler;
import org.ednovo.gooru.client.mvp.search.event.SearchPaginationHandler;
import org.ednovo.gooru.client.mvp.search.event.SourceSuggestionHandler;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionHandler;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionInfoHandler;
import org.ednovo.gooru.client.mvp.search.event.SwitchSearchHandler;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropHandler;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Search Team
 * 
 */
public interface SearchUiHandlers extends BaseUiHandlers, SearchPaginationHandler, RefreshSearchHandler, StandardsSuggestionHandler, SourceSuggestionHandler, RegisterSearchDropHandler, SearchHandler, UnregisterSearchDropHandler, SwitchSearchHandler, ConsumeShelfCollectionsHandler, StandardsSuggestionInfoHandler,AggregatorSuggestionEventHandler,UpdateRatingsInSearchHandler {
	
	/**
	 * Set search page view
	 */
	/**
	 * 
	 */
	void initiateSearch();
	
	/**
	 * @param searchResultDo
	 */
	public void showRatingAndReviewPopup(ResourceSearchResultDo searchResultDo);
	
	/**
	 * @return
	 */
	public AddResourceContainerPresenter getAddResourceContainerPresenter();
	
	/**
	 * @param addResourceContainerPanel
	 * @param searchResultDo
	 * @param Type
	 */
	public void showAddResourceToShelfView(SimplePanel addResourceContainerPanel,ResourceSearchResultDo searchResultDo,String Type);
	
	/**
	 * @param addResourceContainerPanel
	 * @param collectionsearchResultDo
	 * @param Type
	 */
	public void showAddCollectionToShelfView(SimplePanel addResourceContainerPanel,CollectionSearchResultDo collectionsearchResultDo,String Type);

	/**
	 * 
	 */
	void getAddStandards();

	/**
	 * 
	 */
	void setUpdatedStandards();

	/**
	 * 
	 */
	void closeStandardsPopup();

	/**
	 * @param DisclosurePanelClose
	 */
	void showAndHideDisclosurePanelOnCLick(DisclosurePanel DisclosurePanelClose);
	
	/**
	 * @param addResourceContainerPanel
	 * @param searchResultDo
	 * @param type
	 */
	void setAnalyticsTabData(SimplePanel addResourceContainerPanel,ResourceSearchResultDo searchResultDo, String type);

	/**
	 * @param addResourceContainerPanel
	 * @param searchResultDo
	 * @param type
	 */
	void setAnalyticsTabDataForCollections(SimplePanel addResourceContainerPanel,CollectionSearchResultDo searchResultDo, String type);

	/**
	 * @param simplePanel     
	 * @param searchResultDo
	 */
	void setTagsWidget(SimplePanel simplePanel, ResourceSearchResultDo searchResultDo);
}
