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
package org.ednovo.gooru.client.mvp.assessments.play.collection.end;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.application.client.service.LibraryServiceAsync;
import org.ednovo.gooru.application.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.application.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.application.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.ContentReportDo;
import org.ednovo.gooru.application.shared.model.folder.FolderWhatsNextCollectionDo;
import org.ednovo.gooru.application.shared.model.library.ConceptDo;
import org.ednovo.gooru.application.shared.model.player.CommentsListDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualPresenter;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.assessments.play.collection.AssessmentsPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.end.study.AssessmentsHomeMetadataPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.end.AssessmentsPreviewEndPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.home.AssessmentsPreviewHomePresenter;
import org.ednovo.gooru.client.mvp.assessments.play.resource.body.AssessmentsResourcePlayerMetadataView;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class AssessmentsEndPresenter extends PresenterWidget<IsAssessmentsEndView> implements AssessmentsEndUiHandlers,ClientConstants{

	@Inject
	private PlayerAppServiceAsync playerAppService;

	@Inject
	private LibraryServiceAsync libraryService;

	@Inject
	private AnalyticsServiceAsync analyticService;

    private SimpleAsyncCallback<CommentsListDo> commentsListDoAsync;

	private CollectionDo collectionDo=null;

	private AssessmentsPlayerPresenter collectionPlayerPresenter=null;

	private AssessmentsPreviewHomePresenter previewHomePresenter;

	private AssessmentsPreviewEndPresenter previewEndPresenter;

	private AssessmentsHomeMetadataPresenter collectionHomeMetadataPresenter;

	private CollectionSummaryIndividualPresenter collectionSummaryIndividualPresenter;

	public static final  Object METADATA_PRESENTER_SLOT = new Object();

	private static final String PAGE = "course-page";

	private static final String CREATE = "CREATE";

	private static final String EDIT = "EDIT";

	private static final String FEATCHINGCOMMENT = "FEATCHINGCOMMENT";

	private static final String INITIAL_COMMENT_LIMIT = "10";

	private static final String INITIAL_OFFSET = "0";

	public static final  Object COLLECTION_REPORTS_SLOT=new Object();

	PrintUserDataDO printData=new PrintUserDataDO();

	String classpageId=null;

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	ClasspageItemDo classpageItemDo=null;

	int count=0;
	
	ArrayList<UserDataDo> questionsData=new ArrayList<UserDataDo>();
	final List<Integer> questionRowIndex=new ArrayList<Integer>();
	private int collectionProgressCount=1;

	@Inject
	public AssessmentsEndPresenter(EventBus eventBus, IsAssessmentsEndView view,AssessmentsPreviewHomePresenter previewHomePresenter,
			AssessmentsPreviewEndPresenter previewEndPresenter,AssessmentsHomeMetadataPresenter collectionHomeMetadataPresenter,CollectionSummaryIndividualPresenter collectionSummaryIndividualPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.previewHomePresenter=previewHomePresenter;
		this.previewEndPresenter=previewEndPresenter;
		this.collectionHomeMetadataPresenter=collectionHomeMetadataPresenter;
		this.collectionSummaryIndividualPresenter=collectionSummaryIndividualPresenter;
	}

	public void setCollectionMetadata(final CollectionDo collectionDo,String classpageId){
		this.collectionDo=collectionDo;
		this.classpageId=classpageId;
		getView().setCollectionMetadata(collectionDo);
	}

	public void setPreviewHomePresenter(){
		previewHomePresenter.setCollectionMetadata(collectionDo);
		previewHomePresenter.removeAssignmentButtons();
		setInSlot(METADATA_PRESENTER_SLOT, previewHomePresenter,false);
	}
	public void setPreviewEndPresenter(){
		previewEndPresenter.setCollectionMetadata(collectionDo);
		setInSlot(METADATA_PRESENTER_SLOT, previewEndPresenter,false);
	}

	public void setStudyEndPage(){
		previewHomePresenter.setCollectionMetadata(collectionDo);
		previewHomePresenter.removeAssignmentImagetButtons();
		setInSlot(METADATA_PRESENTER_SLOT, previewHomePresenter,false);
	}

	public void setCollectionHomeMetadata(){
		collectionHomeMetadataPresenter.setCollectionMetadata(collectionDo);
		setInSlot(METADATA_PRESENTER_SLOT, collectionHomeMetadataPresenter,false);
	}
	public void setCollectionSummaryBasedOnClasspageIdSessionId(){
		getSessionsDataByUser(collectionDo.getGooruOid(),classpageId!=null?classpageId:"",AppClientFactory.getLoggedInUser().getGooruUId());
	}

	public void setCollectionSummaryData(String collectionId,String classpageId,String userId,String sessionId,PrintUserDataDO printData){
		if(AppClientFactory.isAnonymous()){
			getView().getLoadingImageLabel().setVisible(false);
		}
		collectionSummaryIndividualPresenter.setIndividualData(collectionId, this.classpageId!=null?this.classpageId:"", userId, sessionId,"",false,getView().getLoadingImageLabel(),printData);
		collectionSummaryIndividualPresenter.setTeacherImage(classpageItemDo);
		setInSlot(COLLECTION_REPORTS_SLOT,collectionSummaryIndividualPresenter,false);
		
		setIndividualData(collectionId, this.classpageId!=null?this.classpageId:"", userId, sessionId,"",false,getView().getLoadingImageLabel(),printData);
	}
	
	
	
	
	public void clearslot(){
		getView().resetData();
		getView().resetCollectionMetaData();
		clearSlot(COLLECTION_REPORTS_SLOT);
		setInSlot(COLLECTION_REPORTS_SLOT,null,false);
	}

	public void resetMetadataFields(){
		getView().resetMetadataFields();
	}

	public PlayerAppServiceAsync getPlayerAppService() {
		return playerAppService;
	}

	public void setPlayerAppService(PlayerAppServiceAsync playerAppService) {
		this.playerAppService = playerAppService;
	}

	public SimpleAsyncCallback<CommentsListDo>  getCommentsListDoAsync() {
		return commentsListDoAsync;
	}

	public void setCommentsListDoAsync(SimpleAsyncCallback<CommentsListDo> commentsListDoAsync) {
		this.commentsListDoAsync = commentsListDoAsync;
	}

	public void setCollectionDoOnRefresh(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		getView().setCollectionMetadata(collectionDo);
	}

	public AssessmentsPlayerPresenter getCollectionPlayerPresenter() {
		return collectionPlayerPresenter;
	}

	public void setCollectionPlayerPresenter(AssessmentsPlayerPresenter collectionPlayerPresenter) {
		this.collectionPlayerPresenter = collectionPlayerPresenter;
		previewHomePresenter.setCollectionPlayerPresenter(collectionPlayerPresenter);
	}

	public void setTeacherInfo(ClasspageItemDo classpageItemDo) {
		this.classpageItemDo=classpageItemDo;
	}

	public void setDataInsightsSummaryUrl(String sessionId){
		getView().setDataInsightsSummaryUrl(sessionId);
	}

	public void setDataInsightsUrl(){
		getView().setDataInsightsUrl();
	}
	public Button getBackToClassButton(){
		return previewHomePresenter.getBackToClassButton();
	}
	public void clearDashBoardIframe(){
		collectionSummaryIndividualPresenter.clearFrame();
	}
	public void setClasspageInsightsUrl(String classpageId, String sessionId){
		getView().setClasspageInsightsUrl(classpageId, sessionId);
	}

	@Override
	public void resetCollectionActivityEventId() {
		collectionPlayerPresenter.resetcollectionActivityEventId();
	}

	@Override
	public void triggerCollectionShareDataEvent(String collectionId,String itemType, String shareType, boolean confirmStatus) {
		if(collectionPlayerPresenter!=null){
			collectionPlayerPresenter.triggerCollectionShareDataEvent( collectionId, itemType,  shareType,  confirmStatus);
		}
	}
	public void displayScoreCount(Integer collectionScore,Integer noOfQuestions){
		getView().displayScoreCount(collectionScore,noOfQuestions);
	}

	@Override
	public void getAvgReaction() {
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}

	@Override
	public void getSessionsDataByUser(final String collectionId,final String classId,final String userId) {
		this.analyticService.getSessionsDataByUser(collectionId, classId, userId, new AsyncCallback<ArrayList<CollectionSummaryUsersDataDo>>() {

			@Override
			public void onSuccess(ArrayList<CollectionSummaryUsersDataDo> result) {
				if(result.size()!=0){
					int day=result.get(result.size()-1).getFrequency();
					printData.setUserName(null);
					printData.setSession(day+AnalyticsUtil.getOrdinalSuffix(day)+" Session");
					printData.setSessionStartTime(AnalyticsUtil.getSessionsCreatedTime((Long.toString(result.get(result.size()-1).getTimeStamp()))));
					getCollectionMetaDataByUserAndSession(collectionId, classId, userId, result.get(result.size()-1).getSessionId(),printData);
					getView().setSessionsData(result);
				}else{
					clearSlot(COLLECTION_REPORTS_SLOT);
					getView().hidePanel();
					collectionSummaryIndividualPresenter.setNoDataMessage(getView().getLoadingImageLabel());
					setInSlot(COLLECTION_REPORTS_SLOT,collectionSummaryIndividualPresenter,false);
				}
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

	}

	public static native String roundToTwo(double number) /*-{
		return ""+(Math.round(number + "e+2")  + "e-2");
	}-*/;
	public void displayScoreCountData(Integer score,Integer questionCount){
//		if(collectionDo!=null&&collectionDo.getCollectionItems()!=null){
//			int questionCount=0;
//			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
//				if(collectionDo.getCollectionItems().get(i).getResource().getResourceType()!=null){
//					String resourceTypeName=collectionDo.getCollectionItems().get(i).getResource().getResourceType().getName();
//					if(resourceTypeName!=null&&resourceTypeName.equalsIgnoreCase("assessment-question")){
//						questionCount++;
//					}
//				}
//			}
		if(questionCount!=null)
		{
			if(questionCount==0){
				displayScoreCount(questionCount,questionCount);
			}else{
				displayScoreCount(score,questionCount);
			}
		}
		else
		{
			questionCount = 0;
			displayScoreCount(score,questionCount);
		}
	}
	@Override
	public void getCollectionMetaDataByUserAndSession(final String collectionId,final String classId, final String userId, final String sessionId,final PrintUserDataDO printData) {
		this.analyticService.getCollectionMetaDataByUserAndSession(collectionId, classId, userId, sessionId, new AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>>() {
			@Override
			public void onSuccess(ArrayList<CollectionSummaryMetaDataDo> result) {
						if (result.size()!=0 && result.get(0).getCompletionStatus() != null && result.get(0).getCompletionStatus().equalsIgnoreCase("completed")) {
								count = 0;
								displayScoreCountData(result.get(0).getScore(),result.get(0).getTotalQuestionCount());
								getView().setCollectionMetaDataByUserAndSession(result);
								setCollectionSummaryData(collectionId, classId,	userId, sessionId, printData);
							} else {
								Timer timer = new Timer() {
								    public void run() {
								          if (count < 10) {
								        	  getCollectionMetaDataByUserAndSession(collectionId, classId, userId,sessionId, printData);
								        	  count++;
								          } else {
								        	  	if (count >= 10) {
												   getView().showMessageWhenDataNotFound();
												   displayScoreCount(0,0);
								        	  	}
								          }
								        }
								      };
								      // Execute the timer to expire 2 seconds in the future
								      timer.schedule(2000);
							}
			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

	}

	
	/*analytics*/
	
	public void setIndividualData(final String collectionId, final String classpageId,final String userId, final String sessionId,final String pathwayId,final boolean isSummary,final HTMLPanel loadingImage,final PrintUserDataDO printUserDataDO) {
		GWT.runAsync(new SimpleRunAsyncCallback() {
			
			@Override
			public void onSuccess() {

				//getView().enableAndDisableEmailButton(isSummary);
				analyticService.getCollectionMetaDataByUserAndSession(collectionId, classpageId,userId, sessionId, new AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>>() {
					
					@Override
					public void onSuccess(ArrayList<CollectionSummaryMetaDataDo> result) {
						if(!StringUtil.checkNull(result)){
							//getView().setIndividualCollectionMetaData(result,printUserDataDO);
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
					
					}
				});
				analyticService.getUserSessionDataByUser(collectionId, classpageId,userId, sessionId, pathwayId,new AsyncCallback<ArrayList<UserDataDo>>() {
					
					@Override
					public void onSuccess(ArrayList<UserDataDo> result) {
						if(!StringUtil.checkNull(result)){
							setIndividualData(result,loadingImage);
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
			}
		});
	}
	
	
	public void setIndividualData(final ArrayList<UserDataDo> result,final HTMLPanel loadingImage) {
		
		GWT.runAsync(new SimpleRunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				collectionProgressCount=0;
				Collections.sort(result,new Comparator<UserDataDo>() {
		        	public int compare(UserDataDo o1, UserDataDo o2) {
		        		 Integer obj1 = new Integer(o1.getItemSequence());
						 Integer obj2 = new Integer(o2.getItemSequence());
		        	     return obj1.compareTo(obj2);
		        	}
		        });
				for (UserDataDo userDataDo : result) {
					if(userDataDo.getStatus()==0){
						if(QUESTION.equalsIgnoreCase(userDataDo.getResourceFormat())){
							if(!OE.equalsIgnoreCase(userDataDo.getType())){
								questionsData.add(userDataDo);
							}
							questionRowIndex.add(collectionProgressCount);
						}
						collectionProgressCount++;
					}
				}
				getView().setQuestionsData(questionsData);
				getView().setQuestionsPrintData(questionsData);
		
			}
		});
	}

	@Override
	public void setHtmltopdf(final String htmlString, final String fileName,final boolean isClickedOnEmail) {
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				analyticService.setHTMLtoPDF(htmlString,fileName,isClickedOnEmail, new AsyncCallback<String>() {
					@Override
					public void onSuccess(String result) {

						if(!StringUtil.checkNull(result)){
							if(isClickedOnEmail){
								getView().setPdfForEmail(result);
							}else{
								getView().getFrame().setUrl(result);
							}
						}
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});

			}
		});
	}


}
