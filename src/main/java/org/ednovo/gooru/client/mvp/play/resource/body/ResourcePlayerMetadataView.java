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
package org.ednovo.gooru.client.mvp.play.resource.body;


import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.body.GwtEarthWidget;
import org.ednovo.gooru.client.mvp.play.resource.framebreaker.ResourceFrameBreakerView;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourcePlayerMetadataView extends BaseViewWithHandlers<ResourcePlayerMetadataUiHandlers> implements IsResourcePlayerMetadataView{

	@UiField FlowPanel resourceWidgetContainer;
	@UiField Button forwardButton,backwardButton;
	
    
	HandlerRegistration forwardButtonHandler=null, backwardButtonHandler=null;
	private static ResourcePlayerMetadataViewUiBinder uiBinder = GWT.create(ResourcePlayerMetadataViewUiBinder.class);

	interface ResourcePlayerMetadataViewUiBinder extends UiBinder<Widget, ResourcePlayerMetadataView> {
	}
	
	@Inject
	public ResourcePlayerMetadataView(){
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo){
		if(forwardButton!=null){
			forwardButton.removeFromParent();
		}
		if(backwardButton!=null){
			backwardButton.removeFromParent();
		}
		previewResouceWidget(collectionItemDo);
	}
	
	public void showResourceWidget(PlaceRequest previousResourceRequest){	
		if(forwardButtonHandler!=null||backwardButtonHandler!=null){
			forwardButtonHandler.removeHandler();
			backwardButtonHandler.removeHandler();
		}
		forwardButton.getElement().getStyle().setDisplay(Display.NONE);
		forwardButtonHandler=forwardButton.addClickHandler(new ShowResourceView(previousResourceRequest));
		backwardButtonHandler=backwardButton.addClickHandler(new ShowResourceView(previousResourceRequest));
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo,PlaceRequest nextResoruceRequest,PlaceRequest previousResourceRequest){	
		if(collectionItemDo!=null){
			if(forwardButtonHandler!=null||backwardButtonHandler!=null){
				forwardButtonHandler.removeHandler();
				backwardButtonHandler.removeHandler();
			}
			forwardButton.getElement().getStyle().clearDisplay();
			previewResouceWidget(collectionItemDo);
			
			forwardButtonHandler=forwardButton.addClickHandler(new ShowResourceView(nextResoruceRequest));
			backwardButtonHandler=backwardButton.addClickHandler(new ShowResourceView(previousResourceRequest));
		}
		
	}
	
	public void previewResouceWidget(CollectionItemDo collectionItemDo){
		resourceWidgetContainer.clear();
		String resourceTypeName=collectionItemDo.getResource().getResourceType().getName();
		if(resourceTypeName.equalsIgnoreCase("video/youtube")){
			resourceWidgetContainer.add(new FlashAndVideoPlayerWidget(ResourceImageUtil.getYoutubeVideoId(collectionItemDo.getResource().getUrl()), collectionItemDo.getStart(), collectionItemDo.getStop()));
		}else if(resourceTypeName.equalsIgnoreCase("animation/kmz")){
			resourceWidgetContainer.add(new GwtEarthWidget(collectionItemDo.getResource().getUrl()));
		}else if(resourceTypeName.equalsIgnoreCase("assessment-question")){
			getUiHandlers().showQuestionView(collectionItemDo);
		}else if(resourceTypeName.equalsIgnoreCase("resource/url")){
			if(collectionItemDo.getResource().getHasFrameBreaker()!=null&&collectionItemDo.getResource().getHasFrameBreaker().equals(true)){
				resourceWidgetContainer.add(new ResourceFrameBreakerView(collectionItemDo));
			}else{
				final WebResourceWidget webResourceWidget=new WebResourceWidget(collectionItemDo.getResource().getUrl());
				resourceWidgetContainer.add(webResourceWidget);
			}
		}else if(resourceTypeName.equalsIgnoreCase("textbook/scribd")){
			//TODO need to change urlll..., need to add api key also
			String signedFlag=collectionItemDo.getResource().getUrl().contains("http")||collectionItemDo.getResource().getUrl().contains("https")?"0":"1";
			String startPage=collectionItemDo.getStart()!=null?collectionItemDo.getStart():"1";
			resourceWidgetContainer.add(new WebResourceWidget(FlashAndVideoPlayerWidget.getProtocal()+"//dv.goorulearning.org/doc/a/view?startPage="+startPage+"&endPage=&signedFlag="+signedFlag+"&oid="+collectionItemDo.getResource().getGooruOid()+"&appKey=&url="+collectionItemDo.getResource().getUrl()));
		}
	}
	
	@Override
	public FlowPanel getResourceWidgetContainer(){
		return resourceWidgetContainer;
	}
	
	public class ShowResourceView implements ClickHandler{
		private PlaceRequest resourceRequest;
		public ShowResourceView(PlaceRequest resourceRequest){
			this.resourceRequest=resourceRequest;
		}
		@Override
		public void onClick(ClickEvent event) {
			AppClientFactory.getPlaceManager().revealPlace(false, resourceRequest,true);
		}
		
	}
}
