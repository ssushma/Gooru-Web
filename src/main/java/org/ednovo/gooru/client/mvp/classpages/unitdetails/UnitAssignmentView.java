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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
	
	
	@Inject
	public UnitAssignmentView(){
		setWidget(uiBinder.createAndBindUi(this));
		assignmentContainer.add(new CollectionsView(null, 0));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		unitSetupButton.addClickHandler(new UnitSetupEvents());
		setCircleData();
	}
	
	public void showUnitNames(){
		for(int i=1; i<5; i++){
			String s="sun"+i;
			String number=Integer.toString(i);
			UnitWidget unitsWidget=new UnitWidget(number, s);
			unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget));
			unitsWidget.getElement().setId(number);
			unitPanel.add(unitsWidget);
		}
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
	
	
	public void setCircleData()
	{
		generalLabel.setText("General");
		requiredLabel.setText("Required");
		optionalLabel.setText("Optional");
		leftArrow.addClickHandler(new cleckOnNext("left"));
		rightArrow.addClickHandler(new cleckOnNext("right"));
		circleContainerPanel.clear();
		leftArrow.setUrl("images/leftSmallarrow.png");
		circleContainerPanel.add(leftArrow);
	
		for(int i=1;i<11;i++){
			final UnitCricleView unitCricleViewObj =new UnitCricleView(true,i);
			unitCricleViewObj.getElement().setId(i+"");
			circleContainerPanel.add(unitCricleViewObj);
			
		}
		rightArrow.setUrl("images/rightSmallarrow.png");
		circleContainerPanel.add(rightArrow);
		
		
		Iterator<Widget> widgets = circleContainerPanel.iterator();
		
		while (widgets.hasNext()) {
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
		}
		
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
//			 if(slot==UnitAssignmentPresenter._SLOT){
//				 assignmentContainer.clear();
//				 assignmentContainer.add(content);
//			}else{
//				assignmentContainer.setVisible(false);
//			}
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
			circleContainerPanel.clear();
			leftArrow.setUrl("images/leftSmallarrow.png");
			circleContainerPanel.add(leftArrow);
			
			for(int i=11;i<21;i++){
				final UnitCricleView unitCricleViewObj =new UnitCricleView(true,i);
				circleContainerPanel.add(unitCricleViewObj);
			}
			rightArrow.setUrl("images/rightSmallarrow.png");
			circleContainerPanel.add(rightArrow);
			Iterator<Widget> widgets = circleContainerPanel.iterator();
			
			while (widgets.hasNext()) {
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
			}
		}else
		{

			circleContainerPanel.clear();
			leftArrow.setUrl("images/leftSmallarrow.png");
			circleContainerPanel.add(leftArrow);
			
			for(int i=1;i<11;i++){
				final UnitCricleView unitCricleViewObj =new UnitCricleView(true,i);
				circleContainerPanel.add(unitCricleViewObj);
			}
			rightArrow.setUrl("images/rightSmallarrow.png");
			circleContainerPanel.add(rightArrow);
			Iterator<Widget> widgets = circleContainerPanel.iterator();
			
			while (widgets.hasNext()) {
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
			}	
		}
		}
	}
	@Override
	public void showUnitNames(ClasspageListDo classpageListDo) {
		// TODO Auto-generated method stub
		this.classpageListDo=classpageListDo;
		for(int i=0; i<limit; i++){
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
		offSet=offSet+5;
		getUiHandlers().getPathwayUnits(limit, offSet);
	}

	@Override
	public void hideMoreUnitsLink() {
		
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
		
	
}
