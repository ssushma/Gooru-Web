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
/**
 * 
 */
package org.ednovo.gooru.client.gin;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
/**
 * 
 * @fileName : BaseViewWithHandlers.java
 *
 * @description :  Base class for a {@link View} that implements the {@link HasUiHandlers}  interface.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class BaseViewWithHandlers<H extends BaseUiHandlers> extends ViewWithUiHandlers<H> implements IsViewWithHandlers<H> {

	private Widget widget;
	/**
	 * Gets as a widget.
	 * @return {@link Widget}
	 */
	@Override
	public Widget asWidget() {
		return widget;
	}
	/**
	 * Gets the widget.
	 * @return {@link Widget}
	 */
	public Widget getWidget() {
		return widget;
	}
	/**
	 * Sets the widget.
	 * @param {@link Widget}
	 */
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	@Override
	public void reset() {
	}
	
	@Override
	public void onUnload() {
		
	}
	
	@Override
	public void onLoad() {
	}


}
