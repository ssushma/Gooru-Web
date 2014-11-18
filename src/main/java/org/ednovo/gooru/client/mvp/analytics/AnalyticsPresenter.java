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
import org.ednovo.gooru.client.mvp.analytics.unitAssignments.AnalyticsUnitAssignmentsPresenter;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.PersonalizeUnitPresenter;
import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
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
	
	private AnalyticsUnitAssignmentsPresenter analyticsUnitAssignmentsPresenter;
	
	private PersonalizeUnitPresenter personalizeUnitPresenter;
	
	public static final  Object COLLECTION_PROGRESS_SLOT = new Object();
	
	public static final  Object UNIT_ASSIGNMENT_SLOT = new Object();
	
	public static final  Object PERSONALIZE_SLOT = new Object();
	
	final String SUMMARY="Summary",PROGRESS="Progress";
	
	private String pathwayId=null;
	
	ClasspageDo classpageDo=null;
	
	@Inject
	private  AnalyticsServiceAsync analyticService;
	
	@Inject
	private ClasspageServiceAsync classpageService;
	
	/**
	 * AnalyticsPresenter constructor
	 * @param eventBus
	 * @param view
	 * @param collectionProgressPresenter
	 * @param collectionSummaryPresenter
	 * @param analyticsUnitAssignmentsPresenter
	 * @param personalizeUnitPresenter
	 */
	@Inject
	public AnalyticsPresenter(EventBus eventBus, IsAnalyticsView view,CollectionProgressPresenter collectionProgressPresenter,CollectionSummaryPresenter collectionSummaryPresenter,AnalyticsUnitAssignmentsPresenter analyticsUnitAssignmentsPresenter,PersonalizeUnitPresenter personalizeUnitPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.collectionProgressPresenter=collectionProgressPresenter;
		this.collectionSummaryPresenter=collectionSummaryPresenter;
		this.analyticsUnitAssignmentsPresenter=analyticsUnitAssignmentsPresenter;
		this.personalizeUnitPresenter=personalizeUnitPresenter;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getPathwayItems(java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public void getPathwayItems(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				//classpageId,pathwayid
				getGradeCollectionJson(classpageId, pathwayGooruOid);
				getView().removeAndAddUnitSelectedStyle();
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getPathwayUnits(java.lang.String, int, int, boolean)
	 */
	@Override
	public void getPathwayUnits(final String classId,int limit, int offset,final boolean clearPanel) {
		final String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {
			@Override
			public void onSuccess(ClassDo classDo) {
				if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
					String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
					if(unitId==null){
                        pathwayId=classDo.getSearchResults().get(0).getResource().getGooruOid();
						getView().revealPlace("reports",null,pathwayId,null);
					}else{
						getView().clearDownArrow();
						clearSlot(COLLECTION_PROGRESS_SLOT);
						getView().hidePersonalizeContainers();
						getView().showUnitNames(classDo,clearPanel);
						getPathwayItems(classpageId,unitId,"sequence",assignmentLimit,assignmentOffset);
					}
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#setClickedTabPresenter(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setClickedTabPresenter(String clickedTab,String collectionId,String selectedCollectionTitle) {
		String pathWayId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		clearSlot(COLLECTION_PROGRESS_SLOT);
		if(clickedTab!=null){
			if(clickedTab.equalsIgnoreCase(SUMMARY)){
				collectionSummaryPresenter.setCollectionSummaryData(collectionId,pathWayId);
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionSummaryPresenter,false);
			}else if(clickedTab.equalsIgnoreCase(PROGRESS)){
				collectionProgressPresenter.setCollectionProgressData(collectionId,pathWayId,false,selectedCollectionTitle);
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionProgressPresenter,false);
			}
		}else{
			setInSlot(COLLECTION_PROGRESS_SLOT, null,false);
		}
	}
	
	/**
	 * Get the analytics service
	 * @return
	 */
	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}
	
	/**
	 * Set the analytics service
	 * @param analyticService
	 */
	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getBottomStudentsData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void getBottomStudentsData(String classpageId, String pathwayId,String collectionId,String sortOrder) {
		this.analyticService.getBottomAndTopScoresData(collectionId, classpageId,pathwayId,sortOrder, new AsyncCallback<ArrayList<GradeJsonData>>() {
			
			@Override
			public void onSuccess(ArrayList<GradeJsonData> result) {
				getView().setBottomStudentsData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getTopStudentsData(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void getTopStudentsData(String classpageId, String pathwayId,String collectionId, String sortOrder) {
		this.analyticService.getBottomAndTopScoresData(collectionId, classpageId,pathwayId,sortOrder, new AsyncCallback<ArrayList<GradeJsonData>>() {
			
			@Override
			public void onSuccess(ArrayList<GradeJsonData> result) {
				getView().setTopStudentsData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getGradeCollectionJson(java.lang.String, java.lang.String)
	 */
	@Override
	public void getGradeCollectionJson(final String classpageId, final String pathwayId) {
		getView().LoadingImageLabeltrue();
		this.analyticService.getAnalyticsGradeData(classpageId, pathwayId, new AsyncCallback<ArrayList<GradeJsonData>>() {
			@Override
			public void onSuccess(ArrayList<GradeJsonData> result) {
				getView().setGradeCollectionData(result);
				if(result.size()!=0){
					getTopStudentsData(classpageId, pathwayId,result.get(0).getResourceGooruOId(),"DESC");
					getBottomStudentsData(classpageId, pathwayId,result.get(0).getResourceGooruOId(),"ASC");
				}
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	/**
	 * This method is used to ge tthe class units.
	 * @param classpageDo
	 */
	public void getClassUnits(ClasspageDo classpageDo){
		this.classpageDo=classpageDo;
		//String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		/*if(unitId!=null && getView().getUnitPanel().getWidgetCount()!=0){
			getPathwayItems(classpageDo.getClasspageId(),unitId,"sequence",assignmentLimit,assignmentOffset);
		}else{*/
			getPathwayUnits(classpageDo.getClasspageId(),limit,offSet,true);
		/*}*/
	}

	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.PresenterWidget#onHide()
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().resetData();
		clearSlot(UNIT_ASSIGNMENT_SLOT);	
		clearSlot(COLLECTION_PROGRESS_SLOT);
		clearSlot(PERSONALIZE_SLOT);	
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#exportOEPathway(java.lang.String, java.lang.String)
	 */
	@Override
	public void exportOEPathway(String classpageId, String pathwayId,String timeZone) {
		this.analyticService.exportPathwayOE(classpageId, pathwayId,timeZone,new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				Window.open(result, "_blank", "directories=0,titlebar=0,toolbar=0,location=0,status=0,menubar=0,scrollbars=no,resizable=no,width=0,height=0");
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getUnitAssignments()
	 */
	@Override
	public void getUnitAssignments() {
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		if(unitId!=null){
			getUnitAssignments(classpageId, unitId, "sequence", assignmentLimit, assignmentOffset);
		}else{
			getUnitAssignments(classpageId, pathwayId, "sequence", assignmentLimit, assignmentOffset);
		}
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#setAnalyticsAssignmentsPresenter(org.ednovo.gooru.shared.model.content.UnitAssignmentsDo, java.lang.String, java.lang.String)
	 */
	@Override
	public void setAnalyticsAssignmentsPresenter(UnitAssignmentsDo result,String classpageId,String pathwayId) {
		clearSlot(UNIT_ASSIGNMENT_SLOT);	
		analyticsUnitAssignmentsPresenter.setAnalyticsAssignmentsPresenter(result,classpageId,pathwayId);
		setInSlot(UNIT_ASSIGNMENT_SLOT, analyticsUnitAssignmentsPresenter,false);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#getUnitAssignments(java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public void getUnitAssignments(final String classpageId, final String pathwayGooruOid,String sequence, int limit, int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				setAnalyticsAssignmentsPresenter(result,classpageId, pathwayGooruOid);
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.AnalyticsUiHandlers#setPersonalizeData()
	 */
	@Override
	public void setPersonalizeData() {
		clearSlot(PERSONALIZE_SLOT);	
		personalizeUnitPresenter.setClasspageData(classpageDo);
		setInSlot(PERSONALIZE_SLOT, personalizeUnitPresenter,false);
	}

	/**
	 * Get the class page service
	 * @return
	 */
	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}

	/**
	 * Sets the class page service
	 * @param classpageService
	 */
	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}
}
