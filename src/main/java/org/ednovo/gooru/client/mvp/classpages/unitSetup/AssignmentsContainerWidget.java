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


import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitAssignentStudentPlayView;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitCricleView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
* @fileName : AssignmentsContainerWidget.java
*
* @description : This class creates the widget for Assignments.
* 
* @version : 1.1
*
* @date:  Sept, 2014.
*
* @Author: Gooru Team.
* 
* @Reviewer: Gooru Team.
*/

public class AssignmentsContainerWidget extends Composite  {
	
	private static AssignmentsContainerWidgetUiBinder uibinder = GWT.create(AssignmentsContainerWidgetUiBinder.class);
	interface AssignmentsContainerWidgetUiBinder extends UiBinder<Widget, AssignmentsContainerWidget>{
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Image assignmentThumbnail;
	
	@UiField Label dueDays;
	
	@UiField UnitCricleView unitCircleView;
	
	@UiField AssignmentContainerWidgetCBundle unitStyle;
	
	UnitAssignentStudentPlayView UnitAssignentStudentPlayView =null;
	
	private boolean isShowingPopUpforStudent = false;
	
	/**
	 * Class constructor
	 * @param classpageItemDo {@link ClasspageItemDo}
	 */
	public AssignmentsContainerWidget(ClasspageItemDo classpageItemDo){ 
		initWidget(uibinder.createAndBindUi(this));
		unitCircleView.setUnitSequenceNumber(classpageItemDo.getItemSequence());
		unitCircleView.getElement().setId(classpageItemDo.getCollectionItemId());
		
		String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(pageLocation.equals(PlaceTokens.STUDENT)){
			unitCircleView.addMouseOverHandler(new StudentAssignmentMouseOverHandler(classpageItemDo.getItemSequence(),classpageItemDo.getResource().getTitle(),classpageItemDo.getPlannedEndDate(),classpageItemDo.getNarration(),classpageItemDo.getResource().getGooruOid(),unitCircleView.getElement().getId()));
		}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
			
		}
		
		assignmentThumbnail.setUrl(classpageItemDo.getResource().getThumbnails().getUrl());
		if(classpageItemDo.getStatus() != null)
		{
			if(classpageItemDo.getStatus().equalsIgnoreCase("completed"))
			{
				//unitCircleView.setUnitSequenceNumber(0);
				unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.greenBubble());
			}
		}
		if(classpageItemDo.getIsRequired() != null)
		{
			if(!classpageItemDo.getIsRequired())
			{
				unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
			}
		}
		
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hidePopup(event);
	          }
	    });
		
	}
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("assignmentThumbnail")
	public void setErrorImage(ErrorEvent event){
		assignmentThumbnail.setUrl("images/default-collection-image-160x120.png");
	}
	
	public class StudentAssignmentMouseOverHandler implements MouseOverHandler{
		int seqNumber;
		String title,direction,collectionId,collectionItemId;
		Long dueDate;
		public StudentAssignmentMouseOverHandler(Integer itemSequence,String title, Long plannedEndDate, String narration,String collectionId, String collectionItemId) {
			// TODO Auto-generated constructor stub
			this.seqNumber = itemSequence;
			this.title = title;
			this.direction = narration;
			this.dueDate = plannedEndDate;
			this.collectionId = collectionId;
			this.collectionItemId = collectionItemId;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			// TODO Auto-generated method stub
			UnitAssignentStudentPlayView = new UnitAssignentStudentPlayView(seqNumber,title,dueDate,direction,collectionId,collectionItemId);
			
			UnitAssignentStudentPlayView.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-128,event.getRelativeElement().getAbsoluteTop()-40);
			UnitAssignentStudentPlayView.show();
			isShowingPopUpforStudent = true;
		}
		
	}
	
	public void hidePopup(NativePreviewEvent event){
		try{
    	if(event.getTypeInt()==Event.ONMOUSEOVER){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	
        	boolean targetStu=eventTargetsPopupStudent(nativeEvent);
        	if(!targetStu){
    		if(isShowingPopUpforStudent){
    			UnitAssignentStudentPlayView.hide();
    		}
        	}
    	}
		}catch(Exception ex){ex.printStackTrace();}
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
}
