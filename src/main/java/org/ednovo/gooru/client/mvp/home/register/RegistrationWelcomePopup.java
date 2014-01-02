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
package org.ednovo.gooru.client.mvp.home.register;

import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : RegistrationWelcomePopup.java
 *
 * @description :  Creates welcome popup after successful registration 
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
public class RegistrationWelcomePopup extends Composite  {

	private static RegistrationWelcomePopupUiBinder uiBinder = GWT.create(RegistrationWelcomePopupUiBinder.class);

	interface RegistrationWelcomePopupUiBinder extends UiBinder<Widget, RegistrationWelcomePopup> {
	}
	@UiField
	BlueButtonUc registerWelcomeUc;
	
	private AppPopUp appPopUp;
	
	private static final String READY_TO_USE_GOORU = "You're now ready to use Gooru!";

	/**
	 * Class constructor, creates welcome popup after successful registration 
	 */
	public RegistrationWelcomePopup() {
		RegisterCBundle.INSTANCE.css().ensureInjected();
		appPopUp = new AppPopUp();
		appPopUp.setContent(READY_TO_USE_GOORU, uiBinder.createAndBindUi(this));
		appPopUp.show();
		appPopUp.center();
		registerWelcomeUc.getElement().setId("btnRegisterWelcome");
	}
	/**
	 * It will return the representation of a view as the widget
	 */
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	/**
	 * @return {@link BlueButtonUc} widget
	 */
	public BlueButtonUc getConfirmButton() {
		return registerWelcomeUc; 
	}
	
	/**
	 * @return {@link AppPopUp} widget
	 */
	public AppPopUp getPopupPanel() { 
		return appPopUp;
	}

}
