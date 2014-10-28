package org.ednovo.gooru.client.mvp.analytics.collectionProgress;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface CollectionProgressCBundle extends ClientBundle{
	static final CollectionProgressCBundle INSTANCE = GWT.create(CollectionProgressCBundle.class);
	public interface CollectionProgressCss extends CssResource{
			String viewResponseInCollectionProgress();
	        String mainDataVpnl();
	        String alignCenterAndBackground();
	        String reaction_explain1();
	        String reaction_understand1();
	        String reaction_mean1();
	        String reaction_dontunderstand1();
	        String reaction_needhelp1();
	        String reaction_redneedhelp();
	        String reaction_reddontunderstand();
	        String htmlpanlProgress();
	        String htmlpanlProgressCollectionView();
	        String summary_title();
	        String maincontainer();
	        String narrowreportText();
	        String filterDropDown();
	        String correct_legend_one();
	        String correct_legend_other();
	        String incorrect_legend();
	        String floatLeft();
	        String resource_monitor_header_title();
	        String correct_incorrect_text();
	}
	@NotStrict
	@Source("collectionProgress.css")
	CollectionProgressCss css();
}
