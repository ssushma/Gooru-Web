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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public interface IsCollectionResourceTabView extends IsViewWithHandlers<CollectionResourceTabUiHandlers> {
	
	/**
	 * Set collection meta data info
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	void setData(CollectionDo collectionDo);
	
	/**
	 * Set collection meta data info
	 * @param result instance of {@link CollectionDo}
	 */
	void insertData(CollectionItemDo result);	
	
	public void updateCollectionItem(CollectionItemDo collectionItem);
	
//	void updateData(ResourceDo result);	
	
	/**
	 * Create collection item
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 * @param newFlag if true new collection item else not  
	 */
	void insertColectionItem(CollectionItemDo collectionItemDo, boolean newFlag);
	
	/**
	 * Create collection item
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 * @param newFlag if true new collection item else not  
	 */
//	void insertCollectionItemForCopy(CollectionItemDo collectionItemDo, boolean isBeingCopiedToSameCollection);
	
	/**
	 * Delete collection item from collection
	 * @param collectionItemDo instance of {@link CollectionItemDo} 
	 * @param resourceChildView instance of {@link ShelfCollectionResourceChildView}
	 */
	void removeCollectionItem(CollectionItemDo collectionItemDo, ShelfCollectionResourceChildView resourceChildView);
	
	/**
	 * Set update/edit mode for collection item
	 * @param editMode enable edit if is true else update
	 * @param resourceWidget {@link Widget} the resource which is dragged.
	 */
	void setEditMode(boolean editMode, Widget resourceWidget);

	/**
	 * To show popup for creating/adding new resource to collection
	 * 
	 * 
	 */
	void displayNewResourcePopup();
	
	/**
	 * Return no text label.
	 */
	//Label setNoResourceLabel();
	
	
	/**
	 * Return no of collection items in the collection
	 */
//	int getCollectionItemSize();
	
	/**
	 * show resources exceeded popup
	 */
	void showMaximumCollectionItemsPopup();
	

	void hideUpdateResourceQuestionPopup();
	
	void hideUpdateResourcePopup();
	
	void updateCollectionItemImage(String fileName,String fileNameWithOutRepository);
		
	void removeUpdateQuestionView();

	void updateResouceItemImage(String url, String fileNameWithOutRespUrl, boolean isEditUserOwnResourceImage);

	void hideNoResourceMsg();
	
	void insertCollectionItemInAddResource(CollectionItemDo collectionItem, RefreshType refreshType);

	void closeAllOpenedPopUp();

	void uploadResource(MediaUploadDo result);

	void hideUpdateOwnResourcePopup();

	void OnBrowseStandardsClickEvent(Button addBtn);

	void setUpdatedStandardsCode(String setStandardsVal,Integer codeId, String setStandardDesc,boolean isQuestionResource, boolean userResource);

//	void reorderItemToNewPosition(ShelfCollectionResourceChildView shelfCollectionResourceChildView,Integer newSequence, String arrow);
}
