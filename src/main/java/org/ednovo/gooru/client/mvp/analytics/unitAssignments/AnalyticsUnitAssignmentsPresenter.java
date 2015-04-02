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
package org.ednovo.gooru.client.mvp.analytics.unitAssignments;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class AnalyticsUnitAssignmentsPresenter extends PresenterWidget<IsAnalyticsUnitAssignmentsView> implements AnalyticsUnitAssignmentsUiHandlers{
	
	@Inject
	private  AnalyticsServiceAsync analyticService;
	
	private String classpageId,pathwayId;
	
	@Inject
	public AnalyticsUnitAssignmentsPresenter(EventBus eventBus, IsAnalyticsUnitAssignmentsView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}


	@Override
	public void setAnalyticsAssignmentsPresenter(UnitAssignmentsDo result,String classpageId,String pathwayGooruOid) {
		this.classpageId=classpageId;
		this.pathwayId=pathwayGooruOid;
		getView().setAssignmentsData(result,false);
	}
	
	@Override
	public void getPathwayItems(String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayId, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				getView().setAssignmentsData(result,true);
			}
		});
	}
}
