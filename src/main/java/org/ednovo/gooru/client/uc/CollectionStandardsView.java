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
package org.ednovo.gooru.client.uc;


import java.util.List;

import org.ednovo.gooru.shared.model.content.StandardFo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : CollectionStandardsView.java
 *
 * @description : This class is used to display the collection standards view.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionStandardsView extends Composite implements HasClickHandlers{
	
	
	@UiField FlowPanel standardContainer;
	
	ToolTipPopUp toolTip ;
	
	private static CollectionStandardsViewUiBinder uiBinder = GWT.create(CollectionStandardsViewUiBinder.class);

	interface CollectionStandardsViewUiBinder extends UiBinder<Widget, CollectionStandardsView> {
	}
	/**
	 * Class constructor.
	 */
	public CollectionStandardsView(){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
	}
	
	@UiConstructor
	public CollectionStandardsView(List<StandardFo> standardsList){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		renderStandards(standardsList);
	}
	/**
	 * This will add the click event.
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
	/**
	 * @function renderStandards 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :  This will render the all the standards.
	 * 
	 * @parm(s) : @param standardsList
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void renderStandards(List<StandardFo> standardsList){
		for(int i=0;i<standardsList.size();i++){
			Label standardText=new Label(standardsList.get(i).getCode());
			standardText.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().standardText());
			standardContainer.add(standardText);
			standardText.addMouseOverHandler(new MouseOverShowStandardToolTip(standardsList.get(i).getDescription()));
			standardText.addMouseOutHandler(new MouseOutHideToolTip());
		}
	}
	/**
	 * This inner class is used to handle the mouse over handler.
	 */
	public class MouseOverShowStandardToolTip implements MouseOverHandler
	{
		String desc=null;
		
		public MouseOverShowStandardToolTip(String description) {
			this.desc = description;
		}
		
		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTip = new ToolTipPopUp(desc, (event.getRelativeElement().getAbsoluteLeft()-45),(event.getRelativeElement().getAbsoluteTop()-140));
			toolTip.popupArrow.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setPopupArrow());
			toolTip.show();
		}
	}
	/**
	 * This inner class is used to handle the mouse out handler.
	 */
	public class MouseOutHideToolTip implements MouseOutHandler
	{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTip.hide();
			 
		}
		
	}
	
}
