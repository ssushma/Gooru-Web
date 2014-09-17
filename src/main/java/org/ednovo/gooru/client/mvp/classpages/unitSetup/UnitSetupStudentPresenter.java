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
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class UnitSetupStudentPresenter extends PresenterWidget<IsUnitSetupStudentView> implements UnitSetupStudentUiHandlers{
	
	private int limit = 5;
	private int offSet = 0;

	@Inject
	public UnitSetupStudentPresenter(EventBus eventBus, IsUnitSetupStudentView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		getPathwayCompleteDetails(limit,offSet);
	}

	@Override
	public void getPathwayCompleteDetails(int limit, int offset) {
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		if(classpageId!=null){
			AppClientFactory.getInjector().getClasspageService().v2GetPathwaysCompleteDetails(classpageId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {

				@Override
				public void onSuccess(ClassDo result) {
					getView().showUnitDetails(result);
					if(result.getSearchResults() != null){
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
	
	
	
	
}
