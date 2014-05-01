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
package org.ednovo.gooru.client.mvp.play.collection.preview;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.HomeCBundle;
import org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView;
import org.ednovo.gooru.client.mvp.play.collection.preview.metadata.NavigationConfirmPopup;
import org.ednovo.gooru.client.mvp.play.resource.body.ResourcePlayerMetadataView;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.tooltip.GlobalTooltipWithButton;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class PreviewPlayerView extends BasePopupViewWithHandlers<PreviewPlayerUiHandlers> implements IsPreviewPlayerView, MessageProperties{
	
	
	@UiField FlowPanel playerBodyContainer,navigationContainer;
	
	@UiField CollectionPlayerHeaderView headerView;
	
	private PopupPanel appPopUp;
	
	private boolean isInfoButtonActive=false;
	
	private boolean isShareButtonActive=false;
	
	private boolean isNarrationButtonActive=false;
	
	private boolean isNavigationButtonActive=false;
	
	private boolean isAddButtonActive=false;
	
	private boolean isFlagButtonActive=false; 
	
	private int userRating=0;
	
	GlobalTooltipWithButton globalTooltipWithButton;
	
	private static final String COLLECTION_RESOURCE_THUMBS_WIDGET_MODE="COLLECTION_RESOURCE_RATING";
	
	private HandlerRegistration autoHideHandler;

	private final EventBus eventBus;

	private static CollectionPlayerViewUiBinder uiBinder = GWT.create(CollectionPlayerViewUiBinder.class);

	interface CollectionPlayerViewUiBinder extends UiBinder<Widget, PreviewPlayerView> {
	}
	
	@Inject
	public PreviewPlayerView(EventBus eventBus){
		super(eventBus);
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.eventBus = eventBus;
		appPopUp=new PopupPanel();
		appPopUp.setGlassEnabled(true);
		appPopUp.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setPlayerContainer());
		appPopUp.add(uiBinder.createAndBindUi(this));
		headerView.getNavigationButton().addClickHandler(new ShowTabWidgetView("navigation"));
		headerView.getNarrationButton().addClickHandler(new ShowTabWidgetView("narration"));
		headerView.getShareButton().addClickHandler(new ShowTabWidgetView("share"));
		headerView.getInfoButton().addClickHandler(new ShowTabWidgetView("info"));
		headerView.getAddButton().addClickHandler(new ShowTabWidgetView("add"));
		getNavigationContainer().getElement().getStyle().setProperty("display", "none");
		headerView.getCloseButton().addClickHandler(new CloseResourcePlayerEvent());

		/*headerView.getThumbsDownButton().addClickHandler(new UpdateThumbsDownEvent());
		headerView.getThumbsUpButton().addClickHandler(new UpdateThumbsUpEvent());*/
		hidePlayerButtons(true,null);
		headerView.getFlagButton().setVisible(false);
		headerView.getFlagButton().addClickHandler(new ShowTabWidgetView("flag"));
		
		setAutoHideOnNavigationEventEnabled(true);
	}

	  @Override
	  public void setAutoHideOnNavigationEventEnabled(boolean autoHide) {
	    if (autoHide) {
	      if (autoHideHandler != null) {
	        return;
	      }
	      autoHideHandler = PreviewPlayerView.this.eventBus.addHandler(NavigationEvent.getType(), new NavigationHandler() {
	            @Override
	            public void onNavigation(NavigationEvent navigationEvent) {
	              if(!AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.PREVIEW_PLAY)){
	            	  closePreviewPlayer();
	            	  hideFromPopup(false);
	              } 
	            }
	          });
	    } else {
	      if (autoHideHandler != null) {
	        autoHideHandler.removeHandler();
	      }
	    }
	  }

	@Override
	public FlowPanel getPlayerBodyContainer() {
		return playerBodyContainer;
		
	}

	public FlowPanel getNavigationContainer() {
		return navigationContainer;
	}

	@Override
	public void setResourceTitle(String resourceTitle) {
		headerView.setResourceTitle(resourceTitle);
	}

	@Override
	public void enablePlayerButton(boolean isAddButtonEnable,boolean isInfoButtonEnable,
			boolean isShareButtonEnable, boolean isNarrationButtonEnable,
			boolean isNavigationButtonEnable,boolean isFlagButtonActive) {
		headerView.enableButtons(isAddButtonEnable,isInfoButtonEnable, isShareButtonEnable, isNarrationButtonEnable, isNavigationButtonEnable,isFlagButtonActive);
	}
	
	public class ShowTabWidgetView implements ClickHandler{
		String tabView="";
		public ShowTabWidgetView(String tabView){	
			this.tabView=tabView;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(tabView.equalsIgnoreCase("add")){
				MixpanelUtil.Player_Click_Add();
				setTabPlaceRequest(tabView,headerView.isAddButtonEnabled(),isAddButtonActive);
			}
			else if(tabView.equalsIgnoreCase("info")){
				setTabPlaceRequest(tabView,headerView.isInfoButtonEnabled(),isInfoButtonActive);
			}else if(tabView.equalsIgnoreCase("share")){
				setTabPlaceRequest(tabView,headerView.isShareButtonEnabled(),isShareButtonActive);
			}else if(tabView.equalsIgnoreCase("navigation")){
				setTabPlaceRequest(tabView,headerView.isNavigationButtonEnabled(),isNavigationButtonActive);
			}else if(tabView.equalsIgnoreCase("narration")){
				setTabPlaceRequest(tabView,headerView.isNarrationButtonEnabled(),isNarrationButtonActive);
			}else if(tabView.equalsIgnoreCase("flag")){
				setTabPlaceRequest(tabView,true,false);
			}
		}		
	}	
	public void setTabPlaceRequest(String tabView, boolean isButtonEnable,boolean isButtonActive){
		if(isButtonEnable){
			String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
			String resourceId=AppClientFactory.getPlaceManager().getRequestParameter("rid", null);
			String view=AppClientFactory.getPlaceManager().getRequestParameter("view", null);
			
			Map<String,String> params = new LinkedHashMap<String,String>();
			params.put("id", collectionId);
			params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
			
			if(resourceId!=null&&!resourceId.equalsIgnoreCase("")){
				if(isButtonActive){
					params.put("rid", resourceId);
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}else{
					params.put("rid", resourceId);
					params.put("tab", tabView);
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
					ResourcePlayerMetadataView.removePadding();
				}
			}
			else if(view!=null&&view.equalsIgnoreCase("end")){
				if(isButtonActive){
					params.put("view", "end");
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}else{
					params.put("tab", tabView);
					params.put("view", "end");
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}
			}else{
				if(isButtonActive){
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);

				}else{
					params.put("tab", tabView);
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}
			}
		}
	}
	
	@Override
    public void setStudentViewLink(){
    	String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
    	String studentLink="#"+PlaceTokens.COLLECTION_PLAY+"&id="+collectionId;
    	headerView.getStudentViewButton().setHref(studentLink);
    	headerView.getStudentViewButton().setTarget("_blank");
    
    }
		
	@Override
    public void setInSlot(Object slot, Widget content) {
		if(slot==PreviewPlayerPresenter.COLLECTION_PLAYER_TOC_PRESENTER_SLOT){
			    //getNavigationContainer().getElement().getStyle().setProperty("display", "none");
			getNavigationContainer().clear();
			getNavigationContainer().setVisible(false);
			if(content!=null){
				getNavigationContainer().add(content);
			}
		}else if(slot==PreviewPlayerPresenter.METADATA_PRESENTER_SLOT){
			getPlayerBodyContainer().clear();
			if(content!=null){
				getPlayerBodyContainer().add(content);
			}
		}  
	}

	@Override
	public void makeButtonActive(boolean makeAddButtionActive,boolean makeInfoButtionActive,boolean makeShareButtonActive, boolean makeNarrationButtonActive,
			boolean makeNavigationButtonActive, boolean makeFlagButtonActive) {
		headerView.makeButtonActive(makeAddButtionActive,makeInfoButtionActive, makeShareButtonActive, makeNarrationButtonActive, makeNavigationButtonActive,makeFlagButtonActive);
		setActiveButton(makeAddButtionActive,makeInfoButtionActive, makeShareButtonActive, makeNarrationButtonActive, makeNavigationButtonActive,makeFlagButtonActive);
		if(makeNavigationButtonActive || makeInfoButtionActive || makeShareButtonActive)
		{
			ResourcePlayerMetadataView.removePadding();
		}
		if(!AppClientFactory.isAnonymous() && makeAddButtionActive){
			ResourcePlayerMetadataView.removePadding();
		}
	}

	@Override
	public void clearActiveButton(boolean deselectAddButton,boolean deselectInfoButton,boolean deselectShareButtion,boolean deselectNarrationButton,boolean deselectNavigationButton,boolean deselectFlagButton) {
		headerView.clearActiveButton(deselectAddButton,deselectInfoButton, deselectShareButtion, deselectNarrationButton, deselectNavigationButton,deselectFlagButton);	
		setActiveButton(false,false,false,false,false,false);
		ResourcePlayerMetadataView.addPadding();
	}
	public void setActiveButton(boolean makeAddButtionActive,boolean makeInfoButtionActive,
			boolean makeShareButtonActive,boolean makeNarrationButtonActive,boolean makeNavigationButtonActive,boolean makeFlagButtonActive){
		this.isInfoButtonActive=makeInfoButtionActive;
		this.isShareButtonActive=makeShareButtonActive;
		this.isNarrationButtonActive=makeNarrationButtonActive;
		this.isNavigationButtonActive=makeNavigationButtonActive;
		this.isAddButtonActive=makeAddButtionActive;
		this.isFlagButtonActive=makeFlagButtonActive;
	}

	public class CloseResourcePlayerEvent implements ClickHandler{
		public void onClick(ClickEvent event) {
			if(!getUiHandlers().isOpenEndedAnswerSubmited()){
				new NavigationConfirmPopup() {
					@Override
					public void navigateToNextResource() {
						super.hide();
						hideFromPopup(true);
						closePreviewPlayer();
					}
				};
			}else{
				hideFromPopup(true);
				closePreviewPlayer();
			}
		}
	}
	
	@Override
	public void closePreviewPlayer() {
		hide();
		getUiHandlers().resetCollectionPlayer();
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	protected String getDefaultView() {
		return PlaceTokens.HOME;
	}	
	
	/*private class UpdateThumbsDownEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				getUiHandlers().showLoginPopupWidget(COLLECTION_RESOURCE_THUMBS_WIDGET_MODE);
			}else{
				int thumbsStaus=userRating==0||userRating==1?-1:0;
				getUiHandlers().updateResourceThumbsRating(thumbsStaus);
			}
		}
	}
	
	private class UpdateThumbsUpEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(AppClientFactory.isAnonymous()){
				getUiHandlers().showLoginPopupWidget(COLLECTION_RESOURCE_THUMBS_WIDGET_MODE);
			}else{
				int thumbsStaus=userRating==0||userRating==-1?1:0;
				getUiHandlers().updateResourceThumbsRating(thumbsStaus);
			}
		}
	}*/
	@Override
	public void updateThumbsRatingView(int userThumbRating) {
		/*userRating=userThumbRating;
		if(userThumbRating==0){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());
		}else if(userThumbRating==-1){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownActive());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());
		}else if(userThumbRating==1){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpActive());
		}*/
		/*String resourcePlayerFirstTimeUser = Cookies.getCookie("resourcePlayerFirstTimeUser");
		if(resourcePlayerFirstTimeUser==null){
			Cookies.setCookie("resourcePlayerFirstTimeUser", "1");
			globalTooltipWithButton=new GlobalTooltipWithButton(GL0542, GL0543);
			globalTooltipWithButton.setGlassStyleName(HomeCBundle.INSTANCE.css().playerAddToolTipGlassStyle());
			globalTooltipWithButton.setStyleName("");
			globalTooltipWithButton.getElement().getStyle().setZIndex(999999);
			globalTooltipWithButton.setPopupPosition(headerView.getAddButton().getAbsoluteLeft() + 7, headerView.getAddButton().getAbsoluteTop()+25);
			globalTooltipWithButton.show();
		}*/
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	
	public void resetThumbsButtons(){
		/*userRating=0;
		headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
		headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());*/
	}

	@Override
	public void hidePlayerButtons(boolean isHidePlayerButtons,String collectionId) {
		if(collectionId==null){
			headerView.getStudentViewButton().setVisible(!isHidePlayerButtons);
			headerView.getFlagButton().setVisible(isHidePlayerButtons);
			
		}else{
			headerView.getStudentViewButton().setVisible(isHidePlayerButtons);
			headerView.getFlagButton().setVisible(!isHidePlayerButtons);
		}
		headerView.getNavigationButton().setVisible(!isHidePlayerButtons);
		headerView.getNarrationButton().setVisible(!isHidePlayerButtons);
		headerView.getShareButton().setVisible(!isHidePlayerButtons);
		headerView.getInfoButton().setVisible(!isHidePlayerButtons);
		headerView.getAddButton().setVisible(!isHidePlayerButtons);
	}

	@Override
	public void makeFlagButtonOrange() {
		headerView.makeFlagButtonOrange();
	}
	
	public void hideStudentViewButton(){
		headerView.getStudentViewButton().setVisible(false);
	}

	/**
	 * This method is used to show first time Add tooltip popup.
	 */
	public void showAddToolTip(){
		String resourcePlayerFirstTimeUser = Cookies.getCookie("resourcePlayerFirstTimeUser");
		if(resourcePlayerFirstTimeUser==null){
			Cookies.setCookie("resourcePlayerFirstTimeUser", "1");
			globalTooltipWithButton=new GlobalTooltipWithButton(GL0681, GL0543);
			globalTooltipWithButton.setGlassStyleName(HomeCBundle.INSTANCE.css().playerAddToolTipGlassStyle());
			globalTooltipWithButton.setStyleName("");
			globalTooltipWithButton.getElement().getStyle().setZIndex(999999);
			globalTooltipWithButton.setPopupPosition(headerView.getAddButton().getAbsoluteLeft() + 7, headerView.getAddButton().getAbsoluteTop()+25);
			globalTooltipWithButton.show();
		}
	}
}
