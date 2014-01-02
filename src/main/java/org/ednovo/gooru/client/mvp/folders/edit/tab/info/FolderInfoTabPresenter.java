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
package org.ednovo.gooru.client.mvp.folders.edit.tab.info;

import java.util.List;

import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.SearchServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
/**
 * @fileName : FolderInfoTabPresenter.java
 *
 * @description : This class is used to display the folder info tab.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class FolderInfoTabPresenter extends PresenterWidget<IsFolderInfoTabView> implements FolderInfoTabUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;
	
	@Inject
	private SearchServiceAsync searchService;
	
	@Inject
	private FolderServiceAsync folderService;
	
	private SimpleAsyncCallback<CollectionDo> folderInfoAsyncCallback;

	private boolean isCourseSet = false;

	private SearchAsyncCallback<SearchDo<CodeDo>> standardSuggestionAsyncCallback;

	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public FolderInfoTabPresenter(EventBus eventBus, IsFolderInfoTabView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	/**
	 * This LifeCycle method is called when the binding the object. And it will set the folder meta data and collection data.
	 */
	@Override
	public void onBind() {
		super.onBind();
		setFolderInformationAsyncCallBack(new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo collectionDo) {
				getView().setParentData(collectionDo);
			}
		});
	}
	/**
	 * Lifecycle method called whenever this presenter is about to be
	 * revealed.
	 */
	@Override
	public void onReveal() {
		
		super.onReveal();
		getView().onLoad();
		getView().reset();
		setParentCollectionData();
		if (!isCourseSet) {
			getTaxonomyService().getCourse(new SimpleAsyncCallback<List<LibraryCodeDo>>() {

				@Override
				public void onSuccess(List<LibraryCodeDo> result) {
					getView().setCourseList(result);
					isCourseSet = true;
				}
			});
		}
	}
	/**
	 * Lifecycle method called on all visible presenters whenever a
	 * presenter is revealed anywhere in the presenter hierarchy.
	 */
	@Override
	protected void onReset() {
		// TODO Auto-generated method stub
		super.onReset();
		setParentCollectionData();
	}
	/**
	 * This method is used to hide.
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
	}
	/**
	 * @function setParentCollectionData 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to set the data for collection data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setParentCollectionData(){
		String parentid = AppClientFactory.getPlaceManager().getRequestParameter("parentid");
		if(parentid!=null) {
			getFolderService().getFolderInformation(parentid, getFolderInformationAsyncCallBack());
		}
	}
	
	//// Setters and Getters //
	/** 
	 * This method is to get the folderService
	 */
	public FolderServiceAsync getFolderService() {
		return folderService;
	}

	/** 
	 * This method is to set the folderService
	 */
	public void setFolderService(FolderServiceAsync folderService) {
		this.folderService = folderService;
	}
	
	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getFolderInformationAsyncCallBack() {
		return folderInfoAsyncCallback; 
	}
	
	/** 
	 * This method is to set the folderInformationAsyncCallBack
	 */
	public void setFolderInformationAsyncCallBack(	SimpleAsyncCallback<CollectionDo> folderInfoAsyncCallback) {
		this.folderInfoAsyncCallback = folderInfoAsyncCallback;
	}

	
	
	/**
	 * @return suggestion standards for the collection as map string
	 */
	public SearchAsyncCallback<SearchDo<CodeDo>> getStandardSuggestionAsyncCallback() {
		if (standardSuggestionAsyncCallback == null) {
			standardSuggestionAsyncCallback = new SearchAsyncCallback<SearchDo<CodeDo>>() {

				@Override
				protected void run(SearchDo<CodeDo> searchDo) { 
					AppClientFactory.getInjector().getSearchService().getSuggestStandard(searchDo, this);
				}

				@Override
				public void onCallSuccess(SearchDo<CodeDo> result) {
					getView().setStandardSuggestions(result);
				}
			};
		}
		return standardSuggestionAsyncCallback;
	}
	/**
	 * This method is used to request standards and suggestions.
	 */
	@Override
	public void requestStandardsSuggestion(SearchDo<CodeDo> searchDo) {

		getStandardSuggestionAsyncCallback().execute(searchDo);
	}

	
	/**
	 * @function getTaxonomyService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to get the taxonomy service.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : TaxonomyServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}
	/**
	 * This method is used to update course.
	 */
	@Override
	public void updateCourse(String collectionId, String courseCode, String action) {

		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, courseCode, null, null, action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().onPostCourseUpdate(result);	
			}
			
		});
	}
	/**
	 * This method is used to update standards.
	 */
	@Override
	public void updateStandard(String collectionId, String taxonomyCodeId, String action) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, taxonomyCodeId, "false", null, action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().onPostStandardUpdate(result);
			}
		});
		
	}
	/**
	 * @function getSearchService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to get the search serivce.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SearchServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public SearchServiceAsync getSearchService() {
		return searchService;
	}
	/**
	 * @function setSearchService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to set the search service.
	 * 
	 * @parm(s) : @param searchService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setSearchService(SearchServiceAsync searchService) {
		this.searchService = searchService;
	}
}
