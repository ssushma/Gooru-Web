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
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : SearchRootView.java
 *
 * @description : This file is related to Loading image and search text.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SearchRootView extends BaseViewWithHandlers<SearchRootUiHandlers> implements IsSearchRootView, MessageProperties {

	private static SearchRootViewUiBinder uiBinder = GWT.create(SearchRootViewUiBinder.class);

	interface SearchRootViewUiBinder extends UiBinder<Widget, SearchRootView> {
	}

	/*public interface Style extends CssResource {
		String active();
	}*/

	/*@UiField
	SearchBarVc searchBarVc;*/
	/*@UiField
	FlowPanel flowpanel;*/
	/*@UiField
	HTMLPanel contentpanel;*/
	@UiField
	SimplePanel searchWrapperSimPanel, shelfTabSimPanel;

	/*@UiField
	Anchor resourceLinkLbl, collectionLinkLbl;*/
	
	@UiField
    Label lodingImage;
	
	/*@UiField
	Style style;*/

	@UiField
	HTML queriedTextHtml;

	/**
	 * Class constructor
	 */
	public SearchRootView() {
		setWidget(uiBinder.createAndBindUi(this));
		
		/*resourceLinkLbl.getElement().setId("lblResourceLink");
		collectionLinkLbl.getElement().setId("lblCollectionLink");
		
		resourceLinkLbl.setText(MessageProperties.GL0174);
		collectionLinkLbl.setText(MessageProperties.GL0175);*/
	}
	/**
	 * setInSlot() is a method used by GWTP in it's lifecycle to set the widget hierarchy that has to be shown to the user. Each time setInSlot is called, it will replace the previous presenter that was assigned to that slot
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == SearchRootPresenter.TYPE_VIEW) {
				searchWrapperSimPanel.clear();
				searchWrapperSimPanel.add(content);
			} else if (slot == SearchRootPresenter.TYPE_SHELF_TAB) {
				shelfTabSimPanel.setWidget(content);
			}
		}
	}
	/**
	 * This is used to get the search text.
	 */
	@Override
	public String getSearchText() {
//		return searchBarVc.getSearchText();
		return AppClientFactory.getPlaceManager().getRequestParameter("query");
	}

	/**
	 * Set resource search page view
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	/*@UiHandler("resourceLinkLbl")
	public void onResourceLinkLblClicked(ClickEvent clickEvent) {
		if(getSearchText()!=null || getSearchText().length()>0){
			MixpanelUtil.Show_Resource_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.RESOURCE_SEARCH,getSearchText()));
		}
		
		if(!AppClientFactory.getPlaceManager().getRequestParameter("query").equalsIgnoreCase("")){ 
			MixpanelUtil.Show_Collection_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.RESOURCE_SEARCH,AppClientFactory.getPlaceManager().getRequestParameter("query")));
		}
	}

	*//**
	 * Set collection search page view 
	 * @param clickEvent instance of {@link ClickEvent}
	 *//*
	@UiHandler("collectionLinkLbl")
	public void onCollectionLinkLblClicked(ClickEvent clickEvent) {
		if(getSearchText()!=null || getSearchText().length()>0){
			MixpanelUtil.Show_Collection_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.COLLECTION_SEARCH,getSearchText()));
		}
		if(!AppClientFactory.getPlaceManager().getRequestParameter("query").equalsIgnoreCase("")){ 
			MixpanelUtil.Show_Collection_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.COLLECTION_SEARCH,AppClientFactory.getPlaceManager().getRequestParameter("query")));
		}
	}*/
	/**
	 * This is used to reset the data.
	 */
	@Override
	public void reset() {
		super.reset();
		queriedTextHtml.setHTML("<p></p>");
	}
	/**
	 * To enable the loading image.
	 */
	@Override
	public void preSearch(SearchDo<?> searchDo) {
		lodingImage.setVisible(true);
//		searchBarVc.setSearchText(searchDo.getUrlQuery());
		
//				searchBarVc.setInitialSearchQuery();
		
		
		/*if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.RESOURCE_SEARCH)) {
			resourceLinkLbl.addStyleName(style.active());
			collectionLinkLbl.removeStyleName(style.active());
		} else {
			collectionLinkLbl.addStyleName(style.active());
			resourceLinkLbl.removeStyleName(style.active());
		}*/
	}
	/**
	 * This is used to display the search text with three dots when it exceeds more than 50 characters and finally to set the text.
	 */
	@Override
	public void postSearch(SearchDo<?> searchDo) {
//		String searchText = searchBarVc.getSearchText();
		String searchText = AppClientFactory.getPlaceManager().getRequestParameter("query");
		if (searchText == null) {
			searchText = "";
		} else {
			if(searchText.length()>50)
		     {
				
				searchText=searchText.substring(0, 50)+"...";
				searchText = "Search results for <b>" + searchText + "</b>";
		     }
		     else{
		    	 
		    	 searchText = "Search results for <b>" + searchText + "</b>";
		    
			
		}
		
		queriedTextHtml.setHTML(searchText);
		lodingImage.setVisible(false);
	}
	}

	/*@Override
	public void clearPanel() {
		contentpanel.clear();
	}*/
}
