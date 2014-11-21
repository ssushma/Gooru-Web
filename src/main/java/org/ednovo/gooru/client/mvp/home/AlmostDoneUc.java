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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */


public class AlmostDoneUc extends PopupPanel{
	

	private UserDo user=null;
	@UiField TextBox emailTxtBox,userNameTxtBox;
	@UiField ListBox roleListBox;
	@UiField HTMLEventPanel cancelButton,okButton;
	@UiField Label errorMessageForUserNameLbl,errorMessageForRoleLbl,uNameLbl,agreeText,andText,gooruText;
	@UiField HTMLPanel buttonContainer,almostDoneText,fillOutText,emailText,roleText;
	/*@UiField Button okButton;*/
	@UiField
	Anchor termsAndPolicyAnr;

	@UiField
	Anchor copyRightAnr;

	private TermsAndPolicyVc termsAndPolicyVc;
	
	private CopyRightPolicyVc copyRightPolicy;

	@UiField(provided = true)
	AlmostDoneUcCBundle res;
	
//	private static final String errorMessageForUserName=i18n.GL1284+i18n.GL_SPL_FULLSTOP;
//	private static final String errorMessageForUserNameTxt=i18n.GL1285+i18n.GL_SPL_FULLSTOP;
//	private static final String errorMessageForUserRole=i18n.GL1146;

//	private static final String IS_ALREADY_AVAILABLE = ""+i18n.GL1286+i18n.GL_SPL_FULLSTOP;
	

	@UiTemplate("AlmostDoneUc.ui.xml")
	interface Binder extends UiBinder<Widget,AlmostDoneUc>
	{
		
	}
	private static final Binder binder = GWT.create(Binder.class);
	private MessageProperties i18n = GWT.create(MessageProperties.class);
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
		almostDoneText.getElement().setInnerText(i18n.GL1279()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP());
		almostDoneText.getElement().setId("pnlAlmostDoneText");
		almostDoneText.getElement().setAttribute("alt",i18n.GL1279()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP());
		almostDoneText.getElement().setAttribute("title",i18n.GL1279()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP());
		
		fillOutText.getElement().setInnerText(i18n.GL1280()+i18n.GL_SPL_SEMICOLON()+" ");
		fillOutText.getElement().setId("pnlFillOutText");
		fillOutText.getElement().setAttribute("alt",i18n.GL1280()+i18n.GL_SPL_SEMICOLON()+" ");
		fillOutText.getElement().setAttribute("title",i18n.GL1280()+i18n.GL_SPL_SEMICOLON()+" ");
		
		emailTxtBox.getElement().setId("txtEmail");
		StringUtil.setAttributes(emailTxtBox, true);
		cancelButton.getElement().setId("epnlCancelButton");
		
		emailText.getElement().setInnerText(i18n.GL0212());
		emailText.getElement().setId("pnlEmailText");
		emailText.getElement().setAttribute("alt",i18n.GL0212());
		emailText.getElement().setAttribute("title",i18n.GL0212());
		
		uNameLbl.getElement().setInnerText(i18n.GL0423());
		uNameLbl.getElement().setId("lblUName");
		uNameLbl.getElement().setAttribute("alt",i18n.GL0423());
		uNameLbl.getElement().setAttribute("title",i18n.GL0423());
		
		roleText.getElement().setInnerText(i18n.GL1281());
		roleText.getElement().setId("pnlRoleText");
		roleText.getElement().setAttribute("alt",i18n.GL1281());
		roleText.getElement().setAttribute("title",i18n.GL1281());
		
		roleListBox.getElement().setId("lbRoleListBox");
		roleListBox.setItemText(0, i18n.GL1282()+i18n.GL_SPL_QUESTION());
		roleListBox.setItemText(1, i18n.GL0417());
		roleListBox.setItemText(2, i18n.GL0416());
		roleListBox.setItemText(3, i18n.GL0418());
		roleListBox.setItemText(4, i18n.GL0419());
		agreeText.setText(i18n.GL1283());
		agreeText.getElement().setId("lblAgreeText");
		agreeText.getElement().setAttribute("alt",i18n.GL1283());
		agreeText.getElement().setAttribute("title",i18n.GL1283());
		
		termsAndPolicyAnr.setText(i18n.GL0297()+" "+i18n.GL_GRR_AND()+" "+i18n.GL0452());
		termsAndPolicyAnr.getElement().setAttribute("alt",i18n.GL0297()+" "+i18n.GL_GRR_AND()+" "+i18n.GL0452());
		termsAndPolicyAnr.getElement().setAttribute("title",i18n.GL0297()+" "+i18n.GL_GRR_AND()+" "+i18n.GL0452());
		
		andText.setText(i18n.GL_GRR_AND()+" "+i18n.GL_GRR_THE());
		copyRightAnr.setText(i18n.GL0421());
		copyRightAnr.getElement().setAttribute("alt",i18n.GL0421());
		copyRightAnr.getElement().setAttribute("title",i18n.GL0421());
		
		gooruText.setText(i18n.GL_GRR_OF()+" "+i18n.GL0733()+i18n.GL_SPL_FULLSTOP());
		okButton.getElement().setInnerText(i18n.GL0190());
		userNameTxtBox.getElement().setId("txtUserName");
		StringUtil.setAttributes(userNameTxtBox, true);
		termsAndPolicyAnr.getElement().setId("lnkTermsAndPolicy");
		buttonContainer.getElement().setId("pnlButtonContainer");
		copyRightAnr.getElement().setId("lnkCopyRight");
		errorMessageForUserNameLbl.getElement().setId("errlblForUserName");
		errorMessageForRoleLbl.getElement().setId("errlblForRole");
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
			errorMessageForUserNameLbl.setText(i18n.GL1097()+" "+i18n.GL0143());
			errorMessageForUserNameLbl.getElement().setAttribute("alt",i18n.GL1097()+" "+i18n.GL0143());
			errorMessageForUserNameLbl.getElement().setAttribute("title",i18n.GL1097()+" "+i18n.GL0143());
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
				errorMessageForUserNameLbl.setText(i18n.GL1284()+i18n.GL_SPL_FULLSTOP());
				errorMessageForUserNameLbl.getElement().setAttribute("alt",i18n.GL1284()+i18n.GL_SPL_FULLSTOP());
				errorMessageForUserNameLbl.getElement().setAttribute("title",i18n.GL1284()+i18n.GL_SPL_FULLSTOP());
				errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
			}
			if(userNameTxtBox.getText().length()>0 && userNameTxtBox.getText().length()<5) 
			{
				errorMessageForUserNameLbl.setText(i18n.GL1285()+i18n.GL_SPL_FULLSTOP());
				errorMessageForUserNameLbl.getElement().setAttribute("alt",i18n.GL1285()+i18n.GL_SPL_FULLSTOP());
				errorMessageForUserNameLbl.getElement().setAttribute("title",i18n.GL1285()+i18n.GL_SPL_FULLSTOP());
				
				errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
			}

			if(userRole.trim().equalsIgnoreCase("what is your role?"))
			{
				errorMessageForRoleLbl.setText(i18n.GL1146());
				errorMessageForRoleLbl.getElement().setAttribute("alt",i18n.GL1146());
				errorMessageForRoleLbl.getElement().setAttribute("title",i18n.GL1146());
				fieldValidationStaus=false;
			}
			if(userNameTxtBox.getText().length()==21){
					//errorMessageForUserNameLbl.setText("Your Character Limit Reached");
				//errorMessageForUserNameLbl.setVisible(true);
				fieldValidationStaus=false;
				
			}
			if(userNameTxtBox.getText().length()>4 && fieldValidationStaus)
			{
				checkUserAvailability(userNameTxtBox.getText(), "username");
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
			errorMessageForUserNameLbl.setText(i18n.GL0061() + userNameTxtBox.getText() + ""+i18n.GL1286()+i18n.GL_SPL_FULLSTOP());
			errorMessageForUserNameLbl.getElement().setAttribute("alt",i18n.GL0061() + userNameTxtBox.getText() + ""+i18n.GL1286()+i18n.GL_SPL_FULLSTOP());
			errorMessageForUserNameLbl.getElement().setAttribute("title",i18n.GL0061() + userNameTxtBox.getText() + ""+i18n.GL1286()+i18n.GL_SPL_FULLSTOP());
			errorMessageForUserNameLbl.setVisible(true);
			
		}
		else
		{
			String userName = userNameTxtBox.getText();
			String userRole=roleListBox.getItemText(roleListBox.getSelectedIndex());
			
			AppClientFactory.getInjector().getHomeService().updateUserDetails(userName, userRole,new SimpleAsyncCallback<Void>(){
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
			});
		}
		
	}

}
