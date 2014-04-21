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



import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TocResourceView extends Composite implements HasClickHandlers,MessageProperties{

	@UiField Image resourceThumbnail;
	@UiField Label resourceTypeImage;
	@UiField HTMLPanel resourceTitle;
	@UiField FlowPanel tocResourceImageContainer,tocResourceContainer;
	private CollectionItemDo collectionItemDo=null;
	
	private String collectionItemId=null;
	
	private HTML contentHtml=new HTML();
	
	private static TocResourceViewUiBinder uiBinder = GWT.create(TocResourceViewUiBinder.class);

	interface TocResourceViewUiBinder extends UiBinder<Widget, TocResourceView> {
	}
	
	public TocResourceView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public TocResourceView(CollectionItemDo collectionItemDo,Integer itemIndex,boolean showItemIndex){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		if(showItemIndex){
			setNavigationResourceTitle(collectionItemDo.getResource().getTitle(),itemIndex);
		}else{
			setNavigationResourceTitle(collectionItemDo.getResource().getTitle());
		}
		if(collectionItemDo.getResource().getResourceFormat()!=null){
			setResourceTypeIcon(collectionItemDo.getResource().getResourceFormat().getDisplayName());
		}
		setResourcePlayLink();
	}
	
	public void setResourceTitleColor(){
		contentHtml.getElement().getStyle().setColor("#515151");
	}
	
	@UiHandler("resourceThumbnail")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		
		resourceThumbnail.setUrl("images/resource_trans.png");
		if(collectionItemDo.getResource().getResourceFormat()!=null){
			resourceThumbnail.setStyleName(getResourceDefaultImage(collectionItemDo.getResource().getResourceFormat().getDisplayName()));
		}
	}
	
	@Override
	public void onLoad(){
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
			if(getQuestionImage()!=null && !getQuestionImage().equals("")){
				resourceThumbnail.setUrl(getQuestionImage());
			}
		}else if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("video/youtube")){
			resourceThumbnail.setUrl(ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(collectionItemDo.getResource().getUrl()),Window.Location.getProtocol()));
		}else{
			resourceThumbnail.setUrl(collectionItemDo.getResource().getThumbnails().getUrl());
		}
		
		if(resourceThumbnail.getUrl() == null || resourceThumbnail.getUrl().isEmpty())
		{

			resourceThumbnail.setUrl("images/resource_trans.png");
			if(collectionItemDo.getResource().getResourceFormat()!=null){
				resourceThumbnail.setStyleName(getResourceDefaultImage(collectionItemDo.getResource().getResourceFormat().getDisplayName()));
			}
		}

		
	}
	
	public void setResourcePlayLink(){
		Anchor resourceAnchor=new Anchor();
		resourceAnchor.setHref(getResourceLink());
		resourceAnchor.setStyleName("");
		resourceAnchor.getElement().appendChild(tocResourceImageContainer.getElement());
		tocResourceContainer.add(resourceAnchor);
	}
	public String getResourceLink(){
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
			String resourceLink="#"+viewToken+"&id="+collectionId+"&rid="+collectionItemDo.getCollectionItemId()+"&tab=narration";
			resourceLink += PreviewPlayerPresenter.setConceptPlayerParameters();
			return resourceLink;
		}else{
			String resourceLink="#"+viewToken+"&id="+collectionId+"&rid="+collectionItemDo.getCollectionItemId();
			resourceLink += PreviewPlayerPresenter.setConceptPlayerParameters();
			return resourceLink;
		}
	}
	
	public void setResourceTypeIcon(String category){
		resourceTypeImage.addStyleName(getResourceTypeImage(category));
	}
	
	public void setNavigationResourceTitle(String title){
		resourceTitle.add(getHTML(title));
	}
	public void setNavigationResourceTitle(String title,Integer itemIndex){
		resourceTitle.add(getHTML(itemIndex+". "+title));
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceType();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Webpage")){
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
		}else if(resourceType.equalsIgnoreCase("text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceType();
		}
		else if(resourceType.equalsIgnoreCase("image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceType();
		}
		else if(resourceType.equalsIgnoreCase("audio")){
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceType();
		}
		else if(resourceType.equalsIgnoreCase("other")){
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceType();
		}
		else if(resourceType.equalsIgnoreCase("exam")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();
		}
		else{
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();
		}
	
	}
	
	public String getResourceDefaultImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Webpage")){
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
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceDefault();
		}else if(resourceType.equalsIgnoreCase("image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("audio")) {
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("other")) {
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("exam")) {
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();
		}
		else{
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();
		}
	}

	public String getCollectionItemId() {
		return collectionItemId;
	}

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
		return thumbnailImage!=null?thumbnailImage:"";
	}
	
	private HTML getHTML(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		contentHtml.setHTML(html);
		contentHtml.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setEllipses());
		return contentHtml;
	}
	
}
