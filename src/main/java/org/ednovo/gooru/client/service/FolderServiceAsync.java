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
package org.ednovo.gooru.client.service;

import java.util.List;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.exception.ServerDownException;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.folder.FolderTocDo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FolderServiceAsync extends BaseServiceAsync {

	void createFolder(CollectionDo collectionDo, AsyncCallback<CollectionDo> callback);
	
	void createFolderToParentFolder(CollectionDo collectionDo, String parentId, AsyncCallback<CollectionDo> callback);

	void getAllFolders(AsyncCallback<List<CollectionItemDo>> callback);
	
	void getFolders(String collectionId, AsyncCallback<List<CollectionItemDo>> callback);
	
	void deleteFolder(String collectionId, AsyncCallback<Void> callback);
	
//	void getFoldersAndCollections(String folderId, AsyncCallback<List<CollectionDo>> callback);

	void getFolderInformation(String folderId, AsyncCallback<CollectionDo> callback);

//	void updateFolderMetadata(String collectionId, String title, String description, String grade, String sharing, String vocabulary, String taxonomyCode, String updateTaxonomyByCode, String action, AsyncCallback<CollectionDo> callback);

	//New APIs for 6.0
	void getChildFolders(int offset, int limit,String parentId,String sharingType, String collectionType, AsyncCallback<FolderListDo> callback);
	
	void deleteCollectionsFolder(String folderId, AsyncCallback<Void> callback);

	void createFolder(String folderName, String parentId, boolean addToShelf, AsyncCallback<FolderDo> callback);

	void moveCollectionIntoFolder(String sourceId, String targetId,AsyncCallback<Void> callback);

	void createCollectionInParent(CollectionDo data, String courseCodeId,String folderId,AsyncCallback<CollectionDo> simpleAsyncCallback);
	
	void updateFolder(String folderId, String title, String ideas, String questions, String performance, AsyncCallback<Void> simpleAsyncCallback);

	void copyDraggedCollectionIntoFolder(CollectionDo collectionDo,String courseCodeId,String parentId,boolean addToShelf, AsyncCallback<CollectionDo> simpleAsyncCallback);

	void getCollectionResources(String parentId,String sharingType, String collectionType, AsyncCallback<FolderListDo> callback);
	
	void reorderFoldersOrCollections(int itemToBeMovedPosSeqNumb, String collectionItemId, AsyncCallback<Void> simpleAsyncCallback);
	
	void getTocFolders(String folderId, AsyncCallback<FolderTocDo> callback);
	
	void getFolderMetaData(String folderId, AsyncCallback<FolderDo> callback);
}
