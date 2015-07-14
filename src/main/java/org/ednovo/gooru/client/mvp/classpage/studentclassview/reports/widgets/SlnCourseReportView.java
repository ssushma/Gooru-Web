package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.SmallPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.StringUtil;

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
	
	public SlnCourseReportView(PlanProgressDo planProgressDo, int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setDebugIds();
		setCircleContainerItems(planProgressDo, count);
		unitBlock.addClickHandler(new LessonPageRedirection(planProgressDo.getGooruOId()));
	}
	
	private void setDebugIds() {
		collectionStudyLbl.setText("Collections Viewed");
		assessmentStudyLbl.setText("Assessments Attemted");
		studyTimeLbl.setText("Total Study Time");
		scoreLbl.setText("Avg Score");
	}
	
	public void setCircleContainerItems(PlanProgressDo planProgressDo, int count) {
		numericOrder.setText(count+"");
		unitCountName.setText(planProgressDo.getTitle());
		unitName.setText("Unit");
		collectionStudyCount.setText(planProgressDo.getCollectionsViewed()+" of "+planProgressDo.getCollectionCount());
		double timeRadialPercent = 0;
		if(planProgressDo.getCollectionCount()>0) {
			timeRadialPercent = (planProgressDo.getCollectionsViewed() / planProgressDo.getCollectionCount()) * 100;
		}
		timeRadial.setStyleName(TIME_RADIAL_PERCENT_LABEL+timeRadialPercent);
		assessmentStudyCount.setText(planProgressDo.getAssessmentsAttempted()+" of "+planProgressDo.getAssessmentCount());
		double scorePercent = 0;
		if(planProgressDo.getAssessmentCount()>0) {
			scorePercent = (planProgressDo.getAssessmentsAttempted() / planProgressDo.getAssessmentCount()) * 100;
		}
		scoreRadial.setStyleName(SCORE_RADIAL_PERCENT_LABEL+scorePercent);
		
		String timeSpentData = "--";
		if(planProgressDo.getTimespent()>0) {
			timeSpentData = StringUtil.getFormattedDate(planProgressDo.getTotalStudyTime(), "");
		}
		studyTimeValue.setText(timeSpentData);
		
		String avgScoreTxt = "--";
		
		if(planProgressDo.getAssessmentCount()==0) {
			avgScoreTxt = "NS";
			hideScoreRadial(false);
		} else if(planProgressDo.getAssessmentsAttempted()==0) {
			avgScoreTxt = "--";
		} else {
			avgScoreTxt = planProgressDo.getScoreInPercentage()+"%";
		}
		
		if(planProgressDo.getCollectionCount()==0) {
			hideTimeRadial(false);
		}
		scoreValue.setText(avgScoreTxt);
		
		int score = planProgressDo.getScoreInPercentage();
		String scoreStyle = "";
		if(planProgressDo.getAssessmentCount()==0||planProgressDo.getAssessmentsAttempted()==0) {
			scoreStyle = "darkGrey border-bottom-white";
		} else {
			if(score<60) {
				scoreStyle = "red";
			} else if(score>=60&&score<=69) {
				scoreStyle = "org";
			} else if(score>=70&&score<=79) {
				scoreStyle = "yellowGreen";
			} else if(score>=80&&score<=89) {
				scoreStyle = "lightGreen";
			} else if(score>=90&&score<=100) {
				scoreStyle = "darkGreen";
			}
		}
		avgScore.addStyleName(scoreStyle);
		
		if(planProgressDo.getAssessmentCount()==0) {
			assessmentStudyCount.setText("--");
			assessmentStudyLbl.setVisible(false);
		}
		if(planProgressDo.getCollectionCount()==0) {
			collectionStudyCount.setText("--");
			collectionStudyLbl.setVisible(false);
		}
		
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