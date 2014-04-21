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
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInCollectionPlayEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPlayEvent;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.player.collection.client.view.collectionoverview.event.ShareListEvent;
import org.ednovo.gooru.player.collection.client.view.collectionoverview.event.UpdateSearchResultMetaDataEvent;

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
public class CollectionPlayPresenter extends BasePlacePresenter<IsCollectionPlayView, CollectionPlayPresenter.IsCollectionPlayProxy> implements CollectionPlayUiHandlers {

	BrowserAgent browserAgent = new BrowserAgent();
	
	private CollectionFormInPlayPresenter collectionFormInPlayPresenter;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.COLLECTION_PLAY_OLD)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsCollectionPlayProxy extends ProxyPlace<CollectionPlayPresenter> {
	}

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CollectionPlayPresenter(IsCollectionPlayView view, IsCollectionPlayProxy proxy,CollectionFormInPlayPresenter collectionFormInPlayPresenter) {
		super(view, proxy);
		this.collectionFormInPlayPresenter = collectionFormInPlayPresenter;
		getView().setUiHandlers(this);
		addRegisteredHandler(SetUserDetailsInCollectionPlayEvent.TYPE, this);
		addRegisteredHandler(RefreshCollectionInShelfListInPlayEvent.TYPE, this);
		addRegisteredHandler(ShareListEvent.TYPE, this);
		addRegisteredHandler(UpdateSearchResultMetaDataEvent.TYPE,this);
	}

	@Override
	protected void onReset() {
		super.onReset();
		getView().setData(getPlaceManager().getRequestParameter(GOORU_OID), AppClientFactory.getLoggedInUser().getToken(),isEmbededCollection(),isShare());
	}
	
	private boolean isEmbededCollection(){
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
	private boolean isShare(){
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
		return PlaceTokens.COLLECTION_PLAY;
	}
	
	@Override
	public void setUserLoginDetails(String sessionToken,String gooruUserId) {
		getView().setUserLoginDetails(sessionToken,gooruUserId);
		
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
	public void addShareWidgetInPlay(boolean isShared,String link,String rawUrl, String title, String desc, String shortenUrl, String type, String shareType) {
    	getView().addShareWidgetInPlay(link,rawUrl,title,desc,shortenUrl,type, shareType);
	}
	@Override
	public void updateSearchResultMetaData(String count, String contentId, String whatToUpdate){
		getView().updateViewCount(count, contentId, whatToUpdate);
		
		
	}
}
