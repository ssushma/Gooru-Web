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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.analytics.collectionProgress.CollectionProgressPresenter;
import org.ednovo.gooru.client.mvp.analytics.collectionSummary.CollectionSummaryPresenter;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateUnitSetGoalEvent;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.PersonalizeUnitPresenter;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class UnitAssignmentPresenter extends PresenterWidget<IsUnitAssignmentView> implements UnitAssignmentUiHandlers{

	
	
	public static final  Object _SLOT = new Object();
	
	private PersonalizeUnitPresenter studentPersonalizePresenter = null;
	
	private CollectionProgressPresenter collectionProgressPresenter;
	
	private CollectionSummaryPresenter collectionSummaryPresenter;
	
	public static final  Object REPORT_SLOT = new Object();
	
	final String SUMMARY="Summary",PROGRESS="Progress",BELOWSCORE="BelowScore",ABOVESCORE="AboveScore";
	
	private int limit = 5;
	private int offSet = 0;
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	private static final String IMAGE_URL="images/core/B-Dot.gif";
	
	@Inject
	public UnitAssignmentPresenter(EventBus eventBus, IsUnitAssignmentView view, PersonalizeUnitPresenter studentPersonalizePresenter,CollectionProgressPresenter collectionProgressPresenter,CollectionSummaryPresenter collectionSummaryPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.studentPersonalizePresenter = studentPersonalizePresenter;
		this.collectionProgressPresenter=collectionProgressPresenter;
		this.collectionSummaryPresenter=collectionSummaryPresenter;
	}
	@Override
	protected void onHide() {
		System.out.println("onhide method...........");
		getView().resetUnitAssignmentView();
	}
	
	public void getClassUnits(String classId){
		if(getView().getUnitPanel().getWidgetCount()==0){
			getPathwayUnits(classId,limit,offSet,true);
		}
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		String assignmentId=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
		if(unitId!=null&&getView().getCircleContainerPanel().getWidgetCount()==0){
			getPathwayItems(classId,unitId,"sequence",assignmentLimit,assignmentOffset);
		}
		if(assignmentId!=null){
			getAssignemntDetails(assignmentId,classId,unitId);
		}
	}
	
	
	@Override
	public void setClasspageData(ClasspageDo classpageDo){
		studentPersonalizePresenter.setClasspageData(classpageDo);
		setInSlot(_SLOT, studentPersonalizePresenter,false);
	}

	@Override
	public void getPathwayItems(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override
			
			public void onSuccess(UnitAssignmentsDo result) {
				String aid=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
				if(aid==null){
					if(result!=null){
						if(result.getSearchResults() != null){
							if(result.getSearchResults().size()>0){
								getAssignemntDetails(result.getSearchResults().get(0).getCollectionItemId(),classpageId,pathwayGooruOid);
							}
						}
					}
				}
				if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.STUDENT)){
					getAnalyticData(result);
				}else{
					getView().getSequence(result);
				}
				

			}
		});
	}
	
	public void getPathwayUnits(final String classId,int limit, int offset,final boolean clearPanel) {
		if(clearPanel){
			getView().getUnitPanel().clear();
		}
		System.out.println("getPathwayUnits");
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClassDo>() {
			@Override
			public void onSuccess(ClassDo classDo) {
				if(classDo!=null&&classDo.getSearchResults()!=null&&classDo.getSearchResults().size()>0){
					getView().showUnitNames(classDo,clearPanel);
					String seqNumber=AppClientFactory.getPlaceManager().getRequestParameter("seqnumber", "1");
					if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.STUDENT)){
						int number=Integer.parseInt(seqNumber);
						number=number-1;
						getView().clearValues();
						getView().scoreHederView(classDo.getSearchResults().get(number));
					}
				}
				
			}
		});
	}
	
	public void getAssignemntDetails(final String assignmentId,final String classpageId,final String pathwayGooruOid){
		Image image=new Image();
		image.setUrl(IMAGE_URL);
		image.setWidth("200px");
		image.setHeight("200px");
		image.getElement().getStyle().setMarginLeft(39, Unit.PCT);
		image.getElement().getStyle().setMarginTop(10, Unit.PX);
		getView().getAssignmentPanel().add(image);
		AppClientFactory.getInjector().getClasspageService().getAssignemntDetails(assignmentId, new SimpleAsyncCallback<ClasspageItemDo>() {
			@Override
			public void onSuccess(ClasspageItemDo classpageItemDo) {
				if(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.EDIT_CLASSPAGE)){
					if(classpageItemDo!=null&&classpageItemDo.getResource()!=null){
						AppClientFactory.getInjector().getAnalyticsService().getAssignmentAverageData(classpageId, pathwayGooruOid, classpageItemDo.getResource().getGooruOid(), new SimpleAsyncCallback<CollectionSummaryMetaDataDo>() {
							@Override
							public void onSuccess(CollectionSummaryMetaDataDo collectionSummaryMetaDataDo) {
								getView().setCollectionSummaryData(collectionSummaryMetaDataDo);
							}
						});
					}
				}
				getView().showAssignment(classpageItemDo);
			}
		});
	}
	
	
	public ClasspageItemDo getClasspateItemDo(UnitAssignmentsDo unitAssignmentDo,String assignmentId){
		for(int i=0;i<unitAssignmentDo.getSearchResults().size();i++){
			ClasspageItemDo classpageItemDo1=unitAssignmentDo.getSearchResults().get(i);
			if(assignmentId.equals(classpageItemDo1.getCollectionItemId())){
				return classpageItemDo1;
			}
		}
		return null;
		
	}

	public void showDashBoardDetails() {
		getView().showDashBoard();
		
	}

	public void showAssignmentDetails() {
		getView().showAssignments();
	}
	
	/**
	 * This API used for to Update the Unit status.
	 * @param collectionItemId as Unit id	
	 * @param minimumScoreByuser 
	 * @param assignmentStatus
	 * @param time
	 */
	@Override
	public void updateUnitstatus(String collectionItemId, String minimumScoreByuser, String assignmentStatus, String time){
		AppClientFactory.getInjector().getClasspageService().updateUnitStatus(collectionItemId, minimumScoreByuser,assignmentStatus,time, new SimpleAsyncCallback<ClassUnitsListDo>() {

			@Override
			public void onSuccess(ClassUnitsListDo result) {
				// TODO Auto-generated method stub
				String updatedTime=(result.getTimeStudying()!=null && !result.getTimeStudying().equals("")) ? result.getTimeStudying():null;
				AppClientFactory.fireEvent(new UpdateUnitSetGoalEvent(0, 0,updatedTime));
				
			}
		});
	}
	/**
	 * This API used for to show Assignments status.
	 */
	public void getAnalyticData(final UnitAssignmentsDo unitAssignmentsDo){
		System.out.println("getAnalyticData");
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String gooruUId=AppClientFactory.getLoggedInUser().getGooruUId();
		String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid",null);
		
	 	AppClientFactory.getInjector().getClasspageService().getAssignmentData(gooruUId, classpageId, 0, 0, pathwayId, new SimpleAsyncCallback<List<InsightsUserDataDo>>() {

			@Override
			public void onSuccess(List<InsightsUserDataDo> result) {
				System.out.println("getAna--sucess");
				if(result!=null){
					getView().setInsightUserData(result);
					getView().getSequence(unitAssignmentsDo);
				}
			}
		});		
	}
	@Override
	public void setClickedTabPresenter(String clickedTab, String collectionId) {
		String pathwayId=AppClientFactory.getPlaceManager().getRequestParameter("uid",null);
		String assignmentId=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
		if(clickedTab!=null){
			if(clickedTab.equalsIgnoreCase(SUMMARY)){
				collectionSummaryPresenter.setCollectionSummaryData(collectionId,pathwayId);
				setInSlot(REPORT_SLOT, collectionSummaryPresenter,false);
			}else if(clickedTab.equalsIgnoreCase(PROGRESS)){
				collectionProgressPresenter.setCollectionProgressData(collectionId,pathwayId);
				setInSlot(REPORT_SLOT, collectionProgressPresenter,false);
			}
		}
	}
}
