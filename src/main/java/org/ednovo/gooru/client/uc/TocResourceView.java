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



import org.ednovo.gooru.shared.model.content.CollectionItemDo;

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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : TocResourceView.java
 *
 * @description : This class is used to display the toc resource view.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class TocResourceView extends Composite implements HasClickHandlers{

	@UiField Image resourceThumbnail;
	@UiField Label resourceTypeImage;
	@UiField HTMLPanel resourceTitle;
	private CollectionItemDo collectionItemDo=null;
	
	private String collectionItemId=null;
	
	private static TocResourceViewUiBinder uiBinder = GWT.create(TocResourceViewUiBinder.class);

	interface TocResourceViewUiBinder extends UiBinder<Widget, TocResourceView> {
	}
	/**
	 * Class constructor.
	 */
	public TocResourceView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public TocResourceView(CollectionItemDo collectionItemDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		setNavigationResourceTitle(collectionItemDo.getResource().getTitle());
		setResourceTypeIcon(collectionItemDo.getResource().getCategory());
	}
	/**
	 * This will handle the error event on resource thumbnail.
	 */
	@UiHandler("resourceThumbnail")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		resourceThumbnail.setUrl("images/resource_trans.png");
		resourceThumbnail.setStyleName(getResourceDefaultImage(collectionItemDo.getResource().getCategory()));
	}
	
	@Override
	public void onLoad(){
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
			resourceThumbnail.setUrl(getQuestionImage());
		}else{
			resourceThumbnail.setUrl(collectionItemDo.getResource().getThumbnails().getUrl());
		}
	}
	/**
	 * This will set the resource type icon.
	 */
	public void setResourceTypeIcon(String category){
		resourceTypeImage.addStyleName(getResourceTypeImage(category));
	}
	/**
	 * This will set the navigation resource title.
	 */
	public void setNavigationResourceTitle(String title){
		resourceTitle.add(getHTML(title));
	}
	/**
	 * this will add the click event.
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	/**
	 * This will return the resoruce type image.
	 */
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceType();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceType();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceType();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceType();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceType();
		}
	}
	/**
	 * 
	 * @function getResourceDefaultImage 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will return the resource default images.
	 * 
	 * 
	 * @parm(s) : @param resourceType
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getResourceDefaultImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceDefault();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceDefault();
		}
	}
	/**
	 * 
	 * @function getCollectionItemId 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will return the collection item id.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getCollectionItemId() {
		return collectionItemId;
	}
	/**
	 * 
	 * @function setCollectionItemId 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This will set the collection item id.
	 * 
	 * 
	 * @parm(s) : @param collectionItemId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setCollectionItemId(String collectionItemId) {
		this.collectionItemId = collectionItemId;
	}
	
	private String getQuestionImage(){
		String thumbnailImage="";
		String assetName="";
		try{
			if(collectionItemDo.getResource().getAssets()!=null&&collectionItemDo.getResource().getAssets().size()>0){
				assetName=collectionItemDo.getResource().getAssets().get(0).getAsset().getName();
				thumbnailImage=collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+assetName;
			}else{
				thumbnailImage=collectionItemDo.getResource().getThumbnails().getUrl();
			}
		}catch(Exception e){
			
		}
		return thumbnailImage;
	}
	
	private HTML getHTML(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		HTML contentHtml=new HTML(html);
		contentHtml.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setEllipses());
		return contentHtml;
	}
	
}
