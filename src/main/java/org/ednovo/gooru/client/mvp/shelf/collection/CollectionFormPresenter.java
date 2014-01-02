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
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.service.ShelfServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

/**
 * 
 * @fileName : CollectionFormPresenter.java
 *
 * @description : This is the presenter class for CollectionFormView.java
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
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
	/**
	 * This method is called when the presenter is instantiated.
	 */
	@Override
	public void onBind() {
		super.onBind();
		setSaveCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().hide();

				Map<String, String> params = new HashMap<String, String>();
				String level = AppClientFactory.getPlaceManager().getRequestParameter("level");
				String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
				String previousNameToken = AppClientFactory.getPlaceManager().getPreviousRequest().getNameToken();

				if(previousNameToken.equalsIgnoreCase(PlaceTokens.EDIT_FOLDERS)||previousNameToken.equalsIgnoreCase(PlaceTokens.FOLDERS)) {
					if(level!=null||folderId!=null) {
						params.put("level", level);
						params.put("folderid", folderId);
						fireEvent(new RefreshCollectionInFolderLevelListEvent(result,
								RefreshFolderType.INSERT));
						
						if(level.equalsIgnoreCase(FOLDER_LEVEL_ONE)||level.equalsIgnoreCase(FOLDER_LEVEL_TWO)||level.equalsIgnoreCase(FOLDER_LEVEL_THREE)) {
							
							CollectionItemDo collectionItemDo = new CollectionItemDo();
							ResourceDo resourceDo = new ResourceDo();
							ResourceTypeDo resourceTypeDo = new ResourceTypeDo();
							resourceDo.setResourceType(resourceTypeDo);
							collectionItemDo.setResource(resourceDo);
							
							collectionItemDo.getResource().setTitle(result.getTitle());
							collectionItemDo.getResource().setGooruOid(result.getGooruOid());
							collectionItemDo.getResource().getResourceType().setName(result.getCollectionType());
							
							AppClientFactory.fireEvent(new InsertFolderInShelfViewEvent(
									collectionItemDo, RefreshType.INSERT, level));
						}
						AppClientFactory.getPlaceManager().revealPlace(
								PlaceTokens.EDIT_FOLDERS, params);
					} else {
						fireEvent(new RefreshCollectionInShelfListEvent(result,
								RefreshType.INSERT));
						fireEvent(new RefreshCollectionInFolderListEvent(result,
								RefreshFolderType.INSERT));
						AppClientFactory.getPlaceManager().revealPlace(
								PlaceTokens.FOLDERS);
					}
				} else {
					String nameToken = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
					if(nameToken.equals(PlaceTokens.SHELF)) {
						fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT_AND_VIEW));
					} else {
						fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
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
	/**
	 * This method is used to save the collection data.
	 */
	@Override
	public void saveCollection(String folderId) {
		CollectionDo collection = getView().getData();
		if (collection.getGooruOid() == null) {
			if (resourceUid == null) {
				if(folderId==null) {
					getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
				} else {
					getResourceService().createCollectionInParent(getView().getData(), getView().getCourseCodeId(), folderId, getSaveCollectionAsyncCallback());
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
	/**
	 *  This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		this.getTaxonomyService().getCourse(getCourseAsyncCallback());
		getView().getAccountTypeId();
	}
	/**
	 * This method is called whenever the user navigates to a page that shows the presenter, whether it was visible or not.
	 */
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
	/**
	 * This method is used to hide the popup's
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().closeAllopenedPopUp();
	}
	/**
	 * This is used to fire RevealRootPopupContentEvent
	 */
	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}
	/**
	 * 
	 * @function getShelfService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns shelfService
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : ShelfServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public ShelfServiceAsync getShelfService() {
		return shelfService;
	}
	/**
	 * 
	 * @function getResourceService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns resourceService
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : ResourceServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}
	/**
	 * 
	 * @function setResourceService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : To set resourceService
	 * 
	 * 
	 * @parm(s) : @param resourceService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}
	/**
	 * 
	 * @function getTaxonomyService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns taxonomyService
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : TaxonomyServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}
	/**
	 * 
	 * @function setTaxonomyService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : To set taxonomyService
	 * 
	 * 
	 * @parm(s) : @param taxonomyService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setTaxonomyService(TaxonomyServiceAsync taxonomyService) {
		this.taxonomyService = taxonomyService;
	}
	/**
	 * 
	 * @function getSaveCollectionAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns saveCollectionAsyncCallback
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<CollectionDo> getSaveCollectionAsyncCallback() {
		return saveCollectionAsyncCallback;
	}
	/**
	 * 
	 * @function setSaveCollectionAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : To set saveCollectionAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param saveCollectionAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setSaveCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback) {
		this.saveCollectionAsyncCallback = saveCollectionAsyncCallback;
	}
	/**
	 * 
	 * @function getCollectionAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns collectionAsyncCallback
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}
	/**
	 * 
	 * @function setCollectionAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : To set collectionAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param collectionAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	/**
	 * 
	 * @function getCourseAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns courseAsyncCallback
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<List<LibraryCodeDo>>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<List<LibraryCodeDo>> getCourseAsyncCallback() {
		return courseAsyncCallback;
	}
	/**
	 * 
	 * @function setCourseAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns courseAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param courseAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCourseAsyncCallback(SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback) {
		this.courseAsyncCallback = courseAsyncCallback;
	}
	/**
	 * To get the place token
	 */
	@Override
	public String getViewToken() {
		return PlaceTokens.COLLECTION;
	}
	
}
