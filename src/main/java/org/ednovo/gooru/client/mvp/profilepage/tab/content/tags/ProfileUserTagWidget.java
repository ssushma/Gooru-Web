package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.user.UserTagsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
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
			
	UserTagsDo userTagDo =new UserTagsDo();
	public ProfileUserTagWidget(){
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	public ProfileUserTagWidget(UserTagsDo userTagDo) {
		this.userTagDo = userTagDo;
		initWidget(uiBinder.createAndBindUi(this));
		
		setData(userTagDo);
	}
	public void setData(UserTagsDo userTagDo){
		String titleLabel=userTagDo.getLabel();
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
		
		ProfileUserTagsResourceView ProfileUserTagsResourceView=new ProfileUserTagsResourceView(mainContainer.getElement().getId(),tagTitle.getText(),tagcount.getText());
		ProfileUserTagsResourceView.show();
		ProfileUserTagsResourceView.center();
		
				
	}
	
	
	
	
}
