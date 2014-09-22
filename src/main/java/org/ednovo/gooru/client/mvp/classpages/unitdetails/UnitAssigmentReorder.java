package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.ReorderAssignmentEvent;
import org.ednovo.gooru.client.mvp.search.event.ResetProgressEvent;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

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

public abstract class UnitAssigmentReorder extends PopupPanel{ 
private static UnitAssigmentReorderUiBinder uiBinder = GWT
			.create(UnitAssigmentReorderUiBinder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	interface UnitAssigmentReorderUiBinder extends
			UiBinder<Widget, UnitAssigmentReorder> {
	}
	@UiField Image popupArrow;
	@UiField Button saveButton,CancelButton;
	@UiField Label titleLabel,descLabel,savingTextLabel,unitTextLbl,assignmentTextLbl;
	@UiField InlineLabel dropdownListPlaceHolder,dropdownListPlaceHolderAssignment;
	@UiField ScrollPanel dropdownListContainerScrollPanel,dropdownListContainerScrollPanelAssignment;
	@UiField HTMLPanel dropdownListContainer,dropdownListContainerAssignment,mainPanel;
	ClassDo classDo;
	int totalCount=0;
	int totalsize=0;
	String classpageId;
	private String selectedPathId;
	private HandlerRegistration onClickUnit;
	
	public UnitAssigmentReorder(ClassDo classDo,String title,String narration,String classpageId,int selectedUnitNumber) {
		setWidget(uiBinder.createAndBindUi(this));
		this.classDo = classDo;
		this.classpageId = classpageId;
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		unitTextLbl.setText(i18n.GL2175());
		unitTextLbl.getElement().setAttribute("style", "display: inline-block;");
		assignmentTextLbl.setText(i18n.GL0103());
		assignmentTextLbl.getElement().setAttribute("style", "display: inline-block;");
		setUnitAssignmentData(classDo,title,narration,selectedUnitNumber);
				
	}
	public void setUnitAssignmentData(ClassDo classDo,String title,String narration,int selectedUnitNumber){
		int totalItemCount = 0;
		popupArrow.setUrl("images/popArrow.png");
		saveButton.setText(i18n.GL0141());
		CancelButton.setText(i18n.GL0142());
		dropdownListContainerScrollPanel.getElement().getStyle().setDisplay(Display.NONE);
		dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
		saveButton.addClickHandler(new clickOnSave());
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		
		totalCount=classDo.getTotalHitCount()!=null?classDo.getTotalHitCount():0;
		if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
			ArrayList<ClassUnitsListDo> classListUnitsListDo =classDo.getSearchResults();
			titleLabel.setText(title);
			if(narration!=null){
				descLabel.setText(narration);
			}
			totalsize =totalsize+classListUnitsListDo.size() ;
			
			for(int i=0; i<classListUnitsListDo.size(); i++){

				totalItemCount=classListUnitsListDo.get(0).getResource().getItemCount();
				displayAssignment(totalItemCount);
				int number=classListUnitsListDo.get(i).getItemSequence();
				
				if(selectedUnitNumber==0){
					dropdownListPlaceHolder.getElement().setInnerHTML(classListUnitsListDo.get(0).getItemSequence()+"");
				}else{
					dropdownListPlaceHolder.getElement().setInnerHTML(selectedUnitNumber+"");
				}
				
				dropdownListPlaceHolder.getElement().setId(classListUnitsListDo.get(0).getResource().getGooruOid());
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
				dropDownAssignmentListItem.addClickHandler(new OnDropdownAssignmentItemClick(number+""));
			}
		}else
		{
			dropdownListPlaceHolderAssignment.getElement().setInnerHTML(1+"");
		}
	}
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
	private class OnDropdownListPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
		}
	}
	private class OnDropdownListAssignmentPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanelAssignment).run(300);
		}
	}
	
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
			//dropdownListPlaceHolder.getElement().setId(UnitCollectionItemId);
			dropdownListPlaceHolder.getElement().setAttribute("id", itemCount+"");
			selectedPathId = UnitCollectionItemId;
			displayAssignment(Integer.parseInt(itemCount));
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
			
			
		}
	}
	private class OnDropdownAssignmentItemClick implements ClickHandler{
		private String seq="";
			public OnDropdownAssignmentItemClick(String seq){
			this.seq=seq;
			
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolderAssignment.setText(seq);
			new CustomAnimation(dropdownListContainerScrollPanelAssignment).run(300);
		}
	}
		
	
	@UiHandler("CancelButton")
	public void onclickCancelBtn(ClickEvent event){
		this.hide();
	}
	
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
			AppClientFactory.getInjector().getClasspageService().v2ReorderPathwaySequence(classpageId,selectedPathId,Integer.parseInt(dropdownListPlaceHolderAssignment.getText()),new SimpleAsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
					CancelButton.setVisible(true);
					saveButton.setVisible(true);
					hide();
					savingTextLabel.setText("");
					
					setAssignmentToNewPosition(Integer.parseInt(dropdownListPlaceHolderAssignment.getText()),selectedPathId);
					
//					AppClientFactory.fireEvent(new ReorderAssignmentEvent(Integer.parseInt(dropdownListPlaceHolderAssignment.getText())));
					
					
					
				}
		});	
			
		}

		public void setAssignmentToNewPosition(int seqPosition,String selectedPathId){
			reorderAssignment(seqPosition,selectedPathId);
		}
	}


	public abstract void reorderAssignment(int seqPosition,String selectedPathId); 
	
}
