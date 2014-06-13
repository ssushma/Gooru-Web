package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.user.UserTagsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagWidget extends Composite{

	private static ProfileUserTagWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagWidgetUiBinder.class);

	interface ProfileUserTagWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagWidget> {
	}
	@UiField Label tagTitle,tagcount;
	@UiField HTMLEventPanel mainContainer;
	ProfileUserTagsResourceView profileUserTagsResourceView = new ProfileUserTagsResourceView();
	UserTagsDo userTagDo =new UserTagsDo();
	public ProfileUserTagWidget(UserTagsDo userTagDo) {
		this.userTagDo = userTagDo;
		initWidget(uiBinder.createAndBindUi(this));
		setData(userTagDo);
	}
	public void setData(UserTagsDo userTagDo){
		String titleLabel=userTagDo.getLabel();
		if(titleLabel.length()>=16){
			titleLabel = titleLabel.substring(0, 16) + "...";
		}
		tagTitle.setText(titleLabel);
		tagcount.setText(userTagDo.getCount());
		mainContainer.getElement().setId(userTagDo.getTagGooruOid());
		
	}
	public HTMLEventPanel getClickOnTags()
	{
		return mainContainer;
	}
	
	
	
	
}
