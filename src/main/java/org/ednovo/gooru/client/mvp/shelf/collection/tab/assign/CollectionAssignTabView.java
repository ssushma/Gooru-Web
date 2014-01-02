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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionEditShareEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : CollectionAssignTabView.java
 *
 * @description : This class is used to set the Editing collection to Assignment under Classpages.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionAssignTabView extends BaseViewWithHandlers<CollectionAssignTabUiHandlers> implements IsCollectionAssignTab {

	@UiField(provided = true)
	CollectionAssignCBundle res;
	
	boolean toClear=true;
	
	boolean isAdded = false;
	
	List<String> collectionsList = new ArrayList<String>();

	boolean toClearAssignment = true;
	
	boolean isAssignmentsEnabled = false;

	private CollectionDo collectionDo;
	
	String classpageId=null;
	
	String assignmentId=null;
	
	boolean isMoreThanLimit=false;	//Limit = 10

	private static CollectionAssignViewTabUiBinder uiBinder = GWT.create(CollectionAssignViewTabUiBinder.class);

	interface CollectionAssignViewTabUiBinder extends UiBinder<Widget, CollectionAssignTabView> {
	}

	
	//Labels
	@UiField Label lblAssignCollectionTitle,lblClasspages,lblClasspagePlaceHolder, lblClasspagesArrow,lblAssignmentsArrow, lblAssignments, lblAssignmentsPlaceHolder, lblNoAssignments;
	
	@UiField Label lblAssignCollectionPrivate, lblAssignmentErrorMsg;
	
	@UiField BlueButtonUc btnAssign;
	
	@UiField ScrollPanel spanelClasspagesPanel, spanelAssignmentsPanel;
	
	@UiField HTMLPanel htmlClasspagesListContainer, htmlAssignmentsListContainer;
	
	@UiField HTMLEventPanel htmlEvenPanelContainer;
	
	@UiField HTMLPanel panelNoClasspages, panelLoading, panelAssignmentsControls;
    @UiField Label lblNoClasspages; 
    @UiField HTML htmlTab, htmlGoto,ancTeach;
    
	/**
	 * Class constructor
	 */
	public CollectionAssignTabView() {
		
		res = CollectionAssignCBundle.INSTANCE;
		CollectionAssignCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		
		setLabelsAndIds();
		
		showHideScrollPanel(false);
		
		hideContainers();
		
		spanelClasspagesPanel.addScrollHandler(new ScrollHandler() {
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelClasspagesPanel.getVerticalScrollPosition() == spanelClasspagesPanel.getMaximumVerticalScrollPosition()){
					toClear = false;
					getUiHandlers().getNextClasspages();
				}
			}
		});
		
		spanelAssignmentsPanel.addScrollHandler(new ScrollHandler() {
			
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelAssignmentsPanel.getVerticalScrollPosition() == spanelAssignmentsPanel.getMaximumVerticalScrollPosition()){
					toClearAssignment = false;
					getUiHandlers().getNextAssignments();
				}
			}
		});
	}
	/**
	 * This method is called immediately before a widget will be detached from the browser's document.
	 */
	@Override
	public void onUnload() {
		setCollectionDo(null);
		
		setLabelsAndIds();
		
		showHideScrollPanel(false);
		
		toClear= true;
		
		htmlAssignmentsListContainer.clear();
		htmlClasspagesListContainer.clear();
		lblAssignmentErrorMsg.setVisible(false);
	}
	/**
	 * This is used to reset the data.
	 */
	@Override
	public void reset() {
		super.reset();
		lblAssignmentErrorMsg.setVisible(false);
	}
	
	/**
	 * 
	 * @function setLabelsAndIds 
	 * 
	 * @created_date : Jul 30, 2013
	 * 
	 * @description
	 * 	To set the default values for labels, button and id for button.
	 * 
	 * @parm(s) : NONE
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setLabelsAndIds(){
		
		lblAssignCollectionPrivate.setText(MessageProperties.GL0112);
		lblAssignCollectionPrivate.setVisible(false);
		
		lblAssignCollectionTitle.setText(MessageProperties.GL0101);
		lblClasspages.setText(MessageProperties.GL0102);
		lblAssignments.setText(MessageProperties.GL0103);
		
		btnAssign.setText(MessageProperties.GL0104);
		
		lblClasspagePlaceHolder.setText(MessageProperties.GL0105);
		lblAssignmentsPlaceHolder.setText(MessageProperties.GL0105);
		
		lblNoClasspages.setText(MessageProperties.GL0106);
		htmlGoto.setHTML(MessageProperties.GL0107);
		ancTeach.setText(MessageProperties.GL0108);
		htmlTab.setHTML(MessageProperties.GL0109);
		
		//ancTeach.setHref("#"+PlaceTokens.TEACH);
		
		//Ids
		btnAssign.getElement().setAttribute("id", "btnAssign");
		btnAssign.setStyleName(res.css().disableAssignButon());
		btnAssign.getElement().getStyle().setMarginRight(17, Unit.PCT);
		btnAssign.setEnabled(false);
		btnAssign.setStyleName(CollectionAssignCBundle.INSTANCE.css().disableAssignButon());
		
		disableAssignemnt();
	}
	/**
	 * 
	 * @function showHideScrollPanel 
	 * 
	 * @created_date : Jul 30, 2013
	 * 
	 * @description
	 * 	Set the visibility based on params
	 * 
	 * @parm(s) : @param visible
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void showHideScrollPanel(boolean visible){
		spanelClasspagesPanel.setVisible(visible);
		spanelAssignmentsPanel.setVisible(visible);
	}
	
	//UI Handlers
	/**
	 * 
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to Open ClasspageContainer on lblClasspagePlaceHolder clicked.
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
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to Open ClasspageContainer on lblClasspagesArrow clicked.
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
	 * @function OpenClasspageContainer 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :  This is used to open the classpage container.
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
	public void OpenClasspageContainer(){
		spanelClasspagesPanel.setVisible(!spanelClasspagesPanel.isVisible());
		if (spanelAssignmentsPanel.isVisible()){
			spanelAssignmentsPanel.setVisible(false);
		}
	}
	/**
	 * 
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to Open AssignmentContainer on lblAssignmentsPlaceHolder clicked.
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
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to Open AssignmentContainer on lblAssignmentsArrow clicked.
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
	 * @function OnClickClasspagePlaceHolder 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to Open AssignmentContainer.
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
	 * @function updateShare 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to update the shareType.
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
	public void updateShare(String shareType) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDo.getGooruOid(), null, null, null, shareType, null, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDo = result;
				AppClientFactory.fireEvent(new CollectionEditShareEvent(result.getSharing()));
			}
		});
	}
	/**
	 * 
	 * @function OnClickAssign 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This UIHandler is used to add Collection To Assignment
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
		resourceDo.setGooruOid(collectionDo.getGooruOid());
		taskResourceAssocDo.setResource(resourceDo);
		
		//Track Mixpanel
		MixpanelUtil.Click_Assign_Click();
		// Api call for adding Collection to Assignment
		
		if (collectionDo.getSharing().equalsIgnoreCase("private")){
			updateShare("anyonewithlink");
			getUiHandlers().setShareType("anyonewithlink");
			lblAssignCollectionPrivate.setVisible(false);
			collectionDo.setSharing("anyonewithlink");
		}else{
			
		}
		
		
		AppClientFactory.getInjector().getClasspageService().v2AddCollectionToAssignment(assignmentId,taskResourceAssocDo, new SimpleAsyncCallback<TaskResourceAssocDo>() {
			@Override
			public void onSuccess(TaskResourceAssocDo result) {

				SuccessPopupVc successPopupVc = new SuccessPopupVc(lblAssignmentsPlaceHolder.getText(), collectionDo.getTitle(), lblClasspagePlaceHolder.getText()) {
					
					@Override
					public void closePoup() {
						clearAssignmentsContainer();
						
						lblClasspagePlaceHolder.setText(MessageProperties.GL0105);
						lblClasspagePlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().placeHolderText());
						lblAssignCollectionPrivate.setVisible(false);
						
						htmlClasspagesListContainer.clear();
						getUiHandlers().getAllClasspages("10", "0");
						
						Window.enableScrolling(true);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
					
						
				        this.hide();
					}
				};
				successPopupVc.center();
				successPopupVc.show();
				
				//Need to handle if Collection is already added.
//				{"code":500,"status":"Resource already associated"}
			}
//			@Override
//			public void onFailure(Throwable caught) {
//				
//			}
		});
	}
	
	
	@UiHandler("htmlEvenPanelContainer")
	public void OnClickEventPanel(ClickEvent event){
//		spanelAssignmentsPanel.setVisible(false);
//		spanelClasspagesPanel.setVisible(false);
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
	@Override
	public void setClasspageData(ClasspageListDo classpageListDo){
		panelLoading.setVisible(false);
		int resultSize = classpageListDo.getSearchResults().size();
		if (resultSize > 0){
			htmlEvenPanelContainer.setVisible(true);
			if (toClear){
				htmlClasspagesListContainer.clear();
				toClear=false;
			}
			for (int i = 0; i < resultSize; i++) {
				String classpageTitle = classpageListDo.getSearchResults().get(i).getTitle();
				classpageId = classpageListDo.getSearchResults().get(i).getGooruOid();
				final Label titleLabel = new Label(classpageTitle);
				titleLabel.setStyleName(CollectionAssignCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement()
						.setAttribute("id", classpageId);
				//Set Click event for title
				titleLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {						
						lblClasspagePlaceHolder.setText(titleLabel.getText());
						lblClasspagePlaceHolder.getElement().setId(titleLabel.getElement().getId());
						lblClasspagePlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().selectedClasspageText());
						
						classpageId = titleLabel.getElement().getId();
						
						toClearAssignment = true;
						//Call API to get List of Assignment associated to this.
						getUiHandlers().getAssignmentsByClasspageId(titleLabel.getElement().getId(), "10", "0");
						
						
						clearAssignmentsContainer();
						
						lblNoAssignments.setText(MessageProperties.GL0110);
						lblNoAssignments.getElement().getStyle().setVisibility(Visibility.VISIBLE);
						panelAssignmentsControls.setVisible(false);
						
						//Hide the scroll container
						spanelClasspagesPanel.setVisible(false);
					}
				});
				htmlClasspagesListContainer.add(titleLabel);
				
			}
		}else{
			//Set if there are not classpages.
			if (toClear){
				panelNoClasspages.setVisible(true);
			}
		}
	}
	/**
	 * 
	 * @function clearAssignmentsContainer 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to clear the AssignmentsContainer.
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
	public void clearAssignmentsContainer(){
		//Clear Assignments data
		getUiHandlers().setAssignmentOffSet(0);
		disableAssignemnt();
		htmlAssignmentsListContainer.clear();
		lblAssignmentsPlaceHolder.setText(MessageProperties.GL0105);
		lblAssignmentsPlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().placeHolderText());
		
		lblAssignmentErrorMsg.setVisible(false);
		
		btnAssign.setEnabled(false);
		btnAssign.setStyleName(CollectionAssignCBundle.INSTANCE.css().disableAssignButon());
	}
	/**
	 * This method is used to set the AssignmentData.
	 */
	@Override
	public void setAssignmentData(AssignmentsListDo result) {
		int resultSize = result.getSearchResults().size();
		if (resultSize > 0){
			enableAssignment();
			panelAssignmentsControls.setVisible(true);
			lblNoAssignments.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			if (toClearAssignment){
				htmlAssignmentsListContainer.clear();
				toClearAssignment=false;
			}
			for (int i = 0; i < resultSize; i++) {
				String assignmentTitle = result.getSearchResults().get(i).getTask().getTitle();
				assignmentId = result.getSearchResults().get(i).getTask().getGooruOid();
				final Label titleLabel = new Label(assignmentTitle);
				titleLabel.setStyleName(CollectionAssignCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", assignmentId);
				//Set Click event for title
				titleLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {						
						lblAssignmentsPlaceHolder.setText(titleLabel.getText());
						lblAssignmentsPlaceHolder.getElement().setId(titleLabel.getElement().getId());
						lblAssignmentsPlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().selectedClasspageText());
						
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
	 * @function getAssignmentCollections 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to  Get AssignmentCollections by Id.
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
//				collectionsList = new ArrayList<String>();
				collectionsList.clear();
				for (ResourceDo resourceDo : result){
					if (collectionDo.getGooruOid().equalsIgnoreCase(resourceDo.getGooruOid().toString())){
						isAdded = true;
						break;
					}
				}
				
				if (!isMoreThanLimit){
					if (!isAdded){
						btnAssign.setEnabled(true);
						btnAssign.setStyleName(CollectionAssignCBundle.INSTANCE.css().activeAssignButton());
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
	 * This method is to get the toClear
	 */
	public boolean isToClear() {
		return toClear;
	}

	/** 
	 * This method is to set the toClear
	 */
	public void setToClear(boolean toClear) {
		this.toClear = toClear;
	}
	/** 
	 * This method is to get the collectionDo
	 */
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}

	/** 
	 * This method is to set the collectionDo
	 */
	@Override
	public void setCollectionDo(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}
	/**
	 * 
	 * @function disableAssignemnt 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to disable the Assignemnt.
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
	public void disableAssignemnt(){
		lblAssignments.setStyleName(CollectionAssignCBundle.INSTANCE.css().labelTextDisable());
		isAssignmentsEnabled = false;
	}
	
	public void enableAssignment(){
		lblAssignments.setStyleName(CollectionAssignCBundle.INSTANCE.css().labelText());
		isAssignmentsEnabled = true;
	}
	/**
	 * This method is used to hide the containers.
	 */
	@Override
	public void hideContainers(){
		htmlClasspagesListContainer.clear();
		htmlAssignmentsListContainer.clear();
		htmlEvenPanelContainer.setVisible(false);
		panelNoClasspages.setVisible(false);
		panelLoading.setVisible(true);
	}
	/**
	 * This method is used to make lblAssignCollectionPrivate as visible.
	 */
	@Override
	public void setPrivateLableVisibility(boolean visibility) {
		lblAssignCollectionPrivate.setVisible(visibility);
	}
	
	
}
