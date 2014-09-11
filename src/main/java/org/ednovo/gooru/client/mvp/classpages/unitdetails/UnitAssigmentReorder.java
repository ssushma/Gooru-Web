package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnitAssigmentReorder extends PopupPanel implements HasMouseOverHandlers,HasMouseOutHandlers{
private static UnitAssigmentReorderUiBinder uiBinder = GWT
			.create(UnitAssigmentReorderUiBinder.class);

	interface UnitAssigmentReorderUiBinder extends
			UiBinder<Widget, UnitAssigmentReorder> {
	}
	@UiField Image popupArrow;
	@UiField Button saveButton,CancelButton;
	@UiField Label titleLabel,descLabel;
	@UiField InlineLabel dropdownListPlaceHolder,dropdownListPlaceHolderAssignment;
	@UiField ScrollPanel dropdownListContainerScrollPanel,dropdownListContainerScrollPanelAssignment;
	@UiField HTMLPanel dropdownListContainer,dropdownListContainerAssignment;
	ClasspageListDo classpageListDo;
	int totalCount=0;
	int totalsize=0;
	int assignmentTotalCount=0;
	int assignmentTotalSize=0;
	private String ORDER_BY="sequence";
	String classpageId;
	
	private int assignment_limit=10;
	private int totalAssignmencount=0;
	
	public UnitAssigmentReorder(ClasspageListDo classpageListDo,ArrayList<CollectionItemDo> assignmentItemSeq,String classpageId) {
		setWidget(uiBinder.createAndBindUi(this));
		this.classpageListDo = classpageListDo;
		this.classpageId = classpageId;
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		setUnitAssignmentData(classpageListDo);
		getAssignmentDropDown(assignmentItemSeq);
		
	}
	public void setUnitAssignmentData(ClasspageListDo classpageListDo){
		popupArrow.setUrl("images/popArrow.png");
		saveButton.setText("Save");
		CancelButton.setText("Cancel");
		titleLabel.setText(classpageListDo.getSearchResults().get(0).getResource().getTitle());
		descLabel.setText(classpageListDo.getSearchResults().get(0).getResource().getDescription());
		dropdownListContainerScrollPanel.getElement().getStyle().setDisplay(Display.NONE);
		dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
		dropdownListPlaceHolder.getElement().setInnerHTML("1");
	
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		totalCount=classpageListDo.getTotalHitCount()!=null?classpageListDo.getTotalHitCount():0;
		System.out.println("totalCount.."+totalCount);
		totalsize =totalsize+classpageListDo.getSearchResults().size() ;
		System.out.println("totalsize.."+totalsize);
		for(int i=0; i<totalsize; i++){
		
			int number=classpageListDo.getSearchResults().get(i).getItemSequence();
			Label dropDownListItem=new Label(number+"");
			dropDownListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
			dropdownListContainer.add(dropDownListItem);
			dropDownListItem.addClickHandler(new OnDropdownItemClick(number+""));
		}
	}
	public void getAssignmentDropDown(ArrayList<CollectionItemDo> assignmentItemSeq)
	{
		dropdownListContainerScrollPanelAssignment.getElement().getStyle().setDisplay(Display.NONE);
		dropdownListPlaceHolderAssignment.addClickHandler(new OnDropdownListAssignmentPlaceHolderClick());
		dropdownListPlaceHolderAssignment.getElement().setInnerHTML("1");
		dropdownListContainerScrollPanel.addScrollHandler(new AssignmentScrollDropdownListContainer());
		assignmentTotalCount = assignmentItemSeq.get(0).getTotalHitCount();
		System.out.println("assignmentTotalCount.."+assignmentTotalCount);
		assignmentTotalSize = 0;
		assignmentTotalSize = assignmentTotalSize+assignmentItemSeq.size();
		for(int i=0; i<assignmentItemSeq.size(); i++){
			
			int number=assignmentItemSeq.get(i).getItemSequence();
			Label dropDownAssignmentListItem=new Label(number+"");
			dropDownAssignmentListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
			dropdownListContainerAssignment.add(dropDownAssignmentListItem);
			dropDownAssignmentListItem.addClickHandler(new OnDropdownAssignmentItemClick(number+""));
		}
	
	}
	private class ScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((dropdownListContainerScrollPanel.getVerticalScrollPosition() == dropdownListContainerScrollPanel.getMaximumVerticalScrollPosition())&&(totalCount>totalsize)){
				AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, Integer.toString(5),  Integer.toString(totalsize), new SimpleAsyncCallback<ClasspageListDo>() {

					@Override
					public void onSuccess(ClasspageListDo result) {
						totalsize = totalsize + result.getSearchResults().size();
						for(int i=0; i<result.getSearchResults().size(); i++){
							
							int number=result.getSearchResults().get(i).getItemSequence();
							Label dropDownListItem=new Label(number+"");
							dropDownListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
							dropdownListContainer.add(dropDownListItem);
							dropDownListItem.addClickHandler(new OnDropdownItemClick(number+""));
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
	
		public OnDropdownItemClick(String seq){
			this.seq=seq;
			
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolder.setText(seq);
			//dropdownListPlaceHolder.getElement().setAttribute("id", collectionId);
			//dropdownListPlaceHolder.getElement().setAttribute("itemsSize", ""+collectionItemsSize);
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
			assignmentTotalSize=0;
			AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, assignment_limit, totalAssignmencount, new AsyncCallback<ArrayList<CollectionItemDo>>() {
				
				@Override
				public void onSuccess(ArrayList<CollectionItemDo> result) {
					if(result!=null){
					
					assignmentTotalCount = result.get(0).getTotalHitCount();
					assignmentTotalSize = assignmentTotalSize+result.size();
					dropdownListContainerAssignment.clear();
					for(int i=0; i<result.size(); i++){
						
						int number=result.get(i).getItemSequence();
						Label dropDownAssignmentListItem=new Label(number+"");
						dropDownAssignmentListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
						dropdownListContainerAssignment.add(dropDownAssignmentListItem);
						dropDownAssignmentListItem.addClickHandler(new OnDropdownAssignmentItemClick(number+""));
					}
				}
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	private class OnDropdownAssignmentItemClick implements ClickHandler{
		private String seq="";
		private String collectionId="";
		private int collectionItemsSize;
		public OnDropdownAssignmentItemClick(String seq){
			this.seq=seq;
			
		}
		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolderAssignment.setText(seq);
			dropdownListPlaceHolderAssignment.getElement().setAttribute("id", collectionId);
			dropdownListPlaceHolderAssignment.getElement().setAttribute("itemsSize", ""+collectionItemsSize);
			new CustomAnimation(dropdownListContainerScrollPanelAssignment).run(300);
		}
	}
	private class AssignmentScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((dropdownListContainerScrollPanelAssignment.getVerticalScrollPosition() == dropdownListContainerScrollPanelAssignment.getMaximumVerticalScrollPosition())&&(assignmentTotalCount>assignmentTotalSize)){
				
				AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, "25509399-83ab-42f1-b774-c1e424b132d0", ORDER_BY, assignment_limit, assignmentTotalSize, new AsyncCallback<ArrayList<CollectionItemDo>>() {
					
					@Override
					public void onSuccess(ArrayList<CollectionItemDo> result) {
						totalAssignmencount=totalAssignmencount+result.size();
						for(int i=0; i<result.size(); i++){
							
							int number=result.get(i).getItemSequence();
							Label dropDownAssignmentListItem=new Label(number+"");
							dropDownAssignmentListItem.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().dropdownListItemContainer());
							dropdownListContainerAssignment.add(dropDownAssignmentListItem);
							dropDownAssignmentListItem.addClickHandler(new OnDropdownAssignmentItemClick(number+""));
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			}
	}
	@UiHandler("saveButton")
	public void onclickSaveBtn(ClickEvent event){
		System.out.println("dropdownListPlaceHolderAssignment.getText().."+dropdownListPlaceHolderAssignment.getText());
		AppClientFactory.getInjector().getClasspageService().v2ReorderPathwaySequence(classpageId,"25509399-83ab-42f1-b774-c1e424b132d0",Integer.parseInt(dropdownListPlaceHolderAssignment.getText()),new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("result on suceess");	
			}

			
	});	
		
	}
	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}
	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}
}
