package org.ednovo.gooru.client.mvp.analytics.unitAssignments;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface AnalyticsUnitAssignmentsCssBundle extends ClientBundle{
	static final AnalyticsUnitAssignmentsCssBundle INSTANCE = GWT.create(AnalyticsUnitAssignmentsCssBundle.class);
	public interface  UnitAssignment extends CssResource{
		String active();
	}
	
	@NotStrict
	@Source("analyticsUnitAssignments.css")
	UnitAssignment unitAssignment();
}
