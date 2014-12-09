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
package org.ednovo.gooru.client.mvp.dashboard;

/**
 * @fileName : PopupForAnalyticsView.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: Dec 8, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class PopupForAnalyticsView extends PopupViewWithUiHandlers<PopupForAnalyticsUiHandlers> implements IsPopupForAnalyticsView {

	private static PopupForAnalyticsViewUiBinder uiBinder = GWT
			.create(PopupForAnalyticsViewUiBinder.class);

	interface PopupForAnalyticsViewUiBinder extends
			UiBinder<Widget, PopupForAnalyticsView> {
	}
	
	@UiField Label titleTextlbl,leftSideText,rightSideText;
	@UiField Button btnHighToLow,btnLowToHigh;
	@UiField HTMLPanel pnlItemsContainer;
	@UiField ScrollPanel pnlScrollPanel;
	@UiField Anchor lnkClose;
	
	PopupPanel popup=new PopupPanel();
	 MessageProperties i18n = GWT.create(MessageProperties.class);
	 
	/**
	 * Constructor
	 * @param eventBus
	 */
	@Inject
	public PopupForAnalyticsView(EventBus eventBus) {
		super(eventBus);
		popup.add(uiBinder.createAndBindUi(this));
		popup.setGlassEnabled(true);
		popup.setAutoHideEnabled(true);
		popup.setGlassStyleName("");
		btnHighToLow.setText(i18n.GL3057());
		btnLowToHigh.setText(i18n.GL3058());
		pnlScrollPanel.addScrollHandler(new ScrollHandler() {
			@Override
			public void onScroll(ScrollEvent event) {

			}
		});
		lnkClose.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				popup.hide();
				Window.enableScrolling(true);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.View#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return popup;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.gin.IsView#reset()
	 */
	@Override
	public void reset() {
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.gin.IsView#onLoad()
	 */
	@Override
	public void onLoad() {
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.gin.IsView#onUnload()
	 */
	@Override
	public void onUnload() {
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsPopupForAnalyticsView#setPopupData()
	 */
	@Override
	public void setPopupData(String isEndorsedOrRemixed,String isReactionOrRatings) {
		if(isEndorsedOrRemixed!=null){
			boolean isEndorsed=Boolean.parseBoolean(isEndorsedOrRemixed);
			if(isEndorsed){
				titleTextlbl.setText(i18n.GL3059());
				
			}else{
				titleTextlbl.setText(i18n.GL3053());
			}
		}
		if(isReactionOrRatings!=null){
			boolean isRatings=Boolean.parseBoolean(isReactionOrRatings);
			if(isRatings){
				titleTextlbl.setText(i18n.GL3054());
			}else{
				titleTextlbl.setText(i18n.GL3055());
			}
		}
	}
	
	/**
	 * This will handle the click event on the button high to low
	 * @param e
	 */
	@UiHandler("btnHighToLow")
	public void onClickOfButtonHighToLow(ClickEvent e){
		btnLowToHigh.removeStyleName("active");
		btnHighToLow.addStyleName("active");
	}
	/**
	 * This will handle the click event on the button low to high
	 * @param e
	 */
	@UiHandler("btnLowToHigh")
	public void onClickOfButtonLowToHigh(ClickEvent e){
		btnHighToLow.removeStyleName("active");
		btnLowToHigh.addStyleName("active");
	}
}
