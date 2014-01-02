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

import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
/**
 * @fileName : ValidTextUc.java
 *
 * @description : This class is used to validate textbox.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ValidTextUc extends FlowPanel {
	private TextBox textBox;
	private ErrorLabelUc errorLabel;
	
	/**
	 * Class constructor
	 */
	public ValidTextUc() {
		RegisterCBundle.INSTANCE.css().ensureInjected();
		textBox = new TextBox();
		this.add(textBox);
		textBox.addFocusHandler(new OnTextBoxFocus());
		errorLabel = new ErrorLabelUc();
		addTextStyle(RegisterCBundle.INSTANCE.css().userRegistrationText());
		errorLabel.setStyleName(RegisterCBundle.INSTANCE.css().userErrorLabel());
		this.add(errorLabel);
		setErrorVisible(false);
	}
	/**
	 * This inner class will hanles the focus event.
	 */
	private class OnTextBoxFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			errorLabel.setVisible(false);
			addTextStyle(RegisterCBundle.INSTANCE.css().userRegistrationText());
		}
	}
	/**
	 * This will set the style name.
	 */
	public void addTextStyle(String textStyle) {
		textBox.setStyleName(textStyle);
	}

	/*public void removeTextstyle(String textStyle) {
		textBox.removeStyleName(textStyle);
	}*/
	/**
	 * This will set the error visiblity
	 */
	public void setErrorVisible(boolean visible) {
		errorLabel.setVisible(visible);
	}
	/**
	 * This will get the user text
	 */
	public String getUserText() {
		return textBox.getText();
	}
	/**
	 * This will set the user text
	 */
	public void setUserText(String userText) {
		this.textBox.setText(userText);
	}
	/**
	 * This will get the error text
	 */
	public String getErrText() {
		return errorLabel.getText();
	}
	/**
	 * This will set the error text
	 */
	public void setErrText(String errText) {
		this.errorLabel.setText(errText);
	}
}
