package org.ednovo.gooru.client.mvp.analytics.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class StudentScoredAboveBelowUlPanel extends Composite {

	private static StudentScoredAboveBelowUlPanelUiBinder uiBinder = GWT
			.create(StudentScoredAboveBelowUlPanelUiBinder.class);

	interface StudentScoredAboveBelowUlPanelUiBinder extends
			UiBinder<Widget, StudentScoredAboveBelowUlPanel> {
	}
	
	@UiField Image userImage;
	
	public StudentScoredAboveBelowUlPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}

	void setData(){
		userImage.setUrl("../images/analytics/score-img.png");
	}
}
