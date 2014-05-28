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


import java.util.Date;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.play.collection.body.GwtEarthWidget;
import org.ednovo.gooru.client.mvp.play.collection.preview.metadata.NavigationConfirmPopup;
import org.ednovo.gooru.client.mvp.play.resource.framebreaker.ResourceFrameBreakerView;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceRatingCountEvent;
import org.ednovo.gooru.client.uc.StarRatingsUc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ReactionDo;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;
import org.ednovo.gooru.shared.util.UAgentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourcePlayerMetadataView extends BaseViewWithHandlers<ResourcePlayerMetadataUiHandlers> implements IsResourcePlayerMetadataView, MessageProperties{

	@UiField FlowPanel resourceWidgetContainer;
	@UiField
	static FlowPanel wrapperContainerField;
	@UiField Button forwardButton,backwardButton,selectedEmoticButton,canExplainEmoticButton,understandEmoticButton,mehEmoticButton,doNotUnderstandEmoticButton,needHelpButton;
	@UiField HTMLEventPanel emoticsContainer;
	@UiField HTMLPanel allEmoticsContainer,singleEmoticsContainer,collectionContainer,ratingsContainer;
	@UiField Label resourcePublisher,reactionToolTipOne,reactionToolTipTwo,reactionToolTipThree,reactionToolTipFour,reactionToolTipFive,mouseOverStarValue,starValue;
	@UiField
	static ResourcePlayerMetadataBundle playerStyle;
	@UiField HTML resourceTitleLbl;
	
//	@UiField(provided = true)
	@UiField InlineHTML one_star,two_star,three_star,four_star,five_star;
	
	/*@UiField SimpleRadioButton rating1;
	@UiField SimpleRadioButton rating2;
	@UiField SimpleRadioButton rating3;
	@UiField SimpleRadioButton rating4;
	@UiField SimpleRadioButton rating5;*/
	
	/*@UiField SimpleCheckBox starFive,starFour,starThree,starTwo,starOne;*/
	
	/*@UiField  StarRatingsUc starRatings;*/

	HandlerRegistration forwardButtonHandler=null, backwardButtonHandler=null;
	
	private static final String REACTION_CAN_UNDERSTAND = "i-can-understand";
	private static final String REACTION_CAN_EXPLAIN = "i-can-explain";
	private static final String REACTION_MEH = "meh";
	private static final String REACTION_DONOT_UNDERSTAND = "i-donot-understand";
	private static final String REACTION_NEED_HELP = "i-need-help";
	private static final String CREATE_PREVIEW_PLAYER_REACTION = "create-reaction-preview";
	private static final String CREATE_STUDY_PLAYER_REACTION = "create-reaction";
	private boolean isCanUnderstandSelected=false;
	private boolean isCanExplainSelected=false;
	private boolean isMehSelected=false;
	private boolean isDoNotUnderstandSelected=false;
	private boolean isNeedHelpSelected=false;
	private CollectionItemDo collectionItemDo=null;
	private String gooruReactionId="";
	private UserStarRatingsWidget userStarRatings = null;
	
	private static final String ONE_STAR="oneStar";
	private static final String TWO_STAR="twoStar";
	private static final String THREE_STAR="threeStar";
	private static final String FOUR_STAR="fourStar";
	private static final String FIVE_STAR="fiveStar";
	
	private static final String POOR="Poor";
	private static final String FAIR="Fair";
	private static final String GOOD="Good";
	private static final String VERY_GOOD="Very Good";
	private static final String EXCELLENT="Excellent";
	private static final String REACTIONS_WIDGET="Contentreactions";
	private static final String RATINGS_WIDGET="Contentratings";
	private static final int CHILD_AGE=13;
	private static final String DEFAULT_RATING_TEXT="Rate this resource";
	private StarRatingsDo starRatingsDo;
	
	private static final String FILLED_BLUE = "filled filledBlue";
	ThankYouResourceStarRatings thankYouResourceStarRatings;
	RatingsConfirmationPopup ratingsConfirmationPopup;
	private boolean isRated=false,isFromThanksPopup=false;
	String assocGooruOId;
	Integer score,count;
	double average;
	
	int currentRating=0;
	
	private static ResourcePlayerMetadataViewUiBinder uiBinder = GWT.create(ResourcePlayerMetadataViewUiBinder.class);

	interface ResourcePlayerMetadataViewUiBinder extends UiBinder<Widget, ResourcePlayerMetadataView> {
	}
	
//	@UiFactory
//	public SimpleRadioButton createRadioButton() {
//	    return new SimpleRadioButton("");
//	}

	@Inject
	public ResourcePlayerMetadataView(){
		
//		one_star = new SimpleRadioButton("");
//		two_star = new SimpleRadioButton("");
//		three_star = new SimpleRadioButton("");
//		four_star = new SimpleRadioButton("");
//		five_star = new SimpleRadioButton("");
		
		setWidget(uiBinder.createAndBindUi(this));
		allEmoticsContainer.getElement().getStyle().setDisplay(Display.NONE);
		singleEmoticsContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		emoticsContainer.addMouseOverHandler(new OnEmoticsMouseOver());
		emoticsContainer.addMouseOutHandler(new OnEmoticsMouseOut());
		reactionToolTipOne.setText(GL0581); 
		reactionToolTipTwo.setText(GL0582); 
		reactionToolTipThree.setText(GL0583); 
		reactionToolTipFour.setText(GL0584); 
		reactionToolTipFive.setText(GL0585); 
		
		/*rating1 = new SimpleRadioButton("rating");
		rating2 = new SimpleRadioButton("rating");
		rating3 = new SimpleRadioButton("rating");
		rating4 = new SimpleRadioButton("rating");
		rating5 = new SimpleRadioButton("rating");*/
		
//		starValue.setVisible(false);
		starValue.setVisible(true);
		starValue.setText(GL1879);
		
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
			emoticsContainer.removeFromParent();
			resourceTitleLbl.setVisible(false);
			resourcePublisher.setVisible(false);
			ratingsContainer.getElement().getStyle().setFloat(Float.RIGHT);
			ratingsContainer.getElement().getStyle().setMarginRight(430,Unit.PX);
//			collectionContainer.getElement().getStyle().setDisplay(Display.NONE);
		}else{
			resourceTitleLbl.setVisible(true);
			resourcePublisher.setVisible(true);
		}
		
		  Boolean isIpad = !!Navigator.getUserAgent().matches("(.*)iPad(.*)");
		  Boolean isWinDskp = !!Navigator.getUserAgent().matches("(.*)NT(.*)");
		  
		  UAgentInfo detector = new UAgentInfo(Navigator.getUserAgent());
		  
		  if(isIpad && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  wrapperContainerField.getElement().setAttribute("style", "margin-top:0px;");
			 
		  }
		  else if(detector.detectMobileQuick() && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  wrapperContainerField.getElement().setAttribute("style", "margin-top:0px;");
		  }
		  else
		  {
			  wrapperContainerField.getElement().setAttribute("style", "margin-top:50px;");
			  
		  }
		  
			one_star.addMouseOverHandler(new OnStarMouseOver(ONE_STAR));
			two_star.addMouseOverHandler(new OnStarMouseOver(TWO_STAR));
			three_star.addMouseOverHandler(new OnStarMouseOver(THREE_STAR));
			four_star.addMouseOverHandler(new OnStarMouseOver(FOUR_STAR));
			five_star.addMouseOverHandler(new OnStarMouseOver(FIVE_STAR));
			
			one_star.addMouseOutHandler(new OnStarMouseOut(ONE_STAR));
			two_star.addMouseOutHandler(new OnStarMouseOut(TWO_STAR));
			three_star.addMouseOutHandler(new OnStarMouseOut(THREE_STAR));
			four_star.addMouseOutHandler(new OnStarMouseOut(FOUR_STAR));
			five_star.addMouseOutHandler(new OnStarMouseOut(FIVE_STAR));
		
	}

	public void showResourceWidget(CollectionItemDo collectionItemDo){
		this.collectionItemDo = collectionItemDo;
		if(collectionItemDo.getResource().getTitle()!=null){
			resourceTitleLbl.setHTML(removeHtmlTags(collectionItemDo.getResource().getTitle()));
		}else{
			resourceTitleLbl.setHTML("");
		}
		getUiHandlers().setResourceMetaData(resourceTitleLbl.getHTML());
		if(collectionItemDo.getResource().getResourceSource()!=null){
			String attributionName=collectionItemDo.getResource().getResourceSource().getAttribution();
			attributionName = attributionName.trim();
			if(attributionName != null && !attributionName.equals("") && !attributionName.equals("null")){
				String resourceSource=collectionItemDo.getResource().getResourceSource().getAttribution();
				if((!collectionItemDo.getResource().getUrl().startsWith("https://docs.google.com"))&&(!collectionItemDo.getResource().getUrl().startsWith("http://docs.google.com"))){
					if(resourceSource.length() > 100){
					resourcePublisher.setText(GL0566+resourceSource.substring(0, 100)+"...");
					}else{
						resourcePublisher.setText(GL0566+resourceSource);
					}
				}else
				{
				resourcePublisher.setText("");	
				}
			}else{
				resourcePublisher.setText("");
			}
		}else{
			resourcePublisher.setText("");
		}

		if(forwardButton!=null){
			forwardButton.removeFromParent();
		}
		if(backwardButton!=null){
			backwardButton.removeFromParent();
		}
		previewResouceWidget(collectionItemDo);
	}

	public void showResourceWidget(PlaceRequest previousResourceRequest){	
		
		collectionContainer.setVisible(false);
		
		if(forwardButtonHandler!=null||backwardButtonHandler!=null){
			forwardButtonHandler.removeHandler();
			backwardButtonHandler.removeHandler();
		}
		forwardButton.getElement().getStyle().setDisplay(Display.NONE);
		forwardButtonHandler=forwardButton.addClickHandler(new ShowResourceView(previousResourceRequest));
		backwardButtonHandler=backwardButton.addClickHandler(new ShowResourceView(previousResourceRequest));
	}

	public void showResourceWidget(CollectionItemDo collectionItemDo,PlaceRequest nextResoruceRequest,PlaceRequest previousResourceRequest){ 
		if(AppClientFactory.isAnonymous()){
			setDefaultReaction();
		}
		if(collectionItemDo!=null){
			collectionContainer.setVisible(true);
			this.collectionItemDo = collectionItemDo;
			if(collectionItemDo.getResource().getTitle()!=null){
				int sequenceNumber=collectionItemDo.getItemSequence();
				resourceTitleLbl.setHTML(sequenceNumber+". "+removeHtmlTags(collectionItemDo.getResource().getTitle()));
			}else{
				resourceTitleLbl.setHTML("");
			}
			getUiHandlers().setResourceMetaData(resourceTitleLbl.getHTML());
			if(collectionItemDo.getResource().getResourceSource()!=null){
				if(collectionItemDo.getResource().getResourceSource().getAttribution()!=null){
					String resourceSource=collectionItemDo.getResource().getResourceSource().getAttribution();
					resourceSource = resourceSource.trim();
					if(resourceSource != null && !resourceSource.equals("") && !resourceSource.equals("null")){
						if((!collectionItemDo.getResource().getUrl().startsWith("https://docs.google.com"))&&(!collectionItemDo.getResource().getUrl().startsWith("http://docs.google.com"))){
							if(resourceSource.length() > 100){
							resourcePublisher.setText(GL0566+resourceSource.substring(0, 100)+"...");
							}else{
								resourcePublisher.setText(GL0566+resourceSource);
							}
						}else{resourcePublisher.setText("");
						}
					}else{
						resourcePublisher.setText("");
					}
				}else{
					resourcePublisher.setText("");
				}
			}else{
				resourcePublisher.setText("");
			}

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
		wrapperContainerField.getElement().getStyle().clearHeight();
		if(resourceTypeName.equalsIgnoreCase("video/youtube")){
			wrapperContainerField.getElement().getStyle().setHeight(525	, Unit.PX);
			resourceWidgetContainer.add(new FlashAndVideoPlayerWidget(ResourceImageUtil.getYoutubeVideoId(collectionItemDo.getResource().getUrl()), collectionItemDo.getStart(), collectionItemDo.getStop()));
		}else if(resourceTypeName.equalsIgnoreCase("animation/kmz")){
			resourceWidgetContainer.add(new GwtEarthWidget(collectionItemDo.getResource().getUrl()));
		}else if(resourceTypeName.equalsIgnoreCase("assessment-question")){
			getUiHandlers().showQuestionView(collectionItemDo);
		}else if(resourceTypeName.equalsIgnoreCase("resource/url")||resourceTypeName.equalsIgnoreCase("image/png")){
			if(collectionItemDo.getResource().getHasFrameBreaker()!=null&&collectionItemDo.getResource().getHasFrameBreaker().equals(true)||isProtocolMatched(collectionItemDo.getResource().getUrl())){
				resourceWidgetContainer.add(new ResourceFrameBreakerView(collectionItemDo));
			}else{
				if(resourceTypeName.equalsIgnoreCase("image/png")){
					final WebResourceWidget webResourceWidget=new WebResourceWidget(collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+collectionItemDo.getResource().getUrl());
					resourceWidgetContainer.add(webResourceWidget);
				}
				else{
					if(!collectionItemDo.getResource().getUrl().startsWith("http"))
					{
						collectionItemDo.getResource().setUrl(collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+collectionItemDo.getResource().getUrl());
					}
					final WebResourceWidget webResourceWidget=new WebResourceWidget(collectionItemDo.getResource().getUrl());
					resourceWidgetContainer.add(webResourceWidget);
				}
			}
		}else {
			String[] urlFormat = collectionItemDo.getResource().getUrl().split("\\.");
			String urlExtension = urlFormat[urlFormat.length - 1];
			if(urlExtension.equalsIgnoreCase("pdf")){
				String resourceSourceUrl="";
				if(!collectionItemDo.getResource().getUrl().substring(0, 4).equalsIgnoreCase("http")){
//					resourceSourceUrl = URL.encode(collectionItemDo.getResource().getUrl()).replaceAll("\\+", "%20");
					resourceSourceUrl = collectionItemDo.getResource().getUrl();
					resourceSourceUrl=collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+resourceSourceUrl;
				}else{
					resourceSourceUrl=collectionItemDo.getResource().getUrl();
				}
				String signedFlag=resourceSourceUrl.contains("http")||resourceSourceUrl.contains("https")?"0":"1";
				String startPage=collectionItemDo.getStart()!=null?collectionItemDo.getStart():"1";
				resourceWidgetContainer.add(new WebResourceWidget(AppClientFactory.getLoggedInUser().getSettings().getDocViewerHome()+"?startPage="+startPage+"&endPage=&signedFlag="+signedFlag+"&oid="+collectionItemDo.getResource().getGooruOid()+"&appKey="+AppClientFactory.getLoggedInUser().getSettings().getDocViewerPoint()+"&url="+resourceSourceUrl));
			}
		}
	}
	
	/**
	 * On click, "canExplain" emotic will be set for a resource, provided user should be logged in or it demands for log in.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("canExplainEmoticButton")
	public void clickOnCanExplainEmoticButtonEmotic(ClickEvent clickEvent){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(REACTIONS_WIDGET);
		}else{
			if(isCanExplainSelected){
				canExplainEmoticButton.setStyleName(playerStyle.spriteType());
				canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
				getUiHandlers().deleteReaction(gooruReactionId);
				deleteReactionTriggerEvent();
				setDefaultReaction();
			}else{
				canExplainEmoticButton.setStyleName(playerStyle.spriteType());
				canExplainEmoticButton.addStyleName(playerStyle.emoticon_vi());
				deleteReactionTriggerEvent();
				createReaction(collectionItemDo.getResource().getGooruOid(),REACTION_CAN_EXPLAIN,gooruReactionId,AppClientFactory.getPlaceManager().getRequestParameter("id"),AppClientFactory.getCurrentPlaceToken());
				getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_CAN_EXPLAIN,PlayerDataLogEvents.REACTION_CREATE);
			}
			 
		}
		
	}
	
	/**
	 * On click, "understand" emotic will be set for a resource, provided user should be logged in or it demands for log in.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("understandEmoticButton")
	public void clickOnUnderstandEmotic(ClickEvent clickEvent){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(REACTIONS_WIDGET);
		}else{
			/**
			 * If user clicks on selected emotic again, it will de-select and will call delete API, else it will highlight the selected emotic 
			 * and call Create API.
			 */
			if(isCanUnderstandSelected){
				understandEmoticButton.setStyleName(playerStyle.spriteType());
				understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
				getUiHandlers().deleteReaction(gooruReactionId);
				deleteReactionTriggerEvent();
				setDefaultReaction();
			}else{
				understandEmoticButton.setStyleName(playerStyle.spriteType());
				understandEmoticButton.addStyleName(playerStyle.emoticon_vii());
				deleteReactionTriggerEvent();
				createReaction(collectionItemDo.getResource().getGooruOid(),REACTION_CAN_UNDERSTAND,gooruReactionId,AppClientFactory.getPlaceManager().getRequestParameter("id"),AppClientFactory.getCurrentPlaceToken());
				getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_CAN_UNDERSTAND,PlayerDataLogEvents.REACTION_CREATE);
			}
		}
		
	}
	
	/**
	 * On click,"meh" emotic will be set for a resource, provided user should be logged in or it demands for log in.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("mehEmoticButton")
	public void clickOnMehEmoticButton(ClickEvent clickEvent){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(REACTIONS_WIDGET);
		}else{
			/**
			 * If user clicks on selected emotic again, it will de-select and will call delete API, else it will highlight the selected emotic 
			 * and call Create API.
			 */
			if(isMehSelected){
				mehEmoticButton.setStyleName(playerStyle.spriteType());
				mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
				getUiHandlers().deleteReaction(gooruReactionId);
				deleteReactionTriggerEvent();
				setDefaultReaction();
			}else{
				mehEmoticButton.setStyleName(playerStyle.spriteType());
				mehEmoticButton.addStyleName(playerStyle.emoticon_v());
				deleteReactionTriggerEvent();
				createReaction(collectionItemDo.getResource().getGooruOid(),REACTION_MEH,gooruReactionId,AppClientFactory.getPlaceManager().getRequestParameter("id"),AppClientFactory.getCurrentPlaceToken());
				getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_MEH,PlayerDataLogEvents.REACTION_CREATE);
			}
			
		}
		
	}
	
	/**
	 * On click, "doNotUnderstand" emotic will be set for a resource, provided user should be logged in or it demands for log in.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("doNotUnderstandEmoticButton")
	public void clickOnDoNotUnderstandEmoticButton(ClickEvent clickEvent){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(REACTIONS_WIDGET);
		}else{
			/**
			 * If user clicks on selected emotic again, it will de-select and will call delete API, else it will highlight the selected emotic 
			 * and call Create API.
			 */
			if(isDoNotUnderstandSelected){
				doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
				doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
				getUiHandlers().deleteReaction(gooruReactionId);
				deleteReactionTriggerEvent();
				setDefaultReaction();
			}else{
				doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
				doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_ix());
				deleteReactionTriggerEvent();
				createReaction(collectionItemDo.getResource().getGooruOid(),REACTION_DONOT_UNDERSTAND,gooruReactionId,AppClientFactory.getPlaceManager().getRequestParameter("id"),AppClientFactory.getCurrentPlaceToken());
				getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_DONOT_UNDERSTAND,PlayerDataLogEvents.REACTION_CREATE);
			}
		}
	}
	
	/**
	 * On click, "needHelp" emotic will be set for a resource, provided user should be logged in or it demands for log in.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("needHelpButton")
	public void clickOnNeedHelpButtonEmoticButton(ClickEvent clickEvent){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(REACTIONS_WIDGET);
		}else{
			/**
			 * If user clicks on selected emotic again, it will de-select and will call delete API, else it will highlight the selected emotic 
			 * and call Create API.
			 */
			if(isNeedHelpSelected){
				needHelpButton.setStyleName(playerStyle.spriteType());
				needHelpButton.addStyleName(playerStyle.emoticon_iv());
				deleteReactionTriggerEvent();
				getUiHandlers().deleteReaction(gooruReactionId);
				setDefaultReaction();
			}else{
				needHelpButton.setStyleName(playerStyle.spriteType());
				needHelpButton.addStyleName(playerStyle.emoticon_x());
				deleteReactionTriggerEvent();
				createReaction(collectionItemDo.getResource().getGooruOid(),REACTION_NEED_HELP,gooruReactionId,AppClientFactory.getPlaceManager().getRequestParameter("id"),AppClientFactory.getCurrentPlaceToken());
				getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_NEED_HELP,PlayerDataLogEvents.REACTION_CREATE);
			}
		}
	}

	public void deleteReactionTriggerEvent(){
		if(isCanUnderstandSelected){
			getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_CAN_UNDERSTAND,PlayerDataLogEvents.REACTION_DELETE);
		}else if(isCanExplainSelected){
			getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_CAN_EXPLAIN,PlayerDataLogEvents.REACTION_DELETE);
		}else if(isDoNotUnderstandSelected){
			getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_DONOT_UNDERSTAND,PlayerDataLogEvents.REACTION_DELETE);
		}else if(isMehSelected){
			getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_MEH,PlayerDataLogEvents.REACTION_DELETE);
		}else if(isNeedHelpSelected){
			getUiHandlers().triggerCreateReactionEvent(collectionItemDo.getResource().getGooruOid(), REACTION_NEED_HELP,PlayerDataLogEvents.REACTION_DELETE);
		}
	}
	private void showLoginPopupWidget(String widgetType) { 
		LoginPopupUc popup =new LoginPopupUc();
		if(widgetType.equals(REACTIONS_WIDGET)){
			popup.setWidgetMode("reactionWidget");
		}else if(widgetType.equals(RATINGS_WIDGET)){
			popup.setWidgetMode("ratingWidget");
		}
		
		popup.setGlassEnabled(true);
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
			if(!getUiHandlers().isOeAnswerSubmited()){
				NavigationConfirmPopup confirmPopup=new NavigationConfirmPopup() {
					@Override
					public void navigateToNextResource() {
						super.hide();
						AppClientFactory.getPlaceManager().revealPlace(false, resourceRequest,true);
					}
				};
			}else{
				AppClientFactory.getPlaceManager().revealPlace(false, resourceRequest,true);
			}
		}
	}

	/*
	 * Inner Class
	 */
	public class OnEmoticsMouseOver implements MouseOverHandler{

		/**
		 * On mouse over emotics options will be shown for the user.  
		 */
		
		@Override
		public void onMouseOver(MouseOverEvent event) {
			allEmoticsContainer.getElement().getStyle().setDisplay(Display.BLOCK);
			singleEmoticsContainer.getElement().getStyle().setDisplay(Display.NONE);
			
			/**
			 * On mouse over if user selected any emotic, selected emotic will be highlighted.
			 * Note: selected emotic will be differntiated based on respective emotic flag.
			 */
			
			if(isCanExplainSelected){
				canExplainEmoticButton.setStyleName(playerStyle.spriteType());
				canExplainEmoticButton.addStyleName(playerStyle.emoticon_vi());
			}else if(isCanUnderstandSelected){
				understandEmoticButton.setStyleName(playerStyle.spriteType());
				understandEmoticButton.addStyleName(playerStyle.emoticon_vii());
			}else if(isMehSelected){
				mehEmoticButton.setStyleName(playerStyle.spriteType());
				mehEmoticButton.addStyleName(playerStyle.emoticon_v());
			}else if(isDoNotUnderstandSelected){
				doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
				doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_ix());
			}else if(isNeedHelpSelected){
				needHelpButton.setStyleName(playerStyle.spriteType());
				needHelpButton.addStyleName(playerStyle.emoticon_x());
			}
		}

	}

	/*
	 * Inner Class
	 */
	public class OnEmoticsMouseOut implements MouseOutHandler{
		
		/**
		 * On mouse out only selected emotic will be visible.
		 */
		@Override
		public void onMouseOut(MouseOutEvent event) {
			allEmoticsContainer.getElement().getStyle().setDisplay(Display.NONE);
			singleEmoticsContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		}
	}

	/**
	 * Sets the emotics for respective resource.
	 * 
	 * @param reactionDo {@link ReactionDo}
	 * @param gooruReactionId {@link String}
	 */
	
	@Override
	public void setReaction(ReactionDo reactionDo,String gooruReactionId) {
		this.gooruReactionId=gooruReactionId;
		if(reactionDo.getReactionText().equalsIgnoreCase(REACTION_CAN_EXPLAIN)){
			selectedEmoticButton.setStyleName(playerStyle.spriteType());
			selectedEmoticButton.addStyleName(playerStyle.emoticon_vi());
			isCanExplainSelected=true;
			
			/**
			 * Except "can explain" emotic, all other will be changed to normal emotics.
			 * Note: this changes is made to achieve when user tries to select multiple emotic, previously selected emotic shld be removed.
			 */
			understandEmoticButton.setStyleName(playerStyle.spriteType());
			understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
			
			mehEmoticButton.setStyleName(playerStyle.spriteType());
			mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
			
			doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
			doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
			
			needHelpButton.setStyleName(playerStyle.spriteType());
			needHelpButton.addStyleName(playerStyle.emoticon_iv());
			
			/**
			 * Except can explain emotic flag, all other emotic flag set to false, based on this again on mouse over previously selected will be removed.
			 * 
			 */
			isCanUnderstandSelected=false;
			isMehSelected=false;
			isDoNotUnderstandSelected=false;
			isNeedHelpSelected=false;
		}else if(reactionDo.getReactionText().equalsIgnoreCase(REACTION_CAN_UNDERSTAND)){
			selectedEmoticButton.setStyleName(playerStyle.spriteType());
			selectedEmoticButton.addStyleName(playerStyle.emoticon_vii());
			isCanUnderstandSelected = true;
			
			/**
			 * Except "can understand" emotic, all other will be changed to normal emotics.
			 * Note: this changes is made to achieve when user tries to select multiple emotic, previously selected emotic shld be removed.
			 */
			canExplainEmoticButton.setStyleName(playerStyle.spriteType());
			canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
			
			mehEmoticButton.setStyleName(playerStyle.spriteType());
			mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
			
			doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
			doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
			
			needHelpButton.setStyleName(playerStyle.spriteType());
			needHelpButton.addStyleName(playerStyle.emoticon_iv());
			
			/**
			 * Except "can understand" emotic flag, all other emotic flag set to false, based on this again on mouse over previously selected will be removed.
			 * 
			 */
			isCanExplainSelected=false;
			isMehSelected=false;
			isDoNotUnderstandSelected=false;
			isNeedHelpSelected=false;
		}else if(reactionDo.getReactionText().equalsIgnoreCase(REACTION_MEH)){
			selectedEmoticButton.setStyleName(playerStyle.spriteType());
			selectedEmoticButton.addStyleName(playerStyle.emoticon_v());
			isMehSelected = true;
			
			/**
			 * Except "meh" emotic, all other will be changed to normal emotics.
			 * Note: this changes is made to achieve when user tries to select multiple emotic, previously selected emotic shld be removed.
			 */
			canExplainEmoticButton.setStyleName(playerStyle.spriteType());
			canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
			
			understandEmoticButton.setStyleName(playerStyle.spriteType());
			understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
			
			doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
			doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
			
			needHelpButton.setStyleName(playerStyle.spriteType());
			needHelpButton.addStyleName(playerStyle.emoticon_iv());
			
			/**
			 * Except "meh" emotic flag, all other emotic flag set to false, based on this again on mouse over previously selected will be removed.
			 * 
			 */
			isCanExplainSelected=false;
			isCanUnderstandSelected=false;
			isDoNotUnderstandSelected=false;
			isNeedHelpSelected=false;
		}else if(reactionDo.getReactionText().equalsIgnoreCase(REACTION_DONOT_UNDERSTAND)){
			selectedEmoticButton.setStyleName(playerStyle.spriteType());
			selectedEmoticButton.addStyleName(playerStyle.emoticon_ix());
			isDoNotUnderstandSelected = true;
			
			/**
			 * Except "do not understand" emotic, all other will be changed to normal emotics.
			 * Note: this changes is made to achieve when user tries to select multiple emotic, previously selected emotic shld be removed.
			 */
			canExplainEmoticButton.setStyleName(playerStyle.spriteType());
			canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
			
			understandEmoticButton.setStyleName(playerStyle.spriteType());
			understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
			
			mehEmoticButton.setStyleName(playerStyle.spriteType());
			mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
			
			needHelpButton.setStyleName(playerStyle.spriteType());
			needHelpButton.addStyleName(playerStyle.emoticon_iv());
			
			/**
			 * Except "do not understand" emotic flag, all other emotic flag set to false, based on this again on mouse over previously selected will be removed.
			 * 
			 */
			isCanExplainSelected=false;
			isCanUnderstandSelected=false;
			isMehSelected=false;
			isNeedHelpSelected=false;
		}else if(reactionDo.getReactionText().equalsIgnoreCase(REACTION_NEED_HELP)){
			selectedEmoticButton.setStyleName(playerStyle.spriteType());
			selectedEmoticButton.addStyleName(playerStyle.emoticon_x());
			isNeedHelpSelected = true;
			
			/**
			 * Except "need help" emotic, all other will be changed to normal emotics.
			 * Note: this changes is made to achieve when user tries to select multiple emotic, previously selected emotic shld be removed.
			 */
			canExplainEmoticButton.setStyleName(playerStyle.spriteType());
			canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
			
			understandEmoticButton.setStyleName(playerStyle.spriteType());
			understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
			
			mehEmoticButton.setStyleName(playerStyle.spriteType());
			mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
			
			doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
			doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
			
			/**
			 * Except "need help" emotic flag, all other emotic flag set to false, based on this again on mouse over previously selected will be removed.
			 * 
			 */
			isCanExplainSelected=false;
			isCanUnderstandSelected=false;
			isMehSelected=false;
			isDoNotUnderstandSelected=false;
			
		}
		
	}
	public static void addPadding(){
		wrapperContainerField.setStyleName(playerStyle.collectionPlayerWrapperPadding());
	}
	
	public static void removePadding(){
		wrapperContainerField.setStyleName(playerStyle.collectionPlayerWrapper());
	}

	/**
	 * If no reaction available, sets the default reaction for all the resources.
	 */
	@Override
	public void setDefaultReaction() {
		gooruReactionId="";
		isCanUnderstandSelected=false;
		isCanExplainSelected = false;
		isDoNotUnderstandSelected=false;
		isMehSelected=false;
		isNeedHelpSelected=false;
		selectedEmoticButton.setStyleName(playerStyle.spriteType());
		selectedEmoticButton.addStyleName(playerStyle.emoticon_ii());
		
		/**
		 * Resets all emotics to normal in allemoticContainer,
		 */
		canExplainEmoticButton.setStyleName(playerStyle.spriteType());
		canExplainEmoticButton.addStyleName(playerStyle.emoticon_i());
		
		understandEmoticButton.setStyleName(playerStyle.spriteType());
		understandEmoticButton.addStyleName(playerStyle.emoticon_ii());
		
		mehEmoticButton.setStyleName(playerStyle.spriteType());
		mehEmoticButton.addStyleName(playerStyle.emoticon_viii());
		
		doNotUnderstandEmoticButton.setStyleName(playerStyle.spriteType());
		doNotUnderstandEmoticButton.addStyleName(playerStyle.emoticon_iii());
		
		needHelpButton.setStyleName(playerStyle.spriteType());
		needHelpButton.addStyleName(playerStyle.emoticon_iv());
	}
	
	/**
	 * On select of any reaction based on the player type API call is done.
	 * 
	 * @param resourceGooruId {@link String}
	 * @param reactionText {@link String}
	 * @param gooruReactionId {@link String}
	 * @param collectionId {@link String}
	 * @param playerName {@link String}
	 */
	private void createReaction(String resourceGooruId,String reactionText,String gooruReactionId,String collectionId,String playerName){
		if(playerName.trim().equalsIgnoreCase(PlaceTokens.COLLECTION_PLAY)){ 
			getUiHandlers().createReaction(resourceGooruId,reactionText,gooruReactionId,collectionId,CREATE_STUDY_PLAYER_REACTION);
		}else if(playerName.trim().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
			getUiHandlers().createReaction(resourceGooruId,reactionText,gooruReactionId,collectionId,CREATE_PREVIEW_PLAYER_REACTION);
		}
		
	}
	
	private String removeHtmlTags(String html){
        html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
        return html;
	}
	public boolean isProtocolMatched(String sourceUrl){
		boolean isProtocolsMatched=false;
		if(FlashAndVideoPlayerWidget.getProtocal().equalsIgnoreCase("https:")){
				isProtocolsMatched=!sourceUrl.contains("https");
		}
		else{
			if(!sourceUrl.contains("docs.google.com")){
				isProtocolsMatched=sourceUrl.contains("https");
			}
		}
		return isProtocolsMatched;
	}
	
	/**
	 * Sets the user ratings and and star rating widget will get added.
	 * 
	 * @param result {@link StarRatingsDo}
	 * @param showThankYouToolTip {@link Boolean}
	 */
	@Override
	public void setUserStarRatings(StarRatingsDo result, boolean showThankYouToolTip) {
		if(result!=null){
			this.starRatingsDo=result;
			isRated=true; 
		}else{
			isRated=false;
		}
		if(thankYouResourceStarRatings!=null){
			if(thankYouResourceStarRatings.isVisible()){
				thankYouResourceStarRatings.hide();
				if(isFromThanksPopup){
					displaySuccessPopup();
				}
			}
		}
		setRatings(result,showThankYouToolTip);
//		setUserRatings(result);
//		ratingsContainer.clear();
//		ratingsContainer.add(userStarRatings);
	}
	
	@Override
	public void setDefaultUserStarRatings() {
//		starValue.setVisible(false);
	}
	
	/**
	 * 
	 * Inner class extending to StarRatingsUc {@link StarRatingsUc}
	 *
	 */
	public class UserStarRatingsWidget extends StarRatingsUc{
		StarRatingsDo ratingsDo =null;
		public boolean showThankYouToolTip;
		
		/**
		 * Class Constructor
		 * @param result {@link StarRatingsDo}
		 * @param showThankYouToolTip {@link Boolean} 
		 */
		public UserStarRatingsWidget(StarRatingsDo result, boolean showThankYouToolTip) { 
			this.ratingsDo=result;
			this.showThankYouToolTip=showThankYouToolTip;
//			setRatings(result,showThankYouToolTip);
		}
		/**
		 * Class constructor
		 */
		public UserStarRatingsWidget() {
			setDefaultRatings();
		}
		/**
		 * Sets the default rating.
		 */
		private void setDefaultRatings() {
			getDefaultRatings();
		}

		/**
		 * Implementation of parent class method, in this create API will be called based the rating selected.
		 * @param selectedStar {@link String}
		 */
		@Override
		public void crateStarRating(String selectedStar) {
			if(selectedStar.equals("starOne")){
				getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),1,true,null);
			}else if(selectedStar.equals("starTwo")){                                           
				getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),2,true,null);
			}else if(selectedStar.equals("starThree")){                                          
				getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),3,true,null);
			}else if(selectedStar.equals("starFour")){                                           
				getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),4,true,null);
			}else if(selectedStar.equals("starFive")){                                           
				getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),5,true,null);
			}
		}
		
	
		
		/**
		 * Sets the Star rating based on the API result.
		 * @param result {@link StarRatingsDo}
		 * @param showThankYouToolTip {@link Boolean} 
		 */
		/*private void setRatings(StarRatingsDo result,boolean showThankYouToolTip) {
			if(showThankYouToolTip){
				ThankYouResourceStarRatings thankYouResourceStarRatings = new ThankYouResourceStarRatings();
				thankYouResourceStarRatings.getElement().getStyle().setZIndex(999999);
				thankYouResourceStarRatings.setPopupPosition(300,Window.getScrollTop()+48);
				thankYouResourceStarRatings.show();
				thankYouResourceStarRatings.setAutoHideEnabled(true);
			}
			setUserRatings(result);
		}*/
	}
	
	public void removeRatingContainer(boolean flag){
		if(flag){
//			ratingsContainer.removeFromParent();
			ratingsContainer.setVisible(false);
		}else{
			if(isChildAccount()){
//				ratingsContainer.removeFromParent();
				ratingsContainer.setVisible(false);
			}else{
				ratingsContainer.setVisible(true);
			}
			emoticsContainer.removeFromParent();
		}
	}
	
	/**
	 * Checks weather the logged in user is child or not.
	 * @return isChild {@link Boolean} 
	 */
	private boolean isChildAccount() {
		Date convertedDOB = null;
		boolean isChild=false;
		int loggedInUserAge = 0;
		com.google.gwt.i18n.client.DateTimeFormat dateFormat = com.google.gwt.i18n.client.DateTimeFormat.getFormat("yyyy-MM-dd hh:mm:ss.S");
		if(AppClientFactory.getLoggedInUser().getDateOfBirth()!=null&&!AppClientFactory.getLoggedInUser().getDateOfBirth().equals("")){
			convertedDOB = dateFormat.parse(AppClientFactory.getLoggedInUser().getDateOfBirth());
			loggedInUserAge = getAge(convertedDOB);
			if(loggedInUserAge<=CHILD_AGE){
				isChild=true;
			}else if(loggedInUserAge>CHILD_AGE){
				isChild=false;
			}
		}
		
		return isChild;
	}

	/**
	 * On click of Star 1 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("one_star")
	public void onStarOneclicked(ClickEvent event){
		if(AppClientFactory.isAnonymous()){
			getDefaultRatings();
			showLoginPopupWidget(RATINGS_WIDGET);
		}else{
			if(isRated){
				updateStarRating(ONE_STAR);
			}else{
				isRated=true;
				crateStarRating(ONE_STAR);
			}
		}
		
		
	}
	
	/**
	 * On click of Star 2 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("two_star")
	public void onStarTwoclicked(ClickEvent event){
		if(AppClientFactory.isAnonymous()){
			getDefaultRatings();
			showLoginPopupWidget(RATINGS_WIDGET);
		}else{
			if(isRated){
				updateStarRating(TWO_STAR);
			}else{
				isRated=true;
				crateStarRating(TWO_STAR);
			}
		}
		
	}
	
	/**
	 * On click of Star 3 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("three_star")
	public void onStarThreeclicked(ClickEvent event){
		if(AppClientFactory.isAnonymous()){
			getDefaultRatings();
			showLoginPopupWidget(RATINGS_WIDGET);
		}else{
			if(isRated){
				updateStarRating(THREE_STAR);
			}else{
				isRated=true;
				crateStarRating(THREE_STAR);
			}
		}
	}
	
	/**
	 * On click of Star 4 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("four_star")
	public void onStarFourclicked(ClickEvent event){
		if(AppClientFactory.isAnonymous()){
			getDefaultRatings();
			showLoginPopupWidget(RATINGS_WIDGET);
		}else{
			if(isRated){
				updateStarRating(FOUR_STAR);
			}else{
				isRated=true;
				crateStarRating(FOUR_STAR);
			}
		}
		
	}
	
	/**
	 * On click of Star 5 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("five_star")
	public void onStarFiveclicked(ClickEvent event){
		if(AppClientFactory.isAnonymous()){
			getDefaultRatings();
			showLoginPopupWidget(RATINGS_WIDGET);
		}else{
			if(isRated){
				updateStarRating(FIVE_STAR);
			}else{
				isRated=true;
				crateStarRating(FIVE_STAR);
			}
		}
		
	}
	
	/**
	 * Sets the Star rating based on the API result.
	 * @param result {@link StarRatingsDo}
	 * @param showThankYouToolTip {@link Boolean} 
	 */
	private void setRatings(StarRatingsDo result,boolean showThankYouToolTip) {
		if(showThankYouToolTip){
			getAvgRatingAndCount(result.getAssocGooruOid(),result.getScore(),result.getFreeText());
		}
		setUserRatings(result);
	}
	
	
	private void getAvgRatingAndCount(String assocGooruOid, Integer score, String review) {
		getUiHandlers().getAvgRatingAndCount(assocGooruOid,score,review);
	}

	/**
	 * default rating will get set
	 */
	public void getDefaultRatings(){
//		one_star.setValue(false);
//		two_star.setValue(false);
//		three_star.setValue(false);
//		four_star.setValue(false);
//		five_star.setValue(false);
	}
	
	
	/**
	 * In this create API will be called based the rating selected.
	 * @param selectedStar {@link String}
	 */
	public void crateStarRating(String selectedStar) {
		if(selectedStar.equals(ONE_STAR)){
			getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),1,true,"");
		}else if(selectedStar.equals(TWO_STAR)){                                           
			getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),2,true,"");
		}else if(selectedStar.equals(THREE_STAR)){                                          
			getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),3,true,"");
		}else if(selectedStar.equals(FOUR_STAR)){                                           
			getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),4,true,"");
		}else if(selectedStar.equals(FIVE_STAR)){                                           
			getUiHandlers().createStarRatings(collectionItemDo.getResource().getGooruOid(),5,true,"");
		}
	}
	
	/**
	 * In this update API will be called based the rating selected.
	 * @param selectedStar {@link String}
	 */
	public void updateStarRating(String selectedStar) {
		if(selectedStar.equals(ONE_STAR)){
			getUiHandlers().updateStarRatings(starRatingsDo.getDeleteRatingGooruOid(),1,true);
		}else if(selectedStar.equals(TWO_STAR)){                                           
			getUiHandlers().updateStarRatings(starRatingsDo.getDeleteRatingGooruOid(),2,true);
		}else if(selectedStar.equals(THREE_STAR)){                                          
			getUiHandlers().updateStarRatings(starRatingsDo.getDeleteRatingGooruOid(),3,true);
		}else if(selectedStar.equals(FOUR_STAR)){                                           
			getUiHandlers().updateStarRatings(starRatingsDo.getDeleteRatingGooruOid(),4,true);
		}else if(selectedStar.equals(FIVE_STAR)){                                           
			getUiHandlers().updateStarRatings(starRatingsDo.getDeleteRatingGooruOid(),5,true);
		}
	}
	
	
	/**
	 * Resource ratings will get set based on the respective scores.
	 * 
	 * @param result {@link StarRatingsDo}
	 */
	public void setUserRatings(StarRatingsDo result){
		if(result!=null){
			setStyle();
			currentRating = result.getScore();
			if(result.getScore()==1){
				starValue.setVisible(true);
				starValue.setText(POOR);
				setStarRatingValue(1); 
			}else if(result.getScore()==2){
				starValue.setVisible(true);
				starValue.setText(FAIR);
				setStarRatingValue(2); 
			}else if(result.getScore()==3){
				starValue.setVisible(true);
				starValue.setText(GOOD);
				setStarRatingValue(3);
			}else if(result.getScore()==4){
				starValue.setVisible(true);
				starValue.setText(VERY_GOOD);
				setStarRatingValue(4);
				
			}else if(result.getScore()==5){
				starValue.setVisible(true);
				starValue.setText(EXCELLENT);
				setStarRatingValue(5);
			}else{
				setStarRatingValue(0);
			}
		}else{
			starValue.setVisible(true);
			starValue.setText(GL1879);
			setStarRatingValue(0);
		}
		
	}
	
	private void setStyle() {
		if(!starValue.getText().equalsIgnoreCase(DEFAULT_RATING_TEXT)){
			starValue.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		}
	}

	public void clearAllStars(){
		one_star.getElement().removeClassName(FILLED_BLUE);
		two_star.getElement().removeClassName(FILLED_BLUE);
		three_star.getElement().removeClassName(FILLED_BLUE);
		four_star.getElement().removeClassName(FILLED_BLUE);
		five_star.getElement().removeClassName(FILLED_BLUE);
	}
	
	
	/**
	 * Sets the stars on view based on the scores.
	 * @param starRating {@link Integer}
	 */
	private void setStarRatingValue(int starRating) {
		
		clearAllStars();
		if(starRating==1){
			one_star.getElement().addClassName(FILLED_BLUE);
		}else if(starRating==2){
			one_star.getElement().addClassName(FILLED_BLUE);
			two_star.getElement().addClassName(FILLED_BLUE);
		}else if(starRating==3){
			one_star.getElement().addClassName(FILLED_BLUE);
			two_star.getElement().addClassName(FILLED_BLUE);
			three_star.getElement().addClassName(FILLED_BLUE);
		}else if(starRating==4){
			one_star.getElement().addClassName(FILLED_BLUE);
			two_star.getElement().addClassName(FILLED_BLUE);
			three_star.getElement().addClassName(FILLED_BLUE);
			four_star.getElement().addClassName(FILLED_BLUE);
		}else if(starRating==5){
			one_star.getElement().addClassName(FILLED_BLUE);
			two_star.getElement().addClassName(FILLED_BLUE);
			three_star.getElement().addClassName(FILLED_BLUE);
			four_star.getElement().addClassName(FILLED_BLUE);
			five_star.getElement().addClassName(FILLED_BLUE);
		}else{
			clearAllStars();
		}
	}
	
	/**
	 * 
	 * Inner class which implements mouse over handler.
	 *
	 */
	public class OnStarMouseOver implements MouseOverHandler{
		private String starScore="";
		/**
		 * Class Constructor.
		 * @param starScore {@link String}
		 */
		public OnStarMouseOver(String starScore) {
			
			this.starScore=starScore;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
				clearAllStars();
				starValue.setVisible(false);
			}else{
				starValue.setVisible(true);
			}
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
					clearAllStars();
					one_star.getElement().addClassName(FILLED_BLUE);
					mouseOverStarValue.setText(POOR);
				}else{
					starValue.setVisible(true);
				}
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
					clearAllStars();
					one_star.getElement().addClassName(FILLED_BLUE);
					two_star.getElement().addClassName(FILLED_BLUE);
					mouseOverStarValue.setText(FAIR);
				}else{
					starValue.setVisible(true);
				}
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
					clearAllStars();
					one_star.getElement().addClassName(FILLED_BLUE);
					two_star.getElement().addClassName(FILLED_BLUE);
					three_star.getElement().addClassName(FILLED_BLUE);
					mouseOverStarValue.setText(GOOD);
				}else{
					starValue.setVisible(true);
				}
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
					clearAllStars();
					one_star.getElement().addClassName(FILLED_BLUE);
					two_star.getElement().addClassName(FILLED_BLUE);
					three_star.getElement().addClassName(FILLED_BLUE);
					four_star.getElement().addClassName(FILLED_BLUE);
					mouseOverStarValue.setText(VERY_GOOD);
				}else{
					starValue.setVisible(true);
				}
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				if(starValue.getText().equals(DEFAULT_RATING_TEXT)){
					clearAllStars();
					one_star.getElement().addClassName(FILLED_BLUE);
					two_star.getElement().addClassName(FILLED_BLUE);
					three_star.getElement().addClassName(FILLED_BLUE);
					four_star.getElement().addClassName(FILLED_BLUE);
					five_star.getElement().addClassName(FILLED_BLUE);
					mouseOverStarValue.setText(EXCELLENT);
				}

			}
		}
		
	}
	
	public class OnStarMouseOut implements MouseOutHandler{
		private String starScore="";
		public OnStarMouseOut(String starScore) {
			this.starScore=starScore;
		}

		@Override
		public void onMouseOut(MouseOutEvent event) {
			clearAllStars();
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}
			
			if(!starValue.getText().equals(DEFAULT_RATING_TEXT)){
				setStarRatingValue(currentRating);
			}
		}
	}
	
	
	public static void onClosingAndriodorIpaddiv()
	{
		  wrapperContainerField.getElement().setAttribute("style", "margin-top:50px;");
	}

	/**
	 * API call to update or to create review.
	 * User review will get created or if already reviewed and edited, review will get updated.
	 * 
	 * @param assocGooruOid {@link String}
	 * @param userReview {@link String}
	 * @param score {@link Integer}
	 * @param isUpdate {@link Boolean}
	 */
	@Override
	public void postReview(String assocGooruOId, String userReview, Integer score,boolean isUpdate) {
		if(isUpdate){
			getUiHandlers().updateReview(starRatingsDo.getDeleteRatingGooruOid(), score,userReview);
		}else{
			if(ratingsConfirmationPopup!=null && ratingsConfirmationPopup.isVisible()){
				ratingsConfirmationPopup.hide();
			}
			isFromThanksPopup=true;
			getUiHandlers().createStarRatings(assocGooruOId,score,false,userReview);
		}
		
	}

	/**
	 * Thank you too-tip will get closed, if it i opened.
	 */
	@Override
	public void hideThankYouPopUp() {
		thankYouResourceStarRatings.hide();
		displaySuccessPopup();
	}

	/**
	 * Invokes Thankyou tool tip after user rated a resource and sets the metadata.
	 * @param assocGooruOid {@link String}
	 * @param score {@link Integer}
	 * @param review {@link String}
	 * @param average {@link Integer}
	 * @param count {@link Integer}
	 */
	@Override
	public void setRatingMetaData(String assocGooruOid, Integer score,String review, double average, Integer count) {
		this.assocGooruOId=assocGooruOid;
		this.score=score;
		this.count=count;
		this.average=average;
		thankYouResourceStarRatings = new ThankYouResourceStarRatings(assocGooruOid,score,review,average,count,collectionItemDo.getResource().getUser().getUsername()); 
		thankYouResourceStarRatings.getElement().getStyle().setZIndex(999999);
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
			thankYouResourceStarRatings.setPopupPosition(685,Window.getScrollTop()+48);
		}else{
			thankYouResourceStarRatings.setPopupPosition(300,Window.getScrollTop()+48);
		}
		
		thankYouResourceStarRatings.show();
		thankYouResourceStarRatings.setAutoHideEnabled(true);
	}
	
	
	private int getAge(Date birthDate) {
		long ageInMillis = new Date().getTime() - birthDate.getTime();
		Date age = new Date(ageInMillis);
		return age.getYear() - 70;
	}

	@Override
	public void displaySuccessPopup() {
		if(ratingsConfirmationPopup!=null && ratingsConfirmationPopup.isVisible()){
			ratingsConfirmationPopup.hide();
		}
		isFromThanksPopup=false;
		ratingsConfirmationPopup=new RatingsConfirmationPopup(assocGooruOId,score,count,average,collectionItemDo.getResource().getUser().getUsername());
		ratingsConfirmationPopup.show();
		ratingsConfirmationPopup.getElement().getStyle().setZIndex(99999);
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
			ratingsConfirmationPopup.setPopupPosition(685,Window.getScrollTop()+60);
		}else{
			ratingsConfirmationPopup.setPopupPosition(314,Window.getScrollTop()+60);
		}
		
		ratingsConfirmationPopup.setAutoHideEnabled(true);
	}

	@Override
	public void updateRatingOnSearch(StarRatingsDo starRatingsDo) {
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
			AppClientFactory.fireEvent(new UpdateResourceRatingCountEvent(collectionItemDo.getResource().getGooruOid()));
		}
		
	}
	
}
