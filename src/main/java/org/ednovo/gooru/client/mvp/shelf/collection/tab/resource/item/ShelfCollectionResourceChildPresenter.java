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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildPresenter;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;

/**
 * @author Search Team
 * 
 */
public class ShelfCollectionResourceChildPresenter extends ChildPresenter<ShelfCollectionResourceChildPresenter, IsShelfCollectionResourceView> {

	private SimpleAsyncCallback<CollectionItemDo> updateCollectionItemAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> copyCollectionItemAsyncCallback;
	
	private SimpleAsyncCallback<Void> updateQuestionItemResourceAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> createCollectionItemAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> reorderCollectionItemAsyncCallback;

	private SimpleAsyncCallback<Void> deleteCollectionItemAsyncCallback;
	
	private SimpleAsyncCallback<List<CollectionDo>> getMyUserCollectionsAsyncCallback;
	
	
	@Inject private ImageUploadPresenter imageUploadPresenter;

	/**
	 * Class constructor
	 * 
	 * @param childView 
	 */
	public ShelfCollectionResourceChildPresenter(IsShelfCollectionResourceView childView) {
		super(childView);
	}

	/**
	 * Update collection item by collection item id which is mandatory   
	 * 
	 * @param collectionItemId gooruOid of collection item
	 * @param narration about collection item resource
	 * @param start  page or time of collection item
	 * @param stop  page or time of collection item
	 */
	public void updateCollectionItem(String collectionItemId, String narration, String start, String stop) {
		getResourceService().updateCollectionItemMetadata(collectionItemId, narration, null, start, stop, getUpdateCollectionItemAsyncCallback());
	}
	public void updateNarrationItem(String collectionItemId, String narration) {
		getResourceService().updateNarrationMetadata(collectionItemId, narration, null, getUpdateCollectionItemAsyncCallback());
	}

	
	/*public void getUserCollections(){
		getResourceService().getUserCollection(getUserCollectionsAsyncCallback());
	}*/
	public void getUserColletionsList(Integer pageSize,Integer pageNum)
	{
		getResourceService().getUserCollectionList(pageSize,pageNum,false,getUserCollectionsAsyncCallback());
	}

	/**
	 *  Delete collection item by collection item id which is mandatory   
	 * 
	 * @param collectionItemId  gooruOid of collection item
	 */
	public void deleteCollectionItem(String collectionItemId) {
		this.getResourceService().deleteCollectionItem(collectionItemId, getDeleteCollectionItemAsyncCallback());
	}

	/**
	 * Reorder collection item with new sequence
	 * 
	 * @param collectionItem instance of {@link CollectionItemDo}
	 */
	public void reorderCollectionItem(CollectionItemDo collectionItem) {
		getResourceService().reorderCollectionItem(collectionItem, getReorderCollectionItemAsyncCallback());
	}

	/**
	 * Copy collection item by collection item id which is mandatory  
	 * 
	 * @param collectionItemId gooruOid of collection item
	 */
	/*public void copyCollectionItem(String collectionItemId) {
		getResourceService().copyCollectionItem(collectionItemId, getCopyCollectionItemAsyncCallback());
	}*/
	
	/**
	 * create collection item by collection item id which is mandatory  
	 * 
	 * @param collectionItemId gooruOid of collection item
	 */
	public void createCollectionItem(String collectionId, String collectionItemId) {
		getResourceService().copyCollectionItem(collectionId, collectionItemId, getCopyCollectionItemAsyncCallback());
	}
    /*public void updateResourceQuestion(String collectionItemId,CollectionQuestionItemDo collectionQuestionItemDo){
    //	getResourceService().updateQuestionResource(collectionItemId, collectionQuestionItemDo, getUpdateQuestionItemResourceAsyncCallback());
    	
    }*/
	/**
	 * @return instance of {@link CollectionItemDo} after update the collection item
	 */
	public SimpleAsyncCallback<List<CollectionDo>> getUserCollectionsAsyncCallback() {
		if (getMyUserCollectionsAsyncCallback == null) {
			getMyUserCollectionsAsyncCallback = new SimpleAsyncCallback<List<CollectionDo>>() {

				@Override
				public void onSuccess(List<CollectionDo> result) {
					getView().onPostUserCollections(result);
				}
			};
		}
		return getMyUserCollectionsAsyncCallback;
	}
	
	public void getWorkspaceData(int offset,int limit,final boolean clearShelfPanel){
		AppClientFactory.getInjector().getResourceService().getFolderWorkspace(offset, limit,null, null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().displayWorkspaceData(folderListDo,clearShelfPanel);
			}
		});
	}

	public void getFolderItems(final TreeItem item,String parentId) {
		AppClientFactory.getInjector().getfolderService().getChildFolders(0, 20, parentId,null, null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}

	public SimpleAsyncCallback<CollectionItemDo> getUpdateCollectionItemAsyncCallback() {
		if (updateCollectionItemAsyncCallback == null) {
			updateCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().getVisible().setVisible(false);
					getView().onPostUpdate(result);
				
					
				}
				@Override
				public void onFailure(Throwable arg0) {
					super.onFailure(arg0);
					getView().getVisible().setVisible(false);
				}
			};
		}
		return updateCollectionItemAsyncCallback;
	}

	
	/**
	 * @return instance of {@link CollectionItemDo} after reorder the collection item
	 */
	public SimpleAsyncCallback<CollectionItemDo> getReorderCollectionItemAsyncCallback() {
		if (reorderCollectionItemAsyncCallback == null) {
			reorderCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().onPostReorder(result);
				}
			};
		}
		return reorderCollectionItemAsyncCallback;
	}

	/**
	 * @return instance of {@link CollectionItemDo}
	 */
	public SimpleAsyncCallback<CollectionItemDo> getCopyCollectionItemAsyncCallback() {
		if (copyCollectionItemAsyncCallback == null) {
			copyCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					
					getView().onPostCopy(result);
				}
			};
		}
		return copyCollectionItemAsyncCallback;
	}

	/**
	 * @return instance of {@link CollectionItemDo}
	 */
	public SimpleAsyncCallback<CollectionItemDo> getCreateCollectionItemAsyncCallback() {
		if (createCollectionItemAsyncCallback == null) {
			createCollectionItemAsyncCallback = new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					getView().onPostCopy(result);
				}
			};
		}
		return copyCollectionItemAsyncCallback;
	}

	public SimpleAsyncCallback<Void> getDeleteCollectionItemAsyncCallback() {
		if (deleteCollectionItemAsyncCallback == null) {
			deleteCollectionItemAsyncCallback = new SimpleAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					getView().onPostDelete();
				}
			};
		}
		return deleteCollectionItemAsyncCallback;
	}
	public SimpleAsyncCallback<Void> getUpdateQuestionItemResourceAsyncCallback() {
		if (updateQuestionItemResourceAsyncCallback == null) {
			updateQuestionItemResourceAsyncCallback = new SimpleAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					getView().onPutUpdate();
					
				}
			};
		}
		return updateQuestionItemResourceAsyncCallback;
	}

	public void setUpdateQuestionItemResourceAsyncCallback(
			SimpleAsyncCallback<Void> updateQuestionItemResourceAsyncCallback) {
		this.updateQuestionItemResourceAsyncCallback = updateQuestionItemResourceAsyncCallback;
		
	}
	
	
	

	public ResourceServiceAsync getResourceService() {
		
		return AppClientFactory.getInjector().getResourceService();
	}

	public void reorderMyCollectionItem(CollectionItemDo collectionItemDo, final ShelfCollectionResourceChildView shelfCollectionResourceChildView,final String arrow, final Integer newSequence) {
		AppClientFactory.getInjector().getResourceService().reorderCollectionItem(collectionItemDo, new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				getView().onPostResourceReorder(result,shelfCollectionResourceChildView,arrow,newSequence);  
			}
		});
	}

}

