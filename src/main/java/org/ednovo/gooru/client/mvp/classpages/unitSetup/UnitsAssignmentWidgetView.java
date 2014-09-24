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

package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshPathwayItemsEvent;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitAssigmentReorder;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
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
	
	
	@UiField HTMLPanel assignmentsContainer,loadingImageLabel;
	
	@UiField Button editUnitButton,addAssignmentButton,cancelEditButton;
	
	@UiField Label lblUnitName,lblUnitNumber;
	
	@UiField HTMLEventPanel htPanelNextArrow,htPanelPreviousArrow;
	@UiField Anchor unitDetailsButton;
	
	private ClassUnitsListDo classUnitsDo;
	
	private ClassDo classDo;
	
	private UnitAssignmentsDo unitAssignmentsDo;
	
	private UnitAssigmentReorder unitAssigmentReorder;
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	boolean isDeleted=false;
	private boolean isEditMode=false;
	private boolean isReorderPopupShowing = false;
	private boolean isStudentMode=false;
	
	private static final String NEXT="next";
	private static final String PREVIOUS= "previous";
	private int totalHitCount=0;
	
	private String pathwayId;

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(ClassUnitsListDo classUnitsDo){
		initWidget(uibinder.createAndBindUi(this));
		this.classUnitsDo=classUnitsDo;
		setLoadingIcon(false);
		setClassUnitsDo(classUnitsDo);
		setUnitNameDetails();
		cancelEditButton.setVisible(false);
		editUnitButton.setVisible(true);
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



	public void setAssignmentsForUnit() {
		setLoadingIcon(false);
		assignmentsContainer.clear();
		if(getTotalHitCount() == 0){
			assignmentsContainer.add(getZeroAssignmentLabel()); 
			editUnitButton.setEnabled(false);
			editUnitButton.getElement().addClassName("disabled");
		}else{
			editUnitButton.setEnabled(true);
			editUnitButton.getElement().removeClassName("disabled");
		}
		if(classUnitsDo!=null && classUnitsDo.getResource()!=null){
			if(classUnitsDo.getResource().getCollectionItems() != null){
				for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
					ClasspageItemDo classpageItemDo=classUnitsDo.getResource().getCollectionItems().get(i);
					assignmentsContainer.add(new AssignmentsContainerWidget(classpageItemDo));
				}
				assignmentsContainer.add(htPanelNextArrow);
				showAndHideAssignmentArrows();
			}
		}
	}
	
	private Label getZeroAssignmentLabel() {
		Label label = new Label();
		label.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		label.getElement().getStyle().setMarginTop(32, Unit.PX); 
		label.setText(i18n.GL2208());
		return label;
	}


	public void clearAssignmentsFromDo(){
		classUnitsDo.getResource().setCollectionItems(new ArrayList<ClasspageItemDo>());
	}
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
//			isEditMode = true;
			setEditMode(true);
			hideEditButton(true);
			assignmentsContainer.clear();
			setAssignmentsEditView(); 
		}
	}
	
	
	public class DeleteAssignment implements ClickHandler{
		String collectionItemId=null;
		String classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		
		public DeleteAssignment(String collectionItemId) {
			this.collectionItemId = collectionItemId;
		}

		@Override
		public void onClick(ClickEvent event) {
			final WaitPopupVc popupVc = new WaitPopupVc(i18n.GL1387(),i18n.GL1388()) { 
				@Override
				public void onTextConfirmed() {
					AppClientFactory.getInjector().getClasspageService().deleteClassPageItem(classPageId,classUnitsDo.getResource().getGooruOid(),collectionItemId, new SimpleAsyncCallback<String>() {
						@Override
						public void onSuccess(String result) {
							if(result.equals("200")){
								boolean isAssignmentDeleted = deleteAssignmentWidget(collectionItemId);
								if(isAssignmentDeleted){
									clearAssignmentsFromDo();
									hide();
									setLoadingIcon(true);
									if((getTotalHitCount()-1)==assignmentOffset){
										if((getTotalHitCount()-1)==0){
											assignmentOffset=0;
										}else{
											assignmentOffset=assignmentOffset-10;
										}
									}
									getUnitAssignments(assignmentOffset,isEditMode(),null);
								}
							}
						}
					});
				}
			};
		}

	}
	
	
	
	public void setAssignmentsEditView() {
		setLoadingIcon(false);
		assignmentsContainer.clear();
		if(getTotalHitCount() == 0){
			assignmentsContainer.add(getZeroAssignmentLabel()); 
		}
		for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
			AssignmentEditView assignmentEditView = new AssignmentEditView(classUnitsDo.getResource().getCollectionItems().get(i));
			assignmentEditView.getChangeAssignmentStatusView().getChangeAssignmentStatusButton().addClickHandler(new AssignmentStatusChangeEvent(assignmentEditView));
			assignmentEditView.setUnitId(classUnitsDo.getResource().getGooruOid());
			assignmentEditView.getDeleteAssignmentLbl().addClickHandler(new DeleteAssignment(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId()));
			if(classUnitsDo.getResource().getCollectionItems().size()>0){ 
				assignmentEditView.getAssignmentReorderLbl().addMouseOverHandler(new ReorderAssignment(classUnitsDo.getResource().getCollectionItems().get(i).getItemSequence(),classUnitsDo.getResource().getCollectionItems().get(i).getResource().getTitle(),classUnitsDo.getResource().getCollectionItems().get(i).getNarration(),classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId()));
			}
			assignmentEditView.setAssignmentId(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId());
			assignmentsContainer.add(assignmentEditView);
		}
		assignmentsContainer.add(htPanelNextArrow);
		showAndHideAssignmentArrows();
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideReorderPopup(event);
	          }
	    });
	}
	
	public class AssignmentStatusChangeEvent implements ClickHandler{
		private AssignmentEditView assignmentEditView;
		public AssignmentStatusChangeEvent(AssignmentEditView assignmentEditView){
			this.assignmentEditView=assignmentEditView;
		}
		@Override
		public void onClick(ClickEvent event) {
			Boolean isRequiredStatus=assignmentEditView.getChangeAssignmentStatusView().getChangeAssignmentStatusButton().getValue();
			String classId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			AppClientFactory.getInjector().getClasspageService().updateAssignmentDetails(classId,assignmentEditView.getUnitId(),assignmentEditView.getAssignmentId(), null, null, null, null, null,isRequiredStatus , new SimpleAsyncCallback<ClasspageItemDo>() {
				@Override
				public void onSuccess(ClasspageItemDo classpageItemDo) {
					Boolean isRequired=classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false;
					assignmentEditView.getChangeAssignmentStatusView().getChangeAssignmentStatusButton().setValue(isRequired);
					updateClasspageItemDo(classpageItemDo);
				}
			});
		}
	}
	
	public void updateClasspageItemDo(ClasspageItemDo classpageItemDo){
		if(classUnitsDo!=null){
			for(int i=0;i<classUnitsDo.getResource().getCollectionItems().size();i++){
				if(classUnitsDo.getResource().getCollectionItems().get(i).getCollectionItemId().equals(classpageItemDo.getCollectionItemId())){
					classUnitsDo.getResource().getCollectionItems().get(i).setIsRequired(classpageItemDo.getIsRequired());
					return;
				}
			}
		}
	}

	public class ReorderAssignment implements MouseOverHandler{

		String collectionItem,title,narration;
		int assignmentSeq;
		
		public ReorderAssignment(int assignmentSeq,String title,String narration,String collectionItem){
			this.assignmentSeq=assignmentSeq;
			this.title = title;
			this.collectionItem = collectionItem;
			this.narration = narration;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			final String classPageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			unitAssigmentReorder = new UnitAssigmentReorder(assignmentSeq,getClassDo(),title, narration,classPageId,classUnitsDo.getItemSequence(),getTotalHitCount(),collectionItem){
				@Override
				public void reorderAssignment(int seqPosition,String selectedPathwayId,String targetPathway) {
					boolean isAssignmentDeleted = deleteAssignmentWidget(collectionItem);
					if(isAssignmentDeleted){
						System.out.println("-- hello --");
						setLoadingIcon(true);
						clearAssignmentsFromDo();
						if(Integer.parseInt(targetPathway)==classUnitsDo.getItemSequence()){
							assignmentOffset =(seqPosition/assignmentLimit)*assignmentLimit;
							if(assignmentOffset==seqPosition){
								assignmentOffset = assignmentOffset-assignmentLimit;
							}
							getUnitAssignments(assignmentOffset,isEditMode(),null);
						}else{
							if((getTotalHitCount()-1)==assignmentOffset){
								assignmentOffset=assignmentOffset-assignmentLimit;
							}
							getUnitAssignments(assignmentOffset,isEditMode(),null);
							AppClientFactory.fireEvent(new RefreshPathwayItemsEvent(selectedPathwayId, classPageId)); 
						}
					}

				}

			};
			unitAssigmentReorder.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-148,event.getRelativeElement().getAbsoluteTop()+36);
			unitAssigmentReorder.show();
			isReorderPopupShowing = true;
		}
	}
	
	public void hideReorderPopup(NativePreviewEvent event){
		try{
			if(event.getTypeInt()==Event.ONMOUSEOVER){
				Event nativeEvent = Event.as(event.getNativeEvent());
				boolean target=eventTargetsPopup(nativeEvent);
				if(!target)
				{
					if(isReorderPopupShowing){
						unitAssigmentReorder.hide();
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
	
	
	public class CancelEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			setEditMode(false);
//			isEditMode = false;
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
		setLoadingIcon(true);
		getUnitAssignments(getAssignmentOffsetValue(NEXT),isEditMode(),NEXT);
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
		setLoadingIcon(true);
		getUnitAssignments(getAssignmentOffsetValue(PREVIOUS),isEditMode(),PREVIOUS);
	}
	
	public void getUnitAssignments(int assignmentOffset,final boolean isAssignmentEditmode, final String direction){
		String classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classPageId, classUnitsDo.getResource().getGooruOid(), "sequence", assignmentLimit, assignmentOffset, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				setTotalHitCount(result.getTotalHitCount());
				classUnitsDo.getResource().setCollectionItems(result.getSearchResults());
				classUnitsDo.getResource().setItemCount(getTotalHitCount());
				if(isAssignmentEditmode){
					setAssignmentsEditView();
				}else{
					setAssignmentsForUnit();
				}
				showAndHideAssignmentArrows();
			}
		}); 
	}
	
	public void addAssignment(ArrayList<ClasspageItemDo> classpageItemDo){
		setTotalHitCount(getTotalHitCount()+classpageItemDo.size());
		setLoadingIcon(true);
		getUnitAssignments(getOffsetValue(),false,null);
	}
	
	private int getOffsetValue() {
		int pageNum = getTotalHitCount()/10;
		if(getTotalHitCount()>(pageNum*10)){
			assignmentOffset = (pageNum*10);
		}else if(getTotalHitCount()==(pageNum*10)){
			assignmentOffset = ((pageNum-1)*10);
		}
		return assignmentOffset;
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

	
	private void showAndHideAssignmentArrows() {
		
		if(Math.abs(getTotalHitCount()-assignmentOffset)>assignmentLimit){
			if(Math.abs(getTotalHitCount()-assignmentOffset)==getTotalHitCount()){
//				setVisible(false);
//				htPanelNextArrow.setVisible(true);
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}else{
//				htPanelPreviousArrow.setVisible(true);
//				htPanelNextArrow.setVisible(true);
				
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				
			}
		}
		
		if(Math.abs(getTotalHitCount()-assignmentOffset)<assignmentLimit){
			if(getTotalHitCount()<assignmentLimit){
//				htPanelPreviousArrow.setVisible(false);
//				htPanelNextArrow.setVisible(false);
				
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				
				
			}else{
//				htPanelPreviousArrow.setVisible(true);
//				htPanelNextArrow.setVisible(false);
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				
			}
		}
		if(Math.abs(getTotalHitCount()-assignmentOffset)==0){
			if(getTotalHitCount()>assignmentLimit){
//				htPanelPreviousArrow.setVisible(true);
//				htPanelNextArrow.setVisible(false);
				
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}else{
//				htPanelPreviousArrow.setVisible(false);
//				htPanelNextArrow.setVisible(false);
				
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}
			
		}
		if(Math.abs(getTotalHitCount()-assignmentOffset)==assignmentLimit){
			if(getTotalHitCount()==assignmentLimit){
//				htPanelNextArrow.setVisible(false); 
//				htPanelPreviousArrow.setVisible(false);
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}else{
//				htPanelPreviousArrow.setVisible(true);
//				htPanelNextArrow.setVisible(false); 
				htPanelPreviousArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				htPanelNextArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}
		}
	}
	
	
	/**
	 * @return the totalHitCount
	 */
	public int getTotalHitCount() {
		return totalHitCount;
	}

	/**
	 * @param totalHitCount the totalHitCount to set
	 */
	public void setTotalHitCount(int totalHitCount) {
		this.totalHitCount = totalHitCount;
	}
	
	
	/**
	 * @return the classDo
	 */
	public ClassDo getClassDo() {
		return classDo;
	}

	/**
	 * @param classDo the classDo to set
	 */
	public void setClassDo(ClassDo classDo) {
		this.classDo = classDo;
	}
	
	/**
	 * @return the classUnitsDo
	 */
	public ClassUnitsListDo getClassUnitsDo() {
		return classUnitsDo;
	}

	/**
	 * @param classUnitsDo the classUnitsDo to set
	 */
	public void setClassUnitsDo(ClassUnitsListDo classUnitsDo) {
		this.classUnitsDo = classUnitsDo;
	}
	
	/**
	 * @return the isEditMode
	 */
	public boolean isEditMode() {
		return isEditMode;
	}

	/**
	 * @param isEditMode the isEditMode to set
	 */
	public void setEditMode(boolean isEditMode) {
		this.isEditMode = isEditMode;
	}
	
	public void setLoadingIcon(boolean showIcon){
		if(showIcon){
			loadingImageLabel.setVisible(true);
		}else{
			loadingImageLabel.setVisible(false);
		}
	}

}
