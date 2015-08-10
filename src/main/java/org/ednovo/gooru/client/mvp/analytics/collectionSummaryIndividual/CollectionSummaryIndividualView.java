package org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.MetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.OetextDataDO;
import org.ednovo.gooru.application.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.application.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.mvp.analytics.collectionSummary.CollectionSummaryWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsTabContainer;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.analytics.util.DataView;
import org.ednovo.gooru.client.mvp.analytics.util.Print;
import org.ednovo.gooru.client.mvp.analytics.util.ViewResponsesPopup;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.InfoUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Clear;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;

public class CollectionSummaryIndividualView  extends BaseViewWithHandlers<CollectionSummaryIndividualUiHandlers> implements IsCollectionSummaryIndividualView,ClientConstants  {

	private static CollectionSummaryIndividualViewUiBinder uiBinder = GWT
			.create(CollectionSummaryIndividualViewUiBinder.class);

	interface CollectionSummaryIndividualViewUiBinder extends
			UiBinder<Widget, CollectionSummaryIndividualView> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField HTMLPanel maincontainer,printWidget,totalAvgReactionlbl,tabContainer,individualScoredData,individualOpenendedData,individualScoredDatapnl,individualResourceBreakdownDatapnl,individualResourceBreakdownData, panelOverview;
	@UiField ListBox filterDropDown;
	@UiField Label noErrorMesage,lblCollectionOverview,lblTotalTimeSpent,lblViews,lblAvgReaction,totalTimeSpentlbl,totalViewlbl,userInfo;
	@UiField Frame downloadFile;

	AnalyticsTabContainer individualTabContainer;
	DataView operationsView;
	CollectionSummaryIndividualCBundle res;
	private int collectionProgressCount=1;
	ViewResponsesPopup popupPanel=null;

	final List<Integer> questionRowIndex=new ArrayList<Integer>();
	final List<Integer> resourceRowIndex=new ArrayList<Integer>();

	ArrayList<UserDataDo> questionsData=new ArrayList<UserDataDo>();
	ArrayList<UserDataDo> openendedData=new ArrayList<UserDataDo>();
	EmailPopup emailPopup=null;
	String collectionTitle=null;

	//Used for print
	HTMLPanel printScoredData=new HTMLPanel("");
	HTMLPanel printOpendedData=new HTMLPanel("");
	HTMLPanel printResourceData=new HTMLPanel("");

	CollectionOverViewWidget collectionOverViewWidget=new CollectionOverViewWidget();
	CollectionSummaryWidget collectionSummaryWidget=new CollectionSummaryWidget();

	String style="";
	String urlDomain = "";

	/**
	 * Constructor
	 */
	public CollectionSummaryIndividualView() {
		this.res = CollectionSummaryIndividualCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		urlDomain=Window.Location.getProtocol()+"//"+Window.Location.getHost();
		style="<link rel='styleSheet' type='text/css' href='"+urlDomain+"/css/googleVisualization.css'><link href='"+urlDomain+"/css/printAnalytics.css' rel='stylesheet' type='text/css'>";
		setData();
		setStaticData();
		noErrorMesage.setVisible(false);
		maincontainer.setVisible(false);
		downloadFile.setVisible(false);
	}
	/**
	 * This method is used to set static data.
	 */
	void setStaticData(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {
				userInfo.setVisible(false);
				panelOverview.setVisible(false);
				StringUtil.setAttributes(printWidget.getElement(), "pnlPrintWidget", null, null);
				StringUtil.setAttributes(totalAvgReactionlbl.getElement(), "pnlTotalAvgReactionlbl", null, null);
				StringUtil.setAttributes(individualScoredData.getElement(), "pnlIndividualScoredData", null, null);
				StringUtil.setAttributes(individualOpenendedData.getElement(), "pnlIndividualOpenendedData", null, null);
				StringUtil.setAttributes(individualScoredDatapnl.getElement(), "pnlIndividualScoredDatapnl", null, null);
				StringUtil.setAttributes(individualResourceBreakdownDatapnl.getElement(), "pnlIndividualResourceBreakdownDatapnl", null, null);
				StringUtil.setAttributes(individualResourceBreakdownData.getElement(), "pnlIndividualResourceBreakdownData", null, null);

				StringUtil.setAttributes(filterDropDown.getElement(), "ddlFilterDropDown", null, null);

				StringUtil.setAttributes(totalTimeSpentlbl.getElement(), "lblTotalTimeSpentlbl", null, null);
				StringUtil.setAttributes(totalViewlbl.getElement(), "lblTotalViewlbl", null, null);
				StringUtil.setAttributes(lblCollectionOverview.getElement(), "lblCollectionOverview", i18n.GL2274(),  i18n.GL2274());
				StringUtil.setAttributes(lblTotalTimeSpent.getElement(), "lblTotalTimeSpent", i18n.GL2275(),  i18n.GL2275());
				StringUtil.setAttributes(lblViews.getElement(), "lblViews", i18n.GL2276(),  i18n.GL2276());
				StringUtil.setAttributes(lblAvgReaction.getElement(), "lblAvgReaction", i18n.GL2277(),  i18n.GL2277());

			}
		});;
	}
	/**
	 * This method is used to hide the panels
	 */
	void hideAllPanels(){
		individualScoredDatapnl.setVisible(false);
		individualOpenendedData.setVisible(false);
		individualResourceBreakdownDatapnl.setVisible(false);
		userInfo.setVisible(false);
	}
	/**
	 * Default method for initialization
	 */
	void setData(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				individualTabContainer=new AnalyticsTabContainer() {
					@Override
					public void onTabClick(String tabClicked) {
						if(SCORED.equalsIgnoreCase(tabClicked)){
							hideAllPanels();
							individualScoredDatapnl.setVisible(true);
						}else if(OPENENDED.equalsIgnoreCase(tabClicked)){
							hideAllPanels();
							individualOpenendedData.setVisible(true);
							userInfo.setVisible(true);
						}else if(BREAKDOWN.equalsIgnoreCase(tabClicked)){
							hideAllPanels();
							individualResourceBreakdownDatapnl.setVisible(true);
						}else if(PRINT.equalsIgnoreCase(tabClicked)){
							setPrintIndividualSummayData(false,false);
						}else if(EMAIL.equalsIgnoreCase(tabClicked)){
							setPrintIndividualSummayData(true,true);
							emailPopup=new EmailPopup();
							emailPopup.setData();
							emailPopup.show();
						}else{
							setPrintIndividualSummayData(true,false);
						}
					}
				};
				tabContainer.add(individualTabContainer);
				filterDropDown.clear();
				filterDropDown.addItem(i18n.GL2289(), i18n.GL2289());
			    filterDropDown.addItem(i18n.GL2290(), i18n.GL2290());
			    filterDropDown.addItem(i18n.GL2291(), i18n.GL2291());

			}
		});
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.IsCollectionSummaryIndividualView#setIndividualData(java.util.ArrayList, com.google.gwt.user.client.ui.HTMLPanel)
	 */
	@Override
	public void setIndividualData(final ArrayList<UserDataDo> result,final HTMLPanel loadingImage) {
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				noErrorMesage.setVisible(false);
				maincontainer.setVisible(true);
				individualTabContainer.clearStyles();
				individualTabContainer.setScoredQuestionsHilight();

				hideAllPanels();
				individualResourceBreakdownDatapnl.setVisible(true);

				individualScoredData.clear();
				individualOpenendedData.clear();
				individualResourceBreakdownData.clear();
				questionsData.clear();
				openendedData.clear();

				collectionProgressCount=0;
				questionRowIndex.clear();
				resourceRowIndex.clear();
				Collections.sort(result,new Comparator<UserDataDo>() {
		        	public int compare(UserDataDo o1, UserDataDo o2) {
		        		 Integer obj1 = new Integer(o1.getItemSequence());
						 Integer obj2 = new Integer(o2.getItemSequence());
		        	     return obj1.compareTo(obj2);
		        	}
		        });
				for (UserDataDo userDataDo : result) {
						if(QUESTION.equalsIgnoreCase(userDataDo.getResourceFormat())){
							if(!OE.equalsIgnoreCase(userDataDo.getType())){
								questionsData.add(userDataDo);
							}else{
								openendedData.add(userDataDo);
							}
							questionRowIndex.add(collectionProgressCount);
						}else{
							resourceRowIndex.add(collectionProgressCount);
						}
						collectionProgressCount++;
				}
				setQuestionsData(questionsData);
				setQuestionsPrintData(questionsData);
				setOpenendedQuestionsData(openendedData);
				setOpenendedQuestionsPrintData(openendedData);
				setCollectionBreakDown(result,loadingImage);
				setCollectionBreakDownPrintData(result);

			}
		});
	}
	/**
	 * This will set the collections break down print data.
	 * @param result
	 */
	void setCollectionBreakDownPrintData(final ArrayList<UserDataDo> result){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				try{
						printResourceData.clear();
						UserDataDo maxAvgValue=Collections.max(result,new Comparator<UserDataDo>() {
				        	public int compare(UserDataDo o1, UserDataDo o2) {
				        		 Long obj1 = new Long(o1.getTimeSpent());
				        	     Long obj2 = new Long(o2.getTimeSpent());
				        	     return obj1.compareTo(obj2);
				        	}
				        });

					    final DataTable data = DataTable.create();
					    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
				        data.addColumn(ColumnType.STRING, i18n.GL3267());
				        data.addColumn(ColumnType.STRING, i18n.GL3182());
				        data.addColumn(ColumnType.STRING, i18n.GL3268());
				        data.addColumn(ColumnType.STRING, i18n.GL0934());
				        data.addColumn(ColumnType.STRING, i18n.GL3261());
				        int rowCount=0,rowVal=0;
				        for(int i=0;i<result.size();i++) {
				        		rowCount=rowCount+1;
				        }
				        data.addRows(rowCount);

				        for(int i=0;i<result.size();i++) {
				        	data.setCell(rowVal, 0,result.get(i).getSequence(), null, getPropertiesCell());
				            //set Format
				              String  resourceCategory =result.get(i).getResourceFormat()!=null?result.get(i).getResourceFormat().trim():"";
				              String categoryStyle="";
				    		  if(WEBSITE.equalsIgnoreCase(resourceCategory) || WEBPAGE.equalsIgnoreCase(resourceCategory)){
							      resourceCategory = WEBPAGE;
							      categoryStyle=res.css().category_new_type_webpage();
							  } else if(SLIDE.equalsIgnoreCase(resourceCategory) || IMAGE.equalsIgnoreCase(resourceCategory)){
							      resourceCategory = IMAGE;
							      categoryStyle=res.css().category_new_type_image();
							  } else if(HANDOUT.equalsIgnoreCase(resourceCategory) || LESSON.equalsIgnoreCase(resourceCategory) || TEXTBOOK.equalsIgnoreCase(resourceCategory)|| TEXT.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = TEXT;
							      categoryStyle=res.css().category_new_type_text();
							  }  else if(EXAM.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = WEBPAGE;
							      categoryStyle=res.css().category_new_type_webpage();
							  } else if(VIDEO.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = VIDEO;
							      categoryStyle=res.css().category_new_type_video();
							  } else if(INTERACTIVE.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = INTERACTIVE;
							      categoryStyle=res.css().category_new_type_interactive();
							  }else if(AUDIO.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = AUDIO;
							      categoryStyle=res.css().category_new_type_audio();
							  } else{
								  categoryStyle=res.css().category_new_type_other();
							  }
				            Label categorylbl=new Label();
				            categorylbl.addStyleName(categoryStyle);
				            categorylbl.addStyleName(res.css().setMarginAuto());
				            data.setValue(rowVal, 1,categorylbl.toString());

				            //Set Question Title
				            Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
				            questionTitle.setStyleName(res.css().alignCenterAndBackground());
				            questionTitle.addStyleName(res.css().alignLeft());

				            data.setValue(rowVal, 2, questionTitle.toString());

				           //Set time spent
				            HorizontalPanel timeSpentpnl=new HorizontalPanel();
				            timeSpentpnl.add(AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()));
				            Label progressBar=new Label();
				            progressBar.setStyleName(res.css().setProgressBar());
				            timeSpentpnl.add(progressBar);
				            double maxAvgVal = ((double) result.get(i).getTimeSpent())/((double) maxAvgValue.getTimeSpent());
				            progressBar.getElement().getStyle().setWidth(maxAvgVal*100, Unit.PX);
				            data.setValue(rowVal, 3, timeSpentpnl.toString());

				            //set Views label
				            Label viewlbl=new Label(Integer.toString(result.get(i).getViews()));
				            viewlbl.setStyleName(res.css().alignCenterAndBackground());
				            data.setValue(rowVal, 4, viewlbl.toString());

				            //Set reactions
				            int reaction=result.get(i).getReaction();
				            data.setValue(rowVal, 5, new AnalyticsReactionWidget(reaction).toString());
				            rowVal++;
				        }
				        final Options options = Options.create();
				        options.setAllowHtml(true);
				        Table table = new Table(data, options);
				        printResourceData.add(table);
				}catch(Exception e){
					AppClientFactory.printSevereLogger("setCollectionBreakDownPrintData :"+e.getMessage());
				}

			}
		});
	}
	/**
	 * This will set the collections break down data
	 * @param result
	 * @param loadingImage
	 */
	void setCollectionBreakDown(final ArrayList<UserDataDo> result,final HTMLPanel loadingImage){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				try{

				final int[] primitivesQuestions = AnalyticsUtil.toIntArray(questionRowIndex);
				final int[] primitivesResources = AnalyticsUtil.toIntArray(resourceRowIndex);

					UserDataDo maxAvgValue=Collections.max(result,new Comparator<UserDataDo>() {
			        	public int compare(UserDataDo o1, UserDataDo o2) {
			        		 Long obj1 = new Long(o1.getTimeSpent());
			        	     Long obj2 = new Long(o2.getTimeSpent());
			        	     return obj1.compareTo(obj2);
			        	}
			        });

				    final DataTable data = DataTable.create();
				    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
			        data.addColumn(ColumnType.STRING, i18n.GL3267());
			        data.addColumn(ColumnType.STRING, i18n.GL3182());
			        data.addColumn(ColumnType.STRING, i18n.GL3268());
			        data.addColumn(ColumnType.STRING, i18n.GL0934());
			        data.addColumn(ColumnType.STRING, i18n.GL3261());
			        int rowCount=0,rowVal=0;
			        for(int i=0;i<result.size();i++) {
			        		rowCount=rowCount+1;
			        }
			        data.addRows(rowCount);

			        for(int i=0;i<result.size();i++) {
			        		data.setCell(rowVal, 0, result.get(i).getSequence(), null, getPropertiesCell());
				            //set Format
				              String  resourceCategory =result.get(i).getResourceFormat()!=null?result.get(i).getResourceFormat().trim():"";
				              String categoryStyle="";
				              if(WEBSITE.equalsIgnoreCase(resourceCategory) || WEBPAGE.equalsIgnoreCase(resourceCategory)){
							      resourceCategory = WEBPAGE;
							      categoryStyle=res.css().category_new_type_webpage();
							  } else if(SLIDE.equalsIgnoreCase(resourceCategory) || IMAGE.equalsIgnoreCase(resourceCategory)){
							      resourceCategory = IMAGE;
							      categoryStyle=res.css().category_new_type_image();
							  } else if(HANDOUT.equalsIgnoreCase(resourceCategory) || LESSON.equalsIgnoreCase(resourceCategory) || TEXTBOOK.equalsIgnoreCase(resourceCategory)|| TEXT.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = TEXT;
							      categoryStyle=res.css().category_new_type_text();
							  }  else if(EXAM.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = WEBPAGE;
							      categoryStyle=res.css().category_new_type_webpage();
							  } else if(VIDEO.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = VIDEO;
							      categoryStyle=res.css().category_new_type_video();
							  } else if(INTERACTIVE.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = WEBPAGE;
							      categoryStyle=res.css().category_new_type_interactive();
							  }else if(AUDIO.equalsIgnoreCase(resourceCategory)) {
							      resourceCategory = AUDIO;
							      categoryStyle=res.css().category_new_type_audio();
							  } else{
								  categoryStyle=res.css().category_new_type_other();
							  }
				            Label categorylbl=new Label();
				            categorylbl.addStyleName(categoryStyle);
				            categorylbl.addStyleName(res.css().setMarginAuto());
				            data.setValue(rowVal, 1,categorylbl.toString());

				            //Set Question Title
				            Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()!=null?result.get(i).getTitle():""));
				            questionTitle.setStyleName(res.css().alignCenterAndBackground());
				            questionTitle.addStyleName(res.css().alignLeft());
				            data.setValue(rowVal, 2, questionTitle.toString());

				           //Set time spent
				            HorizontalPanel timeSpentpnl=new HorizontalPanel();
				            timeSpentpnl.add(AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()));
				            Label progressBar=new Label();
				            progressBar.setStyleName(res.css().setProgressBar());
				            timeSpentpnl.add(progressBar);
				            double maxAvgVal = ((double) result.get(i).getTimeSpent())/((double) maxAvgValue.getTimeSpent());
				            progressBar.getElement().getStyle().setWidth(maxAvgVal*100, Unit.PX);
				            data.setValue(rowVal, 3, timeSpentpnl.toString());

				            Label viewlbl=new Label(Integer.toString(result.get(i).getViews()));
				            viewlbl.setStyleName(res.css().alignCenterAndBackground());
				            data.setValue(rowVal, 4, viewlbl.toString());

				            //Set reactions
				            int reaction=result.get(i).getReaction();
				            data.setValue(rowVal, 5, new AnalyticsReactionWidget(reaction).toString());
				        	rowVal++;
			        }
			        final Options options = Options.create();
			        options.setAllowHtml(true);
			        Table table = new Table(data, options);
			        individualResourceBreakdownData.add(table);
			        table.getElement().getFirstChildElement().getFirstChildElement().getFirstChildElement().getStyle().setProperty("width", "98% !important");
			        filterDropDown.addChangeHandler(new ChangeHandler() {

						@Override
						public void onChange(ChangeEvent event) {
							  individualResourceBreakdownData.clear();
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
							     individualResourceBreakdownData.add(table);
							     table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
						}
					});

				}catch(Exception e){
					AppClientFactory.printSevereLogger("setCollectionBreakDown :"+e.getMessage());
				}
			        if(loadingImage!=null)
			        loadingImage.setVisible(false);

			}
		});
	}
	/**
	 * This will set the openended questions data for printing purpose
	 * @param result
	 */
	void setOpenendedQuestionsPrintData(final ArrayList<UserDataDo> result){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				try{
					printOpendedData.clear();
				    DataTable data = DataTable.create();
				    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
			        data.addColumn(ColumnType.STRING, i18n.GL0308());
			        data.addColumn(ColumnType.STRING, i18n.GL3260());
			        data.addColumn(ColumnType.STRING, i18n.GL2084());
			        data.addColumn(ColumnType.STRING, i18n.GL3261());
			        data.addColumn(ColumnType.STRING, i18n.GL3262());
			        data.addRows(result.size());
			        for(int i=0;i<result.size();i++) {
			        	data.setCell(i, 0, result.get(i).getSequence(), null, getPropertiesCell());

			            //Set Question Title
			            Label questionTitle=new Label( AnalyticsUtil.html2text(result.get(i).getTitle()));
			            questionTitle.setStyleName(res.css().alignCenterAndBackground());
			            questionTitle.addStyleName(res.css().alignLeft());
			            data.setValue(i, 1, questionTitle.toString());

			            //Set completion
			            int noOfAttempts=result.get(i).getAttempts();
			            Label completion=new Label();
			            completion.setStyleName(res.css().alignCenterAndBackground());
			            if(noOfAttempts>0){
			            	completion.setText(i18n.GL1447());
			            }else{
			            	completion.setText(i18n.GL3263());
			            }
			            data.setValue(i, 2, completion.toString());

			            //Set time spent
			            data.setValue(i, 3, AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

			            //Set reactions
			            int reaction=result.get(i).getReaction();
			            data.setValue(i, 4, new AnalyticsReactionWidget(reaction).toString());

			            //set View response label
			            Label viewResponselbl=new Label(result.get(i).getText());
			            viewResponselbl.setStyleName(res.css().viewResponseTextOpended());
			            data.setValue(i, 5, viewResponselbl.toString());
			        }
			        Options options = Options.create();
			        options.setAllowHtml(true);
			        final Table table = new Table(data, options);
			        printOpendedData.add(table);
			        if(result.size()==0){
			        	Label erroeMsg=new Label();
			        	erroeMsg.setStyleName(res.css().displayMessageTextForOEQuestions());
			        	erroeMsg.setText(i18n.GL3118());
			        	printOpendedData.add(erroeMsg);
			        }
				}catch(Exception e){
					AppClientFactory.printSevereLogger("setOpenendedQuestionsPrintData : "+e.getMessage());
				}

			}
		});
	}
	/**
	 * This will set the openended questions data
	 * @param result
	 */
	void setOpenendedQuestionsData(final ArrayList<UserDataDo> result){

		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

			    DataTable data = DataTable.create();
			    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
		        data.addColumn(ColumnType.STRING, i18n.GL0308());
		        data.addColumn(ColumnType.STRING, i18n.GL3260());
		        data.addColumn(ColumnType.STRING, i18n.GL2084());
		        data.addColumn(ColumnType.STRING, i18n.GL3261());
		        data.addColumn(ColumnType.STRING, i18n.GL3262());
		        data.addRows(result.size());
		        for(int i=0;i<result.size();i++) {
		        	data.setCell(i, 0, result.get(i).getSequence(), null, getPropertiesCell());

		            //Set Question Title
		            Label questionTitle=new Label( AnalyticsUtil.html2text(result.get(i).getTitle()));
		            questionTitle.setStyleName(res.css().alignCenterAndBackground());
		            questionTitle.addStyleName(res.css().alignLeft());
		            data.setValue(i, 1, questionTitle.toString());

		            //Set completion
		            int noOfAttempts=result.get(i).getAttempts();
		            Label completion=new Label();
		            completion.setStyleName(res.css().alignCenterAndBackground());
		            if(noOfAttempts>0){
		            	completion.setText(i18n.GL_GRR_YES());
		            }else{
		            	completion.setText(i18n.GL_GRR_NO());
		            }
		            data.setValue(i, 2, completion.toString());

		            //Set time spent
		            data.setValue(i, 3, AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

		            //Set reactions
		            int reaction=result.get(i).getReaction();
		            data.setValue(i, 4, new AnalyticsReactionWidget(reaction).toString());

		            //set View response label
		        	if(result.get(i).getAnswerObject()!=null && !result.get(i).getStatus().equalsIgnoreCase("skipped")) {
		            Label viewResponselbl=new Label(VIEWRESPONSE);
		            viewResponselbl.setStyleName(res.css().viewResponseTextOpended());
		            viewResponselbl.getElement().setAttribute("resourceGooruId", result.get(i).getResourceGooruOId());
	   	            viewResponselbl.getElement().setAttribute("questionType", result.get(i).getType());
	   	            viewResponselbl.getElement().setAttribute("answerObj", result.get(i).getAnswerObject());
     			    viewResponselbl.getElement().setAttribute("attempts",String.valueOf(noOfAttempts));
		            data.setValue(i, 5, viewResponselbl.toString());
		        	}
		            
		        }
		        Options options = Options.create();
		        options.setAllowHtml(true);
		        final Table table = new Table(data, options);
		        individualOpenendedData.add(table);
		        if(result.size()==0){
		        	Label erroeMsg=new Label();
		        	erroeMsg.setStyleName(res.css().displayMessageTextForOEQuestions());
		        	erroeMsg.setText(i18n.GL3264());
		        	individualOpenendedData.add(erroeMsg);
		        }
		        table.addDomHandler(new SummaryPopupClick(), ClickEvent.getType());
		       // table.addDomHandler(new ClickOnTableCell(), ClickEvent.getType());
		        table.getElement().getFirstChildElement().getFirstChildElement().getFirstChildElement().getStyle().setProperty("width", "98% !important");

			}
		});;
	}
	/**
	 * This class is used to handle the click event on the table cell
	 */
	class ClickOnTableCell implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Element ele=event.getNativeEvent().getEventTarget().cast();
			if(ele.getInnerText().equalsIgnoreCase(VIEWRESPONSE) && !StringUtil.isEmpty(ele.getAttribute("resourceGooruId"))){
				getUiHandlers().setOEtextData(ele.getAttribute("resourceGooruId"),ele.getAttribute("questionType"));
			}
		}
	}
	/**
	 * This will set the question data for printing purpose
	 * @param result
	 */
	void setQuestionsPrintData(final ArrayList<UserDataDo> result){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				try{
					printScoredData.clear();
					boolean isTickdisplay=false;
				    DataTable data = DataTable.create();
				    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
			        data.addColumn(ColumnType.STRING, i18n.GL0308());
			        data.addColumn(ColumnType.STRING, i18n.GL2288());
			        data.addColumn(ColumnType.STRING, i18n.GL3269());
			        data.addColumn(ColumnType.STRING, i18n.GL3270());
			        data.addColumn(ColumnType.STRING, i18n.GL2084());
			        data.addColumn(ColumnType.STRING, i18n.GL3271());

			        data.addRows(result.size());
			        if(result.size()!=0){
						        for(int i=0;i<result.size();i++) {
						        	isTickdisplay=false;
						            data.setCell(i, 0, result.get(i).getSequence(), null, getPropertiesCell());

						            Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
						            questionTitle.setStyleName(res.css().alignCenterAndBackground());
						            questionTitle.setStyleName(res.css().alignLeft());
						            data.setValue(i, 1, questionTitle.toString());
						            int noOfAttempts=result.get(i).getAttempts();


						            //Set Answer choices
						            String questionType= result.get(i).getType();
						            if(questionType.equalsIgnoreCase("HS")){
						            	questionType= result.get(i).getQuestionType();
						            }
						            String scoreStatus= result.get(i).getStatus();
						        	if(questionType.equalsIgnoreCase(MC) ||questionType.equalsIgnoreCase(TF) || questionType.equalsIgnoreCase(TSLASHF)){
						        		Label anserlbl=new Label();
						        		if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
						        			 Map<String, Integer> authorObject = result.get(i).getOptions();

						        			 for (Map.Entry<String, Integer> entry : authorObject.entrySet())
											 {
												 String userSelectedOption=entry.getKey();
												 int ansStatus=entry.getValue();
												 if(userSelectedOption!=null){
													 anserlbl.setText(userSelectedOption);
													 if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts==1){
														 anserlbl.getElement().getStyle().setColor(CORRECT);
														 isTickdisplay=true;
													 }else if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts>1){
														 anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
													 }else{
														 anserlbl.getElement().getStyle().setColor(INCORRECT);
													 }
												 }
											 }

						        			/*
						        			 if(authorObject.keySet().size()!=0){
						        				 String userSelectedOption=authorObject.keySet().iterator().next();
							        			 correctAnser=getCorrectAnswer(result.get(i).getMetaData());
							        			 if(userSelectedOption!=null && correctAnser!=null){
							        				 anserlbl.setText(userSelectedOption);
							        				 if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts==1){
							        					 anserlbl.getElement().getStyle().setColor(CORRECT);
							        					 isTickdisplay=true;
							        				 }else if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts>1){
							        					 anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
							        				 }else{
							        					 anserlbl.getElement().getStyle().setColor(INCORRECT);
							        				 }
							        			 }
						        			 }*/
						        		}
						        		anserlbl.setStyleName(res.css().alignCenterAndBackground());
						        		data.setValue(i, 3, anserlbl.toString());
						        	}else if (FIB.equalsIgnoreCase(questionType)){
						        		VerticalPanel answerspnl=new VerticalPanel();
						        		if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
						        			String answerTextFormat = "";
						        			String[] answersArry = null;
						        			ArrayList<MetaDataDo> questionList=result.get(i).getMetaData();
											for (MetaDataDo metaDataDo : questionList) {
												String answerText = "";
												if((metaDataDo.getAnswerText() != null)) {
													String text=StringUtil.removeAllHtmlCss(removeHtmlTags(InfoUtil.removeQuestionTagsOnBoldClick(metaDataDo.getAnswerText())));
													answerText = text;
												}
												answerTextFormat += '[' + answerText +']';
												if(questionList.size()  != metaDataDo.getSequence()){
													  answerTextFormat += ",";
												}
											}
											String[] userFibOption = null;
											if(result.get(i).getText() != null) {
												answersArry=answerTextFormat.split(",");
												userFibOption =result.get(i).getText().split(",");
											}
											if(answersArry!=null && userFibOption!=null){
												boolean isCorrect=false;
												for (int k = 0; k < answersArry.length; k++) {
													Label answerChoice=new Label();
													if(answersArry[k]!=null && k<userFibOption.length){
														if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts == 1)){
															answerChoice.setText(userFibOption[k]);
															answerChoice.getElement().getStyle().setColor(CORRECT);
														}else if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts > 1)) {
															answerChoice.setText(userFibOption[k]);
															answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
															isCorrect=true;
														}else{
															answerChoice.setText(userFibOption[k]);
															answerChoice.getElement().getStyle().setColor(INCORRECT);
															isCorrect=true;
														}
														answerChoice.setStyleName(res.css().alignCenterAndBackground());
														answerspnl.add(answerChoice);
													}
												}
												if(!isCorrect){
													 isTickdisplay=true;
												}
											}
						        		}
						        		 answerspnl.setStyleName(res.css().setMarginAuto());
						        		 data.setValue(i, 3, answerspnl.toString());
						        	}else  if(MA.equalsIgnoreCase(questionType)){
						        		VerticalPanel answerspnl=new VerticalPanel();
						        		if(result.get(i).getAnswerObject()!=null) {
						        			 JSONValue value = JSONParser.parseStrict(result.get(i).getAnswerObject());
						        			 JSONObject answerObject = value.isObject();
						        			 Set<String> keys=answerObject.keySet();
						        			 Iterator<String> itr = keys.iterator();
						        			 boolean isCorrect=false;
						        		      while(itr.hasNext()) {
						        		    	  answerspnl.clear();
						        		         JSONArray attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
						        		         for(int j=0;j<attemptsObj.size();j++){
						        		        	Label answerChoice=new Label();
						        		            String showMessage = null;
						        		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
						        		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
						        		        	String matext =attemptsObj.get(j).isObject().get("text").isString().stringValue();
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
						 										 isCorrect=true;
						 									} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
						 										answerChoice.getElement().getStyle().setColor(CORRECT);
						 									} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
						 										answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
						 									}
						 							  }else{
						 								 isCorrect=true;
						 							  }
						 	        		        answerChoice.setStyleName(res.css().alignCenterAndBackground());
						 	        		        answerspnl.add(answerChoice);
						        		         }
						        		      }
						        		      if(!isCorrect){
													 isTickdisplay=true;
												}
						        		}
						        		 answerspnl.setStyleName(res.css().setMarginAuto());
						        		 data.setValue(i, 3, answerspnl.toString());
						        	}else if(HT_RO.equalsIgnoreCase(questionType) || HT_HL.equalsIgnoreCase(questionType) || HS_TXT.equalsIgnoreCase(questionType) || HS_IMG.equalsIgnoreCase(questionType)){
							        	VerticalPanel answerspnl=new VerticalPanel();
						        		if(result.get(i).getAnswerObject()!=null && !result.get(i).getStatus().equalsIgnoreCase("skipped")) {
						        			Label viewResponselbl=new Label(VIEWRESPONSE);
						        			viewResponselbl.setStyleName("summaryViewResponse");
						        			viewResponselbl.getElement().setAttribute("resourceGooruId", result.get(i).getResourceGooruOId());
						        			viewResponselbl.getElement().setAttribute("questionType", result.get(i).getType());
						        			viewResponselbl.getElement().setAttribute("answerObj", result.get(i).getAnswerObject());
						        			viewResponselbl.getElement().setAttribute("attempts",String.valueOf(noOfAttempts));
						        			answerspnl.add(viewResponselbl);
						        		}
						        		 answerspnl.setStyleName(res.css().setMarginAuto());
						        		 data.setValue(i, 3, answerspnl.toString());
						        	}
						        	Image correctImg=new Image();
						        	if(isTickdisplay){
						        		 correctImg.setUrl(urlDomain+"/images/analytics/tick.png");
						        	}else{
						        		correctImg.setUrl(urlDomain+"/images/analytics/wrong.png");
						        	}
						            data.setCell(i, 2, correctImg.toString(), null, getPropertiesCell());
						            //Set attempts
						            Label attempts=new Label(Integer.toString(noOfAttempts));
						            attempts.setStyleName(res.css().alignCenterAndBackground());
						            data.setValue(i, 4, attempts.toString());

						            //Set time spent
						            data.setValue(i, 5,AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

						            //Set reactions
						            int reaction=result.get(i).getReaction();
						            data.setValue(i, 6, new AnalyticsReactionWidget(reaction).toString());
						        }
						}
			        Options options = Options.create();
			        options.setAllowHtml(true);
			        Table table = new Table(data, options);
			        printScoredData.add(table);
			        if(result.size()==0){
			        	Label erroeMsg=new Label();
			        	erroeMsg.setStyleName(res.css().displayMessageTextForScoredQuestions());
			        	erroeMsg.setText(i18n.GL3265());
			        	printScoredData.add(erroeMsg);
			        }
				}catch(Exception e){
					AppClientFactory.printSevereLogger("setQuestionsPrintData : "+e.getMessage());
				}

			}
		});
	}
	/**
	 * This will set the question data
	 * @param result
	 */
	void setQuestionsData(final ArrayList<UserDataDo> result){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

			    DataTable data = DataTable.create();
			    data.addColumn(ColumnType.NUMBER, i18n.GL3259());
		        data.addColumn(ColumnType.STRING, i18n.GL0308());
		        data.addColumn(ColumnType.STRING, i18n.GL0315());
		        data.addColumn(ColumnType.STRING, i18n.GL3270());
		        data.addColumn(ColumnType.STRING, i18n.GL2084());
		        data.addColumn(ColumnType.STRING, i18n.GL3271());

		        data.addRows(result.size());
		      if(result.size()!=0){
					        for(int i=0;i<result.size();i++) {
					            data.setCell(i, 0, result.get(i).getSequence(), null, getPropertiesCell());
					            Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
					            questionTitle.setStyleName(res.css().alignCenterAndBackground());
					            questionTitle.setStyleName(res.css().alignLeft());
					            data.setValue(i, 1, questionTitle.toString());
					            int noOfAttempts=result.get(i).getAttempts();

					            //Set Answer choices
					            String questionType= result.get(i).getType();
					            if(questionType.equalsIgnoreCase("HS")){
					            	questionType= result.get(i).getQuestionType();
					            }
					            String scoreStatus= result.get(i).getStatus();

					        	if(MC.equalsIgnoreCase(questionType) ||TF.equalsIgnoreCase(questionType) || TSLASHF.equalsIgnoreCase(questionType)){
					        		Label anserlbl=new Label();
					        		if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
					        			 Map<String, Integer> authorObject=result.get(i).getOptions();
					        			 for (Map.Entry<String, Integer> entry : authorObject.entrySet())
										 {
											 String userSelectedOption=entry.getKey();
											 if(userSelectedOption!=null){
													anserlbl.setText(userSelectedOption);
													if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts==1){
														anserlbl.getElement().getStyle().setColor(CORRECT);
													}else if(STATUS_CORRECT.equalsIgnoreCase(scoreStatus) && noOfAttempts>1){
														anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
													}else{
														anserlbl.getElement().getStyle().setColor(INCORRECT);
													}
												}
										 }

					        		}
					        		anserlbl.setStyleName(res.css().alignCenterAndBackground());
					        		data.setValue(i, 2, anserlbl.toString());
					        	}else if (FIB.equalsIgnoreCase(questionType)){
					        		VerticalPanel answerspnl=new VerticalPanel();
					        		if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
					        			String answerTextFormat = "";
					        			String[] answersArry = null;
					        			ArrayList<MetaDataDo> questionList=result.get(i).getMetaData();
										for (MetaDataDo metaDataDo : questionList) {
											String answerText = "";
											if((metaDataDo.getAnswerText() != null)) {
												String text=StringUtil.removeAllHtmlCss(removeHtmlTags(InfoUtil.removeQuestionTagsOnBoldClick(metaDataDo.getAnswerText())));
												answerText = text;
											}
											answerTextFormat += '[' + answerText +']';
											if(questionList.size()  != metaDataDo.getSequence()){
												  answerTextFormat += ",";
											}
										}
										String[] userFibOption = null;
										if(result.get(i).getText() != null) {
											answersArry=answerTextFormat.split(",");
											userFibOption =result.get(i).getText().split(",");
										}
										if(answersArry!=null && userFibOption!=null){
											for (int k = 0; k < answersArry.length; k++) {
												Label answerChoice=new Label();
												if(answersArry[k]!=null && k<userFibOption.length){
													if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts == 1)){
														answerChoice.setText(userFibOption[k]);
														answerChoice.getElement().getStyle().setColor(CORRECT);
													}else if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts > 1)) {
														answerChoice.setText(userFibOption[k]);
														answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
													}else{
														answerChoice.setText(userFibOption[k]);
														answerChoice.getElement().getStyle().setColor(INCORRECT);
													}
													answerChoice.setStyleName(res.css().alignCenterAndBackground());
													answerspnl.add(answerChoice);
												}
											}
										}
					        		}
					        		 answerspnl.setStyleName(res.css().setMarginAuto());
					        		 data.setValue(i, 2, answerspnl.toString());
					        	}else  if(MA.equalsIgnoreCase(questionType)){
					        		VerticalPanel answerspnl=new VerticalPanel();
					        		if(result.get(i).getAnswerObject()!=null) {
					        			 JSONValue value = JSONParser.parseStrict(result.get(i).getAnswerObject());
					        			 JSONObject answerObject = value.isObject();
					        			 Set<String> keys=answerObject.keySet();
					        			 Iterator<String> itr = keys.iterator();
					        		      while(itr.hasNext()) {
					        		    	  answerspnl.clear();
					        		         JSONArray attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
					        		         for(int j=0;j<attemptsObj.size();j++){
					        		        	Label answerChoice=new Label();
					        		            String showMessage = null;
					        		            boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
					        		        	String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
					        		        	String matext =attemptsObj.get(j).isObject().get("text").isString().stringValue();
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
					 										answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
					 									}
					 							  }
					 	        		        answerChoice.setStyleName(res.css().alignCenterAndBackground());
					 	        		        answerspnl.add(answerChoice);
					        		         }
					        		      }
					        		}
					        		 answerspnl.setStyleName(res.css().setMarginAuto());
					        		 data.setValue(i, 2, answerspnl.toString());
					        	}else if(HT_RO.equalsIgnoreCase(questionType) || HT_HL.equalsIgnoreCase(questionType) || HS_TXT.equalsIgnoreCase(questionType) || HS_IMG.equalsIgnoreCase(questionType)){
					        		VerticalPanel answerspnl=new VerticalPanel();
					        		if(result.get(i).getAnswerObject()!=null && !result.get(i).getStatus().equalsIgnoreCase("skipped")) {
					        			Label viewResponselbl=new Label(VIEWRESPONSE);
					        			viewResponselbl.setStyleName("summaryViewResponse");
					        			viewResponselbl.getElement().setAttribute("resourceGooruId", result.get(i).getResourceGooruOId());
					        			viewResponselbl.getElement().setAttribute("questionType", result.get(i).getType());
					        			viewResponselbl.getElement().setAttribute("answerObj", result.get(i).getAnswerObject());
					        			viewResponselbl.getElement().setAttribute("attempts",String.valueOf(noOfAttempts));
					        			answerspnl.add(viewResponselbl);
					        		}
					        		 answerspnl.setStyleName(res.css().setMarginAuto());
					        		 data.setValue(i, 2, answerspnl.toString());
					        	}

					            //Set attempts
					            Label attempts=new Label(Integer.toString(noOfAttempts));
					            attempts.setStyleName(res.css().alignCenterAndBackground());
					            data.setValue(i, 3, attempts.toString());

					            //Set time spent
					            data.setValue(i, 4, AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

					            //Set reactions
					            int reaction=result.get(i).getReaction();
					            data.setValue(i, 5, new AnalyticsReactionWidget(reaction).toString());
					        }
					}
		        Options options = Options.create();
		        options.setAllowHtml(true);
		        Table table = new Table(data, options);
		        table.getElement().setId("individulaDataScored");
		        individualScoredData.add(table);
		        if(result.size()==0){
		        	Label erroeMsg=new Label();
		        	erroeMsg.setStyleName(res.css().displayMessageTextForScoredQuestions());
		        	erroeMsg.setText(i18n.GL3265());
		        	individualScoredData.add(erroeMsg);
		        }
		        table.addDomHandler(new SummaryPopupClick(), ClickEvent.getType());
		        table.getElement().getFirstChildElement().getFirstChildElement().getFirstChildElement().getStyle().setProperty("width", "98% !important");

			}
		});
	}
	/**
	 * This will return the correct answers
	 * @param metaDataObj
	 * @return
	 */
	String getCorrectAnswer(ArrayList<MetaDataDo> metaDataObj){
		for (MetaDataDo metaDataDo : metaDataObj) {
			if(metaDataDo.getIsCorrect()==1){
				return AnalyticsUtil.getCharForNumber(metaDataDo.getSequence()-1);
			}
		}
		return null;
	}
	/**
	 * This will set the cell properties
	 * @return
	 */
	com.google.gwt.visualization.client.Properties getPropertiesCell(){
		  Properties properties=Properties.create();
		  properties.set("style", "text-align:center;");
		  com.google.gwt.visualization.client.Properties p=properties.cast();
		  return p;
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.IsCollectionSummaryIndividualView#setIndividualCollectionMetaData(java.util.ArrayList, org.ednovo.gooru.shared.model.analytics.PrintUserDataDO)
	 */
	@Override
	public void setIndividualCollectionMetaData(
			ArrayList<CollectionSummaryMetaDataDo> result,PrintUserDataDO printUserDataDO) {
		//Set collection meta data
		collectionTitle=result.get(0).getTitle();
		totalTimeSpentlbl.setText(AnalyticsUtil.getTimeSpent(result.get(0).getAvgTimeSpent()));
		totalViewlbl.setText(Integer.toString(result.get(0).getViews()));
		totalAvgReactionlbl.clear();
		totalAvgReactionlbl.add(new AnalyticsReactionWidget(result.get(0).getAvgReaction()));
		collectionOverViewWidget.setData(result.get(0),false);
		collectionSummaryWidget.setDataAnalyticsData(result.get(0),printUserDataDO);
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.IsCollectionSummaryIndividualView#setViewResponseData(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void setViewResponseData(final ArrayList<OetextDataDO> result, final String resourceGooruId,final String collectionId,final String classpageId, final String pathwayId, final String questionType, final boolean isSummary, final String session, final ClasspageItemDo classpageItemDo) {
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				 popupPanel=new ViewResponsesPopup(result,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary,session,classpageItemDo);
				 popupPanel.setStyleName(res.css().setOETextPopupCenter());
			     if(popupPanel.isShowing()){
			    	 popupPanel.hide();
			    	 Window.enableScrolling(true);
			     }else{
			    	 Window.enableScrolling(false);
			    	 popupPanel.setGlassEnabled(true);
			    	 popupPanel.setGlassStyleName(res.css().setGlassStyleName());
			    	 popupPanel.setAutoHideEnabled(true);
			    	 popupPanel.show();
			    	 popupPanel.center();
			     }

			}
		});
	}
	/**
	 * This method is used for printing purpose
	 * @param isClickedOnSave
	 * @param isClickedOnEmail
	 */
	public void setPrintIndividualSummayData(final boolean isClickedOnSave, final boolean isClickedOnEmail){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				printWidget.clear();
				Label collectionSummaryText=new Label();
				collectionSummaryText.setText(i18n.GL1587());
				collectionSummaryText.getElement().getStyle().setPaddingBottom(15, Unit.PX);
				collectionSummaryText.addStyleName("collectionSummaryText");
				printWidget.add(collectionSummaryText);
				printWidget.add(collectionSummaryWidget);

				//To add scored questions
				Label scoredQuestionHeading=new Label();
				scoredQuestionHeading.setText(i18n.GL2282());
				scoredQuestionHeading.getElement().getStyle().setClear(Clear.BOTH);
				scoredQuestionHeading.getElement().getStyle().setPaddingTop(15, Unit.PX);
				scoredQuestionHeading.getElement().getStyle().setPaddingBottom(20, Unit.PX);
				printWidget.add(scoredQuestionHeading);
				printWidget.add(printScoredData);
				printScoredData.getElement().getStyle().setPaddingBottom(20, Unit.PX);
				//To add OE questions
				Label opendedQuestionHeading=new Label();
				opendedQuestionHeading.setText(i18n.GL3266());
				opendedQuestionHeading.getElement().getStyle().setPaddingBottom(20, Unit.PX);
				printWidget.add(opendedQuestionHeading);
				printWidget.add(printOpendedData);
				printOpendedData.getElement().getStyle().setPaddingBottom(20, Unit.PX);
				//To add resource breakdown
				printWidget.add(collectionOverViewWidget);
				printWidget.add(printResourceData);
				if(isClickedOnSave){
						 getUiHandlers().setHtmltopdf(style.toString().replaceAll("'", "\\\\\"")+printWidget.getElement().getInnerHTML().toString().replaceAll("\"", "\\\\\""),collectionTitle,isClickedOnEmail);
						 printWidget.clear();
				}else{
					Print.it(style,printWidget);
				    printWidget.clear();
				}

			}
		});
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.IsCollectionSummaryIndividualView#setPdfForEmail(java.lang.String)
	 */
	@Override
	public void setPdfForEmail(String path){
		if(emailPopup!=null){
			emailPopup.setEmailData(collectionTitle,path);
		}
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.IsCollectionSummaryIndividualView#enableAndDisableEmailButton(boolean)
	 */
	@Override
	public void enableAndDisableEmailButton(boolean isSummary){
		individualTabContainer.getEmailButton().setVisible(!isSummary);
	}
	@Override
	public void setErrorMessage() {
		noErrorMesage.setVisible(true);
		maincontainer.setVisible(false);
	}
	@Override
	public Frame getFrame(){
		return downloadFile;
	}

	private String removeHtmlTags(String html){
		html = html.replaceAll("(<\\w+)[^>]*(>)", "$1$2");
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("</a>", "").replaceAll("<a>", "");
        return html;
	}


	/**
	 * This class is used to handle the click event on the table cell
	 */
	public class SummaryPopupClick implements ClickHandler{


		@Override
		public void onClick(ClickEvent event) {
			Element ele=event.getNativeEvent().getEventTarget().cast();
			if(ele.getInnerText().equalsIgnoreCase(VIEWRESPONSE) && !StringUtil.isEmpty(ele.getAttribute("resourceGooruId")) && !StringUtil.isEmpty(ele.getAttribute("answerObj"))){
				JSONValue value = JSONParser.parseStrict(ele.getAttribute("answerObj").toString());
				JSONObject answerObject = value.isObject();
				Set<String> keys=answerObject.keySet();
				Iterator<String> itr = keys.iterator();
				JSONArray attemptsObj=null;
				while(itr.hasNext()) {
					attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
				}
				if(attemptsObj!=null){
					SummaryAnswerStatusPopup summaryPopup=new SummaryAnswerStatusPopup(attemptsObj, ele.getAttribute("questionType"),ele.getAttribute("attempts"));
				}
			}
		}
	};

}
