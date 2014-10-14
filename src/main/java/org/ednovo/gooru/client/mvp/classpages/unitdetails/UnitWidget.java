/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.util.StringUtil;

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
*
* @description : This class used to show Units in Assignments page.
*
* @version :1.1
*
* @date: Sep 8 2014
   	
* @Author Gooru Team
* 
* Reviewer Gooru Team
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
 	
 	private String unitCollectionItemId=null;
 	
 	private String unitNmae=null;
 	
 	ClassUnitsListDo classUnitDo;
 	
 	
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
	public UnitWidget(ClassUnitsListDo classUnitDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.classUnitDo=classUnitDo;
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		this.unitGooruOid=classUnitDo.getResource().getGooruOid();
		this.unitCollectionItemId=classUnitDo.getCollectionItemId();
		this.unitNmae=classUnitDo.getResource().getTitle();
		ilUnitNumber.setText(""+classUnitDo.getItemSequence());
		ilUnitName.setText(classUnitDo.getResource().getTitle());
		setElementIds();
	}
	
	/**
	 * To set the Ids
	 */
	private void setElementIds() {
		StringUtil.setAttributes(ilUnitNumber.getElement(), "ilUnitNumber", null, ilUnitNumber.getText());
		StringUtil.setAttributes(ilUnitName.getElement(), "ilUnitName", null, ilUnitName.getText());
		StringUtil.setAttributes(liPanelUnit.getElement(), "liPanelUnit", null, null);
		StringUtil.setAttributes(unitNameContainer.getElement(), "unitNameContainer", null, null);
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

	public String getUnitCollectionItemId() {
		return unitCollectionItemId;
	}

	/**
	 * @return the classUnitDo
	 */
	public ClassUnitsListDo getClassUnitDo() {
		return classUnitDo;
	}

	public String getUnitNmae() {
		return unitNmae;
	}

	public void setUnitNmae(String unitNmae) {
		this.unitNmae = unitNmae;
	}
}
