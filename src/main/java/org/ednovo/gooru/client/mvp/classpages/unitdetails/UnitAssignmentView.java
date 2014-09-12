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
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class UnitAssignmentView extends BaseViewWithHandlers<UnitAssignmentUiHandlers> implements IsUnitAssignmentView{

	@UiField HTMLPanel assignmentContainer;


	private static UnitAssignmentViewUiBinder uiBinder = GWT.create(UnitAssignmentViewUiBinder.class);

	interface UnitAssignmentViewUiBinder extends UiBinder<Widget, UnitAssignmentView> {
		
	}
	
	@UiField HTMLPanel unitPanel;
	
	@UiField Label lblMoreUnits;
	
	@UiField Anchor unitSetupButton;
	
	UnitAssignmentCssBundle res;
	
	ClasspageListDo classpageListDo;
	
	private int limit = 5;
	private int offSet = 0;
		
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel circleContainerPanel;
	@UiField Label generalLabel,requiredLabel,optionalLabel;
	Image leftArrow = new Image();
	Image rightArrow = new Image();
		
	private String ORDER_BY="sequence";
	private int limit_circle=10;
	
	UnitAssigmentReorder unitAssigmentReorder=null;
	private HandlerRegistration leftHandler;
	private HandlerRegistration rightHandler;
	private int totalAssignmentHitcount;
	private int totalAssignmencount=0;
	private String classpageid;
	ArrayList<CollectionItemDo> assignmentItemSeq;
	boolean isShowing=false;
	
	@Inject
	public UnitAssignmentView(){
		setWidget(uiBinder.createAndBindUi(this));
		assignmentContainer.add(new CollectionsView(null, 0));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		unitSetupButton.addClickHandler(new UnitSetupEvents());
	}
	
	public HTMLPanel getUnitPanel(){
		return unitPanel;
	}
	
	public HTMLPanel getCircleContainerPanel(){
		return circleContainerPanel;
	}
	
	@Override
	public void getPathwayItems(){
		classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		getUiHandlers().getPathwayItems(classpageid, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, limit_circle, totalAssignmencount);
	}
	
	
	public class UnitChangeEvent implements ClickHandler{
		private UnitWidget unitsWidget;
		public UnitChangeEvent(UnitWidget unitsWidget){
			this.unitsWidget=unitsWidget;
		}
		@Override
		public void onClick(ClickEvent event) {
			revealPlace("unitdetails",null,"");
		}
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
	
	
	
	public void setCircleData(ArrayList<CollectionItemDo> itemSequence)
	{
		
		requiredLabel.setText("Required");
		optionalLabel.setText("Optional");
		if(itemSequence!=null &&itemSequence.size()!=0){
			
		
		totalAssignmentHitcount = itemSequence.get(0).getTotalHitCount();
		try{
			if(leftHandler!=null) {
				leftHandler.removeHandler();
			}
		}catch (AssertionError ae) { }
		try{
			if(rightHandler!=null) {
				rightHandler.removeHandler();
			}
		}catch (AssertionError ae) { }
		leftHandler=leftArrow.addClickHandler(new cleckOnNext("left"));
		rightHandler=rightArrow.addClickHandler(new cleckOnNext("right"));
		circleContainerPanel.clear();
		leftArrow.setUrl("images/leftSmallarrow.png");
		circleContainerPanel.add(leftArrow);
		totalAssignmencount=totalAssignmencount+itemSequence.size();
		
		for(int i=0;i<itemSequence.size();i++){
			final UnitCricleView unitCricleViewObj =new UnitCricleView(true,itemSequence.get(i).getItemSequence());
			unitCricleViewObj.getElement().setId(i+"");
			circleContainerPanel.add(unitCricleViewObj);
			unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler());
			unitCricleViewObj.addMouseOutHandler(new UnitSeqMouseOutHandler());
			unitCricleViewObj.addClickHandler(new AssignmentClickChangeEvent(unitCricleViewObj));
			
		}
		if(totalAssignmencount==totalAssignmentHitcount)
		{
			rightArrow.setVisible(false);
		}else{
			rightArrow.setVisible(true);	
		}
		if(totalAssignmentHitcount<10)
		{
			rightArrow.setVisible(false);
			leftArrow.setVisible(false);
			
		
		}
		else
		{
			leftHandler=leftArrow.addClickHandler(new cleckOnNext("left"));
			rightHandler=rightArrow.addClickHandler(new cleckOnNext("right"));
			rightArrow.setVisible(true);
			leftArrow.setVisible(false);
		}
		rightArrow.setUrl("images/rightSmallarrow.png");
		circleContainerPanel.add(rightArrow);
		
		
		//Iterator<Widget> widgets = circleContainerPanel.iterator();
		
		/*while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			if (widget instanceof UnitCricleView) {
				((UnitCricleView) widget).addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						final Iterator<Widget> widgetsPanel = circleContainerPanel.iterator();
						while (widgetsPanel.hasNext()) {
							 widgetsPanel.next().removeStyleName(res.unitAssignment().active());
						}
						widget.addStyleName(res.unitAssignment().active());
					}
					
			});
		}
			
					
		
		}*/
		}else
		{
			Label noAssignmentlabel = new Label("Assignment not available");
			circleContainerPanel.clear();
			circleContainerPanel.add(noAssignmentlabel);
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
				 assignmentContainer.clear();
				 assignmentContainer.add(content);
			}else{
//				assignmentContainer.setVisible(false);
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
				leftArrow.setVisible(true);
				getUiHandlers().getPathwayItems(classpageid, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, limit_circle, totalAssignmencount);
			}
			else{
				totalAssignmencount =totalAssignmencount-10;
				
				getUiHandlers().getPathwayItems(classpageid, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, limit_circle, totalAssignmencount);
			}
		}
	}
	
	@Override
	public void getSequence(ArrayList<CollectionItemDo> getSeq) {
		this.assignmentItemSeq=getSeq;
		setCircleData(getSeq);
	}
	public class UnitSeqMouseOverHandler implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			isShowing=true;
			unitAssigmentReorder = new UnitAssigmentReorder(classpageListDo,assignmentItemSeq,classpageid);
			unitAssigmentReorder.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-128,event.getRelativeElement().getAbsoluteTop()+40);
			unitAssigmentReorder.show();
			unitAssigmentReorder.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					isShowing=true;
					unitAssigmentReorder.show();		
				}
			});
			unitAssigmentReorder.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					isShowing=false;
					
				}
			});
		
		}
		}
	public class UnitSeqMouseOutHandler implements MouseOutHandler{


		@Override
		public void onMouseOut(MouseOutEvent event) {
			if(!isShowing){
			unitAssigmentReorder.hide();
			}
			
		}
			
		}
	
	@Override
	public void showUnitNames(ClassDo classDo,boolean clearPanel) {
	//	this.classpageListDo=classpageListDo;
		int totalCount=classDo.getTotalHitCount()!=null?classDo.getTotalHitCount():0;
		int size =classDo.getSearchResults().size() ;
		for(int i=0; i<size; i++){
			String unitName=classDo.getSearchResults().get(i).getResource().getTitle();
			int number=classDo.getSearchResults().get(i).getItemSequence();
			String unitGooruOid=classDo.getSearchResults().get(i).getGooruOid();
			String sequenceNumber=Integer.toString(number);
			UnitWidget unitsWidget=new UnitWidget(sequenceNumber, unitName,unitGooruOid);
			unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget));
			unitsWidget.getElement().setId(sequenceNumber);
			unitPanel.add(unitsWidget);
		}

	}

	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		offSet=offSet+limit;
		//getUiHandlers().getPathwayUnits(limit, offSet);
	}

	@Override
	public void hideMoreUnitsLink() {
		lblMoreUnits.setVisible(false);
	}

	 private class UnitSetupEvents implements ClickHandler{
			@Override
			public void onClick(ClickEvent event) {
				revealPlace("unitsetup","1",null);
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
	public void showMoreUnitsLink(){
		lblMoreUnits.setVisible(true);
	}
	
}
