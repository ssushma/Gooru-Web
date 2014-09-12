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
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;

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
	UnitCricleView unitCricleViewObj;
	
	@Inject
	public UnitAssignmentView(){
		setWidget(uiBinder.createAndBindUi(this));
		assignmentContainer.add(new CollectionsView(null, 0));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		unitSetupButton.addClickHandler(new UnitSetupEvents());
		
	}
	@Override
	public void getPathwayItems(){
		leftArrow.setVisible(false);
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
			removeUnitSelectedStyle();
			addUnitSelectStyle(unitsWidget);
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
		rightArrow.getElement().setAttribute("style", "cursor:pointer");
		leftArrow.getElement().setAttribute("style", "cursor:pointer");
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hidePopup(event);
	          }
	    });
		
		
			if(itemSequence!=null &&itemSequence.size()!=0){
				totalAssignmentHitcount = itemSequence.get(0).getTotalHitCount();
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
				leftArrow.setUrl("images/leftSmallarrow.png");
				circleContainerPanel.add(leftArrow);
				totalAssignmencount=totalAssignmencount+itemSequence.size();
				
				for(int i=0;i<itemSequence.size();i++){
					unitCricleViewObj =new UnitCricleView(true,itemSequence.get(i).getItemSequence());
					unitCricleViewObj.getElement().setId(i+"");
					circleContainerPanel.add(unitCricleViewObj);
					unitCricleViewObj.addMouseOverHandler(new UnitSeqMouseOverHandler());
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
				
				rightArrow.setUrl("images/rightSmallarrow.png");
				circleContainerPanel.add(rightArrow);
							
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
				if(limit_circle==totalAssignmencount){
					rightArrow.setVisible(false);	
				}
				getUiHandlers().getPathwayItems(classpageid, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, limit_circle, totalAssignmencount);
			}
			else{
				
				totalAssignmencount =totalAssignmencount-20;
				if(totalAssignmencount<10)
				{
					leftArrow.setVisible(false);	
				}
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
			unitAssigmentReorder = new UnitAssigmentReorder(classpageListDo,assignmentItemSeq,classpageid);
			unitAssigmentReorder.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-128,event.getRelativeElement().getAbsoluteTop()+40);
			unitAssigmentReorder.show();
			}
		}
	public void hidePopup(NativePreviewEvent event){
    	if(event.getTypeInt()==Event.ONMOUSEOVER){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	boolean target=eventTargetsPopup(nativeEvent);
        	if(!target)
        	{
        		unitAssigmentReorder.hide();
        		
        	}
    	}
     }
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			return unitAssigmentReorder.getElement().isOrHasChild(Element.as(target));
		}
		return false;
	}
	@Override
	public void showUnitNames(ClasspageListDo classpageListDo) {
		// TODO Auto-generated method stub
		this.classpageListDo=classpageListDo;
		int totalCount=classpageListDo.getTotalHitCount()!=null?classpageListDo.getTotalHitCount():0;
		int size =classpageListDo.getSearchResults().size() ;

		if(Math.abs(totalCount-offSet) > size){
			showMoreUnitsLink();
		}else{
			hideMoreUnitsLink();
		}
		for(int i=0; i<size; i++){
			String unitName=classpageListDo.getSearchResults().get(i).getResource().getTitle();
			int number=classpageListDo.getSearchResults().get(i).getItemSequence();
			String sequenceNumber=Integer.toString(number);
			UnitWidget unitsWidget=new UnitWidget(sequenceNumber, unitName);
			unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget));
			unitsWidget.getElement().setId(sequenceNumber);
			unitPanel.add(unitsWidget);
		}

	}

	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		offSet=offSet+limit;
		getUiHandlers().getPathwayUnits(limit, offSet);
	}

	@Override
	public void hideMoreUnitsLink() {
		lblMoreUnits.setVisible(false);
	}

	 private class UnitSetupEvents implements ClickHandler{
			@Override
			public void onClick(ClickEvent event) {
				revealPlace("unitsetup");
			}
		}
		 public void revealPlace(String tabName){
				Map<String,String> params = new HashMap<String,String>();
				String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
				String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
				params.put("pageSize", pageSize);
				params.put("classpageid", classpageid);
				params.put("pageNum", pageNum);
				params.put("pos", pos);
				if(tabName!=null){
					params.put("tab", tabName);
				}
				PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
				AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		 }
		
	
	public void showMoreUnitsLink(){
		lblMoreUnits.setVisible(true);
	}
	
}
