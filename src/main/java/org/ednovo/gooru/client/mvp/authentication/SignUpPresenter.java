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
package org.ednovo.gooru.client.mvp.authentication;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.uc.SignUpGradeCourseView;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

	/**
	 * 
	 * @fileName : SignUpPresenter.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 26-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
public class SignUpPresenter extends PresenterWidget<IsSignUpView> implements SignUpUiHandlers {
	@Inject
	private UserServiceAsync userService;

	private UserDo user;


	/**
	 * Class constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public SignUpPresenter(EventBus eventBus, IsSignUpView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	/**
	 *  This method is called when the presenter is instantiated
	 */
	@Override
	public void onBind() {
		super.onBind();
	}
	/**
	 *  This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	public void onReveal() {
		super.onReveal();
	}
	/**
	 * 
	 * @function setUserService 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :This method is used to set the userService.
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
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used get the user service.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserServiceAsync
	 *
	 * @throws : 
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
     * @created_date : 26-Dec-2013
     * 
     * @description :This method is used to set the user details.
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
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to get the user details.
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
     * This method is used to create the user.
     */
	@Override
	public void CreateUser(String postData, final String loginData) {
		AppClientFactory.getInjector().getUserService().createUser(postData, new SimpleAsyncCallback<UserDo>() {

			@Override
			public void onSuccess(UserDo result) {
				if (result!=null){
					if (result.getCode() !=null &&  result.getCode() >399){
						new AlertContentUc("Oops!", result.getStatus());
						getView().toggleButtons();
					}else if (result.getGooruUId() !=null && !result.getGooruUId().equalsIgnoreCase("")){
						AppClientFactory.getInjector().getAppService().v2Signin(loginData, new SimpleAsyncCallback<UserDo>() {

							@Override
							public void onSuccess(UserDo result) {
								getView().hide();
								AppClientFactory.setLoggedInUser(result);
								AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(false));
								SignUpGradeCourseView gradeCourseView = new SignUpGradeCourseView(result);
							}
						});
						
					}
				}
			}
		});
	}
    /**
     * 
     * @function displayPopup 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description : This method is used to dispaly popup.
     * 
     * 
     * @parm(s) : @param displayScreen
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     * 
     *
     *
     */
	public void displayPopup(int displayScreen) {
		getView().displayPopUp(displayScreen);
	}
}
