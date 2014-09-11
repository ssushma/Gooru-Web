/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.LiPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author janamitra
 *
 */
public class UnitWidget extends Composite implements HasClickHandlers{

	private static UnitWidgetUiBinder uiBinder = GWT
			.create(UnitWidgetUiBinder.class);

	interface UnitWidgetUiBinder extends UiBinder<Widget, UnitWidget> {
	}
	
 	@UiField InlineLabel ilUnitNumber,ilUnitName;
 	
 	@UiField HTMLEventPanel unitNameContainer;
 	
 	@UiField LiPanel liPanelUnit;
 	
 	
 	private String unitGooruOid=null;
 	
 	
 	UnitAssignmentCssBundle res;

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
	public UnitWidget(String serialNumber, String unitName,String unitGooruOid) {
		initWidget(uiBinder.createAndBindUi(this));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		ilUnitNumber.setText(serialNumber);
		ilUnitName.setText(unitName);
		this.unitGooruOid=unitGooruOid;
	}
	
	/**
	 * @return the htPanelUnit
	 */
	public HTMLEventPanel getUnitNameContainer() {
		return unitNameContainer;
	}

	/**
	 * @return the liPanelUnit
	 */
	public LiPanel getLiPanelUnit() {
		return liPanelUnit;
	}
	
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	
	public String getUnitGooruOid(){
		return unitGooruOid;
	}

}
