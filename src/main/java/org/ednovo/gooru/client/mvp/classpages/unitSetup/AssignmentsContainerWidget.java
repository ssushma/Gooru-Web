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


import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitAssignentStudentPlayView;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitCricleView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

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

	private ClasspageItemDo classpageItemDo = null;
	
	private InsightsUserDataDo insightsUserDataDo;
	
	private String unitId = null;
	

	/**
	 * Class constructor
	 * @param classpageItemDo {@link ClasspageItemDo}
	 * @param insightsUserDataDo 
	 */
		public AssignmentsContainerWidget(ClasspageItemDo classpageItemDo, String unitId, InsightsUserDataDo insightsUserDataDo){ 

		initWidget(uibinder.createAndBindUi(this));
		this.classpageItemDo = classpageItemDo;
		this.unitId = unitId;  
		this.insightsUserDataDo=insightsUserDataDo;
		unitCircleView.setUnitSequenceNumber(classpageItemDo.getItemSequence());
		unitCircleView.getElement().setId(classpageItemDo.getCollectionItemId());
		
		String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(pageLocation.equals(PlaceTokens.STUDENT)){
			unitCircleView.addMouseOverHandler(new StudentAssignmentMouseOverHandler(classpageItemDo.getItemSequence(),classpageItemDo.getResource().getTitle(),classpageItemDo.getPlannedEndDate(),classpageItemDo.getNarration(),classpageItemDo.getResource().getGooruOid(),unitCircleView.getElement().getId()));
		}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
			
		}
		
		assignmentThumbnail.setUrl(classpageItemDo.getResource().getThumbnails().getUrl());
		
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hidePopup(event);
	          }
	    });
		
		if(insightsUserDataDo!=null){
			setAssignmentCircleStatus();
		}else{
			/*if(classpageItemDo.getStatus() != null)
			{
				if(classpageItemDo.getStatus().equalsIgnoreCase("completed"))
				{
					//unitCircleView.setUnitSequenceNumber(0);
					unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.greenBubble());
				}
			}*/
			if(classpageItemDo.getIsRequired() != null)
			{
				if(!classpageItemDo.getIsRequired())
				{
					unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
				}
				if(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed"))
				 {
					 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background: #b9bbca url(../images/liners.png) repeat-x center !important;");

				 }
			}else{
				if((classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
				 {
					 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");

				 }
			}
		}
		
	}
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("assignmentThumbnail")
	public void setErrorImage(ErrorEvent event){
		assignmentThumbnail.setUrl("images/default-collection-image-160x120.png");
	}
	
	@UiHandler("assignmentThumbnail")
	public void assignmentThumbnailClickEvent(ClickEvent event){
		revealPlace("unitdetails",null,unitId,classpageItemDo.getCollectionItemId());
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
	 
	 /**
	  * To set the status colors for Assignment circles based on student progress
	  */

	 private void setAssignmentCircleStatus(){
		 if(insightsUserDataDo.getUserData()!= null && insightsUserDataDo.getMinimumScore()!=null){

			 if(insightsUserDataDo.getUserData().get(0).getGradeInPercentage()!=null){
				 String grade=insightsUserDataDo.getUserData().get(0).getGradeInPercentage();
				 String minScore=insightsUserDataDo.getMinimumScore();
				 if(grade.equals(minScore)|| Integer.parseInt(grade)>Integer.parseInt(minScore)){
					 unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.greenCircle());
				 }else{
					 unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.redCircle());
				 }
				 
				 if(insightsUserDataDo.getIsRequired() != null)
					{
						if(insightsUserDataDo.getIsRequired()==0)
						{
							unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
						}else{
						}
						
					}
				 
				 if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
				 {
					 try
					 {
					 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");
					 }
					 catch(Exception ex)
					 {
						 ex.printStackTrace();
					 }

				 }
			 }
			 else
			 {
				 if(insightsUserDataDo.getIsRequired() != null)
					{
						if(insightsUserDataDo.getIsRequired()==0)
						{
							unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
						}else{

						}
						
					}
				 
				 if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
				 {
					 try
					 {
					 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");
					 }
					 catch(Exception ex)
					 {
						 ex.printStackTrace();
					 }

				 }
			 }

		 }else if(insightsUserDataDo.getIsRequired() != null)
			{
				if(insightsUserDataDo.getIsRequired()==0)
				{
					unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
					if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
					 {
						 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background: #b9bbca url(../images/liners.png) repeat-x center !important;");

					 }
				}else{
					if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
					 {
						 unitCircleView.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");

					 }
				}
				
			}
		 
		 

	 }

}
