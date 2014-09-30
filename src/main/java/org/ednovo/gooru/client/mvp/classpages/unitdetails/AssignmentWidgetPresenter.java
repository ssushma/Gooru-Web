package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class AssignmentWidgetPresenter extends PresenterWidget<IsAssignmentWidget> implements AssignmentWidgetViewUiHandler{
	
	private HTMLPanel assignmentContainer;
	private Map<String, String> getDirection = new HashMap<String, String>();
	private HTMLPanel assignmentWidgetConatiner;
	@Inject
	public AssignmentWidgetPresenter(EventBus eventBus,
			IsAssignmentWidget view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		
	}
	@Override
	protected void onBind() {
		super.onBind();
	}
	
		
	
	
	public void getUnitAssignmentData(UnitAssignmentsDo unitAssignmentsDo,ClassDo classDo){
		getView().displayAssignments(unitAssignmentsDo,classDo);
		
	}
	
	public HTMLPanel getAssignmentContainer() {
		return assignmentContainer;
	}
	
	public void setAssignmentContainer(HTMLPanel assignmentContainer) {
		this.assignmentContainer = assignmentContainer;
	}
	
	@Override
	public void clearAssignmentContainer() {
		if(assignmentContainer!=null){
			assignmentContainer.clear();
		}
	}
	public Map<String, String> getGetDirection() {
		return getDirection;
	}
	public void setGetDirection(Map<String, String> getDirection) {
		this.getDirection = getDirection;
	}
	public HTMLPanel getAssignmentWidgetConatiner() {
		return assignmentWidgetConatiner;
	}
	public void setAssignmentWidgetConatiner(HTMLPanel assignmentWidgetConatiner) {
		this.assignmentWidgetConatiner = assignmentWidgetConatiner;
	}
	@Override
	public void clearAssignmentWidgetConatiner() {
		if(assignmentWidgetConatiner!=null){
			assignmentWidgetConatiner.clear();
		}
		
	}
		
			
}
