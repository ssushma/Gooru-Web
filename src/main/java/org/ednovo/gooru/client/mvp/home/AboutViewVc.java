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

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.util.MessageProperties;

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
public class AboutViewVc extends Composite implements MessageProperties {

	private static final String CDN_END_POINT = AppClientFactory.getLoggedInUser().getSettings().getCdnEndPoint();

	private static AboutViewUiBinder uiBinder = GWT
			.create(AboutViewUiBinder.class);

	interface AboutViewUiBinder extends UiBinder<Widget, AboutViewVc> {
	}
	
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
		lblWonderfulSupporters.setText(GL0245);
		lblWonderfulSupporters.getElement().setId("lblWonderfulSupporters");
		lblWonderfulSupporters.getElement().setAttribute("alt",GL0245);
		lblWonderfulSupporters.getElement().setAttribute("title",GL0245);
		
		backto.setText(GL1260);
		backto.getElement().setAttribute("alt",GL1260);
		backto.getElement().setAttribute("title",GL1260);
		
		ciscoImg.setTitle(GL1267);
		ciscoImg.getElement().setId("imgCisco");
		ciscoImg.setAltText(GL1267);

		gatesImg.setTitle(GL1268);
		gatesImg.setAltText(GL1268);
		gatesImg.getElement().setId("imgGates");
		
		onrImg.setTitle(GL1269);
		onrImg.setAltText(GL1269);
		onrImg.getElement().setId("imgOnr");
		
		googleImg.setTitle(GL1270);
		googleImg.setAltText(GL1270);
		googleImg.getElement().setId("imgGoogle");
		
		nglcImg.setTitle(GL1271);
		nglcImg.setAltText(GL1271);
		nglcImg.getElement().setId("imgNglc");
		
		pearsonImg.setTitle(GL1272);
		pearsonImg.setAltText(GL1272);
		pearsonImg.getElement().setId("imgPearson");
		
		hewlettImg.setTitle(GL1273);
		hewlettImg.setAltText(GL1273);
		hewlettImg.getElement().setId("imgHewlett");
		
		scefdnImg.setTitle(GL1274);
		scefdnImg.setAltText(GL1274);
		scefdnImg.getElement().setId("imgScefdn");
		
		fenwickImg.setTitle(GL1275);
		fenwickImg.setAltText(GL1275);
		fenwickImg.getElement().setId("imgFenwick");
		
		ramImg.setTitle(GL1276);
		ramImg.setAltText(GL1276);
		ramImg.getElement().setId("imgRam");
		
		nonProfitLbl.setText(GL1277);
		nonProfitLbl.getElement().setId("lblNonProfit");
		nonProfitLbl.getElement().setAttribute("alt",GL1277);
		nonProfitLbl.getElement().setAttribute("title",GL1277);
		
		about.setText(GL1242);
		about.getElement().setAttribute("alt",GL1242);
		about.getElement().setAttribute("title",GL1242);
		about.setHref("http://about.goorulearning.org");
		sectionText.setText(" "+GL1278);
		sectionText.getElement().setId("lblSection");
		sectionText.getElement().setAttribute("alt",GL1278);
		sectionText.getElement().setAttribute("title",GL1278);
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
