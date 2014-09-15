package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import java.util.Iterator;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
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
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	boolean isDeleted=false;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(ClassUnitsListDo classUnitsDo, boolean studentMode){
		initWidget(uibinder.createAndBindUi(this));
		this.classUnitsDo=classUnitsDo;
		
		if(studentMode)
		{
			editUnitButton.removeFromParent();
			addAssignmentButton.removeFromParent();
		}
		
		setAssignmentsForUnit();
		setUnitNameDetails();
		cancelEditButton.setVisible(false);
		editUnitButton.addClickHandler(new EditAssignmentEvent());
		cancelEditButton.addClickHandler(new CancelEditEvent());
		unitDetailsButton.addClickHandler(new UnitChangeEvent(classUnitsDo.getResource().getGooruOid()));
	}

	private void setAssignmentsForUnit() {
		assignmentsContainer.clear();

		if(classUnitsDo!=null){
			for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
				ClasspageItemDo classpageItemDo=classUnitsDo.getResource().getCollectionItems().get(i);
				assignmentsContainer.add(new AssignmentsContainerWidget(classpageItemDo));
			}
		}
	}
	
	public void clearAssignmentsFromDo(){
		classUnitsDo.getResource().setCollectionItems(new ArrayList<ClasspageItemDo>());
	}
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
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
									getUnitAssignments();
								}
							}
						}
					});
				}
			};
		}

	}
	
	
	
	public void getPathWayItems() {
		
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
			System.out.println("--- in order --");
		}
		
	}
	
	
	public class CancelEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hideEditButton(false);
			setAssignmentsForUnit();
		}
	}
	
	public class UnitChangeEvent implements ClickHandler{
		private String unitGooruOid;
		public UnitChangeEvent(String unitGooruOid){
			this.unitGooruOid=unitGooruOid;
		}
		@Override
		public void onClick(ClickEvent event) {
			revealPlace("unitdetails",null,unitGooruOid);
		}
	}
	
	 public void revealPlace(String tabName,String pageNum,String unitId){
			Map<String,String> params = new HashMap<String,String>();
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			params.put("classpageid", classpageid);
			if(pageNum!=null){
				params.put("pageNum", pageNum);
			}
			if(tabName!=null){
				params.put("tab", tabName);
			}
			if(unitId!=null){
				params.put("uid", unitId);
			}
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
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
		getUnitAssignments();
	}
	
	
	@UiHandler("htPanelPreviousArrow")
	public void clickOnPreviousArrow(ClickEvent clickEvent){
		getUnitAssignments();
	}
	
	public void getUnitAssignments(){
		String classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, classUnitsDo.getResource().getGooruOid(), "", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
//				setAssignmentsForUnit();
				setAssignmentsEditView();
			}
		}); 
	}


}
