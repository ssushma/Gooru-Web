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
package org.ednovo.gooru.client.mvp.shelf.collection;

import org.ednovo.gooru.client.mvp.search.NoSearchResultBundle;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : CollectionSharePrivateResource.java
 *
 * @description : This file is used to set the Private Resource data in Collection Share .
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
public class CollectionSharePrivateResource extends Composite {

	@UiField Label resourceCategory;
	
	@UiField HTML resourceTitle,resourceDescription;
	
	@UiField Image resourceImageUc;
	
	@UiField NoSearchResultBundle noResultStyle;
	
	@UiField HTMLPanel resourceCategoryIcon;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";
	
	private static final String PNG = ".png";
	
	private static final String SMALL = "Small";
	
	private static CollectionSharePrivateResourceUiBinder uiBinder = GWT
			.create(CollectionSharePrivateResourceUiBinder.class);

	interface CollectionSharePrivateResourceUiBinder extends
			UiBinder<Widget, CollectionSharePrivateResource> {
	}
	/**
	 * Class Constructor.
	 * @param collectionItemDo
	 */
	public CollectionSharePrivateResource(CollectionItemDo collectionItemDo) {
		initWidget(uiBinder.createAndBindUi(this));
		String resourceHtmlTitle=collectionItemDo.getResourceTitle();
		resourceHtmlTitle=resourceHtmlTitle.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		resourceTitle.setHTML(resourceHtmlTitle);
		final String category = collectionItemDo.getResource().getCategory();
		resourceCategory.setText(category);
		resourceCategoryIcon.addStyleName(UcCBundle.INSTANCE.css().resourceName());
		resourceCategoryIcon.addStyleName(category.toLowerCase() + SMALL);
		if(!category.equalsIgnoreCase("Question")){
			String descriptionTxt = collectionItemDo.getResource().getDescription();
			descriptionTxt = descriptionTxt.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
			resourceDescription.setHTML(descriptionTxt);
		}
		
		final String url = collectionItemDo.getResource().getThumbnails().getUrl();
		if(url!=null) {
			resourceImageUc.setUrl(collectionItemDo.getResource().getThumbnails().getUrl());
		} else {
			resourceImageUc.setUrl(DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG);
		}
		
		resourceImageUc.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				resourceImageUc.setUrl(DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG);
			}
		});
	}
}
