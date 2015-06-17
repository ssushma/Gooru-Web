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
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.folder.FolderListDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class MyCollectionsListPresenter extends PresenterWidget<IsMyCollectionsListView> implements MyCollectionsListUiHandlers{
	
	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	/**
	 * Constructor
	 * @param eventBus
	 * @param view
	 */
	@Inject
	public MyCollectionsListPresenter(MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter,EventBus eventBus, IsMyCollectionsListView view) {
		super(eventBus, view);
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
		getView().setUiHandlers(this);
	}

	@Override
	public void setData(String type,HTMLPanel slotPanel,FolderListDo result) {
		getView().setData(type,slotPanel,result);
	}
	
	@Override
	public void setListPresenterBasedOnType(String type,HTMLPanel slotPanel) {
		clearSlot(ShelfMainPresenter.RIGHT_SLOT);
		getMyCollectionsRightClusterPresenter().setDefaultActiveTab();
		getMyCollectionsRightClusterPresenter().setTabItems(2, type,slotPanel);
		setInSlot(ShelfMainPresenter.RIGHT_SLOT, getMyCollectionsRightClusterPresenter());
	}
	@Override
	public MyCollectionsRightClusterPresenter getMyCollectionsRightClusterPresenter() {
		return myCollectionsRightClusterPresenter;
	}

	@Override
	public void reorderWidgetPositions(String idToMove,int itemSeqToAPI) {
		AppClientFactory.getInjector().getfolderService().reorderFoldersOrCollections(itemSeqToAPI,idToMove, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				getView().resetWidgetPositions();
				//getView().onReorderChangeWidgetPosition(shelfFolderItemChildView,itemToBeMovedPosSeqNumb,itemPosSeqNumb,downArrow);
			}
		});
	}
}
