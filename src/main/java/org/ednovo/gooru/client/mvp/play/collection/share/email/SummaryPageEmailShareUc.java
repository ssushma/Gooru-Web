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
package org.ednovo.gooru.client.mvp.play.collection.share.email;


import org.ednovo.gooru.client.uc.PlayerBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SummaryPageEmailShareUc extends PopupPanel {

	@UiField Label fromValidation, toValidation, lblEmailFriend, lblFrom, lblTo, lblSendMeCopy, lblSubject, lblMessage, fromLbl, cpAttachmentContainer;
	
	@UiField CheckBox checkCopyEmail;
	
	@UiField Button btnSend, cancelLbl;
	
	@UiField TextBox toTxt, fromTxt, subTxt;

	@UiField RichTextArea msgTxa;

	private static boolean isCheckedValue;

	private static boolean isvalid;

	private String cfm = "no";
	
	private static final String AT_SYMBOL = "@";

	String GL0215 = "Please enter your Email.";
	String GL0216 = "Please specify at least one recipient.";
	String GL0217 = "Enter recipient's email";
	String GL0218 = "Enter your Email";
	String GL0222 = "Email your Collection Results";
	String GL0223 = "From";
	String GL_SPL_SEMICOLON = ":";
	String GL0224 = "To";
	String GL0225 = "Send me a copy of this message";
	String GL0226 = "Subject";
	String GL0227 = "Message";
	String GL0228 = "Send";
	String GL0142 = "Cancel";
	String GL_EMAIL_SUBJECT = "I've shared my Gooru collection summary with you";
	String GL0219 = "Hello [Enter your teacher or tutor's name] <div><br/></div><div>I am sharing my collection summary with you.<br/>(PDF attached)</div>" +
			"<div><br/></div><div>Thank you!</div><div>[Enter your full name]</div>";

	String restEndPoint = "";
	String session = "";
	String pdfUrl = "";
	
	private static SummaryPageEmailShareUcUiBinder uiBinder = GWT
			.create(SummaryPageEmailShareUcUiBinder.class);

	interface SummaryPageEmailShareUcUiBinder extends
			UiBinder<Widget, SummaryPageEmailShareUc> {
	}


	public SummaryPageEmailShareUc(String restEndPoint, String session, String fromEmailAddress, String teacherName, String studentName, String pdfUrl) {
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		String[] fileName = pdfUrl.split("/");
		cpAttachmentContainer.setText(fileName[fileName.length-1]);
		
		this.restEndPoint = restEndPoint;
		this.session = session;
		this.pdfUrl = pdfUrl;
		fromValidation.setText(GL0215);
		toValidation.setText(GL0216);
		lblEmailFriend.setText(GL0222);
		lblFrom.setText(GL0223 + GL_SPL_SEMICOLON);
		lblTo.setText(GL0224 + GL_SPL_SEMICOLON);
		lblSendMeCopy.setText(GL0225);
		lblSubject.setText(GL0226 + GL_SPL_SEMICOLON);
		lblMessage.setText(GL0227 + GL_SPL_SEMICOLON);
		btnSend.setText(GL0228);
		cancelLbl.setText(GL0142);
		
		fromValidation.setVisible(false);
		toValidation.setVisible(false);
		toTxt.getElement().setId("tbTo");
		subTxt.getElement().setId("tbSubject");
		subTxt.setText(GL_EMAIL_SUBJECT);
		fromTxt.getElement().setId("tbFrom");
		msgTxa.getElement().setId("taMessage");
		btnSend.getElement().setId("btnSend");
		if(fromEmailAddress==null || fromEmailAddress.isEmpty()) {
			fromLbl.setVisible(false);
			fromTxt.setVisible(true);
			fromTxt.getElement().setAttribute("placeholder",GL0218);
		} else {
			fromLbl.setText(fromEmailAddress);
			fromLbl.setVisible(true);
			fromTxt.setVisible(false);
		}
		toTxt.getElement().setAttribute("placeholder",GL0217);
		msgTxa.setHTML(GL0219);
		isCheckedValue = false;
		isvalid = true;
		this.setGlassStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setGlassPanelStyle());
		this.setGlassEnabled(true);
		this.center();

		msgTxa.addInitializeHandler(new InitializeHandler() {
			@Override
			public void onInitialize(InitializeEvent event) {
				    Document document = IFrameElement.as(msgTxa.getElement()).getContentDocument();
	                BodyElement body = document.getBody();
	                body.setAttribute("style", "font-family: Arial;font-size:12px;");
			}
		});
	}
	
	@UiHandler("cancelLbl")
	public void onCancelClickEvent(ClickEvent event) {
		closeEmailpanel();
	}

	private void closeEmailpanel() {
		this.hide();
	}
	
	@UiHandler("btnSend")
	public void onSendBtnClickEvent(ClickEvent event) {
		isvalid = true;
		if(fromTxt.isVisible()) {
			if (fromTxt.getText().equals("")) {
				fromValidation.setVisible(true);
				isvalid = false;
			}
			if ((fromTxt.getText() != null && !fromTxt.getText().isEmpty())
					&& !fromTxt.getText().contains(AT_SYMBOL)) {

				fromValidation.setText("Please enter valid email.");
				fromValidation.setVisible(true);
				isvalid = false;
			}
		}

		if (toTxt.getText().equals("")) {
			toValidation.setVisible(true);
			isvalid = false;
		}
		if ((toTxt.getText() != null && !toTxt.getText().isEmpty())
				&& !toTxt.getText().contains(AT_SYMBOL)) {

			toValidation.setText("Please enter valid email.");
			toValidation.setVisible(true);
			isvalid = false;
		}
		if (isvalid) {
			String fromEmail = "";
			if(fromTxt.isVisible()) {
				fromEmail = fromTxt.getText();
			} else {
				fromEmail = fromLbl.getText();
			}
//			playerRpcService.sendEmailWithPdf(restEndPoint, session, toTxt.getText(), fromEmail, cfm, subTxt.getText(), msgTxa.getHTML(), pdfUrl, cpAttachmentContainer.getText(), new AsyncCallback<String>() {
//				@Override
//				public void onSuccess(String response) {
//					if(response.equalsIgnoreCase("success")) {
//						closeEmailpanel();
//						ThankYouToolTip thankYouToolTip=new ThankYouToolTip();
//						thankYouToolTip.setTitleData("Email to Friend", toTxt.getText());
//						thankYouToolTip.setPopupPosition((Window.getClientWidth()-400)/2,(Window.getClientHeight()-165)/2+Window.getScrollTop());
//						thankYouToolTip.show();						
//					}
//				}
//				@Override
//				public void onFailure(Throwable arg0) {
//				}
//			});
		}
	}

	@UiHandler("fromTxt")
	public void onKeydownEvent(KeyDownEvent event) {
		fromValidation.setVisible(false);
	}

	@UiHandler("toTxt")
	public void onKeydownClickEvent(KeyDownEvent event) {
		toValidation.setVisible(false);
	}

	@UiHandler("checkCopyEmail")
	public void oncheckCopyEmailEvent(ClickEvent event) {

		if (checkCopyEmail.isChecked()) {
			cfm = "yes";
		} else {
			cfm = "no";
		}
	}
}
