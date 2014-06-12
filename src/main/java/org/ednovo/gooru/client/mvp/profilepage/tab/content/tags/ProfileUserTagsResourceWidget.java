package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;

public class ProfileUserTagsResourceWidget extends Composite {

	private static ProfileUserTagsResourceWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagsResourceWidgetUiBinder.class);

	interface ProfileUserTagsResourceWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagsResourceWidget> {
	}
	@UiField Label resourceTitle,resourceType,resourceSource;
	@UiField HTMLPanel ratingContainer;
	@UiField Image resourceImage,resourceTypeIcon;
	RatingWidgetView ratingWidgetView;
	public ProfileUserTagsResourceWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	public void setData()
	{
		resourceTitle.setText("Understand the Basic School Rules");
		resourceType.setText("video");
		resourceSource.setText("multiple Source");
		setAvgRatingWidget(2,3.2);
		
	}
	private void setAvgRatingWidget(int ratingCount,double averageRating) {
		ratingContainer.clear();
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetView.getRatingCountLabel().setText(ratingCount+"");
		ratingWidgetView.setAvgStarRating(averageRating);
		ratingContainer.add(ratingWidgetView);
	}
}
