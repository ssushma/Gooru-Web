package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;


public interface IsAssignmentWidget extends IsViewWithHandlers<AssignmentWidgetViewUiHandler>{
	public void displayAssignments(UnitAssignmentsDo unitAssignmentsDo);
	public void getClassUnitDoObj(ClassDo classDo);
	
	
}
