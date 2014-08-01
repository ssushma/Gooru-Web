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
package org.ednovo.gooru.client.mvp.folders;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetButtonEvent;
import org.ednovo.gooru.client.mvp.search.event.SetButtonHandler;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FoldersWelcomePage extends Composite {

	private static FoldersWelcomePageUiBinder uiBinder = GWT
			.create(FoldersWelcomePageUiBinder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField
	Label lblStartCreateingCollection, lblCollectionDesc, lblViewWalkthrough,
			lblUpload, lblCustomizeCollections, lblCollaborate, lblFurther,
			lblAssess, lblAddQuestion, lblGuideWith, lblGuideNarration,
			lblCustomizeResource, lblEditStart, lblOne, lblTwo, lblThree,
			lblFour, lblFive;
	
	@UiField HTML htmlWalkSampleCollection;
	
	@UiField Anchor imgSampleCollection;
	
	@UiField
	Button btnCreateCollection;

	interface FoldersWelcomePageUiBinder extends
			UiBinder<Widget, FoldersWelcomePage> {
	}

	public FoldersWelcomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		Window.enableScrolling(true);

		SetButtonHandler setButtonVisibility = new SetButtonHandler() {

			@Override
			public void setButtonVisibility() {
				setVisibility();
			}
		};
		AppClientFactory.getEventBus().addHandler(
				SetButtonEvent.TYPE, setButtonVisibility);
		
		
		setText();
		
		imgSampleCollection.setHref("#collection-play&id=2548d591-9131-4577-b873-83b8f172eda5");
		imgSampleCollection.setTarget("_blank");
		
		Image imgComponent = new Image();
		imgComponent.setUrl("images/EmptyPages/thumbnail.png");
		imgComponent.setWidth("119");
		imgComponent.setHeight("74");
		
		imgSampleCollection.getElement().appendChild(imgComponent.getElement());
		imgSampleCollection.getElement().setId("lnkSampleCollection");
		
		
		
	/*	<g:Image styleName="{WelcomePage.thumbnailImage}" url="images/EmptyPages/thumbnail.png" width="119"
				height="74" />*/
		
/*		
		imgSampleCollection.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("#preview-play&id=2548d591-9131-4577-b873-83b8f172eda5", "_blank", "");
			}
		});*/
	}

	/**
	 * @function setText 
	 * 
	 * @created_date : May 22, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void setText() {
		lblStartCreateingCollection.setText(i18n.GL1813());
		lblStartCreateingCollection.getElement().setId("lblStartCreateingCollection");
		lblStartCreateingCollection.getElement().setAttribute("alt",i18n.GL1813());
		lblStartCreateingCollection.getElement().setAttribute("title",i18n.GL1813());
		
		lblCollectionDesc.setText(i18n.GL1814());
		lblCollectionDesc.getElement().setId("lblCollectionDesc");
		lblCollectionDesc.getElement().setAttribute("alt",i18n.GL1814());
		lblCollectionDesc.getElement().setAttribute("title",i18n.GL1814());
		
		btnCreateCollection.setText(i18n.GL1815());
		btnCreateCollection.getElement().setId("btnCreateCollection");
		btnCreateCollection.getElement().setAttribute("alt",i18n.GL1815());
		btnCreateCollection.getElement().setAttribute("title",i18n.GL1815());
		//lblViewWalkthrough.setText(i18n.GL1816);
		lblViewWalkthrough.getElement().setId("lblViewWalkthrough");
		
		lblUpload.setText(i18n.GL1817());
		lblUpload.getElement().setId("lblUpload");
		lblUpload.getElement().setAttribute("alt",i18n.GL1817());
		lblUpload.getElement().setAttribute("title",i18n.GL1817());
		
		lblCustomizeCollections.setText(i18n.GL1818());
		lblCustomizeCollections.getElement().setId("lblCustomizeCollections");
		lblCustomizeCollections.getElement().setAttribute("alt",i18n.GL1818());
		lblCustomizeCollections.getElement().setAttribute("title",i18n.GL1818());
		
		lblCollaborate.setText(i18n.GL1819());
		lblCollaborate.getElement().setId("lblCollaborate");
		lblCollaborate.getElement().setAttribute("alt",i18n.GL1819());
		lblCollaborate.getElement().setAttribute("title",i18n.GL1819());
		
		lblFurther.setText(i18n.GL1820());
		lblFurther.getElement().setId("lblFurther");
		lblFurther.getElement().setAttribute("alt",i18n.GL1820());
		lblFurther.getElement().setAttribute("title",i18n.GL1820());
		
		lblAssess.setText(i18n.GL1821());
		lblAssess.getElement().setId("lblAssess");
		lblAssess.getElement().setAttribute("alt",i18n.GL1821());
		lblAssess.getElement().setAttribute("title",i18n.GL1821());
		
		lblAddQuestion.setText(i18n.GL1822());
		lblAddQuestion.getElement().setId("lblAddQuestion");
		lblAddQuestion.getElement().setAttribute("alt",i18n.GL1822());
		lblAddQuestion.getElement().setAttribute("title",i18n.GL1822());
		
		lblGuideWith.setText(i18n.GL1823());
		lblGuideWith.getElement().setId("lblGuideWith");
		lblGuideWith.getElement().setAttribute("alt",i18n.GL1823());
		lblGuideWith.getElement().setAttribute("title",i18n.GL1823());
		
		lblGuideNarration.setText(i18n.GL1824());
		lblGuideNarration.getElement().setId("lblGuideNarration");
		lblGuideNarration.getElement().setAttribute("alt",i18n.GL1824());
		lblGuideNarration.getElement().setAttribute("title",i18n.GL1824());
		
		lblCustomizeResource.setText(i18n.GL1825());
		lblCustomizeResource.getElement().setId("lblCustomizeResource");
		lblCustomizeResource.getElement().setAttribute("alt",i18n.GL1825());
		lblCustomizeResource.getElement().setAttribute("title",i18n.GL1825());
		
		lblEditStart.setText(i18n.GL1826());
		lblEditStart.getElement().setId("lblEditStart");
		lblEditStart.getElement().setAttribute("alt",i18n.GL1826());
		lblEditStart.getElement().setAttribute("title",i18n.GL1826());
		
		lblOne.setText(i18n.GL_GRR_NUMERIC_ONE());
		lblOne.getElement().setId("lblOne");
		lblOne.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_ONE());
		lblOne.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_ONE());
		
		lblTwo.setText(i18n.GL_GRR_NUMERIC_TWO());
		lblTwo.getElement().setId("lblTwo");
		lblTwo.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_TWO());
		lblTwo.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_TWO());
		
		lblThree.setText(i18n.GL_GRR_NUMERIC_THREE());
		lblThree.getElement().setId("lblThree");
		lblThree.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_THREE());
		lblThree.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_THREE());
		
		lblFour.setText(i18n.GL_GRR_NUMERIC_FOUR());
		lblFour.getElement().setId("lblFour");
		lblFour.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_FOUR());
		lblFour.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_FOUR());
		
		lblFive.setText(i18n.GL_GRR_NUMERIC_FIVE());
		lblFive.getElement().setId("lblFive");
		lblFive.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_FIVE());
		lblFive.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_FIVE());
		
		htmlWalkSampleCollection.setHTML(i18n.GL1830());
		htmlWalkSampleCollection.getElement().setId("htmlWalkSampleCollection");
		htmlWalkSampleCollection.getElement().setAttribute("alt",i18n.GL1830());
		htmlWalkSampleCollection.getElement().setAttribute("title",i18n.GL1830());
		
		setVisibility();
	}

	private void setVisibility(){
		if (AppClientFactory.isAnonymous()){
			btnCreateCollection.setVisible(false);
		}else{
			btnCreateCollection.setVisible(true);
		}
	}
	
	@UiHandler("btnCreateCollection")
	public void OnClickNewCollection(ClickEvent event) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION);
	}
}
