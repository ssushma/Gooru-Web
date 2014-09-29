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
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class UnitSetupStudentPresenter extends PresenterWidget<IsUnitSetupStudentView> implements UnitSetupStudentUiHandlers{
	
	private int limit = 5;
	private int offSet = 0;
	String gooruUid;
	String pathwayId;
	ClassDo classDo;

	@Inject
	public UnitSetupStudentPresenter(EventBus eventBus, IsUnitSetupStudentView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		//getPathwayCompleteDetails(limit,offSet);
	}

	@Override
	public void getPathwayCompleteDetails(int limit, int offset) {
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		if(classpageId!=null){
			AppClientFactory.getInjector().getClasspageService().v2GetPathwaysCompleteDetails(classpageId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {

				@Override
				public void onSuccess(ClassDo result) {
					if(result.getSearchResults() != null){
						classDo=result;
					if(result.getSearchResults().size()>0){
						String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
						getView().showUnitDetails(classDo);
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
	
	@Override
	public void getAnalyticData(String gooruUId, String pathwayId){
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
	 	AppClientFactory.getInjector().getClasspageService().getAssignmentData(gooruUId, classpageId, 20, 0, pathwayId, new SimpleAsyncCallback<List<InsightsUserDataDo>>() {

			@Override
			public void onSuccess(List<InsightsUserDataDo> result) {
//				getView().setAssignments(result);
				System.out.println("sucesss:"+result.get(0).getTitle());
			}
		});		
	}
	
	
}
