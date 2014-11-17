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

import java.util.List;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceHandler;
import org.ednovo.gooru.client.mvp.shelf.event.ReorderCollectionResourcesEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateEditResourceImageHandler;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateQuestionImageHandler;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;

/**
 * @author Search Team
 *
 */
public interface CollectionResourceTabUiHandlers extends BaseUiHandlers,UpdateQuestionImageHandler,UpdateEditResourceImageHandler, InsertCollectionItemInAddResourceHandler,ReorderCollectionResourcesEventHandler {
	
	//void imageUpload();
	
	/**
	 * @param collectionDo
	 * @param clickType
	 */
	void addResourcePopup(CollectionDo collectionDo, String clickType);
	
	/**
	 * @param questionItemId
	 * @param collectionQuestionItemDo
	 * @param thumbnailUrl
	 */
	void updateQuestionResource(String questionItemId,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl);
	
	/**
	 * @param collectionItemId
	 */
	void updateQustionImage(String collectionItemId);
	
	/**
	 * @param collectionItemDo
	 * @param tagList
	 */
	void updateResourceInfo(CollectionItemDo collectionItemDo,List<String> tagList);
	
	/**
	 * @param collectionQuestionId
	 */
	void removeQuestionImage(String collectionQuestionId);
	
	/**
	 * 
	 */
	void imageEditResourceUpload();
	
//	void updateQuestionImage(String collectionItemId,String fileName);
	
	/**
	 * @param collectionItemDo
	 */
	void showEditQuestionResourcePopup(CollectionItemDo collectionItemDo);

	/**
	 * 
	 */
	void imageEditUserOwnResourceUpload();

//	void getUserResourceMediaFileName(String resourceFilePath);

	/**
	 * @param string
	 * @param gooruOid
	 */
	void editUserOwnResource(String string, String gooruOid);

	/**
	 * @param val
	 */
	void getBrowseStandardsInfo(boolean val);

	/**
	 * 
	 */
	void addUpdatedBrowseStandards();

	/**
	 * 
	 */
	void closeBrowseStandardsPopup();


}