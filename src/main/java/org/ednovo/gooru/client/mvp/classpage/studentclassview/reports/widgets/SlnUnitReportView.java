package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SlnUnitReportView extends Composite {
	
	@UiField HTMLEventPanel unitBlock;
	@UiField HTMLPanel slnContentPanel, circleIcon;
	@UiField Label numericOrder;
	@UiField H3Panel lessonCountName;
	@UiField PPanel lessonName;
	@UiField H2Panel totalScore;
	
	private static SlnUnitReportViewUiBinder uiBinder = GWT.create(SlnUnitReportViewUiBinder.class);

	interface SlnUnitReportViewUiBinder extends UiBinder<Widget, SlnUnitReportView> {
	}

	public SlnUnitReportView(PlanProgressDo planProgressDo, int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setReportData(planProgressDo, count);
	}
	
	public void setReportData(PlanProgressDo planProgressDo, int count) {
		numericOrder.setText(count+"");
		lessonCountName.setText(planProgressDo.getTitle());
		lessonName.setText("Lesson");
		
		String circleType = "grey";
		String page = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_PREVIEW_MODE, UrlNavigationTokens.FALSE);
		if(!page.equalsIgnoreCase(UrlNavigationTokens.TRUE)) {
			if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("NotAttempted")) {
				
			} else if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("ScoreNotYetMet")) {
				circleType = "blue-circle";
			} else if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("ScoreMet")) {
				circleType = "green-circle";
			}
		}
		circleIcon.addStyleName(circleType);
		
		totalScore.setText("60");
		slnContentPanel.clear();
		slnContentPanel.add(new SlnContentWidget("collection",""));
		slnContentPanel.add(new SlnContentWidget("assessment",""));
		slnContentPanel.add(new SlnContentWidget("assessment","lastItem"));
	}
	
}