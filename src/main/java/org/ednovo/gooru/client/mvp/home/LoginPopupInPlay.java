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

import org.ednovo.gooru.client.SimpleAsyncCallback;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInCollectionPlayEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInPlayEvent;
import org.ednovo.gooru.client.mvp.home.register.RegisterVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

	/**
	 * 
	 * @fileName : LoginPopupInPlay.java
	 *
	 * @description : Relates to Login.
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
public class LoginPopupInPlay extends PopupPanel {

    @UiField
    TextBoxWithPlaceholder loginTxtBox;

    @UiField
    TextBoxWithPlaceholder passwordTxtBox;

    @UiField
    Label registerHereLbl;

    @UiField(provided = true)
    HomeCBundle res;

    private HeaderUc headerUc;
    
    protected UserDo userDo;

    private SimpleAsyncCallback<UserDo> signedInDataAsyncCallback;

    private static final String LOGIN_ERROR = "Please double-check your email address and password, and then try logging in again.";

    private static final String LOGIN_COOKIE_DISABLE_MESSAGE = "Your browser's cookies seem to be turned off. Please turn them on to continue! Don't know how ? <a href=\"http://support.google.com/accounts/bin/answer.py?hl=en&amp;p=mail&amp;ctx=ch_ServiceLoginAuth&amp;answer=61416\" target=\"_blank\" style=\"text-decoration: none;\">This might help you!</a>";

    private static final String OOPS = "Oops!";

    interface Binder extends UiBinder<Widget, LoginPopupInPlay> {

    }

    private static final Binder binder = GWT.create(Binder.class);
	/**
	 * Constructor.
	 */
    public LoginPopupInPlay() {
        super(true);
        this.res = HomeCBundle.INSTANCE;
        res.css().ensureInjected();
        this.getElement().getStyle().setZIndex(999999);
        this.setGlassStyleName(HomeCBundle.INSTANCE.css().loginPopupGlassStyle());
        add(binder.createAndBindUi(this));
        loginTxtBox.addStyleName(HomeCBundle.INSTANCE.css().textBoxPlaceHolderWidth());
        passwordTxtBox.addStyleName(HomeCBundle.INSTANCE.css().textBoxPlaceHolderWidth());
        loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
        passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
    }

    /**
     * Class constructor , assign {@link HeaderUc} instance
     * 
     * @param headerUc
     *            instance of {@link HeaderUc}
     */
    public LoginPopupInPlay(HeaderUc headerUc) {
        super(true);
        this.res = HomeCBundle.INSTANCE;
        res.css().ensureInjected();
        this.headerUc = headerUc;
        add(binder.createAndBindUi(this));
        loginTxtBox.addStyleName(HomeCBundle.INSTANCE.css().textBoxPlaceHolderWidth());
        passwordTxtBox.addStyleName(HomeCBundle.INSTANCE.css().textBoxPlaceHolderWidth());
        loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
        passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
    }

    
    /**
     * User login popup allows to sign in if correct credential and set user
     * info on header view
     * 
     * @param clickEvent
     *            instance of {@link ClickEvent}
     */
    @UiHandler("loginButton")
    public void onLoginClicked(ClickEvent clickEvent) {
        if (isCookieEnabled()) {
            String username = loginTxtBox.getText().trim();
            String password = passwordTxtBox.getText().trim();
            if (username.length() > 1 && password.length() > 1) {
                AppClientFactory.getInjector().getAppService().signin(username, password, new AsyncCallback<UserDo>() {

                    @Override
                    public void onSuccess(UserDo result) {
                        AppClientFactory.setLoggedInUser(result);
                        AppClientFactory.fireEvent(new SetUserDetailsInPlayEvent(result.getToken()));
                        AppClientFactory.fireEvent(new SetUserDetailsInCollectionPlayEvent(result.getToken(),result.getGooruUId()));
                        hide();
                        //headerUc.setLoggedInUser(result);
                        AppClientFactory.fireEvent(new SetHeaderEvent(result));
                        
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        new AlertContentUc(OOPS, caught.getMessage());
                    }
                });
            } else {
                new AlertContentUc(OOPS, LOGIN_ERROR);
            }
        } else  { 
            new AlertMessageUc("Aww!", new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
        }
    }

    /**
     * Cancel the login popup
     * 
     * @param clickEvent
     *            instance of {@link ClickEvent}
     */
    @UiHandler("cancelButton")
    public void onCancelClicked(ClickEvent clickEvent) {
        setVisible(false);

    }

    /**
     * Get register popup and set popup location
     * 
     * @param clickEvent
     *            instance of {@link ClickEvent}
     */
    @UiHandler("registerHereLbl")
    public void onRegisterClicked(ClickEvent clickEvent) {
        RegisterVc registerVc = new RegisterVc();
        registerVc.show();
        registerVc.center();
        registerVc.setGlassEnabled(true);
        setVisible(false);
    }

    /**
     * Get forget password popup while clicking forgot password link in login
     * popup
     * 
     * @param clickEvent
     *            instance of {@link ClickEvent}
     */
    @UiHandler("forgotPwd")
    public void onForgotPwdClicked(ClickEvent clickEvent) {
        new ForgotPasswordVc();
        setVisible(false);
    }

    /**
     * Keyup handler.
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
     * Update user view flag
     * 
     * @param user
     *            instance of {@link UserDo}
     */
    private void showNewGooruTryOut(UserDo user) {
        if (user != null) {
            int flag = user.getViewFlag() != null ? user.getViewFlag() : 0;
            if (flag == 0 && !AppClientFactory.isAnonymous()) {
            	
             //   new TryItOutVc();
                AppClientFactory.getInjector().getUserService().updateUserViewFlag(user.getGooruUId(), 1, new SimpleAsyncCallback<UserDo>() {
                    @Override
                    public void onSuccess(UserDo newUser) {
                    	userDo = AppClientFactory.getLoggedInUser();
                    	userDo.setViewFlag(newUser.getViewFlag());
                        AppClientFactory.setLoggedInUser(userDo);
                    }
                });
            }
        }
    }
    /**
     * 
     * @function isCookieEnabled 
     * 
     * @created_date : 30-Dec-2013
     * 
     * @description : To check wheather isCookieEnabled or not.
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
	/**
	 * 
	 * @function getSignedInDataAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :returns signedInDataAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return signedInDataAsyncCallback
	 * 
	 * @return : SimpleAsyncCallback<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	    public SimpleAsyncCallback<UserDo> getSignedInDataAsyncCallback() {
        return signedInDataAsyncCallback;
    }
	/**
	 * 
	 * @function setSignedInDataAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : To initialize signedInDataAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param signedInDataAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
    public void setSignedInDataAsyncCallback(SimpleAsyncCallback<UserDo> signedInDataAsyncCallback) {
        this.signedInDataAsyncCallback = signedInDataAsyncCallback;
    }
}
