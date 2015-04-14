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

package org.ednovo.gooru.client.mvp.gsearch.collection;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.util.CollectionSearchWidget;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @fileName : SearchCollectionView.java
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
public class SearchCollectionView extends BaseViewWithHandlers<SearchCollectionUiHandlers>
		implements IsSearchCollectionView {

	private static SearchCollectionViewUiBinder uiBinder = GWT
			.create(SearchCollectionViewUiBinder.class);

	interface SearchCollectionViewUiBinder extends UiBinder<Widget, SearchCollectionView> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel searchResultPanel;
	
	public SearchCollectionView() {
		setWidget(uiBinder.createAndBindUi(this));
		Window.addWindowScrollHandler(new ScrollHandler() {
			@Override
			public void onWindowScroll(ScrollEvent event) {
				if((event.getScrollTop()+Window.getClientHeight())==Document.get().getBody().getClientHeight()){
					for(int i=0;i<20;i++){
						//searchResultPanel.add(new CollectionSearchWidget());
					}
				}
			}
		});
		/*for(int i=0;i<20;i++){
			searchResultPanel.add(new CollectionSearchWidget());
		}*/
	}

	@Override
	public void setCollectionsData(SearchDo<CollectionSearchResultDo> result) {
		if(result!=null && result.getSearchResults().size()>0){
			for (CollectionSearchResultDo collectionSearchResultDo : result.getSearchResults()) {
				searchResultPanel.add(new CollectionSearchWidget(collectionSearchResultDo));
			}
		}
	}
}
