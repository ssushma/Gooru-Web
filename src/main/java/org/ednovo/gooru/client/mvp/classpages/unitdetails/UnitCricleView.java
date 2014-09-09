package org.ednovo.gooru.client.mvp.classpages.unitdetails;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class UnitCricleView extends Composite implements HasClickHandlers{

	private static UnitCricleViewUiBinder uiBinder = GWT
			.create(UnitCricleViewUiBinder.class);

	interface UnitCricleViewUiBinder extends UiBinder<Widget, UnitCricleView> {
	}
	
	/*@UiField(provided = true)
	UnitAssignmentCssBundle res;*/
	
	@UiField InlineLabel unitNumber;
	@UiField HTMLPanel bubbleOuterPanel;
	
	@UiField FlowPanel bubbleMain;
	
	boolean isRequired; 
		
	public UnitCricleView(boolean isRequired,int unitCircleNumber) {
		/*this.res = UnitAssignmentCssBundle.INSTANCE;
		res.css().ensureInjected();*/
		this.isRequired=isRequired;
		
		initWidget(uiBinder.createAndBindUi(this));
		unitNumber.setText(unitCircleNumber+"");
		//bubbleMain.setStyleName(res.css().bubbleMain());
		showCircle();
		
	}
	public void selectcircle()
	{
	//	bubbleOuterPanel.addStyleName(res.css().active());
		
	}
	public void deSelectcircle()
	{
		//bubbleOuterPanel.removeStyleName(res.css().active());	
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
		
	}
	/*
	 * This method is used to display optional Circle
	 */
	public void displayOptionalCircle()
	{
		
	}
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
}
