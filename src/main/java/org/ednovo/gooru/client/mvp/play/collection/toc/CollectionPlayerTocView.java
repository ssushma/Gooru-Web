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
package org.ednovo.gooru.client.mvp.play.collection.toc;

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.TocCollectionEndView;
import org.ednovo.gooru.client.uc.TocCollectionHomeView;
import org.ednovo.gooru.client.uc.TocResourceView;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionPlayerTocView extends BaseViewWithHandlers<CollectionPlayerTocUiHandlers> implements IsCollectionPlayerTocView{

	@UiField FlowPanel navgationTocContainer;
	
	private int selectedWidgetIndex=-1;
	
	private static CollectionPlayerTocViewUiBinder uiBinder = GWT.create(CollectionPlayerTocViewUiBinder.class);

	interface CollectionPlayerTocViewUiBinder extends UiBinder<Widget, CollectionPlayerTocView> {
	}
	
	@Inject
	public CollectionPlayerTocView(){
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setNavigationResources(CollectionDo collectionDo){
		if(collectionDo!=null){
			if(navgationTocContainer.getWidgetCount()==0){
				navgationTocContainer.clear();
				List<CollectionItemDo> collectionItems=collectionDo.getCollectionItems();
				navgationTocContainer.setWidth(collectionItems.size()*120+140+140+"px");
				TocCollectionHomeView tocCollectionHomeView=new TocCollectionHomeView(collectionDo.getThumbnails().getUrl());
				tocCollectionHomeView.addClickHandler(new PreviewCollectionHomeView(collectionDo.getGooruOid()));
				navgationTocContainer.add(tocCollectionHomeView);
				for(int i=0;i<collectionItems.size();i++){
					CollectionItemDo collectionItemDo=collectionItems.get(i);
					TocResourceView tocResoruceView=new TocResourceView(collectionItemDo);
					tocResoruceView.setCollectionItemId(collectionItemDo.getCollectionItemId());
					tocResoruceView.addClickHandler(new PreviewResourceView(collectionItemDo,collectionDo.getGooruOid()));
					navgationTocContainer.add(tocResoruceView);
				}
				TocCollectionEndView tocCollectionEndView=new TocCollectionEndView(collectionDo.getThumbnails().getUrl());
				tocCollectionEndView.addClickHandler(new PreviewCollectionEndView(collectionDo.getGooruOid()));
				navgationTocContainer.add(tocCollectionEndView);
			}
		}
	}
	@Override
	public void setResourceActive(String collectionId,String collectionItemid,boolean isCollectionHome){
		if(selectedWidgetIndex!=-1){
			Widget widget=navgationTocContainer.getWidget(selectedWidgetIndex);
			widget.removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().tocResourceSelected());
		}
		if(collectionItemid!=null){
			int widgetCount=navgationTocContainer.getWidgetCount();
			for(int i=0;i<widgetCount;i++){
				Widget widget=navgationTocContainer.getWidget(i);
				if(widget instanceof TocResourceView){
					TocResourceView resourceView=(TocResourceView)widget;
					if(collectionItemid.equals(resourceView.getCollectionItemId())){
						selectedWidgetIndex=i;
						resourceView.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().tocResourceSelected());
						return;
					}
				}
			}		
		}else if(isCollectionHome){
			selectedWidgetIndex=0;
			Widget widget=navgationTocContainer.getWidget(selectedWidgetIndex);
			widget.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().tocResourceSelected());
		}else{
			int widgetCount=navgationTocContainer.getWidgetCount();
			selectedWidgetIndex=widgetCount-1;
			Widget widget=navgationTocContainer.getWidget(selectedWidgetIndex);
			widget.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().tocResourceSelected());
		}
		
	}
	
	public class PreviewCollectionEndView implements ClickHandler{
		private String collectionId="";
		public PreviewCollectionEndView(String collectionId){
			this.collectionId=collectionId;
		}
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request=new PlaceRequest("p").with("id", collectionId).with("view", "end");
			AppClientFactory.getPlaceManager().revealPlace(false,request);
		}
	}
	
	public class PreviewCollectionHomeView implements ClickHandler{
		private String collectionId="";
		public PreviewCollectionHomeView(String collectionId){
			this.collectionId=collectionId;
		}
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request=new PlaceRequest("p").with("id", collectionId);
			AppClientFactory.getPlaceManager().revealPlace(false,request);
		}
	}
	
	public class PreviewResourceView implements ClickHandler{
		private CollectionItemDo collectionItemDo;
		private String collectionId;
		public PreviewResourceView(CollectionItemDo collectionItemDo,String collectionId){
			this.collectionItemDo=collectionItemDo;
			this.collectionId=collectionId;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(this.collectionItemDo.getNarration()!=null&&!this.collectionItemDo.getNarration().trim().equals("")){
				PlaceRequest request=new PlaceRequest("p").with("id", collectionId)
						.with("rid", this.collectionItemDo.getCollectionItemId())
						.with("tab", "narration");
				AppClientFactory.getPlaceManager().revealPlace(false,request);
			}else{
				PlaceRequest request=new PlaceRequest("p").with("id", collectionId).with("rid", this.collectionItemDo.getCollectionItemId());
				AppClientFactory.getPlaceManager().revealPlace(false,request);
			}
		}
	}
}
