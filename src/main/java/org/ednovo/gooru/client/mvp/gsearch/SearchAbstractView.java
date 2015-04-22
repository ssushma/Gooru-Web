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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterEvent;
import org.ednovo.gooru.client.mvp.gsearch.events.UpdateFilterHandler;
import org.ednovo.gooru.client.mvp.search.util.NoSearchResultWidget;
import org.ednovo.gooru.client.uc.CloseLabelSetting;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 * @param <T>
 *            type of ResourceSearchResultDo
 */
public abstract class SearchAbstractView<T extends ResourceSearchResultDo> extends BaseViewWithHandlers<GooruSearchUiHandlers> implements IsGooruSearchView<T>, ClickHandler {

	private static SearchAbstractViewUiBinder uiBinder = GWT.create(SearchAbstractViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface SearchAbstractViewUiBinder extends UiBinder<Widget, SearchAbstractView<?>> {
	}
	
	@UiField UlPanel ulSubjectPanel,ulCategoryPanel,ulRatingsPanel;
	
	@UiField LiPanel resourcePanel, collectionPanel;
	
	@UiField HTMLPanel fixedFilterSearch,searchResultPanel,pnlBackToTop,subjectDropDown,gradesPanel,resourceSearchPanel,collectionSearchPanel,btnStandardsBrowse,gradesDropDown;
	
	@UiField Label lblLoadingText,ratingsLbl;
	
	@UiField InlineLabel searchResults;
	
	@UiField FlowPanel pnlAddFilters;
	
	@UiField TextBox authorTxtBox;
	
	LiPanel liPanel;
	
	private static final String COMMA_SEPARATOR = i18n.GL_GRR_COMMA();
	
	private static final String SUBJECTS_SEPARATOR = "~~";
	
	String FILLED_GREEN = "filled";
	
	String grades,standards,stdCode,subjects,categories,oerTag,mobileFirendlyTag,ratingTag,publisher,aggregator,accessMode,authors,reviewTag;

	int pageNumber = 1,resultCountVal=0,previousValue;
	
	
	String selectedSubjects,selectedAuthors, selectedGrades,selectedStandards,selectedCategories,selectedStars;
	
	private HandlerRegistration handlerRegistration=null;

	/**
	 * Assign new instance for 
	 * 
	 * @param resourceSearch
	 *            whether resource search or not
	 */
	public SearchAbstractView(boolean resourceSearch) {
		setWidget(uiBinder.createAndBindUi(this));
		searchFeildsIds();
		lblLoadingText.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		pnlBackToTop.setVisible(false);
		ulSubjectPanel.setStyleName("dropdown-menu");
		fixedFilterSearch.getElement().setAttribute("id", "fixedFilterSearchID");
		Window.addWindowScrollHandler(new ScrollHandler() {
			@Override
			public void onWindowScroll(ScrollEvent event) {
				if(event.getScrollTop()>=200){
					pnlBackToTop.setVisible(true);
				}else{
					pnlBackToTop.setVisible(false);
				}
				if(resultCountVal>=8){
					if ((event.getScrollTop() + Window.getClientHeight()) >= Document.get().getBody().getClientHeight()) {
						lblLoadingText.setVisible(true);
						pageNumber++;
						if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
							getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber, 9);
						}else{
							getUiHandlers().getCollectionSearchResultsOnPageWise("",pageNumber, 8);
						}
					}
				}
			}
		});
		pnlBackToTop.getElement().setId("back-top");
		AppClientFactory.getEventBus().addHandler(UpdateFilterEvent.TYPE, updatefilter);
		pnlBackToTop.addDomHandler(new BackToTopClickHandler(), ClickEvent.getType());
		subjectDropDown.addDomHandler(new DropDownClickHandler(1), ClickEvent.getType());
		btnStandardsBrowse.addDomHandler(new DropDownClickHandler(2), ClickEvent.getType());
		gradesDropDown.addDomHandler(new GradesDropDownHandler(), ClickEvent.getType());
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
		
		/*if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_COLLECTION)){
			collectionSearchPanel.setVisible(true);
		}else{
			
		}*/
		
		showRatings();
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
	
	@Override
	public void postSearch(SearchDo<T> searchDo) {
		if (searchDo.getSearchResults() != null && searchDo.getSearchResults().size() > 0) {
			searchResults.setVisible(true);
			resultCountVal=searchDo.getSearchResults().size()+resultCountVal;
			searchResults.setText(i18n.GL3210()+"  "+"("+searchDo.getSearchHits()+")");
			for (T searchResult : searchDo.getSearchResults()) {
				searchDo.getSearchHits();
				searchResultPanel.add(renderSearchResult(searchResult));
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
		showAuthorFilter();
		showStandardsFilter();
		showRatingsFilter();
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
	
	private void showRatings() {
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
	private void showRatingsFilter() {

		ratingTag = AppClientFactory.getPlaceManager().getRequestParameter("flt.rating");
		if(ratingTag!=null){
			pnlAddFilters.setVisible(true);
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
		 Map<String, String> filters = new HashMap<String, String>();
		 if(!selectedSubjects.isEmpty()){
			 filters.put(IsGooruSearchView.SUBJECT_FLT, selectedSubjects);
		 }
		 if(!selectedAuthors.isEmpty()){
			 filters.put(IsGooruSearchView.OWNER_FLT, selectedAuthors);
		 }
		 if(!selectedGrades.isEmpty()){
			 filters.put(IsGooruSearchView.GRADE_FLT, selectedGrades);
		 }
		 if(!selectedStandards.isEmpty()){
			 filters.put(IsGooruSearchView.STANDARD_FLT, selectedStandards);
		 }
		 if(!selectedCategories.isEmpty()){
			 filters.put(IsGooruSearchView.CATEGORY_FLT, selectedCategories);
		 }
		 if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE)){
			 if(!selectedStars.isEmpty()){
				 filters.put(IsGooruSearchView.RATINGS_FLT, selectedStars);
			 }else{
				 filters.put(IsGooruSearchView.RATINGS_FLT, "5,4,3,2,1,0");
			 }
		 }

		 return filters; 
	}
	
	private class GradesDropDownHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			String displayValue=gradesPanel.getElement().getStyle().getDisplay();
			if(StringUtil.isEmpty(displayValue) || "none".equalsIgnoreCase(displayValue)){
				gradesPanel.getElement().getStyle().setDisplay(Display.BLOCK);
			}else{
				gradesPanel.getElement().getStyle().setDisplay(Display.NONE);
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
}
