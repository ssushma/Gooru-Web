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
package org.ednovo.gooru.client.mvp.play.collection;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionPresenter;
import org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataPresenter;
import org.ednovo.gooru.client.mvp.play.collection.event.ShowCollectionTabWidgetEvent;
import org.ednovo.gooru.client.mvp.play.collection.event.ShowResourceViewEvent;
import org.ednovo.gooru.client.mvp.play.collection.event.UpdateCollectionViewCountEvent;
import org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter;
import org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter;
import org.ednovo.gooru.client.mvp.play.collection.toc.CollectionPlayerTocPresenter;
import org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionPresenter;
import org.ednovo.gooru.client.mvp.play.resource.body.ResourcePlayerMetadataPresenter;
import org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationPresenter;
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
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

public class CollectionPlayerPresenter extends BasePlacePresenter<IsCollectionPlayerView, CollectionPlayerPresenter.IsCollectionPlayerProxy> implements CollectionPlayerUiHandlers{
	
	@Inject
	private PlayerAppServiceAsync playerAppService;
	
    private SimpleAsyncCallback<CollectionDo> collectionDetailsAsync;
    
    private CollectionPlayerMetadataPresenter metadataPresenter;
    
    private ResourcePlayerMetadataPresenter resoruceMetadataPresenter;
    
    private CollectionPlayerTocPresenter collectionPlayerTocPresenter;
    
    private ResourceNarrationPresenter resourceNarrationPresenter;
    
    private CollectionFormInPlayPresenter collectionFormInPlayPresenter;
    
    private CollectionSharePresenter collectionSharePresenter;
    
    private ResourceInfoPresenter resourceInfoPresenter;
    
    private AddResourceCollectionPresenter addResourcePresenter;
    
    private AddCollectionPresenter addCollectionPresenter;
    
    private CollectionDo collectionDo=null;
    
    private CollectionItemDo collectionItemDo=null;
    
    private String collectionMetadataId=null;
    
    private String collectionSummaryId=null;
    
    private String collectionActivityEventId=null;
    
    private String resourceActivityEventId=null;
    
    private String resourceActivityResourceId=null;
    
    private String sessionId=null;
    
    private String sessionItemId=null;
    
    private String collectionDataLogEventId=null;
    
    private String resourceDataLogEventId;
    
    private Long collectionStartTime=0L;
    
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
     
    public static final  Object COLLECTION_PLAYER_TOC_PRESENTER_SLOT = new Object(); 
    
    public static final  Object METADATA_PRESENTER_SLOT = new Object();
    
    private static final String RESOURCE="resource";
    
    private static final String COLLECTION_RESOURCE_THUMBS_WIDGET_MODE="COLLECTION_RESOURCE_RATING";
    
    private static final String COLLECTION_RESOURCE_ADD_WIDGET="COLLECTION_RESOURCE_ADD";
    
    private static final String COLLECTION_RESOURCE_FLAG="collection_resource_flag";
	
	@Inject
	public CollectionPlayerPresenter(CollectionPlayerMetadataPresenter metadataPresenter,ResourcePlayerMetadataPresenter resoruceMetadataPresenter,
			CollectionPlayerTocPresenter collectionPlayerTocPresenter,CollectionSharePresenter collectionSharePresenter,
			ResourceInfoPresenter resourceInfoPresenter,ResourceNarrationPresenter resourceNarrationPresenter,
			EventBus eventBus,IsCollectionPlayerView view, IsCollectionPlayerProxy proxy, AddResourceCollectionPresenter addResourcePresenter,
     		AddCollectionPresenter addCollectionPresenter,CollectionFormInPlayPresenter collectionFormInPlayPresenter) {
		super(view, proxy);
		getView().setUiHandlers(this);
		this.metadataPresenter=metadataPresenter;
		this.resoruceMetadataPresenter=resoruceMetadataPresenter;
		this.collectionPlayerTocPresenter=collectionPlayerTocPresenter;
		this.resourceNarrationPresenter=resourceNarrationPresenter;
		this.collectionSharePresenter=collectionSharePresenter;
		this.resourceInfoPresenter=resourceInfoPresenter;
		this.addCollectionPresenter=addCollectionPresenter;
		this.addResourcePresenter=addResourcePresenter;
		this.collectionFormInPlayPresenter=collectionFormInPlayPresenter;
		resoruceMetadataPresenter.setCollectionPlayerPresnter(this,true);
		addResourcePresenter.getAddCollectionViewButton().addClickHandler(new showAddCollectionView());
		addCollectionPresenter.getAddResourceViewButton().addClickHandler(new showAddResourceView());
		addResourcePresenter.getAddNewCollectionButton().addClickHandler(new ShowNewCollectionWidget());
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.COLLECTION_PLAY_OLD)
	public interface IsCollectionPlayerProxy extends ProxyPlace<CollectionPlayerPresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealRootPopupContentEvent.fire(this, this);
	}
	
	@Override
	public void onBind() {
	  super.onBind();
	  addRegisteredHandler(ShowResourceViewEvent.TYPE, this);
	  addRegisteredHandler(UpdateCollectionViewCountEvent.TYPE, this);
	  addRegisteredHandler(ShowCollectionTabWidgetEvent.TYPE, this);
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
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
	  super.prepareFromRequest(request);
	  getCollectionDetails();
	}
	
	public void getCollectionDetails(){
		final String collectionId=getPlaceManager().getRequestParameter("id", null);
		  final String resourceId=getPlaceManager().getRequestParameter("rid", null);
		  final String tabView=getPlaceManager().getRequestParameter("tab", null);
		  final String apiKey=getPlaceManager().getRequestParameter("key", null);
		  final String view=getPlaceManager().getRequestParameter("view", null);
		  if(this.collectionDo!=null){
			  if(resourceId!=null&&!resourceId.equals("")){
				  showResourceView(resourceId,tabView);
				  showTabWidget(tabView,collectionId,resourceId,false,false);
			  }
			  else if(collectionId!=null && !collectionId.equalsIgnoreCase("")){
				  if(view!=null&&view.equalsIgnoreCase("end")){
					  showCollectionEndView(collectionId, tabView);
					  showTabWidget(tabView,collectionId,resourceId,false,true);
				  }else{
					  showCollectionMetadataView(tabView);
					  showTabWidget(tabView,collectionId,resourceId,true,false);
				  }
			  }
		  }else{
			 // if(apiKey!=null && !apiKey.equalsIgnoreCase("")){
			      if(collectionId!=null && !collectionId.equalsIgnoreCase("")){
			    	  this.playerAppService.getSimpleCollectionDetils(apiKey,collectionId,resourceId,tabView, new SimpleAsyncCallback<CollectionDo>() {
			    			@Override
			    			public void onSuccess(CollectionDo collectionDo) {
			    				  showCollectionView(collectionDo,collectionId,resourceId,tabView);
			    			}
			    		});
			      }
			 // }
//			  else{
//				  //TODO need to implemente error message if API key is missing or invalid.
//				  Window.alert("API KEY IS MISSING");
//			  }
		  }
	}
	
	public void showCollectionView(CollectionDo collectionDo,String collectionId,String resourceId, String tabView){
		  this.collectionDo=collectionDo;
		  if(collectionId==null || collectionId.equalsIgnoreCase("")){
			  return;
		  }
		  else{
			  if(resourceId==null || resourceId.equalsIgnoreCase("")){
				  String view=getPlaceManager().getRequestParameter("view", null);
				  if(view!=null&&view.equalsIgnoreCase("end")){
					  showCollectionEndView(collectionId, tabView);
					  showTabWidget(tabView,collectionId,resourceId,false,true);
				  }else{
					 showCollectionMetadataView(tabView);
					 showTabWidget(tabView,collectionId,resourceId,true,false);
				 }
			  }else{
				  showResourceView(resourceId,tabView);
				  showTabWidget(tabView,collectionId,resourceId,false,false);
			  }
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
	protected void setCollectionDetails(CollectionDo collectionDo){
		if(collectionDo!=null){
			getView().setResourceTitle(collectionDo.getTitle());
		}
	}
	public void showCollectionMetadataView(String tabView){
		this.collectionItemDo=null;
		this.collectionSummaryId=null;
		setCollectionDetails(collectionDo);
		metadataPresenter.setCollectionMetadata(collectionDo);
		if(this.collectionMetadataId!=null){
			if(this.collectionMetadataId.equalsIgnoreCase(collectionDo.getGooruOid())){
				makeButtonActive(tabView);
				return;
			}
		}
		this.collectionMetadataId=collectionDo.getGooruOid();
		getProfilUserVisibility(collectionDo.getUser().getGooruUId());
		enablePlayerButton(true,false, true, false, true);
		getView().resetThumbsButtons();
		getView().updateThumbsRatingView(collectionDo.getUserRating());
		makeButtonActive(tabView);
		stopResourceDataLog();
		resetAnswerLists();
		setInSlot(METADATA_PRESENTER_SLOT, metadataPresenter,false);
	}
	public void showResourceView(String collectionItemId,String tabView) {
		CollectionItemDo collectionItemDo=getCollectionItemDo(collectionItemId);
		this.collectionMetadataId=null;
		this.collectionSummaryId=null;
		if(this.collectionItemDo!=null){
			if(this.collectionItemDo.getCollectionItemId().equalsIgnoreCase(collectionItemDo.getCollectionItemId())){
				makeButtonActive(tabView);
				return;
			}
		}
		//TODO need to check is collection sharable or not, need to enable narration button if narration exist.
		
		if(tabView!=null&&tabView.equals("narration")){
			enablePlayerButton(true,true, true, true, true);
			makeButtonActive(tabView);
		}else{
			enablePlayerButton(true,true, true, false, true);
			makeButtonActive(tabView);
		}
		this.collectionItemDo=collectionItemDo;
		clearSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT);
		updateResourceViewCount(collectionItemDo.getResource().getGooruOid(),collectionItemDo.getViews().toString(),RESOURCE,collectionItemId);
		createPlayerDataLogs();
		PlaceRequest nextResoruceRequest=getNextButtonRequestUrl(collectionItemId);
		PlaceRequest previousResoruceRequest=getPreviousButtonRequestUrl(collectionItemId);
		getView().setResourceTitle(collectionItemDo.getResource().getTitle());
		getView().resetThumbsButtons();
		getView().updateThumbsRatingView(collectionItemDo.getResource().getUserRating());
		resoruceMetadataPresenter.showResourceWidget(collectionItemDo,nextResoruceRequest,previousResoruceRequest);
		setInSlot(METADATA_PRESENTER_SLOT, resoruceMetadataPresenter);
	}
	public void showCollectionEndView(String collectionId,String tabView) {
		this.collectionMetadataId=null;
		this.collectionItemDo=null;
		if(this.collectionSummaryId!=null){
			if(this.collectionSummaryId.equalsIgnoreCase(collectionDo.getGooruOid())){
				makeButtonActive(tabView);
				return;
			}
		}
		//TODO need to check is collection sharable or not, need to enable narration button if narration exist.
		enablePlayerButton(true,false, true, false, true);
		this.collectionSummaryId=collectionDo.getGooruOid();
		makeButtonActive(tabView);
		clearSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT);
		PlaceRequest previousResoruceRequest=getPreviousButtonRequestUrl();
		getView().setResourceTitle(collectionDo.getTitle());
		getView().resetThumbsButtons();
		getView().updateThumbsRatingView(collectionDo.getUserRating());
		resoruceMetadataPresenter.showResourceWidget(collectionDo,previousResoruceRequest);
		stopResourceDataLog();
		resetAnswerLists();
		stopCollectionDataLog();
		updateSession(sessionId);
		setInSlot(METADATA_PRESENTER_SLOT, resoruceMetadataPresenter);
	}
	public void makeButtonActive(String tabView){
		if(tabView!=null){
			//getView().clearActiveButtion();
			if(tabView.equalsIgnoreCase("add")){
				getView().clearActiveButton(false,true, true, true, true);
				getView().makeButtonActive(true, false,false, false, false);	
			}
			else if(tabView.equalsIgnoreCase("info")){
				getView().clearActiveButton(true,false, true, true, true);
				getView().makeButtonActive(false,true, false, false, false);	
			}
			else if(tabView.equalsIgnoreCase("share")){
				getView().clearActiveButton(true,true, false, true, true);
				getView().makeButtonActive(false,false, true, false, false);
			}
			else if(tabView.equalsIgnoreCase("narration")){
				getView().clearActiveButton(true,true, true, false, true);
				getView().makeButtonActive(false,false, false, true, false);
			}
			else if(tabView.equalsIgnoreCase("navigation")){
				getView().clearActiveButton(true,true, true, true, false);
				getView().makeButtonActive(false,false, false, false, true);
			}
		}
	}
	@Override
	public void showResourceView(Integer collectionItemSequence, boolean isForwardDirection) {
		//getCollectionItemDo(collectionItemSequence,isForwardDirection);
	}
	
	public void showTabWidget(String tabView,String collectionId,String resourceId,boolean isCollectionHome,boolean isCollectionEnd){
		if(tabView==null||tabView.equals("")){
			clearTabSlot();
		}
		else if(tabView.equals("add")){
			if(AppClientFactory.isAnonymous()){
				showLoginPopupWidget(COLLECTION_RESOURCE_ADD_WIDGET);
			}else{
				 if(isCollectionHome||isCollectionEnd){
					 addCollectionPresenter.getAddResourceViewButton().setVisible(false);
					 setAddCollectionView(collectionId);
				 }else{
					 addCollectionPresenter.getAddResourceViewButton().setVisible(true);
					 setAddResourcesView(collectionId, resourceId);
				 }
			}
		 }
		else if(tabView.equals("navigation")){
			 setNavigationResourcesView(collectionId,resourceId,isCollectionHome);
		 }else if(tabView.equals("share")){
			 setCollectionShareView(collectionId,resourceId);
		 }else if(tabView.equals("narration")){
			setNarrationView(resourceId);
		 }else if(tabView.equals("info")){
			 setResourceInfoView(resourceId);
		 }
		 else{
			 getView().getNavigationContainer().clear();
		 }
	}
	public class showAddResourceView implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			final String collectionId=getPlaceManager().getRequestParameter("id", null);
			  final String resourceId=getPlaceManager().getRequestParameter("rid", null);
			setAddResourcesView(collectionId,resourceId);
		}
	}
	public class showAddCollectionView implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			final String collectionId=getPlaceManager().getRequestParameter("id", null);
			setAddCollectionView(collectionId);
		}
	}
	public CollectionItemDo getCollectionItemDo(String collectionItemId){
		if(collectionItemId!=null&&!collectionItemId.equalsIgnoreCase("")&&collectionDo!=null&&collectionDo.getGooruOid()!=null){
			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
				if(collectionItemId.equalsIgnoreCase(collectionItemDo.getCollectionItemId())){
					return collectionItemDo;
				}
			}
		}
		return null;	
	}
	
	public void updatCollectionViewsCount(){
		if(collectionDo!=null&&collectionDo.getGooruOid()!=null){
			String viewsCount=collectionDo.getViews();
			Integer viewsCounts=Integer.parseInt(viewsCount)+1;
			collectionDo.setViews(viewsCounts.toString());
			metadataPresenter.setViewCount(viewsCounts.toString());
		}
	}
	public void updateViewCount(String collectionItemId){
		if(collectionItemId!=null&&!collectionItemId.equalsIgnoreCase("")&&collectionDo!=null&&collectionDo.getGooruOid()!=null){
			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
				if(collectionItemId.equalsIgnoreCase(collectionItemDo.getCollectionItemId())){
					String viewsCount=collectionItemDo.getResource().getViews();
					Integer viewsCounts=Integer.parseInt(viewsCount)+1;
					collectionItemDo.getResource().setViews(viewsCounts.toString());
					resourceInfoPresenter.updateViewsCount(viewsCounts.toString());
					return;
				}
			}
		}
	}
	public PlaceRequest getNextButtonRequestUrl(String collectionItemId){
		if(collectionItemId!=null&&!collectionItemId.equalsIgnoreCase("")&&collectionDo!=null&&collectionDo.getGooruOid()!=null){
			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
				if(collectionItemId.equalsIgnoreCase(collectionItemDo.getCollectionItemId())){
					if(collectionDo.getCollectionItems().size()==(i+1)){
						PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid()).with("view", "end");
						return request;
					}else{
						collectionItemDo=collectionDo.getCollectionItems().get(i+1);
						return getResourcePlaceRequest(collectionItemDo);
					}
				}
			}
		}
		return null;
	}
	public PlaceRequest getPreviousButtonRequestUrl(){
		if(collectionDo!=null&&collectionDo.getGooruOid()!=null){
			if(collectionDo.getCollectionItems().size()>0){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(collectionDo.getCollectionItems().size()-1);
				return getResourcePlaceRequest(collectionItemDo);		
			}else{
				PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid());
				return request;
			}
		}
		return null;
	}
	public PlaceRequest getPreviousButtonRequestUrl(String collectionItemId){
		if(collectionItemId!=null&&!collectionItemId.equalsIgnoreCase("")&&collectionDo!=null&&collectionDo.getGooruOid()!=null){
			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
				if(collectionItemId.equalsIgnoreCase(collectionItemDo.getCollectionItemId())){
					if(i==0){
						PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid());
						return request;
					}else{
						collectionItemDo=collectionDo.getCollectionItems().get(i-1);
						return getResourcePlaceRequest(collectionItemDo);
					}
				}
			}
		}
		return null;
	}
	public void revealResourceView(CollectionItemDo collectionItemDo){
		if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
			PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid())
					.with("rid", collectionItemDo.getCollectionItemId())
					.with("tab", "narration");
			AppClientFactory.getPlaceManager().revealPlace(false,request);
		}else{
			PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid()).with("rid", collectionItemDo.getCollectionItemId());
			AppClientFactory.getPlaceManager().revealPlace(false,request);
		}
	}
	
	public PlaceRequest getResourcePlaceRequest(CollectionItemDo collectionItemDo){
		if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
			PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
			with("id", collectionDo.getGooruOid()).with("rid", collectionItemDo.getCollectionItemId())
					.with("tab", "narration");
			return request;
		}else{
			PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid()).with("rid", collectionItemDo.getCollectionItemId());
			return request;
		}
		
	}
	
	public void setAddResourcesView(String collectionId,String resourceId){	
		addResourcePresenter.setCollectionItemData(collectionId, getCollectionItemDo(resourceId));
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, addResourcePresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);		
	}
	public void setAddCollectionView(String collectionId){
		addCollectionPresenter.setCollectionDo(collectionDo);
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, addCollectionPresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);		
	}
	
	public void setNavigationResourcesView(String collectionId,String resourceId,boolean isCollectionHome){		
		collectionPlayerTocPresenter.setNavigationResources(collectionDo);
		collectionPlayerTocPresenter.setResourceActive(collectionId, resourceId, isCollectionHome);
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, collectionPlayerTocPresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
		
	}
	public void setNarrationView(String resourceId){
		CollectionItemDo collectionItemDo=getCollectionItemDo(resourceId);
		resourceNarrationPresenter.setNarrationMetadata(collectionItemDo);
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, resourceNarrationPresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
	}
	public void setResourceInfoView(String resourceId){
		CollectionItemDo collectionItemDo=getCollectionItemDo(resourceId);
		resourceInfoPresenter.setResoruceDetails(collectionItemDo);
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, resourceInfoPresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
	}
	public void setCollectionShareView(String collectionId,String resourceId){
		
		if(resourceId!=null&&!resourceId.equalsIgnoreCase("")){
			CollectionItemDo collectionItemDo=getCollectionItemDo(resourceId);
			collectionSharePresenter.setResourceShareData(collectionItemDo.getResource().getGooruOid());
		}
		collectionSharePresenter.showShareView(resourceId!=null&&!resourceId.equalsIgnoreCase("")?true:false);
		collectionSharePresenter.setCollectionShareData(collectionDo);
		setInSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT, collectionSharePresenter,false);
		new CustomAnimation(getView().getNavigationContainer()).run(400);
	}
	
	public void clearTabSlot(){
		clearSlot(COLLECTION_PLAYER_TOC_PRESENTER_SLOT);
	}
	
	public void enablePlayerButton(boolean isAddButtonEnable,boolean isInfoButtonEnable, boolean isShareButtonEnable, boolean isNarrationButtonEnable, boolean isNavigationButtonEnable){
		getView().enablePlayerButton(isAddButtonEnable,isInfoButtonEnable, isShareButtonEnable, isNarrationButtonEnable, isNavigationButtonEnable);
	}
	

	@Override
	public void updateViewsCount() {
		updateResourceViewCount(collectionDo.getGooruOid(),collectionDo.getViews(),RESOURCE);
	}
	
	public void createPlayerDataLogs(){
		if(collectionActivityEventId!=null&&!collectionActivityEventId.isEmpty()){
			stopResourceDataLog();
			resetAnswerLists();
			createResourceDataLog();
			createSessionItem();
		}else{
			if(collectionDo!=null){
				collectionActivityEventId=GwtUUIDGenerator.uuid();
				collectionDataLogEventId=GwtUUIDGenerator.uuid();
				collectionStartTime=System.currentTimeMillis();
				PlayerDataLogEvents.collectionPlayStartEvent(collectionDataLogEventId, PlayerDataLogEvents.COLLECTION_PLAY_EVENT_NAME, "", PlayerDataLogEvents.OPEN_SESSION_STATUS, collectionDo.getGooruOid(), 
				    		PlayerDataLogEvents.START_EVENT_TYPE, collectionStartTime, collectionStartTime, 0L, AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid());
				startPlayerActivityEvent(collectionActivityEventId, "", PlayerConstants.COLLECTION_EVENT_NAME, collectionDo.getGooruOid(), collectionDo.getGooruOid(), PlayerConstants.COLLECTION_CONTEXT+collectionDo.getGooruOid(), getUserAgent());
				createSession(collectionDo.getGooruOid());
				createResourceDataLog();
			}	
		}
	}
	
	public void createResourceDataLog(){
		resourceActivityEventId=GwtUUIDGenerator.uuid();
		resourceActivityResourceId=collectionItemDo.getResource().getGooruOid();
		String resourceContext=PlayerConstants.COLLECTION_CONTEXT+collectionDo.getGooruOid()+"/"+resourceActivityResourceId;
		startPlayerActivityEvent(resourceActivityEventId, collectionActivityEventId, PlayerConstants.RESOURCE_EVENT_NAME, collectionDo.getGooruOid(), resourceActivityResourceId, resourceContext, getUserAgent());
		startResourceInsightDataLog();
	}
	
	public void stopResourceDataLog(){
		if(resourceActivityResourceId!=null){
			String resourceContext=PlayerConstants.COLLECTION_CONTEXT+collectionDo.getGooruOid()+"/"+resourceActivityResourceId;
			stopPlayerActivityEvent(resourceActivityEventId, collectionActivityEventId, PlayerConstants.RESOURCE_EVENT_NAME, collectionDo.getGooruOid(), resourceActivityResourceId, resourceContext, getUserAgent());
			stopResourceInsightDataLog();
			resourceActivityResourceId=null;
		}
	}
	
	public void stopCollectionDataLog(){
		if(collectionActivityEventId!=null){
			stopPlayerActivityEvent(collectionActivityEventId, "", PlayerConstants.COLLECTION_EVENT_NAME, collectionDo.getGooruOid(), collectionDo.getGooruOid(), PlayerConstants.COLLECTION_CONTEXT+collectionDo.getGooruOid(), getUserAgent());
			Long collectionEndTime=System.currentTimeMillis();
			PlayerDataLogEvents.collectionPlayStartEvent(collectionDataLogEventId, PlayerDataLogEvents.COLLECTION_PLAY_EVENT_NAME, "", PlayerDataLogEvents.OPEN_SESSION_STATUS, collectionDo.getGooruOid(), 
		    		PlayerDataLogEvents.STOP_EVENT_TYPE, collectionStartTime, collectionEndTime, collectionEndTime-collectionStartTime, AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid());
		}
	}
	
	public void startResourceInsightDataLog(){
		resourceDataLogEventId=GwtUUIDGenerator.uuid();
		resourceStartTime=System.currentTimeMillis();
		if(collectionItemDo!=null){
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					resourcePlayEventName=PlayerDataLogEvents.COLLECTION_RESOURCE_OE_EVENT_NAME;
				}else{
					resourcePlayEventName=PlayerDataLogEvents.COLLECTION_RESOUCE_PLAY_EVENT_NAME;
				}
			}else{
				resourcePlayEventName=PlayerDataLogEvents.COLLECTION_RESOUCE_PLAY_EVENT_NAME;
			}
		}
		PlayerDataLogEvents.resourcePlayStartStopEvent(resourceDataLogEventId, resourcePlayEventName, collectionDataLogEventId,resourceActivityResourceId,collectionDo.getGooruOid(), PlayerDataLogEvents.START_EVENT_TYPE, resourceStartTime,
	                 resourceStartTime, 0L,AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length());
	}
	
	public void stopResourceInsightDataLog(){
		stopHintOrExplanationEvent();
		Long resourceEndTime=System.currentTimeMillis();
		PlayerDataLogEvents.resourcePlayStartStopEvent(resourceDataLogEventId, resourcePlayEventName, collectionDataLogEventId,resourceActivityResourceId,collectionDo.getGooruOid(), PlayerDataLogEvents.STOP_EVENT_TYPE, resourceStartTime,
				resourceEndTime,resourceEndTime-resourceStartTime,AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length());
	}
	
	public void createSessionItem(){
		if(collectionItemDo!=null){
			createSessionItem(sessionId, collectionItemDo.getCollectionItemId(), collectionItemDo.getResource().getGooruOid());
		}
	}
	
	public void updateResourceViewCount(String gooruId,String viewsCount,String resourceType){
		this.playerAppService.updateViewCount(gooruId, viewsCount, resourceType, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				updatCollectionViewsCount();
			}
		});
	}
	public void updateResourceViewCount(String gooruId,String viewsCount,String resourceType,final String collectionItemId){
		this.playerAppService.updateViewCount(gooruId, viewsCount, resourceType, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
					updateViewCount(collectionItemId);
			}
		});
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
				CollectionPlayerPresenter.this.sessionId=sessionId;
				if(collectionItemDo!=null){
					createSessionItem(sessionId, collectionItemDo.getCollectionItemId(), collectionItemDo.getResource().getGooruOid());
				}
			}
		});
	}
	
	public void createSessionItem(String sessionTrackerId,String collectionItemId, String resourceGooruOid){
		this.playerAppService.createSessionItemInCollection(sessionTrackerId, collectionItemId, resourceGooruOid, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String sessionItemId) {
				CollectionPlayerPresenter.this.sessionItemId=sessionItemId;
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
					hintOrExplanationEventName=PlayerDataLogEvents.COLLECTION_RESOURCE_OE_HINT_EVENT_NAME;
				}else{
					hintOrExplanationEventName=PlayerDataLogEvents.COLLECTION_RESOURCE_HINT_EVENT_NAME;
				}
			}
		}
		PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, hintOrExplanationEventName, resourceDataLogEventId, resourceActivityResourceId,
				collectionDo.getGooruOid(), PlayerDataLogEvents.START_EVENT_TYPE, hintOrExplanationStartTime, hintOrExplanationStartTime, 0L, AppClientFactory.getLoginSessionToken(),
				AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
	}
	
	public void startExplanationDataLogEvent(){
		stopHintOrExplanationEvent();
		isExplanationUsed=true;
		hintOrExplanationEventId=GwtUUIDGenerator.uuid();
		if(collectionItemDo!=null){
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					hintOrExplanationEventName=PlayerDataLogEvents.COLLECTION_RESOURCE_OE_EXPLANATION_EVENT_NAME;
				}else{
					hintOrExplanationEventName=PlayerDataLogEvents.COLLECTION_RESOURCE_EXPLANATION_EVENT_NAME;
				}
			}
		}
		PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, hintOrExplanationEventName, resourceDataLogEventId, resourceActivityResourceId, 
				collectionDo.getGooruOid(), PlayerDataLogEvents.START_EVENT_TYPE, hintOrExplanationStartTime,hintOrExplanationStartTime, 0L, AppClientFactory.getLoginSessionToken(),
				AppClientFactory.getGooruUid(), isExplanationUsed,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
	}
	
	public void saveOeQuestionAnswerDataLogEvent(){
		stopHintOrExplanationEvent();
		hintOrExplanationEventName=null;
		String submitEventId=GwtUUIDGenerator.uuid();
		Long answerEndTime=System.currentTimeMillis();
		PlayerDataLogEvents.submitOeAnswerDataLogEvent(submitEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_OE_SUBMIT_EVENT_NAME, resourceDataLogEventId,
				 resourceActivityResourceId,resourceStartTime,answerEndTime, answerEndTime-resourceStartTime,
				 AppClientFactory.getLoginSessionToken(), AppClientFactory.getGooruUid(),attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),collectionDo.getGooruOid());
	}
	
	public void stopHintOrExplanationEvent(){
		if(hintOrExplanationEventName!=null){
			Long endTime=System.currentTimeMillis();
			Long spendTime=endTime-hintOrExplanationStartTime;
			if(hintOrExplanationEventName.equals(PlayerDataLogEvents.COLLECTION_RESOURCE_EXPLANATION_EVENT_NAME)){
				PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_EXPLANATION_EVENT_NAME, resourceDataLogEventId, resourceActivityResourceId, 
	    				collectionDo.getGooruOid(), PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime,endTime, spendTime, AppClientFactory.getLoginSessionToken(),
	    				AppClientFactory.getGooruUid(), true,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
			}else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.COLLECTION_RESOURCE_HINT_EVENT_NAME)){
				PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_HINT_EVENT_NAME, resourceDataLogEventId, resourceActivityResourceId,
						collectionDo.getGooruOid(), PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime, endTime, spendTime,  AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
			}
			else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.COLLECTION_RESOURCE_OE_EXPLANATION_EVENT_NAME)){
				PlayerDataLogEvents.explanationButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_OE_EXPLANATION_EVENT_NAME, resourceDataLogEventId, resourceActivityResourceId, 
						collectionDo.getGooruOid(), PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime,endTime, spendTime, AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), true,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),hintId);
			}else if(hintOrExplanationEventName.equals(PlayerDataLogEvents.COLLECTION_RESOURCE_OE_HINT_EVENT_NAME)){
				PlayerDataLogEvents.hintsButtonDataLogEvent(hintOrExplanationEventId, PlayerDataLogEvents.COLLECTION_RESOURCE_OE_HINT_EVENT_NAME, resourceDataLogEventId, resourceActivityResourceId,
						collectionDo.getGooruOid(), PlayerDataLogEvents.STOP_EVENT_TYPE, hintOrExplanationStartTime, endTime, spendTime, AppClientFactory.getLoginSessionToken(),
						AppClientFactory.getGooruUid(), 0, hintId,attemptTrySequence,attemptStatus, answerIds,oeQuestionAnswerText,oeQuestionAnswerText.length(),isExplanationUsed);
			}
		}
	}
	
	public void getProfilUserVisibility(final String gooruUid){
		this.playerAppService.getUserProfileVisibility(gooruUid, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				if(result){
					metadataPresenter.setUserProfileName(gooruUid);
				}
			}
		});
	}
	
	@Override
	public String getViewToken() {
		return PlaceTokens.COLLECTION_PLAY;
	}


	@Override
	public void showLoginPopupWidget(String widgetMode){
		LoginPopupUc popup =new LoginPopupUc();
		popup.setWidgetMode(widgetMode);
		popup.setGlassEnabled(true);
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
		addResourcePresenter.updateWorkSpaceLink(collectionId);
	}
	
	@Override
	public void refreshCollectionInShelfListInPlay(String collectionId) {
		updateAddResourceCollectionWidget(collectionId);
	}
	
	@Override
	public void updateResourceThumbsRating(final int userThumbsRataing) {
		String resourceGooruOid=getPlaceManager().getRequestParameter("rid", null);
		if(resourceGooruOid!=null){
		 CollectionItemDo colectionItemDo=getCollectionItemDo(resourceGooruOid);
		 resourceGooruOid=colectionItemDo.getResource().getGooruOid();
		}else{
			resourceGooruOid=getPlaceManager().getRequestParameter("id", null);
		}
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
		String resourceGooruOid=getPlaceManager().getRequestParameter("rid", null);
		if(resourceGooruOid!=null){
		 CollectionItemDo collectionItemDo=getCollectionItemDo(resourceGooruOid);
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
		}else{
			resourceGooruOid=getPlaceManager().getRequestParameter("id", null);
			 int resourceLikes=collectionDo.getMetaInfo().getRating().getVotesUp();
			 int userRating=collectionDo.getUserRating();
			if(userThumbsRataing==1){
				resourceLikes=resourceLikes+1;
			}else if((userThumbsRataing==0||userThumbsRataing==-1)&&userRating==1){
				resourceLikes=resourceLikes-1;
			}
			resourceLikes=resourceLikes<0?0:resourceLikes;
			metadataPresenter.updateLikesCount(resourceLikes);
			collectionDo.setUserRating(userThumbsRataing);
			collectionDo.getMetaInfo().getRating().setVotesUp(resourceLikes);
		}		
	}
	
	@Override
	public void showTabWidget(String widgetMode,boolean isLoginRequestCancel) {
		if(!isLoginRequestCancel&&widgetMode.equalsIgnoreCase(COLLECTION_RESOURCE_THUMBS_WIDGET_MODE)){
			getCollection();
		}
	}
	
	public void getCollection(){
		String collectionId=getPlaceManager().getRequestParameter("id", null);
		 this.playerAppService.getSimpleCollectionDetils(null,collectionId,null,null, new SimpleAsyncCallback<CollectionDo>() {
 			@Override
 			public void onSuccess(CollectionDo collectionDo) {
 				CollectionPlayerPresenter.this.collectionDo=collectionDo;
 				updateThumbsRatingView(collectionDo.getUserRating());
 			}
 		});
	}
	
	public void resetCollectionPlayer(){
		collectionItemDo=null;
	    collectionMetadataId=null;
	    collectionSummaryId=null;
	    collectionActivityEventId=null;
	    resourceActivityEventId=null;
	    resourceActivityResourceId=null;
	    sessionId=null;
	    sessionItemId=null;
	    collectionDataLogEventId=null;
	    resourceDataLogEventId=null;
	    collectionStartTime=0L;
	    resourceStartTime=0L;
	    hintOrExplanationStartTime=0L;
	    hintOrExplanationEventName=null;
	    hintOrExplanationEventId=null;
	    resourcePlayEventName=null;
	    attemptAnswersMap.clear();
	    attemptTrySequence.clear();
	    attemptStatus.clear();
	    answerIds.clear();
	    oeQuestionAnswerText="";
		hintId=0;
		isExplanationUsed=false;
		getView().setResourceTitle("");
		enablePlayerButton(false, false, false, false, false);
		getView().resetThumbsButtons();
		clearTabSlot();
		clearSlot(METADATA_PRESENTER_SLOT);
		resoruceMetadataPresenter.resetResourceMetaData();
		resourceInfoPresenter.resetResourceInfo();
		
	}
}
