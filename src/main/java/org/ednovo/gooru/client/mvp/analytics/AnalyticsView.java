package org.ednovo.gooru.client.mvp.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.util.HCLineChart;
import org.ednovo.gooru.client.mvp.analytics.util.StudentScoredAboveBelowUlPanel;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitWidget;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.util.StringUtil;

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
	
	@UiField HTMLPanel unitPanel;
	
	@UiField Label lblMoreUnits,summaryArrowlbl,progressArrowlbl,responsesArrowlbl;
	
	@UiField HTMLPanel unitOptionsContainer,personalizeContainer,assignmentContainer,graphWidget,slotWidget,orangeProgressBar,greenProgressBar,blueProgressBar,scoredBelowPanel,scoredAbovePanel,loadingImageLabel;
	
	@UiField Button btnCollectionSummary,btnCollectionProgress,btnCollectionResponses,personalizeBtn;
	
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
	private int selectedUnitNumber;
	String unitCollectionId;
	
	String unitId; 
	ClassDo classDo;
	private ClassUnitsListDo classUnitsDo;
	
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
	}
	public class loadCollectionsChangeHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
			//when changing the collections drop down reset all the changes.
			getUiHandlers().setClickedTabPresenter(null,null);
			clearDownArrow();
			setMinimumScoresData();
			String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
			String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			int selectedIndex=loadCollections.getSelectedIndex();
			String collectionId=loadCollections.getValue(selectedIndex);
			getUiHandlers().getBottomAndTopScoresData(classpageId, pathwayId, collectionId);
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
			if(clicked.equalsIgnoreCase(PROGRESS)){
				isSummayClicked=false;
				if(isProgressClicked){
					isProgressClicked=false;
					getUiHandlers().setClickedTabPresenter(null,selectedCollectionId);
				}else{
					isProgressClicked=true;
					getUiHandlers().setClickedTabPresenter(PROGRESS,selectedCollectionId);
					progressArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else if(clicked.equalsIgnoreCase(SUMMARY)){
				isProgressClicked=false;
				if(isSummayClicked){
					isSummayClicked=false;
					getUiHandlers().setClickedTabPresenter(null,selectedCollectionId);
				}else{
					isSummayClicked=true;
					getUiHandlers().setClickedTabPresenter(SUMMARY,selectedCollectionId);
					summaryArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else{
				String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
				String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				getUiHandlers().exportOEPathway(classpageId, pathwayId);
			}
		}
	}
	@Override
	public void clearDownArrow(){
		clearDownArrows();
		isSummayClicked=false;
		isProgressClicked=false;
	}
	public void clearDownArrows(){
		summaryArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		progressArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		responsesArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
	}
	
	@Override
	public void hidePersonalizeContainers(){
		isPersonalizedBtnClicked=false;
		assignmentContainer.setVisible(false);
		personalizeContainer.setVisible(false);
		unitOptionsContainer.setVisible(false);
	}
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
	
	public void addUnitSelectStyle(UnitWidget unitsWidget){
		unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
	}
	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		String currentPlaceToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String classpageid=currentPlaceToken.equals(PlaceTokens.EDIT_CLASSPAGE)?AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null):AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		getUiHandlers().getPathwayUnits(classpageid, limit, (limit*unitsPageNumber),false);
		removeAndAddUnitSelectedStyle();
	}
	public void removeAndAddUnitSelectedStyle(){
		Iterator<Widget> widgets = unitPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitWidget) {
				UnitWidget unitsWidget=(UnitWidget)widget;
				String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", "");
				if(unitId.equals(unitsWidget.getUnitGooruOid())){
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
					unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
				}else{
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
				}
			}
		}		
		
	}
	@Override
	public void hideMoreUnitsLink() {
		
		
	}
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
				personalizeContainer.setVisible(true);
				personalizeContainer.add(content);
			}else{
				slotWidget.setVisible(false);
			}
		}else{
			slotWidget.setVisible(false);
		}
	}

	
	@Override
	public void showUnitNames(ClassDo classDo, boolean clearPanel) {
		this.classDo = classDo;
		unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		if(unitId==null){
			unitId = classDo.getSearchResults().get(0).getResource().getGooruOid();
		}
		if(clearPanel){
			unitPanel.clear();
		}
		unitsTotalCount=classDo.getTotalHitCount();
		updatePageNumber();
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
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
			setPersonalizeBtnText(unitTitle);
			removeAndAddUnitSelectedStyle();
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
	 
	@Override
	public void setBottomAndTopScoresData(ArrayList<GradeJsonData> result) {
		scoredAbovePanel.clear();
		scoredBelowPanel.clear();
		if(result.size()>0)
		{
			if(result.get(0).getUserData() != null)
			{
				for(int i=0;i<result.get(0).getUserData().size();i++){
					UserDataDo userData=result.get(0).getUserData().get(i);
					scoredAbovePanel.add(new StudentScoredAboveBelowUlPanel(userData));
					scoredBelowPanel.add(new StudentScoredAboveBelowUlPanel(userData));
				}
			}
		}
	}
	
	@Override
	public void setGradeCollectionData(ArrayList<GradeJsonData> gradeData) {
		loadcollectionsmap.clear();
		graphWidget.clear();
		graphWidget.add(new HCLineChart().chart(gradeData));
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
	 * @param unitCollectionId the unitCollectionId to set
	 */
	public void setUnitCollectionId(String unitCollectionId) {
		this.unitCollectionId = unitCollectionId;
	}
	public HTMLPanel getUnitPanel(){
		return unitPanel;
	}
	/**
	 * This method is used to set minimum scored data
	 * @param passedScoreVal
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
			orangeProgressBar.getElement().getStyle().setWidth((minimunScoreVal==0)?0:(minimunScoreVal-1), Unit.PCT);
			greenProgressBar.getElement().getStyle().setWidth(100-(minimunScoreVal+1), Unit.PCT);
		}
	}
	@Override
	public void LoadingImageLabeltrue() {
		loadingImageLabel.setVisible(true);
	}
	@Override
	public void LoadingImageLabelFalse() {
		loadingImageLabel.setVisible(false);
	}

	@UiHandler("personalizeBtn")
	public void clickOnPersonalizeBtn(ClickEvent event){
		if(isPersonalizedBtnClicked){
			assignmentContainer.setVisible(false);
			personalizeContainer.setVisible(false);
			unitOptionsContainer.setVisible(false);
			isPersonalizedBtnClicked=false;
		}else{
			getUiHandlers().getUnitAssignments();
			unitOptionsContainer.setVisible(true);
			isPersonalizedBtnClicked=true;
		}
	}
	
	public void setPersonalizeBtnText(String unitTitle){
		if (unitTitle.length() > 10){
			unitTitle = unitTitle.substring(0, 11) + "...";
		}
		personalizeBtn.setText(StringUtil.generateMessage(i18n.GL2221(), unitTitle));
	}
}
