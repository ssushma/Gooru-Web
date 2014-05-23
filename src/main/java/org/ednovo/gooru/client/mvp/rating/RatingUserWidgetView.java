package org.ednovo.gooru.client.mvp.rating;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite {

	@UiField HTMLPanel reviewContainer;
	
	@UiField Label userName, timeStamp, review;
	
	@UiField Button editReview;
	
	@UiField RatingAndReviewStyleBundle style;
	
	private static RatingUserWidgetViewUiBinder uiBinder = GWT
			.create(RatingUserWidgetViewUiBinder.class);

	interface RatingUserWidgetViewUiBinder extends
			UiBinder<Widget, RatingUserWidgetView> {
	}

	public RatingUserWidgetView(StarRatingsDo starRatingsDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(starRatingsDo);
	}
	
	public void setData(StarRatingsDo starRatingsDo) {
		userName.setText(starRatingsDo.getCreator().getUsername());
		//timeStamp.setText("3 days ago");
		review.setText(starRatingsDo.getFreeText());
		
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
			reviewContainer.addStyleName(style.creatorReviewPanel());
			editReview.addStyleName(style.editReview());
		} else {
			editReview.removeStyleName(style.editReview());
		}
	}
	
	
}