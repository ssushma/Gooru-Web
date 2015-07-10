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
package org.ednovo.gooru.client.mvp.classpage.studentclassview;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.EmPanel;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
/**
 * 
 * @fileName : StudentClassView.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 19-Jun-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class StudentClassView extends BaseViewWithHandlers<StudentClassUiHandlers> implements IsStudentClassView ,ClickHandler{
	
	@UiField SpanPanel classCodeSpan, studentMessage;
	@UiField EmPanel teacherOwnership;
	@UiField H2Panel courseName;
	@UiField SimplePanel learningMapContainer;
	@UiField Image classImage, teacherImage, studentImage;
	@UiField SimpleCheckBox switchCheckBox;
	@UiField HTMLPanel editClassMetadataPanel, previewClassMetadataPanel;
	@UiField Button joinClassBtn, teachViewBtn;
	@UiField Label studentViewLbl;
	
	private static final String DEFAULT_CLASSPAGE_IMAGE = "../images/Classpage/default-classpage.png";
	
	private static final String DEFAULT_USER_IMAGE = "../images/settings/setting-user-image.png";
	
	private static final String CLASS_OWNERSHIP_NAME = "'s Class";
	
	private static final String CLASS_READER_NAME = "Hello, ";
	
	private static StudentClassViewUiBinder uiBinder = GWT.create(StudentClassViewUiBinder.class);

	interface StudentClassViewUiBinder extends UiBinder<Widget, StudentClassView> {    
		
	}
	
	public static final MessageProperties i18n = GWT.create(MessageProperties.class); 
	
	@Inject
	public StudentClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		switchCheckBox.addClickHandler(new ClasspageTabNavigator());
	}

	@Override
	public void onClick(ClickEvent event) {
		
	}

	@Override
	public void clearAll() {
		
	}
	
	@Override
	public void setCourseData(ClasspageDo classpageDo) {
		switchCheckBox.getElement().setId("myonoffswitch");
		switchCheckBox.getElement().setAttribute("name", "onoffswitch");
		String thumbnail = classpageDo.getThumbnailUrl();
		if(thumbnail==null) {
			thumbnail = DEFAULT_CLASSPAGE_IMAGE;
		}
		classImage.setUrl(thumbnail);
		classImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				classImage.setUrl(DEFAULT_CLASSPAGE_IMAGE);
			}
		});
		classImage.setWidth("1000px");
		classImage.setHeight("165px");
		classCodeSpan.setText(classpageDo.getClassCode());
		courseName.setText(classpageDo.getName());
		teacherOwnership.setText(classpageDo.getUser().getUsername()+CLASS_OWNERSHIP_NAME);
		teacherImage.setUrl(classpageDo.getUser().getProfileImageUrl());
		teacherImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				teacherImage.setUrl(DEFAULT_USER_IMAGE);
			}
		});
		studentMessage.setText(CLASS_READER_NAME+AppClientFactory.getLoggedInUser().getUsernameDisplay()+"!");
		studentImage.setUrl(AppClientFactory.getLoggedInUser().getProfileImageUrl());
		studentImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				studentImage.setUrl(DEFAULT_USER_IMAGE);
			}
		});
	}
	
	@Override
	public void addToSlot(Object slot, Widget content) {
		if (content != null) {
			learningMapContainer.clear();
			learningMapContainer.setWidget(content);
		}
	}

	public class ClasspageTabNavigator implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			if(switchCheckBox.isChecked()) {
				request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB, UrlNavigationTokens.STUDENT_CLASSPAGE_REPORT_ITEM);
			} else {
				request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB, UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM);
			}
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}
	
	@Override
	public void setButtonHighlight() {
		String page = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB, UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM);
		if(page.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM)) {
			switchCheckBox.setChecked(false);
		} else {
			switchCheckBox.setChecked(true);
		}
	}

	@Override
	public void setPreviewClassMode(boolean isPreview) {
		editClassMetadataPanel.setVisible(!isPreview);
		previewClassMetadataPanel.setVisible(isPreview);
		joinClassBtn.setVisible(false);
	}

	@Override
	public void setJoinClassData() {
		setPreviewClassMode(true);
		joinClassBtn.setVisible(true);
		teachViewBtn.setVisible(false);
		studentViewLbl.setVisible(false);
	}
	
	@UiHandler("joinClassBtn")
	public void clickJoinClassBtn(ClickEvent event) {
		
	}
	
	@UiHandler("teachViewBtn")
	public void clickTeachViewBtn(ClickEvent event) {
		PlaceRequest request = new PlaceRequest(PlaceTokens.EDIT_CLASS);
		request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.TEACHER_CLASS_SETTINGS);
		request.with(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW, UrlNavigationTokens.TEACHER_CLASS_SETTINGS_INFO);
		AppClientFactory.getPlaceManager().revealPlace(request);
	}
}