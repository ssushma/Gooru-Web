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

import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class HowToUseGooruUc extends Composite implements MessageProperties{

	@UiField Anchor youTubePlayerContainer;
	@UiField Anchor learnmore,backto;
	@UiField HTMLPanel panelHowToUseGooru;
	@UiField Label gooruText,discoverLbl,k12Text,organizeLbl,customizableText,teachText,assignToStudents,studyText,
	completeAssignmentsText,watchVideoText,orText;
	@UiField Image videoIcon;
	
	private final String YOUTUBE_FEATURED_URL = "http://www.youtube.com/v/nq9HTYiv7jM";
	
	YoutubePopupVc youtubePopupVc = null;
	private static HowToUseGooruUcUiBinder uiBinder = GWT
			.create(HowToUseGooruUcUiBinder.class);

	interface HowToUseGooruUcUiBinder extends UiBinder<Widget, HowToUseGooruUc> {
	}

	public HowToUseGooruUc() {
		initWidget(uiBinder.createAndBindUi(this));
		gooruText.setText(GL0199);
		backto.setText(GL1260);
		discoverLbl.setText(GL0179);
		k12Text.setText(GL1328_1);
		organizeLbl.setText(GL0180);
		customizableText.setText(GL1329_1);
		teachText.setText(GL0181);
		assignToStudents.setText(GL1067);
		studyText.setText(GL0182);
		completeAssignmentsText.setText(GL1330);
		watchVideoText.setText(GL1331);
		orText.setText(" "+GL0209.toUpperCase()+" ");
		learnmore.setText(GL0751);
		videoIcon.setAltText(GL1332);
		videoIcon.setUrl("images/landing-page/video-icon.png");
		learnmore.setHref("http://about.goorulearning.org/product/overview/");
		panelHowToUseGooru.getElement().setId("panelHowToUseGooru");
		youTubePlayerContainer.getElement().setId("lnkYouTube");
		learnmore.getElement().setId("lnkLearnMore");
		backto.getElement().setId("lnkBackTo");
	}

	@UiHandler("youTubePlayerContainer")
	public void openYoutubeContainer(ClickEvent event) {
		MixpanelUtil.ClickOnVideo();
		youtubePopupVc = new YoutubePopupVc("", loadYouTube());
	}
	
	public String loadYouTube(){
         String height ="500";
         String width="800";
         String  embeddableHtmlString = "<embed type=\"application/x-shockwave-flash\" src=\""+YOUTUBE_FEATURED_URL+"?amp;rel=0&amp;enablejsapi=1&amp;version=3&amp;autoplay=0&amp;start=1\""
               + " width=\""+width+"\" height=\""+height+"\" id=\"embed\"  quality=\"high\" allowfullscreen=\"true\" allowscriptaccess=\"always\" autoplay=\"0\" wmode=\"opaque\">";
         return embeddableHtmlString;
	}
	@UiHandler("learnmore")
	public void onlearnmoreClicked(ClickEvent clickEvent) {
		MixpanelUtil.ClickOnAboutGooruLearningOrg();
	}
}
