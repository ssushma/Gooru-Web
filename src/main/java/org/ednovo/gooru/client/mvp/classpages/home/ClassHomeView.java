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
package org.ednovo.gooru.client.mvp.classpages.home;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentView;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * 
 * @fileName : ClassHomeView.java
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
public class ClassHomeView extends BaseViewWithHandlers<ClassHomeUiHandlers> implements IsClassHomeView {
	
	private static ClassCodeViewUiBinder uiBinder = GWT
			.create(ClassCodeViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField Button btnCreateClass,btnEnter, disabledBtn,seeMorebtnJoined,seeMorebtnOwner;
	
	@UiField Label lblCreateAClass;
	
	@UiField HTMLPanel joinedClassesContainer,ownerClassesContainer,joinedContainerTitle,teachContainerTitle;
	
	@UiField TextBoxWithPlaceholder txtCode;
	
	AlertMessageUc alertMessageUc;
	
	private NewClasspagePopupView newPopup = null;
	
	private boolean isValid=true;
	
	private Integer pageInitialLimitJoined = 10;
	private Integer offsetLimitJoined = 0;
	
	private Integer defaultLimit = 10;
	
	private Integer pageInitialLimitOwner = 10;
	private Integer offsetLimitOwner = 0;
	
	interface ClassCodeViewUiBinder extends UiBinder<Widget, ClassHomeView> {

	}

	
	
	@Inject
	public ClassHomeView() {
		setWidget(uiBinder.createAndBindUi(this));
		
		setText();


	}
	/**
	 * 
	 */
	public void callServiceRequestsToBindData() {
		ownerClassesContainer.clear();
		joinedClassesContainer.clear();
		txtCode.setText("");
		pageInitialLimitOwner = 10;
		pageInitialLimitJoined = 10;
		offsetLimitOwner = 0;
		offsetLimitOwner = 0;
		
		AppClientFactory.getInjector().getClasspageService().v2GetUserClasses(defaultLimit.toString(), offsetLimitOwner.toString(),String.valueOf(Math.random()),
				new SimpleAsyncCallback<ClasspageListDo >() {
					@Override
					public void onSuccess(ClasspageListDo result) {
						if(result.getTotalHitCount()>pageInitialLimitOwner)
						{
							seeMorebtnOwner.setVisible(true);
						}
						else
						{
							seeMorebtnOwner.setVisible(false);
						}

						if(result.getSearchResults().size()>0)
						{
							ownerClassesContainer.getElement().setInnerHTML("");
						for(int i = 0; i<result.getSearchResults().size();i++) 
						{
							ClasspageWidgetView classpageWidget =  new ClasspageWidgetView();
							classpageWidget.setClassPageImage(result.getSearchResults().get(i),"Teach");
							ownerClassesContainer.add(classpageWidget);
						}
						}
						else
						{
							ownerClassesContainer.getElement().setInnerHTML(i18n.GL1929());
						}
						
					}
				});
		
		AppClientFactory.getInjector().getClasspageService().v2GetUserStudyClasses(defaultLimit.toString(), offsetLimitJoined.toString(),String.valueOf(Math.random()),
				new SimpleAsyncCallback<ClasspageListDo >() {
					@Override
					public void onSuccess(ClasspageListDo result) {
						if(result.getTotalHitCount()>pageInitialLimitJoined)
						{
							seeMorebtnJoined.setVisible(true);
						}
						else
						{
							seeMorebtnJoined.setVisible(false);
						}
						if(result.getSearchResults().size()>0)
						{
						joinedClassesContainer.getElement().setInnerHTML("");
						for(int i = 0; i<result.getSearchResults().size();i++) 
						{
							ClasspageWidgetView classpageWidget =  new ClasspageWidgetView();
							classpageWidget.setClassPageImage(result.getSearchResults().get(i),"Study");
							joinedClassesContainer.add(classpageWidget);
						}
						}
						else
						{
							joinedClassesContainer.getElement().setInnerHTML(i18n.GL1930());
						}
						
					}
				});
	}
	private void setCreateClassVisibility() {
		
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
		disabledBtn.setText(i18n.GL0213());		
		joinedContainerTitle.getElement().setInnerHTML(i18n.GL1925());
		joinedContainerTitle.getElement().setId("pnlJoinedContainerTitle");
		joinedContainerTitle.getElement().setAttribute("alt",i18n.GL1925());
		joinedContainerTitle.getElement().setAttribute("title",i18n.GL1925());
		
		teachContainerTitle.getElement().setInnerHTML(i18n.GL1927());	
		teachContainerTitle.getElement().setId("pnlTeachContainerTitle");
		teachContainerTitle.getElement().setAttribute("alt",i18n.GL1927());
		teachContainerTitle.getElement().setAttribute("title",i18n.GL1927());
		
		txtCode.setPlaceholder(i18n.GL1785());		
		txtCode.getElement().setId("txtCode");
		txtCode.getElement().setAttribute("alt",i18n.GL1785());
		txtCode.getElement().setAttribute("title",i18n.GL1785());
		
		btnEnter.setText(i18n.GL0213());	
		btnEnter.getElement().setId("btnEnter");
		btnEnter.getElement().setAttribute("alt",i18n.GL0213());
		btnEnter.getElement().setAttribute("title",i18n.GL0213());
		
		btnCreateClass.getElement().setInnerHTML(i18n.GL1928());	
		btnCreateClass.getElement().setId("btnCreateClass");
		btnCreateClass.getElement().setAttribute("alt",i18n.GL1928());
		btnCreateClass.getElement().setAttribute("title",i18n.GL1928());
		
		disabledBtn.setVisible(false);	
		seeMorebtnJoined.setText(i18n.GL0508());
		seeMorebtnJoined.getElement().setId("btnSeeMoreJoined");
		seeMorebtnJoined.getElement().setAttribute("alt",i18n.GL0508());
		seeMorebtnJoined.getElement().setAttribute("title",i18n.GL0508());
		
		seeMorebtnOwner.setText(i18n.GL0508());
		seeMorebtnOwner.getElement().setId("btnSeeMoreOwner");
		seeMorebtnOwner.getElement().setAttribute("alt",i18n.GL0508());
		seeMorebtnOwner.getElement().setAttribute("title",i18n.GL0508());
		
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
		seeMorebtnJoined.addClickHandler(new OnClickSeeMoreJoined());
		seeMorebtnOwner.addClickHandler(new OnClickSeeMoreOwner());
		joinedClassesContainer.getElement().setId("pnljJoinedClassesContainer");
		lblCreateAClass.getElement().setId("lblCreateAClass");
		ownerClassesContainer.getElement().setId("pnlOwnerClassesContainer");
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
	 * @fileName : ClassHomeView.java
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
	 * @fileName : ClassHomeView.java
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
	 * @fileName : ClassHomeView.java
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
	public class OnClickSeeMoreJoined implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {		
			offsetLimitJoined = pageInitialLimitJoined;
			AppClientFactory.getInjector().getClasspageService().v2GetUserStudyClasses(defaultLimit.toString(), offsetLimitJoined.toString(),String.valueOf(Math.random()),
					new SimpleAsyncCallback<ClasspageListDo >() {
						@Override
						public void onSuccess(ClasspageListDo result) {
							pageInitialLimitJoined = pageInitialLimitJoined + 10;
							if(result.getTotalHitCount()>pageInitialLimitJoined)
							{
								seeMorebtnJoined.setVisible(true);
							}
							else
							{
								seeMorebtnJoined.setVisible(false);
							}


							for(int i = 0; i<result.getSearchResults().size();i++) 
							{
								ClasspageWidgetView classpageWidget =  new ClasspageWidgetView();
								classpageWidget.setClassPageImage(result.getSearchResults().get(i),"Study");
								joinedClassesContainer.add(classpageWidget);
							}

							
						}
					});
		}
		
	}
	/**
	 * 
	 * @fileName : ClassHomeView.java
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
	public class OnClickSeeMoreOwner implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {	
			offsetLimitOwner = pageInitialLimitOwner;
			AppClientFactory.getInjector().getClasspageService().v2GetUserClasses(defaultLimit.toString(), offsetLimitOwner.toString(),String.valueOf(Math.random()),
					new SimpleAsyncCallback<ClasspageListDo >() {
						@Override
						public void onSuccess(ClasspageListDo result) {
							pageInitialLimitOwner = pageInitialLimitOwner + 10;
							if(result.getTotalHitCount()>pageInitialLimitOwner)
							{
								seeMorebtnOwner.setVisible(true);
							}
							else
							{
								seeMorebtnOwner.setVisible(false);
							}


							for(int i = 0; i<result.getSearchResults().size();i++) 
							{
								ClasspageWidgetView classpageWidget =  new ClasspageWidgetView();
								classpageWidget.setClassPageImage(result.getSearchResults().get(i),"Teach");
								ownerClassesContainer.add(classpageWidget);
							}

							
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
