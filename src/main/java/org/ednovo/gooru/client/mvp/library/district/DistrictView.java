package org.ednovo.gooru.client.mvp.library.district;

import java.util.ArrayList;
import java.util.Iterator;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView;
import org.ednovo.gooru.client.mvp.library.district.metadata.LibraryMetaDataContentUc;
import org.ednovo.gooru.client.mvp.profilepage.data.item.ProfileTopicListView;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
` * 
 */
public class DistrictView extends BaseViewWithHandlers<DistrictUiHandlers> implements IsDistrictView {

	@UiField HTMLPanel courseTabs;

	@UiField HTMLPanel landingBanner, container, featuredCourseTabs, leftNav, contentScroll, libraryMetaDataContainer, contributorsContainer, courseBanner, featuredEducator,
	featuredCourses, scrollPanel, loadingIconPanel,partnerLogo;

	@UiField Label courseTitle, featuredCousesLbl,featuredContributor;
	
	@UiField Anchor featuredContributorsLink;
	
	@UiField DistrictStyleBundle districtStyleUc;
	
	@UiField Image courseImage, educatorPhoto;
	
	private String placeToken;
	
	DistrictMenuNav districtMenuNav = null;
	
	private static final String FEATURED_COURSE="featured-course",COURSE_PAGE = "course-page", COURSE_ID = "courseId", FEATURED_LABEL = "featured", 
			CALLBACK = "callback", ACTIVE_STYLE = "active",LIBRARY_PAGE = "page";

	private String unitListId = "";

	private final static String COURSE_DEFAULT_IMG = "../images/library/course-1000x300.png";

	private static DistrictViewUiBinder uiBinder = GWT.create(DistrictViewUiBinder.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	interface DistrictViewUiBinder extends UiBinder<Widget, DistrictView> {
	}
	
	public DistrictView() {		
		setWidget(uiBinder.createAndBindUi(this));
		setAssets(AppClientFactory.getCurrentPlaceToken());
	}
	
	@Override
	public void onLoad() {
	}
	
	@Override
	public void loadFeaturedContributors(String callBack, String placeToken,ProfileLibraryListDo profileLibraryListDo) {
		if(callBack.equalsIgnoreCase(FEATURED_COURSE)) {
			districtMenuNav.setSubjectPanelIds(profileLibraryListDo);
			showCourseBanner(null, false);
			if(profileLibraryListDo.getSearchResult()!=null&&profileLibraryListDo.getSearchResult().size()>0) {
				setFeaturedCourseWidgets(profileLibraryListDo.getSearchResult(),false);
			}
		}
	}
	
	private void setFeaturedCourseWidgets(ArrayList<ProfileLibraryDo> profileLibDoList, boolean isFeaturedCourseSelected) {
		featuredCourses.clear();
		leftNav.clear();
		String courseId = AppClientFactory.getPlaceManager().getRequestParameter(COURSE_ID);
		
		final ArrayList<ProfileLibraryDo> courseList = profileLibDoList.get(0).getCollectionItems();
		
		for(int i = 0; i<courseList.size(); i++) {
			featuredCourses.add(new DistrictFeaturedView(courseList.get(i)));
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
			DistrictFeaturedView districtFeaturedView = ((DistrictFeaturedView) widget);
			try {
				if(courseId.equals(districtFeaturedView.getCourseId())) {
					widget.addStyleName(ACTIVE_STYLE);
				}
			} catch (Exception e) {}
			districtFeaturedView.getfeaturedCoursePanel().addClickHandler(new ClickHandler() {
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
				libraryUnitMenuView.addStyleName(districtStyleUc.unitLiActive());
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
						widgetTxt.removeStyleName(districtStyleUc.unitLiActive());
					}
					widget.addStyleName(districtStyleUc.unitLiActive());
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
		AppClientFactory.getInjector().getLibraryService().getLibraryPaginationWorkspace(unitListId, "public", 14, new SimpleAsyncCallback<ProfileLibraryListDo>() {

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
				for(int i = 0; i <folderListDo.size(); i++) {
					count++;
					if(folderListDo.get(i).getType().equals("scollection")) {
						contentScroll.add(new ProfileTopicListView(folderListDo.get(i), count, AppClientFactory.getCurrentPlaceToken(), "scollection"));
					} else {
						contentScroll.add(new ProfileTopicListView(folderListDo.get(i), count, AppClientFactory.getCurrentPlaceToken()));
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
	
	public void setAssets(String placeToken) {
		courseTabs.getElement().setId("courseTabs");
		container.getElement().setId("container");
		featuredCourseTabs.getElement().setId("featuredCourseTabs");
		leftNav.getElement().setId("leftNav");
		contentScroll.getElement().setId("contentScroll");
		courseBanner.getElement().setId("courseBanner");
		featuredEducator.getElement().setId("featuredEducator");
		featuredCousesLbl.getElement().setId("lblFeaturedCousesLbl");
		featuredCourses.getElement().setId("pnlFeaturedCourses");
		partnerLogo.getElement().setId("pnlPartnerLogo");
		courseImage.getElement().setId("imgCourseImage");
		courseTitle.getElement().setId("lblCourseTitle");
		educatorPhoto.getElement().setId("imgEducatorPhoto");
		featuredContributor.getElement().setId("lblFeaturedContributor");
		featuredContributorsLink.getElement().setId("lnkFeaturedContributorsLink");
		scrollPanel.getElement().setId("sbScrollPanel");
		libraryMetaDataContainer.getElement().setId("pnlLibraryMetaDataContainer");
		loadingIconPanel.getElement().setId("pnlLoadingIconPanel");
		contributorsContainer.getElement().setId("pnlContributorsContainer");
		
		setPlaceToken(placeToken);
		if(getPlaceToken().equalsIgnoreCase(PlaceTokens.SAUSD_LIBRARY)) {
			landingBanner.getElement().setId("landingSausdBanner");
			featuredCousesLbl.setText(i18n.GL1901());
			featuredCousesLbl.getElement().setAttribute("alt",i18n.GL1901());
			featuredCousesLbl.getElement().setAttribute("title",i18n.GL1901());
		} else if(getPlaceToken().equalsIgnoreCase(PlaceTokens.LIFEBOARD)) {
			landingBanner.getElement().setId("landingLifeboardBanner");
			featuredCousesLbl.setText(i18n.GL2046());
			featuredCousesLbl.getElement().setAttribute("alt",i18n.GL2046());
			featuredCousesLbl.getElement().setAttribute("title",i18n.GL2046());
		}


		if(getPlaceToken().equalsIgnoreCase(PlaceTokens.SAUSD_LIBRARY)) {
			partnerLogo.setStyleName(districtStyleUc.sausdPartnerLogo());
			partnerLogo.setVisible(true);
			partnerLogo.getElement().getStyle().setRight(10, Unit.PX);
		} else {
			partnerLogo.setVisible(false);
		}

		contributorsContainer.setVisible(false);
		courseBanner.setVisible(false);
		featuredEducator.setVisible(false);
		districtMenuNav = new DistrictMenuNav(getPlaceToken()) {
			@Override
			public void clickOnCourse(ArrayList<ProfileLibraryDo> unitList, String courseId, ProfileLibraryDo profileLibraryDo) {
				showCourseBanner(profileLibraryDo, true);
				setSubjectUnits(unitList);
			}
		};
		courseTabs.add(districtMenuNav);
		landingBanner.add(new DistrictBannerView(getPlaceToken()));
		featuredContributorsLink.setText(i18n.GL1005());
		featuredContributorsLink.getElement().setAttribute("alt",i18n.GL1005());
		featuredContributorsLink.setTitle(i18n.GL1005());
		courseImage.setWidth("1000px");
		courseImage.setHeight("300px");
	}
	
	private void setSubjectUnits(ArrayList<ProfileLibraryDo> unitList) {
		leftNav.clear();
		setUnitList(unitList);
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
			courseTitle.getElement().setAttribute("alt",profileLibraryDo.getTitle());
			courseTitle.getElement().setAttribute("title",profileLibraryDo.getTitle());
		}
	}
}