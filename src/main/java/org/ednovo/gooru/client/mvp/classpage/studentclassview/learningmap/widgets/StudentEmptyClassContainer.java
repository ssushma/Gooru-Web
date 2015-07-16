package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.client.uc.PPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StudentEmptyClassContainer extends Composite {

	@UiField PPanel errorLbl, recoverLbl;
	
	private static StudentEmptyClassContainerUiBinder uiBinder = GWT
			.create(StudentEmptyClassContainerUiBinder.class);

	interface StudentEmptyClassContainerUiBinder extends
			UiBinder<Widget, StudentEmptyClassContainer> {
	}

	public StudentEmptyClassContainer() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setUserName(String userName) {
		errorLbl.setText(userName+" has not added content for this Class yet.");
		recoverLbl.setText("Please check back again later!");
	}
}