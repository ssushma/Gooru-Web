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
package org.ednovo.gooru.client.mvp.folders.edit.tab.content;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.folders.event.RefreshCollectionInFolderLevelListEvent;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * 
 * @fileName : FolderContentTabPresenter.java
 *
 * @description : This is the presenter class for FolderContentTabView.java.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class FolderContentTabPresenter extends PresenterWidget<IsFolderContentTabView> implements FolderContentTabUiHandlers {

	
	@Inject
	private FolderServiceAsync folderService;
	
	private SimpleAsyncCallback<List<CollectionItemDo>> getAllFoldersAsyncCallback;
	
	private final String FOLDER_LEVEL = "3";

	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public FolderContentTabPresenter(EventBus eventBus, IsFolderContentTabView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(RefreshCollectionInFolderLevelListEvent.TYPE, this);		
	}
	/**
	 * This method is called when the presenter is instantiated.
	 */
	@Override
	public void onBind() {
		super.onBind();

		setGetAllFoldersAsyncCallback(new SimpleAsyncCallback<List<CollectionItemDo>>() {
			@Override
			public void onSuccess(List<CollectionItemDo> result) {
				getView().clearWorkspaceFoldersListPanel();
				int folderSize = result.size();
				if (folderSize > 0) {
					for (int i = 0; i < folderSize; i++) {
						getView().addFolder(result.get(i));
					}
					getView().disablenoWorkspaceLbl();
				} else {
					getView().enablenoWorkspaceLbl();
				}
			}
		});
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	public void onReveal() {
		
		super.onReveal();
		getView().onLoad();
		getView().reset();
		
	}
	/**
	 * This method is used to hide some content.
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
	}
	/**
	 * This method is called whenever the user navigates to a page that shows the presenter, whether it was visible or not.
	 */
	@Override
	protected void onReset(){
		String folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
		
		if(folderLevel.equalsIgnoreCase(FOLDER_LEVEL)){
			getView().disableNewFolderUiHandler();
		} else {
			getView().enableNewFolderUiHandler();
		}
		
	}
	
	// // Setters and Getters //
	/**
	 * This method is to set the folderService
	 */
	public void setFolderService(FolderServiceAsync folderService) {
		this.folderService = folderService;
	}

	/**
	 * This method is to get the folderService
	 */
	public FolderServiceAsync getFolderService() {
		return folderService;
	}

	/**
	 * @return the getAllClasspagesAsyncCallback
	 */
	public SimpleAsyncCallback<List<CollectionItemDo>> getGetAllFoldersAsyncCallback() {
		return getAllFoldersAsyncCallback;
	}

	/**
	 * @param getAllClasspagesAsyncCallback
	 *            the getAllClasspagesAsyncCallback to set
	 */
	public void setGetAllFoldersAsyncCallback(
			SimpleAsyncCallback<List<CollectionItemDo>> getAllFoldersAsyncCallback) {
		this.getAllFoldersAsyncCallback = getAllFoldersAsyncCallback;
	}
	/**
	 * This is used to get the folder details based on folder id.
	 */
	@Override
	public void getSecondThirdLevelFolders() {
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		getFolderService().getFolders(folderId, getGetAllFoldersAsyncCallback());
	}
	/**
	 * This method is used to refresh the collections in folder level list.
	 */
	@Override
	public void refreshCollectionInFolderLevelList(CollectionDo collectionDo,
			RefreshFolderType refreshFolderType) {
		
				CollectionItemDo collectionItemDo = new CollectionItemDo();
				ResourceDo resourceDo = new ResourceDo();
				ResourceTypeDo resourceTypeDo = new ResourceTypeDo();
				resourceDo.setResourceType(resourceTypeDo);
				collectionItemDo.setResource(resourceDo);
				
				collectionItemDo.getResource().setTitle(collectionDo.getTitle());
				collectionItemDo.getResource().setGooruOid(collectionDo.getGooruOid());
				collectionItemDo.getResource().getResourceType().setName(collectionDo.getCollectionType());
				
				if(refreshFolderType.equals(RefreshFolderType.INSERT)) {
					getView().refreshCollectionInFolderLevelList(collectionItemDo, refreshFolderType);
				} else if(refreshFolderType.equals(RefreshFolderType.DELETE)) {
					
				}		
	}
	
}
