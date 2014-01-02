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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * 
 * @fileName : SearchMoreInfoVcCBundle.java
 *
 * @description : This file is the interface for SearchMoreInfoVc and to apply css styles.
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
public interface SearchMoreInfoVcCBundle extends ClientBundle {

	static final SearchMoreInfoVcCBundle INSTANCE = GWT.create(SearchMoreInfoVcCBundle.class);

	public interface SearchMoreInfoVcCss extends CssResource {

		String moreInfoMetaData(); 

		String moreInfoTitle();

		String gradeIcon();

		String tagIcon();

		String timeIcon();

		String likesIcon();

		String shareIcon();

		String rightsIcon();

		String moreInfoResourcesCountLblTxt();

		
		String moreInfoRightScrollPanel();

		String moreInfoRightPanel();
		
		String imageIcon();
		
		String htmlTxt();
		
		String clear();
		
		String questionRadioButton();
		
		String questionRadioButtonSelected();
		
		String questionRadioButtonContainer();
		
		// PPP Css //
		
		String publicPPMoreInfoRightScrollPanel();
		
		String moreInfoResourceSearceRightScrollPanel();
		String moreInfoResourceSearchRightPanel();
		String resourceSearchHtmlTxt();
		String resourceCollectionThumbnailPanel();
		String resourceCollectionTitlePanel();
		String moreInfoRightsLbl();

		String notFriendly();
		String questionMark();
//		String questionContainer();
		String imageHeight();
	}

	@Source("SearchMoreInfoVc.css")
	SearchMoreInfoVcCss css();
}
