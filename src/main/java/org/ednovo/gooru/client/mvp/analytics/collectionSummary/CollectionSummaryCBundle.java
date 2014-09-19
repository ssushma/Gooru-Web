package org.ednovo.gooru.client.mvp.analytics.collectionSummary;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface CollectionSummaryCBundle extends ClientBundle{
	static final CollectionSummaryCBundle INSTANCE = GWT.create(CollectionSummaryCBundle.class);
	public interface CollectionSummaryCss extends CssResource{
			
	}
	@NotStrict
	@Source("collectionSummary.css")
	CollectionSummaryCss css();
}
