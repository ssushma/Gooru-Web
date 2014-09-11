package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class UnitCricleView extends Composite implements HasClickHandlers,HasMouseOverHandlers,HasMouseOutHandlers{

	private static UnitCricleViewUiBinder uiBinder = GWT
			.create(UnitCricleViewUiBinder.class);

	interface UnitCricleViewUiBinder extends UiBinder<Widget, UnitCricleView> {
	}
	
	@UiField InlineLabel unitNumber;
	@UiField HTMLPanel bubbleOuterPanel;
	boolean isRequired; 
		
	public UnitCricleView(boolean isRequired,int unitCircleNumber) {
		
		this.isRequired=isRequired;
		UnitAssignmentCssBundle.INSTANCE.unitAssignment().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		unitNumber.setText(unitCircleNumber+"");
		showCircle();
		
	}
	
	public void showCircle()
	{
		if(isRequired)
		{
			displayRequiredCircle();
		}else{
			displayOptionalCircle();
		}
	}
	/*
	 * This method is used to display required Circle
	 */
	public void displayRequiredCircle()
	{
		unitNumber.removeStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleOptional());
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleBig());
	}
	/*
	 * This method is used to display optional Circle
	 */
	public void displayOptionalCircle()
	{
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleBig());
		unitNumber.addStyleName(UnitAssignmentCssBundle.INSTANCE.unitAssignment().bubbleOptional());
	}
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return addDomHandler(handler, MouseOverEvent.getType());
	}
	
}
