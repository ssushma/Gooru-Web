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

package org.ednovo.gooru.client.uc.tooltip;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;
import org.ednovo.gooru.shared.util.UAgentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : OrganizeToolTip.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author: Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class DashBoardToolTip extends PopupPanel implements HasMouseOutHandlers{
	
	private static DashBoardToolTipUiBinder uiBinder = GWT
			.create(DashBoardToolTipUiBinder.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class); 

	interface DashBoardToolTipUiBinder extends UiBinder<Widget, DashBoardToolTip> {
	}
	
	@UiField Label lblDashBoard;
	
	@UiField HTMLPanel tooltipPanel,panelCode;
	
	public DashBoardToolTip() {
		setWidget(uiBinder.createAndBindUi(this));
		
		lblDashBoard.setText("DashBoard");
		lblDashBoard.getElement().setId("lblDashBoard");
		lblDashBoard.getElement().setAttribute("alt", "DashBoard");
		lblDashBoard.getElement().setAttribute("title", "DashBoard");
		
		panelCode.getElement().setId("pnlPanelCode");
		tooltipPanel.getElement().setId("pnlTooltipPanel");
		
		  Boolean isIpad = !!Navigator.getUserAgent().matches("(.*)iPad(.*)");
		  Boolean isAndriod = !!Navigator.getUserAgent().matches("(.*)Android(.*)");
		  Boolean isWinDskp = !!Navigator.getUserAgent().matches("(.*)NT(.*)");
		  
		  UAgentInfo detector = new UAgentInfo(Navigator.getUserAgent());
		  
		  if(isIpad && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  tooltipPanel.getElement().setAttribute("style", "position:relative;top:-3px;");
		  }
		  else if(isAndriod && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  tooltipPanel.getElement().setAttribute("style", "position:relative;top:-3px;");
		  }		  
		  else
		  {
			  tooltipPanel.getElement().getStyle().setWidth(120, Unit.PX);
			  tooltipPanel.getElement().getStyle().setPosition(Position.FIXED);
		  }
		
		this.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
			    hide();
			}
		});
        
		lblDashBoard.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!AppClientFactory.isAnonymous()){
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.DASHBOARD);
				}
			}
		});
        
	}
	
	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return addDomHandler(handler, MouseOutEvent.getType());
	}
	
}