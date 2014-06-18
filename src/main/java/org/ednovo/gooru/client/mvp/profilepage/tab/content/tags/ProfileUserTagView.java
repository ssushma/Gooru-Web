package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.user.UserTagsDo;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
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
	HTMLPanel followingContainer;
	HTMLPanel tagResourceContainer;
	@UiField ScrollPanel userTagScrollPanel;
	String limit = "10";
	int totalTagCount = 0;
	
	int totalHintCount;
	
	public ProfileUserTagView(List<UserTagsDo> userTagDo,HTMLPanel followingContainer, HTMLPanel tagResourceContainer) {
		initWidget(uiBinder.createAndBindUi(this));
		this.userTagDo = userTagDo;
		totalTagCount=0;
		totalTagCount =userTagDo.size();
		totalHintCount = userTagDo.get(0).getTotalHitCount();
		
		this.followingContainer = followingContainer;
		this.tagResourceContainer = tagResourceContainer;
		setData();
	}
	@UiHandler("userTagScrollPanel")
	public void dragFollowingScrollPanel(ScrollEvent event) {
		if (userTagScrollPanel.getVerticalScrollPosition() == userTagScrollPanel.getMaximumVerticalScrollPosition() && totalTagCount<totalHintCount) {
		AppClientFactory.getInjector().getUserService().getUserAddedContentTagSummary(AppClientFactory.getPlaceManager().getRequestParameter("id"),Integer.toString(totalTagCount),limit,new AsyncCallback<List<UserTagsDo>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<UserTagsDo> result) {
				
				if(result.size()>0){
					totalTagCount = totalTagCount+result.size();
					for(int i=0;i<result.size();i++){
						ProfileUserTagWidget profileUserTagWidget =new ProfileUserTagWidget(userTagDo.get(i),followingContainer,tagResourceContainer);
						userTagsConatiner.add(profileUserTagWidget);
					}
					
			}
				
			}
		});
		}
	}
	public void setData(){
		userTagsConatiner.clear();
		TagTextMessage.setText(GL1915);
		tagTextMessage.getElement().setInnerHTML(GL1937);
		
		for(int i=0;i<userTagDo.size();i++){
			ProfileUserTagWidget profileUserTagWidget =new ProfileUserTagWidget(userTagDo.get(i),followingContainer,tagResourceContainer);
			userTagsConatiner.add(profileUserTagWidget);
		}
		}
	
	}


