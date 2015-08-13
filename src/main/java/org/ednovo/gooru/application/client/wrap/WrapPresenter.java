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
package org.ednovo.gooru.application.client.wrap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePresenter;
import org.ednovo.gooru.application.client.wrap.WrapPresenter.IsWrapProxy;
import org.ednovo.gooru.application.shared.model.user.UserDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.event.ActivateSearchBarEvent;
import org.ednovo.gooru.client.event.ActivateSearchBarHandler;
import org.ednovo.gooru.client.event.InvokeGooruGuideBubbleEvent;
import org.ednovo.gooru.client.event.InvokeGooruGuideBubbleHandler;
import org.ednovo.gooru.client.event.InvokeLoginEvent;
import org.ednovo.gooru.client.event.InvokeLoginHandler;
import org.ednovo.gooru.client.event.InvokeRegisterHandler;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualCBundle;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsTabCBundle;
import org.ednovo.gooru.client.mvp.folder.toc.FolderContainerCBundle;
import org.ednovo.gooru.client.mvp.home.LoginPopUpCBundle;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.home.event.HomeHandler;
import org.ednovo.gooru.client.mvp.home.event.PreFilterEvent;
import org.ednovo.gooru.client.mvp.home.event.PreFilterEventHandler;
import org.ednovo.gooru.client.mvp.home.event.SetDiscoverLinkEvent;
import org.ednovo.gooru.client.mvp.home.event.SetDiscoverLinkHandler;
import org.ednovo.gooru.client.mvp.play.collection.end.CollectionPlaySummaryCBundle;
import org.ednovo.gooru.client.mvp.prime.PrimePresenter;
import org.ednovo.gooru.client.mvp.profilepage.event.UpdateProfileHeaderImageEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.UserHeaderImageEventHandler;
import org.ednovo.gooru.client.mvp.search.SearchCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 * @author Search Team
 *
 */

public class WrapPresenter extends BasePresenter<IsWrapView, IsWrapProxy> implements InvokeLoginHandler, InvokeRegisterHandler, ActivateSearchBarHandler, InvokeGooruGuideBubbleHandler,HomeHandler,SetDiscoverLinkHandler,PreFilterEventHandler,UserHeaderImageEventHandler{


	private String  RESOURCE_SEARCH="resource-search";
	private String COLLECTION_SEARCH="collection-search";

	private HandlerRegistration nativePreviewHandlerRegistration;

	private static final String GOORU_USER_INACTIVE = "in-active";

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_VIEW = new Type<RevealContentHandler<?>>();

	@ProxyStandard
	public interface IsWrapProxy extends Proxy<WrapPresenter> {
	}

	@Inject
	public WrapPresenter(IsWrapView view, IsWrapProxy proxy) {
		super(view, proxy);
		addRegisteredHandler(InvokeLoginEvent.TYPE, this);
		addRegisteredHandler(ActivateSearchBarEvent.TYPE, this);
		addRegisteredHandler(InvokeGooruGuideBubbleEvent.TYPE, this);
		addRegisteredHandler(HomeEvent.TYPE, this);
		addRegisteredHandler(SetDiscoverLinkEvent.TYPE, this);
		addRegisteredHandler(PreFilterEvent.TYPE, this);
		addRegisteredHandler(UpdateProfileHeaderImageEvent.TYPE, this);

		//showPrefilterPopup();

//		AppClientFactory.getInjector().getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
//			@Override
//			public void onSuccess(UserDo loggedInUser) {
//				AppClientFactory.setLoggedInUser(loggedInUser);
//				setLoginData(loggedInUser);
//			}
//		});
		registerWindowEvents();

		getloggersStatus();

		loadResponsiveCss();

	}

	@Override
	protected final void revealInParent() {
		RevealContentEvent.fire(this, PrimePresenter.TYPE_VIEW, this);
	}

	@Override
	public void invokeLogin() {
		getView().invokeLogin();
	}

	public void setLoginData(UserDo user) {
		getView().setLoginData(user);
	}

	@Override
	public void invokeRegister() {
		getView().invokeRegister();
	}

	@Override
	public void activateSearchBar(boolean activate) {
		getView().activateSearchBar(activate);
	}

	@Override
	public void invokeGooruGuideBubble() {
//		getView().invokeGooruGuideBubble();

	}

	@Override
	public void activateClassicButton(boolean activate) {
		getView().activateClassicButton(activate);

	}

	@Override
	public void setSelected(HeaderTabType tabType) {

			getView().setDotsPanelSelection(tabType);

	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.home.event.SetDiscoverLinkHandler#setDiscoverLink(java.lang.String)
	 */
	@Override
	public void setDiscoverLink(String discoverLink) {
		getView().setDiscoverLinkFromLibrary(discoverLink);
	}

	@Override
	protected void onReset() {
		super.onReset();
		String nameToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(nameToken!=null&&nameToken.equalsIgnoreCase(RESOURCE_SEARCH)){
			getView().getSearchFiltersPanel().getElement().getStyle().setDisplay(Display.BLOCK);
			getView().getCollectionSearchFiltersPanel().getElement().getStyle().setDisplay(Display.NONE);
		}else if(nameToken!=null&&nameToken.equalsIgnoreCase(COLLECTION_SEARCH)){
			getView().getSearchFiltersPanel().getElement().getStyle().setDisplay(Display.NONE);
			getView().getCollectionSearchFiltersPanel().getElement().getStyle().setDisplay(Display.BLOCK);

		}
	}

	@Override
	public void openPreFilterPopup() {
	}

	@Override
	public void setUserHeaderProfileImage(String imageUrl) {
		getView().updateUserHeaderProfileImage(imageUrl);
	}


	/**
	 * Checks the status of loggers from property file whether it is enabled or not.
	 */
	private void getloggersStatus() {
		AppClientFactory.getInjector().getSearchService().isClientSideLoggersEnabled(new SimpleAsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				AppClientFactory.setClientLoggersEnabled(result);
			}

		});
	}

	private void registerWindowEvents(){
		nativePreviewHandlerRegistration = Event.addNativePreviewHandler(new NativePreviewHandler() {

			public void onPreviewNativeEvent(NativePreviewEvent event) {
				if(event.getTypeInt()==Event.ONMOUSEOVER){
					if(AppClientFactory.getUserStatus()!=null){
						Cookies.setCookie("gooru-active-user", AppClientFactory.getUserStatus(),getCurrentDateAndTime());
					}
					if((AppClientFactory.getUserStatus()==null || AppClientFactory.getUserStatus().trim().equals(GOORU_USER_INACTIVE)) && AppClientFactory.isUserflag()){
						AppClientFactory.setUserflag(false)	;
						if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.FOLDER_TOC)|| AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_COLLECTION) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.STUDY)){
							userLoggedOutheader();
						}
						else{
							redirectToLandingPage();
						}

					}

				}
			}
		});
	}

	/*
	 * If user logged out by staying on Discover or Study page on any one of the tab,
	 * this method will be called and header will reset on other tabs.
	 *
	 * */

	protected Date getCurrentDateAndTime() {
		Date date = new Date();
		Date updatedDate = new Date((date.getTime() + (1000 * 60 * 60 * 24)));//(1000 * 60 * 60 * 24)=24 hrs. **** 120060 = 2 mins
		return updatedDate;
	}

	private void userLoggedOutheader(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {
				AppClientFactory.getInjector().getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo loggedInUser) {
						AppClientFactory.setLoggedInUser(loggedInUser);
						AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
					}
				});
			}
		} );
	}


	/*
	 * If user logged out on any one of the tab,
	 * this method will be called to redirect to landing page on other tabs
	 *  and Log-in pop up will be invoked.
	 *
	 * */

	private void redirectToLandingPage(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {
				AppClientFactory.getInjector().getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo loggedInUser) {
						AppClientFactory.setLoggedInUser(loggedInUser);
						AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
						if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.STUDENT)){

						}else if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SHELF)){
						}else{
							Map<String, String> params = new HashMap<String,String>();
							params.put("loginEvent", "true");
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME, params);
						}
					}
				});
			}
		});
	}

	private void loadResponsiveCss(){
		StyleInjector.injectAtEnd("@media (max-width: 767px){"+SearchCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		StyleInjector.injectAtEnd("@media (max-width: 767px) and (orientation:portrait){"+SearchCBundle.INSTANCE.getResponsive1Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (max-width: 767px) and (orientation:landscape){"+SearchCBundle.INSTANCE.getResponsive2Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 480px) and (max-width: 767px){"+SearchCBundle.INSTANCE.getResponsive3Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 240px) and (max-width: 319px){"+SearchCBundle.INSTANCE.getResponsive4Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 320px) and (max-width: 479px){"+SearchCBundle.INSTANCE.getResponsive5Style().getText()+"}");
		StyleInjector.injectAtEnd("@media screen and (min-width: 768px){"+SearchCBundle.INSTANCE.getResponsive6Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 1200px){"+SearchCBundle.INSTANCE.getResponsive7Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 768px) and (max-width: 991px) {"+SearchCBundle.INSTANCE.getResponsive8Style().getText()+"}");

		SearchCBundle.INSTANCE.css().ensureInjected();

		StyleInjector.injectAtEnd("@media (min-width: 240px) and (max-width: 319px){"+LoginPopUpCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 320px) and (max-width: 479px){"+LoginPopUpCBundle.INSTANCE.getResponsive1Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 480px) and (max-width: 767px){"+LoginPopUpCBundle.INSTANCE.getResponsive2Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 768px) and (max-width: 991px){"+LoginPopUpCBundle.INSTANCE.getResponsive3Style().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 1200px){"+LoginPopUpCBundle.INSTANCE.getResponsive4Style().getText()+"}");
		StyleInjector.injectAtEnd("@media screen and (max-width: 767px) {"+LoginPopUpCBundle.INSTANCE.getResponsive5Style().getText()+"}");
		StyleInjector.injectAtEnd("@media screen and (min-width: 768px) {"+LoginPopUpCBundle.INSTANCE.getResponsive6Style().getText()+"}");

		LoginPopUpCBundle.INSTANCE.css().ensureInjected();

		StyleInjector.injectAtEnd("@media (max-width: 767px) {"+AnalyticsTabCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 768px) and (max-width: 991px) {"+AnalyticsTabCBundle.INSTANCE.getResponsive1Style().getText()+"}");

		AnalyticsTabCBundle.INSTANCE.css().ensureInjected();

		StyleInjector.injectAtEnd("@media (max-width: 767px) {"+CollectionSummaryIndividualCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 768px) and (max-width: 991px) {"+CollectionSummaryIndividualCBundle.INSTANCE.getResponsive1Style().getText()+"}");

		CollectionSummaryIndividualCBundle.INSTANCE.css().ensureInjected();

		StyleInjector.injectAtEnd("@media (max-width: 767px) {"+CollectionPlaySummaryCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		StyleInjector.injectAtEnd("@media (min-width: 768px) and (max-width: 991px) {"+CollectionPlaySummaryCBundle.INSTANCE.getResponsive1Style().getText()+"}");

		CollectionPlaySummaryCBundle.INSTANCE.css().ensureInjected();

		StyleInjector.injectAtEnd("@media (min-width: 480px) and (max-width: 767px){"+FolderContainerCBundle.INSTANCE.getResponsiveStyle().getText()+"}");
		FolderContainerCBundle.INSTANCE.css().ensureInjected();
	}

}
