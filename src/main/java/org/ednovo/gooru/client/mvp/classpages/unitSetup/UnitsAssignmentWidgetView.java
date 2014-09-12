package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
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

public class UnitsAssignmentWidgetView extends Composite {
	
	private static UnitsAssignmentWidgetViewUiBinder uibinder = GWT.create(UnitsAssignmentWidgetViewUiBinder.class);
	interface UnitsAssignmentWidgetViewUiBinder extends UiBinder<Widget, UnitsAssignmentWidgetView>{
		
	}
	
	
	@UiField HTMLPanel assignmentsContainer;
	
	@UiField Button editUnitButton,addAssignmentButton,cancelEditButton;
	
	@UiField Label lblUnitName,lblUnitNumber;
	
	CollectionDo collectionDo;
	
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
				System.out.println("itemSequence::"+itemSequence);
				if(collectionDo.getResource().getCollectionItems().get(i).getResource()!=null){
					System.out.println("secondlevel");
					url=collectionDo.getResource().getCollectionItems().get(i).getResource().getThumbnails().getUrl()!=null?collectionDo.getResource().getCollectionItems().get(i).getResource().getThumbnails().getUrl():null;
				   System.out.println("url::"+url);
				}
			}
			assignmentsContainer.add(new AssignmentsContainerWidget(itemSequence,url," "));
		}
	}
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hideEditButton(true);
			assignmentsContainer.clear();
			for(int i=0;i<9;i++){
				assignmentsContainer.add(new AssignmentEditView());
			}
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
	
	private void setUnitNameDetails() {
			int number=collectionDo.getItemSequence();
			String sequenceNumber=Integer.toString(number);
			lblUnitName.setText(collectionDo.getResource().getTitle());
			lblUnitNumber.setText(sequenceNumber);
	}

}
