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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.home.ResourceCurosal;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.TocCollectionEndView;
import org.ednovo.gooru.client.uc.TocCollectionHomeView;
import org.ednovo.gooru.client.uc.TocResourceView;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionPlayerTocView extends BaseViewWithHandlers<CollectionPlayerTocUiHandlers> implements IsCollectionPlayerTocView,MessageProperties{

	@UiField FlowPanel navgationTocContainer;
	@UiField Label previousButton,nextButton,hideText;
	
	@UiField HTMLEventPanel hideButton;
	
	private int selectedWidgetIndex=-1;
	
	private static CollectionPlayerTocViewUiBinder uiBinder = GWT.create(CollectionPlayerTocViewUiBinder.class);

	interface CollectionPlayerTocViewUiBinder extends UiBinder<Widget, CollectionPlayerTocView> {
	}
	
	@Inject
	public CollectionPlayerTocView(){
		setWidget(uiBinder.createAndBindUi(this));
		hideText.setText(GL0592);
	}
	public void clearNavigationPanel(){
		navgationTocContainer.clear();
	}
	@Override
	public void setNavigationResources(CollectionDo collectionDo){
		int resourcesSize=collectionDo.getCollectionItems()!=null?collectionDo.getCollectionItems().size():0;
		if(collectionDo!=null){
			if(navgationTocContainer.getWidgetCount()==0){
				navgationTocContainer.clear();
				nextButton.setVisible(true);
				previousButton.setVisible(true);
				List<CollectionItemDo> collectionItems=collectionDo.getCollectionItems();
			
				TocCollectionHomeView tocCollectionHomeView=new TocCollectionHomeView(collectionDo.getThumbnails().getUrl());
				navgationTocContainer.add(tocCollectionHomeView);
				for(int i=0;i<collectionItems.size();i++){
					CollectionItemDo collectionItemDo=collectionItems.get(i);
					TocResourceView tocResoruceView=new TocResourceView(collectionItemDo,i+1,true);
					tocResoruceView.setCollectionItemId(collectionItemDo.getCollectionItemId());
					navgationTocContainer.add(tocResoruceView);
				}
				TocCollectionEndView tocCollectionEndView=new TocCollectionEndView(collectionDo.getThumbnails().getUrl());
				navgationTocContainer.add(tocCollectionEndView);
				if(resourcesSize>6){
					new ResourceCurosal(nextButton, previousButton, navgationTocContainer, resourcesSize, 120);
				}
				//resources width with padding and margin constitutes 102px for each and collection home and end with padding and margin width
				//have 150px each. navgationTocContainer width is derived from this.
				if(resourcesSize>0)
				{
				navgationTocContainer.getElement().setAttribute("style", "width:"+((resourcesSize*(102))+300)+"px !important;");
				}
				else
				{
					nextButton.setVisible(false);
					previousButton.setVisible(false);
				navgationTocContainer.getElement().setAttribute("style", "width:"+(300)+"px !important;");
				}
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
	
	/**
	 * 
	 * @function onhideBtnClicked 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("hideButton")
	public void onhideBtnClicked(ClickEvent clickEvent) 
	{
		PlaceRequest collectionRequest = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
		String collectionId = collectionRequest.getParameter("id", null);
		String collectionItemId = collectionRequest.getParameter("rid", null);
		String chkViewParam = collectionRequest.getParameter("view", null);
		
		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		
	if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.RESOURCE_PLAY))
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.RESOURCE_PLAY).
				with("id", collectionId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam == null && collectionItemId != null)
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId).with("rid", collectionItemId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam == null && collectionItemId != null)
	{
		params.put("rid", collectionItemId);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam == null && collectionItemId == null)
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam == null && collectionItemId == null)
	{
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam.equalsIgnoreCase("end"))
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId).with("view", "end");
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam.equalsIgnoreCase("end"))
	{
		params.put("view", "end");
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);

	}
	}

	

	
}
