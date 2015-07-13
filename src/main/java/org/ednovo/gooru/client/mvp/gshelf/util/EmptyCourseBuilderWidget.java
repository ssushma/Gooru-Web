package org.ednovo.gooru.client.mvp.gshelf.util;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.H1Panel;
import org.ednovo.gooru.client.uc.suggestbox.widget.Paragraph;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class EmptyCourseBuilderWidget extends Composite {

	private static EmptyCourseBuilderWidgetUiBinder uiBinder = GWT
			.create(EmptyCourseBuilderWidgetUiBinder.class);

	interface EmptyCourseBuilderWidgetUiBinder extends
			UiBinder<Widget, EmptyCourseBuilderWidget> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel pnlCourseGetting;
	@UiField Button btnCreateCourse;
	@UiField H1Panel pnlH1Title;
	@UiField Paragraph pCreateFirstCourse,pCreateText;
	@UiField Anchor lnkTextMyContent;

	public EmptyCourseBuilderWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		pnlCourseGetting.getElement().setId("coursesGetting");
		pnlCourseGetting.setHeight(Window.getClientHeight()+"px");
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				pnlCourseGetting.setHeight(Window.getClientHeight()+"px");
			}
		});
		pnlH1Title.setText(i18n.GL1288());
		StringUtil.setAttributes(pnlH1Title.getElement(), i18n.GL1288(), i18n.GL1288());
		
		pCreateFirstCourse.setText(i18n.GL3391());
		StringUtil.setAttributes(pCreateFirstCourse.getElement(), i18n.GL3391(), i18n.GL3391());
		
		pCreateText.setText(i18n.GL3392());
		StringUtil.setAttributes(pCreateText.getElement(), i18n.GL3392(), i18n.GL3392());
		
		lnkTextMyContent.setText(i18n.GL3393());
		StringUtil.setAttributes(lnkTextMyContent.getElement(), i18n.GL3393(), i18n.GL3393());
	}
	@UiHandler("btnCreateCourse")
	public void createCourseClick(ClickEvent e){
		onClick();
	}
	public abstract void onClick();
}
