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
package org.ednovo.gooru.client.mvp.folders.item;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildPresenter;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.ClasspageService;
import org.ednovo.gooru.application.client.service.FolderServiceAsync;
import org.ednovo.gooru.application.client.service.ResourceServiceAsync;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

/**
 * @author Search Team
 * 
 */
public class FolderItemChildPresenter extends ChildPresenter<FolderItemChildPresenter, IsFolderItemView>{

	private SimpleAsyncCallback<Void> deleteFolderAsyncCallback;
	@Inject
	private FolderServiceAsync folderService;
	ClasspageService classpageService=null;
	private CollectionItemDo collectionItemDo = null;
	private SimpleAsyncCallback<CollectionItemDo> reorderFolderItemAsyncCallback;
	
	private String FOLDER_LEVEL_ONE = "1";
	
	private String FOLDER_LEVEL_TWO = "2";

	private String FOLDER_LEVEL_THREE = "3";

	/**
	 * Class constructor
	 * 
	 * @param childView 
	 */
	public FolderItemChildPresenter(IsFolderItemView childView) {
		super(childView);
	}
	
	/** 
	 * This method is to get the classpageService
	 */
	public ClasspageService getClasspageService() {
		return classpageService;
	}


	/** 
	 * This method is to set the classpageService
	 */
	public void setClasspageService(ClasspageService classpageService) {
		this.classpageService = classpageService;
	}
	
	public FolderServiceAsync getFolderService() {
		return folderService;
	}

	
	public void deleteMyFolder(String collectionId, final CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
		AppClientFactory.getInjector().getfolderService().deleteFolder(collectionId, new SimpleAsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
					String level = AppClientFactory.getPlaceManager().getRequestParameter("level");
					String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
					getView().asWidget().removeFromParent();
					CollectionDo collectionDo = new CollectionDo();
					collectionDo.setTitle(collectionItemDo.getResource().getTitle());
					collectionDo.setGoals(collectionItemDo.getResource().getGoals());
					collectionDo.setGooruOid(collectionItemDo.getResource().getGooruOid());
					collectionDo.setCollectionType(collectionItemDo.getResource().getResourceType().getName());

					if(level!=null) {
						if(level.equalsIgnoreCase(FOLDER_LEVEL_ONE)||level.equalsIgnoreCase(FOLDER_LEVEL_TWO)||level.equalsIgnoreCase(FOLDER_LEVEL_THREE)) {
							AppClientFactory.fireEvent(new InsertFolderInShelfViewEvent(
									collectionItemDo, RefreshType.DELETE, level));
						}
					} else {
						AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(
								collectionDo, RefreshType.DELETE));
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.FOLDERS);
					}
				}
			});
	}
	
	public void setDeleteFolderAsyncCallback(
			SimpleAsyncCallback<Void> deleteFolderAsyncCallback) {
		this.deleteFolderAsyncCallback = deleteFolderAsyncCallback;
	}
	
	public FolderServiceAsync getfolderService() {
		return AppClientFactory.getInjector().getfolderService();
	}
	public SimpleAsyncCallback<Void> getDeleteFolderAsyncCallback() {
			
		return deleteFolderAsyncCallback;
	}

	public void reorderCollectionItem(CollectionItemDo collectionItemDo) { 
		getResourceService().reorderCollectionItem(collectionItemDo, getReorderFolderItemAsyncCallback());
	}
	
	public AsyncCallback<CollectionItemDo> getReorderFolderItemAsyncCallback() {
		if (reorderFolderItemAsyncCallback == null) {
			reorderFolderItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().onPostReorder(result);
				}
			};
		}
		return reorderFolderItemAsyncCallback;
	}
	public ResourceServiceAsync getResourceService() {
		
		return AppClientFactory.getInjector().getResourceService();
	}

	public void deleteFolderInShelfView(){
		
	}
	
}
