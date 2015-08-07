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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.GooruCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class TryItOutVc extends PopupPanel implements ClickHandler{

	@UiField
	Label closePopUpLbl,improveGooruText,celebrationLbl,classicGooruLbl,goBackText;

	@UiField
	Anchor backToClassicAnr,learnMoreLbl,tryItOutLbl;

	@UiField
	FlowPanel tryItOutNewGooruFloPanel;

	private static TryItOutUiBinder uiBinder = GWT.create(TryItOutUiBinder.class);

	interface TryItOutUiBinder extends UiBinder<Widget, TryItOutVc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);


	/**
	 * Class constructor
	 */
	public TryItOutVc() {
		setWidget(uiBinder.createAndBindUi(this));
		GooruCBundle.INSTANCE.css().ensureInjected();
		this.setSize("440px", "300px");
		this.setGlassEnabled(true);
		this.addStyleName(GooruCBundle.INSTANCE.css().tryitoutpopup());
		this.show();
		this.center();
		improveGooruText.setText(i18n.GL0285());
		improveGooruText.getElement().setId("lblImproveGooruText");
		improveGooruText.getElement().setAttribute("alt",i18n.GL0285());
		improveGooruText.getElement().setAttribute("title",i18n.GL0285());
		
		celebrationLbl.setText(i18n.GL1314());
		celebrationLbl.getElement().setId("lblCelebrationLbl");
		celebrationLbl.getElement().setAttribute("alt",i18n.GL1314());
		celebrationLbl.getElement().setAttribute("title",i18n.GL1314());
		
		learnMoreLbl.setHref("http://support.goorulearning.org/entries/23251492-Why-are-we-retiring-Classic-Gooru-and-transitioning-everyone-over-to-the-new-version-");
		learnMoreLbl.setText(i18n.GL1315());
		learnMoreLbl.getElement().setId("lblLearnMoreLbl");
		learnMoreLbl.getElement().setAttribute("alt",i18n.GL1315());
		learnMoreLbl.getElement().setAttribute("title",i18n.GL1315());
		
		backToClassicAnr.setText(i18n.GL1316());
		backToClassicAnr.getElement().setId("lnkBackToClassicAnr");
		backToClassicAnr.getElement().setAttribute("alt",i18n.GL1316());
		backToClassicAnr.getElement().setAttribute("title",i18n.GL1316());
		
		classicGooruLbl.setText(i18n.GL1317());
		classicGooruLbl.getElement().setId("lnkClassicGooruLbl");
		classicGooruLbl.getElement().setAttribute("alt",i18n.GL1317());
		classicGooruLbl.getElement().setAttribute("title",i18n.GL1317());
		
		tryItOutLbl.setText(i18n.GL1318());
		tryItOutLbl.getElement().setId("lnkTryItOutLbl");
		tryItOutLbl.getElement().setAttribute("alt",i18n.GL1318());
		tryItOutLbl.getElement().setAttribute("title",i18n.GL1318());
		
		goBackText.setText(i18n.GL1319());
		goBackText.getElement().setId("lblGoBackText");
		goBackText.getElement().setAttribute("alt",i18n.GL1319());
		goBackText.getElement().setAttribute("title",i18n.GL1319());
	
		closePopUpLbl.getElement().setId("lblClosePopUpLbl");
		tryItOutNewGooruFloPanel.getElement().setId("fpnlTryItOutNewGooruFloPanel");
		
		backToClassicAnr.setHref(AppClientFactory.getLoggedInUser().getSettings().getClassicEndPoint());
		tryItOutNewGooruFloPanel.addDomHandler(this, ClickEvent.getType());
	}

	/**
	 * Hide popup
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("closePopUpLbl")
	public void closeTryItOutPopUp(ClickEvent clickEvent) {
		this.hide();
		int flag = AppClientFactory.getLoggedInUser().getViewFlag();
		if(flag == 1 &&  !AppClientFactory.getLoggedInUser().getUserUid().equals(AppClientFactory.GOORU_ANONYMOUS)){
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		
	}

}
