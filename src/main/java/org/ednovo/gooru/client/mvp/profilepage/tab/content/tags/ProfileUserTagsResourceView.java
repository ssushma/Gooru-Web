package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagsResourceView extends Composite implements MessageProperties {

	private static ProfileUserTagsResourceViewUiBinder uiBinder = GWT
			.create(ProfileUserTagsResourceViewUiBinder.class);

	interface ProfileUserTagsResourceViewUiBinder extends
			UiBinder<Widget, ProfileUserTagsResourceView> {
	}
	@UiField HTMLPanel userTagsResourceContainerConatiner;
	@UiField Label TagTextMessage,tagType,tagCount,tagMessage;

	public ProfileUserTagsResourceView() {
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	public void setData(){
		TagTextMessage.setText(GL1915);
		tagMessage.setText(GL1943);
		tagType.setText("handout");
		tagCount.setText("60");
		for(int i=0;i<7;i++){
			ProfileUserTagsResourceWidget profileUserTagsResourceWidget=new ProfileUserTagsResourceWidget();
			userTagsResourceContainerConatiner.add(profileUserTagsResourceWidget);
			
		}
	}
	public Label tagMessage(){
		return tagMessage;
	}
}
