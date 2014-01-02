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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : EditableTextAreaUc.java
 *
 * @description : This class will return the editable text area.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class EditableTextAreaUc extends Composite implements HasValue<String> {

	private static EditableLabelUiBinder uiBinder = GWT
			.create(EditableLabelUiBinder.class);

	interface EditableLabelUiBinder extends
			UiBinder<Widget, EditableTextAreaUc> {
	}

	@UiField
	protected HTML html;

	@UiField
	protected DeckPanel deckPanel;

	@UiField
	protected TextArea textArea;

	@UiField
	protected FocusPanel focusPanel;

	protected String placeholder = "";

	protected String text;

	@UiField(provided = true)
	UcCBundle res;

	/**
	 * Class constructor
	 */
	public EditableTextAreaUc() {
		this.res = UcCBundle.INSTANCE;
		initWidget(uiBinder.createAndBindUi(this));
		deckPanel.showWidget(0);
		/*
		 * focusPanel.addClickHandler(new ClickHandler() {
		 * 
		 * @Override public void onClick(ClickEvent event) { switchToEdit(); }
		 * });
		 * 
		 * html.addClickHandler(new ClickHandler() {
		 * 
		 * @Override public void onClick(ClickEvent event) { switchToEdit(); }
		 * });
		 * 
		 * textArea.addBlurHandler(new BlurHandler() {
		 * 
		 * @Override public void onBlur(BlurEvent event) { switchToLabel(); }
		 * });
		 */

		/*
		 * textArea.addKeyPressHandler(new KeyPressHandler() {
		 * 
		 * @Override public void onKeyPress(KeyPressEvent event) {
		 * 
		 * if (event.getCharCode() == KeyCodes.KEY_ENTER) { switchToLabel(); }
		 * else if (event.getCharCode() == KeyCodes.KEY_ESCAPE) {
		 * textArea.setText(html.getText()); // reset to the original value } }
		 * });
		 */
		textArea.addKeyUpHandler(new ValidateConfirmText());
	}

	private class ValidateConfirmText implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			checkCharacterLimit(textArea.getText());
		}
	}

	/**
	 * Change to edit view
	 */
	public void switchToEdit() {

		if (deckPanel.getVisibleWidget() == 1)
			return;
		 textArea.setText(html.getHTML().equals(getPlaceholder()) ? "" :
		  html.getHTML());
		deckPanel.showWidget(1);
		textArea.setFocus(true);
		textArea.addStyleName("shelfEditDesc");
		textArea.getElement().setAttribute("maxlength", "415");
	}

	/**
	 * Change to label view
	 */
	public void switchToLabel() {
		if (deckPanel.getVisibleWidget() == 0)
			return;
		// setValue(textArea.getText(), true);
		setValue(textArea.getText().trim().length() == 0 ? getPlaceholder()
				: textArea.getText(), true); // fires events, too
		deckPanel.showWidget(0);
		String text = getValue();

		if ((textArea.getText() != null || text.trim().length() > 0)) {
			// if ((textArea.getText() != null || text.trim().length() > 0) &&
			// !getText().equals(text)) {

			setText(text);
			onEditDisabled(getValue());
		}
	}

	/**
	 * For cancel edit view
	 */
	public void switchToDesCancelLabel() {
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
	 * This will add the click event.
	 */
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}
	/**
	 * This will return the value.
	 */
	@Override
	public String getValue() {
		// return textArea.getText().trim().equals(getPlaceholder()) ? "" :
		// textArea.getText();

		return textArea.getText().trim();
	}
	/**
	 * This will set the value.
	 */
	@Override
	public void setValue(String value) {
		if (value == null || value.trim().length() == 0) {
			value = getPlaceholder();
		}
		html.setHTML(value);
		textArea.setText(value);
	}

	public void setExtraHtmlStyleName(String style) {
		html.addStyleName(style);
	}

	public void setExtraTextAreaStyleName(String style) {
		textArea.addStyleName(style);
	}
	/**
	 * This will return the placeholder.
	 */
	public String getPlaceholder() {
		return placeholder;
	}
	/**
	 * This will set the placeholder.
	 */
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	/**
	 * This will return the text.
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
	 * This will set  the value.
	 */
	@Override
	public void setValue(String value, boolean fireEvents) {
		if (fireEvents)
			ValueChangeEvent.fireIfNotEqual(this, getValue(), value);
		setValue(value);
	}
}
