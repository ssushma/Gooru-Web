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
package org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;



/**
 * 
 * @fileName : PersonalizeUnitPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 09-Sep-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class PersonalizeUnitPresenter extends
		PresenterWidget<IsPersonalizeUnitView> implements
		PersonalizeUnitUiHandlers {

	@Inject
	private ClasspageServiceAsync classpageService;
	
	private SimpleAsyncCallback<StudentsAssociatedListDo> studentAssociatedListDo = null;

	private ClasspageDo classpageDo = null;

	private int offSet=0;

	private int limit=5; 
	
	
	@Inject
	public PersonalizeUnitPresenter(EventBus eventBus,
			IsPersonalizeUnitView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		
		setStudentAssociatedListDo(new SimpleAsyncCallback<StudentsAssociatedListDo>() {

			@Override
			public void onSuccess(StudentsAssociatedListDo result) {
				getView().displayAssignmentsGoals(result);
				getView().displayPagination(result, offSet, limit);
			}
		});
		
	}


	/** 
	 * This method is to get the studentAssociatedListDo
	 */
	public SimpleAsyncCallback<StudentsAssociatedListDo> getStudentAssociatedListDo() {
		return studentAssociatedListDo;
	}


	/** 
	 * This method is to set the studentAssociatedListDo
	 */
	public void setStudentAssociatedListDo(SimpleAsyncCallback<StudentsAssociatedListDo> studentAssociatedListDo) {
		this.studentAssociatedListDo = studentAssociatedListDo;
	}

	@Override
	public void getStudentsList(int offSet, int limit, String type, String classCode){
		System.out.println("getStudentsList offSet : "+offSet);
//		this.offSet = offSet;
		if (classCode == null){
			classCode = this.classpageDo.getClasspageCode();
		}	
		if (limit==0){
			limit = this.limit; 
		}
		getClasspageService().getActiveAssociatedStudentListByCode(classCode, offSet, limit, type, getStudentAssociatedListDo());		
	}
	@Override
	public void getList(){
		System.out.println("getList .... ");
		getStudentsList(offSet, limit, "active", classpageDo.getClasspageCode());
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
	public void setClasspageData(ClasspageDo classpageDo){
		this.classpageDo = classpageDo;
		System.out.println("setClasspageData .... ");
		getList();
	}


	/** 
	 * This method is to get the classpageDo
	 */
	@Override
	public ClasspageDo getClasspageDo() {
		return classpageDo;
	}


	/** 
	 * This method is to set the classpageDo
	 */
	public void setClasspageDo(ClasspageDo classpageDo) {
		this.classpageDo = classpageDo;
	}
}
