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
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FoldersWelcomePage extends Composite implements MessageProperties {

	private static FoldersWelcomePageUiBinder uiBinder = GWT
			.create(FoldersWelcomePageUiBinder.class);

	@UiField
	Label lblStartCreateingCollection, lblCollectionDesc, lblViewWalkthrough,
			lblUpload, lblCustomizeCollections, lblCollaborate, lblFurther,
			lblAssess, lblAddQuestion, lblGuideWith, lblGuideNarration,
			lblCustomizeResource, lblEditStart, lblOne, lblTwo, lblThree,
			lblFour, lblFive;
	
	@UiField HTML htmlWalkSampleCollection;
	
	@UiField
	Button btnCreateCollection;

	interface FoldersWelcomePageUiBinder extends
			UiBinder<Widget, FoldersWelcomePage> {
	}

	public FoldersWelcomePage() {
		initWidget(uiBinder.createAndBindUi(this));

		SetButtonHandler setButtonVisibility = new SetButtonHandler() {

			@Override
			public void setButtonVisibility() {
				setVisibility();
			}
		};
		AppClientFactory.getEventBus().addHandler(
				SetButtonEvent.TYPE, setButtonVisibility);
		
		
		setText();
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
		lblStartCreateingCollection.setText(GL1813);
		lblCollectionDesc.setText(GL1814);
		btnCreateCollection.setText(GL1815);
		lblViewWalkthrough.setText(GL1816);
		lblUpload.setText(GL1817);
		lblCustomizeCollections.setText(GL1818);
		lblCollaborate.setText(GL1819);
		lblFurther.setText(GL1820);
		lblAssess.setText(GL1821);
		lblAddQuestion.setText(GL1822);
		lblGuideWith.setText(GL1823);
		lblGuideNarration.setText(GL1824);
		lblCustomizeResource.setText(GL1825);
		lblEditStart.setText(GL1826);
		
		lblOne.setText(GL_GRR_NUMERIC_ONE);
		lblTwo.setText(GL_GRR_NUMERIC_TWO);
		lblThree.setText(GL_GRR_NUMERIC_THREE);
		lblFour.setText(GL_GRR_NUMERIC_FOUR);
		lblFive.setText(GL_GRR_NUMERIC_FIVE);
		
		htmlWalkSampleCollection.setHTML(GL1830);
		
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
