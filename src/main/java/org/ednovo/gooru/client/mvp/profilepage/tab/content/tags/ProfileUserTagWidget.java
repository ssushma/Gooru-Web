package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.user.UserTagsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagWidget extends Composite {

	private static ProfileUserTagWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagWidgetUiBinder.class);

	interface ProfileUserTagWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagWidget> {
	}
	@UiField
	Label tagTitle;
	@UiField
	Label tagcount;
	@UiField
	HTMLEventPanel mainContainer;
	HTMLPanel followingContainer; HTMLPanel tagResourceContainer;		
	UserTagsDo userTagDo =new UserTagsDo();
	String titleLabelName;
	public ProfileUserTagWidget(){
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	public ProfileUserTagWidget(UserTagsDo userTagDo,HTMLPanel followingContainer, HTMLPanel tagResourceContainer) {
		this.userTagDo = userTagDo;
		initWidget(uiBinder.createAndBindUi(this));
		this.followingContainer = followingContainer;
		this.tagResourceContainer = tagResourceContainer;
		setData(userTagDo);
	}
	public void setData(UserTagsDo userTagDo){
		String titleLabel=userTagDo.getLabel();
		titleLabelName=userTagDo.getLabel();
		mainContainer.setTitle(titleLabel);
		mainContainer.getElement().setAttribute("alt", titleLabel);
		if(titleLabel.length()>=12){
			titleLabel = titleLabel.substring(0, 12) + "...";
		}
		tagTitle.setText(titleLabel);
		tagcount.setText(userTagDo.getCount());
		mainContainer.getElement().setId(userTagDo.getTagGooruOid());
		
		
		
	}
	@UiHandler("mainContainer")
	public void onclick(ClickEvent event)
	{
		tagResourceContainer.clear();
		ProfileUserTagsResourceView ProfileUserTagsResourceView=new ProfileUserTagsResourceView(mainContainer.getElement().getId(),titleLabelName,tagcount.getText(),followingContainer,tagResourceContainer);
		tagResourceContainer.add(ProfileUserTagsResourceView);
		followingContainer.setVisible(false);
		tagResourceContainer.setVisible(true);
		
		
				
	}
	
	
	
	
}
