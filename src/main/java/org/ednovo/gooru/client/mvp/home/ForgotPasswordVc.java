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

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertForgetContentUc;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ForgotPasswordVc.java
 *
 * @description : This file will Send a mail to user to update their password through forgot password link if user exists show new pop up
 * that tells the password reset mail has been sent else through validation error
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
public class ForgotPasswordVc extends PopupPanel implements MessageProperties{

	private static ForgotPasswordVcUiBinder uiBinder = GWT
			.create(ForgotPasswordVcUiBinder.class);
	
	@UiField
	Anchor supportLink;

	@UiField
	Button sendMailBtnUc;
	
	@UiField
	TextBox forgotEmailIdTxtBox;
	@UiField HTMLEventPanel cancelButton;
	
	@UiField(provided = true)
	LoginPopUpCBundle res;
	
	@UiField Label lblLoginHeading,lblDisplayTextMessage,lblTextMessageInfomation,errorMessage;


	//private AppPopUp appPopUp;

	interface ForgotPasswordVcUiBinder extends
			UiBinder<Widget, ForgotPasswordVc> {
	}

	/**
	 * Class constructor , to create forgot password popup
	 */
	public ForgotPasswordVc() {
		super(false);
		this.res = LoginPopUpCBundle.INSTANCE;
        res.css().ensureInjected();
        this.setGlassStyleName(LoginPopUpCBundle.INSTANCE.css().loginPopupGlassStyle());
        this.setGlassEnabled(true);
       	this.getElement().getStyle().setZIndex(99999);
       	setWidget(uiBinder.createAndBindUi(this));
  		forgotEmailIdTxtBox.getElement().setId("tbUsername");
		sendMailBtnUc.getElement().setId("btnSubmit");
		supportLink.getElement().setId("lnkSupport");
		this.center();
		this.setSize("502px", "390px");
		lblLoginHeading.setHeight("16px");
		lblLoginHeading.setText(MessageProperties.GL0063);
		lblDisplayTextMessage.setText(MessageProperties.GL0436);
		lblTextMessageInfomation.getElement().setAttribute("style", "font-size: 13px !important");
		lblTextMessageInfomation.setText(MessageProperties.GL0435);
		forgotEmailIdTxtBox.setWidth("341px");
		forgotEmailIdTxtBox.getElement().setAttribute("placeholder", MessageProperties.GL0434);
		forgotEmailIdTxtBox.setFocus(true);
		errorMessage.setVisible(false);
	    
		
	}
	/**
	 * 
	 * @function onCloseClick 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :UIHandler for cancelButton.
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
	@UiHandler("cancelButton")
	public void onCloseClick(ClickEvent clickEvent)
	{
		this.hide();	
		  
        if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.COLLECTION_PLAY) ||
				AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.RESOURCE_PLAY)){
		}else{
			//appPopUp.hide();
			Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
	}
	
		
	/**
	 * @return {@link BlueButtonUc} uiField
	 *//*
	protected Button getConfirmationButton() {
		return sendMailBtnUc; 
	}
	
	protected boolean hasValidateData() { 
		return true;
	}*/
	
	/**
	 * @return emailId which is to be reset password
	 */
	protected String getforgotEmailId() {
		return forgotEmailIdTxtBox.getText(); 
	}
	
	
	/**
	 * Send a mail to user to update their password through forgot password link if user exists show new pop up
	 *  that tells the password reset mail has been sent else through validation error
	 * 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("sendMailBtnUc")
	public void forgotPassword(ClickEvent clickEvent){
		if (forgotEmailIdTxtBox.getText().trim().length() > 0) {
			AppClientFactory.getInjector().getUserService().forgotPassword(this.getforgotEmailId(), new SimpleAsyncCallback<Map<String, Object>>() {

				@Override
				public void onSuccess(Map<String, Object> result) {
					String error=(String) result.get("error");
                    if (result != null && result.containsKey("error") && result.get("error").toString().length() > 0) {
						if(error.equalsIgnoreCase("Looks like this email is tied with Google!")){
							 errorMessage.setVisible(true);
							 hide();
							 AlertForgetContentUc alertForgetContentUc = new AlertForgetContentUc();	
							 alertForgetContentUc.show();
							 alertForgetContentUc.center();
							 alertForgetContentUc.getElement().getStyle().setZIndex(999999);
						}else{
							errorMessage.setText(MessageProperties.GL0438);
							errorMessage.setVisible(true);
							//new AlertContentUc("Oops!", (String) result.get("error"));
						}
						return;
					}
					if (result != null && result.containsKey("gooruUid") && result.get("gooruUid").toString().length() > 0) {
						//appPopUp.hide();
						hide();
						ForgotPwdSuccessVc forgotPwdSuccessVc=new ForgotPwdSuccessVc();
						forgotPwdSuccessVc.setGlassEnabled(true);
						forgotPwdSuccessVc.show();
						forgotPwdSuccessVc.center();
						
					}
				}

			});
		}else
		{
			
			errorMessage.setVisible(true);
			errorMessage.setText(MessageProperties.GL0439);
		//new AlertContentUc(GL0064, PROVIDE_EMAIL_OR_USERNAME);
		}
		}
	
}
