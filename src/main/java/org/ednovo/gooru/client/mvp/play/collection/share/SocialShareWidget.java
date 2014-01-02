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
package org.ednovo.gooru.client.mvp.play.collection.share;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class SocialShareWidget extends Composite {

	private static SocialShareWidgetUiBinder uiBinder = GWT
			.create(SocialShareWidgetUiBinder.class);

	interface SocialShareWidgetUiBinder extends
			UiBinder<Widget, SocialShareWidget> {
	}
	
	@UiField Button fbButton,twitterButton,emailButton;

	public SocialShareWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("fbButton")
	public void onClickFbButton(ClickEvent clickEvent) {
		onFacebook();
	}

	@UiHandler("twitterButton")
	public void onClickTwitterButton(ClickEvent clickEvent) {
		onTwitter();
	}
	
	@UiHandler("emailButton")
	public void onClickEmailButton(ClickEvent clickEvent) {
		onEmail();
	}
	
	public abstract void onFacebook();

	public abstract void onTwitter();
	
	public abstract void onEmail();
}
