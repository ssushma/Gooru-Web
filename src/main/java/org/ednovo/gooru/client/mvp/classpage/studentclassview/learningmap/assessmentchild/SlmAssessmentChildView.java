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
package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.assessmentchild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanContentDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets.SlmExternalAssessmentForm;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 *
 */
public class SlmAssessmentChildView extends ChildView<SlmAssessmentChildPresenter> implements IsSlmAssessmentView {

	@UiField Anchor reportUrl;

	@UiField HTMLPanel reportView, imageContainer, resourceImgContainer;

	@UiField H3Panel contentName;

	@UiField PPanel contentDescription;

	@UiField Label timeSpent, viewCount, lastSession, timeSpentLbl, lastAccessedLbl;

	@UiField Image contentImage;

	@UiField HTMLEventPanel viewReport;

	private final String DEFAULT_COLLECTION_IMAGE = "../images/default-collection-image-160x120.png";

	private final String DEFAULT_ASSESSMENT_IMAGE = "../images/default-assessment-image -160x120.png";

	String DEFULT_IMAGE_PREFIX = "images/default-";

	String PNG = ".png";

	String SMALL = "Small";

	private PopupPanel toolTipPopupPanel = new PopupPanel();

	private PlanContentDo planContentDo = null;

	private static SlmAssessmentChildViewUiBinder uiBinder = GWT.create(SlmAssessmentChildViewUiBinder.class);

	interface SlmAssessmentChildViewUiBinder extends UiBinder<Widget, SlmAssessmentChildView> {
	}

	public SlmAssessmentChildView(PlanContentDo planContentDo, String status, String userId) {
		initWidget(uiBinder.createAndBindUi(this));
		this.planContentDo = planContentDo;

		setData(planContentDo);
		viewReport.addClickHandler(new IndividualReportView(planContentDo.getGooruOid(),planContentDo.getCollectionType()));
		contentName.addClickHandler(new PlayClassContent(planContentDo.getGooruOid(),planContentDo.getCollectionType(), status, userId));
		contentImage.addClickHandler(new PlayClassContent(planContentDo.getGooruOid(),planContentDo.getCollectionType(), status, userId));
	}

	public void setData(final PlanContentDo planContentDo) {
		final String collectionType = planContentDo.getCollectionType();

		String page = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_PREVIEW_MODE, UrlNavigationTokens.FALSE);
		if(page.equalsIgnoreCase(UrlNavigationTokens.TRUE)) {
			reportView.setVisible(false);
		} else {
			reportView.setVisible(true);
		}

		if(planContentDo.getThumbnails()!=null&&planContentDo.getThumbnails().getUrl()!=null) {
			contentImage.setUrl(planContentDo.getThumbnails().getUrl());
		} else {
			setDefaultThumbnail(collectionType);
		}

		contentImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				setDefaultThumbnail(collectionType);
			}
		});
		if(collectionType!=null&&(collectionType.equalsIgnoreCase("assessment/url"))) {
			imageContainer.setStyleName("assessmentImageContainer");
			reportView.clear();
			reportView.add(new SlmExternalAssessmentForm(planContentDo.getProgress()));
		} else if(collectionType!=null&&collectionType.equalsIgnoreCase("assessment")) {
			imageContainer.setStyleName("assessmentImageContainer");
			timeSpentLbl.setText("Score");
			lastAccessedLbl.setText("Last Attempted");
			timeSpent.setText(planContentDo.getProgress().getScoreInPercentage()+"%");
		} else {
			imageContainer.setStyleName("collectionImageContainer");
			timeSpentLbl.setText("Total Time Spent");
			lastAccessedLbl.setText("Last Viewed");
			timeSpent.setText(StringUtil.getFormattedDate(planContentDo.getProgress().getTimeSpent(), ""));
		}
		contentName.setText(planContentDo.getTitle());
		contentDescription.setText(planContentDo.getDescription());

		viewCount.setText(planContentDo.getProgress().getViews()+"");
		String lastAccessed = "--";
		if(planContentDo.getProgress().getLastAccessed()>0) {
			lastAccessed = AnalyticsUtil.getCreatedTime(Long.toString(planContentDo.getProgress().getLastAccessed()));
		}
		lastSession.setText(lastAccessed);
		if(collectionType!=null&&collectionType.equalsIgnoreCase("assessment/url")) {
			resourceImgContainer.setVisible(false);
		} else {
			setResourceData(planContentDo.getItems());
		}
	}

	private void setDefaultThumbnail(String collectionType) {
		if(collectionType!=null&&(collectionType.equalsIgnoreCase("assessment")||collectionType.equalsIgnoreCase("assessment/url"))) {
			contentImage.setUrl(DEFAULT_ASSESSMENT_IMAGE);
		} else {
			contentImage.setUrl(DEFAULT_COLLECTION_IMAGE);
		}
	}

	public class IndividualReportView implements ClickHandler {
		private String type = "collection";
		private String gooruOid = null;

		public IndividualReportView(String gooruOid, String type) {
			if(type!=null) {
				this.type = type;
			}
			this.gooruOid = gooruOid;
		}

		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASSPAGE_CONTENT,type);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_ASSESSMENT_ID, gooruOid);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB,UrlNavigationTokens.STUDENT_CLASSPAGE_REPORT_ITEM);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}

	public class PlayClassContent implements ClickHandler {

		private String type = "collection";
		private String gooruOid = null;
		private String status = null;
		private String userId = null;

		public PlayClassContent(String gooruOid, String type, String status, String userId) {
			if(type!=null) {
				this.type = type;
			}
			this.gooruOid = gooruOid;
			this.status = status;
			this.userId = userId;
		}

		@Override
		public void onClick(ClickEvent event) {
			String classUId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_CLASS_ID, null);
			String courseGooruOid = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, null);
			String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, null);
			String lessonId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, null);
			Map<String,String> params = new LinkedHashMap<String,String>();

			String token = PlaceTokens.ASSESSMENT_PLAY;

			if(type.equalsIgnoreCase("assessment")) {
				token = PlaceTokens.ASSESSMENT_PLAY;
			} else if(type.equalsIgnoreCase("collection")) {
				token = PlaceTokens.COLLECTION_PLAY;
			}

			if(status!=null&&status.equalsIgnoreCase("active")) {
				params.put("isStudent", "true");	// This should be changed based on; whether user has joined or not.
			}

			if(status==null) {
				status = "debug-point";
			}
			contentImage.getElement().setAttribute("debug-point", status);
			contentName.getElement().setAttribute("debug-point", status);

			params.put("id", gooruOid);
			params.put("cid", classUId);
			params.put("courseId", courseGooruOid);
			params.put("unitId", unitId);
			params.put("lessonId", lessonId);

			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(token, params);
			if(!type.equalsIgnoreCase("assessment/url")) {
				AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
			} else {
				if(planContentDo.getUrl()!=null&&!planContentDo.getUrl().isEmpty()) {
					Window.open(planContentDo.getUrl(), "_blank", "");
				}
			}
		}
	}

	private void setResourceData(ArrayList<PlanContentDo> resourceList) {
		int size = resourceList.size();
		if(size>0) {
			if(size>10) {
				size = 10;
			}
			for(int i=0;i<size;i++) {
				try {
					final PlanContentDo resourceDo = resourceList.get(i);
					String categoryString = "";
					if(resourceDo.getResourceFormat()!=null){
						categoryString = resourceDo.getResourceFormat().getDisplayName();
					}
					final String category = categoryString;
					final HTMLEventPanel resourcePanel = new HTMLEventPanel("");
					//resourcePanel.setStyleName(libraryStyle.resourceImage());

					final Image resourceImage = new Image();
					String resourceTitle = null;
					try {
						resourceTitle = resourceDo.getTitle().replaceAll("\\<[^>]*>","");
						resourceDo.setTitle(resourceTitle);
					} catch (Exception e){
						AppClientFactory.printSevereLogger("SimAssessmentChileView : setResourceData 1 : "+e.getMessage());
					}
					resourceImage.setAltText(resourceTitle);
					resourceImage.setTitle(resourceTitle);

					final HTMLEventPanel resourceCategoryIcon = new HTMLEventPanel("");
					resourceCategoryIcon.addMouseOverHandler(new MouseOverHandler() {
						@Override
						public void onMouseOver(MouseOverEvent event) {
							try {
								toolTipPopupPanel.clear();
								toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(resourceDo.getTitle()));
								toolTipPopupPanel.setStyleName("");
								toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 55);
								toolTipPopupPanel.show();
							} catch(Exception ex) {
								AppClientFactory.printSevereLogger("SimAssessmentChileView : setResourceData 2 : "+ex.getMessage());
							}
						}
					});
					resourceCategoryIcon.addMouseOutHandler(new MouseOutHandler() {
						@Override
						public void onMouseOut(MouseOutEvent event) {
							toolTipPopupPanel.hide();
						}
					});

					resourceCategoryIcon.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {

						}
					});

					resourceImage.addMouseOverHandler(new MouseOverHandler() {
						@Override
						public void onMouseOver(MouseOverEvent event) {
							try
							{
								toolTipPopupPanel.clear();
								toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(resourceDo.getTitle()));
								toolTipPopupPanel.setStyleName("");
								toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 55);
								toolTipPopupPanel.show();
							}
							catch(Exception ex)
							{
								AppClientFactory.printSevereLogger("SimAssessmentChileView : setResourceData 3 : "+ex.getMessage());
							}
						}
					});

					resourceImage.addMouseOutHandler(new MouseOutHandler() {
						@Override
						public void onMouseOut(MouseOutEvent event) {
							toolTipPopupPanel.hide();
						}
					});
					try {
						if(resourceDo.getThumbnails()!=null&&resourceDo.getThumbnails().getUrl()!=null&&!resourceDo.getThumbnails().getUrl().isEmpty()) {
							resourceImage.setUrl(resourceDo.getThumbnails().getUrl());
						} else {
							resourceImage.setUrl(DEFULT_IMAGE_PREFIX +getDetaultResourceImage(category.toLowerCase()) + PNG);
						}

						resourceImage.addErrorHandler(new ErrorHandler() {
							@Override
							public void onError(ErrorEvent event) {
								resourceImage.setUrl(DEFULT_IMAGE_PREFIX +getDetaultResourceImage(category.toLowerCase()) + PNG);
							}
						});
					} catch (Exception e){
						e.printStackTrace();
						resourceImage.setUrl(DEFULT_IMAGE_PREFIX + getDetaultResourceImage(category.toLowerCase()) + PNG);
						resourceImage.setAltText(resourceDo.getTitle());
						resourceImage.setTitle(resourceDo.getTitle());
						AppClientFactory.printSevereLogger("SimAssessmentChileView : setResourceData 4 : "+e.getMessage());
					}

					resourcePanel.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {

						}
					});

					resourceCategoryIcon.addStyleName("resourceName");
					resourceCategoryIcon.addStyleName(getDetaultResourceImage(category.toLowerCase()) + SMALL);
					resourcePanel.add(resourceImage);
					resourcePanel.add(resourceCategoryIcon);
					resourceImgContainer.add(resourcePanel);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		} else {
			resourceImgContainer.add(new Label("No resources!!!"));
		}
	}

	public String getDetaultResourceImage(String category){
		String categoryIcon=StringUtil.getEquivalentCategory(category==null?"":category.toLowerCase());
		return categoryIcon ;
	}

}