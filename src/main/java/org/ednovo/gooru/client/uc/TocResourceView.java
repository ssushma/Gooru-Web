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



import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.rating.events.OpenReviewPopUpEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsInRealTimeEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateRatingsInRealTimeHandler;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
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
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class TocResourceView extends Composite implements HasClickHandlers{

	@UiField Image resourceThumbnail;
	@UiField Label resourceTypeImage,resourceIndex,resourceCategory,resourceSourceName;
	@UiField HTMLPanel resourceTitle;
	@UiField HTML resourceHoverTitle;
	@UiField FlowPanel tocResourceImageContainer,tocResourceContainer,ratingWidgetPanel,resourceThumbnailContainer;
	private CollectionItemDo collectionItemDo=null;
	
	private String collectionItemId=null;
	
	private HTML contentHtml=new HTML();
	private RatingWidgetView ratingWidgetView=null;
	
	private static TocResourceViewUiBinder uiBinder = GWT.create(TocResourceViewUiBinder.class);

	interface TocResourceViewUiBinder extends UiBinder<Widget, TocResourceView> {
	}
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	
	public TocResourceView(){
		initWidget(uiBinder.createAndBindUi(this));
		tocResourceContainer.getElement().setId("fpnlTocResourceContainer");
		tocResourceImageContainer.getElement().setId("fpnlTocResourceImageContainer");
		resourceThumbnail.getElement().setId("imgResourceThumbnail");
		resourceTypeImage.getElement().setId("lblResourceTypeImage");
		resourceTitle.getElement().setId("pnlResourceTitle");
		resourceIndex.getElement().setId("lblResourceIndex");
		resourceHoverTitle.getElement().setId("htmlResourceHoverTitle");
		resourceCategory.getElement().setId("lblResourceCategory");
		resourceSourceName.getElement().setId("lblResourceSourceName");
		ratingWidgetPanel.getElement().setId("fpnlRatingWidgetPanel");
	}
	
	@UiConstructor
	public TocResourceView(CollectionItemDo collectionItemDo,Integer itemIndex,boolean showItemIndex, boolean addHyperlink){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		tocResourceContainer.getElement().setId("fpnlTocResourceContainer");
		tocResourceImageContainer.getElement().setId("fpnltocResourceImageContainer");
		resourceThumbnail.getElement().setId("imgResourceThumbnail");
		resourceTypeImage.getElement().setId("lblResourceTypeImage");
		resourceTitle.getElement().setId("pnlResourceTitle");
		resourceIndex.getElement().setId("lblResourceIndex");
		resourceHoverTitle.getElement().setId("htmlResourceHoverTitle");
		resourceCategory.getElement().setId("lblResourceCategory");
		resourceSourceName.getElement().setId("lblResourceSourceName");
		ratingWidgetPanel.getElement().setId("fpnlRatingWidgetPanel");
		if(showItemIndex){
			setNavigationResourceTitle(collectionItemDo.getResource().getTitle(),itemIndex);
		}else{
			setNavigationResourceTitle(collectionItemDo.getResource().getTitle());
		}
		if(collectionItemDo.getResource().getResourceFormat()!=null){
			setResourceTypeIcon(collectionItemDo.getResource().getResourceFormat().getDisplayName());
		}
		if(addHyperlink){
			//setResourcePlayLink();
		}else{
			//this.addClickHandler(new ResourceRequest());
		}
		setResourceSequence(itemIndex);
		setResourceCategory();
		setReourceSourceName();
		if(!AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.PREVIEW_PLAY)){
			setAvgRatingWidget();
		}
		AppClientFactory.getEventBus().addHandler(UpdateRatingsInRealTimeEvent.TYPE,setRatingWidgetMetaData);
		
	}
	/**
	 * Average star ratings widget will get integrated.
	 */
	private void setAvgRatingWidget() {
		ratingWidgetView=new RatingWidgetView();
		if(collectionItemDo.getResource().getRatings()!=null){
			ratingWidgetView.getRatingCountOpenBrace().setText(i18n. GL_SPL_OPEN_SMALL_BRACKET());
			ratingWidgetView.getRatingCountLabel().setText(collectionItemDo.getResource().getRatings().getCount()!=null ?collectionItemDo.getResource().getRatings().getCount().toString(): "0");
			ratingWidgetView.getRatingCountCloseBrace().setText(i18n. GL_SPL_CLOSE_SMALL_BRACKET());
			ratingWidgetView.setAvgStarRating(collectionItemDo.getResource().getRatings().getAverage());
		}
//		ratingWidgetView.getRatingCountLabel().addClickHandler(new ShowRatingPopupEvent());
		ratingWidgetPanel.add(ratingWidgetView);
	}

	/**
	 * 
	 * Inner class implementing {@link ClickEvent}
	 *
	 */
	private class ShowRatingPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			/**
			 * OnClick of count label event to invoke Review pop-pup
			 */
			AppClientFactory.fireEvent(new OpenReviewPopUpEvent(collectionItemDo.getResource().getGooruOid(),"",collectionItemDo.getResource().getUser().getUsername())); 
		}
	}

	public void setReourceSourceName(){
		if(collectionItemDo.getResource().getResourceSource()!=null){
			if((!collectionItemDo.getResource().getUrl().startsWith("https://docs.google.com"))&&(!collectionItemDo.getResource().getUrl().startsWith("http://docs.google.com"))){
			resourceSourceName.setText(collectionItemDo.getResource().getResourceSource().getAttribution()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():"");
			resourceTitle.getElement().setAttribute("alt", collectionItemDo.getResource().getResourceSource().getAttribution()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():"");
			resourceTitle.getElement().setAttribute("title", collectionItemDo.getResource().getResourceSource().getAttribution()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():"");
			}
			}else{
			resourceSourceName.setText("");
		}
		
	}
	public void setResourceCategory(){
		if(collectionItemDo.getResource().getResourceFormat()!=null){
			String resourceType=collectionItemDo.getResource().getResourceFormat().getDisplayName();
			resourceType=resourceType.toLowerCase();
			
			if(resourceType.equalsIgnoreCase("lesson")||resourceType.equalsIgnoreCase("textbook")||resourceType.equalsIgnoreCase("handout"))
			{
				resourceType=resourceType.replaceAll("lesson", "text").replaceAll("textbook", "text").replaceAll("handout", "text");
			}
			if(resourceType.equalsIgnoreCase("slide"))
			{
				resourceType=resourceType.replaceAll("slide","image");
			}
			if(resourceType.equalsIgnoreCase("exam")||resourceType.equalsIgnoreCase("website")|| resourceType.equalsIgnoreCase("challenge"))
			{
				resourceType=resourceType.replaceAll("exam","webpage").replaceAll("website","webpage").replaceAll("challenge","webpage");
			}
			resourceCategory.setText(resourceType);
			resourceCategory.getElement().setAttribute("alt", resourceType);
			resourceCategory.getElement().setAttribute("title", resourceType);
		}
	}
	public void setResourceSequence(int itemIndex){
		resourceIndex.setText(itemIndex<10?"0"+itemIndex:""+itemIndex);
		resourceIndex.getElement().setAttribute("alt", itemIndex<10?"0"+itemIndex:""+itemIndex);
		resourceIndex.getElement().setAttribute("title", itemIndex<10?"0"+itemIndex:""+itemIndex);
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
public class ResourceRequest implements ClickHandler{
	public void onClick(ClickEvent event){
		Map<String,String> params = new LinkedHashMap<String,String>();
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
			params.put("rid", collectionItemDo.getCollectionItemId());
			params.put("tab", "narration");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(viewToken, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}else{
			params.put("rid", collectionItemDo.getCollectionItemId());
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(viewToken, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}
	}

}
	
	
	public void setResourceTypeIcon(String category){
		resourceTypeImage.addStyleName(getResourceTypeImage(category));
	}
	
	public void setNavigationResourceTitle(String title){
		resourceTitle.add(getHTML(title));
		resourceTitle.getElement().setAttribute("alt", getHTML(title).toString());
		resourceTitle.getElement().setAttribute("title", ""+getHTML(title).toString());
		resourceHoverTitle.setHTML(getHTML(title).toString());
		resourceHoverTitle.getElement().setAttribute("alt", getHTML(title).toString());
		resourceHoverTitle.getElement().setAttribute("title", getHTML(title).toString());
	}
	public void setNavigationResourceTitle(String title,Integer itemIndex){
		resourceTitle.add(getHTML(itemIndex+""));
		resourceTitle.getElement().setAttribute("alt", itemIndex+". "+title);
		resourceTitle.getElement().setAttribute("title", itemIndex+". "+title);
		resourceHoverTitle.setHTML(title.toString());
		resourceHoverTitle.getElement().setAttribute("alt", title.toString());
		resourceHoverTitle.getElement().setAttribute("title", title.toString());
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
		return thumbnailImage!=null?thumbnailImage:"images/defaultRes.png";
	}
	
	private HTML getHTML(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		contentHtml.setHTML(html);
		contentHtml.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sequenceNumber());
		return contentHtml;
	}
	
	public void hideResourceThumbnailContainer(boolean hide){
		if(hide){
			resourceThumbnailContainer.setVisible(false);
		}else{
			resourceThumbnailContainer.setVisible(true);
		}
	}
	
	UpdateRatingsInRealTimeHandler setRatingWidgetMetaData = new UpdateRatingsInRealTimeHandler() {	
		
		@Override
		public void updateRatingInRealTime(String gooruOid, double average,Integer count) {
			if(collectionItemDo.getResource()!=null){
				if(collectionItemDo.getResource().getGooruOid().equals(gooruOid)){
					ratingWidgetView.getRatingCountLabel().setText(count.toString()); 
					ratingWidgetView.setAvgStarRating(average);
				}
			}
		}
	};
}
