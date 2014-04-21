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
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FoldersWelcomePage extends Composite implements MessageProperties{

	@UiField
	Label newCollectionUIHandler,needHelpLbl;
	
	@UiField
	Anchor supportCenterAnr;
	
	@UiField HTMLPanel createLbl,gettingStartedLbl,createTextLbl,selectedLbl,customizeLbl,guideStudentsLbl,shareLbl,assignLbl;
	
	@UiField Image roundedOneLbl,workSpaceLbl,roundedTwoLbl,narrationLbl,roundedThreeLbl,shareAssignLbl;

	private static FoldersWelcomePageUiBinder uiBinder = GWT
			.create(FoldersWelcomePageUiBinder.class);

	interface FoldersWelcomePageUiBinder extends
			UiBinder<Widget, FoldersWelcomePage> {
	}

	public FoldersWelcomePage() {
		initWidget(uiBinder.createAndBindUi(this));
		//supportCenterAnr.setHref("http://support.goorulearning.org/home");
		supportCenterAnr.setTarget("_blank");
		createLbl.getElement().setInnerText(GL1508);
		gettingStartedLbl.getElement().setInnerText(GL1509);
		roundedOneLbl.setTitle(GL1398);
		roundedOneLbl.setAltText(GL1398);
		roundedOneLbl.setUrl("images/rounded-one.png");
		createTextLbl.getElement().setInnerText(GL1335);
		selectedLbl.getElement().setInnerText(GL1510);
		workSpaceLbl.setTitle(GL1511);
		workSpaceLbl.setAltText(GL1511);
		workSpaceLbl.setUrl("images/folders/workspace-image.png");
		roundedTwoLbl.setTitle(GL1400);
		roundedTwoLbl.setAltText(GL1400);
		roundedTwoLbl.setUrl("images/rounded-two.png");
		customizeLbl.getElement().setInnerText(GL0631);
		guideStudentsLbl.getElement().setInnerText(GL1512);
		narrationLbl.setTitle(GL1036);
		narrationLbl.setAltText(GL1036);
		narrationLbl.setUrl("images/folders/narration-image.png");
		roundedThreeLbl.setTitle(GL1403);
		roundedThreeLbl.setAltText(GL1403);
		roundedThreeLbl.setUrl("images/rounded-three.png");
		shareLbl.getElement().setInnerText(GL0526);
		assignLbl.getElement().setInnerText(GL1513);
		shareAssignLbl.setTitle(GL1514);
		shareAssignLbl.setAltText(GL1514);
		shareAssignLbl.setUrl("images/folders/share-assign-image.png");
		needHelpLbl.setText(GL1405);
		needHelpLbl.getElement().setAttribute("style", "float: left;margin-left: 27%;");
		supportCenterAnr.setText(GL1406);
		supportCenterAnr.getElement().setAttribute("style", "float: left;padding-left: 5px;");
		supportCenterAnr.setHref("http://support.goorulearning.org/hc/en-us");
	}

	@UiHandler("newCollectionUIHandler")
	public void OnClickNewCollection(ClickEvent event) {
		AppClientFactory.getPlaceManager()
		.revealPlace(PlaceTokens.COLLECTION);
	}

}
