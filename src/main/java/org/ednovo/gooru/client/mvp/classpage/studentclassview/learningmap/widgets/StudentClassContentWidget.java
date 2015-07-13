package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
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
	
	private final String DEFAULT_COLLECTION_IMAGE = "../images/default-collection-image-160x120.png";
	
	private final String DEFAULT_ASSESSMENT_IMAGE = "../images/default-assessment-image -160x120.png";

	private PopupPanel toolTipPopupPanel = new PopupPanel();
	
	private static StudentClassContentWidgetUiBinder uiBinder = GWT.create(StudentClassContentWidgetUiBinder.class);
	
	interface StudentClassContentWidgetUiBinder extends UiBinder<Widget, StudentClassContentWidget> {}
	
	public StudentClassContentWidget(final PlanProgressDo planDo, String contentStyle) {
		initWidget(uiBinder.createAndBindUi(this));
		String contentName = planDo.getTitle();
		contentPanel.addMouseOverHandler(new MouseOverShowClassCodeToolTip(contentName));
		contentPanel.addMouseOutHandler(new MouseOutHideToolTip());
		if(!contentStyle.isEmpty()) {
			contentPanel.addStyleName(contentStyle);
		}
		String url = "";
		imagePanel.setUrl(url);
		imagePanel.setHeight("55px");
		imagePanel.setWidth("75px");
		imagePanel.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				if(planDo.getType()!=null&&planDo.getType().equalsIgnoreCase("assessment")) {
					imagePanel.setUrl(DEFAULT_ASSESSMENT_IMAGE);
				} else {
					imagePanel.setUrl(DEFAULT_COLLECTION_IMAGE);
				}
			}
		});
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