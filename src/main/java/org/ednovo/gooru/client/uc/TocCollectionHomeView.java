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
package org.ednovo.gooru.client.uc;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : TocCollectionHomeView.java
 *
 * @description : This class is used to display the collection home view.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class TocCollectionHomeView extends Composite implements HasClickHandlers{

	@UiField Image resourceThumbnail;
	@UiField HTMLPanel resourceTitle;
	private String thumbnailUrl;
	private static TocResourceViewUiBinder uiBinder = GWT.create(TocResourceViewUiBinder.class);

	interface TocResourceViewUiBinder extends UiBinder<Widget, TocCollectionHomeView> {
	}
	/**
	 * class constructor.
	 */
	public TocCollectionHomeView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public TocCollectionHomeView(String thumbnailUrl){
		initWidget(uiBinder.createAndBindUi(this));
		this.thumbnailUrl=thumbnailUrl;
	}
	
	public void onLoad(){
		resourceThumbnail.setUrl(thumbnailUrl);
	}
	
	@UiHandler("resourceThumbnail")
	public void onErrorImageLoad(ErrorEvent event){
		resourceThumbnail.setUrl("images/default-collection-image-160x120.png");
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
}
