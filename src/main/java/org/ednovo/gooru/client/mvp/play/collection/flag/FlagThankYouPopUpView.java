package org.ednovo.gooru.client.mvp.play.collection.flag;

import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class FlagThankYouPopUpView extends PopupPanel
		 {

	private static ThankYouCollectionCoverPageToolTipUiBinder uiBinder = GWT
			.create(ThankYouCollectionCoverPageToolTipUiBinder.class);

	interface ThankYouCollectionCoverPageToolTipUiBinder extends
			UiBinder<Widget, FlagThankYouPopUpView> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
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
		this.setWidth("418px");
		this.setHeight("162px");
		flagHeaderText.setText(i18n.GL0600());
		flagHeaderText.getElement().setId("lblFlagHeaderText");
		flagHeaderText.getElement().setAttribute("alt",i18n.GL0600());
		flagHeaderText.getElement().setAttribute("title",i18n.GL0600());
		  
		thanksSubmitText.setText(i18n.GL0615());
		thanksSubmitText.getElement().setId("lblThanksSubmitText");
		thanksSubmitText.getElement().setAttribute("alt",i18n.GL0615());
		thanksSubmitText.getElement().setAttribute("title",i18n.GL0615());
		
		popUpCloseButton.setResource(FlagBundle.IMAGEBUNDLEINSTANCE
				.closeFlagPopUpImages());
		popUpCloseButton.getElement().setId("imgPopUpCloseButton");
		
		okButton.setText(i18n.GL0190());
		okButton.getElement().setAttribute("id","okButton");
		okButton.getElement().setAttribute("alt",i18n.GL0190());
		okButton.getElement().setAttribute("title",i18n.GL0190());
		
		closeButton.getElement().setId("epnlCloseButton");
	}
	
	public HTMLEventPanel getCloseButton(){
		return closeButton;
	}
	public Button getOkButton(){
		return okButton;
	}
	

}
