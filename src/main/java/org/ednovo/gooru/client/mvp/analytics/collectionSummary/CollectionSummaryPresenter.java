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
package org.ednovo.gooru.client.mvp.analytics.collectionSummary;
import java.util.ArrayList;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualPresenter;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryTeacher.CollectionSummaryTeacherPresenter;
import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryUsersDataDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class CollectionSummaryPresenter extends PresenterWidget<IsCollectionSummaryView> implements CollectionSummaryUiHandlers{
	
	public static final  Object TEACHER_STUDENT_SLOT = new Object();
	
	private CollectionSummaryTeacherPresenter collectionSummaryTeacherPresenter;
	
	private CollectionSummaryIndividualPresenter collectionSummaryIndividualPresenter;

    ArrayList<CollectionSummaryMetaDataDo> collectionMetadata;
	
	@Inject
	private  AnalyticsServiceAsync analyticService;
	@Inject
	public CollectionSummaryPresenter(EventBus eventBus, IsCollectionSummaryView view,CollectionSummaryTeacherPresenter collectionSummaryTeacherPresenter,CollectionSummaryIndividualPresenter collectionSummaryIndividualPresenter) {
		super(eventBus, view);
		this.collectionSummaryTeacherPresenter=collectionSummaryTeacherPresenter;
		this.collectionSummaryIndividualPresenter=collectionSummaryIndividualPresenter;
		getView().setUiHandlers(this);
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}

	@Override
	public void setCollectionSummaryData(final String collectionId,final String pathwayId) {
		getView().getLoadinImage().setVisible(true);
		final String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		this.analyticService.getCollectionSummaryUsersData(classpageId,new AsyncCallback<ArrayList<CollectionSummaryUsersDataDo>>() {
			
			@Override
			public void onSuccess(ArrayList<CollectionSummaryUsersDataDo> result) {
				getView().setUsersData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
		this.analyticService.getCollectionMetaData(collectionId,classpageId,new AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>>() {
			
			@Override
			public void onSuccess(ArrayList<CollectionSummaryMetaDataDo> result) {
				getView().setCollectionMetaData(result,pathwayId);
				collectionMetadata=result;
				setTeacherData(collectionId,classpageId,pathwayId);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	@Override
	public void loadUserSessions(final String collectionId,final String classId,final String userId,final String pathwayId) {
		this.analyticService.getSessionsDataByUser(collectionId, classId, userId, new AsyncCallback<ArrayList<CollectionSummaryUsersDataDo>>() {
			
			@Override
			public void onSuccess(ArrayList<CollectionSummaryUsersDataDo> result) {
				getView().setUserSessionsData(result);
				if(result.size()!=0)
				setIndividualData(collectionId,classId,userId,result.get(0).getSessionId(), pathwayId);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	@Override
	public void setTeacherData(String collectionId,String classpageId,String pathwayId) {
		getView().getLoadinImage().setVisible(true);
		clearSlot(TEACHER_STUDENT_SLOT);
		collectionSummaryTeacherPresenter.setTeacherData(collectionId,classpageId,pathwayId,collectionMetadata,getView().getLoadinImage());
		setInSlot(TEACHER_STUDENT_SLOT, collectionSummaryTeacherPresenter,false);		
	}

	@Override
	public void setIndividualData(String collectionId,String classpageId,String userId,String sessionId,String pathwayId) {
		getView().getLoadinImage().setVisible(true);
		clearSlot(TEACHER_STUDENT_SLOT);
		collectionSummaryIndividualPresenter.setIndividualData(collectionId,classpageId,userId,sessionId,pathwayId,true,getView().getLoadinImage());
		setInSlot(TEACHER_STUDENT_SLOT, collectionSummaryIndividualPresenter,false);	
	}
	
}
