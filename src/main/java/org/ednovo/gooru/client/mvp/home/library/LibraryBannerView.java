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
package org.ednovo.gooru.client.mvp.home.library;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : LibraryBannerView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Dec-2013
 *
 * @Author IBC
 *
 * @Reviewer: 
 */
public class LibraryBannerView extends Composite implements MessageProperties{

	@UiField HTMLPanel partnerLogo, landingBannerInner, findLbl, shareLbl, measureLbl, contributeLbl, fourSteps;
	@UiField Label headerTag;
	@UiField Label subHeaderTag;
	@UiField LibraryStyleBundle libraryStyle;

	
	private static LibraryBannerViewUiBinder uiBinder = GWT
			.create(LibraryBannerViewUiBinder.class);

	interface LibraryBannerViewUiBinder extends
			UiBinder<Widget, LibraryBannerView> {
	}

	public LibraryBannerView(String placeToken) {
		initWidget(uiBinder.createAndBindUi(this));
		getLandingBannerText(placeToken);
	}

	@Override
	public void onLoad() {
		landingBannerInner.getElement().setId("landingBannerInner");
	}
	
	private void getLandingBannerText(String placeToken) {
		if(placeToken.contains(PlaceTokens.HOME)) {
			setLandingBannerText(GL0522,GL0523,GL0524,GL0525,GL0526,GL0527,GL0528,GL0529,GL0530,GL0531);
			partnerLogo.setVisible(false);
		} else if(placeToken.contains(PlaceTokens.RUSD_LIBRARY)) {
			setLandingBannerText(GL0532,GL0533,GL0534,GL0535,GL0536,GL0537,GL0538,GL0539,GL0540,GL0541);
			fourSteps.getElement().getStyle().setBackgroundColor("#000000");
			partnerLogo.setStyleName(libraryStyle.rusdPartnerLogo());
			partnerLogo.setVisible(true);
		} else if(placeToken.contains(PlaceTokens.SAUSD_LIBRARY)) {
			setLandingBannerText(GL1902,GL1903,GL1904,GL1905,GL1906,GL1907,GL1908,GL1909,GL1910,GL1911);
			fourSteps.getElement().getStyle().setBackgroundColor("#000000");
			partnerLogo.setStyleName(libraryStyle.sausdPartnerLogo());
			partnerLogo.setVisible(true);
		}
	}
	
	private void setLandingBannerText(String headerMsg, String subHeaderMsg, String findInlineMsg, String findMsg, String shareInlineMsg, String shareMsg, 
			String measureInlineMsg, String measureMsg, String contributeInlineMsg, String contributeMsg) {
			headerTag.setText(headerMsg);
			subHeaderTag.setText(subHeaderMsg);
			
			InlineLabel findInlineLbl = new InlineLabel(findInlineMsg);
			InlineLabel shareInlineLbl = new InlineLabel(shareInlineMsg);
			InlineLabel measureInlineLbl = new InlineLabel(measureInlineMsg);
			InlineLabel contributeInlineLbl = new InlineLabel(contributeInlineMsg);
			
			Label findLblMsg = new Label(findMsg);
			Label shareLblMsg = new Label(shareMsg);
			Label measureLblMsg = new Label(measureMsg);
			Label contributeLblMsg = new Label(contributeMsg);
			findLblMsg.setStyleName(libraryStyle.bannerSpanBlock());
			shareLblMsg.setStyleName(libraryStyle.bannerSpanBlock());
			measureLblMsg.setStyleName(libraryStyle.bannerSpanBlock());
			contributeLblMsg.setStyleName(libraryStyle.bannerSpanBlock());
			
			findLbl.add(findInlineLbl);
			findLbl.add(findLblMsg);
			
			shareLbl.add(shareInlineLbl);
			shareLbl.add(shareLblMsg);
			
			measureLbl.add(measureInlineLbl);
			measureLbl.add(measureLblMsg);
			
			contributeLbl.add(contributeInlineLbl);
			contributeLbl.add(contributeLblMsg);
	}	
}