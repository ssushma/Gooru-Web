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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
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

public class SignUpRoleView extends PopupPanel implements MessageProperties {

	@UiField Label lblTitle, lblCancel,teacherLbl,studentLbl,parentLbl,otherLbl;
	
	@UiField HTMLPanel teacherRg, studentRg, parentRg, otherRg,oneMoreStepText,pleaseFillLbl;
	
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
		
		oneMoreStepText.getElement().setInnerText(GL0898+GL_SPL_EXCLAMATION);
		oneMoreStepText.getElement().setId("pnlOneMoreStepText");
		oneMoreStepText.getElement().setAttribute("alt",GL0898);
		oneMoreStepText.getElement().setAttribute("title",GL0898);
		
		teacherLbl.setText(GL0416);
		teacherLbl.getElement().setId("lblTeacher");
		teacherLbl.getElement().setAttribute("alt",GL0416);
		teacherLbl.getElement().setAttribute("title",GL0416);
		
		studentLbl.setText(GL0417);
		studentLbl.getElement().setId("lblStudent");
		studentLbl.getElement().setAttribute("alt",GL0417);
		studentLbl.getElement().setAttribute("title",GL0417);
		
		parentLbl.setText(GL0418);
		parentLbl.getElement().setId("lblParent");
		parentLbl.getElement().setAttribute("alt",GL0418);
		parentLbl.getElement().setAttribute("title",GL0418);
		
		otherLbl.setText(GL0419);
		otherLbl.getElement().setId("lblOther");
		otherLbl.getElement().setAttribute("alt",GL0419);
		otherLbl.getElement().setAttribute("title",GL0419);
		
		submitRegistration.setText(GL0486);
		submitRegistration.getElement().setId("pnlsubmitRegistration");
		submitRegistration.getElement().setAttribute("alt",GL0486);
		submitRegistration.getElement().setAttribute("title",GL0486);
		
		teacherRg.add(teacherRb);
		teacherRg.getElement().setId("pnlTeacherRg");
		teacherRg.getElement().setAttribute("alt","");
		teacherRg.getElement().setAttribute("title","");
		
		studentRg.add(studentRb);
		studentRg.getElement().setId("pnlStudentRg");
		studentRg.getElement().setAttribute("alt","");
		studentRg.getElement().setAttribute("title","");
		
		parentRg.add(parentRb);
		parentRg.getElement().setId("pnlParentRg");
		parentRg.getElement().setAttribute("alt","");
		parentRg.getElement().setAttribute("title","");
		
		otherRg.add(otherRb);
		otherRg.getElement().setId("pnlOtherRg");
		otherRg.getElement().setAttribute("alt","");
		otherRg.getElement().setAttribute("title","");
		
		
		
		loginTxtBox.addStyleName(res.css().loginTextBoxMargin());
        loginTxtBox.getElement().setAttribute("placeholder", GL0423);
        loginTxtBox.getElement().setId("txtLogin");
        loginTxtBox.getElement().setAttribute("alt","");
        loginTxtBox.getElement().setAttribute("title","");
        
      
        pleaseFillLbl.getElement().setInnerText(GL0953);
        pleaseFillLbl.getElement().setId("pnlOneMoreStepText");
		pleaseFillLbl.getElement().setAttribute("alt",GL0953);
		pleaseFillLbl.getElement().setAttribute("title",GL0953);
		
        lblTitle.setText(GL0186 + GL_SPL_EXCLAMATION);
		lblTitle.getElement().setId("lblTitle");
		lblTitle.getElement().setAttribute("alt",GL0186);
		lblTitle.getElement().setAttribute("title",GL0186);
		
		lblCancel.getElement().setId("lblCancel");
		lblCancel.getElement().setAttribute("alt","");
		lblCancel.getElement().setAttribute("title","");
		

		this.setGlassEnabled(true);
		this.show();
		this.center();
		
	}

	@UiHandler("lblCancel")
	public void onCancelClick(ClickEvent clickEvent) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
	}

	private class TeacherRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Teacher";
		}
	}

	private class StudentRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Student";
		}
	}

	private class ParentRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Parent";
		}
	}

	private class OtherRbClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			userRole = "Other";
		}
	}

	@UiHandler("submitRegistration")
	public void onClickSubmitRegistration(ClickEvent event) {
		checkUserAvailability(loginTxtBox.getText(), "username");
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
			
			AppClientFactory.getInjector().getHomeService().updateUserDetails(userName, userRole,new SimpleAsyncCallback<Void>(){
				@Override
				public void onSuccess(Void result) {
					AppClientFactory.getInjector().getUserService().updateUserViewFlag(userDo.getGooruUId(), 1, new SimpleAsyncCallback<UserDo>() {
						@Override
						public void onSuccess(UserDo newUser) {
							UserDo userDo = AppClientFactory.getLoggedInUser();
							userDo.setViewFlag(newUser.getViewFlag());
							AppClientFactory.setLoggedInUser(userDo);
							AppClientFactory.fireEvent(new SetHeaderEvent(newUser));  
						}
					});
					Window.enableScrolling(false);
					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
				}
			});
		}
		
	}

}
