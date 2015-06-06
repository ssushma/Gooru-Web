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
package org.ednovo.gooru.client.mvp.profilepage.content;


import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */
public class PPPCollectionSearchResultWrapperVc extends SearchResultWrapperVc<CollectionItemDo, CollectionItemSearchResultDo> {

	private PPPCollectionMoreInfoVc moreInfoVc;
	
	private String collectionId;


	/**
	 * Class constructor
	 */
	public PPPCollectionSearchResultWrapperVc(String collectionId) {
		super();
		this.collectionId=collectionId;
	}

	public PPPCollectionSearchResultWrapperVc() {
	}

	@Override
	protected SearchMoreInfoVc<CollectionItemDo, CollectionItemSearchResultDo> getSearchMoreInfoVc() {
		if(moreInfoVc == null) {
			 moreInfoVc = new PPPCollectionMoreInfoVc(collectionId);
		}
		return moreInfoVc;
	}
	
	@UiChild(tagname="content")
	protected void setContent(Widget widget) {
		super.setContent(widget);
	}

}
