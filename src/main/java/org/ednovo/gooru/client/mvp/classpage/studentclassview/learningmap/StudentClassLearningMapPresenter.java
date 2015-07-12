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
package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.UrlNavigationTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
 */
public class StudentClassLearningMapPresenter extends PresenterWidget<IsStudentClassLearningMapView> implements StudentClassLearningMapUiHandlers {
	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	
	private ClasspageDo classpageDo = null;
	
	@Inject
	public StudentClassLearningMapPresenter(EventBus eventBus, IsStudentClassLearningMapView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
		
	}

	@Override
	public void onReveal() {
		super.onReveal();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}
	
	@Override
	public void onReset() {
		setData();
	}
	
	public void setData() {
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		String classUId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_CLASS_ID, null);
		String classGooruOid = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, null);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, null);
		String lessonId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, null);
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			if(classGooruOid!=null) {
				AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classUId, classGooruOid, null, null, "plan", null, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
					@Override
					public void onSuccess(ArrayList<PlanProgressDo> dataList) {
						getView().setMetadataContent(dataList);
						getView().setContent(dataList);
					}
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			if(classGooruOid!=null) {
				AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classUId, classGooruOid, null, null, "plan", null, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
					@Override
					public void onSuccess(ArrayList<PlanProgressDo> dataList) {
						getView().setMetadataContent(dataList);
					}
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
			if(classGooruOid!=null&&unitId!=null) {
				AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classUId, classGooruOid, unitId, null, "plan", null, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
					@Override
					public void onSuccess(ArrayList<PlanProgressDo> dataList) {
						getView().setContent(dataList);
					}
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			if(classGooruOid!=null&&unitId!=null&&lessonId!=null) {
				AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classUId, classGooruOid, unitId, null, "plan", null, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
					@Override
					public void onSuccess(ArrayList<PlanProgressDo> dataList) {
						getView().setMetadataContent(dataList);
					}
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		}
	}
	
	@Override
	public void getLessonPlanData(String contentGooruIds) {
		String classUId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_CLASS_ID, null);
		String classGooruOid = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, null);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, null);
		String lessonId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, null);
		Map<String,String> queryParams = new HashMap<String,String>();
		queryParams.put("contentGooruIds", contentGooruIds);
		
		AppClientFactory.getInjector().getClasspageService().getStudentPlanProgressData(classUId, classGooruOid, unitId, lessonId, "plan", queryParams, new SimpleAsyncCallback<ArrayList<PlanProgressDo>>() {
			@Override
			public void onSuccess(ArrayList<PlanProgressDo> dataList) {
				getView().setContent(dataList);
			}
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	public ClasspageDo getClasspageDo() {
		return classpageDo;
	}

	public void setClasspageDo(ClasspageDo classpageDo) {
		this.classpageDo = classpageDo;
	}

}