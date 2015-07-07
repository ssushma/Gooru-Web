package org.ednovo.gooru.client.mvp.gshelf.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AssessmentPopupWidget extends PopupPanel {

	private static AssessmentPopupWidgetUiBinder uiBinder = GWT
			.create(AssessmentPopupWidgetUiBinder.class);

	interface AssessmentPopupWidgetUiBinder extends
			UiBinder<Widget, AssessmentPopupWidget> {
	}

	@UiField HTMLPanel pnlMainContainer;
	@UiField InlineLabel spnClose;
	@UiField Button btnCreateNormalAssessment,btnCreateExternalAssessment;
	
	public AssessmentPopupWidget() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlMainContainer.getElement().setId("addAssessmentPopup");
	}
	@UiHandler("btnCreateNormalAssessment")
	public void clickOnNormalAssessment(ClickEvent event){
		clickOnNoramlAssessmentClick();
	}
	@UiHandler("btnCreateExternalAssessment")
	public void clickOnExternalAssessment(ClickEvent event){
		clickOnExternalAssessmentClick();
	}
	@UiHandler("spnClose")
	public void clickOnClose(ClickEvent event){
		AssessmentPopupWidget.this.hide();
	}
	public abstract void clickOnNoramlAssessmentClick();
	public abstract void clickOnExternalAssessmentClick();
}
