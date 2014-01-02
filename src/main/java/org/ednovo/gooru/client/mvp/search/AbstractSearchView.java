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
package org.ednovo.gooru.client.mvp.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.RequestShelfCollectionEvent;
import org.ednovo.gooru.client.mvp.search.event.SearchPaginationEvent;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AbstractSearchView.java
 *
 * @description : Deals with search.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class AbstractSearchView<T extends ResourceSearchResultDo> extends BaseViewWithHandlers<SearchUiHandlers> implements IsSearchView<T>, ClickHandler {

	private static AbstractSearchViewUiBinder uiBinder = GWT.create(AbstractSearchViewUiBinder.class);

	interface AbstractSearchViewUiBinder extends UiBinder<Widget, AbstractSearchView<?>> {
	}

	@UiField(provided = true)
	SearchFilterVc searchFilterVc;

	@UiField(provided = true)
	AppMirageDragContainer searchResultPanel;

	@UiField
	FlowPanel paginationFocPanel;

	@UiField
	ScrollPanel searchFilterPanel;
	
	protected ResourceDragController dragController;

	private static final String PREVIOUS = "PREVIOUS";

	private static final String NEXT = "NEXT";

	protected final List<CollectionDo> SHELF_COLLECTIONS = new ArrayList<CollectionDo>();

	public boolean refreshShelfInfo;

	public boolean refreshedShelfCollections;
	String rootWebUrl = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
	/**
	 * Assign new instance for {@link ResourceDragController}, {@link AppMirageDragContainer}, {@link SearchFilterVc}
	 * 
	 * @param resourceSearch
	 *            whether resource search or not
	 */
	public AbstractSearchView(boolean resourceSearch) {
		dragController = new ResourceDragController(RootPanel.get());
		searchResultPanel = new AppMirageDragContainer(dragController);
		searchFilterVc = new SearchFilterVc(resourceSearch);
		setWidget(uiBinder.createAndBindUi(this));
		searchFilterPanel.getElement().setId("searchFilterPanelDiv");
	}
	/**
	 * To set filters.
	 */
	@Override
	public void preSearch(SearchDo<T> searchDo) {
		reset();
		searchFilterVc.setFilter(searchDo.getFilters());
	}
	/**
	 * Pagination for search.
	 */
	@Override
	public void postSearch(SearchDo<T> searchDo) {
		searchResultPanel.setVisible(false);
		searchResultPanel.setClonnable(true);
		if (searchDo.getSearchResults() != null && searchDo.getSearchResults().size() > 0) {
			for (T searchResult : searchDo.getSearchResults()) {
				searchDo.getSearchHits();
				searchResultPanel.addDraggable(renderSearchResult(searchResult));
			}
			if (searchDo.getTotalPages() > 1) {
				if (searchDo.getPageNum() > 1) {
					paginationFocPanel.add(new PaginationButtonUc(searchDo.getPageNum() - 1, PREVIOUS, this));
				}
				int page = searchDo.getPageNum() < 10 ? 1 : searchDo.getPageNum() - 8;
				for (int count = 1; count < 10 && page <= searchDo.getTotalPages(); page++, ++count) {
					paginationFocPanel.add(new PaginationButtonUc(page, page == searchDo.getPageNum(), this));
				}
				if (searchDo.getPageNum() < searchDo.getTotalPages()) {
					paginationFocPanel.add(new PaginationButtonUc(searchDo.getPageNum() + 1, NEXT, this));
				}
			}
		}
		
		else {
			MixpanelUtil.Search_No_Results();
			if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().contains("resource-search"))
			{
			searchResultPanel.add(new NOSearchResultCollectionVc());
			}
			if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().contains("collection-search"))
			{
			searchResultPanel.add(new NOSearchResultCollectionVc());
			}
			
		}
		refreshShelfInfo = true;
		if (refreshedShelfCollections) {
			refreshShelfCollections(SHELF_COLLECTIONS);
		} else {
			AppClientFactory.fireEvent(new RequestShelfCollectionEvent());
		}
		searchResultPanel.setVisible(true);
	}
	/**
	 * This is to reset the data.
	 */
	@Override
	public void reset() {
		super.reset();
		refreshShelfInfo = false;
		refreshedShelfCollections = false;
		searchResultPanel.setClonnable(false);
		searchResultPanel.clear();
		paginationFocPanel.clear();
		SHELF_COLLECTIONS.clear();
	}

	/**
	 * @return instance of {@link SearchFilterVc}
	 */
	public SearchFilterVc getSearchFilterVc() {
		return searchFilterVc;
	}
	/**
	 * To set SearchFilter
	 */
	@Override
	public void setSearchFilter(SearchFilterDo searchFilterDo) {
		getSearchFilterVc().renderFilter(searchFilterDo);
		getUiHandlers().initiateSearch();
	}
	/**
	 * To get search filters
	 */
	@Override
	public Map<String, String> getSearchFilters() {
		return getSearchFilterVc().getFilter();
	}

	public abstract IsDraggable renderSearchResult(T searchDo);

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() instanceof PaginationButtonUc) {
			AppClientFactory.fireEvent(new SearchPaginationEvent(((PaginationButtonUc) event.getSource()).getPage()));
		} else {
			Window.alert("Event is not caught");
		}
	}

	/**
	 * @return instance of {@link AppMirageDragContainer}
	 */
	public AppMirageDragContainer getSearchResultPanel() {
		return searchResultPanel;
	}
	/**
	 * To set SourceSuggestions to searchFilterVc.
	 */
	@Override
	public void setSourceSuggestions(SearchDo<String> sourceSuggestions) {
		searchFilterVc.setSourceSuggestions(sourceSuggestions);
	}
	/**
	 * To set StandardSuggestions to searchFilterVc.
	 */
	@Override
	public void setStandardsSuggestions(SearchDo<CodeDo> standardsSuggestions) {
		searchFilterVc.setStandardSuggestions(standardsSuggestions);
	}
	/**
	 * To register drop controller.
	 */
	@Override
	public void registerDropController(ResourceDropController dropController, RegisterSearchDropEvent.DROP_AREA type) {
		dragController.unregisterDropController(dropController);
		dragController.registerDropController(dropController);
	}
	/**
	 * To unregister drop controller.
	 */
	@Override
	public void unregisterDropController(ResourceDropController dropController, RegisterSearchDropEvent.DROP_AREA type) {
		dragController.unregisterDropController(dropController);
	}
	/**
	 * This method is called immediately before a widget will be detached from the browser's document.
	 */
	@Override
	public void onUnload() {
		super.onUnload();
		dragController.unregisterDropControllers();
	}
	/**
	 * To set shelf collections
	 */
	@Override
	public void setShelfCollections(List<CollectionDo> shelfCollections) {
		SHELF_COLLECTIONS.clear();
		if (shelfCollections != null) {
			SHELF_COLLECTIONS.addAll(shelfCollections);
		}
		refreshedShelfCollections = true;
		if (refreshShelfInfo) {
			refreshShelfCollections(SHELF_COLLECTIONS);
		}
	}

	protected abstract void refreshShelfCollections(List<CollectionDo> shelfCollections);
	/**
	 * To set SourceSuggestionsInfo
	 */
	@Override
	public void setStandardsSuggestionsInfo(SearchDo<CodeDo> result) {
		searchFilterVc.setSourceSuggestionsInfo(result);
	}
	/**
	 * To reset filters.
	 */
	@Override
	public void resetFilters(){
		searchFilterVc.clearAllFields();
	}

}
