package org.ednovo.gooru.client.mvp.play.collection.flag;

import org.ednovo.gooru.player.collection.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class FlagThankYouPopUpView extends PopupPanel implements MessageProperties
		 {

	private static ThankYouCollectionCoverPageToolTipUiBinder uiBinder = GWT
			.create(ThankYouCollectionCoverPageToolTipUiBinder.class);

	interface ThankYouCollectionCoverPageToolTipUiBinder extends
			UiBinder<Widget, FlagThankYouPopUpView> {
	}
	@UiField
	HTMLEventPanel closeButton;
	@UiField
	Image popUpCloseButton;
	@UiField Button okButton;
	@UiField Label flagHeaderText,thanksSubmitText;
	public FlagThankYouPopUpView() {
		super(false);
		FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setZIndex(999999);
		this.setGlassStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().glassStyle());
		setGlassEnabled(true);
		flagHeaderText.setText(GL0600);
		thanksSubmitText.setText(GL0615);
		popUpCloseButton.setResource(FlagBundle.IMAGEBUNDLEINSTANCE
				.closeFlagPopUpImages());
		okButton.setText(GL0190);
		okButton.getElement().setAttribute("id","okButton");
	}
	
	public HTMLEventPanel getCloseButton(){
		return closeButton;
	}
	public Button getOkButton(){
		return okButton;
	}
	

}
