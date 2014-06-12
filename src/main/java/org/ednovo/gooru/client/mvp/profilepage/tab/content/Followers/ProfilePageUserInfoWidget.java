package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

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
		
		//userNameLabel.setText(userFollowDo.getUsername());
		userNameLabel.getElement().setId(userFollowDo.getGooruUid());
		userCollections.setText(userFollowDo.getSummary().getCollection()+" Collection");
		
		userFollowDetails.setText(userFollowDo.getSummary().getFollowers()+" Followers | " +userFollowDo.getSummary().getFollowing()+" Following");
		
		String gooruUid = userNameLabel.getElement().getId();
		Anchor anchor = new Anchor();
		String userName=userFollowDo.getUsername();
		String token= "#"+PlaceTokens.PROFILE_PAGE+"&id="+gooruUid+"&user="+userName;
			anchor.setHref(token);
		
		anchor.setText(userName);
		anchor.getElement().setAttribute("style","font-size: 18px !important");
		
		anchor.setTarget("_blank");
		userNameLabel.setText("");
		userNameLabel.getElement().appendChild(anchor.getElement());	
		
	}
	public void clearAll()
	{
		profileThumbnailImage.setUrl("");
		userNameLabel.setText("");
		userCollections.setText("");
		userFollowDetails.setText("");
		
	}
	
}
