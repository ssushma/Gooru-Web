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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * 
 * @fileName : CollectionAssignTabPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jul 30, 2013
 *
 * @Author ramadevikrishnan
 *
 * @Reviewer:
 */
public class CollectionAssignTabPresenter extends PresenterWidget<IsCollectionAssignTab> implements CollectionAssignTabUiHandlers {

	
	@Inject
	private ClasspageServiceAsync classpageService;
	
	private SimpleAsyncCallback<ClasspageListDo> getClasspageList;
	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;
	
	CollectionDo collectionDo=null;
	
	String shareType=null;
	
	String limit="10";//pagesize
	
	int classpageOffSet=0;
	int assignmentOffSet=0;
	
	boolean isApiCalling=false;
	
	String classpageId=null;
	
	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public CollectionAssignTabPresenter(EventBus eventBus, IsCollectionAssignTab view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
		setGetClasspageList(new SimpleAsyncCallback<ClasspageListDo>() {

			@Override
			public void onSuccess(ClasspageListDo result) {
				if(shareType != null)
				{
				getView().setPrivateLableVisibility(shareType.equalsIgnoreCase("private") ? true : false);
				}
				getView().setClasspageData(result);
			}
		});
		

		
	}

	@Override
	public void onReveal() {
		super.onReveal();

		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.ORGANIZE));
		
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		getView().setToClear(true);
		
		getView().setToClear(true);
		isApiCalling = false;
		getClasspage(collectionDo, null,null);
	}
	
	public void getClasspage(CollectionDo collectionDo, String shareType,ScrollPanel spanel){
		this.shareType = shareType;
		this.collectionDo = collectionDo;
		getView().setCollectionDo(collectionDo);
		
		getView().closeCalendar(spanel);
		
		if (!isApiCalling){			//This condition is added because, this method is called thrice from shelf
			classpageOffSet = 0;
			isApiCalling = true;
			/**
			 * getting available classpages of the user
			 */
			getAllClasspages(limit, String.valueOf(classpageOffSet));
			
			
			getView().hideContainers();
		}
	}
	
	
	@Override
	protected void onReset() {
		super.onReset();
//		getView().clearPanels();
//		isApiCalling = false;
//		getClasspage(collectionDo);
	}
	
	@Override
	protected void onUnbind() {
		isApiCalling = false;
		getView().onUnload();
	}
	
	@Override
	protected void onHide() {
		super.onHide();
		isApiCalling = false;
		getView().onUnload();
	}
	
	/**
	 * 
	 * @function getAllClasspages 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param limit
	 * @parm(s) : @param offSet
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@Override
	public void getAllClasspages(String limit, String offSet) {
		getClasspageService().v2GetAllClasspages(limit, offSet, getGetClasspageList());
	}
	
	@Override
	public void getNextClasspages() {
		classpageOffSet = classpageOffSet+10;
		getAllClasspages(limit,String.valueOf(classpageOffSet));
	}
	
	
	////Setters and Getters //	
	/** 
	 * This method is to get the classpageService
	 */
	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}

	/** 
	 * This method is to set the classpageService
	 */
	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}

	/** 
	 * This method is to get the getClasspageList
	 */
	public SimpleAsyncCallback<ClasspageListDo> getGetClasspageList() {
		return getClasspageList;
	}

	/** 
	 * This method is to set the getClasspageList
	 */
	public void setGetClasspageList(SimpleAsyncCallback<ClasspageListDo> getClasspageList) {
		this.getClasspageList = getClasspageList;
	}

	@Override
	public void getAssignmentsByClasspageId(String classpageId,String pageSize, String pageNum) {
		this.classpageId = classpageId;
		getClasspageService().v2GetAssignemtsByClasspageId(classpageId,pageSize,pageNum, getAssignmentsListAsyncCallback());
	}

	/** 
	 * This method is to get the assignmentsListAsyncCallback
	 */
	public SimpleAsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentsListAsyncCallback
	 */
	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}

	@Override
	public void getNextAssignments() {
		if (classpageId!=null){
			assignmentOffSet = assignmentOffSet+10;
			getAssignmentsByClasspageId(classpageId, limit, String.valueOf(assignmentOffSet));
		}
	}
	
	/** 
	 * This method is to get the assignmentOffSet
	 */
	public int getAssignmentOffSet() {
		return assignmentOffSet;
	}

	/** 
	 * This method is to set the assignmentOffSet
	 */
	@Override
	public void setAssignmentOffSet(int assignmentOffSet) {
		this.assignmentOffSet = assignmentOffSet;
	}
	/** 
	 * This method is to get the shareType
	 */
	public String getShareType() {
		return shareType;
	}

	/** 
	 * This method is to set the shareType
	 */
	@Override
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}	

}
