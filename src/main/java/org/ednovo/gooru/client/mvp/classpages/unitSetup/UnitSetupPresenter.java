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
package org.ednovo.gooru.client.mvp.classpages.unitSetup;
import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerPresenter;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshPathwayItemsEvent;
import org.ednovo.gooru.client.mvp.rating.events.DeletePlayerStarRatingsEvent;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class UnitSetupPresenter extends PresenterWidget<IsUnitSetupView> implements UnitSetupUiHandlers{
	
	private int limit = 5;
	private int offSet = 0;
	
	AddAssignmentContainerPresenter addAssignmentContainerPresenter=null;

	@Inject
	public UnitSetupPresenter(EventBus eventBus, IsUnitSetupView view, AddAssignmentContainerPresenter addAssignmentContainerPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.addAssignmentContainerPresenter = addAssignmentContainerPresenter;
		addRegisteredHandler(RefreshPathwayItemsEvent.TYPE,this);
	}
	
	public void getUnitsWithAssignemnts(){
		getPathwayCompleteDetails(limit,offSet);
	}
	
	@Override
	public void onReveal() {
		super.onReveal();
		String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
		int offsetVal = 0;
		if(pageNum != null)
		{
			offsetVal = Integer.parseInt(pageNum);
			if(offsetVal!=0)
			{	
			offsetVal = (offsetVal-1);
			}
		}
		getView().setLoadingIcon(true);
		getPathwayCompleteDetails(limit,(offsetVal)*limit);
		
		
		/*ResetPaginationHandler reset = new ResetPaginationHandler() {

			@Override
			public void callPathwaysAPI(int offSetVal) {
				System.out.println("1");
				getPaginatedPathways(offSetVal);
				
			}
		};*/
	}
	

	@Override
	public void getPathwayCompleteDetails(int limit, int offset) {
		getView().setLoadingIcon(true);
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(classpageId!=null){
			AppClientFactory.getInjector().getClasspageService().v2GetPathwaysCompleteDetails(classpageId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {

				@Override
				public void onSuccess(ClassDo result) {
					getView().showUnitDetails(result);
					if(result.getSearchResults() != null)
					{
					if(result.getSearchResults().size()>0){
						String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
						int pageNumVal = 0;
						if(pageNum != null)
						{
							try
							{
							pageNumVal = Integer.parseInt(pageNum);
							}
							catch(Exception e)
							{
								
							}
						}
						getView().setPagination(result.getTotalHitCount(),pageNumVal);
						
					}
				}
					
				}
			});
		}
		
	}

	/**
	 * Before calling API.
	 */
	@Override
	public void addAssignmentToPathway(String classPageId, String pathwayId,String mode) {
		addAssignmentContainerPresenter.setUnitSetupPresenter(this);
		addAssignmentContainerPresenter.getUserShelfData();
		addAssignmentContainerPresenter.addAssignmentToPathway(classPageId, pathwayId,mode);
		addToPopupSlot(addAssignmentContainerPresenter);
	}

	/**
	 * After API call success, to add assignment widgets.
	 * @param pathwayId 
	 * @param result
	 */
	public void addAssignmentToPathway(ArrayList<ClasspageItemDo> classpageItemDo, String pathwayId) {  
		getView().addAssignmentWidget(classpageItemDo,pathwayId); 
	}
	
	public void clearUnitAssignmentWidgetContaner(){
		getView().clearUnitAssignmentWidgetContaner();
		limit = 5;
		offSet = 0;
	}

	@Override
	public void refreshPathway(String classpageId, String pathwayId) {
		getView().refreshPathwayItems(classpageId,pathwayId);
	}

}
