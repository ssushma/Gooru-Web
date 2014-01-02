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

import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ThanksPopupUc.java
 *
 * @description : This file deals with Thanks popup.
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
public class ThanksPopupUc extends PopupPanel {
 
	@UiField Label lblLoginHeading, lblCongratsHeader,lblCheckYourEmail,lblWhatsNext,lblLearnHowTo,lblClose; //lblDiscover,lblOrganize,lblTeach
	
	@UiField Button btnStartUsingGooru, btnStartCreatingStudent;//btnDiscover, btnOrganize, btnTeach,
	
	@UiField HTML htmlSupport;
	
	@UiField HTMLPanel panelPopupInner;
	
	@UiField(provided = true)
	SignUpCBundle res;
	String account=null;
	String parentEmailId=null;
	String dob = null;
	String userName = null;
	String privateGooruUId = null;
	
	@UiTemplate("ThanksPopupUc.ui.xml")
	interface Binder extends UiBinder<Widget, ThanksPopupUc> {

	}

	private static final Binder binder = GWT.create(Binder.class);
	
	/**
	 * Class constructor , to create Login Popup. 
	 */
	
	public ThanksPopupUc(){
		super(false);
		this.setGlassEnabled(true);
		
        this.res = SignUpCBundle.INSTANCE;
        res.css().ensureInjected();
        add(binder.createAndBindUi(this));
        

        
        account = AppClientFactory.getPlaceManager().getRequestParameter("account") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("account") : "regular";
//        parentEmailId = AppClientFactory.getPlaceManager().getRequestParameter("parentEmailId") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("parentEmailId") : null;
        dob = AppClientFactory.getPlaceManager().getRequestParameter("dob") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("dob").replaceAll("D", "/") : null;
        userName = AppClientFactory.getPlaceManager().getRequestParameter("userName") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("userName") : null;
        privateGooruUId = AppClientFactory.getPlaceManager().getRequestParameter("privateGooruUId") !=null ? AppClientFactory.getPlaceManager().getRequestParameter("privateGooruUId") : null;
//        if (account.equalsIgnoreCase("parent")){
        	this.getElement().getStyle().setHeight(450, Unit.PX);
        	panelPopupInner.getElement().getStyle().setHeight(360, Unit.PX);
//        }else{
//        	this.getElement().getStyle().clearHeight();
//        	panelPopupInner.getElement().getStyle().clearHeight();
//        }

        setTextAndIds();
        
        setHandlers();
        
		this.center();
	}

	
	/**
	 * 
	 * @function setHandlers 
	 * 
	 * @created_date : 15-09-2013
	 * 
	 * @description : This is used to set handlers.
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

		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		
//		this.setStyleName(res.css().thanksPopup());
		this.removeStyleName("gwt-PopupPanel");
		this.getElement().getStyle().setZIndex(99999);
	
	}
	/**
	 * 
	 * @function setAccountType 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This is used to set account type.
	 * 
	 * 
	 * @parm(s) : @param type
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setAccountType(String type){
		if (type.equalsIgnoreCase("normal")){
			btnStartUsingGooru.setVisible(true);
			btnStartCreatingStudent.setVisible(false);
		}else{
			
		}
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
		lblLoginHeading.setText(MessageProperties.GL0186);
		lblCongratsHeader.setText(MessageProperties.GL0429);
		lblCheckYourEmail.setText(MessageProperties.GL0430);
		lblWhatsNext.setText(MessageProperties.GL0432);
	
		//This is not required when registered as parent.		
		btnStartUsingGooru.setText(MessageProperties.GL0431);
		//This is not required when registered as parent.
		lblLearnHowTo.setText(MessageProperties.GL0433);
		lblLearnHowTo.setVisible(false);
		lblWhatsNext.setVisible(false);
		//This is not required when registered as parent.
//		lblDiscover.setText(MessageProperties.GL0179);
		//This is not required when registered as parent.
//		lblOrganize.setText(MessageProperties.GL0180);
		//This is not required when registered as parent.
//		lblTeach.setText(MessageProperties.GL0181);
		
		//This is not required for Regular user.
		btnStartCreatingStudent.setText(MessageProperties.GL0472);
				
		btnStartUsingGooru.setVisible(account.equalsIgnoreCase("regular") ? true : false);			
//		lblWhatsNext.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		lblLearnHowTo.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		lblDiscover.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		btnDiscover.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		lblOrganize.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		btnOrganize.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		lblTeach.setVisible(account.equalsIgnoreCase("regular") ? true : false);
//		btnTeach.setVisible(account.equalsIgnoreCase("regular") ? true : false);
		
		btnStartCreatingStudent.setVisible(account.equalsIgnoreCase("parent") ? true : false);
		
		htmlSupport.setHTML(MessageProperties.GL0437);
		
		btnStartUsingGooru.getElement().setId("btnStartUsingGooru");
		btnStartCreatingStudent.getElement().setId("btnStartCreatingStudent");
	}
	/**
	 * 
	 * @function clickOnStartGooru 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description :  This will dispaly start us using gooru on StartUsingGooru button click.
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
	@UiHandler("btnStartUsingGooru")
	public void clickOnStartGooru(ClickEvent event){
		Map<String, String> map = StringUtil.splitQuery(Window.Location.getHref());
		map.remove("callback");
		map.remove("type");
		AppClientFactory.getPlaceManager().revealPlace(AppClientFactory.getCurrentPlaceToken(), map);
		hide();
	}
	/**
	 * 
	 * @function clickOnClose 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This is used to close popup.
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
	@UiHandler("lblClose")
	public void clickOnClose(ClickEvent event){
		if (account.equalsIgnoreCase("parent")){ 
			startCreatingStudent();
		}
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
	}
//	@UiHandler("btnDiscover")
//	public void clickOnDiscoverBtn(ClickEvent event){
//		
//	}
//	@UiHandler("btnOrganize")
//	public void clickOnOrganizeBtn(ClickEvent event){
//		
//	}
//	@UiHandler("btnTeach")
//	public void clickOnTeachBtn(ClickEvent event){
//		
//	}
	/**
	 * 
	 * @function clickOnStartCreatingStudent 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This is used to call create student.
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
	@UiHandler("btnStartCreatingStudent")
	public void clickOnStartCreatingStudent(ClickEvent event){
		hide();
		startCreatingStudent();
	}
	/**
	 * 
	 * @function clickOnStartCreatingStudent 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This is used to create student.
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
	private void startCreatingStudent(){
		String externalId = AppClientFactory.getLoggedInUser().getExternalId();
		String email = AppClientFactory.getLoggedInUser().getEmailId();
		
		parentEmailId = externalId != null ? externalId : email != null ? email : null;
		privateGooruUId = AppClientFactory.getLoggedInUser().getGooruUId();
		
		AppClientFactory.getInjector().getAppService().v2Signout(new SimpleAsyncCallback<UserDo>() {

			@Override
			public void onSuccess(UserDo userDo) {
				AppClientFactory.setLoggedInUser(userDo);
				AppClientFactory.fireEvent(new SetHeaderEvent(userDo));
				StudentSignUpUc studentSignUp = new StudentSignUpUc(parentEmailId, userName, dob, privateGooruUId);
				studentSignUp.center();
				studentSignUp.show();
			}
		});
	}
}

