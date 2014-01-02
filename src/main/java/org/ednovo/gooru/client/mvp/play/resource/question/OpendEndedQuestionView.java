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



import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public abstract class OpendEndedQuestionView extends Composite{
	
	@UiField HTMLPanel answetTextAfterSubmission;
	@UiField Button submitButton;
	@UiField TextArea openEndedAnswerTextArea;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label submittedText,errorMessageText,messageBodyText;
	private static final String ERROR_MESSAGE="Character limit is reached.";
	private static final String EMPTY_ERROR_MESSAGE="Answer text should not be empty.";
	private static final String OPEN_ENDED_BODY_TEXT="Please type your answer in the field below, and click the \"Save\" button to save your response when you're done.";
	private String answerText="";
	private static OpendEndedQuestionViewUiBinder uiBinder = GWT.create(OpendEndedQuestionViewUiBinder.class);

	interface OpendEndedQuestionViewUiBinder extends UiBinder<Widget, OpendEndedQuestionView> {
		
	}
	
	@Inject
	public OpendEndedQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
		setQuestionTypeCaption();
	}
	
	public void setQuestionTypeCaption(){
		messageBodyText.setText(OPEN_ENDED_BODY_TEXT);
	}
	
	@UiHandler("openEndedAnswerTextArea")
	public void onKeypressTextArea(KeyPressEvent event){
		answerText=openEndedAnswerTextArea.getValue();
		setOeQuestionAnswerText(answerText);
		 if(answerText!=null){
			 if(answerText.trim().length()>=1000){
				 errorMessageText.setText(ERROR_MESSAGE);
				 event.preventDefault();
			 }else{
				 errorMessageText.setText("");
			 }
		 }
	}
	
	@UiHandler("submitButton")
	public void clickOnSubmitButton(ClickEvent clickEvent){
		 answerText=openEndedAnswerTextArea.getValue();
		 if(answerText!=null&&answerText.trim().length()>0){
			 if(answerText.trim().length()>1000){
				 errorMessageText.setText(ERROR_MESSAGE);
			 }else{
				 errorMessageText.setText("");
				 submitButton.removeFromParent();
				 submittedText.setText("saving...");
				 //TODO answer submit API
				 showSubmitedText();
				 
			 }
		 }else{
			 errorMessageText.setText(EMPTY_ERROR_MESSAGE);
		 }
	}
	
	public void showSubmitedText(){
		submittedText.setText("");
		openEndedAnswerTextArea.removeFromParent();
		answetTextAfterSubmission.add(new HTML(openEndedAnswerTextArea.getValue()));
		createSesstionItemAttemptOe(openEndedAnswerTextArea.getValue());
		AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
		attempteAnswersDo.setAnswersText(openEndedAnswerTextArea.getValue());
		setAttemptStatus(null,attempteAnswersDo);
		saveOeQuestionAnswerDataLogEvent();
	}
	
	public abstract void createSesstionItemAttemptOe(String answerText);
	public abstract void setAttemptStatus(String collecionItemId, AttemptedAnswersDo attempteAnswersDo);
	public abstract void setOeQuestionAnswerText(String answerText);
	public abstract void saveOeQuestionAnswerDataLogEvent();
	
}
