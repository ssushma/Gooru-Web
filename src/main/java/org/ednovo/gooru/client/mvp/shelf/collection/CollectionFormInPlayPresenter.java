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

import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPlayEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPreviewPlayEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInResourcePlayEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.service.ShelfServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class CollectionFormInPlayPresenter extends PresenterWidget<IsCollectionFormInPlayView> implements CollectionFormInPlayUiHandlers {

	@Inject
	private ShelfServiceAsync shelfService;

	@Inject
	private ResourceServiceAsync resourceService;

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;

	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;

	private SimpleAsyncCallback<List<LibraryCodeDo>> courseAsyncCallback;

	private String resourceOid;
	
	private String playerType=null;

	public String getResourceUid() {
		return resourceOid;
	}
	
	public String setPlayerType(String playerType){
		return playerType;
	}

	public void setResourceUid(String resourceUid) {
		this.resourceOid = resourceUid;
	}

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CollectionFormInPlayPresenter( EventBus eventBus,IsCollectionFormInPlayView view) {
		super(eventBus,view);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
		
		setSaveCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().hide();
				getView().reset();
				fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
				playerType=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
				if(playerType.equalsIgnoreCase(PlaceTokens.COLLECTION_PLAY)){
					fireEvent(new RefreshCollectionInShelfListInPlayEvent(result.getGooruOid()));
					fireEvent(new RefreshDisclosurePanelEvent(result.getGooruOid()));
				}else if(playerType.equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
					fireEvent(new RefreshCollectionInShelfListInPreviewPlayEvent(result.getGooruOid()));
				}else if(playerType.equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
					fireEvent(new RefreshCollectionInShelfListInResourcePlayEvent(result.getGooruOid()));
					fireEvent(new RefreshDisclosurePanelEvent(result.getGooruOid()));
				}else if(playerType.equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
					fireEvent(new RefreshDisclosurePanelEvent(result.getGooruOid()));
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
				//getView().reset();
				getView().setLibraryCodes(result);
			}
		});
	}

	@Override
	public void saveCollection() {
		CollectionDo collection = getView().getData();
		if (collection.getGooruOid() == null) {
			if (resourceOid == null) {
				getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
			} else {
				getResourceService().createCollectionWithItem(collection, getView().getCourseCodeId(), resourceOid, getSaveCollectionAsyncCallback());
			}
		} else {
			getResourceService().copyCollection(collection, "true", getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
		}
	}
	
	public void getCourse(){
	//	this.getTaxonomyService().getCourse(getCourseAsyncCallback());
	}

	@Override
	protected void onReveal(){
		this.getTaxonomyService().getCourse(getCourseAsyncCallback());
		if(!(AppClientFactory.isAnonymous())){
			getView().getAccountTypeId();
		}
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

}
