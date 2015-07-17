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
package org.ednovo.gooru.client.mvp.classpage.teach.edit.content;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.EditClassSettingsPresenter;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.coursePopup.AddCourseToClassPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


/**
 * @fileName : EditClassSettingsNavigationPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 06-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassSettingsNavigationPresenter extends PresenterWidget<IsEditClassSettingsNavigationView> implements EditClassSettingsNavigationUiHandler{
	
	
	EditClassSettingsPresenter editClassSettingsPresenter;
	
	EditClassContentPresenter editClassContentPresenter;
	
	ClasspageDo classpageDo;
	
	AddCourseToClassPresenter addCourseToClassPresenter;
	
	@Inject
	public EditClassSettingsNavigationPresenter(EventBus eventBus,IsEditClassSettingsNavigationView view,EditClassSettingsPresenter editClassSettingsPresenter,EditClassContentPresenter editClassContentPresenter,AddCourseToClassPresenter addCourseToClassPresenter){
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.editClassSettingsPresenter=editClassSettingsPresenter;
		this.editClassContentPresenter=editClassContentPresenter;
		this.addCourseToClassPresenter=addCourseToClassPresenter;
	}
	
	@Override
	public void onBind() {
		super.onBind();
		//getCourseData();
		
	}

	@Override
	public void onReveal() {
		getCourseData();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}
	
	@Override
	protected void onReset() {
		loadNavigationPage();
		getView().setActiveStyles();
	}
	
	public void  loadNavigationPage(){
		String subPage = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW,"");
		clearSlot(CLASS_CONETENT_TAB);
		clearSlot(CLASS_SETTINGS_TAB);
		if(subPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_SETTINGS_INFO)) {
			addToSlot(CLASS_SETTINGS_TAB, editClassSettingsPresenter);
		} else if(subPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE) || subPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS)) {
			addToSlot(CLASS_CONETENT_TAB, editClassContentPresenter);
		}
		
	}

	public void setClassDetails(ClasspageDo classpageDo) {
		this.classpageDo=classpageDo;
		editClassSettingsPresenter.setClassData(classpageDo);
		editClassContentPresenter.setClassData(classpageDo);
	}
	
	public void getCourseData(){
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID);
		if(courseId != null && !courseId.isEmpty()){
			AppClientFactory.getInjector().getResourceService().getCourseDataById(courseId, new AsyncCallback<FolderDo>() {
				
				@Override
				public void onSuccess(FolderDo result) {
					getView().setCourseData(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		}else{
			getView().setAddCourseData();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.EditClassSettingsNavigationUiHandler#addCourseToClass()
	 */
	@Override
	public void addCourseToClass() {
		addCourseToClassPresenter.getUserShelfCourseData("", "class");
		addCourseToClassPresenter.getView().getAppPopUp().show();
		addCourseToClassPresenter.getView().getAppPopUp().center();
		addCourseToClassPresenter.getView().getAppPopUp().setGlassEnabled(true);
	}
	
}
