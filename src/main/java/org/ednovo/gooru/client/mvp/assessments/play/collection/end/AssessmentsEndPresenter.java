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

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.application.client.service.LibraryServiceAsync;
import org.ednovo.gooru.application.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.application.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.application.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.ContentReportDo;
import org.ednovo.gooru.application.shared.model.folder.FolderWhatsNextCollectionDo;
import org.ednovo.gooru.application.shared.model.library.ConceptDo;
import org.ednovo.gooru.application.shared.model.player.CommentsListDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualPresenter;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.assessments.play.collection.AssessmentsPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.end.study.AssessmentsHomeMetadataPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.event.AssessmentsSetPlayerLoginStatusEvent;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.end.AssessmentsPreviewEndPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.home.AssessmentsPreviewHomePresenter;
import org.ednovo.gooru.client.mvp.assessments.play.resource.body.AssessmentsResourcePlayerMetadataView;
import org.ednovo.gooru.client.uc.PlayerBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class AssessmentsEndPresenter extends PresenterWidget<IsAssessmentsEndView> implements AssessmentsEndUiHandlers{

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
		setRelatedConcepts(collectionDo);
	}

	public void displayAuthorDetails(boolean isDisplayDetails){
		getView().displayAuthorDetails(isDisplayDetails);
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
	}
	public void clearslot(){
		getView().resetData();
		getView().resetCollectionMetaData();
		clearSlot(COLLECTION_REPORTS_SLOT);
		setInSlot(COLLECTION_REPORTS_SLOT,null,false);
	}

	public void setViewCount(String viewCount){
		getView().setViewCount(viewCount);
	}

	public void updateLikesCount(int likesCount){
		//getView().setLikesCount(likesCount);
	}

	public void setUserProfileName(String gooruUid){
		getView().setUserProfileName(gooruUid);
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

	public void getFlagedReport(String gooruOid) {
		playerAppService.getContentReport(collectionDo.getGooruOid(), AppClientFactory.getGooruUid(), new SimpleAsyncCallback<ArrayList<ContentReportDo>>() {
			@Override
			public void onSuccess(ArrayList<ContentReportDo> result) {
				String gooruFlagId="";
				if(result.size()==0){
					getView().getFlagButton().setText(i18n.GL0556());
					getView().getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().previewCoverFlagImageOrange());
					getView().getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().playerPreviewCoverFlagImage());
				}else{
					for(int i =0;i<result.size();i++){
						gooruFlagId = gooruFlagId+result.get(i).getDeleteContentGooruOid();
						getView().getFlagButton().setText(i18n.GL0557());
						getView().getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().playerPreviewCoverFlagImage());
						getView().getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().previewCoverFlagImageOrange());

					}
			}
			}
		});

	}

	public void setRelatedConcepts(final CollectionDo collectionDo) {
		final String subject = AppClientFactory.getPlaceManager().getRequestParameter("subject");
		final String lessonId = AppClientFactory.getPlaceManager().getRequestParameter("lessonId", "123");
		final String libraryType = AppClientFactory.getPlaceManager().getRequestParameter("library", PlaceTokens.DISCOVER);
		final String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderId");
		final String folderItemId = AppClientFactory.getPlaceManager().getRequestParameter("folderItemId");

		if(folderId==null && folderItemId==null) {
			getView().hideNextCollectionContainer(true);
			if(subject!=null) {
				this.libraryService.getLibraryCollections(subject, lessonId, libraryType, new SimpleAsyncCallback<ArrayList<ConceptDo>>() {
					@Override
					public void onSuccess(ArrayList<ConceptDo> conceptDoList) {
						getView().isConceptsContainerVisible(true);
						getView().setRelatedConceptsContent(conceptDoList, PAGE, subject, lessonId, libraryType);
						if(conceptDoList!=null){
							for(int i=0;i<conceptDoList.size();i++){
								if(!conceptDoList.get(i).getGooruOid().equals(collectionDo.getGooruOid())){
									getNextCollectionDetails(conceptDoList.get(i).getGooruOid(),PAGE,subject,lessonId,libraryType);
									return;
								}
							}
						}
					}
				});
			} else {
				getView().isConceptsContainerVisible(false);
			}
		}
		else
		{
		getNextCollectionItem(folderId,folderItemId,collectionDo.getUrl());
		}


	}

	public void getNextCollectionDetails(String gooruOid, String page, final String subject,final  String lessonId, final String libraryType){
		getView().hideNextCollectionContainer(false);
		AppClientFactory.getInjector().getPlayerAppService().getSimpleCollectionDetils(null, gooruOid, null, null, null, new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo result) {
				getView().displayNextCollectionDetails(result,subject, lessonId,libraryType);
			}
		});
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
		getView().clearDashBoardIframe();
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
	public void displaySpendTime(Long hours,Long mins, Double secs){
		getView().displaySpendTime( hours,mins, secs);
	}
	public void displayScoreCount(Integer collectionScore,Integer noOfQuestions){
		getView().displayScoreCount(collectionScore,noOfQuestions);
	}

	@Override
	public void getAvgReaction() {
	}

	public void showAvgReaction(Integer averageReaction){
		averageReaction=averageReaction!=null?averageReaction:0;
		String reactionType=null;

		switch (averageReaction) {
		case 5:
			reactionType=AssessmentsResourcePlayerMetadataView.REACTION_CAN_EXPLAIN;
			break;
		case 4:
			reactionType=AssessmentsResourcePlayerMetadataView.REACTION_CAN_UNDERSTAND;
			break;
		case 2:
			reactionType=AssessmentsResourcePlayerMetadataView.REACTION_DONOT_UNDERSTAND;
			break;
		case 3:
			reactionType=AssessmentsResourcePlayerMetadataView.REACTION_MEH;
			break;
		case 1:
			reactionType=AssessmentsResourcePlayerMetadataView.REACTION_NEED_HELP;
			break;
		}
		getView().showAvgReaction(reactionType);
	}

	public void dispalyTime(){
		getView().dispalyTime();
	}

	@Override
	public void updateCommentsStatus(String commentsStatus) {
		if(collectionPlayerPresenter!=null){
			collectionPlayerPresenter.updateCommentsStatus(commentsStatus);
		}

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
	public void convertMilliSecondsToTime(Long milliSeconds){
		//milliSeconds=milliSeconds>0&&milliSeconds<1000?1000:milliSeconds;
		double totalSecs = (double)milliSeconds/1000;
		//totalSecs=Math.round(totalSecs);
	    long hours = (long) (totalSecs / 3600);
	    long mins = (long) ((totalSecs / 60) % 60);
	    double secs = (double) (totalSecs % 60);
	    String formattedResult=roundToTwo(secs);
	    displaySpendTime(hours,mins,Double.valueOf(formattedResult));
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
								showAvgReaction( result.get(0).getAvgReaction());
								convertMilliSecondsToTime(result.get(0).getAvgTimeSpent());
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
												   showAvgReaction(0);
												   convertMilliSecondsToTime(0L);
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

	public void getNextCollectionItem(String folderId,String folderItemId,final String urlVal) {
		if(folderId!=null && folderItemId!=null) {
			AppClientFactory.getInjector().getPlayerAppService().getNextCollectionFromToc(folderId, folderItemId, new SimpleAsyncCallback<FolderWhatsNextCollectionDo>() {
				@Override
				public void onSuccess(FolderWhatsNextCollectionDo result) {
					if(result.getTitle()!=null){
						getCollection(result.getGooruOid(),result);
					}else{
						getView().hideNextCollectionContainer(true);
					}
				}
			});
		} else {
			getView().hideNextCollectionContainer(true);
		}
	}
	public void getCollection(String nextCollId,final FolderWhatsNextCollectionDo result){

		this.playerAppService.getSimpleCollectionDetils(null,nextCollId,null,null, null, new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo collectionDo) {
				getView().displayWhatsNextContent(result,collectionDo.getUrl());
			}
		});
	}

}
