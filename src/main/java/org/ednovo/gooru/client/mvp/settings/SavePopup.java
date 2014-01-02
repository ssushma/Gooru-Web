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
package org.ednovo.gooru.client.mvp.settings;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : SavePopup.java
 *
 * @description : This file is related to SavePopup.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SavePopup extends PopupPanel {
	
	
	@UiField Label lbOk;

	private static SavePopupUiBinder uiBinder = GWT.create(SavePopupUiBinder.class);
	
	interface SavePopupUiBinder extends UiBinder<Widget, SavePopup> {
	}
	/**
	 * Constructor to show the SavePopup.
	 */
	public SavePopup(){
		super();
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		this.show();
		this.center();
		
	}
	/**
	 * 
	 * @function OnClickOkButton 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to hide the save popup.
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
	@UiHandler("lbOk")
	public void OnClickOkButton(ClickEvent event){
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		this.hide();
		}
}
