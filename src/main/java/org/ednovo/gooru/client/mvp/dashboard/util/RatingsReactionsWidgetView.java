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
package org.ednovo.gooru.client.mvp.dashboard.util;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.PublishedCollectionsInfoDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : RatingsReactionsWidgetView.java
 *
 * @description : This is a widget used for iterating profile page user ratings details and Users' reactions details. 
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
public abstract class RatingsReactionsWidgetView extends Composite {

	private static RatingsReactionsWidgetViewViewUiBinder uiBinder = GWT.create(RatingsReactionsWidgetViewViewUiBinder.class);

	interface RatingsReactionsWidgetViewViewUiBinder extends UiBinder<Widget, RatingsReactionsWidgetView> {
	}
	
	public MessageProperties i18N = GWT.create(MessageProperties.class);

	
	PublishedCollectionsInfoDo publishedCollectionsInfoDoGlobal = new PublishedCollectionsInfoDo();
		
	@UiField Label labelValue;
	
	@UiField FlowPanel ratingReactionWidget;
	
	@UiField HTMLPanel resourcesTitle;
	
	@UiField Image resourceTypeIcon;
	
	
	int position = 0;
	
	public RatingsReactionsWidgetView(PublishedCollectionsInfoDo publishedCollectionsInfoDo, String ratingsorreactions, Boolean ratingorreactionFlag) {
		initWidget(uiBinder.createAndBindUi(this));

		this.publishedCollectionsInfoDoGlobal=publishedCollectionsInfoDo;
		
		if(ratingorreactionFlag)
		{
		RatingWidgetView ratingWidgetView = new RatingWidgetView();
		ratingWidgetView.setAvgStarRating(5);
		ratingReactionWidget.add(ratingWidgetView);
		resourcesTitle.setTitle(publishedCollectionsInfoDo.getTitle());
		resourceTypeIcon.setUrl("images/"+publishedCollectionsInfoDo.getCategory()+"Icon.png");
		labelValue.setText("(based on "+publishedCollectionsInfoDo.getRatingsCount()+" "+ratingsorreactions+")");
		}
		else
		{
		ReactionWidget reactionWidget = new ReactionWidget(5);
		ratingReactionWidget.add(reactionWidget);
		resourcesTitle.setTitle(publishedCollectionsInfoDo.getTitle());
		resourceTypeIcon.setUrl("images/"+publishedCollectionsInfoDo.getCategory()+"Icon.png");
		labelValue.setText("(based on "+publishedCollectionsInfoDo.getReactionsCount()+" "+ratingsorreactions+")");
		}

	}
	
	
	
}