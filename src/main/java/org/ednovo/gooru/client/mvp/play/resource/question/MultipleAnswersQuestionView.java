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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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
			showPreviousResult(questionAnswerDo.getAnswerId(),checkBoxAnswerOptionView);
			i++;
		}
	}
	
	public void showPreviousResult(int answerId,CheckBoxAnswerOptionView checkBoxAnswerOptionView){
		if(attemptedAnswerDo!=null){
		 Map<Integer,Boolean> answerOptionCount=attemptedAnswerDo.getAnswerOptionResult();
			 if(answerOptionCount.get(answerId)!=null){
				if(answerOptionCount.get(answerId)){
					checkBoxAnswerOptionView.radioYesButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
					checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(true);
					checkBoxAnswerOptionView.answerOptionNoRadioButton.setValue(false);
					if(checkBoxAnswerOptionView.isAnswerCorrect()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					}
				}else{
					checkBoxAnswerOptionView.radioNoButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().selectedRadioIcon());
					checkBoxAnswerOptionView.answerOptionYesRadioButton.setValue(false);
					checkBoxAnswerOptionView.answerOptionNoRadioButton.setValue(true);
					if(!checkBoxAnswerOptionView.isAnswerCorrect()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
					}
				}
			 }
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
		boolean mutipleAnswerChoiceStatus=true;
		Map<Integer,Boolean> answerOptionResult=new LinkedHashMap<Integer,Boolean>();
		List<String> userAttemptedValueList=new ArrayList<String>();
		List<Integer> answerIds=new ArrayList<Integer>();
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof CheckBoxAnswerOptionView){
				CheckBoxAnswerOptionView checkBoxAnswerOptionView=(CheckBoxAnswerOptionView)widget;
				answerIds.add(checkBoxAnswerOptionView.getAnswerId());
				if(checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
					userAttemptedValueList.add("1");
					//createSessionItemAttempt(checkBoxAnswerOptionView.getAnswerId(), checkBoxAnswerOptionView.isAnswerCorrect()?"correct":"wrong");
					answerOptionResult.put(checkBoxAnswerOptionView.getAnswerId(), true);
					if(checkBoxAnswerOptionView.isAnswerCorrect()==checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
						if(mutipleAnswerChoiceStatus){
							mutipleAnswerChoiceStatus=true;
						}
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
						 mutipleAnswerChoiceStatus=false;
					}
				}
				if(checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
					userAttemptedValueList.add("0");
					answerOptionResult.put(checkBoxAnswerOptionView.getAnswerId(), false);
					if(!checkBoxAnswerOptionView.isAnswerCorrect()==checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
						if(mutipleAnswerChoiceStatus){
							mutipleAnswerChoiceStatus=true;
						}
					}else{
						checkBoxAnswerOptionView.answerChoiceResult.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
						mutipleAnswerChoiceStatus=false;
					}
				}
				if(!checkBoxAnswerOptionView.answerOptionYesRadioButton.getValue()&&!checkBoxAnswerOptionView.answerOptionNoRadioButton.getValue()){
					userAttemptedValueList.add("");
					mutipleAnswerChoiceStatus=false;
				}
			}
		}
		increaseUserAttemptCount();
		AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
		attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
		//attempteAnswersDo.setAttemptResult(checkBoxAnswerOptionView.isAnswerCorrect());
		//attempteAnswersDo.setAnswerId(checkBoxAnswerOptionView.getAnswerId());
		attempteAnswersDo.setAnswerOptionResult(answerOptionResult);
		setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
		int score=0;
		boolean isFirstTry=isChekcAnswerButtonClicked;
		if(!isChekcAnswerButtonClicked){
			isChekcAnswerButtonClicked=true;
			score=mutipleAnswerChoiceStatus?1:0;
		}
		String attemptStatus=mutipleAnswerChoiceStatus==true?"correct":"wrong";
		userAttemptedValue(userAttemptedValueList);
		setAnswersDetailsWitithTime(answerIds,mutipleAnswerChoiceStatus?1:0,1,score,!isFirstTry);
		createSesstionItemAttemptForMultipleAnswer(answerIds,userAttemptedValueList,attemptStatus);
	}
	
	public abstract void createSessionItemAttempt(int answerId,String answerAttemptStatus);
	public abstract void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo);
	public abstract void setAnswerAttemptSequence(int attemptSequence,int attemptStatus, int answerId);
	public void isUserAnswerAttempted(boolean isUserAttemptedResult){}
	public void setAnswersDetailsWitithTime(List<Integer> answerIds,int answerStatus,int answerSequence,int score,boolean isFirstTry){
		
	}
	public abstract void increaseUserAttemptCount();
	public abstract void userAttemptedValue(List<String> userAttemptedValueList);
	public abstract void createSesstionItemAttemptForMultipleAnswer(List<Integer> answerIds,List<String> userAttemptedAnswers,String attemptStatus);
	
}
