package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.client.mvp.classpage.teach.edit.student.EditClassStudentView.MouseOutHideToolTip1;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.student.EditClassStudentView.MouseOverShowClassCodeToolTip1;
import org.ednovo.gooru.client.uc.SpanPanel;
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
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class StudentClassLearningMapCircle extends Composite {

	@UiField HTMLEventPanel circleField;
	@UiField SpanPanel spanTxt;
	private PopupPanel toolTipPopupPanel = new PopupPanel();
	
	private static StudentClassLearningMapCircleUiBinder uiBinder = GWT.create(StudentClassLearningMapCircleUiBinder.class);
	
	interface StudentClassLearningMapCircleUiBinder extends UiBinder<Widget, StudentClassLearningMapCircle> {}

	public StudentClassLearningMapCircle(String circleStyle) {
		initWidget(uiBinder.createAndBindUi(this));
		String lessonName = "Lesson 3: Fractions and Whole Numbers";
		circleField.addMouseOverHandler(new MouseOverShowClassCodeToolTip(lessonName));
		circleField.addMouseOutHandler(new MouseOutHideToolTip());
		if(!circleStyle.isEmpty()) {
			circleField.setStyleName(circleStyle);
		}
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
			toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft(), event.getRelativeElement().getAbsoluteTop()+25);
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