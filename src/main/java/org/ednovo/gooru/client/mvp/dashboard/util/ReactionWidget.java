package org.ednovo.gooru.client.mvp.dashboard.util;

import org.ednovo.gooru.client.mvp.dashboard.util.ReactionsWidgetCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : ReactionWidget
 *
 * @description : This widget is used for displaying the reaction icon based on the value passed. 
 *
 *
 * @version : 1.0
 *
 * @date: 08-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class ReactionWidget extends Composite {

	private static ReactionWidgetUiBinder uiBinder = GWT
			.create(ReactionWidgetUiBinder.class);

	interface ReactionWidgetUiBinder extends
			UiBinder<Widget, ReactionWidget> {
	}
	
	@UiField Label reactionlbl;
	
	ReactionsWidgetCBundle res;
	
	/**
	 * Constructor
	 * @param reaction
	 */
	public ReactionWidget(int reaction) {
		this.res = ReactionsWidgetCBundle.INSTANCE;
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
