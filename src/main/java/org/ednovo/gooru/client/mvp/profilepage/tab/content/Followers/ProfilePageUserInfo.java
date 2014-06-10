package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageUserInfo extends Composite {

	private static ProfilePageUserInfoUiBinder uiBinder = GWT
			.create(ProfilePageUserInfoUiBinder.class);

	interface ProfilePageUserInfoUiBinder extends
			UiBinder<Widget, ProfilePageUserInfo> {
	}
	@UiField Image profileThumbnailImage;
	@UiField Label userNameLabel,userCollections,userFollowers,userTags,userFollowing;
	
	public ProfilePageUserInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		SetData();
	}
	public void SetData(){
	profileThumbnailImage.setUrl("images/settings/setting-user-image.png");
	userNameLabel.setText("username");
	userCollections.setText("0 collection | ");
	userFollowers.setText("1 follower");
	userTags.setText("0 tags");
	userFollowing.setText("0 follwing");
	}
}
