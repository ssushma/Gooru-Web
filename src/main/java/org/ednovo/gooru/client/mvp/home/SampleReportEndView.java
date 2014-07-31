package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class SampleReportEndView extends PopupPanel {

	private static SampleReportEndViewUiBinder uiBinder = GWT
			.create(SampleReportEndViewUiBinder.class);

	interface SampleReportEndViewUiBinder extends
			UiBinder<Widget, SampleReportEndView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	@UiField
	HTMLPanel imageContainer;
	@UiField
	Label lblsummaryText, lblCollectionProgress, lblCollectionProgressDetails,
			lblHeading;
	@UiField
	Image leftImage,bgImage;
	@UiField
	HTMLEventPanel cancelButton;

	public SampleReportEndView() {
		setWidget(uiBinder.createAndBindUi(this));
		this.setStyleName("reportPopup");
		this.setGlassEnabled(true);
		this.show();
		this.center();
		Window.enableScrolling(false);
		setUiField();
		this.getElement().getStyle().setZIndex(99999);
	}

	private void setUiField() {
		lblsummaryText
				.setText("These are some of the reports you will able to see for students in your class.");
		lblCollectionProgress.setText(i18n.GL1586());
		lblCollectionProgressDetails
				.setText("See your students' real-time progress through the collections you've assigned.");
	//	rightImage.setUrl("images/landing-page/nextArrow.png");
		leftImage.setUrl("images/landing-page/previousArrow.png");
		lblHeading.setText("Sample Reports");
		bgImage.setUrl("images/landing-page/collectionSummary3.png");
		bgImage.getElement().setAttribute("style", "width:100%");
		
	}

	@UiHandler("leftImage")
	public void rightImageClick(ClickEvent event) {
		this.hide();
		SampleReportNextView sampleReportNextView = new SampleReportNextView();
	}

	@UiHandler("cancelButton")
	public void cancelButtonClick(ClickEvent event) {
		this.hide();
		Window.enableScrolling(true);
	}
}
