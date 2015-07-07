package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
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

	public StudentClassLearningMapContainer(int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setCircleContainerItems(count);
		unitBlock.addClickHandler(new LessonPageRedirection("unitId"));
	}
	
	public void setCircleContainerItems(int count) {
		numericOrder.setText((count+1)+"");
		unitCountName.setText("Operations & Algebraic Thinking");
		unitName.setText("Unit");
		circleContainer.add(new StudentClassLearningMapCircle("green-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("blue-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("green-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("green-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("blue-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("blue-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("blue-circle"));
		circleContainer.add(new StudentClassLearningMapCircle("blue-circle"));
		circleContainer.add(new StudentClassLearningMapCircle(""));
		circleContainer.add(new StudentClassLearningMapCircle(""));
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