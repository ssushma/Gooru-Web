package org.ednovo.gooru.client.mvp.analytics;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface AnalyticsCssBundle extends ClientBundle{
	static final AnalyticsCssBundle INSTANCE = GWT.create(AnalyticsCssBundle.class);
	public interface  UnitAssignment extends CssResource{
		String active();
		String bubbleMain();
		String bubbleOuter();
		String bubbleBig();
		String unitMenuActive();
		String bubbleOptional();
		String activeCaretup();
	}
	
	@NotStrict
	@Source("analytics.css")
	UnitAssignment unitAssignment();
}
