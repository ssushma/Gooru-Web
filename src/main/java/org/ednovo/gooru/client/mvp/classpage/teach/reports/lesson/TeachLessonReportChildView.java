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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.classpages.MasterReportDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.TeachStudentEmptyDataView;
import org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport.TeachStudentReportPopupWidget;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;
import org.gwt.advanced.client.ui.widget.AdvancedFlexTable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */
public class TeachLessonReportChildView extends ChildView<TeachLessonReportChildPresenter> implements IsTeachLessonReportView,ClientConstants {

	@UiField HTMLPanel lessonTablePanel;
	
	final AdvancedFlexTable lessonTablePanelWidget = new AdvancedFlexTable();
	
	private static final String QUESTION = "assessment-question";
	
	private static final String RESOURCE = "resource";

	private final String COLLECTION_GREEN = "#bbd1b8 !important";
	
	private final String COLLECTION_RED = "#EAB4B3 !important";
	
	private final String COLLECTION_ORANGE = "#ffe7c0 !important";
	
	private final String ASSESSMENT_GREEN = "#3fc380 !important";
	
	private final String ASSESSMENT_ORANGE = "#f1aa44 !important";

	private final String WHITE = "#ffffff";

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
		getPresenter().getLessonMasteryData(classId, courseId, unitId, lessonId, assessmentId, collectionType);
	}
	
	@Override
	public void setCollectionMasterytData(ArrayList<MasterReportDo> result) {
		String contentView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
		lessonTablePanel.clear();
		setDataTable(result, contentView);
		setDataTableH(result, contentView);
		Element element = Document.get().getElementById("exampleH");
		element.setAttribute("style", "display:none;");
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

	public void setDataTable(ArrayList<MasterReportDo> collectionProgressData, String contentView) {
        int columnsSize=collectionProgressData.size();
        if(columnsSize>0) {
    		try{
    			boolean isCollection = false;
    			String contentName = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
    			if(contentName.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
    				isCollection = true;
    			}
    			
    			lessonTablePanel.clear();
    			final AdvancedFlexTable adTable=new AdvancedFlexTable();
    			adTable.getElement().setId("example");
    			lessonTablePanel.add(adTable);
    			// create headers and put them in the thead tag
    			Label title=new Label(i18n.GL1932());
    			adTable.setHeaderWidget(0, title);
    			adTable.setHeaderWidget(1, new Label(i18n.GL2288()));
    			
    			int noOfQuestions=0;

    			MasterReportDo defaultUserDataForUsers=null;
    			int rowCount=0;
    			for (MasterReportDo collectionProgressDataDo : collectionProgressData) {
    				defaultUserDataForUsers=collectionProgressDataDo;
    				rowCount=rowCount+1;
    				if(collectionProgressDataDo.getType()!=null && collectionProgressDataDo.getType().equalsIgnoreCase(QUESTION)){
    					HTML questionPnl=new HTML(collectionProgressDataDo.getSequence()+": Question");
    					adTable.setHeaderWidget(rowCount+1,questionPnl);
    					 if(!collectionProgressDataDo.getQuestionType().equalsIgnoreCase("OE")){
    						 noOfQuestions++;
    					 }
    				}else{
    					HTML resourcePnl=new HTML(collectionProgressDataDo.getSequence()+": Resource");
    					adTable.setHeaderWidget(rowCount+1,resourcePnl);
    				}
    			}
    			if(defaultUserDataForUsers!=null){
    				int sizeNames=defaultUserDataForUsers.getUsageData().size();
    		        for(int i=0;i<sizeNames;i++) {
    		        	  int score=0,position=0;
    		        	  for(int j=0;j<columnsSize;j++) {
    		        		  	  String color=WHITE;
    			        		  if(collectionProgressData.get(j).getType()!=null && !collectionProgressData.get(j).getType().equalsIgnoreCase(QUESTION)){
    				        		  
    			        		  }else{
    			        			  String questionType = collectionProgressData.get(j).getQuestionType()!=null?collectionProgressData.get(j).getQuestionType():"";
    			        			  if(!questionType.equalsIgnoreCase("OE")) {
        			        			  int attemptCount=collectionProgressData.get(j).getUsageData().get(i).getAttempts();
        			        			  int scoreValue=collectionProgressData.get(j).getUsageData().get(i).getScore();
        			        			  
        			        			  if(isCollection) {
        			        				  if(attemptCount>1&&scoreValue>=1){
        			        					  color = COLLECTION_ORANGE;
        			        					  score++;
        			        				  } else if(attemptCount==1&&scoreValue==1) {
        			        					  color = COLLECTION_GREEN;
        			        					  score++;
        			        				  } else if(attemptCount>=1&&scoreValue==0) {
        			        					  color=COLLECTION_RED;
        			        				  } else {
        			        					  color=WHITE;
        			        				  }
        			        			  } else {
        			        				  if(attemptCount>=1&&scoreValue>=1){
        			        					  color = ASSESSMENT_GREEN;
        			        					  score++;
        			        				  } else if(attemptCount>=1&&scoreValue==0) {
        			        					  color = ASSESSMENT_ORANGE;
        			        				  } else {
        			        					  color=WHITE;
        			        				  }
        			        			  }
    			        			  }
    			        		  }
    			        		  if(OE.equalsIgnoreCase(collectionProgressData.get(j).getQuestionType()))
    			        		  {
    			        			  FlowPanel flwPnl = new FlowPanel();
    				        		  if(collectionProgressData.get(j).getUsageData().get(i).getAnswerObject()!=null)
    				        		  {
    	    			        		JSONValue value = JSONParser.parseStrict(collectionProgressData.get(j).getUsageData().get(i).getAnswerObject());
    	    			  				JSONObject answerObject = value.isObject();
    	    			  				Set<String> keys=answerObject.keySet();
    	    			  				Iterator<String> itr = keys.iterator();
    	    			  				JSONArray attemptsObj=null;
    	    			  				while(itr.hasNext()) {
    	    			  					attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
    	    			  				}
    	    			  				if(attemptsObj!=null)
    	    			  				{
	    			  					flwPnl = renderAnswersDataOE(attemptsObj,collectionProgressData.get(j).getQuestionType(),collectionProgressData.get(j).getUsageData().get(i).getAttempts(),collectionProgressData.get(j).getUsageData().get(i).getOptions());
	    			  					adTable.setWidget(i, position+2,flwPnl);
    	    			  				}
    	    			  				else
      	    			  				{
    	    			         	  		  Label timeStamplbl=new Label("");
    	        			        		  adTable.setWidget(i, position+2,timeStamplbl);
      	    			  				}

    				        		  }
  	    			  				else
  	    			  				{
	    			         	  		  Label timeStamplbl=new Label(StringUtil.getElapsedTime(collectionProgressData.get(j).getUsageData().get(i).getTimeSpent()));
	        			        		  adTable.setWidget(i, position+2,timeStamplbl);
  	    			  				}
    			        		  }
    			        		  else
    			        		  {
    			        	  		  Label timeStamplbl=new Label(StringUtil.getElapsedTime(collectionProgressData.get(j).getUsageData().get(i).getTimeSpent()));
        			        		  adTable.setWidget(i, position+2,timeStamplbl);
    			        		  }
    			      
    			        		  adTable.getCellFormatter().getElement(i, position+2).setAttribute("style", "background-color:"+color);
    			        		  position++;
    		        	   }
    		        	  HTML studentName = new HTML(defaultUserDataForUsers.getUsageData().get(i).getUserName());
    		        	  adTable.setWidget(i, 0,studentName);
    		        	  studentName.addClickHandler(new StudentPlaySummary(defaultUserDataForUsers.getUsageData().get(i).getUserName(), defaultUserDataForUsers.getUsageData().get(i).getUserUId()));
    		        	  studentName.setStyleName("myclasses-mastery-unit-cell-style");
    		        	  int percent=0;
    		        	  if(noOfQuestions!=0){
    		        		  percent=((score*100)/noOfQuestions);
    		        	  }
    		        	  Label scoreWidget=new Label(score+"/"+noOfQuestions+" ("+percent+"%)");
    		        	  adTable.setWidget(i, 1,scoreWidget);
    		        }
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
        } else {
        	lessonTablePanel.clear();
        	lessonTablePanel.add(new TeachStudentEmptyDataView());
        }
	}
	
	
	public void setDataTableH(ArrayList<MasterReportDo> collectionProgressData, String contentView) {
		 int columnsSize=collectionProgressData.size();
	        if(columnsSize>0) {
	    		try{
	    			boolean isCollection = false;
	    			String contentName = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT, UrlNavigationTokens.TEACHER_CLASSPAGE_ASSESSMENT);
	    			if(contentName.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASSPAGE_COLLECTION)) {
	    				isCollection = true;
	    			}
	    			
	    			//lessonTablePanel.clear();
	    			final AdvancedFlexTable adTable=new AdvancedFlexTable();
	    			adTable.getElement().setId("exampleH");
	    			lessonTablePanel.add(adTable);
	    			// create headers and put them in the thead tag
	    			Label title=new Label(i18n.GL1932());
	    			adTable.setHeaderWidget(0, title);
	    			adTable.setHeaderWidget(1, new Label(i18n.GL2288()));
	    			
	    			int noOfQuestions=0;

	    			MasterReportDo defaultUserDataForUsers=null;
	    			int rowCount=0;
	    			for (MasterReportDo collectionProgressDataDo : collectionProgressData) {
	    				defaultUserDataForUsers=collectionProgressDataDo;
	    				rowCount=rowCount+1;
	    				if(collectionProgressDataDo.getType()!=null && collectionProgressDataDo.getType().equalsIgnoreCase(QUESTION)){
	    					HTML questionPnl=new HTML(collectionProgressDataDo.getSequence()+": Question");
	    					adTable.setHeaderWidget(rowCount+1,questionPnl);
	    					 if(!collectionProgressDataDo.getQuestionType().equalsIgnoreCase("OE")){
	    						 noOfQuestions++;
	    					 }
	    				}else{
	    					HTML resourcePnl=new HTML(collectionProgressDataDo.getSequence()+": Resource");
	    					adTable.setHeaderWidget(rowCount+1,resourcePnl);
	    				}
	    			}
	    			if(defaultUserDataForUsers!=null){
	    				int sizeNames=defaultUserDataForUsers.getUsageData().size();
	    		        for(int i=0;i<sizeNames;i++) {
	    		        	  int score=0,position=0;
	    		        	  for(int j=0;j<columnsSize;j++) {
	    		        		  	  String color=WHITE;
	    		        		  	 String questionType = collectionProgressData.get(j).getQuestionType()!=null?collectionProgressData.get(j).getQuestionType():"";
	    			        		  if(collectionProgressData.get(j).getType()!=null && !collectionProgressData.get(j).getType().equalsIgnoreCase(QUESTION)){
	    				        		  
	    			        		  }else{
	    			        			 
	    			        			  if(!questionType.equalsIgnoreCase("OE")) {
	        			        			  int attemptCount=collectionProgressData.get(j).getUsageData().get(i).getAttempts();
	        			        			  int scoreValue=collectionProgressData.get(j).getUsageData().get(i).getScore();
	        			        			  
	        			        			  if(isCollection) {
	        			        				  if(attemptCount>1&&scoreValue>=1){
	        			        					  color = COLLECTION_ORANGE;
	        			        					  score++;
	        			        				  } else if(attemptCount==1&&scoreValue==1) {
	        			        					  color = COLLECTION_GREEN;
	        			        					  score++;
	        			        				  } else if(attemptCount>=1&&scoreValue==0) {
	        			        					  color=COLLECTION_RED;
	        			        				  } else {
	        			        					  color=WHITE;
	        			        				  }
	        			        			  } else {
	        			        				  if(attemptCount>=1&&scoreValue>=1){
	        			        					  color = ASSESSMENT_GREEN;
	        			        					  score++;
	        			        				  } else if(attemptCount>=1&&scoreValue==0) {
	        			        					  color = ASSESSMENT_ORANGE;
	        			        				  } else {
	        			        					  color=WHITE;
	        			        				  }
	        			        			  }
	    			        			  }
	    			        		  }
	    			        		  if(OE.equalsIgnoreCase(questionType)|| MC.equalsIgnoreCase(questionType) ||TF.equalsIgnoreCase(questionType) || TSLASHF.equalsIgnoreCase(questionType) || FIB.equalsIgnoreCase(questionType) || MA.equalsIgnoreCase(questionType) || HS_IMG.equalsIgnoreCase(questionType) || "HS".equalsIgnoreCase(questionType) || HS_TXT.equalsIgnoreCase(questionType) || HT_HL.equalsIgnoreCase(questionType) || HT_RO.equalsIgnoreCase(questionType))
	    			        		  {
	    			        			  FlowPanel flwPnl = new FlowPanel();
	    				        		  if(collectionProgressData.get(j).getUsageData().get(i).getAnswerObject()!=null)
	    				        		  {
	    	    			        		JSONValue value = JSONParser.parseStrict(collectionProgressData.get(j).getUsageData().get(i).getAnswerObject());
	    	    			  				JSONObject answerObject = value.isObject();
	    	    			  				Set<String> keys=answerObject.keySet();
	    	    			  				Iterator<String> itr = keys.iterator();
	    	    			  				JSONArray attemptsObj=null;
	    	    			  				while(itr.hasNext()) {
	    	    			  					attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
	    	    			  				}
	    	    			  				if(attemptsObj!=null)
	    	    			  				{
		    			  					flwPnl = renderAnswersData(attemptsObj,collectionProgressData.get(j).getQuestionType(),collectionProgressData.get(j).getUsageData().get(i).getAttempts(),collectionProgressData.get(j).getUsageData().get(i).getOptions());
		    			  					adTable.setWidget(i, position+2,flwPnl);
	    	    			  				}
	    	    			  				else
		  	    			  				{
			    			         	  		  Label timeStamplbl=new Label("");
			        			        		  adTable.setWidget(i, position+2,timeStamplbl);
		  	    			  				}

	    				        		  }
	  	    			  				else
	  	    			  				{
		    			         	  		  Label timeStamplbl=new Label(StringUtil.getElapsedTime(collectionProgressData.get(j).getUsageData().get(i).getTimeSpent()));
		        			        		  adTable.setWidget(i, position+2,timeStamplbl);
	  	    			  				}
	    			        		  }
	    			        		  else
	    			        		  {
	    			        	  		  Label timeStamplbl=new Label(StringUtil.getElapsedTime(collectionProgressData.get(j).getUsageData().get(i).getTimeSpent()));
	        			        		  adTable.setWidget(i, position+2,timeStamplbl);
	    			        		  }
	    			      
	    			        		  adTable.getCellFormatter().getElement(i, position+2).setAttribute("style", "background-color:"+color);
	    			        		  position++;
	    		        	   }
	    		        	  HTML studentName = new HTML(defaultUserDataForUsers.getUsageData().get(i).getUserName());
	    		        	  adTable.setWidget(i, 0,studentName);
	    		        	  studentName.addClickHandler(new StudentPlaySummary(defaultUserDataForUsers.getUsageData().get(i).getUserName(), defaultUserDataForUsers.getUsageData().get(i).getUserUId()));
	    		        	  studentName.setStyleName("myclasses-mastery-unit-cell-style");
	    		        	  int percent=0;
	    		        	  if(noOfQuestions!=0){
	    		        		  percent=((score*100)/noOfQuestions);
	    		        	  }
	    		        	  Label scoreWidget=new Label(score+"/"+noOfQuestions+" ("+percent+"%)");
	    		        	  adTable.setWidget(i, 1,scoreWidget);
	    		        }
	    			}
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	        } else {
	        	lessonTablePanel.clear();
	        	lessonTablePanel.add(new TeachStudentEmptyDataView());
	        }
	}
	
	public class StudentPlaySummary implements ClickHandler {
		String userId = null, userName = null;
		
		public StudentPlaySummary(String userName, String userId) {
			this.userId = userId;
			this.userName = userName;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			String contentName = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CONTENT_NAME, "");
			TeachStudentReportPopupWidget popup = new TeachStudentReportPopupWidget(contentName,userName,userId, classId, courseId, unitId, lessonId, assessmentId, collectionType, UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW);
		}
	}
	
	public FlowPanel renderAnswersData(JSONArray attemptsObj, String questionType, int noOfAttempts, Map<String, Integer> authorObject){
		FlowPanel timeStamplbl = new FlowPanel();
		//String qType =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		if(MC.equalsIgnoreCase(questionType) ||TF.equalsIgnoreCase(questionType) || TSLASHF.equalsIgnoreCase(questionType)){
			
	
			
			for(int j=0;j<attemptsObj.size();j++){
				Label anserlbl=new Label();
	        	Image answerChoice=new Image();
	        	answerChoice.addStyleName("summaryHsImg");
	            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
	        	String scoreStatus =attemptsObj.get(j).isObject().get("status").isString().stringValue();
	        	String hsImage =attemptsObj.get(j).isObject().get("text").isString().stringValue();
			
				 for (Map.Entry<String, Integer> entry : authorObject.entrySet())
				 {
					 String userSelectedOption=entry.getKey();
					// int ansStatus=entry.getValue();
					 if(userSelectedOption!=null){
							anserlbl.setText(getTextFromHTML(userSelectedOption));
							
							if(collectionType.equalsIgnoreCase("collection"))
							{
								if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts==1){
									anserlbl.getElement().getStyle().setColor(CORRECT);
								}else if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts>1){
									anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
								}else{
									anserlbl.getElement().getStyle().setColor(INCORRECT);
								}
							}
							else
							{
								if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus)){
										anserlbl.getElement().getStyle().setColor(CORRECT);
									}else{
										anserlbl.getElement().getStyle().setColor(INCORRECT);
									}
							}
						}
					 
				 }
					
					anserlbl.setStyleName(STYLE_TABLE_CENTER);
					timeStamplbl.add(anserlbl);

			//adTable.setWidget(i, 2,anserlbl);
			}
		}else if (FIB.equalsIgnoreCase(questionType)){


					for(int j=0;j<attemptsObj.size();j++){
						FlowPanel answerspnl=new FlowPanel();
						Label answerChoice=new Label();
						boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
						String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
						String fibtext =getTextFromHTML(attemptsObj.get(j).isObject().get("text").isString().stringValue());
						if(skip == false)
						{
							answerChoice.setText(fibtext);
							/*if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
								answerChoice.getElement().getStyle().setColor(INCORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
								answerChoice.getElement().getStyle().setColor(CORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
							if(collectionType.equalsIgnoreCase("collection"))
							{
								answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
							}
							else
							{
								answerChoice.getElement().getStyle().setColor(CORRECT);
							}
								
							}*/
						}
						answerChoice.setStyleName(STYLE_TABLE_CENTER);
						answerspnl.add(answerChoice);
						
						answerspnl.setStyleName(STYLE_MARGIN_AUTO);
						timeStamplbl.add(answerspnl);
					}
				

			//adTable.setWidget(i, 2,answerspnl);
			//data.setValue(i, 2, answerspnl.toString());
		}else  if(MA.equalsIgnoreCase(questionType)){

		
					for(int j=0;j<attemptsObj.size();j++){
						FlowPanel answerspnl=new FlowPanel();
						Label answerChoice=new Label();
						String showMessage = null;
						boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
						String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
						String matext =getTextFromHTML(attemptsObj.get(j).isObject().get("text").isString().stringValue());
						if(skip == false)
						{
							if(ZERO_NUMERIC.equalsIgnoreCase(matext)) {
								showMessage = i18n.GL_GRR_NO();
							} else if(ONE.equalsIgnoreCase(matext)) {
								showMessage = i18n.GL_GRR_YES();
							}
							answerChoice.setText(showMessage);
							if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
								answerChoice.getElement().getStyle().setColor(INCORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
								answerChoice.getElement().getStyle().setColor(CORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
								if(collectionType.equalsIgnoreCase("collection"))
								{
									answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
								}
								else
								{
									answerChoice.getElement().getStyle().setColor(CORRECT);
								}
							}
						}
						answerChoice.setStyleName(STYLE_TABLE_CENTER);
						answerspnl.add(answerChoice);
						
						answerspnl.setStyleName(STYLE_MARGIN_AUTO);
						timeStamplbl.add(answerspnl);
					}
				
			

		}else if(HS_IMG.equalsIgnoreCase(questionType)){
			for(int j=0;j<attemptsObj.size();j++){
	        	Label answerChoice=new Label("");
	        	answerChoice.addStyleName("summaryHsImg");
	            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
	        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
	        	String hsImage =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		         if(skip == false)
				  {
					answerChoice.setText(hsImage);
						/*if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
							answerChoice.getElement().getStyle().setBorderColor(INCORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
							answerChoice.getElement().getStyle().setBorderColor(CORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
							answerChoice.getElement().getStyle().setBorderColor(CORRECT);
						}*/
				  }
		         timeStamplbl.add(answerChoice);
	         }
		}else if(questionType.equalsIgnoreCase("HS") || HS_TXT.equalsIgnoreCase(questionType)){
			 for(int j=0;j<attemptsObj.size();j++){
		        	HTML answerChoice=new HTML();
		        	answerChoice.getElement().getStyle().setPadding(5, Unit.PX);
		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
		        	String hsText =attemptsObj.get(j).isObject().get("text").isString().stringValue();
  		         if(skip == false)
					  {
  		     	  String newDatVal =URL.decodeQueryString(hsText).replaceAll("></table>", "</div>");  
	  		     	newDatVal =newDatVal.replaceAll("<table", "<div");
	  		     	newDatVal =newDatVal.replaceAll("></tbody>", "</div>");  
	  		     	newDatVal =newDatVal.replaceAll("<tbody>", "<div>");
	  		     	newDatVal =newDatVal.replaceAll("></tr>", "</div>");  
	  		     	newDatVal =newDatVal.replaceAll("<tr>", "<div>");
	  		     	newDatVal =newDatVal.replaceAll("></td>", "</div>");  
	  		     	newDatVal =newDatVal.replaceAll("<td", "<div");
						answerChoice.setHTML(newDatVal);
							/*if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
								answerChoice.addStyleName(HS_INCORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
								answerChoice.addStyleName(HS_CORRECT);
							} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
								answerChoice.addStyleName(HS_CORRECT);
							}*/
					  }
  		       timeStamplbl.add(answerChoice);
		         }

		}else if(HT_HL.equalsIgnoreCase(questionType)){
			 for(int j=0;j<attemptsObj.size();j++){
		        	HTML answerChoice=new HTML();
		        	answerChoice.getElement().getStyle().setPadding(5, Unit.PX);
		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
		        	String hlText =attemptsObj.get(j).isObject().get("text").isString().stringValue();

  		         if(skip == false)
  		         {
  		        	 if(hlText.contains(PLAYER_HT_HL)){
  		        		 hlText=hlText.replaceAll(PLAYER_HT_HL, SUMMARY_HT_HL);
  		        	 }
  		        	 if(hlText.contains(PLAYER_HT_ANS)){
  		        		 hlText=hlText.replaceAll(PLAYER_HT_ANS, SUMMARY_HTPLAYER_ANS);
  		        	 }
  		        	 if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
  		        		hlText=hlText.replaceAll(CORRECT_WORD, CORRECT_WORD);
  		        	 }
  	  		     	  String newDatVal =URL.decodeQueryString(hlText).replaceAll("></table>", "</div>");  
  	  		     	newDatVal =newDatVal.replaceAll("<table", "<div");
  	  		     	newDatVal =newDatVal.replaceAll("></tbody>", "</div>");  
  	  		     	newDatVal =newDatVal.replaceAll("<tbody>", "<div>");
  	  		     	newDatVal =newDatVal.replaceAll("></tr>", "</div>");  
  	  		     	newDatVal =newDatVal.replaceAll("<tr>", "<div>");
  	  		     	newDatVal =newDatVal.replaceAll("></td>", "</div>");  
  	  		     	newDatVal =newDatVal.replaceAll("<td", "<div");
  		        	 answerChoice.setHTML(newDatVal);
  		         }
  		       timeStamplbl.add(answerChoice);
		         }
		}else if(HT_RO.equalsIgnoreCase(questionType)){
			 for(int j=0;j<attemptsObj.size();j++){
		        	HTML answerChoice=new HTML();
		        	answerChoice.getElement().getStyle().setPadding(5, Unit.PX);
		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
		        	String htROText =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		         if(skip == false)
					  {
 	  		     	  String newDatVal =URL.decodeQueryString(htROText).replaceAll("></table>", "</div>");  
 	  		     	newDatVal =newDatVal.replaceAll("<table", "<div");
 	  		     	newDatVal =newDatVal.replaceAll("></tbody>", "</div>");  
 	  		     	newDatVal =newDatVal.replaceAll("<tbody>", "<div>");
 	  		     	newDatVal =newDatVal.replaceAll("></tr>", "</div>");  
 	  		     	newDatVal =newDatVal.replaceAll("<tr>", "<div>");
 	  		     	newDatVal =newDatVal.replaceAll("></td>", "</div>");  
 	  		     	newDatVal =newDatVal.replaceAll("<td", "<div");
						answerChoice.setHTML(newDatVal);
						if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
							answerChoice.addStyleName(HS_INCORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
							answerChoice.addStyleName(HS_CORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
							answerChoice.addStyleName(HS_CORRECT);
						}
					  }
		         timeStamplbl.add(answerChoice);
		         }
		}else if(OE.equalsIgnoreCase(questionType)){
			 for(int j=0;j<attemptsObj.size();j++){
		        	HTML answerChoice=new HTML();
		        	answerChoice.getElement().getStyle().setPadding(5, Unit.PX);
		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
		        	String OeAnswer =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		         if(skip == false)
					  {
		        	 	AppClientFactory.printInfoLogger("OeAnswer : "+OeAnswer);
		        	 	  String newDatVal =URL.decodeQueryString(OeAnswer).replaceAll("></table>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<table", "<div");
		 	  		     	newDatVal =newDatVal.replaceAll("></tbody>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<tbody>", "<div>");
		 	  		     	newDatVal =newDatVal.replaceAll("></tr>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<tr>", "<div>");
		 	  		     	newDatVal =newDatVal.replaceAll("></td>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<td", "<div");
						answerChoice.setHTML(newDatVal);
						/*if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
							answerChoice.addStyleName(HS_INCORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
							answerChoice.addStyleName(HS_CORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
							answerChoice.addStyleName(HS_ONMULTIPULEATTEMPTS);
						}*/
					  }
		         timeStamplbl.add(answerChoice);
		        }
		}

		return timeStamplbl;
	}
	
	public FlowPanel renderAnswersDataOE(JSONArray attemptsObj, String questionType, int noOfAttempts, Map<String, Integer> authorObject){
		FlowPanel timeStamplbl = new FlowPanel();
		//String qType =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		if(OE.equalsIgnoreCase(questionType)){
			 for(int j=0;j<attemptsObj.size();j++){
		        	HTML answerChoice=new HTML();
		        	answerChoice.getElement().getStyle().setPadding(5, Unit.PX);
		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
		        	String OeAnswer =attemptsObj.get(j).isObject().get("text").isString().stringValue();
		         if(skip == false)
					  {
		        	 	AppClientFactory.printInfoLogger("OeAnswer : "+OeAnswer);
		        	 	  String newDatVal =URL.decodeQueryString(OeAnswer).replaceAll("></table>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<table", "<div");
		 	  		     	newDatVal =newDatVal.replaceAll("></tbody>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<tbody>", "<div>");
		 	  		     	newDatVal =newDatVal.replaceAll("></tr>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<tr>", "<div>");
		 	  		     	newDatVal =newDatVal.replaceAll("></td>", "</div>");  
		 	  		     	newDatVal =newDatVal.replaceAll("<td", "<div");
						answerChoice.setHTML(newDatVal);
						/*if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
							answerChoice.addStyleName(HS_INCORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
							answerChoice.addStyleName(HS_CORRECT);
						} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
							answerChoice.addStyleName(HS_ONMULTIPULEATTEMPTS);
						}*/
					  }
		         timeStamplbl.add(answerChoice);
		        }
		}

		return timeStamplbl;
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		lessonTablePanel.getElement().getParentElement().setAttribute("style", "min-height:"+(Window.getClientHeight()+Window.getScrollTop()-100)+"px");
	}
	
	private String getTextFromHTML(String html){
		html = html.replaceAll("\\+", "%2B");
		html = URL.decodeQueryString(html);
		return html;
	}

}