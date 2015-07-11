package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
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

public class StudentClassLearningMapContainer extends Composite {

	@UiField HTMLEventPanel unitBlock;
	@UiField HTMLPanel circleContainer;
	@UiField H3Panel unitCountName;
	@UiField PPanel unitName;
	@UiField Label numericOrder;
	
	private static StudentClassLearningMapContainerUiBinder uiBinder = GWT
			.create(StudentClassLearningMapContainerUiBinder.class);

	interface StudentClassLearningMapContainerUiBinder extends
			UiBinder<Widget, StudentClassLearningMapContainer> {
	}

	public StudentClassLearningMapContainer(PlanProgressDo planProgressDo, int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setCircleContainerItems(planProgressDo, count);
		unitBlock.addClickHandler(new LessonPageRedirection(planProgressDo.getGooruOId()));
	}
	
	public void setCircleContainerItems(PlanProgressDo planProgressDo, int count) {
		numericOrder.setText((count+1)+"");
		unitCountName.setText(planProgressDo.getTitle());
		unitName.setText("Unit");
		int size = planProgressDo.getItem().size();
		ArrayList<PlanProgressDo> dataList = planProgressDo.getItem();
		for(int i=0;i<size;i++) {
			circleContainer.add(new StudentClassLearningMapCircle(dataList.get(i)));
		}
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