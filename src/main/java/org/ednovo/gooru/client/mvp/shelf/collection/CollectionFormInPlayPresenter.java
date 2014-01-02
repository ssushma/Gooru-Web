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

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPlayEvent;
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
 * 
 * @fileName : CollectionFormInPlayPresenter.java
 *
 * @description : This is the presenter class for CollectionFormInPlayView.java
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

	private String resourceUid;

	public String getResourceUid() {
		return resourceUid;
	}

	public void setResourceUid(String resourceUid) {
		this.resourceUid = resourceUid;
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
				getView().reset();
				fireEvent(new RefreshCollectionInShelfListEvent(result, RefreshType.INSERT));
				fireEvent(new RefreshCollectionInShelfListInPlayEvent(result.getGooruOid()));
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
	/**
	 * This is used save the collection.
	 */
	@Override
	public void saveCollection() {
		CollectionDo collection = getView().getData();
		if (collection.getGooruOid() == null) {
			if (resourceUid == null) {
				getResourceService().createCollection(getView().getData(), getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
			} else {
				getResourceService().createCollectionWithItem(collection, getView().getCourseCodeId(), resourceUid, getSaveCollectionAsyncCallback());
			}
		} else {
			getResourceService().copyCollection(collection, "true", getView().getCourseCodeId(), getSaveCollectionAsyncCallback());
		}
	}
	/**
	 * This is used to get the course.
	 */
	public void getCourse(){
	//	this.getTaxonomyService().getCourse(getCourseAsyncCallback());
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	protected void onReveal(){
		this.getTaxonomyService().getCourse(getCourseAsyncCallback());
		getView().getAccountTypeId();
	}
	/**
	 * 
	 * @function getShelfService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns shelfService.
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
	 * @description : returns resourceService.
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
	 * @description :This is used to initialize resourceService
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
	 * @description :returns taxonomyService
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
	 * @description :This is used to set taxonomyService
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
	 * @description :returns saveCollectionAsyncCallback.
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
	 * @description : This is used to set saveCollectionAsyncCallback
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
	 * @description : returns collectionAsyncCallback.
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
	 * @description : This is used to initialize collectionAsyncCallback.
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
	 * @description :returns courseAsyncCallback
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
	 * @description :This is used to set courseAsyncCallback.
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

}
