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
package org.ednovo.gooru.client.mvp.gshelf.courselist;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.folder.FolderListDo;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author Search Team
 *
 */
public interface MyCollectionsListUiHandlers extends BaseUiHandlers{
	/**
	 * This method is used to set content
	 * @param type
	 * @param slotPane
	 * @param resultl
	 */
	public void setData(String type,HTMLPanel slotPane,FolderListDo result,boolean clrPanel);
	/**
	 * This method is used to set type of presenter based on the type
	 * @param type
	 * @param slotPanel
	 * @param folderObj
	 */
	public void setListPresenterBasedOnType(String type,HTMLPanel slotPanel,FolderDo folderObj);
	/**
	 * This method will return the Right Cluster Presenter
	 * @return
	 */
	MyCollectionsRightClusterPresenter getMyCollectionsRightClusterPresenter();
	/**
	 * This method is used to reset widgets positions
	 * @param idToMove
	 * @param itemSeqToAPI
	 */
	public void reorderWidgetPositions(String idToMove,int itemSeqToAPI);
	/**
	 * This method is used to set Data in the content slot
	 * @param type
	 * @param slotPanel
	 * @param folderId
	 */
	public void setDataInContentSlot(String type,HTMLPanel slotPanel,String folderId);
}
