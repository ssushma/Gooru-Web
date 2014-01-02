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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.RegisterTabDndEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.ConsumeShelfCollectionsEvent;
import org.ednovo.gooru.client.mvp.search.event.RequestShelfCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionAndItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemInFoldersEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DeleteFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DisableDraggableEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshLevelFolderInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfOpenClickEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UserInfoMsgShelfEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * 
 * @fileName : ShelfListPresenter.java
 *
 * @description : It gives  details of all the handlers which are being added  and used
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ShelfListPresenter extends PresenterWidget<IsShelfListView> implements ShelfListUiHandlers {

	@Inject
	private ResourceServiceAsync resourceService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> saveCollectionItemAsyncCallback;

	private SimpleAsyncCallback<List<CollectionDo>> userCollectionAsyncCallback;
	
	private boolean clrPanel=false;

	private String version = null;
	
	private String folderLevel = null;
	
	private static String FLT_NOT_MEDIA_TYPE = "fltNot.mediaType";
	
	private static String IPAD_FRIENDLY  = "iPad_friendly";

	private static String IPAD_NOT_FRIENDLY  = "not_ipad_friendly";

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

	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void onReveal() {
		super.onReveal();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.FOLDERS)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SHELF)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.EDIT_FOLDERS)){
			getView().collectionListScrollpanel(false);
		}else{
			getView().collectionListScrollpanel(true);
		}
		getView().onLoad();
	}
/**
 * @description: It redirects to another page
 */
	@Override
	public void onReset() {
		super.onReset();
		getView().resetDragImage();
		if (version == null || (version != null && !version.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getToken()))) {
			getView().reset();
			getResourceService().getUserCollectionList(20,ShelfListView.getpageNumber(),false,getUserCollectionAsyncCallback(true));
			version = AppClientFactory.getLoggedInUser().getToken();
		}
		getView().setNewCollectionPanel();
		Document doc = Document.get();
		doc.getElementById("uvTab").getStyle().setDisplay(Display.BLOCK);
	}
	/**
	 * @description: It doesn't display and hides the content
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
	}
	/**
	 * @description: It creates the collection
	 */

	@Override
	public void initCreateCollection() {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION);
	}
	/**
	 * @description:It copy the collection
	 */

	@Override
	public void copyCollection(String collectionUid) {
		MixpanelUtil.Drag_Collection_FromSearchResultToFolder();
		CollectionDo collection = new CollectionDo();
		collection.setGooruOid(collectionUid);
		getResourceService().copyCollection(collection, "true", null, getSaveCollectionAsyncCallback());
	}
/**
 *@description: It create collection items
 */
	@Override
	public void createCollectionItem(String collectionUid, String resourceUid) {
		MixpanelUtil.Drag_Resource_FromSearchResultToCollection();
		getResourceService().createCollectionItem(collectionUid, resourceUid, getSaveCollectionItemAsyncCallback());
	}
/**
  *@description: It create collection and also items

 */
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
	/**
	  *@description: It create collection items in folders

	 */
	@Override
	public void createCollectionItemInFolders(String collectionUid,
			String resourceUid, String folderLevel) {
		this.folderLevel = folderLevel;
		getResourceService().createCollectionItem(collectionUid, resourceUid, getSaveCollectionItemInFoldersAsyncCallback());
	}
/**
 * @description: It request the shelf view
 */
	@Override
	public void requestShelfView(String collectionId) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, new String[] { "id", collectionId });
	}
	/**
	 * @description:It register and controllers
	 */
	
	@Override
	public void registerDndControllers() {
		getView().registerDropControllers();
	}
/**
 * @description: It reqwuest shelf collections
 */
	@Override
	public void requestShelfCollections() {
		if (getView().isFireConsumeShelfCollectionEvent() && !AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)) {
			AppClientFactory.fireEvent(new ConsumeShelfCollectionsEvent(getView().getShelfCollections()));
		}
	}
/**
 * @description: It refresh collection in shelf list
 */
	@Override
	public void refreshCollectionInShelfList(CollectionDo collection, RefreshType refreshType) {
		getView().refreshCollectionInShelfList(collection, refreshType);
	}
	/**
	 * @description: It refresh level folder in shelf list
	 */
	@Override
	public void refreshLevelFolderInShelfList(String collectionId,	RefreshType refreshType, String folderLevel , int sequence,boolean flag) {
		getView().refreshLevelFolderInShelfList(collectionId, refreshType, folderLevel,sequence,flag);
	}
	/**
	 * @description: it inserts folder in shelf view
	 */
	
	@Override
	public void insertFolderInShelfView(CollectionItemDo collectionItemDo,
			RefreshType refreshType, String folderLevel) {
		getView().insertFolderInShelfView(collectionItemDo, refreshType, folderLevel);
	}
	/**
	 * @description: It deletes folder in shelf view
	 */
	@Override
	public void deleteFolderInShelfView(CollectionItemDo collectionItemDo,
			RefreshType refreshType, String folderLevel) {
			
	}
	/**
	 * @description:It disables the draggable event
	 */
	@Override
	public void disableDraggableEvent(String folderLevel,
			String folderObjectType) {
		getView().disableDraggableEvent(folderLevel, folderObjectType);
	}
/**
 * @description:It refresh collection item in shelf list
 */
	@Override
	public void refreshCollectionItemInShelfList(CollectionItemDo collectionItem, RefreshType refreshType) {
		getView().refreshCollectionItemInShelfList(collectionItem, refreshType);

	}
/**
 * 
 * @function getSaveCollectionItemAsyncCallback 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :Api calling
 * 
 * 
 * @parm(s) : @return
 * 
 * @return : SimpleAsyncCallback<CollectionItemDo>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
/**
 * 
 * @function getSaveCollectionItemInFoldersAsyncCallback 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :Api calling for insertFolderInShelfView
 * 
 * 
 * @parm(s) : @return
 * 
 * @return : SimpleAsyncCallback<CollectionItemDo>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public SimpleAsyncCallback<CollectionItemDo> getSaveCollectionItemInFoldersAsyncCallback() {
		if (saveCollectionItemAsyncCallback == null) {
			saveCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().insertFolderInShelfView(result, RefreshType.INSERT, folderLevel);
				}
			};
		}
		return saveCollectionItemAsyncCallback;
	}
	/**
	 * 
	 * @function getUserCollectionAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :Api calling to get user collections
	 * 
	 * 
	 * @parm(s) : @param clearShelfPanel
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<List<CollectionDo>>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public SimpleAsyncCallback<List<CollectionDo>> getUserCollectionAsyncCallback(boolean clearShelfPanel) {
		
		
		clrPanel=clearShelfPanel;
		if (userCollectionAsyncCallback == null) {
			userCollectionAsyncCallback = new SimpleAsyncCallback<List<CollectionDo>>() {

				@Override
				public void onSuccess(List<CollectionDo> result) {
					getView().setUserShelfData(result,clrPanel);
					String collectionId = AppClientFactory.getPlaceManager().getRequestParameter("id", "INVALID");
					if (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF) && !collectionId.equals("INVALID")) {
						getView().openShelfCollection(collectionId);
					} else if (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF) && collectionId.equals("INVALID")) {
						AppClientFactory.fireEvent(new RequestShelfEvent(result.get(0).getGooruOid()));
					}
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

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}
/**
 * @description: It refresh user shelf collection
 */
	@Override
	public void refreshUserShelfCollections() {
		ShelfListView.setPageNumber(1);
		getResourceService().getUserCollectionList(20,ShelfListView.getpageNumber(),false,getUserCollectionAsyncCallback(true));
	}
/**
 * @description:It gets self collection list items
 */
	@Override
	public void getSelfCollectionListItems(int pageSize, Integer pageNumber,boolean clearShelfPanel) {
			getResourceService().getUserCollectionList(pageSize,pageNumber,false,getUserCollectionAsyncCallback(clearShelfPanel));
	}
	/**
	 * 
	 * @function disableFolderCollectionPanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It disables the folder collection panel
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void disableFolderCollectionPanel() {
		getView().disableFolderCollectionPanel();
	}
/**
 * 
 * @function enableFolderCollectionPanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It enables the folder collection panel
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void enableFolderCollectionPanel() {
		getView().enableFolderCollectionPanel();
	}
/**
 * @description:It requests to open shelf
 */
	@Override
	public void requestShelfOpenClick(String collectionId) {
		getView().setOpenCollectionId(collectionId);
	}
/**
 * @description:It sets the user informatiin message
 */
	@Override
	public void setUserInfoMsg(String userMsg) {
		getView().setUserShelfMsg(userMsg);
	}

}
