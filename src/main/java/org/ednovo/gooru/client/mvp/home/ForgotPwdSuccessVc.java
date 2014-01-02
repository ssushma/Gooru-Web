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
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ForgotPwdSuccessVc.java
 *
 * @description : To Hide ForgotPasswordVc and to create a new popup.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ForgotPwdSuccessVc extends PopupPanel implements MessageProperties{

	private static ForgotPwdSuccessVcUiBinder uiBinder = GWT
			.create(ForgotPwdSuccessVcUiBinder.class);

	interface ForgotPwdSuccessVcUiBinder extends
			UiBinder<Widget, ForgotPwdSuccessVc> {
	}
	
	
	@UiField
	Anchor supportlnk;
	@UiField
	Button okBtnUc;
	
	@UiField(provided = true)
	LoginPopUpCBundle res;
	
	@UiField Label lblLoginHeading,lblTextMessageInfomation,lblDisplayTextMessage;
	@UiField HTMLEventPanel closeButton;
	/**
	 * Class constructor , create a new pop up
	 */
	public ForgotPwdSuccessVc() {
		super(false);
		this.res = LoginPopUpCBundle.INSTANCE;
        res.css().ensureInjected();
        this.setGlassStyleName(LoginPopUpCBundle.INSTANCE.css().loginPopupGlassStyle());
        this.setGlassEnabled(true);
        setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(99999);
       	okBtnUc.getElement().setId("btnSubmit");
       	supportlnk.getElement().setId("lnksupport");
		
		this.setSize("502px", "382px");
		lblLoginHeading.setHeight("16px");
		lblLoginHeading.setText(MessageProperties.GL0063);
		lblDisplayTextMessage.setText(MessageProperties.GL0440);
		lblTextMessageInfomation.getElement().setAttribute("style", "font-size: 16px !important");
		lblTextMessageInfomation.setText(MessageProperties.GL0441);
		this.center();
		
	}
	
	/**
	 * Hide {@link ForgotPasswordVc} popup
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("okBtnUc")
	public void onOkBtnUcClick(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
		/*ForgotPasswordConfirmEmail forgotPasswordConfirmEmail=new ForgotPasswordConfirmEmail();
		forgotPasswordConfirmEmail.setGlassEnabled(true);
		forgotPasswordConfirmEmail.show();
		forgotPasswordConfirmEmail.center();*/
		
	}
	/**
	 * 
	 * @function onCloseClick 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandler for closeButton.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("closeButton")
	public void onCloseClick(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
	}
}
