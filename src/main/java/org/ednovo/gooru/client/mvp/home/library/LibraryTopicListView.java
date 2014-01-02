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
/**
 * 
 * @fileName : LibraryTopicListView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 04-Dec-2013
 *
 * @Author Chandra Veluru
 *
 * @Reviewer:
 */
package org.ednovo.gooru.client.mvp.home.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc;
import org.ednovo.gooru.client.mvp.home.library.customize.LoginCustomizePopUp;
import org.ednovo.gooru.client.mvp.home.library.events.OpenLessonConceptEvent;
import org.ednovo.gooru.client.mvp.home.library.events.OpenLessonConceptHandler;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoadingIconEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoadingIconHandler;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.LessonDo;
import org.ednovo.gooru.shared.model.library.LibraryCollectionItemDo;
import org.ednovo.gooru.shared.model.library.LibraryResourceDo;
import org.ednovo.gooru.shared.model.library.TopicDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LibraryTopicListView.java
 *
 * @description : This class is used to display the library topics list.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryTopicListView extends Composite {

	@UiField ScrollPanel lessonScrollPanel;
	@UiField HTMLPanel conceptList,collectionInfo,resourcesInside;
	@UiField HTMLEventPanel searchLink;
	@UiField Label topicTitleLbl, noCollectionLbl;
	@UiField Image collectionImage;
	@UiField HTML collectionTitleLbl, collectionDescriptionLbl;
	@UiField Button assignCollectionBtn, customizeCollectionBtn;
	@UiField HTMLPanel loadingImage, collectionViewer;
	
	@UiField LibraryStyleBundle libraryStyle;

	private HandlerRegistration imageHandler;

	
	@UiField FlowPanel standardsFloPanel;

	private Integer topicId;
	
	private boolean isScrollable = true;
	
	private boolean isAssignPopup = false;
	
	private boolean isCustomizePopup = false;
	
	private ConceptDo conceptDo;
	
	private String searchTitle="";
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";
	
	private static final String PNG = ".png";
	
	private static final String SMALL = "Small";
	
	private static final String DEFAULT_COLLECTION_IMAGE = "../images/default-collection-image-160x120.png";
	
	private static Integer LESSON_PAGE_INITIAL_LIMIT = 3;
	
	private static String PAGE = "page";
	
	private static final String COURSE_PAGE = "course-page";
	
	private static final String STANDARD_CODE = "code";

	private static final String STANDARD_DESCRIPTION = "description";
	
	private static final String PNG_CROP = "-80x60.";
	
	private static LibraryTopicViewUiBinder uiBinder = GWT.create(LibraryTopicViewUiBinder.class);
	
	private PopupPanel toolTipPopupPanel = new PopupPanel();

	interface LibraryTopicViewUiBinder extends
			UiBinder<Widget, LibraryTopicListView> {
	}
	/**
	 * Class constructor.
	 * @param topicDo
	 * @param topicNumber
	 */
	public LibraryTopicListView(TopicDo topicDo, Integer topicNumber) {
		initWidget(uiBinder.createAndBindUi(this));
		this.topicId = topicDo.getCodeId();
		topicTitleLbl.setText("Topic "+topicNumber+": "+topicDo.getLabel());
		searchTitle=topicDo.getLabel();
		setLessonData(topicDo.getLesson());
		try {
			setConceptData(topicDo.getLesson().get(0).getCollection().get(0),topicDo.getCodeId());
		} catch(Exception e) {
			collectionInfo.setVisible(false);
			resourcesInside.setVisible(false);
			noCollectionLbl.setVisible(true);
		}
		searchLink.addClickHandler(new OnSearchLinkClick());
		loadingImage.setVisible(false);
		AppClientFactory.getEventBus().addHandler(OpenLessonConceptEvent.TYPE, openLessonConceptHandler);
		AppClientFactory.getEventBus().addHandler(SetLoadingIconEvent.TYPE, setLoadingIconHandler);
		
		//Temporary fix
		//lessonScrollPanel.setHeight("15px");
		
	}
	
	/** 
	 * This method is to set the conceptDo
	 */
	public void setConceptDo(ConceptDo conceptDo) {
		this.conceptDo = conceptDo;
	}
	/**
	 * This will return the concept data.
	 */
	private ConceptDo getConceptDo() {
		return conceptDo;
	}
	
	/**
	 * 
	 * @param list 
	 * @function setLessonData 
	 * 
	 * @created_date : 04-Dec-2013
	 * 
	 * @description : Thsi method is used to set the lesson data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	private void setLessonData(final List<LessonDo> lessonDoList) {
		boolean isLessonHighlighted = true;
		if(lessonDoList.size()>=LESSON_PAGE_INITIAL_LIMIT) {
			for(int i=0;i<LESSON_PAGE_INITIAL_LIMIT;i++) {
				if(i==0) {
					isLessonHighlighted = true;
				} else {
					isLessonHighlighted = false;
				}
				conceptList.add(new LibraryLessonUc(lessonDoList.get(i),topicId,isLessonHighlighted, (i+1)));
			}
			final String subject = AppClientFactory.getPlaceManager().getRequestParameter("subject","featured");
			lessonScrollPanel.addScrollHandler(new ScrollHandler() {
				@Override
				public void onScroll(ScrollEvent event) {
					if(isScrollable) {
						isScrollable = false;
						AppClientFactory.getInjector().getLibraryService().getLessonsOnPagination(subject, ""+topicId, LESSON_PAGE_INITIAL_LIMIT, 5, new AsyncCallback<ArrayList<LessonDo>>() {
							@Override
							public void onFailure(Throwable caught) {
								throw new RuntimeException("Not implemented");
							}

							@Override
							public void onSuccess(ArrayList<LessonDo> result) {
								for(int i=0;i<result.size();i++) {
									conceptList.add(new LibraryLessonUc(result.get(i),topicId,false,((LESSON_PAGE_INITIAL_LIMIT+1)+i)));
								}
							}
						});
					}
				}
			});
		} else {
			for(int i=0;i<lessonDoList.size();i++) {
				if(i==0) {
					isLessonHighlighted = true;
				} else {
					isLessonHighlighted = false;
				}
				conceptList.add(new LibraryLessonUc(lessonDoList.get(i),topicId,isLessonHighlighted,(i+1)));
			}
		}
	}
	
	/**
	 * 
	 * @fileName : LibraryTopicListView.java
	 *
	 * @description : This will handle the click event on the search link button.
	 *
	 * @version : 1.0
	 *
	 * @date: 04-Dec-2013
	 *
	 * @Reviewer:
	 */
	private class OnSearchLinkClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			String page = AppClientFactory.getPlaceManager().getRequestParameter(PAGE,"landing");
			if(page.equals(COURSE_PAGE)) {
				MixpanelUtil.mixpanelEvent("CoursePage_search_topic");
			} else {
				MixpanelUtil.mixpanelEvent("LandingPage_search_topic");
			}
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_SEARCH, updateParams(searchTitle));
			
		}
	}
	
	/**
	 * 
	 * @function updateParams 
	 * 
	 * @created_date : 04-Dec-2013
	 * 
	 * @description : This method will update the parameters.
	 * 
	 * @parm(s) : @param searchQuery
	 * @parm(s) : @return
	 *
	 * @return : Map<String,String>
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public Map<String, String> updateParams(String searchQuery) {
		Map<String, String> params = new HashMap<String,String>();
		params.put("query", searchQuery);
		params.put("pageNum", "1");
		params.put("pageSize", "8");
		return params;
	}

	/**
	 * @function setConceptData 
	 * 
	 * @created_date : 04-Dec-2013
	 * 
	 * @description : This method will set the concept data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setConceptData(final ConceptDo conceptDo, Integer topicId) {
		setConceptDo(conceptDo);
		if(this.topicId==topicId) {
			if(conceptDo.getGooruOid()!=null) {
				collectionInfo.setVisible(true);
				resourcesInside.setVisible(true);
				noCollectionLbl.setVisible(false);
				
				try {
					collectionImage.setUrl(StringUtil.formThumbnailName(conceptDo.getThumbnails().getUrl(),"-160x120."));
					collectionImage.addErrorHandler(new ErrorHandler() {
						@Override
						public void onError(ErrorEvent event) {
							collectionImage.setUrl(DEFAULT_COLLECTION_IMAGE);
						}
					});
					if(imageHandler!=null) {
						imageHandler.removeHandler();
					}
					imageHandler=collectionImage.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							String page = AppClientFactory.getPlaceManager().getRequestParameter(PAGE,"landing");
							if(page.equals(COURSE_PAGE)) {
								MixpanelUtil.mixpanelEvent("CoursePage_Plays_Collection");
							} else {
								MixpanelUtil.mixpanelEvent("LandingPage_Plays_Collection");
							}
							Map<String, String> params = new HashMap<String, String>();
							params.put("id", conceptDo.getGooruOid());
							com.google.gwt.user.client.Window.scrollTo(0, 0);
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
						}
					});
				} catch (Exception e) {
					collectionImage.setUrl(DEFAULT_COLLECTION_IMAGE);
				}
				
				collectionTitleLbl.setHTML(conceptDo.getTitle());
				String description = conceptDo.getGoals();
				if(description!=null&&description.length()>=100) {
					description = description.substring(0,100)+"...";
				}
				collectionDescriptionLbl.setHTML(description);
				
				if(conceptDo.getMetaInfo().getStandards()!=null) {
					standardsFloPanel.clear();
					List<StandardFo> standardFoList = conceptDo.getMetaInfo().getStandards();
					List<Map<String, String>> standardMap = new ArrayList<Map<String, String>>();
					
					ResourceSearchResultDo searchResultDo = new ResourceSearchResultDo();
					for(int i=0;i<standardFoList.size();i++) {
						Map<String, String> standards = new HashMap<String, String>();
						standards.put(STANDARD_CODE, standardFoList.get(i).getCode());
						standards.put(STANDARD_DESCRIPTION, standardFoList.get(i).getDescription());
						standardMap.add(standards);
					}
					if(standardMap.size()<=0) {
						standardsFloPanel.setVisible(false);
					} else {
						standardsFloPanel.setVisible(true);
						searchResultDo.setStandards(standardMap);
						renderStandards(standardsFloPanel, searchResultDo);
					}
				}
				
				resourcesInside.clear();
				ArrayList<LibraryCollectionItemDo> libraryResources =  conceptDo.getCollectionItems();
				if(libraryResources!=null) {
					int resourceCount = libraryResources.size();
					int resources=resourceCount<=4?resourceCount:4;
					final Label resourceCountLbl = new Label(resources+" of the "+resourceCount+" resources in this collection");
					resourcesInside.add(resourceCountLbl);
					for(int i=0;i<resources;i++) {
						try {
							final LibraryCollectionItemDo libraryItem = libraryResources.get(i);
							final LibraryResourceDo libraryResourceDo = libraryItem.getResource();
							final String category = libraryResourceDo.getCategory()!=null?libraryResourceDo.getCategory():"";
							final HTMLEventPanel resourcePanel = new HTMLEventPanel("");
							resourcePanel.setStyleName(libraryStyle.resourceImage());
							
							final Image resourceImage = new Image();
							resourceImage.setWidth("80px");
							resourceImage.setHeight("60px");
							resourceImage.setAltText(libraryResourceDo.getTitle());
							resourceImage.setTitle(libraryResourceDo.getTitle());
							
							final String categoryImage=libraryResourceDo.getCategory();
							
							String sourceAttribution = "";
							if(libraryResourceDo.getResourceSource()!=null&&libraryResourceDo.getResourceSource().getAttribution()!=null) {
								sourceAttribution = libraryResourceDo.getResourceSource().getAttribution();
							}
							final String attribution = sourceAttribution;
							resourceImage.addMouseOverHandler(new MouseOverHandler() {
							   	
								@Override
								public void onMouseOver(MouseOverEvent event) {
									toolTipPopupPanel.clear();
									toolTipPopupPanel.setWidget(new DiscoverToolTip(libraryResourceDo.getTitle(),categoryImage,attribution));
									toolTipPopupPanel.setStyleName("");
									toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 55);
									toolTipPopupPanel.show();
								}
							});
							
							resourceImage.addMouseOutHandler(new MouseOutHandler() {
								
								@Override
								public void onMouseOut(MouseOutEvent event) {
								toolTipPopupPanel.hide();
								}
							});
							try {
								if(libraryResourceDo.getResourceType()!=null&&libraryResourceDo.getResourceType().getName().equalsIgnoreCase("video/youtube")) {
									String youTubeIbStr = ResourceImageUtil.getYoutubeVideoId(libraryResourceDo.getUrl());
									String thumbnailUrl = ResourceImageUtil.youtubeImageLink(youTubeIbStr);
									resourceImage.setUrl(thumbnailUrl);
								} else {
									resourceImage.setUrl(libraryResourceDo.getThumbnails().getUrl());
								}
								resourceImage.addErrorHandler(new ErrorHandler() {
									@Override
									public void onError(ErrorEvent event) {
										resourceImage.setUrl(DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG);
									}
								});
							} catch (Exception e){
								resourceImage.setUrl(DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG);
								resourceImage.setAltText(libraryResourceDo.getTitle());
								resourceImage.setTitle(libraryResourceDo.getTitle());
							}
							
							resourcePanel.addClickHandler(new ClickHandler() {
								@Override
								public void onClick(ClickEvent event) {
									String page = AppClientFactory.getPlaceManager().getRequestParameter(PAGE,"landing");
									if(page.equals(COURSE_PAGE)) {
										MixpanelUtil.mixpanelEvent("CoursePage_Plays_Resource");
									} else {
										MixpanelUtil.mixpanelEvent("LandingPage_Plays_Resource");
									}
									Map<String, String> params = new HashMap<String, String>();
									params.put("id", libraryResourceDo.getGooruOid());
								 	params.put("pn", "resource");
									AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
								}
							});
							
							final HTMLPanel resourceCategoryIcon = new HTMLPanel("");
							resourceCategoryIcon.addStyleName(UcCBundle.INSTANCE.css().resourceName());
							resourceCategoryIcon.addStyleName(category.toLowerCase() + SMALL);
							resourcePanel.add(resourceImage);
							resourcePanel.add(resourceCategoryIcon);
							resourcesInside.add(resourcePanel);
						} catch (Exception e){
							e.printStackTrace();
						}
					}
				}
			} else {
				collectionInfo.setVisible(false);
				resourcesInside.setVisible(false);
				noCollectionLbl.setVisible(true);
			}
		}
		loadingImage.setVisible(false);
		collectionViewer.setVisible(true);
	}
	
	OpenLessonConceptHandler openLessonConceptHandler = new OpenLessonConceptHandler() {
		@Override
		public void openLessonConcept(ConceptDo conceptDo, Integer topicId) {
			setConceptData(conceptDo, topicId);
		}
	};
	
	SetLoadingIconHandler setLoadingIconHandler = new SetLoadingIconHandler() {
		@Override
		public void setLoadingIcon(boolean isVisible, Integer topicIdCollection) {
			if(topicId==topicIdCollection) {
				collectionViewer.setVisible(!isVisible);
				loadingImage.setVisible(isVisible);
			}
		}
	};
	
	/**
	 * @function onassignCollectionBtnClicked 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description : This will handle the click event on the assign collection.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	@UiHandler("assignCollectionBtn")
	public void onassignCollectionBtnClicked(ClickEvent clickEvent) {
		String collectionId = getConceptDo().getGooruOid();
		MixpanelUtil.mixpanelEvent("LandingPage_Assign_Collection");

				if(!isAssignPopup){
					isAssignPopup=true;
				AssignPopupVc successPopupVc = new AssignPopupVc(collectionId) {
					
					@Override
					public void closePoup() {
						Window.enableScrolling(true);
				        this.hide();
				    	isAssignPopup=false;
					}
				};
				Window.scrollTo(0, 0);
				successPopupVc.setWidth("500px");
				successPopupVc.setHeight("auto");

				successPopupVc.show();
				successPopupVc.center();
				if (AppClientFactory.isAnonymous()){
				successPopupVc.setPopupPosition(successPopupVc.getAbsoluteLeft(), 20);
				}
				else
				{
				successPopupVc.setPopupPosition(successPopupVc.getAbsoluteLeft(), 20);
				}
			}
	}
	
	/**
	 * 
	 * @function oncustomizeCollectionBtnClicked 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description : This will handle the click event on the customize collection.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("customizeCollectionBtn")
	public void oncustomizeCollectionBtnClicked(ClickEvent clickEvent) {
		
		String collectionId = getConceptDo().getGooruOid();
		MixpanelUtil.mixpanelEvent("LandingPage_customize_collection");

				if(!isCustomizePopup){
					isCustomizePopup=true;
				Boolean loginFlag = false;
				if (AppClientFactory.isAnonymous()){
					loginFlag = true;
				}
				else
				{
					loginFlag = false;
				}
				LoginCustomizePopUp successPopupVc = new LoginCustomizePopUp(collectionId, loginFlag) {

					@Override
					public void closePoup() {
						Window.enableScrolling(true);
						this.hide();	
						isCustomizePopup = false;
					}
				};
				Window.scrollTo(0, 0);
				successPopupVc.setWidth("500px");
				successPopupVc.setHeight("320px");
				successPopupVc.show();
				successPopupVc.center();
			}
		
	}	
	/**
	 * @function renderStandards 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to render the standards.
	 * 
	 * @parm(s) : @param standardsContainer
	 * @parm(s) : @param searchResultDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void renderStandards(FlowPanel standardsContainer, ResourceSearchResultDo searchResultDo) {
		if (searchResultDo.getStandards() != null) {
			List<Map<String, String>> standards = searchResultDo.getStandards();
			Iterator<Map<String, String>> iterator = standards.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 0) {
					if (count < 18){
						StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
						toolTipwidgets.add(standardItem);
					}
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standards);
					toolTipUc.setStyleName(UcCBundle.INSTANCE.css().searchStandard());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (standards.size()>18){
				final Label left = new Label("+"+(standards.size() - 18));
				toolTipwidgets.add(left);
			}
			if (searchResultDo.getStandards().size() > 1) {
				Integer moreStandardsCount = searchResultDo.getStandards().size() - 1;
				DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standards);
				toolTipUc.setStyleName(libraryStyle.blueLink());
				standardsContainer.add(toolTipUc);
			}
		}
	}
}
