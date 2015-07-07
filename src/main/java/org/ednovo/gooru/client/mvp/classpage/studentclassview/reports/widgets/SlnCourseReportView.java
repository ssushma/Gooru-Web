package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.SmallPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class SlnCourseReportView extends Composite {

	@UiField HTMLEventPanel unitBlock;
	@UiField H3Panel unitCountName, collectionStudyCount, assessmentStudyCount, studyTimeValue;
	@UiField PPanel unitName, studyTimeLbl, scoreLbl;
	@UiField Label numericOrder;
	@UiField SmallPanel collectionStudyLbl,assessmentStudyLbl;
	@UiField H2Panel scoreValue;
	@UiField HTMLPanel scoreRadial, timeRadial, avgScore;
	
	private static final String SCORE_RADIAL_PERCENT_LABEL = "progress-radial org-progress-";
	private static final String TIME_RADIAL_PERCENT_LABEL = "progress-radial blue-progress-";
	
	private static SlnUnitReportViewUiBinder uiBinder = GWT
			.create(SlnUnitReportViewUiBinder.class);

	interface SlnUnitReportViewUiBinder extends
			UiBinder<Widget, SlnCourseReportView> {
	}
	
	public SlnCourseReportView(int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setDebugIds();
		setCircleContainerItems(count);
		unitBlock.addClickHandler(new LessonPageRedirection("unitId"));
	}
	
	private void setDebugIds() {
		collectionStudyLbl.setText("Collections Viewed");
		assessmentStudyLbl.setText("Assessments Attemted");
		studyTimeLbl.setText("Total Study Time");
		scoreLbl.setText("Avg Score");
	}
	
	public void setCircleContainerItems(int count) {
		numericOrder.setText(count+"");
		unitCountName.setText("Operations & Algebraic Thinking");
		unitName.setText("Unit");
		collectionStudyCount.setText("4 of 8");
		timeRadial.setStyleName(TIME_RADIAL_PERCENT_LABEL+"50");
		assessmentStudyCount.setText("2 of 8");
		scoreRadial.setStyleName(SCORE_RADIAL_PERCENT_LABEL+"40");
		studyTimeValue.setText("3 hrs 45 min");
		scoreValue.setText("84%");
		avgScore.addStyleName("lightGreen");
		//hideTimeRadial();
		//hideScoreRadial();
	}
	
	private void hideTimeRadial(boolean isNotVisible) {
		timeRadial.setVisible(isNotVisible);
	}
	
	private void hideScoreRadial(boolean isNotVisible) {
		scoreRadial.setVisible(isNotVisible);
	}
	
	public class LessonPageRedirection implements ClickHandler{
		private String unitId = null;
		
		public LessonPageRedirection(String unitId) {
			this.unitId = unitId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_ID, unitId);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}	
	}

}
