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
import org.ednovo.gooru.application.shared.model.featured.FeaturedCollectionContentDo;
import org.ednovo.gooru.client.mvp.home.LandingPageStyleCss;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class GooruClassRoomCollectionUc extends Composite{

	@UiField LandingPageStyleCss landingPageStyle;
	
	@UiField Image methodsCollection;
	
	@UiField Label contentTitle, howToUseTitle;
	
	@UiField HTML contentDescription;
	
	@UiField HTMLPanel howToUseDescription;
	
	private final String CLASSROOM_TAB1 = "gooruCrTab1";

	private final String CLASSROOM_TAB2 = "gooruCrTab2";

	private final String CLASSROOM_TAB3 = "gooruCrTab3";

	private final String CLASSROOM_TAB4 = "gooruCrTab4";

	private final String CLASSROOM_TAB5 = "gooruCrTab5";
	
	private String Tabfilter="";
	
	private InlineLabel worksOnGooruLbl1;
	
	private InlineLabel worksOnGooruLbl2;

	private static GooruClassRoomCollectionUcUiBinder uiBinder = GWT
			.create(GooruClassRoomCollectionUcUiBinder.class);

	interface GooruClassRoomCollectionUcUiBinder extends
			UiBinder<Widget, GooruClassRoomCollectionUc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public GooruClassRoomCollectionUc(FeaturedCollectionContentDo featuredCollectionContentDo, String tabfilter, String title, String useCase, String description, String collectionId) {
		initWidget(uiBinder.createAndBindUi(this));
		this.Tabfilter=tabfilter;
		worksOnGooruLbl1 = new InlineLabel();
		worksOnGooruLbl2 = new InlineLabel();
		setData(featuredCollectionContentDo, title, useCase, description,collectionId);
		
		methodsCollection.getElement().setId("imgMethodsCollection");
		contentTitle.getElement().setId("lblContentTitle");
		contentDescription.getElement().setId("htmlContentDescription");
		howToUseTitle.getElement().setId("lblHowToUseTitle");
		howToUseDescription.getElement().setId("pnlHowToUseDescription");
	}
	
	private void setData(final FeaturedCollectionContentDo featuredCollectionContentDo, String title, String useCase, String description, final String collectionId) {

		methodsCollection.setUrl(StringUtil.formThumbnailName(featuredCollectionContentDo.getScollections().get(0).getThumbnailUrl(),"-266x200."));
		methodsCollection.setAltText(featuredCollectionContentDo.getScollections().get(0).getTitle());
		methodsCollection.setTitle(featuredCollectionContentDo.getScollections().get(0).getTitle());
		methodsCollection.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SetTab(Tabfilter);
				Map<String, String> params = new HashMap<String, String>();
				params.put("id", featuredCollectionContentDo.getScollections().get(0).getGooruOid());
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
			}
		});
		methodsCollection.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				methodsCollection.setUrl("images/collection-default-image.png");
			}
		});
		
		contentTitle.setText(title);
		contentTitle.getElement().setAttribute("alt",title);
		contentTitle.getElement().setAttribute("title",title);
		contentTitle.getElement().getStyle().setMarginBottom(3, Unit.PX);
		contentDescription.setHTML(useCase);
		contentDescription.getElement().setAttribute("alt",useCase);
		contentDescription.getElement().setAttribute("title",useCase);
		contentDescription.getElement().getStyle().setMarginBottom(10, Unit.PX);
		
		if(!collectionId.equalsIgnoreCase("na")) {
			String[] lengthDescription = description.split("\\.");
			worksOnGooruLbl2.setText(lengthDescription[lengthDescription.length-1]+".");
			description = description.replaceAll(lengthDescription[lengthDescription.length-1]+".","");
			worksOnGooruLbl1.setText(description);
			worksOnGooruLbl2.setStyleName(landingPageStyle.collectionInlineMsg());
			howToUseDescription.add(worksOnGooruLbl1);
			howToUseDescription.add(worksOnGooruLbl2);
			worksOnGooruLbl2.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("id", collectionId);
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
				}
			});
		} else {
			howToUseDescription.add(new HTML(description));
		}
		howToUseTitle.setText(i18n.GL1321());
		howToUseTitle.getElement().setAttribute("alt",i18n.GL1321());
		howToUseTitle.getElement().setAttribute("title",i18n.GL1321());
		howToUseTitle.getElement().getStyle().setMarginBottom(3, Unit.PX);
	}
	
	private void SetTab(String Tabfilter) {
		if(Tabfilter.equalsIgnoreCase(CLASSROOM_TAB1)){
			MixpanelUtil.ClickOnBlendedLearningCollection();
		} else if(Tabfilter.equalsIgnoreCase(CLASSROOM_TAB2)){
			MixpanelUtil.ClickOnFlippedClassRoomCollection();
		} else if(Tabfilter.equalsIgnoreCase(CLASSROOM_TAB3)){
			MixpanelUtil.ClickOnAssesmentsCollection();
		} else if(Tabfilter.equalsIgnoreCase(CLASSROOM_TAB4)){
			MixpanelUtil.ClickOnProjectBasedLearningCollection();
		} else if(Tabfilter.equalsIgnoreCase(CLASSROOM_TAB5)){
			MixpanelUtil.ClickOnEnrichedInstructionCollection();
		}
	}	
}
