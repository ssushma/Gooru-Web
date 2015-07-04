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
package org.ednovo.gooru.client.mvp.gshelf.courselist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.gshelf.util.ContentWidgetWithMove;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MyCollectionsListView  extends BaseViewWithHandlers<MyCollectionsListUiHandlers> implements IsMyCollectionsListView,ClientConstants  {

	private static MyCollectionsListViewUiBinder uiBinder = GWT.create(MyCollectionsListViewUiBinder.class);

	interface MyCollectionsListViewUiBinder extends UiBinder<Widget, MyCollectionsListView> {
	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel courseListContainer,pnlH2TitleContainer,pnlCreateContainer,pnlAddContainer;
	@UiField VerticalPanel pnlCourseList;
	@UiField H2Panel h2Title;
	@UiField Button btnCreate,btnCreateResource,btnCreateQuestion;
	@UiField ScrollPanel listScrollPanel;
	@UiField Label lblAddNew;
	
	int index=0;
	
	String type;
	
	final String COURSE="Course",UNIT="Unit",LESSON="Lesson",FOLDER="Folder",COLLECTION="Collection",ASSESSMENT="Assessment";
	
	private static final String VIEW= "view";

	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private static final String ID = "id";
	
	public MyCollectionsListView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				setScrollHeight();
			}
		});
	}
	/**
	 * This method is used to set id's
	 */
	public void setIds(){
		courseListContainer.getElement().setId("gShelfCousesList");
		h2Title.getElement().setId("h2Title");
		pnlCourseList.getElement().setId("pnlCourseList");
		pnlH2TitleContainer.getElement().setId("pnlH2TitleContainer");
		setScrollHeight();
	}
	/**
	 * This method is used to reset the widget positions with default text
	 */
	@Override
	public void resetWidgetPositions(){
		Iterator<Widget> widgets=pnlCourseList.iterator();
		int index=0;
		while (widgets.hasNext()){
			Widget widget=widgets.next();
			if(widget instanceof ContentWidgetWithMove){
				ContentWidgetWithMove contentWidgetWithMove=(ContentWidgetWithMove) widget;
				contentWidgetWithMove.getH3Panel().setText(type+" "+(index+1));
				contentWidgetWithMove.getTextBox().setText((index+1)+"");
				contentWidgetWithMove.getTextBox().getElement().setAttribute("index",index+"");
				if(index==0){
					//If this is the first widget we are hiding the up arrow
					contentWidgetWithMove.getTopArrow().setVisible(false);
				}else if(index==(pnlCourseList.getWidgetCount()-1)){
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
	/**
	 * This method is used to set data for fields
	 */
	@Override
	public void setData(String type,List<FolderDo> listOfContent,boolean clrPanel,boolean isInnerSlot,FolderDo folderDo) {
		this.type=type;
		pnlH2TitleContainer.setVisible(true);
		pnlCreateContainer.setVisible(false);
		if(isInnerSlot){
			pnlH2TitleContainer.setVisible(false);
			pnlCreateContainer.setVisible(true);
			String view=AppClientFactory.getPlaceManager().getRequestParameter(VIEW);
			if(view!=null && (view.equalsIgnoreCase(FOLDER) || view.equalsIgnoreCase(COLLECTION))){
				btnCreate.setVisible(false);
				pnlAddContainer.setVisible(false);
			}else{
				btnCreate.setVisible(true);
				lblAddNew.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
				pnlAddContainer.setVisible(true);
			}
		}else{
			if(COURSE.equalsIgnoreCase(type)){
				h2Title.setText(i18n.GL1180());
			}else if(FOLDER.equalsIgnoreCase(type)){
				btnCreate.setVisible(false);
				pnlAddContainer.setVisible(false);
				if(folderDo!=null){
					h2Title.setText(folderDo.getTitle()+" "+i18n.GL3336());
				}else{
					h2Title.setText(i18n.GL0994());
				}
			}else if(COLLECTION.equalsIgnoreCase(type)){
				btnCreate.setVisible(false);
				pnlAddContainer.setVisible(false);
				if(folderDo!=null){
					h2Title.setText(folderDo.getTitle()+" "+i18n.GL3336());
				}else{
					h2Title.setText(i18n.GL3282());
				}
			}else{
				pnlH2TitleContainer.setVisible(false);
				pnlCreateContainer.setVisible(true);
			}
		}
		if(clrPanel){
			index=0;
			pnlCourseList.clear();
		}else{
			index=pnlCourseList.getWidgetCount();
			setLastWidgetArrowVisiblity(true);
		}
		setCreateText();
		if(listOfContent!=null && listOfContent.size()>0){
			for (FolderDo folderObj : listOfContent) {
				final ContentWidgetWithMove widgetMove=new ContentWidgetWithMove(index,type,folderObj) {
					@Override
					public void moveWidgetPosition(String movingPosition,String currentWidgetPosition, boolean isDownArrow,String moveId) {
						int movingIndex= Integer.parseInt(movingPosition);
						if(pnlCourseList.getWidgetCount()>=movingIndex){
							//Based on the position it will insert the widget in the vertical panel
							String itemSequence=pnlCourseList.getWidget(movingIndex-1).getElement().getAttribute("itemSequence");
							getUiHandlers().reorderWidgetPositions(moveId, Integer.parseInt(itemSequence));
							if(!isDownArrow){
								movingIndex= (movingIndex-1);
								int currentIndex= Integer.parseInt(currentWidgetPosition);
								pnlCourseList.insert(pnlCourseList.getWidget(currentIndex), movingIndex);
							}else{
								int currentIndex= Integer.parseInt(currentWidgetPosition);
								pnlCourseList.insert(pnlCourseList.getWidget(currentIndex), movingIndex);
							}
						}
					}
				};
				widgetMove.getElement().setAttribute("itemSequence", folderObj.getItemSequence()+"");
				widgetMove.getTitleContainer().addDomHandler(new ClickOnTitleContainer(folderObj), ClickEvent.getType());
				widgetMove.enableAndDisableCount(folderObj.getType());
				pnlCourseList.add(widgetMove);
				index++;
			}
			setLastWidgetArrowVisiblity(false);
		}
	}
	/**
	 * This method is used to set the create text
	 * @param typeVal
	 */
	public void setCreateText(){
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		String o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
		String id=AppClientFactory.getPlaceManager().getRequestParameter(ID,null);
		btnCreateResource.setVisible(false);
		btnCreateQuestion.setVisible(false);
		if(id!=null){
			btnCreateResource.setVisible(true);
			btnCreateQuestion.setVisible(true);
			btnCreateResource.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL1110());
			StringUtil.setAttributes(btnCreateResource.getElement(), i18n.GL1110(), i18n.GL1110());
			btnCreateQuestion.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL0308());
			StringUtil.setAttributes(btnCreateQuestion.getElement(), i18n.GL0308(), i18n.GL0308());
			
			btnCreate.setVisible(false);
			lblAddNew.setVisible(false);
		}else if(o3!=null){
			btnCreateResource.setVisible(true);
			btnCreateQuestion.setVisible(true);
			btnCreateResource.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL1451());
			StringUtil.setAttributes(btnCreateResource.getElement(), i18n.GL1451(), i18n.GL1451());
			btnCreateQuestion.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL3024());
			StringUtil.setAttributes(btnCreateQuestion.getElement(), i18n.GL3024(), i18n.GL3024());
			
			btnCreate.setVisible(false);
			lblAddNew.setVisible(false);
		}else if(o2!=null){
			btnCreate.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL3417());
			lblAddNew.setText(i18n.GL3417());
		}else if(o1!=null){
			btnCreate.setText(i18n.GL_SPL_PLUS()+" "+i18n.GL3416());
			lblAddNew.setText(i18n.GL3416());
		}
	}
	/**
	 * This inner class is used to handle the click event on title container
	 */
	class ClickOnTitleContainer implements ClickHandler{
		FolderDo folderObj;
		ClickOnTitleContainer(FolderDo folderObj){
			this.folderObj=folderObj;
		}
		@Override
		public void onClick(ClickEvent event) {
			Map<String,String> params = new HashMap<String,String>();
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, updateParameters(params,folderObj));
			getUiHandlers().getShelfMainPresenter().updateLeftShelfPanelActiveStyle();
		}
	}
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			 if(slot==ShelfMainPresenter.RIGHT_SLOT){
				 getUiHandlers().getShelfMainPresenter().getView().getSlot().clear();
				 getUiHandlers().getShelfMainPresenter().getView().getSlot().add(content);
			 }
		}
	}
	/**
	 * On pagination it will enable the previous widget down arrow for move functionality
	 * @param isVisible
	 */
	public void setLastWidgetArrowVisiblity(boolean isVisible){
		ContentWidgetWithMove lastwidget=(ContentWidgetWithMove) pnlCourseList.getWidget(pnlCourseList.getWidgetCount()-1);
		lastwidget.getDownArrow().setVisible(isVisible);
	}
	/**
	 * This method will set the height and it will display the scroll
	 */
	public void setScrollHeight(){
		listScrollPanel.getElement().getStyle().setHeight((Window.getClientHeight()-120), Unit.PX);
		listScrollPanel.getElement().getStyle().setOverflowY(Overflow.AUTO);
	}
	/**
	 * This method will return the scroll panel
	 * @return
	 */
	@Override
	public ScrollPanel getScrollPanel(){
		return listScrollPanel;
	}
	/**
	 * This method is used to update the url parameters
	 * @param params
	 * @param folderObj
	 * @return
	 */
	public Map<String,String> updateParameters(Map<String,String> params,FolderDo folderObj){
		String view=AppClientFactory.getPlaceManager().getRequestParameter(VIEW,null);
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		String o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);
		String id=AppClientFactory.getPlaceManager().getRequestParameter(ID,null);
		if( view!=null){
			params.put(VIEW,view);
		}else{
			params.put(VIEW,"Course");
		}
		if(o1==null && o2==null && o3==null && id==null){
			params.put(O1_LEVEL,folderObj.getGooruOid());
		} else if(o1!=null && o2==null && o3==null && id==null){
			params.put(O1_LEVEL, o1);
			params.put(O2_LEVEL,folderObj.getGooruOid());
		}else if(o1!=null && o2!=null && o3==null && id==null) {
			params.put(O1_LEVEL,o1);
			params.put(O2_LEVEL,o2);
			params.put(O3_LEVEL,folderObj.getGooruOid());
		}else{
			params.put(O1_LEVEL,o1);
			params.put(O2_LEVEL,o2);
			params.put(O3_LEVEL,o3);
			params.put(ID,folderObj.getGooruOid());
		}
		return params;
	}
}
