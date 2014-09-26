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
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
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
	
	@UiField Label lblMoreUnits,unitTitleDetails,lblTimeHours,lblTimeMin;
	
	@UiField Anchor unitSetupButton;
	
	@UiField Button btnDashBoard,btnAssignment,btnSetGoal, btnPersonalize;
	
	@UiField Label lblControl,lblGreenControl;
	
	@UiField TextBox txtMinuts,txtHours;
	
	UnitAssignmentCssBundle res;
	
	ClassDo classDo;
	
	ClassUnitsListDo classUnitsListDo;
	
	String unitCollectionId;
	
	private int limit = 5;
	private int unitsPageNumber = 0;
	private int unitsTotalCount = 0;
	
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
		txtHours.getElement().setAttribute("style", "text-align:right");
		txtMinuts.getElement().setAttribute("style", "text-align:right");
		timeLablePanel.setVisible(false);
		
		StringUtil.setAttributes(assignmentContainer.getElement(), "divAssignmentContainer", null, null);
		StringUtil.setAttributes(personalizeContainer.getElement(), "divPersonalizeContainer", null, null);
		StringUtil.setAttributes(btnPersonalize.getElement(), "btnPersonalize", "Personalize Units", "Personalize Units");
		panelPersonalizeButtonContainer.setVisible(false);
		displayPersonalizeOptions(false);
		setPersonalizeState(false);
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
		unitTitleDetails.setText("");
		unitTitleDetails.setText(unitTitle);
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
							unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getTotalHitCount(),unitCricleViewObj.getElement().getId()));
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
				getUnitAssignments(getAssignmentOffsetValue(NEXT),isEditMode);
			}
			else{
				clearAssignmentsFromDo();
				getUnitAssignments(getAssignmentOffsetValue(PREVIOUS),isEditMode);
			}
		}
	}
	
	@Override
	public void getSequence(UnitAssignmentsDo unitAssignmentsDo) {
		this.unitAssignmentsDo = unitAssignmentsDo;
		
		setCircleData(unitAssignmentsDo);
	}
	/*This class is used to display tooltip on assignment for Teacher */
	public class UnitSeqMouseOverHandler implements MouseOverHandler{
		String title;
		String narration;
		int totalHintCount,seqNo;
		String selectedAssignmentId;
		public UnitSeqMouseOverHandler(int seqNo,String title, String narration, int totalHintCount,String selectedAssignmentId) {
			this.title = title;
			this.narration = narration;
			this.totalHintCount = totalHintCount;
			this.selectedAssignmentId = selectedAssignmentId;
			this.seqNo =seqNo;
		}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		unitAssigmentReorder = new UnitAssigmentReorder(seqNo,classDo,title,narration,AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null),selectedUnitNumber,totalHintCount,selectedAssignmentId,AppClientFactory.getPlaceManager().getRequestParameter("uid", null)){
			@Override
			public void reorderAssignment(int seqPosition,String selectedPathId,String targetUnitNumb) { 
				setAssignmentToNewPosition(seqPosition,selectedPathId,totalHintCount);
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
		unitTitleDetails.setText(unitName!=null?unitName:"");
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
	public void getUnitAssignments(int assignmentOffset,final boolean isAssignmentEditmode){
		String classPageId;
		classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classPageId==null){
			classPageId= AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		}
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, unitId, "sequence", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
				if(isAssignmentEditmode){
					//setAssignmentsEditView();
				}else{
					setAssignmentsForUnit(result);
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
	private void setAssignmentsForUnit(UnitAssignmentsDo unitAssignmentsDo) {
		requiredText.setText(i18n.GL2222());
		circleContainerPanel.clear();
		circleContainerPanel.add(requiredText);
		if(classUnitsDo!=null){
			leftArrow.setUrl("images/leftSmallarrow.png");
			leftArrow.getElement().setAttribute("style","margin-left: 10px");
			circleContainerPanel.add(leftArrow);

			for(int i=0;i<unitAssignmentsDo.getSearchResults().size();i++){
				unitCricleViewObj =new UnitCricleView(unitAssignmentsDo.getSearchResults().get(i));
				//unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid()+"");
				unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId());
				circleContainerPanel.add(unitCricleViewObj);
				String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
				if(pageLocation.equals(PlaceTokens.STUDENT)){
					unitCricleViewObj.addMouseOverHandler(new StudentAssignmentMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getPlannedEndDate(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getSearchResults().get(i).getResource().getGooruOid(),unitCricleViewObj.getElement().getId()));
					
				}else{
					unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getTotalHitCount(),unitCricleViewObj.getElement().getId()));
					}
				unitCricleViewObj.addClickHandler(new AssignmentClickChangeEvent(unitCricleViewObj));
				
			
				
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
			
			assignmentContainer.setVisible(false);
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
		assignmentContainer.setVisible(false);
		personalizeContainer.setVisible(false);
		
		revealPlace("dashboard");
		
	}
	
	@UiHandler("btnAssignment")
	public void clickOnAssignement(ClickEvent clickEvent){
		
		btnAssignment.setStyleName(res.unitAssignment().selected());
		btnDashBoard.removeStyleName(res.unitAssignment().selected());
		containerPanel.setVisible(true);
		goalContainer.setVisible(false);
		assignmentContainer.setVisible(false);
		personalizeContainer.setVisible(false);
		revealPlace(ASSIGNMENTS);
	}
	
	public void scoreHederView(ClassUnitsListDo classUnitsListDo) {
		scoreHedingContainer.clear();
		ScoreHedingView scoreHedingView = null;

		ClassUnitsListDo classUnits=getClassUnitsListDo();
		
		if(classUnits==null){
			classUnits=classUnitsListDo;
		}
		for(int i=0; i<2; i++){
			scoreHedingView=new ScoreHedingView(classUnits);
			scoreHedingContainer.add(scoreHedingView);
			if(i==0){
				scoreHedingView.getLblTitle().setText(i18n.GL2195());
			}else{
				scoreHedingView.getLblTitle().setText(i18n.GL2203());
			}
		}
		//txtHours.addBlurHandler(new ScoreHandler());
		txtHours.addKeyPressHandler(scoreHedingView.new HasNumbersOnly());
		txtMinuts.addKeyPressHandler(scoreHedingView.new HasNumbersOnly());
		txtHours.addBlurHandler(new TimeHandler());
		txtMinuts.addBlurHandler(new TimeHandler());
	}
	
	

	@Override
	public void showAssignment(ClasspageItemDo classpageItemDo) {
		assignmentContainer.clear();
		CollectionsView collectionView=new CollectionsView(classpageItemDo){
			@Override
			public void updateAssignmentRequiredStatus(Boolean isRequired,String collectionItemId,String readStatus,boolean isUpdateRequiredStatus){
				if(isUpdateRequiredStatus){
				updateCircleRequiredView(isRequired, collectionItemId);
				}else{
					updateAssingmentCircleReadStatus(isRequired,collectionItemId,readStatus);
				}
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
	
	public void setAssignmentToNewPosition(int pageNumber,String selectedPathId,int totalHintCount){
		
		if(selectedPathId.equalsIgnoreCase(unitId)){
			assignmentOffset =(pageNumber/assignmentLimit)*assignmentLimit;
			if(assignmentOffset==pageNumber){
				assignmentOffset = assignmentOffset-assignmentLimit;
			}
			getUnitAssignments(assignmentOffset,isEditMode);
		}else{
			if(totalHintCount-1==assignmentOffset){
				assignmentOffset=assignmentOffset-assignmentLimit;
			}
			getUnitAssignments(assignmentOffset,isEditMode);
			
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
			assignmentContainer.setVisible(false);
			personalizeContainer.setVisible(false);
		}
		isClickOnAssignment =false;
	}


	@Override
	public void showAssignments() {
		
		// TODO Auto-generated method stub
		htmDashBoardTabs.removeFromParent();
		containerPanel.setVisible(true);
		goalContainer.removeFromParent();
		assignmentContainer.setVisible(true);
		personalizeContainer.setVisible(false);
		
	}
	
	private void setDashBoardIds() {
		lblControl.getElement().setId("controll");
//		lblGreenControl.getElement().setId("greenControll");
	}
	
	public class TimeHandler implements BlurHandler{

		@Override
		public void onBlur(BlurEvent event) {
			String hours = txtHours.getText();
			String min = txtMinuts.getText();
			if((hours != null || hours != "")){
				try{
					if(Integer.parseInt(hours) >24 || Integer.parseInt(hours)<0){
						txtHours.setText(getValidationTime(hours, true));
					}else{

					}

				}catch(NumberFormatException numberFormatException){
					numberFormatException.printStackTrace();
				}

			}
			if(min !=null || min != ""){
				try{
					if(Integer.parseInt(min) >60 || Integer.parseInt(min) <0){
						txtMinuts.setText(getValidationTime(min, false));
					}else{

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

	private String getValidationTime(String time, boolean isHours) {
		// TODO Auto-generated method stub
		if(isHours){
			if(Integer.parseInt(time) >24){
				return "24";
			}
		}else{
			if(Integer.parseInt(time)>60){
				return "60";
			}
		}
		return null;
	}
	
	@UiHandler("btnSetGoal")
	public void clickOnGoalBtn(ClickEvent clickEvent){
		
		if((txtHours.getText()!=null && txtHours.getText()!="")|| (txtMinuts.getText()!=null && txtMinuts.getText()!="") ){
			if(btnSetGoal.getText().equals(SETGOAL)){
				lblTimeHours.setText(txtHours.getText()+" h");
				lblTimeMin.setText(txtMinuts.getText()+" min");
				showAndHideTextBox();
				btnSetGoal.setText(EDITGOAL);
				lblGreenControl.getElement().setId("greenControll");
				lblControl.getElement().setAttribute("style", "-webkit-transform: rotate(-50deg);");
			}else{
				btnSetGoal.setStyleName("primary");
				showAndHideTextBox();
				btnSetGoal.setText(SETGOAL);
			}
			
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
				String unitId=AppClientFactory.getPlaceManager().getRequestParameter("unitId", null);
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
	
}
