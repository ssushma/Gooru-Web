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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.course.TeachCourseReportChildView;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.lesson.TeachLessonReportChildView;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.unit.TeachUnitReportChildView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class TeachStudentDashboardView extends BaseViewWithHandlers<TeachStudentDashboardUiHandler> implements IsTeachStudentDashboardView{

	@UiField HTMLPanel bodyView;
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	private static TeachStudentDashboardViewUiBinder uiBinder = GWT.create(TeachStudentDashboardViewUiBinder.class);

	interface TeachStudentDashboardViewUiBinder extends	UiBinder<Widget, TeachStudentDashboardView> {
	}

	public TeachStudentDashboardView() {
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setReportView() {
		bodyView.clear();
		String reportView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		if(reportView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			bodyView.add(new TeachCourseReportChildView(null));
		} else if(reportView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			bodyView.add(new TeachUnitReportChildView());
		} else if(reportView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			bodyView.add(new TeachLessonReportChildView());
		}
	}
	
}
