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

import java.util.List;

import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.client.mvp.search.AbstractSearchView;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;

import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : CollectionSearchView.java
 *
 * @description : To get CollectionSearchResults and to refresh results.
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
public class CollectionSearchView extends AbstractSearchView<CollectionSearchResultDo> implements IsCollectionSearchView {

	/**
	 * Class constructor
	 */
	public CollectionSearchView() {
		super(false);
	}
	/**
	 * returns CollectionSearchResults.
	 */
	@Override
	public IsDraggable renderSearchResult(CollectionSearchResultDo searchResultDo) {
		return new CollectionSearchResultVc(searchResultDo, dragController);
	}
	/**
	 * To refresh collections.
	 */
	@Override
	protected void refreshShelfCollections(List<CollectionDo> shelfCollections) {
		for (Widget widget : getSearchResultPanel()) {
			if (widget instanceof Draggable && ((Draggable)widget).getDraggableUc() instanceof CollectionSearchResultVc) {
				CollectionSearchResultVc searchResultVc = (CollectionSearchResultVc) ((Draggable)widget).getDraggableUc();
				boolean added = false;
				for (CollectionDo collection : shelfCollections) {
					if (collection.getGooruOid().equals(searchResultVc.getCollectionResultDo().getGooruOid())) {
						searchResultVc.setAddedToShelf(true);
						added = true;
						break;
					}
				}
				if (!added) {
					searchResultVc.setAddedToShelf(false);
				}
			}
		}
	}
}
