
/**
 * 
 */
package org.ednovo.gooru.client.uc.tooltip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : GlobalTooltipWithButton.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author: Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class GlobalTooltipWithButton extends PopupPanel implements HasMouseOutHandlers{

	private static GlobalTooltipWithButtonUiBinder uiBinder = GWT
			.create(GlobalTooltipWithButtonUiBinder.class);

	interface GlobalTooltipWithButtonUiBinder extends
	UiBinder<Widget, GlobalTooltipWithButton> {
	}


	@UiField
	Label desLbl,headerText;

	@UiField
	HTMLPanel panelArrow;

	@UiField
	Button btnConfirm;
	
	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public GlobalTooltipWithButton() {
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		headerText.removeFromParent();
		show();
		setPanelPosition();
	}
	public GlobalTooltipWithButton(String description, String btnName){
        setWidget(uiBinder.createAndBindUi(this));
		desLbl.setText(description);
		btnConfirm.setText(btnName);
		headerText.removeFromParent();
		setGlassEnabled(true);
		show();
		setPanelPosition();
	}
	
	public GlobalTooltipWithButton(String header,String description, String btnName){
        setWidget(uiBinder.createAndBindUi(this));
		desLbl.setText(description);
		btnConfirm.setText(btnName);
		headerText.setText(header);
		setGlassEnabled(true);
		show();
		setPanelPosition();
	}

	public void setPanelPosition(){
		panelArrow.getElement().getStyle().setPosition(Position.ABSOLUTE);
	}

	@UiHandler("btnConfirm")
	public void clickOnOkButton(ClickEvent clickEvent){
		hide();
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}
	
	public Button getCloseButton(){
		return btnConfirm;
	}

}
