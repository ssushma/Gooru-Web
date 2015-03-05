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
 * @fileName : UserDashBoardCommonInfo.java
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
public class UserDashBoardCommonInfo extends Composite{
	private static UserDashBoardCommonInfoUiBinder uiBinder = GWT
			.create(UserDashBoardCommonInfoUiBinder.class);
	
	@UiField Label countLbl,textLbl;

	interface UserDashBoardCommonInfoUiBinder extends
			UiBinder<Widget, UserDashBoardCommonInfo> {

	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, UserDashBoardCommonInfo> {
	}

	@Inject
	public UserDashBoardCommonInfo() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Inject
	public UserDashBoardCommonInfo(Label countLbl1, Label textLbl1) {
		initWidget(uiBinder.createAndBindUi(this));
		textLbl.setText(textLbl1.getText());
		countLbl.setText(countLbl1.getText());
	}
}