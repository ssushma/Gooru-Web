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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.Anchor;
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
	
	@UiField UlPanel ulSubjectPanel;
	
	@UiField LiPanel resourcePanel, collectionPanel;
	
	@UiField HTMLPanel searchResultPanel,pnlBackToTop,subjectDropDown,gradesPanel;
	
	@UiField HTMLEventPanel gradesDropDown;
	
	@UiField Label lblLoadingText;
	
	@UiField InlineLabel searchResults;
	
	@UiField FlowPanel pnlAddFilters;
	
	@UiField TextBox authorTxtBox;
	
	LiPanel liPanel;
	
	private static final String COMMA_SEPARATOR = i18n.GL_GRR_COMMA();
	
	private static final String SUBJECTS_SEPARATOR = "~~";
	
	String grades,stdCode,subjects,categories,oerTag,mobileFirendlyTag,ratingTag,publisher,aggregator,accessMode,authors,reviewTag;

	int pageNumber = 1,resultCountVal=0;
	
	String selectedSubjects,selectedAuthors, selectedGrades;
	
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
		Window.addWindowScrollHandler(new ScrollHandler() {
			@Override
			public void onWindowScroll(ScrollEvent event) {
				if(event.getScrollTop()>=200){
					pnlBackToTop.setVisible(true);
				}else{
					pnlBackToTop.setVisible(false);
				}
				if(resultCountVal>=8){
					if ((event.getScrollTop() + Window.getClientHeight()) == Document.get().getBody().getClientHeight()) {
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
		subjectDropDown.addDomHandler(new DropDownClickHandler(), ClickEvent.getType());
		gradesDropDown.addClickHandler(new GradesDropDownHandler());
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
	}
	/**
	 * This inner class will handle the click event on the subject dropdown click
	 * @author Gooru
	 */
	public class DropDownClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			String displayValue=ulSubjectPanel.getElement().getStyle().getDisplay();
			if(StringUtil.isEmpty(displayValue) || "none".equalsIgnoreCase(displayValue)){
				ulSubjectPanel.getElement().getStyle().setDisplay(Display.BLOCK);
				subjectDropDown.getElement().getStyle().setBackgroundColor("#1076bb");
			}else{
				ulSubjectPanel.getElement().getStyle().setDisplay(Display.NONE);
				subjectDropDown.getElement().getStyle().clearBackgroundColor();
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
	}
	
	@UiHandler("collectionPanel")
	protected void clickOnCollection(ClickEvent clickEvent){
		collectionPanel.setStyleName("active");
		resourcePanel.removeStyleName("active");
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
			searchResultPanel.add(NoSearchResultWidget.getInstance());
			lblLoadingText.setVisible(false);
			searchResults.setVisible(false);
		}
		pnlAddFilters.clear();
		showGradesFilter();
		showCategoryFilter();
		showSubjectsFilter();
		showAuthorFilter();
	}
	/**
	 * This method will set the search Filters 
	 */
	@Override
	public void setSearchFilter(SearchFilterDo searchFilterDo) {
		if(searchFilterDo.getSubjects()!=null && searchFilterDo.getSubjects().size()>=0){
			renderSubjects(searchFilterDo.getSubjects());
		}
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
				setSelectedSubjects(split[i]);
			}
		}
	}
	/**
	 * This method is used to highlight selected values for Subjects
	 * @param filterName
	 * @param panelName
	 */
	public void setSelectedSubjects(String filterName){
		Iterator<Widget> widgets= ulSubjectPanel.iterator();
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
	 * Pre-Selected Subjects showing in search page
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
				
				if (panelName != null && panelName.equalsIgnoreCase("categoryPanel") && !newFilterVal.equalsIgnoreCase("Audio")&& !newFilterVal.equalsIgnoreCase("Webpage")){
					newFilterVal = newFilterVal.substring(0, newFilterVal.length()-1);
				}
				if(filterValue.contains("Grade"))
				{
					newFilterVal = filterValue.replaceAll("Grade ", "");
					getUiHandlers().getGooruGradesPresenter().updateFilterStyle(newFilterVal);
				}
				if(panelName.equals("subjectsPanel")){
					removeSelectedSubjects(newFilterVal,panelName);
				}
				callSearch();
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
			}
		}
	}
	/**
	 * This method is used to remove selected values for Subjects
	 * @param filterName
	 * @param panelName
	 */
	public void removeSelectedSubjects(String filterName,String panelName){
		Iterator<Widget> widgets= ulSubjectPanel.iterator();
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
			}
		}
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
}
