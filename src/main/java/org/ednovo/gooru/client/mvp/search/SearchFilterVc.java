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

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.GetSearchKeyWordEvent;
import org.ednovo.gooru.client.mvp.search.event.SourceSuggestionEvent;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionEvent;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionInfoEvent;
import org.ednovo.gooru.client.mvp.search.event.SwitchSearchEvent;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.DisclosurePanelUc;
import org.ednovo.gooru.client.uc.DownToolTipUc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.search.AbstractSearchDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
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
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : SearchFilterVc.java
 *
 * @description : Related to search filters.
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
public class SearchFilterVc extends Composite implements SelectionHandler<SuggestOracle.Suggestion> {

	private static SearchFilterVcUiBinder uiBinder = GWT.create(SearchFilterVcUiBinder.class);

	interface SearchFilterVcUiBinder extends UiBinder<Widget, SearchFilterVc> {
	}
	public interface Style extends CssResource {
		String active();
	}

	@UiField
	DisclosurePanelUc categoryPanelUc;
	
	@UiField
	Anchor resourceLinkLbl, collectionLinkLbl;

	@UiField
	DisclosurePanelUc subjectPanelUc;

	@UiField
	DisclosurePanelUc gradePanelUc;

	@UiField
	DisclosurePanelUc sourcePanelUc;

	@UiField
	DisclosurePanelUc standardPanelUc;

	@UiField
	DisclosurePanelUc authorPanelUc;
	
	@UiField HTMLPanel panelNotMobileFriendly;

	@UiField(provided = true)
	AppSuggestBox sourceSgstBox;

	@UiField
	TextBox authorTxtBox;

	@UiField(provided = true)
	AppSuggestBox standardSgstBox;

	@UiField
	FlowPanel authorContainerFloPanel;

	@UiField
	FlowPanel sourceContainerFloPanel;

	@UiField
	FlowPanel standardContainerFloPanel;

	@UiField
	Label sourcesNotFoundLbl;

	@UiField
	Label standardsNotFoundLbl;
	
	@UiField
	Label sourceHelpicon, standardHelpicon;

	@UiField
	HTMLEventPanel sourceToolTip, standardToolTip;
	
	CheckBox chkNotFriendly = null;
	
	@UiField
	Style style;
	
	
	ToolTip toolTip = null;
	
	private AppMultiWordSuggestOracle sourceSuggestOracle;

	private AppMultiWordSuggestOracle standardSuggestOracle;

	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>();

	private SearchDo<CodeDo> standardsInfoSearchDo = new SearchDo<CodeDo>();

	private SearchDo<String> sourceSearchDo = new SearchDo<String>();
	
	private Map<String,String> standardCodesMap = new HashMap<String, String>();

	private static final String NO_MATCH_FOUND = "no match found";
	
	private static final String ALL = "All";
	
	private static final String COMMA_SEPARATOR = ",";

	private boolean resourceSearch;
	
	private DownToolTipUc sourcetooltipPopUpUc;
	
	private DownToolTipUc standardtooltipPopUpUc;

	private boolean isSourcePopupShowing=false;

	private boolean isStandardPopupShowing=false;

	/**
	 * Class constructor, creates new {@link AppSuggestBox} and events for StandardsSuggestionEvent
	 * 
	 * @param resourceSearch whether resource search or not
	 */
	public SearchFilterVc(final boolean resourceSearch) {
		this.resourceSearch = resourceSearch;
		standardSuggestOracle = new AppMultiWordSuggestOracle(true);
		standardSearchDo.setPageSize(15);
		standardsInfoSearchDo.setPageSize(20);
		standardsInfoSearchDo.setQuery("-");
		standardsInfoSearchDo.setType(AbstractSearchDo.STANDARD_CODE);
		
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {
			@Override
			public void keyAction(String text) {
				standardSearchDo.setSearchResults(null);
				standardSearchDo.setQuery(text);
				if (text != null && text.trim().length() > 0) {
					AppClientFactory.fireEvent(new StandardsSuggestionEvent(standardSearchDo));
				}
			}

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		sourceSuggestOracle = new AppMultiWordSuggestOracle(true);
		sourceSearchDo.setPageSize(10);		
		
		sourceSgstBox = new AppSuggestBox(sourceSuggestOracle) {
			@Override
			public void keyAction(String text) {
				if (resourceSearch) {
					sourceSearchDo.setSearchResults(null);
					sourceSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						AppClientFactory.fireEvent(new SourceSuggestionEvent(sourceSearchDo));
					}
				}
			}

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
/*	ClickHandler eve1=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(isSourcePopupShowing){
					sourceToolTip.setVisible(true);
					isSourcePopupShowing=false;
				}else{
					sourceToolTip.setVisible(false);
					isSourcePopupShowing=true;
				}
				if(isStandardPopupShowing){
					standardToolTip.setVisible(true);
					isStandardPopupShowing=false;
				}else{
					sourceToolTip.setVisible(false);
					isStandardPopupShowing=true;
				}
			}
		};
		RootPanel.get().addDomHandler(eve1, ClickEvent.getType());
*/
		sourceSgstBox.getElement().setAttribute("placeHolder", "e.g. Nasa");
		sourceSgstBox.getElement().setId("asSourceSgst");
		standardSgstBox.addSelectionHandler(this);
		standardSgstBox.getElement().setId("asStandardSgst");
		initWidget(uiBinder.createAndBindUi(this));
		if (resourceSearch) {
			sourcePanelUc.setVisible(true);
			sourcesNotFoundLbl.getElement().getStyle().setOpacity(0.0);
			sourceSgstBox.addSelectionHandler(this);
		} else {
			authorPanelUc.setVisible(true);
			authorTxtBox.getElement().setId("tbAuthor");
			authorTxtBox.addKeyUpHandler(new KeyUpHandler() {

				@Override
				public void onKeyUp(KeyUpEvent event) {
					if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
						if (authorTxtBox.getText() != null && authorTxtBox.getText().length() > 0) {
							String text = authorTxtBox.getValue();
							authorContainerFloPanel.add(new FilterLabelVc(text,true));
							authorTxtBox.setText("");
							AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
						}
					}
				}
			});
		}
		standardsNotFoundLbl.getElement().getStyle().setOpacity(0.0);
		if(resourceSearch){
			categoryPanelUc.setHeaderTitle("Category");
			categoryPanelUc.getElement().addClassName("categoryFilterContainer");
		}else{
			categoryPanelUc.setHeaderTitle("Collection Type");
		}
		
		resourceLinkLbl.getElement().setId("lblResourceLink");
		collectionLinkLbl.getElement().setId("lblCollectionLink");
		
		resourceLinkLbl.setText(MessageProperties.GL0174);
		collectionLinkLbl.setText(MessageProperties.GL0175);
		
	}
	

	/**
	 * @param disclosurePanelVc instance of DisclosurePanelUc which gets added widget
	 * @param key check box name
	 * @param value check box value
	 */
	public void renderCheckBox(DisclosurePanelUc disclosurePanelVc, String key, String value) {
		CheckBox categoryChk = new CheckBox();
		categoryChk.setText(value);
		categoryChk.setName(key);
		if(value.equalsIgnoreCase("videos")){
			categoryChk.getElement().setId("chkVideos");	
		}else if(value.equalsIgnoreCase("websites")){
			categoryChk.getElement().setId("chkWebsites");	
		}
		else if(value.equalsIgnoreCase("interactives")){
			categoryChk.getElement().setId("chkInteractives");
		}
		else if(value.equalsIgnoreCase("questions")){
			categoryChk.getElement().setId("chkQuestions");
		}
		else if(value.equalsIgnoreCase("slides")){
			categoryChk.getElement().setId("chkSlides");
		}
		else if(value.equalsIgnoreCase("textbooks")){
			categoryChk.getElement().setId("chkTextbooks");
		}
		else if(value.equalsIgnoreCase("handouts")){
			categoryChk.getElement().setId("chkHandouts");
		}
		else if(value.equalsIgnoreCase("lessons")){
			categoryChk.getElement().setId("chkLessons");
		}
		else if(value.equalsIgnoreCase("exams")){
			categoryChk.getElement().setId("chkExams");
		}
		else if(value.equalsIgnoreCase("science")){
			categoryChk.getElement().setId("chkScience");
		}
		else if(value.equalsIgnoreCase("math")){
			categoryChk.getElement().setId("chkMath");
		}
		else if(value.equalsIgnoreCase("Social Sciences")){
			categoryChk.getElement().setId("chkSocialSciences");
		}
		else if(value.equalsIgnoreCase("Language Arts")){
			categoryChk.getElement().setId("chkLanguageArts");
		}
		else if(value.equalsIgnoreCase("Arts and Humanities")){
			categoryChk.getElement().setId("chkArts&Humanities");
		}
		else if(value.equalsIgnoreCase("Technology and Engineering")){
			categoryChk.getElement().setId("chkTechnology&Engineering");
		}
		else if(value.equalsIgnoreCase("Elementary School")){
			categoryChk.getElement().setId("chkElementarySchool");
		}
		else if(value.equalsIgnoreCase("Middle School")){
			categoryChk.getElement().setId("chkMiddleSchool");
		}
		else if(value.equalsIgnoreCase("High School")){
			categoryChk.getElement().setId("chkHighSchool");
		}
		else if(value.equalsIgnoreCase("Higher Education")){
			categoryChk.getElement().setId("chkHigherEducation");
		}
		else if(value.equalsIgnoreCase("Show only Quizzes")){
			categoryChk.getElement().setId("chkShowonlyQuizzes");
		}
		categoryChk.setStyleName(CssTokens.FILTER_CHECKBOX);
		categoryChk.addStyleName(value.toLowerCase());
		disclosurePanelVc.addWidget(categoryChk);
		categoryChk.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
			}
		});
	}
	
	/**
	 * @param disclosurePanelVc instance of DisclosurePanelUc which gets added widget
	 * @param key check box name
	 * @param value check box value
	 */
	public void renderCheckBox(HTMLPanel disclosurePanelVc, String key, String value) {
		if (chkNotFriendly==null){
			chkNotFriendly = new CheckBox();
		}
		chkNotFriendly.setText(value);
		chkNotFriendly.setName(key);
		if(value.equalsIgnoreCase("Mobile Friendly")){
			chkNotFriendly.getElement().setId("chkNotFriendly");
			chkNotFriendly.getElement().getStyle().setMarginTop(20, Unit.PX);
			chkNotFriendly.getElement().getStyle().setMarginLeft(9, Unit.PX);
			chkNotFriendly.getElement().getStyle().setWidth(102, Unit.PX);
		}
		chkNotFriendly.setStyleName(CssTokens.FILTER_CHECKBOX);
		chkNotFriendly.addStyleName(value.toLowerCase());
		disclosurePanelVc.add(chkNotFriendly);
		chkNotFriendly.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (chkNotFriendly.getValue()){
					MixpanelUtil.MOS_Filter("Selected");
				}else{
					MixpanelUtil.MOS_Filter("Unselected");
				}
				AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
			}
		});
		
	}
	
	/*public void renderRadioButtons(final DisclosurePanelUc disclosurePanelVc, String key, String value){
		final QuestionTypeFilter questionTypeFilter=new QuestionTypeFilter(key);
		questionTypeFilter.radioButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				FlowPanel flowPanel=disclosurePanelVc.getContent();
				for(int i=0;i<flowPanel.getWidgetCount();i++){
					
					QuestionTypeFilter widget=(QuestionTypeFilter)flowPanel.getWidget(i);
					widget.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButton());
					
				}
				
				questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonSelected());
				if(!questionTypeFilter.hiddenRadioButton.getValue()){
					questionTypeFilter.hiddenRadioButton.setValue(true);
					AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
				}
			}
		});
		questionTypeFilter.radioButtonLabel.setText(value);
				
		disclosurePanelVc.addWidget(questionTypeFilter);
	}*/
	

	/**
	 * Set resource search page view
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("resourceLinkLbl")
	public void onResourceLinkLblClicked(ClickEvent clickEvent) {
		
		if(!AppClientFactory.getPlaceManager().getRequestParameter("query").equalsIgnoreCase("")){ 
			MixpanelUtil.Show_Collection_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.RESOURCE_SEARCH,AppClientFactory.getPlaceManager().getRequestParameter("query")));
		}
	}

	/**
	 * Set collection search page view 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("collectionLinkLbl")
	public void onCollectionLinkLblClicked(ClickEvent clickEvent) {
		if(!AppClientFactory.getPlaceManager().getRequestParameter("query").equalsIgnoreCase("")){ 
			MixpanelUtil.Show_Collection_Search_Results();
			AppClientFactory.fireEvent(new SwitchSearchEvent(PlaceTokens.COLLECTION_SEARCH,AppClientFactory.getPlaceManager().getRequestParameter("query")));
		}
	}
	/**
	 * 
	 * @function onSourceHelpIconClicked 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to display tooltip on sourceHelpicon clicked.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("sourceHelpicon")
	public void onSourceHelpIconClicked(ClickEvent event) {
		if(!(sourceToolTip.getWidgetCount()>0)) {
			sourcetooltipPopUpUc = new DownToolTipUc();
			sourcetooltipPopUpUc.setContent(new HTML(MessageProperties.GL0246));
			sourceToolTip.add(sourcetooltipPopUpUc);
		}
		if(sourceToolTip.isVisible()) {
			sourceToolTip.setVisible(false);
		} else {
			sourceToolTip.setVisible(true);
			standardToolTip.setVisible(false);
		}
		isSourcePopupShowing = true;
	}
	/**
	 * 
	 * @function onStandardHelpiconClicked 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used to display help icon on sourceHelpicon clicked.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("standardHelpicon")
	public void onStandardHelpiconClicked(ClickEvent event) {
		if(!(standardToolTip.getWidgetCount()>0)) {
			standardtooltipPopUpUc = new DownToolTipUc();
			standardtooltipPopUpUc.setContent(new HTML(MessageProperties.GL0247));
			standardToolTip.add(standardtooltipPopUpUc);
		}
		if(standardToolTip.isVisible()) {
			standardToolTip.setVisible(false);
		} else {
			sourceToolTip.setVisible(false);
			standardToolTip.setVisible(true);
		}
		isStandardPopupShowing = true;
	}
	/**
	 * 
	 * @fileName : SearchFilterVc.java
	 *
	 * @description : It's related to QuestionTypeFilter.
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
	public class QuestionTypeFilter extends Composite{
		
		FlowPanel flowPanel;
		InlineLabel radioButton;
		InlineLabel radioButtonLabel;
		RadioButton hiddenRadioButton=null;

	    public QuestionTypeFilter(String key){
	    	SearchMoreInfoVcCBundle.INSTANCE.css().ensureInjected();
	    	initWidget(flowPanel=new FlowPanel());
	    	flowPanel.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonContainer());
	    	radioButton=new InlineLabel();
	    	radioButtonLabel=new InlineLabel();
	    	radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButton());
	    	flowPanel.add(radioButton);
	    	flowPanel.add(radioButtonLabel);
	    	hiddenRadioButton=new RadioButton("qusetionFilter",key);
	    	hiddenRadioButton.getElement().getStyle().setDisplay(Display.NONE);
	    	flowPanel.add(hiddenRadioButton);
	    }

	}

	/**
	 * Get filter for search
	 * @param searchFilterDo instance of {@link SearchFilterDo}
	 */
	public void renderFilter(SearchFilterDo searchFilterDo) {
		categoryPanelUc.clear();
		subjectPanelUc.clear();
		gradePanelUc.clear();
		panelNotMobileFriendly.clear();
		if (searchFilterDo != null) {
			if (searchFilterDo.getCategories() != null) {
			 
				Iterator<Map.Entry<String, String>> categoriesIterator = searchFilterDo.getCategories().entrySet().iterator();
				while (categoriesIterator.hasNext()) {
					Map.Entry<String, String> entry = categoriesIterator.next();
					renderCheckBox(categoryPanelUc, entry.getKey(), entry.getValue());
				}
			}
			if (searchFilterDo.getGradeLevels() != null) {		
				renderCheckBox(gradePanelUc, "K-4", "Elementary School");
				renderCheckBox(gradePanelUc, "5-8", "Middle School");
				renderCheckBox(gradePanelUc, "9-12", "High School");
				renderCheckBox(gradePanelUc, "H", "Higher Education");
			}
			if (searchFilterDo.getSubjects() != null) {
				for (String subject : searchFilterDo.getSubjects()) {
					renderCheckBox(subjectPanelUc, subject, subject);
				}
			}
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			resourceLinkLbl.addStyleName(style.active());
			collectionLinkLbl.removeStyleName(style.active());
			renderCheckBox(panelNotMobileFriendly, "not_ipad_friendly", "Mobile Friendly");
			final Image imgNotFriendly = new Image("images/mos/questionmark.png");
			imgNotFriendly.getElement().getStyle().setMarginTop(21, Unit.PX);
			imgNotFriendly.getElement().getStyle().setCursor(Cursor.POINTER);
			imgNotFriendly.setAltText("Question Mark");
			imgNotFriendly.setTitle("Question Mark");
			imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTip = new ToolTip(MessageProperties.GL0454);
					
					toolTip.getElement().getStyle().setBackgroundColor("transparent");
					toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
					toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(150+22), imgNotFriendly.getAbsoluteTop()+22);
					toolTip.show();
				}
			});
			imgNotFriendly.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					
					EventTarget target = event.getRelatedTarget();
					  if (Element.is(target)) {
						  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
							  toolTip.hide();
						  }
					  }
				}
			});
			panelNotMobileFriendly.add(imgNotFriendly);
			panelNotMobileFriendly.setVisible(true);
		}else{
			collectionLinkLbl.addStyleName(style.active());
			resourceLinkLbl.removeStyleName(style.active());
		}
		this.setVisible(true);
	}
	
	/**
	 * Get search filter such as grade, subject, category, etc..
	 * @return search filter as Map value
	 */
	protected Map<String, String> getFilter() {
		Map<String, String> filterMap = new HashMap<String, String>();
		String selectedGrade = getSelectedFilter(gradePanelUc);
		if (!selectedGrade.isEmpty()) {
			filterMap.put(IsSearchView.GRADE_FLT, selectedGrade);
		}
	//	if(resourceSearch){
			String category = getSelectedFilter(categoryPanelUc);
			if (!category.isEmpty()) {
				filterMap.put(IsSearchView.CATEGORY_FLT, category);
			} else {
				filterMap.put(IsSearchView.CATEGORY_FLT, ALL);
			}
	//	}else{
		//	String category = getSelectedRadioButton(categoryPanelUc,COMMA_SEPARATOR);
	//		if (!category.isEmpty()) {
	//			filterMap.put(IsSearchView.CATEGORY_FLT, category);
	//		} else {
	//			filterMap.put(IsSearchView.CATEGORY_FLT, "all");
	//		}
	//	}
		String selectedSubject = getSelectedFilter(subjectPanelUc, "~~");
		if (!selectedSubject.isEmpty()) {
			filterMap.put(IsSearchView.SUBJECT_FLT, selectedSubject);
		}
		if (resourceSearch) {
			String sourceSgsts = getSuggestions(sourceContainerFloPanel);
			if (!sourceSgsts.isEmpty()) {
				filterMap.put(IsSearchView.SOURCE_FLT, sourceSgsts);
			}
		} else {
			String authorSgsts = getSuggestions(authorContainerFloPanel);
			if (!authorSgsts.isEmpty()) {
				filterMap.put(IsSearchView.OWNER_FLT, authorSgsts);
			}
		}
		String standardSgsts = getSuggestions(standardContainerFloPanel);
		if (!standardSgsts.isEmpty()) {
			filterMap.put(IsSearchView.STANDARD_FLT, standardSgsts);
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			if (chkNotFriendly !=null &&  chkNotFriendly.getValue()){
//				if (chkNotFriendly.getText().equalsIgnoreCase("not_ipad_friendly")){
					filterMap.put(IsSearchView.MEDIATYPE_FLT, "not_ipad_friendly");
//				}
			}
		}else{
			filterMap.remove(IsSearchView.MEDIATYPE_FLT);
		}
		return filterMap;
	}

	/**
	 * Suggest added filters
	 * @param flowPanel instance of {@link FlowPanel} which has all filter value as widget
	 * @return filter suggestions as string
	 */
	public String getSuggestions(FlowPanel flowPanel) {
		String suggestions = "";
		Iterator<Widget> widgets = flowPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof FilterLabelVc) {
				if (!suggestions.isEmpty()) {
					suggestions += COMMA_SEPARATOR;
				}
				suggestions += ((FilterLabelVc) widget).getSourceText();
			} else if (widget instanceof DownToolTipWidgetUc) {
				if (!suggestions.isEmpty()) {
					suggestions += COMMA_SEPARATOR;
				}
				suggestions += ((FilterLabelVc) ((DownToolTipWidgetUc) widget).getWidget()).getSourceText();
			}
		}
		return suggestions;
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

	/**
	 * @param filterDisclosurePanell instance of {@link DisclosurePanelUc}
	 * @return selected filterDisclosurePanell name
	 */
	private String getSelectedFilter(DisclosurePanelUc filterDisclosurePanell) {
		return getSelectedFilter(filterDisclosurePanell, COMMA_SEPARATOR);
	}

	/**
	 * Get filters for search
	 * @param filterDisclosurePanell instance of {@link DisclosurePanelUc} which has filters widget
	 * @param separator concatenation of the filters with separator
	 * @return concatenation of selected filters
	 */
	private String getSelectedFilter(DisclosurePanelUc filterDisclosurePanell, String separator) {
		String selectedFilter = "";
			for (Widget filterWidget : filterDisclosurePanell.getContent()) {
				if (filterWidget instanceof CheckBox) {
					CheckBox filterCheckBox = (CheckBox) filterWidget;
					if (filterCheckBox != null && filterCheckBox.getValue()) {
						if (!selectedFilter.isEmpty()) {
							selectedFilter += separator;
						}
						selectedFilter += filterCheckBox.getName();
					}
				}
			}
	
		return selectedFilter;
	}
	
	/*private String getSelectedRadioButton(DisclosurePanelUc filterDisclosurePanell, String separator){
		String selectedFilter = "";
		for (Widget filterWidget : filterDisclosurePanell.getContent()) {
			if (filterWidget instanceof QuestionTypeFilter) {
				QuestionTypeFilter filterRadiobuttonBox = (QuestionTypeFilter) filterWidget;
				if (filterRadiobuttonBox.hiddenRadioButton != null && filterRadiobuttonBox.hiddenRadioButton.getValue()) {
					if (!selectedFilter.isEmpty()) {
						selectedFilter += separator;
					}
					selectedFilter += filterRadiobuttonBox.hiddenRadioButton.getText();
				}
			}
		}
		return selectedFilter;
		
	}*/

	/**
	 * Set search filters
	 * @param filter as Map to set filter values 
	 */
	public void setFilter(Map<String, String> filter) {
		String grade = filter.get(IsSearchView.GRADE_FLT);
		String notFriendly = filter.get(IsSearchView.MEDIATYPE_FLT);
		setSelectedFilter(gradePanelUc, grade);
		String categories = filter.get(IsSearchView.CATEGORY_FLT);
		if(categories==null){
			clearAllFields();
		}
		setSelectedFilter(categoryPanelUc, categories);
		String subjects = filter.get(IsSearchView.SUBJECT_FLT);
		setSelectedFilter(subjectPanelUc, subjects, "~~");
		standardSgstBox.setText("");
		sourceSgstBox.setText("");
		authorTxtBox.setText("");
		String standards = filter.get(IsSearchView.STANDARD_FLT);
		if (standards != null) {
			setFilterSuggestionData(standardContainerFloPanel, standards.split(COMMA_SEPARATOR), true);
		}
		if (resourceSearch) {
			String sources = filter.get(IsSearchView.SOURCE_FLT);
			if (sources != null) {
				setFilterSuggestionData(sourceContainerFloPanel, sources.split(COMMA_SEPARATOR), false);
			}
		} else {
			String authors = filter.get(IsSearchView.OWNER_FLT);
			if (authors != null) {
				setFilterSuggestionData(authorContainerFloPanel, authors.split(COMMA_SEPARATOR), false);
			}
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			if (notFriendly!=null){
				chkNotFriendly.setValue(true);
			}else{
				chkNotFriendly.setValue(false);
			}
		}
	}
	/**
	 * 
	 * @function setFilterSuggestionData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set filter suggestion data.
	 * 
	 * 
	 * @parm(s) : @param flowPanel
	 * @parm(s) : @param filters
	 * @parm(s) : @param addToolTip
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setFilterSuggestionData(FlowPanel flowPanel, String[] filters, boolean addToolTip) {

		Iterator<Widget> widgets = flowPanel.iterator();
		while (widgets.hasNext()) {
			Widget filterWidget = widgets.next();
			boolean exist = false;
			for (String filter : filters) {
				if (filterWidget instanceof FilterLabelVc && filter.equals(((FilterLabelVc) filterWidget).getSourceText())) {
					exist = true;
				} else if (filterWidget instanceof DownToolTipWidgetUc && filter.equals(((FilterLabelVc) ((DownToolTipWidgetUc) filterWidget).getWidget()).getSourceText())) {
					exist = true;
				}
				if (exist) {
					break;
				}
			}
			if (!exist) {
				filterWidget.removeFromParent();
			}
		}
		widgets = flowPanel.iterator();
		String filterCodes = "";
		for (String filter : filters) {
			boolean exist = false;
			while (widgets.hasNext()) {
				Widget filterWidget = widgets.next();
				if (filterWidget instanceof FilterLabelVc && filter.equals(((FilterLabelVc) filterWidget).getSourceText())) {
					exist = true;
				} else if (filterWidget instanceof DownToolTipWidgetUc && filter.equals(((FilterLabelVc) ((DownToolTipWidgetUc) filterWidget).getWidget()).getSourceText())) {
					exist = true;
				}
				if (exist) {
					break;
				}
			}
			if (!exist) {
				if (addToolTip) {
					flowPanel.add(new DownToolTipWidgetUc(new FilterLabelVc(filter) {
						
						@Override
						public void onCloseLabelClick(ClickEvent event) {
							getParent().removeFromParent();
							AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
						}
						
					}, "No description Available"));
					filterCodes += COMMA_SEPARATOR + filter;
				} else {
					flowPanel.add(new FilterLabelVc(filter));
				}
			}
		}

		if (filterCodes.length() > 1) {
			standardsInfoSearchDo.setQuery(filterCodes);
			AppClientFactory.fireEvent(new StandardsSuggestionInfoEvent(standardsInfoSearchDo));
		}
	}

	/**
	 * Call setSelectedFilter method
	 * @param filterFlowPanel instance of {@link DisclosurePanelUc}
	 * @param checkedValues filters name 
	 */
	private void setSelectedFilter(DisclosurePanelUc filterFlowPanel, String checkedValues) {
		setSelectedFilter(filterFlowPanel, checkedValues, COMMA_SEPARATOR);
	}

	/**
	 * Set filter value for search with separator
	 * @param filterFlowPanel instance of {@link DisclosurePanelUc} which has filter values
	 * @param checkedValues selected filter value
	 * @param separator concatenation of the filter value by separator 
	 */
	private void setSelectedFilter(DisclosurePanelUc filterFlowPanel, String checkedValues, String separator) {
		List<String> items = null;
		if (checkedValues != null) {
			items = Arrays.asList(checkedValues.split("\\s*" + separator + "\\s*"));
		}
		
		if (items != null) {
			//if(resourceSearch){
				for (Widget filterWidget : filterFlowPanel.getContent()) {
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
			//}
/*			else{
				boolean isRadioButtonSelected=false;
				for (Widget filterWidget : filterFlowPanel.getContent()) {
					if (filterWidget instanceof QuestionTypeFilter) {
						QuestionTypeFilter questionTypeFilter = (QuestionTypeFilter) filterWidget;
						//filterCheckBox.setValue(false);
						questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButton());
						questionTypeFilter.hiddenRadioButton.setValue(false);
						for (String item : items) {
							if ((questionTypeFilter.hiddenRadioButton.getText().equals(item))) {
								questionTypeFilter.hiddenRadioButton.setValue(true);
								isRadioButtonSelected=true;
								questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonSelected());
							}
						}
					}
				}
//				if(!isRadioButtonSelected){
//					QuestionTypeFilter questionTypeFilter = (QuestionTypeFilter)filterFlowPanel.getContent().getWidget(2);
//					questionTypeFilter.hiddenRadioButton.setValue(true);
//					questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonSelected());
//				}
				
			}*/
			
		}
		
	}

	/**
	 * Clear all selected filter values
	 * @param filterFlowPanel instance {@link DisclosurePanelUc} which has selected filter values
	 */
	public void clearFilter(DisclosurePanelUc filterFlowPanel) {
	//	if(resourceSearch){
			for (Widget filterWidget : filterFlowPanel.getContent()) {
				if (filterWidget instanceof CheckBox) {
					((CheckBox) filterWidget).setValue(false);
				}
			}
/*		}else{
			for (Widget filterWidget : filterFlowPanel.getContent()) {
				if (filterWidget instanceof QuestionTypeFilter) {
					QuestionTypeFilter questionTypeFilter = (QuestionTypeFilter) filterWidget;
					questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButton());
					questionTypeFilter.hiddenRadioButton.setValue(false);
					if(questionTypeFilter.hiddenRadioButton.getText().equalsIgnoreCase("all")){
						questionTypeFilter.hiddenRadioButton.setValue(true);
						questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonSelected());
					}

				}
				if (filterWidget instanceof CheckBox) {
					((CheckBox) filterWidget).setValue(false);
				}
			}
//			QuestionTypeFilter questionTypeFilter = (QuestionTypeFilter)filterFlowPanel.getContent().getWidget(2);
//			questionTypeFilter.hiddenRadioButton.setValue(true);
//			questionTypeFilter.radioButton.setStyleName(SearchMoreInfoVcCBundle.INSTANCE.css().questionRadioButtonSelected());
		}*/
	}

	/**
	 * Clear all specified widget values , specified text box and refresh event  
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("clearAll")
	public void onClearFilter(ClickEvent clickEvent) {
		clearFilter(categoryPanelUc);
		clearFilter(gradePanelUc);
		clearFilter(subjectPanelUc);
		standardSgstBox.setText("");
		sourceSgstBox.setText("");
		sourceContainerFloPanel.clear();
		standardContainerFloPanel.clear();
		authorContainerFloPanel.clear();
		standardCodesMap.clear();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			chkNotFriendly.setValue(false);
		}
		AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
	}
	/**
	 * 
	 * @function clearAllFields 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to clear all the filelds.
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
	public void clearAllFields(){
		clearFilter(categoryPanelUc);
		clearFilter(gradePanelUc);
		clearFilter(subjectPanelUc);
		standardSgstBox.setText("");
		sourceSgstBox.setText("");
		sourceContainerFloPanel.clear();
		standardContainerFloPanel.clear();
		authorContainerFloPanel.clear();
		standardCodesMap.clear();
		AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
	}
	/**
	 * On selection it will fadein/fadeOut some of labels.
	 */
	@Override
	public void onSelection(SelectionEvent<SuggestOracle.Suggestion> event) {
		if (event.getSource().equals(sourceSgstBox)) {
			String text = sourceSgstBox.getValue();
			if (text.equals(NO_MATCH_FOUND)) {
				new FadeInAndOut(sourcesNotFoundLbl.getElement(), 5000, 5000);
			} else {
				sourceContainerFloPanel.add(new FilterLabelVc(text,true));
				AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
			}
			sourceSgstBox.setText("");
			sourceSuggestOracle.clear();
		} else {
			String text = standardSgstBox.getValue();
			if (text.equals(NO_MATCH_FOUND)) {
				new FadeInAndOut(standardsNotFoundLbl.getElement(), 5000, 5000);
			} else {
				addStandardFilter(text);
				AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
			}
			standardSgstBox.setText("");
			standardSuggestOracle.clear();
		}
	}
	/**
	 * 
	 * @function addStandardFilter 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is to add standard filter.
	 * 
	 * 
	 * @parm(s) : @param code
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void addStandardFilter(String code) {		
		standardContainerFloPanel.add(new DownToolTipWidgetUc(new FilterLabelVc(code), standardCodesMap.get(code)));
	}

	/**
	 * Set suggestion standards
	 * @param standardSearchDo instance of {@link SearchDo} type of CodeDo 
	 */
	public void setStandardSuggestions(SearchDo<CodeDo> standardSearchDo) {
		standardSuggestOracle.clear();
		this.standardSearchDo = standardSearchDo;
		if (this.standardSearchDo.getSearchResults() != null) {
			List<String> sources = getSuggestionsAsList(standardContainerFloPanel);
			for (CodeDo code : standardSearchDo.getSearchResults()) {
				if (!sources.contains(code.getCode())) {
					standardSuggestOracle.add(code.getCode());
				}
				standardCodesMap.put(code.getCode(), code.getLabel());
			}
		}
		if (standardSuggestOracle.isEmpty()) {
			standardSuggestOracle.add(NO_MATCH_FOUND);
		}
		standardSgstBox.showSuggestionList();
	}
	/**
	 * 
	 * @function setSourceSuggestionsInfo 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This file is to set SourceSuggestionsInfo.
	 * 
	 * 
	 * @parm(s) : @param searchDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setSourceSuggestionsInfo(SearchDo<CodeDo> searchDo) {
		Iterator<Widget> widgets = standardContainerFloPanel.iterator();
		while (widgets.hasNext()) {
			DownToolTipWidgetUc downToolTipWidgetUc = (DownToolTipWidgetUc) widgets.next();
			FilterLabelVc filterWidget = (FilterLabelVc) downToolTipWidgetUc.getWidget();
			HTML html = (HTML)downToolTipWidgetUc.getToolTipWidget();
			for (CodeDo code : searchDo.getSearchResults()) {
				if (filterWidget.getSourceText().equals(code.getCode())) {
					html.setHTML(code.getLabel());
					break;
				}
			}
		}
	}

	/**
	 * @param sourceSearchDo instance of {@link SearchDo}
	 */
	public void setSourceSuggestions(SearchDo<String> sourceSearchDo) {
		sourceSuggestOracle.clear();
		this.sourceSearchDo = sourceSearchDo;
		if (this.sourceSearchDo.getSearchResults() != null) {
			this.sourceSearchDo.getSearchResults().removeAll(getSuggestionsAsList(sourceContainerFloPanel));
		}
		if (this.sourceSearchDo.getSearchResults() != null && this.sourceSearchDo.getSearchResults().size() > 0) {
			sourceSuggestOracle.setAll(sourceSearchDo.getSearchResults());
		} else {
			sourceSuggestOracle.add(NO_MATCH_FOUND);
		}
		sourceSgstBox.showSuggestionList();
	}

}
