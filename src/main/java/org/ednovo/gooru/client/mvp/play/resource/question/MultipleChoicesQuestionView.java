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

import java.util.Iterator;
import java.util.TreeSet;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class  MultipleChoicesQuestionView extends Composite{
	
	@UiField Button checkAnswer;
	@UiField FlowPanel optionsContainer;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label messageBodyText;
	
	private boolean isCheckButtonEnabled=true;
	
	private static final String TRUE_FALSE_BODY_TEXT="Please select the correct answer.";
	private CollectionItemDo collectionItemDo;
	
	private static MultipleChoicesQuestionViewUiBinder uiBinder = GWT.create(MultipleChoicesQuestionViewUiBinder.class);

	interface MultipleChoicesQuestionViewUiBinder extends UiBinder<Widget, MultipleChoicesQuestionView> {
		
	}
	
	public MultipleChoicesQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
	}
	
	@UiConstructor
	public MultipleChoicesQuestionView(CollectionItemDo collectionItemDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.collectionItemDo=collectionItemDo;
		setQuestionTypeCaption();
		renderQuestionAnswerOptions();
	}
	
	private void setQuestionTypeCaption(){
		messageBodyText.setText(TRUE_FALSE_BODY_TEXT);
	}
	
	private void renderQuestionAnswerOptions(){
		TreeSet<QuestionAnswerDo> answersSet=collectionItemDo.getResource().getAnswers();
		Iterator<QuestionAnswerDo> answersList=answersSet.iterator();
		int i=0;
		while (answersList.hasNext()) {
			QuestionAnswerDo questionAnswerDo=answersList.next();
			final QuestionAnswerOptionView questionAnswerOptionView=new QuestionAnswerOptionView(questionAnswerDo.getAnswerText(),("(" + (char) (65 + i) + ") "));
			questionAnswerOptionView.radioButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
			questionAnswerOptionView.setAnswerCorrect(questionAnswerDo.isIsCorrect());
			questionAnswerOptionView.radioButton.addClickHandler(new RadioButtonSelectEvent(questionAnswerOptionView,questionAnswerDo,i));
			// TODO need to implement logic
			optionsContainer.add(questionAnswerOptionView);
			i++;
		}
	}
	
	public class RadioButtonSelectEvent implements ClickHandler{
		private QuestionAnswerOptionView questionAnswerOptionView=null;
		private QuestionAnswerDo questionAnswerDo=null;
		private int attemptSequence=0;
		
		public RadioButtonSelectEvent(QuestionAnswerOptionView questionAnswerOptionView,QuestionAnswerDo questionAnswerDo,int attemptSequence){
			this.questionAnswerOptionView=questionAnswerOptionView;
			this.questionAnswerDo=questionAnswerDo;
			this.attemptSequence=attemptSequence;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			if(!this.questionAnswerOptionView.answerOptionRadioButton.getValue()){
				resetSelectedRadioButton();
				enableCheckAnswerButton();
				questionAnswerOptionView.answerOptionRadioButton.setValue(true);
				questionAnswerOptionView.radioButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
				createSessionItemAttempt(questionAnswerDo.getAnswerId(), questionAnswerDo.isIsCorrect()?"true":"false");
				AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
				attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
				attempteAnswersDo.setAttemptResult(questionAnswerDo.isIsCorrect());
				attempteAnswersDo.setAnswerId(questionAnswerDo.getAnswerId());
				setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
				int attemptStatus=questionAnswerDo.isIsCorrect()?1:0;
				setAnswerAttemptSequence(attemptSequence,attemptStatus,questionAnswerDo.getAnswerId());
			}
		}	
	}
	
	private void resetSelectedRadioButton(){
		int widgetCount=optionsContainer.getWidgetCount();
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof QuestionAnswerOptionView){
				QuestionAnswerOptionView questionAnswerOptionView=(QuestionAnswerOptionView)widget;
				questionAnswerOptionView.radioButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
				questionAnswerOptionView.answerOptionRadioButton.setValue(false);
				questionAnswerOptionView.answerChoiceResult.setStyleName("");
			}
		}
	}
	
	private void enableCheckAnswerButton(){
		isCheckButtonEnabled=true;
		checkAnswer.removeStyleName(oeStyle.hintsInActiveButton());
		checkAnswer.addStyleName(oeStyle.openEndedQuestionSubmitButton());
	}
	
	@UiHandler("checkAnswer")
	public void checkButtonClickEvent(ClickEvent event){
		if(isCheckButtonEnabled){
			showCorrectResult();
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName(oeStyle.openEndedQuestionSubmitButton());
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}
	}
	
	private void showCorrectResult(){
		int widgetCount=optionsContainer.getWidgetCount();
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof QuestionAnswerOptionView){
				QuestionAnswerOptionView questionAnswerOptionView=(QuestionAnswerOptionView)widget;
				if(questionAnswerOptionView.answerOptionRadioButton.getValue()){
					if(questionAnswerOptionView.isAnswerCorrect()){
						questionAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					}else{
						questionAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					}
				}
			}
		}
	}
	
	public abstract void createSessionItemAttempt(int answerId,String answerAttemptStatus);
	public abstract void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo);
	public abstract void setAnswerAttemptSequence(int attemptSequence,int attemptStatus, int answerId);

}
