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
/**
 *
*/
package org.ednovo.gooru.client.mvp.test;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 *
 * @fileName : TestPresenter.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 26-May-2015
 *
 * @Author tumbalam
 *
 * @Reviewer:
 */
public class TestPresenter extends BasePlacePresenter<IsTestView, IsEditClasspageProxy> implements TestUiHandlers {

	@Inject
	public TestPresenter(IsTestView view, IsEditClasspageProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.TEST)
	public interface IsTestProxy extends ProxyPlace<TestPresenter> {
	}


	@Override
	public String getViewToken() {
		return AppClientFactory.getCurrentPlaceToken();
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		Window.enableScrolling(true);
			}


	@Override
	protected void onHide() {
		super.onHide();

	}

	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
	}

	@Override
	protected void onReset() {
		Window.enableScrolling(true);
	}
}
