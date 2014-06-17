package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.user.UserTagsResourceDO;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	@UiField HTMLPanel userTagsResourceContainerConatiner,tagContainer;
	@UiField Label TagTextMessage,tagType,tagCount;
	@UiField
	Label tagMessage;
	String tagId;
	String labelName;
	String count;
	HTMLPanel followingContainer; 
	HTMLPanel tagResourceContainer;
	public ProfileUserTagsResourceView(String tagId,String labelName,String count,HTMLPanel followingContainer, HTMLPanel tagResourceContainer) {
		initWidget(uiBinder.createAndBindUi(this));
		this.tagId = tagId;
		this.labelName = labelName;
		this.count = count;
		this.followingContainer=followingContainer;
		this.tagResourceContainer=tagResourceContainer;
		getData(tagId);
		
	}
	
	public void getData(String tagGooruOid)
	{
		AppClientFactory.getInjector().getUserService().getResourcesByTag(tagGooruOid, new AsyncCallback<List<UserTagsResourceDO>>() {
			
			@Override
			public void onSuccess(List<UserTagsResourceDO> result) {
				
				setData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void setData(List<UserTagsResourceDO> result){
		
		TagTextMessage.setText(GL1915);
		tagMessage.setText(GL1944);
		tagContainer.getElement().setAttribute("alt", labelName);
		tagContainer.setTitle(labelName);
		
		if(labelName.length()>=12){
			labelName = labelName.substring(0, 12) + "...";
		}
		tagType.setText(labelName);
		tagCount.setText(count);
		userTagsResourceContainerConatiner.clear();
		for(int i=0;i<result.size();i++){
			ProfileUserTagsResourceWidget profileUserTagsResourceWidget=new ProfileUserTagsResourceWidget(result.get(i));
			userTagsResourceContainerConatiner.add(profileUserTagsResourceWidget);
		}
			
		
	}
	@UiHandler("tagMessage")
	public void onclickOnBackButton(ClickEvent event){
		tagResourceContainer.setVisible(false);
		followingContainer.setVisible(true);
	}
	
}
