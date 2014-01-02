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

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LeftToolTipWidgetUc.java
 *
 * @description : This is left tooltip popup widget.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LeftToolTipWidgetUc extends FocusPanel implements MouseOverHandler, MouseOutHandler {

	private LeftToolTipUc tooltipPopUpUc;

	/**
	 * Class constructor
	 */
	public LeftToolTipWidgetUc() {
		addDomHandler(this, MouseOutEvent.getType());
		addDomHandler(this, MouseOverEvent.getType());
	}

	/**
	 * Class constructor with two parameter
	 * @param widget instance of {@link Widget}
	 * @param toolTipWidget instance of {@link Widget}
	 */
	public LeftToolTipWidgetUc(Widget widget, Widget toolTipWidget) {
		this();
		setWidget(widget);
		setToolTipWidget(toolTipWidget);
	}
	
	@UiChild(tagname="widget")
	public void setWidget(Widget widget) {
		super.setWidget(widget);
	}

	@UiChild(tagname="toolTipWidget")
	public void setToolTipWidget(Widget toolTipWidget) {
		if (toolTipWidget != null) {
			tooltipPopUpUc = new LeftToolTipUc();
			tooltipPopUpUc.setContent(toolTipWidget);
		}
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		if (tooltipPopUpUc != null) {
			tooltipPopUpUc.hide();
		}
	}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		if (tooltipPopUpUc != null && !tooltipPopUpUc.isShowing()) {
			tooltipPopUpUc.show();
			tooltipPopUpUc.setPopupPosition(getAbsoluteLeft()-tooltipPopUpUc.getOffsetWidth(), getAbsoluteTop() + (getOffsetHeight() / 2));
		}
	}

}
