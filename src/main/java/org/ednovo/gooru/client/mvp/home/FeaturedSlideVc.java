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

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.home.HomeCBundle;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.featured.FeaturedContentDo;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class FeaturedSlideVc extends Composite{

	private static FeaturedSlideVcUiBinder uiBinder = GWT.create(FeaturedSlideVcUiBinder.class);

	interface FeaturedSlideVcUiBinder extends UiBinder<Widget, FeaturedSlideVc> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField
	ParagraphElement contentDisplayTitle;

	@UiField(provided = true)
	HomeCBundle res;

	@UiField
	FocusPanel collectionStudyButtonFocPanel;

	@UiField
	Hidden collectionGooruOid;

	@UiField Label didYouKnowText;

	@UiField
	StudyFeaturedCollection studyFeaturedCollection;



	/**
	 * Class constructor , assign featuredContentDo instance and initialise  mouse over , mouse out methods
	 *
	 * @param featuredContentDo instance of {@link FeaturedContentDo}
	 */
	public FeaturedSlideVc(FeaturedContentDo featuredContentDo) {
		this.res = HomeCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		didYouKnowText.setText(i18n.GL1241());
		didYouKnowText.getElement().setId("lblDidYouKnowText");
		didYouKnowText.getElement().setAttribute("alt",i18n.GL1241());
		didYouKnowText.getElement().setAttribute("title",i18n.GL1241());
		contentDisplayTitle.setId("pContentDisplayTitle");
		this.setData(featuredContentDo);
		collectionStudyButtonFocPanel.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				  if( FeaturedContentVc.elapsedTimer != null){
				  FeaturedContentVc.elapsedTimer.cancel();
				  }
				  studyFeaturedCollection.featuredStartStudyFloPanel.setVisible(true);

			}
		});
		collectionStudyButtonFocPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				if( FeaturedContentVc.elapsedTimer != null){
			  //  FeaturedContentVc.elapsedTimer.run();
			    FeaturedContentVc.elapsedTimer.scheduleRepeating(500*6);
				}
				studyFeaturedCollection.featuredStartStudyFloPanel.setVisible(false);
			}
		});
		collectionStudyButtonFocPanel.getElement().setId("focuspnlCollectionStudyButtonFocPanel");
		studyFeaturedCollection.getElement().setId("sfcStudyFeaturedCollection");


	}

	/**
	 * Set featured content information such as title , image url
	 * @param featuredContentDo instance of {@link FeaturedContentDo}
	 */
	private void setData(FeaturedContentDo featuredContentDo) {
		collectionGooruOid.setValue(featuredContentDo.getCollectionId());
		studyFeaturedCollection.setFeaturedCollectionImageUrl(featuredContentDo.getUrl());
	    studyFeaturedCollection.getContentUrlImg().setAltText(featuredContentDo.getContentTitle());
	    studyFeaturedCollection.getContentUrlImg().setTitle(featuredContentDo.getContentTitle());
		contentDisplayTitle.setInnerText(featuredContentDo.getDisplayTitle());
	}

	/**
	 * To play the featured collection
	 * @param e {@link ClickEvent} instance
	 */
	@UiHandler("collectionStudyButtonFocPanel")
	public void playCollectionByContentImage(ClickEvent e) {
		MixpanelUtil.Click_FeaturedCollection();
		FeaturedContentVc.elapsedTimer.scheduleRepeating(500*6);
		Window.scrollTo(0, 0);
		Element embedElement = Document.get().getElementById("embed");
		Element parentElement = Document.get().getElementById("embed").getParentElement();
		embedElement.removeFromParent();

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", this.collectionGooruOid.getValue());
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
	}
}
