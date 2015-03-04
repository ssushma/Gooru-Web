///*******************************************************************************
// * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
// * 
// *  http://www.goorulearning.org/
// * 
// *  Permission is hereby granted, free of charge, to any person obtaining
// *  a copy of this software and associated documentation files (the
// *  "Software"), to deal in the Software without restriction, including
// *  without limitation the rights to use, copy, modify, merge, publish,
// *  distribute, sublicense, and/or sell copies of the Software, and to
// *  permit persons to whom the Software is furnished to do so, subject to
// *  the following conditions:
// * 
// *  The above copyright notice and this permission notice shall be
// *  included in all copies or substantial portions of the Software.
// * 
// *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
// ******************************************************************************/
//package org.ednovo.gooru.client.mvp.player;
//
//import java.util.Date;
//
//import org.ednovo.gooru.client.PlaceTokens;
//import org.ednovo.gooru.client.gin.AppClientFactory;
//import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
//import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
//import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataEvent;
//import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
//import org.ednovo.gooru.client.mvp.socialshare.SocialShareView;
//import org.ednovo.gooru.client.uc.AlertContentUc;
//import org.ednovo.gooru.client.uc.BrowserAgent;
//import org.ednovo.gooru.client.uc.ShareViewUc;
//import org.ednovo.gooru.shared.i18n.MessageProperties;
//import org.ednovo.gooru.shared.model.social.SocialShareDo;
//import org.ednovo.gooru.shared.model.user.UserDo;
//
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.dom.client.Document;
//import com.google.gwt.dom.client.Element;
//import com.google.gwt.dom.client.Style.Display;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.event.shared.EventBus;
//import com.google.gwt.event.shared.HandlerRegistration;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.HTMLPanel;
//import com.google.gwt.user.client.ui.Widget;
//import com.google.inject.Inject;
//import com.gwtplatform.mvp.client.proxy.PlaceRequest;
//
///**
// * @author Search Team
// * 
// */
//public class CollectionPlayView extends BasePopupViewWithHandlers<CollectionPlayUiHandlers> implements	IsCollectionPlayView {
//
//	//private CollectionOverviewPopupImpl gooruCollectionPlayer;
//	
//	private CollectionPlayWidget gooruCollectionPlayer;
//	
//	ShareViewUc shareContainer;  
//	
//	HTMLPanel ftmPanel;
//
//	Document doc = Document.get();
//
////	private static final String OOPS = i18n.GL0061;
//
//	String reloadUrl = null;
//
//	private PlaceRequest previousRequest = null;
//	long nowLong;
//	Date now;
//
//	boolean isIncrementedCollection;
//
//	private String gooruOid;
//	String countview=null;
//	String contentid=null;
//	boolean updateview=false;
//	
//	HandlerRegistration playerCloseHandler;
//	
//	 private MessageProperties i18n = GWT.create(MessageProperties.class);
//
//	/**
//	 * Class constructor , Assign styles for overview popup
//	 * 
//	 * @param eventBus
//	 *            {@link EventBus}
//	 */
//	@Inject
//	public CollectionPlayView(EventBus eventBus) {
//		super(eventBus);
//		isIncrementedCollection=false;
//		now = new Date();
//		nowLong = now.getTime();
// 	    nowLong = nowLong + (1000 * 60 * 60 * 4);
//	 	/*nowLong = nowLong + (1000 * 60 * 30);*/
//		now.setTime(nowLong);
//
//		//gooruCollectionPlayer = new CollectionOverviewPopupImpl();
//		shareContainer=new ShareViewUc("", "");
//		ftmPanel=new HTMLPanel("");
//		gooruCollectionPlayer = new CollectionPlayWidget();
//		gooruCollectionPlayer.setGlassEnabled(true);
////		gooruCollectionPlayer.getElement().setAttribute("style", "min-height:100%; min-width:100%;");
//		gooruCollectionPlayer.getElement().getStyle().setZIndex(99999);
//
//		String device = BrowserAgent.returnFormFactorView();
//		
//		if (device.equalsIgnoreCase("desktop")){
//			gooruCollectionPlayer.getElement().getStyle().setWidth(100, Unit.PCT);
//			gooruCollectionPlayer.getElement().getStyle().setHeight(100, Unit.PCT);
//		}else{
//			gooruCollectionPlayer.getElement().getStyle().setWidth(1200, Unit.PX);
//			gooruCollectionPlayer.getElement().getStyle().setHeight(755, Unit.PX);
//		}
//		
//		setAutoHideOnNavigationEventEnabled(true);
//	    gooruCollectionPlayer.getAddNewCollectionLabel().addClickHandler(new OnNewCollectionClick());
//		//reloadUrl = Window.Location.getHref();
//	    
//		try{
//			doc.getElementById("headerMainPanel").getStyle().setZIndex(0);
//			doc.getElementById("goToClasicInnerPanel").getStyle().setZIndex(0);
//		}catch(Exception e){
//		}
//	}
//	@Override
//	public void updateViewCount(String count, String contentId,
//			String whatToUpdate) {
//		if(count!=null||count!=""){
//		updateview=true;
//		this.countview=count;
//		this.contentid=contentId;
//		}
//		
//	}
//	@Override
//	public void setData(final String gooruOid, String token,boolean isEmbededCollection,boolean isShared) {
//		isIncrementedCollection=true;
//		this.gooruOid = gooruOid;
//		hideFromPopup(false);
//		doc.getElementById("uvTab").getStyle().setDisplay(Display.NONE);
//
//		EventBus bus=AppClientFactory.getEventBus();
//
//		try{
//			doc.getElementById("headerMainPanel").getStyle().setZIndex(0);
//			doc.getElementById("goToClasicInnerPanel").getStyle().setZIndex(0);
//		}catch(Exception e){
//		}
//		String loggedInGooruUserId=AppClientFactory.isAnonymous()?"ANONYMOUS":AppClientFactory.loggedInUser.getGooruUId();
//		gooruCollectionPlayer.setData(gooruOid, token, getSettings()
//				.getRestEndPoint(),getSettings().getDocViewerPoint(),
//				AppClientFactory.isAnonymous(), AppClientFactory
//						.getLoggedInUser().getSettings().getHomeEndPoint()
//						+ "/",getSettings().getApiKeyPoint(),bus,isEmbededCollection,loggedInGooruUserId,isShared);
//		gooruCollectionPlayer.isUserLoggedIn(AppClientFactory.isAnonymous(),loggedInGooruUserId, AppClientFactory.getLoggedInUser().getEmailId(), AppClientFactory.getLoggedInUser().getUsername());
//		if(playerCloseHandler!=null) {
//			playerCloseHandler.removeHandler();
//		}
//		playerCloseHandler = gooruCollectionPlayer.getCollectionPlayerCloseButton().addClickHandler(
//				new ClickHandler() {
//					@Override
//					public void onClick(ClickEvent e) {
//						gooruCollectionPlayer.stopCloseButtonDataLogEvents();
//						if(updateview){
//							if(countview!=null||countview!=""){
//							try{	
//								AppClientFactory.fireEvent(new UpdateSearchResultMetaDataEvent(countview, contentid, "views"));
//														
//							}
//							catch(NumberFormatException ex){
//								
//							}
//							catch(Exception exc){
//								
//							}
//							}
//							updateview=false;
//							}
//						try{
//							Element ifrmaeElement=Document.get().getElementById("collectionWebresourceContainer");
//							if(ifrmaeElement!=null){
//								ifrmaeElement.setAttribute("src", "");
//							}
//						}catch(Exception exception){
//						}
//							hideFromPopup(true);
//							hide();
//						try{
//							doc.getElementById("headerMainPanel").getStyle().clearZIndex();
//							doc.getElementById("goToClasicInnerPanel").getStyle().clearZIndex();
//						}catch(Exception ex){
//							
//						}
//						doc.getElementById("uvTab").getStyle()
//								.setDisplay(Display.BLOCK);
//						if (AppClientFactory.isAnonymous()
//								&& gooruCollectionPlayer.getUserDo() != null) {/*
//							if (AppClientFactory.isAnonymous() && gooruCollectionPlayer.getUserDo().getUsername() != null && gooruCollectionPlayer.getUserDo().getPassword() != null) {
//								AppClientFactory.getInjector().getAppService().signin(gooruCollectionPlayer.getUserDo().getEmailId(),gooruCollectionPlayer.getUserDo().getPassword(),new AsyncCallback<UserDo>() {
//
//													@Override
//													public void onSuccess(UserDo result) {
//														AppClientFactory.setLoggedInUser(result);
//														// refresh page
//														AppClientFactory.fireEvent(new SetHeaderEvent(result));
//														//redirect(reloadUrl);
//														AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());
//													}
//
//													@Override
//													public void onFailure(	Throwable caught) {
////														new AlertContentUc(i18n.GL0061(),caught.getMessage());
//													}
//												});
//							}
//						*/}
//						if (gooruCollectionPlayer.getIsResourceOrCollectionAdded()) {
//							//redirect(reloadUrl);
//							AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());
//						}
//
//						//
//						//AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
//
//						//
//
//					}
//				});
//		reloadUrl = Window.Location.getHref();
//	}
//
//	@Override
//	public void setMobileData(String gooruOid, String token) {
//
//	}
//
//	@Override
//	public Widget asWidget() {
//		return gooruCollectionPlayer;
//	}
//
//	@Override
//	protected String getDefaultView() {
//		return PlaceTokens.HOME;
//	}
//
//	native void redirect(String url)
//	/*-{
//	 		$wnd.location = url;
//	        $wnd.location.reload();
//	}-*/;
//	@Override
//	public void setUserLoginDetails(String sessionToken,String gooruUserId) {
//		gooruCollectionPlayer.setSession(sessionToken);
//		gooruCollectionPlayer.isUserLoggedIn(false,gooruUserId, AppClientFactory.getLoggedInUser().getEmailId(), AppClientFactory.getLoggedInUser().getUsername());
//    	gooruCollectionPlayer.showCollectionLikesDisLikes();
//	}
//	private class OnNewCollectionClick implements ClickHandler{
//		@Override
//		public void onClick(ClickEvent event) {
//			getUiHandlers().displayNewCollectionPopupView(event.getRelativeElement().getAttribute("resourceId"));
//		}
//	}
//	@Override
//	public void refreshShelfCollectionInPlay(String collectionId) {
//	    gooruCollectionPlayer.showResourceAddedSuccessMessage(collectionId);
//		gooruCollectionPlayer.refreshShelfCollectionList();
//		
//	}
//	public void ftmWidget(Widget w)
//	{
//		shareContainer.add(w);
//	}
//	@Override
//	public void addShareWidgetInPlay(String link,String rawUrl, String title, String desc, String shortenUrl, String type, String shareType) {
//		SocialShareDo shareDo = new SocialShareDo();
//		shareDo.setBitlylink(link);
//		shareDo.setRawUrl(rawUrl);
//		shareDo.setTitle(title);
//		shareDo.setDescription(desc);
//		shareDo.setThumbnailurl(shortenUrl);
//		shareDo.setCategoryType(type);
//		shareDo.setOnlyIcon(false);
//		shareDo.setShareType(shareType);
//		shareDo.setDecodeRawUrl(link);
//		SocialShareView socialView=new SocialShareView(shareDo);
//		gooruCollectionPlayer.setFTMWidget(socialView);
//	}
//
//	
//}
