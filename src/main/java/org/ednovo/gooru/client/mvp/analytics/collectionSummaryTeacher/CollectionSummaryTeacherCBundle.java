package org.ednovo.gooru.client.mvp.analytics.collectionSummaryTeacher;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface CollectionSummaryTeacherCBundle extends ClientBundle{
	static final CollectionSummaryTeacherCBundle INSTANCE = GWT.create(CollectionSummaryTeacherCBundle.class);
	public interface CollectionSummaryCss extends CssResource{
			
	}
	@NotStrict
	@Source("collectionSummaryTeacher.css")
	CollectionSummaryCss css();
}
