package org.ednovo.gooru.client.mvp.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.analytics.util.HCLineChart;
import org.ednovo.gooru.client.mvp.analytics.util.StudentScoredAboveBelowUlPanel;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitWidget;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.AssignmentGoal.AssignmentGoalView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollaboratorsDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class AnalyticsView extends BaseViewWithHandlers<AnalyticsUiHandlers> implements IsAnalyticsView {

	private static AnalyticsViewUiBinder uiBinder = GWT
			.create(AnalyticsViewUiBinder.class);

	interface AnalyticsViewUiBinder extends UiBinder<Widget, AnalyticsView> {
	}
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	AnalyticsCssBundle res;
	
	@UiField HTMLPanel highlightedStudentsContainer,scoreAboveHighlightedStudentsContainer,scoreBelowHighlightedStudentsContainer,unitPanel;
	
	@UiField Label lblMoreUnits,summaryArrowlbl,progressArrowlbl,responsesArrowlbl;
	
	@UiField HTMLPanel personalizeMainContainer,unitOptionsContainer,personalizeContainer,assignmentContainer,graphWidget,slotWidget,orangeProgressBar,greenProgressBar,blueProgressBar,scoredBelowPanel,scoredAbovePanel,loadingImageLabel;
	
	@UiField Button btnViewHighlightedStudents,btnViewAllStudents,btnCollectionSummary,btnCollectionProgress,btnCollectionResponses,personalizeBtn;
	
	@UiField ListBox loadCollections;
	
	@UiField InlineLabel minimumScorelbl;
	
	@UiField TextBox minimumScoreBelow,minimumScoreAbove;
	
	ClasspageListDo classpageListDo;
	
	boolean isSummayClicked=false,isProgressClicked=false,isPersonalizedBtnClicked=false;
	
	Map<String,GradeJsonData> loadcollectionsmap=new HashMap<String, GradeJsonData>();
	
	final String SUMMARY="Summary",PROGRESS="Progress",BELOWSCORE="BelowScore",ABOVESCORE="AboveScore";
	
	private int limit = 5;
	private int unitsPageNumber = 0;
	private int unitsTotalCount = 0;
	String unitCollectionId;
	int selectedUnitNumber;
	String unitId; 
	ClassDo classDo;
	private ClassUnitsListDo classUnitsDo;
	
	/**
	 * Default constructor
	 */
	public AnalyticsView() {
		this.res = AnalyticsCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));	
		btnCollectionSummary.addClickHandler(new ViewAssignmentClickEvent("Summary"));
		btnCollectionProgress.addClickHandler(new ViewAssignmentClickEvent("Progress"));
		btnCollectionResponses.addClickHandler(new ViewAssignmentClickEvent(""));
		minimumScoreBelow.setText("0");
		minimumScoreAbove.setText("0");
		minimumScoreBelow.addKeyUpHandler(new MiniMumScoreKeyUpHandler(BELOWSCORE));
		minimumScoreAbove.addKeyUpHandler(new MiniMumScoreKeyUpHandler(ABOVESCORE));
		loadCollections.addChangeHandler(new loadCollectionsChangeHandler());
		assignmentContainer.setVisible(false);
		highlightedStudentsContainer.setVisible(false);
		setStaticData();
	}
	/**
	 * This method is used to set static text.
	 */
	void setStaticData(){
		StringUtil.setAttributes(highlightedStudentsContainer.getElement(), "pnlHighlightedStudentsContainer", null, null);
		StringUtil.setAttributes(scoreAboveHighlightedStudentsContainer.getElement(), "pnlScoreAboveHighlightedStudentsContainer", null, null);
		StringUtil.setAttributes(scoreBelowHighlightedStudentsContainer.getElement(), "pnlScoreBelowHighlightedStudentsContainer", null, null);
		StringUtil.setAttributes(unitPanel.getElement(), "pnlUnitPanel", null, null);
		StringUtil.setAttributes(personalizeMainContainer.getElement(), "pnlPersonalizeMainContainer", null, null);
		StringUtil.setAttributes(unitOptionsContainer.getElement(), "pnlUnitOptionsContainer", null, null);
		StringUtil.setAttributes(personalizeContainer.getElement(), "pnlPersonalizeContainer", null, null);
		StringUtil.setAttributes(assignmentContainer.getElement(), "pnlAssignmentContainer", null, null);
		StringUtil.setAttributes(graphWidget.getElement(), "pnlGraphWidget", null, null);
		StringUtil.setAttributes(slotWidget.getElement(), "pnlSlotWidget", null, null);
		StringUtil.setAttributes(orangeProgressBar.getElement(), "pnlOrangeProgressBar", null, null);
		StringUtil.setAttributes(greenProgressBar.getElement(), "pnlGreenProgressBar", null, null);
		StringUtil.setAttributes(blueProgressBar.getElement(), "pnlBlueProgressBar", null, null);
		StringUtil.setAttributes(scoredBelowPanel.getElement(), "pnlScoredBelowPanel", null, null);
		StringUtil.setAttributes(scoredAbovePanel.getElement(), "pnlScoredAbovePanel", null, null);
		StringUtil.setAttributes(loadingImageLabel.getElement(), "pnLoadingImage", null, null);
		
		StringUtil.setAttributes(loadCollections.getElement(), "ddlLoadCollections", null, null);
		
		StringUtil.setAttributes(lblMoreUnits.getElement(), "lblMoreUnits", i18n.GL2256(), i18n.GL2256());
		StringUtil.setAttributes(summaryArrowlbl.getElement(), "lblSummaryArrowlbl", null, null);
		StringUtil.setAttributes(progressArrowlbl.getElement(), "lblProgressArrow", null, null);
		StringUtil.setAttributes(responsesArrowlbl.getElement(), "lblResponsesArrow", null, null);
		
		StringUtil.setAttributes(btnViewHighlightedStudents.getElement(), "btnViewHighlightedStudents", i18n.GL2293(), i18n.GL2293());
		StringUtil.setAttributes(btnViewAllStudents.getElement(), "btnViewAllStudents", i18n.GL2292(), i18n.GL2292());
		StringUtil.setAttributes(btnCollectionSummary.getElement(), "btnCollectionSummary", i18n.GL2228(), i18n.GL2228());
		StringUtil.setAttributes(btnCollectionProgress.getElement(), "btnCollectionProgress", i18n.GL2229(), i18n.GL2229());
		StringUtil.setAttributes(btnCollectionResponses.getElement(), "btnCollectionResponses", i18n.GL2258(),i18n.GL2258());
		StringUtil.setAttributes(personalizeBtn.getElement(), "btnPersonalize", null, null);
		
		StringUtil.setAttributes(minimumScorelbl.getElement(), "spnMinimumScorelbl", null, null);
			
		StringUtil.setAttributes(minimumScoreBelow.getElement(), "txtMinimumScoreBelow", null, null);
		StringUtil.setAttributes(minimumScoreAbove.getElement(), "txtMinimumScoreAbove", null, null);	
	}
	public class loadCollectionsChangeHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
			//when changing the collections drop down reset all the changes.
			getUiHandlers().setClickedTabPresenter(null,null,null);
			clearDownArrow();
			setMinimumScoresData();
			String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
			String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			int selectedIndex=loadCollections.getSelectedIndex();
			String collectionId=loadCollections.getValue(selectedIndex);
			getUiHandlers().getTopStudentsData(classpageId, pathwayId,collectionId,"DESC");
			getUiHandlers().getBottomStudentsData(classpageId, pathwayId,collectionId,"ASC");
		}
	}
	public class ViewAssignmentClickEvent implements ClickHandler{
		private String clicked;
		public ViewAssignmentClickEvent(String clicked){
			this.clicked=clicked;
		}
		@Override
		public void onClick(ClickEvent event) {
			clearDownArrows();
			String selectedCollectionId=loadCollections.getValue(loadCollections.getSelectedIndex());
			String selectedCollectionTitle=loadCollections.getItemText(loadCollections.getSelectedIndex());
			if(clicked.equalsIgnoreCase(PROGRESS)){
				isSummayClicked=false;
				if(isProgressClicked){
					isProgressClicked=false;
					getUiHandlers().setClickedTabPresenter(null,selectedCollectionId,selectedCollectionTitle);
				}else{
					isProgressClicked=true;
					getUiHandlers().setClickedTabPresenter(PROGRESS,selectedCollectionId,selectedCollectionTitle);
					progressArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else if(clicked.equalsIgnoreCase(SUMMARY)){
				isProgressClicked=false;
				if(isSummayClicked){
					isSummayClicked=false;
					getUiHandlers().setClickedTabPresenter(null,selectedCollectionId,selectedCollectionTitle);
				}else{
					isSummayClicked=true;
					getUiHandlers().setClickedTabPresenter(SUMMARY,selectedCollectionId,selectedCollectionTitle);
					summaryArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else{
				String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
				String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				getUiHandlers().exportOEPathway(classpageId, pathwayId,AnalyticsUtil.getTimeZone());
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#clearDownArrow()
	 */
	@Override
	public void clearDownArrow(){
		clearDownArrows();
		isSummayClicked=false;
		isProgressClicked=false;
	}
	/**
	 * This method is used to clear the arrow styles
	 */
	public void clearDownArrows(){
		summaryArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		progressArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		responsesArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#resetData()
	 */
	@Override
	public void resetData(){
		clearDownArrow();
		unitPanel.clear();
		graphWidget.clear();
		loadCollections.clear();
		scoredAbovePanel.clear();
		scoredBelowPanel.clear();
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#hidePersonalizeContainers()
	 */
	@Override
	public void hidePersonalizeContainers(){
		isPersonalizedBtnClicked=false;
		assignmentContainer.setVisible(false);
		highlightedStudentsContainer.setVisible(false);
		personalizeMainContainer.setVisible(false);
		unitOptionsContainer.setVisible(false);
	}
	/**
	 * This method is used to remove the unit selected style
	 */
	public void removeUnitSelectedStyle(){
		Iterator<Widget> widgets = unitPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitWidget) {
				UnitWidget unitsWidget=(UnitWidget)widget;
				unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
			}
		}		
	}
	
	/**
	 * This method is used to add unit select style 
	 * @param unitsWidget
	 */
	public void addUnitSelectStyle(UnitWidget unitsWidget){
		unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
	}
	/**
	 * This will handle the click event on the more units.
	 * @param event
	 */
	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		String currentPlaceToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String classpageid=currentPlaceToken.equals(PlaceTokens.EDIT_CLASSPAGE)?AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null):AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		getUiHandlers().getPathwayUnits(classpageid, limit, (limit*unitsPageNumber),false);
		removeAndAddUnitSelectedStyle();
	}
	/*@UiHandler("printTest")
	public void clickOnPrintTest(ClickEvent event){
		String style="<link href='../css/printAnalytics.css' rel='stylesheet' type='text/css'><link rel='styleSheet' type='text/css' href='https://www.google.com/uds/api/visualization/1.0/8c95b72e5c145d5b3d7bb8b4ea74fd63/ui+en,table+en.css'>";
		Print.it(style,graphWidget);
		System.out.println("in");
	}*/
	
	/**
	 * This will handle the click event on the view all studetns
	 * @param event
	 */
	@UiHandler("btnViewAllStudents")
	public void clickOnViewAllStudents(ClickEvent event){
		getUiHandlers().setPersonalizeData();
		personalizeMainContainer.setVisible(true);
		highlightedStudentsContainer.setVisible(false);
	}
	/**
	 * This will handle the click event on the view highlighted students
	 * @param event
	 */
	@UiHandler("btnViewHighlightedStudents")
	public void clickOnViewHignlightStudents(ClickEvent event){
		personalizeMainContainer.setVisible(false);
		highlightedStudentsContainer.setVisible(true);
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#removeAndAddUnitSelectedStyle()
	 */
	@Override
	public void removeAndAddUnitSelectedStyle(){
		Iterator<Widget> widgets = unitPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitWidget) {
				UnitWidget unitsWidget=(UnitWidget)widget;
				String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
				if(unitId.equals(unitsWidget.getUnitGooruOid())){
					setPersonalizeBtnText(unitsWidget.getUnitNmae());
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
					unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
				}else{
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
				}
			}
		}		
		
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#hideMoreUnitsLink()
	 */
	@Override
	public void hideMoreUnitsLink() {
		
		
	}
	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.ViewImpl#setInSlot(java.lang.Object, com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		slotWidget.clear();
		if (content != null) {
			 if(slot==AnalyticsPresenter.COLLECTION_PROGRESS_SLOT){
			    slotWidget.setVisible(true);
				slotWidget.add(content);
			}else  if(slot==AnalyticsPresenter.UNIT_ASSIGNMENT_SLOT){
				assignmentContainer.setVisible(true);
				assignmentContainer.add(content);
			}else if(slot==AnalyticsPresenter.PERSONALIZE_SLOT){
				personalizeContainer.clear();
				highlightedStudentsContainer.setVisible(true);
				personalizeContainer.add(content);
			}else{
				slotWidget.setVisible(false);
			}
		}else{
			slotWidget.setVisible(false);
		}
	}

	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#showUnitNames(org.ednovo.gooru.shared.model.content.ClassDo, boolean)
	 */
	@Override
	public void showUnitNames(ClassDo classDo, boolean clearPanel) {
		this.classDo = classDo;
		unitsTotalCount=classDo.getTotalHitCount();
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
			if(unitId==null){
				unitId = classDo.getSearchResults().get(0).getResource().getGooruOid();
			}
			if(clearPanel){
				unitPanel.clear();
				unitsPageNumber=0;
			}
			updatePageNumber();
			ArrayList<ClassUnitsListDo> classListUnitsListDo =classDo.getSearchResults();
			for(int i=0; i<classListUnitsListDo.size(); i++){
				ClassUnitsListDo classListUnitsListDObj=classDo.getSearchResults().get(i);
				classUnitsDo=classListUnitsListDObj;
				//unitTitleDetails.setText(classDo.getSearchResults().get(0).getResource().getTitle());
				String unitTitle = classDo.getSearchResults().get(i).getResource().getTitle();
				if(unitTitle!=null && unitTitle.length()>11){
					unitTitle = unitTitle.substring(0,11)+"...";
				}
				int unitNumber = classDo.getSearchResults().get(i).getItemSequence();
				UnitWidget unitsWidget=new UnitWidget(classListUnitsListDo.get(i));
				unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget,unitTitle,unitNumber));
				if(unitId!=null&&unitId.equals(unitsWidget.getUnitGooruOid())){
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
					unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
					setPersonalizeBtnText(unitTitle);
				}else{
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
				}
				unitPanel.add(unitsWidget);
			}
		}
	}
	/**
	 * This method is used to update the page number
	 */
	private void updatePageNumber(){
		unitsPageNumber++;
		if((limit*unitsPageNumber)<unitsTotalCount){
			lblMoreUnits.setVisible(true);
		}else{
			lblMoreUnits.setVisible(false);
		}
	}
	public class UnitChangeEvent implements ClickHandler{
		private UnitWidget unitsWidget;
		private String unitTitle;
		private int unitNumber;
		public UnitChangeEvent(UnitWidget unitsWidget,String unitTitle,int unitNumber){
			this.unitsWidget=unitsWidget;
			this.unitTitle = unitTitle;
			this.unitNumber = unitNumber;
		}
		@Override
		public void onClick(ClickEvent event) {
			selectedUnitNumber = unitNumber;
			setUnitCollectionId(unitsWidget.getUnitCollectionItemId());
			revealPlace("reports",null,unitsWidget.getUnitGooruOid(),null);
			//setPersonalizeBtnText(unitTitle);
			//removeAndAddUnitSelectedStyle();
		}
	}
	
	public class MiniMumScoreKeyUpHandler implements KeyUpHandler{
		private String scoreVal;
		public MiniMumScoreKeyUpHandler(String scoreVal){
			this.scoreVal=scoreVal;
		}
		@Override
		public void onKeyUp(KeyUpEvent event) {
			String originalScoredVal=minimumScorelbl.getText();
			String minimumScoreBelowVal=minimumScoreBelow.getText().trim();
			String minimumScoreAboveVal=minimumScoreAbove.getText().trim();
			if(originalScoredVal!=null && !originalScoredVal.trim().isEmpty() && !minimumScoreBelowVal.trim().isEmpty() && !minimumScoreAboveVal.trim().isEmpty()){
				originalScoredVal=originalScoredVal.replaceAll("%", "");
				if((Integer.parseInt(originalScoredVal)<Integer.parseInt(minimumScoreAboveVal)) && scoreVal.equalsIgnoreCase(ABOVESCORE)){
					greenProgressBar.getElement().getStyle().setWidth((100-Integer.parseInt(minimumScoreAboveVal)), Unit.PCT);
				}
				if((Integer.parseInt(originalScoredVal)>Integer.parseInt(minimumScoreBelowVal)) && scoreVal.equalsIgnoreCase(BELOWSCORE)){
					orangeProgressBar.getElement().getStyle().setWidth(Integer.parseInt(minimumScoreBelowVal), Unit.PCT);
				}
			}
		}
	}
	 /* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#revealPlace(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	 public void revealPlace(String tabName,String pageNum,String unitId,String assignmentId){
			Map<String,String> params = new HashMap<String,String>();
			String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
			String classpageid="";
			if(pageLocation.equals(PlaceTokens.STUDENT)){
				classpageid=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
				params.put("id", classpageid);
			}
			else{
				classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				params.put("classpageid", classpageid);
			}
		
			if(pageNum!=null){
				params.put("pageNum", pageNum);
			}
			if(tabName!=null){
				params.put("tab", tabName);
			}
			if(unitId!=null){
				params.put("uid", unitId);
			}
			
			PlaceRequest placeRequest=null;
			if(pageLocation.equals(PlaceTokens.STUDENT)){
			  placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.STUDENT, params);	
			}
			else{
				placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			}
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }
	 
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#setBottomStudentsData(java.util.ArrayList)
	 */
	@Override
	public void setBottomStudentsData(ArrayList<GradeJsonData> result) {
		scoredBelowPanel.clear();
		scoreBelowHighlightedStudentsContainer.clear();
		if(result.size()>0)
		{
			if(result.get(0).getUserData() != null)
			{
				scoredBelowPanel.add(new StudentScoredAboveBelowUlPanel(null,true));
				for(int i=0;i<result.get(0).getUserData().size();i++){
					UserDataDo userData=result.get(0).getUserData().get(i);
					scoredBelowPanel.add(new StudentScoredAboveBelowUlPanel(userData,false));
					
					//This is used to set the bottom 3 studetns assignment data
					CollaboratorsDo collaboratorsDo2=new CollaboratorsDo();
					collaboratorsDo2.setGooruUid(userData.getGooruUId());
					collaboratorsDo2.setUsername(userData.getUserName());
					if(userData.getFirstName()!=null){
						collaboratorsDo2.setFirstName(userData.getFirstName());
					}else{
						collaboratorsDo2.setFirstName(userData.getUserName());
					}
					if(userData.getLastName()!=null)
					collaboratorsDo2.setLastName(userData.getLastName());
					if(userData.getEmailId()!=null)
					collaboratorsDo2.setEmailId(userData.getEmailId());
					scoreBelowHighlightedStudentsContainer.add(new AssignmentGoalView(collaboratorsDo2));
				}
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#setTopStudentsData(java.util.ArrayList)
	 */
	@Override
	public void setTopStudentsData(ArrayList<GradeJsonData> result) {
		scoredAbovePanel.clear();
		scoreAboveHighlightedStudentsContainer.clear();
		if(result.size()>0)
		{
			if(result.get(0).getUserData() != null)
			{
				scoredAbovePanel.add(new StudentScoredAboveBelowUlPanel(null,true));
				for(int i=0;i<result.get(0).getUserData().size();i++){
					UserDataDo userData=result.get(0).getUserData().get(i);
					scoredAbovePanel.add(new StudentScoredAboveBelowUlPanel(userData,false));
					//This is used to set the top 3 studetns assignment data
					CollaboratorsDo collaboratorsDo2=new CollaboratorsDo();
					collaboratorsDo2.setGooruUid(userData.getGooruUId());
					collaboratorsDo2.setUsername(userData.getUserName());
					if(userData.getFirstName()!=null){
						collaboratorsDo2.setFirstName(userData.getFirstName());
					}else{
						collaboratorsDo2.setFirstName(userData.getUserName());
					}
					if(userData.getLastName()!=null)
					collaboratorsDo2.setLastName(userData.getLastName());
					if(userData.getEmailId()!=null)
					collaboratorsDo2.setEmailId(userData.getEmailId());
					scoreAboveHighlightedStudentsContainer.add(new AssignmentGoalView(collaboratorsDo2));
				}
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#setGradeCollectionData(java.util.ArrayList)
	 */
	@Override
	public void setGradeCollectionData(ArrayList<GradeJsonData> gradeData) {
		loadcollectionsmap.clear();
		graphWidget.clear();
		if(gradeData.size()>0)
		{
		graphWidget.add(new HCLineChart().chart(gradeData));
		}
		loadCollections.clear();
		if(gradeData!=null){
			for (GradeJsonData gradeJsonData : gradeData) {
				loadcollectionsmap.put(gradeJsonData.getResourceGooruOId(), gradeJsonData);
				loadCollections.addItem(gradeJsonData.getTitle(), gradeJsonData.getResourceGooruOId());
			}
			setMinimumScoresData();
		}
		loadingImageLabel.setVisible(false);
	}
	/**
	 * This will set the unit collection id
	 * @param unitCollectionId
	 */
	public void setUnitCollectionId(String unitCollectionId) {
		this.unitCollectionId = unitCollectionId;
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#getUnitPanel()
	 */
	public HTMLPanel getUnitPanel(){
		return unitPanel;
	}
	/**
	 * This method is used to set the minimum scored data.
	 */
	void setMinimumScoresData(){
		if(loadCollections.getItemCount()!=0){
			int selectedIndex=loadCollections.getSelectedIndex();
			String selectedValue=loadCollections.getValue(selectedIndex);
			int minimunScoreVal=0;
			if(loadcollectionsmap.get(selectedValue).getMinimumScore()!=null){
			    minimunScoreVal=Integer.parseInt(loadcollectionsmap.get(selectedValue).getMinimumScore());
			}
			minimumScorelbl.setText(minimunScoreVal+"%");
			minimumScoreAbove.setText((minimunScoreVal+1)+"");
			minimumScoreBelow.setText((minimunScoreVal==0)?0+"":(minimunScoreVal-1)+"");
			orangeProgressBar.getElement().getStyle().setWidth((minimunScoreVal==0)?0:minimunScoreVal, Unit.PCT);
			greenProgressBar.getElement().getStyle().setWidth(100-(minimunScoreVal+1), Unit.PCT);
		}
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#LoadingImageLabeltrue()
	 */
	@Override
	public void LoadingImageLabeltrue() {
		loadingImageLabel.setVisible(true);
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.IsAnalyticsView#LoadingImageLabelFalse()
	 */
	@Override
	public void LoadingImageLabelFalse() {
		loadingImageLabel.setVisible(false);
	}

	/**
	 * This is used to handle the click event on the personalize button.
	 * @param event
	 */
	@UiHandler("personalizeBtn")
	public void clickOnPersonalizeBtn(ClickEvent event){
		if(isPersonalizedBtnClicked){
			assignmentContainer.setVisible(false);
			personalizeMainContainer.setVisible(false);
			highlightedStudentsContainer.setVisible(false);
			unitOptionsContainer.setVisible(false);
			isPersonalizedBtnClicked=false;
		}else{
			getUiHandlers().getUnitAssignments();
			highlightedStudentsContainer.setVisible(true);
			unitOptionsContainer.setVisible(true);
			isPersonalizedBtnClicked=true;
		}
	}
	
	/**
	 * This is used to set the text for personalized button.
	 * @param unitTitle
	 */
	public void setPersonalizeBtnText(String unitTitle){
		if (unitTitle.length() > 10){
			unitTitle = unitTitle.substring(0, 11) + "...";
		}
		personalizeBtn.setText(StringUtil.generateMessage(i18n.GL2221(), unitTitle));
		StringUtil.setAttributes(personalizeBtn.getElement(), "btnPersonalize", StringUtil.generateMessage(i18n.GL2221(), unitTitle), StringUtil.generateMessage(i18n.GL2221(), unitTitle));
	}
	
	/**
	 * This will set the styles for the data table cells.
	 * @return
	 */
	com.google.gwt.visualization.client.Properties getPropertiesCell(){
			  Properties properties=Properties.create();
			  properties.set("style", "text-align:center;font-weight:bold;background-color: red;");
			  com.google.gwt.visualization.client.Properties p=properties.cast();
			  return p;
	}
}
