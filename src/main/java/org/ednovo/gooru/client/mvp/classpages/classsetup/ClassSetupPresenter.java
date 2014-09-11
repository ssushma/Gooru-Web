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
package org.ednovo.gooru.client.mvp.classpages.classsetup;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerPresenter;
import org.ednovo.gooru.client.mvp.classpages.unitSetup.UnitSetupPresenter;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class ClassSetupPresenter extends PresenterWidget<IsClassSetupView> implements ClassSetupUiHandlers{

	
	public static final  Object UNITS_SLOT = new Object();
	
	AddAssignmentContainerPresenter assignmentContainer=null;
	String classpageId="";
	String pathwayId="";
	
	private UnitSetupPresenter unitSetupPresenter;
	
	@Inject
	public ClassSetupPresenter(EventBus eventBus, IsClassSetupView view,UnitSetupPresenter unitSetupPresenter,AddAssignmentContainerPresenter assignmentContainer) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.unitSetupPresenter=unitSetupPresenter;
		this.assignmentContainer = assignmentContainer;
	

	}
	
	@Override
	public void onReveal() {
		super.onReveal();
		
		getPathways();
	}
	
	@Override
	public void setUnit(String unitName, String pathwayId) {
		 getView().setContent(unitName,pathwayId);
	}
	
	@Override
	public void OnUnitSetupClick() {
		setInSlot(UNITS_SLOT, unitSetupPresenter,false);
	}
	

	
	public void getPathways(){
		getView().clearPanel();
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classpageid != null)
		{
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageid, "10", "0", new SimpleAsyncCallback<ClasspageListDo>() {
			@Override
			public void onSuccess(ClasspageListDo classpageItemDo) {
				if(classpageItemDo.getSearchResults().size()>0)
				{
					for(int i=0;i<classpageItemDo.getSearchResults().size();i++)
					{
						setUnit(classpageItemDo.getSearchResults().get(i).getResource().getTitle(), classpageItemDo.getSearchResults().get(i).getResource().getGooruOid());
						
					}
				}
			}
		});
		}
	}
	
	@Override
	public void createPathway(String pathwayTitle){
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classpageid != null)
		{
		AppClientFactory.getInjector().getClasspageService().v2CreatePathwayForAClass(classpageid, pathwayTitle, new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo pathwayItemObject) {
				if(pathwayItemObject.getTitle() != null)
				{
					setUnit(pathwayItemObject.getTitle(),pathwayItemObject.getGooruOid());
				}
			}
		});
		}
	}
	
	@Override
	public void updatePathway(String pathwayId, String pathwayTitle){
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classpageid != null)
		{
		AppClientFactory.getInjector().getClasspageService().v2UpdatePathwayById(classpageid,pathwayId, pathwayTitle, new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo pathwayItemObject) {


			}
		});
		}
	}
	
	@Override
	public void deletePathway(String pathwayId){
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classpageid != null)
		{
		AppClientFactory.getInjector().getClasspageService().deletePathway(classpageid, pathwayId, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				getPathways();
			}
		});
		}
	}
	
	@Override
	public void addAssignmentsContainerPopup(String pathwayIdVal) {
	System.out.println("pathwayIdVal::"+pathwayIdVal);
	classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
	//pathwayId="25509399-83ab-42f1-b774-c1e424b132d0";
	assignmentContainer.getUserShelfData();
	assignmentContainer.setClasspageIdFromClassSetupPresenter(classpageId, pathwayIdVal,this,true);
	addToPopupSlot(assignmentContainer);
	}
	

	
	

	
	
}
