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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

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

public class SummaryPageEmailShareUc extends PopupPanel{

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
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);


	public SummaryPageEmailShareUc( String fromEmailAddress,String pdfUrl) {
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		String[] fileName = pdfUrl.split("/");
		cpAttachmentContainer.setText(fileName[fileName.length-1]); 
		cpAttachmentContainer.getElement().setAttribute("alt",fileName[fileName.length-1]);
		cpAttachmentContainer.getElement().setAttribute("title",fileName[fileName.length-1]);
		this.pdfUrl = pdfUrl;
		fromValidation.setText(i18n.GL0215());
		fromValidation.getElement().setId("lblFromValidation");
		fromValidation.getElement().setAttribute("alt",i18n.GL0215());
		fromValidation.getElement().setAttribute("title",i18n.GL0215());
		
		toValidation.setText(i18n.GL0216());
		toValidation.getElement().setId("lblToValidation");
		toValidation.getElement().setAttribute("alt",i18n.GL0216());
		toValidation.getElement().setAttribute("title",i18n.GL0216());
		
		lblEmailFriend.setText(i18n.GL1449());
		lblEmailFriend.getElement().setId("lblEmailFriend");
		lblEmailFriend.getElement().setAttribute("alt",i18n.GL1449());
		lblEmailFriend.getElement().setAttribute("title",i18n.GL1449());
		
		lblFrom.setText(i18n.GL0223() + i18n.GL_SPL_SEMICOLON()+" ");
		lblFrom.getElement().setId("lblFrom");
		lblFrom.getElement().setAttribute("alt",i18n.GL0223());
		lblFrom.getElement().setAttribute("title",i18n.GL0223());
		
		lblTo.setText(i18n.GL0224() + i18n.GL_SPL_SEMICOLON()+" ");
		lblTo.getElement().setId("lblTo");
		lblTo.getElement().setAttribute("alt",i18n.GL0224());
		lblTo.getElement().setAttribute("title",i18n.GL0224());
		
		lblSendMeCopy.setText(i18n.GL0225());
		lblSendMeCopy.getElement().setId("lblSendMeCopy");
		lblSendMeCopy.getElement().setAttribute("alt",i18n.GL0225());
		lblSendMeCopy.getElement().setAttribute("title",i18n.GL0225());
		
		lblSubject.setText(i18n.GL0226() + i18n.GL_SPL_SEMICOLON()+" ");
		lblSubject.getElement().setId("lblSubject");
		lblSubject.getElement().setAttribute("alt",i18n.GL0226());
		lblSubject.getElement().setAttribute("title",i18n.GL0226());
		
		lblMessage.setText(i18n.GL0227() + i18n.GL_SPL_SEMICOLON()+" ");
		lblMessage.getElement().setId("lblSubject");
		lblMessage.getElement().setAttribute("alt",i18n.GL0227());
		lblMessage.getElement().setAttribute("title",i18n.GL0227());
		
		btnSend.setText(i18n.GL0228());
		btnSend.getElement().setId("btnSend");
		btnSend.getElement().setAttribute("alt",i18n.GL0227());
		btnSend.getElement().setAttribute("title",i18n.GL0227());
		
		cancelLbl.setText(i18n.GL0142());
		cancelLbl.getElement().setId("btnCancelLbl");
		cancelLbl.getElement().setAttribute("alt",i18n.GL0142());
		cancelLbl.getElement().setAttribute("title",i18n.GL0142());
		
		mandatoryErrorLbl.setVisible(false);
		mandatoryErrorRichTextArea.setVisible(false);
		
		fromValidation.setVisible(false);
		toValidation.setVisible(false);
		toTxt.getElement().setId("tbTo");
		subTxt.getElement().setId("tbSubject");
		StringUtil.setAttributes(subTxt);
		subTxt.setText(i18n.GL1443());
		subTxt.getElement().setAttribute("alt",i18n.GL1443());
		subTxt.getElement().setAttribute("title",i18n.GL1443());
		StringUtil.setAttributes(subTxt);
		
		fromTxt.getElement().setId("tbFrom");
		msgTxa.getElement().setId("taMessage");
		StringUtil.setAttributes(msgTxa);
		fromLbl.getElement().setId("lblFromLbl");
		checkCopyEmail.getElement().setId("chkCheckCopyEmail");
		mandatoryErrorLbl.getElement().setId("errlblMandatoryErrorLbl");
		mandatoryErrorRichTextArea.getElement().setId("errlblMandatoryErrorRichTextArea");
		
		
		
		if(fromEmailAddress==null || fromEmailAddress.isEmpty()) {
			fromLbl.setVisible(false);
			fromTxt.setVisible(true);
			fromTxt.getElement().setAttribute("placeholder",i18n.GL1442());
		} else {
			fromLbl.setText(fromEmailAddress);
			fromLbl.getElement().setAttribute("alt",fromEmailAddress);
			fromLbl.getElement().setAttribute("title",fromEmailAddress);
			fromLbl.setVisible(true);
			fromTxt.setVisible(false);
		}
		toTxt.getElement().setAttribute("placeholder",i18n.GL0217());
		msgTxa.setHTML(i18n.GL1444());
		msgTxa.getElement().setAttribute("alt",i18n.GL1444());
		msgTxa.getElement().setAttribute("title",i18n.GL1444());
		
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

				fromValidation.setText(i18n.GL1027());
				fromValidation.getElement().setAttribute("alt",i18n.GL1027());
				fromValidation.getElement().setAttribute("title",i18n.GL1027());
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

			toValidation.setText(i18n.GL1027());
			toValidation.getElement().setAttribute("alt",i18n.GL1027());
			toValidation.getElement().setAttribute("title",i18n.GL1027());
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
														thankYouToolTip.setTitleData(i18n.GL0222(), toTxt.getText());
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