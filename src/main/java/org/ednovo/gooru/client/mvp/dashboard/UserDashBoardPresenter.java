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

/**
 * @fileName : UserSettingsPresenter.java 
 *
 * @description : 
 *
 * @version :1.0
 *
 * @date: APR 18 2013

 * @Author Gooru Team 
 * 
 * Reviewer Gooru Team
 *
 */
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class UserDashBoardPresenter
		extends
		BasePlacePresenter<IsUserDashBoardView, UserDashBoardPresenter.IsUserDashBoardProxy>
		implements UserDashBoardUiHandlers {
	
	@Inject
	private UserServiceAsync userService;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.DASHBOARD)
	public interface IsUserDashBoardProxy extends
			ProxyPlace<UserDashBoardPresenter> {

	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@Inject
	public UserDashBoardPresenter(final IsUserDashBoardView view,
			final IsUserDashBoardProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
		Window.enableScrolling(true);
	}

	@Override
	public void onReveal() {
		Window.enableScrolling(true);
		displayDashBoardPage();
	}

	void displayDashBoardPage() {
		getView().dispalyDashBoardHomePage();
	}

	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
		displayDashBoardPage();
	}
	@Override
	protected void onHide() {
		super.onHide();
	}
	public UserServiceAsync getUserService() {
		return userService;
	}
	@Override
	public String getViewToken() {
		return null;
	}
}