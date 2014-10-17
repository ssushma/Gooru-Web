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
package org.ednovo.gooru.client.mvp.shelf.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.RegisterTabDndEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.search.event.ConsumeShelfCollectionsEvent;
import org.ednovo.gooru.client.mvp.search.event.RequestShelfCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ActivateCollectionStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ChangeShelfPanelActiveStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.InsertMovedCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.OpenParentFolderEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemForSearchInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RemoveMovedCollectionFolderEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ReorderShelfListItemsEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetCollectionMovedStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderCollectionStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateFolderItemEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyDraggedCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionAndItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemInFoldersEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DeleteFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DisableDraggableEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DragOverOpenFolderEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshLevelFolderInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfOpenClickEvent;
import org.ednovo.gooru.client.mvp.shelf.event.ResourceDragOverShelfEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UserInfoMsgShelfEvent;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

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
public class ShelfListPresenter extends PresenterWidget<IsShelfListView> implements ShelfListUiHandlers {

	@Inject
	private ResourceServiceAsync resourceService;

	@Inject
	private FolderServiceAsync folderService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;
	
	private SimpleAsyncCallback<CollectionDo> saveDraggedCollectionAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> saveCollectionItemAsyncCallback;

	private SimpleAsyncCallback<FolderListDo> userCollectionAsyncCallback;
	
	private boolean clrPanel=false;

	private String version = null;
	
	private String folderLevel = null;
	
	private static String FLT_NOT_MEDIA_TYPE = "fltNot.mediaType";
	
	private static String IPAD_FRIENDLY  = "iPad_friendly";

	private static String IPAD_NOT_FRIENDLY  = "not_ipad_friendly";

	private List<FolderDo> searchResult = new ArrayList<FolderDo>();
	
	/**
	 * Class Constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public ShelfListPresenter(EventBus eventBus, IsShelfListView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(CopyCollectionEvent.TYPE, this);
		addRegisteredHandler(CreateCollectionItemEvent.TYPE, this);
		addRegisteredHandler(CreateCollectionItemInFoldersEvent.TYPE, this);
		addRegisteredHandler(CreateCollectionAndItemEvent.TYPE, this);
		addRegisteredHandler(RequestShelfEvent.TYPE, this);
		addRegisteredHandler(RequestShelfCollectionEvent.TYPE, this);
		addRegisteredHandler(RegisterTabDndEvent.TYPE, this);
		addRegisteredHandler(RefreshCollectionInShelfListEvent.TYPE, this);
		addRegisteredHandler(RefreshLevelFolderInShelfListEvent.TYPE, this);
		addRegisteredHandler(InsertFolderInShelfViewEvent.TYPE, this);
		addRegisteredHandler(DeleteFolderInShelfViewEvent.TYPE, this);
		addRegisteredHandler(DisableDraggableEvent.TYPE, this);
		addRegisteredHandler(RefreshCollectionItemInShelfListEvent.TYPE, this);
		addRegisteredHandler(RefreshUserShelfCollectionsEvent.TYPE, this);
		addRegisteredHandler(RequestShelfOpenClickEvent.TYPE, this);
		addRegisteredHandler(UserInfoMsgShelfEvent.TYPE, this);
		addRegisteredHandler(ResourceDragOverShelfEvent.TYPE, this);
		addRegisteredHandler(CopyDraggedCollectionEvent.TYPE, this);
		addRegisteredHandler(RefreshFolderItemEvent.TYPE, this);
		addRegisteredHandler(RefreshFolderItemForSearchInAddResourceEvent.TYPE, this);

		addRegisteredHandler(ChangeShelfPanelActiveStyleEvent.TYPE, this);
		addRegisteredHandler(UpdateShelfFolderNameEvent.TYPE, this);
		addRegisteredHandler(RemoveMovedCollectionFolderEvent.TYPE, this); 
		addRegisteredHandler(DragOverOpenFolderEvent.TYPE, this); 
		addRegisteredHandler(InsertMovedCollectionEvent.TYPE, this); 
		addRegisteredHandler(SetCollectionMovedStyleEvent.TYPE, this); 
		addRegisteredHandler(SetFolderCollectionStyleEvent.TYPE, this); 
		addRegisteredHandler(OpenParentFolderEvent.TYPE, this); 
		addRegisteredHandler(UpdateShelfFolderMetaDataEvent.TYPE, this);
		addRegisteredHandler(ActivateCollectionStyleEvent.TYPE, this);
		addRegisteredHandler(ReorderShelfListItemsEvent.TYPE, this);
		
	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void onReveal() {
		super.onReveal();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)){
			getView().collectionListScrollpanel(false);
		}else{
			getView().collectionListScrollpanel(true);
		}
		getView().setBackToSearch();
		getView().onLoad();
	}

	@Override
	public void onReset() {
		super.onReset();
		getView().resetDragImage();
		if (version == null || (version != null && !version.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getToken()))) {
			getView().reset();
			getResourceService().getFolderWorkspace((ShelfListView.getpageNumber()-1)*20, 20,null,null,getUserCollectionAsyncCallback(true));
			version = AppClientFactory.getLoggedInUser().getToken();
		}
		getView().setNewCollectionPanel();
		Document doc = Document.get();
		doc.getElementById("uvTab").getStyle().setDisplay(Display.BLOCK);
	}
	
	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
	}

	@Override
	public void initCreateCollection() {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION);
	}

	@Override
	public void copyCollection(CollectionDo collectionDo,String codeId) {
		MixpanelUtil.Drag_Collection_FromSearchResultToFolder();
		getResourceService().copyCollection(collectionDo, "true", codeId, getSaveCollectionAsyncCallback());
	}

	@Override
	public void createCollectionItem(String collectionUid, String resourceUid) {
		MixpanelUtil.Drag_Resource_FromSearchResultToCollection();
		getResourceService().createCollectionItem(collectionUid, resourceUid, getSaveCollectionItemAsyncCallback());
	}

	@Override
	public void createCollectionAndItem(String resourceUid) {
		MixpanelUtil.Drag_Resource_FromSearchResultToNewCollection();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("resourceId", resourceUid);
		
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)) {
			String mediaType = AppClientFactory.getPlaceManager().getRequestParameter(FLT_NOT_MEDIA_TYPE);
			if(mediaType!=null) {
				params.put("mediaType", IPAD_FRIENDLY);
			}
		}
		
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION, params);
	}
	
	@Override
	public void createCollectionItemInFolders(String collectionUid,
			String resourceUid, String folderLevel) {
		
	}

	@Override
	public void requestShelfView(String collectionId) {
		if(collectionId==null) {
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF);
		} else {
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, new String[] { "id", collectionId });
		}
	}
	
	@Override
	public void registerDndControllers() {
		getView().registerDropControllers();
	}

	@Override
	public void requestShelfCollections() {
		if (getView().isFireConsumeShelfCollectionEvent() && !AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)) {
			AppClientFactory.fireEvent(new ConsumeShelfCollectionsEvent(getView().getShelfCollections()));
		}
	}

	@Override
	public void refreshCollectionInShelfList(CollectionDo collection, RefreshType refreshType) {
		getView().refreshCollectionInShelfList(collection, refreshType);
	}
	
	@Override
	public void refreshLevelFolderInShelfList(String collectionId,	RefreshType refreshType, String folderLevel , int sequence,boolean flag) {
		
	}
	
	@Override
	public void insertFolderInShelfView(CollectionItemDo collectionItemDo, RefreshType refreshType, String folderLevel) {
		
	}
	
	@Override
	public void deleteFolderInShelfView(CollectionItemDo collectionItemDo,
			RefreshType refreshType, String folderLevel) {
			
	}
	
	@Override
	public void disableDraggableEvent(String folderLevel,
			String folderObjectType) {
		getView().disableDraggableEvent(folderLevel, folderObjectType);
	}

	@Override
	public void refreshCollectionItemInShelfList(CollectionItemDo collectionItem, RefreshType refreshType) {
		getView().refreshCollectionItemInShelfList(collectionItem, refreshType);

	}

	public SimpleAsyncCallback<CollectionItemDo> getSaveCollectionItemAsyncCallback() {
		if (saveCollectionItemAsyncCallback == null) {
			saveCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().refreshCollectionItemInShelfList(result, RefreshType.INSERT);
				}
			};
		}
		return saveCollectionItemAsyncCallback;
	}

	public SimpleAsyncCallback<FolderListDo> getUserCollectionAsyncCallback(boolean clearShelfPanel) {
		clrPanel=clearShelfPanel;
		if (userCollectionAsyncCallback == null) {
			userCollectionAsyncCallback = new SimpleAsyncCallback<FolderListDo>() {

				@Override
				public void onSuccess(FolderListDo result) {
					getView().setUserShelfData(result.getSearchResult(),clrPanel);
				}
			};
		}
		return userCollectionAsyncCallback;
	}

	/**
	 * @return instance of collectionDo after collection save
	 */
	public SimpleAsyncCallback<CollectionDo> getSaveCollectionAsyncCallback() {
		if (saveCollectionAsyncCallback == null) {
			saveCollectionAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					getView().refreshCollectionInShelfList(result, RefreshType.INSERT);
				}
			};
		}
		return saveCollectionAsyncCallback;
	}
	
	
	public SimpleAsyncCallback<CollectionDo> SaveDraggedCollectionAsyncCallback() {
		if (saveDraggedCollectionAsyncCallback == null) {
			saveDraggedCollectionAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
//					getView().insertDraggedCollectionInShelfList(result);
				}
			};
		}
		return saveDraggedCollectionAsyncCallback;
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public FolderServiceAsync getFolderService() {
		return folderService;
	}
	
	@Override
	public void refreshUserShelfCollections() {
		ShelfListView.setPageNumber(1);
		getResourceService().getFolderWorkspace((ShelfListView.getpageNumber()-1)*20, 20,null,null,getUserCollectionAsyncCallback(true));
	}

	@Override
	public void getSelfCollectionListItems(int pageSize, Integer pageNumber,boolean clearShelfPanel) {
			getResourceService().getFolderWorkspace((pageNumber-1)*pageSize,pageSize,null,null,getUserCollectionAsyncCallback(clearShelfPanel));
	}
	
	public void disableFolderCollectionPanel() {
		getView().disableFolderCollectionPanel();
	}

	public void enableFolderCollectionPanel() {
		getView().enableFolderCollectionPanel();
	}

	@Override
	public void requestShelfOpenClick(String collectionId) {
		getView().setOpenCollectionId(collectionId);
	}

	@Override
	public void setUserInfoMsg(String userMsg) {
		getView().setUserShelfMsg(userMsg);
	}

	@Override
	public void getChildFolderItems(final String folderId, final boolean isDataCalled) {
		if(isDataCalled) {
			getView().getChildFolderItems(null);
		} else {
			AppClientFactory.getInjector().getfolderService().getChildFolders((getView().getChildPageNumber()-1)*20, 20, folderId,null, null,new SimpleAsyncCallback<FolderListDo>() {
				@Override
				public void onSuccess(FolderListDo result) {
					searchResult.addAll(result.getSearchResult());
					if(result.getSearchResult().size()==20) {
						getView().setChildPageNumber(getView().getChildPageNumber()+1);
						setPaginatedChildFolders(folderId, isDataCalled);
					} else {
						getView().setChildPageNumber(1);
						getView().getChildFolderItems(searchResult);
						searchResult.clear();
					}
				}
			});
		}
	}

	private void setPaginatedChildFolders(String folderId, boolean isDataCalled) {
		getChildFolderItems(folderId, isDataCalled);
	}
	
	@Override
	public void getCollectionItems(String collectionOid,boolean collectionOpenedStatus) {
		if(collectionOpenedStatus) {
			getView().getCollectionItems(null);
		} else {
			
			/** Changed to new API call for fetching resources in a order **/
    		AppClientFactory.getInjector().getfolderService().getCollectionResources(collectionOid,null, null, new SimpleAsyncCallback<FolderListDo>(){
				@Override
				public void onSuccess(FolderListDo result) {
					getView().getCollectionItems(result.getSearchResult());
					
				}
    		});
		}
	}

	@Override
	public void getCollectionItems(String collectionId) {
		getView().getAllCollectionItems(collectionId);
	}

	@Override
	public void copyDraggedCollection(CollectionDo collectionDo,String collectionId,final String parentId) { 
		AppClientFactory.getInjector().getfolderService().copyDraggedCollectionIntoFolder(collectionDo,collectionId,parentId,false,new SimpleAsyncCallback<CollectionDo>() { 

			@Override
			public void onSuccess(CollectionDo result) {
				getView().insertDraggedCollectionInShelfList(result,parentId);
			}
		});
	}

	@Override
	public void refreshFolderItem(FolderDo folderDo, RefreshFolderType refreshFolderType, HashMap<String, String> params) {
		getView().refreshFolderItemData(folderDo, refreshFolderType, params);
	}

	@Override
	public void createFolderInParent(String parentName, final String parentId, final HashMap<String,String> params) {
			boolean addToShelf = false;
			if(parentId.isEmpty()) {
				addToShelf = true;
			}
			AppClientFactory.getInjector().getfolderService().createFolder(parentName, parentId, addToShelf, new SimpleAsyncCallback<FolderDo>() {
				@Override
				public void onSuccess(FolderDo result) {
					AppClientFactory.fireEvent(new UpdateFolderItemEvent(result, parentId, params));
				}
			});
	}
	
	@Override
	public void changeShelfPanelActiveStyle() {
		getView().changeShelfPanelActiveStyle();
	}
	
	@Override
	public void updateShelfFolderName(String folderName,String folderId) {
		/**
		 * Commented, beacuse of DO-4851 and handled in Shelf collection class it self.
		 */
//		getView().updateShelfFolderName(folderName);
	}

	@Override
	public void removeMovedCollectionFromShelf(String sourceId) {
		getView().removeMovedCollFolder(sourceId);
	}

	@Override
	public void onDragOverOpenFolder(String folderId,boolean showcollectionFormView) {
		getView().onDragOverOpenFolder(folderId,showcollectionFormView);
	}

	@Override
	public void insertMovedCollection(FolderDo folderDo,RefreshFolderType refreshFolderType, HashMap<String, String> params) {
		getView().insertMovedCollection(folderDo, refreshFolderType, params);
	}

	@Override
	public void setCollectionMovedStyle(String gooruOId) {
		getView().setMovedCollectionStyle(gooruOId);
		
	}

	@Override
	public void setChildFolderCollectionStyle(HashMap<String, String> params, String clickType) {
		getView().setChildFolderCollectionStyle(params, clickType);
	}

	@Override
	public void openParentFolderEvent() {
		getView().openParentFolderEvent();
	}

	@Override
	public void updateShelfFolderMetaData(String ideas, String performanceTasks, String questions) {
		getView().updateShelfFolderMetaData(ideas, performanceTasks, questions);
	}

	@Override
	public void activecollectionStyle() {
		getView().setCollectionActiveStyle();
	}
	@Override
	public void refreshFolderItemInSearch(FolderDo folderDo,
			RefreshFolderType refreshFolderType, HashMap<String, String> params) {
		getView().refreshFolderItemDataInSearchAddResource(folderDo, refreshFolderType, params);
		
	}

	@Override
	public void reorderShelfListItems(String itemId, int toBeMovedPos, String direction, HashMap<String, String> params) {
		getView().reorderShelfItems(itemId,toBeMovedPos,direction,params);
	}
}