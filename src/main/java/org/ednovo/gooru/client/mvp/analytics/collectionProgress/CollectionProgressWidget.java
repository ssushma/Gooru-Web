package org.ednovo.gooru.client.mvp.analytics.collectionProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.analytics.util.DataView;
import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;

import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;

public class CollectionProgressWidget extends BaseViewWithHandlers<CollectionProgressUiHandlers> implements IsCollectionProgressView  {

	private static CollectionProgressWidgetUiBinder uiBinder = GWT
			.create(CollectionProgressWidgetUiBinder.class);

	interface CollectionProgressWidgetUiBinder extends
			UiBinder<Widget, CollectionProgressWidget> {
	}
	@UiField(provided = true)
	CollectionProgressCBundle res;
	
	@UiField VerticalPanel htmlpnlProgress;
	@UiField ListBox filterDropDown;
	@UiField HTMLPanel scrollForCollectionProgress;
	
	DataView operationsView;
	private final String GREEN = "#BCD1B9 !important";
	private final String RED = "#EAB4B3 !important";
	private final String ORANGE = "#FFE7C2 !important";
	private final String WHITE = "#FFF";
	
	private int collectionProgressCount=1;
	
	public CollectionProgressWidget() {
		this.res=CollectionProgressCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));	
		scrollForCollectionProgress.getElement().setId("scrollForCollectionProgress");
	}
	@Override
	public void setData(ArrayList<CollectionProgressDataDo> collectionProgressData){
		final List<Integer> questionColumnIndex=new ArrayList<Integer>();
		final List<Integer> resourceColumnIndex=new ArrayList<Integer>();
		collectionProgressCount=1;
		int noOfQuestions=0;
		htmlpnlProgress.clear();
		filterDropDown.clear();
		CollectionProgressDataDo defaultUserDataForUsers=null;
		final DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Name");
		data.addColumn(ColumnType.STRING, "Score");
		for (CollectionProgressDataDo collectionProgressDataDo : collectionProgressData) {
			defaultUserDataForUsers=collectionProgressDataDo;
			if(collectionProgressDataDo.getCategory().equalsIgnoreCase("question")){
				 data.addColumn(ColumnType.STRING, "Question&nbsp;"+collectionProgressCount,"question");
				 noOfQuestions++;
				 questionColumnIndex.add(collectionProgressCount+1);
			}else{
				 data.addColumn(ColumnType.STRING, "Resource&nbsp;"+collectionProgressCount,"resource");
				 resourceColumnIndex.add(collectionProgressCount+1);
			}
			collectionProgressCount++;
		}
		final int[] primitivesQuestions = AnalyticsUtil.toIntArray(questionColumnIndex);
		final int[] primitivesResources = AnalyticsUtil.toIntArray(resourceColumnIndex);
		
		if(defaultUserDataForUsers!=null){
			int sizeNames=defaultUserDataForUsers.getUserData().size();
			if(sizeNames!=0){
				data.addRows(sizeNames);
			}
	        int columnsSize=collectionProgressData.size();
	        for(int i=0;i<sizeNames;i++) {
	        	  int score=0;
	        	  for(int j=0;j<columnsSize;j++) {
	        		  	  String color=WHITE;
	        		  	  VerticalPanel mainDataVpnl=new VerticalPanel();
		        		  if(!collectionProgressData.get(j).getCategory().equalsIgnoreCase("question")){
		        			  int reaction=collectionProgressData.get(j).getUserData().get(i).getReaction();
		        			  Label reactionlbl=new Label();
				        		 if(reaction == 0){
				        			 reactionlbl.setText("--");
				        		 }else{
				        			  String customClass=res.css().reaction_redneedhelp();
					        		  if (reaction==1) {
										  customClass = res.css().reaction_redneedhelp();
									  } else if (reaction==2) {
										  customClass = res.css().reaction_reddontunderstand();
									  } else if (reaction==3) {
										  customClass =res.css().reaction_mean1();
									  } else if (reaction==4) {
										  customClass = res.css().reaction_understand1();
									  }else if (reaction>4) {
										  customClass = res.css().reaction_explain1();
									  }
					        		  reactionlbl.addStyleName(customClass);
				        		 }
			        		  mainDataVpnl.add(reactionlbl);
			        		  reactionlbl.getElement().getParentElement().addClassName(res.css().alignCenterAndBackground());
		        		  }else{
		        			  String typeOfQuestion=collectionProgressData.get(j).getType();
		        			  String answerOption=collectionProgressData.get(j).getUserData().get(i).getOptions();
		        			  String answer="";
		        			  int attemptCount=collectionProgressData.get(j).getUserData().get(i).getAttempts();
		        			  if(typeOfQuestion.equalsIgnoreCase("MA") || typeOfQuestion.equalsIgnoreCase("FIB") || typeOfQuestion.equalsIgnoreCase("OE")){
		        				  Label viewResponselbl=new Label();
				        		  mainDataVpnl.add(viewResponselbl);
		        				  String answerText="--";
		        				  if(answerOption!=null){
					        		  answerText="View Response";
					        		  viewResponselbl.getElement().getParentElement().addClassName(res.css().viewResponseInCollectionProgress());
		        				  }else{
		        					  answerText="--";
		        					  viewResponselbl.getElement().getParentElement().getStyle().setBackgroundColor(WHITE);
		        				  }
		        				  viewResponselbl.getElement().setPropertyString("id", "name of the response");
		        				  viewResponselbl.setText(answerText);
		        			  }else{
		        				  String answerText="";
				        		  if(answerOption!=null){
				        			  JSONValue value = JSONParser.parseStrict(answerOption);
					        		  JSONObject optionObj = value.isObject();
					        		  Set<String> keys=optionObj.keySet();
					        		  if(keys.iterator().hasNext())
					        			  answer= keys.iterator().next().toString();
					        		  
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
				        		  answerlbl.getElement().getParentElement().addClassName(res.css().alignCenterAndBackground());
		        			  }
		        			  if(answerOption!=null && collectionProgressData.get(j).getMetaData()!=null){
		        					int scoreValue=collectionProgressData.get(j).getUserData().get(i).getScore();
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
		        						 color=RED;
		        					 }
		        			  }
		        		  }
		        		  Label timeStamplbl=new Label(getTimeSpent(collectionProgressData.get(j).getUserData().get(i).getTimeSpent()));
		        		  mainDataVpnl.add(timeStamplbl);
		        		  timeStamplbl.getElement().getParentElement().addClassName(res.css().alignCenterAndBackground());
		        		  Properties properties=Properties.create();
		        		  properties.set("style", "background-color: "+color);
		        		  com.google.gwt.visualization.client.Properties p=properties.cast();
		        		  mainDataVpnl.addStyleName(res.css().mainDataVpnl());
		        		  data.setCell(i, j+2,mainDataVpnl.toString(),null,p);
	        	   }
	        	  data.setValue(i, 0,defaultUserDataForUsers.getUserData().get(i).getUserName());
	        	  VerticalPanel scoreWidget=new VerticalPanel();
	        	  Label noOfQuestionAttened=new Label(score+"/"+noOfQuestions);
	        	  int percent=0;
	        	  if(noOfQuestions!=0){
	        		  percent=((score*100)/noOfQuestions);
	        	  }
	        	  Label percentage=new Label("("+percent+"%)");
	        	  scoreWidget.add(noOfQuestionAttened);
	        	  scoreWidget.add(percentage);
	        	  data.setValue(i, 1,scoreWidget.toString());
	        }
		}
		
        final Options options = Options.create();
        options.setAllowHtml(true);
        
        final DataView view =DataView.create(data);
        
        final Table table = new Table(view, options);
        table.setStyleName("collectionProgressTable");
     
        filterDropDown.addItem("All", "All");
        filterDropDown.addItem("Questions", "Questions");
        filterDropDown.addItem("Resources", "Resources");
        filterDropDown.addChangeHandler(new ChangeHandler() {
		
			@Override
			public void onChange(ChangeEvent event) {
					htmlpnlProgress.clear();
					int selectedIndex=filterDropDown.getSelectedIndex();
				 	operationsView=DataView.create(data);
					 if(selectedIndex==1){
						 operationsView.hideColumns(primitivesResources); 
					 }
					 if(selectedIndex==2){
						 operationsView.hideColumns(primitivesQuestions); 
					 }
					 Table table = new Table(operationsView, options);
				     table.setStyleName("collectionProgressTable");
				     htmlpnlProgress.add(table);	
				     table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
			}
		});
        table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
        htmlpnlProgress.add(table);	
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
				createdTime=createdTime+hours+":";
			}else{
				createdTime=hours+":";
			}
		}
		if(minutes!=0){
			if(createdTime!=null){
				createdTime=createdTime+((minutes<10)?"0"+minutes:minutes)+":";
			}else{
				createdTime=((minutes<10)?"0"+minutes:minutes)+":";
			}
		}
		if(seconds!=0){
			if(createdTime!=null){
				createdTime=createdTime+((seconds<10)?"0"+seconds:seconds)+"";
			}else{
				createdTime="00"+":"+((seconds<10)?"0"+seconds:seconds)+"";
			}
		}
		return createdTime;
	}
}
