package org.ednovo.gooru.client.mvp.dashboard.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface ReactionsWidgetCBundle extends ClientBundle{
	static final ReactionsWidgetCBundle INSTANCE = GWT.create(ReactionsWidgetCBundle.class);
	public interface CollectionSummaryIndividualCss extends CssResource{
		      String setMarginAuto();
	          String reaction_explain1();
	          String reaction_understand1();
	          String reaction_mean1();
	          String reaction_dontunderstand1();
			  String reaction_needhelp1();
	}
	@NotStrict
	@Source("collectionSummaryIndividual.css")
	CollectionSummaryIndividualCss css();
}
