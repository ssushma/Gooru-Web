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
package org.ednovo.gooru.client.mvp.folders.newfolder;

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
import org.ednovo.gooru.client.mvp.folders.newfolder.FolderFormViewPresenter.IsFolderPopUpFormProxy;
import org.ednovo.gooru.client.mvp.shelf.event.InsertFolderInShelfViewEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;
/**
 * @fileName : FolderFormViewPresenter.java
 *
 * @description : This is the presenter for the folder form view.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class FolderFormViewPresenter extends
		BasePlacePresenter<IsFoldersPopupView, IsFolderPopUpFormProxy>
		implements FoldersPopupUiHandlers {

	@Inject
	private FolderServiceAsync folderService;

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;

	private SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback;

	private String FOLDER_LEVEL_ONE = "1";
	
	private String FOLDER_LEVEL_TWO = "2";

	private String FOLDER_LEVEL_THREE = "3";

	@ProxyCodeSplit
	@NameToken(PlaceTokens.CREATEFOLDER)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsFolderPopUpFormProxy extends
			ProxyPlace<FolderFormViewPresenter> {
	}
	
	/**
	 * Class constructor
	 * @param view instance of {@link IsFoldersPopupView}
	 * @param proxy instance of {@link IsFolderPopUpFormProxy}
	 */

	@Inject
	public FolderFormViewPresenter(IsFoldersPopupView view,
			IsFolderPopUpFormProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}
	/**
	 * This method is used to get the view token.
	 */
	@Override
	public String getViewToken() {
		return PlaceTokens.CREATEFOLDER;
	}
	/**
	 * This method is used to create a new folder.
	 */
	@Override
	public void createFolder(CollectionDo collectionDo) {
		getFolderService().createFolder(collectionDo,
				getCollectionAsyncCallback());
	}
	/**
	 * This method is used to create a new folder on the parent node.
	 */
	@Override
	public void createFolderToParentFolder(CollectionDo collectionDo,
			String parentId) {
		getFolderService().createFolderToParentFolder(collectionDo, parentId,
				getCollectionAsyncCallback());		
	}

	// //Setters and Getters //
	/**
	 * This method is to get the classpageService
	 */
	public FolderServiceAsync getFolderService() {
		return folderService;
	}
	
	/**
	 * This method is to set the classpageService
	 * @param getFolderService instance of {@link FolderServiceAsync}
	 */
	public void setFolderService(FolderServiceAsync getFolderService) {
		this.folderService = getFolderService;
	}

	/**
	 * This method is to get the collectionAsyncCallback
	 * @return collectionAsyncCallback instance of {@link SimpleAsyncCallback<CollectionDo>} 
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/**
	 * This method is to set the collectionAsyncCallback
	 * @param collectionAsyncCallback instance of {@link SimpleAsyncCallback<CollectionDo>}
	 */
	public void setCollectionAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	/**
	 * This LifeCycle method is called when the binding the object. And it will set the folders data.
	 */
	@Override
	public void onBind() {
		super.onBind();
		setCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo collectionDo) {
				getView().closePopupPanel();
				Map<String, String> params = new HashMap<String, String>();
				String level = AppClientFactory.getPlaceManager().getRequestParameter("level");
				String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");

				if(level!=null||folderId!=null) {
					params.put("level", level);
					params.put("folderid", folderId);
					fireEvent(new RefreshCollectionInFolderLevelListEvent(collectionDo,
							RefreshFolderType.INSERT));
					
					if(level.equalsIgnoreCase(FOLDER_LEVEL_ONE)||level.equalsIgnoreCase(FOLDER_LEVEL_TWO)||level.equalsIgnoreCase(FOLDER_LEVEL_THREE)) {
						
						CollectionItemDo collectionItemDo = new CollectionItemDo();
						ResourceDo resourceDo = new ResourceDo();
						ResourceTypeDo resourceTypeDo = new ResourceTypeDo();
						resourceDo.setResourceType(resourceTypeDo);
						collectionItemDo.setResource(resourceDo);
						
						collectionItemDo.getResource().setTitle(collectionDo.getTitle());
						collectionItemDo.getResource().setGooruOid(collectionDo.getGooruOid());
						collectionItemDo.getResource().getResourceType().setName(collectionDo.getCollectionType());
						
						AppClientFactory.fireEvent(new InsertFolderInShelfViewEvent(
								collectionItemDo, RefreshType.INSERT, level));
					}
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.EDIT_FOLDERS, params);
				} else {
					fireEvent(new RefreshCollectionInShelfListEvent(collectionDo,
							RefreshType.INSERT));
					fireEvent(new RefreshCollectionInFolderListEvent(collectionDo,
							RefreshFolderType.INSERT));
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.FOLDERS);
				}
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
	 * This is where a presenter performs the operations required to become visible. The reason this is called revealIn Parent is due to the hierarchical nature of presenters.
	 */
	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(FolderFormViewPresenter.this, this);
	}

	/**
	 * 
	 * @return taxonomyService instance of {@link TaxonomyServiceAsync}
	 */
	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}

	/**
	 * 
	 * @param taxonomyService instance of {@link taxonomyService}
	 */
	
	public void setTaxonomyService(TaxonomyServiceAsync taxonomyService) {
		this.taxonomyService = taxonomyService;
	}

	/**
	 * 
	 * @return courseAsyncCallback instance of {@link LibraryCodeDo} as list
	 */
	public SimpleAsyncCallback<List<LibraryCodeDo>> getCourseAsyncCallback() {
		return courseAsyncCallback;
	}

	/**
	 * 
	 * @param courseAsyncCallback instance of {@link taxonomyService}
	 */
	public void setCourseAsyncCallback(
			SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback) {
		this.courseAsyncCallback = courseAsyncCallback;
	}

	/**
	 * Lifecycle method called whenever this presenter is about to be
	 * revealed.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		this.getTaxonomyService().getCourse(getCourseAsyncCallback());

	}

}
