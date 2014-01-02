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
package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AlertMessageUc.java
 *
 * @description : This class will display the  customized alert messages.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AlertMessageUc extends Composite {

	public AppPopUp appPopUp;

	@UiField
	public BlueButtonUc okButton;

	@UiField
	FlowPanel content;

	private static AlertMessageUcUiBinder uiBinder = GWT.create(AlertMessageUcUiBinder.class);

	interface AlertMessageUcUiBinder extends UiBinder<Widget, AlertMessageUc> {
	}

	/**
	 * Class constructor
	 * 
	 * @param messageHeader
	 *            header for popup
	 * @param messageContent
	 *            for popup
	 */
	public AlertMessageUc(String messageHeader, Widget messageContent) {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent(messageHeader, uiBinder.createAndBindUi(this));
		content.add(messageContent);
		appPopUp.show();
		appPopUp.center();
		okButton.getElement().setId("btnOk");
	}
	/**
	 * @function onClick 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the ok button.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("okButton")
	public void onClick(ClickEvent clickEvent) {
		hide();
	}
	/**
	 * @function hide 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to hide the popup.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void hide() {
		appPopUp.hide();
	}
}
