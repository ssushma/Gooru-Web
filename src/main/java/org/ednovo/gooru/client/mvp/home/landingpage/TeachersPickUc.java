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

import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.featured.FeaturedCollectionContentDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.home.LandingPageStyleCss;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountEvent;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountHandler;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TeachersPickUc extends Composite{

	@UiField LandingPageStyleCss landingPageStyle;
	
	@UiField HTMLEventPanel featuredTab, mathTab, scienceTab, socialTab, languageTab;
	
	@UiField HTMLPanel featuredContainer, teachersPickPanel, panelTeachersPick;
	
	private Label teachersPickPanelLabel;
	
	private HTMLPanel featuredContent, mathContent, scienceContent, socialContent, languageContent, clearFix, loadingImage;
	
	private final String FEATURED_TAB = "featured";
	
	private final String MATH_TAB = "math";
	
	private final String SCIENCE_TAB = "science";

	private final String SOCIAL_TAB = "social-sciences";

	private final String LANGUAGE_TAB = "language-arts";

	private final String TEACHERS_PICK_DESCRIPTION = "This is the test hover for Teacher's pick";
	
	private static String loggedStatus = "success";
	private static TeachersPickUcUiBinder uiBinder = GWT
			.create(TeachersPickUcUiBinder.class);

	interface TeachersPickUcUiBinder extends UiBinder<Widget, TeachersPickUc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public TeachersPickUc() {
		initWidget(uiBinder.createAndBindUi(this));
		mathTab.addStyleName(landingPageStyle.courseTabsLiActive());
		featuredContent = new HTMLPanel("");
		mathContent = new HTMLPanel("");
		scienceContent = new HTMLPanel("");
		socialContent = new HTMLPanel("");
		languageContent = new HTMLPanel("");
		loadingImage = new HTMLPanel("");
		
		mathTab.getElement().setInnerText(i18n.GL1001());
		mathTab.getElement().setId("epnlMathTab");
		mathTab.getElement().setAttribute("alt",i18n.GL1001());
		mathTab.getElement().setAttribute("title",i18n.GL1001());
		
		scienceTab.getElement().setInnerText(i18n.GL1000());
		scienceTab.getElement().setId("epnlScienceTab");
		scienceTab.getElement().setAttribute("alt",i18n.GL1000());
		scienceTab.getElement().setAttribute("title",i18n.GL1000());
		
		socialTab.getElement().setInnerText(i18n.GL1002());
		socialTab.getElement().setId("epnlSocialTab");
		socialTab.getElement().setAttribute("alt",i18n.GL1002());
		socialTab.getElement().setAttribute("title",i18n.GL1002());
		
		languageTab.getElement().setInnerText(i18n.GL1003());
		languageTab.getElement().setId("epnLanguageTab");
		languageTab.getElement().setAttribute("alt",i18n.GL1003());
		languageTab.getElement().setAttribute("title",i18n.GL1003());
		
		featuredTab.getElement().setInnerText(i18n.GL1009());
		featuredTab.getElement().setId("epnlFeaturedTab");
		featuredTab.getElement().setAttribute("alt",i18n.GL1009());
		featuredTab.getElement().setAttribute("title",i18n.GL1009());
		
		loadingImage.setStyleName(landingPageStyle.loadingImage());
		featuredContainer.add(loadingImage);
		teachersPickPanelLabel = new Label(i18n.GL0198());
		teachersPickPanel.add(teachersPickPanelLabel);//new DownToolTipWidgetUc(teachersPickPanelLabel, TEACHERS_PICK_DESCRIPTION));
		getTeacherPickCollections(MATH_TAB);
		AppClientFactory.getEventBus().addHandler(SetTexasAccountEvent.TYPE,setTexasAccountHandler);
		panelTeachersPick.getElement().setId("panelTeachersPick");
		teachersPickPanel.getElement().setId("pnlTeachersPickPanel");
		featuredContainer.getElement().setId("pnlFeaturedContainer");
	}
	
	SetTexasAccountHandler setTexasAccountHandler=new SetTexasAccountHandler(){
		@Override
		public void setTexasAccountEvent(String loggedInStatus) {
			loggedStatus = loggedInStatus;
			
			featuredContent.clear();
			mathContent.clear();
			scienceContent.clear();
			socialContent.clear();
			languageContent.clear();
			
			if(featuredTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
				getTeacherPickCollections(FEATURED_TAB);
			} else if(mathTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
				getTeacherPickCollections(MATH_TAB);
			} else if(scienceTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
				getTeacherPickCollections(SCIENCE_TAB);
			} else if(socialTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
				getTeacherPickCollections(SOCIAL_TAB);
			} else if(languageTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
				getTeacherPickCollections(LANGUAGE_TAB);
			}
		}
	};

	private void getTeacherPickCollections(final String filterTab) {
		loadingImage.setVisible(true);
		AppClientFactory.getInjector().getHomeService().getFeaturedThemeCollection(filterTab, new SimpleAsyncCallback<List<FeaturedCollectionContentDo>>() {
			@Override
			public void onSuccess(List<FeaturedCollectionContentDo> result) {
				setTeacherPickCollections(result, filterTab);
			}
		});
	}
	
	private void setTeacherPickCollections(final List<FeaturedCollectionContentDo> collectionList, String filterTab) {
		if(filterTab.equalsIgnoreCase(FEATURED_TAB)) {
			for(int i = 0; i < collectionList.size(); i++) {
				featuredContent.add(new FeaturedCollectionUc(collectionList.get(i).getScollections().get(0)));
			}
			clearFix = new HTMLPanel("");
			clearFix.setStyleName(landingPageStyle.clearfix());
			featuredContent.add(clearFix);
			featuredContainer.add(featuredContent);
		} else if(filterTab.equalsIgnoreCase(MATH_TAB)) {
			for(int i = 0; i < collectionList.size(); i++) {
				mathContent.add(new FeaturedCollectionUc(collectionList.get(i).getScollections().get(0)));
			}
			clearFix = new HTMLPanel("");
			clearFix.setStyleName(landingPageStyle.clearfix());
			mathContent.add(clearFix);
			featuredContainer.add(mathContent);
		} else if(filterTab.equalsIgnoreCase(SCIENCE_TAB)) {
			for(int i = 0; i < collectionList.size(); i++) {
				scienceContent.add(new FeaturedCollectionUc(collectionList.get(i).getScollections().get(0)));
			}
			clearFix = new HTMLPanel("");
			clearFix.setStyleName(landingPageStyle.clearfix());
			scienceContent.add(clearFix);
			featuredContainer.add(scienceContent);
		} else if(filterTab.equalsIgnoreCase(SOCIAL_TAB)) {
			for(int i = 0; i < collectionList.size(); i++) {
				socialContent.add(new FeaturedCollectionUc(collectionList.get(i).getScollections().get(0)));
			}
			clearFix = new HTMLPanel("");
			clearFix.setStyleName(landingPageStyle.clearfix());
			socialContent.add(clearFix);
			featuredContainer.add(socialContent);
		} else if(filterTab.equalsIgnoreCase(LANGUAGE_TAB)) {
			for(int i = 0; i < collectionList.size(); i++) {
				languageContent.add(new FeaturedCollectionUc(collectionList.get(i).getScollections().get(0)));
			}
			clearFix = new HTMLPanel("");
			clearFix.setStyleName(landingPageStyle.clearfix());
			languageContent.add(clearFix);
			featuredContainer.add(languageContent);
		}
		loadingImage.setVisible(false);
	}
	
	private void displayContent(String filterTab) {
		if(filterTab.equalsIgnoreCase(FEATURED_TAB)) {
			featuredContent.getElement().getStyle().setDisplay(Display.BLOCK);
			mathContent.getElement().getStyle().setDisplay(Display.NONE);
			scienceContent.getElement().getStyle().setDisplay(Display.NONE);
			socialContent.getElement().getStyle().setDisplay(Display.NONE);
			languageContent.getElement().getStyle().setDisplay(Display.NONE);
		} else if(filterTab.equalsIgnoreCase(MATH_TAB)) {
			featuredContent.getElement().getStyle().setDisplay(Display.NONE);
			mathContent.getElement().getStyle().setDisplay(Display.BLOCK);
			scienceContent.getElement().getStyle().setDisplay(Display.NONE);
			socialContent.getElement().getStyle().setDisplay(Display.NONE);
			languageContent.getElement().getStyle().setDisplay(Display.NONE);
		} else if(filterTab.equalsIgnoreCase(SCIENCE_TAB)) {
			featuredContent.getElement().getStyle().setDisplay(Display.NONE);
			mathContent.getElement().getStyle().setDisplay(Display.NONE);
			scienceContent.getElement().getStyle().setDisplay(Display.BLOCK);
			socialContent.getElement().getStyle().setDisplay(Display.NONE);
			languageContent.getElement().getStyle().setDisplay(Display.NONE);
		} else if(filterTab.equalsIgnoreCase(SOCIAL_TAB)) {
			featuredContent.getElement().getStyle().setDisplay(Display.NONE);
			mathContent.getElement().getStyle().setDisplay(Display.NONE);
			scienceContent.getElement().getStyle().setDisplay(Display.NONE);
			socialContent.getElement().getStyle().setDisplay(Display.BLOCK);
			languageContent.getElement().getStyle().setDisplay(Display.NONE);
		} else if(filterTab.equalsIgnoreCase(LANGUAGE_TAB)) {
			featuredContent.getElement().getStyle().setDisplay(Display.NONE);
			mathContent.getElement().getStyle().setDisplay(Display.NONE);
			scienceContent.getElement().getStyle().setDisplay(Display.NONE);
			socialContent.getElement().getStyle().setDisplay(Display.NONE);
			languageContent.getElement().getStyle().setDisplay(Display.BLOCK);
		}
	}
	
	@UiHandler("featuredTab")
	void onClickFeaturedTab(ClickEvent event) {
		if(!featuredTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
			MixpanelUtil.ClickOnFeatured();
			displayContent(FEATURED_TAB);
			if(!(featuredContent.getWidgetCount()>0)) {
				getTeacherPickCollections(FEATURED_TAB);
			}
			featuredTab.addStyleName(landingPageStyle.courseTabsLiActive());
			mathTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			scienceTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			socialTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			languageTab.removeStyleName(landingPageStyle.courseTabsLiActive());		
		}
	}

	@UiHandler("mathTab")
	void onClickMathTab(ClickEvent event) {
		if(!mathTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
			MixpanelUtil.ClickOnMathTab();
			displayContent(MATH_TAB);
			if(!(mathContent.getWidgetCount()>0)) {
				getTeacherPickCollections(MATH_TAB);
			}
			featuredTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			mathTab.addStyleName(landingPageStyle.courseTabsLiActive());
			scienceTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			socialTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			languageTab.removeStyleName(landingPageStyle.courseTabsLiActive());		
		}
	}

	@UiHandler("scienceTab")
	void onClickScienceTab(ClickEvent event) {
		if(!scienceTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
			MixpanelUtil.ClickOnScienceTab();
			displayContent(SCIENCE_TAB);
			if(!(scienceContent.getWidgetCount()>0)) {
				getTeacherPickCollections(SCIENCE_TAB);
			}
			featuredTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			mathTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			scienceTab.addStyleName(landingPageStyle.courseTabsLiActive());
			socialTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			languageTab.removeStyleName(landingPageStyle.courseTabsLiActive());		
		}
	}

	@UiHandler("socialTab")
	void onClickSocialTab(ClickEvent event) {
		if(!socialTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
			MixpanelUtil.ClickOnSocialSciencesTab();
			displayContent(SOCIAL_TAB);
			if(!(socialContent.getWidgetCount()>0)) {
				getTeacherPickCollections(SOCIAL_TAB);
			}
			featuredTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			mathTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			scienceTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			socialTab.addStyleName(landingPageStyle.courseTabsLiActive());
			languageTab.removeStyleName(landingPageStyle.courseTabsLiActive());		
		}
	}

	@UiHandler("languageTab")
	void onClickLanguageTab(ClickEvent event) {
		if(!languageTab.getStyleName().contains(landingPageStyle.courseTabsLiActive())) {
			MixpanelUtil.ClickOnLanguageArtsTab();
			displayContent(LANGUAGE_TAB);
			if(!(languageContent.getWidgetCount()>0)) {
				getTeacherPickCollections(LANGUAGE_TAB);
			}
			featuredTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			mathTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			scienceTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			socialTab.removeStyleName(landingPageStyle.courseTabsLiActive());
			languageTab.addStyleName(landingPageStyle.courseTabsLiActive());		
		}
	}
}
