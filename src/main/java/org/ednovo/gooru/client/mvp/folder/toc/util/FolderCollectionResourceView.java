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
package org.ednovo.gooru.client.mvp.folder.toc.util;

import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FolderCollectionResourceView extends Composite {

	private static FolderCollectionResourceViewUiBinder uiBinder = GWT
			.create(FolderCollectionResourceViewUiBinder.class);

	interface FolderCollectionResourceViewUiBinder extends
			UiBinder<Widget, FolderCollectionResourceView> {
	}
	@UiField UlPanel ulCollectionResources;
	FolderDo folderDo;
	
	FolderTocCBundle res;
	
	LiPanel liPanel;
	public FolderCollectionResourceView(FolderDo folderDo) {
		this.res = FolderTocCBundle.INSTANCE;
		res.css().ensureInjected();
		this.folderDo=folderDo;
		initWidget(uiBinder.createAndBindUi(this));
		setListData();
	}

	private void setListData() {
		int collectionItemsCount=folderDo.getCollectionItems().size();
		String resourceType="";
		for(int i=0;i<collectionItemsCount;i++){
			liPanel=new LiPanel();
			Label text=new Label(folderDo.getCollectionItems().get(i).getTitle());
			liPanel.add(text);
			resourceType=folderDo.getCollectionItems().get(i).getResourceFormat().getValue();
			liPanel.addStyleName(resourceType);
			ulCollectionResources.add(liPanel);
		}
	}
}
