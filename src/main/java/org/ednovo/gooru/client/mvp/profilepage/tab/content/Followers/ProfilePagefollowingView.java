package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;


import java.util.List;

import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePagefollowingView extends Composite implements MessageProperties {

	private static ProfilePagefollowingViewUiBinder uiBinder = GWT
			.create(ProfilePagefollowingViewUiBinder.class);

	interface ProfilePagefollowingViewUiBinder extends
			UiBinder<Widget, ProfilePagefollowingView> {
	}
	
	@UiField HTMLPanel follwingTextMessage,userConatiner;
	List<UserFollowDo> userFollowDo;
	String tab;
	
	public ProfilePagefollowingView(List<UserFollowDo> userFollowDo,String tab) {
		initWidget(uiBinder.createAndBindUi(this));
		this.userFollowDo = userFollowDo;
		this.tab = tab;
		setData();
	}
	public void setData(){
		follwingTextMessage.getElement().setInnerHTML(GL1913);
		userConatiner.clear();
		for(int i=0; i< userFollowDo.size(); i++){
			ProfilePageUserInfoWidget profilePageUserInfo=new ProfilePageUserInfoWidget(userFollowDo.get(i),tab);
			userConatiner.add(profilePageUserInfo);
		}
		
		
	}
	
}
