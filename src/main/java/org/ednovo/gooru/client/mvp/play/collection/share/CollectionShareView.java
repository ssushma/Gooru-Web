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
package org.ednovo.gooru.client.mvp.play.collection.share;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.share.email.CollectionEmailShareView;
import org.ednovo.gooru.client.mvp.play.collection.share.email.SentEmailSuccessVc;
import org.ednovo.gooru.client.mvp.socialshare.SocialShareView;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
public class CollectionShareView extends BaseViewWithHandlers<CollectionShareUiHandlers> implements IsCollectionShareView,MessageProperties{


	private static CollectionShareViewUiBinder uiBinder = GWT.create(CollectionShareViewUiBinder.class);

	interface CollectionShareViewUiBinder extends UiBinder<Widget, CollectionShareView> {

	}

	@UiField HTMLPanel sharePanel,shareMainTitle;

	@UiField TextArea resourceShareTextArea,collectionShareTextArea;
	
	@UiField FlowPanel socialSharePanel,collectionShareContainer;

	@UiField InlineLabel embedLink,bitlyLink;
	
	@UiField Label resourceTitleText,collectionShareText,hideText,shareText;
	
	@UiField HTMLEventPanel hideButton;
	
	private boolean isResourceView=false;

	private String embedurl, bitlyUrl, originalUrl,embededIframeURL,resourceShareUrl;
	
	private String shareUrl="";
	
	private String shareBitlyUrl="";
	
	private String embedBitlyUrl="";

	private static final String SWITCH_FULL_URL = GL0643;

	private static final String SWITCH_EMBED_CODE = GL0640;

	private static final String SWITCH_BITLY = GL0639;
	
	private CollectionEmailShareView emailShareView=null;
	
	private Map<String, String> collectionShareMap=null;
	
	private Map<String, String> resourceShareMap=null;

	@Inject
	public CollectionShareView(){
		setWidget(uiBinder.createAndBindUi(this));		
		resourceShareTextArea.setReadOnly(true);
		resourceShareTextArea.getElement().setAttribute("readOnly", "");
		embedLink.setText(SWITCH_EMBED_CODE);
		bitlyLink.setText(SWITCH_BITLY);
		shareMainTitle.getElement().setInnerHTML(GL0644);
		collectionShareText.setText(GL0645);
		bitlyLink.getElement().setInnerHTML(GL0639);
		embedLink.getElement().setInnerHTML(GL0640);
		hideText.setText(GL0592);
		shareText.setText(GL0638);
	}
	
	public void showShareView(boolean isResourceView){
		this.isResourceView=isResourceView;
		collectionShareTextArea.setValue("");
		if(isResourceView){
			socialSharePanel.setVisible(true);
			collectionShareContainer.setVisible(false);
//			resourceTitleText.setText("Resource");
		}else{
			resourceTitleText.setText(GL0645);
			collectionShareContainer.setVisible(false);
			socialSharePanel.setVisible(true);
		}	
	}
	
	public void setCollectionShareData(Map<String, String> shareUrlsList){
		isResourceView=false;
		collectionShareMap=new HashMap<String,String>();
		shareBitlyUrl = shareUrlsList.get("shortenUrl").toString();
		shareUrl= shareUrlsList.get("decodeRawUrl").toString();
		originalUrl=shareUrlsList.get("rawUrl").toString();
		embedurl=shareUrlsList.get("embedUrlRawUrl").toString();
		setIframeUrl(embedurl);		
		collectionShareMap.put(SWITCH_FULL_URL, shareUrl);
		collectionShareMap.put(SWITCH_BITLY, shareBitlyUrl);
		embedLink.setText(SWITCH_EMBED_CODE);
		bitlyLink.setText(SWITCH_BITLY);
		resourceShareTextArea.setText(shareUrl);
	}
	
	public void setResourceShareData(Map<String, String> shareUrlsList){
		isResourceView=true;
		resourceShareTextArea.setValue(shareUrl);
		resourceShareMap=new HashMap<String,String>();
		String resourceShareBitlyUrl = shareUrlsList.get("shortenUrl").toString();
		resourceShareUrl= shareUrlsList.get("decodeRawUrl").toString();
		setResourceIframeUrl(resourceShareUrl);	
		resourceShareMap.put(SWITCH_FULL_URL, resourceShareUrl);
		resourceShareMap.put(SWITCH_BITLY, resourceShareBitlyUrl);
		resourceShareTextArea.setText(resourceShareUrl);
		embedLink.setText(SWITCH_EMBED_CODE);
		bitlyLink.setText(SWITCH_BITLY);
	}
	public void setCollectionShareData(){
		embedLink.setText(SWITCH_EMBED_CODE);
		bitlyLink.setText(SWITCH_BITLY);
		if(isResourceView){
			collectionShareTextArea.setText(shareUrl);
		}else{
			resourceShareTextArea.setText(shareUrl);
		}
	}
	
	public void setResourceShareData(){
		resourceShareTextArea.setValue("");
		String resourceShareUrl=resourceShareMap.get(SWITCH_FULL_URL);
		resourceShareTextArea.setText(resourceShareUrl);
	}
	
	
	@Override
	public void setData(final CollectionDo collectionDo) {
		sharePanel.clear();
		SocialShareWidget swidget= new SocialShareWidget(collectionDo.getGoals(),collectionDo.getThumbnails().getUrl(),"collection") {

			@Override
			public void onTwitter() {
				Window.open("http://twitter.com/intent/tweet?text=" + GL1439+collectionDo.getTitle().replaceAll("\\+", "%2B") +": " + shareBitlyUrl, "_blank", "width=600,height=300");
			}
			
			@Override
			public void onFacebook() {
				 SocialShareView.postOnFacebook(collectionDo.getTitle(),SocialShareView.getEncodedUrl(shareUrl),getResourceDescription(),getThumbnailUrl());
			}

			@Override
			public void onEmail() {
				String emailSubject=GL1439+collectionDo.getTitle();
				String emailDescription= collectionDo.getTitle()+"<div><br/></div><div>"+shareUrl+"</div><div><br/></div><div>"+GL1440+" "+AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint()+" "+GL1441+"</div>";
				 emailShareView=new CollectionEmailShareView(emailSubject, emailDescription){
					@Override
					public void sendEmail(String fromEmail, String toEmail,
							String copyEmail, String subject, String message) {
						getUiHandlers().sendEmail( fromEmail,  toEmail, copyEmail,  subject,  message);
					}
				};
				emailShareView.show();
				

			}
		};

		sharePanel.add(swidget);
	}


	
	public void setIframeUrl(String iframeBitlyUrl){
		embedBitlyUrl = "<iframe width=\"1024px\" height=\"768px\" src=\"" + iframeBitlyUrl + "\" frameborder=\"0\" ></iframe>";
		collectionShareMap.put(SWITCH_EMBED_CODE, embedBitlyUrl);
	}
	public void setResourceIframeUrl(String iframeBitlyUrl){
		String resourceEmbedBitlyUrl = "<iframe width=\"1024px\" height=\"768px\" src=\"" + iframeBitlyUrl + "\" frameborder=\"0\" ></iframe>";
		resourceShareMap.put(SWITCH_EMBED_CODE, resourceEmbedBitlyUrl);
	}
	
	@Override
	public void setIframeText(Map<String, String> embedLink) {
		String iframeText;
		if (embedLink != null && embedLink.containsKey("shortenUrl")) {
			embedurl = embedLink.get("decodeRawUrl").toString();
			iframeText = "<iframe width=\"1024px\" height=\"768px\" src=\"" + embedurl + "\" frameborder=\"0\" ></iframe>";
			collectionShareMap.put(SWITCH_EMBED_CODE, iframeText);
		}
	}

	@UiHandler("embedLink")
	public void onClickEmbedLink(ClickEvent clickEvent){
		String shareTxt=resourceShareTextArea.getText();
		String embed=embedLink.getText();
		Iterator<String> keyIterator =null;
		if(isResourceView){
			keyIterator=resourceShareMap.keySet().iterator();
		}else{
			keyIterator=collectionShareMap.keySet().iterator();
		}
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= isResourceView?resourceShareMap.get(key):collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				embedLink.setText(key);
				if(isResourceView){
					resourceShareTextArea.setText(resourceShareMap.get(embed));
				}else{
					resourceShareTextArea.setText(collectionShareMap.get(embed));
				}
			}
		}

	}
	
	@UiHandler("resourceShareTextArea")
	public void onClickresourceShareTextArea(ClickEvent clickEvent){
	
		resourceShareTextArea.selectAll();
		resourceShareTextArea.setFocus(true);
	}

	@UiHandler("bitlyLink")
	public void onClickBitlyLink(ClickEvent clickEvent){
		String shareTxt=resourceShareTextArea.getText();
		String linkUrl=bitlyLink.getText();
		Iterator<String> keyIterator =null;
		if(isResourceView){
			keyIterator=resourceShareMap.keySet().iterator();
		}else{
			keyIterator=collectionShareMap.keySet().iterator();
		}
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= isResourceView?resourceShareMap.get(key):collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				bitlyLink.setText(key);
				if(isResourceView){
					resourceShareTextArea.setText(resourceShareMap.get(linkUrl));
					//collectionShareTextArea.setText(collectionShareMap.get(linkUrl));
				}else{
					resourceShareTextArea.setText(collectionShareMap.get(linkUrl));
				}
			}
		}
	}
	@Override
	public void hideSendEmailPopup(String toEmail){
		emailShareView.hide();
		new SentEmailSuccessVc(toEmail);
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
	
	public String removeHtmlTags(String content){
		return content.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView#setEmbedurl(java.lang.String)
	 */
	@Override
	public void setEmbedurl(String embedurl) {
		this.embedurl=embedurl;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView#setEmbededIframeURL(java.lang.String)
	 */
	@Override
	public void setEmbededIframeURL(String embededIframeURL) {
		this.embededIframeURL=embededIframeURL;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView#showResourceData(org.ednovo.gooru.shared.model.content.CollectionItemDo)
	 */
	@Override
	public void showResourceData(final CollectionItemDo collectionItemDo) {
		sharePanel.clear();
		SocialShareWidget swidget= new SocialShareWidget(collectionItemDo.getResource().getDescription(),collectionItemDo.getResource().getThumbnails().getUrl(),collectionItemDo.getCategory(),collectionItemDo) {
			@Override
			public void onTwitter() {
				Window.open("http://twitter.com/intent/tweet?text=" + GL1439+removeHtmlTags(collectionItemDo.getResource().getTitle()).replaceAll("\\+", "%2B") +": " + SocialShareView.getEncodedUrl(resourceShareUrl), "_blank", "width=600,height=300");
			}
			@Override
			public void onFacebook() {
				SocialShareView.postOnFacebook(removeHtmlTags(collectionItemDo.getResource().getTitle()),SocialShareView.getEncodedUrl(resourceShareUrl),getResourceDescription(),getThumbnailUrl());
			}

			@Override
			public void onEmail() {
				String emailSubject=GL1439+removeHtmlTags(collectionItemDo.getResource().getTitle());
				String emailDescription= collectionItemDo.getResource().getTitle()+"<div><br/></div><div>"+resourceShareUrl+"</div><div><br/></div><div>"+GL1440+" "+AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint()+" "+GL1441+"</div>";
				 emailShareView=new CollectionEmailShareView(emailSubject, emailDescription){
					@Override
					public void sendEmail(String fromEmail, String toEmail,
							String copyEmail, String subject, String message) {
						getUiHandlers().sendEmail( fromEmail,  toEmail, copyEmail,  subject,  message);
					}
				};
				emailShareView.show();
			
			}
		};

		sharePanel.add(swidget);
	}
}
