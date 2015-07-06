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
package org.ednovo.gooru.client.mvp.classpage.teach.reports.course;

import org.ednovo.gooru.application.client.child.ChildView;
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
public class TeachCourseReportChildView extends ChildView<TeachCourseReportChildPresenter> implements IsTeachCourseReportView {

	@UiField HTMLPanel courseTable;
	
	private static TeachCourseReportChildViewUiBinder uiBinder = GWT.create(TeachCourseReportChildViewUiBinder.class);

	interface TeachCourseReportChildViewUiBinder extends UiBinder<Widget, TeachCourseReportChildView> {
	}

	public TeachCourseReportChildView() {
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new TeachCourseReportChildPresenter(this));
		getData();
	}
	
	public void getData() {
		setTableData();
	}

	@Override
	public void setTableData() {
		final AdvancedFlexTable courseTableWidget = new AdvancedFlexTable();
		courseTableWidget.getElement().setId("course-table-report-data-id");
		courseTable.add(courseTableWidget);
		courseTable.getElement().setId("courseTableID");
		courseTable.getElement().setClassName("scrollTBL");
		courseTableWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("Student");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		courseTableWidget.setHeaderWidget(0, studentNameLbl);
		columnCount++;
		for(int headerColumnCount=1;headerColumnCount<20;headerColumnCount++) {
			HTML unitName = new HTML("U"+headerColumnCount+"&nbsp;Unit&nbsp;Name&nbsp;"+headerColumnCount);
			unitName.setStyleName("");
			unitName.setWidth("100px");
			unitName.addClickHandler(new ClickUnitName("unitId"));
			courseTableWidget.setHeaderWidget(headerColumnCount, unitName);
			columnCount++;
		}
		
		for(int rowWidgetCount=0;rowWidgetCount<20;rowWidgetCount++) {
			for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
				if(columnWidgetCount==0) {
					Anchor studentName = new Anchor("Student "+rowWidgetCount);
					studentName.setStyleName("");
					studentName.addClickHandler(new ClickUnitName("studentId"));
					courseTableWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
					courseTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
				} else {
					Label scoreLbl = new Label("90%");
					courseTableWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
					courseTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().setClassName("lightgreen");
				}
			}
		}
	}
	
	public static native void sortAndFixed() /*-{
	    var table =$wnd.$('#course-table-report-data-id').DataTable({
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
		var table = $wnd.$('#course-table-report-data-id').DataTable();
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
}