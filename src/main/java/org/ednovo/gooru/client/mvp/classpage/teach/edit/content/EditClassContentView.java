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
package org.ednovo.gooru.client.mvp.classpage.teach.edit.content;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.content.widget.EditClassLessonView;
import org.ednovo.gooru.client.uc.LabelUc;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.PPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


/**
 * @fileName : EditClassContentView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassContentView extends BaseViewWithHandlers<EditClassContentViewUiHandler> implements IsEditClassContentView {
	
	
	@UiField Anchor minmumScoreAnr,contentSettingsAnr;
	
	@UiField InlineLabel courseLbl,titleLbl,markAllLbl,visiblLbl,hiddenLbl;
	
	@UiField Button editCourseBtn,studentPreviewbtn,saveBtn;
	
	@UiField HTMLPanel scoreContainer,contentSeetingsContainer;
	
	@UiField PPanel scorePanel,helpPanel,unitPanel,choseTxtPanel,noteTxtPanel;
	
	@UiField TextBox scoreTextBox;
	
	@UiField LiPanel minLiPnl,settLiPanel;
	
	@UiField HTMLPanel unitList;
	
	@UiField PPanel lessonPanel,collectionTitlePanel,visiblePanel;
	
	@UiField HTMLPanel tableConatiner;
	
	EditClassLessonView editClassLessonView;
	
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	

	private static EditClassContentViewUiBinder uiBinder = GWT.create(EditClassContentViewUiBinder.class);

	interface EditClassContentViewUiBinder extends
			UiBinder<Widget, EditClassContentView> {
	}

	public EditClassContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		scoreTextBox.setText("95");
		setId();
		for(int i=0; i<5 ;i++){
			editClassLessonView = new EditClassLessonView();
			tableConatiner.add(editClassLessonView);
		}
	}
	
	public void setTabVisible(boolean visible){
		scoreContainer.setVisible(visible);
		contentSeetingsContainer.setVisible(!visible);
	}
	
	@Override
	public void setNavigationTab(){
		String tabView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASSSUB_PAGE_VIEW,"");
		if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE)){
			setTabVisible(true);
			minLiPnl.addStyleName(CssTokens.ACTIVE);
		}else if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS)){
			setTabVisible(false);
			settLiPanel.addStyleName(CssTokens.ACTIVE);
		}else{
			setTabVisible(true);
		}
	}
	
	public void setId(){
		minmumScoreAnr.setText(i18n.GL3403());
		minmumScoreAnr.getElement().setId("minmumAnrId");
		minmumScoreAnr.getElement().setAttribute("alt",i18n.GL3403());
		minmumScoreAnr.getElement().setAttribute("title",i18n.GL3403());
		
		contentSettingsAnr.setText(i18n.GL3404());
		contentSettingsAnr.getElement().setId("contentSettingAnrId");
		contentSettingsAnr.getElement().setAttribute("alt",i18n.GL3404());
		contentSettingsAnr.getElement().setAttribute("title",i18n.GL3404());
		
		courseLbl.setText(i18n.GL0326());
		courseLbl.getElement().setId("courseLblId");
		courseLbl.getElement().setAttribute("alt",i18n.GL0326());
		courseLbl.getElement().setAttribute("title",i18n.GL0326());
		
		editCourseBtn.setText(i18n.GL3405());
		editCourseBtn.getElement().setId("editCourseId");
		editCourseBtn.getElement().setAttribute("alt",i18n.GL3405());
		editCourseBtn.getElement().setAttribute("title",i18n.GL3405());
		
		studentPreviewbtn.setText(i18n.GL3406());
		studentPreviewbtn.getElement().setId("previwBtnId");
		studentPreviewbtn.getElement().setAttribute("alt",i18n.GL3406());
		studentPreviewbtn.getElement().setAttribute("title",i18n.GL3406());
		
		scorePanel.setText(i18n.GL3407());
		scorePanel.getElement().setId("scorePnlId");
		scorePanel.getElement().setAttribute("alt",i18n.GL3407());
		scorePanel.getElement().setAttribute("title",i18n.GL3407());
		
		helpPanel.setText(i18n.GL3408());
		helpPanel.getElement().setId("helpPnlId");
		helpPanel.getElement().setAttribute("alt",i18n.GL3408());
		helpPanel.getElement().setAttribute("title",i18n.GL3408());
		
		saveBtn.setText(i18n.GL0141());
		saveBtn.getElement().setId("saveBtnId");
		saveBtn.getElement().setAttribute("alt",i18n.GL0141());
		saveBtn.getElement().setAttribute("title",i18n.GL0141());
		
		unitPanel.setText(i18n.GL3281());
		unitPanel.getElement().setId("unitPanelId");
		
		ListBox unitListBox = new ListBox();
		
		unitListBox.addItem("Rates & Rations", "Rates & Rations");
		unitListBox.addItem("Rates & Rations", "Exponents");
		
		unitList.add(unitListBox);
		
		scoreContainer.getElement().setId("scoreContainerId");
		
		choseTxtPanel.setText(i18n.GL3409());
		choseTxtPanel.getElement().setId("choseTxtpanelId");
		
		noteTxtPanel.setText(i18n.GL3410());
		noteTxtPanel.getElement().setId("notetxtPanelId");
		
		markAllLbl.setText(i18n.GL3411());
		markAllLbl.getElement().setId("marlAllLblId");
		
		visiblLbl.setText(i18n.GL3412());
		visiblLbl.getElement().setId("visibleLblId");
		
		hiddenLbl.setText(i18n.GL3413());
		hiddenLbl.getElement().setId("hiddenLblId");
		
		lessonPanel.setText(i18n.GL0910());
		lessonPanel.getElement().setId("lessonPanelId");
		
		collectionTitlePanel.setText(i18n.GL3414());
		collectionTitlePanel.getElement().setId("collectionTitlePanelId");
		
		visiblePanel.setText(i18n.GL3415());
		visiblePanel.getElement().setId("visibliePanelId");
		
		
		
		minmumScoreAnr.addClickHandler(new ContentTabNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE,minLiPnl));
		contentSettingsAnr.addClickHandler(new ContentTabNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS,settLiPanel));
		
		
		
	}
	
	public class ContentTabNavigationHandler implements ClickHandler{

		String view;
		LiPanel liPanel;
		
		public ContentTabNavigationHandler(String view,LiPanel liPanel){
			this.view=view;
			this.liPanel=liPanel;
		}
		
		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 */
		@Override
		public void onClick(ClickEvent event) {
			minLiPnl.removeStyleName(CssTokens.ACTIVE);
			settLiPanel.removeStyleName(CssTokens.ACTIVE);
			liPanel.addStyleName(CssTokens.ACTIVE);
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASSSUB_PAGE_VIEW, view);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
		
	}

}
