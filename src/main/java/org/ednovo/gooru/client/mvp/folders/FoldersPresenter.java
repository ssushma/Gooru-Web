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
package org.ednovo.gooru.client.mvp.folders;

import java.util.LinkedHashMap;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.ActivateSearchBarEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy;
import org.ednovo.gooru.client.mvp.folders.event.RefreshCollectionInFolderListEvent;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * 
 * @fileName : FoldersPresenter.java
 *
 * @description : This is the presenter class for FoldersView.java
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
public class FoldersPresenter extends BasePlacePresenter<IsFoldersView, IsFoldersProxy> implements FoldersUiHandlers {
	@Inject
	private FolderServiceAsync folderService;

	@Inject
	private ShelfListPresenter shelfListPresenter;

	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;

	private SimpleAsyncCallback<List<CollectionItemDo>> getAllFoldersAsyncCallback;
	
	private LinkedHashMap<String, CollectionDo> foldersHashMap = new LinkedHashMap<String, CollectionDo>();

	@Inject
	public FoldersPresenter(ShelfListPresenter shelfTabPresenter,IsFoldersView view, IsFoldersProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
		addRegisteredHandler(RefreshCollectionInFolderListEvent.TYPE, this);
		this.shelfListPresenter = shelfTabPresenter;
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.FOLDERS)
	public interface IsFoldersProxy extends ProxyPlace<FoldersPresenter> {
	}
	/**
	 * This method is used to get the view token.
	 */
	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 *This method  is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		getFirstLevelWorkspaceFolders();
		fireEvent(new ActivateSearchBarEvent(true));
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.ORGANIZE));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		getView().setBackToSearch();
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
				shelfListPresenter.disableFolderCollectionPanel();
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
	 * This is used to change the place to CREATEFOLDER.
	 */
	@Override
	public void initCreateFolder() {
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));	
		AppClientFactory.getPlaceManager()
				.revealPlace(PlaceTokens.CREATEFOLDER);
	}
	/**
	 * This is used to change the place to COLLECTION.
	 */
	@Override
	public void initCreateCollection() {
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));	
		AppClientFactory.getPlaceManager()
				.revealPlace(PlaceTokens.COLLECTION);
	}
	/**
	 * This is used to change the place to FOLDERS.
	 */
	@Override
	public void initFolderRedirect() {
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));	
		AppClientFactory.getPlaceManager()
				.revealPlace(PlaceTokens.FOLDERS);
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
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/**
	 * This method is to set the collectionAsyncCallback
	 */
	public void setCollectionAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
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
	 *This method is called whenever the user navigates to a page that shows the presenter, whether it was visible or not.
	 */
	
	@Override
	protected void onReset() {
		super.onReset();
		setInSlot(TYPE_FOLDERS_SHELF_VIEW, shelfListPresenter);
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	/**
	 * This method is used to get the details of all the folders.
	 */
	@Override
	public void getFirstLevelWorkspaceFolders() {
		getFolderService().getAllFolders(getGetAllFoldersAsyncCallback());
	}
	/**
	 * This method is used to refresh the collection in folders list.
	 */
	@Override
	public void refreshCollectionInFolderList(CollectionDo collectionDo,
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
				getView().refreshCollectionInFolderList(collectionItemDo, refreshFolderType);
				getView().disablenoWorkspaceLbl();
			} else if(refreshFolderType.equals(RefreshFolderType.DELETE)) {
				getView().enablenoWorkspaceLbl();
			}
	}
}
