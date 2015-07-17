package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
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

public class StudentClassLessonContainer extends Composite {

	@UiField HTMLPanel lessonContainer, circleIcon;
	@UiField H3Panel lessonCountName;
	@UiField PPanel lessonName;
	@UiField HTMLEventPanel lessonWidget;
	@UiField Label numericOrder;
	
	private static StudentClassLessonContainerUiBinder uiBinder = GWT.create(StudentClassLessonContainerUiBinder.class);

	interface StudentClassLessonContainerUiBinder extends
			UiBinder<Widget, StudentClassLessonContainer> {
	}

	public StudentClassLessonContainer(PlanProgressDo planProgressDo, int count, String status, String userId) {
		initWidget(uiBinder.createAndBindUi(this));
		setCircleContainerItems(planProgressDo, count, status, userId);
		lessonWidget.addClickHandler(new LessonPageRedirection(planProgressDo.getGooruOId()));
	}
	
	public void setCircleContainerItems(PlanProgressDo planProgressDo, int count, String status, String userId) {
		numericOrder.setText(count+"");
		lessonCountName.setText(planProgressDo.getTitle());
		lessonName.setText("Lesson");
		
		ArrayList<PlanProgressDo> dataList = planProgressDo.getItem();
		int size = dataList.size();
		
		String page = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_PREVIEW_MODE, UrlNavigationTokens.FALSE);
		if(!page.equalsIgnoreCase(UrlNavigationTokens.TRUE)) {
			String circleIconStyle = "";
			if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("NotAttempted")) {
				
			} else if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("ScoreNotMet")) {
				circleIconStyle = "blue-circle";
			} else if(planProgressDo.getScoreStatus()!=null&&planProgressDo.getScoreStatus().equalsIgnoreCase("ScoreMet")) {
				circleIconStyle = "green-circle";
			}
			circleIcon.setStyleName(circleIconStyle);
		}
		
		if(size>0) {
			for(int i=0;i<size;i++) {
				PlanProgressDo planDo = dataList.get(i);
				String styleName = "blueBorder ";
				if(planDo.getType()!=null&&(planDo.getType().equalsIgnoreCase("assessment")||planDo.getType().equalsIgnoreCase("assessment/url"))) {
					styleName = "orgBorder ";
				}
				if(!page.equalsIgnoreCase(UrlNavigationTokens.TRUE)) {
					if(planDo.getScoreStatus()!=null&&planDo.getScoreStatus().equalsIgnoreCase("NotAttempted")) {
						styleName = styleName + "cursorPointer";
					} else if(planDo.getScoreStatus()!=null&&planDo.getScoreStatus().equalsIgnoreCase("ScoreNotMet")) {
						styleName = styleName + "blueselected cursorPointer";
					} else if(planDo.getScoreStatus()!=null&&planDo.getScoreStatus().equalsIgnoreCase("ScoreMet")) {
						styleName = styleName + "selected cursorPointer";
					}
				}
				lessonContainer.add(new StudentClassContentWidget(planDo, styleName, planProgressDo.getGooruOId(), status, userId));
			}
		} else {
			lessonContainer.add(StringUtil.getStudentPlanErrorLbl("Your teacher has not assigned any assessments or collections yet!", "error-lbl-student-course-plan"));
		}
	}
	
	public class LessonPageRedirection implements ClickHandler{
		private String lessonId = null;
		
		public LessonPageRedirection(String lessonId) {
			this.lessonId = lessonId;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW);
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_ID, lessonId);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
	}
}