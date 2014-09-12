package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import java.util.Iterator;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class UnitsAssignmentWidgetView extends Composite {
	
	private static UnitsAssignmentWidgetViewUiBinder uibinder = GWT.create(UnitsAssignmentWidgetViewUiBinder.class);
	interface UnitsAssignmentWidgetViewUiBinder extends UiBinder<Widget, UnitsAssignmentWidgetView>{
		
	}
	
	
	@UiField HTMLPanel assignmentsContainer;
	
	@UiField Button editUnitButton,addAssignmentButton,cancelEditButton;
	
	@UiField Label lblUnitName,lblUnitNumber;
	
	CollectionDo collectionDo;
	
	boolean isDeleted=false;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(CollectionDo collectionDo){
		initWidget(uibinder.createAndBindUi(this));
		this.collectionDo=collectionDo;
		setAssignmentsForUnit();
		setUnitNameDetails();
		cancelEditButton.setVisible(false);
		editUnitButton.addClickHandler(new EditAssignmentEvent());
		cancelEditButton.addClickHandler(new CancelEditEvent());
	}

	private void setAssignmentsForUnit() {
		assignmentsContainer.clear();
		for(int i=0;i<collectionDo.getResource().getCollectionItems().size();i++){
			String url = " ";
			int itemSequence = 0;
			if(collectionDo!=null && collectionDo.getResource()!=null ){
				System.out.println("fistlevel");
				itemSequence=collectionDo.getResource().getCollectionItems().get(i).getItemSequence();
				if(collectionDo.getResource().getCollectionItems().get(i).getResource()!=null){
					url=collectionDo.getResource().getCollectionItems().get(i).getResource().getThumbnails().getUrl()!=null?collectionDo.getResource().getCollectionItems().get(i).getResource().getThumbnails().getUrl():null;
				}
			}
			assignmentsContainer.add(new AssignmentsContainerWidget(itemSequence,url,"25 days"));
		}
	}
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hideEditButton(true);
			assignmentsContainer.clear();
			for(int i=0;i<collectionDo.getResource().getCollectionItems().size();i++){
				AssignmentEditView assignmentEditView = new AssignmentEditView(collectionDo);
				assignmentEditView.getDeleteAssignmentLbl().addClickHandler(new DeleteAssignment(collectionDo.getResource().getCollectionItems().get(i).getCollectionItemId()));
				assignmentEditView.getAssignmentReorderLbl().addClickHandler(new ReorderAssignment(collectionDo.getResource().getCollectionItems().get(i).getCollectionItemId())); 
				assignmentEditView.setAssignmentId(collectionDo.getResource().getCollectionItems().get(i).getCollectionItemId());
				
				assignmentsContainer.add(assignmentEditView);
			}
		}
	}
	
	
	public class DeleteAssignment implements ClickHandler{
		String collectionItemId=null;
		
		public DeleteAssignment(String collectionItemId) {
			this.collectionItemId = collectionItemId;
		}

		@Override
		public void onClick(ClickEvent event) {
			final WaitPopupVc popupVc = new WaitPopupVc(i18n.GL1387(),i18n.GL1388()) { 
				@Override
				public void onTextConfirmed() {
					AppClientFactory.getInjector().getClasspageService().deleteClassPageItem(collectionItemId, new SimpleAsyncCallback<String>() {
						@Override
						public void onSuccess(String result) {
							if(result.equals("200")){
								boolean isAssignmentDeleted = deleteAssignmentWidget(collectionItemId);
								if(isAssignmentDeleted){
									hide();
//									getPathWayItems();
								}
							}
						}
					});
				}
			};
		}

	}
	
	
	
	public void getPathWayItems() {
		
	}
	
	
	
	public class ReorderAssignment implements ClickHandler{

		String collectionItem;
		
		public ReorderAssignment(String collectionItem){
			this.collectionItem = collectionItem;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			System.out.println("--- in order --");
		}
		
	}
	
	
	public class CancelEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hideEditButton(false);
			setAssignmentsForUnit();
		}
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
			int number=collectionDo.getItemSequence();
			String sequenceNumber=Integer.toString(number);
			lblUnitName.setText(collectionDo.getResource().getTitle());
			lblUnitNumber.setText(sequenceNumber);
	}

}
