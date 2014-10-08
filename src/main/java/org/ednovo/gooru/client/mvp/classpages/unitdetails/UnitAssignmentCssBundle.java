package org.ednovo.gooru.client.mvp.classpages.unitdetails;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface UnitAssignmentCssBundle extends ClientBundle{
	static final UnitAssignmentCssBundle INSTANCE = GWT.create(UnitAssignmentCssBundle.class);
	public interface  UnitAssignment extends CssResource{
		String active();
		String bubbleMain();
		String bubbleOuter();
		String bubbleBig();
		String unitMenuActive();
		String bubbleOptional();
		String selected();
		String teachTab();
		String assingmentcompleted();
		String assignmentCompletedWithOptional();
		String dueDataIcon();
		String headerDueDate();
		String directionHeading();
		String directionDesc();
		String redCircle();
		String greenCircle();
		String stylishBub();
		String greenBubbleWithCheck();
		String redBubbleWithCheck();
		String requiredBubbleWithCheck();
		String notrequiredBubbleWithCheck();
		
	}
	
	@NotStrict
	@Source("unitassignment.css")
	UnitAssignment unitAssignment();
}
