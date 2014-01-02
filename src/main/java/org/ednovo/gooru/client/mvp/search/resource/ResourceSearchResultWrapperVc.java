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

import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ResourceSearchResultWrapperVc.java
 *
 * @description : This file deals with resource search results more info panel.
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
public class ResourceSearchResultWrapperVc extends SearchResultWrapperVc<ResourceSearchResultDo, CollectionSearchResultDo> {

	private ResourceMoreInfoVc moreInfoVc;
	
	private ResourceDragController searchDragController;

	/**
	 * Class constructor
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public ResourceSearchResultWrapperVc(ResourceDragController searchDragController) {
		super();
		this.searchDragController = searchDragController;
	}
	/**
	 * Returns search moreInfo.
	 */
	@Override
	protected SearchMoreInfoVc<ResourceSearchResultDo, CollectionSearchResultDo> getSearchMoreInfoVc() { 
		if(moreInfoVc == null) {
			 moreInfoVc = new ResourceMoreInfoVc(searchDragController);
		}
		return moreInfoVc;
	}
	/**
	 * This is used to set the content.
	 */
	@UiChild(tagname="content")
	protected void setContent(Widget widget) {
		super.setContent(widget);
	}

}
