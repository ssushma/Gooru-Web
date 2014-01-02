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

import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : GlobalToolTip.java
 *
 * @description : This class is used to display the global tooltips. 
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class GlobalToolTip extends Composite {
	
	@UiField
	HTMLEventPanel confirmationPanel;
	
	@UiField
	Label desLbl;
	
	@UiField
	HTMLPanel panelArrow;
	
	
	public interface GlobalToolTipUiBinder extends UiBinder<Widget, GlobalToolTip>{
	}
	
	public static GlobalToolTipUiBinder toolTipGlobalUiBinder=GWT.create(GlobalToolTipUiBinder.class);{
	}
	/**
	 * class constructor.
	 */
	public GlobalToolTip(){
		initWidget(toolTipGlobalUiBinder.createAndBindUi(this));
		setPanelPosition();
	}
	
	/**
	 * Class constructor.
	 * @param description
	 */
    public GlobalToolTip(String description){
		initWidget(toolTipGlobalUiBinder.createAndBindUi(this));
		desLbl.setText(description);

		setPanelPosition();
	}
    /**
     * @function setPanelPosition 
     * 
     * @created_date : 31-Dec-2013
     * 
     * @description : This method is used to set the panel position.
     * 
     * @parm(s) : 
     * 
     * @return : void
     *
     * @throws : <Mentioned if any exceptions>
     *
     */
    public void setPanelPosition(){
    	panelArrow.getElement().getStyle().setPosition(Position.ABSOLUTE);
    	/*if (AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.PROFILE_PAGE)){
			panelArrow.getElement().getStyle().setPosition(Position.ABSOLUTE);
		}else{
			panelArrow.getElement().getStyle().clearPosition();
		}*/
    }
	
}
