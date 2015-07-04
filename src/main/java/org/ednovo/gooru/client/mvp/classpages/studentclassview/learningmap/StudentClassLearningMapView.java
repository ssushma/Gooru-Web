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
package org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap;

import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.assessmentchild.SlmAssessmentChildView;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.widgets.StudentClassLearningMapContainer;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.widgets.StudentClassLessonContainer;
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
public class StudentClassLearningMapView extends BaseViewWithHandlers<StudentClassLearningMapUiHandlers> implements IsStudentClassLearningMapView {

	@UiField HTMLPanel containerData, learningMapContainer, headerLinksContainer, topBackLinkBox, standardsBlock;
	@UiField SpanPanel allContentTxt, currentContentName, previousContentName, nextContentName, spanTxt;
	@UiField HTMLEventPanel allContentPanel, previousContentPanel, nextContentPanel;
	
	@UiField LoadingUc cropImageLoading;
	
	String allContentStr = null, previousContentStr = null, nextContentStr = null;
	
	private static StudentClassLearningMapViewUiBinder uiBinder = GWT
			.create(StudentClassLearningMapViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface StudentClassLearningMapViewUiBinder extends
			UiBinder<Widget, StudentClassLearningMapView> {
	}
	
	public StudentClassLearningMapView() {
		setWidget(uiBinder.createAndBindUi(this));
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
	
	public void getContentData() {
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
		spanTxt.setText("NS");
		learningMapContainer.clear();
		
		allContentStr = "all";
		previousContentStr = "id";
		nextContentStr = "id1";
		
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			allContentTxt.setText("You have 7 Units to complete");
			headerLinksContainer.setVisible(false);
			topBackLinkBox.setVisible(false);
			standardsBlock.setVisible(false);
			for(int i=0;i<10;i++) {
				learningMapContainer.add(new StudentClassLearningMapContainer());
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			allContentTxt.setText("All Units");
			previousContentName.setText("Unit 2");
			currentContentName.setText("Number & Operations - Fractions");
			nextContentName.setText("Unit 4");
			headerLinksContainer.setVisible(true);
			topBackLinkBox.setVisible(true);
			standardsBlock.setVisible(false);
			for(int i=0;i<10;i++) {
				learningMapContainer.add(new StudentClassLessonContainer("green-circle"));
			}
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_CONTENT_VIEW)) {
			allContentTxt.setText("All Lessons");
			previousContentName.setText("Lesson 2");
			currentContentName.setText("Fractions and whole numbers");
			nextContentName.setText("Lesson 4");
			headerLinksContainer.setVisible(true);
			topBackLinkBox.setVisible(true);
			standardsBlock.setVisible(true);
			for(int i=0;i<4;i++) {
				learningMapContainer.add(new SlmAssessmentChildView());
			}
		}
		setContentVisiblity(true);
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
	
	@Override
	public void setContent() {
		setContentVisiblity(false);
		getContentData();
	}
	
	public void navigateToPage(String id) {
		Map<String,String> params = StringUtil.splitQuery(Window.Location.getHref());
		
		String uId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
		String lId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
		String pageView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT);
		
		if(id.equalsIgnoreCase("all")) {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
			} else if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_CONTENT_VIEW)) {
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
			}
		} else {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
				if(uId!=null&&!uId.isEmpty()) {
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, id);
				}
			} else if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_CONTENT_VIEW)) {
				if(lId!=null&&!lId.isEmpty()) {
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, id);
				}
			}
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW, params);
	}
	
	private void setContentVisiblity(boolean isVisible) {
		containerData.setVisible(isVisible);
		cropImageLoading.setVisible(!isVisible);
	}
}