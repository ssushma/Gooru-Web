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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.LandingPageStyleCss;
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
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
	/**
	 * 
	 * @fileName : GooruInClassRoomVc.java
	 *
	 * @description : Based on tab filters it will display tabcontent data by passing respective class room data.
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
public class GooruInClassRoomVc extends Composite {

	@UiField LandingPageStyleCss landingPageStyle;

	@UiField HTMLEventPanel gooruCrTab1, gooruCrTab2, gooruCrTab3, gooruCrTab4, gooruCrTab5;
	
	@UiField HTMLPanel methodsContentContainer, panelGooruClassRoom;
	
	@UiField Anchor backto;
	
	private List<String> gooruClassCollectionList = new ArrayList<String>();
	
	private List<String> gooruClassRoomHowToUse = new ArrayList<String>();
	
	private HTMLPanel tabContent1, tabContent2, tabContent3, tabContent4, tabContent5, loadingImage;
	
	private final String CLASSROOM_TAB1 = "gooruCrTab1";

	private final String CLASSROOM_TAB2 = "gooruCrTab2";

	private final String CLASSROOM_TAB3 = "gooruCrTab3";

	private final String CLASSROOM_TAB4 = "gooruCrTab4";

	private final String CLASSROOM_TAB5 = "gooruCrTab5";
	
	private final String BLENDED_TITLE=MessageProperties.GL0148;

	private final String BLENDED_USE_CASE=MessageProperties.GL0149;

	private final String BLENDED_DESCRIPTION=MessageProperties.GL0150;

	private final String FLIPPED_TITLE=MessageProperties.GL0151;

	private final String FLIPPED_USE_CASE=MessageProperties.GL0152;

	private final String FLIPPED_DESCRIPTION=MessageProperties.GL0153;

	private final String ASSESSMENT_TITLE=MessageProperties.GL0154;

	private final String ASSESSMENT_USE_CASE=MessageProperties.GL0155;

	private final String ASSESSMENT_DESCRIPTION=MessageProperties.GL0156;

	private final String PROJECT_TITLE=MessageProperties.GL0157;

	private final String PROJECT_USE_CASE=MessageProperties.GL0158;

	private final String PROJECT_DESCRIPTION=MessageProperties.GL0159;

	private final String ENRICHED_TITLE=MessageProperties.GL0160;

	private final String ENRICHED_USE_CASE=MessageProperties.GL0161;

	private final String ENRICHED_DESCRIPTION=MessageProperties.GL0162;

	private final String CLASSROOM = "classroom";
	
	List<FeaturedCollectionContentDo> classroomContent = null;
	
	private static GooruInClassRoomVcUiBinder uiBinder = GWT
			.create(GooruInClassRoomVcUiBinder.class);

	interface GooruInClassRoomVcUiBinder extends
			UiBinder<Widget, GooruInClassRoomVc> {
	}
	/**
	 * Constructor.
	 */
	public GooruInClassRoomVc() {
		initWidget(uiBinder.createAndBindUi(this));
		tabContent1 = new HTMLPanel("");
		tabContent2 = new HTMLPanel("");
		tabContent3 = new HTMLPanel("");
		tabContent4 = new HTMLPanel("");
		tabContent5 = new HTMLPanel("");
		loadingImage = new HTMLPanel("");
		loadingImage.setStyleName(landingPageStyle.loadingImage());
		methodsContentContainer.add(loadingImage);
		gooruClassCollectionList = Arrays.asList(AppClientFactory.getLoggedInUser().getCollectionFilterProperties().getClassroomUseCases().split(","));
		gooruClassRoomHowToUse = Arrays.asList(AppClientFactory.getLoggedInUser().getCollectionFilterProperties().getClassroomHowToUse().split(","));
		gooruCrTab1.addStyleName(landingPageStyle.methodsLiActive());
		setTabbedContent(CLASSROOM_TAB1);
		panelGooruClassRoom.getElement().setId("panelGooruClassRoom");
		backto.getElement().setId("lnkBackTo");
		
	}
	/**
	 * 
	 * @function setTabbedContent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will do service call by cassing CLASSROOM data ,and it will call setData() method by passing the result as a parameter.
	 * 
	 * 
	 * @parm(s) : @param tabFilter
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setTabbedContent(String tabFilter) {
		loadingImage.setVisible(true);
		AppClientFactory.getInjector().getHomeService().getFeaturedThemeCollection(CLASSROOM, new SimpleAsyncCallback<List<FeaturedCollectionContentDo>>() {
			@Override
			public void onSuccess(List<FeaturedCollectionContentDo> result) {
				classroomContent = result;
				setData(classroomContent);
			}
		});
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will set the classroomContent to respective tabContent.
	 * 
	 * 
	 * @parm(s) : @param classroomContent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setData(List<FeaturedCollectionContentDo> classroomContent) {
		tabContent1.add(new GooruClassRoomCollectionUc(classroomContent.get(0), CLASSROOM_TAB1, BLENDED_TITLE, BLENDED_USE_CASE, BLENDED_DESCRIPTION, gooruClassRoomHowToUse.get(0)));
		methodsContentContainer.add(tabContent1);
		tabContent2.add(new GooruClassRoomCollectionUc(classroomContent.get(1), CLASSROOM_TAB2, FLIPPED_TITLE, FLIPPED_USE_CASE, FLIPPED_DESCRIPTION, gooruClassRoomHowToUse.get(1)));
		methodsContentContainer.add(tabContent2);
		tabContent3.add(new GooruClassRoomCollectionUc(classroomContent.get(2), CLASSROOM_TAB3, ASSESSMENT_TITLE, ASSESSMENT_USE_CASE, ASSESSMENT_DESCRIPTION, gooruClassRoomHowToUse.get(2)));
		methodsContentContainer.add(tabContent3);
		tabContent4.add(new GooruClassRoomCollectionUc(classroomContent.get(3), CLASSROOM_TAB4, PROJECT_TITLE, PROJECT_USE_CASE, PROJECT_DESCRIPTION, gooruClassRoomHowToUse.get(3)));
		methodsContentContainer.add(tabContent4);
		tabContent5.add(new GooruClassRoomCollectionUc(classroomContent.get(4), CLASSROOM_TAB5, ENRICHED_TITLE, ENRICHED_USE_CASE, ENRICHED_DESCRIPTION, gooruClassRoomHowToUse.get(4)));
		methodsContentContainer.add(tabContent5);
		displayContent(CLASSROOM_TAB1);
		loadingImage.setVisible(false);
	}
	/**
	 * 
	 * @function displayContent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will dispaly content based on tabFilter.
	 * 
	 * 
	 * @parm(s) : @param tabFilter
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void displayContent(String tabFilter) {
		loadingImage.setVisible(true);
		if(tabFilter.equalsIgnoreCase(CLASSROOM_TAB1)) {
			tabContent1.getElement().getStyle().setDisplay(Display.BLOCK);
			tabContent2.getElement().getStyle().setDisplay(Display.NONE);
			tabContent3.getElement().getStyle().setDisplay(Display.NONE);
			tabContent4.getElement().getStyle().setDisplay(Display.NONE);
			tabContent5.getElement().getStyle().setDisplay(Display.NONE);
		} else if(tabFilter.equalsIgnoreCase(CLASSROOM_TAB2)) {
			tabContent1.getElement().getStyle().setDisplay(Display.NONE);
			tabContent2.getElement().getStyle().setDisplay(Display.BLOCK);
			tabContent3.getElement().getStyle().setDisplay(Display.NONE);
			tabContent4.getElement().getStyle().setDisplay(Display.NONE);
			tabContent5.getElement().getStyle().setDisplay(Display.NONE);
		} else if(tabFilter.equalsIgnoreCase(CLASSROOM_TAB3)) {
			tabContent1.getElement().getStyle().setDisplay(Display.NONE);
			tabContent2.getElement().getStyle().setDisplay(Display.NONE);
			tabContent3.getElement().getStyle().setDisplay(Display.BLOCK);
			tabContent4.getElement().getStyle().setDisplay(Display.NONE);
			tabContent5.getElement().getStyle().setDisplay(Display.NONE);
		} else if(tabFilter.equalsIgnoreCase(CLASSROOM_TAB4)) {
			tabContent1.getElement().getStyle().setDisplay(Display.NONE);
			tabContent2.getElement().getStyle().setDisplay(Display.NONE);
			tabContent3.getElement().getStyle().setDisplay(Display.NONE);
			tabContent4.getElement().getStyle().setDisplay(Display.BLOCK);
			tabContent5.getElement().getStyle().setDisplay(Display.NONE);
		} else if(tabFilter.equalsIgnoreCase(CLASSROOM_TAB5)) {
			tabContent1.getElement().getStyle().setDisplay(Display.NONE);
			tabContent2.getElement().getStyle().setDisplay(Display.NONE);
			tabContent3.getElement().getStyle().setDisplay(Display.NONE);
			tabContent4.getElement().getStyle().setDisplay(Display.NONE);
			tabContent5.getElement().getStyle().setDisplay(Display.BLOCK);
		}
		loadingImage.setVisible(false);
	}
	/**
	 * 
	 * @function onClickGooruCrTab1 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandlers for gooruCrTab1.It will enable the landing page styles for gooruCrTab1.
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
	@UiHandler("gooruCrTab1")
	void onClickGooruCrTab1(ClickEvent event) {
		MixpanelUtil. ClickOnBlendedLearning();
		if(!gooruCrTab1.getStyleName().contains(landingPageStyle.methodsLiActive())) {
			displayContent(CLASSROOM_TAB1);
			if(!(tabContent1.getWidgetCount()>0)) {
				loadingImage.setVisible(true);
				setTabbedContent(CLASSROOM_TAB1);
			}
			gooruCrTab1.addStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab2.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab3.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab4.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab5.removeStyleName(landingPageStyle.methodsLiActive());		
		}
	}
	/**
	 * 
	 * @function onClickGooruCrTab1 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandlers for gooruCrTab2.It will enable the landing page styles for gooruCrTab2.
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
	@UiHandler("gooruCrTab2")
	void onClickGooruCrTab2(ClickEvent event) {
		MixpanelUtil.ClickOnFlippedClassRoom();
		if(!gooruCrTab2.getStyleName().contains(landingPageStyle.methodsLiActive())) {
			displayContent(CLASSROOM_TAB2);
			if(!(tabContent2.getWidgetCount()>0)) {
				loadingImage.setVisible(true);
				setTabbedContent(CLASSROOM_TAB2);
			}
			gooruCrTab1.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab2.addStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab3.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab4.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab5.removeStyleName(landingPageStyle.methodsLiActive());
		}
	}
	/**
	 * 
	 * @function onClickGooruCrTab1 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandlers for gooruCrTab3.It will enable the landing page styles for gooruCrTab3.
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
	@UiHandler("gooruCrTab3")
	void onClickGooruCrTab3(ClickEvent event) {
		MixpanelUtil.ClickOnAssesments();
		if(!gooruCrTab3.getStyleName().contains(landingPageStyle.methodsLiActive())) {
			displayContent(CLASSROOM_TAB3);
			if(!(tabContent3.getWidgetCount()>0)) {
				loadingImage.setVisible(true);
				setTabbedContent(CLASSROOM_TAB3);
			}
			gooruCrTab1.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab2.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab3.addStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab4.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab5.removeStyleName(landingPageStyle.methodsLiActive());		
		}
	}
	/**
	 * 
	 * @function onClickGooruCrTab1 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandlers for gooruCrTab4.It will enable the landing page styles for gooruCrTab4.
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
	@UiHandler("gooruCrTab4")
	void onClickGooruCrTab4(ClickEvent event) {
		MixpanelUtil.ClickOnProjectBasedLearning();
		if(!gooruCrTab4.getStyleName().contains(landingPageStyle.methodsLiActive())) {
			displayContent(CLASSROOM_TAB4);
			if(!(tabContent4.getWidgetCount()>0)) {
				loadingImage.setVisible(true);
				setTabbedContent(CLASSROOM_TAB4);
			}
			gooruCrTab1.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab2.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab3.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab4.addStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab5.removeStyleName(landingPageStyle.methodsLiActive());		
		}
	}
	/**
	 * 
	 * @function onClickGooruCrTab1 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandlers for gooruCrTab5.It will enable the landing page styles for gooruCrTab5.
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
	@UiHandler("gooruCrTab5")
	void onClickGooruCrTab5(ClickEvent event) {
		MixpanelUtil.ClickOnEnrichedInstruction();
		if(!gooruCrTab5.getStyleName().contains(landingPageStyle.methodsLiActive())) {
			displayContent(CLASSROOM_TAB5);
			if(!(tabContent5.getWidgetCount()>0)) {
				loadingImage.setVisible(true);
				setTabbedContent(CLASSROOM_TAB5);
			}
			gooruCrTab1.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab2.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab3.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab4.removeStyleName(landingPageStyle.methodsLiActive());
			gooruCrTab5.addStyleName(landingPageStyle.methodsLiActive());		
		}
	}
}
