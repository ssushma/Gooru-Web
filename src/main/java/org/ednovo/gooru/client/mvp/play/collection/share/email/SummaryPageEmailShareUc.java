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


import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.ThankYouToolTip;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SummaryPageEmailShareUc extends PopupPanel implements MessageProperties{

	@UiField Label fromValidation, toValidation, lblEmailFriend, lblFrom, lblTo, lblSendMeCopy, lblSubject, lblMessage, fromLbl, cpAttachmentContainer,mandatoryErrorLbl,mandatoryErrorRichTextArea;
	
	@UiField CheckBox checkCopyEmail;
	
	@UiField Button btnSend, cancelLbl;
	
	@UiField TextBox toTxt, fromTxt, subTxt;

	@UiField RichTextArea msgTxa;

	private static boolean isCheckedValue;

	private static boolean isvalid;

	private String cfm = "no";
	
	private static final String AT_SYMBOL = "@";

	String restEndPoint = "";
	String session = "";
	String pdfUrl = "";
	boolean isHavingBadWordsInTextbox=false,isHavingBadWordsInRichText=false;
	private static SummaryPageEmailShareUcUiBinder uiBinder = GWT
			.create(SummaryPageEmailShareUcUiBinder.class);

	interface SummaryPageEmailShareUcUiBinder extends
			UiBinder<Widget, SummaryPageEmailShareUc> {
	}


	public SummaryPageEmailShareUc( String fromEmailAddress,String pdfUrl) {
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		String[] fileName = pdfUrl.split("/");
		cpAttachmentContainer.setText(fileName[fileName.length-1]); 
		this.pdfUrl = pdfUrl;
		fromValidation.setText(GL0215);
		toValidation.setText(GL0216);
		lblEmailFriend.setText(GL1449);
		lblFrom.setText(GL0223 + GL_SPL_SEMICOLON);
		lblTo.setText(GL0224 + GL_SPL_SEMICOLON);
		lblSendMeCopy.setText(GL0225);
		lblSubject.setText(GL0226 + GL_SPL_SEMICOLON);
		lblMessage.setText(GL0227 + GL_SPL_SEMICOLON);
		btnSend.setText(GL0228);
		cancelLbl.setText(GL0142);
		
		mandatoryErrorLbl.setVisible(false);
		mandatoryErrorRichTextArea.setVisible(false);
		
		fromValidation.setVisible(false);
		toValidation.setVisible(false);
		toTxt.getElement().setId("tbTo");
		subTxt.getElement().setId("tbSubject");
		subTxt.setText(GL1443);
		fromTxt.getElement().setId("tbFrom");
		msgTxa.getElement().setId("taMessage");
		btnSend.getElement().setId("btnSend");
		if(fromEmailAddress==null || fromEmailAddress.isEmpty()) {
			fromLbl.setVisible(false);
			fromTxt.setVisible(true);
			fromTxt.getElement().setAttribute("placeholder",GL1442);
		} else {
			fromLbl.setText(fromEmailAddress);
			fromLbl.setVisible(true);
			fromTxt.setVisible(false);
		}
		toTxt.getElement().setAttribute("placeholder",GL0217);
		msgTxa.setHTML(GL1444);
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
		subTxt.addBlurHandler(new CheckProfanityInOnBlur(subTxt,null, mandatoryErrorLbl));
		msgTxa.addBlurHandler(new CheckProfanityInOnBlur(null,msgTxa, mandatoryErrorRichTextArea));
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

				fromValidation.setText(GL1027);
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

			toValidation.setText(GL1027);
			toValidation.setVisible(true);
			isvalid = false;
		}
		if(isvalid){
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", subTxt.getValue());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
						isHavingBadWordsInTextbox = value;
						if(value){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(subTxt, mandatoryErrorLbl,value);
						}else{
							parms.put("text", msgTxa.getText());
							AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new SimpleAsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									isHavingBadWordsInRichText=result;
									if(result){
										SetStyleForProfanity.SetStyleForProfanityForRichTextArea(msgTxa, mandatoryErrorRichTextArea, result);
									}else{
										if (!isHavingBadWordsInRichText && !isHavingBadWordsInTextbox) {
											String fromEmail = "";
											if(fromTxt.isVisible()) {
												fromEmail = fromTxt.getText();
											} else {
												fromEmail = fromLbl.getText();
											}
											AppClientFactory.getInjector().getPlayerAppService().sendEmailWithPdf(toTxt.getText(),fromEmail,cfm,subTxt.getText(), msgTxa.getHTML(), pdfUrl,cpAttachmentContainer.getText(),new SimpleAsyncCallback<String>(){
												@Override
												public void onSuccess(String result) {
													if(result.equalsIgnoreCase("success")) {
														closeEmailpanel();
														ThankYouToolTip thankYouToolTip=new ThankYouToolTip();
														thankYouToolTip.setTitleData(GL0222, toTxt.getText());
														thankYouToolTip.setPopupPosition((Window.getClientWidth()-400)/2,(Window.getClientHeight()-165)/2+Window.getScrollTop());
														thankYouToolTip.show();	
													}
												}
											});
										}
									}
								}
							});
						}
				}
			});
		}
		/*if (isvalid  && !isHavingBadWordsInRichText && !isHavingBadWordsInTextbox) {
			String fromEmail = "";
			if(fromTxt.isVisible()) {
				fromEmail = fromTxt.getText();
			} else {
				fromEmail = fromLbl.getText();
			}
			
			AppClientFactory.getInjector().getPlayerAppService().sendEmailWithPdf(toTxt.getText(),fromEmail,cfm,subTxt.getText(), msgTxa.getHTML(), pdfUrl,cpAttachmentContainer.getText(),new SimpleAsyncCallback<String>(){

				@Override
				public void onSuccess(String result) {

					if(result.equalsIgnoreCase("success")) {

						closeEmailpanel();

						ThankYouToolTip thankYouToolTip=new ThankYouToolTip();

						thankYouToolTip.setTitleData("Email to Friend", toTxt.getText());

						thankYouToolTip.setPopupPosition((Window.getClientWidth()-400)/2,(Window.getClientHeight()-165)/2+Window.getScrollTop());

						thankYouToolTip.show();	

					}

				}



			});
			
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
		}*/
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
	public class CheckProfanityInOnBlur implements BlurHandler{
		private TextBox textBox;
		private Label label;
		private RichTextArea richTextArea;
		public CheckProfanityInOnBlur(TextBox textBox,RichTextArea richTextArea,Label label){
			this.textBox=textBox;
			this.label=label;
			this.richTextArea=richTextArea;
		}
		@Override
		public void onBlur(BlurEvent event) {
			Map<String, String> parms = new HashMap<String, String>();
			if(textBox!=null){
				parms.put("text", textBox.getValue());
			}else{
				parms.put("text", richTextArea.getText());
			}
			btnSend.setEnabled(false);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					btnSend.setEnabled(true);
					if(textBox!=null){
						isHavingBadWordsInTextbox = value;
						SetStyleForProfanity.SetStyleForProfanityForTextBox(textBox, label, value);
					}else{
						isHavingBadWordsInRichText=value;
						SetStyleForProfanity.SetStyleForProfanityForRichTextArea(richTextArea, label, value);
					}
					
				}
			});
		}
	}
}