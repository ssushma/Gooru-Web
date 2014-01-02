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
package org.ednovo.gooru.client.mvp.authentication.uc;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
  /**
   * 
   * @fileName : SignUpRoleView.java
   *
   * @description : This file deals with signup role view.
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
public class SignUpRoleView extends PopupPanel {

	@UiField Label lblTitle, lblCancel;
	
	@UiField HTMLPanel teacherRg, studentRg, parentRg, otherRg;
	
	@UiField TextBoxWithPlaceholder loginTxtBox;

	@UiField Button submitRegistration;
	
	private RadioButton teacherRb, studentRb, parentRb, otherRb;
	
	private String userRole = null;
	
	@UiField(provided = true)
	SignUpCBundle res;

	private static SignUpRoleViewUiBinder uiBinder = GWT
			.create(SignUpRoleViewUiBinder.class);

	interface SignUpRoleViewUiBinder extends UiBinder<Widget, SignUpRoleView> {
	}
    /**
     * Constructor 
     * @param email
     * @param userDo
     */
	public SignUpRoleView(String email, UserDo userDo) {
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		
		teacherRb = new RadioButton("roleRadioGroup", "");
		studentRb = new RadioButton("roleRadioGroup", "");
		parentRb = new RadioButton("roleRadioGroup", "");
		otherRb = new RadioButton("roleRadioGroup", "");
		teacherRb.addClickHandler(new TeacherRbClick());
		studentRb.addClickHandler(new StudentRbClick());
		parentRb.addClickHandler(new ParentRbClick());
		otherRb.addClickHandler(new OtherRbClick());
		
		teacherRg.add(teacherRb);
		studentRg.add(studentRb);
		parentRg.add(parentRb);
		otherRg.add(otherRb);
		
		submitRegistration.getElement().setId("submitRegistration");
		loginTxtBox.addStyleName(res.css().loginTextBoxMargin());
        loginTxtBox.getElement().setAttribute("placeholder", "Username");
		lblTitle.setText(MessageProperties.GL0186 + MessageProperties.GL_SPL_EXCLAMATION);

		this.setGlassEnabled(true);
		this.show();
		this.center();
		
	}
    /**
     * 
     * @function closeSignUpRoleView 
     * 
     * @created_date : 26-Dec-2013
     * 
     * @description :  This is used to close signup role view.
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
	public void closeSignUpRoleView() {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
	}
	/**
     * 
     * @fileName : SignUpRoleView.java
     *
     * @description : This will close signup role view on cancel button click.
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
	@UiHandler("lblCancel")
	public void onCancelClick(ClickEvent clickEvent) {
		closeSignUpRoleView();
	}
	/**
     * 
     * @fileName : SignUpRoleView.java
     *
     * @description : This will set the user role to Teacher.
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
	private class TeacherRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Teacher";
		}
	}
	/**
     * 
     * @fileName : SignUpRoleView.java
     *
     * @description : This will set the user role to Student.
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
	private class StudentRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Student";
		}
	}
    /**
     * 
     * @fileName : SignUpRoleView.java
     *
     * @description : This will set the user role to Parent.
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
	private class ParentRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Parent";
		}
	}
    /**
     * 
     * @fileName : SignUpRoleView.java
     *
     * @description : This will set the user role to other.
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
	private class OtherRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Other";
		}
	}
	/**
	 * 
	 * @function onClickSubmitRegistration 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :This UIHandler is used to check user availability on submit registration button click.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("submitRegistration")
	public void onClickSubmitRegistration(ClickEvent event) {
		checkUserAvailability(loginTxtBox.getText(), "byUsername");
	}
	
	/**
	 * Checks the availability of user name, entered by User.
	 * @param userName
	 * @param type 
	 * 
	 */
	
	public void checkUserAvailability(String userName, String type) {
		AppClientFactory.getInjector().getUserService().getEmailId(userName, type, new SimpleAsyncCallback<UserDo>()
		{
				@Override
				public void onSuccess(UserDo result) {					
					checkUserNameAvailability(result);
				}
		});
	}

	/**
	 * If username exists, display alert message else proceed further. 
	 * @param result {{@link UserDo}
	 */

	public void checkUserNameAvailability(UserDo result) {
		if (result != null && result.isAvailability() && loginTxtBox.getText() != null) {
			
		}
		else
		{
			String userName = loginTxtBox.getText();
			String userRole = this.userRole;
			final UserDo userDo = AppClientFactory.getLoggedInUser();
			
			AppClientFactory.getInjector().getHomeService().updateUserDetails(userName, userRole,new AsyncCallback<Void>(){
				@Override
				public void onSuccess(Void result) {
					AppClientFactory.getInjector().getUserService().updateUserViewFlag(userDo.getGooruUId(), 1, new SimpleAsyncCallback<UserDo>() {
						@Override
						public void onSuccess(UserDo newUser) {
							UserDo userDo = AppClientFactory.getLoggedInUser();
							userDo.setViewFlag(newUser.getViewFlag());
							AppClientFactory.setLoggedInUser(userDo);
							AppClientFactory.fireEvent(new SetHeaderEvent(newUser));
							closeSignUpRoleView();
							SignUpGradeCourseView signUpGradeCourseView = new SignUpGradeCourseView(userDo);
						}
					});
					Window.enableScrolling(false);
					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
				}
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		}
	}

}
