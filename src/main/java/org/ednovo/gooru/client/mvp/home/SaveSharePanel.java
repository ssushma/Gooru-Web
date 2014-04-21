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


import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public abstract class SaveSharePanel extends PopupPanel implements MessageProperties{

 
	@UiField
	Anchor gettingAnchr;
	@UiField FlowPanel helpContainer;
 
	@UiField HTMLPanel saveSharePanelContentContainer;
	
	@UiField HTMLEventPanel closeButton;
	
	@UiField Label quickHelpText,whatText,discoverText,searchText,organizeText,lessonText,teachLbl,
	teachLessonTitle,tLNo_ONE,thinkAboutText,tLNo_TWO,answerThisText,studyLbl,visitText;
	
	@UiField Image closeButtonText,helpImage,videoBigIconImage,plusIconImage,textBookBigIconImage,plusImage,
	topArrowImage,smalllArrowImage,studyImage;
	
	@UiField Anchor howDoISearchText,whichTypeText,filtersText,seeMoreLbl,saveResourceText,narrationText,collectionShareText,
	seeMoreLabel,howtoTeachText,classPageText,shareClasspageText,seeMoreTeachLbl,startAssignmentText,seemoreStudyLbl,
	supportCenterLbl;
	
	private static FaqSlideUiBinder uiBinder = GWT
			.create(FaqSlideUiBinder.class);

	@UiTemplate("SaveSharePanel.ui.xml")
	interface FaqSlideUiBinder extends UiBinder<Widget, SaveSharePanel> {
	}

	/**
	 * Class constructor
	 */
	public SaveSharePanel() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		this.setStyleName("");
		this.getElement().getStyle().setZIndex(9999);
		saveSharePanelContentContainer.getElement().getStyle().setDisplay(Display.NONE);
		quickHelpText.setText(GL1287+GL_SPL_SEMICOLON);	
		gettingAnchr.setText(GL1288);
		whatText.setText(GL1289+GL_SPL_QUESTION);
		closeButtonText.setTitle(GL1050);
		closeButtonText.setAltText(GL1050);
		closeButtonText.setUrl("images/close-button.png");
		discoverText.setText(GL0179);
		searchText.setText(GL0176);
		helpImage.setUrl("images/02_help.png");
		howDoISearchText.setText(GL1290+GL_SPL_QUESTION);
		howDoISearchText.setHref("http://support.goorulearning.org/entries/23254041");
		whichTypeText.setHref("http://support.goorulearning.org/entries/23254171");
		filtersText.setText(GL1292+GL_SPL_QUESTION);
		filtersText.setHref("http://support.goorulearning.org/entries/23269257");
		seeMoreLbl.setText(GL0508);
		seeMoreLbl.setHref("http://support.goorulearning.org/forums/22070013-Discover");
		organizeText.setText(GL0180);
		videoBigIconImage.setUrl("images/video-big-icon.png");
		plusIconImage.setUrl("images/plus-icon.png");
		plusImage.setUrl("images/plus-icon.png");
		topArrowImage.setUrl("images/top-arrow.png");
		smalllArrowImage.setUrl("images/small-arrow.png");
		textBookBigIconImage.setUrl("images/text-book-big-icon.png");
		lessonText.setText(GL1296);
		saveResourceText.setText(GL1297+GL_SPL_QUESTION);
		saveResourceText.setHref("http://support.goorulearning.org/entries/23277268");
		narrationText.setText(GL1298+GL_SPL_QUESTION);
		narrationText.setHref("http://support.goorulearning.org/entries/23277558");
		collectionShareText.setText(GL1299+GL_SPL_QUESTION);
		collectionShareText.setHref("http://support.goorulearning.org/entries/23277568");
		seeMoreLabel.setText(GL0508);
		seeMoreLabel.setHref("http://support.goorulearning.org/forums/22084787-Organize");
		teachLbl.setText(GL0181);
		teachLessonTitle.setText(GL1296);
		tLNo_ONE.setText(GL_GRR_NUMERIC_ONE);
		thinkAboutText.setText(GL1300);
		tLNo_TWO.setText(GL_GRR_NUMERIC_TWO);
		answerThisText.setText(GL1301);
		howtoTeachText.setText(GL1302+GL_SPL_QUESTION);
		howtoTeachText.setHref("http://support.goorulearning.org/entries/24075976");
		classPageText.setText(GL1303+GL_SPL_QUESTION);
		classPageText.setHref("http://support.goorulearning.org/entries/24061522");
		shareClasspageText.setText(GL1304+GL_SPL_QUESTION);
		shareClasspageText.setHref("http://support.goorulearning.org/entries/24064511");
		seeMoreTeachLbl.setHref("http://support.goorulearning.org/forums/22161812");
		seeMoreTeachLbl.setText(GL0508);
		studyLbl.setText(GL0594);
		studyImage.setUrl("images/study-image.png");
		startAssignmentText.setText(GL1305+GL_SPL_QUESTION);
		startAssignmentText.setHref("http://support.goorulearning.org/entries/24076673");
		seemoreStudyLbl.setText(GL0508);
		seemoreStudyLbl.setHref("http://support.goorulearning.org/forums/22157603");
		visitText.setText(GL1306);
		supportCenterLbl.setText(GL1307);
		supportCenterLbl.setHref("http://support.goorulearning.org/forums");
		gettingAnchr.setHref("http://www.goorulearning.org/#!collection-play&id=f96a3e33-4250-406d-8c95-f3f6332ac659");
		gettingAnchr.setTarget("_blank");
	}
	@Override
	public void onLoad(){
		super.onLoad();
		if(isAttached()){
			new CustomAnimation(saveSharePanelContentContainer).run(500);
		}
		
	}
	
	@UiHandler("closeButton")
	public abstract void closeButton(ClickEvent clickEvent);
	
}
