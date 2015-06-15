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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.client.mvp.gshelf.util.CourseGradeWidget;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class CourseInfoView extends BaseViewWithHandlers<CourseInfoUiHandlers> implements IsCourseInfoView {

	private static GooruGradesViewUiBinder uiBinder = GWT.create(GooruGradesViewUiBinder.class);
	
	@UiTemplate("CourseInfoView.ui.xml")
	interface GooruGradesViewUiBinder extends UiBinder<Widget, CourseInfoView> {
	}	

	@UiField HTMLPanel courseInfo,pnlGradeContainer;
	@UiField UlPanel ulMainGradePanel,ulSelectedItems;
	
	Map<String,LibraryCodeDo>  courseListBasedOnTitle=new HashMap<String,LibraryCodeDo>();
	CourseGradeWidget courseGradeWidget;
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public CourseInfoView() {
		setWidget(uiBinder.createAndBindUi(this));
		courseInfo.getElement().setId("pnlCourseInfo");
		pnlGradeContainer.getElement().setId("pnlGradeContainer");
		ulMainGradePanel.getElement().setId("ulMainGradePanel");
	}
	
	/**
	 * This method will display the Grades according to the subject
	 */
	@Override
	public void showInfoDetailsBasedOnCourseId(LibraryCodeDo libraryCodeDo) {
		pnlGradeContainer.clear();
		courseGradeWidget=new CourseGradeWidget(libraryCodeDo.getNode()) {
			@Override
			public void setSelectedGrade(String lblvalue, final long codeId,boolean isAdd) {
				if(isAdd){
					final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(lblvalue);
					liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							removeGradeWidget(courseGradeWidget.getGradePanel(),codeId);
							liPanelWithClose.removeFromParent();
						}
					});
					liPanelWithClose.setId(codeId);
					ulSelectedItems.add(liPanelWithClose);
				}else{
					removeGradeWidget(ulSelectedItems,codeId);
				}
			}
		};
		pnlGradeContainer.add(courseGradeWidget);
	}
	/**
	 * This method will remove the widget based on the codeId in the UlPanel
	 * @param ulPanel
	 * @param codeId
	 */
	public void removeGradeWidget(UlPanel ulPanel,long codeId){
		Iterator<Widget> widgets=ulPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget=widgets.next();
			if(widget instanceof LiPanelWithClose){
				LiPanelWithClose obj=(LiPanelWithClose) widget;
				if(obj.getId()==codeId){
					obj.removeFromParent();
				}
			}
			if(widget instanceof LiPanel){
				LiPanel obj=(LiPanel) widget;
				if(obj.getCodeId()==codeId){
					obj.removeStyleName("active");
				}
			}
		}
	}

	@Override
	public void setCourseList(List<LibraryCodeDo> libraryCode) {
		courseListBasedOnTitle.clear();
		ulMainGradePanel.clear();
		if (libraryCode.size()>0) {
			for (LibraryCodeDo libraryCodeDo : libraryCode) {
				String titleText=libraryCodeDo.getLabel().trim();
				courseListBasedOnTitle.put(titleText, libraryCodeDo);
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(titleText);
				title.addClickHandler(new ClickOnSubject(titleText));
				liPanel.add(title);
				ulMainGradePanel.add(liPanel);
			}
			showInfoDetailsBasedOnCourseId(libraryCode.get(0));
		}
	}
	/**
	 * This inner class is used to get selected subjects grades
	 */
	class ClickOnSubject implements ClickHandler{
		String selectedText;
		ClickOnSubject(String selectedText){
			this.selectedText=selectedText;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(courseListBasedOnTitle.size()>0){
				showInfoDetailsBasedOnCourseId(courseListBasedOnTitle.get(selectedText));
			}
		}
	}
}
