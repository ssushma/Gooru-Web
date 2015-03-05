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
package org.ednovo.gooru.client.mvp.dashboard;

/**
 * @fileName : PopupForAnalyticsPresenter.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: Dec 8, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
import javax.inject.Inject;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class PopupForAnalyticsPresenter extends PresenterWidget<IsPopupForAnalyticsView> implements PopupForAnalyticsUiHandlers {
		 public interface MyView extends PopupView {
		 }

		 /**
		  * Constructor
		 * @param eventBus
		 * @param view
		 */
		@Inject
		 public PopupForAnalyticsPresenter(EventBus eventBus, IsPopupForAnalyticsView view) {
				super(eventBus, view);
				getView().setUiHandlers(this);
		 }

		/* (non-Javadoc)
		 * @see org.ednovo.gooru.client.mvp.dashboard.PopupForAnalyticsUiHandlers#setPopupData()
		 */
		@Override
		public void setPopupData(String isEndorsedOrRemixed,String isReactionOrRatings) {
			getView().setPopupData(isEndorsedOrRemixed,isReactionOrRatings);
		}
}
