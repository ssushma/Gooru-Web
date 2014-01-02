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
package org.ednovo.gooru.client.mvp.play.resource.share;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.share.SocialShareWidget;
import org.ednovo.gooru.client.mvp.play.collection.share.email.CollectionEmailShareView;
import org.ednovo.gooru.client.mvp.play.collection.share.email.SentEmailSuccessVc;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

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

public class ResourceShareView extends BaseViewWithHandlers<ResourceShareUiHandlers> implements IsResourceShareView{


	private static ResourceShareViewUiBinder uiBinder = GWT.create(ResourceShareViewUiBinder.class);

	 interface ResourceShareViewUiBinder extends UiBinder<Widget, ResourceShareView> {

	}

	@UiField HTMLPanel sharePanel;

	@UiField TextArea resourceShareTextArea;
	
	@UiField FlowPanel socialSharePanel;

	@UiField InlineLabel embedLink,bitlyLink;
	
	@UiField Label resourceTitleText;
	

	private String  bitlyUrl;
	
	private String shareUrl="";
	
	private String shareBitlyUrl="";
	
	private String embedBitlyUrl="";

	private static final String SWITCH_FULL_URL = "Switch to full URL";

	private static final String SWITCH_EMBED_CODE = "Switch to embed code";

	private static final String SWITCH_BITLY = "Switch to Bit.ly";
	
	private CollectionEmailShareView emailShareView=null;
	
	
	private Map<String, String> resourceShareMap=null;

	@Inject
	public ResourceShareView(){
		setWidget(uiBinder.createAndBindUi(this));
		embedLink.setText(SWITCH_EMBED_CODE);
		bitlyLink.setText(SWITCH_BITLY);
	}
	
	public void setResourceShareData(Map<String, String> shareUrlsList){
		resourceShareMap=new HashMap<String,String>();
		setResourceIframeUrl(shareUrlsList.get("embedbitlyurl").toString());
		shareBitlyUrl = shareUrlsList.get("sharebitlyurl").toString();
		shareUrl= shareUrlsList.get("shareurl").toString();
		resourceShareMap.put(SWITCH_FULL_URL, shareUrl);
		resourceShareMap.put(SWITCH_BITLY, shareBitlyUrl);
		resourceShareTextArea.setText(shareUrl);
	}
	
	public void setResourceShareData(){
		String resourceShareUrl=resourceShareMap.get(SWITCH_FULL_URL);
		resourceShareTextArea.setText(resourceShareUrl);
	}
	
	
	@Override
	public void setData(final CollectionItemDo collectionItemDo) {
		
		SocialShareWidget swidget= new SocialShareWidget() {

			@Override
			public void onTwitter() {
				Window.open("http://twitter.com/intent/tweet?text=" + "Gooru - "+collectionItemDo.getResource().getTitle().replaceAll("\\+", "%2B") +": " + shareBitlyUrl, "_blank", "width=600,height=300");
			}
			
			@Override
			public void onFacebook() {
//				Window.open(
//						"http://www.facebook.com/sharer/sharer.php?s=100&p[url]="
//								+ originalUrl + "&p[images][0]="
//								+collectionDo.getThumbnailUrl() + "&p[title]="
//								+collectionDo.getTitle().replaceAll("\\+", "%2B")+ "&p[summary]=" +collectionDo.getGoals(),
//								"_blank", "width=626,height=436");
			}

			@Override
			public void onEmail() {
				String emailSubject="Gooru - "+collectionItemDo.getResource().getTitle();
				String emailDescription= collectionItemDo.getResource().getTitle()+"<div><br/></div><div>"+shareBitlyUrl+"</div><div><br/></div><div>Sent using Gooru. Visit http://www.goorulearning.org/ for more great resources and collections. It's free!</div>";
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


	public void setResourceIframeUrl(String iframeBitlyUrl){
		String resourceEmbedBitlyUrl = "<iframe width=\"1024px\" height=\"768px\" src=\"" + iframeBitlyUrl + "\" frameborder=\"0\" ></iframe>";
		resourceShareMap.put(SWITCH_EMBED_CODE, resourceEmbedBitlyUrl);
	}
	

	@UiHandler("embedLink")
	public void onClickEmbedLink(ClickEvent clickEvent){
		String shareTxt=resourceShareTextArea.getText();
		String embed=embedLink.getText();
		Iterator<String> keyIterator = resourceShareMap.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= resourceShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				embedLink.setText(key);
				resourceShareTextArea.setText(resourceShareMap.get(embed));
			}
		}

	}

	@UiHandler("bitlyLink")
	public void onClickBitlyLink(ClickEvent clickEvent){
		String shareTxt=resourceShareTextArea.getText();
		String linkUrl=bitlyLink.getText();
		Iterator<String> keyIterator = resourceShareMap.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= resourceShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				bitlyLink.setText(key);
				resourceShareTextArea.setText(resourceShareMap.get(linkUrl));
			}
		}
	}
	@Override
	public void hideSendEmailPopup(String toEmail){
		emailShareView.hide();
		new SentEmailSuccessVc(toEmail);
	}	
}
