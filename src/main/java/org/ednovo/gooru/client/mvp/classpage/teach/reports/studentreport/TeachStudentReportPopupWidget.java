package org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.UrlNavigationTokens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class TeachStudentReportPopupWidget extends PopupPanel {
	
	@UiField Label popupTitle;
	
	@UiField HTMLPanel contentPanel, panel;
	
	@UiField Anchor closeButton;
	
	private static TeachStudentReportPopupWidgetUiBinder uiBinder = GWT
			.create(TeachStudentReportPopupWidgetUiBinder.class);

	interface TeachStudentReportPopupWidgetUiBinder extends
			UiBinder<Widget, TeachStudentReportPopupWidget> {
	}
	
	public TeachStudentReportPopupWidget() {
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		this.setWidth((Window.getClientWidth()-100)+"px");
		this.setGlassEnabled(true);
		this.setPopupPosition(50, Window.getScrollTop()+50);
		this.show();
		setData();
	}

	public void setData() {
		panel.clear();
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			popupTitle.setText("Course View");
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			popupTitle.setText("Unit View");
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			popupTitle.setText("Assessment View");
		}
		panel.add(new TeachStudentReportPopupChildView());
	}
	
	@UiHandler("closeButton")
	public void CloseButton(ClickEvent event) {
		this.hide();
	}
	
}