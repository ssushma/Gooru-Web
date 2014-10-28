package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateFolderItemHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView;

/**
 * @author Search Team
 *
 */
public interface FolderItemTabUiHandlers extends BaseUiHandlers, UpdateFolderItemHandler { 
	
	void createFolderInParent(String folderName, String parentId);
	public void updateCollectionInfo(String folderId, String title, String description); 
	public void setFolderTitle(String title);
	public void setFolderData(String folderId, String folderParentName, int pageNumber);
	void reorderFoldersOrCollection(ShelfFolderItemChildView shelfFolderItemChildView, int itemToBeMovedPosSeqNumb,int itemPosSeqNumb, String downArrow, String collectionItemId, int itemSeqToAPI);
}