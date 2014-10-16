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
package org.ednovo.gooru.client.mvp.player;

import java.util.Date;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.client.mvp.socialshare.SocialShareView;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.ShareViewUc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.social.SocialShareDo;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 * 
 */
public class ResourcePlayView extends
		BasePopupViewWithHandlers<ResourcePlayUiHandlers> implements
		IsResourcePlayView {

	private ResourcePlayWidget gooruResourcePlayer;

	Document doc = Document.get();
	String reloadUrl = null;
	long nowLong;
	Date now;
	boolean isIncremented;
	ShareViewUc shareContainer;
	HTMLPanel ftmPanel;

	private String gooruOid;
	String viewCount;
	String contentId;

	HandlerRegistration playerCloseHandler;
	
	 private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor, style for resource player popup panel
	 * 
	 * @param eventBus
	 *            {@link EventBus}
	 */
	@Inject
	public ResourcePlayView(EventBus eventBus) {
		super(eventBus);
		// addShareWidgetInPlay();
		isIncremented = false;
		now = new Date();
		nowLong = now.getTime();
		nowLong = nowLong + (1000 * 60 * 60 * 4);
		// nowLong = nowLong + (1000 * 60 * 30);
		now.setTime(nowLong);
		shareContainer = new ShareViewUc("", "");
		ftmPanel = new HTMLPanel("");
		gooruResourcePlayer = new ResourcePlayWidget();
		gooruResourcePlayer.setGlassEnabled(true);
		gooruResourcePlayer.getElement().getStyle().setZIndex(999);
		setAutoHideOnNavigationEventEnabled(true);
		
		try{
			doc.getElementById("headerMainPanel").getStyle().setZIndex(0);
			doc.getElementById("goToClasicInnerPanel").getStyle().setZIndex(0);
		}catch(Exception e){
		}
		
		gooruResourcePlayer.getAddNewCollectionLabel().addClickHandler(
				new OnNewCollectionClick());
		if(playerCloseHandler!=null) {
			playerCloseHandler.removeHandler();
		}
		playerCloseHandler = gooruResourcePlayer.getCloseButton().addClickHandler(

		new ClickHandler() {
			@Override
			public void onClick(ClickEvent e) {
				try{
				if(viewCount!=null||viewCount!=""){
				AppClientFactory.fireEvent(new UpdateSearchResultMetaDataEvent(viewCount, gooruOid, "views"));
				}	
				}
				catch(NumberFormatException exe){
				}
				catch(NullPointerException ex){}
				gooruResourcePlayer.stopResourcePlayerDataLogEvent();

				try {
					Element ifrmaeElement = Document.get().getElementById(
							"resourcePlayerContainer");
					if (ifrmaeElement != null) {
						ifrmaeElement.setAttribute("src", "");
					}
				} catch (Exception exception) {
				}

				gooruResourcePlayer.getResourcePlayerContainer().clear();
				hideFromPopup(true);
				hide();
				gooruResourcePlayer.stopHintsExplanationEvent();
				gooruResourcePlayer.stopQuestionEvent();
				
				try{
					doc.getElementById("headerMainPanel").getStyle().clearZIndex();
					doc.getElementById("goToClasicInnerPanel").getStyle().clearZIndex();
				}catch(Exception ex){
					
				}
			
				doc.getElementById("uvTab").getStyle()
						.setDisplay(Display.BLOCK);
				if (AppClientFactory.isAnonymous()
						&& gooruResourcePlayer.getUserDo() != null) {
					if (gooruResourcePlayer.getUserDo().getUsername() != null
							&& gooruResourcePlayer.getUserDo()
									.getUserPassword() != null) {
						AppClientFactory
								.getInjector()
								.getAppService()
								.signin(gooruResourcePlayer.getUserDo()
										.getEmailId(),
										gooruResourcePlayer.getUserDo()
												.getUserPassword(),
										new AsyncCallback<UserDo>() {
											@Override
											public void onSuccess(UserDo result) {
												AppClientFactory
														.setLoggedInUser(result);
												// refresh page
												AppClientFactory
														.fireEvent(new SetHeaderEvent(
																result));
												// redirect(reloadUrl);
												AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());
											}

											@Override
											public void onFailure(
													Throwable caught) {
//												new AlertContentUc(i18n.GL0061(),caught.getMessage());
											}
										});
					}
				}
				/*if (gooruResourcePlayer.getIsResourceAdded()) {
					// redirect(reloadUrl);
					AppClientFactory
							.fireEvent(new RefreshUserShelfCollectionsEvent());

				}*/
				AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());

				//AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
				// /

				//
			}
		});

		reloadUrl = Window.Location.getHref();
		Window.enableScrolling(true);
	}
	@Override
	public void updateResourceView(String count, String resourceId, String type) {
		if(count!=null||count!=""){
		viewCount=count;
		}
	}
	@Override
	public void setData(String gooruOid, String token, String playerName,boolean isEmbededResource,boolean isShared) {
		this.gooruOid = gooruOid;
		isIncremented = true;
		hideFromPopup(false);
		doc.getElementById("uvTab").getStyle().setDisplay(Display.NONE);
		try{
			doc.getElementById("headerMainPanel").getStyle().setZIndex(0);
			doc.getElementById("goToClasicInnerPanel").getStyle().setZIndex(0);
		}catch(Exception e){
		}
		
		EventBus bus = AppClientFactory.getEventBus();

		gooruResourcePlayer.setData(gooruOid, token, getSettings()
				.getRestEndPoint(), getSettings().getDocViewerPoint(),
				playerName, AppClientFactory.isAnonymous(), AppClientFactory
						.getLoggedInUser().getSettings().getHomeEndPoint()
						+ "/", getSettings().getApiKeyPoint(), bus,isEmbededResource, isShared);
		gooruResourcePlayer.setLoggedUserData(AppClientFactory.getLoggedInUser().getGooruUId());
	}

	public void setUserLoginDetails(String sessionToken) {
		gooruResourcePlayer.setSessionToken(sessionToken);
		gooruResourcePlayer.isUserLoggedIn(false);
		gooruResourcePlayer.getUserRatingOnResource();
	}

	@Override
	public void setMobileData(String gooruOid, String token, String playerName) {

	}

	@Override
	public Widget asWidget() {
		return gooruResourcePlayer;
	}

	@Override
	protected String getDefaultView() {
		return PlaceTokens.HOME;
	}

	native void redirect(String url)
	/*-{
	 		$wnd.location = url;
	        $wnd.location.reload();
	}-*/;

	private class OnNewCollectionClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			getUiHandlers().displayNewCollectionPopupView(
					event.getRelativeElement().getAttribute("resourceId"));
		}
	}

	@Override
	public void refreshShelfCollectionInPlay(String collectionId) {
		gooruResourcePlayer.showResourceAddedSuccessMessage(collectionId);
		gooruResourcePlayer.refreshShelfCollectionList();

	}

	public void ftmWidget(Widget w) {
		shareContainer.add(w);
	}

	@Override
	public void addShareWidgetInPlay(String link,String rawUrl, String title, String desc,
			String shortenUrl, String type, String shareType) {

		SocialShareDo shareDo = new SocialShareDo();
		shareDo.setBitlylink(link);
		shareDo.setRawUrl(rawUrl);
		shareDo.setTitle(title);
		shareDo.setDescription(desc);
		shareDo.setThumbnailurl(shortenUrl);
		shareDo.setCategoryType(type);
		shareDo.setOnlyIcon(false);
		shareDo.setShareType(shareType);
		shareDo.setDecodeRawUrl(link);
		SocialShareView socialView = new SocialShareView(shareDo);

		gooruResourcePlayer.setFTMWidget(socialView);

	}

	
}
