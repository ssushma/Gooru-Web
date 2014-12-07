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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;

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
/**
 * 
 * @fileName : ClassCodeView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 07-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class ClassCodeView extends BaseViewWithHandlers<ClassCodeUiHandlers> implements IsClassCodeView {
	
	private static ClassCodeViewUiBinder uiBinder = GWT
			.create(ClassCodeViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField Button btnCreateClass,btnEnter, disabledBtn;
	
	@UiField Label lblCreateAClass,lblEasyToOrganize,lblAccessAClass,lblEasyAccessForStudents,lblUniqueClassCode, lblOne, lblTwo, lblThree;
	
	@UiField Label lblManageAssignments,lblClearDue,lblMonitorStudentProgress,lblMonitorDesc, lblFavoriteClasses, lblClassOne, lblClassTwo, lblClassThree, lblClassFour;
	
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
	/**
	 * 
	 * @function setCreateClassVisibility 
	 * 
	 * @created_date : 07-Dec-2014
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
	private void setCreateClassVisibility() {
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
		
		btnCreateClass.setText(i18n.GL1771());
		btnCreateClass.getElement().setId("btnCreateClass");
		btnCreateClass.getElement().setAttribute("alt",i18n.GL1771());
		btnCreateClass.getElement().setAttribute("title",i18n.GL1771());
		
		btnEnter.setText(i18n.GL0213());
		btnEnter.getElement().setId("btnEnter");
		btnEnter.getElement().setAttribute("alt",i18n.GL0213());
		btnEnter.getElement().setAttribute("title",i18n.GL0213());
		
		disabledBtn.setText(i18n.GL0213());
		disabledBtn.getElement().setId("btnDisable");
		disabledBtn.getElement().setAttribute("alt",i18n.GL0213());
		disabledBtn.getElement().setAttribute("title",i18n.GL0213());
		
		lblCreateAClass.setText(i18n.GL1771());
		lblCreateAClass.getElement().setId("lblCreateAClass");
		lblCreateAClass.getElement().setAttribute("alt",i18n.GL1771());
		lblCreateAClass.getElement().setAttribute("title",i18n.GL1771());
		
		lblEasyToOrganize.setText(i18n.GL1772());
		lblEasyToOrganize.getElement().setId("lblEasyToOrganize");
		lblEasyToOrganize.getElement().setAttribute("alt",i18n.GL1772());
		lblEasyToOrganize.getElement().setAttribute("title",i18n.GL1772());
		
		lblAccessAClass.setText(i18n.GL1773());
		lblAccessAClass.getElement().setId("lblAccessAClass");
		lblAccessAClass.getElement().setAttribute("alt",i18n.GL1773());
		lblAccessAClass.getElement().setAttribute("title",i18n.GL1773());
		
		lblEasyAccessForStudents.setText(i18n.GL1774());
		lblEasyAccessForStudents.getElement().setId("lblEasyAccessForStudents");
		lblEasyAccessForStudents.getElement().setAttribute("alt",i18n.GL1774());
		lblEasyAccessForStudents.getElement().setAttribute("title",i18n.GL1774());
		
		lblUniqueClassCode.setText(i18n.GL1775());
		lblUniqueClassCode.getElement().setId("lblUniqueClassCode");
		lblUniqueClassCode.getElement().setAttribute("alt",i18n.GL1775());
		lblUniqueClassCode.getElement().setAttribute("title",i18n.GL1775());
		
		lblOne.setText(i18n.GL_GRR_NUMERIC_ONE());
		lblOne.getElement().setId("lblOne");
		lblOne.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_ONE());
		lblOne.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_ONE());
		
		lblTwo.setText(i18n.GL_GRR_NUMERIC_TWO());
		lblTwo.getElement().setId("lblTwo");
		lblTwo.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_TWO());
		lblTwo.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_TWO());
		
		lblThree.setText(i18n.GL_GRR_NUMERIC_THREE());
		lblThree.getElement().setId("lblThree");
		lblThree.getElement().setAttribute("alt",i18n.GL_GRR_NUMERIC_THREE());
		lblThree.getElement().setAttribute("title",i18n.GL_GRR_NUMERIC_THREE());
		
		lblManageAssignments.setText(i18n.GL1776());
		lblManageAssignments.getElement().setId("lblManageAssignments");
		lblManageAssignments.getElement().setAttribute("alt",i18n.GL1776());
		lblManageAssignments.getElement().setAttribute("title",i18n.GL1776());
		
		lblClearDue.setText(i18n.GL1777());
		lblClearDue.getElement().setId("lblClearDue");
		lblClearDue.getElement().setAttribute("alt",i18n.GL1777());
		lblClearDue.getElement().setAttribute("title",i18n.GL1777());
		
		lblMonitorStudentProgress.setText(i18n.GL1778());
		lblMonitorStudentProgress.getElement().setId("lblMonitorStudentProgress");
		lblMonitorStudentProgress.getElement().setAttribute("alt",i18n.GL1778());
		lblMonitorStudentProgress.getElement().setAttribute("title",i18n.GL1778());
		
		lblMonitorDesc.setText(i18n.GL1779());
		lblMonitorDesc.getElement().setId("lblMonitorDesc");
		lblMonitorDesc.getElement().setAttribute("alt",i18n.GL1779());
		lblMonitorDesc.getElement().setAttribute("title",i18n.GL1779());
		
		ancSampleReport.setText(i18n.GL1780());
		ancSampleReport.getElement().setId("lnkSampleReport");
		ancSampleReport.getElement().setAttribute("alt",i18n.GL1780());
		ancSampleReport.getElement().setAttribute("title",i18n.GL1780());
		ancSampleReport.setVisible(false);
		
		lblFavoriteClasses.setText(i18n.GL1781());
		lblFavoriteClasses.getElement().setId("lblFavoriteClasses");
		lblFavoriteClasses.getElement().setAttribute("alt",i18n.GL1781());
		lblFavoriteClasses.getElement().setAttribute("title",i18n.GL1781());
		
		lblClassOne.setText(i18n.GL1782());
		lblClassOne.getElement().setId("lblClassOne");
		lblClassOne.getElement().setAttribute("alt",i18n.GL1782());
		lblClassOne.getElement().setAttribute("title",i18n.GL1782());
		
		lblClassTwo.setText(i18n.GL1783());
		lblClassTwo.getElement().setId("lblClassTwo");
		lblClassTwo.getElement().setAttribute("alt",i18n.GL1783());
		lblClassTwo.getElement().setAttribute("title",i18n.GL1783());
		
		lblClassThree.setText(i18n.GL1784());	
		lblClassThree.getElement().setId("lblClassThree");
		lblClassThree.getElement().setAttribute("alt",i18n.GL1784());
		lblClassThree.getElement().setAttribute("title",i18n.GL1784());
		
		lblClassFour.setText( i18n.GL1784_1());
		lblClassFour.getElement().setId("lblClassFour");
		lblClassFour.getElement().setAttribute("alt",i18n.GL1784_1());
		lblClassFour.getElement().setAttribute("title",i18n.GL1784_1());
		
		txtCode.setPlaceholder(i18n.GL1785());
		txtCode.getElement().setId("txtCode");
		panelClassOne.getElement().setId("pnlClassOne");
		panelClassTwo.getElement().setId("pnlClassTwo");
		panelClassThree.getElement().setId("pnlClassThree");
		panelClassFour.getElement().setId("pnlClassFour");
		
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
		OpenClasspageEdit("272e9c46-c0a9-427a-9a0d-f31eb051ce3a", PlaceTokens.STUDENT);
	}
	
	@UiHandler("panelClassTwo")
	public void OpenSecondClass(ClickEvent event){
		OpenClasspageEdit("087ddf35-6b2b-4411-9832-d8e789a25888", PlaceTokens.STUDENT);
	}

	@UiHandler("panelClassThree")
	public void OpenThreeClass(ClickEvent event){
		OpenClasspageEdit("6b2fbea8-b3e9-4b74-937b-28e209049eec", PlaceTokens.STUDENT);
	}
	@UiHandler("panelClassFour")
	public void OpenFourClass(ClickEvent event){
		OpenClasspageEdit("18c2e8db-ffcc-471e-960b-78b5ae30b98d", PlaceTokens.STUDENT);
	}
	
	/**
	 * 
	 * @function OpenClasspageEdit 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param gooruOId
	 * @parm(s) : @param token
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void OpenClasspageEdit(String gooruOId, String token) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", gooruOId);
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
	/**
	 * 
	 * @fileName : ClassCodeView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 07-Dec-2014
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer:
	 */
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
											taskDo.setTitle(i18n.GL0121());
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
	/**
	 * 
	 * @fileName : ClassCodeView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 07-Dec-2014
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer:
	 */
	public class OnEnterClassCodeClick implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			setEnterLblVisbility(true);
			if (txtCode.getText().trim().equalsIgnoreCase("") || txtCode.getText().trim() == null){
				alertMessageUc=new AlertMessageUc(i18n.GL0061(), new Label(i18n.GL0243()));
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

//				@Override
//				public void onFailure(Throwable caught) {
//					setEnterLblVisbility(false);
//				}
				
				@Override
				public void onSuccess(CollectionDo result) {
					 setEnterLblVisbility(false);
					 if(result.getGooruOid()==null){
						 Window.enableScrolling(false);
						 AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
						alertMessageUc=new AlertMessageUc(i18n.GL0061(), new Label(i18n.GL0244()));
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
							    	   new SentEmailSuccessVc(i18n.GL1177(), i18n.GL1535());
							       }else{
							    	   new SentEmailSuccessVc(i18n.GL1177(), i18n.GL1535_1());
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
	/**
	 * 
	 * @function setEnterLblVisbility 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param isVisible
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setEnterLblVisbility(boolean isVisible) {
		btnEnter.setVisible(!isVisible);
		disabledBtn.setVisible(isVisible);
	}
}
