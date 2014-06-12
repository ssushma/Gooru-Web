package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.ui.HTMLEventPanel;

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
	public ProfileUserTagWidget() {
		
		initWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	public void setData(){
		tagTitle.setText("Lexile Level 6");
		tagcount.setText("26");
		profileUserTagsResourceView.tagMessage().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				
			}
		});
	}
	public HTMLEventPanel getClickOnTags()
	{
		return mainContainer;
	}
	
	
	
	
}
