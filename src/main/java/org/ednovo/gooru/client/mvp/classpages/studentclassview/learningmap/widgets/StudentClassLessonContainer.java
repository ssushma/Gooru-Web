package org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.widgets;

import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class StudentClassLessonContainer extends Composite {

	@UiField HTMLPanel lessonContainer, circleIcon;
	@UiField H3Panel lessonCountName;
	@UiField PPanel lessonName;
	
	private static StudentClassLessonContainerUiBinder uiBinder = GWT
			.create(StudentClassLessonContainerUiBinder.class);

	interface StudentClassLessonContainerUiBinder extends
			UiBinder<Widget, StudentClassLessonContainer> {
	}

	public StudentClassLessonContainer(String circleIconStyle) {
		initWidget(uiBinder.createAndBindUi(this));
		setCircleContainerItems();
		circleIcon.setStyleName(circleIconStyle);
	}
	
	public void setCircleContainerItems() {
		lessonCountName.setText("Lesson 1");
		lessonName.setText("Comparing Fractions with Common Debominators & Numerators");
		
		lessonContainer.add(new StudentClassContentWidget("blueBorder","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/2092/3457/e6cfc5e1-0611-48d8-9637-92a0dce76786_1371894b-c2af-4468-a077-c93ecc4f7ede-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder selected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4383/9a76aa68-bd60-4fe4-8d02-f54c8e105290-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder blueselected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4385/f236d78f-681e-43e4-b648-9dc564780623-160x120.png"));
		lessonContainer.add(new StudentClassContentWidget("orgBorder selected","http://d1lkwrtg12r0i3.cloudfront.net/prod1/f000/1151/4415/322bab19-05bc-42e9-b47c-498a98a924bb-160x120.png"));
	}
}