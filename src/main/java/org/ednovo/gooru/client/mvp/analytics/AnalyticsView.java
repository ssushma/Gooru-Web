package org.ednovo.gooru.client.mvp.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.analytics.util.StudentScoredAboveBelowUlPanel;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitWidget;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class AnalyticsView extends BaseViewWithHandlers<AnalyticsUiHandlers> implements IsAnalyticsView {

	private static AnalyticsViewUiBinder uiBinder = GWT
			.create(AnalyticsViewUiBinder.class);

	interface AnalyticsViewUiBinder extends UiBinder<Widget, AnalyticsView> {
	}

	AnalyticsCssBundle res;
	
	@UiField VerticalPanel unitPanel;
	
	@UiField Label lblMoreUnits,summaryArrowlbl,progressArrowlbl,responsesArrowlbl;
	
	@UiField HTMLPanel graphWidget,slotWidget,orangeProgressBar,greenProgressBar,blueProgressBar,scoredBelowPanel,scoredAbovePanel;
	
	@UiField Button btnCollectionSummary,btnCollectionProgress,btnCollectionResponses;
	
	@UiField ListBox loadCollections;
	
	@UiField InlineLabel minimumScorelbl;
	
	@UiField TextBox minimumScoreBelow,minimumScoreAbove;
	
	ClasspageListDo classpageListDo;
	
	boolean isSummayClicked=false,isProgressClicked=false;
	
	final String SUMMARY="Summary",PROGRESS="Progress",BELOWSCORE="BelowScore",ABOVESCORE="AboveScore";
	
	private int limit = 5;
	private int offSet = 0;
	String unitId; 
	ClassDo classDo;
	private ClassUnitsListDo classUnitsDo;
	
	public AnalyticsView() {
		this.res = AnalyticsCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));	
		graphWidget.add(new HCBarChart().createLineChart());
		btnCollectionSummary.addClickHandler(new ViewAssignmentClickEvent("Summary"));
		btnCollectionProgress.addClickHandler(new ViewAssignmentClickEvent("Progress"));
		minimumScoreBelow.setText("0");
		minimumScoreAbove.setText("0");
		minimumScoreBelow.addKeyUpHandler(new MiniMumScoreKeyUpHandler(BELOWSCORE));
		minimumScoreAbove.addKeyUpHandler(new MiniMumScoreKeyUpHandler(ABOVESCORE));
	}
	public class ViewAssignmentClickEvent implements ClickHandler{
		private String clicked;
		public ViewAssignmentClickEvent(String clicked){
			this.clicked=clicked;
		}
		@Override
		public void onClick(ClickEvent event) {
			clearDownArrow();
			if(clicked.equalsIgnoreCase(PROGRESS)){
				isSummayClicked=false;
				if(isProgressClicked){
					isProgressClicked=false;
					getUiHandlers().setClickedTabPresenter(null);
				}else{
					isProgressClicked=true;
					getUiHandlers().setClickedTabPresenter(PROGRESS);
					progressArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else if(clicked.equalsIgnoreCase(SUMMARY)){
				isProgressClicked=false;
				if(isSummayClicked){
					isSummayClicked=false;
					getUiHandlers().setClickedTabPresenter(null);
				}else{
					isSummayClicked=true;
					getUiHandlers().setClickedTabPresenter(SUMMARY);
					summaryArrowlbl.addStyleName(res.unitAssignment().activeCaretup());
				}
			}else{
				
			}
		}
	}
	void clearDownArrow(){
		summaryArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		progressArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
		responsesArrowlbl.removeStyleName(res.unitAssignment().activeCaretup());
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
		offSet=offSet+limit;
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
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			ArrayList<ClassUnitsListDo> classListUnitsListDo =classDo.getSearchResults();
			for(int i=0; i<classListUnitsListDo.size(); i++){
				ClassUnitsListDo classListUnitsListDObj=classDo.getSearchResults().get(i);
				classUnitsDo=classListUnitsListDObj;
				//unitTitleDetails.setText(classDo.getSearchResults().get(0).getResource().getTitle());
				UnitWidget unitsWidget=new UnitWidget(classListUnitsListDo.get(i));
				unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget));
				unitPanel.add(unitsWidget);
			}
		}
	}

	public class UnitChangeEvent implements ClickHandler{
		private UnitWidget unitsWidget;
		public UnitChangeEvent(UnitWidget unitsWidget){
			this.unitsWidget=unitsWidget;
		}
		@Override
		public void onClick(ClickEvent event) {
			revealPlace("unitdetails",null,unitsWidget.getUnitGooruOid());
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
			String minimumScoreBelowVal=minimumScoreBelow.getText();
			String minimumScoreAboveVal=minimumScoreAbove.getText();
			if(originalScoredVal!=null && !originalScoredVal.trim().isEmpty()){
				originalScoredVal=originalScoredVal.replaceAll("%", "");
				if((Integer.parseInt(originalScoredVal)<Integer.parseInt(minimumScoreAboveVal)) && scoreVal.equalsIgnoreCase(ABOVESCORE)){
					greenProgressBar.getElement().getStyle().setWidth((100-Integer.parseInt(minimumScoreAboveVal)), Unit.PCT);
					getUiHandlers().getMinimumAboveScoredData();
				}
				if((Integer.parseInt(originalScoredVal)>Integer.parseInt(minimumScoreBelowVal)) && scoreVal.equalsIgnoreCase(BELOWSCORE)){
					orangeProgressBar.getElement().getStyle().setWidth(Integer.parseInt(minimumScoreBelowVal), Unit.PCT);
					getUiHandlers().getMinimumBelowScoredData();
				}
			}
		}
	}
	 public void revealPlace(String tabName,String pageNum,String unitId){
		 	
			Map<String,String> params = new HashMap<String,String>();
			String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
			String classpageid="";
			if(pageLocation.equals(PlaceTokens.STUDENT))
			{
			classpageid=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
			params.put("id", classpageid);
			}
			else
			{
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
			if(pageLocation.equals(PlaceTokens.STUDENT))
			{
				placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.STUDENT, params);	
			}
			else
			{
				placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			}
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }
	 
	@Override
	public void setMinimumAvobeScoredData() {
		scoredAbovePanel.clear();
		for(int i=0;i<3;i++){
			scoredAbovePanel.add(new StudentScoredAboveBelowUlPanel());
		}
	}
	@Override
	public void setMinimumBelowScoredData() {
		scoredBelowPanel.clear();
		for(int i=0;i<3;i++){
			scoredBelowPanel.add(new StudentScoredAboveBelowUlPanel());
		}
	}
}
