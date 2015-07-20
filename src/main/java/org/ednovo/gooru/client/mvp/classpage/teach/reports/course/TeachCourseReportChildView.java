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

import java.util.ArrayList;

import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport.TeachStudentReportPopupWidget;
import org.ednovo.gooru.shared.util.StringUtil;
import org.gwt.advanced.client.ui.widget.AdvancedFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 * 
 */
public class TeachCourseReportChildView extends ChildView<TeachCourseReportChildPresenter> implements IsTeachCourseReportView {

	@UiField HTMLPanel courseTable, reportContainer, noDataPanel;
	
	@UiField Anchor studentAnr;
	
	@UiField Label notePanel;
	
	@UiField Image studentImage;

	@UiField Button connectCourseBtn,addStudentBtn;
	
	@UiField InlineLabel courseHeaderLbl, courseTitleLbl;
	
	private static final String STUDENTIMAGE = "images/Classpage/studentsIco.png";

	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static TeachCourseReportChildViewUiBinder uiBinder = GWT.create(TeachCourseReportChildViewUiBinder.class);

	interface TeachCourseReportChildViewUiBinder extends UiBinder<Widget, TeachCourseReportChildView> {
	}

	public TeachCourseReportChildView(ClasspageDo classpageDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new TeachCourseReportChildPresenter(this));
		setIds();
		String classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,null);
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID,null);
		if(classId!=null&&courseId!=null) {
			getPresenter().getCourseMasteryData(classId, courseId);
		}
		//setMetaData(classpageDo);
	}
	
	private void setIds() {
		reportContainer.setVisible(false);
		noDataPanel.setVisible(false);
		studentImage.setUrl(STUDENTIMAGE);
		notePanel.setText(i18n.GL3422());
		notePanel.getElement().setId("notePanelId");
		connectCourseBtn.setText(i18n.GL3424());
		connectCourseBtn.getElement().setId("connectCourseBtnId");
		addStudentBtn.setText(i18n.GL3423());
		addStudentBtn.getElement().setId("addStudentBtnId");
		courseHeaderLbl.setText(i18n.GL0574());
		courseHeaderLbl.getElement().setId("courseHeaderLblId");

	}
	
	private void setMetaData(ClasspageDo classpageDo) {
		String memberCountStr = classpageDo.getMemberCount();
		int memberCount = 0;
		if(memberCountStr!=null) {
			memberCount = Integer.parseInt(memberCountStr);
		}
		if(memberCount>0&&classpageDo.getCourseGooruOid()!=null) {
			String classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,null);
			String courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID,null);
			if(classId!=null&&courseId!=null) {
				getPresenter().getCourseMasteryData(classId, courseId);
			}
		} else {
			if(memberCount==0&&classpageDo.getCourseGooruOid()==null) {
				setVisibility(false, true, true, false, false);
			} else if(memberCount>0&&classpageDo.getCourseGooruOid()==null){
				setVisibility(true, false, true, false, false);
			} else if(memberCount==0&&classpageDo.getCourseGooruOid()!=null){
				setVisibility(false, true, false, true, true);
			}
		}
	}
	
	private void setVisibility(boolean isStudentAnrVisible, boolean isAddStudentBtnVisible, boolean isConnectCourseBtnVisible, boolean isCourseHeaderLblVisible, boolean isCourseTitleLblVisible) {
		studentAnr.setVisible(isStudentAnrVisible);
		addStudentBtn.setVisible(isAddStudentBtnVisible);
		connectCourseBtn.setVisible(isConnectCourseBtnVisible);
		courseHeaderLbl.setVisible(isCourseHeaderLblVisible);
		courseTitleLbl.setVisible(isCourseTitleLblVisible);
	}
	
	@Override
	public void setTableData(ArrayList<PlanProgressDo> result) {
		ArrayList<PlanProgressDo> usageData = null;
		final AdvancedFlexTable courseTableWidget = new AdvancedFlexTable();
		courseTableWidget.getElement().setId("course-table-report-data-id");
		courseTable.add(courseTableWidget);
		courseTable.getElement().setId("courseTableID");
		courseTable.getElement().setClassName("scrollTBL");
		courseTableWidget.addStyleName("table table-bordered tableStyle");
		
		int rowCount = result.size();
		
		for(int rowWidgetCount=0;rowWidgetCount<rowCount;rowWidgetCount++) {
			String color = "#fff";
			if(rowWidgetCount%2==1) {
				color = "#f8fafb";
			}
			PlanProgressDo planDo = result.get(rowWidgetCount);
			HTML studentName = new HTML(planDo.getUserName());
			studentName.setStyleName("myclasses-mastery-unit-cell-style");
			studentName.addClickHandler(new StudentCourseView(planDo.getUserName(), planDo.getUserUId()));
			courseTableWidget.setWidget(rowWidgetCount,0,studentName);
			courseTableWidget.getWidget(rowWidgetCount,0).getElement().getParentElement().getStyle().setBackgroundColor(color);
			courseTableWidget.getWidget(rowWidgetCount,0).getElement().getParentElement().getStyle().setWidth(150, Unit.PX);
			usageData = planDo.getUsageData();
			int columnCount = usageData.size();
			for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
				int score = usageData.get(columnWidgetCount).getScoreInPercentage();
				String scoreStr = "--";
				if(score>0) {
					scoreStr = score+"%";
				}
				Label scoreLbl = new Label(scoreStr);
				courseTableWidget.setWidget(rowWidgetCount, columnWidgetCount+1,scoreLbl);
				String highlightStyle = StringUtil.getHighlightStyle(score);
				if(highlightStyle!=null&&highlightStyle.equalsIgnoreCase("grey")) {
					courseTableWidget.getWidget(rowWidgetCount, columnWidgetCount+1).getElement().getParentElement().getStyle().setBackgroundColor(color);
				} else {
					courseTableWidget.getWidget(rowWidgetCount, columnWidgetCount+1).getElement().getParentElement().setClassName(highlightStyle);
				}
				courseTableWidget.getWidget(rowWidgetCount, columnWidgetCount+1).getElement().getParentElement().getStyle().setWidth(150, Unit.PX);
			}
		}
		
		Label studentNameLbl = new Label("Student");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("150px");
		courseTableWidget.setHeaderWidget(0, studentNameLbl);
		
		int columnCount = usageData.size();
		
		for(int headerColumnCount=0;headerColumnCount<columnCount;headerColumnCount++) {
			HTML unitName = new HTML(usageData.get(headerColumnCount).getTitle());
			unitName.setStyleName("myclasses-mastery-unit-cell-style");
			unitName.setWidth("150px");
			unitName.addClickHandler(new ClickUnitName(usageData.get(headerColumnCount).getGooruOId()));
			courseTableWidget.setHeaderWidget(headerColumnCount+1, unitName);
		}
	}
	
	public static native void sortAndFixed() /*-{
	    var table =$wnd.$('#course-table-report-data-id').DataTable({
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         false,
	        bFilter:false,
	        bInfo: false,
	        sort: false
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
		//sortAndFixed();
	}
	
	public class ClickUnitName implements ClickHandler {
		private String unitId = null;
		public ClickUnitName(String unitId) {
			this.unitId = unitId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, unitId);
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}
	
	public class StudentCourseView implements ClickHandler {
		private String gooruUId = null;
		private String userName = null;
		public StudentCourseView(String userName, String gooruUId) {
			this.userName = userName;
			this.gooruUId = gooruUId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			TeachStudentReportPopupWidget popup = new TeachStudentReportPopupWidget(userName,gooruUId);
		}
	}

}