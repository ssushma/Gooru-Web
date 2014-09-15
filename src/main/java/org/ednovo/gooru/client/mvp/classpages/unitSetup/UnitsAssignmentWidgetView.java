package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class UnitsAssignmentWidgetView extends Composite {
	
	private static UnitsAssignmentWidgetViewUiBinder uibinder = GWT.create(UnitsAssignmentWidgetViewUiBinder.class);
	interface UnitsAssignmentWidgetViewUiBinder extends UiBinder<Widget, UnitsAssignmentWidgetView>{
		
	}
	
	
	@UiField HTMLPanel assignmentsContainer;
	
	@UiField Button editUnitButton,addAssignmentButton,cancelEditButton;
	
	@UiField Label lblUnitName,lblUnitNumber;
	
	@UiField HTMLEventPanel htPanelNextArrow,htPanelPreviousArrow;
	@UiField Anchor unitDetailsButton;
	
	private ClassUnitsListDo classUnitsDo;
	
	private UnitAssignmentsDo unitAssignmentsDo;
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	boolean isDeleted=false;
	private boolean isEditMode=false;
	
	private boolean isStudentMode=false;
	
	private static final String NEXT="next";
	private static final String PREVIOUS= "previous";
	
	private String pathwayId;
	

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(ClassUnitsListDo classUnitsDo){
		initWidget(uibinder.createAndBindUi(this));
		this.classUnitsDo=classUnitsDo;
		setAssignmentsForUnit();
		setUnitNameDetails();
		cancelEditButton.setVisible(false);
		editUnitButton.addClickHandler(new EditAssignmentEvent());
		cancelEditButton.addClickHandler(new CancelEditEvent());
		unitDetailsButton.addClickHandler(new UnitChangeEvent(classUnitsDo.getResource().getGooruOid(),PlaceTokens.EDIT_CLASSPAGE));
	}
	
	public UnitsAssignmentWidgetView(ClassUnitsListDo classUnitsDo, boolean studentMode){
		initWidget(uibinder.createAndBindUi(this));
		editUnitButton.removeFromParent();
		addAssignmentButton.removeFromParent();
		cancelEditButton.removeFromParent();
		this.classUnitsDo=classUnitsDo;
		setAssignmentsForUnit();
		setUnitNameDetails();
		unitDetailsButton.addClickHandler(new UnitChangeEvent(classUnitsDo.getResource().getGooruOid(),PlaceTokens.STUDENT));
	}



	private void setAssignmentsForUnit() {
		assignmentsContainer.clear();

		if(classUnitsDo!=null){
			for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
				ClasspageItemDo classpageItemDo=classUnitsDo.getResource().getCollectionItems().get(i);
				showAndHidePaginationArrows();
				assignmentsContainer.add(new AssignmentsContainerWidget(classpageItemDo));
			}
		}
	}
	
	private void showAndHidePaginationArrows() {
		System.out.println("classUnitsDo.getResource().getItemCount():"+classUnitsDo.getResource().getItemCount());
		if(classUnitsDo.getResource().getItemCount()>assignmentLimit){
			htPanelNextArrow.setVisible(true);
//			htPanelPreviousArrow.setVisible(true);
		}else{
			htPanelNextArrow.setVisible(false);
			htPanelPreviousArrow.setVisible(false);
		}
	}

	public void clearAssignmentsFromDo(){
		classUnitsDo.getResource().setCollectionItems(new ArrayList<ClasspageItemDo>());
	}
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			isEditMode = true;
			hideEditButton(true);
			assignmentsContainer.clear();
			setAssignmentsEditView(); 
		}
	}
	
	
	public class DeleteAssignment implements ClickHandler{
		String collectionItemId=null;
		
		public DeleteAssignment(String collectionItemId) {
			this.collectionItemId = collectionItemId;
		}

		@Override
		public void onClick(ClickEvent event) {
			final WaitPopupVc popupVc = new WaitPopupVc(i18n.GL1387(),i18n.GL1388()) { 
				@Override
				public void onTextConfirmed() {
					AppClientFactory.getInjector().getClasspageService().deleteClassPageItem(collectionItemId, new SimpleAsyncCallback<String>() {
						@Override
						public void onSuccess(String result) {
							if(result.equals("200")){
								boolean isAssignmentDeleted = deleteAssignmentWidget(collectionItemId);
								if(isAssignmentDeleted){
									clearAssignmentsFromDo();
									hide();
									getUnitAssignments(assignmentOffset,isEditMode);
								}
							}
						}
					});
				}
			};
		}

	}
	
	
	
	public void setAssignmentsEditView() {
		assignmentsContainer.clear();
		for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
			AssignmentEditView assignmentEditView = new AssignmentEditView(classUnitsDo);
			assignmentEditView.getDeleteAssignmentLbl().addClickHandler(new DeleteAssignment(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId()));
			assignmentEditView.getAssignmentReorderLbl().addClickHandler(new ReorderAssignment(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId())); 
			assignmentEditView.setAssignmentId(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId());
			assignmentsContainer.add(assignmentEditView);
		}
	}

	public class ReorderAssignment implements ClickHandler{

		String collectionItem;
		
		public ReorderAssignment(String collectionItem){
			this.collectionItem = collectionItem;
		}
		
		@Override
		public void onClick(ClickEvent event) {
		}
		
	}
	
	
	public class CancelEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			isEditMode = false;
			hideEditButton(false);
			setAssignmentsForUnit();
		}
	}
	
	public class UnitChangeEvent implements ClickHandler{
		private String unitGooruOid;
		private String viewToken;
		public UnitChangeEvent(String unitGooruOid,String viewToken){
			this.unitGooruOid=unitGooruOid;
			this.viewToken=viewToken;
		}
		@Override
		public void onClick(ClickEvent event) {
			revealPlace("unitdetails",null,unitGooruOid,viewToken);
		}
	}
	
	 public void revealPlace(String tabName,String pageNum,String unitId,String viewToken){
			Map<String,String> params = new HashMap<String,String>();
			String classpageid= "";
			if(viewToken.equals(PlaceTokens.STUDENT))
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
			PlaceRequest placeRequest= null;
			placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(viewToken, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }
	
	public void hideEditButton(boolean hide){
		if(hide){
			editUnitButton.getElement().setAttribute("style", "display:none !important");
		}else{
			editUnitButton.getElement().removeAttribute("style");
		}
		addAssignmentButton.setVisible(!hide);
		cancelEditButton.setVisible(hide);
	}
	
	public boolean deleteAssignmentWidget(String collectionItemId) { 
		Iterator<Widget> assignmentContainerWidget = assignmentsContainer.iterator();
		while(assignmentContainerWidget.hasNext()){
			Widget widget = assignmentContainerWidget.next();
			if(widget instanceof AssignmentEditView){
				if(((AssignmentEditView) widget).getAssignmentId().equals(collectionItemId)){
					widget.removeFromParent();
					isDeleted = true;
				}
			}
		}
		return isDeleted;
	}

	private void setUnitNameDetails() {
			int number=classUnitsDo.getItemSequence();
			String sequenceNumber=Integer.toString(number);
			lblUnitName.setText(classUnitsDo.getResource().getTitle());
			lblUnitNumber.setText(sequenceNumber);
	}
	
	@UiHandler("htPanelNextArrow")
	public void clickOnNextArrow(ClickEvent clickEvent){
		clearAssignmentsFromDo();
		getUnitAssignments(getAssignmentOffsetValue(NEXT),isEditMode);
	}
	
	
	private int getAssignmentOffsetValue(String direction) {
		if(direction.equals(NEXT)){
			assignmentOffset = assignmentOffset+assignmentLimit;
		}else{
			assignmentOffset = Math.abs(assignmentOffset-assignmentLimit);
		}
		return assignmentOffset;
	}

	@UiHandler("htPanelPreviousArrow")
	public void clickOnPreviousArrow(ClickEvent clickEvent){
		clearAssignmentsFromDo();
		getUnitAssignments(getAssignmentOffsetValue(PREVIOUS),isEditMode);
	}
	
	public void getUnitAssignments(int assignmentOffset,final boolean isAssignmentEditmode){
		String classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, classUnitsDo.getResource().getGooruOid(), "sequence", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
				if(isAssignmentEditmode){
					setAssignmentsEditView();
				}else{
					setAssignmentsForUnit();
				}
				
				showAndHideAssignmentArrows(result);
			}
		}); 
	}
	
	
	public void addAssignment(ArrayList<ClasspageItemDo> classpageItemDo){ 
		getUnitAssignments(assignmentOffset,false);
	}
	
	/**
	 * @return the pathwayId
	 */
	public String getPathwayId() {
		return pathwayId;
	}



	/**
	 * @param pathwayId the pathwayId to set
	 */
	public void setPathwayId(String pathwayId) {
		this.pathwayId = pathwayId;
	}
	
	
	/**
	 * @return the addAssignmentButton
	 */
	public Button getAddAssignmentButton() {
		return addAssignmentButton;
	}

	
	private void showAndHideAssignmentArrows(UnitAssignmentsDo unitAssignmentsDo) {
		// TODO Auto-generated method stub
		int totalAssignments=unitAssignmentsDo.getTotalHitCount();
		System.out.println("totalAssignments:"+totalAssignments);
		if(Math.abs(totalAssignments-assignmentOffset)>assignmentLimit){
			if(Math.abs(totalAssignments-assignmentOffset)==totalAssignments){
				htPanelPreviousArrow.setVisible(false);
				htPanelNextArrow.setVisible(true);
			}else{
				htPanelPreviousArrow.setVisible(true);
				htPanelNextArrow.setVisible(true);
			}
			
		}else{
			htPanelNextArrow.setVisible(false);
			htPanelPreviousArrow.setVisible(true);
		}
	}

}
