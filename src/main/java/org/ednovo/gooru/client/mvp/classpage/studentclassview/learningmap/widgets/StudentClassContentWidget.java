package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets.StudentClassLearningMapCircle.MouseOutHideToolTip;
import org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets.StudentClassLearningMapCircle.MouseOverShowClassCodeToolTip;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class StudentClassContentWidget extends Composite {

	@UiField HTMLEventPanel contentPanel;
	@UiField Image imagePanel;
	
	private PopupPanel toolTipPopupPanel = new PopupPanel();
	
	private static StudentClassContentWidgetUiBinder uiBinder = GWT.create(StudentClassContentWidgetUiBinder.class);
	
	interface StudentClassContentWidgetUiBinder extends UiBinder<Widget, StudentClassContentWidget> {}
	
	public StudentClassContentWidget(String circleStyle, String url) {
		initWidget(uiBinder.createAndBindUi(this));
		String contentName = "Collection 1: Fractions";
		contentPanel.addMouseOverHandler(new MouseOverShowClassCodeToolTip(contentName));
		contentPanel.addMouseOutHandler(new MouseOutHideToolTip());
		if(!circleStyle.isEmpty()) {
			contentPanel.addStyleName(circleStyle);
		}
		imagePanel.setUrl(url);
		imagePanel.setHeight("55px");
		imagePanel.setWidth("75px");
	}
	
	public class MouseOverShowClassCodeToolTip implements MouseOverHandler{
		private String label = null;
		public MouseOverShowClassCodeToolTip(String label) {
			this.label = label;
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new GlobalToolTip(label));
			toolTipPopupPanel.setStyleName("");
			toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft()+50, event.getRelativeElement().getAbsoluteTop()+40);
			toolTipPopupPanel.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanel.show();
		}
	}
	
	public class MouseOutHideToolTip implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanel.hide();
		}
	}

}