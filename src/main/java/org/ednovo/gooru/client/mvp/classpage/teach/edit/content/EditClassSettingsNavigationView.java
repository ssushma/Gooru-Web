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
import org.ednovo.gooru.client.uc.LiPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


/**
 * @fileName : EditClassSettingsNavigationView.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 06-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer:
 */
public class EditClassSettingsNavigationView extends BaseViewWithHandlers<EditClassSettingsNavigationUiHandler> implements IsEditClassSettingsNavigationView{

	@UiField LiPanel classInfo,minLiPnl,settLiPanel;

	@UiField Anchor classInfoAnr,minmumScoreAnr,contentSettingsAnr;

	@UiField InlineLabel courseLbl,titleLbl;

	@UiField Button studentPreviewbtn;

	@UiField SimplePanel bodyView;

	MessageProperties i18n = GWT.create(MessageProperties.class);

	private static EditClassSettingsNavigationViewUiBinder uiBinder = GWT.create(EditClassSettingsNavigationViewUiBinder.class);

	interface EditClassSettingsNavigationViewUiBinder extends	UiBinder<Widget, EditClassSettingsNavigationView> {
	}

	public EditClassSettingsNavigationView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		//setActiveStyles();
	}

	public void setIds(){
		minmumScoreAnr.setText(i18n.GL3403());
		minmumScoreAnr.getElement().setId("minmumAnrId");
		minmumScoreAnr.getElement().setAttribute("alt",i18n.GL3403());
		minmumScoreAnr.getElement().setAttribute("title",i18n.GL3403());

		contentSettingsAnr.setText(i18n.GL3404());
		contentSettingsAnr.getElement().setId("contentSettingAnrId");
		contentSettingsAnr.getElement().setAttribute("alt",i18n.GL3404());
		contentSettingsAnr.getElement().setAttribute("title",i18n.GL3404());

		classInfoAnr.setText(i18n.GL3420());
		classInfoAnr.getElement().setId("contentSettingAnrId");
		classInfoAnr.getElement().setAttribute("alt",i18n.GL3420());
		classInfoAnr.getElement().setAttribute("title",i18n.GL3420());

		courseLbl.setText(i18n.GL0326());
		courseLbl.getElement().setId("courseLblId");
		courseLbl.getElement().setAttribute("alt",i18n.GL0326());
		courseLbl.getElement().setAttribute("title",i18n.GL0326());

		studentPreviewbtn.setText(i18n.GL3406());
		studentPreviewbtn.getElement().setId("previwBtnId");
		studentPreviewbtn.getElement().setAttribute("alt",i18n.GL3406());
		studentPreviewbtn.getElement().setAttribute("title",i18n.GL3406());

		classInfoAnr.addClickHandler(new SubNavigationTabHandler(UrlNavigationTokens.TEACHER_CLASS_SETTINGS_INFO,classInfo));
		minmumScoreAnr.addClickHandler(new SubNavigationTabHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE,minLiPnl));
		settLiPanel.addClickHandler(new SubNavigationTabHandler(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS,settLiPanel));
	}

	@Override
	public void setActiveStyles(){
		String subPageView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW,"");
		if(subPageView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_SETTINGS_INFO)){
			classInfo.setStyleName(CssTokens.ACTIVE);
		}else if(subPageView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE)){
			minLiPnl.setStyleName(CssTokens.ACTIVE);
		}else if(subPageView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS)){
			settLiPanel.setStyleName(CssTokens.ACTIVE);
		}

	}

	public class SubNavigationTabHandler implements ClickHandler{

		String subView;
		LiPanel liPanel;

		public SubNavigationTabHandler(String subView,LiPanel liPanel){
			this.subView=subView;
			this.liPanel=liPanel;
		}


		@Override
		public void onClick(ClickEvent event) {
			minLiPnl.removeStyleName(CssTokens.ACTIVE);
			settLiPanel.removeStyleName(CssTokens.ACTIVE);
			classInfo.removeStyleName(CssTokens.ACTIVE);
			liPanel.addStyleName(CssTokens.ACTIVE);
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW, subView);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}

	}

	@Override
	public void addToSlot(Object slot, Widget content) {
		super.addToSlot(slot, content);
		if (content != null) {
			bodyView.setWidget(content);
		}

	}

}
