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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.classpages.MasterReportDo;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport.TeachStudentReportPopupWidget;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.StringUtil;
import org.gwt.advanced.client.ui.widget.AdvancedFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 * 
 */
public class TeachLessonReportChildView extends ChildView<TeachLessonReportChildPresenter> implements IsTeachLessonReportView {

	@UiField HTMLPanel lessonTablePanel, dashboardContainer;
	
	@UiField HTMLEventPanel allContentPanel;
	
	@UiField SpanPanel textLbl, collectionTitle;
	
	@UiField Button downloadLink, previewLink;
	
	final AdvancedFlexTable lessonTablePanelWidget = new AdvancedFlexTable();
	
	private static final String QUESTION = "assessment-question";
	
	private static final String RESOURCE = "resource";

	private final String GREEN = "#3FC380 !important";
	
	private final String RED = "#EAB4B3 !important";
	
	private final String ORANGE = "#FEC956 !important";
	
	private final String WHITE = "#FFF";

	private static final String VIEWRESPONSE = "View Answer";

	String classId = null, courseId = null, unitId = null, lessonId = null, assessmentId = null, collectionType = null;
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static TeachCourseReportChildViewUiBinder uiBinder = GWT.create(TeachCourseReportChildViewUiBinder.class);

	interface TeachCourseReportChildViewUiBinder extends UiBinder<Widget, TeachLessonReportChildView> {
	}

	public TeachLessonReportChildView() {
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new TeachLessonReportChildPresenter(this));
		classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,null);
		courseId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID,null);
		unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID,null);
		lessonId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID,null);
		assessmentId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID,null);
		collectionType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT,UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		
		if(collectionType.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			previewLink.setText("Preview Collection");
		} else {
			previewLink.setText("Preview Assessment");
		}
		getPresenter().getLessonMasteryData(classId, courseId, unitId, lessonId, assessmentId, collectionType);
	}
	
	@Override
	public void setCollectionMasterytData(ArrayList<MasterReportDo> result) {
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		String title = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CONTENT_NAME, "My Content");
		lessonTablePanel.clear();
		collectionTitle.setText(title);
		if(contentView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT)) {
			textLbl.setText("All Assessments");
		} else {
			textLbl.setText("All Collections");
		}
		setDataTable(result, contentView);
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
		//sortAndFixed();
		dashboardContainer.getElement().setAttribute("style", "min-height:"+(Window.getClientHeight()+Window.getScrollTop()-120)+"px");
	}
	
	public void setDataTable(ArrayList<MasterReportDo> collectionProgressData, String contentView) {
		try{
			lessonTablePanel.clear();
			final AdvancedFlexTable adTable=new AdvancedFlexTable();
			adTable.getElement().setId("example");
			lessonTablePanel.add(adTable);
			// create headers and put them in the thead tag
			Label title=new Label(i18n.GL1932());
			adTable.setHeaderWidget(0, title);
			adTable.setHeaderWidget(1, new Label(i18n.GL2288()));
			
			int questionColumnIndex=0,resourceColumnIndex=0;
			int noOfQuestions=0;

			MasterReportDo defaultUserDataForUsers=null;
			int rowCount=0;
			for (MasterReportDo collectionProgressDataDo : collectionProgressData) {
				defaultUserDataForUsers=collectionProgressDataDo;
				rowCount=rowCount+1;
				if(collectionProgressDataDo.getType()!=null && collectionProgressDataDo.getType().equalsIgnoreCase(QUESTION)){
					HTML questionPnl=new HTML(collectionProgressDataDo.getSequence()+":&nbsp;Question");
					adTable.setHeaderWidget(rowCount+1,questionPnl);
					 if(!collectionProgressDataDo.getType().equalsIgnoreCase("OE")){
						 noOfQuestions++;
					 }
					 questionColumnIndex++;
				}else{
						HTML resourcePnl=new HTML(collectionProgressDataDo.getSequence()+":&nbsp;Resource");
						adTable.setHeaderWidget(rowCount+1,resourcePnl);
						resourceColumnIndex++;
				}
			}
			if(defaultUserDataForUsers!=null){
				int sizeNames=defaultUserDataForUsers.getUsageData().size();
		        int columnsSize=collectionProgressData.size();
		        for(int i=0;i<sizeNames;i++) {
		        	  int score=0,position=0;
		        	  for(int j=0;j<columnsSize;j++) {
		        		  	  String color=WHITE;
		        		  	  VerticalPanel mainDataVpnl=new VerticalPanel();
			        		  if(collectionProgressData.get(j).getType()!=null && !collectionProgressData.get(j).getType().equalsIgnoreCase(QUESTION)){
			        			  
			        		  }else{
			        			  String typeOfQuestion=collectionProgressData.get(j).getType()!=null?collectionProgressData.get(j).getType():"";
			        			//  String answerOption=collectionProgressData.get(j).getUserData().get(i).getOptions().toString();
			        			  
			        			  Map<String, Integer> answerOption = collectionProgressData.get(j).getUsageData().get(i).getOptions();
			        			  String answer="";
			        			  int attemptCount=collectionProgressData.get(j).getUsageData().get(i).getAttempts();
			        			  if((typeOfQuestion!=null) && (typeOfQuestion.equalsIgnoreCase("MA") || typeOfQuestion.equalsIgnoreCase("FIB") || typeOfQuestion.equalsIgnoreCase("OE"))){
			        				  Label viewResponselbl=new Label();
					        		  mainDataVpnl.add(viewResponselbl);
			        				  String answerText="--";
			        				  if(answerOption!=null){
						        		  answerText=VIEWRESPONSE;
						        		 // viewResponselbl.getElement().getParentElement().addClassName(res.css().viewResponseInCollectionProgress());
			        				  }else{
			        					  answerText="--";
			        					  viewResponselbl.getElement().getParentElement().getStyle().setBackgroundColor(WHITE);
			        				  }
			        				  viewResponselbl.setText(answerText);
			        				  //viewResponselbl.addClickHandler(new ClickOnTableCell());
			        				  viewResponselbl.getElement().setAttribute("questionCount", (j+1)+"");
			        				  viewResponselbl.getElement().setAttribute("questionType", typeOfQuestion);
			        				  viewResponselbl.getElement().setAttribute("question", AnalyticsUtil.html2text(collectionProgressData.get(j).getTitle()!=null?collectionProgressData.get(j).getTitle():""));
				        				if(collectionProgressData.get(j).getUsageData()!=null && collectionProgressData.get(j).getUsageData().get(i) != null && collectionProgressData.get(j).getUsageData().get(i).getText() != null){
				        					  viewResponselbl.getElement().setAttribute("questionAnswer",  AnalyticsUtil.html2text(collectionProgressData.get(j).getUsageData().get(i).getText()));
				        				  }
			        				  }else{
			        				  String answerText="";
					        		  if(answerOption!=null){
					        			  	for (Map.Entry<String, Integer> entry : answerOption.entrySet()) {
					        			  		if(entry.getValue()==1) {
					        			  			answer = entry.getKey();
					        			  		}
					        				}
						        		  if(typeOfQuestion.equalsIgnoreCase("TF")){
				        					  if(answer.equalsIgnoreCase("A")){
				        						  answerText="true";
				        					  }else if(answer.equalsIgnoreCase("B")){
				        						  answerText="false";
				        					  }else{
				        						  answerText="--";
				        					  }
				        				  }else{
				        					  answerText=answer;
				        				  }
					        		  }else{
					        			  answerText="--";
					        		  }
			        				  Label answerlbl=new Label(answerText);
					        		  mainDataVpnl.add(answerlbl);
			        			  }
			        			  if(answerOption!=null && collectionProgressData.get(j).getMetaData()!=null){
			        					int scoreValue=collectionProgressData.get(j).getUsageData().get(i).getScore();
			        					 if(scoreValue>=1){
			        						 if(attemptCount>1){
						        				  color=ORANGE;
						        			  }else if(attemptCount==1){
						        				  score++;
						        				  color=GREEN;
						        			  }else{
						        				  color=WHITE;
						        			  }
			        					 }else{
			        						 color=ORANGE;
			        					 }
			        			  }
			        		  }
			        		  Label timeStamplbl=new Label(getTimeSpent(collectionProgressData.get(j).getUsageData().get(i).getTimeSpent()));
			        		  mainDataVpnl.add(timeStamplbl);
			        		  adTable.setWidget(i, position+2,mainDataVpnl);
			        		  adTable.getCellFormatter().getElement(i, position+2).setAttribute("style", "background-color: "+color);
			        		  position++;
		        	   }
		        	  HTML studentName = new HTML(defaultUserDataForUsers.getUsageData().get(i).getUserName());
		        	  adTable.setWidget(i, 0,studentName);
		        	  studentName.addClickHandler(new StudentPlaySummary(defaultUserDataForUsers.getUsageData().get(i).getUserName(), defaultUserDataForUsers.getUsageData().get(i).getUserUId()));
		        	  studentName.setStyleName("myclasses-mastery-unit-cell-style");
		        	  VerticalPanel scoreWidget=new VerticalPanel();
		        	  Label noOfQuestionAttened=new Label(score+"/"+noOfQuestions);
		        	  int percent=0;
		        	  if(noOfQuestions!=0){
		        		  percent=((score*100)/noOfQuestions);
		        	  }
		        	  Label percentage=new Label("("+percent+"%)");
		        	  scoreWidget.add(noOfQuestionAttened);
		        	  scoreWidget.add(percentage);
		        	  adTable.setHTML(i, 1,scoreWidget.toString());
		        }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		sortAndFixed();
	}
	
	private String getTimeSpent(Long commentCreatedTime) {
		String createdTime = null;
		double seconds = (double) ((double)commentCreatedTime / 1000) % 60 ;
		int minutes = (int) ((commentCreatedTime / (1000*60)) % 60);
		int hours   = (int) ((commentCreatedTime / (1000*60*60)) % 24);
		int days = (int) (commentCreatedTime / (1000*60*60*24));
		if(days!=0){
			createdTime=days+":";
		}
		if(hours!=0){
			if(createdTime!=null){
				createdTime=createdTime+hours+":";
			}else{
				createdTime=hours+":";
			}
		}
		if(minutes!=0){
			if(createdTime!=null){
				createdTime=createdTime+minutes+":";
			}else{
				createdTime=minutes+":";
			}
		}
		if(seconds!=0){
			Double secondsInMille=Double.valueOf(roundToTwo(seconds));
			String formattedTime="";
			if(secondsInMille > 0 && secondsInMille<1){
				formattedTime="<1";
			}else if( Math.round(secondsInMille)>=1 &&  Math.round(secondsInMille)<10){
				formattedTime="0"+((int) Math.round(secondsInMille))+"";
			}else{
				formattedTime=((int) Math.round(secondsInMille))+"";
			}
			if(createdTime!=null){
				createdTime=createdTime+formattedTime+"";
			}else{
				createdTime="00"+":"+formattedTime+"";
			}
		}
		return createdTime;
	}
	public static native String roundToTwo(double number) /*-{
		return ""+(Math.round(number + "e+2")  + "e-2");
	}-*/;

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
	
	@UiHandler("allContentPanel")
	public void backToUnitView(ClickEvent event) {
		Map<String,String> params = StringUtil.splitQuery(Window.Location.getHref());
		params.put(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
		params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID);
		params.remove(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID);
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_CLASS, params);
	}
	
	@UiHandler("previewLink")
	public void accessPlayer(ClickEvent event) {
		Map<String,String> params = new LinkedHashMap<String,String>();
		String token = PlaceTokens.ASSESSMENT_PLAY;
		String id = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID,null);
		String collectionType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT,UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		if(collectionType.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
			token = PlaceTokens.COLLECTION_PLAY;
		}
		params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_CLASS_ID, id);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(token, params);
		AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
	}
	
	public class StudentPlaySummary implements ClickHandler {
		String userId = null, userName = null;
		
		public StudentPlaySummary(String userName, String userId) {
			this.userId = userId;
			this.userName = userName;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			TeachStudentReportPopupWidget popup = new TeachStudentReportPopupWidget(collectionTitle.getText(),userName,userId);
		}
	}
	
	
	public void setData1Table(ArrayList<PlanProgressDo> result, String contentView) {
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
					//studentName.addClickHandler(new StudentPlaySummary("studentId"));
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

}