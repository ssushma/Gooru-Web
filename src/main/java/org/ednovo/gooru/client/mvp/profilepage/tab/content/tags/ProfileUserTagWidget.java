package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagWidget extends Composite {

	private static ProfileUserTagWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagWidgetUiBinder.class);

	interface ProfileUserTagWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagWidget> {
	}
	@UiField Label tagTitle,tagcount;
	public ProfileUserTagWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	public void setData(){
		tagTitle.setText("Lexile Level 6");
		tagcount.setText("26");
	}
}
