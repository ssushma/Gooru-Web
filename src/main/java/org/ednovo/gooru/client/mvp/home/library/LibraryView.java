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
 * @fileName : LibraryView.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 02-Dec-2013
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
import org.ednovo.gooru.client.mvp.home.event.SetDiscoverLinkEvent;
import org.ednovo.gooru.client.mvp.home.library.contributors.LibraryContributorsView;
import org.ednovo.gooru.client.mvp.home.library.events.OpenSubjectCourseEvent;
import org.ednovo.gooru.client.mvp.home.library.events.OpenSubjectCourseHandler;
import org.ednovo.gooru.client.mvp.home.library.events.SetSubjectDoEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetSubjectDoHandler;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.SubjectDo;
import org.ednovo.gooru.shared.model.library.TopicDo;
import org.ednovo.gooru.shared.model.library.UnitDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.seanchenxi.gwt.storage.client.StorageExt;
import com.seanchenxi.gwt.storage.client.StorageKey;
import com.seanchenxi.gwt.storage.client.StorageKeyFactory;
/**
 * @fileName : LibraryView.java
 *
 * @description : This is the library view.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryView extends Composite {

	@UiField HTMLPanel courseTabs,landingBanner,container,featuredCourseTabs,leftNav,contentScroll,contributorsContainer,courseBanner,featuredEducator,featuredCourses;

	@UiField Label courseTitle, featuredCousesLbl,featuredContributor;
	
	@UiField Anchor featuredContributorsLink;
	
	@UiField LibraryStyleBundle libraryStyleUc;

	@UiField HTMLPanel scrollPanel, loadingIconPanel;
	
	@UiField Image courseImage, educatorPhoto;
	
	ArrayList<CourseDo> courseDo = new ArrayList<CourseDo>();
	
	HashMap<String, SubjectDo> courseMap = new HashMap<String, SubjectDo>();
	
	CourseDo subjectCourseDo = new CourseDo();
	
	private static final String COURSE_PAGE = "course-page";
	private static final String FEATURED_CONTRIBUTORS = "featured-contributors";
	private static final String FEATURED_COURSE_PAGE = "featured-course";
	private static final String LIBRARY_PAGE = "page";
	private static final String COURSE_ID = "courseId";
	private static final String UNIT_ID = "unitId";
	private static final String SUBJECT_NAME = "subject";
	private static final String FEATURED_LABEL = "featured";
	private static final String ACTIVE_STYLE = "active";
	private static final String CALLBACK = "callback";
	
	private String defaultCourseId = "";
	private String previousCallBack = "";
	private String previousCourseId = "";
	private boolean isUnitLoaded = false;
	
	private final static String COURSE_DEFAULT_IMG = "../images/library/course-1000x300.png";
	
	private static final String EDUCATOR_DEFAULT_IMG = "../images/settings/setting-user-image.png";
	
	private static final String PNG = ".png";
	
	private final static String MR = "Mr. ";
	
	private final static String MS = "Ms. ";

	private final static String FEMALE = "female";

	private final static String MALE = "male";

    StorageExt localStorage = StorageExt.getLocalStorage();

    StorageKey<HashMap<String, SubjectDo>> libraryStorageObject = StorageKeyFactory.objectKey("libraryStorageObject");
	
    LibraryMenuNav libraryMenuNavigation = new LibraryMenuNav();
    
	private static LibraryViewUiBinder uiBinder = GWT.create(LibraryViewUiBinder.class);

	interface LibraryViewUiBinder extends UiBinder<Widget, LibraryView> {
	}
	/**
	 * Class constructor.
	 */
	public LibraryView() {
		initWidget(uiBinder.createAndBindUi(this));
		setDebugId();
		AppClientFactory.getEventBus().addHandler(OpenSubjectCourseEvent.TYPE, openSubjectCourseHandler);
		AppClientFactory.getEventBus().addHandler(SetSubjectDoEvent.TYPE, setSubjectDoHandler);
		loadingIconPanel.setVisible(false);
		courseImage.setWidth("1000px");
		courseImage.setHeight("300px");
	}
	
	/**
	 * 
	 * @function setDebugId 
	 * 
	 * @created_date : 02-Dec-2013
	 * 
	 * @description : This method is used to set the debug id.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setDebugId() {
		contributorsContainer.setVisible(false);
		courseBanner.setVisible(false);
		featuredEducator.setVisible(false);
		
		courseTabs.add(libraryMenuNavigation);
		landingBanner.add(new LibraryBannerView());
		
		featuredContributorsLink.setTitle("Featured Contributors");
		featuredContributorsLink.setHref("#discover&page=featured-contributors");
	}
	/**
	 * This method will set the id's while loading.
	 */
	@Override
	public void onLoad() {
		courseTabs.getElement().setId("courseTabs");
		landingBanner.getElement().setId("landingBanner");
		container.getElement().setId("container");
		featuredCourseTabs.getElement().setId("featuredCourseTabs");
		leftNav.getElement().setId("leftNav");
		contentScroll.getElement().setId("contentScroll");
		courseBanner.getElement().setId("courseBanner");
		featuredEducator.getElement().setId("featuredEducator");
	}
	
	/**
	 * @function setLibraryTopicListData 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description : This method is used to set the library topic list.
	 * 
	 * @parm(s) : @param topicDoList
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public void setLibraryTopicListData(final ArrayList<TopicDo> topicDoList) {
		contentScroll.clear();
		try {
			for(int i = 0; i <topicDoList.size(); i++) {
				contentScroll.add(new LibraryTopicListView(topicDoList.get(i), (i+1)));
			}
			contentScroll.setVisible(true);
			loadingIconPanel.setVisible(false);
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 
	 * @function loadContributorsPage 
	 * 
	 * @created_date : 03-Dec-2013
	 * 
	 * @description : This method is used to load contribution pages.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void loadContributorsPage(String callBack) {
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(COURSE_ID);
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UNIT_ID);
		String callBackSignup = AppClientFactory.getPlaceManager().getRequestParameter(CALLBACK,null);
		String discoverUrl = Window.Location.getHref();
		Window.enableScrolling(true);
		if(callBack.equalsIgnoreCase(FEATURED_CONTRIBUTORS)){
			discoverUrl.replaceAll("&page=featured-contributors", "");
			AppClientFactory.fireEvent(new SetDiscoverLinkEvent(discoverUrl));
			featuredCourseTabs.setVisible(false);
			featuredCousesLbl.setVisible(false);
			landingBanner.setVisible(false);
			container.setVisible(false);
			contributorsContainer.setVisible(true);
			if(contributorsContainer.getWidgetCount()<=0) {
				contributorsContainer.add(new LibraryContributorsView());
			}
			libraryMenuNavigation.setTabSelection(FEATURED_CONTRIBUTORS);
		} else if(callBack.equalsIgnoreCase(COURSE_PAGE)){
			AppClientFactory.fireEvent(new SetDiscoverLinkEvent(discoverUrl));
			landingBanner.setVisible(false);
			contributorsContainer.setVisible(false);
			featuredCourseTabs.setVisible(false);
			featuredCousesLbl.setVisible(false);
			featuredEducator.setVisible(true);
			courseBanner.setVisible(true);
			container.setVisible(true);
			
			Window.scrollTo(0, 0);
			
			String subjectId = AppClientFactory.getPlaceManager().getRequestParameter(SUBJECT_NAME);
			String subjectName = getSubjectNameBySubjectId(courseMap, subjectId);
			CourseDo courseDo = null;
			if(subjectName!=null&&courseMap.get(subjectName)!=null&&courseMap.get(subjectName).getData()!=null) {
				libraryMenuNavigation.setTabSelection(subjectName);
				courseDo = getCourseDoFromCourseId(courseMap.get(subjectName), courseId);
				setCourseData(courseDo);
			} else {
				libraryMenuNavigation.getTaxonomyData(subjectId,courseId);
			}
		} else if(callBack.equalsIgnoreCase(FEATURED_COURSE_PAGE)){
			libraryMenuNavigation.setTabSelection(FEATURED_LABEL);
			if(callBackSignup!=null) {
				Window.enableScrolling(false);
			}
			AppClientFactory.fireEvent(new SetDiscoverLinkEvent(discoverUrl));
			contributorsContainer.setVisible(false);
			featuredEducator.setVisible(false);
			courseBanner.setVisible(false);
			landingBanner.setVisible(true);
			container.setVisible(true);
			featuredCourseTabs.setVisible(true);
			featuredCousesLbl.setVisible(true);
			if((callBack!=previousCallBack)||(courseId!=previousCourseId)) {
				if(courseMap!=null&&courseMap.get("featured")!=null) {
					setFeaturedCourseWidgets(courseMap.get("featured").getData(), true);
				} else {
					getFeaturedCourses(FEATURED_LABEL);
				}
			}
		}
		this.previousCallBack = callBack;
		this.previousCourseId = courseId;
	}
	
	/**
	 * 
	 * @function setFeaturedCourses 
	 * 
	 * @created_date : 04-Dec-2013
	 * 
	 * @description : This method is used to get featured courses.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public void getFeaturedCourses(final String featuredLabel) {
		try {
			if(Cookies.getCookie("featured-gooru-release")!=null&&!Cookies.getCookie("featured-gooru-release").contains("5.11")) {
				if(localStorage!=null&&localStorage.get(libraryStorageObject)!=null&&localStorage.get(libraryStorageObject).get(featuredLabel)!=null){
					localStorage.get(libraryStorageObject).remove(featuredLabel);
				}
			}
			HashMap<String, SubjectDo> savedValuesMap = localStorage.get(libraryStorageObject);
			if(savedValuesMap!=null&&savedValuesMap.get(featuredLabel)!=null) {
				setFeaturedCourseWidgets(savedValuesMap.get(featuredLabel).getData(), false);
			} else {
				AppClientFactory.getInjector().getLibraryService().getSubjects(featuredLabel, new AsyncCallback<HashMap<String, SubjectDo>>() {

					@Override
					public void onFailure(Throwable caught) {
						
					}

					@Override
					public void onSuccess(HashMap<String, SubjectDo> subjectDoList) {
						courseMap = subjectDoList;
						libraryMenuNavigation.setSubjectPanelIds(courseMap);
						setFeaturedCourseWidgets(subjectDoList.get(featuredLabel).getData(), false);
					}
				});
			}
		} catch (SerializationException e) {
			e.printStackTrace(); 
		}
	}
		
	/**
	 * @function setFeaturedCourseWidgets 
	 * 
	 * @created_date : 14-Dec-2013
	 * 
	 * @description : This method is used to set featured courses widgets.
	 * 
	 * @parm(s) : @param courseDoList
	 * @parm(s) : @param isFeaturedCourseSelected
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setFeaturedCourseWidgets(final ArrayList<CourseDo> courseDoList, boolean isFeaturedCourseSelected) {
		featuredCourses.clear();
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(COURSE_ID);
		for(int i = 0; i<courseDoList.size(); i++) {
			featuredCourses.add(new FeaturedCourseListView(courseDoList.get(i)));
			if(!isFeaturedCourseSelected) {
				if(i==0&&(courseId==null)) {
					featuredCourses.getWidget(i).addStyleName(ACTIVE_STYLE);
					defaultCourseId = ""+courseDoList.get(i).getCodeId();
					setUnitListData(courseDoList.get(i).getUnit());
				}
			} else if(isFeaturedCourseSelected&&courseId==null) {
				if(i==0) {
					featuredCourses.getWidget(i).addStyleName(ACTIVE_STYLE);
					setUnitListData(courseDoList.get(i).getUnit());
				} else {
					featuredCourses.getWidget(i).removeStyleName(ACTIVE_STYLE);
				}
			}
		}
		
		final Iterator<Widget> widgets = featuredCourses.iterator();
		int widgetCount = 0;
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			final int widgetCountTemp = widgetCount;
			FeaturedCourseListView featuredCourseListView = ((FeaturedCourseListView) widget);
			try {
				if(courseId.equals(""+featuredCourseListView.getCourseId())) {
					setUnitListData(courseDoList.get(widgetCount).getUnit());
					widget.addStyleName(ACTIVE_STYLE);
				}
			} catch (Exception e) {}
			featuredCourseListView.getfeaturedCoursePanel().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					MixpanelUtil.mixpanelEvent("FeaturedCourse_SelectsCourse");
					final Iterator<Widget> widgetsPanel = featuredCourses.iterator();
					while (widgetsPanel.hasNext()) {
						widgetsPanel.next().removeStyleName(ACTIVE_STYLE);
					}
					widget.addStyleName(ACTIVE_STYLE);
					setUnitListData(courseDoList.get(widgetCountTemp).getUnit());
					Map<String,String> params = new HashMap<String, String>();
					params.put(LIBRARY_PAGE, FEATURED_COURSE_PAGE);
					params.put(COURSE_ID, ""+((FeaturedCourseListView) widget).getCourseId());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
				}
			});
			widgetCount++;
		}
	}

	/**
	 * @param unitDoList 
	 * @function setUnitListData 
	 * 
	 * @created_date : 04-Dec-2013
	 * 
	 * @description : This method is used to set unit list.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setUnitListData(final List<UnitDo> unitDoList) {
		String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UNIT_ID);
		final String subjectId = AppClientFactory.getPlaceManager().getRequestParameter(SUBJECT_NAME, FEATURED_LABEL);
		leftNav.clear();
		for(int i = 0; i<unitDoList.size(); i++) {
			leftNav.add(new LibraryUnitMenuView(unitDoList.get(i)));
			if(i==0&&(unitId==null)) {
				leftNav.getWidget(i).addStyleName(libraryStyleUc.unitLiActive());
				setLibraryTopicListData(unitDoList.get(i).getTopic());
			}
		}
		
		int widgetCount = 0;
		final Iterator<Widget> widgets = leftNav.iterator();
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			final int widgetCountTemp = widgetCount;
			final LibraryUnitMenuView libraryUnitMenuView = ((LibraryUnitMenuView) widget);
			try {
				if(unitId.equals(libraryUnitMenuView.getUnitId())) {
					widget.addStyleName(libraryStyleUc.unitLiActive());
					if(widgetCountTemp==0) {
						setLibraryTopicListData(unitDoList.get(widgetCountTemp).getTopic());
					} else {
						contentScroll.setVisible(false);
						loadingIconPanel.setVisible(true);
						getTopicsOnPagination(subjectId, libraryUnitMenuView.getUnitId());
					}
				}
			} catch(Exception e) {}
			
			libraryUnitMenuView.getUnitMenuItemPanel().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					final Iterator<Widget> widgetsPanel = leftNav.iterator();
					while (widgetsPanel.hasNext()) {
						widgetsPanel.next().removeStyleName(libraryStyleUc.unitLiActive());
					}
					widget.addStyleName(libraryStyleUc.unitLiActive());
					
					String callBack = AppClientFactory.getPlaceManager().getRequestParameter(LIBRARY_PAGE,FEATURED_COURSE_PAGE);
					String courseId = AppClientFactory.getPlaceManager().getRequestParameter(COURSE_ID,null);
					if(widgetCountTemp==0) {
						setLibraryTopicListData(unitDoList.get(widgetCountTemp).getTopic());
					} else {
						contentScroll.setVisible(false);
						loadingIconPanel.setVisible(true);
						getTopicsOnPagination(subjectId, libraryUnitMenuView.getUnitId());
					}
					Map<String,String> params = new HashMap<String, String>();
					params.put(LIBRARY_PAGE, callBack);
					if(courseId!=null) {
						params.put(COURSE_ID, courseId);
					} else {
						params.put(COURSE_ID, defaultCourseId);
					}
					if(subjectId!=null) {
						params.put(SUBJECT_NAME, subjectId);
					}
					params.put(UNIT_ID, ((LibraryUnitMenuView) widget).getUnitId());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME,params);
				}
			});
			widgetCount++;
		}
	}
	
	/**
	 * 
	 * @function getTopicsOnPagination 
	 * 
	 * @created_date : 18-Dec-2013
	 * 
	 * @description : This method is used to get topics while navigating.
	 * 
	 * @parm(s) : @param unitId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void getTopicsOnPagination(String subjectId, String unitId) {
		AppClientFactory.getInjector().getLibraryService().getTopicsOnPagination(subjectId, unitId, new AsyncCallback<ArrayList<TopicDo>>() {			
			@Override
			public void onSuccess(ArrayList<TopicDo> topicDoList) {
				setLibraryTopicListData(topicDoList);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	OpenSubjectCourseHandler openSubjectCourseHandler = new OpenSubjectCourseHandler() {
		@Override
		public void openSubjectCourse(String subjectName, CourseDo courseDo) {
			setCourseData(courseDo);
		}
	};

	SetSubjectDoHandler setSubjectDoHandler = new SetSubjectDoHandler() {
		@Override
		public void setSubjectDo(String subjectCode, SubjectDo subjectDo) {
			courseMap.put(subjectCode, subjectDo);
		}
	};
	
	/**
	 * 
	 * @param courseDo2 
	 * @function setCourseData 
	 * 
	 * @created_date : 09-Dec-2013
	 * 
	 * @description :This method is used to set course data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setCourseData(CourseDo courseDo) {
			educatorPhoto.setVisible(true);
			featuredContributor.setVisible(true);
			if(courseDo!=null) {
				courseImage.setUrl(courseDo.getThumbnails().getUrl());
				courseImage.addErrorHandler(new ErrorHandler() {
					@Override
					public void onError(ErrorEvent event) {
						courseImage.setUrl(COURSE_DEFAULT_IMG);
					}
				});
				
				courseTitle.setText(courseDo.getLabel());
				try {
					educatorPhoto.setHeight("46px");
					educatorPhoto.setWidth("46px");
					
					String authorName = "";
					if(courseDo.getCreator().getGender().equalsIgnoreCase(MALE)) {
						authorName = MR+courseDo.getCreator().getLastName();
					} else if(courseDo.getCreator().getGender().equalsIgnoreCase(FEMALE)) {
						authorName = MS+courseDo.getCreator().getLastName();
					} else {
						authorName = courseDo.getCreator().getLastName();
					}
					
					featuredContributor.setText(authorName+" "+" is the featured contributor for "+courseDo.getLabel()+". ");
					educatorPhoto.setUrl(AppClientFactory.getLoggedInUser().getSettings().getProfileImageUrl() + courseDo.getCreator().getGooruUId()+PNG);
					educatorPhoto.addErrorHandler(new ErrorHandler() {
						@Override
						public void onError(ErrorEvent event) {
							educatorPhoto.setUrl(EDUCATOR_DEFAULT_IMG);
						}
					});
				} catch (Exception e) {
					educatorPhoto.setVisible(false);
					featuredContributor.setVisible(false);
				}
			}
			
			String libraryPage = AppClientFactory.getPlaceManager().getRequestParameter(LIBRARY_PAGE,"emptyPage");
			if(!isUnitLoaded&&libraryPage.equals(COURSE_PAGE)) {
				setUnitListData(courseDo.getUnit());
				isUnitLoaded=true;
			}
			if(courseDo.getUnit()!=null) {
				setUnitListData(courseDo.getUnit());
			}
	}
	
	/**
	 * 
	 * @function getSubjectNameBySubjectId 
	 * 
	 * @created_date : 12-Dec-2013
	 * 
	 * @description : This method is used to get subject names based on the sunbject id.
	 * 
	 * @parm(s) : @param subjectList
	 * @parm(s) : @param subjectId
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getSubjectNameBySubjectId(HashMap<String, SubjectDo> subjectList, String subjectId) {
		for (Map.Entry<String, SubjectDo> entry : subjectList.entrySet()) {
			if(entry.getValue().getCode().equals(subjectId)) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/**
	 * @function getCourseDoFromCourseId 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description : This method is used to get the course data based on the course id.
	 * 
	 * @parm(s) : @param subjectDo
	 * @parm(s) : @param courseId
	 * @parm(s) : @return
	 * 
	 * @return : CourseDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CourseDo getCourseDoFromCourseId(SubjectDo subjectDo, String courseId) {
		final Iterator<CourseDo> courses = subjectDo.getData().iterator();
		while (courses.hasNext()) {
			final CourseDo courseDo = courses.next();
			String course = ""+courseDo.getCodeId();
			if(course.equals(courseId)) {
				return courseDo;
			}
		}
		return new CourseDo();
	}
	
}
