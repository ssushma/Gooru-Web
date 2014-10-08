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
package org.ednovo.gooru.client.mvp.analytics;
import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.analytics.collectionProgress.CollectionProgressPresenter;
import org.ednovo.gooru.client.mvp.analytics.collectionSummary.CollectionSummaryPresenter;
import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class AnalyticsPresenter extends PresenterWidget<IsAnalyticsView> implements AnalyticsUiHandlers{
	

	private int limit = 5;
	private int offSet = 0;
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	private CollectionProgressPresenter collectionProgressPresenter;
	
	private CollectionSummaryPresenter collectionSummaryPresenter;
	
	public static final  Object COLLECTION_PROGRESS_SLOT = new Object();
	
	final String SUMMARY="Summary",PROGRESS="Progress";
	
	@Inject
	private  AnalyticsServiceAsync analyticService;
	
	@Inject
	public AnalyticsPresenter(EventBus eventBus, IsAnalyticsView view,CollectionProgressPresenter collectionProgressPresenter,CollectionSummaryPresenter collectionSummaryPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.collectionProgressPresenter=collectionProgressPresenter;
		this.collectionSummaryPresenter=collectionSummaryPresenter;
	}

	@Override
	public void getPathwayItems(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override

			public void onSuccess(UnitAssignmentsDo result) {
				//classpageId,pathwayid
				getGradeCollectionJson(classpageId, pathwayGooruOid);
			}
		});

	}

	@Override
	public void getPathwayUnits(final String classId,int limit, int offset,final boolean clearPanel) {
		final String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {
			@Override
			public void onSuccess(ClassDo classDo) {
				getView().showUnitNames(classDo,clearPanel);
				if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
					String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
					if(unitId==null){
						getPathwayItems(classpageId,classDo.getSearchResults().get(0).getResource().getGooruOid(),"sequence",assignmentLimit,assignmentOffset);
					}
				}
			}
		});
	}

	@Override
	public void setClickedTabPresenter(String clickedTab,String collectionId) {
		String pathWayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		clearSlot(COLLECTION_PROGRESS_SLOT);
		if(clickedTab!=null){
			if(clickedTab.equalsIgnoreCase(SUMMARY)){
				collectionSummaryPresenter.setCollectionSummaryData(collectionId,pathWayId);
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionSummaryPresenter,false);
			}else if(clickedTab.equalsIgnoreCase(PROGRESS)){
				collectionProgressPresenter.setCollectionProgressData(collectionId,pathWayId);
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionProgressPresenter,false);
			}
		}else{
			setInSlot(COLLECTION_PROGRESS_SLOT, null,false);
		}
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}

	@Override
	public void getBottomAndTopScoresData(String classpageId, String pathwayId,String collectionId) {
		this.analyticService.getBottomAndTopScoresData(collectionId, classpageId,pathwayId, new AsyncCallback<ArrayList<GradeJsonData>>() {
			
			@Override
			public void onSuccess(ArrayList<GradeJsonData> result) {
				getView().setBottomAndTopScoresData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	@Override
	public void getGradeCollectionJson(final String classpageId, final String pathwayId) {
		getView().LoadingImageLabeltrue();
		this.analyticService.getAnalyticsGradeData(classpageId, pathwayId, new AsyncCallback<ArrayList<GradeJsonData>>() {
			@Override
			public void onSuccess(ArrayList<GradeJsonData> result) {
	
				getView().setGradeCollectionData(result);
				
				if(result.size()!=0){
					getBottomAndTopScoresData(classpageId, pathwayId,result.get(0).getResourceGooruOId());
			
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	public void getClassUnits(String classId){
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		if(getView().getUnitPanel().getWidgetCount()>=0){
			getPathwayUnits(classId,limit,offSet,true);
		}
		if(unitId!=null){
			getPathwayItems(classId,unitId,"sequence",assignmentLimit,assignmentOffset);
		}
	}

	@Override
	public void exportOEPathway(String classpageId, String pathwayId) {
		this.analyticService.exportPathwayOE(classpageId, pathwayId,new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				Window.open(result, "_blank", "directories=0,titlebar=0,toolbar=0,location=0,status=0,menubar=0,scrollbars=no,resizable=no,width=0,height=0");
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}
