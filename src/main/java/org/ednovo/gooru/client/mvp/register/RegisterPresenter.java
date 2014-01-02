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
package org.ednovo.gooru.client.mvp.register;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

/**
 * 
 * @fileName : RegisterPresenter.java
 *
 * @description : This is the presenter class for RegisterView.java
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class RegisterPresenter extends BasePlacePresenter<IsRegisterView, IsRegisterProxy> implements RegisterUiHandlers {

	
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.REGISTER)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsRegisterProxy extends ProxyPlace<RegisterPresenter> {
	}

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public RegisterPresenter(IsRegisterView view, IsRegisterProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}
	
	@Inject PlaceManager placeManager;
	/**
	 * This method is called when the presenter is instantiated.
	 */
	@Override
	public void onBind() {
		super.onBind();
		getView().clearAll();
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		getView().clearAll();
	}
	/**
	 * This method is called whenever the user navigates to a page that shows the presenter, whether it was visible or not.
	 */
	@Override
	protected void onReset() {
		super.onReset();
		PlaceRequest request=new PlaceRequest(PlaceTokens.HOME);
		Map<String, String> params = new HashMap<String, String>();
		params.put("callback","register");
		getPlaceManager().revealPlace(request, params);
	}
	/**
	 * To fire RevealRootPopupContentEvent
	 */
	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}
	/**
	 * To get the place token.
	 */
	@Override
	public String getViewToken() {
		return PlaceTokens.REGISTER;
	}
}
