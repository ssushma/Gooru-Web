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
package org.ednovo.gooru.client.uc.tooltip;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SearchBoxToolTip extends Composite {
	
	@UiField 
	Anchor solarLbl,exponentsLbl,oceansLbl,cellsLbl;
	@UiField
	HTMLPanel mainPanel;
	@UiField Label enterSubjectText,examplesText;
	Map<String, String> hm;
	
	public interface SearchBoxToolTipUiBinder extends UiBinder<Widget, SearchBoxToolTip>{
	}
	
	public static SearchBoxToolTipUiBinder searchBoxToolTipUiBinder=GWT.create(SearchBoxToolTipUiBinder.class);{
	}
	private MessageProperties i18n = GWT.create(MessageProperties.class); 
	/*
	 * constructor
	*/
	public SearchBoxToolTip(){
		MixpanelUtil.Loading_ToolTip();
		initWidget(searchBoxToolTipUiBinder.createAndBindUi(this));
		mainPanel.getElement().setId("pnlMainPanel");
		
		enterSubjectText.setText(i18n.GL1068());
		enterSubjectText.getElement().setId("lblEnterSubjectText");
		enterSubjectText.getElement().setAttribute("alt", i18n.GL1068());
		enterSubjectText.getElement().setAttribute("title", i18n.GL1068());
		
		examplesText.setText(i18n.GL1069());
		examplesText.getElement().setId("lblExamplesText");
		examplesText.getElement().setAttribute("alt", i18n.GL1069());
		examplesText.getElement().setAttribute("title", i18n.GL1069());
		
		solarLbl.setText(i18n.GL1070());
		solarLbl.getElement().setId("lnkSolar");
		solarLbl.getElement().setAttribute("alt", i18n.GL1070());
		solarLbl.getElement().setAttribute("title", i18n.GL1070());
		
		exponentsLbl.setText(i18n.GL1071());
		exponentsLbl.getElement().setId("lnkExponents");
		exponentsLbl.getElement().setAttribute("alt", i18n.GL1071());
		exponentsLbl.getElement().setAttribute("title", i18n.GL1071());
		
		oceansLbl.setText(i18n.GL1072());
		oceansLbl.getElement().setId("lnkOceans");
		oceansLbl.getElement().setAttribute("alt", i18n.GL1072());
		oceansLbl.getElement().setAttribute("title", i18n.GL1072());
		
		cellsLbl.setText(i18n.GL1073());
		cellsLbl.getElement().setId("lnkCells");
		cellsLbl.getElement().setAttribute("alt", i18n.GL1073());
		cellsLbl.getElement().setAttribute("title", i18n.GL1073());
		
		solarLbl.addClickHandler(new SearchSolorClickHandler());
		exponentsLbl.addClickHandler(new SearchExponentClickHandler());
		oceansLbl.addClickHandler(new SearchOceansClickHandler());
		cellsLbl.addClickHandler(new SearchCellsClickHandler());
		
		hm = new HashMap<String, String>();	
		hm.put("category", "All");
		hm.put("query", "");	
		hm.put("pageSize", "8");
		hm.put("pageNum", "1");
		
	}
	/*
	 * Solar Label click event
	*/
	private class SearchSolorClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_OnToolTipSearch();
			hm.put("query", "Solar system");
			mainPanel.setVisible(false);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_SEARCH, hm);
		}
	}
	/*
	 * exponents Label click event
	*/
	private class SearchExponentClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_OnToolTipSearch();
			hm.put("query", "exponents");
			mainPanel.setVisible(false);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_SEARCH, hm);
		}
	}
	/*
	 * oceans Label click event
	*/
	private class SearchOceansClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_OnToolTipSearch();
			hm.put("query", "oceans");
			mainPanel.setVisible(false);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_SEARCH, hm);
		}
	}
	/*
	 * cells Label click event
	*/
	private class SearchCellsClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_OnToolTipSearch();
			hm.put("query", "cells");
			mainPanel.setVisible(false);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_SEARCH, hm);
		}
	}
	
}
