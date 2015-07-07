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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H1Panel;
import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
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
	
	@UiField SpanPanel classCodeSpan;
	@UiField H1Panel courseName;
	@UiField SimplePanel learningMapContainer;
	@UiField Image classImage;
	@UiField SimpleCheckBox switchCheckBox;
	
	private static StudentClassViewUiBinder uiBinder = GWT.create(StudentClassViewUiBinder.class);

	interface StudentClassViewUiBinder extends UiBinder<Widget, StudentClassView> {    
		
	}
	
	public static final MessageProperties i18n = GWT.create(MessageProperties.class); 
	
	@Inject
	public StudentClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		setCourseData();
		switchCheckBox.addClickHandler(new ClasspageTabNavigator());
	}

	@Override
	public void onClick(ClickEvent event) {
		
	}

	@Override
	public void clearAll() {
		
	}
	
	public void setCourseData() {
		switchCheckBox.getElement().setId("myonoffswitch");
		switchCheckBox.getElement().setAttribute("name", "onoffswitch");
		classImage.setUrl("https://qa.goorulearning.org/images/Classpage/default-classpage.png");
		classImage.setWidth("1000px");
		classImage.setHeight("165px");
		setClassCodeText("XYPRSZ");
	}
	
	private void setClassCodeText(String classCode) {
		classCodeSpan.setText(classCode);
		courseName.setText("4th Grade Math");
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

}