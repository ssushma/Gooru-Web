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
package org.ednovo.gooru.client.mvp.library.sausd;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : SausdBannerView.java
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
public class SausdBannerView extends Composite {

	@UiField HTMLPanel partnerLogo, landingBannerInner;
	@UiField Label headerTag, subHeaderTag, info1, info2, info3, info4, title1, title2;
	@UiField SausdStyleBundle sausdStyleUc;
	
	private static SausdBannerViewUiBinder uiBinder = GWT
			.create(SausdBannerViewUiBinder.class);
	
	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);

	interface SausdBannerViewUiBinder extends
			UiBinder<Widget, SausdBannerView> {
	}

	public SausdBannerView(String placeToken) {
		initWidget(uiBinder.createAndBindUi(this));
		getLandingBannerText(placeToken);
	}

	@Override
	public void onLoad() {
		landingBannerInner.getElement().setId("landingBannerInner");
	}
	
	private void getLandingBannerText(String placeToken) {
		if(placeToken.contains(PlaceTokens.SAUSD_LIBRARY)) {
			setLandingBannerText(i18n.GL1902(),i18n.GL1903(),i18n.GL1977(),i18n.GL1978(),i18n.GL1979(),i18n.GL1980());
			partnerLogo.setStyleName(sausdStyleUc.sausdPartnerLogo());
			partnerLogo.setVisible(true);
		}
	}
	
	private void setLandingBannerText(String headerMsg, String subHeaderMsg, String infoText1, String infoText2, String infoText3, String infoText4) {
		
		    partnerLogo.getElement().setId("pnlPartnerLogo"); 
		    
			headerTag.setText(headerMsg);
			headerTag.getElement().setId("lblHeaderTag");
			headerTag.getElement().setAttribute("alt",headerMsg);
			headerTag.getElement().setAttribute("title",headerMsg);
			
			subHeaderTag.setText(subHeaderMsg);

			subHeaderTag.getElement().setId("lblSubHeaderTag");
			subHeaderTag.getElement().setAttribute("alt",subHeaderMsg);
			subHeaderTag.getElement().setAttribute("title",subHeaderMsg);
			
			title1.setText(i18n.GL1981());
			title1.getElement().setId("lblTitle1");
			title1.getElement().setAttribute("alt",i18n.GL1981());
			title1.getElement().setAttribute("title",i18n.GL1981());
			
			title2.setText(i18n.GL1982());
			title2.getElement().setId("lblTitle2");
			title2.getElement().setAttribute("alt",i18n.GL1982());
			title2.getElement().setAttribute("title",i18n.GL1982());
			
			info1.setText(infoText1);
			info1.getElement().setId("lblInfo1");
			info1.getElement().setAttribute("alt",infoText1);
			info1.getElement().setAttribute("title",infoText1);
			
			info2.setText(infoText2);
			info2.getElement().setId("lblInfo2");
			info2.getElement().setAttribute("alt",infoText2);
			info2.getElement().setAttribute("title",infoText2);
			
			info3.setText(infoText3);
			info3.getElement().setId("lblInfo3");
			info3.getElement().setAttribute("alt",infoText3);
			info3.getElement().setAttribute("title",infoText3);
			
			info4.setText(infoText4);
			info4.getElement().setId("lblInfo4");
			info4.getElement().setAttribute("alt",infoText4);
			info4.getElement().setAttribute("title",infoText4);
	}	
}