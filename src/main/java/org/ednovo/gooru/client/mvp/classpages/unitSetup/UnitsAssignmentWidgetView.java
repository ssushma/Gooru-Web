package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnitsAssignmentWidgetView extends Composite {
	
	private static UnitsAssignmentWidgetViewUiBinder uibinder = GWT.create(UnitsAssignmentWidgetViewUiBinder.class);
	interface UnitsAssignmentWidgetViewUiBinder extends UiBinder<Widget, UnitsAssignmentWidgetView>{
		
	}
	
	
	@UiField HTMLPanel assignmentsContainer;
	
	@UiField Button editUnitButton,addAssignmentButton,cancelEditButton;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(int totAssignment){
		initWidget(uibinder.createAndBindUi(this));
		setAssignmentsForUnit(totAssignment);
		cancelEditButton.setVisible(false);
		editUnitButton.addClickHandler(new EditAssignmentEvent());
		cancelEditButton.addClickHandler(new CancelEditEvent());
	}

	private void setAssignmentsForUnit(int totAssignment) {
		assignmentsContainer.clear();
		for(int i=0;i<totAssignment;i++){
			assignmentsContainer.add(new AssignmentsContainerWidget((i+1),"images/classroomSetupImg.png","25 days"));
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
			setAssignmentsForUnit(10);
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

}
