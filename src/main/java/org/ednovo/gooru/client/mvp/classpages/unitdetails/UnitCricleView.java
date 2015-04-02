package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class UnitCricleView extends Composite implements HasClickHandlers,HasMouseOverHandlers,HasMouseOutHandlers{

	private static UnitCricleViewUiBinder uiBinder = GWT
			.create(UnitCricleViewUiBinder.class);

	interface UnitCricleViewUiBinder extends UiBinder<Widget, UnitCricleView> {
	}
	
	@UiField InlineLabel unitNumber;
	@UiField HTMLPanel bubbleOuterPanel;
	
	private ClasspageItemDo classpageItemDo;
	
	UnitAssignmentCssBundle res;
	
	private  InsightsUserDataDo insightsUserDataDo;
	
	public UnitCricleView() {
		initWidget(uiBinder.createAndBindUi(this));
		UnitAssignmentCssBundle.INSTANCE.unitAssignment().ensureInjected();
		
	}
	public UnitCricleView(ClasspageItemDo classpageItemDo, InsightsUserDataDo insightsUserDataDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.classpageItemDo=classpageItemDo;
		this.insightsUserDataDo=insightsUserDataDo;
		res=UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		unitNumber.setText(classpageItemDo.getItemSequence()+"");
		boolean isRequired=classpageItemDo!=null&&classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false;
		boolean assignmentStudyStatus=classpageItemDo!=null&&classpageItemDo.getStatus()!=null&&classpageItemDo.getStatus().equals("completed")?true:false;
		showCircle(isRequired, assignmentStudyStatus);
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(insightsUserDataDo!=null){
			System.out.println("Enter:::");
			setAssignmentCircleStatus();
		}
		if(viewToken.equals(PlaceTokens.STUDY)){
			assignmentReadStatus(isRequired,classpageItemDo.getStatus());
		}
		
	}
	
	public void setBubbleStyleName(String styleName){
		unitNumber.setStyleName(styleName);
	}
	
	public void setBubbleContainerStyle(String styleName){
		bubbleOuterPanel.setStyleName(styleName);
	}
	
	public void setUnitSequenceNumber(int sequenceNumber){
		if(sequenceNumber == 0){
			unitNumber.setText("");
		}
		else{
			unitNumber.setText(""+sequenceNumber);
		}
	}
	
	public void showCircle(boolean isRequired, boolean isChecked){
		if(isRequired){
			displayRequiredCircle(isChecked);
		}else{
			displayOptionalCircle(isChecked);
		}
	}
	
	public void assignmentReadStatus(boolean isRequired,String readStatus){
		unitNumber.removeStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().assingmentcompleted());
		unitNumber.removeStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().assignmentCompletedWithOptional());
		boolean assignmentStudyStatus=readStatus!=null&&readStatus.equals("completed")?true:false;
		if(isRequired){
			if(assignmentStudyStatus){
				unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().assingmentcompleted());
			}
		}else{
			if(assignmentStudyStatus){
				unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().assignmentCompletedWithOptional());
			}
		}
	}
	
	public String getAssignementId(){
		return classpageItemDo!=null?classpageItemDo.getCollectionItemId():"";
	}
	/*
	 * This method is used to display required Circle
	 */
	public void displayRequiredCircle(boolean isChecked){

		unitNumber.removeStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleOptional());
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleBig());
		if(isChecked){

			unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().assingmentcompleted());
		
	}

	}
	/*
	 * This method is used to display optional Circle
	 */
	public void displayOptionalCircle(boolean isChecked)
	{
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleBig());
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleOptional());
		
		if(isChecked){

			unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().notrequiredBubbleWithCheck());
		
		}
		else
		{
			unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleOptional());
		}
	}
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}
	
	 /**
	  * To set the status colors for Assignment circles based on student progress
	  */

	 private void setAssignmentCircleStatus(){

		 if(insightsUserDataDo.getUserData()!= null && insightsUserDataDo.getUserData().get(0).getGradeInPercentage()!=null && insightsUserDataDo.getMinimumScore()!=null){

			 if(insightsUserDataDo.getUserData().get(0).getGradeInPercentage()!=null){
				 String grade=insightsUserDataDo.getUserData().get(0).getGradeInPercentage();
				 String minScore=insightsUserDataDo.getMinimumScore();
				 System.out.println("minScore::"+minScore);
				 System.out.println("grade::"+grade);
				 if(grade.equals(minScore)|| Integer.parseInt(grade)>Integer.parseInt(minScore)){
					this.getElement().getFirstChildElement().setClassName(res.unitAssignment().greenCircle());
				 }else{
					 this.getElement().getFirstChildElement().setClassName(res.unitAssignment().redCircle());
				 }
				 if((classpageItemDo!=null && classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")))
				 {
					 System.out.println("classpageitemdo");
					 this.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");

				 }
			 }

		 }else if(insightsUserDataDo.getIsRequired() != null)
			{
				if(insightsUserDataDo.getIsRequired()==0)
				{
					this.getElement().getFirstChildElement().setClassName(res.unitAssignment().stylishCircle());
					if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
					 {
						 this.getElement().getFirstChildElement().setAttribute("style", "background: #b9bbca url(../images/liners.png) repeat-x center !important;");

					 }
				}else{
					if((insightsUserDataDo.getStatus() != null && insightsUserDataDo.getStatus().equals("1")) ||(classpageItemDo.getStatus() != null && classpageItemDo.getStatus().equalsIgnoreCase("completed")) )
					 {
						 this.getElement().getFirstChildElement().setAttribute("style", "background-image: url(../images/checkMark.png);");

					 }
				}
				
			}
		 
		 

	 }
	
}
