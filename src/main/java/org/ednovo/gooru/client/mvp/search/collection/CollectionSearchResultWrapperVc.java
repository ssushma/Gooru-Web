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

import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class CollectionSearchResultWrapperVc extends SearchResultWrapperVc<CollectionSearchResultDo, CollectionItemSearchResultDo> {

	private CollectionMoreInfoVc moreInfoVc;
	
	private String collectionId;

	private ResourceDragController searchDragController;

	/**
	 * Class constructor
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public CollectionSearchResultWrapperVc(ResourceDragController searchDragController,String collectionId) {
		super();
		this.searchDragController = searchDragController;
		this.collectionId=collectionId;
	}

	public CollectionSearchResultWrapperVc() {
	}

	@Override
	protected SearchMoreInfoVc<CollectionSearchResultDo, CollectionItemSearchResultDo> getSearchMoreInfoVc() {
		if(moreInfoVc == null) {
			 moreInfoVc = new CollectionMoreInfoVc(searchDragController,collectionId);
		}
		return moreInfoVc;
	}
	
	@UiChild(tagname="content")
	protected void setContent(Widget widget) {
		super.setContent(widget);
	}

}
