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

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.application.shared.model.player.AnswerAttemptDo;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddAnswerImg;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHotSpotQuestionAnswerChoice;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.StringUtil;

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

public abstract  class HotSpotAnswersQuestionView extends Composite{

	@UiField Button checkAnswer;
	@UiField FlowPanel optionsContainer;
	@UiField Label messageBodyText;
	@UiField HTMLPanel answerText;

	private CollectionItemDo collectionItemDo;

	private AttemptedAnswersDo attemptedAnswerDo=null;

	private boolean isCheckButtonEnabled=true;
	
	private boolean isCheckAnswerButtonClicked=false;
	
	private static final String NORMAL_RADIO="answer-radio-normal-icon";
	private static final String SELECTED_RADIO="answer-radio-selected-icon";
	private static final String CORRECT_ICON="answer-right-icon";
	private static final String INCORRECT_ICON="answer-wrong-icon";


	private static HotSpotAnswersQuestionViewUiBinder uiBinder = GWT.create(HotSpotAnswersQuestionViewUiBinder.class);

	interface HotSpotAnswersQuestionViewUiBinder extends UiBinder<Widget, HotSpotAnswersQuestionView> {

	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public HotSpotAnswersQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
	}

	@UiConstructor
	public HotSpotAnswersQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswerDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		setQuestionTypeCaption();
		this.attemptedAnswerDo=attemptedAnswerDo;
		renderQuestionAnswerOptions();
		answerText.getElement().setInnerHTML(i18n.GL0665());
		answerText.getElement().setAttribute("alt",i18n.GL0665());
		answerText.getElement().setAttribute("title",i18n.GL0665());
		checkAnswer.setText(i18n.GL0666());
		checkAnswer.getElement().setAttribute("alt",i18n.GL0666());
		checkAnswer.getElement().setAttribute("title",i18n.GL0666());
	}
	
	private void setQuestionTypeCaption(){
		messageBodyText.setText(i18n.GL1457()+i18n.GL_SPL_FULLSTOP());
		answerText.getElement().setId("pnlAnswerText");
		checkAnswer.getElement().setId("btnCheckAnswer");
		messageBodyText.getElement().setId("lblMessageBodyText");
		optionsContainer.getElement().setId("fpnlOptionsContainer");
	}
	
	private void renderQuestionAnswerOptions(){
		if(collectionItemDo!=null && collectionItemDo.getResource()!=null && collectionItemDo.getResource().getAnswers()!=null){
			TreeSet<QuestionAnswerDo> answersSet=collectionItemDo.getResource().getAnswers();
			Iterator<QuestionAnswerDo> answersList=answersSet.iterator();
			int i=0;
			
			if(collectionItemDo.getResource().getAttributes().getHlType().equalsIgnoreCase(i18n.GL3228_1())){
				while (answersList.hasNext()) {
					QuestionAnswerDo questionAnswerDo=answersList.next();
					double randNumber = Math.random();
					final AddAnswerImg addAnswerImage = new AddAnswerImg();
					addAnswerImage.getChangeImgLbl().setVisible(false);
					addAnswerImage.getRemoveImgLbl().setVisible(false);
					addAnswerImage.setAnswerImage(questionAnswerDo.getAnswerText()+"?"+randNumber);
					addAnswerImage.setFileName(null);
					optionsContainer.add(addAnswerImage);
				}
			}else{
				while (answersList.hasNext()) {
					QuestionAnswerDo questionAnswerDo=answersList.next();
					final QuestionAnswerOptionView questionAnswerOptionView=new QuestionAnswerOptionView(questionAnswerDo.getAnswerText(),("(" + (char) (65 + i) + ") "));
				//	questionAnswerOptionView.setAnswerId(questionAnswerDo.getAnswerId());
					questionAnswerOptionView.getElement().setId(i+"id");
					questionAnswerOptionView.radioButton.setStyleName(NORMAL_RADIO);
					questionAnswerOptionView.setAnswerCorrect(questionAnswerDo.isIsCorrect());
					questionAnswerOptionView.radioButton.addClickHandler(new RadioButtonSelectEvent(questionAnswerOptionView,questionAnswerDo,i+1));
					optionsContainer.add(questionAnswerOptionView);
					
					if(attemptedAnswerDo!=null){
					showPreviousAttemptResult(0,questionAnswerOptionView,questionAnswerDo.isIsCorrect());
					}
					i++;
				}
			}
		}
	}
	
	public void showPreviousAttemptResult(int answerId,QuestionAnswerOptionView questionAnswerOptionView,boolean isCorrect){
				if(isCorrect){
					questionAnswerOptionView.answerChoiceResult.setStyleName(CORRECT_ICON);
					questionAnswerOptionView.radioButton.setStyleName(SELECTED_RADIO);
					questionAnswerOptionView.answerOptionRadioButton.setValue(true);
				}else{
					questionAnswerOptionView.answerChoiceResult.setStyleName(INCORRECT_ICON);
					questionAnswerOptionView.radioButton.setStyleName(SELECTED_RADIO);
					questionAnswerOptionView.answerOptionRadioButton.setValue(true);
				}
	}
	
	public class RadioButtonSelectEvent implements ClickHandler{
		private QuestionAnswerOptionView questionAnswerOptionView=null;
		private QuestionAnswerDo questionAnswerDo=null;
		private int attemptSequence=1;
		
		public RadioButtonSelectEvent(QuestionAnswerOptionView questionAnswerOptionView,QuestionAnswerDo questionAnswerDo,int attemptSequence){
			this.questionAnswerOptionView=questionAnswerOptionView;
			this.questionAnswerDo=questionAnswerDo;
			this.attemptSequence=attemptSequence;
		}
		
		@Override
		public void onClick(ClickEvent event) {
				
				if(questionAnswerOptionView.isChecked){
					questionAnswerOptionView.isChecked=false;
					questionAnswerOptionView.radioButton.setStyleName(NORMAL_RADIO);
					questionAnswerOptionView.answerOptionRadioButton.setValue(false);
					questionAnswerOptionView.answerChoiceResult.setStyleName("");
					int attemptStatus=questionAnswerDo.isIsCorrect()?1:0;
					setAnswerAttemptSequence(attemptSequence,attemptStatus,questionAnswerDo.getSequence());
				}else{
					questionAnswerOptionView.isChecked=true;
					questionAnswerOptionView.answerOptionRadioButton.setValue(true);
					questionAnswerOptionView.radioButton.setStyleName(SELECTED_RADIO);
					int attemptStatus=questionAnswerDo.isIsCorrect()?1:0;
					setAnswerAttemptSequence(attemptSequence,attemptStatus,questionAnswerDo.getSequence());
				}
				isUserAnswerAttempted(true);
				checkSelectedRadioButton();
				
		}	
	}
	
	private void checkSelectedRadioButton(){
		int widgetCount=optionsContainer.getWidgetCount();
		disableCheckAnswerButton();
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof QuestionAnswerOptionView){
				QuestionAnswerOptionView questionAnswerOptionView=(QuestionAnswerOptionView)widget;
				questionAnswerOptionView.answerChoiceResult.removeStyleName(CORRECT_ICON);
				questionAnswerOptionView.answerChoiceResult.removeStyleName(INCORRECT_ICON);
				if(questionAnswerOptionView.radioButton.getStyleName().equalsIgnoreCase(SELECTED_RADIO)){
					enableCheckAnswerButton();
				}
			}
		}
	}
	
	private void enableCheckAnswerButton(){
		isCheckButtonEnabled=true;
		checkAnswer.removeStyleName("hintsInActiveButton");
		checkAnswer.addStyleName("primary");
	}
	private void disableCheckAnswerButton(){
		isCheckButtonEnabled=true;
		checkAnswer.addStyleName("hintsInActiveButton");
		checkAnswer.removeStyleName("primary");
	}
	
	@UiHandler("checkAnswer")
	public void checkButtonClickEvent(ClickEvent event){
		if(isCheckButtonEnabled){
			showCorrectResult();
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName("primary");
			checkAnswer.addStyleName("hintsInActiveButton");
		}
	}
	
	private void showCorrectResult(){
		int widgetCount=optionsContainer.getWidgetCount();
		boolean mutipleAnswerChoiceStatus=true;
		Map<Integer,Boolean> answerOptionResult=new LinkedHashMap<Integer,Boolean>();
		List<Integer> answerIds=new ArrayList<Integer>();
		List<String> userAttemptedValueList=new ArrayList<String>();
		List<AnswerAttemptDo> userAttemptedOptionsList=new ArrayList<AnswerAttemptDo>();
		
		for(int i=0;i<widgetCount;i++){
			Widget widget=optionsContainer.getWidget(i);
			if(widget instanceof QuestionAnswerOptionView){
				QuestionAnswerOptionView questionAnswerOptionView=(QuestionAnswerOptionView)widget;
				AnswerAttemptDo answerAttemptDo=new AnswerAttemptDo();
				answerAttemptDo.setText(StringUtil.replaceSpecial(questionAnswerOptionView.getAnswerText())); 
				answerAttemptDo.setAnswerId(i+1);
				answerAttemptDo.setOrder(i+1+"");
				answerIds.add(i+1);
				
				if(questionAnswerOptionView.isChecked){
				
					if(questionAnswerOptionView.isAnswerCorrect()){
						if(mutipleAnswerChoiceStatus){
							mutipleAnswerChoiceStatus=true;
						}
						answerAttemptDo.setStatus("1");
						answerOptionResult.put(1, true);
						userAttemptedValueList.add("1");
						questionAnswerOptionView.answerChoiceResult.setStyleName(CORRECT_ICON);
					}else{
						mutipleAnswerChoiceStatus=false;
						answerOptionResult.put(0, false);
						userAttemptedValueList.add("0");
						answerAttemptDo.setStatus("0");
						questionAnswerOptionView.answerChoiceResult.setStyleName(INCORRECT_ICON);
					}
				}
					answerAttemptDo.setStatus(questionAnswerOptionView.isAnswerCorrect()?"1":"0");
					userAttemptedOptionsList.add(answerAttemptDo);
				}
		}
		userAttemptedAnswerObject(userAttemptedOptionsList);
		increaseUserAttemptCount();
		
		AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
		if(collectionItemDo.getResource()!=null && collectionItemDo.getResource().getType()!=null){
		attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
		}
		attempteAnswersDo.setAnswerOptionResult(answerOptionResult);
		setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
		
		String attemptStatus=mutipleAnswerChoiceStatus==true?"correct":"wrong";
		int score=0;
		boolean isFirstTry=isCheckAnswerButtonClicked;
		isCheckAnswerButtonClicked=true;
		score=mutipleAnswerChoiceStatus?1:0;
		userAttemptedValue(userAttemptedValueList);
		setAnswersDetailsWitithTime(answerIds,mutipleAnswerChoiceStatus?1:0,1,score,!isFirstTry);
		createSesstionItemAttemptForMultipleAnswer(answerIds,userAttemptedValueList,attemptStatus);
	}
	
	public abstract void createSessionItemAttempt(int answerId,String answerAttemptStatus);
	public abstract void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo);
	public abstract void setAnswerAttemptSequence(int attemptSequence,int attemptStatus, int answerId);
	public void isUserAnswerAttempted(boolean isUserAttemptedResult){}
	public void setAnswersDetailsWitithTime(List<Integer> answerIds,int answerStatus,int answerSequence,int score,boolean isFirstTry){}

	public abstract void increaseUserAttemptCount();
	public abstract void userAttemptedValue(List<String> userAttemptedValueList);
	public abstract void createSesstionItemAttemptForMultipleAnswer(List<Integer> answerIds,List<String> userAttemptedAnswers,String attemptStatus);
	public abstract void userAttemptedAnswerObject(List<AnswerAttemptDo> answerOptionAttemptList);
}
