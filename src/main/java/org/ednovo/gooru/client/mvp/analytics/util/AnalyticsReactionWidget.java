package org.ednovo.gooru.client.mvp.analytics.util;

import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AnalyticsReactionWidget extends Composite {

	private static AnalyticsReactionWidgetUiBinder uiBinder = GWT
			.create(AnalyticsReactionWidgetUiBinder.class);

	interface AnalyticsReactionWidgetUiBinder extends
			UiBinder<Widget, AnalyticsReactionWidget> {
	}
	
	@UiField Label reactionlbl;
	
	CollectionSummaryIndividualCBundle res;
	
	public AnalyticsReactionWidget(int reaction) {
		this.res = CollectionSummaryIndividualCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		 if(reaction == 0){
			 reactionlbl.setText("--");
		 }else{
			  String customClass=res.css().reaction_needhelp1();
    		  if (reaction==1) {
				  customClass = res.css().reaction_needhelp1();
			  } else if (reaction==2) {
				  customClass = res.css().reaction_dontunderstand1();
			  } else if (reaction==3) {
				  customClass =res.css().reaction_mean1();
			  } else if (reaction==4) {
				  customClass = res.css().reaction_understand1();
			  }else if (reaction>4) {
				  customClass = res.css().reaction_explain1();
			  }
    		  reactionlbl.addStyleName(customClass);
		 }
		 reactionlbl.addStyleName(res.css().setMarginAuto());
	}
}
