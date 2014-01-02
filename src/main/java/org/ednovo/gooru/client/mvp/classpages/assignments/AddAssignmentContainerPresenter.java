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
package org.ednovo.gooru.client.mvp.classpages.assignments;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshAssignmentsListEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

/**
 * 
 * @fileName : AddAssignmentContainerPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddAssignmentContainerPresenter extends PresenterWidget<IsAddAssignmentContainerView> implements AddAssignmentContainerUiHandlers{
	
	private String classpageId="";
	
	private SimpleAsyncCallback<CollectionDo> assignmentAsyncCallback;
	
	private SimpleAsyncCallback<AssignmentDo> assignmentV2AsyncCallback;
	
	IsCollectionResourceTabView isCollResourceTabView=null;
	
	CollectionDo collectionDo;
	
	@Inject
	private ClasspageServiceAsync classpageService;
	/**
	 * Constructor
	 * @param isCollResourceTabView
	 * @param eventBus
	 * @param view
	 */
	@Inject
	public AddAssignmentContainerPresenter(IsCollectionResourceTabView isCollResourceTabView, EventBus eventBus, IsAddAssignmentContainerView view) {
		super(eventBus, view);
		
		getView().setUiHandlers(this);		
		this.isCollResourceTabView = isCollResourceTabView;
	}
	/**
	 * This is called when the presenter is instantiated.
	 */
	@Override
	protected void onBind() {
		super.onBind();
		setAssignmentAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				//Set the Assignment to classpage
				if (result.getTitle() != null) {
					AppClientFactory.fireEvent(new RefreshAssignmentsListEvent(false));
					getView().resetAllFields();

					Window.enableScrolling(true);
			        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

					getView().hide();
				} else {
					getView().resetClicked();
					new AlertContentUc("Oops!",	"Looks like you've selected a date that's already past! Do your students a favor and choose a date in the future.");
				}
			}
		});
		/** 
		 * This method is to set the assignmentAsyncCallback
		 */
		setAssignmentV2AsyncCallback(new SimpleAsyncCallback<AssignmentDo>() {

			@Override
			public void onSuccess(AssignmentDo result) {
				AppClientFactory.fireEvent(new RefreshAssignmentsListEvent(false));
				getView().resetAllFields();

				Window.enableScrolling(true);
		        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

				getView().hide();
				
			}
		});
	}
	
	/*Setter and getters */
	/** 
	 * This method is to get the classpageId
	 */
	public String getClasspageId() {
		return classpageId;
	}

	/** 
	 * This method is to set the classpageId
	 */
	public void setClasspageId(String classpageId) {
		getView().setClasspageId(classpageId);
		this.classpageId = classpageId;
	}
	/** 
	 * This method is to get the assignmentAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getAssignmentAsyncCallback() {
		return assignmentAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentAsyncCallback
	 */
	public void setAssignmentAsyncCallback(
			SimpleAsyncCallback<CollectionDo> assignmentAsyncCallback) {
		this.assignmentAsyncCallback = assignmentAsyncCallback;
	}
	
	/**
	 * This method is used to create assignment.
	 */
	
	@Override
	public void createAssignment(CollectionDo collectionDo, String dueDate) {
		getClasspageService().createAssignment(collectionDo, getClasspageId(), dueDate, getAssignmentAsyncCallback());
	}
	
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
	
	@Override
	public void v2CreateAssignment(AssignmentDo assignmentDo) {
		getClasspageService().v2CreateAssignment(assignmentDo, getAssignmentV2AsyncCallback());
	}

	/** 
	 * This method is to get the assignmentV2AsyncCallback
	 */
	public SimpleAsyncCallback<AssignmentDo> getAssignmentV2AsyncCallback() {
		return assignmentV2AsyncCallback;
	}

	/** 
	 * This method is to set the assignmentV2AsyncCallback
	 */
	public void setAssignmentV2AsyncCallback(
			SimpleAsyncCallback<AssignmentDo> assignmentV2AsyncCallback) {
		this.assignmentV2AsyncCallback = assignmentV2AsyncCallback;
	}
	
}
