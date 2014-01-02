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
/**
 * 
*/
package org.ednovo.gooru.client.uc;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AlertForgetContentUc.java
 *
 * @description : This is customized alert forget content class.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AlertForgetContentUc extends PopupPanel {
	
	@UiField HTMLEventPanel cancelButton,gmailButton;
	
	@UiField(provided = true)
	ForgetPopUpCBundle res;
		
	private static final String FORGET_ERROR ="Looks like this email is tied with Google!";
	
	private static final String LOGIN_MESSAGE="Sign in through this link";
	
	@UiField Label suggestionMessage,errorMessage;
	
	@UiTemplate("AlertForgetContentUc.ui.xml")
	interface Binder extends UiBinder<Widget, AlertForgetContentUc> {

	}	
	private static final Binder binder = GWT.create(Binder.class);
	/**
	 * Class constructor.
	 */
	public AlertForgetContentUc(){
		
		this.res = ForgetPopUpCBundle.INSTANCE;
		res.css().ensureInjected();
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.setSize("475px", "225px");
		this.center();
		suggestionMessage.setText(LOGIN_MESSAGE);
		errorMessage.setText(FORGET_ERROR);
		
		
	}
	/**
	 * @function onCancelClicked 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will hanle the click event on the cancel button.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		//this.setVisible(false);
		hide();

	}
	/**
	 * @function onGmailButtonClicked 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the gmail button click.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("gmailButton")
	public void onGmailButtonClicked(ClickEvent clickEvent)
	{
		String callBack = Window.Location.getHref();
		AppClientFactory.getInjector().getSearchService().getGoogleSignin(callBack, new SimpleAsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				Window.Location.replace(result);
			
			}
		});
	}
}

