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

import org.apache.bcel.generic.LSTORE;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.util.ContentResourceWidgetWithMove;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceHandler;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
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
	@UiField Button btnAddResources, btnAddQuestions;
	@UiField Anchor ancAddResource, ancAddQuestion;

	CollectionContentPresenter collectionContentPresenter;
	CollectionDo listOfContent=null;

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	int index=0;
	String type;
	private String clickType;

	public CollectionContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlContentContainer.getElement().setId("resourceEdit");

		StringUtil.setAttributes(btnAddResources.getElement(), "btnAddResources", i18n.GL_SPL_PLUS() +" "+ i18n.GL0174(), i18n.GL_SPL_PLUS() +" "+ i18n.GL0174());
		StringUtil.setAttributes(btnAddQuestions.getElement(), "btnAddQuestions", i18n.GL_SPL_PLUS() +" "+ i18n.GL1042(), i18n.GL_SPL_PLUS() +" "+ i18n.GL1042());

		//Adding Click Handlers.
		btnAddResources.addClickHandler(new NewResourceClickEvent());
		btnAddQuestions.addClickHandler(new NewQuestionClickEvent());

		ancAddResource.addClickHandler(new NewResourceClickEvent());
		ancAddQuestion.addClickHandler(new NewQuestionClickEvent());

		addRegisteredHandler(InsertCollectionItemInAddResourceEvent.TYPE, this);
	}

	private void addRegisteredHandler(
			Type<InsertCollectionItemInAddResourceHandler> type2,
			CollectionContentView collectionContentView) {

	}

	@Override
	public void setData(CollectionDo listOfContent,FolderDo folderDo, RefreshType type){
		this.listOfContent = listOfContent;

		if(listOfContent.getCollectionItems().size()>0){
			index=0;
			for (CollectionItemDo collectionItem : listOfContent.getCollectionItems()) {
				setDisplayResourceItem(collectionItem, type, index);
				index++;
			}
			setLastWidgetArrowVisiblity(false);
		}
	}

	@Override
	public void setDisplayResourceItem(CollectionItemDo collectionItem,RefreshType type, int index){
		int tmpIndex = index;
		Window.enableScrolling(true);
		if (index == 0){
			pnlReosurceList.clear();
		}else if (tmpIndex ==-1){
			index = listOfContent.getCollectionItems().size();
		}

		if (type.equals(RefreshType.INSERT)){
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
				@Override
				public void updateNarration(CollectionItemDo collectionItem,String narration) {
					getUiHandlers().updateNarrationItem(collectionItem, narration);
				}
			};
			widgetMove.setPresenter(collectionContentPresenter);
			widgetMove.getElement().setAttribute("itemSequence", collectionItem.getItemSequence()+"");
			pnlReosurceList.add(widgetMove);

		}else{

		}

		if (tmpIndex ==-1){
			setLastWidgetArrowVisiblity(false);
			resetWidgetPositions();
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

	@Override
	public void setCollectionContentPresenter(CollectionContentPresenter collectionContentPresenter){
		this.collectionContentPresenter=collectionContentPresenter;
	}


	/*
	 * To handle click event for New Resource
	 */
	private class NewResourceClickEvent implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_On_AddResource();
			clickType = "Url";
			if (listOfContent.getCollectionItems().size() >= 25) {

			} else {
				MixpanelUtil.Click_Add_NewResource();
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				displayNewResourcePopup();
			}
		}
	}

	/*
	 * To handle click event for New Resource
	 */
	private class NewQuestionClickEvent implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			try{
				MixpanelUtil.Click_On_AddQuestion();
				clickType = "Question";
				if (listOfContent.getCollectionItems().size() >= 25) {

				} else {
					Window.enableScrolling(false);
					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
					displayNewResourcePopup();
				}
			}catch(Exception e){
				AppClientFactory.printSevereLogger(e.getMessage());
			}
		}

	}

	@Override
	public void displayNewResourcePopup() {
		getUiHandlers().addResourcePopup(listOfContent, clickType);
	}

	@Override
	public void updateDeleteItem(String collectionItemId, int itemSequence) {
		//This method will delete the collectionItemId and reset the widget orders.
		listOfContent.getCollectionItems().remove(itemSequence);
		resetWidgetPositions();
	}

}
