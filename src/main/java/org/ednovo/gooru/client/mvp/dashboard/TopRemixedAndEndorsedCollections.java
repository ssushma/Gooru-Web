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
package org.ednovo.gooru.client.mvp.dashboard;

import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * 
 * @fileName : TopRemixedAndEndorsedCollections.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 07-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class TopRemixedAndEndorsedCollections extends Composite{
	private static TopRemixedAndEndorsedCollectionsUiBinder uiBinder = GWT
			.create(TopRemixedAndEndorsedCollectionsUiBinder.class);
	
	@UiField Label collectionNameLbl,countNoOfEndorsements,titleLbl;

	interface TopRemixedAndEndorsedCollectionsUiBinder extends
			UiBinder<Widget, TopRemixedAndEndorsedCollections> {

	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, TopRemixedAndEndorsedCollections> {
	}

	@Inject
	public TopRemixedAndEndorsedCollections() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TopRemixedAndEndorsedCollections(String title, String collName,String totalEndorsements) {
		initWidget(uiBinder.createAndBindUi(this));
		titleLbl.setText(title);
		collectionNameLbl.setText(collName);
		countNoOfEndorsements.setText(totalEndorsements);
	}
}