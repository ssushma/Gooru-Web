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
package org.ednovo.gooru.client.mvp.Analytics;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.Analytics.collectionProgress.CollectionProgressPresenter;
import org.ednovo.gooru.client.mvp.Analytics.collectionSummary.CollectionSummaryPresenter;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.event.shared.EventBus;
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
	public AnalyticsPresenter(EventBus eventBus, IsAnalyticsView view,CollectionProgressPresenter collectionProgressPresenter,CollectionSummaryPresenter collectionSummaryPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.collectionProgressPresenter=collectionProgressPresenter;
		this.collectionSummaryPresenter=collectionSummaryPresenter;
		getPathwayUnits("",limit,offSet,true);
	}

	@Override
	public void getPathwayItems(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<UnitAssignmentsDo>() {
			@Override

			public void onSuccess(UnitAssignmentsDo result) {
				String aid=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
				if(aid==null){
					if(result!=null&&result.getSearchResults().size()>0){
						//getAssignemntDetails(result.getSearchResults().get(0).getCollectionItemId(),classpageId,pathwayGooruOid);
					}
				}
				//getView().getSequence(result);
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
	public void setClickedTabPresenter(String clickedTab) {
		clearSlot(COLLECTION_PROGRESS_SLOT);
		if(clickedTab!=null){
			if(clickedTab.equalsIgnoreCase(SUMMARY)){
				collectionSummaryPresenter.setCollectionSummaryData("fe78faa5-f7f0-4927-9282-a58a4e3deb5d");
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionSummaryPresenter,false);
			}else if(clickedTab.equalsIgnoreCase(PROGRESS)){
				collectionProgressPresenter.setCollectionProgressData("fe78faa5-f7f0-4927-9282-a58a4e3deb5d");
				setInSlot(COLLECTION_PROGRESS_SLOT, collectionProgressPresenter,false);
			}
		}else{
			setInSlot(COLLECTION_PROGRESS_SLOT, null,false);
		}
	}
}
