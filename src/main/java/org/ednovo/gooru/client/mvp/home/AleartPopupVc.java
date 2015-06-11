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

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class AleartPopupVc extends Composite{

	private AppPopUp appPopUp;

	@UiField
	BlueButtonUc okBtnUc;
	
	@UiField Label storeResourcesText;
	
	@UiField FlowPanel buttonContainer;
	
//	private static final String IS_COLLECTIONS = i18n.GL1089+i18n.GL_SPL_FULLSTOP+i18n.GL_SPL_FULLSTOP+i18n.GL_SPL_FULLSTOP;

	private static AleartPopupVcUiBinder uiBinder = GWT.create(AleartPopupVcUiBinder.class);

	interface AleartPopupVcUiBinder extends UiBinder<Widget, AleartPopupVc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor , get confirm logout popup
	 */
	public AleartPopupVc() {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent((i18n.GL1089()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP()+i18n.GL_SPL_FULLSTOP()), uiBinder.createAndBindUi(this));
		appPopUp.show();
		appPopUp.center();
		okBtnUc.setText(i18n.GL0190());
		okBtnUc.getElement().setId("btnOkBtnUc");
		okBtnUc.getElement().setAttribute("alt",i18n.GL0190());
		okBtnUc.getElement().setAttribute("title",i18n.GL0190());
		
		storeResourcesText.setText(i18n.GL1237());
		storeResourcesText.getElement().setId("lblStoreResourcesText");
		storeResourcesText.getElement().setAttribute("alt",i18n.GL1237());
		storeResourcesText.getElement().setAttribute("title",i18n.GL1237());
		buttonContainer.getElement().setId("pnlButtonContainer");
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
