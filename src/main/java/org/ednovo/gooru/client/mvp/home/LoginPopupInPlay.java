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
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class LoginPopupInPlay extends PopupPanel {

    @UiField
    TextBoxWithPlaceholder loginTxtBox;

    @UiField
    TextBoxWithPlaceholder passwordTxtBox;

    @UiField
    Label registerHereLbl,loginLbl,betaText,loginToCreateteLbl,forgotPwd,doNotHaveAcLbl;

    @UiField CheckBox keepMeLoginLbl;
    
    @UiField Button loginButton;
    
    @UiField Anchor cancelButton;
    
    @UiField(provided = true)
    HomeCBundle res;

    private HeaderUc headerUc;
    
    protected UserDo userDo;

    private SimpleAsyncCallback<UserDo> signedInDataAsyncCallback;

//    private static final String LOGIN_ERROR =i18n.GL0347;

//    private static final String LOGIN_COOKIE_DISABLE_MESSAGE =i18n.GL0348;

//    private static final String OOPS = i18n.GL0061;

    interface Binder extends UiBinder<Widget, LoginPopupInPlay> {

    }

    private static final Binder binder = GWT.create(Binder.class);
    
    private MessageProperties i18n = GWT.create(MessageProperties.class);

    public LoginPopupInPlay() {
        super(true);
        this.res = HomeCBundle.INSTANCE;
        res.css().ensureInjected();
       // this.getElement().getStyle().setZIndex(999999);
        //this.getElement().setAttribute("style", "width: 515px;height: 547px;z-index: 999999;visibility: visible;position: absolute;left: 0 !important;right: 0 !important;margin:auto;");
        this.setGlassStyleName(HomeCBundle.INSTANCE.css().loginPopupGlassStyle());
        add(binder.createAndBindUi(this));
        loginLbl.setText(i18n.GL0187()+i18n.GL_SPL_EXCLAMATION());
        loginLbl.getElement().setId("lblLoginLbl");
        loginLbl.getElement().setAttribute("alt",i18n.GL0187());
        loginLbl.getElement().setAttribute("title",i18n.GL0187());
		
        betaText.setText(i18n.GL0178());
        betaText.getElement().setId("lblBetaText");
        betaText.getElement().setAttribute("alt",i18n.GL0178());
        betaText.getElement().setAttribute("title",i18n.GL0178());
        
        loginToCreateteLbl.setText(i18n.GL1251()+i18n.GL_SPL_EXCLAMATION());
        loginToCreateteLbl.getElement().setId("lblLoginToCreateteLbl");
        loginToCreateteLbl.getElement().setAttribute("alt",i18n.GL1251());
        loginToCreateteLbl.getElement().setAttribute("title",i18n.GL1251());
        
        loginTxtBox.setPlaceholder(i18n.GL0434());
        loginTxtBox.getElement().setId("txtLoginTxtBox");
        passwordTxtBox.getElement().setId("pswPasswordTxtBox");
        passwordTxtBox.setPlaceholder(i18n.GL0204());
      
        forgotPwd.setText(i18n.GL0063()+i18n.GL_SPL_QUESTION());
        forgotPwd.getElement().setId("lblForgotPwd");
        forgotPwd.getElement().setAttribute("alt",i18n.GL0063());
        forgotPwd.getElement().setAttribute("title",i18n.GL0063());
        
        keepMeLoginLbl.setText(i18n.GL1252());
        keepMeLoginLbl.getElement().setId("chkKeepMeLoginLbl");
        keepMeLoginLbl.getElement().setAttribute("alt",i18n.GL1252());
        keepMeLoginLbl.getElement().setAttribute("title",i18n.GL1252());
        
        loginButton.setText(i18n.GL0187());
        loginButton.getElement().setId("btnLoginButton");
        loginButton.getElement().setAttribute("alt",i18n.GL0187());
        loginButton.getElement().setAttribute("title",i18n.GL0187());
        
        cancelButton.setText(i18n.GL0142());
        cancelButton.getElement().setId("lnkCancelButton");
        cancelButton.getElement().setAttribute("alt",i18n.GL0142());
        cancelButton.getElement().setAttribute("title",i18n.GL0142());
        
        doNotHaveAcLbl.setText(i18n.GL0208());
        doNotHaveAcLbl.getElement().setId("lblDoNotHaveAcLbl");
        doNotHaveAcLbl.getElement().setAttribute("alt",i18n.GL0208());
        doNotHaveAcLbl.getElement().setAttribute("title",i18n.GL0208());
        
        registerHereLbl.setText(i18n.GL1253());
        registerHereLbl.getElement().setId("lblRegisterHereLbl");
        registerHereLbl.getElement().setAttribute("alt",i18n.GL1253());
        registerHereLbl.getElement().setAttribute("title",i18n.GL1253());
        
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
        loginLbl.setText(i18n.GL0187()+i18n.GL_SPL_EXCLAMATION());
        betaText.setText(i18n.GL0178());
        loginToCreateteLbl.setText(i18n.GL1251()+i18n.GL_SPL_EXCLAMATION());
        loginTxtBox.setPlaceholder(i18n.GL0434());
        passwordTxtBox.setPlaceholder(i18n.GL0204());
        forgotPwd.setText(i18n.GL0063()+i18n.GL_SPL_QUESTION());
        keepMeLoginLbl.setText(i18n.GL1252());
        loginButton.setText(i18n.GL0187());
        cancelButton.setText(i18n.GL0142());
        doNotHaveAcLbl.setText(i18n.GL0208());
        registerHereLbl.setText(i18n.GL1253());
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
                AppClientFactory.getInjector().getAppService().signin(username, password, new SimpleAsyncCallback<UserDo>() {

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
//                        new AlertContentUc(i18n.GL0061(), caught.getMessage());
                    }
                });
            } else {
                new AlertContentUc(i18n.GL0061(), i18n.GL0347());
            }
        } else  { 
            new AlertMessageUc(i18n.GL0738(), new HTML(i18n.GL0348()));
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
     * @author Search Team
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
    
    private static native boolean isCookieEnabled() /*-{
        return navigator.cookieEnabled;
     }-*/;

    public SimpleAsyncCallback<UserDo> getSignedInDataAsyncCallback() {
        return signedInDataAsyncCallback;
    }

    public void setSignedInDataAsyncCallback(SimpleAsyncCallback<UserDo> signedInDataAsyncCallback) {
        this.signedInDataAsyncCallback = signedInDataAsyncCallback;
    }
}
