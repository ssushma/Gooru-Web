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

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInPlayEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPlayEvent;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.event.ShareListEvent;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.event.UpdateSearchResultMetaDataEvent;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

/**
 * @author Search Team
 *
 */
public class ResourcePlayPresenter extends BasePlacePresenter<IsResourcePlayView, ResourcePlayPresenter.IsResourcePlayProxy> implements ResourcePlayUiHandlers {
	
	protected static final String PLAYER_NAME = "pn";

	BrowserAgent browserAgent = new BrowserAgent();
	
	private CollectionFormInPlayPresenter collectionFormInPlayPresenter;

	@ProxyCodeSplit
	@NameToken(PlaceTokens.RESOURCE_PLAY_OLD)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsResourcePlayProxy extends ProxyPlace<ResourcePlayPresenter> {
	}

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public ResourcePlayPresenter(IsResourcePlayView view, IsResourcePlayProxy proxy,CollectionFormInPlayPresenter collectionFormInPlayPresenter) {
		super(view, proxy);
		this.collectionFormInPlayPresenter=collectionFormInPlayPresenter;
		getView().setUiHandlers(this);
		addRegisteredHandler(SetUserDetailsInPlayEvent.TYPE, this);
		addRegisteredHandler(RefreshCollectionInShelfListInPlayEvent.TYPE, this);
		addRegisteredHandler(ShareListEvent.TYPE, this);
		addRegisteredHandler(UpdateSearchResultMetaDataEvent.TYPE,this);
	}

	@Override
	public void onReset() {
		super.onReset();
		getView().setData(getPlaceManager().getRequestParameter(GOORU_OID), AppClientFactory.getLoggedInUser().getToken(), getPlaceManager().getRequestParameter(PLAYER_NAME),isEmbededResource(),isShared());
	}
	
	private boolean isEmbededResource(){
		if(getPlaceManager().getRequestParameter("embed")!=null){
			if(getPlaceManager().getRequestParameter("embed").equalsIgnoreCase("true")){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	private boolean isShared(){
		if(getPlaceManager().getRequestParameter("share")!=null){
			if(getPlaceManager().getRequestParameter("share").equalsIgnoreCase("true")){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.RESOURCE_PLAY;
	}

	@Override
	public void setUserLoginDetails(String sessionToken) {
		getView().setUserLoginDetails(sessionToken);
		
	}
	@Override
	public void displayNewCollectionPopupView(String resourceId){
		addToPopupSlot(collectionFormInPlayPresenter);
		collectionFormInPlayPresenter.setResourceUid(resourceId);
	}

	@Override
	public void refreshCollectionInShelfListInPlay(String collectionId) {
		getView().refreshShelfCollectionInPlay(collectionId);
		
	}

	@Override
	public void addShareWidgetInPlay(boolean isShared,String link, String rawUrl,String title, String desc, String shortenUrl, String type, String shareType) {
		getView().addShareWidgetInPlay(link,rawUrl,title,desc,shortenUrl,type, shareType);
		
	}

	@Override
	public void updateSearchResultMetaData(String count, String contentId,
			String whatToUpdate) {
		if(count!=null){
		getView().updateResourceView(count, contentId, whatToUpdate);
		}
		
	}
	
}
