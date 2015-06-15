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
package org.ednovo.gooru.client.mvp.gshelf.righttabs;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyCollectionsRightClusterView extends BaseViewWithHandlers<MyCollectionsRightClusterUiHandlers> implements IsMyCollectionsRightClusterView,ClientConstants  {

	private static MyCollectionsRightViewUiBinder uiBinder = GWT.create(MyCollectionsRightViewUiBinder.class);

	interface MyCollectionsRightViewUiBinder extends UiBinder<Widget, MyCollectionsRightClusterView> {
	}
	
	@UiField HTMLPanel mainPanel,pnlSlotInnerContent;
	
	public MyCollectionsRightClusterView() {
		setWidget(uiBinder.createAndBindUi(this));
		mainPanel.getElement().setId("gShelfCourseInfo");
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		pnlSlotInnerContent.clear();
		if(content!=null){
			if(slot==MyCollectionsRightClusterPresenter.INNER_SLOT){
				pnlSlotInnerContent.add(content);
			 }
		}
	}
}
