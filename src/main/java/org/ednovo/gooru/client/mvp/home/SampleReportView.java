package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class SampleReportView extends PopupPanel {

	private static SampleReportViewUiBinder uiBinder = GWT
			.create(SampleReportViewUiBinder.class);

	interface SampleReportViewUiBinder extends
			UiBinder<Widget, SampleReportView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	@UiField
	HTMLPanel imageContainer,panelMain;
	@UiField
	FlowPanel bodyContainer;
	@UiField
	Label lblsummaryText, lblCollectionProgress, lblCollectionProgressDetails,
			lblHeading;
	@UiField
	Image rightImage,bgImage;
	@UiField
	HTMLEventPanel cancelButton;

	public SampleReportView() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		if (!BrowserAgent.isDevice()){
			this.setHeight("642px");
			int clientHeight = Window.getClientHeight();
			int marginTop = (clientHeight - 642) / 2;
			
			panelMain.getElement().getStyle().setMarginTop(marginTop <0 ? 0 : marginTop, Unit.PX);
		}
		this.show();
		Window.enableScrolling(false);
		setUiField();
		this.getElement().getStyle().setZIndex(99999);
		this.center();


	}

	private void setUiField() {
		lblsummaryText.setText("These are some of the reports you will be able to see for students in your class.");
		lblCollectionProgress.setText(i18n.GL1586());
		lblCollectionProgressDetails.setText("See your students' real-time progress through the collections you've assigned.");
		bgImage.setUrl("images/landing-page/sampleReports1.png");
		bgImage.getElement().setAttribute("style", "width:100%");
		rightImage.setUrl("images/landing-page/nextArrow.png");
		lblHeading.setText("Sample Reports");
	}

	@UiHandler("rightImage")
	public void rightImageClick(ClickEvent event) {
		this.hide();
		SampleReportNextView sampleReportView = new SampleReportNextView();
	}

	@UiHandler("cancelButton")
	public void cancelButtonClick(ClickEvent event) {
		this.hide();
		Window.enableScrolling(true);
	}
}
