package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.H4Panel;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class PublishConfirmationPopup extends PopupPanel {

	@UiField H4Panel h3PanelDataTitle, h3PanelDataDesc;
	
	@UiField Button btnNegitive, btnPositive;
	
	@UiField Label lblTitle,lblRemoving;
	
	@UiField HTMLPanel popupSteps;

	@UiTemplate("PublishConfirmationPopup.ui.xml")
	interface Binder extends UiBinder<Widget, PublishConfirmationPopup> {}
	
	private static final Binder binder = GWT.create(Binder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public PublishConfirmationPopup() {
		super(false);
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);
		popupSteps.getElement().setId("popupSteps");
		popupSteps.setWidth("650px");
		btnNegitive.setText(StringUtil.generateMessage(i18n.GL0142()));
		btnNegitive.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0142()));
		btnNegitive.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0142()));
		
		btnPositive.setText(StringUtil.generateMessage(i18n.GL0190()));
		btnPositive.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL0190()));
		btnPositive.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL0190()));
		
		lblRemoving.setVisible(false);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		this.center();

	}
	
	public void setPositiveButtonText(String text) {
		btnPositive.setText(text);
		btnPositive.getElement().setAttribute("alt",text);
		btnPositive.getElement().setAttribute("title",text);
	}
	
	public void setNegitiveButtonText(String text) {
		btnNegitive.setText(text);
		btnNegitive.getElement().setAttribute("alt",text);
		btnNegitive.getElement().setAttribute("title",text);
	}
	
	public void setPleaseWaitText(String text){
		lblRemoving.setText(text);
		lblRemoving.getElement().setAttribute("alt",text);
		lblRemoving.getElement().setAttribute("title",text);
	}
	
	public void setPopupTitle(String title) {
		lblTitle.setText(title);
		lblTitle.getElement().setAttribute("alt",title);
		lblTitle.getElement().setAttribute("title",title);
	}
	
	private void setButtonVisibility(boolean visibility) {
		btnPositive.setVisible(visibility);
		btnNegitive.setVisible(visibility);
	}
	
	public void setH3Data(String title, String desc) {
		if(title!=null) {
			h3PanelDataTitle.setText(title);
		} else {
			h3PanelDataTitle.setVisible(false);
		}
		if(desc!=null) {
			h3PanelDataDesc.setText(desc);
		} else {
			h3PanelDataDesc.setVisible(false);
		}
	}
	
	@UiHandler("btnPositive")
	public void onPostitiveClickEvent(ClickEvent event){
		if (lblRemoving.getText()!=null && !lblRemoving.getText().equalsIgnoreCase("")){
			showIsRemoving();
			setButtonVisibility(false);
		}
		onClickPositiveButton(null);
	}

	@UiHandler("btnNegitive")
	public void onNegitiveClickEvent(ClickEvent event){
		onClickNegitiveButton(event);
	}
	
	@UiHandler("closeBtn")
	public void onColseButtonClicked(ClickEvent event){
		hide();
		Window.enableScrolling(true);
	}
	
	public void showIsRemoving() {
		lblRemoving.setVisible(true);
	}
	
	public abstract void onClickPositiveButton(ClickEvent event);

	public abstract void onClickNegitiveButton(ClickEvent event);
	
}