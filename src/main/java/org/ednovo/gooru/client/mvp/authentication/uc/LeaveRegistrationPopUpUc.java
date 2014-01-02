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

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

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

public class LeaveRegistrationPopUpUc extends PopupPanel {

	private static LeaveRegistrationPopUpUcUiBinder uiBinder = GWT
			.create(LeaveRegistrationPopUpUcUiBinder.class);

	interface LeaveRegistrationPopUpUcUiBinder extends
			UiBinder<Widget, LeaveRegistrationPopUpUc> {
	}

	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblHeading, lblSubHeading;
	@UiField
	Button btnLeave, btnContinue;
	String accountType = "";
	String childDob = "";
	String parentEmailId = "";
	String childUsername = "";
    /**
     * This method is used to dispaly LeaveRegistrationPopUp
     * @param type
     * @param emailId
     * @param username
     * @param dob
     */
	public LeaveRegistrationPopUpUc(String type,String emailId,String username,String dob) {
		super(false);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		accountType = type;
		parentEmailId = emailId;
		childUsername = username;
		childDob = dob;
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
     * @description : This method is used to set the data in LeaveRegistrationPopUp
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
		lblTitle.setText(MessageProperties.GL0480
				+ MessageProperties.GL_SPL_QUESTION);
		lblHeading.setText(MessageProperties.GL0477);
		lblHeading.getElement().setAttribute("style", "margin-bottom:0px");
		lblSubHeading.setText(MessageProperties.GL0478);
		btnLeave.getElement().setId("btnLeave");
		btnContinue.getElement().setId("btnContinue");
		btnLeave.setText(MessageProperties.GL0480);
		btnContinue.setText(MessageProperties.GL0479);
		btnContinue.getElement().setAttribute("style", "margin-left: 20px");
		
	}
    /**
     * 
     * @function onClickLblCancel 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This method is used to close the popup.
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
     * @description : This button is used to close signup on click of leave button.
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
	@UiHandler("btnLeave")
	public void onClickButtonLeave(ClickEvent event) {
		MixpanelUtil.close_signUp();
		this.hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}
    /**
     * 
     * @function onClickBtnContinue 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This method is used to continue registration on Continue button click.
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
	@UiHandler("btnContinue")
	public void onClickBtnContinue(ClickEvent event) {
		MixpanelUtil.continue_registration();
		if(accountType=="parent")
		{
			
			Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
			params.put("type", "2");
			params.put("callback", "signup");
			AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );

		}
		if(accountType=="registerChild")
		{
			Map<String, String> params = new HashMap<String, String>();
			params.put("callback", "registerChild");
			params.put("type", "4");
			
			if (childDob != null) {
				params.put("dob", childDob);
			}
			if (childUsername != null) {
				params.put("userName", childUsername);
			}
			if(parentEmailId!=null){
				params.put("emailId",parentEmailId);
			}
			AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );
			
		}
		this.hide();
	}

}
