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
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.user.UserDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class GooruGuideInfoVc extends PopupPanel {
	
	
	@UiField
	BlueButtonUc guideSlideHomeBtnUc;
	
	@UiField Label gooruGuideLbl;
	
	private static GooruGuideInfoUiBinder uiBinder = GWT.create(GooruGuideInfoUiBinder.class);

	interface GooruGuideInfoUiBinder extends UiBinder<Widget, GooruGuideInfoVc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	/**
	 * Class constructor
	 */
	public GooruGuideInfoVc() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		gooruGuideLbl.setText(i18n.GL1247());
		gooruGuideLbl.getElement().setId("lblGooruGuide");
		gooruGuideLbl.getElement().setAttribute("alt",i18n.GL1247());
		gooruGuideLbl.getElement().setAttribute("title",i18n.GL1247());
		
		guideSlideHomeBtnUc.setText(i18n.GL0543());
		guideSlideHomeBtnUc.getElement().setAttribute("alt",i18n.GL0543());
		guideSlideHomeBtnUc.getElement().setAttribute("title",i18n.GL0543());
		guideSlideHomeBtnUc.getElement().setId("btnGuideSlideHome");
	}
	
	/**
	 * Update user view flag , which is used to find out the first signin of the user 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("guideSlideHomeBtnUc")
	public void slideToHomePopUp(ClickEvent clickEvent) {
		this.hide();
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		AppClientFactory.getInjector().getUserService().updateUserViewFlag(AppClientFactory.getLoggedInUser().getGooruUId(), 2, new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo newUser) {
				UserDo user = AppClientFactory.getLoggedInUser();
				user.setViewFlag(newUser.getViewFlag());
				AppClientFactory.setLoggedInUser(user);
			}
		});
	}	
}
