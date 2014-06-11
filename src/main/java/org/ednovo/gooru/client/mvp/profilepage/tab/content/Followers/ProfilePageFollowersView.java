package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageFollowersView extends Composite implements MessageProperties {

	private static ProfilePageFollowersViewUiBinder uiBinder = GWT
			.create(ProfilePageFollowersViewUiBinder.class);

	interface ProfilePageFollowersViewUiBinder extends
			UiBinder<Widget, ProfilePageFollowersView> {
	}
	@UiField HTMLPanel followersTextMessage,followersUserConatiner;
	List<UserFollowDo> userFollowDo = new ArrayList<UserFollowDo>();
	String tab;
	public ProfilePageFollowersView(List<UserFollowDo> userFollowDo,String tab) {
		this.tab = tab;
		this.userFollowDo = userFollowDo;
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	public void setData()
	{
		followersTextMessage.getElement().setInnerHTML(GL1914);
		followersUserConatiner.clear();
		for(int i=0; i< userFollowDo.size(); i++){
			ProfilePageUserInfoWidget profilePageUserInfoWidget=new ProfilePageUserInfoWidget(userFollowDo.get(i),tab);
			followersUserConatiner.add(profilePageUserInfoWidget);
		}
		
		
	}

}
