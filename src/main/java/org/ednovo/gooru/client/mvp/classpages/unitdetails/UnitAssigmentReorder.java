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


import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : UnitAssigmentReorder.java
 * 
 * @description :This class is used to display tooltip of assignment for teachers
 * 
 * 
 * @version : 1.1
 * 
 * @date: Sep 14, 2014
 * 
 * @Author Gooru Team
 * 
 * @Reviewer:
 */
public abstract class UnitAssigmentReorder extends PopupPanel{ 
private static UnitAssigmentReorderUiBinder uiBinder = GWT
			.create(UnitAssigmentReorderUiBinder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	interface UnitAssigmentReorderUiBinder extends
			UiBinder<Widget, UnitAssigmentReorder> {
	}
	@UiField Image popupArrow;
	@UiField Button saveButton,CancelButton;
	@UiField Label descLabel,savingTextLabel,unitTextLbl,assignmentTextLbl;
	@UiField InlineLabel dropdownListPlaceHolder,dropdownListPlaceHolderAssignment;
	@UiField ScrollPanel dropdownListContainerScrollPanel,dropdownListContainerScrollPanelAssignment;
	@UiField HTMLPanel dropdownListContainer,dropdownListContainerAssignment,mainPanel;
	@UiField InlineLabel seqNum,titleLabel;
	
	ClassDo classDo;
	int totalCount=0;
	int totalsize=0;
	String classpageId;
	private String selectedPathId;
	private HandlerRegistration onClickUnit;
	private int totalHintCount;
	private String selectedAssignmentId,pathwayId;
	/**
	 * 
	 * @constructor : UnitAssigmentReorder
	 * 
	 * @param : Sequence Number
	 * @param : ClassDo object
	 * @param : assignment title
	 * @param : assignment narration
	 * @param : classpageId
	 * @param : selectedUnitNumber
	 * @param : totalHintCount
	 * @param : selectedAssignmentId
	 */
	public UnitAssigmentReorder(int seqNo,ClassDo classDo,String title,String narration,String classpageId,int selectedUnitNumber,int totalHintCount,String selectedAssignmentId,String  pathwayId) {
		setWidget(uiBinder.createAndBindUi(this));
		this.classDo = classDo;
		this.classpageId = classpageId;
		this.totalHintCount = totalHintCount;
		this.selectedAssignmentId = selectedAssignmentId;
		this.pathwayId=pathwayId;
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		unitTextLbl.setText(i18n.GL2175());
		unitTextLbl.getElement().setId("unitTextLbl");
		unitTextLbl.getElement().setAttribute("alt",i18n.GL2175());
		unitTextLbl.getElement().setAttribute("style", "display: inline-block;");
		assignmentTextLbl.setText(i18n.GL0103());
		assignmentTextLbl.getElement().setId("assignmentTextLbl");
		assignmentTextLbl.getElement().setAttribute("alt",i18n.GL0103());
		assignmentTextLbl.getElement().setAttribute("style", "display: inline-block;");
		setUnitAssignmentData(classDo,title,narration,selectedUnitNumber);
		seqNum.setText(seqNo+".");
		seqNum.getElement().setId("seqNum");
		seqNum.getElement().setAttribute("alt",seqNo+"");
		this.getElement().setAttribute("style","background: transparent");
		
				
	}
	/**
	 * 
	 * @method name : setUnitAssignmentData
	 * 
	 * @param : classDo 
	 * @param : assignment title
	 * @param : assignment narration
	 * @param : selectedUnitNumber
	 */
	public void setUnitAssignmentData(ClassDo classDo,String title,String narration,int selectedUnitNumber){
		int totalItemCount = 0;
		popupArrow.setUrl("images/popArrow.png");
		saveButton.setText(i18n.GL0141());
		saveButton.getElement().setId("saveButton");
		saveButton.getElement().setAttribute("alt",i18n.GL0141());
		CancelButton.setText(i18n.GL0142());
		CancelButton.getElement().setId("CancelButton");
		CancelButton.getElement().setAttribute("alt",i18n.GL0142());
		titleLabel.getElement().setId("titleLabel");
		descLabel.getElement().setId("descLabel");
		dropdownListContainerScrollPanel.getElement().getStyle().setDisplay(Display.NONE);
		dropdownListContainerScrollPanel.getElement().setId("dropdownListContainerScrollPanel");
		dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
		
		saveButton.addClickHandler(new clickOnSave());
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		
		totalCount=classDo.getTotalHitCount()!=null?classDo.getTotalHitCount():0;
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			ArrayList<ClassUnitsListDo> classListUnitsListDo =classDo.getSearchResults();
			titleLabel.setText(title);
			titleLabel.getElement().setAttribute("alt",title);
			if(narration!=null){
				descLabel.setText(narration);
				descLabel.getElement().setAttribute("alt",narration);
			}
			totalsize =totalsize+classListUnitsListDo.size() ;
			
			for(int i=0; i<classListUnitsListDo.size(); i++){

				//totalItemCount=classListUnitsListDo.get(0).getResource().getItemCount();
				displayAssignment(totalHintCount);
				int number=classListUnitsListDo.get(i).getItemSequence();
				
				if(selectedUnitNumber==0){
					dropdownListPlaceHolder.getElement().setInnerHTML(classListUnitsListDo.get(0).getItemSequence()+"");
				}else{
					dropdownListPlaceHolder.getElement().setInnerHTML(selectedUnitNumber+"");
				}
				if(pathwayId==null){
					dropdownListPlaceHolder.getElement().setId(classListUnitsListDo.get(0).getResource().getGooruOid());
				}else{
					dropdownListPlaceHolder.getElement().setId(pathwayId);	
				}
				String unitCollectionItemId=classListUnitsListDo.get(i).getResource().getGooruOid();
				
				Label dropDownListItem=new Label(number+"");
				dropDownListItem.getElement().setId(classListUnitsListDo.get(i).getResource().getItemCount()+"");
				dropDownListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
				dropdownListContainer.add(dropDownListItem);
				dropDownListItem.addClickHandler(new OnDropdownItemClick(number+"",dropDownListItem.getElement().getId(),unitCollectionItemId));
			}
			if(totalCount==1 && totalItemCount==1)	{
				saveButton.setVisible(false);
			}
			else{
				saveButton.setVisible(true);
			}
			
		}
		
				
	}
	/**
	 * 
	 * @method name : displayAssignment
	 * 
	 * @discription : This method is used to display the assignment in dropdown
	 * 
	 * @param : totalItemCount 
	 */
	public void displayAssignment(Integer totalItemCount)
	{
		dropdownListContainerAssignment.clear();
		dropdownListContainerScrollPanelAssignment.getElement().getStyle().setDisplay(Display.NONE);
		try{
			if(onClickUnit!=null) {
				onClickUnit.removeHandler();
			}
			
		}catch (AssertionError ae) { }
		onClickUnit = dropdownListPlaceHolderAssignment.addClickHandler(new OnDropdownListAssignmentPlaceHolderClick());
		
		if(totalItemCount!=null &&totalItemCount!=0){
			for(int i=1; i<=totalItemCount; i++){
				dropdownListPlaceHolderAssignment.getElement().setInnerHTML(1+"");
				int number=i;
				Label dropDownAssignmentListItem=new Label(number+"");
				
				dropDownAssignmentListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
				dropdownListContainerAssignment.add(dropDownAssignmentListItem);
				dropDownAssignmentListItem.addClickHandler(new OnDropdownAssignmentItemClick(number+"",dropDownAssignmentListItem.getElement().getId()));
			}
		}else
		{
			dropdownListPlaceHolderAssignment.getElement().setInnerHTML(1+"");
		}
	}
	/**
	 * 
	 * @classname name : ScrollDropdownListContainer
	 * 
	 * @discription : This class is used to display the more unit on scroll
	 * if unit is greater than 5.
	 * 
	 */
	private class ScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((dropdownListContainerScrollPanel.getVerticalScrollPosition() == dropdownListContainerScrollPanel.getMaximumVerticalScrollPosition())&&(totalCount>totalsize)){
				AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, Integer.toString(5),  Integer.toString(totalsize), new SimpleAsyncCallback<ClassDo>() {
					@Override
					public void onSuccess(ClassDo result) {
						totalsize = totalsize + result.getSearchResults().size();
						for(int i=0; i<result.getSearchResults().size(); i++){

							String CollectionItemId=result.getSearchResults().get(i).getResource().getGooruOid();
							int totalItemCount=result.getSearchResults().get(i).getResource().getItemCount();
							int number=result.getSearchResults().get(i).getItemSequence();
							Label dropDownListItem=new Label(number+"");
							dropDownListItem.getElement().setId(totalItemCount+"");
							dropDownListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
							dropdownListContainer.add(dropDownListItem);
							dropDownListItem.addClickHandler(new OnDropdownItemClick(number+"",dropDownListItem.getElement().getId(),CollectionItemId));
						}
				}
				});
				}
			}
	}
	/**
	 * 
	 * @classname name : OnDropdownListPlaceHolderClick
	 * 
	 * @discription : This click event is used to display unit on dropdown
	 */
	private class OnDropdownListPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
		}
	}
	/**
	 * 
	 * @classname name : OnDropdownListAssignmentPlaceHolderClick
	 * 
	 * @discription : This click event is used to display assignment on dropdown
	 */
	private class OnDropdownListAssignmentPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanelAssignment).run(300);
		}
	}
	/**
	 * 
	 * @classname name : OnDropdownItemClick
	 * 
	 * @discription : This click event is used to select unit number
	 */
	private class OnDropdownItemClick implements ClickHandler{
		private String seq="";
		private String itemCount;
		private String UnitCollectionItemId;
		
		
	
		public OnDropdownItemClick(String seq,String itemCount,String UnitCollectionItemId){
			this.seq = seq;
			this.itemCount = itemCount;
			this.UnitCollectionItemId = UnitCollectionItemId;
			
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolder.setText(seq);
			dropdownListPlaceHolder.getElement().setAttribute("id", itemCount+"");
			selectedPathId = UnitCollectionItemId;
			displayAssignment(Integer.parseInt(itemCount));
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
			
			
		}
	}
	/**
	 * 
	 * @classname name : OnDropdownAssignmentItemClick
	 * 
	 * @discription : This click event is used to select assignment number
	 */
	private class OnDropdownAssignmentItemClick implements ClickHandler{
			private String seq="";
			private String selectedTargetId;
			public OnDropdownAssignmentItemClick(String seq,String selectedTargetId){
			this.seq=seq;
			this.selectedTargetId = selectedTargetId;
			
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolderAssignment.setText(seq);
			dropdownListPlaceHolderAssignment.getElement().setId(selectedTargetId);
			new CustomAnimation(dropdownListContainerScrollPanelAssignment).run(300);
		}
	}
		
	/**
	 * 
	 * @UiHandler : CancelButton
	 * 
	 * @discription : This click event is used to hide popup
	 */
	@UiHandler("CancelButton")
	public void onclickCancelBtn(ClickEvent event){
		this.hide();
	}
	/**
	 * 
	 * @classname : clickOnSave
	 * 
	 * @discription : This click event is used reorder the assignment on click of save button 
	 */
	
	public class clickOnSave implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			CancelButton.setVisible(false);
			saveButton.setVisible(false);
			savingTextLabel.setText(i18n.GL0808());
			if(selectedPathId==null)
			{
				selectedPathId = dropdownListPlaceHolder.getElement().getId();	
			}
				
			AppClientFactory.getInjector().getClasspageService().pathwayItemMoveWithReorder(classpageId,selectedPathId,selectedAssignmentId,dropdownListPlaceHolderAssignment.getText(),new SimpleAsyncCallback<Void>(){

				@Override
				public void onSuccess(Void result) {
					CancelButton.setVisible(true);
					saveButton.setVisible(true);
					hide();
					savingTextLabel.setText("");

					setAssignmentToNewPosition(Integer.parseInt(dropdownListPlaceHolderAssignment.getText()),selectedPathId,dropdownListPlaceHolder.getElement().getInnerHTML());
					
				}
				
			});
			
		}

		public void setAssignmentToNewPosition(int seqPosition,String selectedPathId,String targetUnit){
			reorderAssignment(seqPosition,selectedPathId,targetUnit);
		}
	}

	/**
	 * 
	 * @method name : reorderAssignment
	 * 
	 * @param : seqPosition
	 * @param : selectedPathId
	 * @param : targetUnit
	 */
	public abstract void reorderAssignment(int seqPosition,String selectedPathId,String targetUnit); 
	
}
