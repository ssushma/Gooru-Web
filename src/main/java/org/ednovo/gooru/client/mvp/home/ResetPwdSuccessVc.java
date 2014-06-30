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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class ResetPwdSuccessVc extends Composite implements MessageProperties {
	
	private AppPopUp appPopUp;

	@UiField
	BlueButtonUc okBtnUc;
	
	@UiField
	Label resetPasswordLbl;
	@UiField FlowPanel buttonContainer;
	
	private static final String LOGIN_WITH_NEW_PWD = GL_SPL_EXCLAMATION+" "+GL1256;

	private static resetPasswordSuccessVcUiBinder uiBinder = GWT
			.create(resetPasswordSuccessVcUiBinder.class);

	interface resetPasswordSuccessVcUiBinder extends
			UiBinder<Widget, ResetPwdSuccessVc> {
	}

	/**
	 * Class constructor , assign user name in reset password success popup
	 * 
	 * @param userName of password request user
	 */
	public ResetPwdSuccessVc(String userName) {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent(GL0062, uiBinder.createAndBindUi(this));
		resetPasswordLbl.setText(userName+LOGIN_WITH_NEW_PWD);
		resetPasswordLbl.getElement().setId("lblResetPasswordLbl");
		resetPasswordLbl.getElement().setAttribute("alt",userName+LOGIN_WITH_NEW_PWD);
		resetPasswordLbl.getElement().setAttribute("title",userName+LOGIN_WITH_NEW_PWD);
		
		buttonContainer.getElement().setId("fpnlButtonContainer");
		
		appPopUp.show();
		appPopUp.center();
		okBtnUc.setText(GL0190);
		okBtnUc.getElement().setId("btnOkBtnUc");
		okBtnUc.getElement().setAttribute("alt",GL0190);
		okBtnUc.getElement().setAttribute("title",GL0190);
		Window.enableScrolling(false);
		AppClientFactory.getEventBus().fireEvent(new SetHeaderZIndexEvent(99, false));
	}
	
	/**
	 * Redirect to home page while clicking ok button on reset password success popup 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("okBtnUc")
	public void onCancelClick(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		AppClientFactory.getEventBus().fireEvent(new SetHeaderZIndexEvent(0, true));
		appPopUp.hide();
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
	}

}
