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

import java.util.ArrayList;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
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
		String classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,null);
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID,null);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID,null);
		String collectionType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT,UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		if(classId!=null&&courseId!=null&&unitId!=null) {
			getPresenter().getUnitMasteryData(classId, courseId, unitId, collectionType);
		}
	}

	@Override
	public void setTableData(ArrayList<PlanProgressDo> result) {
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT)) {
			setContentLinksHighlight("activeDiv","");
		} else if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			setContentLinksHighlight("","activeDiv");
		}
		setAssessmentTableData(result);
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
	public void setAssessmentTableData(ArrayList<PlanProgressDo> userList) {
		boolean isCollection = false;
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			isCollection = true;
		}
		
		unitTablePanel.clear();
		assessmentTableWidget.getElement().setId("unit-table-report-data-id");
		unitTablePanel.add(assessmentTableWidget);
		unitTablePanel.getElement().setId("courseTableID");
		unitTablePanel.getElement().setClassName("scrollTBL");
		assessmentTableWidget.addStyleName("table table-bordered tableStyle");
		
		int rowCount = userList.size();
		
		Label studentNameLbl = new Label("");
		studentNameLbl.setStyleName("");
		studentNameLbl.setWidth("100px");
		assessmentTableWidget.setWidget(0,1,studentNameLbl);
		assessmentTableWidget.getWidget(0, 1).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
		
		for(int rowWidgetCount=0;rowWidgetCount<rowCount;rowWidgetCount++) {
			String color = "#fff";
			if(rowWidgetCount%2==1) {
				color = "#f8fafb";
			}
			int columnWidgetCount = 0;
			if(columnWidgetCount==0) {
				Anchor studentName = new Anchor(userList.get(rowWidgetCount).getUserName()); //
				studentName.setStyleName("");
				studentName.setWidth("100px");
				studentName.addClickHandler(new StudentUnitView(userList.get(rowWidgetCount).getUserName(), userList.get(rowWidgetCount).getUserUId()));
				assessmentTableWidget.setWidget(rowWidgetCount+2, columnWidgetCount,studentName);
				assessmentTableWidget.getWidget(rowWidgetCount+2, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
				
				if(rowWidgetCount==0) {
					HTML studentNameTitle = new HTML("Student&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					studentNameTitle.setWidth("100px");
					studentName.setStyleName("");
					assessmentTableWidget.setWidget(rowWidgetCount+1, columnWidgetCount,studentNameTitle);
					assessmentTableWidget.getWidget(rowWidgetCount+1, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
					assessmentTableWidget.getWidget(rowWidgetCount+1, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
				}
				columnWidgetCount++;
			}
			ArrayList<PlanProgressDo> lessonList = userList.get(rowWidgetCount).getUsageData();
			int lessonCount = lessonList.size();
			for(int lessonWidgetCount=0;lessonWidgetCount<lessonCount;lessonWidgetCount++) {
				ArrayList<PlanProgressDo> collectionList = lessonList.get(lessonWidgetCount).getUsageData();
				int collectionCount = collectionList.size();
				for(int collectionWidgetCount=0;collectionWidgetCount<collectionCount;collectionWidgetCount++) {
					if(rowWidgetCount==0) {
						String A_STRING = "A";
						if(isCollection) {
							A_STRING = "C";
						}
						Label scoreLblTitle = new Label(A_STRING+columnWidgetCount);
						scoreLblTitle.setWidth("80px");
						scoreLblTitle.addStyleName("myclasses-mastery-collection-cell-style");
						scoreLblTitle.addClickHandler(new CollectionAssessmentView(lessonList.get(lessonWidgetCount).getGooruOId(),collectionList.get(collectionWidgetCount).getGooruOId(),contentView,collectionList.get(collectionWidgetCount).getTitle()));
						assessmentTableWidget.setWidget(rowWidgetCount+1, columnWidgetCount,scoreLblTitle);
						assessmentTableWidget.getWidget(rowWidgetCount+1, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
						assessmentTableWidget.getWidget(rowWidgetCount+1, columnWidgetCount).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					}
					final Label contentLabel = new Label("");
					if(isCollection) {
						contentLabel.setText(StringUtil.getFormattedDate(collectionList.get(collectionWidgetCount).getTimespent(), ""));
						assessmentTableWidget.setWidget(rowWidgetCount+2, columnWidgetCount,contentLabel);
					} else {
						int score = collectionList.get(collectionWidgetCount).getScoreInPercentage();
						contentLabel.setText(score+"%");
						contentLabel.setWidth("80px");
						assessmentTableWidget.setWidget(rowWidgetCount+2, columnWidgetCount,contentLabel);
						assessmentTableWidget.getWidget(rowWidgetCount+2, columnWidgetCount).getElement().getParentElement().setClassName(StringUtil.getHighlightStyle(score));
					}
					assessmentTableWidget.getWidget(rowWidgetCount+2, columnWidgetCount).getElement().getParentElement().getStyle().setBackgroundColor(color);
					columnWidgetCount++;
				}
			}
		}
		if(userList!=null&&userList.size()>0&&userList.get(0)!=null) {
			int lessonSize = userList.get(0).getUsageData().size();
			int colSpan = 0;
			for(int headerColumnCount=0;headerColumnCount<lessonSize;headerColumnCount++) {
				PlanProgressDo lessonDo = userList.get(0).getUsageData().get(headerColumnCount);
				if(lessonDo.getUsageData().size()>0) {
					HTML unitName = new HTML("L"+(headerColumnCount+1)+"&nbsp;"+lessonDo.getTitle());
					unitName.setStyleName("");
					assessmentTableWidget.setWidget(0, headerColumnCount+1,unitName);
					assessmentTableWidget.getWidget(0, headerColumnCount+1).getElement().getParentElement().getStyle().setBackgroundColor("#f8fafb");
					assessmentTableWidget.getWidget(0, headerColumnCount+1).getElement().getParentElement().getStyle().setFontWeight(FontWeight.BOLD);
					colSpan = colSpan + lessonDo.getUsageData().size();
					assessmentTableWidget.getFlexCellFormatter().setColSpan(0, (headerColumnCount+1), colSpan);
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
		if(previousLinkTxt==null) {
			previousContentPanel.setVisible(false);
		} else {
			previousContentPanel.setVisible(true);
		}
		if(nextLinkTxt==null) {
			nextContentPanel.setVisible(false);
		} else {
			nextContentPanel.setVisible(true);
		}
		previousContentName.setText(previousLinkTxt);
		currentContentName.setText(currentLinkTxt);
		nextContentName.setText(nextLinkTxt);
	}

	@Override
	public void setMetadataContent(ArrayList<PlanProgressDo> dataList) {
		headerLinksContainer.setVisible(false);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, null);
		setContentVisibility(false);
		allContentStr = ALL;
		setLinksData(unitId, dataList, "All Units", "Unit");
		setContentVisibility(true);
	}
	
	private void setLinksData(String id, ArrayList<PlanProgressDo> dataList, String allTxt, String titleTxt) {
		int size = dataList.size();
		int matchedCount = 0;
		String name = null, previousName = null, nextName = null;
		for(int i=0;i<size;i++) {
			PlanProgressDo planProgressDo = dataList.get(i);
			if(planProgressDo.getGooruOId().equalsIgnoreCase(id)) {
				matchedCount = i;
				break;
			}
		}
		if(matchedCount==0&&size==1) {
			previousContentStr = null;
			nextContentStr = null;
		} else if(matchedCount==0&&size>1) {
			previousContentStr = null;
			nextContentStr = dataList.get(matchedCount+1).getGooruOId();
			name = titleTxt+" "+(matchedCount+1)+": "+dataList.get(matchedCount).getTitle();
			nextName = titleTxt+" "+(matchedCount+2);
		} else if(matchedCount==size-1) {
			nextContentStr = null;
			previousContentStr = dataList.get(matchedCount-1).getGooruOId();
			name = titleTxt+" "+(matchedCount+1)+": "+dataList.get(matchedCount).getTitle();
			previousName = titleTxt+" "+(matchedCount);
		} else if(matchedCount<size-1) {
			previousContentStr = dataList.get(matchedCount-1).getGooruOId();
			nextContentStr = dataList.get(matchedCount+1).getGooruOId();
			name = titleTxt+" "+(matchedCount+1)+": "+dataList.get(matchedCount).getTitle();
			nextName = titleTxt+" "+(matchedCount+2);
			previousName = titleTxt+" "+(matchedCount);
		}
		setNavLinksData(allTxt, previousName, name, nextName);
	}

	private void setContentVisibility(boolean isVisible) {
		topContainer.setVisible(isVisible);
		learningMapContainer.setVisible(isVisible);
		headerLinksContainer.setVisible(isVisible);
	}
	
	public class CollectionAssessmentView implements ClickHandler {
		private String contentId = null, contentType = null, lessonId = null, title = null;
		public CollectionAssessmentView(String lessonId, String contentId, String contentType, String title) {
			this.lessonId = lessonId;
			this.contentId = contentId;
			this.contentType = contentType;
			this.title = title;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, lessonId);
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, contentType);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID, contentId);
			request = request.with(UrlNavigationTokens.CONTENT_NAME, title);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}

	public class StudentUnitView implements ClickHandler {
		private String userName = null;
		private String userUid = null;
		public StudentUnitView(String userName, String userUid) {
			this.userName = userName;
			this.userUid = userUid;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			TeachStudentReportPopupWidget popup = new TeachStudentReportPopupWidget(userName,userUid);
		}
	}
}