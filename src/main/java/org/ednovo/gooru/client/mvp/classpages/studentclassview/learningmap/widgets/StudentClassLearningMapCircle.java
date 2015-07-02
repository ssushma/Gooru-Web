package org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.widgets;

import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class StudentClassLearningMapCircle extends Composite {

	@UiField HTMLPanel circleField;
	@UiField SpanPanel spanTxt;
	
	private static StudentClassLearningMapCircleUiBinder uiBinder = GWT.create(StudentClassLearningMapCircleUiBinder.class);
	
	interface StudentClassLearningMapCircleUiBinder extends UiBinder<Widget, StudentClassLearningMapCircle> {}

	public StudentClassLearningMapCircle(String circleStyle) {
		initWidget(uiBinder.createAndBindUi(this));
		if(!circleStyle.isEmpty()) {
			circleField.setStyleName(circleStyle);
			if(circleStyle.equalsIgnoreCase("green-text")) {
				spanTxt.setText("NS");
			}
		}
	}
}