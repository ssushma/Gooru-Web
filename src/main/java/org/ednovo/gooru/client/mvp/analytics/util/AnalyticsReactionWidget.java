/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
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
	
	/**
	 * Constructor
	 * @param reaction
	 */
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
