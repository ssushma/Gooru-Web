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
package org.ednovo.gooru.client.mvp.play.collection;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView;
import org.ednovo.gooru.client.uc.PlayerBundle;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionPlayerView extends BasePopupViewWithHandlers<CollectionPlayerUiHandlers> implements IsCollectionPlayerView{
	
	
	@UiField FlowPanel playerBodyContainer,navigationContainer;
	
	@UiField CollectionPlayerHeaderView headerView;
	
	private PopupPanel appPopUp;
	
	private boolean isInfoButtonActive=false;
	
	private boolean isShareButtonActive=false;
	
	private boolean isNarrationButtonActive=false;
	
	private boolean isNavigationButtonActive=false;
	
	private boolean isAddButtonActive=false;
	
	private int userRating=0;
	
	private static final String COLLECTION_RESOURCE_THUMBS_WIDGET_MODE="COLLECTION_RESOURCE_RATING";
	
	private static CollectionPlayerViewUiBinder uiBinder = GWT.create(CollectionPlayerViewUiBinder.class);

	interface CollectionPlayerViewUiBinder extends UiBinder<Widget, CollectionPlayerView> {
	}
	
	@Inject
	public CollectionPlayerView(EventBus eventBus){
		super(eventBus);
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
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
		headerView.getThumbsDownButton().addClickHandler(new UpdateThumbsDownEvent());
		headerView.getThumbsUpButton().addClickHandler(new UpdateThumbsUpEvent());
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
			boolean isNavigationButtonEnable) {
		headerView.enableButtons(isAddButtonEnable,isInfoButtonEnable, isShareButtonEnable, isNarrationButtonEnable, isNavigationButtonEnable);
	}
	
	public class ShowTabWidgetView implements ClickHandler{
		String tabView="";
		public ShowTabWidgetView(String tabView){
			this.tabView=tabView;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(tabView.equalsIgnoreCase("add")){
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
			}			
		}		
	}	
	public void setTabPlaceRequest(String tabView, boolean isButtonEnable,boolean isButtonActive){
		if(isButtonEnable){
			String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
			String resourceId=AppClientFactory.getPlaceManager().getRequestParameter("rid", null);
			String view=AppClientFactory.getPlaceManager().getRequestParameter("view", null);
			if(resourceId!=null&&!resourceId.equalsIgnoreCase("")){
				if(isButtonActive){
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId).with("rid", resourceId);
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}else{
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId).with("rid", resourceId).with("tab", tabView);
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}
			}
			else if(view!=null&&view.equalsIgnoreCase("end")){
				if(isButtonActive){
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId).with("view", "end");
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}else{
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId).with("tab", tabView).with("view", "end");
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}
			}else{
				if(isButtonActive){
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId);
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}else{
					PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionId).with("tab", tabView);
					AppClientFactory.getPlaceManager().revealPlace(false,request,true);
				}
			}
		}
		
	}
		
	@Override
    public void setInSlot(Object slot, Widget content) {
		if(slot==CollectionPlayerPresenter.COLLECTION_PLAYER_TOC_PRESENTER_SLOT){
			    //getNavigationContainer().getElement().getStyle().setProperty("display", "none");
			getNavigationContainer().clear();
			getNavigationContainer().setVisible(false);
			if(content!=null){
				getNavigationContainer().add(content);
			}
		}else if(slot==CollectionPlayerPresenter.METADATA_PRESENTER_SLOT){
			getPlayerBodyContainer().clear();
			getPlayerBodyContainer().add(content);
		}  
	}

	@Override
	public void makeButtonActive(boolean makeAddButtionActive,boolean makeInfoButtionActive,boolean makeShareButtonActive, boolean makeNarrationButtonActive,
			boolean makeNavigationButtonActive) {
		headerView.makeButtonActive(makeAddButtionActive,makeInfoButtionActive, makeShareButtonActive, makeNarrationButtonActive, makeNavigationButtonActive);
		setActiveButton(makeAddButtionActive,makeInfoButtionActive, makeShareButtonActive, makeNarrationButtonActive, makeNavigationButtonActive);
	}

	@Override
	public void clearActiveButton(boolean deselectAddButton,boolean deselectInfoButton,boolean deselectShareButtion,boolean deselectNarrationButton,boolean deselectNavigationButton) {
		headerView.clearActiveButton(deselectAddButton,deselectInfoButton, deselectShareButtion, deselectNarrationButton, deselectNavigationButton);	
		setActiveButton(false,false,false,false,false);
	}
	public void setActiveButton(boolean makeAddButtionActive,boolean makeInfoButtionActive,
			boolean makeShareButtonActive,boolean makeNarrationButtonActive,boolean makeNavigationButtonActive){
		this.isInfoButtonActive=makeInfoButtionActive;
		this.isShareButtonActive=makeShareButtonActive;
		this.isNarrationButtonActive=makeNarrationButtonActive;
		this.isNavigationButtonActive=makeNavigationButtonActive;
		this.isAddButtonActive=makeAddButtionActive;
	}

	public class CloseResourcePlayerEvent implements ClickHandler{
		public void onClick(ClickEvent event) {
			hideFromPopup(true);
			hide();
			getUiHandlers().resetCollectionPlayer();
		}
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	protected String getDefaultView() {
		return PlaceTokens.HOME;
	}	
	
	private class UpdateThumbsDownEvent implements ClickHandler{
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
	}
	@Override
	public void updateThumbsRatingView(int userThumbRating) {
		System.out.println("user rating in view==>"+userThumbRating);
		userRating=userThumbRating;
		if(userThumbRating==0){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());
		}else if(userThumbRating==-1){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownActive());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());
		}else if(userThumbRating==1){
			headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
			headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpActive());
		}
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	
	public void resetThumbsButtons(){
		userRating=0;
		headerView.getThumbsDownButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsDownNormal());
		headerView.getThumbsUpButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().thumbsUpNormal());
	}
}
