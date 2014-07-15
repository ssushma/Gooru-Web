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
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;

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

public class HowToUseGooruUc extends Composite{

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

	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);
	
	public HowToUseGooruUc() {
		initWidget(uiBinder.createAndBindUi(this));
		gooruText.setText(i18n.GL0199());
		gooruText.getElement().setId("lblGooruText");
		gooruText.getElement().setAttribute("alt",i18n.GL0199());
		gooruText.getElement().setAttribute("title",i18n.GL0199());
		
		backto.setText(i18n.GL1260());
		backto.getElement().setAttribute("alt",i18n.GL1260());
		backto.getElement().setAttribute("title",i18n.GL1260());
		
		discoverLbl.setText(i18n.GL0179());
		discoverLbl.getElement().setId("lblDiscoverLbl");
		discoverLbl.getElement().setAttribute("alt",i18n.GL0179());
		discoverLbl.getElement().setAttribute("title",i18n.GL0179());
		
		k12Text.setText(i18n.GL1328_1());
		k12Text.getElement().setId("lblK12Text");
		k12Text.getElement().setAttribute("alt",i18n.GL1328_1());
		k12Text.getElement().setAttribute("title",i18n.GL1328_1());
		
		organizeLbl.setText(i18n.GL0180());
		organizeLbl.getElement().setId("lblOrganizeLbl");
		organizeLbl.getElement().setAttribute("alt",i18n.GL0180());
		organizeLbl.getElement().setAttribute("title",i18n.GL0180());
		
		customizableText.setText(i18n.GL1329_1());
		customizableText.getElement().setId("lblCustomizableText");
		customizableText.getElement().setAttribute("alt",i18n.GL1329_1());
		customizableText.getElement().setAttribute("title",i18n.GL1329_1());
		
		teachText.setText(i18n.GL0181());
		teachText.getElement().setId("lblTeachText");
		teachText.getElement().setAttribute("alt",i18n.GL0181());
		teachText.getElement().setAttribute("title",i18n.GL0181());
		
		assignToStudents.setText(i18n.GL1067());
		assignToStudents.getElement().setId("lblAssignToStudents");
		assignToStudents.getElement().setAttribute("alt",i18n.GL1067());
		assignToStudents.getElement().setAttribute("title",i18n.GL1067());
		
		studyText.setText(i18n.GL0182());
		studyText.getElement().setId("lblStudyText");
		studyText.getElement().setAttribute("alt",i18n.GL0182());
		studyText.getElement().setAttribute("title",i18n.GL0182());
		
		completeAssignmentsText.setText(i18n.GL1330());
		completeAssignmentsText.getElement().setId("lblCompleteAssignmentsText");
		completeAssignmentsText.getElement().setAttribute("alt",i18n.GL1330());
		completeAssignmentsText.getElement().setAttribute("title",i18n.GL1330());
		
		watchVideoText.setText(i18n.GL1331());
		watchVideoText.getElement().setId("lblWatchVideoText");
		watchVideoText.getElement().setAttribute("alt",i18n.GL1331());
		watchVideoText.getElement().setAttribute("title",i18n.GL1331());
		
		orText.setText(" "+i18n.GL0209().toUpperCase()+" ");
		orText.getElement().setId("lblOrText");
		orText.getElement().setAttribute("alt",i18n.GL0209().toUpperCase());
		orText.getElement().setAttribute("title",i18n.GL0209().toUpperCase());
		
		learnmore.setText(i18n.GL0751());
		learnmore.getElement().setAttribute("alt",i18n.GL0751());
		learnmore.getElement().setAttribute("title",i18n.GL0751());
		
		videoIcon.setAltText(i18n.GL1332());
		videoIcon.getElement().setId("imgVideoIcon");
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
