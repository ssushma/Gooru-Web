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
package org.ednovo.gooru.client.mvp.classpages.assignments;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.classsetup.ClassSetupPresenter;
import org.ednovo.gooru.client.mvp.classpages.classsetup.ClassSetupUnitPresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter;
import org.ednovo.gooru.client.mvp.classpages.unitSetup.UnitSetupPresenter;
import org.ednovo.gooru.client.mvp.search.event.ResetProgressEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView;
import org.ednovo.gooru.shared.model.content.ClassSetupDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * 
 * @fileName : AddAssignmentContainerPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddAssignmentContainerPresenter extends PresenterWidget<IsAddAssignmentContainerView> implements AddAssignmentContainerUiHandlers{
	
	private String classpageId=null;
	private EditClasspagePresenter editClasspagePresenter=null;
	
	private String classpageIdToAssign=null;
	private String pathwayId=null;
	private ClassSetupUnitPresenter classSetupUnitPresenter=null;
	private UnitSetupPresenter unitSetupPresenter=null;
	private String mode;
	private String	pathwayTitle = null;
	private static final String CLASS_SETUP="classSetUpMode";
	private static final String UNIT_SETUP="unitSetupMode";
	
	@Inject
	public AddAssignmentContainerPresenter(IsCollectionResourceTabView isCollResourceTabView, EventBus eventBus, IsAddAssignmentContainerView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);		
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	public void getUserShelfData(){
		getView().clearShelfData();
		getWorkspaceData(0,20,true);
	}
	public void getWorkspaceData(int offset,int limit, final boolean clearShelfPanel){
		AppClientFactory.getInjector().getResourceService().getFolderWorkspace(offset, limit,"public,anyonewithlink", null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				if(folderListDo.getCount()==0){
					getView().displayNoCollectionsMsg();
				}else{
					getView().displayWorkspaceData(folderListDo,clearShelfPanel);
				}
			}
		});
	}

	@Override
	public void getFolderItems(final TreeItem item,String parentId) {
		AppClientFactory.getInjector().getfolderService().getChildFolders(0, 20, parentId,"public,anyonewithlink", null, new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}
	public void addCollectionToAssign(String collectionId,String direction,String dueDate){
		AppClientFactory.getInjector().getClasspageService().createClassPageItem(this.classpageId, collectionId, dueDate, direction, new SimpleAsyncCallback<ClasspageItemDo>() {
			@Override
			public void onSuccess(ClasspageItemDo classpageItemDo) {
				getView().hideAddCollectionPopup(classpageItemDo.getCollectionTitle());
				getEditClasspagePresenter().setClasspageItemDo(classpageItemDo);
			}
		});
	}
	
	public void addCollectionToAssign(String collectionId){
		if(mode.equals(CLASS_SETUP) || mode.equals(UNIT_SETUP)){
			addAssignment(collectionId,pathwayId);
		}else{		
			AppClientFactory.getInjector().getClasspageService().assignItemToClass(this.classpageId, collectionId, null, null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
				@Override
				public void onSuccess(ArrayList<ClasspageItemDo> classpageItemDoList) {
					if(classpageItemDoList!=null&&classpageItemDoList.size()>0){
						getView().hideAddCollectionPopup("");
						//	AppClientFactory.fireEvent(new ResetProgressEvent());
						/*					for(int i=0;i<classpageItemDoList.size();i++){
		
		if(isFromClassSetUpPresenter)
		{
			AppClientFactory.getInjector().getClasspageService().v2AssignCollectionTOPathway(this.classpageIdToAssign, this.pathwayId, collectionId,null,null,null,null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
			@Override
			public void onSuccess(ArrayList<ClasspageItemDo> result) {
			// TODO Auto-generated method stubgetr
			getView().hideAddCollectionPopup("");
			}
			});
		}
		else
		{		
		AppClientFactory.getInjector().getClasspageService().assignItemToClass(this.classpageId, collectionId, null, null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
			@Override
			public void onSuccess(ArrayList<ClasspageItemDo> classpageItemDoList) {
				if(classpageItemDoList!=null&&classpageItemDoList.size()>0){
					getView().hideAddCollectionPopup("");
				//	AppClientFactory.fireEvent(new ResetProgressEvent());
/*					for(int i=0;i<classpageItemDoList.size();i++){
						ClasspageItemDo classpageItemDo=classpageItemDoList.get(i);
						getEditClasspagePresenter().setClasspageItemDo(classpageItemDo);
					}*/
						showCollectionsAfterAddingNewCollections();

					}
				}
			});
		}
	}
	
	public void showCollectionsAfterAddingNewCollections(){
		Map<String,String> params = new HashMap<String,String>();
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		params.put("order", "asce");
		params.put("classpageid", classpageid);
		params.put("pageNum", 1+"");
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
		AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
		AppClientFactory.fireEvent(new ResetProgressEvent());
	}
	public void setClasspageId(String classpageId,EditClasspagePresenter editClasspagePresenter){
		this.classpageId=classpageId;
		this.setEditClasspagePresenter(editClasspagePresenter);
	}

	public EditClasspagePresenter getEditClasspagePresenter() {
		return editClasspagePresenter;
	}

	public void setEditClasspagePresenter(EditClasspagePresenter editClasspagePresenter) {
		this.editClasspagePresenter = editClasspagePresenter;
	}
	
	public void addAssignmentToPathway(String classpageId,String pathwayId,String mode,String pathwayTitle){
		this.classpageIdToAssign = classpageId;
		this.pathwayId = pathwayId;
		this.mode= mode;
		this.pathwayTitle = pathwayTitle;
		getView().setUnitTitle(pathwayTitle);
	}


	private void addAssignment(String collectionId,final String pathwayId) { 
		AppClientFactory.getInjector().getClasspageService().v2AssignCollectionTOPathway(this.classpageIdToAssign, this.pathwayId, collectionId,null,null,null,null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
			@Override
			public void onSuccess(ArrayList<ClasspageItemDo> result) {
				if(mode.equals(CLASS_SETUP)){
					getView().hideAddCollectionPopup("");
				}else if(mode.equals(UNIT_SETUP)){
					if(unitSetupPresenter !=null){
						//getView().hideAddCollectionPopup("");
						getView().hideAddCollectionPopup(pathwayTitle);
						unitSetupPresenter.addAssignmentToPathway(result,pathwayId);
					}
				}
			}
		});
	}

	public void setUnitSetupPresenter(UnitSetupPresenter unitSetupPresenter) { 
		this.unitSetupPresenter = unitSetupPresenter;
	}
	
	
}
