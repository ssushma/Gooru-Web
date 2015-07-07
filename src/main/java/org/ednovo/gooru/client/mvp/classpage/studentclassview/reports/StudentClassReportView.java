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
package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports;

import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets.StudentClassLessonContainer;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets.SlnCourseReportView;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets.SlnUnitReportView;
import org.ednovo.gooru.client.uc.LoadingUc;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *  
 */
public class StudentClassReportView extends BaseViewWithHandlers<StudentClassReportUiHandlers> implements IsStudentClassReportView {
	
	@UiField LoadingUc cropImageLoading;
	@UiField SpanPanel textLbl, currentContentName, previousContentName, nextContentName;
	@UiField HTMLPanel topContainer, reportBodyBlock, learningMapContainer, headerLinksContainer;
	@UiField HTMLEventPanel previousContentPanel, currentContentPanel, nextContentPanel, allContentPanel;
	
	String allContentStr = null, previousContentStr = null, nextContentStr = null;
	
	private static final String ALL = "all";

	private static StudentClassReportViewUiBinder uiBinder = GWT
			.create(StudentClassReportViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface StudentClassReportViewUiBinder extends
			UiBinder<Widget, StudentClassReportView> {
	}

	public StudentClassReportView() {
		setWidget(uiBinder.createAndBindUi(this));
		cropImageLoading.setVisible(false);
		setDebugIds();
	}

	private void setDebugIds() {
		cropImageLoading.setLoadingText(i18n.GL1234());
		cropImageLoading.getElement().setId("loadingUcCropImageLoading");
	}
	
	@Override
	public void reset() {
		super.reset();
	}
	
	@Override
	public void setReportData() {
		headerLinksContainer.setVisible(false);
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		
		allContentStr = ALL;
		previousContentStr = "id";
		nextContentStr = "id1";
		
		setContentVisibility(false);
		reportBodyBlock.clear();
		
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			setNavLinksData("Your progress for this class", null, null, null);
			for(int i=0;i<4;i++) {
				reportBodyBlock.add(new SlnCourseReportView(i+1));
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			setNavLinksData("All Units", "Unit 2", "Unit 3: Number & Operations - Fractions", "Unit 4");
			for(int i=0;i<10;i++) {
				reportBodyBlock.add(new SlnUnitReportView(i+1));
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
				//reportBodyBlock.add(child);
		}
		setContentVisibility(true);
	}
	
	@UiHandler("allContentPanel")
	public void ClickAllContentPanel(ClickEvent event) {
		navigateToPage(allContentStr);
	}
	@UiHandler("previousContentPanel")
	public void ClickPreviousContentPanel(ClickEvent event) {
		navigateToPage(previousContentStr);
	}
	@UiHandler("nextContentPanel")
	public void ClickNextContentPanel(ClickEvent event) {
		navigateToPage(nextContentStr);
	}
	
	public void navigateToPage(String id) {
		Map<String,String> params = StringUtil.splitQuery(Window.Location.getHref());
		
		String uId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
		String lId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
		String pageView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT);
		
		if(id.equalsIgnoreCase(ALL)) {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
			} else if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
			}
		} else {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
				if(uId!=null&&!uId.isEmpty()) {
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, id);
				}
			} else if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
				if(lId!=null&&!lId.isEmpty()) {
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, id);
				}
			}
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW, params);
	}
	
	private void setNavLinksData(String allTxt, String previousLinkTxt, String currentLinkTxt, String nextLinkTxt) {
		textLbl.setText(allTxt);
		previousContentName.setText(previousLinkTxt);
		currentContentName.setText(currentLinkTxt);
		nextContentName.setText(nextLinkTxt);
	}

	private void setContentVisibility(boolean isVisible) {
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		cropImageLoading.setVisible(!isVisible);
		topContainer.setVisible(isVisible);
		learningMapContainer.setVisible(isVisible);
		if(!pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			headerLinksContainer.setVisible(isVisible);
		}
	}
}