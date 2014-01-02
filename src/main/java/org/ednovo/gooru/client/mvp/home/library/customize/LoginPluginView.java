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
import org.ednovo.gooru.shared.util.MessageProperties;

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
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * 
 * @fileName : LoginPluginView.java
 *
 * @description : This class is used to set the Editing collection to Assignment
 *              under Classpages.
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
public abstract class LoginPluginView extends ChildView<LoginPluginPresenter> implements
		IsLoginPlugin, MessageProperties {

	@UiField(provided = true)
	AssignPopUpCBundle res;

	@UiField
	TextBoxWithPlaceholder loginTxtBox;

	@UiField
	TextBoxWithPlaceholder passwordTxtBox;

	@UiField
	Button loginButton;

	@UiField
	Anchor forgotPwd, ancSignUp;

	@UiField
	Label lblPleaseWait, collectionDescription;

	@Inject
	private ResourceServiceAsync resourceService;

	private SimpleAsyncCallback<CollectionDo> saveCollectionAsyncCallback;

	CollectionDo collectionObject = new CollectionDo();

	private static final String OOPS = MessageProperties.GL0061;
	private static final String LOGIN_ERROR = MessageProperties.GL0347;
	private static final String LOGIN_COOKIE_DISABLE_MESSAGE = MessageProperties.GL0348;

	private static LoginPluginUiBinder uiBinder = GWT
			.create(LoginPluginUiBinder.class);

	interface LoginPluginUiBinder extends UiBinder<Widget, LoginPluginView> {
	}

	/**
	 * Class constructor
	 */
	public LoginPluginView(CollectionDo collectionObject) {

		res = AssignPopUpCBundle.INSTANCE;
		this.collectionObject = collectionObject;
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

		collectionDescription.setText(MessageProperties.GL0476);
		forgotPwd.getElement().setId("lnkForgotPwd");
		loginTxtBox.setPlaceholder(MessageProperties.GL0202);
		loginTxtBox.getElement().setAttribute("placeholder",
				MessageProperties.GL0202);
		loginTxtBox.setFocus(true);
		passwordTxtBox.setPlaceholder(MessageProperties.GL0204);
		forgotPwd.setText(MessageProperties.GL0205);
		loginButton.setText(MessageProperties.GL0187);

		lblPleaseWait.setText(MessageProperties.GL0242);

		loginTxtBox.getElement().setId("tbLoginUsername");
		passwordTxtBox.getElement().setId("tbLoginPassword");
		loginButton.getElement().setId("btnLogin");

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
										lblPleaseWait.setText(MessageProperties.GL0505);
										AppClientFactory
												.setLoggedInUser(result);
										AppClientFactory
												.fireEvent(new SetHeaderEvent(
														result));
										AppClientFactory
												.fireEvent(new SetUserDetailsInCollectionPlayEvent(
														result.getToken(),
														result.getGooruUId()));

										AppClientFactory
												.getInjector()
												.getResourceService()
												.copyCollection(
														collectionObject,
														"true",
														null,
														getSaveCollectionAsyncCallback());
										
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
			new AlertMessageUc("Aww!", new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
		}
		
		
	}
	/**
	 * 
	 * @function setHandlers 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to set the Handlers.
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
	/**
	 * 
	 * @function onSignUp 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to set the callback parameters and passing them to service as parameters.
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
	@UiHandler("ancSignUp")
	public void onSignUp(ClickEvent clickEvent){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("callback", "signup");
		params.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );
		closePoupfromChild();
	}
	/**
	 * 
	 * @function onForgotPwdClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to open forgotPwd popup.
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
	 * 
	 * @function getResourceService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns resourceService.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : ResourceServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}
	/**
	 * 
	 * @function setResourceService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for resourceService.
	 * 
	 * 
	 * @parm(s) : @param resourceService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
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
					showSuccessMsgfromChild(result.getGooruOid());
				}
			};
		}
		return saveCollectionAsyncCallback;
	}
	/**
	 * 
	 * @function isCookieEnabled 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To check the cookie statuus wheather it is enabled/disabled.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private static native boolean isCookieEnabled() /*-{
													return navigator.cookieEnabled;
													}-*/;

	
	public abstract void closePoupfromChild();
	
	public abstract void showSuccessMsgfromChild(String collectionId);
	
}
