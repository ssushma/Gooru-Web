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

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.PPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


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
	
	@UiField InlineLabel courseLbl,titleLbl;
	
	@UiField Button editCourseBtn,studentPreviewbtn,saveBtn;
	
	@UiField HTMLPanel scoreContainer;
	
	@UiField PPanel scorePanel,helpPanel;
	
	@UiField TextBox scoreTextBox;
	
	
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	

	private static EditClassContentViewUiBinder uiBinder = GWT.create(EditClassContentViewUiBinder.class);

	interface EditClassContentViewUiBinder extends
			UiBinder<Widget, EditClassContentView> {
	}

	public EditClassContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		scoreTextBox.setText("95");
		setId();
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
		
		scoreContainer.getElement().setId("scoreContainerId");
		
		
		
	}

}
