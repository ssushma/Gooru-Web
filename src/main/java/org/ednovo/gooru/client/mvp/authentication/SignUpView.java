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

import java.util.Date;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.InvokeLoginEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.uc.CreateAccountUc;
import org.ednovo.gooru.client.mvp.authentication.uc.LeaveRegistrationPopUpUc;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * 
 * @fileName : SignUpView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Aug 30, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class SignUpView extends PopupViewWithUiHandlers<SignUpUiHandlers> implements IsSignUpView, MessageProperties {

	private static SignUpViewUiBinder uiBinder = GWT.create(SignUpViewUiBinder.class);

	protected AppPopUp appPopUp;
		
	interface SignUpViewUiBinder extends UiBinder<Widget, SignUpView> {
	}

	@UiField Label lblTitle,lblJoinGooruCommunity,lblDescription,lblWhyWithGoogle,lblQuestionMark,lblPopupWhyWithGoogle,lblParentInfo;
	
	@UiField Label lblPopupWhyWithGoogleDesc,lblOr,lblDontHaveGoogleAccount,lblAlreadyHaveAccount,lblCancel;
	
	@UiField Button btnSignUpWithGoogle;
	
	@UiField Anchor  achSignUpWithEmail,achClickToLogin;
	
	@UiField HTMLPanel panelSignUp, panelUserInfo;
	
	CreateAccountUc createAccount = null;
	
	String account = null;
	String childDob = null;
	String childUserName = null;
	
	/**
	 * Class constructor, creates popup , focus and blur events
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public SignUpView(EventBus eventBus) {
		super(eventBus);
		SignUpCBundle.INSTANCE.css().ensureInjected();

		appPopUp = new AppPopUp(GL0697);
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		
		
		
	}
	
	public void displayPopUp(int displayScreen){
/*		appPopUp = new AppPopUp("NoHeader");
		appPopUp.setContent(uiBinder.createAndBindUi(this));*/
		
		appPopUp.addStyleName(SignUpCBundle.INSTANCE.css().popupBackground());
		
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		
		
		appPopUp.setGlassStyleName(SignUpCBundle.INSTANCE.css().signUpPopUpGlassCss());

		
		appPopUp.center();
		
		setUiAndIds();
		showPanelById(displayScreen);
		
		account = AppClientFactory.getPlaceManager().getRequestParameter("account") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("account")  :  null ;
		childDob = AppClientFactory.getPlaceManager().getRequestParameter("dob") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("dob")  :  null ;
		childUserName = AppClientFactory.getPlaceManager().getRequestParameter("userName") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("userName")  :  null ;
		
	}

	private void setUiAndIds(){
		lblTitle.setText(GL0186 +GL_SPL_EXCLAMATION);
		lblJoinGooruCommunity.setText(GL0400);
		lblDescription.setText(GL0401);
		lblParentInfo.setVisible(false);
		lblParentInfo.setText(GL0470);
		
		btnSignUpWithGoogle.setText(GL0402);
		
		lblWhyWithGoogle.setText(GL0403);
		lblQuestionMark.setText(GL_SPL_QUESTION);
		lblPopupWhyWithGoogle.setText(GL0403 + GL_SPL_QUESTION);
	
		lblPopupWhyWithGoogleDesc.setText(GL0404);
		lblOr.setText(GL0209);
		lblDontHaveGoogleAccount.setText(GL0405 +GL_SPL_QUESTION);
		lblAlreadyHaveAccount.setText(GL0407 + GL_SPL_QUESTION);
		
		achSignUpWithEmail.setText(GL0406);
		achClickToLogin.setText(GL0408);
		
		btnSignUpWithGoogle.getElement().setId("btnSignUpWithGoogle");
	}
	
	
	private void showPanelById(int id){
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		
		panelSignUp.setVisible(id ==1 || id ==3  ? true : false);
		panelUserInfo.setVisible(id ==2 ? true : false);
		
		if (id==2){
			openCreateUser();
			lblJoinGooruCommunity.setVisible(true);
			lblDescription.setVisible(true);
			lblParentInfo.setVisible(false);
		}else if (id==3){
			lblJoinGooruCommunity.setVisible(false);
			lblDescription.setVisible(false);
			lblParentInfo.setVisible(true);
		}
	}
	
	//Ui Handlers
	
	/**
	 * Hide the popup and redirect to home page while clicking cancel
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("lblCancel")
	public void onCancelClick(ClickEvent clickEvent) {
		MixpanelUtil.close_signUp();
		
		if (AppClientFactory.getPlaceManager().getRequestParameter("type") !=null && !AppClientFactory.getPlaceManager().getRequestParameter("type").equalsIgnoreCase("1")){
			LeaveRegistrationPopUpUc leaveRegistrationPopUpUc=new LeaveRegistrationPopUpUc(GL0074.toLowerCase(),"","","");
			leaveRegistrationPopUpUc.show();
		}else{
			Map<String, String> map = StringUtil.splitQuery(Window.Location.getHref());
			if(map.containsKey("query"))
			{
				String queryVal = AppClientFactory.getPlaceManager().getRequestParameter("query");
				queryVal = queryVal.replace("+", " ");
				map.put("query", queryVal);
			}
			if(map.containsKey("flt.subjectName"))
			{
				String subjectNameVal = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
				/*String subjectNameVal = map.get("flt.subjectName");
				subjectNameVal = subjectNameVal.replaceAll("%5C1", "&");
				try
				{
					subjectNameVal = URL.decodeQueryString(subjectNameVal);
				}
				catch(Exception ex)
				{
					
				}*/
				subjectNameVal = subjectNameVal.replace("+", " ");
				map.put("flt.subjectName", subjectNameVal);
			}
			map.remove("callback");
			map.remove("type");
			map.remove("rp");
			
			if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.COLLECTION_PLAY)||
					AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.STUDENT)){
				
			} else {
				map.remove("id");
			}
			
			if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.COLLECTION_PLAY)||AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
				PlaceRequest placeRequest = new PlaceRequest(AppClientFactory.getCurrentPlaceToken()); 
				if (map != null) {
					for (String key : map.keySet()) {
						placeRequest = placeRequest.with(key, map.get(key));
					}
				}
				AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
			}else{
				AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), map);
				Window.enableScrolling(true);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
			}
		}
		appPopUp.hide();
	}

	@UiHandler("btnSignUpWithGoogle")
	public void onClickBtnGoogle(ClickEvent clickEvent){
		String callBack = Window.Location.getHref();
		Map<String, String> mapParms = StringUtil.splitQuery(callBack);
		if (!callBack.contains("parent")){
			mapParms.remove("callback");
			mapParms.remove("type");
			mapParms.remove("rp");
			mapParms.remove("id");
		}else{
			mapParms.put("callback", "registerChild");
		}
		AppClientFactory.getInjector().getSearchService().getGoogleSignin(AppClientFactory.getCurrentPlaceToken(),  mapParms, new SimpleAsyncCallback<String>() {
		
			@Override
			public void onSuccess(String gConnectUrl) {
				MixpanelUtil.Click_Gmail_SignIn("LoginPopup");
				Window.Location.replace(gConnectUrl);
			}
		});
	}
	
	@UiHandler("achClickToLogin")
	public void onClickAlreadyHaveAccount(ClickEvent clickEvent){
		Map<String, String> map = StringUtil.splitQuery(Window.Location.getHref());
		if(map.containsKey("query"))
		{
			String queryVal = AppClientFactory.getPlaceManager().getRequestParameter("query");
			map.put("query", queryVal);
		}
		if(map.containsKey("flt.subjectName"))
		{
			String subjectNameVal = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
			map.put("flt.subjectName", subjectNameVal);
		}
		map.remove("callback");
		map.remove("type");
		AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), map);
		appPopUp.hide();
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String tabView=AppClientFactory.getPlaceManager().getRequestParameter("tab",null);
		if(tabView != null)
		{
		if((viewToken.equals(PlaceTokens.COLLECTION_PLAY)||viewToken.equals(PlaceTokens.PREVIEW_PLAY)||viewToken.equals(PlaceTokens.RESOURCE_PLAY))&&
				(tabView!=null)&&(tabView.equals("add")||tabView.equals("flag"))){
			
		}else{
			AppClientFactory.fireEvent(new InvokeLoginEvent());
		}
		}
		else
		{
			AppClientFactory.fireEvent(new InvokeLoginEvent());
		}
	}
	
	@UiHandler("achSignUpWithEmail")
	public void onClickSignUpWithEmail(ClickEvent clickEvent){
		MixpanelUtil.sign_up_with_your_email();
		hide();
		Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
		if(params.containsKey("query"))
		{
			String queryVal = AppClientFactory.getPlaceManager().getRequestParameter("query");
			params.put("query", queryVal);
		}
		if(params.containsKey("flt.subjectName"))
		{
			String subjectNameVal = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
			params.put("flt.subjectName", subjectNameVal);
		}
		params.put("type", "2");
		params.put("callback", "signup");
		if (account!=null && lblParentInfo.isVisible()){
			params.put("account", account);
		}
		if (childDob!=null){
			params.put("dob", childDob);
		}
		if (childUserName!=null){
			params.put("userName", childUserName);
		}
		AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), params );
	}

	private void openCreateUser(){
		createAccount = new CreateAccountUc() {
			
			private TermsAndPolicyVc termsAndPolicyVc;
			private CopyRightPolicyVc copyRightPolicy;
			private TermsOfUse termsOfUse;

			@Override
			public void OpenTermsPrivacy() {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				appPopUp.hide();
				termsAndPolicyVc = new TermsAndPolicyVc(false) {
					
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						appPopUp.show();
					}
				};
				termsAndPolicyVc.show();
				termsAndPolicyVc.setSize("902px", "300px");
				termsAndPolicyVc.center();
				termsAndPolicyVc.getElement().getStyle().setZIndex(99999);//To display the view in collection player.
			}
			
			@Override
			public void OpenCopyRight() {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				appPopUp.hide();
				copyRightPolicy = new CopyRightPolicyVc() {
					
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						appPopUp.show();
					}
				};
				copyRightPolicy.show();
				copyRightPolicy.setSize("902px", "300px");
				copyRightPolicy.center();	
				copyRightPolicy.getElement().getStyle().setZIndex(99999);//To display the view in collection player.
			}
			@Override
			public void OpenPrivacy() {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				appPopUp.hide();
				termsOfUse=new TermsOfUse(){

					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						appPopUp.show();
					}
					
				};
				termsOfUse.show();
				termsOfUse.setSize("902px", "300px");
				termsOfUse.center();
				termsOfUse.getElement().getStyle().setZIndex(99999);//To display the view in collection player.
			
			}
			//Send data to create user.
			@Override
			public void CreateUser(String data, String loginData) {
				getUiHandlers().CreateUser(data, loginData);
			}

			@Override
			public void closePoup() {
				appPopUp.hide();
				
			}
		};
		panelUserInfo.clear();
		panelUserInfo.add(createAccount);
		
	}
	
	
	public void toggleButtons(){
		createAccount.toggleButtons();
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub

	}
	private int getAge(Date birthDate){
		if(birthDate!=null) {
			long ageInMillis = new Date().getTime() - birthDate.getTime();
			Date age = new Date(ageInMillis);
			return age.getYear()- 70;
		} else {
			return 0;
		}
	}
}
