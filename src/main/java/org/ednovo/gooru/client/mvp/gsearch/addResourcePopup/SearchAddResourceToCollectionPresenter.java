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
package org.ednovo.gooru.client.mvp.gsearch.addResourcePopup;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemForSearchInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

/**
 * 
 * @fileName : SearchAddResourceToCollectionPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 22-APR-2015
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SearchAddResourceToCollectionPresenter extends PresenterWidget<IsSearchAddResourceToCollectionView> implements SearchAddResourceToCollectionUiHandlers,ClientConstants{


	ResourceSearchResultDo searchResultDo =null;
	String type =null;
	String accessType =null;
	private String parentId=null;
	HashMap<String, String>  urlParameters;
	 private String O1_LEVEL_VALUE = null, O2_LEVEL_VALUE = null, O3_LEVEL_VALUE = null;
	CollectionFormPresenter collectionFormPresenter;

	HashMap<String,String> successparams = new HashMap<String, String>();
	
	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;
	
	@Inject
	public SearchAddResourceToCollectionPresenter(EventBus eventBus, IsSearchAddResourceToCollectionView view, CollectionFormPresenter collectionFormPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);	
		this.collectionFormPresenter = collectionFormPresenter;
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	@Override
	public void getUserShelfData(ResourceSearchResultDo searchResultDo,String searchType) {
		this.searchResultDo =searchResultDo;
		getView().setDefaultPanelVisibility(false);
		getWorkspaceData(0,20,true,searchType);
	}
	@Override
	public void getUserShelfCollectionsData(CollectionSearchResultDo collectionsearchResultDo,String searchType) {
		this.searchResultDo =collectionsearchResultDo;
		getView().setDefaultPanelVisibility(true);
		getWorkspaceData(0,20,true,searchType);
		//getView().setCollectionSearchResultDo(this.collectionsearchResultDo);
	}
	public void getWorkspaceData(int offset,int limit, final boolean clearShelfPanel,final String searchType){
		if(COLLECTION.equalsIgnoreCase(searchType)){
			type= FOLDER;
			accessType = ACESSTEXT;
		}else{
			type=null;
			accessType = ACESSTEXT;
		}
		AppClientFactory.getInjector().getResourceService().getFolderWorkspace(offset, limit,null, type,true, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				if(folderListDo.getCount()==0){
					getView().displayNoCollectionsMsg();
				}else{
					getView().displayWorkspaceData(folderListDo,clearShelfPanel,searchType);
				}
			}
		});
	}
	@Override
	public void getFolderItems(final TreeItem item,String parentId) {
		AppClientFactory.getInjector().getfolderService().getChildFolders(0, 20, parentId,null, type,true, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}
	@Override
	public void addResourceToCollection(final String selectedFolderOrCollectionid,String searchType,final String title) {
		if(selectedFolderOrCollectionid!=null){
			//This will check the resource count
			AppClientFactory.getInjector().getfolderService().getCollectionResources(selectedFolderOrCollectionid,null, null, new SimpleAsyncCallback<FolderListDo>(){
				@Override
				public void onSuccess(FolderListDo result) {
					if (result.getCount()<25){
						//If the resource length is less than 25 then we need to create the collection item
						AppClientFactory.getInjector().getResourceService().createCollectionItem(selectedFolderOrCollectionid, searchResultDo.getGooruOid(), new SimpleAsyncCallback<CollectionItemDo>() {
							@Override
							public void onSuccess(CollectionItemDo result) {
								successparams.put("id", selectedFolderOrCollectionid);
								getView().displaySuccessPopup(title,selectedFolderOrCollectionid,successparams);
							}
						});
					}
				}
			});
		}
	}
	@Override
	public void addCollectionToFolder(final String selectedFolderOrCollectionid,String searchType, final String title, final int folerLevel,HashMap<String, String> urlparams) {
		this.urlParameters=urlparams;
		final CollectionDo collection = new CollectionDo();
		if(searchType.equalsIgnoreCase("collection")){
		collection.setGooruOid(searchResultDo.getGooruOid());
		collection.setSharing("anyonewithlink");
		if(selectedFolderOrCollectionid!=null){
			successparams.put("o1", selectedFolderOrCollectionid);
			O1_LEVEL_VALUE = urlparams.get("o1");
			O2_LEVEL_VALUE = urlparams.get("o2");
			O3_LEVEL_VALUE = urlparams.get("o3");
			
			if(O3_LEVEL_VALUE!=null){
				parentId=O3_LEVEL_VALUE;
			}else if(O2_LEVEL_VALUE!=null){
				parentId=O2_LEVEL_VALUE;
			}else if(O1_LEVEL_VALUE!=null){
				parentId=O1_LEVEL_VALUE;
			}
			AppClientFactory.getInjector().getfolderService().copyDraggedCollectionIntoFolder(collection,searchResultDo.getGooruOid(),parentId,false,new SimpleAsyncCallback<CollectionDo>() { 
				@Override
				public void onSuccess(CollectionDo result) {
					FolderDo folderDo=getFolderDo(result);
					HashMap<String,String> params = new HashMap<String,String>();
					if(O3_LEVEL_VALUE!=null) {
						params.put("o3", O3_LEVEL_VALUE);
					}
					if(O2_LEVEL_VALUE!=null) {
						params.put("o2", O2_LEVEL_VALUE);
					}
					if(O1_LEVEL_VALUE!=null) {
						params.put("o1", O1_LEVEL_VALUE);
					}
					AppClientFactory.fireEvent(new RefreshFolderItemForSearchInAddResourceEvent(folderDo, RefreshFolderType.INSERT, params));
			
				}
			});
			
		}else{
			getView().restrictionToAddResourcesData("Please select a folder to add collection");
			//getView().getButtonVisiblity();
		}
	}
		
	}
	public FolderDo getFolderDo(CollectionDo collectionDo) {
		FolderDo folderDo = new FolderDo();
		folderDo.setGooruOid(collectionDo.getGooruOid());
		folderDo.setTitle(collectionDo.getTitle());
		folderDo.setType(collectionDo.getCollectionType());
		folderDo.setSharing(collectionDo.getSharing());
		folderDo.setCollectionType(collectionDo.getCollectionType());
		ThumbnailDo thumbnailDo = new ThumbnailDo();
		thumbnailDo.setUrl(collectionDo.getThumbnailUrl());
		folderDo.setThumbnails(thumbnailDo);
		List<FolderItemDo> folderItems = new ArrayList<FolderItemDo>();
		if(collectionDo.getCollectionItems()!=null) {
			for(int i=0;i<collectionDo.getCollectionItems().size();i++) {
				CollectionItemDo collectionItemDo = collectionDo.getCollectionItems().get(i);
				FolderItemDo folderItemDo = new FolderItemDo();
				folderItemDo.setGooruOid(collectionItemDo.getGooruOid());
				folderItemDo.setTitle(collectionItemDo.getResourceTitle());
				folderItemDo.setType(collectionItemDo.getItemType());
				ResourceFormatDo resourceFormatDo = new ResourceFormatDo();
				resourceFormatDo.setValue(collectionItemDo.getCategory());
				folderItems.add(folderItemDo);
			}
			folderDo.setCollectionItems(folderItems);
		}
		return folderDo;
	}
	
	@Override
	public void addCollectionToMyCollections(String object,
			String currentsearchType) {
		final CollectionDo collection = new CollectionDo();
		if(currentsearchType.equalsIgnoreCase("collection")){
			collection.setGooruOid(searchResultDo.getGooruOid());
			AppClientFactory
			.getInjector()
			.getResourceService()
			.copyCollection(collection, "true", null,
					getSaveCollectionAsyncCallback());			
	}
		
}
	/**
	 * @return instance of collectionDo after collection save
	 */
	public SimpleAsyncCallback<CollectionDo> getSaveCollectionAsyncCallback() {
		if (saveCollectionAsyncCallback == null) {
			saveCollectionAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					//success msg
					getView().displaySuccessPopup(result.getTitle(), result.getGooruOid(), successparams);
					//hidePopup();

				}
			};
		}
		return saveCollectionAsyncCallback;
	}
	
	@Override
	public Button getAddButton() {
		return getView().getAddButton();
	}

	@Override
	public void hidePopup() {
		getView().hidePopup();
	}
}
