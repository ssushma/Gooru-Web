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
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AlmostDoneUc.java
 *
 * @description : This file Deals with Almost done popup.
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

public class AlmostDoneUc extends PopupPanel {
	

	private UserDo user=null;
	@UiField TextBox emailTxtBox,userNameTxtBox;
	@UiField ListBox roleListBox;
	@UiField HTMLEventPanel cancelButton,okButton;
	@UiField Label errorMessageForUserNameLbl,errorMessageForRoleLbl;
	@UiField HTMLPanel buttonContainer;
	/*@UiField Button okButton;*/
	@UiField
	Anchor termsAndPolicyAnr;

	@UiField
	Anchor copyRightAnr;

	private TermsAndPolicyVc termsAndPolicyVc;
	
	private CopyRightPolicyVc copyRightPolicy;

	@UiField(provided = true)
	AlmostDoneUcCBundle res;
	
	private static final String errorMessageForUserName="Please choose a username.";
	private static final String errorMessageForUserNameTxt="A username must be at least 5 characters long.";
	private static final String errorMessageForUserRole="Please select a role.";

	private static final String IS_ALREADY_AVAILABLE = " is already in use.";
	

	@UiTemplate("AlmostDoneUc.ui.xml")
	interface Binder extends UiBinder<Widget,AlmostDoneUc>
	{
		
	}
	private static final Binder binder = GWT.create(Binder.class);
	
	/**
	 * Class constructor , to create Almost done popup
	 * @param userEmail 
	 * @param user {@link UserDo}
	 */
	
	
	public AlmostDoneUc(String userEmail, UserDo user) { 
		super(false);
		this.user = user;
		this.res = AlmostDoneUcCBundle.INSTANCE;
		res.css().ensureInjected();
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);
		
		this.center();
		emailTxtBox.getElement().setId("txtEmail");
		userNameTxtBox.getElement().setId("txtUserName");
		termsAndPolicyAnr.getElement().setId("lnkTermsAndPolicy");
		copyRightAnr.getElement().setId("lnkCopyRight");
		emailTxtBox.setText(userEmail);
		emailTxtBox.setReadOnly(true);	
		errorMessageForUserNameLbl.setVisible(false);

		
		copyRightPolicy = new CopyRightPolicyVc() {
			
			@Override
			public void openParentPopup() {
				//No need to set any thing.
			}
		};
		

		/**
		 * Added click handler for showing Terms and Policy popup in footer 
		 * @param clickEvent instance of {@link ClickEvent} 
		 **/
		termsAndPolicyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
				termsAndPolicyVc = new TermsAndPolicyVc(false) {
					
					@Override
					public void openParentPopup() {
//						this.show();
					}
				};
				
				termsAndPolicyVc.show();
				termsAndPolicyVc.setSize("600px", "300px");
				termsAndPolicyVc.center();
			}
		});
		
		/**
		 * Added click handler for showing copy right popup in footer 
		 * @param clickEvent instance of {@link ClickEvent} 
		 * 
		 **/
		
		copyRightAnr.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));	
				copyRightPolicy.show();
				copyRightPolicy.setSize("600px", "300px");
				copyRightPolicy.center();				
			}
		});

		userNameTxtBox.getElement().setAttribute("maxlength","20");
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));

	}
	
	/**
	 * Added click handler to hide Almost done Popup
	 * @param clickEvent instance of {@link ClickEvent} 
	 */

	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	
	/**
	 * Added click handler for Textfield to perform basic validations.
	 * @param event instance of {@link KeyUpEvent} 
	 */

	@UiHandler("userNameTxtBox")
	public void keyUserNameTextBox(KeyUpEvent event){
		String userName=userNameTxtBox.getText();
		errorMessageForUserNameLbl.setText("");
		if(userName.length()>0){
			errorMessageForUserNameLbl.setText("");
		}
		if(userName.length()==20){
			errorMessageForUserNameLbl.setText("Your Character Limit Reached");
			errorMessageForUserNameLbl.setVisible(true);
		//	fieldValidationStaus=false;
		}else{
			errorMessageForUserNameLbl.setVisible(false);
		}

		
	}
	
	/**
	 * Added click handler to perform basic validations.
	 * @param event instance of {@link ClickEvent} 
	 */
	
	@UiHandler("roleListBox")
	public void onClickRoleListBox(ClickEvent event){
		String userRole=roleListBox.getItemText(roleListBox.getSelectedIndex());
		errorMessageForRoleLbl.setText("");
		if(!(userRole.trim().equalsIgnoreCase("what is your role?"))){
			errorMessageForRoleLbl.setText("");
		}
		
	}
	
	
	/**
	 * Added click handler for checking availability of username and to set userName and role.
	 * @param event instance of {@link ClickEvent} 
	 */
	
	@UiHandler("okButton")
	public void onOkButtonClicked(ClickEvent clickEvent)
	{
		boolean fieldValidationStaus=true;
		
		if(buttonContainer.getStyleName().equals(AlmostDoneUcCBundle.INSTANCE.css().registrationPopupBlueButton()))
		{
			
			String userRole=roleListBox.getItemText(roleListBox.getSelectedIndex());
			
			if(userNameTxtBox.getText()==null||userNameTxtBox.getText().trim().equals(""))
			{
				errorMessageForUserNameLbl.setText(errorMessageForUserName);
				errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
			}
			if(userNameTxtBox.getText().length()>0 && userNameTxtBox.getText().length()<5) 
			{
				errorMessageForUserNameLbl.setText(errorMessageForUserNameTxt);
				errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
			}

			if(userRole.trim().equalsIgnoreCase("what is your role?"))
			{
				errorMessageForRoleLbl.setText(errorMessageForUserRole);
				fieldValidationStaus=false;
			}
			if(userNameTxtBox.getText().length()==21){
					//errorMessageForUserNameLbl.setText("Your Character Limit Reached");
				//errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
				
			}
			if(userNameTxtBox.getText().length()>4 && fieldValidationStaus)
			{
				checkUserAvailability(userNameTxtBox.getText(), "byUsername");
			}
		}
	
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
		if (result != null && result.isAvailability() && userNameTxtBox.getText() != null) {
			errorMessageForUserNameLbl.setText("Oops ! " + userNameTxtBox.getText() + IS_ALREADY_AVAILABLE);
			errorMessageForUserNameLbl.setVisible(true);
			
		}
		else
		{
			String userName = userNameTxtBox.getText();
			String userRole=roleListBox.getItemText(roleListBox.getSelectedIndex());
			
			AppClientFactory.getInjector().getHomeService().updateUserDetails(userName, userRole,new AsyncCallback<Void>(){
				@Override
				public void onSuccess(Void result) {
					hide();
//					Window.enableScrolling(true);
//					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
					MixpanelUtil.Click_OK_AlmostDone();
					AppClientFactory.getInjector().getUserService().updateUserViewFlag(user.getGooruUId(), 1, new SimpleAsyncCallback<UserDo>() {
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

				@Override
				public void onFailure(Throwable caught) {
					
				}
				
			});
		}
		
	}

}
