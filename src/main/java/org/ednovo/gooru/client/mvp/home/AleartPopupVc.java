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
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * This file is related to AppPopUp
 */
public class AleartPopupVc extends Composite {

	private AppPopUp appPopUp;

	@UiField
	BlueButtonUc okBtnUc;
	
	private static final String IS_COLLECTIONS = "Ooops...";

	private static AleartPopupVcUiBinder uiBinder = GWT.create(AleartPopupVcUiBinder.class);

	interface AleartPopupVcUiBinder extends UiBinder<Widget, AleartPopupVc> {
	}

	/**
	 * Class constructor , get confirm logout popup
	 */
	public AleartPopupVc() {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent(IS_COLLECTIONS, uiBinder.createAndBindUi(this));
		appPopUp.show();
		appPopUp.center();
	}

	/**
	 * Logout from signed user and makes as a anonymous user 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("okBtnUc")
	public void userLogout(ClickEvent clickEvent) {
		
		appPopUp.hide();
		/*AppClientFactory.getInjector().getAppService().signout(new SimpleAsyncCallback<UserDo>() {

			@Override
			public void onSuccess(UserDo result) {
				appPopUp.hide();
				AppClientFactory.setLoggedInUser(result);
				AppClientFactory.getInjector().getWrapPresenter().get().setLoginData(result);
				//AppClientFactory.resetPlace();
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
			}

		});*/

	}

}
