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
package org.ednovo.gooru.client.mvp.profilepage.tab.content;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter;
import org.ednovo.gooru.client.service.ProfilePageServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
 */
public class ProfilePageContentTabPresenter extends PresenterWidget<IsProfilePageContentTabView> implements ProfilePageContentTabUiHandlers {

	private ProfilePageListPresenter profilePageListPresenter = null;
	
	@Inject
	private ProfilePageServiceAsync profilePageService;
	
	private SimpleAsyncCallback<List<CollectionItemDo>> getWorkSpaceAsyncCallback;

	private int PARENT_FOLDER_ID = 0;
	
	private boolean isProfilePageList = false;
	
	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public ProfilePageContentTabPresenter(EventBus eventBus, IsProfilePageContentTabView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
		setGetWorkSpaceAsyncCallback(new SimpleAsyncCallback<List<CollectionItemDo>>() {
			@Override
			public void onSuccess(List<CollectionItemDo> collectionItemDo) {
				
				if(collectionItemDo.size()>0) {
					String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
					if(folderId!=null) {
						getView().setMetaData(collectionItemDo.get(PARENT_FOLDER_ID));
					}
				}
				getView().setContentItemData(collectionItemDo);
			}
		});
	}
	
	@Override
	public void onReveal() {
		super.onReveal();
		if(isProfilePageList==false) {
			isProfilePageList = true;
			setInSlot(TYPE_PUBLIC_SHELF_VIEW, getProfilePageListPresenter());
		}
	}
	
	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset(){
		getView().clearContentItemData();
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
		if(folderId!=null) {
			getProfilePageService().getFolders(folderId, getGetWorkSpaceAsyncCallback());
		}
	}
	
	public void setProfilePageListPresenter(ProfilePageListPresenter profilePageListPresenter){
		this.profilePageListPresenter = profilePageListPresenter;
	}
	
	public ProfilePageListPresenter getProfilePageListPresenter() {
		return profilePageListPresenter;
	}
	
	/** 
	 * This method is to get the profilePageService
	 */
	public ProfilePageServiceAsync getProfilePageService() {
		return profilePageService;
	}

	/** 
	 * This method is to set the profilePageService
	 */
	public void setProfilePageService(ProfilePageServiceAsync profilePageService) {
		this.profilePageService = profilePageService;
	}

	/**
	 * @return the getGetWorkSpaceAsyncCallback
	 */
	public SimpleAsyncCallback<List<CollectionItemDo>> getGetWorkSpaceAsyncCallback() {
		return getWorkSpaceAsyncCallback;
	}

	/**
	 * @param getWorkSpaceAsyncCallback
	 *            the getWorkSpaceAsyncCallback to set
	 */
	public void setGetWorkSpaceAsyncCallback(
			SimpleAsyncCallback<List<CollectionItemDo>> getWorkSpaceAsyncCallback) {
		this.getWorkSpaceAsyncCallback = getWorkSpaceAsyncCallback;
	}
}
