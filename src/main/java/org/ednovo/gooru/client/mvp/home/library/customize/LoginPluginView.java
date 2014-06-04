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
package org.ednovo.gooru.client.mvp.home.library.customize;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.ForgotPasswordVc;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInCollectionPlayEvent;
import org.ednovo.gooru.client.mvp.home.library.assign.AssignPopUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.DataLogEvents;
import org.ednovo.gooru.shared.util.GwtUUIDGenerator;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * 
 * @fileName : CollectionAssignViewTab.java
 * 
 * @description : This class is used to set the Editing collection to Assignment
 *              under Classpages.
 * 
 * @version : 1.0
 * 
 * @date: Jul 30, 2013
 * 
 * 
 * @Reviewer:
 */
public abstract class LoginPluginView extends ChildView<LoginPluginPresenter> implements
		IsLoginPlugin, MessageProperties {

	@UiField(provided = true)
	AssignPopUpCBundle res;

	@UiField
	TextBoxWithPlaceholder loginTxtBox;

	@UiField
	TextBoxWithPlaceholder passwordTxtBox;

	@UiField
	Button loginButton,gmailButton;

	@UiField
	Anchor forgotPwd, ancSignUp;

	@UiField
	Label lblPleaseWait, collectionDescription,donotHaveAcount,lblOr;
	
	@UiField HTMLPanel hangOnText,signUpPanel;

	@Inject
	private ResourceServiceAsync resourceService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;

	CollectionDo collectionObject = new CollectionDo();
	String collectionTitle="";

	private static final String OOPS =GL0061;
	private static final String LOGIN_ERROR =GL0347;
	private static final String LOGIN_COOKIE_DISABLE_MESSAGE =GL0348;

	private static LoginPluginUiBinder uiBinder = GWT
			.create(LoginPluginUiBinder.class);

	interface LoginPluginUiBinder extends UiBinder<Widget, LoginPluginView> {
	}

	/**
	 * Class constructor
	 */
	public LoginPluginView(CollectionDo collectionObject,String collectionTitle) {

		res = AssignPopUpCBundle.INSTANCE;
		this.collectionObject = collectionObject;
		this.collectionTitle = collectionTitle;
		AssignPopUpCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		setLabelsAndIds();
		setHandlers();

	}

	/**
	 * 
	 * @function setLabelsAndIds
	 * 
	 * @created_date : Jul 30, 2013
	 * 
	 * @description To set the default values for labels, button and id for
	 *              button.
	 * 
	 * @parm(s) : NONE
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 * 
	 * 
	 * 
	 */
	public void setLabelsAndIds() {
		hangOnText.getElement().setInnerText(GL0740);
		signUpPanel.getElement().setAttribute("style", "display: inline-block;");
		donotHaveAcount.setText(GL0634);
		donotHaveAcount.getElement().setAttribute("style", "float: left;");
		ancSignUp.getElement().setAttribute("style", "float: left;padding: 0;margin-left: 5px;");
		ancSignUp.setText(GL0207);
		collectionDescription.setText(GL0476);
		forgotPwd.getElement().setId("lnkForgotPwd");
		loginTxtBox.setPlaceholder(GL0202);
		loginTxtBox.getElement().setAttribute("placeholder",GL0202);
		loginTxtBox.setFocus(true);
		passwordTxtBox.setPlaceholder(GL0204);
		forgotPwd.setText(GL0205);
		loginButton.setText(GL0187);
		lblPleaseWait.setText(GL0242);
		loginButton.setText(GL1185);
		loginTxtBox.getElement().setId("tbLoginUsername");
		passwordTxtBox.getElement().setId("tbLoginPassword");
		loginButton.getElement().setId("btnLogin");
		gmailButton.setText(GL0203);
		lblOr.setText(GL0209);
		gmailButton.getElement().setId("customizeGmailBtn");
		lblPleaseWait.setVisible(false);

	}

	/**
	 * Added click handler to perform Login operation by taking entered user
	 * name and password from the user.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */

	@UiHandler("loginButton")
	public void onLoginClicked(ClickEvent clickEvent) {

		if (isCookieEnabled()) {
			

			String username = loginTxtBox.getText().trim();
			String password = passwordTxtBox.getText().trim();

			JSONObject login = new JSONObject();
			login.put("username", new JSONString(username));
			login.put("password", new JSONString(password));

			if (username.length() > 1 && password.length() > 1) {

				loginButton.setVisible(false);
				lblPleaseWait.setVisible(true);

				AppClientFactory
						.getInjector()
						.getAppService()
						.v2Signin(login.toString(),
								new SimpleAsyncCallback<UserDo>() {
									@Override
									public void onSuccess(UserDo result) {
										lblPleaseWait.setText(GL0505);
										AppClientFactory
												.setLoggedInUser(result);
										AppClientFactory
												.fireEvent(new SetHeaderEvent(
														result));
										AppClientFactory
												.fireEvent(new SetUserDetailsInCollectionPlayEvent(
														result.getToken(),
														result.getGooruUId()));
										/*AppClientFactory
												.getInjector()
												.getResourceService()
												.copyCollection(
														collectionObject,
														"true",
														null,
														getSaveCollectionAsyncCallback());*/
										
										showSuccessMsgfromChild(collectionObject.getGooruOid(),collectionTitle);
										MixpanelUtil.mixpanelEvent("Login_FromCustomize_Pop-up");
									}

									@Override
									public void onFailure(Throwable caught) {
										loginButton.setVisible(true);
										lblPleaseWait.setVisible(false);
										new AlertContentUc(OOPS, LOGIN_ERROR);
									}
								});
			} else {
				loginButton.setVisible(true);
				lblPleaseWait.setVisible(false);
				new AlertContentUc(OOPS, LOGIN_ERROR);
			}
		} else {
			loginButton.setVisible(true);
			lblPleaseWait.setVisible(false);
			new AlertMessageUc(GL0738, new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
		}
		
		
	}

	private void setHandlers() {

		this.setSize("515px", "547px");
		loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
		passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
	}

	/**
	 * creating inner class implementing KeyUpHandler interface.
	 * 
	 */
	public class LoginKeyupHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				onLoginClicked(null);
			}
		}

	}
	
	@UiHandler("ancSignUp")
	public void onSignUp(ClickEvent clickEvent){
		Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
		if(params.containsKey("query"))
		{
			String queryVal = AppClientFactory.getPlaceManager().getRequestParameter("query");
			params.put("query", queryVal);
		}
		if(params.containsKey("flt.subjectName"))
		{
			String subjectNameVal = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
			params.put("flt.subjectName", subjectNameVal);
		}
		params.put("callback", "signup");
		params.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );
		closePoupfromChild();
	}

	@UiHandler("forgotPwd")
	public void onForgotPwdClicked(ClickEvent clickEvent) {
		
		ForgotPasswordVc forgotPasswordVc = new ForgotPasswordVc();
		forgotPasswordVc.setGlassEnabled(true);
		forgotPasswordVc.show();
		forgotPasswordVc.center();
		closePoupfromChild();
		// this.hide();

	}
	
	/**
	 * User login popup allows to sign in if correct credentials and set user
	 * info on header view
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("gmailButton")
	public void onGmailButtonClicked(ClickEvent clickEvent){
		DataLogEvents.signIn(GwtUUIDGenerator.uuid(),"login",System.currentTimeMillis(),System.currentTimeMillis(), "", AppClientFactory.getLoggedInUser().getToken());
		String callBack = Window.Location.getHref();
	
		AppClientFactory.getInjector().getSearchService().getGoogleSignin(callBack, new SimpleAsyncCallback<String>() {
		
			@Override
			public void onSuccess(String result) {
//				MixpanelUtil.Click_Gmail_SignIn("LoginPopup");
				Window.Location.replace(result);
			
			}
		});
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * @return instance of collectionDo after collection save
	 */
	public SimpleAsyncCallback<CollectionDo> getSaveCollectionAsyncCallback() {
		if (saveCollectionAsyncCallback == null) {
			saveCollectionAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					
					showSuccessMsgfromChild(result.getGooruOid(),collectionTitle);
				}
			};
		}
		return saveCollectionAsyncCallback;
	}

	private static native boolean isCookieEnabled() /*-{
													return navigator.cookieEnabled;
													}-*/;

	
	public abstract void closePoupfromChild();
	
	public abstract void showSuccessMsgfromChild(String collectionId,String collectionTitle );
	
}
