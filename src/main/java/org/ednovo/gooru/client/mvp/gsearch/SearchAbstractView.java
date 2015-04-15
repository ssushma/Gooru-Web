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
package org.ednovo.gooru.client.mvp.gsearch;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 * @param <T>
 *            type of ResourceSearchResultDo
 */
public abstract class SearchAbstractView<T extends ResourceSearchResultDo> extends BaseViewWithHandlers<GooruSearchUiHandlers> implements IsGooruSearchView<T>, ClickHandler {

	private static SearchAbstractViewUiBinder uiBinder = GWT.create(SearchAbstractViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface SearchAbstractViewUiBinder extends UiBinder<Widget, SearchAbstractView<?>> {
	}
	
	@UiField LiPanel resourcePanel, collectionPanel;
	
	@UiField HTMLPanel searchResultPanel;

	int pageNumber = 1;
	
	/**
	 * Assign new instance for 
	 * 
	 * @param resourceSearch
	 *            whether resource search or not
	 */
	public SearchAbstractView(boolean resourceSearch) {
		setWidget(uiBinder.createAndBindUi(this));
		searchFeildsIds();
		Window.addWindowScrollHandler(new ScrollHandler() {
			@Override
			public void onWindowScroll(ScrollEvent event) {
				if ((event.getScrollTop() + Window.getClientHeight()) == Document.get().getBody().getClientHeight()) {
					pageNumber++;
					getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber, 8);
				}
			}
		});
	}
	@Override
	public void onClick(ClickEvent event) {
		
	}

	/**
     * To set ids for all fields.
     */
	private void searchFeildsIds() {
		StringUtil.setAttributes(resourcePanel.getElement(), "searchResourcePanel", i18n.GL1755(), i18n.GL1755());
		StringUtil.setAttributes(collectionPanel.getElement(), "searchCollectionPanel", i18n.GL1754(), i18n.GL1754());
	}
	
	@UiHandler("resourcePanel")
	public void clickOnResource(ClickEvent clickEvent){
		collectionPanel.removeStyleName("active");
		resourcePanel.setStyleName("active");
	}
	
	@UiHandler("collectionPanel")
	protected void clickOnCollection(ClickEvent clickEvent){
		collectionPanel.setStyleName("active");
		resourcePanel.removeStyleName("active");
	}
	
	@Override
	public void postSearch(SearchDo<T> searchDo) {
		if (searchDo.getSearchResults() != null && searchDo.getSearchResults().size() > 0) {
			for (T searchResult : searchDo.getSearchResults()) {
				searchDo.getSearchHits();
				searchResultPanel.add(renderSearchResult(searchResult));
			}
		}
	}
	
	public abstract Widget renderSearchResult(T searchDo);
}
