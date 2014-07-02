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
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class ChildAccountPopup extends Composite implements MessageProperties {
	private AppPopUp appPopUp;
	private static ChildAccountPopupUiBinder uiBinder = GWT.create(ChildAccountPopupUiBinder.class);

	interface ChildAccountPopupUiBinder extends UiBinder<Widget, ChildAccountPopup> {
	}

	@UiField
	BlueButtonUc confirmationBtnUc;
	@UiField Label congrtstext,excitedText;
	
	private static final String CHILD_SUCCESS_TEXT = GL1214;

	/**
	 * Class constructor
	 */
	public ChildAccountPopup() {
		RegisterCBundle.INSTANCE.css().ensureInjected();
		appPopUp = new AppPopUp();
		appPopUp.setStyleName(RegisterCBundle.INSTANCE.css().registerPopup());
		appPopUp.setContent(CHILD_SUCCESS_TEXT, uiBinder.createAndBindUi(this));
		appPopUp.show();
		appPopUp.center();
		congrtstext.setText(GL1212);
		congrtstext.getElement().setId("lblCongrtstext");
		congrtstext.getElement().setAttribute("alt",GL1212);
		congrtstext.getElement().setAttribute("title",GL1212);
		
		excitedText.setText(GL1213);
		excitedText.getElement().setId("lblExcitedText");
		excitedText.getElement().setAttribute("alt",GL1213);
		excitedText.getElement().setAttribute("title",GL1213);
		
		confirmationBtnUc.setText(GL0190);
		confirmationBtnUc.getElement().setId("btnConfirmation");
		confirmationBtnUc.getElement().setAttribute("alt",GL0190);
		confirmationBtnUc.getElement().setAttribute("title",GL0190);
	}

	/**
	 * @return {@link BlueButtonUc} widget
	 */
	public BlueButtonUc confirmationButton() {
		return confirmationBtnUc;
	}

	/**
	 * @return {@link AppPopUp} widget
	 */
	public AppPopUp getPopupPanel() {
		return appPopUp;
	}
}
