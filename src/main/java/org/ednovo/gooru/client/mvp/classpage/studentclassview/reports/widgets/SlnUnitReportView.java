package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SlnUnitReportView extends Composite {
	
	@UiField HTMLEventPanel unitBlock, leftArrow, rightArrow;
	@UiField HTMLPanel slnContentPanel, circleIcon, avgScorePanel;
	@UiField Label numericOrder;
	@UiField H3Panel lessonCountName;
	@UiField PPanel lessonName;
	@UiField H2Panel totalScore;
	
	ArrayList<PlanProgressDo> dataList = new ArrayList<PlanProgressDo>();
	
	int start = 0, end = 0;
	
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
		
		int score = planProgressDo.getScoreInPercentage();
		String scoreStyle = "";
		if(score==0) {
			scoreStyle = "darkGrey border-bottom-white";
		} else if(score<60) {
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
		avgScorePanel.addStyleName(scoreStyle);
		totalScore.setText(score+"");
		
		dataList = planProgressDo.getItem();
		int size = dataList.size();
		
		if(dataList!=null&&size>0) {
			start = 0;
			if(size < 3) {
				end = size;
			} else {
				end = 2;
			}
			setData(start,end);
		}
	}
	
	private void setData(int startPoint, int endPoint) {
		slnContentPanel.clear();
		for(int z=startPoint;z<endPoint;z++) {
			String lastItem = "";
			if(z==(dataList.size()-1)) {
				lastItem = "lastItem";
			}
			slnContentPanel.add(new SlnContentWidget(dataList.get(z),lastItem));
		}
		setArrows();
	}
	
	private void setArrows() {
		boolean leftArrowVisibile = false, rightArrowVisible = false;
		if(end>2) {
			leftArrowVisibile = true;
		}
		if(end<dataList.size()) {
			rightArrowVisible = true;
		}
		setArrowVisibility(leftArrowVisibile,rightArrowVisible);
	}
	
	private void setArrowVisibility(boolean leftArrowVisibile, boolean rightArrowVisible) {
		leftArrow.setVisible(leftArrowVisibile);
		rightArrow.setVisible(rightArrowVisible);
	}
	
	@UiHandler("leftArrow")
	public void clickLeftArrow(ClickEvent event) {
		end = start - 1;
		if(start-3<0) {
			start = 0;
		} else {
			start = start - 3;
		}
		setData(start, end);
	}
	
	@UiHandler("rightArrow")
	public void clickRightArrow(ClickEvent event) {
		start = end + 1;
		if((dataList.size()-1)-end > 3) {
			end = end + 3;
		} else {
			end = (dataList.size()-1);
		}
		setData(start, end);		
	}

}