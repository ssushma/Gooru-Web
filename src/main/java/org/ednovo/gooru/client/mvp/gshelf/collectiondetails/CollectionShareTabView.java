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
package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class CollectionShareTabView extends BaseViewWithHandlers<CollectionShareTabUiHandlers> implements IsCollectionShareTabView {

	private static CollectionShareTabViewUiBinder uiBinder = GWT.create(CollectionShareTabViewUiBinder.class);

	@UiTemplate("CollectionShareTabView.ui.xml")
	interface CollectionShareTabViewUiBinder extends UiBinder<Widget, CollectionShareTabView> {
	}	

	@UiField TextArea shareTextArea;
	@UiField Anchor bitlyLink,embedLink;


	public MessageProperties i18n = GWT.create(MessageProperties.class);

	private String shareUrl="";

	private String shareBitlyUrl="";

	private String embedurl="";
	private String embedBitlyUrl="";

	private Map<String, String> collectionShareMap=null;

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public CollectionShareTabView() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setCollectionShareData(Map<String, String> shareUrlsList){
		collectionShareMap=new HashMap<String,String>();
		if(shareUrlsList!=null){
			shareBitlyUrl = shareUrlsList.get(ClientConstants.SHORTENURL).toString();
			//shareUrl= shareUrlsList.get(ClientConstants.DECODERAWURL).toString();
			embedurl=shareUrlsList.get(ClientConstants.EMBEDURLRAWURL).toString();
			setIframeUrl(embedurl);		
		}
		collectionShareMap.put(i18n.GL0643(), shareUrl);
		collectionShareMap.put(i18n.GL0639(), shareBitlyUrl);
		embedLink.setText(i18n.GL0640());
		embedLink.getElement().setAttribute("alt",i18n.GL0640());
		embedLink.getElement().setAttribute("title",i18n.GL0640());

		bitlyLink.setText(i18n.GL0639());
		bitlyLink.getElement().setAttribute("alt",i18n.GL0639());
		bitlyLink.getElement().setAttribute("title",i18n.GL0639());

		shareTextArea.setText(shareUrl);
		shareTextArea.getElement().setAttribute("alt",shareUrl);
		shareTextArea.getElement().setAttribute("title",shareUrl);
	}

	public void setIframeUrl(String iframeBitlyUrl){
		embedBitlyUrl = "<iframe width=\"1024px\" height=\"768px\" src=\"" + iframeBitlyUrl + "\" frameborder=\"0\" ></iframe>";
		collectionShareMap.put(i18n.GL0640(), embedBitlyUrl);
	}

	@UiHandler("embedLink")
	public void onClickEmbedLink(ClickEvent clickEvent){
		String shareTxt=shareTextArea.getText();
		String embed=embedLink.getText();
		Iterator<String> keyIterator =null;

		keyIterator=collectionShareMap.keySet().iterator();

		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value = collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				embedLink.setText(key);
				embedLink.getElement().setAttribute("alt",key);
				embedLink.getElement().setAttribute("title",key);
				shareTextArea.setText(collectionShareMap.get(embed));
				shareTextArea.getElement().setAttribute("alt",collectionShareMap.get(embed));
				shareTextArea.getElement().setAttribute("title",collectionShareMap.get(embed));

			}
		}
	}

	@UiHandler("shareTextArea")
	public void onClickshareTextArea(ClickEvent clickEvent){
		shareTextArea.selectAll();
		shareTextArea.setFocus(true);
	}

	@UiHandler("bitlyLink")
	public void onClickBitlyLink(ClickEvent clickEvent){
		String shareTxt=shareTextArea.getText();
		String linkUrl=bitlyLink.getText();
		Iterator<String> keyIterator =null;
		keyIterator=collectionShareMap.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				bitlyLink.setText(key);
				bitlyLink.getElement().setAttribute("alt",key);
				bitlyLink.getElement().setAttribute("title",key);
				shareTextArea.setText(collectionShareMap.get(linkUrl));
				shareTextArea.getElement().setAttribute("alt",collectionShareMap.get(linkUrl));
				shareTextArea.getElement().setAttribute("title",collectionShareMap.get(linkUrl));
			}
		}
	}

	@Override
	public void setShareUrl(String shareUrl) {
		this.shareUrl=shareUrl;
	}

}
