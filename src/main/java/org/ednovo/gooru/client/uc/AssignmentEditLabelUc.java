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

import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AssignmentEditLabelUc.java
 *
 * @description : This class is used to display the assignment edit label.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AssignmentEditLabelUc extends Composite implements
		HasValue<String> {

	private static AssignmentEditLabelUcUiBinder uiBinder = GWT
			.create(AssignmentEditLabelUcUiBinder.class);

	interface AssignmentEditLabelUcUiBinder extends
			UiBinder<Widget, AssignmentEditLabelUc> {
	}

	@UiField
	protected Label editLabel;

	@UiField
	protected DeckPanel deckPanel;

	@UiField
	protected TextBox editTextBox;

	@UiField
	protected FocusPanel focusPanel;

	protected String placeholder = "";

	protected String text;
	@UiField Label errorLabel;

	// static boolean pencilVisiblity = true;

	@UiField(provided = true)
	UcCBundle res;
	/**
	 * Class constructor.
	 */
	public AssignmentEditLabelUc() {
		this.res = UcCBundle.INSTANCE;
		initWidget(uiBinder.createAndBindUi(this));
		errorLabel.setText(MessageProperties.GL0173);
		errorLabel.setVisible(false);
		deckPanel.showWidget(0);

		editTextBox.addKeyUpHandler(new ValidateConfirmText());

	}
	/**
	 * This will handle the key up hanler.
	 */
	private class ValidateConfirmText implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			checkCharacterLimit(editTextBox.getText());
			errorLabel.setVisible(false);
		}
	}

	/**
	 * Change to editable view
	 */
	public void switchToEdit() {

		// pencilVisiblity=false;
		// Element
		// editButtonImage=(Element)getWidget().getParent().getParent().getElement().getLastChild();
		// editButtonImage.getStyle().setDisplay(Display.NONE);
		// Element
		// characterlimit=(Element)getWidget().getParent().getParent().getParent().getParent().getParent().getElement().getLastChild();
		// characterlimit.getFirstChildElement().getStyle().setOpacity(1);

		if (deckPanel.getVisibleWidget() == 1)
			return;
		editTextBox.setText(getValue());	
		deckPanel.showWidget(1);
		editTextBox.setFocus(true);
		editTextBox.addStyleName("shelfEditTitleForAssignment");
		editTextBox.setMaxLength(50);
		errorLabel.setVisible(false);
		editTextBox.getElement().setId("txtEdit");

	}

	/**
	 * Change to label
	 */
	public void switchToLabel() {

		if (deckPanel.getVisibleWidget() == 0)
			return;

		if (editTextBox.getText().trim().length() > 0) {
			setValue(editTextBox.getText(), true); // fires events, too
		}else {
			errorLabel.setVisible(true);
//			new AlertContentUc("Oops", "Title Shouldn't be empty!");
			//checkEmptyTitle(text);
			return;
		}
		if ((getText() != null && text.trim().length() > 0)) {
			deckPanel.showWidget(0);
			setText(editTextBox.getText());
			onEditDisabled(editTextBox.getText());
			errorLabel.setVisible(false);
		}

		String text = getValue();

		if ((getText() != null && text.trim().length() > 0)) {
			deckPanel.showWidget(0);
			setText(editTextBox.getText());
			onEditDisabled(editTextBox.getText());
			errorLabel.setVisible(false);
		}

	}

	public void cancel() {
		deckPanel.showWidget(0);
		editTextBox.setText(editLabel.getText());
		errorLabel.setVisible(false);
	}

	// Override this method to catch on blur
	/**
	 * @param text
	 */
	public void onEditDisabled(String text) {

	}

	// Override this method to catch on blur
	/**
	 * @param text
	 */
	public void checkCharacterLimit(String text) {

	}
	/**
	 * 
	 * @function checkEmptyTitle 
	 * 
	 * @created_date : Aug 22, 2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param text
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	/*public void checkEmptyTitle(String text){
		
	}*/

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public String getValue() {
		return editTextBox.getText();
	}

	@Override
	public void setValue(String value) {

		editLabel.setText(value.length() > 50 ? value.substring(0, 50) + "..."
				: value);
		editTextBox.setText(value);
	}

	/**
	 * @return placeholder
	 */
	public String getPlaceholder() {
		return placeholder;
	}
	/**
	 * set the  placeholder
	 */
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	/**
	 * get the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * set the text
	 */
	public void setText(String text) {
		this.text = text;
		setValue(text);
	}
	/**
	 * set the values.
	 */
	@Override
	public void setValue(String value, boolean fireEvents) {

		if (fireEvents)
			ValueChangeEvent.fireIfNotEqual(this, getValue(), value);
		setValue(value);
	}
	/**
	 * This will return the textbox source.
	 */
	public TextBox getTextBoxSource() {
		return editTextBox;
	}

	/*
	 * public static boolean getPencilVisiblity() { return pencilVisiblity; }
	 */

}
