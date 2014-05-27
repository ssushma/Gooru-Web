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
package org.ednovo.gooru.client.mvp.play.resource.body;


import java.util.ArrayList;

import org.apache.xpath.operations.Bool;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter;
import org.ednovo.gooru.client.mvp.rating.RatingAndReviewPopupPresenter;
import org.ednovo.gooru.client.mvp.rating.events.OpenReviewPopUpEvent;
import org.ednovo.gooru.client.mvp.rating.events.PostUserReviewEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataEvent;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ContentStarRatingsDo;
import org.ednovo.gooru.shared.model.content.ReactionDo;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourcePlayerMetadataPresenter extends PresenterWidget<IsResourcePlayerMetadataView> implements ResourcePlayerMetadataUiHandlers{
	
	private QuestionResourcePresenter questionResourcePresenter;
	
	private CollectionEndPresenter collectionEndPresenter;
	
	private CollectionPlayerPresenter collectionPlayerPresenter;
	
	private PreviewPlayerPresenter previewPlayerPresenter;
	
	private ResourcePlayerPresenter resourcePlayerPresenter;
	
	private boolean isCollectionPlayer=false;
	
	private boolean isResourcePlayer=false;
	
	private boolean isPreviewPlayer=false;
	
	private RatingAndReviewPopupPresenter ratingAndReviewPopup;

	private String resourceTitle = null;
	
	@Inject
	public ResourcePlayerMetadataPresenter(EventBus eventBus, IsResourcePlayerMetadataView view,QuestionResourcePresenter questionResourcePresenter,CollectionEndPresenter collectionEndPresenter,RatingAndReviewPopupPresenter ratingAndReviewPopup) {
		super(eventBus, view);
		this.questionResourcePresenter=questionResourcePresenter;
		this.collectionEndPresenter=collectionEndPresenter;
		this.ratingAndReviewPopup = ratingAndReviewPopup;
		getView().setUiHandlers(this);
		addRegisteredHandler(PostUserReviewEvent.TYPE, this);
		addRegisteredHandler(OpenReviewPopUpEvent.TYPE, this);
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo){
		getView().showResourceWidget(collectionItemDo);
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo,PlaceRequest nextResoruceRequest,PlaceRequest previousResourceRequest){
		getView().showResourceWidget(collectionItemDo,nextResoruceRequest,previousResourceRequest);
	}
	
	public void showResourceWidget(CollectionDo collectionDo,PlaceRequest previousResourceRequest){
		getView().showResourceWidget(previousResourceRequest);
		collectionEndPresenter.showCollectionEndPreview(collectionDo,collectionPlayerPresenter.getAttemptAnswersMap());
		getView().getResourceWidgetContainer().clear();
		getView().getResourceWidgetContainer().add(collectionEndPresenter.getWidget());
	}

	@Override
	public void showQuestionView(CollectionItemDo collectionItemDo) {
		questionResourcePresenter.setCollectionPlayer(isCollectionPlayer);
		questionResourcePresenter.setResourcePlayer(isResourcePlayer);
		questionResourcePresenter.setPreviewPlayer(isPreviewPlayer);
		questionResourcePresenter.setCollectionPlayerPresnter(collectionPlayerPresenter);
		questionResourcePresenter.setResourcePlayerPresenter(resourcePlayerPresenter);
		questionResourcePresenter.setPreviewPlayerPresenter(previewPlayerPresenter);
		questionResourcePresenter.showQuestionPreview(collectionItemDo);
		//removeUserAttemptResult();
		getView().getResourceWidgetContainer().add(questionResourcePresenter.getWidget());
	}
	
	public void setCollectionPlayerPresnter(CollectionPlayerPresenter collectionPlayerPresenter,boolean isCollectionPlayer){
		this.collectionPlayerPresenter=collectionPlayerPresenter;
		collectionEndPresenter.setCollectionPlayerPresenter(collectionPlayerPresenter);
		this.isCollectionPlayer=true;
		this.isResourcePlayer=false;
		this.isPreviewPlayer=false;
	}
	
	public void setPreviewPlayerPresenter(PreviewPlayerPresenter previewPlayerPresenter){
		this.previewPlayerPresenter=previewPlayerPresenter;
		this.isCollectionPlayer=false;
		this.isResourcePlayer=false;
		this.isPreviewPlayer=true;
	}
	
	public void setResourcePlayerPresenter(ResourcePlayerPresenter resourcePlayerPresenter,boolean isCollectionPlayer){
		this.resourcePlayerPresenter=resourcePlayerPresenter;
		this.isCollectionPlayer=false;
		this.isResourcePlayer=true;
		this.isPreviewPlayer=false;
	}
	
	public void removeUserAttemptResult(){
		if(isCollectionPlayer){
			collectionPlayerPresenter.removeUserAttemptResult();
		}else if(isResourcePlayer){
			resourcePlayerPresenter.removeUserAttemptResult();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.removeUserAttemptResult();
		}
	}
	
	public boolean isOeAnswerSubmited(){
		boolean isOeAnswerSubmited=true;
		if(isCollectionPlayer){
			isOeAnswerSubmited=collectionPlayerPresenter.isOpenEndedAnswerSubmited();
		}else if(isResourcePlayer){
			isOeAnswerSubmited=resourcePlayerPresenter.isOpenEndedAnswerSubmited();
		}else if(isPreviewPlayer){
			isOeAnswerSubmited=previewPlayerPresenter.isOpenEndedAnswerSubmited();
		}
		return isOeAnswerSubmited;
	}
	public void  triggerCreateReactionEvent(String resourceId,String reactionType,String eventName){
		Long startTime=System.currentTimeMillis();
		if(isCollectionPlayer){
			collectionPlayerPresenter.triggerReactiontDataLogEvent(resourceId, startTime, startTime, reactionType,eventName);
		}else if(isResourcePlayer){
			//resourcePlayerPresenter.removeUserAttemptResult();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.triggerReactiontDataLogEvent(resourceId, startTime, startTime, reactionType,eventName);
		}
	}
	public void resetResourceMetaData(){
		getView().getResourceWidgetContainer().clear();
	}
	public void removeRatingContainer(boolean flag){
		getView().removeRatingContainer(flag);
	}
	@Override
	public void createReaction(String resourceId,String reactionText,String gooruReactionId,String collectionId, String createStudyPlayerReaction) {
		AppClientFactory.getInjector().getPlayerAppService().createReaction(resourceId,reactionText,gooruReactionId,collectionId,createStudyPlayerReaction, new SimpleAsyncCallback<ReactionDo>() {
			@Override
			public void onSuccess(ReactionDo result) {
				getView().setReaction(result,result.getDeleteReactionGooruOid()); 
			}
		});
	}

	/**
	 * Get reaction API is called and gets respective reaction.
	 * @param collectionItemDo {@link CollectionItemDo}
	 */
	public void setReaction(CollectionItemDo collectionItemDo) { 
		AppClientFactory.getInjector().getPlayerAppService().getResourceReaction(collectionItemDo.getResource().getGooruOid(),AppClientFactory.getGooruUid(), new SimpleAsyncCallback<ArrayList<ReactionDo>>() {
			@Override
			public void onSuccess(ArrayList<ReactionDo> result) {
				String gooruReactionId="";
				if(result.size()==0){
					getView().setDefaultReaction();
				}else{
					for(int i =0;i<result.size();i++){
						gooruReactionId = gooruReactionId+result.get(i).getDeleteReactionGooruOid();
						if(result.size()!=(i+1)){
							gooruReactionId=gooruReactionId+",";
						}
					}
					getView().setReaction(result.get(0),gooruReactionId); 
				}
				
			}
		});
	}

	@Override
	public void deleteReaction(String gooruReactionId) {
		AppClientFactory.getInjector().getPlayerAppService().deleteReaction(gooruReactionId,new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
	
	public void updateFlagImageOnEndView(){
		collectionEndPresenter.updateFlagImageOnEndView();
	}
	
	public void clearIfrmaeContent(){
		try {
			Element ifrmaeElement = Document.get().getElementById("resourcePlayerContainer");
			if (ifrmaeElement != null) {
				ifrmaeElement.setAttribute("src", "");
			}
		} catch (Exception exception) {
		}
	}
	public void createSessionAttemptTryWhenNavigation(int questionType){
		questionResourcePresenter.createSessionAttemptTryWhenNavigation(questionType);
	}
	
	
	/**
	 * API call to create the ratings based on the user input and triggers the API.
	 * 
	 * @param associateGooruOid {@link String}
	 * @param starRatingValue {@link Integer}
	 * @param clickEvent {@link ClickEvent}
	 */
	@Override
	public void createStarRatings(String associateGooruOid, int starRatingValue, final boolean showThankYouToolTip,String userReview) {
		AppClientFactory.getInjector().getPlayerAppService().createStarRatings(associateGooruOid,starRatingValue,userReview,new SimpleAsyncCallback<StarRatingsDo>() {
			@Override
			public void onSuccess(StarRatingsDo result) { 
				getView().setUserStarRatings(result,showThankYouToolTip);
				getView().updateRatingOnSearch(result); 
			}
		});
	}

	/**
	 * API call to set Ratings for a resource.
	 * 
	 * @param collectionItemDo {@link CollectionItemDo}
	 */
	public void setResourceStarRatings(CollectionItemDo collectionItemDo) { 
		/*AppClientFactory.getInjector().getPlayerAppService().getResourceStarRatings(collectionItemDo.getResource().getGooruOid(),AppClientFactory.getGooruUid(),new SimpleAsyncCallback<StarRatingsDo>() {

			@Override
			public void onSuccess(StarRatingsDo result) {
				getView().setUserStarRatings(result,null);
			}
		});*/
		
		AppClientFactory.getInjector().getPlayerAppService().getResourceRatingWithReviews(collectionItemDo.getResource().getGooruOid(), AppClientFactory.getGooruUid(), new SimpleAsyncCallback<ArrayList<StarRatingsDo>>() {

			@Override
			public void onSuccess(ArrayList<StarRatingsDo> result) {
				if(result.size()>0){
					getView().setUserStarRatings(result.get(0),false); 
				}else{
					getView().setUserStarRatings(null,false); 
				}
				
			}
		});
	}

	/**
	 * Receiving event to post the review. 
	 */
	@Override
	public void postReview(String assocGooruOId, String userReview, Integer score,boolean isUpdate) {
		getView().postReview(assocGooruOId,userReview,score,isUpdate);	
	}

	/**
	 * API call to updats the Ratings for a resource.
	 * 
	 * @param gooruOid {@link String}
	 * @param starRatingValue {@link Integer}
	 * @param showThankYouToolTip {@link Boolean} 
	 */
	@Override
	public void updateStarRatings(String gooruOid, int starRatingValue,boolean showThankYouToolTip) {
		AppClientFactory.getInjector().getPlayerAppService().updateResourceStarRatings(gooruOid, starRatingValue, new SimpleAsyncCallback<ArrayList<StarRatingsDo>>(){

			@Override
			public void onSuccess(ArrayList<StarRatingsDo> result) {
				if(result.size()>0){
					getView().setUserStarRatings(result.get(0),true); 
				}
			}
		}); 
	}

	/**
	 * Updates the Reviews for a resource.
	 * 
	 * @param gooruOid {@link String}
	 * @param starRatingValue {@link Integer}
	 * @param showThankYouToolTip {@link Boolean} 
	 */
	@Override
	public void updateReview(String deleteRatingGooruOid, Integer score,String userReview) { 
		AppClientFactory.getInjector().getPlayerAppService().updateResourceStarReviews(deleteRatingGooruOid, score, userReview, new SimpleAsyncCallback<ArrayList<StarRatingsDo>>(){

			@Override
			public void onSuccess(ArrayList<StarRatingsDo> result) {
				if(result.size()>0){
					getView().hideThankYouPopUp();
				}
			}
		}); 
	}

	/**
	 * Receiving event to open review pop-up
	 * 
	 */
	@Override
	public void openReviewPopUp(String assocGooruOId) {
		addToPopupSlot(ratingAndReviewPopup);
		ratingAndReviewPopup.displayPopup(resourceTitle, assocGooruOId);
		ratingAndReviewPopup.getWidget().getElement().getStyle().setZIndex(999999);
	}

	/**
	 * API call to get a avg rating and total count.
	 * 
	 * @param assocGooruOid {@link String}
	 * @param score {@link Integer}
	 * @param review {@link String} 
	 */
	@Override
	public void getAvgRatingAndCount(final String assocGooruOid,final Integer score, final String review) {
		AppClientFactory.getInjector().getPlayerAppService().getContentStarRatings(assocGooruOid, new SimpleAsyncCallback<ContentStarRatingsDo>() {

			@Override
			public void onSuccess(ContentStarRatingsDo result) {
				getView().setRatingMetaData(assocGooruOid,score,review,result.getAverage(),result.getCount());
			}
		});
	}

	@Override
	public void setResourceMetaData(String resourceTitle) {
		this.resourceTitle = resourceTitle;
	}

}
