package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.shared.model.user.UserFollowDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageUserInfoWidget extends Composite {

	private static ProfilePageUserInfoUiBinder uiBinder = GWT
			.create(ProfilePageUserInfoUiBinder.class);

	interface ProfilePageUserInfoUiBinder extends
			UiBinder<Widget, ProfilePageUserInfoWidget> {
	}
	@UiField Image profileThumbnailImage;
	@UiField Label userNameLabel,userCollections,userFollowDetails;
	UserFollowDo userFollowDo=new UserFollowDo();
	String tab;
	public ProfilePageUserInfoWidget(UserFollowDo userFollowDo,String tab) {
		this.userFollowDo=userFollowDo;
		this.tab = tab;
		initWidget(uiBinder.createAndBindUi(this));
		SetData();
	}
	public void SetData(){
	if("following".equalsIgnoreCase(tab)){
			setView(userFollowDo);
		}
		if("followers".equalsIgnoreCase(tab)){
			setView(userFollowDo);
		}
	}
	
	public void	setView(UserFollowDo userFollowDo){
		profileThumbnailImage.setUrl(userFollowDo.getProfileImageUrl());
		profileThumbnailImage.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent event) {
				profileThumbnailImage.setUrl("images/settings/setting-user-image.png");
				
			}
		});
		
		userNameLabel.setText(userFollowDo.getUsername());
		userCollections.setText(userFollowDo.getSummary().getCollection()+" Collection");
		
		userFollowDetails.setText(userFollowDo.getSummary().getFollowers()+" Followers | " +userFollowDo.getSummary().getFollowing()+" Following");
		
		
	}
	public void clearAll()
	{
		profileThumbnailImage.setUrl("");
		userNameLabel.setText("");
		userCollections.setText("");
		userFollowDetails.setText("");
		
	}
}
