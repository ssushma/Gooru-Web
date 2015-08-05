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

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.StandardFo;
import org.ednovo.gooru.client.mvp.home.LandingPageStyleCss;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FeaturedCollectionUc extends Composite{

	@UiField LandingPageStyleCss landingPageStyle;

	@UiField Label courseTitle, collectionTitle, gradeTag1, gradeTag2,createdByText,gradesText,standardsText;

	@UiField Anchor collectionAuthor;

	@UiField Image featuredCollectionImg;

	@UiField HTMLPanel collectionGrades, collectionStandards, standardsTab, creatorText;

	@UiField HTMLEventPanel featuredCollectionHoverEvent;

	@UiField HTML featuredCollectionDescription;

	private Label standardsLabel = new Label();

	private boolean displayStandardsLabel = false;

	private boolean displayGradesLabel = false;

	private String DEFAULT_COLLECTION_IMAGE = "images/default-collection-image-160x120.png";

	private static FeaturedCollectionUcUiBinder uiBinder = GWT
			.create(FeaturedCollectionUcUiBinder.class);

	interface FeaturedCollectionUcUiBinder extends
			UiBinder<Widget, FeaturedCollectionUc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public FeaturedCollectionUc(CollectionDo collectionDo) {
		initWidget(uiBinder.createAndBindUi(this));
		collectionAuthor.setStyleName(landingPageStyle.userNamePPPdisabled());
		featuredCollectionHoverEvent.addMouseOverHandler(new ShowHoverCollectionContainer());
		featuredCollectionHoverEvent.addMouseOutHandler(new HideHoverCollectionContainer());
		setCollectionData(collectionDo);

		courseTitle.getElement().setId("lblCourseTitle");
		featuredCollectionHoverEvent.getElement().setId("epnlFeaturedCollectionHoverEvent");
		featuredCollectionImg.getElement().setId("imgFeaturedCollection");
		featuredCollectionDescription.getElement().setId("htmlFeaturedCollectionDescription");
		collectionTitle.getElement().setId("lblCollectionTitle");
		creatorText.getElement().setId("pnlCreatorText");
		createdByText.getElement().setId("lblCreatedByText");
		collectionAuthor.getElement().setId("lnkCollectionAuthor");
		collectionGrades.getElement().setId("pnlCollectionGrades");
		gradesText.getElement().setId("lblGradesText");
		gradeTag1.getElement().setId("lblGradeTag1");
		gradeTag2.getElement().setId("lblGradeTag2");
		collectionStandards.getElement().setId("pnlCollectionStandards");
		standardsText.getElement().setId("lblStandardsText");
		standardsTab.getElement().setId("pnlStandardsTab");
	}

	private class ShowHoverCollectionContainer implements MouseOverHandler {
		@Override
		public void onMouseOver(MouseOverEvent event) {
			collectionTitle.setVisible(false);
			collectionAuthor.setVisible(false);
			if(displayGradesLabel){
				collectionGrades.setVisible(false);
			}
			if(displayStandardsLabel==true) {
				collectionStandards.setVisible(false);
			}
			creatorText.setVisible(false);
			featuredCollectionDescription.getElement().getStyle().setDisplay(Display.BLOCK);
		}
	}

	private class HideHoverCollectionContainer implements MouseOutHandler {
		@Override
		public void onMouseOut(MouseOutEvent event) {
			collectionTitle.setVisible(true);
			if(displayGradesLabel){
				collectionGrades.setVisible(true);
			}
			if(displayStandardsLabel==true) {
				collectionStandards.setVisible(true);
			}
			collectionAuthor.setVisible(true);
			creatorText.setVisible(true);
			featuredCollectionDescription.getElement().getStyle().clearDisplay();
		}
	}

	private void setCollectionData(final CollectionDo collectionDo) {
			createdByText.setText(i18n.GL0622()+" ");
			createdByText.getElement().setAttribute("alt",i18n.GL0622()+" ");
			createdByText.getElement().setAttribute("title",i18n.GL0622()+" ");

			gradesText.setText(i18n.GL1320_1());
			gradesText.getElement().setAttribute("alt",i18n.GL1320_1());
			gradesText.getElement().setAttribute("title",i18n.GL1320_1());

			standardsText.setText(i18n.GL0575());
			standardsText.getElement().setAttribute("alt",i18n.GL0575());
			standardsText.getElement().setAttribute("title",i18n.GL0575());

			collectionTitle.setText(collectionDo.getTitle());
			collectionTitle.getElement().setAttribute("alt",collectionDo.getTitle());
			collectionTitle.getElement().setAttribute("title",collectionDo.getTitle());

			collectionAuthor.setText(collectionDo.getUser().getUsernameDisplay());
			collectionAuthor.setStyleName(landingPageStyle.userNamePPPdisabled());

			try {
				int customFieldSize = collectionDo.getUser().getCustomFields().size();
				for(int i = 0; i < customFieldSize; i++) {
					if(collectionDo.getUser().getCustomFields().get(i).getOptionalValue().equalsIgnoreCase("true")) {
						collectionAuthor.removeStyleName(landingPageStyle.userNamePPPdisabled());
						collectionAuthor.setStyleName(landingPageStyle.userNamePPPenabled());
						collectionAuthor.setTarget("_blank");
						collectionAuthor.setHref("#profilepage&id="+collectionDo.getUser().getGooruUId()+"&user="+collectionDo.getUser().getUsername());
						collectionAuthor.addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								MixpanelUtil.ClickOnTheUsernameFromLandingPage();
							}
						});
					}
				}
			} catch(Exception e) {
				AppClientFactory.printSevereLogger("FCUc : setCollectionData : "+e.getMessage());
			}

			featuredCollectionImg.setUrl(StringUtil.formThumbnailName(collectionDo.getThumbnails().getUrl(),"-160x120."));
			featuredCollectionImg.setAltText(collectionDo.getTitle());
			featuredCollectionImg.setTitle(collectionDo.getTitle());
			featuredCollectionImg.addErrorHandler(new ErrorHandler() {
				@Override
				public void onError(ErrorEvent event) {
					featuredCollectionImg.setUrl(DEFAULT_COLLECTION_IMAGE);
					featuredCollectionImg.setAltText("Collection");
					featuredCollectionImg.setTitle(collectionDo.getTitle());
				}
			});
			featuredCollectionImg.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					MixpanelUtil.ClickTheCollectionsFromLandingPage();
					Map<String, String> params = new HashMap<String, String>();
					params.put("id", collectionDo.getGooruOid());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
				}
			});

			featuredCollectionDescription.setHTML(collectionDo.getGoals());
			try {
				if (collectionDo.getMetaInfo().getCourse().get(0)!=null) {
					if(collectionDo.getMetaInfo().getCourse().get(0).contains("English Language Arts"))
					{
						String courseTitleTxt=collectionDo.getMetaInfo().getCourse().get(0).replaceAll("English Language Arts", "ELA");
						courseTitle.setText(courseTitleTxt);
						courseTitle.getElement().setAttribute("alt",courseTitleTxt);
						courseTitle.getElement().setAttribute("title",courseTitleTxt);
					}
					else
					{
						courseTitle.setText(collectionDo.getMetaInfo().getCourse().get(0));
						courseTitle.getElement().setAttribute("alt",collectionDo.getMetaInfo().getCourse().get(0));
						courseTitle.getElement().setAttribute("title",collectionDo.getMetaInfo().getCourse().get(0));
					}
					} else {
					courseTitle.setVisible(false);
				}
			} catch (Exception e) {
				courseTitle.setVisible(false);
			}

			if (collectionDo.getMetaInfo() != null && collectionDo.getMetaInfo().getStandards() != null && collectionDo.getMetaInfo().getStandards().size() > 0) {
				for (StandardFo standard : collectionDo.getMetaInfo().getStandards()) {
					standardsLabel.setText(standard.getCode());
					standardsTab.add(new DownToolTipWidgetUc(standardsLabel, standard.getDescription()));
					displayStandardsLabel = true;
					break;
				}
			} else {
					collectionStandards.setVisible(false);
			}

			if(collectionDo.getGrade()!=null && !collectionDo.getGrade().isEmpty()) {
				try {
					String grades[] = collectionDo.getGrade().split(",");
					int gradeLength = grades.length;
					if(gradeLength == 0) {
						gradeTag1.setVisible(false);
						gradeTag2.setVisible(false);
						collectionGrades.setVisible(false);
					} else if (gradeLength == 1) {
						gradeTag1.setText(grades[0]);
						gradeTag2.setVisible(false);
						displayGradesLabel = true;
					} else {
						gradeTag1.setText(grades[0]);
						gradeTag2.setText(grades[1]);
						displayGradesLabel = true;
					}
				} catch (Exception e) {
					AppClientFactory.printSevereLogger("FCUc : setCollectionData : "+e.getMessage());
				}
			} else {
				collectionGrades.setVisible(false);
			}
	}
}
