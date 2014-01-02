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

import org.ednovo.gooru.shared.model.user.FilterSettings;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.ViewImpl;
/**
 * 
 * @fileName : BaseView.java
 *
 * @description :  Handles all the UI-related code for a {@link Presenter}.
 *
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class BaseView extends ViewImpl implements IsView {

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
	/**
	 * Resets
	 */
	@Override
	public void reset() {
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @function getSettings 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method will check the is the user logged in or not.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : FilterSettings
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	protected FilterSettings getSettings() {
		return AppClientFactory.getLoggedInUser() != null ? AppClientFactory.getLoggedInUser().getSettings() : null;
	}

}
