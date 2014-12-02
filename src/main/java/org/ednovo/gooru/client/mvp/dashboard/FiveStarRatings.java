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
package org.ednovo.gooru.client.mvp.dashboard;
/**


*
* @description : 
*
* @version :1.0
*
* @date: APR 19 2013
   	
* @Author Gooru Team
* 
* Reviewer Gooru Team
*
*/
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class FiveStarRatings extends Composite{
	private static FiveStarRatingsUiBinder uiBinder = GWT
			.create(FiveStarRatingsUiBinder.class);
	
	@UiField Label fiveStarRatedLbl,resourceNameLbl,icanExplainLbl,reactionResourcesLbl;
	@UiField Image fivestarImage,resourceImage,iCanExplainImage;
	@UiField HTMLPanel ratingsHeaderPnl,reactionsHeaderPnl;

	interface FiveStarRatingsUiBinder extends
			UiBinder<Widget, FiveStarRatings> {

	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, FiveStarRatings> {
	}

	@Inject
	public FiveStarRatings() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public FiveStarRatings(String val) {
		initWidget(uiBinder.createAndBindUi(this));
		fiveStarRatedLbl.setText("5-Star Rated Resources");
		fivestarImage.setUrl("../images/profileimages/rating.png");
		resourceImage.setUrl("../images/profileimages/videoIcon.png");
		resourceNameLbl.setText("Roman Poets");
		resourceNameLbl.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		iCanExplainImage.setUrl("../images/profileimages/iconBig.png");
		icanExplainLbl.setText("I Can Explain");
		reactionResourcesLbl.setText("Reaction Resources");
		if(val.equalsIgnoreCase("fivestarRatings")){
			ratingsHeaderPnl.setVisible(true);
			reactionsHeaderPnl.setVisible(false);
		}else if(val.equalsIgnoreCase("fivestarReviews")){
			ratingsHeaderPnl.setVisible(false);
			reactionsHeaderPnl.setVisible(true);
		}
	}
}