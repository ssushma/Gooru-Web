package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnitsAssignmentWidgetView extends Composite {
	
	private static UnitsAssignmentWidgetViewUiBinder uibinder = GWT.create(UnitsAssignmentWidgetViewUiBinder.class);
	interface UnitsAssignmentWidgetViewUiBinder extends UiBinder<Widget, UnitsAssignmentWidgetView>{
		
	}
	
	
	@UiField HTMLPanel assignmentsContainer;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public UnitsAssignmentWidgetView(int totAssignment){
		initWidget(uibinder.createAndBindUi(this));
		setAssignmentsForUnit(totAssignment);
	}

	private void setAssignmentsForUnit(int totAssignment) {
		for(int i=0;i<totAssignment;i++){
			assignmentsContainer.add(new AssignmentsContainerWidget((i+1),"images/classroomSetupImg.png","25 days"));
		}
	}

}
