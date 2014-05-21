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
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.GetSearchKeyWordEvent;
import org.ednovo.gooru.client.mvp.search.event.SourceSuggestionEvent;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionEvent;
import org.ednovo.gooru.client.mvp.search.event.AggregatorSuggestionEvent;
import org.ednovo.gooru.client.mvp.search.event.StandardsSuggestionInfoEvent;
import org.ednovo.gooru.client.mvp.search.event.SwitchSearchEvent;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.DisclosurePanelUc;
import org.ednovo.gooru.client.uc.DownToolTipUc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.search.AbstractSearchDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.search.SearchFilterDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
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
 * @author Search Team
 * 
 */
public class SearchFilterVc extends Composite implements SelectionHandler<SuggestOracle.Suggestion>,MessageProperties {

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
	DisclosurePanelUc sourcePanelUc,aggregatorPanelUc;

	@UiField
	DisclosurePanelUc standardPanelUc;

	@UiField
	DisclosurePanelUc authorPanelUc;
	
	@UiField HTMLPanel panelNotMobileFriendly;
	
	@UiField
	HTMLPanel oerPanel;

	@UiField(provided = true)
	AppSuggestBox sourceSgstBox;

	@UiField
	TextBox authorTxtBox;

	@UiField(provided = true)
	AppSuggestBox standardSgstBox;
	
	@UiField(provided = true)
	AppSuggestBox aggregatorSgstBox;
	
	@UiField
	FlowPanel authorContainerFloPanel;

	@UiField
	FlowPanel sourceContainerFloPanel,aggregatorContainerFloPanel;

	@UiField
	FlowPanel standardContainerFloPanel;

	@UiField
	Label sourcesNotFoundLbl,filtersText,notifyText,aggregatorNotFoundLbl;

	@UiField
	Label standardsNotFoundLbl;
	
	@UiField
	Label sourceHelpicon, standardHelpicon,clearAll,aggregatorHelpicon;

	@UiField
	HTMLEventPanel sourceToolTip, standardToolTip,aggregatorToolTip;
	
	/*@UiField Image publisherTooltip;*/
	CheckBox chkNotFriendly = null;
	CheckBox chkOER = null;
	@UiField
	Style style;
	
	
	ToolTip toolTip = null;
	
	private AppMultiWordSuggestOracle sourceSuggestOracle;

	private AppMultiWordSuggestOracle standardSuggestOracle;
	
	private AppMultiWordSuggestOracle aggregatorSuggestOracle;

	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>();

	private SearchDo<CodeDo> standardsInfoSearchDo = new SearchDo<CodeDo>();

	private SearchDo<String> sourceSearchDo = new SearchDo<String>();
	
	private SearchDo<String> aggregatorSearchDo = new SearchDo<String>();
	
	private Map<String,String> standardCodesMap = new HashMap<String, String>();

	private static final String NO_MATCH_FOUND = GL0723;
	
	private static final String ALL = "All";
	
	private static final String COMMA_SEPARATOR = GL_GRR_COMMA;

	private boolean resourceSearch;
	
	private DownToolTipUc sourcetooltipPopUpUc;
	
	private DownToolTipUc standardtooltipPopUpUc;

	private boolean isSourcePopupShowing=false;

	private boolean isStandardPopupShowing=false;
	
	private DownToolTipUc aggregatortooltipPopUpUc;
	
	private static final String USER_META_ACTIVE_FLAG = "0";
	
	List<String> standardPreflist = null;
	List<String> standardPrefListElement = null;
				
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
		if(AppClientFactory.getLoggedInUser().getSettings().getTaxonomyPreferences()!=null){
		String[] standards = AppClientFactory.getLoggedInUser().getSettings().getTaxonomyPreferences().split(",");
		standardPrefListElement=new ArrayList<String>();
			for (String str : standards) {
				standardPrefListElement.add(str);
		 }
		}
		final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();
		
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {
			@Override
			public void keyAction(String text) {
				text=text.toUpperCase();
				if(AppClientFactory.isAnonymous()) {
					standardSearchDo.setSearchResults(null);
					standardSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						AppClientFactory.fireEvent(new StandardsSuggestionEvent(standardSearchDo));
					}
				} else {
					boolean standardsPrefDisplayPopup = false;
					standardPreferenceTooltip.hide();
					standardSearchDo.setSearchResults(null);
					standardSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						
						standardPreferenceTooltip.hide();
						standardSuggestOracle.clear();
							if(standardPreflist!=null){
								for(int count=0; count<standardPreflist.size();count++) {
									if(text.contains("CCSS") || text.contains("TEKS") || text.contains("CA")) {
										if(text.contains(standardPreflist.get(count))) {
											standardsPrefDisplayPopup = true;
											break;
										} else {
											standardsPrefDisplayPopup = false;
										}
									} else {
										standardsPrefDisplayPopup = true;
									}
								}
							}
							
							if(standardsPrefDisplayPopup==true){
								standardPreferenceTooltip.hide();
								AppClientFactory.fireEvent(new StandardsSuggestionEvent(standardSearchDo));
							} else{
								standardSgstBox.hideSuggestionList();
								standardSuggestOracle.clear();
								standardPreferenceTooltip.show();
								standardPreferenceTooltip.setPopupPosition(standardSgstBox.getAbsoluteLeft()+3, standardSgstBox.getAbsoluteTop()+33);
							}
							
						}
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
		aggregatorSuggestOracle = new AppMultiWordSuggestOracle(true);
		aggregatorSearchDo.setPageSize(10);	
		aggregatorSgstBox = new AppSuggestBox(aggregatorSuggestOracle) {
			
			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void keyAction(String text) {
				if (resourceSearch) {
					aggregatorSearchDo.setSearchResults(null);
					aggregatorSearchDo.setQuery(text);
					if (text != null && text.trim().length() > 0) {
						//AppClientFactory.fireEvent(new AggregatorSuggestionEvent(aggregatorSearchDo));
					}
				}
				
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
		
		sourceSgstBox.getElement().setAttribute("placeHolder", GL1464);
		sourceSgstBox.getElement().setId("asSourceSgst");
		sourceSgstBox.getElement().setAttribute("style","margin-top: 5px;");
		standardSgstBox.addSelectionHandler(this);
		aggregatorSgstBox.getElement().setId("asAggregatorSgst");
		aggregatorSgstBox.getElement().setAttribute("placeHolder", GL1749);
		aggregatorSgstBox.getElement().setAttribute("style","margin-top: 5px;");
		
		BlurHandler blurhander=new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if(standardPreferenceTooltip!=null && standardPreferenceTooltip.isShowing()){
					standardPreferenceTooltip.hide();
				}
			}
		};
		standardSgstBox.addDomHandler(blurhander, BlurEvent.getType());
		initWidget(uiBinder.createAndBindUi(this));
		filtersText.setText(GL0719);
		resourceLinkLbl.setText(GL0174);
		notifyText.setText(GL0720);
		collectionLinkLbl.setText(GL0175);
		categoryPanelUc.setHeaderTitle(GL0721);
		sourcePanelUc.setHeaderTitle(GL0566);
		sourceHelpicon.setText(GL_SPL_QUESTION);
		sourcesNotFoundLbl.setText(GL0723);
		authorPanelUc.setHeaderTitle(GL0573);
		standardPanelUc.setHeaderTitle(GL0724);
		standardHelpicon.setText(GL_SPL_QUESTION);
		standardsNotFoundLbl.setText(GL0723);
		subjectPanelUc.setHeaderTitle(GL0226);
		gradePanelUc.setHeaderTitle(GL0165);
		clearAll.setText(GL0725);
	//	oerPanel.setVisible(false);
		aggregatorPanelUc.setHeaderTitle(GL1748);
		
		if (resourceSearch) {
			sourcePanelUc.setVisible(true);
			aggregatorPanelUc.setVisible(true);
			sourcesNotFoundLbl.getElement().getStyle().setOpacity(0.0);
			sourceSgstBox.addSelectionHandler(this);
			aggregatorSgstBox.addSelectionHandler(this);
			aggregatorNotFoundLbl.getElement().getStyle().setOpacity(0.0);
			
			final Image publisherTooltip  = new Image();
			publisherTooltip.setUrl("images/mos/questionmark.png");
			publisherTooltip.getElement().getStyle().setMarginTop(-46, Unit.PX);
			publisherTooltip.getElement().getStyle().setMarginLeft(73, Unit.PX);
			publisherTooltip.getElement().getStyle().setPosition(Position.ABSOLUTE);
			publisherTooltip.setAltText(GL0732);
			publisherTooltip.setTitle(GL0732);
			
			final Image aggregatorTooltip = new Image();
			aggregatorTooltip.setUrl("images/mos/questionmark.png");
			aggregatorTooltip.getElement().getStyle().setMarginTop(-46, Unit.PX);
			aggregatorTooltip.getElement().getStyle().setMarginLeft(85, Unit.PX);
			aggregatorTooltip.getElement().getStyle().setPosition(Position.ABSOLUTE);
			
			aggregatorTooltip.setAltText(GL0732);
			aggregatorTooltip.setTitle(GL0732);
			aggregatorPanelUc.getContent().add(aggregatorTooltip);
			sourcePanelUc.getContent().add(publisherTooltip);
			publisherTooltip.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTip = new ToolTip(GL1769);
					toolTip.getLblLink().setVisible(false);
					toolTip.getElement().getStyle().setBackgroundColor("transparent");
					toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
					toolTip.setPopupPosition(publisherTooltip.getAbsoluteLeft()-(50+22), publisherTooltip.getAbsoluteTop()+22);
					toolTip.show();
				}
			});
			publisherTooltip.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					EventTarget target = ((MouseOutEvent) event).getRelatedTarget();
					  if (Element.is(target)) {
						  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
							  toolTip.hide();
						  }
					  }	
					
				}
			});
			aggregatorTooltip.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTip = new ToolTip(GL1768);
					toolTip.getLblLink().setVisible(false);
					toolTip.getElement().getStyle().setBackgroundColor("transparent");
					toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
					toolTip.setPopupPosition(aggregatorTooltip.getAbsoluteLeft()-(50+22), aggregatorTooltip.getAbsoluteTop()+22);
					toolTip.show();
					
				}
			});
			aggregatorTooltip.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					EventTarget target = ((MouseOutEvent) event).getRelatedTarget();
					  if (Element.is(target)) {
						  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
							  toolTip.hide();
						  }
					  }	
					
				}
			});
			
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
			categoryPanelUc.setHeaderTitle(GL0721);
			categoryPanelUc.getElement().addClassName("categoryFilterContainer");
		}else{
			categoryPanelUc.setHeaderTitle(GL1465);
		}
		
		resourceLinkLbl.getElement().setId("lblResourceLink");
		collectionLinkLbl.getElement().setId("lblCollectionLink");
		
		resourceLinkLbl.setText(GL0174);
		collectionLinkLbl.setText(GL0175);
		
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
			MixpanelUtil.mixpanelEvent("search_video_filter_selected");
			categoryChk.getElement().setId("chkVideos");	
		}else if(value.equalsIgnoreCase("webpage")){
			MixpanelUtil.mixpanelEvent("search_webpage_filter_selected");
			categoryChk.getElement().setId("chkwebpage");	
		}
		/*else if(value.equalsIgnoreCase("websites"))
		{
			MixpanelUtil.mixpanelEvent("search_websites_filter_selected");
			categoryChk.getElement().setId("chkwebsites");	
		}*/
		else if(value.equalsIgnoreCase("interactives")){
			MixpanelUtil.mixpanelEvent("search_interactives_filter_selected");
			categoryChk.getElement().setId("chkInteractives");
		}
		else if(value.equalsIgnoreCase("questions")){
			MixpanelUtil.mixpanelEvent("search_questions_filter_selected");
			categoryChk.getElement().setId("chkQuestions");
		}
		else if(value.equalsIgnoreCase("images")){
			MixpanelUtil.mixpanelEvent("search_images_filter_selected");
			categoryChk.getElement().setId("chkImages");
		}
		else if(value.equalsIgnoreCase("texts")){
			MixpanelUtil.mixpanelEvent("search_texts_filter_selected");
			categoryChk.getElement().setId("chkTexts");
		}
		else if(value.equalsIgnoreCase("audios")){
			MixpanelUtil.mixpanelEvent("search_audios_filter_selected");
			categoryChk.getElement().setId("chkAudios");
		}
		/*else if(value.equalsIgnoreCase("others")){
			MixpanelUtil.mixpanelEvent("search_others_filter_selected");
			categoryChk.getElement().setId("chkOther");
		}*/
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
	public void renderCheckBox(HTMLPanel disclosurePanelVc, String key, final String value) {
		
		chkNotFriendly = new CheckBox();
		chkNotFriendly.setText(value);
		chkNotFriendly.setName(key);
		
		if(value.equalsIgnoreCase("Mobile Friendly")){
			disclosurePanelVc.setStyleName("mobilefriendlyContainer");
			chkNotFriendly.getElement().setId("chkNotFriendly");
			chkNotFriendly.getElement().getStyle().setMarginTop(20, Unit.PX);
			/*chkNotFriendly.getElement().getStyle().setMarginLeft(9, Unit.PX);
			chkNotFriendly.getElement().getStyle().setWidth(102, Unit.PX);*/
		}
		/*if(value.equalsIgnoreCase("Show only OER")){
			chkNotFriendly.getElement().setId("chkOer");
			chkNotFriendly.getElement().getStyle().setMarginTop(20, Unit.PX);
			chkNotFriendly.setStyleName(CssTokens.FILTER_CHECKBOX);
		}*/
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
	public void renderOERCheckBox(HTMLPanel disclosurePanelVc, String key, final String value) {
		chkOER = new CheckBox();	
		chkOER.setText(value);
		chkOER.setName(key);
		disclosurePanelVc.add(chkOER);
		if(value.equalsIgnoreCase("OER")){
			disclosurePanelVc.setStyleName("oerContainer");
			chkOER.getElement().setId("chkOer");
			chkOER.getElement().getStyle().setMarginTop(-10, Unit.PX);
			chkOER.setStyleName(CssTokens.FILTER_CHECKBOX);
		}
		chkOER.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if (chkOER.getValue()){
					MixpanelUtil.mixpanelEvent("checks the OER filter box");

				}else{
					MixpanelUtil.mixpanelEvent("unchecks the OER filter box");
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
	
	
	@UiHandler("sourceHelpicon")
	public void onSourceHelpIconClicked(ClickEvent event) {
		if(!(sourceToolTip.getWidgetCount()>0)) {
			sourcetooltipPopUpUc = new DownToolTipUc();
			sourcetooltipPopUpUc.setContent(new HTML(GL0246));
			sourceToolTip.add(sourcetooltipPopUpUc);
		}
		if(sourceToolTip.isVisible()) {
			sourceToolTip.setVisible(false);
		} else {
			sourceToolTip.setVisible(true);
			standardToolTip.setVisible(false);
			aggregatorToolTip.setVisible(false);
		}
		isSourcePopupShowing = true;
	}
	
	@UiHandler("standardHelpicon")
	public void onStandardHelpiconClicked(ClickEvent event) {
		if(!(standardToolTip.getWidgetCount()>0)) {
			standardtooltipPopUpUc = new DownToolTipUc();
			standardtooltipPopUpUc.setContent(new HTML(GL0247));
			standardToolTip.add(standardtooltipPopUpUc);
		}
		if(standardToolTip.isVisible()) {
			standardToolTip.setVisible(false);
		} else {
			sourceToolTip.setVisible(false);
			standardToolTip.setVisible(true);
			aggregatorToolTip.setVisible(false);
		}
		isStandardPopupShowing = true;
	}
	@UiHandler("aggregatorHelpicon")
	public void onAggregatorHelpiconClicked(ClickEvent event) {
		if(!(aggregatorToolTip.getWidgetCount()>0)) {
			aggregatortooltipPopUpUc = new DownToolTipUc();
			aggregatortooltipPopUpUc.setContent(new HTML(GL0247));
			aggregatorToolTip.add(aggregatortooltipPopUpUc);
		}
		if(aggregatorToolTip.isVisible()) {
			aggregatorToolTip.setVisible(false);
		} else {
			sourceToolTip.setVisible(false);
			standardToolTip.setVisible(false);
			aggregatorToolTip.setVisible(true);
		}
	//	isStandardPopupShowing = true;
		
	}
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
		oerPanel.clear();
		if (searchFilterDo != null) {
			if (searchFilterDo.getCategories() != null) {
				Iterator<Map.Entry<String, String>> categoriesIterator = searchFilterDo.getCategories().entrySet().iterator();
				while (categoriesIterator.hasNext()) {
					Map.Entry<String, String> entry = categoriesIterator.next();
					renderCheckBox(categoryPanelUc, entry.getKey(), entry.getValue());
				}
			}
			if (searchFilterDo.getGradeLevels() != null) {		
				renderCheckBox(gradePanelUc, "K-4", GL0166);
				renderCheckBox(gradePanelUc, "5-8", GL0167);
				renderCheckBox(gradePanelUc, "9-12", GL0168);
				renderCheckBox(gradePanelUc, "H", GL0169);
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
			imgNotFriendly.getElement().getStyle().setLeft(114, Unit.PX);
			imgNotFriendly.getElement().getStyle().setTop(-21, Unit.PX);
			imgNotFriendly.getElement().getStyle().setMarginLeft(30, Unit.PX);
			imgNotFriendly.getElement().getStyle().setPosition(Position.RELATIVE);
	
			
			
/*			imgNotFriendly.getElement().getStyle().setMarginLeft(29, Unit.PX);
*/
			imgNotFriendly.getElement().getStyle().setCursor(Cursor.POINTER);
			imgNotFriendly.setAltText(GL0732);
			imgNotFriendly.setTitle(GL0732);
			imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTip = new ToolTip(GL0454+""+"<img src='/images/mos/ipadFriendly.png' style='margin-top:0px;'/>"+" "+GL04431);
					
					toolTip.getElement().getStyle().setBackgroundColor("transparent");
					toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
					toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(50+22), imgNotFriendly.getAbsoluteTop()+22);
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
			//added for OER search
			renderOERCheckBox(oerPanel, "not_show_OER", "OER");
			final Image oer = new Image("images/mos/questionmark.png");
			oer.getElement().getStyle().setLeft(85, Unit.PX);
			oer.getElement().getStyle().setTop(-20, Unit.PX);
			oer.getElement().getStyle().setPosition(Position.RELATIVE);
			oer.getElement().getStyle().setCursor(Cursor.POINTER);
			oer.setAltText(GL0732);
			oer.setTitle(GL0732);
			oer.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTip = new ToolTip(GL1767);
					toolTip.getLblLink().setVisible(false);
					toolTip.getElement().getStyle().setBackgroundColor("transparent");
					toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
					toolTip.setPopupPosition(oer.getAbsoluteLeft()-(50+22), oer.getAbsoluteTop()+22);
					toolTip.show();
				}
			
			});
			oer.addMouseOutHandler(new MouseOutHandler() {
				
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
			oerPanel.add(oer);
			oerPanel.setVisible(true);
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
			String aggregatorSgsts = getSuggestions(aggregatorContainerFloPanel);
			if (!aggregatorSgsts.isEmpty()) {
				filterMap.put(IsSearchView.SOURCE_FLT, aggregatorSgsts);
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
			if(chkOER!=null && chkOER.getValue()){
				filterMap.put(IsSearchView.OER_FLT, "1");
			}
			}else{
			filterMap.remove(IsSearchView.MEDIATYPE_FLT);
			filterMap.remove(IsSearchView.OER_FLT);
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
	 * Get added suggestion filters
	 * @param flowPanel instance of {@link FlowPanel} which has all filter value as widget
	 * @return filter suggestions as string
	 */
	public List<String> getAggregatorAsList(FlowPanel flowPanel) {
		List<String> aggregations = new ArrayList<String>();
		Iterator<Widget> widgets = flowPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof FilterLabelVc) {
				aggregations.add(((FilterLabelVc) widget).getSourceText());
			} else if (widget instanceof DownToolTipWidgetUc) {
				aggregations.add(((FilterLabelVc) ((DownToolTipWidgetUc) widget).getWidget()).getSourceText());
			}
		}
		return aggregations;
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
						MixpanelUtil.mixpanelEvent("search_"+selectedFilter+"_filter_selected");
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
		String oer = filter.get(IsSearchView.OER_FLT);
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
		aggregatorSgstBox.setText("");
		String standards = filter.get(IsSearchView.STANDARD_FLT);
		if (standards != null) {
			setFilterSuggestionData(standardContainerFloPanel, standards.split(COMMA_SEPARATOR), true);
		}
		if (resourceSearch) {
			String sources = filter.get(IsSearchView.SOURCE_FLT);
			if (sources != null) {
				setFilterSuggestionData(sourceContainerFloPanel, sources.split(COMMA_SEPARATOR), false);
			}
			String aggregator = filter.get(IsSearchView.SOURCE_FLT);
		if (aggregator != null) {
				//setFilterSuggestionData(aggregatorContainerFloPanel, aggregator.split(COMMA_SEPARATOR), false);
			}
			
		} else {
			String authors = filter.get(IsSearchView.OWNER_FLT);
			if (authors != null) {
				setFilterSuggestionData(authorContainerFloPanel, authors.split(COMMA_SEPARATOR), false);
			}
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			if (notFriendly!=null){
				try{
					chkNotFriendly.setValue(true);
				}catch(Exception e){
					
				}
			}else{
				try{
					chkNotFriendly.setValue(false);
				}catch(Exception e){
					
				}
			}
			if(oer!=null)
			{
				try{
				chkOER.setValue(true);
				}catch(Exception e){}
			}
			else{
				try{
				chkOER.setValue(false);
				}catch(Exception e){}
			}
		}
	}

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
						
					}, GL1466));
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
		aggregatorContainerFloPanel.clear();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)){
			chkNotFriendly.setValue(false);
			chkOER.setValue(false);
		}
		AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
	}
	
	public void clearAllFields(){
		clearFilter(categoryPanelUc);
		clearFilter(gradePanelUc);
		clearFilter(subjectPanelUc);
		standardSgstBox.setText("");
		sourceSgstBox.setText("");
		sourceContainerFloPanel.clear();
		standardContainerFloPanel.clear();
		authorContainerFloPanel.clear();
		aggregatorContainerFloPanel.clear();
		standardCodesMap.clear();
		AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
	}

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
			
		} else if(event.getSource().equals(aggregatorSgstBox)){
			String text = aggregatorSgstBox.getValue();
			if (text.equals(NO_MATCH_FOUND)) {
				new FadeInAndOut(aggregatorNotFoundLbl.getElement(), 5000, 5000);
			} else {
				aggregatorContainerFloPanel.add(new FilterLabelVc(text,true));
				AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
			}
			aggregatorSgstBox.setText("");
			aggregatorSuggestOracle.clear();
		}
			
			else {
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
	public void setAggregatorSuggestions(SearchDo<String> aggregatorSearchDo) {
		aggregatorSuggestOracle.clear();
		this.aggregatorSearchDo=aggregatorSearchDo;
		if(this.aggregatorSearchDo.getSearchResults() != null){
			this.aggregatorSearchDo.getSearchResults().removeAll(getAggregatorAsList(aggregatorContainerFloPanel));
		}
		if (this.aggregatorSearchDo.getSearchResults() != null && this.aggregatorSearchDo.getSearchResults().size() > 0) {
			aggregatorSuggestOracle.setAll(aggregatorSearchDo.getSearchResults());
		} else {
			aggregatorSuggestOracle.add(NO_MATCH_FOUND);
		}
		aggregatorSgstBox.showSuggestionList();
	}
	public void getUserStandardPrefCodeId()
	{
		/**
		 * This RPC is to get the User profile Details(codeId value)
		 */
		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(AppClientFactory.getGooruUid(),USER_META_ACTIVE_FLAG,new SimpleAsyncCallback<ProfileDo>() {

							@Override
							public void onSuccess(ProfileDo profileObj) {
								if(profileObj.getUser().getMeta().getTaxonomyPreference().getCode()!=null){
									if(profileObj.getUser().getMeta().getTaxonomyPreference().getCode().size()==0){
									standardPanelUc.setVisible(false);
									}else
									{
										standardPanelUc.setVisible(true);
										standardPreflist=new ArrayList<String>();
										for (String code : profileObj.getUser().getMeta().getTaxonomyPreference().getCode()) {
											standardPreflist.add(code);
											standardPreflist.add(code.substring(0, 2));
										 }
									}
								}else{
									standardPanelUc.setVisible(false);
								}
							}

						});
	}
	public void getStandardVisiblity()
	{
		standardPanelUc.setVisible(true);
	}
	
}
