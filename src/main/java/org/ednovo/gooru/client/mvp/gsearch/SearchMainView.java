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

package org.ednovo.gooru.client.mvp.gsearch;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @fileName : SearchMainView.java
 *
 * @description :
 *
 * @version : 1.3
 *
 * @date: 10-04-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class SearchMainView extends BaseViewWithHandlers<SearchMainUiHandlers>
		implements IsSearchMainView {

	private static SearchMainViewUiBinder uiBinder = GWT
			.create(SearchMainViewUiBinder.class);

	interface SearchMainViewUiBinder extends UiBinder<Widget, SearchMainView> {
	}

	private static MessageProperties i18n = GWT.create(MessageProperties.class);


	@UiField HTMLPanel gooruSearchMainContainer,searchResultPanel;

	@UiField SimplePanel preferenceFiltersPanel;




	public SearchMainView() {
		setWidget(uiBinder.createAndBindUi(this));
		gooruSearchMainContainer.getElement().setId("gooruSearchMainContainer");
		searchFeildsIds();
	}
    /**
     * To set ids for all fields.
     */
	private void searchFeildsIds() {

	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == SearchMainPresenter.TYPE_VIEW) {
				preferenceFiltersPanel.clear();
				preferenceFiltersPanel.add(content);
			}
		}
	}

	@Override
	public String getSearchText() {
		return AppClientFactory.getPlaceManager().getRequestParameter("query");
	}

}
