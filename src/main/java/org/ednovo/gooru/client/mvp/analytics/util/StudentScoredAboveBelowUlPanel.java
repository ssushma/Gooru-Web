package org.ednovo.gooru.client.mvp.analytics.util;

import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class StudentScoredAboveBelowUlPanel extends Composite {

	private static StudentScoredAboveBelowUlPanelUiBinder uiBinder = GWT
			.create(StudentScoredAboveBelowUlPanelUiBinder.class);

	interface StudentScoredAboveBelowUlPanelUiBinder extends
			UiBinder<Widget, StudentScoredAboveBelowUlPanel> {
	}
	
	@UiField Image userImage;
	@UiField Label namelbl,scorelbl,timelbl;
	@UiField HTMLPanel reactionlbl;
	
	public StudentScoredAboveBelowUlPanel(UserDataDo userData) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(userData);
	}

	void setData(UserDataDo userData){
		userImage.setUrl("../images/analytics/score-img.png");
		namelbl.setText(userData.getUserName());
		scorelbl.setText(userData.getGradeInPercentage());
		timelbl.setText(userData.getTimeSpent()+"");
		reactionlbl.add(new AnalyticsReactionWidget(userData.getReaction()));
	}
}
