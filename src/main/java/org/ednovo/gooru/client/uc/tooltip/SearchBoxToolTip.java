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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : SearchBoxToolTip.java
 *
 * @description : This class is used to display the search text box tooltip.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SearchBoxToolTip extends Composite{
	
	@UiField 
	Anchor solarLbl,exponentsLbl,oceansLbl,cellsLbl;
	@UiField
	HTMLPanel mainPanel;
	
	Map<String, String> hm;
	
	public interface SearchBoxToolTipUiBinder extends UiBinder<Widget, SearchBoxToolTip>{
	}
	
	public static SearchBoxToolTipUiBinder searchBoxToolTipUiBinder=GWT.create(SearchBoxToolTipUiBinder.class);{
	}
	/*
	 * constructor
	*/
	public SearchBoxToolTip(){
		MixpanelUtil.Loading_ToolTip();
		initWidget(searchBoxToolTipUiBinder.createAndBindUi(this));
		solarLbl.getElement().setId("lnkSolar");
		exponentsLbl.getElement().setId("lnkExponents");
		oceansLbl.getElement().setId("lnkOceans");
		cellsLbl.getElement().setId("lnkCells");
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
