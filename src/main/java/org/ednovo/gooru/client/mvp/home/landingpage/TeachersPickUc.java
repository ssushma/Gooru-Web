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

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.LandingPageStyleCss;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountEvent;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountHandler;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.featured.FeaturedCollectionContentDo;
import org.ednovo.gooru.shared.util.MessageProperties;

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

public class TeachersPickUc extends Composite implements MessageProperties{

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
	/**
	 * Constructor
	 */
	public TeachersPickUc() {
		initWidget(uiBinder.createAndBindUi(this));
		mathTab.addStyleName(landingPageStyle.courseTabsLiActive());
		featuredContent = new HTMLPanel("");
		mathContent = new HTMLPanel("");
		scienceContent = new HTMLPanel("");
		socialContent = new HTMLPanel("");
		languageContent = new HTMLPanel("");
		loadingImage = new HTMLPanel("");
		loadingImage.setStyleName(landingPageStyle.loadingImage());
		featuredContainer.add(loadingImage);
		teachersPickPanelLabel = new Label(MessageProperties.GL0198);
		teachersPickPanel.add(teachersPickPanelLabel);//new DownToolTipWidgetUc(teachersPickPanelLabel, TEACHERS_PICK_DESCRIPTION));
		getTeacherPickCollections(MATH_TAB);
		AppClientFactory.getEventBus().addHandler(SetTexasAccountEvent.TYPE,setTexasAccountHandler);
		panelTeachersPick.getElement().setId("panelTeachersPick");
	}
	/**
	 * This will insert particular FEATURED_TAB data into featuredContent based on landingPageStyles.
	 */
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
	/**
	 * 
	 * @function getTeacherPickCollections 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Based on filterTab it will set the data into TeacherPickCollections.
	 * 
	 * 
	 * @parm(s) : @param filterTab
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void getTeacherPickCollections(final String filterTab) {
		loadingImage.setVisible(true);
		AppClientFactory.getInjector().getHomeService().getFeaturedThemeCollection(filterTab, new SimpleAsyncCallback<List<FeaturedCollectionContentDo>>() {
			@Override
			public void onSuccess(List<FeaturedCollectionContentDo> result) {
				setTeacherPickCollections(result, filterTab);
			}
		});
	}
	/**
	 * This will insert particular data into featuredContent based on filterTab.
	 */
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
	/**
	 * 
	 * @function displayContent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will dispaly content based on filter tab.
	 * 
	 * 
	 * @parm(s) : @param filterTab
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
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
	/**
	 * 
	 * @function onClickFeaturedTab 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will enable the css styles of all the tabs(featuredTab,mathTab,scienceTab,loggedStatus)
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
	/**
	 * 
	 * @function onClickFeaturedTab 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will enable the css styles of mathTab
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
	/**
	 * 
	 * @function onClickFeaturedTab 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will enable the css styles of scienceTab
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
	/**
	 * 
	 * @function onClickFeaturedTab 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will enable the css styles of socialTab
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
	/**
	 * 
	 * @function onClickFeaturedTab 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will enable the css styles of languageTab
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
