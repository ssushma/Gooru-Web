package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
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

public class SampleReportNextView extends PopupPanel {

	private static SampleReportNextViewUiBinder uiBinder = GWT
			.create(SampleReportNextViewUiBinder.class);

	interface SampleReportNextViewUiBinder extends
			UiBinder<Widget, SampleReportNextView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	@UiField
	HTMLPanel imageContainer;
	@UiField
	Label lblsummaryText, lblCollectionProgress, lblCollectionProgressDetails,
			lblHeading;
	@UiField
	Image rightImage, leftImage,bgImage;
	@UiField
	HTMLEventPanel cancelButton;

	public SampleReportNextView() {
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.setHeight("603px");
		this.show();
		this.center();
		Window.enableScrolling(false);
		setUiField();
		this.getElement().getStyle().setZIndex(99999);
	}

	private void setUiField() {
		lblsummaryText
				.setText("These are some of the reports you will be able to see for students in your class.");
		lblCollectionProgress.setText(i18n.GL1587());
		lblCollectionProgressDetails
				.setText("See how your class is performing on each question.");
		rightImage.setUrl("");
		lblHeading.setText("Sample Reports");
		bgImage.setUrl("images/landing-page/collectionSummary2.png");
		rightImage.setUrl("images/landing-page/nextArrow.png");
		leftImage.setUrl("images/landing-page/previousArrow.png");
		bgImage.getElement().setAttribute("style", "width:100%");
	}

	@UiHandler("rightImage")
	public void rightImageClick(ClickEvent event) {
		this.hide();
		SampleReportEndView sampleReportEndView = new SampleReportEndView();
	}

	@UiHandler("leftImage")
	public void leftImageClick(ClickEvent event) {
		this.hide();
		SampleReportView sampleReportView = new SampleReportView();
	}

	@UiHandler("cancelButton")
	public void cancelButtonClick(ClickEvent event) {
		this.hide();
		Window.enableScrolling(true);
	}
}
