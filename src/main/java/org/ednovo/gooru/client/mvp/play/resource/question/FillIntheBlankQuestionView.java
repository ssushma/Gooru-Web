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
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
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

	private List<TextBox> textBoxArray=new ArrayList<TextBox>();
	private CollectionItemDo collectionItemDo=null;
	private boolean isCheckButtonEnabled=true;
	private static final String FIB_BODY_TEXT="Please type your answer(s) in the blank(s) provided";
	private static final String FIB_SEPARATOR = "_______";
	
	private static OpendEndedQuestionViewUiBinder uiBinder = GWT.create(OpendEndedQuestionViewUiBinder.class);

	interface OpendEndedQuestionViewUiBinder extends UiBinder<Widget, FillIntheBlankQuestionView> {
		
	}
	
	public FillIntheBlankQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
		renderFibQuestion();
	}
	
	@UiConstructor
	public FillIntheBlankQuestionView(CollectionItemDo collectionItemDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		setQuestionTypeCaption();
		renderFibQuestion();
	}
	
	public void setQuestionTypeCaption(){
		messageBodyText.setText(FIB_BODY_TEXT);
	}
	
	public void renderFibQuestion(){
		String[] fibArray = this.collectionItemDo.getResource().getQuestionText().split(FIB_SEPARATOR);
		String fibQuestionTxt = "";
		int answerArraySize = this.collectionItemDo.getResource().getAnswers().size();
		HTML fibText=new HTML();
		fibText.setStyleName(oeStyle.answerTextContainer());
		for(int i = 0; i < fibArray.length; i++) {
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
			answerText.addKeyPressHandler(new AnswerTextBoxKeypressEvent());
			answerText.setStyleName(oeStyle.answerTextBox());
			optionsContainer.add(answerText);
			textBoxArray.add(answerText);
			Document.get().getElementById("fib"+i).appendChild(answerText.getElement());
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
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName(oeStyle.openEndedQuestionSubmitButton());
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}		
	}
	
	private void highlightTextBoxes(){
		TreeSet<QuestionAnswerDo> answersList=this.collectionItemDo.getResource().getAnswers();
		Iterator<QuestionAnswerDo> answersIterator=answersList.iterator();
		int i=0;
		while(answersIterator.hasNext()){
			QuestionAnswerDo questionAnswerDo=answersIterator.next();
			if(questionAnswerDo.getAnswerText().equalsIgnoreCase(textBoxArray.get(i).getText())){
				textBoxArray.get(i).addStyleName(oeStyle.answerCorrectTextBox());
			}else{
				textBoxArray.get(i).addStyleName(oeStyle.answerWrongTextBox());
				showResultPanel(i,questionAnswerDo.getAnswerText());
			}
			textBoxArray.get(i).setReadOnly(true);
			i++;
		}
	}
	
	public class AnswerTextBoxKeypressEvent implements KeyPressHandler{
		@Override
		public void onKeyPress(KeyPressEvent event) {
			for(int i=0;i<textBoxArray.size();i++){
				if(textBoxArray.get(i).getText().length()>0){
					enableCheckAnswerButton();
				}
			}
		}
	}
	
	private void showResultPanel(int blankNum,String correctAnswer){
		FlowPanel resultContianer=new FlowPanel();
		resultContianer.setStyleName(oeStyle.resultPanelConatiner());
		HTMLPanel blankHtml=new HTMLPanel("Blank "+(blankNum+1)+":");
		blankHtml.setStyleName(oeStyle.resultPanelText());
		Label answerWrongImagePanel=new Label();
		answerWrongImagePanel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
		answerWrongImagePanel.addStyleName(oeStyle.resultPanelAnswerImage());
		HTMLPanel answerOptiontext=new HTMLPanel("correct answer: "+correctAnswer);
		answerOptiontext.setStyleName(oeStyle.resultPanelText());
		resultContianer.add(blankHtml);
		resultContianer.add(answerWrongImagePanel);
		resultContianer.add(answerOptiontext);
		resultPanel.add(resultContianer);
		resultPanel.setStyleName(oeStyle.resultPanel());
	}
}
