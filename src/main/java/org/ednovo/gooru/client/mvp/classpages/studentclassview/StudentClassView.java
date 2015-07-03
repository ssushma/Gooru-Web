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
package org.ednovo.gooru.client.mvp.classpages.studentclassview;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
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
	@UiField H2Panel courseName;
	@UiField Button learningMapBtn, reportsBtn;
	@UiField SimplePanel learningMapContainer;
	
	private static StudentClassViewUiBinder uiBinder = GWT.create(StudentClassViewUiBinder.class);

	interface StudentClassViewUiBinder extends UiBinder<Widget, StudentClassView> {    
		
	}
	
	public static final MessageProperties i18n = GWT.create(MessageProperties.class); 
	
	@Inject
	public StudentClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		setCourseData();
		learningMapBtn.addClickHandler(new ClasspageTabNavigator(UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM,learningMapBtn));
		reportsBtn.addClickHandler(new ClasspageTabNavigator(UrlNavigationTokens.STUDENT_CLASSPAGE_REPORT_ITEM,reportsBtn));
	}

	@Override
	public void onClick(ClickEvent event) {
		
	}

	@Override
	public void clearAll() {
		
	}
	
	public void setCourseData() {
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
		String token = null;
		Button button =null;
		public ClasspageTabNavigator(String token, Button button) {
			this.token = token;
			this.button = button;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			learningMapBtn.removeStyleName(CssTokens.ACTIVE);
			reportsBtn.removeStyleName(CssTokens.ACTIVE);
			button.addStyleName(CssTokens.ACTIVE);
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB, token);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}
	
}