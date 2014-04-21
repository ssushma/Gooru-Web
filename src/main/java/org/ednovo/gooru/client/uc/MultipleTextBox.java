package org.ednovo.gooru.client.uc;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBoxBase;

/**
 * MultipleTextBox allow to have multiple suggestions at a result, separated by
 * comma, like gmail has at compose message field "TO", "CC", "BCC".
 * 
 * @author Viktor Zaprudnev
 * 
 *         Usage: SuggestBox(oracle, new MultipleTextBox());
 */

public  abstract class MultipleTextBox extends TextBoxBase implements KeyUpHandler, KeyDownHandler,HasClickHandlers{
	
	
	private boolean validation = true;
	
	/**
	 * Creates an empty multiple text box.
	 */
	public MultipleTextBox() {
		this(Document.get().createTextInputElement(), "gwt-TextBox");
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be an <input> element whose type is 'text'.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected MultipleTextBox(Element element) {
		super(element);
		assert InputElement.as(element).getType().equalsIgnoreCase("text");
	}

	MultipleTextBox(Element element, String styleName) {
		super(element);
		if (styleName != null) {
			setStyleName(styleName);
		}
	}

	@Override
	public String getText() {
		String wholeString = super.getText();
		String lastString = wholeString;
		if (wholeString != null && !wholeString.trim().equals("")) {
			int lastComma = wholeString.trim().lastIndexOf(",");
			if (lastComma > 0) {
				lastString = wholeString.trim().substring(lastComma + 1);
			}
		}
		return lastString;
	}

	@Override
	public void setText(String text) {
		String wholeString = super.getText();
		if (text != null && text.equals("")) {
			super.setText(text);
		} else {
			// Clean last text, to replace with new value, for example, if new
			// text is v.zaprudnevd@gmail.com:
			// "manuel@we-r-you.com, v" need to be replaced with:
			// "manuel@we-r-you.com, v.zaprudnevd@gmail.com, "

			if (wholeString != null) {
				int lastComma = wholeString.trim().lastIndexOf(",");
				if (lastComma > 0) {
					wholeString = wholeString.trim().substring(0, lastComma);
				} else {
					wholeString = "";
				}

				if (!wholeString.trim().endsWith(",")
						&& !wholeString.trim().equals("")) {
					wholeString = wholeString + ", ";
				}

				wholeString = wholeString + text + ", ";
				super.setText(wholeString);
			}
		}
	}
	
	public abstract void keyAction(String text);

	@Override
	public void onKeyDown(KeyDownEvent event) {
		int keyCode = event.getNativeKeyCode();
		String text = this.getText().trim();
		if (validation) {
			if ((keyCode == (char) KeyCodes.KEY_TAB) || (keyCode == (char) KeyCodes.KEY_LEFT) || (keyCode == (char) KeyCodes.KEY_RIGHT) && (keyCode != (char) KeyCodes.KEY_DOWN) && (keyCode != (char) KeyCodes.KEY_UP)) {

			}
		}
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		int keyCode = event.getNativeKeyCode();
		String text = this.getText().trim();
		if (keyCode != (char) KeyCodes.KEY_TAB && keyCode != (char) KeyCodes.KEY_ENTER && keyCode != (char) KeyCodes.KEY_LEFT && (keyCode != (char) KeyCodes.KEY_RIGHT) && (keyCode != (char) KeyCodes.KEY_DOWN) && (keyCode != (char) KeyCodes.KEY_UP)) {
			keyAction(text);
		}
	}

	public final String getSuggestionValue() {
		
			return this.getText();
	
	}

}