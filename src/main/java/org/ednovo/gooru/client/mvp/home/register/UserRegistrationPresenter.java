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
package org.ednovo.gooru.client.mvp.home.register;

import java.util.Map;


import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * 
 * @fileName : UserRegistrationPresenter.java
 *
 * @description : This is the presenter class for UserRegistrationView.
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
public class UserRegistrationPresenter extends PresenterWidget<IsUserRegistrationView> implements UserRegistrationUiHandlers {

	private static final String GOORU_UID = "gooruuid";
	private static final String SESSION_Id = "sessionid";
	private static final String DOB = "dob";

	@Inject
	private UserServiceAsync userService;

	private UserDo user;

	private AsyncCallback<ProfileDo> updateUserAsyncCallback;

	private RegistrationWelcomePopup registrationWelcomePopup;

	private SimpleAsyncCallback<UserDo> checkUserAsyncCallback;

	private ChildAccountPopup childAccountPopup;
	
	private SimpleAsyncCallback<UserDo> createChildUserAsyncCallback;

	private String accountType;
	
	private boolean showWelcomeMessage = false;
	
	private SimpleAsyncCallback<UserDo> updateFlagAsyncCallback;
	
	private static final String CHILD = "Child";
	
	private static final String NON_PARENT = "NonParent";
	
	private static final String PARENT = "Parent";
	
	private static final String OH_NO_TEXT = "Oh! No...";
	
	private static final String ACCOUNT_TYPE = "accountType";
	
	private static final String REGISTRATION_TYPE = "registrationType";
	
	private static final String FIRST_NAME = "firstName";
	
	private static final String LAST_NAME = "lastName";
	
	private static final String EMAIL_ID = "emailId";
	
	private static final String ORGANIZATION_CODE = "organizationCode";
	
	private static final String GOORU = "gooru";
	
	private static final String CHILD_LAST_NAME = "childlastname";
	
	private static final String CHILD_FIRST_NAME = "childfirstname";
	
	private static final String GMAIL_ADDRESS = "@gmail.com";

	/**
	 * Class constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public UserRegistrationPresenter(EventBus eventBus, IsUserRegistrationView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	/**
	 * This method is called when the presenter is instantiated.
	 */
	@Override
	public void onBind() {
		super.onBind();
		setUpdateUserAsyncCallback(new AsyncCallback<ProfileDo>() {

			@Override
			public void onSuccess(final ProfileDo userProfile) {
				if (!getView().getRegistrationType().equalsIgnoreCase(CHILD)) {
					AppClientFactory.setLoggedInUser(userProfile.getUser());
					AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(userProfile.getUser());
				}

				if (getView().getRegistrationType().equalsIgnoreCase(NON_PARENT)) {
					getView().closeRegisterPopup();
					showWelcomeMessage();
				}
				if (getView().getRegistrationType().equalsIgnoreCase(PARENT)) {
					showWelcomeMessage = true;
					getView().renderChildAccount();
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				UcCBundle.INSTANCE.css().ensureInjected();
				new AlertContentUc(OH_NO_TEXT, caught.getMessage()).getAlertBox().addStyleName(UcCBundle.INSTANCE.css().increaseZindex());
			}

		});

		setCheckUserAsyncCallback(new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo result) {
				getView().checkUserNameAvailability(result);
			}
		});
		
		setCreateChildUserAsyncCallback(new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo user) {
				if (getView().getRegistrationType().equalsIgnoreCase(CHILD)) 
				{
					getView().closeRegisterPopup();
					childAccountPopup = new ChildAccountPopup();
					childAccountPopup.confirmationButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							childAccountPopup.getPopupPanel().hide();
							if (showWelcomeMessage) 
							{
								showWelcomeMessage();
							}
							else
							{								
								AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
							}
						}
					});
				}
			}
		});
		
		setUpdateFlagAsyncCallback(new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo newUser) {
				UserDo user = AppClientFactory.getLoggedInUser();
				user.setViewFlag(newUser.getViewFlag());
				AppClientFactory.setLoggedInUser(user);
			}
		});	
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	public void onReveal() {
		super.onReveal();
		getView().setRegisteredUserDetails(getUser(), getAccountType());
	}

	/**
	 * This method is used to update user details.
	 */
	@Override
	public void updateUserDetails(Map<String, String> params) {
		params.put(ACCOUNT_TYPE, getView().getRegistrationType());
		params.put(REGISTRATION_TYPE, getView().getRegistrationType());
		this.getUserService().updateUserDetails(AppClientFactory.getPlaceManager().getRequestParameter(GOORU_UID), AppClientFactory.getPlaceManager().getRequestParameter(SESSION_Id), params, getUpdateUserAsyncCallback());
	}
	/**
	 * This methos is used to register child user account.
	 */
	@Override
	public void registerChildUserAccount(Map<String, String> params) {
		params.put(FIRST_NAME, getView().getFirstName());
		params.put(LAST_NAME, getView().getLastName());
		params.put(ACCOUNT_TYPE, getView().getRegistrationType());
		params.put(REGISTRATION_TYPE, getView().getRegistrationType());
		params.put(EMAIL_ID, GMAIL_ADDRESS);
		params.put(ORGANIZATION_CODE, GOORU);
		params.put("childFlag", "true");
		params.put("userParentId", AppClientFactory.getPlaceManager().getRequestParameter(GOORU_UID));
		params.put("dateOfBirth", AppClientFactory.getPlaceManager().getRequestParameter(DOB).replaceAll("d", "/"));

		this.getUserService().registerUser(params, getCreateChildUserAsyncCallback());
		
	}
	
	/**
	 * Creates welcome popup after registration
	 */
	private void showWelcomeMessage() { 
		
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
		getUserService().updateUserViewFlag(AppClientFactory.getLoggedInUser().getGooruUId(), 1, getUpdateFlagAsyncCallback());
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
		
		/*registrationWelcomePopup = new RegistrationWelcomePopup();
		registrationWelcomePopup.getConfirmButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				registrationWelcomePopup.getPopupPanel().hide();
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
				getUserService().updateUserViewFlag(AppClientFactory.getLoggedInUser().getGooruUId(), 1, getUpdateFlagAsyncCallback());
				GooruGuideVc gooruGuideVc = new GooruGuideVc();
				gooruGuideVc.show();
				gooruGuideVc.center();
				
			}
		});*/
	}
	/**
	 * 
	 * @function setUserService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for userService
	 * 
	 * 
	 * @parm(s) : @param userService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserService(UserServiceAsync userService) {
		this.userService = userService;
	}
	/**
	 * 
	 * @function getUserService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns userService.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public UserServiceAsync getUserService() {
		return userService;
	}
	/**
	 * 
	 * @function setUser 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for user.
	 * 
	 * 
	 * @parm(s) : @param user
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUser(UserDo user) {
		this.user = user;
	}
	/**
	 * 
	 * @function getUser 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns user.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public UserDo getUser() {
		return user;
	}
	/**
	 * 
	 * @function setUpdateUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for updateUserAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param updateUserAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUpdateUserAsyncCallback(AsyncCallback<ProfileDo> updateUserAsyncCallback) {
		this.updateUserAsyncCallback = updateUserAsyncCallback;
	}
	/**
	 * 
	 * @function getUpdateUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns updateUserAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : AsyncCallback<ProfileDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public AsyncCallback<ProfileDo> getUpdateUserAsyncCallback() {
		return updateUserAsyncCallback;
	}
	/**
	 * 
	 * @function setAccountType 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for accountType.
	 * 
	 * 
	 * @parm(s) : @param accountType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * 
	 * @function getAccountType 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns accountType.
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
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 
	 * @function getCheckUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns checkUserAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<UserDo> getCheckUserAsyncCallback() {
		return checkUserAsyncCallback;
	}
	/**
	 * 
	 * @function setCheckUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for checkUserAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param checkUserAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCheckUserAsyncCallback(SimpleAsyncCallback<UserDo> checkUserAsyncCallback) {
		this.checkUserAsyncCallback = checkUserAsyncCallback;
	}
	/**
	 * This will check user availability.
	 */
	@Override
	public void checkUserAvailability(String userName, String type) {
		this.getUserService().getEmailId(userName, type, getCheckUserAsyncCallback());
	}
	/**
	 * 
	 * @function getCreateChildUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns createChildUserAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<UserDo> getCreateChildUserAsyncCallback() {
		return createChildUserAsyncCallback;
	}
	/**
	 * 
	 * @function setCreateChildUserAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for createChildUserAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param createChildUserAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCreateChildUserAsyncCallback(SimpleAsyncCallback<UserDo> createChildUserAsyncCallback) {
		this.createChildUserAsyncCallback = createChildUserAsyncCallback;
	}
	/**
	 * 
	 * @function setUpdateFlagAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for updateFlagAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param updateFlagAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUpdateFlagAsyncCallback(SimpleAsyncCallback<UserDo> updateFlagAsyncCallback) {
		this.updateFlagAsyncCallback = updateFlagAsyncCallback;
	}
	/**
	 * 
	 * @function getUpdateFlagAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns updateFlagAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<UserDo> getUpdateFlagAsyncCallback() {
		return updateFlagAsyncCallback;
	}

}
