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
package org.ednovo.gooru.client.mvp.gshelf.coursedetails;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility.AddClassToCourseView;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility.ContentVisibilityChildView;
import org.ednovo.gooru.client.mvp.gshelf.util.ClassListWidget;
import org.ednovo.gooru.client.uc.H4Panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class CourseShareView extends BaseViewWithHandlers<CourseShareUiHandlers> implements IsCourseShareView {

	private static CourseShareViewUiBinder uiBinder = GWT.create(CourseShareViewUiBinder.class);

	@UiTemplate("CourseShareView.ui.xml")
	interface CourseShareViewUiBinder extends UiBinder<Widget, CourseShareView> {
	}

	public MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField VerticalPanel classListPnl;
	@UiField HTMLPanel assinPnl, associatedClassesPnl, courseDetailsContainer, shareMainContainer, classPanel, contentVisibilityPanel;
	@UiField Anchor createClassAchr;
	@UiField Button courseBtn;
	@UiField H4Panel addClassBtn;
	
	AddClassToCourseView addClassPopup = null;
	
	/**
	 * Class constructor
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public CourseShareView() {
		setWidget(uiBinder.createAndBindUi(this));
		assinPnl.getElement().setId("addCourseToClasPopup");
		classListPnl.getElement().getStyle().setWidth(100, Unit.PCT);
		shareMainContainer.setVisible(false);
		addClassBtn.setText("+ Add Class");
		addClassBtn.addClickHandler(new AddClass());
		courseBtn.addClickHandler(new AddClass());
	}
	
	public class AddClass implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			addClassPopup = new AddClassToCourseView() {
				@Override
				public void onClickPositiveButton(ClickEvent event) {
					if(addClassPopup.getClassId()==null) {
						addClassPopup.getErrorLabel().setVisible(true);
					} else {
						addClassPopup.getErrorLabel().setVisible(false);
						getUiHandlers().assign2ClassPage(addClassPopup.getClassId(), AppClientFactory.getPlaceManager().getRequestParameter("o1", ""));
					}
				}
			};
			addClassPopup.getElement().getStyle().setZIndex(9999999);
			addClassPopup.show();
			addClassPopup.center();
		}
	}
	
	@Override
	public void setDefaultClass() {
		if(addClassPopup!=null) {
			addClassPopup.hide();
		}
		Window.enableScrolling(true);
	}

	@UiHandler("courseBtn")
	public void clickOnCourseBtn(ClickEvent clickEvent){
		
	}

	@UiHandler("createClassAchr")
	public void createNewClass(ClickEvent clickEvent){
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME,new String[] { UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.MYCLASS});
	}

	@Override
	public void showClassesInList(ArrayList<ClasspageDo> classPageDo, final String courseId) {
		shareMainContainer.setVisible(true);
		setDefaultClass();
		if(classPageDo!=null&&classPageDo.size()>0) {
			assinPnl.setVisible(false);
			courseDetailsContainer.setVisible(true);
			associatedClassesPnl.setVisible(true);
			if(classPageDo!=null){
				int rowCount = 0;
				for(final ClasspageDo classObj:classPageDo){
					ClassListWidget classListWidget = new ClassListWidget(classObj,courseId);
					if(rowCount%2!=0) {
						classListWidget.getElement().getStyle().setBackgroundColor("#F8FAFB");
					}
					classListWidget.getEditClassAnchor().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							redirectToContentVisibility(classObj, courseId);
						}
					});
					classListPnl.add(classListWidget);
					rowCount++;
				}
			}
		} else {
			classPanel.setVisible(true);
			assinPnl.setVisible(true);
			courseDetailsContainer.setVisible(false);
		}
	}
	
	@Override
	public void redirectToContentVisibility(ClasspageDo classObj, String courseId) {
		classPanel.setVisible(false);
		contentVisibilityPanel.clear();
		contentVisibilityPanel.setVisible(true);
		ContentVisibilityChildView classListWidget = new ContentVisibilityChildView(classObj,courseId);
		classListWidget.getAnrAllClasses().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				classPanel.setVisible(true);
				contentVisibilityPanel.setVisible(false);
			}
		});
		contentVisibilityPanel.add(classListWidget);
	}
	
	@Override
	public void clearSharePlanes() {
		classListPnl.clear();
		contentVisibilityPanel.clear();
	}

	/**
	 * @return the associatedClassesPnl
	 */
	@Override
	public HTMLPanel getAssociatedClassesPnl() {
		return associatedClassesPnl;
	}
}