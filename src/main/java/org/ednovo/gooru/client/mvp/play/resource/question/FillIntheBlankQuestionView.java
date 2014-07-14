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
import java.util.List;
import java.util.TreeSet;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.model.player.AnswerAttemptDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class FillIntheBlankQuestionView extends Composite{
	
	@UiField Button checkAnswer;
	@UiField FlowPanel optionsContainer,resultPanel;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label messageBodyText;
	@UiField HTMLPanel answerText;

	private List<TextBox> textBoxArray=new ArrayList<TextBox>();
	private String[] enteredAnswerText=new String[3];
	private CollectionItemDo collectionItemDo=null;
	private boolean isCheckButtonEnabled=false;
//	private static final String FIB_BODY_TEXT=i18n.GL1454;
	private static final String FIB_SEPARATOR = "_______";
	
	private boolean isFirstTry=false;
	
	private AttemptedAnswersDo attemptedAnswerDo=null;
	
	private static OpendEndedQuestionViewUiBinder uiBinder = GWT.create(OpendEndedQuestionViewUiBinder.class);

	interface OpendEndedQuestionViewUiBinder extends UiBinder<Widget, FillIntheBlankQuestionView> {
		
	}
	
	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);
	
	public FillIntheBlankQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
		answerText.getElement().setInnerHTML(i18n.GL0665());
		answerText.getElement().setAttribute("alt",i18n.GL0665());
		answerText.getElement().setAttribute("title",i18n.GL0665());
		
		checkAnswer.setText(i18n.GL0666());
		checkAnswer.getElement().setAttribute("alt",i18n.GL0666());
		checkAnswer.getElement().setAttribute("title",i18n.GL0666());
		
		messageBodyText.getElement().setAttribute("title",i18n.GL0666());
		
		renderFibQuestion();
		setId();
	}
	public void setId(){
		answerText.getElement().setId("pnlAnswerText");
		checkAnswer.getElement().setId("btnCheckAnswer");
		messageBodyText.getElement().setId("lblMessageBodyText");
		optionsContainer.getElement().setId("fpnlOptionsContainer");
		resultPanel.getElement().setId("fpnlResultPanel");
	}
	@UiConstructor
	public FillIntheBlankQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswerDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		this.attemptedAnswerDo=attemptedAnswerDo;
		setQuestionTypeCaption();
		renderFibQuestion();
		answerText.getElement().setInnerHTML(i18n.GL0665());
		answerText.getElement().setAttribute("alt",i18n.GL0665());
		answerText.getElement().setAttribute("title",i18n.GL0665());
		checkAnswer.setText(i18n.GL0666());
		checkAnswer.getElement().setAttribute("alt",i18n.GL0666());
		checkAnswer.getElement().setAttribute("title",i18n.GL0666());
		setId();
	}
	
	public void setQuestionTypeCaption(){
		messageBodyText.setText(i18n.GL1454());
		messageBodyText.getElement().setAttribute("alt",i18n.GL1454());
		messageBodyText.getElement().setAttribute("title",i18n.GL1454());
	}
	
	public void renderFibQuestion(){
		String[] fibArray = this.collectionItemDo.getResource().getQuestionText().split(FIB_SEPARATOR);
		String fibQuestionTxt = "";
		int answerArraySize = this.collectionItemDo.getResource().getAnswers().size();
		HTML fibText=new HTML();
		fibText.setStyleName(oeStyle.answerTextContainer());
		for(int i = 0; i < fibArray.length; i++) {
/*			if(fibQuestionTxt.length()>0)
			{
			fibQuestionTxt = fibQuestionTxt.replaceAll("\\<.*?\\>", "");
			}*/
			fibQuestionTxt = fibQuestionTxt + fibArray[i];
			if(i<answerArraySize) {
				fibQuestionTxt = fibQuestionTxt + "<span id=\"fib"+i+"\"></span>";
			}
		}
		
		fibText.setHTML(fibQuestionTxt);
		optionsContainer.add(fibText);
	}
	
	@Override
	public void onLoad(){
		super.onLoad();
		int answerArraySize = this.collectionItemDo.getResource().getAnswers().size();
		for(int i = 0; i < answerArraySize; i++) {
			TextBox answerText = new TextBox();
			answerText.addKeyUpHandler(new AnswerTextBoxKeypressEvent());
			answerText.setStyleName(oeStyle.answerTextBox());
			optionsContainer.add(answerText);
			textBoxArray.add(answerText);
			Document.get().getElementById("fib"+i).appendChild(answerText.getElement());
		}
		showPreviousAttemptedResult();
	}
	public void showPreviousAttemptedResult(){
		if(attemptedAnswerDo!=null){
			String[] previoustAttemptedResult=attemptedAnswerDo.getFibAnswersList();
			for(int i=0;i<textBoxArray.size();i++){
				textBoxArray.get(i).setText(StringUtil.replaceSpecial(previoustAttemptedResult[i]));
			}
		}
	}
	private void enableCheckAnswerButton(){
		isCheckButtonEnabled=true;
		checkAnswer.removeStyleName(oeStyle.hintsInActiveButton());
		checkAnswer.addStyleName(oeStyle.openEndedQuestionSubmitButton());
	}
	
	@UiHandler("checkAnswer")
	public void checkAnswerButtonEvent(ClickEvent event){
		if(isCheckButtonEnabled){
			highlightTextBoxes();
			increaseUserAttemptCount();
			setEnteredFibAnswersData(enteredAnswerText);
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName(oeStyle.openEndedQuestionSubmitButton());
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}		
	}
	
	private void highlightTextBoxes(){
		TreeSet<QuestionAnswerDo> answersList=this.collectionItemDo.getResource().getAnswers();
		Iterator<QuestionAnswerDo> answersIterator=answersList.iterator();
		int i=0;
		boolean isFibStatus=true;
		List<String> attemptedAnswersList=new ArrayList<String>();
		List<Integer> attemptAnswerIds=new ArrayList<Integer>();
		List<Integer> attemptTrySequenceArray=new ArrayList<Integer>();
		List<Integer> attemptStatusArray=new ArrayList<Integer>();
		List<AnswerAttemptDo> userAttemptedOptionsList=new ArrayList<AnswerAttemptDo>();
		while(answersIterator.hasNext()){
			QuestionAnswerDo questionAnswerDo=answersIterator.next();
			String 	questionAnswerDoAnswerText	=	questionAnswerDo.getAnswerText().trim();
		  	String 	textBoxAnswerDoAnswerText	=	textBoxArray.get(i).getText().trim();
		  	questionAnswerDoAnswerText 	=questionAnswerDoAnswerText.replaceAll("<[^>]*>", "");
		  	questionAnswerDoAnswerText = StringUtil.replaceSpecial(questionAnswerDoAnswerText);
		  	attemptedAnswersList.add(textBoxAnswerDoAnswerText);
		  	attemptAnswerIds.add(questionAnswerDo.getAnswerId());
		  	attemptTrySequenceArray.add(i+1);
		  	AnswerAttemptDo answerAttemptDo=new AnswerAttemptDo();
			answerAttemptDo.setText(StringUtil.replaceSpecial(textBoxAnswerDoAnswerText));
			answerAttemptDo.setAnswerId(questionAnswerDo.getAnswerId());
			answerAttemptDo.setOrder(i+1+"");
			userAttemptedOptionsList.add(answerAttemptDo);
			if(textBoxAnswerDoAnswerText!=null&&textBoxAnswerDoAnswerText.equals("")){
				answerAttemptDo.setSkip(true);
			}
			if(questionAnswerDoAnswerText.equalsIgnoreCase(textBoxAnswerDoAnswerText)){
				answerAttemptDo.setStatus("1");
				if(isFibStatus){
					isFibStatus=true;
				}
				textBoxArray.get(i).addStyleName(oeStyle.answerCorrectTextBox());
			}else{
				answerAttemptDo.setStatus("0");
				isFibStatus=false;
				textBoxArray.get(i).addStyleName(oeStyle.answerWrongTextBox());
				showResultPanel(i,questionAnswerDo.getAnswerText());
			}
			textBoxArray.get(i).setReadOnly(true);
			i++;
		}
		attemptStatusArray.add(isFibStatus?1:0);
		int score=0;
		boolean isFirstAttempt=false;
		isFirstTry=true;
		isFirstAttempt=true;
		score=isFibStatus?1:0;
		
		userAttemptedAnswerObject(userAttemptedOptionsList);
		String attemptStatus=isFibStatus==true?"correct":"wrong";
		createSesstionItemAttemptOe(attemptAnswerIds,attemptedAnswersList,attemptStatus);
		setFibAnswerIdsWithTime(attemptAnswerIds,attemptTrySequenceArray,attemptStatusArray,score,isFirstAttempt,attemptedAnswersList);
		
	}
	public void createSesstionItemAttemptOeWhenNavigation(){
		TreeSet<QuestionAnswerDo> answersList=this.collectionItemDo.getResource().getAnswers();
		Iterator<QuestionAnswerDo> answersIterator=answersList.iterator();
		int i=0;
		boolean isFibStatus=true;
		List<String> attemptedAnswersList=new ArrayList<String>();
		List<Integer> attemptAnswerIds=new ArrayList<Integer>();
		while(answersIterator.hasNext()){
			QuestionAnswerDo questionAnswerDo=answersIterator.next();
			String 	questionAnswerDoAnswerText	=	StringUtil.replaceSpecial(questionAnswerDo.getAnswerText().trim());
		  	String 	textBoxAnswerDoAnswerText	=	StringUtil.replaceSpecial(textBoxArray.get(i).getText().trim());
		  	attemptedAnswersList.add(textBoxAnswerDoAnswerText);
		  	attemptAnswerIds.add(questionAnswerDo.getAnswerId());
			if(questionAnswerDoAnswerText.equalsIgnoreCase(textBoxAnswerDoAnswerText)){
				if(isFibStatus){
					isFibStatus=true;
				}
			}else{
				isFibStatus=false;
				//showResultPanel(i,questionAnswerDo.getAnswerText());
			}
			i++;
		}
		String attemptStatus=isFibStatus==true?"correct":"wrong";
		createSesstionItemAttemptOe(attemptAnswerIds,attemptedAnswersList,attemptStatus);
	}
	public class AnswerTextBoxKeypressEvent implements KeyUpHandler{
		@Override
		public void onKeyUp(KeyUpEvent event) {
			for(int i=0;i<textBoxArray.size();i++){
				if(textBoxArray.get(i).getText().length()>0){
					if(!textBoxArray.get(i).isReadOnly()){
						enableCheckAnswerButton();
					}
				}
				enteredAnswerText[i]=StringUtil.replaceSpecial(textBoxArray.get(i).getText().trim());
			}
			isUserAnswerAttempted(true);
		}
	}
	
	private void showResultPanel(int blankNum,String correctAnswer){
		FlowPanel resultContianer=new FlowPanel();
		resultContianer.setStyleName(oeStyle.resultPanelConatiner());
		HTMLPanel blankHtml=new HTMLPanel(i18n.GL1455()+" "+(blankNum+1)+i18n.GL_SPL_SEMICOLON());
		blankHtml.setStyleName(oeStyle.resultPanelText());
		Label answerWrongImagePanel=new Label();
		answerWrongImagePanel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
		answerWrongImagePanel.addStyleName(oeStyle.resultPanelAnswerImageFIB());
		
		HTML answerOptiontext=new HTML();
		answerOptiontext.setHTML(i18n.GL1456()+i18n.GL_SPL_SEMICOLON()+" "+correctAnswer);
		answerOptiontext.setStyleName(oeStyle.resultPanelText());
		resultContianer.add(blankHtml);
		resultContianer.add(answerWrongImagePanel);
		resultContianer.add(answerOptiontext);
		resultPanel.add(resultContianer);
		resultPanel.setStyleName(oeStyle.resultPanel());
	}
	
	public void setEnteredFibAnswersData(String[] enteredFibAnswersData){
		AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
		attempteAnswersDo.setFibAnswersList(enteredFibAnswersData);
		attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
		setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
	}
	public void setAttemptStatus(String collecionItemId, AttemptedAnswersDo attempteAnswersDo){
		
	}
	public void createSesstionItemAttemptOe(List<Integer> answerIds,List<String> userAttemptedAnswers,String attemptStatus){
		
	}
	public void isUserAnswerAttempted(boolean isUserAttemptedResult){
	}
	public void setFibAnswerIdsWithTime(List<Integer> attemptAnswerIds,List<Integer> attemptTrySequenceArray,List<Integer> attemptStatusArray,Integer score,boolean isFirstAttempt,List<String> attemptedAnswersList){
		
	}
	public void increaseUserAttemptCount(){
		
	}
	
	public void userAttemptedAnswerObject(List<AnswerAttemptDo> userAttemptedOptionsList) {
	}
}
