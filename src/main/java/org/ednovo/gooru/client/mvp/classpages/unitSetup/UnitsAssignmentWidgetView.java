package org.ednovo.gooru.client.mvp.classpages.unitSetup;


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
	
	ClassUnitsListDo classUnitsDo;
	
	private int assignmentOffset=10;
	private int assignmentLimit=10;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(ClassUnitsListDo classUnitsDo){
		initWidget(uibinder.createAndBindUi(this));
		this.classUnitsDo=classUnitsDo;
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
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hideEditButton(true);
			assignmentsContainer.clear();
			for(int i=0;i<9;i++){
				assignmentsContainer.add(new AssignmentEditView());
			}
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
				// TODO Auto-generated method stub
				
			}
		}); 
	}


}
