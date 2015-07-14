package org.ednovo.gooru.client.mvp.classpage.teach.reports.studentreport;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class TeachStudentReportPopupWidget extends PopupPanel {
	
	@UiField Label popupTitle;
	
	@UiField HTMLPanel contentPanel, panel;
	
	@UiField Anchor closeButton;
	
	@UiField SpanPanel userName;
	
	@UiField Image userImage;
	
	private static final String DEFAULT_USER_IMAGE = "../images/settings/setting-user-image.png";
	
	private static TeachStudentReportPopupWidgetUiBinder uiBinder = GWT
			.create(TeachStudentReportPopupWidgetUiBinder.class);

	interface TeachStudentReportPopupWidgetUiBinder extends
			UiBinder<Widget, TeachStudentReportPopupWidget> {
	}
	
	public TeachStudentReportPopupWidget(String userNameLbl, String gooruUId) {
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		this.setGlassEnabled(true);
		this.setPopupPosition(0, Window.getScrollTop()+50);
		this.show();
		setData(userNameLbl,gooruUId);
	}

	public void setData(String userNameLbl,String gooruUId) {
		panel.clear();
		userName.setText("Hello, "+userNameLbl+"!");
		userImage.setUrl(AppClientFactory.getLoggedInUser().getProfileImageUrl()+gooruUId+".png");
		userImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				userImage.setUrl(DEFAULT_USER_IMAGE);
			}
		});
		String pageType = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSPAGE_REPORT_TYPE, UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW);
		if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_VIEW)) {
			popupTitle.setText("Course View");
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_UNIT_VIEW)) {
			popupTitle.setText("Unit View");
		} else if(pageType.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LESSON_VIEW)) {
			popupTitle.setText("Assessment View");
		}
		panel.add(new TeachStudentReportPopupChildView(userNameLbl,gooruUId));
	}
	
	@UiHandler("closeButton")
	public void CloseButton(ClickEvent event) {
		this.hide();
	}
	
}