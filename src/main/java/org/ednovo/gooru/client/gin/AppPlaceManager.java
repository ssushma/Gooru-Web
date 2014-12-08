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
package org.ednovo.gooru.client.gin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

/**
 * 
 * @fileName : AppPlaceManager.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 06-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
@Singleton
public class AppPlaceManager extends PlaceManagerImpl implements IsPlaceManager {

	private PlaceRequest defaultPlaceRequest;

	private PlaceRequest errorPlaceRequest;

	private PlaceRequest previousRequest = null;
	
	private PlaceRequest playerBackRequest=null;

	private boolean refreshPlace = true;
	
	private PlaceRequest previousRequestUrl;
	
	private PlaceRequest previousPlayerRequestUrl;
	
	private PlaceRequest searchMovedPlaceRequest=null;
	
	private String beforePlayerOpenSeoToken="";
	
	private String classpageEventId="";
	
	private boolean isLibraryEventTriggered=false;
	
	private Map<String,Boolean> libraryEventMap=new HashMap<String, Boolean>();
	
	private String isLibraryEventId=null;

	@Inject
	public AppPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, @AppDefaultPlace String place) {
		super(eventBus, tokenFormatter);
		this.defaultPlaceRequest = new PlaceRequest(place);
		this.errorPlaceRequest = new PlaceRequest(PlaceTokens.HOME);
	}

	@Override
	public void revealPlace(PlaceRequest place) {
		revealPlace(true, place);
	}

	@Override
	public void revealPlace(boolean refresh, PlaceRequest place) {
		if (previousRequest == null || !previousRequest.equals(place)) {
			previousRequest = getCurrentPlaceRequest();
			playerBackRequest=previousRequest;
		}
		setRefreshPlace(refresh);
		super.revealPlace(place);
	}
	
	@Override
	public void revealPlace(boolean refresh, PlaceRequest place,boolean isPlayerRequest) {
//		if (previousRequest != null && !previousRequest.equals(place)) {
//			playerBackRequest=previousRequest;
//		}
		setRefreshPlace(refresh);
		super.revealPlace(place);
	}
	
	@Override
	public PlaceRequest preparePlaceRequest(String viewToken, Map<String,String> params) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken); 
		if (params != null) {
			for (String key : params.keySet()) {
				placeRequest = placeRequest.with(key, params.get(key));
			}
		}
		return placeRequest;
	}

	@Override
	public void revealDefaultPlace() {
		revealPlace(defaultPlaceRequest);
	}

	@Override
	public void revealErrorPlace(String invalidHistoryToken) {
		revealPlace(errorPlaceRequest, true);
	}

	@Override
	public void revealPlace(String viewToken) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken);
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(String viewToken, String[]... params) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken);
		if (params != null) {
			for (String[] param : params) {
				if (param != null && param.length == 2) {
					placeRequest = placeRequest.with(param[0], param[1]);
				}
			}
		}
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(String viewToken, Map<String, String> params) {
		revealPlace(viewToken, params, false);
	}

	@Override
	public void revealPlace(String viewToken, Map<String, String> params, boolean onlyIfNew) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken); 
		if (params != null) {
			for (String key : params.keySet()) {
				placeRequest = placeRequest.with(key, params.get(key));
			}
		}
		
		/*if (onlyIfNew && placeRequest.equals(AppClientFactory.getPlaceManager().getCurrentPlaceRequest())) {
			
			return;
		}*/
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(PlaceRequest placeRequest, Map<String, String> params) {
		if (params != null) {
			for (String key : params.keySet()) {
				placeRequest = placeRequest.with(key, params.get(key));
			}
		}
		revealPlace(placeRequest);
	}

	@Override
	public String getRequestParameter(String key) {
		if (getCurrentPlaceRequest() != null) {
			return getCurrentPlaceRequest().getParameter(key, null);
		}
		return null;
	}

	@Override
	public String getRequestParameter(String key, String defaultValue) {
		if (getCurrentPlaceRequest() != null) {
			return getCurrentPlaceRequest().getParameter(key, defaultValue);
		}
		return null;
	}

	@Override
	public Integer getRequestParameterAsInt(String key) {
		String param = getRequestParameter(key);
		return (param != null) ? Integer.parseInt(param) : null;
	}

	@Override
	public Integer getRequestParameterAsInt(String key, String defaultValue) {
		String param = getRequestParameter(key, defaultValue);
		return (param != null) ? Integer.parseInt(param) : null;
	}

	@Override
	public boolean refreshPlace() {
		return refreshPlace;
	}

	public void setRefreshPlace(boolean refreshPlace) {
		this.refreshPlace = refreshPlace;
	}

	/**
	 * @return the previousRequest
	 */
	public PlaceRequest getPreviousRequest() {
		return previousRequest;
	}

	/**
	 * @return the previousRequest
	 */
	public PlaceRequest getPlayerPreviousRequest() {
		return playerBackRequest;
	}
	/**
	 * @param previousRequest
	 *            the previousRequest to set
	 */
	public void setPreviousRequest(PlaceRequest previousRequest) {
		this.previousRequest = previousRequest;
	}

	@Override
	public void revealPreviousPlace(boolean refresh, String defaultViewToken) {
		if (previousRequest != null) {
			revealPlace(refresh, previousRequest);
		} else {
			revealPlace(defaultViewToken);
		}
	}
	
	@Override
	public void revealPlayerPreviousPlace(boolean refresh, String defaultViewToken) {
		if (playerBackRequest != null) {
			revealPlace(refresh, playerBackRequest);
		} else {
			revealPlace(defaultViewToken);
		}
	}
	
	public void revealClosePlayer(){
		revealPlace(false, getPreviousPlayerRequestUrl());
	}

	@Override
	public void redirectPlace(String viewToken) {
		setRefreshPlace(true);
		super.revealPlace(new PlaceRequest(viewToken));
	}
	
	 @Override
	  public void revealPlace(final PlaceRequest request, final boolean updateBrowserUrl) {
		 setPreviousRequestUrl(request);
		 super.revealPlace(request, updateBrowserUrl);
	  }
	
	@Override
	 public PlaceRequest getCurrentPlaceRequest() {
	    if (getCurrentPlaceHierarchy().size() > 0) {
	    	PlaceRequest placeRequest=getCurrentPlaceHierarchy().get(getCurrentPlaceHierarchy().size() - 1);
	    	if(placeRequest.getNameToken().contains("!")){
	    		placeRequest=getModifiedPlaceRequest(placeRequest);
	    		getCurrentPlaceHierarchy().set(getCurrentPlaceHierarchy().size() - 1, placeRequest);
	    		return placeRequest;
	    	}
	    	if(placeRequest.getNameToken().contains(PlaceTokens.PREVIEW_PLAY)){
	    		placeRequest=getReplacedPlaceRequest(placeRequest);
	    		getCurrentPlaceHierarchy().set(getCurrentPlaceHierarchy().size() - 1, placeRequest);
	    		setPreviousRequestUrl(placeRequest);
	    		return placeRequest;
	    	}
	    	setPreviousRequestUrl(placeRequest);
	        return placeRequest;
	    } else {
	      return new PlaceRequest();
	    }
	  }
	
	public PlaceRequest getReplacedPlaceRequest(PlaceRequest placeRequest){
		PlaceRequest newPlaceRequest=new PlaceRequest(replaceNameToken(placeRequest.getNameToken()));
		Set<String> parameters=placeRequest.getParameterNames();
		Iterator<String> parmsItr= parameters.iterator();
		while (parmsItr.hasNext()) {
			String paramName=parmsItr.next();
			newPlaceRequest=newPlaceRequest.with(paramName, placeRequest.getParameter(paramName, ""));
		}
		return newPlaceRequest;
	}
	
	public PlaceRequest getModifiedPlaceRequest(PlaceRequest placeRequest){
		PlaceRequest newPlaceRequest=new PlaceRequest(modifyNameToken(placeRequest.getNameToken()));
		Set<String> parameters=placeRequest.getParameterNames();
		Iterator<String> parmsItr= parameters.iterator();
		while (parmsItr.hasNext()) {
			String paramName=parmsItr.next();
			newPlaceRequest=newPlaceRequest.with(paramName, placeRequest.getParameter(paramName, ""));
		}
		return newPlaceRequest;
	}
	public String modifyNameToken(String historyToken){
		  String unescapedHistoryToken = URL.decodeQueryString(historyToken);
		  if(unescapedHistoryToken.startsWith("!")){
			  unescapedHistoryToken=unescapedHistoryToken.substring(1);
		  }	  
		  return unescapedHistoryToken;
	}
	public String replaceNameToken(String historyToken){
		  String unescapedHistoryToken = URL.decodeQueryString(historyToken);
		  unescapedHistoryToken=unescapedHistoryToken.replaceAll(PlaceTokens.PREVIEW_PLAY, PlaceTokens.COLLECTION_PLAY);
		  return unescapedHistoryToken;
	}

	/**
	 * @return the previousRequestUrl
	 */
		public PlaceRequest getPreviousRequestUrl() {
			return previousRequestUrl;
		}
		
		/**
		 * @param previousRequestUrl the previousRequestUrl to set
		 */
		public void setPreviousRequestUrl(PlaceRequest previousRequestUrl) {
			String viewToken=previousRequestUrl.getNameToken();
			if(viewToken.equals(PlaceTokens.PREVIEW_PLAY)||viewToken.equals(PlaceTokens.COLLECTION_PLAY)||viewToken.equals(PlaceTokens.RESOURCE_PLAY)||viewToken.equals(PlaceTokens.COLLECTION)){
				String previousViewToken=this.previousRequestUrl!=null?this.previousRequestUrl.getNameToken():"";
				if(!previousViewToken.equals(PlaceTokens.PREVIEW_PLAY)&&!previousViewToken.equals(PlaceTokens.COLLECTION_PLAY)&&!previousViewToken.equals(PlaceTokens.RESOURCE_PLAY)){
					setPreviousPlayerRequestUrl(getPreviousRequestUrl());
					setBeforePlayerOpenSeoToken(Window.getTitle());
				}
				this.previousRequestUrl = previousRequestUrl;
			}else{
				this.previousRequestUrl = previousRequestUrl;
			}
		}
		
		/**
		 * @return the previousPlayerRequestUrl
		 */
		public PlaceRequest getPreviousPlayerRequestUrl() {
			return previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
		}
		public String getSeachEventPageLocation(){
			String pageLocation="home-search";
			if(getSearchMovedPlaceRequest()!=null){
				if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.HOME)||getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.RUSD_LIBRARY)
						||getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.SAUSD_LIBRARY)){
					pageLocation="home-search";
				}else if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)){
					pageLocation="shelf-search";
				}
				else if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.PROFILE_PAGE)){
					pageLocation="profile-search";					
				}
				else if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.EDIT_CLASSPAGE)){
					pageLocation="teach-search";			
				}
				else if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.STUDY)){
					pageLocation="study-search";			
				}
				else if(getSearchMovedPlaceRequest().getNameToken().equals(PlaceTokens.STUDENT)){
					pageLocation="study-search";			
				}
			}else{
				pageLocation="home-search";
			}
			return pageLocation;
		}
		
		public String getPageLocation(){
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			if(pageLocation.equals(PlaceTokens.COLLECTION_SEARCH)||pageLocation.equals(PlaceTokens.RESOURCE_SEARCH)){
				pageLocation=getSeachEventPageLocation();
			}else{
				if(pageLocation.equals(PlaceTokens.HOME)){
					String page=AppClientFactory.getPlaceManager().getRequestParameter("page",null);
					if(page!=null){
						if(page.equals("teach")){
							pageLocation="teach";
						}else if(page.equals("study")){
							pageLocation="study";
						}else{
							pageLocation="home";
						}
					}else{
						pageLocation="home";
					}
				}else if(pageLocation.equals(PlaceTokens.RUSD_LIBRARY)||pageLocation.equals(PlaceTokens.SAUSD_LIBRARY)){
					pageLocation="home";
				}else if(pageLocation.equals(PlaceTokens.SHELF)){
					pageLocation="shelf";
				}else if(pageLocation.equals(PlaceTokens.PROFILE_PAGE)){
					pageLocation="profile";
				}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
					pageLocation="teach";
				}else if(pageLocation.equals(PlaceTokens.STUDENT)){
					pageLocation="study";
				}else{
					pageLocation="home";
				}
			}
			return pageLocation;
		}
		public String getPlayerMode(){
			String mode=PlayerDataLogEvents.PREVIEW;
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			if(pageLocation.equals(PlaceTokens.COLLECTION_SEARCH)||pageLocation.equals(PlaceTokens.RESOURCE_SEARCH)){
				 mode=PlayerDataLogEvents.STUDY;
			}
			return mode;
		}
		public String getPlayerModeInTeach(){
			String mode=PlayerDataLogEvents.PREVIEW;
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			if(pageLocation.equals(PlaceTokens.COLLECTION_SEARCH)||pageLocation.equals(PlaceTokens.RESOURCE_SEARCH)){
				 mode=PlayerDataLogEvents.STUDY;
			}
			return mode;
		}
		public String getFolderIds(){
			String folderIds="";
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			if(pageLocation.equals(PlaceTokens.SHELF)){
				for(int i=1;i<4;i++){
					String folderId=placeRequest.getParameter("o"+i, "");
					if(folderId!=null&&!folderId.equals("")){
						folderIds=folderIds+folderId+"/";
					}
				}
			}
			return folderIds;
		}
		public String getFolderIdsInString(){
			String folderIds="";
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			if(pageLocation.equals(PlaceTokens.SHELF)){
				for(int i=1;i<4;i++){
					String folderId=placeRequest.getParameter("o"+i, "");
					if(folderId!=null&&!folderId.equals("")){
						folderIds=folderIds+folderId+"/";
					}
				}
			}
			return folderIds;
		}
		public String getDataLogClasspageId(){
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			String classpageId="";
			if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
				classpageId=placeRequest.getParameter("classpageid", "");
			}else if(pageLocation.equals(PlaceTokens.STUDENT)){
				classpageId=placeRequest.getParameter("id", "");
			}
			return classpageId;
		}
		public String getClasspageEventId(){
			PlaceRequest placeRequest=previousPlayerRequestUrl!=null?previousPlayerRequestUrl:getDefaultPlayerPlaceRequest();
			String pageLocation=placeRequest.getNameToken();
			String classpageEventId="";
			if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
				classpageEventId=this.classpageEventId;
			}else if(pageLocation.equals(PlaceTokens.STUDENT)){
				classpageEventId=this.classpageEventId;
			}
			return classpageEventId;
		}
		public void setClasspageEventId(String classpageEventId){
			this.classpageEventId=classpageEventId;
		}
		/**
		 * @param previousPlayerRequestUrl the previousPlayerRequestUrl to set
		 */
		public void setPreviousPlayerRequestUrl(PlaceRequest previousPlayerRequestUrl) {
			this.previousPlayerRequestUrl = previousPlayerRequestUrl;
		}
		
		public PlaceRequest getDefaultPlayerPlaceRequest(){
			return new PlaceRequest(PlaceTokens.HOME);
		}

		/** 
		 * This method is to get the beforePlayerOpenSeoToken
		 */
		public String getBeforePlayerOpenSeoToken() {
			return beforePlayerOpenSeoToken;
		}

		/** 
		 * This method is to set the beforePlayerOpenSeoToken
		 */
		public void setBeforePlayerOpenSeoToken(String beforePlayerOpenSeoToken) {
			this.beforePlayerOpenSeoToken = beforePlayerOpenSeoToken;
		}

		public PlaceRequest getSearchMovedPlaceRequest() {
			return searchMovedPlaceRequest;
		}

		public void setSearchMovedPlaceRequest(PlaceRequest searchMovedPlaceRequest) {
			this.searchMovedPlaceRequest = searchMovedPlaceRequest;
		}

		@Override
		public boolean isLibaryEventTriggered(String libraryName) {
			Boolean isLibraryEvent=libraryEventMap.get(libraryName);
			return isLibraryEvent!=null?isLibraryEvent:false;
		}

		@Override
		public String getLibaryEventId() {
			return this.isLibraryEventId;
		}
		
		@Override
		public void setLibraryEventId(String libraryEventId){
			this.isLibraryEventId=libraryEventId;
		}
		
		@Override
		public void setLibaryEventTriggered(String libraryName){
			libraryEventMap.put(libraryName, true);
			isLibraryEventTriggered=true;
		}
		
		@Override
		public void resetLibraryEventData(String libraryName){
			//isLibraryEventTriggered=false;
			libraryEventMap.remove(libraryName);
			isLibraryEventId=null;
		}
		
		

}