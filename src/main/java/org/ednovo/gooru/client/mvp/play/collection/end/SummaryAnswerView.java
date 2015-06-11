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
package org.ednovo.gooru.client.mvp.play.collection.end;


import org.ednovo.gooru.application.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SummaryAnswerView extends Composite{
	
	@UiField Label questionAnswerChoice;
	@UiField HTML questionAnswerSequence,questionAnswerText;
	
	private static SummaryAnswerViewUiBinder uiBinder = GWT.create(SummaryAnswerViewUiBinder.class);

	interface SummaryAnswerViewUiBinder extends UiBinder<Widget, SummaryAnswerView> {
		
	}
	public SummaryAnswerView(){
		initWidget(uiBinder.createAndBindUi(this));
		setId();
	}
	
	@UiConstructor
	public SummaryAnswerView(String fibQuest,boolean fibAnsIsCorrect) { 
		initWidget(uiBinder.createAndBindUi(this));
		questionAnswerText.setHTML(removeHtmlTags(fibQuest));
		if(fibAnsIsCorrect){
			questionAnswerChoice.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
		}else{
			questionAnswerChoice.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
		}
		setId();
	}
	
	public SummaryAnswerView(AttemptedAnswersDo attemptedAnswersDo) { 
		initWidget(uiBinder.createAndBindUi(this));
		questionAnswerText.setHTML(removeHtmlTags(attemptedAnswersDo.getAnswersText()));
		setId();
	}
	@UiConstructor
	public SummaryAnswerView(QuestionAnswerDo questionAnserDo,int sequenceNum,boolean userAttempedStatus){
		initWidget(uiBinder.createAndBindUi(this));
		questionAnswerSequence.setText((char) (65 + sequenceNum)+")");
		questionAnswerSequence.getElement().setAttribute("alt",(char) (65 + sequenceNum)+")");
		questionAnswerSequence.getElement().setAttribute("title",(char) (65 + sequenceNum)+")");
		questionAnswerText.setHTML(removeHtmlTags(questionAnserDo.getAnswerText()));
		questionAnswerText.getElement().setAttribute("alt",removeHtmlTags(questionAnserDo.getAnswerText()));
		questionAnswerText.getElement().setAttribute("title",removeHtmlTags(questionAnserDo.getAnswerText()));
		if(userAttempedStatus){
			if(questionAnserDo.isIsCorrect()){
				questionAnswerChoice.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerRightIcon());
			}else{
				questionAnswerChoice.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().answerWronIcon());
			}	
		}
		setId();
	}
	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}
	public void setId(){
		questionAnswerChoice.getElement().setId("lblQuestionAnswerChoice");
		questionAnswerSequence.getElement().setId("htmlQuestionAnswerSequence");
		questionAnswerText.getElement().setId("htmlQuestionAnswerText");
	}
		
}
