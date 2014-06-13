package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.shared.model.user.UserTagsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagView extends Composite implements MessageProperties {

	private static ProfileUserTagViewUiBinder uiBinder = GWT
			.create(ProfileUserTagViewUiBinder.class);

	interface ProfileUserTagViewUiBinder extends
			UiBinder<Widget, ProfileUserTagView> {
	}
	
	List<UserTagsDo> userTagDo = new ArrayList<UserTagsDo>();
	
	@UiField HTMLPanel userTagsConatiner,tagTextMessage;
	@UiField Label TagTextMessage;
	ProfileUserTagWidget profileUserTagWidget;
	public ProfileUserTagView(List<UserTagsDo> userTagDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.userTagDo=userTagDo;
		setData();
	}
	public void setData(){
		TagTextMessage.setText(GL1915);
		tagTextMessage.getElement().setInnerHTML(GL1937);
		for(int i=0;i<userTagDo.size();i++){
			profileUserTagWidget=new ProfileUserTagWidget(userTagDo.get(i));
			userTagsConatiner.add(profileUserTagWidget);
		}
		
	}

}
