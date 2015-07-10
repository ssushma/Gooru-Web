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
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
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
	
	
	@UiField InlineLabel markAllLbl,visiblLbl,hiddenLbl;
	
	@UiField Button saveBtn;
	
	@UiField HTMLPanel scoreContainer,contentSeetingsContainer;
	
	@UiField PPanel scorePanel,helpPanel,unitPanel,choseTxtPanel,noteTxtPanel;
	
	@UiField TextBox scoreTextBox;
	
	@UiField HTMLPanel unitList;
	
	@UiField PPanel lessonPanel,collectionTitlePanel,visiblePanel;
	
	@UiField HTMLPanel tableConatiner;
	
	EditClassLessonView editClassLessonView;
	
	ClasspageDo classpageDo;
	
	
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
		String tabView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW,"");
		if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE)){
			setTabVisible(true);
		}else if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS)){
			setTabVisible(false);
		}else{
			setTabVisible(true);
		}
	}
	
	public void setId(){

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
		
		
		
		/*minmumScoreAnr.addClickHandler(new ContentTabNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE,minLiPnl));
		contentSettingsAnr.addClickHandler(new ContentTabNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS,settLiPanel));*/
		
		
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.IsEditClassContentView#setClassData(org.ednovo.gooru.application.shared.model.content.ClasspageDo)
	 */
	@Override
	public void setClassData(ClasspageDo classpageDo) {
		this.classpageDo=classpageDo;
		
		
	}
	
	/*public class ContentTabNavigationHandler implements ClickHandler{

		String view;
		LiPanel liPanel;
		
		public ContentTabNavigationHandler(String view,LiPanel liPanel){
			this.view=view;
			this.liPanel=liPanel;
		}
		
		 (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 
		@Override
		public void onClick(ClickEvent event) {
			minLiPnl.removeStyleName(CssTokens.ACTIVE);
			settLiPanel.removeStyleName(CssTokens.ACTIVE);
			liPanel.addStyleName(CssTokens.ACTIVE);
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW, view);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
		
	}*/

}
