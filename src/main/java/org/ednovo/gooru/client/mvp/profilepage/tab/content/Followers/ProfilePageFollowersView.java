package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.user.UserFollowDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageFollowersView extends Composite implements MessageProperties {

	private static ProfilePageFollowersViewUiBinder uiBinder = GWT
			.create(ProfilePageFollowersViewUiBinder.class);

	interface ProfilePageFollowersViewUiBinder extends
			UiBinder<Widget, ProfilePageFollowersView> {
	}
	@UiField HTMLPanel followersUserConatiner;
	List<UserFollowDo> userFollowDo = new ArrayList<UserFollowDo>();
	@UiField InlineLabel followersTextMessage,followersTextMessageNormal;
	String tab;
	@UiField ScrollPanel followerScrollPanel;
	
	String limit = "10";
	int totalUserCount  = 0;
	int totalHintCount;
	
	public ProfilePageFollowersView(List<UserFollowDo> userFollowDo,String tab) {
		this.tab = tab;
		this.userFollowDo = userFollowDo;
		initWidget(uiBinder.createAndBindUi(this));
		totalUserCount =0;
		totalUserCount  =userFollowDo.size();
		totalHintCount = userFollowDo.get(0).getTotalHintCount();
		setData();
	}
	public void setData()
	{
		
		followersTextMessage.setText(GL1914);
		followersTextMessage.getElement().setAttribute("style", "font-weight:bold");
		followersTextMessageNormal.setText(GL1914_1);
		followersUserConatiner.clear();
		for(int i=0; i< userFollowDo.size(); i++){
			ProfilePageUserInfoWidget profilePageUserInfoWidget=new ProfilePageUserInfoWidget(userFollowDo.get(i),tab);
			followersUserConatiner.add(profilePageUserInfoWidget);
		}
		
		
	}
	@UiHandler("followerScrollPanel")
	public void dragFollowingScrollPanel(ScrollEvent event) {
		if (followerScrollPanel.getVerticalScrollPosition() == followerScrollPanel.getMaximumVerticalScrollPosition() && totalUserCount <totalHintCount) {
		
			AppClientFactory.getInjector().getUserService().getFollowedByUsers(AppClientFactory.getPlaceManager().getRequestParameter("id"),Integer.toString(totalUserCount),limit, new AsyncCallback<List<UserFollowDo>>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<UserFollowDo> result) {
			
				if(result.size()>0){
					totalUserCount  = totalUserCount +result.size();
					for(int i=0; i< result.size(); i++){
						ProfilePageUserInfoWidget profilePageUserInfoWidget=new ProfilePageUserInfoWidget(result.get(i),tab);
						followersUserConatiner.add(profilePageUserInfoWidget);
					}
				
				}
			}
		});
	}
	}

}
