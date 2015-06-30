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
package org.ednovo.gooru.client.mvp.gshelf.collectioncontent;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.gshelf.util.ContentResourceWidgetWithMove;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CollectionContentView extends BaseViewWithHandlers<CollectionContentUiHandlers> implements IsCollectionContentView  {

	private static CollectionContentViewUiBinder uiBinder = GWT
			.create(CollectionContentViewUiBinder.class);

	interface CollectionContentViewUiBinder extends
			UiBinder<Widget, CollectionContentView> {
	}

	@UiField HTMLPanel pnlContentContainer;
	@UiField VerticalPanel pnlReosurceList;
	
	int index=0;
	
	public CollectionContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlContentContainer.getElement().setId("resourceEdit");
		index=0;
		for (int i = 0; i < 10; i++) {
			ContentResourceWidgetWithMove widgetMove=new ContentResourceWidgetWithMove(index) {
				@Override
				public void moveWidgetPosition(String movingPosition,String currentWidgetPosition, boolean isDownArrow, String moveId) {
					int movingIndex= Integer.parseInt(movingPosition);
					if(pnlReosurceList.getWidgetCount()>=movingIndex){
						//Based on the position it will insert the widget in the vertical panel
						String itemSequence=pnlContentContainer.getWidget(movingIndex-1).getElement().getAttribute("itemSequence");
						//getUiHandlers().reorderWidgetPositions(moveId, Integer.parseInt(itemSequence));
						if(!isDownArrow){
							movingIndex= (movingIndex-1);
							int currentIndex= Integer.parseInt(currentWidgetPosition);
							pnlReosurceList.insert(pnlContentContainer.getWidget(currentIndex), movingIndex);
						}else{
							int currentIndex= Integer.parseInt(currentWidgetPosition);
							pnlReosurceList.insert(pnlContentContainer.getWidget(currentIndex), movingIndex);
						}
					}
				}
			}; 
			//widgetMove.getElement().setAttribute("itemSequence", folderObj.getItemSequence()+"");
			pnlReosurceList.add(widgetMove);
			index++;
		}
	}
}
