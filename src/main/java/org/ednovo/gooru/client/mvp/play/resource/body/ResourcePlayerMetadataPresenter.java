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

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ReactionDo;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
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
	
	@Inject
	public ResourcePlayerMetadataPresenter(EventBus eventBus, IsResourcePlayerMetadataView view,QuestionResourcePresenter questionResourcePresenter,CollectionEndPresenter collectionEndPresenter) {
		super(eventBus, view);
		this.questionResourcePresenter=questionResourcePresenter;
		this.collectionEndPresenter=collectionEndPresenter;
		getView().setUiHandlers(this);
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

}
