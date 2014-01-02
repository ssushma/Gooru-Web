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
package org.ednovo.gooru.client.mvp.authentication.afterthirteen;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.authentication.uc.SignUpDontWorryView;
import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.model.user.V2UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
/**
 * 
 * @fileName : SignUpTurnsAfterThirteenView.java
 *
 * @description : This is the view for sign up popup after 13 years. 
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SignUpTurnsAfterThirteenView extends
PopupViewWithUiHandlers<SignUpAfterThirteenUiHandler> implements
IsAfterThirteen {

	private static SignUpTurnsAfterThirteenUiBinder uiBinder = GWT
			.create(SignUpTurnsAfterThirteenUiBinder.class);

	interface SignUpTurnsAfterThirteenUiBinder extends
			UiBinder<Widget, SignUpTurnsAfterThirteenView> {
	}

	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblStuDes, lblQuestionMark;
	@UiField
	InlineLabel lblStuDesDetails, lblStuDesDetails2;
	@UiField
	TextBoxWithPlaceholder txtEmailId;
	@UiField
	ErrorLabelUc emailValidUc;
	@UiField
	Button btnEnterLater, btnSubmit;
	@UiField
	Label lblfeaturesTitle, lblfeaturesTitleDes1, lblfeaturesTitleDes2,
			lblfeaturesTitleDes3,lblUpdating;
	@UiField
	HTMLPanel tooltipContent;

	String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private static final String GOORU_UID = "gooruUid";

	private static final String ACCOUNT_TYPE = "accountType";
	boolean isValidEmailId = true;
	boolean isValid = true;
	private AppPopUp appPopUp;
	/**
	 * Parameterized constructor for injecting the css and other resources.
	 * @param eventBus
	 */
	@Inject
	public SignUpTurnsAfterThirteenView(EventBus eventBus) {
		super(eventBus);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		
		
	}
	/**
	 * This method is used to display the ppopup
	 */
	@Override
	public void displayView() {
		appPopUp = new AppPopUp("NoHeader");
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		appPopUp.setStyleName(RegisterCBundle.INSTANCE.css()
				.registerPopupStyle());

		appPopUp.setGlassEnabled(true);
		appPopUp.setAutoHideOnHistoryEventsEnabled(false);

		appPopUp.getElement().getStyle().setZIndex(99);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		appPopUp.getElement().getStyle().setBackgroundColor("transparent");
		setUiAndIds();
		appPopUp.center();
	}
	/**
	 * 
	 * @function setUiAndIds 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This will set the images and ID's for the fields.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setUiAndIds() {
		lblTitle.setText(MessageProperties.GL0481
				+ MessageProperties.GL_SPL_EXCLAMATION);
		lblStuDes.setText(MessageProperties.GL0483
				+ MessageProperties.GL_SPL_EXCLAMATION);
		lblStuDesDetails.setText(MessageProperties.GL0484);
		lblStuDesDetails2.setText(MessageProperties.GL0485);
		lblQuestionMark.setText(MessageProperties.GL_SPL_QUESTION);
		emailValidUc.setVisible(false);
		txtEmailId.setPlaceholder(MessageProperties.GL0426);
		btnEnterLater.getElement().setId("btnEnterLater");
		btnSubmit.getElement().setId("btnSubmit");
		btnEnterLater.setText(MessageProperties.GL0487);
		btnSubmit.setText(MessageProperties.GL0486);
		lblfeaturesTitle.setText(MessageProperties.GL0488
				+ MessageProperties.GL_SPL_QUESTION);
		lblfeaturesTitleDes1.setText(MessageProperties.GL0489);
		lblfeaturesTitleDes2.setText(MessageProperties.GL0490);
		lblfeaturesTitleDes3.setText(MessageProperties.GL0491);
		tooltipContent.getElement().setAttribute("style", "width:193px");
		btnSubmit.getElement().setAttribute("style", "margin-left: 10px");
		txtEmailId.addBlurHandler(new OnBlurHandler());
		txtEmailId.addKeyUpHandler(new OnKeyUpHandler());
		lblUpdating.setVisible(false);
		btnSubmit.getElement().addClassName("disabled");
		btnSubmit.setEnabled(false);
		
	}
	/**
	 * @function onClickLblCancel 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event of cancel.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblCancel")
	public void onClickLblCancel(ClickEvent event) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
	}
	/**
	 * @function sendConfirmationMail 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to send the confirmation mail to the user.
	 * 
	 * @parm(s) : @param params
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	
	private void sendConfirmationMail(Map<String, String> params) {

		AppClientFactory
				.getInjector()
				.getUserService()
				.resendConfirmationMail(params,
						new SimpleAsyncCallback<Object>() {
							@Override
							public void onSuccess(Object result) {
								
							}
						});
	}
	/**
	 * @function onClickbtnEnterLater 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :It will hanlde the click event on the enter button.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("btnEnterLater")
	public void onClickbtnEnterLater(ClickEvent event) {
		this.hide();
		SignUpDontWorryView signUpDontWorryView=new SignUpDontWorryView();
		signUpDontWorryView.show();

	}
	/**
	 * @fileName : SignUpTurnsAfterThirteenView.java
	 *
	 * @description : This inner class is used to handle the Blur event. 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnBlurHandler implements BlurHandler {

		@Override
		public void onBlur(BlurEvent event) {
			if (event.getSource() == txtEmailId && txtEmailId.getText() != null
					&& !txtEmailId.getText().equalsIgnoreCase("")) {
				boolean isValidFrom = txtEmailId.getText().matches(EMAIL_REGEX);
				if (isValidFrom) {
					checkUserAvailability(
							txtEmailId.getText(), "byEmailid");
					emailValidUc.setVisible(false);
					txtEmailId.removeStyleName(res.css().errorMsgDisplay());
				} else {
					btnSubmit.getElement().addClassName("disabled");
					btnSubmit.setEnabled(false);
					txtEmailId.addStyleName(res.css().errorMsgDisplay());
					emailValidUc.addStyleName(res.css().errorLbl());
					emailValidUc.setText(MessageProperties.GL0464);
					emailValidUc.setVisible(true);
				}
			}

		}
	}
	/**
	 * Checks the availability of user name, entered by User.
	 * 
	 * @param userName
	 * @param type
	 * 
	 */
	public boolean checkUserAvailability(String userName, final String type) {

		AppClientFactory.getInjector().getUserService()
				.getEmailId(userName, type, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo result) {
						isValidEmailId = result.isAvailability();
						if (isValidEmailId) {
							btnSubmit.getElement().addClassName("disabled");
							btnSubmit.setEnabled(false);
							txtEmailId.addStyleName(res.css()
									.errorMsgDisplay());
							emailValidUc.addStyleName(res.css().errorLbl());
							emailValidUc.setText(MessageProperties.GL0447);
							emailValidUc.setVisible(true);
							isValid = false;
						}else 
						{
							btnSubmit.setEnabled(true);
							btnSubmit.getElement().removeClassName("disabled");
							emailValidUc.removeStyleName(res.css().errorLbl());
							txtEmailId.removeStyleName(res.css()
									.errorMsgDisplay());
							emailValidUc.setVisible(false);
							isValid = true;
						}
						
					}
				});
		
		return isValid;
	}
	/**
	 * @fileName : SignUpTurnsAfterThirteenView.java
	 *
	 * @description : This inner class is used to hanlde the key up hanlder.
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class OnKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
		 if (event.getSource() == txtEmailId) {
			 txtEmailId.removeStyleName(res.css().errorMsgDisplay());
			emailValidUc.setVisible(false);
		 }
		}
	}
	/**
	 * @function validateUserInput 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to validated the user input.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public boolean validateUserInput(){
		String emilId = txtEmailId.getText().trim();
		if (emilId.equalsIgnoreCase("") || emilId == null) {
			txtEmailId.addStyleName(res.css().errorMsgDisplay());
			isValid = false;
			btnSubmit.getElement().addClassName("disabled");
			btnSubmit.setEnabled(false);
		
			
		} 
		return isValid;
	}
	/**
	 * @function onClickbtnSubmit 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : It will handle the click event on the Submit button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("btnSubmit")
	public void onClickbtnSubmit(ClickEvent event) {
		if(validateUserInput() && !isValidEmailId)
		{
		MixpanelUtil.Registration_turns13_submit_email();
		btnSubmit.setVisible(false);
		btnEnterLater.setVisible(false);
		lblUpdating.setVisible(true);
		AppClientFactory.getInjector().getUserService().updateV2ProfileDo(txtEmailId.getText(), "nonParent", "", "", "","", new AsyncCallback<V2UserDo>() {
			
			@Override
			public void onSuccess(V2UserDo result) {
				hide();
				AppClientFactory.setLoggedInUser(result.getUser());
				AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(false));
				
				lblUpdating.setVisible(false);
				Map<String, String> map = StringUtil.splitQuery(Window.Location
						.getHref());
				map.put("callback", "profileUpdate");
				AppClientFactory.getPlaceManager().revealPlace(
						AppClientFactory.getCurrentPlaceToken(), map);
				
				Map<String, String> params = new HashMap<String, String>();
				params.put(GOORU_UID, AppClientFactory.getGooruUid());
				params.put(ACCOUNT_TYPE, "nonParent");
				sendConfirmationMail(params);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		
		}
	}
	/**
	 * Which is responsible for returning the widget corresponding to that view
	 */
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void onLoad() {
		
	}

	@Override
	public void onUnload() {
		
	}

}
