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
package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.HomeCBundle;
import org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.social.SocialShareDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * @fileName : EmailShareUc.java
 *
 * @description : This file used to show popUp for share the data through email.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class EmailShareUc extends PopupPanel implements MessageProperties {

	private static EmailShareUcUiBinder uiBinder = GWT
			.create(EmailShareUcUiBinder.class);

	interface EmailShareUcUiBinder extends UiBinder<Widget, EmailShareUc> {
	}

	@UiField
	Label  cancelLbl, fromValidation, toValidation, checkCopyEmail, lblEmailFriend,lblFrom, lblTo,lblSendMeCopy,lblSubject,lblMessage;

	@UiField
	BlueButtonUc btnSend;

	@UiField
	TextBox toTxt, fromTxt, subTxt;

	@UiField
	RichTextArea msgTxa;

	/*
	 * @UiField CheckBox checkCopyEmail;
	 */

	SocialShareDo socialShareDo;

	private static boolean isCheckedValue;

	private static boolean isvalid;

	private SimpleAsyncCallback<Void> socialShareAsyncCallback = null;

	@Inject
	private ClasspageServiceAsync classpageServiceAsync;

	private String cfm;

	private String loggedEmailId;

	private static final String AT_SYMBOL = "@";

	/**
	 * Class constructor , create a new pop up
	 * @param socialDo, Object of SocialShareDo. 
	 */
	public EmailShareUc(SocialShareDo socialDo) {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		UcCBundle.INSTANCE.css().ensureInjected();
		HomeCBundle.INSTANCE.css().ensureInjected();
		this.socialShareDo = socialDo;
		setSocialShareAsyncCallback(new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
			}

		});
		this.getElement().getStyle().setZIndex(999999);
		this.setGlassStyleName(HomeCBundle.INSTANCE.css()
				.loginPopupGlassStyle());
		fromValidation.setText(MessageProperties.GL0215);
		toValidation.setText(MessageProperties.GL0216);
		lblEmailFriend.setText(MessageProperties.GL0222);
		lblFrom.setText(MessageProperties.GL0223 + MessageProperties.GL_SPL_SEMICOLON);
		lblTo.setText(MessageProperties.GL0224 + MessageProperties.GL_SPL_SEMICOLON);
		lblSendMeCopy.setText(MessageProperties.GL0225);
		lblSubject.setText(MessageProperties.GL0226 + MessageProperties.GL_SPL_SEMICOLON);
		lblMessage.setText(MessageProperties.GL0227 + MessageProperties.GL_SPL_SEMICOLON);
		btnSend.setText(MessageProperties.GL0228);
		cancelLbl.setText(MessageProperties.GL0142);

		fromValidation.setVisible(false);
		toValidation.setVisible(false);


		loggedEmailId=socialShareDo.getEmailId();
		cancelLbl.getElement().setId("lblCancel");
		toTxt.getElement().setId("tbTo");
		subTxt.getElement().setId("tbSubject");
		fromTxt.getElement().setId("tbFrom");
		msgTxa.getElement().setId("taMessage");
		btnSend.getElement().setId("btnSend");
		fromTxt.getElement().getStyle().setBorderWidth(0, Unit.PX);
		fromTxt.setText(loggedEmailId);
		fromTxt.setReadOnly(true);
		toTxt.getElement().setAttribute("placeholder",
				MessageProperties.GL0217);

		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.PROFILE_PAGE)){
			if(socialShareDo.getIsSearchShare()){
				//				subTxt.setText("Gooru -"+socialShareDo.getTitle());
				subTxt.setText(StringUtil.generateMessage(MessageProperties.GL0218, socialShareDo.getTitle()));
				//				msgTxa.setHTML(socialShareDo.getTitle() +"<div><br/></div>"+"<div>" +socialShareDo.getBitlylink() + "</div><div><br/></div>"+ "<div>"+"Sent using Gooru. Visit www.goorulearning.org for more great resources and collections. It's free!"+"</div>");
				msgTxa.setHTML(StringUtil.generateMessage(MessageProperties.GL0219, socialShareDo.getTitle(), socialShareDo.getBitlylink(), AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint()));
			}else{
				//				subTxt.setText("Check out "+socialShareDo.getTitle()+" Gooru profile and fantastic collections");
				subTxt.setText(StringUtil.generateMessage(MessageProperties.GL0220, socialShareDo.getTitle()));
				//				msgTxa.setHTML(socialShareDo.getTitle() +" is an active member of the Gooru community! Take a look and browse through all their great collections - " +socialShareDo.getBitlylink()
				//						+ "<div><br/></div>"+ "<div>"+"Gooru is a free search engine for learning used by thousands of teachers around the world to discover, organize and create teaching materials."+ "</div><div><br/></div>"+ "<div>"+"Experience Gooru today at http://goorulearning.org/"+"</div>");
				msgTxa.setHTML(StringUtil.generateMessage(MessageProperties.GL0221, socialShareDo.getTitle(), socialShareDo.getBitlylink(), AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint()));
			}
		}else{
			//			subTxt.setText("Gooru -"+socialShareDo.getTitle());
			subTxt.setText(StringUtil.generateMessage(MessageProperties.GL0218, socialShareDo.getTitle()));
			//			msgTxa.setHTML(socialShareDo.getTitle() +"<div><br/></div>"+"<div>" +socialShareDo.getBitlylink() + "</div><div><br/></div>"+ "<div>"+"Sent using Gooru. Visit www.goorulearning.org for more great resources and collections. It's free!"+"</div>");
			msgTxa.setHTML(StringUtil.generateMessage(MessageProperties.GL0219, socialShareDo.getTitle(), socialShareDo.getBitlylink(), AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint()));
		}

		isCheckedValue = false;
		isvalid = true;
		Window.enableScrolling(false);
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

	/**
	 * Hide {@link EmailShareUc} popup
	 * @param clickEvent instOLance of {@link ClickEvent}
	 */
	@UiHandler("cancelLbl")
	public void onCancelClickEvent(ClickEvent event) {
		this.hide();
		String placeToken = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(!(placeToken.equals(PlaceTokens.COLLECTION_PLAY)||placeToken.equals(PlaceTokens.RESOURCE_PLAY))) {
			Window.enableScrolling(true);
		}
	}

	/**
	 * Validates and send the data.
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("btnSend")
	public void onSendBtnClickEvent(ClickEvent event) {
		isvalid = true;
		if (fromTxt.getText().equals("")) {
			fromValidation.setVisible(true);
			isvalid = false;
		}
		if (toTxt.getText().equals("")) {
			toValidation.setVisible(true);
			isvalid = false;
		}
		if ((fromTxt.getText() != null && !fromTxt.getText().isEmpty())
				&& !fromTxt.getText().contains(AT_SYMBOL)) {

			fromValidation.setText("Please enter valid email.");
			fromValidation.setVisible(true);
			isvalid = false;
		}
		if(fromTxt.getText() != null){
			String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			Boolean from = fromTxt.getText().matches(EMAIL_REGEX);
			if(from)
			{
				isvalid = true;
			}
			else
			{
				toValidation.setText("Please enter valid email.");
				toValidation.setVisible(true);
				isvalid = false;
			}
		}
		if ((toTxt.getText() != null && !toTxt.getText().isEmpty())
				&& !toTxt.getText().contains(AT_SYMBOL)) {
			toValidation.setText("Please enter valid email.");
			toValidation.setVisible(true);
			isvalid = false;

		}
		if(toTxt.getText() != null){
			String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			Boolean to = toTxt.getText().matches(EMAIL_REGEX);
			if(to)
			{
				isvalid = true;
			}
			else
			{
				toValidation.setText("Please enter valid email.");
				toValidation.setVisible(true);
				isvalid = false;
			}
		}
		if (isvalid) {
			AppClientFactory
			.getInjector()
			.getClasspageService()
			.socialShareEmail(fromTxt.getText(), toTxt.getText(), cfm,
					subTxt.getText(), msgTxa.getHTML(),
					new SimpleAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					hide();
					String placeToken = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
					if(!(placeToken.equals(PlaceTokens.COLLECTION_PLAY)||placeToken.equals(PlaceTokens.RESOURCE_PLAY))) {
						Window.enableScrolling(true);
					}
					new SentEmailSuccessVc(toTxt.getText());
				}

			});

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

		if (isCheckedValue) {
			checkCopyEmail.setStyleName(UcCBundle.INSTANCE.css()
					.classPageEmailCheckBoxBgHoverSprite());
			isCheckedValue = false;
			cfm = "no";
		} else {
			checkCopyEmail.setStyleName(UcCBundle.INSTANCE.css()
					.classPageEmailCheckBoxBgHover());
			isCheckedValue = true;
			cfm = "yes";
		}
		/*
		 * if(cfm.equalsIgnoreCase("yes")){
		 * toTxt.setText(toTxt.getText()+","+fromTxt.getText()); }else{
		 * 
		 * }
		 */

	}

	/*public ClasspageServiceAsync getclasspageServiceAsync() {
		return classpageServiceAsync;
	}

	public void setclasspageServiceAsync(
			ClasspageServiceAsync classpageServiceAsync) {
		this.classpageServiceAsync = classpageServiceAsync;
	}*/

	public SimpleAsyncCallback<Void> getSocialShareAsyncCallback() {
		return socialShareAsyncCallback;
	}

	public void setSocialShareAsyncCallback(
			SimpleAsyncCallback<Void> socialShareAsyncCallback) {
		this.socialShareAsyncCallback = socialShareAsyncCallback;
	}

}
