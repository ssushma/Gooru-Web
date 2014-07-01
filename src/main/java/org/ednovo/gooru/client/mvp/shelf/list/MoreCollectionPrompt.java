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
package org.ednovo.gooru.client.mvp.shelf.list;

import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class MoreCollectionPrompt extends Composite implements MessageProperties{

	private static MoreCollectionPromptUiBinder uiBinder = GWT.create(MoreCollectionPromptUiBinder.class);
	
	protected AppPopUp appPopUp;
	@UiField Label manyResourcesText,tipLabelText,splitCollectionText;
	@UiField BlueButtonUc okButton;
	@UiField Anchor cancelButton;

	interface MoreCollectionPromptUiBinder extends UiBinder<Widget, MoreCollectionPrompt> {
	}

	/**
	 * Class constructor , assign new instance of {@link AppPopUp} and set title and content message 
	 */
	public MoreCollectionPrompt() {
		appPopUp = new AppPopUp();
		appPopUp.setContent(GL0981,uiBinder.createAndBindUi(this));
		appPopUp.show();
		appPopUp.center();
		manyResourcesText.setText(GL0978);
		manyResourcesText.getElement().setId("lblManyResourcesText");
		manyResourcesText.getElement().setAttribute("alt", GL0978);
		manyResourcesText.getElement().setAttribute("title", GL0978);
		tipLabelText.setText(GL0979);
		tipLabelText.getElement().setId("lblTipLabelText");
		tipLabelText.getElement().setAttribute("alt", GL0979);
		tipLabelText.getElement().setAttribute("title", GL0979);
		
		splitCollectionText.setText(GL0980);
		splitCollectionText.getElement().setId("lblSplitCollectionText");
		splitCollectionText.getElement().setAttribute("alt", GL0980);
		splitCollectionText.getElement().setAttribute("title", GL0980);
		
		okButton.setText(GL0190.toLowerCase());
		okButton.getElement().setId("bluebtnOkButton");
		okButton.getElement().setAttribute("alt", GL0190.toLowerCase());
		okButton.getElement().setAttribute("title", GL0190.toLowerCase());
		
		cancelButton.setText(GL0142);
		cancelButton.getElement().setId("lnkCancelButton");
		cancelButton.getElement().setAttribute("alt", GL0142);
		cancelButton.getElement().setAttribute("title",GL0142);
	}

}
