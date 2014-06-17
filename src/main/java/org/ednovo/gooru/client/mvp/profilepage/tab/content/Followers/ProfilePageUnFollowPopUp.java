package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageUnFollowPopUp extends PopupPanel {

	private static ProfilePageUnFollowPopUpUiBinder uiBinder = GWT
			.create(ProfilePageUnFollowPopUpUiBinder.class);

	interface ProfilePageUnFollowPopUpUiBinder extends
			UiBinder<Widget, ProfilePageUnFollowPopUp> {
	}
	@UiField Label popupHeaderTitleLbl;
	@UiField Button okBtn;
	@UiField InlineLabel inputTitleLbl,inputTitleLblName;
	
	public ProfilePageUnFollowPopUp() {
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		okBtn.setText(MessageProperties.GL1386);
		popupHeaderTitleLbl.setText(MessageProperties.GL1939);
		String userName=AppClientFactory.getPlaceManager().getRequestParameter("user", null);
		inputTitleLbl.setText(MessageProperties.GL1940);
		inputTitleLblName.setText(userName);
		inputTitleLblName.getElement().setAttribute("style", "font-weight:bold");
		
	}
	@UiHandler("okBtn")
	public void clickOnOk(ClickEvent event)
	{
		this.hide();
		Window.enableScrolling(true);
	}
}
