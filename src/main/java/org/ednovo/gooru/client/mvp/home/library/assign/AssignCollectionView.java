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
package org.ednovo.gooru.client.mvp.home.library.assign;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionEditShareEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.TaskResourceAssocDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AssignCollectionView.java
 *
 * @description : This class is used to set the Editing collection to Assignment under Classpages.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class AssignCollectionView extends ChildView<AssignCollectionPresenter> implements
IsCollectionAssign, MessageProperties {

	@UiField(provided = true)
	AssignPopUpCBundle res;
	
	@UiField Label lblAssignCollectionTitle,lblClasspages,lblClasspagePlaceHolder, lblClasspagesArrow,lblAssignmentsArrow, lblAssignments, lblAssignmentsPlaceHolder, lblNoAssignments;
	

	@UiField Label lblAssignCollectionPrivate, lblAssignmentErrorMsg,lblNoClassPageMsg,lblNoClassPage;
	
	@UiField BlueButtonUc btnAssign;
	
	@UiField ScrollPanel spanelClasspagesPanel, spanelAssignmentsPanel;
	
	@UiField HTMLPanel htmlClasspagesListContainer, htmlAssignmentsListContainer;
	
	@UiField HTMLPanel  panelAssignmentsControls,panelNoClasspages,htmlPanelContainer,panelTitleContainer;
	
	@UiField HTMLPanel controlsContainer;
	
	@UiField HTMLPanel assignMoreCpContainer;
	
	@UiField Label assignMoreCpLbl;
	
	@UiField Button classPageBtn;
	
	private SimpleAsyncCallback<ClasspageListDo> getClasspageList;	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;	
	private SimpleAsyncCallback<CollectionDo> collectionDoAsyncCallback;	
	
	String toAssignStr = null;	
	String limit="10";//pagesize	
	int classpageOffSet=0;
	int assignmentOffSet=0;	
	boolean isApiCalling=false;	
	boolean toClear=true;	
	boolean isAdded = false;	
	List<String> collectionsList = new ArrayList<String>();
	boolean toClearAssignment = true;	
	boolean isAssignmentsEnabled = false;
	CollectionDo collectionDoGlobal = new CollectionDo();	
	String classpageId=null;	
	String assignmentId=null;	
	boolean isMoreThanLimit=false;	//Limit = 10	
	String shareType=null;

	
	private ClasspageServiceAsync classpageService;	

	private static AssignCollectionViewUiBinder uiBinder = GWT.create(AssignCollectionViewUiBinder.class);

	interface AssignCollectionViewUiBinder extends UiBinder<Widget, AssignCollectionView> {
	}

	
	
	/**
	 * Class constructor
	 */
	public AssignCollectionView(CollectionDo collectionDoObject) {
		
	
		res = AssignPopUpCBundle.INSTANCE;
		AssignPopUpCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		
		toAssignStr = collectionDoObject.getGooruOid();
		collectionDoGlobal = collectionDoObject;

		getClassPageData();
	}
	/**
	 * 
	 * @function getClassPageData 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to get classpage Data.
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
	public void getClassPageData() {
		lblNoClassPage.setText(MessageProperties.GL0106);
		lblNoClassPageMsg.setText(MessageProperties.GL0504);
		setLabelsAndIds();
		htmlPanelContainer.setVisible(false);
		panelNoClasspages.setVisible(false);
		onLoaded();
		panelTitleContainer.getElement().getStyle().setMarginBottom(15, Unit.PX);
		spanelClasspagesPanel.setVisible(false);
		spanelClasspagesPanel.addScrollHandler(new ScrollHandler() {
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelClasspagesPanel.getVerticalScrollPosition() == spanelClasspagesPanel.getMaximumVerticalScrollPosition()){
					toClear = false;
					getNextClasspages();
				}
			}
		});
		
		
		spanelAssignmentsPanel.addScrollHandler(new ScrollHandler() {
			
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelAssignmentsPanel.getVerticalScrollPosition() == spanelAssignmentsPanel.getMaximumVerticalScrollPosition()){
					toClearAssignment = false;
					getNextAssignments();
				}
			}
		});
		
		getClasspage(collectionDoGlobal, null);
		assignMoreCpContainer.setVisible(false);
	}
	
	/**
	 * 
	 * @function onLoaded 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :
	 * 
	 * 
	 * @parm(s) : This is used to set the Classpage Data.
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void onLoaded(){
		
		setGetClasspageList(new SimpleAsyncCallback<ClasspageListDo>() {

			@Override
			public void onSuccess(ClasspageListDo result) 
			{				
				setClasspageData(result);
			}
		});
		setAssignmentsListAsyncCallback(new SimpleAsyncCallback<AssignmentsListDo>() {

			@Override
			public void onSuccess(AssignmentsListDo result) {
				isApiCalling = false;
				setAssignmentData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	
	}
	
	/** 
	 * This method is to get the getClasspageList
	 */
	public SimpleAsyncCallback<ClasspageListDo> getGetClasspageList() {
		return getClasspageList;
	}
	/**
	 * 
	 * @function getClasspageService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : Returns ClasspageServiceAsync.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : ClasspageServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}
	/**
	 * 
	 * @function setClasspageService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to initialize classpageService.
	 * 
	 * 
	 * @parm(s) : @param classpageService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}
	/**
	 * 
	 * @function getCollectionDoAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns collectionDoAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionDoAsyncCallback() {
		return collectionDoAsyncCallback;
	}



	public void setCollectionDoAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionDoAsyncCallback) {
		this.collectionDoAsyncCallback = collectionDoAsyncCallback;
	}
	/** 
	 * This method is to set the getClasspageList
	 */
	public void setGetClasspageList(SimpleAsyncCallback<ClasspageListDo> getClasspageList) {
		this.getClasspageList = getClasspageList;
	}
	/**
	 * 
	 * @function getAssignmentsByClasspageId 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to get Assignments By Classpage Id.
	 * 
	 * 
	 * @parm(s) : @param classpageId
	 * @parm(s) : @param pageSize
	 * @parm(s) : @param pageNum
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void getAssignmentsByClasspageId(String classpageId,String pageSize, String pageNum) {
		this.classpageId = classpageId;
		AppClientFactory.getInjector().getClasspageService().v2GetAssignemtsByClasspageId(classpageId, pageSize, pageNum, getAssignmentsListAsyncCallback());
	}

	/** 
	 * This method is to get the assignmentsListAsyncCallback
	 */
	public SimpleAsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentsListAsyncCallback
	 */
	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}
	/**
	 * 
	 * @function getNextAssignments 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to get Next Assignments.
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
	public void getNextAssignments() {
		if (classpageId!=null){
			assignmentOffSet = assignmentOffSet+10;
			getAssignmentsByClasspageId(classpageId, limit, String.valueOf(assignmentOffSet));
		}
	}
	
	/** 
	 * This method is to get the assignmentOffSet
	 */
	public int getAssignmentOffSet() {
		return assignmentOffSet;
	}

	/** 
	 * This method is to set the assignmentOffSet
	 */
	public void setAssignmentOffSet(int assignmentOffSet) {
		this.assignmentOffSet = assignmentOffSet;
	}
	/** 
	 * This method is to get the shareType
	 */
	public String getShareType() {
		return shareType;
	}

	/** 
	 * This method is to set the shareType
	 */
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}	
	/**
	 * 
	 * @function setPrivateLableVisibility 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This is used to visible the lblAssignCollectionPrivate.
	 * 
	 * 
	 * @parm(s) : @param visibility
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setPrivateLableVisibility(boolean visibility) {
		lblAssignCollectionPrivate.setVisible(visibility);
	}
	
	/**
	 * 
	 * @function setClasspageData 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description
	 * 		Create Classpage (title) label and set to Classpage list box
	 * 
	 * @parm(s) : @param classpageListDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setClasspageData(ClasspageListDo classpageListDo){
		


		int resultSize = classpageListDo.getSearchResults().size();
		if (resultSize > 0){
			//htmlEvenPanelContainer.setVisible(true);
			htmlPanelContainer.setVisible(true);
			if (toClear){
				htmlClasspagesListContainer.clear();
				toClear=false;
			}
			for (int i = 0; i < resultSize; i++) {
				String classpageTitle = classpageListDo.getSearchResults().get(i).getTitle();
				classpageId = classpageListDo.getSearchResults().get(i).getGooruOid();
				final Label titleLabel = new Label(classpageTitle);
				titleLabel.setStyleName(AssignPopUpCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", classpageId);
				//Set Click event for title
				titleLabel.addClickHandler(new CpTitleLabelClick(titleLabel));
				htmlClasspagesListContainer.add(titleLabel);
			}
		}else{
			//Set if there are not classpages.
			if (toClear){
				htmlPanelContainer.setVisible(false);
				panelNoClasspages.setVisible(true);
				
			}
		}
	}
	/**
	 * 
	 * @fileName : AssignCollectionView.java
	 *
	 * @description : This is to Call API to get List of Assignment associated to this.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class CpTitleLabelClick implements ClickHandler{
		/**
		 * @param titleLabel
		 */
		
		private Label titleLabel;
		public CpTitleLabelClick(Label titleLabel) {
			this.titleLabel = titleLabel;
		}

		@Override
		public void onClick(ClickEvent event) {
			lblClasspagePlaceHolder.setText(titleLabel.getText());
			lblClasspagePlaceHolder.getElement().setId(titleLabel.getElement().getId());
			lblClasspagePlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
			
			classpageId = titleLabel.getElement().getId();
			

			//Call API to get List of Assignment associated to this.
			getAssignmentsByClasspageId(titleLabel.getElement().getId(), "10", "0");
			
			

			
			lblNoAssignments.setText(MessageProperties.GL0110);
			lblNoAssignments.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			panelAssignmentsControls.setVisible(false);
			
			//Hide the scroll container
			spanelClasspagesPanel.setVisible(false);
		}
	}
	/**
	 * 
	 * @function setAssignmentData 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to set Assignment Data.
	 * 
	 * 
	 * @parm(s) : @param result
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setAssignmentData(AssignmentsListDo result) {
		int resultSize = result.getSearchResults().size();
		if (resultSize > 0){
			enableAssignment();
			panelAssignmentsControls.setVisible(true);
			lblNoAssignments.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			htmlAssignmentsListContainer.clear();
			for (int i = 0; i < resultSize; i++) {
				String assignmentTitle = result.getSearchResults().get(i).getTask().getTitle();
				assignmentId = result.getSearchResults().get(i).getTask().getGooruOid();
				final Label titleLabel = new Label(assignmentTitle);
				titleLabel.setStyleName(AssignPopUpCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", assignmentId);
				//Set Click event for title
				titleLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {						
						lblAssignmentsPlaceHolder.setText(titleLabel.getText());
						lblAssignmentsPlaceHolder.getElement().setId(titleLabel.getElement().getId());
						lblAssignmentsPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
						
						lblAssignmentErrorMsg.setVisible(false);
						
						assignmentId = titleLabel.getElement().getId();
						//Call get all Collections associated to Assigment and then enable the Assign button
						getAssignmentCollections(assignmentId);
						
						
						
						//Hide the scroll container
						spanelAssignmentsPanel.setVisible(false);
					}
				});
				htmlAssignmentsListContainer.add(titleLabel);
			}
		}else{
			//Set if there are not Assignments.
			if (toClearAssignment){
				lblNoAssignments.setText(MessageProperties.GL0111);
				lblNoAssignments.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				panelAssignmentsControls.setVisible(false);
			}
		}
	}
	/**
	 * 
	 * @function setCollectionDo 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Setter method for collectionDo.
	 * 
	 * 
	 * @parm(s) : @param collectionDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCollectionDo(CollectionDo collectionDo) {
		this.collectionDoGlobal = collectionDo;

	}
	/**
	 * 
	 * @function enableAssignment 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to enable assignment.
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
	public void enableAssignment(){
		lblAssignments.setStyleName(AssignPopUpCBundle.INSTANCE.css().labelText());
		isAssignmentsEnabled = true;
	}
	/**
	 * 
	 * @function getAssignmentCollections 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :You can Assign collection if the max no doesn't exceeds 10.Otherwise you can assign.
	 * 
	 * 
	 * @parm(s) : @param assignmentId
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public boolean getAssignmentCollections(String assignmentId){
		isMoreThanLimit=false;
		isAdded=false;
		AppClientFactory.getInjector().getClasspageService().v2GetAssignmentCollectionsById(assignmentId, new SimpleAsyncCallback<List<ResourceDo>>() {

			@Override
			public void onSuccess(List<ResourceDo> result) {
				
				isMoreThanLimit = result.size()>=10 ? true : false;
				collectionsList = new ArrayList<String>();				
				collectionsList.clear();
				
				
				
				for (ResourceDo resourceDo : result){
	
					if (toAssignStr.equalsIgnoreCase(resourceDo.getGooruOid().toString())){
						isAdded = true;
						break;
					}
				}

				
				if (!isMoreThanLimit){
					if (!isAdded){
						btnAssign.setEnabled(true);
						btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().activeAssignButton());
					}else{
						//You can't add this collection, because this already added
						lblAssignmentErrorMsg.setVisible(true);
						lblAssignmentErrorMsg.setText(MessageProperties.GL0114);
					}
				}else{
					// You can't add this collection, because the assignment has 10 collections
					lblAssignmentErrorMsg.setVisible(true);
					lblAssignmentErrorMsg.setText(MessageProperties.GL0113);
					
				}
			}
		});
		
		return isMoreThanLimit;
	}
	/**
	 * 
	 * @function ClickOnPlaceHolder 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This UIHandler is used to open Assignments Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("lblAssignmentsPlaceHolder")
	public void ClickOnPlaceHolder(ClickEvent event){
		OpenAssignmentsContainer();
	}
	/**
	 * 
	 * @function ClickOnPlaceHolder 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This UIHandler is used to open Assignments Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("lblAssignmentsArrow")
	public void ClickOnArrow(ClickEvent event){
		OpenAssignmentsContainer();
	}
	/**
	 * 
	 * @function OpenAssignmentsContainer 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to open Assignments Container.
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
	public void OpenAssignmentsContainer(){
		if (isAssignmentsEnabled){
			spanelAssignmentsPanel.setVisible(!spanelAssignmentsPanel.isVisible());
			if (spanelClasspagesPanel.isVisible()){
				spanelClasspagesPanel.setVisible(false);
			}
		}
	}
	/**
	 * 
	 * @function OnClickAssign 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This UIHandler is used to do Api call for adding Collection to Assignment
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("btnAssign")
	public void OnClickAssign(ClickEvent event){
		TaskResourceAssocDo taskResourceAssocDo = new TaskResourceAssocDo();
		ResourceDo resourceDo = new ResourceDo();
		resourceDo.setGooruOid(toAssignStr);
		taskResourceAssocDo.setResource(resourceDo);
		
		
		//Track Mixpanel
		MixpanelUtil.Click_Assign_Click();
		// Api call for adding Collection to Assignment
		if(collectionDoGlobal.getSharing() != null)
		{
		if (collectionDoGlobal.getSharing().equalsIgnoreCase("private")){
			updateShare("anyonewithlink");
			setShareType("anyonewithlink");
			lblAssignCollectionPrivate.setVisible(false);
			collectionDoGlobal.setSharing("anyonewithlink");
		}else{
			
		}
		}
		

		AppClientFactory.getInjector().getClasspageService().v2AddCollectionToAssignment(assignmentId,taskResourceAssocDo, new SimpleAsyncCallback<TaskResourceAssocDo>() {
			@Override
			public void onSuccess(TaskResourceAssocDo result) {
				//closePoupfromChild();
				MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
				
				controlsContainer.setVisible(false);
				btnAssign.setVisible(false);
				
				assignMoreCpContainer.setVisible(true);
				assignMoreCpLbl.setText("You have successfully assigned this collection to "+lblClasspagePlaceHolder.getText());
				
/*				SuccessPopupAssignVc successPopupVc = new SuccessPopupAssignVc(lblAssignmentsPlaceHolder.getText(), collectionDoGlobal.getTitle(), lblClasspagePlaceHolder.getText()) {
					
					@Override
					public void closePoup() {
					
						lblClasspagePlaceHolder.setText(MessageProperties.GL0105);
						lblClasspagePlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());
						lblAssignCollectionPrivate.setVisible(false);

						getAllClasspages("10", "0");
						
						Window.enableScrolling(true);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
					
						
				        this.hide();
				        
					}
				};
				successPopupVc.center();
				successPopupVc.show();
*/
			}

		});
		
		MixpanelUtil.mixpanelEvent("CoursePage_Assign_Collection");
	}
	/**
	 * 
	 * @function classPageBtnClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This UIHandler is used to get classpage data.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("classPageBtn")
	public void classPageBtnClicked(ClickEvent event) {
		htmlClasspagesListContainer.clear();
		controlsContainer.setVisible(true);
		btnAssign.setVisible(true);
		getClassPageData();
	}
	/**
	 * 
	 * @function updateShare 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This methodis used to uodate sharing status.
	 * 
	 * 
	 * @parm(s) : @param shareType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void updateShare(String shareType) 
	{
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDoGlobal.getGooruOid(), null, null, null, shareType, null, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDoGlobal = result;
				AppClientFactory.fireEvent(new CollectionEditShareEvent(result.getSharing()));
			}
		});
	}
	/**
	 * This is used to get DragHandle.
	 */
	@Override
	public Widget getDragHandle() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *To get initDraggableMirage
	 */
	@Override
	public IsDraggableMirage initDraggableMirage() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This will execute on blur handler of DragEvent.
	 */
	@Override
	public void onDragBlur() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This is used to get the Drag id.
	 */
	@Override
	public String getDragId() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This is used to get the Drag Type.
	 */
	@Override
	public DRAG_TYPE getDragType() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * This is used to get the Drag TopCorrection.
	 */
	@Override
	public int getDragTopCorrection() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * This is used to get the Drag Left Correction..
	 */

	@Override
	public int getDragLeftCorrection() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @function getClasspage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to get class page data.
	 * 
	 * 
	 * @parm(s) : @param collectionDo
	 * @parm(s) : @param shareType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void getClasspage(CollectionDo collectionDo, String shareType){
		this.shareType = shareType;
		this.collectionDoGlobal = collectionDo;
	
		setCollectionDo(collectionDo);
		
				//This condition is added because, this method is called thrice from shelf
			classpageOffSet = 0;
			isApiCalling = true;
			/**
			 * getting available classpages of the user
			 */
			getAllClasspages(limit, String.valueOf(classpageOffSet));
			
			//hideContainers();
		
	}
	/**
	 * 
	 * @function getAllClasspages 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to get all the class pages.
	 * 
	 * 
	 * @parm(s) : @param limit
	 * @parm(s) : @param offSet
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void getAllClasspages(String limit, String offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetAllClasspages(limit, offSet, getGetClasspageList());
		
		
	}
	/**
	 * 
	 * @function getNextClasspages 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to get all the classpages.
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
	public void getNextClasspages() {
		classpageOffSet = classpageOffSet+10;
		getAllClasspages(limit,String.valueOf(classpageOffSet));
	}
	/**
	 * 
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To open Class Page Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("lblClasspagePlaceHolder")
	public void OnClickClasspagePlaceHolder(ClickEvent event){
		OpenClasspageContainer();
	}
	/**
	 * 
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To open Class Page Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("lblClasspagesArrow")
	public void OnClickClasspageArrow(ClickEvent event){
		OpenClasspageContainer();
	}
	/**
	 * 
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To method is to open Class Page Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void OpenClasspageContainer(){
		spanelClasspagesPanel.setVisible(!spanelClasspagesPanel.isVisible());
		if (spanelAssignmentsPanel.isVisible()){
			spanelAssignmentsPanel.setVisible(false);
		}
		
		
	}
	/**
	 * 
	 * @function setLabelsAndIds 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To set all the lables
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
	public void setLabelsAndIds()
	{
		
		lblAssignCollectionPrivate.setText(MessageProperties.GL0112);
		lblAssignCollectionPrivate.setVisible(false);
		
		lblAssignCollectionTitle.setText(MessageProperties.GL0101);
		lblClasspages.setText(MessageProperties.GL0102);
		lblAssignments.setText(MessageProperties.GL0103);
		
		btnAssign.setText(MessageProperties.GL0104);
		
		lblClasspagePlaceHolder.setText(MessageProperties.GL0105);
		lblAssignmentsPlaceHolder.setText(MessageProperties.GL0105);
		
	
		//Ids
		btnAssign.getElement().setAttribute("id", "btnAssign");
		btnAssign.setStyleName(res.css().disableAssignButon());
		btnAssign.getElement().getStyle().setMarginLeft(190, Unit.PX);
		btnAssign.setEnabled(false);
		btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().disableAssignButon());

		lblClasspagePlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());
		lblAssignmentsPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());

		
	}
	
	public abstract void closePoupfromChild();
	
	
}
