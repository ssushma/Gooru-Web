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
package org.ednovo.gooru.client.mvp.folders;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class FoldersWelcomePage extends Composite {
	
	@UiField HTMLPanel myContentLoggedout;
	
	@UiField Button createCourseBtn, loginBtn;
	
	private static FoldersWelcomePageUiBinder uiBinder = GWT
			.create(FoldersWelcomePageUiBinder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface FoldersWelcomePageUiBinder extends
			UiBinder<Widget, FoldersWelcomePage> {
	}

	public FoldersWelcomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		setText();
	}
	
	private void setText() {
		myContentLoggedout.getElement().setId("myContentLoggedout");
	}
	
	@UiHandler("createCourseBtn")
	public void clickCourseBtn(ClickEvent event) {
		openLogin();
	}
	
	@UiHandler("loginBtn")
	public void clickloginBtn(ClickEvent event) {
		openLogin();
	}

	private void openLogin() {
		LoginPopupUc loginPopupUc=new LoginPopupUc() {
			@Override
			public	void onLoginSuccess(){
				
			}
		};
		Window.enableScrolling(false);
		loginPopupUc.show();
		loginPopupUc.setGlassEnabled(true);
	}

	@Override
	public void onLoad() {
		animate();
	}
	
	public static native void animate() /*-{
		new $wnd.WOW().init();
	}-*/;

}
