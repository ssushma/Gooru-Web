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
package org.ednovo.gooru.client.mvp.folders.edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.ActivateSearchBarEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter;
import org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter;
import org.ednovo.gooru.client.mvp.folders.event.RequestFolderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 * @fileName : EditFolderPresenter.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: Apr 20, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */

public class EditFolderPresenter extends BasePlacePresenter<IsEditFolderView, EditFolderPresenter.IsEditFolderProxy> implements EditFolderUiHandlers {

	@Inject
	private FolderServiceAsync folderService;
	
	@Inject
	private ResourceServiceAsync resourceService;
	
	private FolderInfoTabPresenter folderInfoTabPresenter;
	
	private FolderContentTabPresenter folderContentTabPresenter;
	
	private SimpleAsyncCallback<List<CollectionItemDo>> getAllFoldersAsyncCallback;

	@Inject
	private ShelfListPresenter shelfListPresenter;

	private SimpleAsyncCallback<List<CollectionDo>> collectionAsyncCallback;
	
	private SimpleAsyncCallback<CollectionDo> folderInfoAsyncCallback;
	
	private SimpleAsyncCallback<CollectionDo> updateCollectionAsyncCallback;

	private SimpleAsyncCallback<List<CollectionDo>> getInsideFoldersAsyncCallback;
	
	Map<String,String> folderParams = new HashMap<String,String>();
	
	private List<CollectionItemDo> collectionItemDo = new ArrayList<CollectionItemDo>();
	
	private CollectionItemDo collectionItemDoObject = null;
	
	private String folderId;
	
	private final String FIRST_LEVEL_FOLDER = "1";
	
	private final String SECOND_LEVEL_FOLDER = "2";

	private final String THIRD_LEVEL_FOLDER = "3";

	@Inject
	public EditFolderPresenter(ShelfListPresenter shelfListPresenter, IsEditFolderView view, IsEditFolderProxy proxy,FolderInfoTabPresenter folderInfoTabPresenter,FolderContentTabPresenter folderContentTabPresenter) {
		super(view, proxy);
		getView().setUiHandlers(this);
		this.shelfListPresenter = shelfListPresenter;
		this.folderInfoTabPresenter=folderInfoTabPresenter;
		this.folderContentTabPresenter=folderContentTabPresenter;
		this.shelfListPresenter.disableFolderCollectionPanel();
		addRegisteredHandler(RequestFolderEvent.TYPE, this);
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.EDIT_FOLDERS)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsEditFolderProxy extends ProxyPlace<EditFolderPresenter> {
	}

	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		fireEvent(new ActivateSearchBarEvent(true));
		getView().setBackToSearch();
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}

	@Override
	public void onBind() {
		super.onBind();
		setFolderInformationAsyncCallBack(new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo collectionDo) {
				getView().setFolderMetaData(collectionDo);
				getView().setCollection(collectionDo);
			}
		});
		
		setGetAllFoldersAsyncCallback(new SimpleAsyncCallback<List<CollectionItemDo>>() {
			@Override
			public void onSuccess(List<CollectionItemDo> result) {
				setCollectionItemDo(result);
			}
		});
	
	}		
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().reset();
		folderInfoTabPresenter.getView().reset();
		folderContentTabPresenter.getView().reset();
		folderId = getPlaceManager().getRequestParameter("folderid");
		setInSlot(TYPE_FOLDERS_SHELF_VIEW, shelfListPresenter);
		getFoldersAndCollections();
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	
	//// Setters and Getters //
	/** 
	 * This method is to get the folderService
	 */
	public FolderServiceAsync getFolderService() {
		return folderService;
	}

	/** 
	 * This method is to set the folderService
	 */
	public void setFolderService(FolderServiceAsync folderService) {
		this.folderService = folderService;
	}
	
	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<List<CollectionDo>> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/** 
	 * This method is to set the collectionAsyncCallback
	 */
	public void setCollectionAsyncCallback(SimpleAsyncCallback<List<CollectionDo>> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	
	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getFolderInformationAsyncCallBack() {
		return folderInfoAsyncCallback; 
	}
	
	/** 
	 * This method is to set the folderInformationAsyncCallBack
	 */
	public void setFolderInformationAsyncCallBack(	SimpleAsyncCallback<CollectionDo> folderInfoAsyncCallback) {
		this.folderInfoAsyncCallback = folderInfoAsyncCallback;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}
	
	@Override
	public void getFoldersAndCollections() {
		folderId = getPlaceManager().getRequestParameter("folderid");
		getFolderService().getFolderInformation(folderId, getFolderInformationAsyncCallBack());
		//getFolderService().getFoldersAndCollections(folderId, getCollectionAsyncCallback());
	}
	
	@Override
	public void revealTab(Type<RevealContentHandler<?>> typeTab,CollectionDo collectionDo) {
		if (typeTab.equals(TYPE_FOLDER_INFO_TAB)) {
			addToSlot(TYPE_FOLDER_INFO_TAB, folderInfoTabPresenter);
			folderInfoTabPresenter.getView().setData(collectionDo);
		} else if(typeTab.equals(TYPE_FOLDER_CONTENT_TAB)) {
			addToSlot(TYPE_FOLDER_CONTENT_TAB, folderContentTabPresenter);
			folderContentTabPresenter.getView().setData(collectionDo);
		}
	}

	@Override
	public void clearTabSlot() {
		clearSlot(TYPE_FOLDER_INFO_TAB);
		clearSlot(TYPE_FOLDER_CONTENT_TAB);
	}

	@Override
	public void updateCollectionInfo(String collectionId, String title,String description) {
		getResourceService().updateCollectionMetadata(collectionId, title, description, null, null, null, null, null, null, null, getUpdateCollectionAsyncCallback());
		
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}

	public SimpleAsyncCallback<CollectionDo> getUpdateCollectionAsyncCallback() {
		if (updateCollectionAsyncCallback == null) {
			updateCollectionAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					getView().onPostCollectionUpdate();
				}
			};
		}
		return updateCollectionAsyncCallback;
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
	
	private void setCollectionItemDo(List<CollectionItemDo> result){
		this.collectionItemDo = result;
	}
	
	@Override
	public void requestFolderView(String collectionId,Map<String, String> params, Boolean refreshType) {
		this.folderParams = params;
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_FOLDERS, params, refreshType);
	}

	@Override
	public void deleteMyFolder(String collectionId, final CollectionDo collectionDo) {

		AppClientFactory.getInjector().getfolderService().deleteFolder(collectionId, new SimpleAsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
					String folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
					if(folderLevel.equalsIgnoreCase(FIRST_LEVEL_FOLDER)) {
						AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(collectionDo, RefreshType.DELETE));
						AppClientFactory.getPlaceManager().revealPlace(
								PlaceTokens.FOLDERS);
					}
				}
			});
	}

	@Override
	public void initFolderRedirect() {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.FOLDERS);
	}
	
}
