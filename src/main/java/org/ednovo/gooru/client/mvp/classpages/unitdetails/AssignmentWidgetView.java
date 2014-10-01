package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetPersonalizeButtonEvent;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class AssignmentWidgetView extends BaseViewWithHandlers<AssignmentWidgetViewUiHandler> implements IsAssignmentWidget {
	
	private static UnitAssignmentWidgetViewUiBinder uiBinder = GWT
			.create(UnitAssignmentWidgetViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface UnitAssignmentWidgetViewUiBinder extends
			UiBinder<Widget, AssignmentWidgetView> {
	}
	
	@UiField Label unitTitleDetails;
	@UiField HTMLPanel circleContainerPanel,personalizePanel;
	
	UnitAssignmentsDo unitAssignmentsDo;
	Label requiredText =new Label();
	UnitAssigmentReorder unitAssigmentReorder=null;
	private HandlerRegistration leftHandler;
	private HandlerRegistration rightHandler;
	
	UnitAssignmentCssBundle res;
	Image leftArrow = new Image();
	Image rightArrow = new Image();
		
	private String ORDER_BY="sequence";
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	private int totalAssignmentHitcount;
	UnitCricleView unitCricleViewObj;
	private static final String NEXT=i18n.GL1463();
	private static final String PREVIOUS= i18n.GL1462();
	private boolean isEditMode=false;
	private boolean isShowingPopUpforStudent = false;
	UnitAssignentStudentPlayView UnitAssignentStudentPlayView =null;
	private boolean isShowingPopUp = false;
	private boolean isNarrationUpdate=false;
	Map<String,String> descriptionDetails=new HashMap<String,String>();
	private int selectedUnitNumber;
	private ClassUnitsListDo classUnitsDo;
	private ClassDo unitsDo;
	
	public AssignmentWidgetView() {
		setWidget(uiBinder.createAndBindUi(this));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		displayPersonalizeOptions(false);
		requiredText.getElement().setAttribute("style", "display: inline;margin-right: 22px;");
	}

	@Override
	public void displayAssignments(UnitAssignmentsDo unitAssignmentsDo,ClassDo classDo) {
		
		this.unitAssignmentsDo = unitAssignmentsDo;
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			if(unitsDo!=null){
				unitsDo.getSearchResults().addAll(classDo.getSearchResults());
			}else{
				this.unitsDo=classDo;
			}
			
		}
		
		
		if(unitAssignmentsDo!=null){
			setUnitName(unitAssignmentsDo.getTitle());
		}
		displayAssignmentCircle(unitAssignmentsDo);
		
	}
	public void setUnitName(String unitName){
		unitName= unitName!=null?unitName:"";
			if (unitName.length() > 10){
				unitName = unitName.substring(0, 11) + "...";
			}
			unitTitleDetails.setText(unitName);
		}
	
	public void displayAssignmentCircle(UnitAssignmentsDo unitAssignmentsDo){
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
	private void showAndHidePaginationArrows() {
		if(totalAssignmentHitcount>assignmentLimit){
			rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}else{
				leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}
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
	public void clearAssignmentsFromDo(){
		if(classUnitsDo!=null){
			classUnitsDo.getResource().setCollectionItems(new ArrayList<ClasspageItemDo>());
		}
	}
	private int getAssignmentOffsetValue(String direction) {
		
		if(direction.equals(NEXT)){
				assignmentOffset = assignmentOffset+assignmentLimit;
			}else{
				assignmentOffset = Math.abs(assignmentOffset-assignmentLimit);
			}
		
		return assignmentOffset;
		}
	public void getUnitAssignments(int assignmentOffset,final boolean isAssignmentEditmode,final int pagenumber,final int mouseOverAssignmentSeqPos,final String selectedAssignmentId){
		String classPageId;
		classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		
		if(classPageId==null){
			classPageId= AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		}
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, unitId, "sequence", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
			//	classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
				if(isAssignmentEditmode){
					//setAssignmentsEditView();
				}else{
					setAssignmentsForUnit(result,pagenumber,mouseOverAssignmentSeqPos,selectedAssignmentId);
				}
				
				showAndHideAssignmentArrows(result);
			}
		}); 
	}
	private void setAssignmentsForUnit(UnitAssignmentsDo unitAssignmentsDo,int pagenumber,int mouseOverAssignmentSeqPos,String selectedAssignmentId) {
		int toalassignmentSize =unitAssignmentsDo.getTotalHitCount();
		String aid = AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
		requiredText.setText(i18n.GL2222());
		circleContainerPanel.clear();
		getUiHandlers().clearAssignmentWidgetConatiner();
		circleContainerPanel.add(requiredText);
		if(unitAssignmentsDo!=null){
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
					unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler(unitAssignmentsDo.getSearchResults().get(i).getItemSequence(),unitAssignmentsDo.getSearchResults().get(i).getResource().getTitle(),unitAssignmentsDo.getSearchResults().get(i).getNarration(),unitAssignmentsDo.getTotalHitCount(),unitCricleViewObj.getElement().getId(),unitCricleViewObj));
				}
				unitCricleViewObj.addClickHandler(new AssignmentClickChangeEvent(unitCricleViewObj));
				if(pagenumber!=0){
					if(pagenumber==assignmentOffset+i+1){
						String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
						removeAssignmentSelectedStyle();
						addAssignmentSelectStyle(unitCricleViewObj);
						getUiHandlers().clearAssignmentContainer();
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
									removeAssignmentSelectedStyle();
									addAssignmentSelectStyle(unitCricleViewObj);
									getUiHandlers().clearAssignmentContainer();
									String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
									revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);
								}
							}
						else
						{
							if(mouseOverAssignmentSeqPos==assignmentOffset+i+1){
								String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
								removeAssignmentSelectedStyle();
								addAssignmentSelectStyle(unitCricleViewObj);
								getUiHandlers().clearAssignmentContainer();
								String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
								revealPlace("unitdetails", null, unitId, newSeqCollectionItemId);	
								}
						}
					}else{
						
						if(aid.equalsIgnoreCase(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId())){
							String newSeqCollectionItemId = unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId();
							removeAssignmentSelectedStyle();
							addAssignmentSelectStyle(unitCricleViewObj);
							getUiHandlers().clearAssignmentContainer();
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
	 * This class is used to display tooltip on assignment for student
	
	 */

	
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
		isNarrationUpdate=true;
		if(isNarrationUpdate){
			descriptionDetails = getUiHandlers().getGetDirection();
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
	public void setAssignmentToNewPosition(int selectedAssignmentpageNumber,String selectedPathId,int totalHintCount,String selectedAssignmentId,UnitCricleView UnitCricleObj,int mouseOverAssignmentSeqPos){
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("unitId", null);
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
	public class AssignmentClickChangeEvent implements ClickHandler{
		private UnitCricleView unitCricleView;
		public AssignmentClickChangeEvent(UnitCricleView unitCricleView){
			this.unitCricleView = unitCricleView;
		}
		@Override
		public void onClick(ClickEvent event) {
			removeAssignmentSelectedStyle();
			addAssignmentSelectStyle(unitCricleView);
			getUiHandlers().clearAssignmentContainer();
			//isPersonalize = false;
			//displayPersonalizeOptions(isPersonalize);
			//setPersonalizeState(isPersonalize);
			String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
			AppClientFactory.fireEvent(new SetPersonalizeButtonEvent(false));
			revealPlace("unitdetails", null, unitId, unitCricleView.getAssignementId());
		}
	}
	
	public void displayPersonalizeOptions(boolean isPersonalize)
	{
		personalizePanel.setVisible(isPersonalize);
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

	
}
