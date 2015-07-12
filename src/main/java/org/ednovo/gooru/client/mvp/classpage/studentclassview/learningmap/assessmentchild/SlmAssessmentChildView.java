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

import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 *
 */
public class SlmAssessmentChildView extends ChildView<SlmAssessmentChildPresenter> implements IsSlmAssessmentView {

	@UiField Anchor reportUrl;

	@UiField HTMLPanel reportView;

	@UiField H3Panel contentName;

	@UiField PPanel contentDescription;

	@UiField Label timeSpent, viewCount, lastSession;

	@UiField Image contentImage;

	private static SlmAssessmentChildViewUiBinder uiBinder = GWT.create(SlmAssessmentChildViewUiBinder.class);

	interface SlmAssessmentChildViewUiBinder extends UiBinder<Widget, SlmAssessmentChildView> {
	}

	public SlmAssessmentChildView(PlanProgressDo planProgressDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(planProgressDo);
		contentName.addClickHandler(new PlayClassContent(planProgressDo.getGooruOId(),planProgressDo.getType()));
		contentImage.addClickHandler(new PlayClassContent(planProgressDo.getGooruOId(),planProgressDo.getType()));
	}

	public void setData(PlanProgressDo planProgressDo) {
		String page = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_PREVIEW_MODE, UrlNavigationTokens.FALSE);
		if(page.equalsIgnoreCase(UrlNavigationTokens.TRUE)) {
			reportView.setVisible(false);
		} else {
			reportView.setVisible(true);
		}
		contentName.setText("No title available");
		contentDescription.setText("No description is available to show");
		long timeSpentValue = planProgressDo.getTimespent();
		timeSpent.setText(timeSpentValue+"");
		viewCount.setText(planProgressDo.getViews()+"");
		lastSession.setText(planProgressDo.getLastAccessed()+"");
		contentImage.setHeight("120px");
		contentImage.setWidth("172px");
	}

	public class PlayClassContent implements ClickHandler {

		private String type = "collection";
		private String gooruOid = null;

		public PlayClassContent(String gooruOid, String type) {
			if(type!=null&&type.equalsIgnoreCase("assessment")) {
				type = "assessment";
			}
			this.gooruOid = gooruOid;
		}

		@Override
		public void onClick(ClickEvent event) {
			String classUId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_CLASS_ID, null);
			String courseGooruOid = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, null);
			String unitId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, null);
			String lessonId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, null);

			String token = PlaceTokens.ASSESSMENT_PLAY;

			if(type=="assessment") {
				token = PlaceTokens.ASSESSMENT_PLAY;
			} else if(type=="collection") {
				token = PlaceTokens.ASSESSMENT_PLAY;
			}

			Map<String,String> params = new LinkedHashMap<String,String>();
			params.put("id", gooruOid);
			params.put("cid", classUId);
			params.put("courseId", courseGooruOid);
			params.put("unitId", unitId);
			params.put("lessonId", lessonId);
			params.put("isStudent", "true");	// This should be changed based on; whether user has joined or not.


			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(token, params);
			AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
		}
	}

}