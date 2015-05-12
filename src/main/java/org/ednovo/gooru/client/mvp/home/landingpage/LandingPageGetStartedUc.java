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

import org.ednovo.gooru.client.mvp.home.register.RegisterVc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class LandingPageGetStartedUc extends Composite{

	@UiField HTMLEventPanel signUpLink, discoverLink, organizeLink;
	@UiField Anchor backto;
	@UiField Label howToStartText,searchLbl,createText,signUpLbl;
	@UiField HTMLPanel searchDescLbl,startCollectionLbl,shareLbl;
	
	private static LandingPageGetStartedUcUiBinder uiBinder = GWT
			.create(LandingPageGetStartedUcUiBinder.class);

	interface LandingPageGetStartedUcUiBinder extends
			UiBinder<Widget, LandingPageGetStartedUc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public LandingPageGetStartedUc() {
		initWidget(uiBinder.createAndBindUi(this));
		howToStartText.setText(i18n.GL1333());
		howToStartText.getElement().setId("lblHowToStartText");
		howToStartText.getElement().setAttribute("alt",i18n.GL1333());
		howToStartText.getElement().setAttribute("title",i18n.GL1333());
		
		backto.setText(i18n.GL1260());
		backto.getElement().setId("lnkBackTo");
		backto.getElement().setAttribute("alt",i18n.GL1260());
		backto.getElement().setAttribute("title",i18n.GL1260());
		
		searchLbl.setText(i18n.GL0176());
		searchLbl.getElement().setId("lblSearchLbl");
		searchLbl.getElement().setAttribute("alt",i18n.GL0176());
		searchLbl.getElement().setAttribute("title",i18n.GL0176());
		
		searchDescLbl.getElement().setInnerText(i18n.GL1334());
		searchDescLbl.getElement().setId("pnlSearchDescLbl");
		searchDescLbl.getElement().setAttribute("alt",i18n.GL1334());
		searchDescLbl.getElement().setAttribute("title",i18n.GL1334());
		
		createText.setText(i18n.GL1335());
		createText.getElement().setId("lblCreateText");
		createText.getElement().setAttribute("alt",i18n.GL1335());
		createText.getElement().setAttribute("title",i18n.GL1335());
		
		startCollectionLbl.getElement().setInnerText(i18n.GL1336());
		startCollectionLbl.getElement().setId("pnlStartCollectionLbl");
		startCollectionLbl.getElement().setAttribute("alt",i18n.GL1336());
		startCollectionLbl.getElement().setAttribute("title",i18n.GL1336());
		
		signUpLbl.setText(i18n.GL0186());
		signUpLbl.getElement().setId("lblSignUpLbl");
		signUpLbl.getElement().setAttribute("alt",i18n.GL0186());
		signUpLbl.getElement().setAttribute("title",i18n.GL0186());
		
		shareLbl.getElement().setInnerText(i18n.GL1337()+i18n.GL_SPL_EXCLAMATION());
		shareLbl.getElement().setId("pnlShareLbl");
		shareLbl.getElement().setAttribute("alt",i18n.GL1337());
		shareLbl.getElement().setAttribute("title",i18n.GL1337());
		
		discoverLink.getElement().setId("epnlDiscoverLink");
		organizeLink.getElement().setId("epnlOrganizeLink");
		signUpLink.getElement().setId("epnlSignUpLink");
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
