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

package org.ednovo.gooru.client;

import org.ednovo.gooru.application.client.gin.AppInjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
/**
 *
 * @fileName : GooruEntry.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 06-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class GooruEntry implements EntryPoint {

	private final AppInjector appInjector = GWT.create(AppInjector.class);

//	private HandlerRegistration nativePreviewHandlerRegistration;

	private static final String GOORU_USER_INACTIVE = "in-active";


	public GooruEntry(){
		DelayedBindRegistry.bind(appInjector);
	}


	public void onModuleLoad() {

		/**
		 * Capturing all uncaught exception on client side.
		 */
//		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
//
//			@Override
//			public void onUncaughtException(Throwable e) {
//				Throwable unwrapped = getExceptionToDisplay(e);
//				AppClientFactory.printSevereLogger("Exception Caught !! "+unwrapped.getMessage());
//			}
//		});
//
//		ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
//	    loadLibraries.add(LoadLibrary.ADSENSE);
//	    loadLibraries.add(LoadLibrary.DRAWING);
//	    loadLibraries.add(LoadLibrary.GEOMETRY);
//	    loadLibraries.add(LoadLibrary.PANORAMIO);
//	    loadLibraries.add(LoadLibrary.PLACES);
//	    loadLibraries.add(LoadLibrary.WEATHER);
//	    loadLibraries.add(LoadLibrary.VISUALIZATION);

//	    AppClientFactory.setAppGinjector(appInjector);
//		appInjector.getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
//			@Override
//			public void onSuccess(UserDo loggedInUser) {
//				AppClientFactory.setLoggedInUser(loggedInUser);
//				UcCBundle.INSTANCE.css().ensureInjected();
//				HomeCBundle.INSTANCE.css().ensureInjected();
//				AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
//				appInjector.getPlaceManager().revealCurrentPlace();
//				AppClientFactory.setProtocol(getHttpOrHttpsProtocol());
//				registerWindowEvents();
//			}
//		});
//		AppClientFactory.setAppGinjector(appInjector);
	}


//	private void registerWindowEvents(){
//		nativePreviewHandlerRegistration = Event.addNativePreviewHandler(new NativePreviewHandler() {
//
//			public void onPreviewNativeEvent(NativePreviewEvent event) {
//				if(event.getTypeInt()==Event.ONMOUSEOVER){
//					if(AppClientFactory.getUserStatus()!=null){
//						Cookies.setCookie("gooru-active-user", AppClientFactory.getUserStatus(),getCurrentDateAndTime());
//					}
//					if((AppClientFactory.getUserStatus()==null || AppClientFactory.getUserStatus().trim().equals(GOORU_USER_INACTIVE)) && AppClientFactory.isUserflag()){
//						AppClientFactory.setUserflag(false)	;
//						if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.FOLDER_TOC)|| AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_COLLECTION) || AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.STUDY)){
//							userLoggedOutheader();
//						}
//						else{
//							redirectToLandingPage();
//						}
//
//					}
//
//				}
//			}
//		});
//	}

	/*
	 * If user logged out by staying on Discover or Study page on any one of the tab,
	 * this method will be called and header will reset on other tabs.
	 *
	 * */

//	protected Date getCurrentDateAndTime() {
//		Date date = new Date();
//		Date updatedDate = new Date((date.getTime() + (1000 * 60 * 60 * 24)));//(1000 * 60 * 60 * 24)=24 hrs. **** 120060 = 2 mins
//		return updatedDate;
//	}
//
//	private void userLoggedOutheader(){
//		appInjector.getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
//			@Override
//			public void onSuccess(UserDo loggedInUser) {
//				AppClientFactory.setLoggedInUser(loggedInUser);
//				UcCBundle.INSTANCE.css().ensureInjected();
//				HomeCBundle.INSTANCE.css().ensureInjected();
//				AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
//			}
//		});
//	}


	/*
	 * If user logged out on any one of the tab,
	 * this method will be called to redirect to landing page on other tabs
	 *  and Log-in pop up will be invoked.
	 *
	 * */

//	private void redirectToLandingPage(){
//		appInjector.getAppService().getLoggedInUser(new SimpleAsyncCallback<UserDo>() {
//			@Override
//			public void onSuccess(UserDo loggedInUser) {
//				AppClientFactory.setLoggedInUser(loggedInUser);
//				UcCBundle.INSTANCE.css().ensureInjected();
//				HomeCBundle.INSTANCE.css().ensureInjected();
//				AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(loggedInUser);
//				if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.STUDENT)){
//
//				}else if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SHELF)){
//					AppClientFactory.fireEvent(new DisplayNoCollectionEvent());
//				}else{
//					Map<String, String> params = new HashMap<String,String>();
//					params.put("loginEvent", "true");
//					appInjector.getPlaceManager().revealPlace(PlaceTokens.HOME, params);
//				}
//			}
//		});
//	}
//
//	public String getHttpOrHttpsProtocol() {
//		return Window.Location.getProtocol();
//	}
//
//	/**
//	 *  Method used to unwrap GWT umbrella exception.
//	 *
//	 * @param e {@link Throwable}
//	 * @return {@link Throwable}
//	 */
//	public Throwable getExceptionToDisplay(Throwable e) {
//	    if(e instanceof UmbrellaException) {
//	      UmbrellaException ue = (UmbrellaException) e;
//	      if(ue.getCauses().size() == 1) {
//	        return getExceptionToDisplay(ue.getCauses().iterator().next());
//	      }
//	    }
//	    return e;
//	  }
}
