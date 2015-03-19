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
package org.ednovo.gooru.client.mvp.shelf.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.folders.event.RefreshCollectionInFolderLevelListEvent;
import org.ednovo.gooru.client.mvp.folders.event.RefreshCollectionInFolderListEvent;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormPresenter.IsCollectionFormProxy;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.OpenParentFolderEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.RefreshFolderItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyDraggedCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.service.ShelfServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderItemDo;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

/**
 * @author Search Team
 *
 */
public class CollectionFormPresenter extends BasePlacePresenter<IsCollectionFormView, IsCollectionFormProxy> implements CollectionFormUiHandlers {

	@Inject
	private ShelfServiceAsync shelfService;

	@Inject
	private ResourceServiceAsync resourceService;

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;

	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;

	private SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback;
	
	private String resourceUid;

	private String mediaType;
	
	private String collectionUid;

	private static final String RESOURCE_ID = "resourceId";
	
	private static final String MEDIA_TYPE = "mediaType";

	private static final String ID = "id";
	
	private String FOLDER_LEVEL_ONE = "1";
	
	private String FOLDER_LEVEL_TWO = "2";

	private String FOLDER_LEVEL_THREE = "3";
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";

	private static String RESOURCE_ID_TO_ADD = "resourceId";
	
	private static String IS_FROM_ADDRESOURCE = "fromAddResource";
	
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.COLLECTION)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsCollectionFormProxy extends ProxyPlace<CollectionFormPresenter> {
	}

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CollectionFormPresenter(IsCollectionFormView view, IsCollectionFormProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
		setSaveCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
		
				getView().resetAssessmentFields();
				Map<String, String> params = new HashMap<String, String>();
				String level = AppClientFactory.getPlaceManager().getRequestParameter("level");
				String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
				String previousNameToken = AppClientFactory.getPlaceManager().getPreviousRequest().getNameToken();
				
				getView().hide();
				
				String mycollection=AppClientFactory.getPlaceManager().getRequestParameter("myCollection");
				if(mycollection != null){
					if(mycollection.equals("true")){
						if(!AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)){
							Map<String,String> params1 = new HashMap<String,String>();
							fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT_AND_VIEW));
							params1.put("id", result.getGooruOid());
							PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, params1);
							AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
						}
					}
				}else{
				if(previousNameToken.equalsIgnoreCase(PlaceTokens.EDIT_FOLDERS)||previousNameToken.equalsIgnoreCase(PlaceTokens.FOLDERS)) {
					if(level!=null||folderId!=null) {
						params.put("level", level);
						params.put("folderid", folderId);
						fireEvent(new RefreshCollectionInFolderLevelListEvent(result,RefreshFolderType.INSERT));
						if(level.equalsIgnoreCase(FOLDER_LEVEL_ONE)||level.equalsIgnoreCase(FOLDER_LEVEL_TWO)||level.equalsIgnoreCase(FOLDER_LEVEL_THREE)) {
							CollectionItemDo collectionItemDo = new CollectionItemDo();
							ResourceDo resourceDo = new ResourceDo();
							ResourceTypeDo resourceTypeDo = new ResourceTypeDo();
							resourceDo.setResourceType(resourceTypeDo);
							collectionItemDo.setResource(resourceDo);
							
							collectionItemDo.getResource().setTitle(result.getTitle());
							collectionItemDo.getResource().setGooruOid(result.getGooruOid());
							collectionItemDo.getResource().getResourceType().setName(result.getCollectionType());
							
							AppClientFactory.fireEvent(new InsertFolderInShelfViewEvent(collectionItemDo, RefreshType.INSERT, level));
						}
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_FOLDERS, params);
					} else {
						fireEvent(new RefreshCollectionInShelfListEvent(result,RefreshType.INSERT));
						fireEvent(new RefreshCollectionInFolderListEvent(result,RefreshFolderType.INSERT));
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.FOLDERS);
					}
				} else {
					String nameToken = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
					if(nameToken.equals(PlaceTokens.SHELF)) {
						fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT_AND_VIEW));
						Map<String,String> params1 = new HashMap<String,String>();
						if(result.getCollectionType().equalsIgnoreCase("assessment/url")){
							PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, params1);
							AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
						}else{
							params1.put("id", result.getGooruOid());
							PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, params1);
							AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
						}
					} else {
						if(IS_FROM_ADDRESOURCE.equalsIgnoreCase("resourceidfromAddResourcePresenter")){
							Map<String,String> params1 = new HashMap<String,String>();
							params1.put("id", result.getGooruOid());
							//fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
							AppClientFactory.getInjector().getResourceService().createCollectionItem(result.getGooruOid(), RESOURCE_ID_TO_ADD, new SimpleAsyncCallback<CollectionItemDo>() {
								@Override
								public void onSuccess(CollectionItemDo result) {
								
								}
							});
							fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
						}else if(nameToken.equals(PlaceTokens.COLLECTION_SEARCH)){
							fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
						}else{
							fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT_AND_VIEW));
							Map<String,String> params1 = new HashMap<String,String>();
							if(result.getCollectionType().equalsIgnoreCase("assessment/url")){
								PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, params1);
								AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
							}else{
								params1.put("id", result.getGooruOid());
								PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, params1);
								AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
							}
					 }
				   }
				}
			  }
			}
		});
		setCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().setData(result);
			}
		});
		setCourseAsyncCallback(new SimpleAsyncCallback<List<LibraryCodeDo>>() {

			@Override
			public void onSuccess(List<LibraryCodeDo> result) {
				getView().setLibraryCodes(result);
			}
		});
	}

	@Override
	public void saveCollection(String folderId,final String o1,final String o2, final String o3) {	
		CollectionDo collection = getView().getData();
		if (collection.getGooruOid() == null) {
			if (resourceUid == null) {
				if(folderId==null) {
					getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
					
				} else {
					AppClientFactory.getInjector().getfolderService().createCollectionInParent(getView().getData(), getView().getCourseCodeId(), folderId,new SimpleAsyncCallback<CollectionDo>() {
						@Override
						public void onSuccess(CollectionDo result) {
							String placeToken = AppClientFactory.getCurrentPlaceToken();
							if(placeToken.equals(PlaceTokens.SHELF)) {
								MixpanelUtil.mixpanelEvent("Organize_add_collection_to_folder");	
							} else if(placeToken.equals(PlaceTokens.RESOURCE_SEARCH) || placeToken.equals(PlaceTokens.COLLECTION_SEARCH)) {
								MixpanelUtil.mixpanelEvent("Search_add_collection_to_folder");
							}
							
							FolderDo folderDo = getFolderDo(result);
							getView().hide();
							
							HashMap<String, String> params = new HashMap<String, String>();
							if(o3!=null) {
								params.put(O1_LEVEL, o1);
								params.put(O2_LEVEL, o2);
								params.put(O3_LEVEL, o3);
								AppClientFactory.fireEvent(new RefreshFolderItemEvent(folderDo, RefreshFolderType.INSERT, params,result)); 
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF,params);
								AppClientFactory.fireEvent(new OpenParentFolderEvent());
							} else if(o2!=null) {
								params.put(O1_LEVEL, o1);
								params.put(O2_LEVEL, o2);
								AppClientFactory.fireEvent(new RefreshFolderItemEvent(folderDo, RefreshFolderType.INSERT, params,result)); 
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF,params);
								AppClientFactory.fireEvent(new OpenParentFolderEvent());
							} else if(o1!=null){
								params.put(O1_LEVEL, o1);
								AppClientFactory.fireEvent(new RefreshFolderItemEvent(folderDo, RefreshFolderType.INSERT, params,result)); 
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF,params);
								AppClientFactory.fireEvent(new OpenParentFolderEvent());
							} else {
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF);
							}
//							fireEvent(new CreateCollectionInFolder(result));
							
						}
					});
					
				}
			} else {
				try{
					if(!mediaType.isEmpty()) {
						collection.setMediaType(mediaType);
					}
				}catch(Exception e){
					
				}
				
				getResourceService().createCollectionWithItem(collection, getView().getCourseCodeId(), resourceUid, getSaveCollectionAsyncCallback());
			}
		} else {
			getResourceService().copyCollection(collection, "true", getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
		}
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		this.getTaxonomyService().getCourse(getCourseAsyncCallback());
		if(!(AppClientFactory.isAnonymous())){
			getView().getAccountTypeId();
		}
	}

	@Override
	protected void onReset() {
		super.onReset();
		resourceUid = getPlaceManager().getRequestParameter(RESOURCE_ID);
		if(getPlaceManager().getRequestParameter(MEDIA_TYPE)!=null) {
			mediaType = getPlaceManager().getRequestParameter(MEDIA_TYPE);
//			getView().updateCollectionFormCheckBox(false);
		} else {
//			getView().updateCollectionFormCheckBox(true);
		}
		collectionUid = getPlaceManager().getRequestParameter(ID);
		if (collectionUid != null) {
			getResourceService().getCollection(collectionUid, true, getCollectionAsyncCallback());
		}
	}
	
	@Override
	protected void onHide() {
		super.onHide();
		getView().closeAllopenedPopUp();
	}

	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}

	public ShelfServiceAsync getShelfService() {
		return shelfService;
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}

	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}

	public void setTaxonomyService(TaxonomyServiceAsync taxonomyService) {
		this.taxonomyService = taxonomyService;
	}

	public SimpleAsyncCallback<CollectionDo> getSaveCollectionAsyncCallback() {
		return saveCollectionAsyncCallback;
	}

	public void setSaveCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback) {
		this.saveCollectionAsyncCallback = saveCollectionAsyncCallback;
	}

	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	public void setCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}

	public SimpleAsyncCallback<List<LibraryCodeDo>> getCourseAsyncCallback() {
		return courseAsyncCallback;
	}

	public void setCourseAsyncCallback(SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback) {
		this.courseAsyncCallback = courseAsyncCallback;
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.COLLECTION;
	}

	@Override
	public void copyCollection(String collectionTitle, String collectionId) {  
		CollectionDo collectionDo = getView().getData();
		collectionDo.setTitle(collectionTitle);
		collectionDo.setGooruOid(collectionId);
		AppClientFactory.fireEvent(new CopyCollectionEvent(collectionDo,getView().getCourseCodeId()));   
		getView().hide();
	}
	
	@Override
	public void copyDraggedCollection(String collectionTitle, String collectionId,String selectedFolderId) {   
		CollectionDo collectionDo = getView().getData();
		collectionDo.setSharing("anyonewithlink");
		collectionDo.setTitle(collectionTitle);
		collectionDo.setGooruOid(collectionId);
//		AppClientFactory.fireEvent(new CopyCollectionEvent(collectionDo,getView().getCourseCodeId()));   
		AppClientFactory.fireEvent(new CopyDraggedCollectionEvent(collectionDo,getView().getCourseCodeId(),selectedFolderId));   
		getView().hide();
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
	public void saveCollectionForSearch(String folderId, String o1, String o2,
			String o3, String resourceidonclick,String fromAddResource) {
		if(resourceidonclick!=null) {
			RESOURCE_ID_TO_ADD =resourceidonclick;
			IS_FROM_ADDRESOURCE=fromAddResource;
			
			getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(),new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					if(IS_FROM_ADDRESOURCE.equalsIgnoreCase("resourceidfromAddResourcePresenter")){
						Map<String,String> params1 = new HashMap<String,String>();
						params1.put("id", result.getGooruOid());
						//fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
						AppClientFactory.getInjector().getResourceService().createCollectionItem(result.getGooruOid(), RESOURCE_ID_TO_ADD, new SimpleAsyncCallback<CollectionItemDo>() {

							@Override
							public void onSuccess(CollectionItemDo result) {
								getView().hide();
							}
						});
						fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
						
						
					}	// TODO Auto-generated method stub
					
				}
			});
		//	getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
			
		}
		
	}
	
	
}
