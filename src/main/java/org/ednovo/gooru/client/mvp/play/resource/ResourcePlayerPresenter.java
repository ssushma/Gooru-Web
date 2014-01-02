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
package org.ednovo.gooru.client.mvp.play.resource;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.play.collection.GwtUUIDGenerator;
import org.ednovo.gooru.client.mvp.play.collection.event.ShowResourceTabWidgetEvent;
import org.ednovo.gooru.client.mvp.play.collection.event.ShowResourceViewEvent;
import org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter;
import org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionPresenter;
import org.ednovo.gooru.client.mvp.play.resource.body.ResourcePlayerMetadataPresenter;
import org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayPresenter;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListInPlayEvent;
import org.ednovo.gooru.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.PlayerConstants;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

public class ResourcePlayerPresenter extends BasePlacePresenter<IsResourcePlayerView, ResourcePlayerPresenter.IsResourcePlayerProxy> implements ResourcePlayerUiHandlers{
	
	@Inject
	private PlayerAppServiceAsync playerAppService;
	
    private SimpleAsyncCallback<CollectionDo> collectionDetailsAsync;
    
    private ResourcePlayerMetadataPresenter resoruceMetadataPresenter;
    
    private ResourceSharePresenter resourceSharePresenter;
    
    private ResourceInfoPresenter resourceInfoPresenter;
    
    private AddResourceCollectionPresenter addResourceCollectionPresnter;
    
    private CollectionFormInPlayPresenter collectionFormInPlayPresenter;
    
    private CollectionItemDo collectionItemDo;
    
    private String gooruOid=null;
    
    private String resourceActivityEventId=null;
    
    private String sessionId=null;
    
    private String sessionItemId=null;
    
    private String resourceDataLogEventId;
    
    private Long resourceStartTime=0L;
    
    private Long hintOrExplanationStartTime=0L;
    
    private String hintOrExplanationEventName=null;
    
    private String hintOrExplanationEventId=null;
    
    private String resourcePlayEventName=null;
       
	private Map<String,AttemptedAnswersDo> attemptAnswersMap=new HashMap<String,AttemptedAnswersDo>();
	
	private List<Integer> attemptTrySequence=new ArrayList<Integer>();
	
	private List<Integer> attemptStatus=new ArrayList<Integer>();
	
	private List<Integer> answerIds=new ArrayList<Integer>();
	
	private String oeQuestionAnswerText="";
	
	private int hintId=0;
	
	private boolean isExplanationUsed=false;
	
    
    public static final  Object TAB_PRESENTER_SLOT = new Object(); 
    public static final  Object METADATA_PRESENTER_SLOT = new Object();
    public static final String ADD_WIDGET_MODE="ADD";
    public static final String RESOURCE_THUMBS_WIDGET_MODE="RESOURCE_RATING";
    public static final String FLAG_WIDGET_MODE="FLAG";
	
	
	@Inject
	public ResourcePlayerPresenter(ResourcePlayerMetadataPresenter resoruceMetadataPresenter,ResourceSharePresenter resourceSharePresenter,
			ResourceInfoPresenter resourceInfoPresenter,EventBus eventBus, CollectionFormInPlayPresenter collectionFormInPlayPresenter,
			IsResourcePlayerView view, IsResourcePlayerProxy proxy,AddResourceCollectionPresenter addResourceCollectionPresnter) {
		super(view, proxy);
		getView().setUiHandlers(this);
		this.resoruceMetadataPresenter=resoruceMetadataPresenter;
		this.resourceSharePresenter=resourceSharePresenter;
		this.resourceInfoPresenter=resourceInfoPresenter;
		this.addResourceCollectionPresnter=addResourceCollectionPresnter;
		addResourceCollectionPresnter.getAddNewCollectionButton().addClickHandler(new ShowNewCollectionWidget());
		this.collectionFormInPlayPresenter=collectionFormInPlayPresenter;
		addResourceCollectionPresnter.getAddCollectionViewButton().setVisible(false);
		resoruceMetadataPresenter.setResourcePlayerPresenter(this, false);
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.RESOURCE_PLAY_OLD)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsResourcePlayerProxy extends ProxyPlace<ResourcePlayerPresenter> {
	}

	@Override
	protected final void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}
	
	@Override
	public void onBind() {
	  super.onBind();
	  addRegisteredHandler(ShowResourceViewEvent.TYPE, this);
	  addRegisteredHandler(ShowResourceTabWidgetEvent.TYPE, this);
	  addRegisteredHandler(RefreshCollectionInShelfListInPlayEvent.TYPE, this);
	}
	@Override
	protected void onReveal() {
	  super.onReveal();
	}
	@Override
	protected void onReset() {
		  super.onReset();
	}
	
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		getResourceDetails();
	}
	
	public void getResourceDetails(){
		  final String resourceId=getPlaceManager().getRequestParameter("id", null);
		  final String tabView=getPlaceManager().getRequestParameter("tab", null);
		  final String apiKey=getPlaceManager().getRequestParameter("key", null);
		  if(this.collectionItemDo!=null){
			  if(resourceId!=null&&!resourceId.equals("")){
				  showResourceView(resourceId,tabView);
				  showTabWidget(tabView,resourceId);
			  }
		  }else{
			 // if(apiKey!=null && !apiKey.equalsIgnoreCase("")){
			      if(resourceId!=null && !resourceId.equalsIgnoreCase("")){
			    	  this.playerAppService.getResourceCollectionItem(apiKey,resourceId,tabView, new SimpleAsyncCallback<CollectionItemDo>() {
			    			@Override
			    			public void onSuccess(CollectionItemDo collectionItemDo) {
			    				showResoruceView(collectionItemDo,resourceId,tabView);
			    			}
			    		});
			      }
			 // }
			 // else{
				  //TODO need to implemente error message if API key is missing or invalid.
			//	  Window.alert("API KEY IS MISSING");
			 // }
		  }
	}

	
	public void showResoruceView(CollectionItemDo collectionItemDo,String resourceId, String tabView){
		  this.collectionItemDo=collectionItemDo;
		  if(resourceId==null || resourceId.equalsIgnoreCase("")){
			  return;
		  }
		  else{  
			  showResourceView(resourceId,tabView);
			  showTabWidget(tabView,resourceId);
		  }
	}
	
	public PlayerAppServiceAsync getPlayerAppService() {
		return playerAppService;
	}

	public void setPlayerAppService(PlayerAppServiceAsync playerAppService) {
		this.playerAppService = playerAppService;
	}

	public SimpleAsyncCallback<CollectionDo> getCollectionDetailsAsync() {
		return collectionDetailsAsync;
	}

	public void setCollectionDetailsAsync(SimpleAsyncCallback<CollectionDo> collectionDetailsAsync) {
		this.collectionDetailsAsync = collectionDetailsAsync;
	}

	public void showResourceView(String resourceId,String tabView) {
		if(gooruOid!=null&&gooruOid.equals(this.collectionItemDo.getResource().getGooruOid())){
			makeButtonActive(tabView);
			return;
		}
		enablePlayerButton(true,true, true);
		makeButtonActive(tabView);
		resetAnswerLists();
		createResourceDataLogs();
		gooruOid=this.collectionItemDo.getResource().getGooruOid();
		updateResourceViewCount(gooruOid,collectionItemDo.getViews().toString(),null);
		getView().setResourceTitle(collectionItemDo.getResource().getTitle());
		updateThumbsRatingView(collectionItemDo.getResource().getUserRating());
		resoruceMetadataPresenter.showResourceWidget(collectionItemDo);
		setInSlot(METADATA_PRESENTER_SLOT, resoruceMetadataPresenter,false);
	}
	public void makeButtonActive(String tabView){
		if(tabView!=null){
			//getView().clearActiveButtion();
			if(tabView.equalsIgnoreCase("add")){
				getView().clearActiveButton(false,true, true);
				getView().makeButtonActive(true,false, false);	
			}
			else if(tabView.equalsIgnoreCase("info")){
				getView().clearActiveButton(true,false, true);
				getView().makeButtonActive(false,true, false);	
			}
			else if(tabView.equalsIgnoreCase("share")){
				getView().clearActiveButton(true,true, false);
				getView().makeButtonActive(false,false, true);
			}
			
		}
	}
	@Override
	public void showResourceView(Integer collectionItemSequence, boolean isForwardDirection) {
		//getCollectionItemDo(collectionItemSequence,isForwardDirection);
	}
	
	public void showTabWidget(String tabView,String resourceId){
		if(tabView==null||tabView.equals("")){
			getView().clearActiveButton(true,true,true);
			new CustomAnimation(getView().getNavigationContainer()).run(400);
		}
		else if(tabView.equals("add")){
			setAddResourceCollectionView(resourceId);
		 }
		else if(tabView.equals("share")){
			 setResourceShareView(resourceId);
		 }else if(tabView.equals("info")){
			 setResourceInfoView(resourceId);
		 }
		 else{
			 getView().getNavigationContainer().clear();
		 }
	}
	public void setAddResourceCollectionView(String resourceId){
		if(AppClientFactory.isAnonymous()){
			showLoginPopupWidget(ADD_WIDGET_MODE);
		}else{
			addResourceCollectionPresnter.setCollectionItemData(null, collectionItemDo);
			setInSlot(TAB_PRESENTER_SLOT, addResourceCollectionPresnter,false);
			new CustomAnimation(getView().getNavigationContainer()).run(400);
		}
	}
	public void setResourceInfoView(String resourceId){
		resourceInfoPresenter.setResoruceDetails(collectionItemDo);
		setInSlot(TAB_PRESENTER_SLOT, resourceInfoPresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
	}
	public void setResourceShareView(String resourceId){
		resourceSharePresenter.setResourceShareData(collectionItemDo);
		setInSlot(TAB_PRESENTER_SLOT, resourceSharePresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
	}
	
	public void clearTabSlot(){
		clearSlot(TAB_PRESENTER_SLOT);
	}
	
	public void enablePlayerButton(boolean isAddButtonEnable,boolean isInfoButtonEnable, boolean isShareButtonEnable){
		getView().enablePlayerButton(isAddButtonEnable,isInfoButtonEnable, isShareButtonEnable);
	}
	
	public void createResourceDataLogs(){
		resourceActivityEventId=GwtUUIDGenerator.uuid();
		startPlayerActivityEvent(resourceActivityEventId, "", PlayerConstants.RESOURCE_PLAYER_EVENT_NAME, "", collectionItemDo.getResource().getGooruOid(), PlayerConstants.RESOURCE_PLAYER_CONTEXT+collectionItemDo.getResource().getGooruOid(), getUserAgent());
		createSession(collectionItemDo.getResource().getGooruOid());
		startResourceInsightDataLog();
	}
	public void startResourceInsightDataLog(){
		resourceDataLogEventId=GwtUUIDGenerator.uuid();
		resourceStartTime=System.currentTimeMillis();
		if(collectionItemDo!=null){
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					resourcePlayEventName=PlayerDataLogEvents.QUESTION_RESOURCE_OE_EVENT_NAME;
				}else{
					resourcePlayEventName=PlayerDataLogEvents.QUESTION_RESOUCE_PLAY_EVENT_NAME;
				}
			}else{
				resourcePlayEventName=PlayerDataLogEvents.RESOUCE_PLAY_EVENT_NAME;
			}
		}
		PlayerDataLogEvents.resourcePlayStartStopEvent(resourceDataLogEventId, resourcePlayEventName, "",collectionItemDo.getResource().getGooruOid(),"", PlayerDataLogEvents.START_EVENT_TYPE, resourceStartTime,
	                 resourceStartTime, 0L,AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length());
	}
	
	public void stopResourceInsightDataLog(){
		stopHintOrExplanationEvent();
		Long resourceEndTime=System.currentTimeMillis();
		PlayerDataLogEvents.resourcePlayStartStopEvent(resourceDataLogEventId, resourcePlayEventName, "",collectionItemDo.getResource().getGooruOid(),"", PlayerDataLogEvents.STOP_EVENT_TYPE, resourceStartTime,
				resourceEndTime,resourceEndTime-resourceStartTime,AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length());
	}
	public void stopDataLogEvents(){
		//TODO need to implement stop datalog events 
	}
	public void startPlayerActivityEvent(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,
			String context,String userAgent){
		this.playerAppService.startActivityPlayerLog(activityEventId, activityParentEventId, eventName, gooruOid, 
				resourceGooruOid, context, userAgent, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String activityEventId) {
				
			}
		});
	}
	public void stopPlayerActivityEvent(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,
			String context,String userAgent){
			this.playerAppService.stopActivityPlayerLog(activityEventId, activityParentEventId, eventName, gooruOid, 
				resourceGooruOid, context, userAgent, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String activityEventId) {
				
			}
		});
	}
	public void createSession(String collectionGooruOid){
		this.playerAppService.createSessionTracker(collectionGooruOid, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String sessionId) {
				ResourcePlayerPresenter.this.sessionId=sessionId;
				if(collectionItemDo!=null){
					createSessionItem(sessionId, collectionItemDo.getResource().getGooruOid(), collectionItemDo.getResource().getGooruOid());
				}
			}
		});
	}
	
	public void createSessionItem(String sessionTrackerId,String collectionItemId, String resourceGooruOid){
		this.playerAppService.createSessionItemInCollection(sessionTrackerId, collectionItemId, resourceGooruOid, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String sessionItemId) {
				ResourcePlayerPresenter.this.sessionItemId=sessionItemId;
			}
		});
	}
	
	public void createSessionItemAttempt(int answerId, String attemptResult){
		this.playerAppService.createSessionItemAttemptTry(sessionId, sessionItemId, answerId, attemptResult, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String sessionItemId) {}
		});
	}
	
	public void createSessionItemAttemptOe(String attemptAnswerResult){
		this.playerAppService.createSessionItemAttemptTryForOe(sessionId, sessionItemId, attemptAnswerResult, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String sessionItemId) {}
		});
	}
	
	public void updateSession(String sessionTrackerId){
		if(sessionTrackerId!=null){
			this.playerAppService.updateSessionInCollection(sessionTrackerId, new SimpleAsyncCallback<String>() {
				@Override
				public void onSuccess(String sessionItemId) {}
			});
		}
	}
	
	public void setUserAttemptResult(String collectionItemId,AttemptedAnswersDo attemptAnswersDo){
		attemptAnswersMap.put(collectionItemId, attemptAnswersDo);
	}
	
	public void removeUserAttemptResult(){
		attemptAnswersMap.remove(collectionItemDo.getCollectionItemId());
	}
	
	public Map<String, AttemptedAnswersDo> getAttemptAnswersMap() {
		return attemptAnswersMap;
	}
	
	public String getUserAgent(){
		return Window.Navigator.getUserAgent();
	}
	
	public void resetAnswerLists(){
		attemptTrySequence.clear();
		attemptStatus.clear();
		answerIds.clear();
		oeQuestionAnswerText="";
		isExplanationUsed=false;
		hintId=0;
		hintOrExplanationEventName=null;
	}
	
	public void setAnswerAttemptSequence(int attemptSequence,int attemptStatus,int answerId){
		this.attemptTrySequence.add(attemptSequence);
		this.attemptStatus.add(attemptStatus);
		this.answerIds.add(answerId);
	}
	
	public void setOeQuestionAnswerText(String oeAnswerText){
		this.oeQuestionAnswerText=oeAnswerText;
	}
	
	public void startHintDataLogEvent(int hintId){
		stopHintOrExplanationEvent();
		this.hintId=hintId;
		hintOrExplanationStartTime=System.currentTimeMillis();
		hintOrExplanationEventId=GwtUUIDGenerator.uuid();
		if(collectionItemDo!=null){
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					hintOrExplanationEventName=PlayerDataLogEvents.QUESTION_OE_HINT_EVENT_NAME;
				}else{
					hintOrExplanationEventName=PlayerDataLogEvents.QUESTION_RESOURCE_HINT_EVENT_NAME;
				}
			}
		}
		PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, hintOrExplanationEventName, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(),
				"", PlayerDataLogEvents.START_EVENT_TYPE, hintOrExplanationStartTime, hintOrExplanationStartTime, 0L, AppClientFactory.getLoginSessionToken(),
				AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
	}
	
	public void startExplanationDataLogEvent(){
		stopHintOrExplanationEvent();
		isExplanationUsed=true;
		hintOrExplanationEventId=GwtUUIDGenerator.uuid();
		if(collectionItemDo!=null){
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					hintOrExplanationEventName=PlayerDataLogEvents.QUESTION_OE_EXPLANATION_EVENT_NAME;
				}else{
					hintOrExplanationEventName=PlayerDataLogEvents.QUESTION_RESOURCE_EXPLANATION_EVENT_NAME;
				}
			}
		}
		PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, hintOrExplanationEventName, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(), 
				"", PlayerDataLogEvents.START_EVENT_TYPE, hintOrExplanationStartTime,hintOrExplanationStartTime, 0L, AppClientFactory.getLoginSessionToken(),
				AppClientFactory.getGooruUid(), isExplanationUsed,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
	}
	
	public void saveOeQuestionAnswerDataLogEvent(){
		stopHintOrExplanationEvent();
		hintOrExplanationEventName=null;
		String submitEventId=GwtUUIDGenerator.uuid();
		Long answerEndTime=System.currentTimeMillis();
		PlayerDataLogEvents.submitOeAnswerDataLogEvent(submitEventId, PlayerDataLogEvents.QUESTION_OE_SAVE_EVENT_NAME, resourceDataLogEventId,
				collectionItemDo.getResource().getGooruOid(),resourceStartTime,answerEndTime, answerEndTime-resourceStartTime,
				 AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),"");
	}
	
	public void stopHintOrExplanationEvent(){
		if(hintOrExplanationEventName!=null){
			Long endTime=System.currentTimeMillis();
			Long spendTime=endTime-hintOrExplanationStartTime;
			if(hintOrExplanationEventName.equals(PlayerDataLogEvents.QUESTION_RESOURCE_EXPLANATION_EVENT_NAME)){
				PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_EXPLANATION_EVENT_NAME, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(), 
	    				"", PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime,endTime, spendTime, AppClientFactory.getLoginSessionToken(),
	    				AppClientFactory.getGooruUid(), true,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
			}else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.QUESTION_RESOURCE_HINT_EVENT_NAME)){
				PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_HINT_EVENT_NAME, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(),
						"", PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime, endTime, spendTime,  AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
			}
			else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.QUESTION_OE_EXPLANATION_EVENT_NAME)){
				PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_OE_EXPLANATION_EVENT_NAME, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(), 
						"", PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime,endTime, spendTime, AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), true,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
			}else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.QUESTION_OE_HINT_EVENT_NAME)){
				PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_OE_HINT_EVENT_NAME, resourceDataLogEventId, collectionItemDo.getResource().getGooruOid(),
						"", PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime, endTime, spendTime, AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
			}
		}
	}
	
	public void updateResourceViewCount(String gooruId,String viewsCount,String resourceType){
		this.playerAppService.updateViewCount(gooruId, viewsCount, resourceType, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
					updateViewCount();
			}
		});
	}
	
	public void updateViewCount(){
		if(collectionItemDo!=null){
			String viewsCount=collectionItemDo.getResource().getViews();
			Integer viewsCounts=Integer.parseInt(viewsCount)+1;
			collectionItemDo.getResource().setViews(viewsCounts.toString());
			resourceInfoPresenter.updateViewsCount(viewsCounts.toString());
		}
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.RESOURCE_PLAY;
	}

	@Override
	public void resetResourcePlayer() {
		getView().setResourceTitle("");
		enablePlayerButton(false,false, false);
		clearTabSlot();
		this.collectionItemDo=null;
		this.gooruOid=null;
		resoruceMetadataPresenter.resetResourceMetaData();
		resourceInfoPresenter.resetResourceInfo();
	}
	
	public void showLoginPopupWidget(String widgetMode){
		LoginPopupUc popup =new LoginPopupUc();
		popup.setWidgetMode(widgetMode);
		popup.setGlassEnabled(true);
	}

	@Override
	public void showTabWidget(String widgetMode,boolean isLoginRequestCancel) {
		  String resourceId=getPlaceManager().getRequestParameter("id", null);
		  if(!isLoginRequestCancel&&widgetMode.equals(ADD_WIDGET_MODE)){
			  getResource(resourceId);
			  setAddResourceCollectionView(resourceId);
		  } else if(!isLoginRequestCancel&&widgetMode.equals(RESOURCE_THUMBS_WIDGET_MODE)){
			  getResource(resourceId);
		  }else if(isLoginRequestCancel&&widgetMode.equals(ADD_WIDGET_MODE)){
			  PlaceRequest request=new PlaceRequest(PlaceTokens.RESOURCE_PLAY).with("id", resourceId);
		      AppClientFactory.getPlaceManager().revealPlace(false,request,true);
		  }
	}
	public void  getResource(String resourceId){
		this.playerAppService.getResourceCollectionItem(null,resourceId,null, new SimpleAsyncCallback<CollectionItemDo>() {
			@Override
			public void onSuccess(CollectionItemDo collectionItemDo) {
				ResourcePlayerPresenter.this.collectionItemDo=collectionItemDo;
				updateThumbsRatingView(collectionItemDo.getResource().getUserRating());
			}
		});
	}
	public class ShowNewCollectionWidget implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			String resourceId=collectionItemDo.getResource().getGooruOid();
			addToPopupSlot(collectionFormInPlayPresenter);
			collectionFormInPlayPresenter.setResourceUid(resourceId);
		}
	}
	
	public void updateAddResourceCollectionWidget(String collectionId){
		addResourceCollectionPresnter.updateWorkSpaceLink(collectionId);
	}
	
	@Override
	public void refreshCollectionInShelfListInPlay(String collectionId) {
		updateAddResourceCollectionWidget(collectionId);
	}

	@Override
	public void updateResourceThumbsRating(final int userThumbsRataing) {
		System.out.println("user rating in presenter===>"+userThumbsRataing);
		String resourceGooruOid=collectionItemDo.getResource().getGooruOid();
		this.playerAppService.updateContentThumbsRating(resourceGooruOid, userThumbsRataing, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				updateThumbsRatingView(userThumbsRataing);
			}
		});
	}
	
	public void updateThumbsRatingView(int userThumbsRataing) {
		updateResourceLikes(userThumbsRataing);
		getView().updateThumbsRatingView(userThumbsRataing);
	}
	
	public void updateResourceLikes(int userThumbsRataing){
		int resourceLikes=collectionItemDo.getRating().getVotesUp();
		int userRating=collectionItemDo.getResource().getUserRating();
		if(userThumbsRataing==1){
			resourceLikes=resourceLikes+1;
		}else if((userThumbsRataing==0||userThumbsRataing==-1)&&userRating==1){
			resourceLikes=resourceLikes-1;
		}
		resourceLikes=resourceLikes<0?0:resourceLikes;
		resourceInfoPresenter.updateLikesCount(resourceLikes);
		collectionItemDo.getResource().setUserRating(userThumbsRataing);
		collectionItemDo.getRating().setVotesUp(resourceLikes);
	}
	
}
