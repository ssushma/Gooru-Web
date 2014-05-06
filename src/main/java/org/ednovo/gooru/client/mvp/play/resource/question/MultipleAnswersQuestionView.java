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

import org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView.MultipleChoicesQuestionViewUiBinder;
import org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView.RadioButtonSelectEvent;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.MessageProperties;

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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract  class MultipleAnswersQuestionView extends Composite implements MessageProperties{
	
	@UiField Button checkAnswer;
	@UiField FlowPanel optionsContainer;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label messageBodyText;
	@UiField HTMLPanel answerText;
	private boolean isCheckButtonEnabled=true;
	
	private boolean isChekcAnswerButtonClicked=false;
	
	private static final String TRUE_FALSE_BODY_TEXT=GL1457+GL_SPL_FULLSTOP;
	private CollectionItemDo collectionItemDo;
	
	private AttemptedAnswersDo attemptedAnswerDo=null;
	
	private static MultipleAnswerQuestionViewUiBinder uiBinder = GWT.create(MultipleAnswerQuestionViewUiBinder.class);

	interface MultipleAnswerQuestionViewUiBinder extends UiBinder<Widget, MultipleAnswersQuestionView> {
		
	}
	
	public MultipleAnswersQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
	}
	
	@UiConstructor
	public MultipleAnswersQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswerDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.collectionItemDo=collectionItemDo;
		setQuestionTypeCaption();
		this.attemptedAnswerDo=attemptedAnswerDo;
		renderQuestionAnswerOptions();
		answerText.getElement().setInnerHTML(GL0665);
		checkAnswer.setText(GL0666);
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
			final CheckBoxAnswerOptionView checkBoxAnswerOptionView=new CheckBoxAnswerOptionView(questionAnswerDo.getAnswerText(),("(" + (char) (65 + i) + ") "));
			checkBoxAnswerOptionView.setAnswerId(questionAnswerDo.getAnswerId());
			checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
			checkBoxAnswerOptionView.radioNoButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
			checkBoxAnswerOptionView.setAnswerCorrect(questionAnswerDo.isIsCorrect());
			checkBoxAnswerOptionView.radioYesButton.addClickHandler(new CheckBoxButtonSelectEvent(checkBoxAnswerOptionView,questionAnswerDo,i+1,true));
			checkBoxAnswerOptionView.radioNoButton.addClickHandler(new CheckBoxButtonSelectEvent(checkBoxAnswerOptionView,questionAnswerDo,i+1,false));
			optionsContainer.add(checkBoxAnswerOptionView);
			showPreviousAttemptResult(questionAnswerDo.getAnswerId(),checkBoxAnswerOptionView);
			i++;
		}
	}
	
	public void showPreviousAttemptResult(int answerId,CheckBoxAnswerOptionView checkBoxAnswerOptionView){
		if(attemptedAnswerDo!=null){
			if(attemptedAnswerDo.getAnswerId()==answerId){
				if(attemptedAnswerDo.isAttemptResult()){
					checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
					checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(true);
				}else{
					checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
					checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(true);
				}
			}
		}
	}
	public class CheckBoxButtonSelectEvent implements ClickHandler{
		private CheckBoxAnswerOptionView checkBoxAnswerOptionView=null;
		private QuestionAnswerDo questionAnswerDo=null;
		private int attemptSequence=1;
		private boolean isYesButton=false;
		
		public CheckBoxButtonSelectEvent(CheckBoxAnswerOptionView checkBoxAnswerOptionView,QuestionAnswerDo questionAnswerDo,int attemptSequence,boolean isYesButton){
			this.checkBoxAnswerOptionView=checkBoxAnswerOptionView;
			this.questionAnswerDo=questionAnswerDo;
			this.attemptSequence=attemptSequence;
			this.isYesButton=isYesButton;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			if(isYesButton&&!this.checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
				checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(true);
				checkBoxAnswerOptionView.answerOptionNoRadioButton.setValue(false);
				enableCheckAnswerButton();
				checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
				checkBoxAnswerOptionView.radioNoButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
				int attemptStatus=questionAnswerDo.isIsCorrect()?1:0;
				setAnswerAttemptSequence(attemptSequence,attemptStatus,questionAnswerDo.getAnswerId());
				isUserAnswerAttempted(true);
			}else if(!isYesButton&&!this.checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
				checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(false);
				checkBoxAnswerOptionView.answerOptionNoRadioButton.setValue(true);
				enableCheckAnswerButton();
				checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().normalRadioIcon());
				checkBoxAnswerOptionView.radioNoButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
				int attemptStatus=questionAnswerDo.isIsCorrect()?1:0;
				setAnswerAttemptSequence(attemptSequence,attemptStatus,questionAnswerDo.getAnswerId());
				isUserAnswerAttempted(true);
			}
		}	
	}
	
	
	private void enableCheckAnswerButton(){
		int widgetCount=optionsContainer.getWidgetCount();
		boolean isOptionSelected=false;
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof CheckBoxAnswerOptionView){
				CheckBoxAnswerOptionView checkBoxAnswerOptionView=(CheckBoxAnswerOptionView)widget;
				checkBoxAnswerOptionView.answerChoiceResult.setStyleName("");
//				if(checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
//					isOptionSelected=true;
//				}
			}
		}
//		if(isOptionSelected){
//			isCheckButtonEnabled=true;
//			checkAnswer.removeStyleName(oeStyle.hintsInActiveButton());
//			checkAnswer.addStyleName("primary");
//		}else{
//			isCheckButtonEnabled=false;
//			checkAnswer.removeStyleName("primary");
//			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
//		}
		
		isCheckButtonEnabled=true;
		checkAnswer.removeStyleName(oeStyle.hintsInActiveButton());
		checkAnswer.addStyleName("primary");
	}
	
	@UiHandler("checkAnswer")
	public void checkButtonClickEvent(ClickEvent event){
		if(isCheckButtonEnabled){
			showCorrectResult();
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName("primary");
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}
	}
	
	private void showCorrectResult(){
		int widgetCount=optionsContainer.getWidgetCount();
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof CheckBoxAnswerOptionView){
				CheckBoxAnswerOptionView checkBoxAnswerOptionView=(CheckBoxAnswerOptionView)widget;
				System.out.println("hellooo==1"+checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue());
				System.out.println("hellooo==5"+checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue());
				if(checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
					System.out.println("hellooo==2");
					//createSessionItemAttempt(checkBoxAnswerOptionView.getAnswerId(), checkBoxAnswerOptionView.isAnswerCorrect()?"correct":"wrong");
					AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
					attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
					attempteAnswersDo.setAttemptResult(checkBoxAnswerOptionView.isAnswerCorrect());
					attempteAnswersDo.setAnswerId(checkBoxAnswerOptionView.getAnswerId());
					setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
					increaseUserAttemptCount();
					int score=0;
					boolean isFirstTry=isChekcAnswerButtonClicked;
					if(!isChekcAnswerButtonClicked){
						isChekcAnswerButtonClicked=true;
						score=checkBoxAnswerOptionView.isAnswerCorrect()?1:0;
					}
					setAnswersDetailsWitithTime(checkBoxAnswerOptionView.getAnswerId(),checkBoxAnswerOptionView.isAnswerCorrect()?1:0,(i+1),score,!isFirstTry);
					if(checkBoxAnswerOptionView.isAnswerCorrect()==checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					}
				}
				if(checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
					System.out.println("hellooo==3");
					if(!checkBoxAnswerOptionView.isAnswerCorrect()==checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					}
				}
			}
		}
	}
	
	public abstract void createSessionItemAttempt(int answerId,String answerAttemptStatus);
	public abstract void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo);
	public abstract void setAnswerAttemptSequence(int attemptSequence,int attemptStatus, int answerId);
	public void isUserAnswerAttempted(boolean isUserAttemptedResult){}
	public void setAnswersDetailsWitithTime(int answerId,int answerStatus,int answerSequence,int score,boolean isFirstTry){
		
	}
	public abstract void increaseUserAttemptCount();
	
	
}
