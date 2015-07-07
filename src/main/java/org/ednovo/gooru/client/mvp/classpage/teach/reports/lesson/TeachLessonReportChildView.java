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
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT)) {
			setAssessmentTableData();
		} else if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			setCollectionTableData();
		}
	}
	
	public static native void sortAndFixed() /*-{
	    var table =$wnd.$('#lesson-table-report-data-id').DataTable({
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         false,
	        bFilter:false,
	        bInfo: false
	    });
	    new $wnd.$.fn.dataTable.FixedColumns(table,{
	        leftColumns: 1
	    });
	}-*/;
	public static native void destoryTables() /*-{
		var table = $wnd.$('#lesson-table-report-data-id').DataTable();
	  	table.destroy();
	}-*/;

	@Override
	public void onLoad() {
		super.onLoad();
		sortAndFixed();
	}
	
	public class ClickUnitName implements ClickHandler {
		private String unitId = null;
		public ClickUnitName(String unitId) {
			this.unitId = unitId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			
		}
	}

	@Override
	public void setAssessmentTableData() {
		final AdvancedFlexTable lessonTablePanelWidget = new AdvancedFlexTable();
		lessonTablePanelWidget.getElement().setId("lesson-table-report-data-id");
		lessonTablePanel.add(lessonTablePanelWidget);
		lessonTablePanel.getElement().setId("lessonTablePanelID");
		lessonTablePanel.getElement().setClassName("scrollTBL");
		lessonTablePanelWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("Student");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		lessonTablePanelWidget.setHeaderWidget(0, studentNameLbl);
		columnCount++;
		for(int headerColumnCount=1;headerColumnCount<20;headerColumnCount++) {
			HTML unitName = new HTML("U"+headerColumnCount+"&nbsp;Unit&nbsp;Name&nbsp;"+headerColumnCount);
			unitName.setStyleName("");
			unitName.setWidth("100px");
			unitName.addClickHandler(new ClickUnitName("unitId"));
			lessonTablePanelWidget.setHeaderWidget(headerColumnCount, unitName);
			columnCount++;
		}
		
		for(int rowWidgetCount=0;rowWidgetCount<20;rowWidgetCount++) {
			for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
				if(columnWidgetCount==0) {
					Anchor studentName = new Anchor("Student "+rowWidgetCount);
					studentName.setStyleName("");
					studentName.addClickHandler(new ClickUnitName("studentId"));
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
				} else {
					Label scoreLbl = new Label("90%");
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().setClassName("lightgreen");
				}
			}
		}
	}

	@Override
	public void setCollectionTableData() {
		final AdvancedFlexTable lessonTablePanelWidget = new AdvancedFlexTable();
		lessonTablePanelWidget.getElement().setId("lesson-table-report-data-id");
		lessonTablePanel.add(lessonTablePanelWidget);
		lessonTablePanel.getElement().setId("lessonTablePanelID");
		lessonTablePanel.getElement().setClassName("scrollTBL");
		lessonTablePanelWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("Student");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		lessonTablePanelWidget.setHeaderWidget(0, studentNameLbl);
		columnCount++;
		for(int headerColumnCount=1;headerColumnCount<20;headerColumnCount++) {
			HTML unitName = new HTML("U"+headerColumnCount+"&nbsp;Unit&nbsp;Name&nbsp;"+headerColumnCount);
			unitName.setStyleName("");
			unitName.setWidth("100px");
			unitName.addClickHandler(new ClickUnitName("unitId"));
			lessonTablePanelWidget.setHeaderWidget(headerColumnCount, unitName);
			columnCount++;
		}
		
		for(int rowWidgetCount=0;rowWidgetCount<20;rowWidgetCount++) {
			for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
				if(columnWidgetCount==0) {
					Anchor studentName = new Anchor("Student "+rowWidgetCount);
					studentName.setStyleName("");
					studentName.addClickHandler(new ClickUnitName("studentId"));
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
				} else {
					Label scoreLbl = new Label("90%");
					lessonTablePanelWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
					lessonTablePanelWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().setClassName("lightgreen");
				}
			}
		}
	}	
}