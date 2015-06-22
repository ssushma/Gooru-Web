package org.ednovo.gooru.application.client.home.presearch;
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
import java.util.Map;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.home.SampleReportView;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 *
 * @fileName : ViewMorePeopleView.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 16-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer:
 */
public class PreSearchView extends BaseViewWithHandlers<PreSearchUiHandlers> implements IsPreSearchView,ClientConstants {

	private static PreSearchViewUiBinder uiBinder = GWT
			.create(PreSearchViewUiBinder.class);

	interface PreSearchViewUiBinder extends
			UiBinder<Widget, PreSearchView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField Button btnTeacherSignUp, btnStudentSignUp, btnGrades, btnSubjects, btnBrowseContent, btnBrowseStandard, btnSeeOurImpact,btnLearnMore,btnLearnAboutApproach;
	@UiField Anchor ancLogin, lblSampleReports;
	@UiField HTMLPanel panelAlreadyHave, panelGrades;


	public PreSearchView() {
		setWidget(uiBinder.createAndBindUi(this));

		setDebugIds();

		RootPanel.get().addDomHandler(rootHandler, ClickEvent.getType());
	}


	private void setDebugIds() {
		btnTeacherSignUp.setText(i18n.GL0186());
		btnStudentSignUp.setText(i18n.GL0186());

		StringUtil.setAttributes(btnTeacherSignUp.getElement(), "btnTeacherSignUp", i18n.GL0186(), i18n.GL0186());
		StringUtil.setAttributes(btnStudentSignUp.getElement(), "btnStudentSignUp", i18n.GL0186(), i18n.GL0186());

		StringUtil.setAttributes(btnSeeOurImpact.getElement(), "btnSeeOurImpact", i18n.GL3301(), i18n.GL3301());
		StringUtil.setAttributes(btnLearnMore.getElement(), "btnLearnMore", i18n.GL3304(), i18n.GL3304());
		StringUtil.setAttributes(btnLearnAboutApproach.getElement(), "btnLearnAboutApproach", i18n.GL3315(), i18n.GL3315());

		StringUtil.setAttributes(panelGrades.getElement(), "gooruSearchMainContainer", "", "");

		panelGrades.setVisible(false);
	}

	/* */
	@Override
	public void setButtonVisibility(){
		btnTeacherSignUp.setVisible(AppClientFactory.isAnonymous());
		btnStudentSignUp.setVisible(AppClientFactory.isAnonymous());
		panelAlreadyHave.setVisible(AppClientFactory.isAnonymous());
	}


	/* UI Handlers...*/

	@UiHandler("btnTeacherSignUp")
	public void onClickTeacherSignUp(ClickEvent event){
		openSignUp();
	}
	@UiHandler("btnStudentSignUp")
	public void onClickStudentSignUp(ClickEvent event){
		openSignUp();
	}

	@UiHandler("btnSeeOurImpact")
	public void onClickSeeOurImpact(ClickEvent event){

	}

	@UiHandler("btnLearnMore")
	public void onClickLearMore(ClickEvent event){

	}

	@UiHandler("btnLearnAboutApproach")
	public void onClickLearnAboutApproach(ClickEvent event){

	}

	@UiHandler("btnGrades")
	public void onClickGrades(ClickEvent event){
		setGradeVisibility();
	}

	@UiHandler("lblSampleReports")
	public void onClickSampleReports(ClickEvent event){
		GWT.runAsync(new SimpleRunAsyncCallback() {
			@Override
			public void onSuccess() {
				Window.scrollTo(0, 0);
				SampleReportView sampleReportView= new SampleReportView();
			}
		});
	}

	@UiHandler("ancLogin")
	public void onClickLogin(ClickEvent event){
		GWT.runAsync(new SimpleRunAsyncCallback() {
			@Override
			public void onSuccess() {
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
				LoginPopupUc popup = new LoginPopupUc() {
					@Override
					public void onLoginSuccess() {

					}
				};
				popup.setGlassEnabled(true);
				popup.center();
				popup.show();
			}
		});

	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == PreSearchPresenter.GRADES){
			panelGrades.add(content);
		}
	}


	/**
	 *
	 * @function openSignUp
	 *
	 * @created_date : 22-Jun-2015
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
	private void openSignUp(){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {
				Map<String, String> map = StringUtil.splitQuery(Window.Location
						.getHref());
				map.put("callback", "signup");
				map.put("type", "1");
				AppClientFactory.getPlaceManager().revealPlace(
						AppClientFactory.getCurrentPlaceToken(), map);
			}
		});
	}

	/**
	 *
	 * @function setGradeVisibility
	 *
	 * @created_date : 22-Jun-2015
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
	private void setGradeVisibility(){
		if (panelGrades.isVisible()){
			panelGrades.setVisible(false);
		}else{
			panelGrades.setVisible(true);
		}
	}

	ClickHandler rootHandler= new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new SimpleRunAsyncCallback() {

				@Override
				public void onSuccess() {
//					setGradeVisibility();
				}
			});
		}
	};
}
