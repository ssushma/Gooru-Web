package org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class StudentClassContentWidget extends Composite {

	@UiField HTMLPanel contentPanel;
	@UiField Image imagePanel;
	
	private static StudentClassContentWidgetUiBinder uiBinder = GWT.create(StudentClassContentWidgetUiBinder.class);
	
	interface StudentClassContentWidgetUiBinder extends UiBinder<Widget, StudentClassContentWidget> {}
	
	public StudentClassContentWidget(String circleStyle, String url) {
		initWidget(uiBinder.createAndBindUi(this));
		if(!circleStyle.isEmpty()) {
			contentPanel.addStyleName(circleStyle);
		}
		imagePanel.setUrl(url);
		imagePanel.setHeight("55px");
		imagePanel.setWidth("75px");
	}
}