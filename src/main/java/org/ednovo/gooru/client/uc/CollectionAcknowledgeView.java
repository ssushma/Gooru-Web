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


import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
/**
 * @fileName : CollectionAcknowledgeView.java
 *
 * @description : This class is used to display the collection acknowledge view.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionAcknowledgeView extends Composite implements HasClickHandlers{

	
	@UiField FlowPanel acknowledgeContainer;
	
	private static BottomButtonViewUiBinder uiBinder = GWT.create(BottomButtonViewUiBinder.class);

	interface BottomButtonViewUiBinder extends UiBinder<Widget, CollectionAcknowledgeView> {
	}
	/**
	 * class constructor.
	 */
	public CollectionAcknowledgeView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiConstructor
	public CollectionAcknowledgeView(CollectionDo collectionDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		renderAcknowledgeResource(collectionDo);
	}
	/**
	 * @function renderAcknowledgeResource 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will render the resource acknowledge.
	 * 
	 * @parm(s) : @param collectionDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void renderAcknowledgeResource(CollectionDo collectionDo){
		if(collectionDo!=null&&collectionDo.getGooruOid()!=null){
			List<String> acknowldegeList=collectionDo.getMetaInfo().getAcknowledgement();
			for(int i=0;i<acknowldegeList.size();i++){
				String sourceName=acknowldegeList.get(i);
				sourceName=sourceName!=null?sourceName.trim():"";
				final FlowPanel resourceSourcesContainer=new FlowPanel();
				Label sourceNameLabel=getResourceNameLabel(sourceName);
				resourceSourcesContainer.add(sourceNameLabel);
				final FlowPanel resourceSourcesWidget=new FlowPanel();
				for(int itemsCount=0;itemsCount<collectionDo.getCollectionItems().size();itemsCount++){
					CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(itemsCount);
					String attribution=collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():null;
					if(attribution!=null&&attribution.trim().equalsIgnoreCase(sourceName)){
						TocResourceView ackResourceView=new TocResourceView(collectionItemDo);
						ackResourceView.addClickHandler(new PreviewResourceView(collectionItemDo, collectionDo.getGooruOid()));
						resourceSourcesWidget.add(ackResourceView);	
					}
				}
				resourceSourcesContainer.add(resourceSourcesWidget);
				acknowledgeContainer.add(resourceSourcesContainer);
				
			}
		}
	}
	/**
	 * @function getResourceNameLabel 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method will return the resource label.
	 * 
	 * @parm(s) : @param sourceName
	 * @parm(s) : @return
	 * 
	 * @return : Label
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private Label getResourceNameLabel(String sourceName){
		Label sourceNameText=new Label(sourceName);
		sourceNameText.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceSourceName());
		return sourceNameText;
	}
	/**
	 * This will add the click event.
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	/**
	 * This inner class is used to preview the resource.
	 */
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
