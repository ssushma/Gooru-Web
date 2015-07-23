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
package org.ednovo.gooru.client.mvp.classpage.teach.reports;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.UrlNavigationTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


public class TeachStudentDashboardPresenter extends PresenterWidget<IsTeachStudentDashboardView> implements TeachStudentDashboardUiHandler{
	
	
	@Inject
	public TeachStudentDashboardPresenter(EventBus eventBus,IsTeachStudentDashboardView view){
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void onReveal() {
		
	}

	@Override
	protected void onHide() {
		super.onHide();
	}
	
	@Override
	public void onReset() {
		String classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,null);
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID,null);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID,null);
		String assessmentId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID,null);
		if(courseId!=null&&unitId!=null&&assessmentId==null) {
			AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classId, courseId, null, null, "plan", null, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
				@Override
				public void onSuccess(ArrayList<PlanProgressDo> dataList) {
					getView().setMetadataContent(dataList);
					getView().setReportView();
				}
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		} else {
			getView().setReportView();
		}
	}
	
	public void  loadNavigationPage(){
		
	}

	public void setClassDetails(ClasspageDo classpageDo) {
		
	}
}