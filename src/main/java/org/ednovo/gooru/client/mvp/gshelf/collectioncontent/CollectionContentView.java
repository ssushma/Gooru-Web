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

import java.util.Iterator;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
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
	String type;
	
	public CollectionContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlContentContainer.getElement().setId("resourceEdit");
	}
	
	@Override
	public void setData(CollectionDo listOfContent,FolderDo folderDo){
		index=0;
		if(listOfContent.getCollectionItems().size()>0){
			for (CollectionItemDo collectionItem : listOfContent.getCollectionItems()) {
				ContentResourceWidgetWithMove widgetMove=new ContentResourceWidgetWithMove(index,collectionItem) {
					@Override
					public void moveWidgetPosition(String movingPosition,String currentWidgetPosition, boolean isDownArrow, String moveId) {
						int movingIndex= Integer.parseInt(movingPosition);
						if(pnlReosurceList.getWidgetCount()>=movingIndex){
							//Based on the position it will insert the widget in the vertical panel
							String itemSequence=pnlReosurceList.getWidget(movingIndex-1).getElement().getAttribute("itemSequence");
							getUiHandlers().reorderWidgetPositions(moveId, Integer.parseInt(itemSequence));
							if(!isDownArrow){
								movingIndex= (movingIndex-1);
								int currentIndex= Integer.parseInt(currentWidgetPosition);
								pnlReosurceList.insert(pnlReosurceList.getWidget(currentIndex), movingIndex);
							}else{
								int currentIndex= Integer.parseInt(currentWidgetPosition);
								pnlReosurceList.insert(pnlReosurceList.getWidget(currentIndex), movingIndex);
							}
						}
					}
				}; 
				widgetMove.getElement().setAttribute("itemSequence", collectionItem.getItemSequence()+"");
				pnlReosurceList.add(widgetMove);
				index++;
			}
			setLastWidgetArrowVisiblity(false);
		}
	}
	/**
	 * On pagination it will enable the previous widget down arrow for move functionality
	 * @param isVisible
	 */
	public void setLastWidgetArrowVisiblity(boolean isVisible){
		ContentResourceWidgetWithMove lastwidget=(ContentResourceWidgetWithMove) pnlReosurceList.getWidget(pnlReosurceList.getWidgetCount()-1);
		lastwidget.getDownArrow().setVisible(isVisible);
	}
	/**
	 * This method is used to reset the widget positions with default text.
	 */
	@Override
	public void resetWidgetPositions(){
		Iterator<Widget> widgets=pnlReosurceList.iterator();
		int index=0;
		while (widgets.hasNext()){
			Widget widget=widgets.next();
			if(widget instanceof ContentResourceWidgetWithMove){
				ContentResourceWidgetWithMove contentWidgetWithMove=(ContentResourceWidgetWithMove) widget;
				contentWidgetWithMove.getElement().setAttribute("itemSequence",Integer.toString((index+1)));
				contentWidgetWithMove.getItemSequenceLabel().setText(Integer.toString((index+1)));
				contentWidgetWithMove.getTextBox().setText((index+1)+"");
				contentWidgetWithMove.getTextBox().getElement().setAttribute("index",index+"");
				if(index==0){
					//If this is the first widget we are hiding the up arrow
					contentWidgetWithMove.getTopArrow().setVisible(false);
				}else if(index==(pnlReosurceList.getWidgetCount()-1)){
					//If this the last widget hiding the down arrow
					contentWidgetWithMove.getDownArrow().setVisible(false);
				}else{
					contentWidgetWithMove.getTopArrow().setVisible(true);
					contentWidgetWithMove.getDownArrow().setVisible(true);
				}
				index++;
			}
		}
	}
}
