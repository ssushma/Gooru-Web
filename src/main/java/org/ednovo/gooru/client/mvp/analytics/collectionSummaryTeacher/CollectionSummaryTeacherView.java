package org.ednovo.gooru.client.mvp.analytics.collectionSummaryTeacher;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.HCBarChart;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsTabContainer;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.analytics.util.DataView;
import org.ednovo.gooru.client.mvp.analytics.util.Print;
import org.ednovo.gooru.client.mvp.analytics.util.SortTable;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.MetaDataDo;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;
//newly added 
public class CollectionSummaryTeacherView  extends BaseViewWithHandlers<CollectionSummaryTeacherUiHandlers> implements IsCollectionSummaryTeacherView  {

	private static CollectionSummaryTeacherViewUiBinder uiBinder = GWT
			.create(CollectionSummaryTeacherViewUiBinder.class);

	interface CollectionSummaryTeacherViewUiBinder extends
			UiBinder<Widget, CollectionSummaryTeacherView> {
	}

	@UiField HTMLPanel totalAvgReactionlbl,hiddenChartPnl,tabContainer,teacherScoredData,teacherScoredDatapnl,teacherOpenendedData,teacherResourceBreakdownData,teacherResourceBreakdownDatapnl;
	@UiField ListBox filterDropDown;
	@UiField Label totalTimeSpentlbl,totalViewlbl;
	
	
	AnalyticsTabContainer teacherTabContainer;
	
	CollectionSummaryTeacherCBundle res;
	ArrayList<CollectionSummaryMetaDataDo> collectionMetaData;
	
	final String SCORED="scoredTab",OPENENDED="openendedTab",BREAKDOWN="breakdownTab";
	private int collectionProgressCount=1;
	
	
	ArrayList<UserDataDo> questionsData=new ArrayList<UserDataDo>();
	ArrayList<UserDataDo> openendedData=new ArrayList<UserDataDo>();
	
	final List<Integer> questionRowIndex=new ArrayList<Integer>();
	final List<Integer> resourceRowIndex=new ArrayList<Integer>();
	DataView operationsView;
	
	public CollectionSummaryTeacherView() {
		this.res = CollectionSummaryTeacherCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	
	void hideAllPanels(){
		teacherScoredDatapnl.setVisible(false);
		teacherOpenendedData.setVisible(false);
		teacherResourceBreakdownDatapnl.setVisible(false);
	}
	void setData(){
		teacherTabContainer=new AnalyticsTabContainer() {
			@Override
			public void onTabClick(String tabClicked) {
				if(tabClicked.equalsIgnoreCase(SCORED)){
					hideAllPanels();
					teacherScoredDatapnl.setVisible(true);
				}else if(tabClicked.equalsIgnoreCase(OPENENDED)){
					hideAllPanels();
					teacherOpenendedData.setVisible(true);
				}else if(tabClicked.equalsIgnoreCase(BREAKDOWN)){
					hideAllPanels();
					teacherResourceBreakdownDatapnl.setVisible(true);
				}else{
					 Element element = DOM.getElementById("collectionBreakDown");
					 Print.it(teacherScoredDatapnl.getElement());
				}
			}
		};
		tabContainer.add(teacherTabContainer);
		filterDropDown.clear();
        filterDropDown.addItem("All", "All");
        filterDropDown.addItem("Questions", "Questions");
        filterDropDown.addItem("Resources", "Resources");
	}
	@Override
	public void setTeacherResourceData(ArrayList<UserDataDo> resourcesData,ArrayList<CollectionSummaryMetaDataDo> collectionMetaData) {
		    hideAllPanels();
		    teacherScoredDatapnl.setVisible(true);
		    this.collectionMetaData=collectionMetaData;
		    teacherScoredData.clear();
			teacherOpenendedData.clear();
			teacherResourceBreakdownData.clear();
			questionsData.clear();
			openendedData.clear();

			collectionProgressCount=0;
			questionRowIndex.clear();
			resourceRowIndex.clear();
			//Set collection meta data
			if(collectionMetaData != null)
			{
			totalTimeSpentlbl.setText(getTimeSpent(collectionMetaData.get(0).getAvgTimeSpent()));
			totalViewlbl.setText(Integer.toString(collectionMetaData.get(0).getViews()));
			totalAvgReactionlbl.clear();
			totalAvgReactionlbl.add(new AnalyticsReactionWidget(collectionMetaData.get(0).getAvgReaction()));
			}
			
	        //This is used for segrate data based on the category
	        for (UserDataDo userDataDo : resourcesData) {
				if(userDataDo.getCategory().equalsIgnoreCase("question")){
					if(userDataDo.getType().equalsIgnoreCase("OE")){
							openendedData.add(userDataDo);
					}else{
						questionsData.add(userDataDo);
					}
					questionRowIndex.add(collectionProgressCount);
				}else{
					resourceRowIndex.add(collectionProgressCount);
				}
				collectionProgressCount++;
	        }
	    	setScoredQuestionsData(questionsData);
	    	setOpenendedQuestionsData(openendedData);
	    	setCollectionBreakDown(resourcesData);
	}
	void setOpenendedQuestionsData(final ArrayList<UserDataDo> result){
            
		 	int totalUserCount=this.collectionMetaData.get(0).getUserCount();
		    DataTable data = DataTable.create();
		    data.addColumn(ColumnType.NUMBER, "No.");
	        data.addColumn(ColumnType.STRING, "Question");
	        data.addColumn(ColumnType.STRING, "Completion");
	        data.addColumn(ColumnType.STRING, "Time&nbsp;Spent");
	        data.addColumn(ColumnType.STRING, "Reaction");
	        data.addColumn(ColumnType.STRING, "Student&nbsp;Responses");
	        data.addRows(result.size());
	        for(int i=0;i<result.size();i++) {
	        	data.setCell(i, 0, i+1, null, getPropertiesCell());
	        	
	            //Set Question Title
	            Label questionTitle=new Label( AnalyticsUtil.html2text(result.get(i).getTitle()));
	            questionTitle.setStyleName(res.css().alignCenterAndBackground());
	            data.setValue(i, 1, questionTitle.toString());
	          
	            //Set completion
	            HTMLPanel completionpnl=new HTMLPanel("");
	            Label progressBar=new Label();
	            progressBar.setStyleName(res.css().setProgressBar());
	            completionpnl.add(progressBar);
	            Label incompleteProgressBar=new Label();
	            incompleteProgressBar.setStyleName(res.css().setIncorrectProgressBar());
	            completionpnl.add(incompleteProgressBar);
	            int attemptedCount=result.get(i).getTotalAttemptUserCount();
	            float maxAvgVal = ((float) attemptedCount)/((float) totalUserCount);
	            progressBar.getElement().getStyle().setWidth(maxAvgVal*100, Unit.PX);
	            incompleteProgressBar.getElement().getStyle().setWidth((100-maxAvgVal*100), Unit.PX);
	            Label studentTextlbl=new Label(attemptedCount+"/"+totalUserCount+" Students");
	            studentTextlbl.setStyleName(res.css().alignCenterAndBackground());
	            studentTextlbl.getElement().getStyle().setWidth(100, Unit.PX);
	            completionpnl.add(studentTextlbl);
	            data.setValue(i, 2, completionpnl.toString());
	          
	            //Set time spent
	            data.setValue(i, 3, getTimeStampLabel(result.get(i).getAvgTimeSpent()).toString());
	           
	            //Set reactions
	            int reaction=result.get(i).getAvgReaction();
	            HTMLPanel reactionpnl=new HTMLPanel("");
	            reactionpnl.add(new AnalyticsReactionWidget(reaction));
	            Label reactioncount=new Label();
	            reactionpnl.add(reactioncount);
	            reactioncount.setText(reaction+"/5");
	            reactioncount.setStyleName(res.css().alignCenterAndBackground());
	            data.setValue(i, 4, reactionpnl.toString());
	           
	            //set View response label
	            Label viewResponselbl=new Label("View Response");
	            viewResponselbl.setStyleName(res.css().viewResponseTextOpended());
	            data.setValue(i, 5, viewResponselbl.toString());
	        }
	        Options options = Options.create();
	        options.setAllowHtml(true);
	        final Table table = new Table(data, options);
	        table.getElement().setId("opendedData");
	        teacherOpenendedData.add(table);
	        table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
	}
	/**
	 * This class is used to handle the click event on the table cell
	 */
	class ClickOnTableCell implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Element ele=event.getNativeEvent().getEventTarget().cast();
			if(ele.getInnerText().equalsIgnoreCase("View Response")){
				//Window.alert("ele:"+ele.getAttribute("id"));
			}
		}
	}
	void setCollectionBreakDown(ArrayList<UserDataDo> result){
		
		final int[] primitivesQuestions = AnalyticsUtil.toIntArray(questionRowIndex);
		final int[] primitivesResources = AnalyticsUtil.toIntArray(resourceRowIndex);
		
			UserDataDo maxAvgValue=Collections.max(result,new Comparator<UserDataDo>() {
	        	public int compare(UserDataDo o1, UserDataDo o2) {
	        		 Long obj1 = new Long(o1.getTimeSpent());
	        	     Long obj2 = new Long(o2.getTimeSpent());
	        	     return obj1.compareTo(obj2);
	        	}
	        });
	        UserDataDo maxViews=Collections.max(result,new Comparator<UserDataDo>() {
	        	public int compare(UserDataDo o1, UserDataDo o2) {
	        		 Integer obj1 = new Integer(o1.getViews());
	        		 Integer obj2 = new Integer(o2.getViews());
	        	     return obj1.compareTo(obj2);
	        	}
	        });
		    final DataTable data = DataTable.create();
		    data.addColumn(ColumnType.NUMBER, "No.");
	        data.addColumn(ColumnType.STRING, "Format");
	        data.addColumn(ColumnType.STRING, "Title");
	        data.addColumn(ColumnType.STRING, "Avg.Time&nbsp;Spent");
	        data.addColumn(ColumnType.STRING, "Views");
	        data.addColumn(ColumnType.STRING, "Reaction");
	        data.addRows(result.size());
	        
	        for(int i=0;i<result.size();i++) {
	        	data.setCell(i, 0, i+1, null, getPropertiesCell());
	            //set Format
	              String  resourceCategory =result.get(i).getCategory();
	              String categoryStyle="";
				  if(resourceCategory.equalsIgnoreCase("website")){
				      resourceCategory = "webpage";
				      categoryStyle=res.css().category_new_type_webpage();
				  } else if(resourceCategory.equalsIgnoreCase("slide")){
				      resourceCategory = "image";
				      categoryStyle=res.css().category_new_type_image();
				  } else if(resourceCategory.equalsIgnoreCase("handout") || resourceCategory.equalsIgnoreCase("lesson") || resourceCategory.equalsIgnoreCase("textbook")) {
				      resourceCategory = "text";
				      categoryStyle=res.css().category_new_type_text();
				  }  else if(resourceCategory.equalsIgnoreCase("exam")) {
				      resourceCategory = "webpage";
				      categoryStyle=res.css().category_new_type_webpage();
				  } else if(resourceCategory.equalsIgnoreCase("video")) {
				      resourceCategory = "webpage";
				      categoryStyle=res.css().category_new_type_video();
				  } else if(resourceCategory.equalsIgnoreCase("interactive")) {
				      resourceCategory = "webpage";
				      categoryStyle=res.css().category_new_type_interactive();
				  } else{
					  categoryStyle=res.css().category_new_type_other();
				  }
	            Label categorylbl=new Label();
	            categorylbl.addStyleName(categoryStyle);
	            categorylbl.addStyleName(res.css().setMarginAuto());
	            data.setValue(i, 1,categorylbl.toString());
	            
	            //Set Question Title
	            Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
	            questionTitle.setStyleName(res.css().alignCenterAndBackground());
	            data.setValue(i, 2, questionTitle.toString());
	          
	           //Set time spent
	            HorizontalPanel timeSpentpnl=new HorizontalPanel();
	            timeSpentpnl.add(getTimeStampLabel(result.get(i).getAvgTimeSpent()));
	            Label progressBar=new Label();
	            progressBar.setStyleName(res.css().setProgressBar());
	            timeSpentpnl.add(progressBar);
	            double maxAvgVal = ((double) result.get(i).getAvgTimeSpent())/((double) maxAvgValue.getTimeSpent());
	            progressBar.getElement().getStyle().setWidth(maxAvgVal*100, Unit.PX);
	            data.setValue(i, 3, timeSpentpnl.toString());
	           
	            //set Views label
	            HorizontalPanel viewpnl=new HorizontalPanel();
	            Label viewlbl=new Label(Integer.toString(result.get(i).getViews()));
	            viewlbl.setStyleName(res.css().alignCenterAndBackground());
	            viewpnl.add(viewlbl);
	            Label viewProgressBar=new Label();
	            viewProgressBar.setStyleName(res.css().setProgressBar());
	            viewpnl.add(viewProgressBar);
	            float maxViewVal = ((float) result.get(i).getViews())/((float) maxViews.getViews());
	            viewProgressBar.getElement().getStyle().setWidth(maxViewVal*100, Unit.PX);
	            data.setValue(i, 4, viewpnl.toString());
	            
	            //Set reactions
	            int reaction=result.get(i).getAvgReaction();
	            HTMLPanel reactionpnl=new HTMLPanel("");
	            reactionpnl.add( new AnalyticsReactionWidget(reaction));
	            Label reactioncount=new Label();
	            reactionpnl.add(reactioncount);
	            reactioncount.setText(reaction+"/5");
	            reactioncount.setStyleName(res.css().alignCenterAndBackground());
	            data.setValue(i, 5, reactionpnl.toString());
	        }
	        final Options options = Options.create();
	        options.setAllowHtml(true);
	        Table table = new Table(data, options);
	        table.getElement().setId("collectionBreakDown");
	        teacherResourceBreakdownData.add(table);
	        filterDropDown.addChangeHandler(new ChangeHandler() {
	    		
				@Override
				public void onChange(ChangeEvent event) {
					    teacherResourceBreakdownData.clear();
						int selectedIndex=filterDropDown.getSelectedIndex();
					 	operationsView=DataView.create(data);
						 if(selectedIndex==1){
							 operationsView.hideRows(primitivesResources); 
						 }
						 if(selectedIndex==2){
							 operationsView.hideRows(primitivesQuestions); 
						 }
						 Table table = new Table(operationsView, options);
					     table.setStyleName("collectionProgressTable");
					     table.getElement().setId("collectionBreakDown");
					     teacherResourceBreakdownData.add(table);	
					     table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
				}
			});
	}
	void setScoredQuestionsData(final ArrayList<UserDataDo> scoredQuestionsData){

		teacherScoredData.clear();
		
        final SortTable sortableTable = new SortTable();
        sortableTable.setStyleName(res.css().tableMain());
        sortableTable.getElement().setId("results");
        sortableTable.setBorderWidth(1);
        sortableTable.setCellPadding(4);
        sortableTable.setCellSpacing(1);
        sortableTable.setWidth("800");
        sortableTable.addColumnHeader("No.",  0);
        sortableTable.addColumnHeader("Question", 1);
        sortableTable.addColumnHeader("#Correct", 2);
        sortableTable.addColumnHeader("Answer&nbsp;Breakdown", 3);
        sortableTable.addColumnHeader("Time&nbsp;Spent", 4);
        sortableTable.addColumnHeader("Reaction", 5);
        sortableTable.getRowFormatter().addStyleName(0, res.css().tableHeader());
        sortableTable.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			 Collections.sort(scoredQuestionsData, new Comparator<UserDataDo>() {
	        	public int compare(UserDataDo o1, UserDataDo o2) {
	        		 String obj1 = new String(o1.getTitle());
	        		 String obj2 = new String(o2.getTitle());
	        	     return obj1.compareTo(obj2);
	        	}
			 });
			 sortableTable.clear();
			 setSortedData(scoredQuestionsData,sortableTable);
			}
		});
        setSortedData(scoredQuestionsData,sortableTable);
	    teacherScoredData.add(sortableTable);
	}
	void setSortedData(ArrayList<UserDataDo> scoredQuestionsData,SortTable sortableTable){
		 for(int i=1;i<=scoredQuestionsData.size();i++){
        	 sortableTable.setValue(i, 0,i);
             sortableTable.setValue(i, 1, AnalyticsUtil.html2text(scoredQuestionsData.get(i-1).getTitle()));
             
             VerticalPanel answerBreakDownpnl=new VerticalPanel();
             if(scoredQuestionsData.get(i-1).getType()!=null){
            	  String getQuestionType=scoredQuestionsData.get(i-1).getType();
                  if(getQuestionType.equalsIgnoreCase("MC") || getQuestionType.equalsIgnoreCase("TF")){
                 		if((scoredQuestionsData.get(i-1).getMetaData() !=null) && (scoredQuestionsData.get(i-1).getMetaData().size() != 0)) {
                 			int metaDataSize=scoredQuestionsData.get(i-1).getMetaData().size();
                 			int totalcount=scoredQuestionsData.get(i-1).getAttempts();
                 			
                 			for(int j=0;j<metaDataSize;j++){
                 				     MetaDataDo metaData=scoredQuestionsData.get(i-1).getMetaData().get(j);
                 	            	 HorizontalPanel datagrap=new HorizontalPanel();
                 	            	 Label tickmarklbl=new Label();
                 	            	 tickmarklbl.setStyleName(res.css().tickMarkImgCss());
                 	            	 datagrap.add(tickmarklbl);
                 	            	 String questionSequence= AnalyticsUtil.getCharForNumber(metaData.getSequence()-1);
                 	            	 int attemptCount=0;
                 	            	 Label sequenceCharlbl=new Label(questionSequence+")");
                 	            	 sequenceCharlbl.setStyleName(res.css().barGraphCharacter());
                 	            	 datagrap.add(sequenceCharlbl);
                 	            	 if(scoredQuestionsData.get(i-1).getOptions()!=null){
                  	        			 JSONValue value = JSONParser.parseStrict(scoredQuestionsData.get(i-1).getOptions());
                  	        			 JSONObject authorObject = value.isObject();
   	               	        			 if(authorObject.keySet().size()!=0 && authorObject.get(questionSequence)!=null){
   	               	        				attemptCount = (int)authorObject.get(questionSequence).isArray().get(0).isNumber().doubleValue();
   	               	        			 }
                    	             }
                 	            	
                 	            	 Label progressBarlbl=new Label("");
                 	            	 if(metaData.getIs_correct()==1){
                 	            		tickmarklbl.addStyleName(res.css().tickMarkImg());
                 	            		progressBarlbl.addStyleName(res.css().assignment_quesiton_ans_bar()); 
                 	            	 }else{
                 	            		progressBarlbl.addStyleName(res.css().wrongSelectStyle());
                 	            	 }
                 	            	 float setWidth=((float)attemptCount/(float)totalcount)*100;
                 	            	 setWidth=(setWidth==0.0?1:setWidth);
                 	            	 progressBarlbl.getElement().getStyle().setWidth(setWidth, Unit.PX);
                 	            	 datagrap.add(progressBarlbl);
                 	            	 
                 	            	 Label countlbl=new Label("("+attemptCount+")");
                 	            	 datagrap.add(countlbl);
                 	            	 answerBreakDownpnl.add(datagrap);
                 		}
                  } 
             }else if(getQuestionType.equalsIgnoreCase("OE")|| getQuestionType.equalsIgnoreCase("fib") ||getQuestionType.equalsIgnoreCase("MA")){
            	 Label viewResponselbl=new Label("View Response");
 	             viewResponselbl.setStyleName(res.css().viewResponseTextOpended());
            	 answerBreakDownpnl.add(viewResponselbl);
             }
           
             sortableTable.setWidget(i, 3, answerBreakDownpnl);
             sortableTable.setValue(i, 4,getTimeStampLabel(scoredQuestionsData.get(i-1).getAvgTimeSpent()).getText());
             sortableTable.setWidget(i, 5,new AnalyticsReactionWidget(scoredQuestionsData.get(i-1).getAvgReaction()));
             
                int[] pieChatValues=new int[3];
	            pieChatValues[0]=scoredQuestionsData.get(i-1).getTotalInCorrectCount();
	            pieChatValues[1]=scoredQuestionsData.get(i-1).getTotalCorrectCount();
	            pieChatValues[2]=scoredQuestionsData.get(i-1).getSkip();
             
             //set row style
             if ( i % 2 == 0 ){
            	 sortableTable.getRowFormatter().addStyleName(i, res.css().tableRowOdd());
            	 sortableTable.setWidget(i, 2, new HCBarChart().pieChart("#fafafa",pieChatValues));
             }else{
            	 sortableTable.getRowFormatter().addStyleName(i, res.css().tableRowEven());
            	 sortableTable.setWidget(i, 2, new HCBarChart().pieChart("#fff",pieChatValues));
	            }
	        }
		}
	}
	com.google.gwt.visualization.client.Properties getPropertiesCell(){
		  Properties properties=Properties.create();
		  properties.set("style", "text-align:center;");
		  com.google.gwt.visualization.client.Properties p=properties.cast();
		  return p;
	}
	Label getTimeStampLabel(long timeSpent){
		 Label timeStamplbl=new Label(getTimeSpent(timeSpent));
         timeStamplbl.setStyleName(res.css().alignCenterAndBackground());
         return timeStamplbl;
	}
	/**
	 * This is used to convert long time format
	 * @param commentCreatedTime
	 * @return
	 */
	private String getTimeSpent(Long commentCreatedTime) {
		String createdTime = null;
		int seconds = (int) (commentCreatedTime / 1000) % 60 ;
		int minutes = (int) ((commentCreatedTime / (1000*60)) % 60);
		int hours   = (int) ((commentCreatedTime / (1000*60*60)) % 24);
		int days = (int) (commentCreatedTime / (1000*60*60*24));
		if(days!=0){
			createdTime=days+":";
		}
		if(hours!=0){
			if(createdTime!=null){
				createdTime=createdTime+hours+" ";
			}else{
				createdTime=hours+" ";
			}
		}
		if(minutes!=0){
			if(createdTime!=null){
				createdTime=createdTime+((minutes<10)?"0"+minutes+"min":minutes+"min")+" ";
			}else{
				createdTime=((minutes<10)?"0"+minutes+"min":minutes+"min")+" ";
			}
		}
		if(seconds!=0){
			if(createdTime!=null){
				createdTime=createdTime+((seconds<10)?"0"+seconds+"sec":seconds+"sec")+"";
			}else{
				createdTime="0min"+" "+((seconds<10)?"0"+seconds+"sec":seconds+"sec")+"";
			}
		}
		return createdTime;
	}
}
