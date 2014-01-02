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

import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class QuestionResourcePresenter extends PresenterWidget<IsQuestionResourceView> implements QuestionResourceUiHandlers{
	private CollectionPlayerPresenter collectionPlayerPresenter=null;
	
	private ResourcePlayerPresenter resourcePlayerPresenter=null;
	
	private boolean isCollectionPlayer=true;
	
	@Inject
	public QuestionResourcePresenter(EventBus eventBus, IsQuestionResourceView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	public void showQuestionPreview(CollectionItemDo collectionItemDo){
		getView().resetQuestionView();
		getView().showQuestionPreview(collectionItemDo);
	}
	
	public void setCollectionPlayerPresnter(CollectionPlayerPresenter collectionPlayerPresenter){
		this.collectionPlayerPresenter=collectionPlayerPresenter;
	}
	
	public void setResourcePlayerPresenter(ResourcePlayerPresenter resourcePlayerPresenter){
		this.resourcePlayerPresenter=resourcePlayerPresenter;
	}

	@Override
	public void createSessionItemAttempt(int answerId,String answerAttemptStatus) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.createSessionItemAttempt(answerId, answerAttemptStatus);
		}else{
			resourcePlayerPresenter.createSessionItemAttempt(answerId, answerAttemptStatus);
		}	
	}

	@Override
	public void createSesstionItemAttemptOe(String answerText) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.createSessionItemAttemptOe(answerText);
		}else{
			resourcePlayerPresenter.createSessionItemAttemptOe(answerText);
		}	
	}
	
	@Override
	public void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setUserAttemptResult(collectionItemId, attemptAnswerDo);
		}else{
			resourcePlayerPresenter.setUserAttemptResult(collectionItemId, attemptAnswerDo);
		}	
	}

	@Override
	public void setAnswerAttemptSequence(int attemptSequence,
			int attemptStatus, int answerId) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}else{
			resourcePlayerPresenter.setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}	
	}

	@Override
	public void setOeQuestionAnswerText(String answerText) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.setOeQuestionAnswerText(answerText);
		}else{
			resourcePlayerPresenter.setOeQuestionAnswerText(answerText);
		}	
	}

	@Override
	public void startHintDataLogEvent(int hintId) {
		if(isCollectionPlayer){
			collectionPlayerPresenter.startHintDataLogEvent(hintId);
		}else{
			resourcePlayerPresenter.startHintDataLogEvent(hintId);
		}	
	}

	@Override
	public void startExplanationDataLogEvent() {
		if(isCollectionPlayer){
			collectionPlayerPresenter.startExplanationDataLogEvent();
		}else{
			resourcePlayerPresenter.startExplanationDataLogEvent();
		}	
	}

	@Override
	public void saveOeQuestionAnswerDataLogEvent() {
		if(isCollectionPlayer){
			collectionPlayerPresenter.saveOeQuestionAnswerDataLogEvent();
		}else{
			resourcePlayerPresenter.saveOeQuestionAnswerDataLogEvent();
		}	
	}

	public boolean isCollectionPlayer() {
		return isCollectionPlayer;
	}

	public void setCollectionPlayer(boolean isCollectionPlayer) {
		this.isCollectionPlayer = isCollectionPlayer;
	}
	
	
	

}
