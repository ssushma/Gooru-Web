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
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.player.AnswerAttemptDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
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

public abstract class OpendEndedQuestionView extends Composite implements MessageProperties{
	
	@UiField HTMLPanel answetTextAfterSubmission,answertext;
	@UiField Button submitButton;
	@UiField TextArea openEndedAnswerTextArea;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label submittedText,errorMessageText,messageBodyText;
	private static final String ERROR_MESSAGE=GL1458+GL_SPL_FULLSTOP;
	private static final String EMPTY_ERROR_MESSAGE=GL1459+GL_SPL_FULLSTOP;
	private static final String OPEN_ENDED_BODY_TEXT=GL1460;
	private String answerText="";
	private CollectionItemDo collectionItemDo;
	private static OpendEndedQuestionViewUiBinder uiBinder = GWT.create(OpendEndedQuestionViewUiBinder.class);

	interface OpendEndedQuestionViewUiBinder extends UiBinder<Widget, OpendEndedQuestionView> {
		
	}
	
	@Inject
	public OpendEndedQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswerDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo=collectionItemDo;
		setQuestionTypeCaption();
		answertext.getElement().setInnerHTML(GL0665);
		submitButton.setText(GL0666);
		showPreviousAttemptResult(attemptedAnswerDo);
	}
	
	public void setQuestionTypeCaption(){
		messageBodyText.setText(OPEN_ENDED_BODY_TEXT);
	}
	
	public void showPreviousAttemptResult(AttemptedAnswersDo attemptedAnswerDo){
		if(attemptedAnswerDo!=null){
			openEndedAnswerTextArea.setValue(attemptedAnswerDo.getAnswersText());
		}
	}
	
	@UiHandler("openEndedAnswerTextArea")
	public void onKeypressTextArea(KeyUpEvent event){
		answerText=openEndedAnswerTextArea.getValue();
		setOeQuestionAnswerText(answerText);
		//saveOeAnswerData();
		 if(answerText!=null){
			 if(answerText.trim().length()>=1000){
				 errorMessageText.setText(ERROR_MESSAGE);
				 event.preventDefault();
			 }else{
				 errorMessageText.setText("");
			 }
			 if(answerText.length()>0){
				 isOeAnswerSubmited(false);
			 }else{
				 isOeAnswerSubmited(true);
			 }
		 }
		 isUserAnswerAttempted(true);
	}
	
	@UiHandler("submitButton")
	public void clickOnSubmitButton(ClickEvent clickEvent){
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_PLAY)){
			MixpanelUtil.ClickOpenEndedQuestionSubmitButtonFromCollectionPlayer();
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_PLAY)){
			MixpanelUtil.ClickOpenEndedQuestionSubmitButtonFromResourcePlayer();
		}
		
		 answerText=openEndedAnswerTextArea.getValue();
		 if(answerText!=null&&answerText.trim().length()>0){
			 if(answerText.trim().length()>1000){
				 errorMessageText.setText(ERROR_MESSAGE);
			 }else{
				 errorMessageText.setText("");
				 submitButton.removeFromParent();
				 submittedText.setText(GL1138);
				 //TODO answer submit API
				 showSubmitedText();
				 isOeAnswerSubmited(true);
			 }
		 }else{
			 errorMessageText.setText(EMPTY_ERROR_MESSAGE);
		 }
	}
	
	public void showSubmitedText(){
		submittedText.setText("");
		answetTextAfterSubmission.add(new HTML(openEndedAnswerTextArea.getValue()));
		createSesstionItemAttemptOe("",openEndedAnswerTextArea.getValue());
		saveOeAnswerData();
		openEndedAnswerTextArea.removeFromParent();
		increaseUserAttemptCount();
		userAnswerObject();
		saveOeQuestionAnswerDataLogEvent();
		triggerSaveOeAnswerTextDataEvent();
	}
	
	public void userAnswerObject(){
		List<AnswerAttemptDo> userAttemptedOptionsList=new ArrayList<AnswerAttemptDo>();
		AnswerAttemptDo answerAttemptDo=new AnswerAttemptDo();
		answerAttemptDo.setText(openEndedAnswerTextArea.getValue()); 
		answerAttemptDo.setAnswerId(0);
		answerAttemptDo.setOrder("");
		answerAttemptDo.setStatus("pending");
		userAttemptedOptionsList.add(answerAttemptDo);
		userAttemptedAnswerObject(userAttemptedOptionsList);
	}
	public void saveOeAnswerData(){
		AttemptedAnswersDo attempteAnswersDo=new AttemptedAnswersDo();
		attempteAnswersDo.setAnswersText(openEndedAnswerTextArea.getValue());
		attempteAnswersDo.setQuestionType(collectionItemDo.getResource().getType());
		setAttemptStatus(collectionItemDo.getCollectionItemId(),attempteAnswersDo);
	}
	public void createSesstionItemAttemptOeWhenNavigation(){
		createSesstionItemAttemptOe("",openEndedAnswerTextArea.getValue());
	}
	public abstract void createSesstionItemAttemptOe(String answerId,String answerText);
	public abstract void setAttemptStatus(String collecionItemId, AttemptedAnswersDo attempteAnswersDo);
	public abstract void setOeQuestionAnswerText(String answerText);
	public abstract void saveOeQuestionAnswerDataLogEvent();
	public void isUserAnswerAttempted(boolean isUserAttemptedResult){
	}
	public void triggerSaveOeAnswerTextDataEvent(){
		
	}
	public abstract void increaseUserAttemptCount();
	public void isOeAnswerSubmited(boolean isOeAnswerSubmited){
		
	}
	public abstract void userAttemptedAnswerObject(List<AnswerAttemptDo> userAttemptedOptionsList);
}
