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

import org.ednovo.gooru.application.shared.i18n.MessageProperties;

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
public class NoCollectionInShelfListView extends Composite{

	@UiField Label emptyCollMsg_1,emptyCollMsg_2;
	
	private static NoCollectionInShelfListViewUiBinder uiBinder = GWT.create(NoCollectionInShelfListViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	interface NoCollectionInShelfListViewUiBinder extends UiBinder<Widget, NoCollectionInShelfListView> {
	}

	/**
	 * Class constructor
	 */
	public NoCollectionInShelfListView() {
		initWidget(uiBinder.createAndBindUi(this));
		emptyCollMsg_1.setText(i18n.GL1031()+i18n.GL_SPL_QUESTION());
		emptyCollMsg_1.getElement().setId("lblEmptyCollMsg_1");
		emptyCollMsg_1.getElement().setAttribute("alt", i18n.GL1031()+i18n.GL_SPL_QUESTION());
		emptyCollMsg_1.getElement().setAttribute("title", i18n.GL1031()+i18n.GL_SPL_QUESTION());
		
		emptyCollMsg_2.setText(i18n.GL1058());
		emptyCollMsg_2.getElement().setId("lblEmptyCollMsg_2");
		emptyCollMsg_2.getElement().setAttribute("alt", i18n.GL1058());
		emptyCollMsg_2.getElement().setAttribute("title", i18n.GL1058());
	}

}
