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
package org.ednovo.gooru.client.mvp.classpage.teach.reports.unit;

import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport.TeachStudentReportPopupWidget;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.StringUtil;
import org.gwt.advanced.client.ui.widget.AdvancedFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 * 
 */
public class TeachUnitReportChildView extends ChildView<TeachUnitReportChildPresenter> implements IsTeachUnitReportView {

	@UiField HTMLPanel unitTablePanel;
	@UiField Label assessementLink, collectionLink;
	@UiField SpanPanel textLbl, currentContentName, previousContentName, nextContentName;
	@UiField HTMLPanel topContainer, learningMapContainer, headerLinksContainer;
	@UiField HTMLEventPanel previousContentPanel, currentContentPanel, nextContentPanel, allContentPanel;
	
	final AdvancedFlexTable assessmentTableWidget = new AdvancedFlexTable();
	final AdvancedFlexTable collectionTableWidget = new AdvancedFlexTable();
	
	String allContentStr = null, previousContentStr = null, nextContentStr = null;
	
	private static final String ALL = "all";

	private static TeachUnitReportChildViewViewUiBinder uiBinder = GWT.create(TeachUnitReportChildViewViewUiBinder.class);

	interface TeachUnitReportChildViewViewUiBinder extends UiBinder<Widget, TeachUnitReportChildView> {
	}

	public TeachUnitReportChildView() {
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new TeachUnitReportChildPresenter(this));
		assessementLink.addClickHandler(new ContentClickHandler("assessment"));
		collectionLink.addClickHandler(new ContentClickHandler("collection"));
		getData();
	}
	
	public void getData() {
		setNavigationData();
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		unitTablePanel.clear();
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT)) {
			setContentLinksHighlight("activeDiv","");
			setAssessmentTableData();
		} else if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			setContentLinksHighlight("","activeDiv");
			setCollectionTableData();
		}
	}
	
	private void setContentLinksHighlight(String assessmentStyle, String collectionStyle) {
		assessementLink.setStyleName(assessmentStyle);
		collectionLink.setStyleName(collectionStyle);
	}
	
	public class ContentClickHandler implements ClickHandler{
		String contentType = null;
		public ContentClickHandler(String contentType) {
			this.contentType = contentType;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, contentType);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}
	
	@Override
	public void setAssessmentTableData() {
		assessmentTableWidget.getElement().setId("unit-table-report-data-id");
		unitTablePanel.add(assessmentTableWidget);
		unitTablePanel.getElement().setId("courseTableID");
		unitTablePanel.getElement().setClassName("scrollTBL");
		assessmentTableWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		assessmentTableWidget.setWidget(0,1,studentNameLbl);
		assessmentTableWidget.getWidget(0, 1).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
		//assessmentTableWidget.setHeaderWidget(0, studentNameLbl);
		int colSpan1 = 5, colSpan2 = 6, colSpan3 = 5, colSpan4 = 10;
		
		columnCount++;
		for(int headerColumnCount=1;headerColumnCount<5;headerColumnCount++) {
			HTML unitName = new HTML("L"+headerColumnCount+"&nbsp;Lesson&nbsp;Name&nbsp;"+headerColumnCount);
			unitName.setStyleName("");
			unitName.setWidth("100px");
			unitName.addClickHandler(new ClickUnitName("unitId"));
			assessmentTableWidget.setWidget(0, headerColumnCount,unitName);
			assessmentTableWidget.getWidget(0, headerColumnCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
			assessmentTableWidget.getWidget(0, headerColumnCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
			columnCount++;
			if(headerColumnCount==1) {
				columnCount = columnCount + (colSpan1-1);
				assessmentTableWidget.getFlexCellFormatter().setColSpan(0, 1, colSpan1);
			}
			if(headerColumnCount==2) {
				columnCount = columnCount + (colSpan2-1);
				assessmentTableWidget.getFlexCellFormatter().setColSpan(0, 2, colSpan2);
			}
			if(headerColumnCount==3) {
				columnCount = columnCount + (colSpan3-1);
				assessmentTableWidget.getFlexCellFormatter().setColSpan(0, 3, colSpan3);
			}
			if(headerColumnCount==4) {
				columnCount = columnCount + (colSpan4-1);
				assessmentTableWidget.getFlexCellFormatter().setColSpan(0, 4, colSpan4);
			}
		}
		
		for(int rowWidgetCount=1;rowWidgetCount<20;rowWidgetCount++) {
			if(rowWidgetCount==1) {
				for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
					if(columnWidgetCount==0) {
						HTML studentName = new HTML("Student&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						studentName.setStyleName("");
						assessmentTableWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					} else {
						Label scoreLbl = new Label("A"+columnWidgetCount);
						assessmentTableWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					}
				}
			} else {
				for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
					if(columnWidgetCount==0) {
						Anchor studentName = new Anchor("Student "+rowWidgetCount);
						studentName.setStyleName("");
						studentName.addClickHandler(new StudentUnitView("studentId"));
						assessmentTableWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("white");
					} else {
						Label scoreLbl = new Label("90%");
						assessmentTableWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
						assessmentTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().setClassName("lightgreen");
					}
				}
			}
		}
	}
	
	public static native void sortAndFixed() /*-{
	    var table =$wnd.$('#unit-table-report-data-id').DataTable({
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
		var table = $wnd.$('#unit-table-report-data-id').DataTable();
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
			
		}
	}

	@Override
	public void setCollectionTableData() {
		collectionTableWidget.getElement().setId("unit-table-report-data-id");
		unitTablePanel.add(collectionTableWidget);
		unitTablePanel.getElement().setId("courseTableID");
		unitTablePanel.getElement().setClassName("scrollTBL");
		collectionTableWidget.addStyleName("table table-bordered tableStyle");
		Label studentNameLbl = new Label("");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		int columnCount = 0;
		collectionTableWidget.setWidget(0,1,studentNameLbl);
		collectionTableWidget.getWidget(0, 1).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
		int colSpan1 = 5, colSpan2 = 6, colSpan3 = 5;
		
		columnCount++;
		for(int headerColumnCount=1;headerColumnCount<5;headerColumnCount++) {
			HTML unitName = new HTML("L"+headerColumnCount+"&nbsp;Lesson&nbsp;Name&nbsp;"+headerColumnCount);
			unitName.setStyleName("");
			unitName.addClickHandler(new ClickUnitName("unitId"));
			collectionTableWidget.setWidget(0, headerColumnCount,unitName);
			collectionTableWidget.getWidget(0, headerColumnCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
			collectionTableWidget.getWidget(0, headerColumnCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
			columnCount++;
			if(headerColumnCount==1) {
				columnCount = columnCount + (colSpan1-1);
				collectionTableWidget.getFlexCellFormatter().setColSpan(0, 1, colSpan1);
			}
			if(headerColumnCount==2) {
				columnCount = columnCount + (colSpan2-1);
				collectionTableWidget.getFlexCellFormatter().setColSpan(0, 2, colSpan2);
			}
			if(headerColumnCount==3) {
				columnCount = columnCount + (colSpan3-1);
				collectionTableWidget.getFlexCellFormatter().setColSpan(0, 3, colSpan3);
			}
		}
		
		for(int rowWidgetCount=1;rowWidgetCount<20;rowWidgetCount++) {
			String color = "#fff";
			if(rowWidgetCount%2==1) {
				color = "#f8fafb";
			}
			if(rowWidgetCount==1) {
				for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
					if(columnWidgetCount==0) {
						HTML studentName = new HTML("Student&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						studentName.setStyleName("");
						studentName.setWidth("100px");
						collectionTableWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					} else {
						Label scoreLbl = new Label("C"+columnWidgetCount);
						scoreLbl.setWidth("80px");
						collectionTableWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					}
				}
			} else {
				for(int columnWidgetCount=0;columnWidgetCount<columnCount;columnWidgetCount++) {
					if(columnWidgetCount==0) {
						Anchor studentName = new Anchor("Student "+rowWidgetCount);
						studentName.setStyleName("");
						studentName.setWidth("100px");
						studentName.addClickHandler(new StudentUnitView("studentId"));
						collectionTableWidget.setWidget(rowWidgetCount, columnWidgetCount,studentName);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
					} else {
						Label scoreLbl = new Label("2 hrs 50 min");
						scoreLbl.setWidth("80px");
						collectionTableWidget.setWidget(rowWidgetCount, columnWidgetCount,scoreLbl);
						collectionTableWidget.getWidget(rowWidgetCount, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
					}
				}
			}
		}
	}

	public void setNavigationData() {
		headerLinksContainer.setVisible(false);
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		
		allContentStr = ALL;
		previousContentStr = "id";
		nextContentStr = "id1";
		
		setContentVisibility(false);
		
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			setNavLinksData("All Units", "Unit 2", "Unit 3: Number & Operations - Fractions", "Unit 4");
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			
		}
		setContentVisibility(true);
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
	
	public void navigateToPage(String id) {
		Map<String,String> params = StringUtil.splitQuery(Window.Location.getHref());
		
		String uId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
		String lId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
		String pageView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE);
		
		if(id.equalsIgnoreCase(ALL)) {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
				params.put(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
				params.remove(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT);
			}
		} else {
			if(pageView.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
				params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID);
				if(uId!=null&&!uId.isEmpty()) {
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, id);
				}
			}
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_CLASS, params);
	}
	
	private void setNavLinksData(String allTxt, String previousLinkTxt, String currentLinkTxt, String nextLinkTxt) {
		textLbl.setText(allTxt);
		previousContentName.setText(previousLinkTxt);
		currentContentName.setText(currentLinkTxt);
		nextContentName.setText(nextLinkTxt);
	}

	private void setContentVisibility(boolean isVisible) {
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		topContainer.setVisible(isVisible);
		learningMapContainer.setVisible(isVisible);
		if(!pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			headerLinksContainer.setVisible(isVisible);
		}
	}

	public class StudentUnitView implements ClickHandler {
		private String courseId = null;
		public StudentUnitView(String courseId) {
			this.courseId = courseId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			TeachStudentReportPopupWidget popup = new TeachStudentReportPopupWidget();
			popup.center();
			popup.show();
		}
	}	
}