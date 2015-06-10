/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.home.landingpage;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class YoutubePopupVc extends PopupPanel{

	@UiField HTMLPanel youtubeVideoContainer;
	@UiField Label titleText;
	@UiField FocusPanel closeButton;
	private static YoutubePopUpUiBinder uiBinder = GWT
			.create(YoutubePopUpUiBinder.class);

	interface YoutubePopUpUiBinder extends UiBinder<Widget, YoutubePopupVc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public YoutubePopupVc(String title, String youtubeVideoUrl) {
		super(true);
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		MixpanelUtil.Landing_Page_video();
		youtubeVideoContainer.add(new HTML(youtubeVideoUrl));
        setModal(true);
        this.setSize("808px", "544px");
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
		this.show();
		this.center();
		titleText.setText(i18n.GL1331());
		titleText.getElement().setId("lblTitleText");
		titleText.getElement().setAttribute("alt",i18n.GL1331());
		titleText.getElement().setAttribute("title",i18n.GL1331());
		closeButton.getElement().setId("fpnlCloseButton");
		youtubeVideoContainer.getElement().setId("pnlYoutubeVideoContainer");
	}

	@Override
	public void hide(boolean autoClose){
	    super.hide(true);
	    Window.enableScrolling(true);
	}
	@UiHandler("closeButton")
	public void onCloseButtonClick(ClickEvent event)
	{
		this.hide();
	}
	
}
