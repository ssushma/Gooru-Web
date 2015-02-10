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

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.folder.toc.util.FolderCollectionView;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : FolderTocView.java
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
public class FolderTocView extends BaseViewWithHandlers<FolderTocUiHandlers> implements IsFolderTocView {

	private static FolderTocViewUiBinder uiBinder = GWT
			.create(FolderTocViewUiBinder.class);

	interface FolderTocViewUiBinder extends UiBinder<Widget, FolderTocView> {
	}
	
	@UiField VerticalPanel pnlAddFoldersCollections;
	
	public FolderTocView() {
		setWidget(uiBinder.createAndBindUi(this));
		//setData();
	}
	/**
	 * This method is used to set folder TOC Data.
	 */
	private void setData() {
		pnlAddFoldersCollections.clear();
		for(int i=0;i<5;i++){
			//pnlAddFoldersCollections.add(new FolderCollectionView());
		}
	}
	@Override
	public void setFolderItems(FolderListDo folderListDo) {
		// TODO Auto-generated method stub
		pnlAddFoldersCollections.clear();
		pnlAddFoldersCollections.add(new FolderCollectionView(folderListDo));
	}
}
