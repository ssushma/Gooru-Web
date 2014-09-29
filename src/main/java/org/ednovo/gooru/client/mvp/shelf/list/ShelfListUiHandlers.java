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

import org.ednovo.gooru.client.event.RegisterTabDndHandler;
import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.search.event.RequestShelfCollectionHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ActivateCollectionStyleHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ChangeShelfPanelActiveStyleHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.InsertMovedCollectionHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.OpenParentFolderHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemEventForSearchInAddResourceHandler;

import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RemoveMovedCollectionFolderHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetCollectionMovedStyleHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderCollectionStyleHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CopyCollectionHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CopyDraggedCollectionHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionAndItemHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemInFoldersHandler;
import org.ednovo.gooru.client.mvp.shelf.event.DeleteFolderInShelfViewEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.DisableDraggableEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.DragOverOpenFolderHandler;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshLevelFolderInShelfListHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfOpenClickHandler;
import org.ednovo.gooru.client.mvp.shelf.event.ResourceDragOverShelfHandler;
import org.ednovo.gooru.client.mvp.shelf.event.UserInfoMsgShelfHandler;
import org.ednovo.gooru.client.mvp.shelf.event.HighlightAssignmentToEditEventHandler;

/**
 * @author Search Team
 *
 */
public interface ShelfListUiHandlers extends BaseUiHandlers, CopyCollectionHandler , CreateCollectionItemHandler, CreateCollectionItemInFoldersHandler, CreateCollectionAndItemHandler, RequestShelfHandler, RegisterTabDndHandler, RefreshCollectionInShelfListHandler, RefreshLevelFolderInShelfListHandler, InsertFolderInShelfViewEventHandler, DeleteFolderInShelfViewEventHandler, DisableDraggableEventHandler, RequestShelfCollectionHandler, RefreshCollectionItemInShelfListHandler,RefreshUserShelfCollectionsEventHandler,RequestShelfOpenClickHandler,UserInfoMsgShelfHandler,ResourceDragOverShelfHandler,CopyDraggedCollectionHandler, RefreshFolderItemHandler, ChangeShelfPanelActiveStyleHandler, UpdateShelfFolderNameHandler,RemoveMovedCollectionFolderHandler,DragOverOpenFolderHandler,InsertMovedCollectionHandler,SetCollectionMovedStyleHandler,SetFolderCollectionStyleHandler,OpenParentFolderHandler,UpdateShelfFolderMetaDataHandler,ActivateCollectionStyleHandler,RefreshFolderItemEventForSearchInAddResourceHandler,HighlightAssignmentToEditEventHandler{
	
	/**
	 * Get create collection page view
	 */
	void initCreateCollection();

	void getSelfCollectionListItems(int i, Integer pageNumber,boolean isShelfListCleared);

	void getChildFolderItems(String folderId, boolean isDataCalled);

	void getCollectionItems(String collectionOid, boolean collectionOpenedStatus); 

	void createFolderInParent(String parentName, String parentId, HashMap<String,String> params);
	
}
