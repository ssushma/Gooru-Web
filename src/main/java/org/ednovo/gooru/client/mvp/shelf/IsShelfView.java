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
package org.ednovo.gooru.client.mvp.shelf;

import java.util.HashMap;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Search Team
 *
 */
public interface IsShelfView extends IsViewWithHandlers<ShelfUiHandlers> {

	/**
	 * Set collection meta data info
	 * @param collection instance of {@link CollectionDo}
	 */
	void setCollection(CollectionDo collection);
	
	/**
	 * Back to search view
	 */
	void setBackToSearch();
	
	/**
	 * Image upload for collection
	 * @param url of the image
	 */
	void onPostCollectionImageUpload(String url);
	
	/**
	 * Delete the collection
	 */
	void onPostCollectionDelete();
	
	/**
	 * Update collection update
	 */
	void onPostCollectionUpdate();
	
	/**
	 * Set No Data of the collection
	 */
	void setNoDataCollection();
 
	void setBalloonPopup();
	
	public FlowPanel getShelfViewMainContainer();
	
	void updateResoureCount(int resourceCount);
	
	public void getLoadingImageInvisible();
	
	public void getLoadingImageVisible();
	
	/**
	 * Edit the copy collection title
	 */
	void editCopyCollectionTitle();
	/**
	 * set focus copy collection title
	 */
	void setFocusCollectionTitle();

	void hideAllOpenedPopUp();
	/*
	 * Set the visibility for Collection Analytics
	 */
	void setCollectionAnalyticsVisibility(String shareValue);
	
	void setCollabCountByType(String type, int count);
	
	void setPersistantTabFlag(String flag);
	
	public SimplePanel getFolderListPanel();

	void CollMovedSucessFully(String sourceId,String targetId, String folderName, HashMap<String, String> params);  

	/**
	 * @function setOnlyNoDataCollection 
	 * 
	 * @created_date : Feb 23, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void setOnlyNoDataCollection();

	FolderDo getFolderDo(CollectionDo result);

	/**
	 * @function getLoadingImageLabel 
	 * 
	 * @created_date : Feb 27, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @return
	 * 
	 * @return : HTMLPanel
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	HTMLPanel getLoadingImageLabel();

	void setPusblishStatus(String publishStatus, CollectionDo colleDo);

	/**
	 * @function getEditPanel 
	 * 
	 * @created_date : Jul 23, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @return
	 * 
	 * @return : HTMLPanel
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	ScrollPanel getEditPanel();  
}
