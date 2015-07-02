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
package org.ednovo.gooru.client.mvp.gshelf.collectioncontent;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class CollectionContentPresenter extends PresenterWidget<IsCollectionContentView> implements CollectionContentUiHandlers {
	
	final String SUBJECT="subject";
	
	final String COURSE="course";
	
	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CollectionContentPresenter( EventBus eventBus,IsCollectionContentView view) {
		super(eventBus,view);
		getView().setUiHandlers(this);
		getView().setCollectionContentPresenter(this);
	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal(){
		super.onReveal();
	}

	@Override
	public void setData(final FolderDo folderDo) {
		/**As off now the API create lession is not implemented hardcode the collection id for testing **/
		AppClientFactory.getInjector().getResourceService().getCollection("431c086c-2e81-4318-9e87-375235a7b84c",true, new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo result) {
				getView().setData(result,folderDo);
			}
		});
	}
	@Override
	public void reorderWidgetPositions(String idToMove,int itemSeqToAPI) {
		AppClientFactory.getInjector().getfolderService().reorderFoldersOrCollections(itemSeqToAPI,idToMove, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				getView().resetWidgetPositions();
			}
		});
	}
	@Override
	public void updateNarrationItem(final CollectionItemDo collectionItem, String narration){
		AppClientFactory.getInjector().getResourceService().updateNarrationMetadata(collectionItem.getCollectionItemId(), narration, null, new SimpleAsyncCallback<CollectionItemDo>() {
			@Override
			public void onSuccess(CollectionItemDo result) {
				collectionItem.setNarration(result.getNarration());
				collectionItem.setStart(result.getStart());
				collectionItem.setStop(result.getStop());
			}
		});
	}
	@Override
	public void deleteCollectionItem(String collectionItemId) {
		AppClientFactory.getInjector().getResourceService().deleteCollectionItem(collectionItemId, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
}
