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


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.OpenClasspageListEvent;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountEvent;
import org.ednovo.gooru.client.mvp.home.event.SetTexasPlaceHolderEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInCollectionPlayEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInPlayEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoginStatusEvent;
import org.ednovo.gooru.client.mvp.play.collection.event.ShowCollectionTabWidgetEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.DataLogEvents;
import org.ednovo.gooru.shared.util.GwtUUIDGenerator;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * 
 * @fileName : LoginPopupUc.java
 *
 * @description : Related to Login Popup.
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
public class LoginPopupUc extends PopupPanel {
 
	@UiField
	TextBoxWithPlaceholder loginTxtBox;

	@UiField
	TextBoxWithPlaceholder passwordTxtBox;

	@UiField Anchor forgotPwd,ancRegisterHere;
	
	@UiField Label lblLoginHeading,lblDoYouHaveAccount,lblOr, lblPleaseWait, lblWelcomeBack,lblLoginWithGooru;

//	@UiField CheckBox lblKeepMeLogedIn;
	
	@UiField HTMLEventPanel cancelButton;
	
	@UiField Button  loginButton,gmailButton;

	
	@UiField(provided = true)
	LoginPopUpCBundle res;

	private HeaderUc headerUc;

	protected UserDo userDo;

	private SimpleAsyncCallback<UserDo> signedInDataAsyncCallback;

	private static final String LOGIN_ERROR = MessageProperties.GL0347;

	private static final String LOGIN_COOKIE_DISABLE_MESSAGE = MessageProperties.GL0348;

	private static final String OOPS = MessageProperties.GL0061;
	
	private String nameToken = "";
	
	public String eventType = "";
	
	private String emailId = null;

	int age = 0;

	
	private String widgetMode=null;
	

	private static final String LOGINEVENT = "loginEvent";
	@UiTemplate("LoginPopupUc.ui.xml")
	interface Binder extends UiBinder<Widget, LoginPopupUc> {

	}

	private static final Binder binder = GWT.create(Binder.class);
	
	/**
	 * Class constructor , to create Login Popup. 
	 */
	
	
	public LoginPopupUc(){
		super(false);
        this.res = LoginPopUpCBundle.INSTANCE;
        res.css().ensureInjected();
        this.setGlassStyleName(LoginPopUpCBundle.INSTANCE.css().loginPopupGlassStyle());
        this.setGlassEnabled(true);
       	this.getElement().getStyle().setZIndex(99999);
       	
        add(binder.createAndBindUi(this));
        setTextAndIds();
        
		lblPleaseWait.setVisible(false);
        
		setHandlers();
        
		this.center();
	}
	/**
	 * Parameterized Constructor to initialize email id.
	 * @param emailId
	 */
	public LoginPopupUc(String emailId){
		this();
		this.emailId = emailId;
	}

	/**
	 * Class constructor , assign {@link HeaderUc} instance
	 * 
	 * @param headerUc
	 *            instance of {@link HeaderUc}
	 */
	public LoginPopupUc(HeaderUc headerUc) {
		super(false);
		this.res = LoginPopUpCBundle.INSTANCE;
		res.css().ensureInjected();
		this.headerUc = headerUc;
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);

		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
//        lblKeepMeLogedIn.getElement().setId("chkLogin");
		setTextAndIds();
		lblPleaseWait.setVisible(false);

		setHandlers();
		
		this.center();		
	}
	/**
	 * 
	 * @function setHandlers 
	 * 
	 * @created_date : 15-09-2013
	 * 
	 * @description : To set Handlers.
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
	private void setHandlers(){

		this.setSize("515px", "547px");
		
		loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
		passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
	}
	
	
	/**
	 * 
	 * @function setText 
	 * 
	 * @created_date : Aug 25, 2013
	 * 
	 * @description
	 * 	To the labels for each controls.
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
	public void setTextAndIds(){
		lblLoginHeading.setText(MessageProperties.GL0187);
		gmailButton.setText(MessageProperties.GL0203);
		gmailButton.getElement().setId("btnGmail");
		forgotPwd.getElement().setId("lnkForgotPwd");
        loginTxtBox.setPlaceholder(MessageProperties.GL0202);
        loginTxtBox.getElement().setAttribute("placeholder", MessageProperties.GL0202);
		loginTxtBox.setFocus(true);
        passwordTxtBox.setPlaceholder(MessageProperties.GL0204);
        forgotPwd.setText(MessageProperties.GL0205);
//        lblKeepMeLogedIn.setText(MessageProperties.GL0206);
        loginButton.setText(MessageProperties.GL0187);
        ancRegisterHere.setText(MessageProperties.GL0207);
        ancRegisterHere.getElement().setId("lnkRegisterHere");
        lblDoYouHaveAccount.setText(MessageProperties.GL0208);
        lblOr.setText(MessageProperties.GL0209);
        lblPleaseWait.setText(MessageProperties.GL0242);
        
        loginTxtBox.getElement().setId("tbLoginUsername");
        passwordTxtBox.getElement().setId("tbLoginPassword");
        loginButton.getElement().setId("btnLogin");
        
        lblPleaseWait.setVisible(false);
        
        lblWelcomeBack.setText(MessageProperties.GL0345);
        lblLoginWithGooru.setText(MessageProperties.GL0346);;
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
				MixpanelUtil.Click_Gmail_SignIn("LoginPopup");
				Window.Location.replace(result);
			
			}
		});
	}
	
	/**
	 * Added click handler to perform Login operation by taking entered user name and password from the user.
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	
	@UiHandler("loginButton")
	public void onLoginClicked(ClickEvent clickEvent) {
	
		if (isCookieEnabled()) {
			
			final String username = loginTxtBox.getText().trim();
			String password = passwordTxtBox.getText().trim();
			
			JSONObject login = new JSONObject();
			login.put("username", new JSONString(username));
			login.put("password", new JSONString(password));
			
			if (username.length() > 1 && password.length() > 1) {
				
				loginButton.setVisible(false);
				lblPleaseWait.setVisible(true);
//				AppClientFactory.getInjector().getAppService().signin(username, password, new AsyncCallback<UserDo>() {
				AppClientFactory.getInjector().getAppService().v2Signin(login.toString(), new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo result) {
						MixpanelUtil.Regular_User_Logged_In();
						if(result.getDateOfBirth()!=null && result.getAccountTypeId()==2){
						MixpanelUtil.Registration_turns13(); 
						com.google.gwt.i18n.client.DateTimeFormat dateFormat = com.google.gwt.i18n.client.DateTimeFormat
									.getFormat("yyyy-MM-dd hh:mm:ss.S");
						Date convertedCurrentDate = null;
						convertedCurrentDate = dateFormat.parse(result.getDateOfBirth());
						age = getAge(convertedCurrentDate);
						 if(age>=13){
							 Map<String, String> map = StringUtil.splitQuery(Window.Location
										.getHref());
								map.put("callback", "turn13");
								AppClientFactory.getPlaceManager().revealPlace(
										AppClientFactory.getCurrentPlaceToken(), map);
							  }
						}
						AppClientFactory.setLoggedInUser(result);
						AppClientFactory.fireEvent(new SetUserDetailsInPlayEvent(result.getToken()));
						AppClientFactory.fireEvent(new SetUserDetailsInCollectionPlayEvent(result.getToken(),result.getGooruUId()));
						if(getWidgetMode()!=null){
							//AppClientFactory.fireEvent(new ShowResourceTabWidgetEvent(getWidgetMode(), false));
						}
						hide();
						//headerUc.setLoggedInUser(result);
					    AppClientFactory.fireEvent(new SetHeaderEvent(result));
						//AppClientFactory.resetPlace();
					    
					    if(result.getUsername().equalsIgnoreCase("TexasTeacher")) {
							AppClientFactory.fireEvent(new SetTexasAccountEvent("failure"));
							AppClientFactory.fireEvent(new SetTexasPlaceHolderEvent(true));
						}else{
							AppClientFactory.fireEvent(new SetTexasAccountEvent("success"));
							AppClientFactory.fireEvent(new SetTexasPlaceHolderEvent(false));
						}
					    
					    AppClientFactory.setUserflag(true);
					    if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.COLLECTION_PLAY)){
					    	//AppClientFactory.fireEvent(new ShowCollectionTabWidgetEvent(getWidgetMode(), false));
					    } 
					    else if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.RESOURCE_PLAY)){
					    	//AppClientFactory.fireEvent(new ShowResourceTabWidgetEvent(getWidgetMode(), false));
						}else{
							AppClientFactory.resetPlace();
							Window.enableScrolling(true);
							AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
						}
					   
					    showNewGooruTryOut(result);
					    if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.HOME)) {
					    	AppClientFactory.fireEvent(new SetLoginStatusEvent(true));
					    }
					    
					    if(nameToken.equals(PlaceTokens.TEACH)) {
					    	AppClientFactory.fireEvent(new OpenClasspageListEvent());
					    }  else if(nameToken.equals(PlaceTokens.SHELF)){
							AppClientFactory.getInjector().getResourceService().getUserCollection(new SimpleAsyncCallback<List<CollectionDo>>() {
				                public void onSuccess(List<CollectionDo> result) {				                	
			                    	for (CollectionDo collection : result) {
			                			if (!collection.getCollectionType().toString().trim().equalsIgnoreCase("folder")){
		                    				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, new String[] { "id", collection.getGooruOid() });
			                				break;
			                			}
			                		}
				                }
				            });
					    }
					  
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
		} else  { 
			loginButton.setVisible(true);
			lblPleaseWait.setVisible(false);
			new AlertMessageUc("Aww!", new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
		}
	}

	/**
	 * Added click handler to hide the login popup.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		
		/*
		 * Checks for parameter value if it is true then it will remove the parameter, so that it will avoid 
		 * invoking login popup multiple times on refresh.
		 */
		if(AppClientFactory.getPlaceManager().getRequestParameter(LOGINEVENT) != null && AppClientFactory.getPlaceManager().getRequestParameter(LOGINEVENT).equalsIgnoreCase("true")){
			hide();
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.COLLECTION_PLAY)){
	    	AppClientFactory.fireEvent(new ShowCollectionTabWidgetEvent(getWidgetMode(), true));
	    } 
	    else if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.RESOURCE_PLAY)){
	    	//AppClientFactory.fireEvent(new ShowResourceTabWidgetEvent(getWidgetMode(), true));
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
        hide();
	}

	/**
	 * Get register popup and set popup location
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("ancRegisterHere")
	public void onRegisterClicked(ClickEvent clickEvent) {
		MixpanelUtil.Arrive_Register_popup();
		DataLogEvents.signUp(GwtUUIDGenerator.uuid(),"login",System.currentTimeMillis(),System.currentTimeMillis(), "");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("callback", "signup");
		params.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME, params );
		
		/*RegisterVc registerVc = new RegisterVc();
		registerVc.center();
		registerVc.show();*/
		
		this.hide();
	}

	/**
	 * Get forgot password popup while clicking on forgot password link on login
	 * popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("forgotPwd")
	public void onForgotPwdClicked(ClickEvent clickEvent) {
		ForgotPasswordVc forgotPasswordVc=new ForgotPasswordVc();
		forgotPasswordVc.setGlassEnabled(true);
		forgotPasswordVc.show();
		forgotPasswordVc.center();
		this.hide();
				
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
	 * Update user view flag
	 * 
	 * @param user
	 *            instance of {@link UserDo}
	 */
	private void showNewGooruTryOut(UserDo user) { 
		if (user != null) {
			int flag = user.getViewFlag() != null ? user.getViewFlag() : 0;
			if (flag == 0 && !AppClientFactory.isAnonymous()) {
				/*ImprovedGooruPopUpView popupview=new ImprovedGooruPopUpView();
				popupview.show();
				popupview.center();*/
				
				//new TryItOutVc();
				
				AppClientFactory.getInjector().getUserService().updateUserViewFlag(user.getGooruUId(), 1, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo newUser) {
						UserDo user = AppClientFactory.getLoggedInUser();
						user.setViewFlag(newUser.getViewFlag());
						AppClientFactory.setLoggedInUser(user);
					}
				});
			} else if((flag == 2||flag == 5||flag==1) && !AppClientFactory.isAnonymous()){
				new ImprovedGooruPopUpView();

				AppClientFactory.getInjector().getUserService().updateUserViewFlag(user.getGooruUId(), 6, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo newUser) {
						UserDo user = AppClientFactory.getLoggedInUser();
						user.setViewFlag(newUser.getViewFlag());
						AppClientFactory.setLoggedInUser(user);
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
	 * @description :Native method to check cookie is enabled or not.
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
	 * @return instance of UserDo.
	 */
	
	public SimpleAsyncCallback<UserDo> getSignedInDataAsyncCallback() {
		return signedInDataAsyncCallback;
	}

	/**
	 * 
	 * @param signedInDataAsyncCallback {@link SimpleAsyncCallback<UserDo>}
	 */
	public void setSignedInDataAsyncCallback(SimpleAsyncCallback<UserDo> signedInDataAsyncCallback) {
		this.signedInDataAsyncCallback = signedInDataAsyncCallback;
	}
	/**
	 * 
	 * @function setNameToken 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : To set NameToken.
	 * 
	 * 
	 * @parm(s) : @param nameToken
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setNameToken(String nameToken) { 
		this.nameToken=nameToken;
	}
	/**
	 * 
	 * @function setMixPanelEvent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To initialize eventType.
	 * 
	 * 
	 * @parm(s) : @param eventType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setMixPanelEvent(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * 
	 * @function getMixPanelEvent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : To get eventType.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public String getMixPanelEvent() {
		return eventType;
		
	}
	/**
	 * onLoad
	 */
	public void onLoad(){
		super.onLoad();
		Scheduler.get().scheduleDeferred(new  ScheduledCommand(){
			public void execute() {
				if(emailId!=null) {
					loginTxtBox.setText(emailId);
					loginTxtBox.setReadOnly(true);
				}
			}
		});
	}
	/**
	 * 
	 * @function getAge 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : To get Age based on DOB.
	 * 
	 * 
	 * @parm(s) : @param birthDate
	 * @parm(s) : @return
	 * 
	 * @return : int
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private int getAge(Date birthDate) {
		if (birthDate != null) {
			long ageInMillis = new Date().getTime() - birthDate.getTime();
			Date age = new Date(ageInMillis);
			return age.getYear() - 70;
		} else {
			return 0;
		}
	}
	/**
	 * 
	 * @function getWidgetMode 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : getter for widgetMode.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public String getWidgetMode() {
		return widgetMode;
	}
	/**
	 * 
	 * @function setWidgetMode 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter for widgetMode.
	 * 
	 * 
	 * @parm(s) : @param widgetMode
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setWidgetMode(String widgetMode) {
		this.widgetMode = widgetMode;

	}
}

