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
package org.ednovo.gooru.client.mvp.classpage.teach.reports.lesson;

import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.gwt.advanced.client.ui.widget.AdvancedFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */
public class TeachLessonReportChildView extends ChildView<TeachLessonReportChildPresenter> implements IsTeachLessonReportView {

	@UiField HTMLPanel lessonTablePanel;
	
	final AdvancedFlexTable lessonTablePanelWidget = new AdvancedFlexTable();
	
	private static TeachCourseReportChildViewUiBinder uiBinder = GWT.create(TeachCourseReportChildViewUiBinder.class);

	interface TeachCourseReportChildViewUiBinder extends UiBinder<Widget, TeachLessonReportChildView> {
	}

	public TeachLessonReportChildView() {
		initWidget(uiBinder.createAndBindUi(this));
		getData();
	}
	
	public void getData() {
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		lessonTablePanel.clear();
		setDataTable(contentView);
	}
	
	public static native void sortAndFixed() /*-{
	    var table =$wnd.$('#collection-table-report-data-id').DataTable({
	        scrollX: true,
	        scrollCollapse: true,
	        paging: false,
	        sort: false,
	        bFilter:false,
	        bInfo: false
	    });
	    new $wnd.$.fn.dataTable.FixedColumns(table,{
	        leftColumns: 2
	    });
	}-*/;
	public static native void destoryTables() /*-{
		var table = $wnd.$('#collection-table-report-data-id').DataTable();
	  	table.destroy();
	}-*/;

	@Override
	public void onLoad() {
		super.onLoad();
		sortAndFixed();
	}
	
	@Override
	public void setDataTable(String contentView) {
		boolean isAssessment = false;
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT)) {
			isAssessment = true;
		}
		
		lessonTablePanelWidget.getElement().setId("collection-table-report-data-id");
		lessonTablePanel.add(lessonTablePanelWidget);
		lessonTablePanel.getElement().setId("lessonTablePanelID");
		lessonTablePanel.getElement().setClassName("scrollTBL");
		lessonTablePanelWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("Student");
		studentNameLbl.setStyleName("text-center");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		lessonTablePanelWidget.setHeaderWidget(0, studentNameLbl);
		columnCount++;
		
		Label scoreLbl = new Label("Score");
		scoreLbl.setStyleName("text-center");
		scoreLbl.setWidth("75px");
		lessonTablePanelWidget.setHeaderWidget(1, scoreLbl);
		columnCount++;
		
		for(int headerColumnCount=2;headerColumnCount<20;headerColumnCount++) {
			String headerTitle = "";
			if(isAssessment) {
				headerTitle = headerColumnCount+": &nbsp;Question";
			} else {
				headerTitle = headerColumnCount+": &nbsp;Resource";
			}
			HTML resourceName = new HTML(headerTitle);
			resourceName.setStyleName("text-center");
			resourceName.setWidth("75px");
			lessonTablePanelWidget.setHeaderWidget(headerColumnCount, resourceName);
			columnCount++;
		}
		
		for(int rowWidgetCount=0;rowWidgetCount<20;rowWidgetCount++) {
			for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
				if(columnWidgetCount==0) {
					Anchor studentName = new Anchor("Student "+rowWidgetCount);
					studentName.setStyleName("text-center");
					//studentName.addClickHandler(new ClickUnitName("studentId"));
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
				} else if(columnWidgetCount==1) {
					final HTMLPanel scoreWidget = new HTMLPanel("");
					scoreWidget.add(new Label("8/10"));
					scoreWidget.add(new Label("80%"));
					scoreWidget.setStyleName("text-center");
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount, scoreWidget);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
				} else {
					if(isAssessment) {
						if(columnWidgetCount%2==1) {
							lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount, getAssessmentQuestionData("B"));
						} else {
							lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount, getAssessmentQuestionData("View Answer"));
						}
					} else {
						if(columnWidgetCount%2==1) {
							lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount, getCollectionResourceData("03:14"));
						} else {
							lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount, getCollectionQuestionData("A","04:15"));
						}
					}
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().setClassName("lightgreen");
				}
			}
		}
	}
	
	private HTMLPanel getCollectionResourceData(String timeSpent) {
		final HTMLPanel panel = new HTMLPanel("");
		panel.add(new Label("--"));
		panel.add(new Label(timeSpent));
		panel.addStyleName("text-center");
		return panel;
	}
	
	private HTMLPanel getCollectionQuestionData(String value, String timeSpent) {
		final HTMLPanel panel = new HTMLPanel("");
		panel.add(new Label(value));
		panel.add(new Label(timeSpent));
		panel.addStyleName("green");
		panel.addStyleName("text-center");
		return panel;
	}
	
	private HTMLPanel getAssessmentQuestionData(String value) {
		final HTMLPanel panel = new HTMLPanel("");
		panel.add(new Label(value));
		panel.addStyleName("green");
		panel.addStyleName("text-center");
		return panel;
	}
}