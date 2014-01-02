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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : ProfilePageDescriptionEditUc.java
 *
 * @description : This class is used to edit the profile page description.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ProfilePageDescriptionEditUc extends Composite implements
		HasValue<String> {

	private static ProfileBiographyEditUCUiBinder uiBinder = GWT
			.create(ProfileBiographyEditUCUiBinder.class);

	interface ProfileBiographyEditUCUiBinder extends
			UiBinder<Widget, ProfilePageDescriptionEditUc> {
	}

	@UiField
	protected HTMLPanel editLabel;

	@UiField
	protected DeckPanel deckPanel;

	@UiField
	protected TextArea editTextBox;

	@UiField
	protected FocusPanel focusPanel;
	@UiField Label errorLabel;
	protected String placeholder = "";

	private Label biographyLabel;
	private Label biographyEditImage;
	
	protected String text;
	@UiField(provided = true)
	UcCBundle res;
	/**
	 * Class constructor.
	 */
	public ProfilePageDescriptionEditUc() {
		this.res = UcCBundle.INSTANCE;
		initWidget(uiBinder.createAndBindUi(this));
		deckPanel.showWidget(0);
		
		biographyLabel = new Label();
		biographyLabel.getElement().setAttribute("style", "float: left; max-width: 500px; min-height: 33px;");
		
		biographyEditImage = new Label("Edit");
		biographyEditImage.setStyleName(res.css().editImage());
		errorLabel.setVisible(false);
		
		editTextBox.getElement().setAttribute("maxlength", "500");
		editTextBox.addKeyUpHandler(new ValidateConfirmText());
		editTextBox.getElement().setAttribute("id", "txtAreaAboutYourself");
		
	}

	public Label getBiographyEditImage() {
		return biographyEditImage;
	}
	/**
	 * This inner class is used to handle the keyup handler.
	 */
	private class ValidateConfirmText implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			errorLabel.setVisible(false);
			checkCharacterLimit(editTextBox.getText());
		}
	}

	/**
	 * Change to editable view
	 */
	public void switchToEdit() {
		if (deckPanel.getVisibleWidget() == 1)
			return;
		editTextBox.setText(getValue());
		deckPanel.showWidget(1);
		editTextBox.setFocus(true);
		
	}

	/**
	 * Change to label
	 */
	public void switchToLabel() {

		if (deckPanel.getVisibleWidget() == 0)
			return;

		setValue(editTextBox.getText().trim(), true); // fires events, too
		String text = getValue();
		deckPanel.showWidget(0);
		setText(editTextBox.getText());
		onEditDisabled(editTextBox.getText());

	}

	public void cancel() {
		editTextBox.setText(biographyLabel.getText());
		errorLabel.setVisible(false);
		deckPanel.showWidget(0);
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
	 * This is used to add the change hanlder.
	 */
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}
	/**
	 * This will get the value.
	 */
	@Override
	public String getValue() {
		return editTextBox.getText();
	}
	/**
	 * This will set the value.
	 */
	@Override
	public void setValue(String value) {
		biographyLabel.setText(value.length() > 500 ? value.substring(0, 500) + "..."
				: value);
		editLabel.add(biographyLabel);
		editLabel.add(biographyEditImage);
		editTextBox.setText(value);
	}

	/**
	 * @return placeholder
	 */
	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	/**
	 * This will get the text.
	 */
	public String getText() {
		return text;
	}
	/**
	 * This will set the text.
	 */
	public void setText(String text) {
		this.text = text;
		setValue(text);
	}
	/**
	 * This will set the value.
	 */
	@Override
	public void setValue(String value, boolean fireEvents) {

		if (fireEvents)
			ValueChangeEvent.fireIfNotEqual(this, getValue(), value);
		setValue(value);
	}

	public TextArea getTextBoxSource() {
		return editTextBox;
	}

	
	
	

}
