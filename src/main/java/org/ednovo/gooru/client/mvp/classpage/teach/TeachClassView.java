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
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


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

	
	@UiField HTMLPanel startContainer/*,tabTitleContainer*/;
	
	@UiField SimplePanel bodyMenuView;
	
	@UiField H2Panel titlePanel;
	
	//@UiField H3Panel tabTitle;
	
	@UiField InlineLabel settingsLbl,studentLbl;
	
	@UiField HTMLEventPanel classSettingsAnr,studentAnr;
	
	@UiField SpanPanel classCodePanel;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static TeachClassViewUiBinder uiBinder = GWT.create(TeachClassViewUiBinder.class);

	interface TeachClassViewUiBinder extends UiBinder<Widget, TeachClassView> {
	}

	
	public TeachClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		classSettingsAnr.addClickHandler(new TeacherClassNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_SETTINGS,UrlNavigationTokens.TEACHER_CLASS_SETTINGS_INFO,classSettingsAnr));
		studentAnr.addClickHandler(new TeacherClassNavigationHandler(UrlNavigationTokens.TEACHER_CLASS_STUDENTES,UrlNavigationTokens.TEACHER_CLASS_STUDENTE_ROASTER,studentAnr));
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
		settingsLbl.setText(i18n.GL3345());
		settingsLbl.getElement().setAttribute("alt",i18n.GL3345());
		settingsLbl.getElement().setAttribute("title",i18n.GL3345());
		
		classCodePanel.setText("XYPRSZ");
		
		//startContainer.getElement().setAttribute("alt","startContainer);
		//startContainer.getElement().setAttribute("title",i18n.GL0747());
		titlePanel.setText("My First Class");
	}
	
	@Override
	public void addToSlot(Object slot, Widget content) {
		super.addToSlot(slot, content);
		String viewPage = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT,"");
		/*//tabTitleContainer.setVisible(true);
		if(viewPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_STUDENTES)){
			tabTitle.setText(i18n.GL1624());
		}else if(viewPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_SETTINGS)){
			tabTitle.setText(i18n.GL3345());
		}else if(viewPage.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SETTINGS)){
			tabTitle.setText(i18n.GL3346());
		}else{
			tabTitleContainer.setVisible(false);
		}*/
		if (content != null) {
			bodyMenuView.setWidget(content);
		}
		
	}
	
	public class TeacherClassNavigationHandler implements ClickHandler{

		String token;
		String subToken;
		HTMLEventPanel htmlEventPanel;
		
		public TeacherClassNavigationHandler(String token,String subToken,HTMLEventPanel htmlEventPanel){
			this.token=token;
			this.subToken=subToken;
			this.htmlEventPanel=htmlEventPanel;
		}
		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.STUDENT_CLASSPAGE_PAGE_DIRECT, token);
			request = request.with(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW, subToken);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
		
	}
}
