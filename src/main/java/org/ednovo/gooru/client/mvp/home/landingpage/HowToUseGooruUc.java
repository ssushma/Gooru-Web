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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : HowToUseGooruUc.java
 *
 * @description :This file is used to embed the youtube player in youTubePlayerContainer.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class HowToUseGooruUc extends Composite {

	@UiField Anchor youTubePlayerContainer;
	@UiField Anchor learnmore,backto;
	@UiField HTMLPanel panelHowToUseGooru;
	
	private final String YOUTUBE_FEATURED_URL = "http://www.youtube.com/v/nq9HTYiv7jM";
	
	YoutubePopupVc youtubePopupVc = null;
	private static HowToUseGooruUcUiBinder uiBinder = GWT
			.create(HowToUseGooruUcUiBinder.class);

	interface HowToUseGooruUcUiBinder extends UiBinder<Widget, HowToUseGooruUc> {
	}
	/**
	 * Constructor.
	 */
	public HowToUseGooruUc() {
		initWidget(uiBinder.createAndBindUi(this));
		panelHowToUseGooru.getElement().setId("panelHowToUseGooru");
		youTubePlayerContainer.getElement().setId("lnkYouTube");
		learnmore.getElement().setId("lnkLearnMore");
		backto.getElement().setId("lnkBackTo");
	}
	/**
	 * 
	 * @function openYoutubeContainer 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :It will load the youtube in youTubePlayerContainer.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("youTubePlayerContainer")
	public void openYoutubeContainer(ClickEvent event) {
		MixpanelUtil.ClickOnVideo();
		youtubePopupVc = new YoutubePopupVc("", loadYouTube());
	}
	/**
	 * 
	 * @function loadYouTube 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To Embed the youtube Data.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public String loadYouTube(){
         String height ="500";
         String width="800";
         String  embeddableHtmlString = "<embed type=\"application/x-shockwave-flash\" src=\""+YOUTUBE_FEATURED_URL+"?amp;rel=0&amp;enablejsapi=1&amp;version=3&amp;autoplay=0&amp;start=1\""
               + " width=\""+width+"\" height=\""+height+"\" id=\"embed\"  quality=\"high\" allowfullscreen=\"true\" allowscriptaccess=\"always\" autoplay=\"0\" wmode=\"opaque\">";
         return embeddableHtmlString;
	}
	/**
	 * 
	 * @function onlearnmoreClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :On Learnmore click it will display information about gooru.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("learnmore")
	public void onlearnmoreClicked(ClickEvent clickEvent) {
		MixpanelUtil.ClickOnAboutGooruLearningOrg();
	}
}
