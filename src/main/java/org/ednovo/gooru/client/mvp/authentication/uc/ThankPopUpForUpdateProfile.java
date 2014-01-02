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
package org.ednovo.gooru.client.mvp.authentication.uc;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
	/**
	 * 
	 * @fileName : ThankPopUpForUpdateProfile.java
	 *
	 * @description : This file deals with Thanks Popup for update profile.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
public class ThankPopUpForUpdateProfile extends PopupPanel {

	private static ThankPopUpForUpdateProfileUiBinder uiBinder = GWT
			.create(ThankPopUpForUpdateProfileUiBinder.class);

	interface ThankPopUpForUpdateProfileUiBinder extends
			UiBinder<Widget, ThankPopUpForUpdateProfile> {
	}
	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblHeading, lblSubHeading;
	@UiField
	Button btnOk;
	/**
	 * Default constructor.
	 */
	public ThankPopUpForUpdateProfile() {
		super(false);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.center();
		this.setSize("502px", "352px");
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		this.getElement().getStyle().setBackgroundColor("transparent");
		setUiAndIds();
	}
	/**
	 * 
	 * @function setUiAndIds 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This will set the ui for thanks popup and appends data to it.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUiAndIds() {
		lblTitle.setText(MessageProperties.GL0481
				+ MessageProperties.GL_SPL_EXCLAMATION);
		lblHeading.setText(MessageProperties.GL0498+MessageProperties.GL_SPL_EXCLAMATION);
		lblHeading.getElement().setAttribute("style", "margin-bottom:0px");
		lblSubHeading.setText(MessageProperties.GL0499);
		
		btnOk.getElement().setId("btnOk");
		btnOk.setText(MessageProperties.GL0190);
				
	}
    /**
     * 
     * @function onClickLblCancel 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This will close thanks popup on cancel button click.
     * 
     * 
     * @parm(s) : @param event
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
	@UiHandler("lblCancel")
	public void onClickLblCancel(ClickEvent event) {
		MixpanelUtil.close_signUp();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
	}
    /**
     * 
     * @function onClickButtonLeave 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description :This will go to close signup.
     * 
     * 
     * @parm(s) : @param event
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
	@UiHandler("btnOk")
	public void onClickButtonLeave(ClickEvent event) {
		MixpanelUtil.close_signUp();
		this.hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}

}
