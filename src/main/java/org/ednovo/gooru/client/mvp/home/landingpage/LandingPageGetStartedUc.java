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
package org.ednovo.gooru.client.mvp.home.landingpage;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.register.RegisterVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class LandingPageGetStartedUc extends Composite implements MessageProperties {

	@UiField HTMLEventPanel signUpLink, discoverLink, organizeLink;
	@UiField Anchor backto;
	@UiField Label howToStartText,searchLbl,createText,signUpLbl;
	@UiField HTMLPanel searchDescLbl,startCollectionLbl,shareLbl;
	
	private static LandingPageGetStartedUcUiBinder uiBinder = GWT
			.create(LandingPageGetStartedUcUiBinder.class);

	interface LandingPageGetStartedUcUiBinder extends
			UiBinder<Widget, LandingPageGetStartedUc> {
	}

	public LandingPageGetStartedUc() {
		initWidget(uiBinder.createAndBindUi(this));
		howToStartText.setText(GL1333);
		backto.setText(GL1260);
		searchLbl.setText(GL0176);
		searchDescLbl.getElement().setInnerText(GL1334);
		createText.setText(GL1335);
		startCollectionLbl.getElement().setInnerText(GL1336);
		signUpLbl.setText(GL0186);
		shareLbl.getElement().setInnerText(GL1337+GL_SPL_EXCLAMATION);
		backto.getElement().setId("lnkBackTo");
	}

	@UiHandler("signUpLink")
	void onClickSignUpLink(ClickEvent event) {
       MixpanelUtil.ClickOnSignUp();
		RegisterVc registerVc = new RegisterVc();
		registerVc.show();
		registerVc.center();
	}
	;
	@UiHandler("discoverLink")
	void onClickDiscoverLink(ClickEvent event) {
		MixpanelUtil.ClickOnSearch();
	}

	@UiHandler("organizeLink")
	void onClickOrganizeLink(ClickEvent event) {
		MixpanelUtil.ClickOnCreate();
	}

}
