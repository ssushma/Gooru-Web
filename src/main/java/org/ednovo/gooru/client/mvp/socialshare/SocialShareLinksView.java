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
package org.ednovo.gooru.client.mvp.socialshare;

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : SocialShareLinksView.java
 *
 * @description : This class will shows the social share links
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SocialShareLinksView extends Composite {

	@UiField
	TextArea shareLinkTxtBox;
	
	@UiField
	FlowPanel shareLinkFlwPl;

	@UiField Label swithUrlLbl, swithToEmbedLbl, shareLbl;
	
	private static final String SWITCH_FULL_URL = "Switch to full URL";
	
	private static final String SWITCH_EMBED_CODE = "Switch to embed code";

	private static final String SWITCH_BITLY = "Switch to Bit.ly";
	
	private static final String SWITCH_URL_LABEL = "swithUrlLbl";

	private static final String SWITCH_TO_EMBED_LABEL = "swithToEmbedLbl";

	private String bitlyLink, decodeRawUrl, embedBitlyLink;
	
	private boolean isPrivate = false;

	private static SocialShareLinksViewUiBinder uiBinder = GWT
			.create(SocialShareLinksViewUiBinder.class);

	interface SocialShareLinksViewUiBinder extends
			UiBinder<Widget, SocialShareLinksView> {
	}
	/**
	 * class constructor.
	 */
	public SocialShareLinksView() {
		initWidget(uiBinder.createAndBindUi(this));
		shareLinkFlwPl.getElement().getStyle().clearPaddingTop();
		shareLinkTxtBox.addClickHandler(new OnTextBoxClick());
		shareLinkTxtBox.getElement().setId("tatShareLink");
		swithUrlLbl.getElement().setId("lblSwithUrl");
		swithToEmbedLbl.getElement().setId("lblSwithToEmbedLbl");
	}
	/**
	 * @function setData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the data.
	 * 
	 * 
	 * @parm(s) : @param shortenUrl
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setData(Map<String, String> shortenUrl) {
		if (shortenUrl != null && shortenUrl.containsKey("shortenUrl")) {
			//shareLinkTxtBox.setText(shortenUrl.get("shortenUrl"));
			//bitlyLink=shareLinkTxtBox.getText();
			shareLinkTxtBox.setText(shortenUrl.get("decodeRawUrl").toString());
			bitlyLink=shortenUrl.get("shortenUrl");
			
		}
		decodeRawUrl=shortenUrl.get("decodeRawUrl").toString();
		
	}
	
	/**
	 * @author Search Team Selected shareLink textBox data.
	 */
	public class OnTextBoxClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			shareLinkTxtBox.selectAll();
			shareLinkTxtBox.setFocus(true);
		}
	}

	public TextArea getshareLinkTxtBox() {
		return shareLinkTxtBox;
	}

	public Label getShareLbl() {
		return shareLbl;
	}

	public FlowPanel getShareLinkFlwPl() {
		return shareLinkFlwPl;
	}

	/**
	 * Switching between Url and Bitly link
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("swithUrlLbl")
	public void onClickSwithUrl(ClickEvent clickevent){
		if(!getIsPrivate()) {
			changeShareUrlEvents(SWITCH_BITLY);
		}
	}
	
	/**
	 * Switching between Url and Bitly link
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("swithToEmbedLbl")
	public void onClickSwithToEmbed(ClickEvent clickevent){
		if(!getIsPrivate()) {
			changeShareUrlEvents(SWITCH_TO_EMBED_LABEL);
		}
	}
	/**
	 * 
	 * @function changeShareUrlEvents 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to change the share url events.
	 * 
	 * 
	 * @parm(s) : @param buttonType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void changeShareUrlEvents(String buttonType) {
		if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_BITLY)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			} else {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			}
		}else if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_BITLY)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			} else {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			}
		}else if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			} else {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			}
		}else if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			} else {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			}
		}else if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_BITLY)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			} else {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			}
		}else if(swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)&&swithUrlLbl.getText().equalsIgnoreCase(SWITCH_BITLY)){
			if(buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			} else {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			}
		}
	}
	/**
	 * @function getIframeText 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to get the iframe text.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String getIframeText() {
		String iframeText;
		if(embedBitlyLink==null){
		embedBitlyLink=shareLinkTxtBox.getText();
		}
		if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.COLLECTION_SEARCH)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)){
			 iframeText = "<iframe width=\"500px\" height=\"208px\" src=\"" + embedBitlyLink + "\" frameborder=\"0\" ></iframe>";
		}else{
			 iframeText = "<iframe width=\"1024px\" height=\"768px\" src=\"" + embedBitlyLink + "\" frameborder=\"0\" ></iframe>";
		}
		return iframeText;
	}
	/**
	 * 
	 * @function setIsPrivate 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set private or not.
	 * 
	 * 
	 * @parm(s) : @param isPrivate
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setIsPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
		setSwitchButtonStyles();
	}
	/**
	 * This will return the boolean value.
	 */
	private boolean getIsPrivate() {
		return isPrivate;
	}
	/**
	 * @function setSwitchButtonStyles 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will set the switch buttons styles.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setSwitchButtonStyles() {
		if(getIsPrivate()) {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
		} else {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.POINTER);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.POINTER);
		}
	}
	private void fullUrlMixPanelEvent() {
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
			MixpanelUtil.Share_direct_search();
		}
		else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)){
			MixpanelUtil.Share_direct_collection_edit();
		}
	}
	
	public void setEmbedBitlyLink(String embedBitlyLink) {
		this.embedBitlyLink = embedBitlyLink;
	}
	
}
