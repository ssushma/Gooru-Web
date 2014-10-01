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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateUnitSetGoalEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateUnitSetGoalHandler;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.client.mvp.search.event.SetPersonalizeButtonEvent;
import org.ednovo.gooru.client.mvp.search.event.SetPersonalizeButtonHandler;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


public class UnitAssignmentView extends BaseViewWithHandlers<UnitAssignmentUiHandlers> implements IsUnitAssignmentView{

	@UiField HTMLPanel assignmentContainer,goalContainer,personalizeContainer, panelPersonalizeButtonContainer;


	private static UnitAssignmentViewUiBinder uiBinder = GWT.create(UnitAssignmentViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface UnitAssignmentViewUiBinder extends UiBinder<Widget, UnitAssignmentView> {
		
	}
	
	@UiField HTMLPanel unitPanel,containerPanel,scoreHedingContainer,htmDashBoardTabs,timeLablePanel,personalizePanel;
	
	@UiField Label lblMoreUnits,unitTitleDetails,lblTimeHours,lblTimeMin,lblTimeValidation;
	
	@UiField Anchor unitSetupButton;
	
	@UiField Button btnDashBoard,btnAssignment,btnSetGoal, btnPersonalize;
	
	@UiField Label lblControl,lblGreenControl;
	
	@UiField TextBox txtMinuts,txtHours;
	
	UnitAssignmentCssBundle res;
	
	private ClassDo classDo;
	
	private ClassDo unitsDo;
	
	ClassUnitsListDo classUnitsListDo;
	
	String unitCollectionId;
	
	private int limit = 5;
	private int unitsPageNumber = 0;
	private int unitsTotalCount = 0;
	
	private String MINUTES= i18n.GL1437();
	private String HOURS= i18n.GL1435();
	
	private String SETGOAL= i18n.GL2197();
	
	private String EDITGOAL= i18n.GL2196();
	
	private String ASSIGNMENTS="assignments";
	private Boolean isClickOnAssignment =false;
	private Boolean isPersonalize = false;
		
	@UiField HTMLPanel circleContainerPanel;

	Image leftArrow = new Image();
	Image rightArrow = new Image();
		
	private String ORDER_BY="sequence";
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	UnitAssigmentReorder unitAssigmentReorder=null;
	private HandlerRegistration leftHandler;
	private HandlerRegistration rightHandler;
	
	private String classpageid;
	UnitAssignmentsDo unitAssignmentsDo;
	boolean isShowing=false;
	UnitCricleView unitCricleViewObj;
	private boolean isShowingPopUp = false;
	private boolean isEditMode=false;
	private boolean isShowingPopUpforStudent = false;
	private ClassUnitsListDo classUnitsDo;
	private static final String NEXT=i18n.GL1463();
	private static final String PREVIOUS= i18n.GL1462();
	String unitId; 
	private int selectedUnitNumber;
	UnitAssignentStudentPlayView UnitAssignentStudentPlayView =null;
	private int totalAssignmentHitcount;
	Label requiredText =new Label();
	CollectionsView collectionView=null;
	private boolean isNarrationUpdate=false;
	Map<String,String> descriptionDetails=new HashMap<String,String>();
	
	int toalassignmentSize=0;
	
	@Inject
	public UnitAssignmentView(){
		setWidget(uiBinder.createAndBindUi(this));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		requiredText.getElement().setAttribute("style", "display: inline;margin-right: 22px;");
		if(pageLocation.equals(PlaceTokens.STUDENT)){
			unitSetupButton.setText(i18n.GL2198());			
		}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
			unitSetupButton.setText(i18n.GL2216());	
		}
		assignmentContainer.setVisible(true);
		lblMoreUnits.setText(i18n.GL2199());
		btnDashBoard.setText(i18n.GL2200());
		btnAssignment.setText(i18n.GL1933());
		unitSetupButton.addClickHandler(new UnitSetupEvents());
		btnDashBoard.setStyleName(res.unitAssignment().selected());

//		requiredLabel.setText(i18n.GL2200());
//		optionalLabel.setText(i18n.GL2201());
		btnSetGoal.setText(i18n.GL2197());

		
		txtHours.getElement().setAttribute("placeholder", "h");
		txtMinuts.getElement().setAttribute("placeholder", "min");
		txtMinuts.setMaxLength(2);
		txtHours.setMaxLength(2);
		txtHours.getElement().setAttribute("style", "text-align:right");
		txtMinuts.getElement().setAttribute("style", "text-align:right");
		timeLablePanel.setVisible(false);
		lblTimeValidation.setVisible(false);
		
		StringUtil.setAttributes(assignmentContainer.getElement(), "divAssignmentContainer", null, null);
		StringUtil.setAttributes(personalizeContainer.getElement(), "divPersonalizeContainer", null, null);
		StringUtil.setAttributes(btnPersonalize.getElement(), "btnPersonalize", "Personalize Units", "Personalize Units");
		panelPersonalizeButtonContainer.setVisible(false);
		displayPersonalizeOptions(false);
		setPersonalizeState(false);
		
		SetPersonalizeButtonHandler handler = new SetPersonalizeButtonHandler() {

			@Override
			public void setPersonalizeButtonEvent(boolean isSelected) {
				setPersonalizeState(isSelected);
				isPersonalize = isSelected;
			}
		};
		
		AppClientFactory.getEventBus().addHandler(SetPersonalizeButtonEvent.TYPE, handler);
		AppClientFactory.getEventBus().addHandler(UpdateUnitSetGoalEvent.TYPE, unitUpdateHandler);
		
	}
	
	public HTMLPanel getUnitPanel(){
		return unitPanel;
	}
	
	public HTMLPanel getCircleContainerPanel(){
		return circleContainerPanel;
	}
	
	public void resetCircleAndAssignmentContainer(String unitTitle){
		circleContainerPanel.clear();
		assignmentContainer.clear();
		setUnitName(unitTitle);
		String tempUntiTitle=unitTitle;
		if (unitTitle.length() > 10){
			tempUntiTitle = unitTitle.substring(0, 11) + "...";
		}
		btnPersonalize.setText(StringUtil.generateMessage(i18n.GL2221(), tempUntiTitle));
		setPersonalizeState(false);
	}
	
	public void resetUnitAssignmentView(){
		circleContainerPanel.clear();
		assignmentContainer.clear();
		unitPanel.clear();
		unitTitleDetails.setText("");
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
			String tempUntiTitle=unitTitle;
			if (unitTitle.length() > 10){
				tempUntiTitle = unitTitle.substring(0, 11) + "...";
			}
			btnPersonalize.setText(StringUtil.generateMessage(i18n.GL2221(), tempUntiTitle));
			selectedUnitNumber = unitNumber;
			resetCircleAndAssignmentContainer(unitTitle);
			setClassUnitsListDo(unitsWidget.getClassUnitDo());
			revealPlace("unitdetails",null,unitsWidget.getUnitGooruOid(),null);
			assignmentOffset=0;
			scoreHederView(unitsWidget.getClassUnitDo());
			removeAndAddUnitSelectedStyle();
		}
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
	
	public void addUnitSelectStyle(UnitWidget unitsWidget){
		unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
	}
	
	
	
	public void setCircleData(UnitAssignmentsDo unitAssignmentsDo){
		requiredText.setText(i18n.GL2222());
		rightArrow.getElement().setAttribute("style", "cursor:pointer");
		leftArrow.getElement().setAttribute("style", "cursor:pointer");
		
		
		
		if(unitAssignmentsDo.getTotalHitCount() != null){
			totalAssignmentHitcount = unitAssignmentsDo.getTotalHitCount();
		}else{
			totalAssignmentHitcount = 0;
		}
		if(unitAssignmentsDo!=null){
			
			if(unitAssignmentsDo.getSearchResults()!=null){
				
				if(unitAssignmentsDo.getSearchResults().size()!=0){
					try{
						if(leftHandler!=null) {
							leftHandler.removeHandler();
						}
						if(rightHandler!=null) {
							rightHandler.removeHandler();
						}
					}catch (AssertionError ae) { }
					
					leftHandler=leftArrow.addClickHandler(new cleckOnNext("left"));
					rightHandler=rightArrow.addClickHandler(new cleckOnNext("right"));
					circleContainerPanel.clear();
					circleContainerPanel.add(requiredText);
					leftArrow.setUrl("images/leftSmallarrow.png");
					leftArrow.getElement().setAttribute("style","margin-left: 10px");
					circleContainerPanel.add(leftArrow);
					for(int i=0;i<unitAssignmentsDo.getSearchResults().size();i++){
						unitCricleViewObj =new UnitCricleView(unitAssignmentsDo.getSearchResults().get(i));
						//unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid());
						unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId());	
						circleContainerPanel.add(unitCricleViewObj);
						String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
						if(pageLocation.equals(PlaceTokens.STUDENT)){
							
							unitCricleViewObj.addMouseOverHandler(new StudentAssignmentMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getPlannedEndDate(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid(),unitCricleViewObj.getElement().getId()));
							
						}else{
							unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getTotalHitCount(),unitCricleViewObj.getElement().getId(),unitCricleViewObj));
						}
						unitCricleViewObj.addClickHandler(new AssignmentClickChangeEvent(unitCricleViewObj));
						String assignmentId=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
						if(assignmentId!=null&&assignmentId.equals(unitCricleViewObj.getAssignementId())){
							unitCricleViewObj.removeStyleName(res.unitAssignment().active());
							unitCricleViewObj.addStyleName(res.unitAssignment().active());
						}
						if(assignmentId==null&&i==0){
							unitCricleViewObj.removeStyleName(res.unitAssignment().active());
							unitCricleViewObj.addStyleName(res.unitAssignment().active());
						}
					}
					rightArrow.setUrl("images/rightSmallarrow.png");
					circleContainerPanel.add(rightArrow);
					Event.addNativePreviewHandler(new NativePreviewHandler() {
				        public void onPreviewNativeEvent(NativePreviewEvent event) {
				        	hidePopup(event);
				          }
				    });
							
				}
			}
		}
		if(totalAssignmentHitcount==0){
			Label noAssignmentlabel = new Label(i18n.GL2202());
			circleContainerPanel.clear();
			circleContainerPanel.add(noAssignmentlabel);
		}
		showAndHideAssignmentArrows(unitAssignmentsDo);
		showAndHidePaginationArrows();
	}
	
	public class AssignmentClickChangeEvent implements ClickHandler{
		private UnitCricleView unitCricleView;
		public AssignmentClickChangeEvent(UnitCricleView unitCricleView){
			this.unitCricleView = unitCricleView;
		}
		@Override
		public void onClick(ClickEvent event) {
			isClickOnAssignment = true;
			removeAssignmentSelectedStyle();
			addAssignmentSelectStyle(unitCricleView);
			assignmentContainer.clear();
			isPersonalize = false;
			displayPersonalizeOptions(isPersonalize);
			setPersonalizeState(isPersonalize);
			String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
			revealPlace("unitdetails", null, unitId, unitCricleView.getAssignementId());
		}
	}
	public void removeAssignmentSelectedStyle(){
		Iterator<Widget> widgets = circleContainerPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitCricleView) {
				UnitCricleView unitCricleView=(UnitCricleView)widget;
				unitCricleView.removeStyleName(res.unitAssignment().active());
			}
		}		
		
	}
	
	public void addAssignmentSelectStyle(UnitCricleView unitCricleView){
		unitCricleView.addStyleName(res.unitAssignment().active());
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			 if(slot==UnitAssignmentPresenter._SLOT){
				 personalizeContainer.clear();
				 personalizeContainer.add(content);
				 personalizeContainer.setVisible(false);
			}else{
			}
		}
	}
	public class cleckOnNext implements ClickHandler{
		String value;
		
		private cleckOnNext(String value){
			this.value = value;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(value=="right"){
				clearAssignmentsFromDo();
				getUnitAssignments(getAssignmentOffsetValue(NEXT),isEditMode,0,0,"");
			}
			else{
				clearAssignmentsFromDo();
				getUnitAssignments(getAssignmentOffsetValue(PREVIOUS),isEditMode,0,0,"");
			}
		}
	}
	
	@Override
	public void getSequence(UnitAssignmentsDo unitAssignmentsDo) {
		this.unitAssignmentsDo = unitAssignmentsDo;
		if(unitAssignmentsDo!=null){
			setUnitName(unitAssignmentsDo.getTitle());
		}
		setCircleData(unitAssignmentsDo);
	}
	/*This class is used to display tooltip on assignment for Teacher */
	public class UnitSeqMouseOverHandler implements MouseOverHandler{
		String title;
		String narration;
		int totalHintCount,seqNo;
		String selectedAssignmentId;
		UnitCricleView UnitCriclevieObj;
		
		public UnitSeqMouseOverHandler(int seqNo,String title, String narration, int totalHintCount,String selectedAssignmentId,UnitCricleView UnitCriclevieObj) {
			this.title = title;
			this.narration = narration;
			this.totalHintCount = totalHintCount;
			this.selectedAssignmentId = selectedAssignmentId;
			this.seqNo =seqNo;
			this.UnitCriclevieObj = UnitCriclevieObj;
			
			
		}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		if(isNarrationUpdate){
			narration=descriptionDetails.get(selectedAssignmentId)!=null?descriptionDetails.get(selectedAssignmentId):narration;
		}
			unitAssigmentReorder = new UnitAssigmentReorder(seqNo,unitsDo,title,narration,AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null),selectedUnitNumber,totalHintCount,selectedAssignmentId,AppClientFactory.getPlaceManager().getRequestParameter("uid", null)){
			@Override
			public void reorderAssignment(int seqPosition,String selectedPathId,String targetUnitNumb,String selectedAssignmentId) { 
				setAssignmentToNewPosition(seqPosition,selectedPathId,totalHintCount,selectedAssignmentId,UnitCriclevieObj,seqNo);
			}
		};
		unitAssigmentReorder.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-128,event.getRelativeElement().getAbsoluteTop()+40);
		unitAssigmentReorder.show();
		isShowingPopUp = true;
		}
	}
	/*This class is used to display tooltip on assignment for student*/
	
	public class StudentAssignmentMouseOverHandler implements MouseOverHandler{
		int seqNumber;
		String title,direction,collectionId,collectionItemId;
		Long dueDate;
		public StudentAssignmentMouseOverHandler(int seqNumber,String title,Long dueDate,String direction,String collectionId,String collectionItemId){
			this.seqNumber = seqNumber;
			this.title = title;
			this.dueDate = dueDate;
			this.direction = direction;
			this.collectionId = collectionId;
			this.collectionItemId = collectionItemId;
			
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			UnitAssignentStudentPlayView = new UnitAssignentStudentPlayView(seqNumber,title,dueDate,direction,collectionId,collectionItemId);
			
			UnitAssignentStudentPlayView.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-128,event.getRelativeElement().getAbsoluteTop()+40);
			UnitAssignentStudentPlayView.show();
			isShowingPopUpforStudent = true;
		}
		
	}
	
	
	public void hidePopup(NativePreviewEvent event){
		try{
    	if(event.getTypeInt()==Event.ONMOUSEOVER){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	boolean target=eventTargetsPopup(nativeEvent);
        	if(!target)
        	{
        		if(isShowingPopUp){
        			unitAssigmentReorder.hide();
        		}
        		
    	   	}
        	boolean targetStu=eventTargetsPopupStudent(nativeEvent);
        	if(!targetStu){
    		if(isShowingPopUpforStudent){
    			UnitAssignentStudentPlayView.hide();
    		}
        	}
    	}
		}catch(Exception ex){ex.printStackTrace();}
     }
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			try{
				return unitAssigmentReorder.getElement().isOrHasChild(Element.as(target));
			}catch(Exception ex){}
		}
		return false;
	}
	private boolean eventTargetsPopupStudent(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			try{
				return UnitAssignentStudentPlayView.getElement().isOrHasChild(Element.as(target));
			}catch(Exception ex){}
		}
		return false;
	}
	@Override
	public void showUnitNames(ClassDo classDo,boolean clearPanel) {
		this.classDo = classDo;
		unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		if(unitId==null){
			unitId = classDo.getSearchResults().get(0).getResource().getGooruOid();
		}
		if(clearPanel){
			unitPanel.clear();
			unitsPageNumber=0;
			unitsDo=null;
		}
		if(unitsDo!=null){
			unitsDo.getSearchResults().addAll(classDo.getSearchResults());
		}else{
			this.unitsDo=classDo;
		}
		unitsTotalCount=classDo.getTotalHitCount();
		updatePageNumber();
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			String tempUntiTitle=classDo.getSearchResults().get(0).getResource().getTitle();
			if (tempUntiTitle.length() > 10){
				tempUntiTitle = tempUntiTitle.substring(0, 11) + "...";
			}
			btnPersonalize.setText(StringUtil.generateMessage(i18n.GL2221(), tempUntiTitle));
			
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
				classListUnitsListDo.get(i).setItemSequence(unitPanel.getWidgetCount()+1);
				UnitWidget unitsWidget=new UnitWidget(classListUnitsListDo.get(i));
				unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget,unitTitle,unitNumber));
				if(unitId!=null&&unitId.equals(unitsWidget.getUnitGooruOid())){
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
					unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
				}else{
					unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
				}
				unitPanel.add(unitsWidget);
			}

		}
	}

	public void setUnitName(String unitName){
	unitName= unitName!=null?unitName:"";
		if (unitName.length() > 10){
			unitName = unitName.substring(0, 11) + "...";
		}
		unitTitleDetails.setText(unitName);
	}
	public void getUnitsPanel(){
		unitPanel.clear();
	}
	@Override
	public void getPathwayItems(){
		classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		getUiHandlers().getPathwayItems(classpageid, unitId, ORDER_BY, assignmentLimit, assignmentOffset);
	}
	
	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		String currentPlaceToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String classpageid=currentPlaceToken.equals(PlaceTokens.EDIT_CLASSPAGE)?AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null):AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		getUiHandlers().getPathwayUnits(classpageid, limit, (limit*unitsPageNumber),false);
		removeAndAddUnitSelectedStyle();
	}

	private void updatePageNumber(){
		unitsPageNumber++;
		if((limit*unitsPageNumber)<unitsTotalCount){
			lblMoreUnits.setVisible(true);
		}else{
			lblMoreUnits.setVisible(false);
		}
	}
	@Override
	public void hideMoreUnitsLink() {
		lblMoreUnits.setVisible(false);
	}

	 private class UnitSetupEvents implements ClickHandler{
			@Override
			public void onClick(ClickEvent event) {
				revealPlace("unitsetup","1",null,null);
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
			if(assignmentId!=null){
				params.put("aid", assignmentId);
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
	public void showMoreUnitsLink(){
		lblMoreUnits.setVisible(true);
	}
	
	public void resetPanels(){
		hideMoreUnitsLink();
	}

	private void showAndHideAssignmentArrows(UnitAssignmentsDo unitAssignmentsDo) {
		int totalAssignments=0;
		if(unitAssignmentsDo.getTotalHitCount() != null)
		{
			totalAssignments = unitAssignmentsDo.getTotalHitCount();
		}
		
		
		if(Math.abs(totalAssignments-assignmentOffset)>assignmentLimit){
			if(Math.abs(totalAssignments-assignmentOffset)==totalAssignments){
				leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}else{
				leftArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}
			
		}else{
			leftArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
		if(totalAssignments<=10){
			leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
		
	}
	private void showAndHidePaginationArrows() {
	if(totalAssignmentHitcount>assignmentLimit){
		rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
		}else{
			leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
	}
	public void getUnitAssignments(int assignmentOffset,final boolean isAssignmentEditmode,final int pagenumber,final int mouseOverAssignmentSeqPos,final String selectedAssignmentId){
		String classPageId;
		classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classPageId==null){
			classPageId= AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		}
		unitId = AppClientFactory.getPlaceManager().getRequestParameter("uid",null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, unitId, "sequence", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
				if(isAssignmentEditmode){
					//setAssignmentsEditView();
				}else{
					setAssignmentsForUnit(result,pagenumber,mouseOverAssignmentSeqPos,selectedAssignmentId);
				}
				
				showAndHideAssignmentArrows(result);
			}
		}); 
	}
	public void clearAssignmentsFromDo(){
		classUnitsDo.getResource().setCollectionItems(new ArrayList<ClasspageItemDo>());
	}
	private int getAssignmentOffsetValue(String direction) {
		
	if(direction.equals(NEXT)){
			assignmentOffset = assignmentOffset+assignmentLimit;
		}else{
			assignmentOffset = Math.abs(assignmentOffset-assignmentLimit);
		}
	
	return assignmentOffset;
	}
	private void setAssignmentsForUnit(UnitAssignmentsDo unitAssignmentsDo,int pagenumber,int mouseOverAssignmentSeqPos,String selectedAssignmentId) {
		toalassignmentSize =unitAssignmentsDo.getTotalHitCount();
		String aid = AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
		requiredText.setText(i18n.GL2222());
		circleContainerPanel.clear();
		circleContainerPanel.add(requiredText);
		if(classUnitsDo!=null){
			leftArrow.setUrl("images/leftSmallarrow.png");
			leftArrow.getElement().setAttribute("style","margin-left: 10px");
			circleContainerPanel.add(leftArrow);
			if(unitAssignmentsDo.getSearchResults().size()>0&&aid==null){
				aid=unitAssignmentsDo.getSearchResults().get(0).getCollectionItemId();
			}
			for(int i=0;i<unitAssignmentsDo.getSearchResults().size();i++){
				unitCricleViewObj =new UnitCricleView(unitAssignmentsDo.getSearchResults().get(i));
				//unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid()+"");
				unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId());
				circleContainerPanel.add(unitCricleViewObj);
				String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
				if(pageLocation.equals(PlaceTokens.STUDENT)){
					unitCricleViewObj.addMouseOverHandler(new StudentAssignmentMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getPlannedEndDate(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid(),unitCricleViewObj.getElement().getId()));
				}else{
					unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getTotalHitCount(),unitCricleViewObj.getElement().getId(),unitCricleViewObj));
				}
				unitCricleViewObj.addClickHandler(new AssignmentClickChangeEvent(unitCricleViewObj));
				if(pagenumber!=0){
					if(pagenumber==assignmentOffset+i+1){
						String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
						assignmentContainer.clear();
						removeAssignmentSelectedStyle();
						addAssignmentSelectStyle(unitCricleViewObj);
						isPersonalize = false;
						displayPersonalizeOptions(isPersonalize);
						setPersonalizeState(isPersonalize);
						String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
						revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);
					}
				}
				if(mouseOverAssignmentSeqPos!=0)
				{
						if(selectedAssignmentId.equalsIgnoreCase(aid)){
							if(mouseOverAssignmentSeqPos > toalassignmentSize){
								mouseOverAssignmentSeqPos = mouseOverAssignmentSeqPos-1;
								if(mouseOverAssignmentSeqPos==assignmentOffset+i+1){
									String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
									assignmentContainer.clear();
									removeAssignmentSelectedStyle();
									addAssignmentSelectStyle(unitCricleViewObj);
									isPersonalize = false;
									displayPersonalizeOptions(isPersonalize);
									setPersonalizeState(isPersonalize);
									String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
									revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);
								}
							}
						else
						{
							if(mouseOverAssignmentSeqPos==assignmentOffset+i+1){
								String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
								assignmentContainer.clear();
								removeAssignmentSelectedStyle();
								addAssignmentSelectStyle(unitCricleViewObj);
								isPersonalize = false;
								displayPersonalizeOptions(isPersonalize);
								setPersonalizeState(isPersonalize);
								String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
								revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);	
								}
						}
					}else{
						
						if(aid.equalsIgnoreCase(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId())){
							String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
							assignmentContainer.clear();
							removeAssignmentSelectedStyle();
							addAssignmentSelectStyle(unitCricleViewObj);
							isPersonalize = false;
							displayPersonalizeOptions(isPersonalize);
							setPersonalizeState(isPersonalize);
							String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
							revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);
						}
					}
				}
				
				
			}
			
			rightArrow.setUrl("images/rightSmallarrow.png");
			circleContainerPanel.add(rightArrow);
		
		}			
			
	}
	/**
	 * 
	 * @function setPersonalizeState 
	 * 
	 * @created_date : 25-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * @param state
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setPersonalizeState(boolean state){
		if (state){			
			btnPersonalize.getElement().replaceClassName("primary", "secondary");
			btnPersonalize.getElement().addClassName("personalizeBorder");
		}else{			
			btnPersonalize.getElement().replaceClassName("secondary", "primary");
			btnPersonalize.getElement().removeClassName("personalizeBorder");			
		}
	}

	@UiHandler("btnPersonalize")
	public void clickOnPersonalize(ClickEvent event){
		containerPanel.setVisible(true);
		goalContainer.setVisible(false);
		if (!isPersonalize){
			isPersonalize = true;
			
			assignmentContainer.setVisible(true);
			personalizeContainer.setVisible(true);
		}else{
			isPersonalize = false;
			
			assignmentContainer.setVisible(true);
			personalizeContainer.setVisible(false);
		}
		setPersonalizeState(isPersonalize);
		displayPersonalizeOptions(isPersonalize);
	}
	@UiHandler("btnDashBoard")
	public void clickOnDashBoard(ClickEvent clickEvent){
		btnDashBoard.setStyleName(res.unitAssignment().selected());
		btnAssignment.removeStyleName(res.unitAssignment().selected());
		containerPanel.setVisible(false);
		goalContainer.setVisible(true);
		assignmentContainer.setVisible(true);
		personalizeContainer.setVisible(false);
		
		revealPlace("dashboard");
		
	}
	
	@UiHandler("btnAssignment")
	public void clickOnAssignement(ClickEvent clickEvent){
		assignmentContainer.setVisible(true);
		btnAssignment.setStyleName(res.unitAssignment().selected());
		btnDashBoard.removeStyleName(res.unitAssignment().selected());
		containerPanel.setVisible(true);
		goalContainer.setVisible(false);	
		personalizeContainer.setVisible(false);
		revealPlace(ASSIGNMENTS);
	}
	
	@Override
	public void scoreHederView(ClassUnitsListDo classUnitsListDo) {
		scoreHedingContainer.clear();
		ScoreHedingView scoreHedingView = null;

		ClassUnitsListDo classUnits=getClassUnitsListDo();
		
		if(classUnits==null){
			classUnits=classUnitsListDo;
		}
		setClassUnitsListDo(classUnits);
		for(int i=0; i<2; i++){
			scoreHedingView=new ScoreHedingView(classUnits);
			if(i==0){
				scoreHedingView.getLblTitle().setText(i18n.GL2195());
			}else{
				scoreHedingView.getLblTitle().setText(i18n.GL2203());
			}
			scoreHedingView.showUnitStatus();
			scoreHedingContainer.add(scoreHedingView);
		}
		showUnitsStudyingTime(classUnits);
		txtHours.addKeyPressHandler(scoreHedingView.new HasNumbersOnly());
		txtMinuts.addKeyPressHandler(scoreHedingView.new HasNumbersOnly());
		txtHours.addBlurHandler(new TimeHandler());
		txtMinuts.addBlurHandler(new TimeHandler());
	}
	
	/**
	 * To set the Unit Study time 
	 * @param classUnits {@link ClassUnitsListDo}
	 */

	private void showUnitsStudyingTime(ClassUnitsListDo classUnits) {
		// TODO Auto-generated method stub
		if(classUnits!=null && classUnits.getTimeStudying()!=null && !classUnits.getTimeStudying().equals("")){
			String timeOfStudying=classUnits.getTimeStudying();
			String[] timeSplit =timeOfStudying.split(" ");
			showAndHideTextBox();
			if(timeSplit!=null){
				if(timeSplit.length==1){
					if(timeSplit[0].contains("hrs")){
						txtHours.setText(timeSplit[0]);
						txtMinuts.setText("");
					}else{
						txtMinuts.setText(timeSplit[0]);
						txtHours.setText("");
					}
				}else{
					txtHours.setText(timeSplit[0]);
					txtMinuts.setText(timeSplit[1]);
				}
			}
			System.out.println("::::"+txtHours.getText().replace("hrs", "h"));
			timeLablePanel.setVisible(true);
			lblTimeHours.setText(txtHours.getText().replace("hrs", "h"));
			lblTimeMin.setText(txtMinuts.getText());
			txtHours.setText(txtHours.getText().replace("hrs", ""));
			txtMinuts.setText(txtMinuts.getText().replace("min", ""));
			txtHours.setVisible(false);
			txtMinuts.setVisible(false);
			btnSetGoal.setStyleName("secondary");
			btnSetGoal.setText(EDITGOAL);
			System.out.println("showUnitsstydingtime");
			lblControl.getElement().setAttribute("style", "-webkit-transform: rotate(-50deg);");
		}else{
			System.out.println("enter:::::::::else");
			txtHours.setVisible(true);
			txtMinuts.setVisible(true);
			txtHours.setText("");
			txtMinuts.setText("");
			timeLablePanel.setVisible(false);
			btnSetGoal.setStyleName("primary");
			btnSetGoal.setText(SETGOAL);
		}
		
	}

	@Override
	public void showAssignment(ClasspageItemDo classpageItemDo) {
		assignmentContainer.clear();
		 collectionView=new CollectionsView(classpageItemDo){
			@Override
			public void updateAssignmentRequiredStatus(Boolean isRequired,String collectionItemId,String readStatus,boolean isUpdateRequiredStatus){
				if(isUpdateRequiredStatus){
				updateCircleRequiredView(isRequired, collectionItemId);
				}else{
					updateAssingmentCircleReadStatus(isRequired,collectionItemId,readStatus);
				}
			}
			@Override
			public void updateAssignmentDirection(String collectionItemId,String direction){
				isNarrationUpdate=true;	
				descriptionDetails.put(collectionItemId, direction);
			}
		};
		assignmentContainer.add(collectionView);
	}
	
	public void updateCircleRequiredView(Boolean isRequired,String collectionItemId){
		Iterator<Widget> widgets = circleContainerPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitCricleView) {
				UnitCricleView unitCricleView=(UnitCricleView)widget;
				if(unitCricleView.getAssignementId().equals(collectionItemId)){
					unitCricleView.showCircle(isRequired);
					return;
				}
			}
		}		
	}
	public void updateAssingmentCircleReadStatus(Boolean isRequired,String collectionItemId,String readStatus){
		Iterator<Widget> widgets = circleContainerPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitCricleView) {
				UnitCricleView unitCricleView=(UnitCricleView)widget;
				if(unitCricleView.getAssignementId().equals(collectionItemId)){
					unitCricleView.assignmentReadStatus(isRequired,readStatus);
					return;
				}
			}
		}		
	}
	
	public void setAssignmentToNewPosition(int selectedAssignmentpageNumber,String selectedPathId,int totalHintCount,String selectedAssignmentId,UnitCricleView UnitCricleObj,int mouseOverAssignmentSeqPos){
		unitId = AppClientFactory.getPlaceManager().getRequestParameter("uid",null);
		if(selectedPathId.equalsIgnoreCase(unitId)){
			assignmentOffset =(selectedAssignmentpageNumber/assignmentLimit)*assignmentLimit;
			if(assignmentOffset==selectedAssignmentpageNumber){
				assignmentOffset = assignmentOffset-assignmentLimit;
			}
			getUnitAssignments(assignmentOffset,isEditMode,selectedAssignmentpageNumber,0,"");
		}else{
			if(totalHintCount-1==assignmentOffset){
				assignmentOffset=assignmentOffset-assignmentLimit;
			}
			getUnitAssignments(assignmentOffset,isEditMode,0,mouseOverAssignmentSeqPos,selectedAssignmentId);
						
		}
		
	}


	@Override
	public void showDashBoard() {
		if(!isClickOnAssignment){
			goalContainer.setVisible(true);
			containerPanel.setVisible(false);
			assignmentContainer.setVisible(true);
			personalizeContainer.setVisible(false);
//			scoreHederView();
			setDashBoardIds();
			htmDashBoardTabs.setVisible(true);
			btnDashBoard.setStyleName(res.unitAssignment().selected());
			btnAssignment.removeStyleName(res.unitAssignment().selected());
		}
		String isAssign=AppClientFactory.getPlaceManager().getRequestParameter("tabname",null);
		if(isAssign!=null && isAssign.equals(ASSIGNMENTS)){
			btnAssignment.setStyleName(res.unitAssignment().selected());
			btnDashBoard.removeStyleName(res.unitAssignment().selected());
			containerPanel.setVisible(true);
			goalContainer.setVisible(false);
			assignmentContainer.setVisible(true);
			personalizeContainer.setVisible(false);
		}
		isClickOnAssignment =false;
	}


	@Override
	public void showAssignments() {
		
		htmDashBoardTabs.removeFromParent();
		containerPanel.setVisible(true);
		goalContainer.removeFromParent();
		assignmentContainer.setVisible(true);
		personalizeContainer.setVisible(false);
		
	}
	
	private void setDashBoardIds() {
		lblControl.getElement().setId("controll");
	}
	
	public class TimeHandler implements BlurHandler{

		@Override
		public void onBlur(BlurEvent event) {
			String hours = txtHours.getText();
			String min = txtMinuts.getText();
			if((hours != null ||!hours.isEmpty())){
				try{
					/*if(Integer.parseInt(hours) >24 || Integer.parseInt(hours)<0){
//						txtHours.setText(getValidationTime(hours, true));
						setTimeValidation(i18n.GL2251());
					}else{
						txtHours.getElement().setAttribute("style", "border-color: #efefef !important;");
					    txtMinuts.getElement().setAttribute("style", "border-color: #efefef !important;");
						lblTimeValidation.setVisible(false);
					}*/

				}catch(NumberFormatException numberFormatException){
					numberFormatException.printStackTrace();
				}

			}
			if(min !=null || min != ""){
				try{
					if(Integer.parseInt(min) >59 || Integer.parseInt(min) <0){
//						txtMinuts.setText(getValidationTime(min, false));
						setTimeValidation(i18n.GL2251(),MINUTES);
					}else{
						txtHours.getElement().setAttribute("style", "border-color: #efefef !important;");
						txtMinuts.getElement().setAttribute("style", "border-color: #efefef !important;");
						lblTimeValidation.setVisible(false);
					}
				}catch(Exception exception){

				}

			}

		}

	}
	/**
	 * Get the valid Unit completion time.
	 * @param time @string
	 * @param isHours 
	 * @return validation time
	 */

	private boolean getvalidationTime() {
		// TODO Auto-generated method stub
		boolean valid=true;
		if(txtMinuts.getText().isEmpty()){
			setTimeValidation(i18n.GL2255(), MINUTES);
			valid=false;
		}
		if(txtHours.getText().isEmpty()){
			setTimeValidation(i18n.GL2254(), HOURS);
			valid=false;
		}
		if(Integer.parseInt(txtMinuts.getText())>59){
			setTimeValidation(i18n.GL2251(), MINUTES);
			valid=false;
		}
		return valid;
	}
	
	@UiHandler("btnSetGoal")
	public void clickOnGoalBtn(ClickEvent clickEvent){
		if((txtHours.getText()!=null && !txtHours.getText().equals(""))|| (txtMinuts.getText()!=null && !txtMinuts.getText().equals(""))){
			try{
				if(btnSetGoal.getText().equals(SETGOAL)){
					if(getvalidationTime()){
						txtHours.getElement().setAttribute("style", "border-color: #efefef !important;");
						txtMinuts.getElement().setAttribute("style", "border-color: #efefef !important;");
						lblTimeValidation.setVisible(false);
						if(txtHours.getText().isEmpty() && !txtMinuts.getText().isEmpty()){
							lblTimeHours.setText(txtHours.getText());
							lblTimeMin.setText(txtMinuts.getText()+" min");
						}
						if(txtMinuts.getText().isEmpty() && !txtHours.getText().isEmpty()){
							lblTimeMin.setText(txtMinuts.getText());
							lblTimeHours.setText(txtHours.getText()+" h");
						}
						if(!txtHours.getText().isEmpty()&& !txtMinuts.getText().isEmpty())
						{
							lblTimeHours.setText(txtHours.getText()+" h");
							lblTimeMin.setText(txtMinuts.getText()+" min");
						}
						if(txtHours.getText().isEmpty()&& txtMinuts.getText().isEmpty()){
							lblTimeHours.setText(txtHours.getText());
							lblTimeMin.setText(txtMinuts.getText());
						}
						showAndHideTextBox();
						btnSetGoal.setStyleName("secondary");
						btnSetGoal.setText(EDITGOAL);
						if(getClassUnitsListDo().getCollectionItemId()!=null){
							String hours = "", minutes="";
							if(txtHours.getText()!=null && !txtHours.getText().equals("")){
								hours=txtHours.getText()+ "hrs ";
							}
							if(txtMinuts.getText()!=null && !txtMinuts.getText().equals("")){
								minutes=txtMinuts.getText()+ "min";
							}
							String time =hours+minutes;
							getUiHandlers().updateUnitstatus(getClassUnitsListDo().getCollectionItemId(), null, null,time);
						}
						lblControl.getElement().setAttribute("style", "-webkit-transform: rotate(-50deg);");
					}
				}else{
					btnSetGoal.setStyleName("primary");
					showAndHideTextBox();
					btnSetGoal.setText(SETGOAL);
					System.out.println("txtMinuts:"+txtMinuts.getText());
					System.out.println("texthours:"+txtHours.getText());
				}

			}catch(Exception e){

			}

		}else{
			System.out.println("validations");
			setTimeValidation(i18n.GL2250(),"");
		}

	}

	/*
	 * show and hide text boxes
	 */
	public void showAndHideTextBox(){
		if(btnSetGoal.getText().equals(SETGOAL)){
			txtHours.setVisible(false);
			txtMinuts.setVisible(false);
			timeLablePanel.setVisible(true);
		}else{
			txtHours.setVisible(true);
			txtMinuts.setVisible(true);
			timeLablePanel.setVisible(false);
		}
	}
	
	/**
	 * To set the time validation msgs
	 */
	private void setTimeValidation(String msg, String type) {
		System.out.println("enter");
		if(!type.isEmpty()){
			if(type.equals(MINUTES)){
				txtMinuts.getElement().setAttribute("style", "border-color: #FBB03B !important;");
			}else{
				txtHours.getElement().setAttribute("style", "border-color: #FBB03B !important;");
			}
		}
		
		lblTimeValidation.setVisible(true);
		lblTimeValidation.setStyleName("errorMessage");
		lblTimeValidation.setText(msg);
	}
	
	UpdateUnitSetGoalHandler unitUpdateHandler = new UpdateUnitSetGoalHandler() {
		
		@Override
		public void updateUnitSetGoal(int minimumScoreByUser, int assignmentStatus,
				String timeStudying) {
			System.out.println("unithandleer");
			if(assignmentStatus!=0){
				classUnitsListDo.setAssignmentCompleted(assignmentStatus);
			}
			if(minimumScoreByUser!=0){
				classUnitsListDo.setMinimumScoreByUser(minimumScoreByUser);
			}
			if(timeStudying!=null){
				classUnitsListDo.setTimeStudying(timeStudying);
			}
			
		}
	};
	

	/**
	 * @return the unitCollectionId
	 */
	public String getUnitCollectionId() {
		return unitCollectionId;
	}

	/**
	 * @param unitCollectionId the unitCollectionId to set
	 */
	public void setUnitCollectionId(String unitCollectionId) {
		this.unitCollectionId = unitCollectionId;
	}

	/**
	 * @return the classUnitsListDo
	 */
	public ClassUnitsListDo getClassUnitsListDo() {
		return classUnitsListDo;
	}

	/**
	 * @param classUnitsListDo the classUnitsListDo to set
	 */
	public void setClassUnitsListDo(ClassUnitsListDo classUnitsListDo) {
		this.classUnitsListDo = classUnitsListDo;
	}
	
	public void displayPersonalizeOptions(boolean isPersonalize)
	{
		personalizePanel.setVisible(isPersonalize);
	}
	
	/**
	 * On click of DashBoard/Assignment details it reveals the pathway details page.
	 * 
	 * @param tabName {@link String}
	 */
	 public void revealPlace(String tabName){
			Map<String,String> params = new HashMap<String,String>();
				String id=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
				params.put("id", id);
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				params.put("pageNum", pageNum);
				String sequenceNumber=AppClientFactory.getPlaceManager().getRequestParameter("seqnumber", null);
				String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
				String tab=AppClientFactory.getPlaceManager().getRequestParameter("tab", null);
			
			if(tab!=null){
				params.put("tab", tab);
			}
			if(tabName!=null){
				params.put("tabname", tabName);
			}
			if(unitId!=null){
				params.put("uid", unitId);
			}
			if(sequenceNumber!=null){
				params.put("seqnumber", sequenceNumber);
			}
			PlaceRequest placeRequest= null;
			placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.STUDENT, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }

	@Override
	public HTMLPanel getAssignmentPanel() {
		// TODO Auto-generated method stub
		return assignmentContainer;
	}
	
	@Override
	public void setCollectionSummaryData(CollectionSummaryMetaDataDo collectionSummaryMetaDataDo) {
		if(collectionView!=null){
			collectionView.setCollectionSummaryData(collectionSummaryMetaDataDo);
		}
		
	}
	
}
