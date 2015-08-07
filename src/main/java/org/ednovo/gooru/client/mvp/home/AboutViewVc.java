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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.home.HomeCBundle;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class AboutViewVc extends Composite {

	private static final String CDN_END_POINT = AppClientFactory.getLoggedInUser().getSettings().getCdnEndPoint();

	private static AboutViewUiBinder uiBinder = GWT
			.create(AboutViewUiBinder.class);

	interface AboutViewUiBinder extends UiBinder<Widget, AboutViewVc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField(provided=true)
	HomeCBundle res;

	@UiField Label lblWonderfulSupporters,nonProfitLbl,sectionText;

	@UiField Anchor backto,about;

	@UiField Image ciscoImg, gatesImg, onrImg, googleImg, nglcImg, pearsonImg, hewlettImg, scefdnImg, fenwickImg, ramImg;

	/**
	 * Class constructor
	 */
	public AboutViewVc() {
		this.res = HomeCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		lblWonderfulSupporters.setText(i18n.GL0245());
		lblWonderfulSupporters.getElement().setId("lblWonderfulSupporters");
		lblWonderfulSupporters.getElement().setAttribute("alt",i18n.GL0245());
		lblWonderfulSupporters.getElement().setAttribute("title",i18n.GL0245());

		backto.setText(i18n.GL1260());
		backto.getElement().setAttribute("alt",i18n.GL1260());
		backto.getElement().setAttribute("title",i18n.GL1260());

		ciscoImg.setTitle(i18n.GL1267());
		ciscoImg.getElement().setId("imgCisco");
		ciscoImg.setAltText(i18n.GL1267());

		gatesImg.setTitle(i18n.GL1268());
		gatesImg.setAltText(i18n.GL1268());
		gatesImg.getElement().setId("imgGates");

		onrImg.setTitle(i18n.GL1269());
		onrImg.setAltText(i18n.GL1269());
		onrImg.getElement().setId("imgOnr");

		googleImg.setTitle(i18n.GL1270());
		googleImg.setAltText(i18n.GL1270());
		googleImg.getElement().setId("imgGoogle");

		nglcImg.setTitle(i18n.GL1271());
		nglcImg.setAltText(i18n.GL1271());
		nglcImg.getElement().setId("imgNglc");

		pearsonImg.setTitle(i18n.GL1272());
		pearsonImg.setAltText(i18n.GL1272());
		pearsonImg.getElement().setId("imgPearson");

		hewlettImg.setTitle(i18n.GL1273());
		hewlettImg.setAltText(i18n.GL1273());
		hewlettImg.getElement().setId("imgHewlett");

		scefdnImg.setTitle(i18n.GL1274());
		scefdnImg.setAltText(i18n.GL1274());
		scefdnImg.getElement().setId("imgScefdn");

		fenwickImg.setTitle(i18n.GL1275());
		fenwickImg.setAltText(i18n.GL1275());
		fenwickImg.getElement().setId("imgFenwick");

		ramImg.setTitle(i18n.GL1276());
		ramImg.setAltText(i18n.GL1276());
		ramImg.getElement().setId("imgRam");

		nonProfitLbl.setText(i18n.GL1277());
		nonProfitLbl.getElement().setId("lblNonProfit");
		nonProfitLbl.getElement().setAttribute("alt",i18n.GL1277());
		nonProfitLbl.getElement().setAttribute("title",i18n.GL1277());

		about.setText(i18n.GL1242());
		about.getElement().setAttribute("alt",i18n.GL1242());
		about.getElement().setAttribute("title",i18n.GL1242());
		about.setHref("http://about.goorulearning.org");
		sectionText.setText(" "+i18n.GL1278());
		sectionText.getElement().setId("lblSection");
		sectionText.getElement().setAttribute("alt",i18n.GL1278());
		sectionText.getElement().setAttribute("title",i18n.GL1278());
		//
		backto.getElement().setId("lnkBackTo");
		about.getElement().setId("lnkAbout");
		setSupportImages();
	}

	private void setSupportImages() {
		ciscoImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/cisco.png");
		gatesImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/gates.png");
		onrImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/onr.png");
		googleImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/google.png");
		nglcImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/nglc.png");
		pearsonImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/pearson.png");
		hewlettImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/hewlett.png");
		scefdnImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/sce.png");
		fenwickImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/fenwick.png");
		ramImg.setUrl(CDN_END_POINT+"/images/landing-page/supporters/ram-shriram.png");
	}

}
