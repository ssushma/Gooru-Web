package org.ednovo.gooru.client.mvp.library.sausd;

import java.util.ArrayList;
import java.util.Iterator;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView;
import org.ednovo.gooru.client.mvp.library.sausd.metadata.LibraryMetaDataContentUc;
import org.ednovo.gooru.client.mvp.profilepage.data.item.ProfileTopicListView;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
` * 
 */
public class SausdView extends BaseViewWithHandlers<SausdUiHandlers> implements IsSausdView, MessageProperties {

	@UiField
	static HTMLPanel courseTabs;

	@UiField HTMLPanel landingBanner, container, featuredCourseTabs, leftNav, contentScroll, libraryMetaDataContainer, contributorsContainer, courseBanner, featuredEducator,
	featuredCourses, scrollPanel, loadingIconPanel,partnerLogo;

	@UiField Label courseTitle, featuredCousesLbl,featuredContributor;
	
	@UiField Anchor featuredContributorsLink;
	
	@UiField SausdStyleBundle sausdStyleUc;
	
	@UiField Image courseImage, educatorPhoto;
	
	private String placeToken;
	
	SausdMenuNav sausdMenuNav = null;
	
	private static final String FEATURED_COURSE="featured-course",COURSE_PAGE = "course-page", COURSE_ID = "courseId", FEATURED_LABEL = "featured", 
			CALLBACK = "callback", ACTIVE_STYLE = "active",LIBRARY_PAGE = "page";

	private String unitListId = "";

	private final static String COURSE_DEFAULT_IMG = "../images/library/course-1000x300.png";

	private static SausdViewUiBinder uiBinder = GWT.create(SausdViewUiBinder.class);

	interface SausdViewUiBinder extends UiBinder<Widget, SausdView> {
	}
	
	public SausdView() {		
		setWidget(uiBinder.createAndBindUi(this));
		setAssets();
	}
	
	@Override
	public void onLoad() {
		courseTabs.getElement().setId("courseTabs");
		container.getElement().setId("container");
		featuredCourseTabs.getElement().setId("featuredCourseTabs");
		leftNav.getElement().setId("leftNav");
		contentScroll.getElement().setId("contentScroll");
		courseBanner.getElement().setId("courseBanner");
		featuredEducator.getElement().setId("featuredEducator");
		
		if(getPlaceToken().equalsIgnoreCase(PlaceTokens.SAUSD_LIBRARY)) {
			landingBanner.getElement().setId("landingSausdBanner");
			featuredCousesLbl.setText(GL1901);
		}
	}
	
	@Override
	public void loadFeaturedContributors(String callBack, String placeToken,ProfileLibraryListDo profileLibraryListDo) {
		if(callBack.equalsIgnoreCase(FEATURED_COURSE)) {
			sausdMenuNav.setSubjectPanelIds(profileLibraryListDo);
			showCourseBanner(null, false);
			setFeaturedCourseWidgets(profileLibraryListDo.getSearchResult(),false);
		}
	}
	
	private void setFeaturedCourseWidgets(ArrayList<ProfileLibraryDo> profileLibDoList, boolean isFeaturedCourseSelected) {
		featuredCourses.clear();
		leftNav.clear();
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(COURSE_ID);
		
		final ArrayList<ProfileLibraryDo> courseList = profileLibDoList.get(0).getCollectionItems();
		
		for(int i = 0; i<courseList.size(); i++) {
			featuredCourses.add(new SausdFeaturedView(courseList.get(i)));
			if(!isFeaturedCourseSelected) {
				if(i==0&&(courseId==null)) {
					featuredCourses.getWidget(i).addStyleName(ACTIVE_STYLE);
					setUnitList(courseList.get(i).getCollectionItems());
				}
			} else if(isFeaturedCourseSelected&&courseId==null) {
				if(i==0) {
					featuredCourses.getWidget(i).addStyleName(ACTIVE_STYLE);
					
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
			SausdFeaturedView sausdFeaturedView = ((SausdFeaturedView) widget);
			try {
				if(courseId.equals(sausdFeaturedView.getCourseId())) {
					widget.addStyleName(ACTIVE_STYLE);
				}
			} catch (Exception e) {}
			sausdFeaturedView.getfeaturedCoursePanel().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					leftNav.clear();
					MixpanelUtil.mixpanelEvent("FeaturedCourse_SelectsCourse");
					final Iterator<Widget> widgetsPanel = featuredCourses.iterator();
					while (widgetsPanel.hasNext()) {
						widgetsPanel.next().removeStyleName(ACTIVE_STYLE);
					}
					widget.addStyleName(ACTIVE_STYLE);
					setUnitList(courseList.get(widgetCountTemp).getCollectionItems());
				}
			});
			widgetCount++;
		}
	}
	
	public void setUnitList(final ArrayList<ProfileLibraryDo> profileLibraryDoList) {
		int firstWidgetCount = leftNav.getWidgetCount();
		for(int i = 0; i<profileLibraryDoList.size(); i++) {
			LibraryUnitMenuView libraryUnitMenuView = new LibraryUnitMenuView(profileLibraryDoList.get(i));
			leftNav.add(libraryUnitMenuView);
			libraryUnitMenuView.setWidgetCount(leftNav.getWidgetCount()+1);
			libraryUnitMenuView.setType(profileLibraryDoList.get(i).getType());
			if(firstWidgetCount==0) {
				firstWidgetCount++;
				loadingPanel(true);
				libraryUnitMenuView.addStyleName(sausdStyleUc.unitLiActive());
				unitListId = profileLibraryDoList.get(i).getGooruOid();
				if(profileLibraryDoList.get(i).getType().equals("scollection")) {
					setTopicListData(profileLibraryDoList.get(i), unitListId);
				} else {
					setTopicListData(profileLibraryDoList.get(i).getCollectionItems(), unitListId, profileLibraryDoList.get(i));
				}
			}
		}
		
		final Iterator<Widget> widgets = leftNav.iterator();
		int widgetCount = 0;
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			final LibraryUnitMenuView libraryUnitMenuView = ((LibraryUnitMenuView) widget);
			final int widgetCountTemp = widgetCount;
			libraryUnitMenuView.getUnitMenuItemPanel().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(libraryUnitMenuView.getWidgetCount()>10) {
						Window.scrollTo(0, 0);
					}
					loadingPanel(true);
					final Iterator<Widget> widgetsPanel = leftNav.iterator();
					while (widgetsPanel.hasNext()) {
						final Widget widgetTxt = widgetsPanel.next();
						widgetTxt.removeStyleName(sausdStyleUc.unitLiActive());
					}
					widget.addStyleName(sausdStyleUc.unitLiActive());
					unitListId = libraryUnitMenuView.getUnitId();
					if(libraryUnitMenuView.getType().equals("scollection")) {
						setTopicListData(profileLibraryDoList.get(widgetCountTemp),  unitListId);
					} else {
						if(widgetCountTemp==0) {
							setTopicListData(profileLibraryDoList.get(widgetCountTemp).getCollectionItems(), unitListId, profileLibraryDoList.get(widgetCountTemp));
						} else {
							getUnitTopics(unitListId, profileLibraryDoList.get(widgetCountTemp));
						}
					}
				}
			});
			widgetCount++;
		}
	}
	
	private void getUnitTopics(final String unitListId, final ProfileLibraryDo profileLibraryDo) {
		AppClientFactory.getInjector().getLibraryService().getLibraryPaginationWorkspace(unitListId, "public", 14, new AsyncCallback<ProfileLibraryListDo>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ProfileLibraryListDo profileLibraryListDo) {
				setTopicListData(profileLibraryListDo.getSearchResult(), unitListId, profileLibraryDo);
			}
		});
	}

	public void setTopicListData(ProfileLibraryDo profileLibraryDo, String folderId) {
		contentScroll.clear();
		try {
			setMetaDataContent(profileLibraryDo);
			contentScroll.add(new ProfileTopicListView(profileLibraryDo, 0, AppClientFactory.getCurrentPlaceToken(), "scollection"));
			loadingPanel(false);
		} catch (Exception e) {
			e.printStackTrace();
			loadingPanel(false);
		}
	}

	public void setTopicListData(ArrayList<ProfileLibraryDo> folderListDo, String folderId, ProfileLibraryDo profileLibraryDo) {
		contentScroll.clear();
		try {
			int count = 0;
			setMetaDataContent(profileLibraryDo);
			if(folderListDo.size()>0) {
				for(int i = 0; i <1; i++) {
					count++;
					if(folderListDo.get(i).getType().equals("scollection")) {
						contentScroll.add(new ProfileTopicListView(folderListDo.get(i), count, AppClientFactory.getCurrentPlaceToken(), "scollection"));
					} else {
						contentScroll.add(new ProfileTopicListView(profileLibraryDo, count, AppClientFactory.getCurrentPlaceToken()));
					}
				}
			} else {
				HTMLPanel emptyContainer = new HTMLPanel("");
				contentScroll.add(emptyContainer);
			}
			loadingPanel(false);
		} catch (Exception e) {
			e.printStackTrace();
			loadingPanel(false);
		}
	}
	
	public void loadingPanel(boolean isVisible) {
		loadingIconPanel.setVisible(isVisible);
		contentScroll.setVisible(!isVisible);
		libraryMetaDataContainer.setVisible(!isVisible);
	}

	public String getPlaceToken() {
		return placeToken;
	}

	private void setPlaceToken(String placeToken) {
		this.placeToken = placeToken;
	}

	private void setMetaDataContent(ProfileLibraryDo profileLibraryDo) {
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SAUSD_LIBRARY)) {
			libraryMetaDataContainer.clear();
			libraryMetaDataContainer.add(new LibraryMetaDataContentUc(profileLibraryDo));
		}
	}
	
	public void setAssets() {
		setPlaceToken(PlaceTokens.SAUSD_LIBRARY);
		if(getPlaceToken().equalsIgnoreCase(PlaceTokens.SAUSD_LIBRARY)) {
			partnerLogo.setStyleName(sausdStyleUc.sausdPartnerLogo());
			partnerLogo.setVisible(true);
			partnerLogo.getElement().getStyle().setRight(10, Unit.PX);
		} else {
			partnerLogo.setVisible(false);
		}

		contributorsContainer.setVisible(false);
		courseBanner.setVisible(false);
		featuredEducator.setVisible(false);
		sausdMenuNav = new SausdMenuNav(getPlaceToken()) {
			@Override
			public void clickOnCourse(ArrayList<ProfileLibraryDo> unitList, String courseId, ProfileLibraryDo profileLibraryDo) {
				showCourseBanner(profileLibraryDo, true);
				setSubjectUnits(profileLibraryDo);
			}
		};
		courseTabs.add(sausdMenuNav);
		landingBanner.add(new SausdBannerView(getPlaceToken()));
		featuredContributorsLink.setText(GL1005);
		featuredContributorsLink.setTitle(GL0680);
		courseImage.setWidth("1000px");
		courseImage.setHeight("300px");
	}
	
	private void setSubjectUnits(ProfileLibraryDo profileLibraryDo) {
		leftNav.clear();
		setUnitList(profileLibraryDo.getCollectionItems());
	}
	
	private void showCourseBanner(ProfileLibraryDo profileLibraryDo, boolean isCoursePageVisible) {
		landingBanner.setVisible(!isCoursePageVisible);
		featuredCourseTabs.setVisible(!isCoursePageVisible);
		featuredCousesLbl.setVisible(!isCoursePageVisible);
		courseBanner.setVisible(isCoursePageVisible);
		if(isCoursePageVisible) {
			courseImage.setUrl(profileLibraryDo.getThumbnails().getUrl());
			courseImage.addErrorHandler(new ErrorHandler() {
				@Override
				public void onError(ErrorEvent event) {
					courseImage.setUrl(COURSE_DEFAULT_IMG);
				}
			});
			courseTitle.setText(profileLibraryDo.getTitle());
		}
	}
}