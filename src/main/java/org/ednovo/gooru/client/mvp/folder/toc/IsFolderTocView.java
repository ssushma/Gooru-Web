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
package org.ednovo.gooru.client.mvp.folder.toc;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderTocDo;

import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
/**
 * @fileName : IsFolderTocView.java
 *
 * @description : 
 *
 * @version : 1.3
 *
 * @date: 06-02-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public interface IsFolderTocView extends IsViewWithHandlers<FolderTocUiHandlers>{
	/**
	 * This method is used to set folder data in the TOC page
	 * @param foldersArrayList
	 */
	void setFolderItems(FolderTocDo  foldersArrayList);
	/**
	 * This method is used to set folder data for child folders
	 * @param item
	 * @param folderListDo
	 * @param parentId
	 */
	public void setFolderItems(TreeItem item,FolderTocDo folderListDo,String parentId);
	/**
	 * This method is used to clear TOC data.
	 */
	void clearTocData();
	/**
	 * This method is used to set banner image
	 */
	void setBannerImages();
	/**
	 * To set the bannner images, titles and logo based on the library name.
	 */
	void setBannerStaticImages();
	/**
	 * This method is used to set banner image based on selected course
	 * @param folderDo
	 */
	void setCourseBanner(FolderDo folderDo);
	/**
	 * This method is used to hide panels
	 */
	void hidePanels();
	/**
	 * To show profile page banner
	 */
	void showProfileBanner();
	/**
	 * This method is used to set back button text based on the previous click
	 * @param from
	 */
	void setBackButtonText(String from);
	/**
	 * This is used to get tree panel
	 * @return
	 */
	Tree getTreePanel();
}
