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
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.mvp.shelf.event.EmbedEnableEvent;
import org.ednovo.gooru.client.mvp.shelf.event.EmbedEnableHandler;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/** 
 * 
 * @fileName : SearchEmbedVc.java
 *
 * @description : 
 *	This class is used to display the Embed iframe content for user to use.
 *
 * @version : 1.0
 *
 * @date: Jul 15, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class SearchEmbedVc extends Composite {

	
	@UiField TextArea txtAreaEmbed,embedlineText; 
	
	boolean isEditable;
	
	private static SearchEmbedVcUiBinder uiBinder = GWT.create(SearchEmbedVcUiBinder.class);
	MessageProperties i18n = GWT.create(MessageProperties.class);
	interface SearchEmbedVcUiBinder extends UiBinder<Widget, SearchEmbedVc> {
	}
	
	//Adding event handler for updating is editable.
	EmbedEnableHandler enableHandler = new EmbedEnableHandler() {
		
		@Override
		public void enableFlag(boolean isEditable) {
			updateIsEditable(isEditable);
		}
	};
	
	/**
	 * Class constructor, for embed 
	 */
	public SearchEmbedVc(String bitlyLink, final boolean isEditable) {
		this.isEditable = isEditable;
		initWidget(uiBinder.createAndBindUi(this));
		embedlineText.setText(i18n.GL0718());
		embedlineText.getElement().setId("tatEmbedlineText");
		embedlineText.getElement().setAttribute("alt",i18n.GL0718());
		embedlineText.getElement().setAttribute("title",i18n.GL0718());
		
		txtAreaEmbed.getElement().setAttribute("id", "txtAreaEmbed");
		StringUtil.setAttributes(txtAreaEmbed, true);
		
		//Handle click event for selecting all text inside text box.
		txtAreaEmbed.addClickHandler(new OnTextAreaClick());
		
		//Adding event handler
		AppClientFactory.getEventBus().addHandler(EmbedEnableEvent.TYPE, enableHandler);
		String iframeText ="";
		//Generation iframe content
		if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.COLLECTION_SEARCH)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)){
			 iframeText = "<iframe width=\"500px\" height=\"208px\" src=\"" + bitlyLink + "\" frameborder=\"0\" ></iframe>";
		}else{
			 iframeText = "<iframe width=\"1024px\" height=\"768px\" src=\"" + bitlyLink + "\" frameborder=\"0\" ></iframe>";
		}
		
		//Setting iframe content to text area.
		txtAreaEmbed.setText(iframeText);
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)){
			//txtAreaEmbed.getElement().removeClassName("org-ednovo-gooru-client-mvp-search-SearchEmbedVc_SearchEmbedVcUiBinderImpl_GenCss_style-embedTextArea");
			//txtAreaEmbed.getElement().addClassName("org-ednovo-gooru-client-mvp-search-SearchEmbedVc_SearchEmbedVcUiBinderImpl_GenCss_style-embedTextAreaShelf");
			txtAreaEmbed.setStyleName(ShelfCBundle.INSTANCE.css().embedTextAreaForShelf());
		}else{
			//txtAreaEmbed.getElement().removeClassName("org-ednovo-gooru-client-mvp-search-SearchEmbedVc_SearchEmbedVcUiBinderImpl_GenCss_style-embedTextAreaShelf");
			//txtAreaEmbed.getElement().addClassName("org-ednovo-gooru-client-mvp-search-SearchEmbedVc_SearchEmbedVcUiBinderImpl_GenCss_style-embedTextArea");
			txtAreaEmbed.setStyleName(ShelfCBundle.INSTANCE.css().embedTextAreaForCollectionSearch());
		}
		
		updateIsEditable(isEditable);
	}
	
	public class OnTextAreaClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if (isEditable){
				txtAreaEmbed.selectAll();
				txtAreaEmbed.setFocus(true);
			}
		}
	}
	public void updateIsEditable(boolean isEditable){
		this.isEditable = isEditable;
		if (!isEditable){
			txtAreaEmbed.addStyleName(ShelfCBundle.INSTANCE.css().shareLinkBoxDisabled());
		}else{
			txtAreaEmbed.removeStyleName(ShelfCBundle.INSTANCE.css().shareLinkBoxDisabled());
		}
		txtAreaEmbed.setVisible(true);
	}
}
