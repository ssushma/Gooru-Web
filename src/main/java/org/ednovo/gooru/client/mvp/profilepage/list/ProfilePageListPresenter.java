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
package org.ednovo.gooru.client.mvp.profilepage.list;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.profilepage.event.RefreshProfileListEvent;
import org.ednovo.gooru.client.service.ProfilePageServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
 */
public class ProfilePageListPresenter extends PresenterWidget<IsProfilePageListView> implements ProfilePageListUiHandlers {

	@Inject
	private ProfilePageServiceAsync profilePageService;
	
	private SimpleAsyncCallback<List<CollectionItemDo>> getWorkSpaceAsyncCallback;

	private boolean clrPanel=false;
	
	private String version = null;

	/**
	 * Class Constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public ProfilePageListPresenter(EventBus eventBus, IsProfilePageListView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(RefreshProfileListEvent.TYPE, this);
	}

	@Override
	public void onReset() {
		//super.onReset();
		String currentRequest = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
			if(!(userId==version)||(folderId==null)) {
				Document doc = Document.get();
				doc.getElementById("uvTab").getStyle().setDisplay(Display.BLOCK);
				version = userId;
		}
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
		
		if(getWorkSpaceAsyncCallback==null) {
			getWorkSpaceAsyncCallback = new SimpleAsyncCallback<List<CollectionItemDo>>() {
				@Override
				public void onSuccess(List<CollectionItemDo> collectionItemDo) {
					getView().setUserShelfData(collectionItemDo,clrPanel);
				}
			};
		}
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

	@Override
	public void refreshProfileList(String collectionId, String folderLevel) {
		getView().refreshProfileList(collectionId, folderLevel);
	}
	
	public void setUserData(String firstName){
		getView().setNoCollectionData(firstName);
	}
	
	public void setShelfListData(List<CollectionItemDo> collectionItemDo) {
		getView().clearMyShelfVerPanel();
		getView().setUserShelfData(collectionItemDo,clrPanel);
	}
}
