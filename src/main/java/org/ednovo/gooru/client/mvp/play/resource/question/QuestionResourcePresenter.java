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
package org.ednovo.gooru.client.mvp.play.resource.question;

import java.util.List;

import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.json.client.JSONNumber;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class QuestionResourcePresenter extends PresenterWidget<IsQuestionResourceView> implements QuestionResourceUiHandlers{
	private CollectionPlayerPresenter collectionPlayerPresenter=null;
	
	private ResourcePlayerPresenter resourcePlayerPresenter=null;
	
	private PreviewPlayerPresenter previewPlayerPresenter=null;
	
	private boolean isCollectionPlayer=false;
	
	private boolean isResourcePlayer=false;
	
	private boolean isPreviewPlayer=false;
	
	@Inject
	public QuestionResourcePresenter(EventBus eventBus, IsQuestionResourceView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	public void showQuestionPreview(CollectionItemDo collectionItemDo){
		getView().resetQuestionView();
		getView().showQuestionPreview(collectionItemDo,getUserAttemptedResult(collectionItemDo.getCollectionItemId()));
	}
	
	public void setCollectionPlayerPresnter(CollectionPlayerPresenter collectionPlayerPresenter){
		this.collectionPlayerPresenter=collectionPlayerPresenter;
	}
	
	public void setResourcePlayerPresenter(ResourcePlayerPresenter resourcePlayerPresenter){
		this.resourcePlayerPresenter=resourcePlayerPresenter;
	}
	
	public AttemptedAnswersDo getUserAttemptedResult(String collectionItemId) {
		if(isCollectionPlayer){
			return collectionPlayerPresenter.getAttemptAnswersMap().get(collectionItemId);
		}else if(isResourcePlayer){
			return resourcePlayerPresenter.getAttemptAnswersMap().get(collectionItemId);
		}else if(isPreviewPlayer){
			return previewPlayerPresenter.getAttemptAnswersMap().get(collectionItemId);
		}else{
			return null;
		}	
	}

	@Override
	public void createSessionItemAttempt(int answerId,String answerAttemptStatus) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.createSessionItemAttempt(answerId, answerAttemptStatus);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.createSessionItemAttempt(answerId, answerAttemptStatus);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.createSessionItemAttempt(answerId, answerAttemptStatus);
		}	
	}

	@Override
	public void createSesstionItemAttemptOe(String answerId,String attemptStatus,String answerText) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.createSessionItemAttemptOe(answerId ,attemptStatus,answerText);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.createSessionItemAttemptOe(answerId, attemptStatus,answerText);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.createSessionItemAttemptOe(answerId ,attemptStatus,answerText);
		}		
	}
	
	@Override
	public void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setUserAttemptResult(collectionItemId, attemptAnswerDo);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.setUserAttemptResult(collectionItemId, attemptAnswerDo);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.setUserAttemptResult(collectionItemId, attemptAnswerDo);
		}		
	}

	@Override
	public void setAnswerAttemptSequence(int attemptSequence,
			int attemptStatus, int answerId) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}		
	}

	@Override
	public void setOeQuestionAnswerText(String answerText) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setOeQuestionAnswerText(answerText);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.setOeQuestionAnswerText(answerText);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.setOeQuestionAnswerText(answerText);
		}		
	}

	@Override
	public void startHintDataLogEvent(int hintId) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.startHintDataLogEvent(hintId);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.startHintDataLogEvent(hintId);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.startHintDataLogEvent(hintId);
		}		
	}

	@Override
	public void startExplanationDataLogEvent() {
		if(isCollectionPlayer){
			collectionPlayerPresenter.startExplanationDataLogEvent();
		}else if(isResourcePlayer){
			resourcePlayerPresenter.startExplanationDataLogEvent();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.startExplanationDataLogEvent();
		}		
	}

	@Override
	public void saveOeQuestionAnswerDataLogEvent() {
		if(isCollectionPlayer){
			collectionPlayerPresenter.saveOeQuestionAnswerDataLogEvent();
		}else if(isResourcePlayer){
			resourcePlayerPresenter.saveOeQuestionAnswerDataLogEvent();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.saveOeQuestionAnswerDataLogEvent();
		}		
	}
	
	public void increaseUserAttemptCount(){
		if(isCollectionPlayer){
			collectionPlayerPresenter.increaseUserAttemptCount();
		}else if(isResourcePlayer){
			resourcePlayerPresenter.increaseUserAttemptCount();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.increaseUserAttemptCount();
		}		
	}

	public boolean isCollectionPlayer() {
		return isCollectionPlayer;
	}

	public void setCollectionPlayer(boolean isCollectionPlayer) {
		this.isCollectionPlayer = isCollectionPlayer;
	}

	public boolean isResourcePlayer() {
		return isResourcePlayer;
	}

	public void setResourcePlayer(boolean isResourcePlayer) {
		this.isResourcePlayer = isResourcePlayer;
	}

	public boolean isPreviewPlayer() {
		return isPreviewPlayer;
	}

	public void setPreviewPlayer(boolean isPreviewPlayer) {
		this.isPreviewPlayer = isPreviewPlayer;
	}

	public PreviewPlayerPresenter getPreviewPlayerPresenter() {
		return previewPlayerPresenter;
	}

	public void setPreviewPlayerPresenter(PreviewPlayerPresenter previewPlayerPresenter) {
		this.previewPlayerPresenter = previewPlayerPresenter;
	}

	@Override
	public void setUserAttemptedQuestionTypeAndStatus(boolean isUserAttemptedResult,int questionType) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setUserAttemptedQuestionTypeAndStatus(isUserAttemptedResult, questionType);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.setUserAttemptedQuestionTypeAndStatus(isUserAttemptedResult, questionType);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.setUserAttemptedQuestionTypeAndStatus(isUserAttemptedResult, questionType);
		}
	}
	
	public void createSessionAttemptTryWhenNavigation(int questionType){
		getView().createSessionAttemptTryWhenNavigation(questionType);
	}
	
	public void setHintIdWithTime(Integer hintId) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.getHintIdsObject().put(hintId.toString(), new JSONNumber(getUnixTimeStamp()));
		}else if(isResourcePlayer){
			resourcePlayerPresenter.getHintIdsObject().put(hintId.toString(), new JSONNumber(getUnixTimeStamp()));
		}else if(isPreviewPlayer){
			previewPlayerPresenter.getHintIdsObject().put(hintId.toString(), new JSONNumber(getUnixTimeStamp()));
		}		
	}
	
	public void setExplanationIdWithTime(String explanation) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.getExplanationIdsObject().put("1", new JSONNumber(getUnixTimeStamp()));
		}else if(isResourcePlayer){
			resourcePlayerPresenter.getExplanationIdsObject().put("1", new JSONNumber(getUnixTimeStamp()));
		}else if(isPreviewPlayer){
			previewPlayerPresenter.getExplanationIdsObject().put("1", new JSONNumber(getUnixTimeStamp()));
		}		
	}
	
	public void setAnswerIdWithTime(Integer answerId,Integer attemptStatus,Integer attemptSequence) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.getAnswerIdsObject().put(answerId.toString(), new JSONNumber(getUnixTimeStamp()));
			collectionPlayerPresenter.getAttemptStatusArray().add(attemptStatus);
			collectionPlayerPresenter.getAttemptTrySequenceArray().add(attemptSequence);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.getAnswerIdsObject().put(answerId.toString(), new JSONNumber(getUnixTimeStamp()));
			resourcePlayerPresenter.getAttemptStatusArray().add(attemptStatus);
			resourcePlayerPresenter.getAttemptTrySequenceArray().add(attemptSequence);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.getAnswerIdsObject().put(answerId.toString(), new JSONNumber(getUnixTimeStamp()));
			previewPlayerPresenter.getAttemptStatusArray().add(attemptStatus);
			previewPlayerPresenter.getAttemptTrySequenceArray().add(attemptSequence);
		}		
	}
	
	public void setResourceScore(Integer score) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setResourceScore(score);
			collectionPlayerPresenter.setCollectionScore(collectionPlayerPresenter.getCollectionScore()+score);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.setResourceScore(score);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.setResourceScore(score);
			previewPlayerPresenter.setCollectionScore(previewPlayerPresenter.getCollectionScore()+score);
		}		
	}
	
	public void triggerSaveOeAnswerTextDataEvent(){
		if(isCollectionPlayer){
			collectionPlayerPresenter.triggerSaveOeAnswerTextDataEvent();
		}else if(isResourcePlayer){
			resourcePlayerPresenter.triggerSaveOeAnswerTextDataEvent();
		}else if(isPreviewPlayer){
			previewPlayerPresenter.triggerSaveOeAnswerTextDataEvent();
		}		
	}
	
	public void setFibAnswerIdsWithTime(List<Integer> attemptAnswerIds,List<Integer> attemptTrySequenceArray,List<Integer> attemptStatusArray){
		for(int i=0;i<attemptAnswerIds.size();i++){
			setAnswerIdWithTime(attemptAnswerIds.get(i),0,attemptTrySequenceArray.get(i));
		}
		
		if(isCollectionPlayer){
			collectionPlayerPresenter.getAttemptStatusArray().clear();
			collectionPlayerPresenter.getAttemptStatusArray().add(attemptTrySequenceArray!=null?attemptStatusArray.get(0):0);
		}else if(isResourcePlayer){
			resourcePlayerPresenter.getAttemptStatusArray().clear();
			resourcePlayerPresenter.getAttemptStatusArray().add(attemptTrySequenceArray!=null?attemptStatusArray.get(0):0);
		}else if(isPreviewPlayer){
			previewPlayerPresenter.getAttemptStatusArray().clear();
			previewPlayerPresenter.getAttemptStatusArray().add(attemptTrySequenceArray!=null?attemptStatusArray.get(0):0);
		}		
		
	}
	
	public Long getUnixTimeStamp(){
		Long currentTime=System.currentTimeMillis();
		return currentTime;
	}

}
