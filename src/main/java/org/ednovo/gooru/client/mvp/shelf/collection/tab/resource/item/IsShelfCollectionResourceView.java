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
/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.List;

import org.ednovo.gooru.client.child.IsChildView;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author SearchTeam
 * 
 */
public interface IsShelfCollectionResourceView extends IsChildView<ShelfCollectionResourceChildPresenter>, IsDraggable {

	/**
	 * Reorder collection item sequence
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 */
	void onPostReorder(CollectionItemDo collectionItemDo);

	/**
	 * Collection item meta data update
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 */
	void onPostUpdate(CollectionItemDo collectionItemDo);
	
	/**
	 * Copy collection item
	 * @param collectionItemDo instance of {@link CollectionItemDo} 
	 */
	void onPostCopy(CollectionItemDo collectionItemDo);

	/**
	 * Delete collection item
	 */
	void onPostDelete();
	
	void onPutUpdate();
	
	/**
	 * Get User Collections
	 * @param result 
	 */
	void onPostUserCollections(List<CollectionDo> result);
	
	/**
	 * Add New collection item
	 */
	void addNewResource();
	
	Label getVisible();
	
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel);
	
	public void setFolderItems(TreeItem item, FolderListDo folderListDo);

	void onPostResourceReorder(CollectionItemDo collectionItemDo,ShelfCollectionResourceChildView shelfCollectionResourceChildView,String arrow, Integer newSequence);
	
	
	

}
