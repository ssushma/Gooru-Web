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
package org.ednovo.gooru.client.mvp.play.resource.narration;

import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.style.PlayerStyleBundle;
import org.ednovo.gooru.client.uc.tooltip.GlobalTooltipWithButton;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourceNarrationView extends PopupViewWithUiHandlers<ResourceNarrationUiHandlers> implements IsResourceNarrationView{
	
	@UiField Image authorImage;
	@UiField HTML resourceTitle,narrationText;
	@UiField Label narrationCloseButton,authorName;
	@UiField Button okButton;
	public PopupPanel appPopUp;
	
	GlobalTooltipWithButton globalTooltipWithButton;
	
	private static ResourceNarrationViewUiBinder uiBinder = GWT.create(ResourceNarrationViewUiBinder.class);

	interface ResourceNarrationViewUiBinder extends UiBinder<Widget, ResourceNarrationView> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@Inject
	public ResourceNarrationView(EventBus eventsBus){
		super(eventsBus);
		appPopUp=new NarrationPopupPanel(true);
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		PlayerStyleBundle.INSTANCE.getPlayerStyleResource().ensureInjected();
		appPopUp.setStyleName(PlayerStyleBundle.INSTANCE.getPlayerStyleResource().narrationPopupContainer());
		narrationCloseButton.addClickHandler(new CloseNarrationPopupEvent());
		okButton.addClickHandler(new CloseNarrationPopupEvent());
		authorName.setText(i18n.GL0423());
		authorName.getElement().setId("lblAuthorName");
		authorName.getElement().setAttribute("alt",i18n.GL0423());
		authorName.getElement().setAttribute("title",i18n.GL0423());
		
		okButton.setText(i18n.GL0703());
		okButton.getElement().setId("btnOkButton");
		okButton.getElement().setAttribute("alt",i18n.GL0703());
		okButton.getElement().setAttribute("title",i18n.GL0703());
		
		resourceTitle.getElement().setId("htmlResourceTitle");
		narrationCloseButton.getElement().setId("lblNarrationCloseButton");
		authorImage.getElement().setId("imgAuthorImage");
		narrationText.getElement().setId("htmlNarrationText");
	}
	public boolean isShowingPopup(){
		return appPopUp.isShowing();
	}
	@Override
	public void setNarrationMetadata(CollectionItemDo collectionItemDo,String userName,String gooruUid){
		if (collectionItemDo!=null){
			String narration=collectionItemDo.getNarration();
			if(narration!=null){
				narration=narration.replaceAll("background-color", "");
			}
			narrationText.setHTML(narration !=null ? narration : "");
			narrationText.getElement().setAttribute("alt",narration !=null ? narration : "");
			narrationText.getElement().setAttribute("title",narration !=null ? narration : "");
			resourceTitle.setHTML(collectionItemDo.getItemSequence()+". "+removeHtmlTags(collectionItemDo.getResource().getTitle()));
			resourceTitle.getElement().setAttribute("alt",collectionItemDo.getItemSequence()+". "+removeHtmlTags(collectionItemDo.getResource().getTitle()));
			resourceTitle.getElement().setAttribute("title",collectionItemDo.getItemSequence()+". "+removeHtmlTags(collectionItemDo.getResource().getTitle()));
			setUserProfileImage(gooruUid);
			authorName.setText(userName);
			authorName.getElement().setAttribute("alt",userName);
			authorName.getElement().setAttribute("title",userName);
		}
	}
	private void setUserProfileImage(String profileUserId) {
		authorImage.setUrl(AppClientFactory.loggedInUser.getSettings().getProfileImageUrl()+profileUserId+".png");
	}
	@UiHandler("authorImage")
	public void setDefaultProfileImage(ErrorEvent event){
		authorImage.setUrl("images/settings/setting-user-image.png");
	}
	public void resetNattationData(){
		narrationText.setHTML("");
		narrationText.getElement().setAttribute("alt","");
		narrationText.getElement().setAttribute("title","");
		authorImage.getElement().removeAttribute("src");
		resourceTitle.setHTML("");
		resourceTitle.getElement().setAttribute("alt","");
		resourceTitle.getElement().setAttribute("title","");
		authorName.setText("");
		authorName.getElement().setAttribute("alt","");
		authorName.getElement().setAttribute("title","");
	}
	private String removeHtmlTags(String html){
        html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
        return html;
	}
	@Override
	public Widget asWidget() {
		return appPopUp;
	}
	@Override
	public void reset() {
		
	}
	@Override
	public void onLoad() {
		
	}
	@Override
	public void onUnload() {
		
	}
	private class CloseNarrationPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.CloseNarration();
			hide();
			hideNarrationPopup();
		}
	}
	public void hideNarrationPopup(){
		if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.PREVIEW_PLAY)){
			showAddToolTip();
		}
		resetNattationData();
		/*if(Document.get().getElementById("playerid")!=null){
	         final Element myPlayer = Document.get().getElementById("playerid");
	         if(myPlayer.getPropertyString("src").contains("youtube")){
	        	 try{
	        		 playVideo(myPlayer);
	        	 }
	        	 catch(Exception ex){
	        		 
	        	 }
	         }
		}*/
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String resourceId=AppClientFactory.getPlaceManager().getRequestParameter("rid", null);

		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		params.put("rid", resourceId);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(viewToken, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	public static native void pauseVideo(Element myPlayer) /*-{
 		myPlayer.pauseVideo();
	}-*/;
	public static native void playVideo(Element myPlayer) /*-{
  		myPlayer.playVideo();
   	}-*/;
	
	/**
	 * This method is used to show first time Add tooltip popup.
	 */
	public void showAddToolTip(){
/*		String resourcePlayerFirstTimeUser =null;
		resourcePlayerFirstTimeUser =Cookies.getCookie("resourcePlayerFirstTimeUser");
		if(resourcePlayerFirstTimeUser==null){
			Cookies.setCookie("resourcePlayerFirstTimeUser", "1");
			globalTooltipWithButton=new GlobalTooltipWithButton(i18n.GL0681, i18n.GL0543);
			globalTooltipWithButton.setGlassStyleName(HomeCBundle.INSTANCE.css().playerAddToolTipGlassStyle());
			globalTooltipWithButton.setStyleName("");
			globalTooltipWithButton.getElement().getStyle().setZIndex(999999);
			globalTooltipWithButton.setPopupPosition(Document.get().getElementById("addButton").getAbsoluteLeft()-16, Document.get().getElementById("addButton").getAbsoluteTop()+22);
			globalTooltipWithButton.show();
		}*/
	}
	
	private class NarrationPopupPanel extends PopupPanel{
		public NarrationPopupPanel(boolean isAutoHide){
			super(isAutoHide);
			this.setGlassEnabled(true);
			this.setStyleName("");
			this.getGlassElement().getStyle().setZIndex(999999);
			this.getElement().getStyle().setZIndex(999999);
		}
		public void hide(boolean isAutoHide){
			super.hide(isAutoHide);
			if(isAutoHide){
				hideNarrationPopup();
			}
		}
	}
}
