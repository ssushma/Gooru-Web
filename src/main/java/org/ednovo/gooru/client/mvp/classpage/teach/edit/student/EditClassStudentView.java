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
package org.ednovo.gooru.client.mvp.classpage.teach.edit.student;

import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.uc.H5Panel;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.suggestbox.widget.AutoSuggestForm;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


/**
 * @fileName : EditClassStudentView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 03-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassStudentView extends BaseViewWithHandlers<EditClassStudentViewUiHandler> implements IsEditClassStudentView {
	
	@UiField LiPanel roasterPanel,reportPanel;
	
	@UiField Anchor roasterAnr,reportPanelAnr,studentAnr;
	
	@UiField PPanel classCodePanel,shareLnkPanel,emailAddTxt,analyPanel;
	
	@UiField InlineLabel classCodeTxtPanel,courseHeaderLbl,courseTitleLbl;
	
	@UiField TextBox sharTxtBox/*,inviteTxtBox*/;
	
	@UiField Button inviteBtn;
	
	@UiField H5Panel inviteEmailTxt,studentJoinPanel,studentPendingPanel;
	
	@UiField VerticalPanel tableContainer,pendingContainer;
	
	@UiField HTMLPanel panelSuggestBox,roasterMainConatiner,reportContainer/*,panelActions,panelCode*/;
	
	@UiField Label lblPleaseWait,lblErrorMessage;
	
	private static final String QUESTIONIMAGE = "images/question.png";
	
	private static final String STUDENTIMAGE = "images/Classpage/studentsIco.png";
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private PopupPanel toolTipPopupPanelNew = new PopupPanel();
	
	private PopupPanel toolTipPopupPanelNew1 = new PopupPanel();
	
	private PopupPanel toolTipPopupPanelNew2 = new PopupPanel();
	
	//@UiField Image pendingImage;
	
	@UiField HTMLPanel pendindUserContainer,activeUserConatiner;
	
	@UiField Image studentImage;
	
	@UiField Anchor notePanel;
	
	@UiField Button connectCourseBtn,addStudentBtn;

	private static EditClassStudentViewUiBinder uiBinder = GWT.create(EditClassStudentViewUiBinder.class);
	
	MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();

	interface EditClassStudentViewUiBinder extends UiBinder<Widget, EditClassStudentView> {
	}
	
	AutoSuggestForm autoSuggetTextBox =null;

	public EditClassStudentView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
		
		for(int i=0;i<=3;i++){
			tableContainer.add(new MembersViewVc("joined") {
				
				@Override
				public void setStudentsListContainer(ClickEvent event) {			
				}
				
				@Override
				public void setCollabCount(int count, String type) {
				}
			});
			pendingContainer.add(new MembersViewVc("pending") {
				
				@Override
				public void setStudentsListContainer(ClickEvent event) {
					throw new RuntimeException("Not implemented");
				}
				
				@Override
				public void setCollabCount(int count, String type) {
					throw new RuntimeException("Not implemented");
				}
			});
		}
		
		roasterAnr.addClickHandler(new EditClassStudentTabHandler(UrlNavigationTokens.TEACHER_CLASS_STUDENTS_ROASTER,roasterPanel));
		reportPanel.addClickHandler(new EditClassStudentTabHandler(UrlNavigationTokens.TEACHER_CLASS_STUDENTS_REPORT,reportPanel));
	}
	
	public void setIds(){
		roasterAnr.setText(i18n.GL3416());
		roasterAnr.getElement().setId("roasterAnrId");
		
		reportPanelAnr.setText(i18n.GL3421());
		reportPanelAnr.getElement().setId("reportPanelId");
		
		classCodePanel.setText(i18n.GL0184());
		classCodePanel.getElement().setId("classCodePanelId");
		
		shareLnkPanel.setText(i18n.GL1594());
		shareLnkPanel.getElement().setId("sharelnkPanel");
		
		inviteEmailTxt.setText(i18n.GL3419());
		inviteEmailTxt.getElement().setId("inviteEmailTxtId");
		
		emailAddTxt.setText(i18n.GL1591());
		emailAddTxt.getElement().setId("emailAddTextId");
		
		inviteBtn.setText(i18n.GL0944());
		inviteBtn.getElement().setId("inviteBtnId");
		
		
		studentJoinPanel.setText(i18n.GL1526());
		studentJoinPanel.getElement().setId("studentJoinPanelId");
		
		analyPanel.setText(i18n.GL1633());
		analyPanel.getElement().setId("analyPanelId");
		
		Image image = new Image(QUESTIONIMAGE);
		image.getElement().setId("classCodeImageId");
		image.addMouseOverHandler(new MouseOverShowClassCodeToolTip1());
		image.addMouseOutHandler(new MouseOutHideToolTip1());
		
		
		Image image2 = new Image(QUESTIONIMAGE);
		image2.getElement().setId("sharLnkId");
		image2.addMouseOverHandler(new MouseOverShowClassCodeToolTip2());
		image2.addMouseOutHandler(new MouseOutHideToolTip2());
		
		notePanel.setText(i18n.GL3422());
		notePanel.getElement().setId("notePanelId");
		
		studentImage.setUrl(STUDENTIMAGE);
		
		addStudentBtn.setText(i18n.GL3423());
		addStudentBtn.getElement().setId("addStudentBtnId");
		
		connectCourseBtn.setText(i18n.GL3424());
		connectCourseBtn.getElement().setId("connectCourseBtnId");
		
		courseHeaderLbl.setText(i18n.GL0574());
		courseHeaderLbl.getElement().setId("courseHeaderLblId");
		
		
		classCodeTxtPanel.setText("XYZRS");
		
		classCodePanel.add(image);
		shareLnkPanel.add(image2);
		
		studentPendingPanel.setText(i18n.GL1525());
		studentPendingPanel.getElement().setId("studentPendingPanelId");
		
		panelSuggestBox.getElement().setId("pnlSuggestbox");
		//panelActions.getElement().setId("pnlActions");
		//panelCode.getElement().setId("pnlCode");
		
		createAutoSuggestBox();
		
		
	}
	
	public void setTabVisible(boolean isVisible){
		roasterMainConatiner.setVisible(isVisible);
		reportContainer.setVisible(!isVisible);
	}
	
	public class MouseOverShowClassCodeToolTip1 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew.clear();
			toolTipPopupPanelNew.setWidget(new GlobalToolTip(i18n.GL2090()));
			toolTipPopupPanelNew.setStyleName("");
			toolTipPopupPanelNew.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew.show();
		}

	}
	
	public class MouseOutHideToolTip1 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew.hide();
		}
	}
	
	public class MouseOverShowClassCodeToolTip2 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew1.clear();
			toolTipPopupPanelNew1.setWidget(new GlobalToolTip(i18n.GL2091()));
			toolTipPopupPanelNew1.setStyleName("");
			toolTipPopupPanelNew1.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew1.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew1.show();
		}

	}
	
	public class MouseOutHideToolTip2 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew1.hide();
		}
	}
	
	@Override
	public void createAutoSuggestBox() {
		panelSuggestBox.setStyleName("auto_suggest");
		autoSuggetTextBox = new AutoSuggestForm(oracle) {

			@Override
			public void onSubmit(DomEvent<EventHandler> event) {
				// Nothing to do....
			}

			@Override
			public void dataObjectModel(String text) {
				if (text.trim().length() > 0){
					AppClientFactory.getInjector().getClasspageService().getSuggestionByName(text.trim(), new SimpleAsyncCallback<List<String>>() {

						@Override
						public void onSuccess(List<String> lstOfSuggestedCollaborators) {
							autoSuggetTextBox.clearAutoSuggestData();
							for (String lstCollab : lstOfSuggestedCollaborators){
								oracle.add(lstCollab);
							}
							autoSuggetTextBox.setAutoSuggest(oracle);
						}
					});
				}
			}

			@Override
			public void keyPressOnTextBox(KeyPressEvent event) {
				lblErrorMessage.setVisible(false);
			}

			@Override
			public void errorMsgVisibility(boolean visibility, String emailId) {
				if (visibility){
					showErrorMessage(StringUtil.generateMessage(i18n.GL1019(), emailId));
				}else{
					lblErrorMessage.setVisible(false);
				}
			}

		};
		autoSuggetTextBox.clearAutoSuggestData();
		panelSuggestBox.clear();
		panelSuggestBox.add(autoSuggetTextBox);
		autoSuggetTextBox.getTxtInput().getTxtInputBox().setFocus(true);
	}
	
	public void showErrorMessage(String errorMessage){
		lblErrorMessage.setText(errorMessage);
		lblErrorMessage.getElement().setAttribute("alt",errorMessage);
		lblErrorMessage.getElement().setAttribute("title",errorMessage);
		lblErrorMessage.setVisible(true);
	}
	
	public class MouseOverShowClassCodeToolTip3 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew2.clear();
			toolTipPopupPanelNew2.setWidget(new GlobalToolTip(i18n.GL2092()));
			toolTipPopupPanelNew2.setStyleName("");
			toolTipPopupPanelNew2.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew2.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew2.show();
		}

	}
	
	public class MouseOutHideToolTip3 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew2.hide();
		}
	}
	
	public class EditClassStudentTabHandler implements ClickHandler{

		String subView;
		LiPanel liPanel;
		
		public EditClassStudentTabHandler(String subView,LiPanel liPanel){
			this.subView=subView;
			this.liPanel=liPanel;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			roasterPanel.removeStyleName(CssTokens.ACTIVE);
			reportPanel.removeStyleName(CssTokens.ACTIVE);
			liPanel.addStyleName(CssTokens.ACTIVE);
			PlaceRequest request = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
			request = request.with(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW, subView);
			AppClientFactory.getPlaceManager().revealPlace(request);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.student.IsEditClassStudentView#setNavigationTab()
	 */
	@Override
	public void setNavigationTab() {
		String subView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW,"");
		if(subView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_STUDENTS_ROASTER)){
			setTabVisible(true);
			roasterPanel.setStyleName(CssTokens.ACTIVE);
		}else{
			setTabVisible(false);
			reportPanel.setStyleName(CssTokens.ACTIVE);
		}
	}

}
