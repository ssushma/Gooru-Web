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
package org.ednovo.gooru.client.mvp.classpage.teach;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : TeachClassView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 26-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class TeachClassView extends BaseViewWithHandlers<TeachClassViewUiHandlers> implements IsTeachClassView {

	
	@UiField HTMLPanel startContainer,tabTitleContainer;
	
	@UiField SimplePanel bodyMenu,bodyMenuView;
	
	@UiField H2Panel titlePanel;
	
	@UiField H3Panel tabTitle;
	
	@UiField InlineLabel settingsLbl,contentLbl,studentLbl;
	
	@UiField HTMLEventPanel classSettingsAnr,studentAnr,classContent;
	
	@UiField SpanPanel classCodePanel;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static TeachClassViewUiBinder uiBinder = GWT.create(TeachClassViewUiBinder.class);

	interface TeachClassViewUiBinder extends UiBinder<Widget, TeachClassView> {
	}

	
	public TeachClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
	}


	/**
	 * @function setIds 
	 * 
	 * @created_date : 26-Jun-2015
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void setIds() {
		startContainer.getElement().setId("getStartedContainer");
		
		studentLbl.getElement().setId("studentLblId");
		studentLbl.setText(i18n.GL3344() +"(0)");
		studentLbl.getElement().setAttribute("alt",i18n.GL3344());
		studentLbl.getElement().setAttribute("title",i18n.GL3344());
		
		settingsLbl.getElement().setId("settingsLblId");
		settingsLbl.setText(i18n.GL3344());
		settingsLbl.getElement().setAttribute("alt",i18n.GL3345());
		settingsLbl.getElement().setAttribute("title",i18n.GL3345());
		
		contentLbl.getElement().setId("contentLblId");
		contentLbl.setText(i18n.GL3345());
		contentLbl.getElement().setAttribute("alt",i18n.GL3346());
		contentLbl.getElement().setAttribute("title",i18n.GL3346());
		
		classCodePanel.setText("XYPRSZ");
		tabTitle.setText("Class Settings");
		
		//startContainer.getElement().setAttribute("alt","startContainer);
		//startContainer.getElement().setAttribute("title",i18n.GL0747());
		titlePanel.setText("My First Class");
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		super.setInSlot(slot, content);
		String view = AppClientFactory.getPlaceManager().getRequestParameter("view","");
		bodyMenuView.clear();
		if(view.equalsIgnoreCase("")){
			tabTitleContainer.setVisible(false);
		}else{
			tabTitleContainer.setVisible(true);
		}
		if (slot == TeachClassViewUiHandlers.SLOT_BODYMENU) {
			bodyMenuView.setWidget(content);
		}
		
	}


	

}
