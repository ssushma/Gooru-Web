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

	public StudentClassLessonContainer(String circleIconStyle, int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setCircleContainerItems(count);
		circleIcon.setStyleName(circleIconStyle);
		lessonWidget.addClickHandler(new LessonPageRedirection("lessonId"));
	}
	
	public void setCircleContainerItems(int count) {
		numericOrder.setText(count+"");
		lessonCountName.setText("Comparing Fractions with Common Denominators & Numerators");
		lessonName.setText("Lesson");
		lessonContainer.add(new StudentClassContentWidget("blueBorder","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/2092/3457/e6cfc5e1-0611-48d8-9637-92a0dce76786_1371894b-c2af-4468-a077-c93ecc4f7ede-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder selected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4383/9a76aa68-bd60-4fe4-8d02-f54c8e105290-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder blueselected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4385/f236d78f-681e-43e4-b648-9dc564780623-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder selected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4415/322bab19-05bc-42e9-b47c-498a98a924bb-160x120.png"));
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