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
package org.ednovo.gooru.client.mvp.classpages.study;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentView;
import org.ednovo.gooru.client.mvp.search.event.SetButtonEvent;
import org.ednovo.gooru.client.mvp.search.event.SetButtonHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ClassCodeView extends BaseViewWithHandlers<ClassCodeUiHandlers> implements IsClassCodeView,MessageProperties {
	
	private static ClassCodeViewUiBinder uiBinder = GWT
			.create(ClassCodeViewUiBinder.class);

	@UiField Button btnCreateClass,btnEnter, disabledBtn;
	
	@UiField Label lblCreateAClass,lblEasyToOrganize,lblAccessAClass,lblEasyAccessForStudents,lblUniqueClassCode, lblOne, lblTwo, lblThree;
	
	@UiField Label lblManageAssignments,lblClearDue,lblMonitorStudentProgress,lblMonitorDesc, lblFavoriteClasses, lblClassOne, lblClassTwo, lblClassThree;
	
	@UiField Anchor ancSampleReport;
	
	@UiField HTMLEventPanel panelClassOne, panelClassTwo, panelClassThree, panelClassFour;
	
	@UiField TextBoxWithPlaceholder txtCode;
	
	AlertMessageUc alertMessageUc;
	
	private NewClasspagePopupView newPopup = null;
	
	private boolean isValid=true;
	
	interface ClassCodeViewUiBinder extends UiBinder<Widget, ClassCodeView> {

	}

	
	
	
	@Inject
	public ClassCodeView() {
		setWidget(uiBinder.createAndBindUi(this));
		
		setText();
		
		SetButtonHandler setButtonVisibility = new SetButtonHandler() {

			@Override
			public void setButtonVisibility() {
				setCreateClassVisibility();
			}
		};
		AppClientFactory.getEventBus().addHandler(
				SetButtonEvent.TYPE, setButtonVisibility);
	}
	private void setCreateClassVisibility() {
		System.out.println("AppClientFactory.isAnonymous() :"+AppClientFactory.isAnonymous());
		if (AppClientFactory.isAnonymous()){
			btnCreateClass.setVisible(false);
		}else{
			btnCreateClass.setVisible(true);
		}
	}
	/**
	 * @function setText 
	 * 
	 * @created_date : May 21, 2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void setText() {
		
		setCreateClassVisibility();
		
		btnCreateClass.setText(GL1771);
		btnEnter.setText(GL1065);
		disabledBtn.setText(GL1065);
		lblCreateAClass.setText(GL1771);
		lblEasyToOrganize.setText(GL1772);
		lblAccessAClass.setText(GL1773);
		lblEasyAccessForStudents.setText(GL1774);
		lblUniqueClassCode.setText(GL1775);
		lblOne.setText(GL_GRR_NUMERIC_ONE);
		lblTwo.setText(GL_GRR_NUMERIC_TWO);
		lblThree.setText(GL_GRR_NUMERIC_THREE);
		lblManageAssignments.setText(GL1776);
		lblClearDue.setText(GL1777);
		lblMonitorStudentProgress.setText(GL1778);
		lblMonitorDesc.setText(GL1779);
		ancSampleReport.setText(GL1780);
		ancSampleReport.setVisible(false);
		lblFavoriteClasses.setText(GL1781);
		lblClassOne.setText(GL1782);
		lblClassTwo.setText(GL1783);
		lblClassThree.setText(GL1784);	
		
		txtCode.setPlaceholder(GL1785);
		
		disabledBtn.setVisible(false);
		
		txtCode.addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				txtCode.getElement().addClassName("textTransform");
			}
		});
		txtCode.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if (txtCode.getText().length() > 0 ){
					
				}else{
					txtCode.getElement().removeClassName("textTransform");
				}
			}
		});
		btnEnter.addClickHandler(new OnEnterClassCodeClick());
		btnCreateClass.addClickHandler(new OnClickCreateClass());
	}
	
	@UiHandler("panelClassOne")
	public void OpenFirstClass(ClickEvent event){
		OpenClasspageEdit("18c2e8db-ffcc-471e-960b-78b5ae30b98d", PlaceTokens.STUDENT);
	}
	
	@UiHandler("panelClassTwo")
	public void OpenSecondClass(ClickEvent event){
		OpenClasspageEdit("6b2fbea8-b3e9-4b74-937b-28e209049eec", PlaceTokens.STUDENT);
	}

	@UiHandler("panelClassThree")
	public void OpenThreeClass(ClickEvent event){
		OpenClasspageEdit("272e9c46-c0a9-427a-9a0d-f31eb051ce3a", PlaceTokens.STUDENT);
	}
	@UiHandler("panelClassFour")
	public void OpenFourClass(ClickEvent event){
		OpenClasspageEdit("087ddf35-6b2b-4411-9832-d8e789a25888", PlaceTokens.STUDENT);
	}
	
	
	private void OpenClasspageEdit(String gooruOId, String token) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", gooruOId);
		params.put("pageNum", "0");
		params.put("pageSize", "10");
		params.put("pos", "1");
		if (!token.equalsIgnoreCase(PlaceTokens.EDIT_CLASSPAGE)){
			params.put("tab","classList");
		}
		AppClientFactory.getPlaceManager().revealPlace(
				token, params);
	}
	
	public class OnClickCreateClass implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.ClickOnNewClassPage();

			newPopup = new NewClasspagePopupView() {

				@Override
				public void createNewClasspage(String title) {

					MixpanelUtil.Create_NewClasspage();
					CollectionDo collectionDo = new CollectionDo();
					collectionDo.setTitle(title);
					collectionDo.setCollectionType("classpage");
					AppClientFactory
							.getInjector()
							.getClasspageService()
							.createClassPage(collectionDo.getTitle(),
									new SimpleAsyncCallback<CollectionDo>() {

										@Override
										public void onSuccess(CollectionDo result) {
											final String classpageId = result
													.getGooruOid();
											AssignmentDo assignmentDo = new AssignmentDo();
											assignmentDo
													.setClasspageId(classpageId);

											TaskDo taskDo = new TaskDo();
											taskDo.setTitle(GL0121);
											taskDo.setTypeName("assignment");
											assignmentDo.setTask(taskDo);

											AttachToDo attachToDo = new AttachToDo();
											attachToDo.setId(classpageId);
											attachToDo.setType("classpage");

											assignmentDo.setAttachTo(attachToDo);

											AppClientFactory
													.getInjector()
													.getClasspageService()
													.v2CreateAssignment(
															assignmentDo,
															new SimpleAsyncCallback<AssignmentDo>() {

																@Override
																public void onSuccess(
																		AssignmentDo result) {
																	// Assig to
																	// classpage.
																	OpenClasspageEdit(classpageId, PlaceTokens.EDIT_CLASSPAGE);
																	newPopup.ClosePopup();
																}
															});
										}
									});
				}
			};
		}
		
	}
	
	public class OnEnterClassCodeClick implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			setEnterLblVisbility(true);
			if (txtCode.getText().trim().equalsIgnoreCase("") || txtCode.getText().trim() == null){
				alertMessageUc=new AlertMessageUc(GL0061, new Label(GL0243));
				ClickHandler alertHandler=new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						isValid=false;
						setEnterLblVisbility(false);
					}
				};
				alertMessageUc.appPopUp.addDomHandler(alertHandler, ClickEvent.getType());
				
				alertMessageUc.okButton.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						isValid=false;
						setEnterLblVisbility(false);
					}
				});
				return;
			}
			
			MixpanelUtil.ClickOnStudyNow();
			AppClientFactory.getInjector().getClasspageService().v2getClasspageByCode(txtCode.getText().trim(), new SimpleAsyncCallback<CollectionDo>(){

				@Override
				public void onFailure(Throwable caught) {
					setEnterLblVisbility(false);
				}
				
				@Override
				public void onSuccess(CollectionDo result) {
					 setEnterLblVisbility(false);
					 if(result.getGooruOid()==null){
						 Window.enableScrolling(false);
						 AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						alertMessageUc=new AlertMessageUc(GL0061, new Label(GL0244));
						ClickHandler alertHandler=new ClickHandler() {

							@Override
							public void onClick(ClickEvent event) {
								isValid=false;
								
							}
						};
						alertMessageUc.appPopUp.addDomHandler(alertHandler, ClickEvent.getType());
						
						alertMessageUc.okButton.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								isValid=false;
							}
						});
					}else if(result.getCreator().getGooruUId().equalsIgnoreCase(AppClientFactory.getGooruUid()))
					{
						
						Map<String, String> params = new HashMap<String, String>();
						params.put("id",result.getGooruOid());
						params.put("pageSize", "10");
						params.put("pageNum", "0");
						params.put("pos", "1");
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
						txtCode.setText("");
						if(alertMessageUc!=null)
						alertMessageUc.hide();
					}				 
					 else if(result.getSharing().equalsIgnoreCase("private")){
					
						if(result.getCreator().getGooruUId().equalsIgnoreCase(AppClientFactory.getGooruUid()))
						{
							if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
								MixpanelUtil.Click_Study_LandingPage();
							}
							
							Map<String, String> params = new HashMap<String, String>();
							params.put("id",result.getGooruOid());
							params.put("pageSize", "10");
							params.put("pageNum", "0");
							params.put("pos", "1");
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
							txtCode.setText("");

							if(alertMessageUc!=null)
							alertMessageUc.hide();
							
							StudentAssignmentView.setPrivatePage();

						}
						else if(result.getStatus().equalsIgnoreCase("active"))
						{
							if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
								MixpanelUtil.Click_Study_LandingPage();
							}
							
							Map<String, String> params = new HashMap<String, String>();
							params.put("id",result.getGooruOid());
							params.put("pageSize", "10");
							params.put("pageNum", "0");
							params.put("pos", "1");
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
							txtCode.setText("");
							if(alertMessageUc!=null)
							alertMessageUc.hide();
							
							StudentAssignmentView.setPrivatePageActive();

						}
						else if(result.getStatus().equalsIgnoreCase("pending")) 
						{
							if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
								MixpanelUtil.Click_Study_LandingPage();
							}
							
							Map<String, String> params = new HashMap<String, String>();
							params.put("id",result.getGooruOid());
							params.put("pageSize", "10");
							params.put("pageNum", "0");
							params.put("pos", "1");
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
							txtCode.setText("");
							if(alertMessageUc!=null)
							alertMessageUc.hide();
							
							StudentAssignmentView.setPrivatePagePending();

						}
						else 
						{
							       if(AppClientFactory.isAnonymous()){
							    	   new SentEmailSuccessVc(GL1177, GL1535);
							       }else{
							    	   new SentEmailSuccessVc(GL1177, GL1535_1);
							       }
						}
						
					}
					else
					{	
						Map<String, String> params = new HashMap<String, String>();
						params.put("id",result.getGooruOid());
						params.put("pageSize", "10");
						params.put("pageNum", "0");
						params.put("pos", "1");
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
						txtCode.setText("");
						if(alertMessageUc!=null)
						alertMessageUc.hide();
						
						if(result.getCreator().getGooruUId().equalsIgnoreCase(AppClientFactory.getGooruUid())){
							StudentAssignmentView.setPublicPage();
						}else if(result.getStatus().equalsIgnoreCase("active")){
							StudentAssignmentView.setPublicPageActive();
						}else {
							StudentAssignmentView.setPublicPagePending();
						}	
						
					}
					setEnterLblVisbility(false);
			}

			});
		}
	}
	public void setEnterLblVisbility(boolean isVisible) {
		btnEnter.setVisible(!isVisible);
		disabledBtn.setVisible(isVisible);
	}
}
