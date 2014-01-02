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

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : NoSearchResultsVc.java
 *
 * @description : This method is to set the data for resources.
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
public class NoSearchResultsVc extends Composite {

	private static NoSearchResultsVcUiBinder uiBinder = GWT.create(NoSearchResultsVcUiBinder.class);

	interface NoSearchResultsVcUiBinder extends UiBinder<Widget, NoSearchResultsVc> {
	}
	
	@UiField Label resourcesCount;
	
	@UiField NoSearchResultBundle noResultStyle;
	
	@UiField HTMLPanel suggestedResourcesContainer;
	
	private static final String DEFULT_VIMAGE = "images/default-video.png";

	private static final String DEFULT_QIMAGE = "images/default-question.png";

	private static final String DEFULT_IIMAGE = "images/default-interactive.png";

	private static final String DEFULT_WIMAGE = "images/default-website.png";

	private static final String DEFULT_TIMAGE = "images/default-textbook.png";

	private static final String DEFULT_EIMAGE = "images/default-exam.png";

	private static final String DEFULT_SIMAGE = "images/default-slide.png";

	private static final String DEFULT_HIMAGE = "images/default-handout.png";

	private static final String DEFULT_LIMAGE = "images/default-lesson.png";
	/**
	 * Class constructor
	 */
	public NoSearchResultsVc() {
		initWidget(uiBinder.createAndBindUi(this));
		getSearchData();
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used to set data for resources.
	 * 
	 * 
	 * @parm(s) : @param searchInput
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setData(SearchDo<ResourceSearchResultDo> searchInput)
	{
		//resourcesCount.setText("There are "+searchInput.getSearchHits()+" suggested resources for you!");
		for(int i=0;i<searchInput.getSearchResults().size();i++){
			if(i<5){
				final String category = searchInput.getSearchResults().get(i).getCategory();
				HTMLPanel resourceContainer=new HTMLPanel("");
				resourceContainer.setStyleName(noResultStyle.resourceContainer());
				final HTMLEventPanel resourceThumbnail=new HTMLEventPanel("");
				resourceThumbnail.setStyleName(noResultStyle.resourceThumbnail());
				resourceThumbnail.getElement().setId(searchInput.getSearchResults().get(i).getGooruOid());
				
				final Image resourceImage=new Image(searchInput.getSearchResults().get(i).getUrl());
				resourceImage.setHeight("60px");
				resourceImage.setWidth("80px");
				
				HTMLPanel resourceTypeIcon=new HTMLPanel("");
				resourceTypeIcon.getElement().setAttribute("style","position: absolute");
				resourceTypeIcon.setStyleName(getResourceCategoryIcon(category));
				resourceThumbnail.add(resourceImage);
				resourceThumbnail.add(resourceTypeIcon);
				
				HTML titleText=new HTML();
				titleText.setStyleName(noResultStyle.resourceTitle());
				final String resourceTitle=searchInput.getSearchResults().get(i).getResourceTitle();
				resourceImage.setAltText(resourceTitle);
				resourceImage.setTitle(resourceTitle);
				if(resourceTitle.length()>=18){
					titleText.setHTML(resourceTitle.substring(0, 17)+ "...");
				} else {
					titleText.setHTML(resourceTitle);
				}
				
				resourceContainer.add(resourceThumbnail);
				resourceContainer.add(titleText);
				suggestedResourcesContainer.add(resourceContainer);
				resourceThumbnail.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						MixpanelUtil.Search_No_Results_Click_Resource();
						Map<String, String> params = new HashMap<String, String>();
						params.put("id",resourceThumbnail.getElement().getId());
						params.put("pn","resource");
						com.google.gwt.user.client.Window.scrollTo(0, 0);
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
					}
				});
				
				resourceImage.addErrorHandler(new ErrorHandler() {
					@Override
					public void onError(ErrorEvent event) {
						String categoryImage = setDefaultResourceThumbnail(category);
						resourceImage.setUrl(categoryImage);
						resourceImage.setAltText(resourceTitle);
						resourceImage.setTitle(resourceTitle);
					}
				});
			}
		}
	}
	/**
	 * 
	 * @function getResourceCategoryIcon 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to get resource category icons.
	 * 
	 * 
	 * @parm(s) : @param categoryType
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private String getResourceCategoryIcon(String categoryType) {
		String resourceCategoryCss = "";
		if(categoryType.equalsIgnoreCase("video")) {
			resourceCategoryCss = noResultStyle.video();
		} else if(categoryType.equalsIgnoreCase("website")) {
			resourceCategoryCss = noResultStyle.website();
		} else if(categoryType.equalsIgnoreCase("interactive")) {
			resourceCategoryCss = noResultStyle.interactive();
		} else if(categoryType.equalsIgnoreCase("slide")) {
			resourceCategoryCss = noResultStyle.slide();
		} else if(categoryType.equalsIgnoreCase("handout")) {
			resourceCategoryCss = noResultStyle.handout();
		} else if(categoryType.equalsIgnoreCase("textbook")) {
			resourceCategoryCss = noResultStyle.textbook();
		} else if(categoryType.equalsIgnoreCase("lesson")) {
			resourceCategoryCss = noResultStyle.lesson();
		} else if(categoryType.equalsIgnoreCase("exam")) {
			resourceCategoryCss = noResultStyle.exam();
		}
		return resourceCategoryCss;
	}
	/**
	 * 
	 * @function setDefaultResourceThumbnail 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used to set default resource thumbnails.
	 * 
	 * 
	 * @parm(s) : @param category
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private String setDefaultResourceThumbnail(String category){
		String resourceImage = "";
		if (category.equalsIgnoreCase("video")) {
			resourceImage = DEFULT_VIMAGE;
		} else if (category.equalsIgnoreCase("question")) {
			resourceImage = DEFULT_QIMAGE;
		} else if (category.equalsIgnoreCase("interactive")) {
			resourceImage = DEFULT_IIMAGE;
		} else if (category.equalsIgnoreCase("website")) {
			resourceImage = DEFULT_WIMAGE;
		} else if (category.equalsIgnoreCase("slide")) {
			resourceImage = DEFULT_SIMAGE;
		} else if (category.equalsIgnoreCase("textbook")) {
			resourceImage = DEFULT_TIMAGE;
		} else if (category.equalsIgnoreCase("handout")) {
			resourceImage = DEFULT_HIMAGE;
		} else if (category.equalsIgnoreCase("lesson")) {
			resourceImage = DEFULT_LIMAGE;
		} else if (category.equalsIgnoreCase("exam")) {
			resourceImage = DEFULT_EIMAGE;
		}
		return resourceImage;
	}
	/**
	 * 
	 * @function getSearchData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to get search data
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void getSearchData()
	{
		SearchDo<ResourceSearchResultDo> searchInput=new SearchDo<ResourceSearchResultDo>();
		AppClientFactory.getInjector().getSearchService().getSuggestSearchResultForResourceNoResult(searchInput, new AsyncCallback<SearchDo<ResourceSearchResultDo>>() {
			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(SearchDo<ResourceSearchResultDo> result) {
				setData(result);
			}
		}) ;
	}
}
