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
package org.ednovo.gooru.client.mvp.gsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterEvent;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterHandler;
import org.ednovo.gooru.client.mvp.search.FilterLabelVc;
import org.ednovo.gooru.client.mvp.search.util.NoSearchResultWidget;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.CloseLabelSetting;
import org.ednovo.gooru.client.uc.DisclosurePanelUc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 * @param <T>
 *            type of ResourceSearchResultDo
 */
public abstract class SearchAbstractView<T extends ResourceSearchResultDo> extends BaseViewWithHandlers<GooruSearchUiHandlers> implements IsGooruSearchView<T>, ClickHandler ,SelectionHandler<SuggestOracle.Suggestion>{

	private static SearchAbstractViewUiBinder uiBinder = GWT.create(SearchAbstractViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface SearchAbstractViewUiBinder extends UiBinder<Widget, SearchAbstractView<?>> {
	}
	
	@UiField UlPanel ulSubjectPanel,ulCategoryPanel,ulRatingsPanel;
	
	@UiField LiPanel resourcePanel, collectionPanel;
	
	@UiField HTMLPanel hideScrollDiv,fixedFilterSearch,pnlBackToTop,subjectDropDown,gradesPanel,resourceSearchPanel,collectionSearchPanel,btnStandardsBrowse,gradesDropDown;
	
	@UiField Label lblLoadingText,ratingsLbl,sourcesNotFoundLbl,aggregatorNotFoundLbl,oerLbl;
	
	@UiField InlineLabel searchResults;
	
	@UiField FlowPanel pnlAddFilters,searchResultPanel,sourceContainerFloPanel;
	
	@UiField TextBox authorTxtBox;
	
	@UiField
	PPanel panelNotMobileFriendly,accessModePanel;
	
	@UiField HTMLEventPanel resourceFiltersDropDwn,moreFilterPanel;
	
	@UiField Image publisherTooltip,aggregatorTooltip;
	
	@UiField(provided = true)
	AppSuggestBox publisherSgstBox;
	
	@UiField(provided = true)
	AppSuggestBox aggregatorSgstBox;

	
	LiPanel liPanel;
	
	private AppMultiWordSuggestOracle sourceSuggestOracle;
	
	private AppMultiWordSuggestOracle aggregatorSuggestOracle;
	
	private SearchDo<String> sourceSearchDo = new SearchDo<String>();
	
	private SearchDo<String> aggregatorSearchDo = new SearchDo<String>();
	
	
	private static final String COMMA_SEPARATOR = i18n.GL_GRR_COMMA();
	
	private static final String SUBJECTS_SEPARATOR = "~~";
	
	private static final String NO_MATCH_FOUND = i18n.GL0723();
	
	private boolean isClickedOnDropDwn=false;
	
	private boolean isClickOnMoreFilter=false;
	
	String[] accessModeArray = new String[]{i18n.GL2094(),i18n.GL2097(),i18n.GL2095(),i18n.GL2098(),i18n.GL2099(),i18n.GL2096()};
	
	CheckBox chkAccessMode = null;
	
	ToolTip toolTip = null;
	
	String FILLED_GREEN = "filled";
	
	String grades,standards,stdCode,subjects,categories,oerTag,mobileFirendlyTag,ratingTag,publisher,aggregator,accessMode,authors,reviewTag;

	int pageNumber = 1,resultCountVal=0,previousValue,scrollTop=0,previousCount=4,previousScrollValue=0;
	
	boolean isInsertTems=false;
	
	
	String selectedSubjects,selectedAuthors, selectedGrades,selectedStandards,selectedCategories,selectedStars,oerValue,selectedAccessMode,selectedPublisheValues,selectedAuggreValues;
	
	private HandlerRegistration handlerRegistration=null;

	/**
	 * Assign new instance for 
	 * 
	 * @param resourceSearch
	 *            whether resource search or not
	 */
	public SearchAbstractView(boolean resourceSearch) {
		sourceSuggestOracle = new AppMultiWordSuggestOracle(true);
		publisherSgstBox = new AppSuggestBox(sourceSuggestOracle) {
			@Override
			public void keyAction(String text,KeyUpEvent event) {
					sourceSearchDo.setSearchResults(null);
					sourceSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						getUiHandlers().requestSourceSuggestions(sourceSearchDo);
				     }
			}
			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				return null;
			}
		};
		aggregatorSuggestOracle = new AppMultiWordSuggestOracle(true);
		aggregatorSearchDo.setPageSize(10);	
		aggregatorSgstBox = new AppSuggestBox(aggregatorSuggestOracle) {
			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				return null;
			}
			@Override
			public void keyAction(String text,KeyUpEvent event) {
					aggregatorSearchDo.setSearchResults(null);
					aggregatorSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						getUiHandlers().requestAggregatorSuggestions(aggregatorSearchDo);
				   }
			}
		};
		setWidget(uiBinder.createAndBindUi(this));
		searchFeildsIds();
		lblLoadingText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		pnlBackToTop.setVisible(false);
		ulSubjectPanel.setStyleName("dropdown-menu");
		fixedFilterSearch.getElement().setAttribute("id", "fixedFilterSearchID");
		Window.addWindowScrollHandler(new ScrollHandler() {
			@Override
			public void onWindowScroll(ScrollEvent event) {
				String placeToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
				if(placeToken.equals(PlaceTokens.SEARCH_RESOURCE) || placeToken.equals(PlaceTokens.SEARCH_COLLECTION)){
					if(event.getScrollTop()>=200){
						pnlBackToTop.setVisible(true);
					}else{
						pnlBackToTop.setVisible(false);
					}
					//This condition is used when user navigate scroll bottom to top at that time it will check the visible items,main panel count,pagenumber and checking the scroll is scrolling to top 
					if (getVisibleItems()<=2 && searchResultPanel.getWidgetCount()>30 && (pageNumber-2)>=2 && (previousScrollValue>=event.getScrollTop())) {
						isInsertTems=true;
						pageNumber--;
						if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
							getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber-2, 9);
						}else{
							getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber-2, 8);
						}
						if(getWidgetHeight()!=0){
							int getTotalScrolltop=getWidgetHeight()*4;
							hideScrollDiv.getElement().getStyle().setHeight((hideScrollDiv.getOffsetHeight()-getTotalScrolltop), Unit.PX);
						}
						previousCount=previousCount-4;
						if((pageNumber-2)==1){
							hideScrollDiv.getElement().getStyle().setHeight(0, Unit.PX);
							previousCount=0;
						}
					}
					//This condition is used to check that the user is scrolling top to bottom
					if(resultCountVal>=8){
						if ((event.getScrollTop() + Window.getClientHeight()) == Document.get().getBody().getClientHeight()) {
							isInsertTems=false;
							lblLoadingText.setVisible(true);
							pageNumber++;
							if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
								getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber, 9);
							}else{
								getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber, 8);
							}
							if(getWidgetHeight()!=0){
								hideScrollDiv.getElement().getStyle().setHeight(getWidgetHeight()*(previousCount), Unit.PX);
								previousCount=previousCount+4;
							}
						}
					}
					previousScrollValue=event.getScrollTop();
				}
			}
		});
		pnlBackToTop.getElement().setId("back-top");
		AppClientFactory.getEventBus().addHandler(UpdateFilterEvent.TYPE, updatefilter);
		pnlBackToTop.addDomHandler(new BackToTopClickHandler(), ClickEvent.getType());
		subjectDropDown.addDomHandler(new DropDownClickHandler(1), ClickEvent.getType());
		btnStandardsBrowse.addDomHandler(new DropDownClickHandler(2), ClickEvent.getType());
		gradesDropDown.addDomHandler(new GradesDropDownHandler(), ClickEvent.getType());
		oerLbl.addClickHandler(new ClickOnOER());
		resourceFiltersDropDwn.addClickHandler(new ResourceFiltersDropDown());
		authorTxtBox.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (authorTxtBox.getText() != null && authorTxtBox.getText().length() > 0) {
						String text = authorTxtBox.getValue();
						pnlAddFilters.add(createTagsLabel(text,"authorPanel"));
						authorTxtBox.setText("");
						authorTxtBox.getElement().setAttribute("alt","");
						authorTxtBox.getElement().setAttribute("title","");
						callSearch();
					}
				}
			}
		});
		ClickHandler rootHandler= new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!isClickedOnDropDwn &&(ulSubjectPanel.isVisible() || gradesPanel.isVisible() ||moreFilterPanel.isVisible())){
					ulSubjectPanel.setVisible(false);
					gradesPanel.setVisible(false);
					if(moreFilterPanel.getElement().getStyle().getDisplay().equalsIgnoreCase("block") && isClickOnMoreFilter){
						moreFilterPanel.getElement().getStyle().setDisplay(Display.BLOCK);
						isClickOnMoreFilter=false;
					}else{
						moreFilterPanel.getElement().getStyle().setDisplay(Display.NONE);
					}
					
				}else if(!isClickedOnDropDwn){
					ulSubjectPanel.setVisible(false);
					gradesPanel.setVisible(false);
					moreFilterPanel.setVisible(false);
				}else{
					isClickedOnDropDwn=false;
				}
			}
		};
		
		RootPanel.get().addDomHandler(rootHandler, ClickEvent.getType());
		
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
			renderCheckBox(panelNotMobileFriendly, "not_ipad_friendly", "Mobile Friendly");
			
	    	renderStarRatings();
	    	renderAccessModeValues();
	    	publisherSgstBox.getElement().setAttribute("placeHolder", i18n.GL1464());
	    	publisherSgstBox.getElement().setId("asSourceSgst");
	    	aggregatorSgstBox.getElement().setId("asAggregatorSgst");
			aggregatorSgstBox.getElement().setAttribute("placeHolder", i18n.GL1749());
			
			aggregatorSgstBox.addSelectionHandler(this);
	    	publisherSgstBox.addSelectionHandler(this);
	    }
		publisherTooltip.addMouseOverHandler(new MouseOverOnImage(i18n.GL1769()));
		publisherTooltip.addMouseOutHandler(new MouseOutOnImage());
		aggregatorTooltip.addMouseOverHandler(new MouseOverOnImage(i18n.GL1768()));
		aggregatorTooltip.addMouseOutHandler(new MouseOutOnImage());
	}
	/**
	 * To render the Access Mode values
	 */
	private void renderAccessModeValues() {
		// TODO Auto-generated method stub
		for(int i=0;i<accessModeArray.length;i++){
			renderAccessModeCheckBox(accessModePanel,accessModeArray[i].toLowerCase(),accessModeArray[i]);
		}
	}
	
	private void renderAccessModeCheckBox(PPanel accessModePanel,final String key,final String value) {
		chkAccessMode = new CheckBox();
		chkAccessMode.setText(value);
		chkAccessMode.setName(key);
		chkAccessMode.setStyleName("checkbox");
		chkAccessMode.addStyleName(value.toLowerCase());
		accessModePanel.add(chkAccessMode);
		chkAccessMode.addValueChangeHandler(new ValueChangeHandler<Boolean>(){

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				callSearch();  
			}
			
		});
	}
	public int getWidgetHeight(){
		if(searchResultPanel.iterator().hasNext()){
			return searchResultPanel.iterator().next().getElement().getOffsetHeight();
		}
		return 0;
	}
	/**
	 * This inner class will handle the click event on the subject dropdown click
	 * @author Gooru
	 */
	public class DropDownClickHandler implements ClickHandler{
		int value;
		DropDownClickHandler(int value){
			this.value=value;
		}
		@Override
		public void onClick(ClickEvent event) {
			isClickedOnDropDwn=true;
			if (gradesPanel.isVisible()){
				gradesPanel.setVisible(false);
			}
			if (moreFilterPanel.isVisible()){
				moreFilterPanel.setVisible(false);
			}
			if(value==1){
				String displayValue=ulSubjectPanel.getElement().getStyle().getDisplay();
				if(StringUtil.isEmpty(displayValue) || "none".equalsIgnoreCase(displayValue)){
					ulSubjectPanel.getElement().getStyle().setDisplay(Display.BLOCK);
					subjectDropDown.getElement().getStyle().setBackgroundColor("#1076bb");
				}else{
					ulSubjectPanel.getElement().getStyle().setDisplay(Display.NONE);
					subjectDropDown.getElement().getStyle().clearBackgroundColor();
				}
			}
			if(value==2){
				getUiHandlers().getAddStandards();
			}
		}
	}
	/**
	 * This inner class will handle the click event on the back to top
	 * @author Gooru
	 */
	public class BackToTopClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			callAnimation();
		}
	}
	
	@Override
	public void onClick(ClickEvent event) {
		
	}
	/**
     * To set ids for all fields.
     */
	private void searchFeildsIds() {
		StringUtil.setAttributes(resourcePanel.getElement(), "searchResourcePanel", i18n.GL1755(), i18n.GL1755());
		StringUtil.setAttributes(collectionPanel.getElement(), "searchCollectionPanel", i18n.GL1754(), i18n.GL1754());
	}
	
	@UiHandler("resourcePanel")
	public void clickOnResource(ClickEvent clickEvent){
		collectionPanel.removeStyleName("active");
		resourcePanel.setStyleName("active");
		resourceSearchPanel.setVisible(true);
		collectionSearchPanel.setVisible(false);
		resetData();
		getUiHandlers().setSearchType(false);
	}
	
	@UiHandler("collectionPanel")
	protected void clickOnCollection(ClickEvent clickEvent){
		collectionPanel.setStyleName("active");
		resourcePanel.removeStyleName("active");
		resourceSearchPanel.setVisible(false);
		collectionSearchPanel.setVisible(true);
		resetData();
		getUiHandlers().setSearchType(true);
	}
	public void removeTopWidgets(boolean isBottomOrTop){
		try{
			if(isBottomOrTop){
				int widgetCount=searchResultPanel.getWidgetCount()-8;
				int totalWidgetCount=searchResultPanel.getWidgetCount();
				int removeWidgetCount=searchResultPanel.getWidgetCount();
				if(searchResultPanel.getWidgetCount()>24){
					Iterator<Widget> widgets=searchResultPanel.iterator();
					while (widgets.hasNext()){
						if(widgetCount==totalWidgetCount){
							break;
						}
						searchResultPanel.remove(removeWidgetCount-1);
						widgetCount++;
						removeWidgetCount--;
					}
				}
			}else{
				int widgetCount=1;
				if(searchResultPanel.getWidgetCount()>24){
					Iterator<Widget> widgets=searchResultPanel.iterator();
					while (widgets.hasNext()){
						if(widgetCount>8){
							break;
						}
						final Widget widget = widgets.next();
						searchResultPanel.remove(widget);
						widgetCount++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void postSearch(SearchDo<T> searchDo) {
		removeTopWidgets(isInsertTems);
		if (searchDo.getSearchResults() != null && searchDo.getSearchResults().size() > 0) {
			searchResults.setVisible(true);
			resultCountVal=searchDo.getSearchResults().size()+resultCountVal;
			searchResults.setText(i18n.GL3210()+"  "+"("+searchDo.getSearchHits()+")");
			searchDo.getSearchHits();
			if(isInsertTems){
				Collections.reverse(searchDo.getSearchResults());
				for (T searchResult : searchDo.getSearchResults()) {
					searchResultPanel.insert(renderSearchResult(searchResult),0);
				}
			}else{
				for (T searchResult : searchDo.getSearchResults()) {
					searchResultPanel.add(renderSearchResult(searchResult));
				}
			}
			lblLoadingText.setVisible(false);
		}else{
			lblLoadingText.setVisible(false);
			searchResults.setVisible(true);
			searchResults.setText(i18n.GL3210()+"  (0) ");
			searchResultPanel.add(NoSearchResultWidget.getInstance());
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.SEARCH_COLLECTION)) {
			collectionPanel.setStyleName("active");
			resourcePanel.removeStyleName("active");
			resourceSearchPanel.setVisible(false);
			collectionSearchPanel.setVisible(true);
		}else{
			collectionPanel.removeStyleName("active");
			resourcePanel.setStyleName("active");
			resourceSearchPanel.setVisible(true);
			collectionSearchPanel.setVisible(false);
		}
		pnlAddFilters.clear();
		showGradesFilter();
		showCategoryFilter();
		showSubjectsFilter();
		showRatingsFilter();
		showAuthorFilter();
		showStandardsFilter();
		showMobileFriendlyFilter();
		showAccessModeFilter();
		showPublisherFilter();
		showAggregatorFilter();
		showOERFilter();
	}
	/**
	 * This method will set the search Filters 
	 */
	@Override
	public void setSearchFilter(SearchFilterDo searchFilterDo) {
		if(searchFilterDo.getSubjects()!=null && searchFilterDo.getSubjects().size()>=0){
			renderSubjects(searchFilterDo.getSubjects());
		}
		if (searchFilterDo.getCategories() != null) {
			Iterator<Map.Entry<String, String>> categoriesIterator = searchFilterDo.getCategories().entrySet().iterator();
			while (categoriesIterator.hasNext()) {
				Map.Entry<String, String> entry = categoriesIterator.next();
				renderCategories(ulCategoryPanel, entry.getKey(), entry.getValue());
			}
		}
	}
	
	/**
	 * To render categories and handle click events for Resource search.
	 * @param ulCategoryPanel {@link UlPanel}
	 * @param key {@link String}
	 * @param value {@link String}
	 */
	private void renderCategories(UlPanel ulCategoryPanel, String key,
			String value) {
		liPanel = new LiPanel();
		Anchor lblSubject=new Anchor(value);
		lblSubject.setStyleName(value.toLowerCase().replaceAll(" ",""));
		liPanel.add(lblSubject);
		liPanel.addClickHandler(new CategoryClickHandler(key,value,liPanel));
		ulCategoryPanel.add(liPanel);
		
	}
	/**
	 * This method is used to render subjects and it will handle the click events on subjects.
	 */
	public void renderSubjects(List<String> list){
		InlineLabel text=new InlineLabel("Try selecting from this cool subjecs:");
		ulSubjectPanel.add(text);
		for (String subject : list) {
			liPanel = new LiPanel();
			Anchor lblSubject=new Anchor(subject);
			liPanel.add(lblSubject);
			liPanel.addClickHandler(new SubjectItemClickHandler(subject,liPanel));
			ulSubjectPanel.add(liPanel);
		}
	}
	
	/**
	 * @param filterPanel instance of DisclosurePanelUc which gets added widget
	 * @param key check box name
	 * @param value check box value
	 */
	public void renderCheckBox(PPanel filterPanel, String key, final String value) {
		final CheckBox categoryChk = new CheckBox();
		categoryChk.setText(value);
		categoryChk.setName(key);
		categoryChk.setStyleName("checkbox");
		//categoryChk.addStyleName(value.toLowerCase());
		filterPanel.add(categoryChk);
		categoryChk.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				callSearch();  
			}
		});

	}
	
	/**
	 * To show the Access mode values in search page
	 */
	private void showAccessModeFilter() {
		accessMode = AppClientFactory.getPlaceManager().getRequestParameter("flt.cfAccessMode");
		if(accessMode!=null){
			pnlAddFilters.setVisible(true);
			String[] split = accessMode.split(",");
			for(int i=0; i<split.length; i++){
				pnlAddFilters.add(createTagsLabel(split[i],"accessModePanel"));
				setSelectedFilter(accessModePanel,accessMode,COMMA_SEPARATOR);
			}
		}
	}
	
	/**
	 * To show the aggregator values in search page
	 */
	private void showAggregatorFilter() {
		aggregator = AppClientFactory.getPlaceManager().getRequestParameter("flt.aggregator");
		if(aggregator!=null){
			String[] split = aggregator.split(",");
			for(int i=0; i<split.length; i++){
				pnlAddFilters.add(createTagsLabel(split[i],"aggregatorPanel"));
			}
				
		}
	}
	
	/**
	 * To render star ratings and handle the click events
	 */
	private void renderStarRatings() {
		for(int i=1;i<=5;i++){
			liPanel = new LiPanel();
			liPanel.getElement().setId(i+"star");
			liPanel.setStyleName("ratingItems star");
			liPanel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
			liPanel.addClickHandler(new RatingClickEvent(liPanel,i));
			ulRatingsPanel.add(liPanel);
		}
	}
	
	protected class RatingClickEvent implements ClickHandler{
		LiPanel ratingPanel;
		int ratingValue;
		public RatingClickEvent(LiPanel ratingPanel, int ratingValue) {
			this.ratingPanel=ratingPanel;
			this.ratingValue=ratingValue;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(previousValue!=0 && previousValue==ratingValue){
				setStyleForRatings(0+"", ulRatingsPanel);
				removeFilter(ratingValue+"Stars");
				previousValue=0;
			}else{
				setStyleForRatings(ratingValue+"", ulRatingsPanel);
				removeFilter(ratingValue+"Stars");
				if(ratingValue==5){
					ratingsLbl.setVisible(false);
					pnlAddFilters.add(createTagsLabel(ratingValue+" Stars","ratingPanel"));
				}else{
					ratingsLbl.getElement().setAttribute("style", "display: block;text-align: center;position:absolute;margin-left:4%;");
					ratingsLbl.setVisible(true);
					pnlAddFilters.add(createTagsLabel(ratingValue+"+ Stars","ratingPanel"));
				}
				previousValue=ratingValue;
			}
			
			callSearch();
		}
	}
	
	/**
	 * This inner class will handle the click event on the subject items
	 * @author Gooru
	 */
	public class SubjectItemClickHandler implements ClickHandler{
		String subjectVal;
		LiPanel liPanel;
		SubjectItemClickHandler(String subjectVal,LiPanel liPanel){
			this.subjectVal=subjectVal;
			this.liPanel=liPanel;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(liPanel.getStyleName().equals("active")){
				liPanel.removeStyleName("active");
				removeFilter(subjectVal);
			}else{
				liPanel.setStyleName("active");
				pnlAddFilters.add(createTagsLabel(subjectVal,"subjectsPanel"));
			}
			ulSubjectPanel.getElement().getStyle().setDisplay(Display.NONE);
			subjectDropDown.removeStyleName("active");
			subjectDropDown.getElement().getStyle().clearBackgroundColor();
			callSearch();
		}
	}
	/**
	 * This inner class is used to handle category click event.
	 * @author Gooru
	 */
	public class CategoryClickHandler implements ClickHandler{
		String categoryValue="",categoryKey="";
		LiPanel liPanel;
		CategoryClickHandler(String categoryKey,String categoryValue, LiPanel liPanel){
			this.categoryValue = categoryValue;
			this.categoryKey = categoryKey;
			this.liPanel = liPanel;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(liPanel.getStyleName().equals("active")){
				liPanel.removeStyleName("active");
				removeFilter(categoryValue);
			}else{
				liPanel.setStyleName("active");
				pnlAddFilters.add(createTagsLabel(categoryKey,"categoryPanel"));
			}
			callSearch();
		}
		
	}
	
	public abstract Widget renderSearchResult(T searchDo);
	
	/**
	 * Pre-Selected grades showing in search page
	 */
	private void showGradesFilter() {
	    grades = AppClientFactory.getPlaceManager().getRequestParameter("flt.grade");
		if(grades!=null){
			pnlAddFilters.setVisible(true);
			String[] gradesSplit = grades.split(",");
			for(int i=0; i<gradesSplit.length; i++){
				pnlAddFilters.add(createTagsLabel(i18n.GL0325()+" "+gradesSplit[i],"gradePanel"));
			}
		}
	}
	/**
	 * Pre-Selected standards showing in search page
	 */
	private void showStandardsFilter() {
		standards = AppClientFactory.getPlaceManager().getRequestParameter("flt.standard");
		if(standards!=null){
			pnlAddFilters.setVisible(true);
			String[] standardsSplit = standards.split(",");
			for(int i=0; i<standardsSplit.length; i++){
				pnlAddFilters.add(createTagsLabel(standardsSplit[i],"standardPanel"));
			}
		}
	}
	
	/**
	 * Pre-Selected Author showing in search page
	 */
	private void showAuthorFilter(){
		authors = AppClientFactory.getPlaceManager().getRequestParameter("flt.owner");
		if(authors!=null){
			String[] split = authors.split(COMMA_SEPARATOR);
			for(int i=0; i<split.length; i++){
				pnlAddFilters.add(createTagsLabel(split[i],"authorPanel"));
			}
		}
	}
	
	/**
	 * Pre-Selected Standards showing in search page
	 */
	private void showMobileFriendlyFilter() {
		mobileFirendlyTag = AppClientFactory.getPlaceManager().getRequestParameter("fltNot.mediaType");
		if(mobileFirendlyTag!=null){
			if(mobileFirendlyTag.equalsIgnoreCase("not_ipad_friendly"))
			{
				pnlAddFilters.add(createTagsLabel("Mobile Friendly","mobileFirendlyPanel"));
				setSelectedFilter(panelNotMobileFriendly,mobileFirendlyTag,COMMA_SEPARATOR);
			}

		}
	}

	/**
	 * Pre-Selected Subjects showing in search page
	 */
	private void showSubjectsFilter() {
		subjects = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
		if(subjects!=null){
			String[] split = subjects.split(SUBJECTS_SEPARATOR);
			for(int i=0; i<split.length; i++){
				pnlAddFilters.add(createTagsLabel(split[i],"subjectsPanel"));
				setStyleSelectedFilters(split[i],ulSubjectPanel);
			}
		}
	}
	
	/**
	 * Pre-Selected Standards showing in search page
	 */
	private void showOERFilter() {
		oerTag = AppClientFactory.getPlaceManager().getRequestParameter("flt.isOer");
		if(oerTag!=null){
			if(oerTag.equalsIgnoreCase("1"))
			{
				pnlAddFilters.add(createTagsLabel("OER","oerPanel"));
				oerLbl.setStyleName("active");
			}

		}
	}

	
	/**
	 * Pre-Selected Standards showing in search page
	 */
	private void showRatingsFilter() {

		ratingTag = AppClientFactory.getPlaceManager().getRequestParameter(IsGooruSearchView.RATINGS_FLT);
		if(ratingTag!=null){
			if(ratingTag.equalsIgnoreCase("5,4,3,2,1,0"))
			{
				pnlAddFilters.add(createTagsLabel("All Ratings","ratingPanel"));
				setStyleForRatings("0", ulRatingsPanel);
				ratingsLbl.setVisible(false);
			}
			else 
			{
				String[] ratingsSplit = ratingTag.split(",");
				if((ratingsSplit[ratingsSplit.length-1]).equals("5")){
					pnlAddFilters.add(createTagsLabel(ratingsSplit[0]+" Stars","ratingPanel"));
					previousValue=5;
					ratingsLbl.setVisible(false);
				}else{
					pnlAddFilters.add(createTagsLabel(ratingsSplit[ratingsSplit.length-1]+"+ Stars","ratingPanel"));
					previousValue=Integer.parseInt(ratingsSplit[ratingsSplit.length-1]);
					ratingsLbl.setVisible(true);
				}
				setStyleForRatings(ratingsSplit[ratingsSplit.length-1]+"", ulRatingsPanel);
			}
		}
	}
	/**
	 * This method is used to highlight selected values for Subjects/Categories
	 * @param filterName
	 * @param filterPanel 
	 */
	public void setStyleSelectedFilters(String filterName, UlPanel filterPanel){
		Iterator<Widget> widgets= filterPanel.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanel){
				if(filterName.equalsIgnoreCase(widget.getElement().getInnerText())){
					((LiPanel) widget).addStyleName("active");
				}
				
			}
		}
	}
	/**
	 * Set filter value for search with separator
	 * @param filterFlowPanel instance of {@link DisclosurePanelUc} which has filter values
	 * @param checkedValues selected filter value
	 * @param separator concatenation of the filter value by separator 
	 */
	private void setSelectedFilter(PPanel filterHtmlPanel, String checkedValues, String separator) {
		List<String> items = null;
		if (checkedValues != null) {
			items = Arrays.asList(checkedValues.split("\\s*" + separator + "\\s*"));
		}
		
		if (items != null) {
			//if(resourceSearch){
			for(int i=0;i<filterHtmlPanel.getWidgetCount();i++){
				Widget filterWidget = filterHtmlPanel.getWidget(i);
				if (filterWidget instanceof CheckBox) {
					CheckBox filterCheckBox = (CheckBox) filterWidget;
					filterCheckBox.setValue(false);
					for (String item : items) {
						if ((filterCheckBox.getName().equals(item))) {	
							filterCheckBox.setValue(true);
						}
					}
				}
			}
		}
		
	}	
	/**
	 * This method is used to highlight selected values for Ratings
	 * @param filterName {@link String}
	 * @param filterPanel {@link UlPanel}
	 */
	public void setStyleForRatings(String filterName, UlPanel filterPanel){
		int filterStar=Integer.parseInt(filterName);
		int countStar;
		Iterator<Widget> widgets= filterPanel.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanel){
				countStar=filterPanel.getWidgetIndex(widget)+1;
				if(countStar<=filterStar){
					((LiPanel) widget).addStyleName(FILLED_GREEN);
					
				}else{
					((LiPanel) widget).removeStyleName(FILLED_GREEN);
				}
			}
		}
	}
	/**
	 * To get list of selected ratings
	 * @param rating {@link String}
	 * @return star {@link String}
	 */
	public String getSelectedRatings(String rating){
		String star="";
		if(!rating.isEmpty()){
			for(int i=5;i>=Integer.parseInt(rating);i--){
				if(!star.isEmpty()){
					star+=COMMA_SEPARATOR;
				}
				star+=i;
			}	
		}
		
		return star.trim();
	}

	/**
	 * Pre-Selected categories showing in search page
	 */
	private void showCategoryFilter() {
		categories = AppClientFactory.getPlaceManager().getRequestParameter("category");
		if(categories!=null){
			pnlAddFilters.setVisible(true);
			String[] split = categories.split(",");
			for(int i=0; i<split.length; i++){
				if(!split[i].equalsIgnoreCase("all"))
				{
					String filterName = !split[i].equalsIgnoreCase("Audio") && !split[i].equalsIgnoreCase("Webpage")  ? split[i] +"s" : split[i];
					pnlAddFilters.add(createTagsLabel(filterName,"categoryPanel"));
					setStyleSelectedFilters(filterName,ulCategoryPanel);
				}
			} 
		}
	}
	
	/**
	 * To show the publisher values in search page
	 */
	private void showPublisherFilter() {
		publisher = AppClientFactory.getPlaceManager().getRequestParameter("flt.publisher");
		if(publisher!=null){
			pnlAddFilters.setVisible(true);
			String[] split = publisher.split(",");
			for(int i=0; i<split.length; i++){
				pnlAddFilters.add(createTagsLabel(split[i],"publisherPanel"));
			}
				
		}
	}
	
	
	/**
	 * Show user searched filter 
	 * 
	 * @param filterValue
	 *            search filter of the label widget which is user searched filter value
	 * @return the label of user search filter.
	 */
	protected CloseLabelSetting createTagsLabel(final String filterValue, final String panelName) {
		return new CloseLabelSetting(filterValue,panelName) {

			@Override
			public void onCloseLabelClick(ClickEvent event) {
				String newFilterVal = filterValue;
				if(panelName != null ){
					if (panelName.equalsIgnoreCase("categoryPanel")){
						//newFilterVal = newFilterVal.substring(0, newFilterVal.length()-1);
						removeSelectedFilterStyle(newFilterVal,ulCategoryPanel);
					}
					if(filterValue.contains("Grade"))
					{
						newFilterVal = filterValue.replaceAll("Grade ", "");
						getUiHandlers().getGooruGradesPresenter().updateFilterStyle(newFilterVal);
					}
					if(panelName.equals("subjectsPanel")){
						removeSelectedFilterStyle(newFilterVal,ulSubjectPanel);
					}
					if(panelName.equals("accessModePanel")){
						removeSelectedFilter(accessModePanel,newFilterVal);
					}
					if(panelName.equals("mobileFirendlyPanel")){
						removeSelectedFilter(panelNotMobileFriendly,newFilterVal);
					}
					if(panelName.equals("oerPanel")){
						oerLbl.removeStyleName("active");
					}
						
					callSearch();
				}
			}
		};
	}
	/**
	 * This method will remove the filters from the pnlAddFilters
	 * @param filterName {@link String}
	 */
	public void removeFilter(String filterName){
		Iterator<Widget> widgets= pnlAddFilters.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof CloseLabelSetting){
				if(filterName.equalsIgnoreCase(((CloseLabelSetting) widget).getSourceText())){
					widget.removeFromParent();
				}
				if(((CloseLabelSetting) widget).getSourceText().contains("Stars") || ((CloseLabelSetting) widget).getSourceText().contains("Ratings")){
					widget.removeFromParent();
				}
			}
		}
	}
	/**
	 * This method is used to remove selected values for Subjects/categories
	 * @param filterName
	 * @param filterPanel
	 */
	public void removeSelectedFilterStyle(String filterName,UlPanel filterPanel){
		Iterator<Widget> widgets= filterPanel.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanel){
				if(filterName.equalsIgnoreCase(widget.getElement().getInnerText())){
					((LiPanel) widget).removeStyleName("active");
					callSearch();
				}
			}
		}
	}
	
	/**
     * Remove the selected search filter and search results when user click on 'X'.
     * @param filterNamePanel {@link HTMLPanel} 
     * @param filterName {@link String} grade/subject search filter name 
     */
	private void removeSelectedFilter(PPanel filterNamePanel,
			String filterName) {
		for(int i=0;i<filterNamePanel.getWidgetCount();i++){
			Widget filterWidget = filterNamePanel.getWidget(i);
			if (filterWidget instanceof CheckBox) {
				CheckBox filterCheckBox = (CheckBox) filterWidget;
				if ((filterCheckBox.getName().equals(filterName))) {	
					filterCheckBox.setValue(false);
				}
			}
		}
		callSearch();
	}
	
	public class ClickOnOER implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(oerLbl.getStyleName().equals("active")){
				removeFilter("OER");
				oerLbl.removeStyleName("active");
			}else{
				oerLbl.setStyleName("active");
				pnlAddFilters.add(createTagsLabel("OER", "oerPanel"));
			}
			
			callSearch();
		}
		
	}

	/**
	 * To get the selected authors values with separator
	 * @return selectedSubjects {@link String}
	 */
	public void getSelectedFilters(){
		selectedAuthors="";
		selectedSubjects="";
		selectedGrades="";
		selectedStandards="";
		selectedCategories="";
		selectedStars="";
		selectedAccessMode="";
		selectedPublisheValues="";
		selectedAuggreValues="";
	    oerValue="";
		
		Iterator<Widget> widgets= pnlAddFilters.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof CloseLabelSetting){
				CloseLabelSetting closeLabelSetting=(CloseLabelSetting) widget;
				if("authorPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedAuthors.isEmpty()) {
						selectedAuthors += COMMA_SEPARATOR;
					}
					selectedAuthors += closeLabelSetting.getSourceText();
				}
				if("subjectsPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedSubjects.isEmpty()) {
						selectedSubjects += SUBJECTS_SEPARATOR;
					}
					selectedSubjects += closeLabelSetting.getSourceText();
				}
				if("gradePanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedGrades.isEmpty()) {
						selectedGrades += COMMA_SEPARATOR;
					}
					selectedGrades += closeLabelSetting.getSourceText().replaceAll(i18n.GL0325(), "").trim();
				}
				if("standardPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedStandards.isEmpty()) {
						selectedStandards += COMMA_SEPARATOR;
					}
					selectedStandards += closeLabelSetting.getSourceText();
				}
				if("categoryPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedCategories.isEmpty()) {
						selectedCategories += COMMA_SEPARATOR;
					}
					selectedCategories += removeLastChar(closeLabelSetting.getSourceText());
				}
				if("ratingPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedStars.isEmpty()) {
						selectedStars += COMMA_SEPARATOR;
					}
					selectedStars += getSelectedRatings(closeLabelSetting.getSourceText().replaceAll("[^0-9]", ""));
					
				}
				if("publisherPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedPublisheValues.isEmpty()) {
						selectedPublisheValues += COMMA_SEPARATOR;
					}
					selectedPublisheValues +=closeLabelSetting.getSourceText();
				}
				if("aggregatorPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					if (!selectedAuggreValues.isEmpty()) {
						selectedAuggreValues += COMMA_SEPARATOR;
					}
					selectedAuggreValues +=closeLabelSetting.getSourceText();
				}
				if("oerPanel".equalsIgnoreCase(closeLabelSetting.getPanelName())){
					
					oerValue="1";
				}

			}
		}
	}
	/**
	 * To remove last char from string.
	 * @param category {@link String}
	 * @return category {@link String}
	 */
	private String removeLastChar(String category) {
		if (category.length() > 0 && category.charAt(category.length()-1)=='s') {
			category = category.substring(0, category.length()-1);
		    }
		return category;
	}
	@Override
	public Map<String, String> getSearchFilters() {
		 getSelectedFilters();
		 Map<String, String> filtersMap = new HashMap<String, String>();
		 if(!selectedSubjects.isEmpty()){
			 filtersMap.put(IsGooruSearchView.SUBJECT_FLT, selectedSubjects);
		 }
		 if(!selectedAuthors.isEmpty()){
			 filtersMap.put(IsGooruSearchView.OWNER_FLT, selectedAuthors);
		 }
		 if(!selectedGrades.isEmpty()){
			 filtersMap.put(IsGooruSearchView.GRADE_FLT, selectedGrades);
		 }
		 if(!selectedStandards.isEmpty()){
			 filtersMap.put(IsGooruSearchView.STANDARD_FLT, selectedStandards);
		 }
		 if(!selectedCategories.isEmpty()){
			 filtersMap.put(IsGooruSearchView.CATEGORY_FLT, selectedCategories);
		 }
		 if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
			 if(!selectedStars.isEmpty()){
				 filtersMap.put(IsGooruSearchView.RATINGS_FLT, selectedStars);
			 }else{
				 filtersMap.put(IsGooruSearchView.RATINGS_FLT, "5,4,3,2,1,0");
			 }

			 if(getSelectedFilter(panelNotMobileFriendly) != null)
			 {
				 if (getSelectedFilter(panelNotMobileFriendly).equalsIgnoreCase("not_ipad_friendly")){
					 filtersMap.put(IsGooruSearchView.MEDIATYPE_FLT, "not_ipad_friendly");
				 }
			 }
			 String selectedAccessMode = getSelectedFilter(accessModePanel);
			 if (!selectedAccessMode.isEmpty()) {
				 filtersMap.put(IsGooruSearchView.ACCESS_MODE_FLT, selectedAccessMode);
			 }
			 if(!selectedPublisheValues.isEmpty()){
				 filtersMap.put(IsGooruSearchView.PUBLISHER_FLT, selectedPublisheValues);
			 }
			 
			 if(!selectedAuggreValues.isEmpty()){
				 filtersMap.put(IsGooruSearchView.AGGREGATOR_FLT, selectedAuggreValues);
			 }
			 if(!oerValue.isEmpty()){
				 filtersMap.put(IsGooruSearchView.OER_FLT, oerValue);
			 }

		 }

		 return filtersMap; 
	}
	
	private class GradesDropDownHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			isClickedOnDropDwn=true;
			if (ulSubjectPanel.isVisible()){
				ulSubjectPanel.setVisible(false);
			}
			if (moreFilterPanel.isVisible()){
				moreFilterPanel.setVisible(false);
			}
			String displayValue=gradesPanel.getElement().getStyle().getDisplay();
			if(StringUtil.isEmpty(displayValue) || "none".equalsIgnoreCase(displayValue)){
				gradesPanel.getElement().getStyle().setDisplay(Display.BLOCK);
				gradesDropDown.getElement().getStyle().setBackgroundColor("#1076bb");
			}else{
				gradesPanel.getElement().getStyle().setDisplay(Display.NONE);
				gradesDropDown.getElement().getStyle().clearBackgroundColor();
			}
		}
	} 
	
	private class ResourceFiltersDropDown implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			isClickedOnDropDwn=true;
			if (ulSubjectPanel.isVisible()){
				ulSubjectPanel.setVisible(false);
			}
			if (gradesPanel.isVisible()){
				gradesPanel.setVisible(false);
			}
			String displayValue=moreFilterPanel.getElement().getStyle().getDisplay();
			if(StringUtil.isEmpty(displayValue) || "none".equalsIgnoreCase(displayValue)){
				moreFilterPanel.getElement().getStyle().setDisplay(Display.BLOCK);
				resourceFiltersDropDwn.getElement().getStyle().setBackgroundColor("#999");
			}else{
				moreFilterPanel.getElement().getStyle().setDisplay(Display.NONE);
				resourceFiltersDropDwn.getElement().getStyle().clearBackgroundColor();
			}
		}
		
	}
	
	/**
	 * This native method is used to set animation when user clicks on the back to top button
	 */
	public static native void callAnimation() /*-{
		$wnd.$('body,html').animate({scrollTop: 0}, 800);
	}-*/;

	@Override
	public void resetData(){
		searchResultPanel.clear();
		resultCountVal=0;
		pageNumber=1;
		lblLoadingText.setVisible(true);
	}
	
	/**
	 * @param filterPanel instance of {@link DisclosurePanelUc}
	 * @return selected filterDisclosurePanell name
	 */
	private String getSelectedFilter(PPanel filterPanel) {
		return getSelectedFilter(filterPanel, COMMA_SEPARATOR);
	}

	
	/**
	 * Get filters for search
	 * @param filterPanel instance of {@link DisclosurePanelUc} which has filters widget
	 * @param separator concatenation of the filters with separator
	 * @return concatenation of selected filters
	 */
	private String getSelectedFilter(PPanel filterPanel, String separator) {
		String selectedFilter = "";
		for(int i =0;i<filterPanel.getWidgetCount();i++){
			Widget filterWidget = filterPanel.getWidget(i);
			if (filterWidget instanceof CheckBox) {
				CheckBox filterCheckBox = (CheckBox) filterWidget;
				if (filterCheckBox != null && filterCheckBox.getValue()) {
					if (!selectedFilter.isEmpty()) {
						selectedFilter += separator;
					}
					selectedFilter += filterCheckBox.getName();
					MixpanelUtil.mixpanelEvent("search_"+selectedFilter+"_filter_selected");
				}
			}
		}
		return selectedFilter;
	}

	/**
	 * This method will call the search function on filters selection changes
	 */
	public void callSearch(){
		getUiHandlers().refreshSearch(getSearchText());
	}
	/**
	 * To get the search query.
	 * @return {@link String}
	 */
	public String getSearchText() {
		return AppClientFactory.getPlaceManager().getRequestParameter("query");
	}
	
	@Override
	public HTMLPanel getGradePanel(){
		return gradesPanel;
	}
	
	UpdateFilterHandler updatefilter = new UpdateFilterHandler() {
		@Override
		public void updateFilters(String filterValue, String addOrRemove) {
			if("add".equals(addOrRemove)){
				pnlAddFilters.add(createTagsLabel(filterValue, "gradePanel"));
			}else{
				removeFilter(filterValue);
			}
			callSearch();
		}
	};
	
	public void OnStandardsClickEvent(Button standardsButtonClicked)
	{
		if(handlerRegistration!=null){
			handlerRegistration.removeHandler();
		}
		handlerRegistration=standardsButtonClicked.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().setUpdatedStandards();
			}
		});
	}
	@Override
	public void setUpdatedStandards(String standardsCode){
		getUiHandlers().closeStandardsPopup();
		if(!standardsCode.isEmpty()){
			pnlAddFilters.add(createTagsLabel(standardsCode,"standardPanel"));
			callSearch();
		}
	}
	/**
	 * This native method is used to get the number of visible items on the screen, based on this we are calling the top scroll functionality
	 */
	public static native int getVisibleItems() /*-{
		var detectPartial = 'complete';
		var count=0;
		$wnd.$('.libraryMainContainerBlock .visibleElement').each(function(){
			var visible = $wnd.$(this).visible(true, false, 'vertical');
			if(visible){
				count++;
			}
		});
		return count;
	}-*/;
	
	public class MouseOverOnImage implements MouseOverHandler{
		String mouseOverTxt;

		public MouseOverOnImage(String mouseOverTxt) {
			this.mouseOverTxt=mouseOverTxt;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			// TODO Auto-generated method stub
			toolTip = new ToolTip(mouseOverTxt);
			toolTip.getLblLink().setVisible(false);
			toolTip.getElement().getStyle().setBackgroundColor("transparent");
			toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
			toolTip.getElement().getStyle().setZIndex(99999);
			toolTip.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-(50+22), event.getRelativeElement().getAbsoluteTop()+22);
			toolTip.show();
		}
		
	}
	
	public class MouseOutOnImage implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			EventTarget target = ((MouseOutEvent) event).getRelatedTarget();
			  if (Element.is(target)) {
				  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
					  toolTip.hide();
				  }
			  }	
		}
		
	}
	
	/**
	 * @param sourceSearchDo instance of {@link SearchDo}
	 */
	@Override
	public void setSourceSuggestions(SearchDo<String> sourceSearchDo) {
		sourceSuggestOracle.clear();
		this.sourceSearchDo = sourceSearchDo;
		if (this.sourceSearchDo.getSearchResults() != null) {
			this.sourceSearchDo.getSearchResults().removeAll(getSuggestionsAsList(pnlAddFilters));
		}
		if (this.sourceSearchDo.getSearchResults() != null && this.sourceSearchDo.getSearchResults().size() > 0) {
			sourceSuggestOracle.setAll(sourceSearchDo.getSearchResults());
		} else {
			sourceSuggestOracle.add(NO_MATCH_FOUND);
		}
		publisherSgstBox.showSuggestionList();
	}
	
	/**
	 * Get added suggestion filters
	 * @param flowPanel instance of {@link FlowPanel} which has all filter value as widget
	 * @return filter suggestions as string
	 */
	public List<String> getSuggestionsAsList(FlowPanel flowPanel) {
		List<String> suggestions = new ArrayList<String>();
		Iterator<Widget> widgets = flowPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof FilterLabelVc) {
				suggestions.add(((FilterLabelVc) widget).getSourceText());
			} else if (widget instanceof DownToolTipWidgetUc) {
				suggestions.add(((FilterLabelVc) ((DownToolTipWidgetUc) widget).getWidget()).getSourceText());
			}
		}
		return suggestions;
	}
	@Override
	public void setAggregatorSuggestions(SearchDo<String> aggregatorSearchDo) {
		aggregatorSuggestOracle.clear();
		this.aggregatorSearchDo=aggregatorSearchDo;
		if(this.aggregatorSearchDo.getSearchResults() != null){
			this.aggregatorSearchDo.getSearchResults().removeAll(getSuggestionsAsList(pnlAddFilters));
		}
		if (this.aggregatorSearchDo.getSearchResults() != null && this.aggregatorSearchDo.getSearchResults().size() > 0) {
			aggregatorSuggestOracle.setAll(aggregatorSearchDo.getSearchResults());
		} else {
			aggregatorSuggestOracle.add(NO_MATCH_FOUND);
		}
		aggregatorSgstBox.showSuggestionList();
	}
	
	@Override
	public void onSelection(SelectionEvent<SuggestOracle.Suggestion> event) {
	if (event.getSource().equals(publisherSgstBox)) {
			String text = publisherSgstBox.getValue();
			if (text.equals(NO_MATCH_FOUND)) {
				new FadeInAndOut(sourcesNotFoundLbl.getElement(), 5000, 5000);
			} else {
				pnlAddFilters.add(createTagsLabel(text, "publisherPanel"));
				callSearch();
			}
			publisherSgstBox.setText("");
			publisherSgstBox.getElement().setAttribute("alt","");
			publisherSgstBox.getElement().setAttribute("title","");
			sourceSuggestOracle.clear();
			
		} else if(event.getSource().equals(aggregatorSgstBox)){
			String text = aggregatorSgstBox.getValue();
			if (text.equals(NO_MATCH_FOUND)) {
				new FadeInAndOut(aggregatorNotFoundLbl.getElement(), 5000, 5000);
			} else {
				pnlAddFilters.add(createTagsLabel(text, "aggregatorPanel"));
				callSearch();
			}
			aggregatorSgstBox.setText("");
			aggregatorSgstBox.getElement().setAttribute("alt","");
			aggregatorSgstBox.getElement().setAttribute("title","");
			aggregatorSuggestOracle.clear();
		}
	}
	
	@UiHandler("moreFilterPanel")
	public void clickOnMorefilterPnl(ClickEvent clickEvent){
		moreFilterPanel.getElement().getStyle().setDisplay(Display.BLOCK);
		isClickOnMoreFilter=true;
	}
}
