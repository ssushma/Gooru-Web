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

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.dom.client.ClickEvent;

/**
 * @author Search Team
 *
 */
public interface IsShelfListView extends IsViewWithHandlers<ShelfListUiHandlers>, DropBox {

	/**
	 * Set user shelf data
	 * @param collection instance of {@link CollectionDo} as List
	 */
	void setUserShelfData(List<FolderDo> collection,boolean clearShelfPanel);

	/**
	 * Create dropped collection 
	 */
	void registerDropControllers();

	/**
	 * Refresh collection list in user shelf
	 * @param collection instance of {@link CollectionDo} 
	 * @param refreshType instance of {@link RefreshType}
	 */
	void refreshCollectionInShelfList(CollectionDo collection, RefreshType refreshType);

	/**
	 * Delete folder list in user shelf
	 * @param folder instance of {@link CollectionItemDo}
	 * @param refreshType instance of {@link RefreshType}
	 * @param String instance of {@link String}
	 */

//	void deleteFolderInShelfView(CollectionItemDo collectionItemDo, RefreshType refreshType, String folderLevel);
	/**
	 * Refresh collection item list in user shelf
	 * @param collectionItem instance of {@link CollectionItemDo}
	 * @param refreshType instance of {@link RefreshType}
	 */
	void refreshCollectionItemInShelfList(CollectionItemDo collectionItem, RefreshType refreshType);
	
	/**
	 * Get user collection list
	 * @return instance of {@link CollectionDo} as List
	 */
	List<FolderDo> getShelfCollections();
	
	/**
	 * @return get collection if true else false
	 */
	boolean isFireConsumeShelfCollectionEvent();
	
	/**
	 * Get shelf collection by given collectionId
	 * @param collectionId of collection
	 */
	void openShelfCollection(String collectionId);
	
	/**
	 * Reset the Dragged image
	 */
	void resetDragImage();
	
	/**
	 * Disable the New folder and New collection links in shelf list view
	 */
	void disableFolderCollectionPanel();
	
	/**
	 * Enable the New folder and New collection links in shelf list view
	 */
	void enableFolderCollectionPanel();
	
	/**
	 * Disable the droppable event for the ShelfCollection.java object
	 */
	void disableDraggableEvent(String folderLevel, String folderObjectType);
	
	void collectionListScrollpanel(boolean isSetClear);

	void displayFoldersPanel(boolean isLoggedIn);
	
	/**
	 * Sets the default new collection panel text and CSS
	 */
	void setNewCollectionPanel();
	
	void setOpenCollectionId(String collectionId);

	void setUserShelfMsg(String userMsg);
	
	void getChildFolderItems(List<FolderDo> folderListDo);

	void getCollectionItems(List<FolderDo> searchResult);

	void getAllCollectionItems(String collectionId);

	void insertDraggedCollectionInShelfList(CollectionDo result, String parentId);   
	
	void refreshFolderItemData(FolderDo folderDo, RefreshFolderType refreshFolderType, HashMap<String,String> params);
	
	void changeShelfPanelActiveStyle();
	
	void updateShelfFolderName(String folderName);

	void setBackToSearch();

	void onClick(ClickEvent event);

	void removeMovedCollFolder(String sourceId);

	void onDragOverOpenFolder(String folderId,boolean showcollectionFormView);

	void insertMovedCollection(FolderDo folderDo,RefreshFolderType refreshFolderType, HashMap<String, String> params);

	void setMovedCollectionStyle(String gooruOId);

	void setChildFolderCollectionStyle(HashMap<String, String> params, String clickType);

	void openParentFolderEvent(); 
	
	Integer getChildPageNumber();

	void setChildPageNumber(Integer childPageNumber);
	
	void updateShelfFolderMetaData(String ideas, String performanceTasks, String questions);

	void setCollectionActiveStyle();
	
	void refreshFolderItemDataInSearchAddResource(FolderDo folderDo,
			RefreshFolderType refreshFolderType, HashMap<String, String> params);

	void reorderShelfItems(String itemId, int toBeMovedPos,String direction, HashMap<String, String> params, FolderDo folderDo, String itemSeqNumb);   
}