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
package org.ednovo.gooru.client.mvp.assessments.play.collection.end;


import java.util.Iterator;
import java.util.TreeSet;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AssessmentsSummaryQuestionView extends Composite{

	@UiField HTML questionText,questionExplanation;
	@UiField HTMLPanel questionAnswerContainer;
	@UiField Label questionSerialNum;
	@UiField Image questionThumbnail;
	private CollectionItemDo collectionItemDo=null;
	private AttemptedAnswersDo attemptedAnswersDo=null;

//	private static final String FIB_SEPARATOR = i18n.GL0885;

	public boolean fibAnsIsCorrect=true;

	private static SummaryQuestionViewUiBinder uiBinder = GWT.create(SummaryQuestionViewUiBinder.class);

	interface SummaryQuestionViewUiBinder extends UiBinder<Widget, AssessmentsSummaryQuestionView> {

	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public AssessmentsSummaryQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiConstructor
	public AssessmentsSummaryQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswersDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.collectionItemDo=collectionItemDo;
		this.attemptedAnswersDo=attemptedAnswersDo;
		renderSummaryQuestionView();
		questionThumbnail.setUrl(getQuestionImage());
	}

	protected void renderSummaryQuestionView(){
		if(collectionItemDo.getResource().getType()==4){
			questionSerialNum.setText(""+collectionItemDo.getItemSequence());
			questionSerialNum.getElement().setAttribute("alt",""+collectionItemDo.getItemSequence());
			questionSerialNum.getElement().setAttribute("title",""+collectionItemDo.getItemSequence());

			if(attemptedAnswersDo!=null){
				String fibQuest = renderFibQuestion(attemptedAnswersDo);
				AssessmentsSummaryAnswerView summaryAnwerView=new AssessmentsSummaryAnswerView(fibQuest,fibAnsIsCorrect);
				questionAnswerContainer.add(summaryAnwerView);
			}else{
				questionText.setHTML(i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
				questionText.getElement().setAttribute("alt",i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
				questionText.getElement().setAttribute("title",i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
			}
			return;
		}
		questionText.setHTML(i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
		questionText.getElement().setAttribute("alt",i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
		questionText.getElement().setAttribute("title",i18n.GL0702()+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));

		questionExplanation.setHTML(removeHtmlTags(collectionItemDo.getResource().getExplanation()));
		questionExplanation.getElement().setAttribute("alt",removeHtmlTags(collectionItemDo.getResource().getExplanation()));
		questionExplanation.getElement().setAttribute("title",removeHtmlTags(collectionItemDo.getResource().getExplanation()));

		questionSerialNum.setText(""+collectionItemDo.getItemSequence());
		questionSerialNum.getElement().setAttribute("alt",""+collectionItemDo.getItemSequence());
		questionSerialNum.getElement().setAttribute("title",""+collectionItemDo.getItemSequence());
		if(collectionItemDo.getResource().getType()==1||collectionItemDo.getResource().getType()==3){
			if(collectionItemDo.getResource().getAnswers().size()>0){
				TreeSet<QuestionAnswerDo> answersList=collectionItemDo.getResource().getAnswers();
				Iterator<QuestionAnswerDo> answersListItr=answersList.iterator();
				int sequenceNum=0;
				while(answersListItr.hasNext()){
					QuestionAnswerDo questionAnserDo=answersListItr.next();
					boolean isUserAttempted=false;
					if(attemptedAnswersDo!=null){
						if(attemptedAnswersDo.getAnswerId()==questionAnserDo.getAnswerId()){
							isUserAttempted=true;
						}
					}
					AssessmentsSummaryAnswerView summaryAnwerView=new AssessmentsSummaryAnswerView(questionAnserDo,sequenceNum,isUserAttempted);
					questionAnswerContainer.add(summaryAnwerView);
					sequenceNum++;
				}
			}
		}else if(collectionItemDo.getResource().getType()==6){
			if(attemptedAnswersDo!=null){
				if(attemptedAnswersDo.getAnswersText()!=null && !attemptedAnswersDo.getAnswersText().equals("")){
					AssessmentsSummaryAnswerView summaryAnwerView=new AssessmentsSummaryAnswerView(attemptedAnswersDo);
					questionAnswerContainer.add(summaryAnwerView);
				}
			}
		}
	}

	public String renderFibQuestion(AttemptedAnswersDo attemptedAnswersDo){
		String[] fibArray = this.collectionItemDo.getResource().getQuestionText().split(i18n.GL0885());
		String fibQuestionTxt = "";
		int j=0;
		int answerArraySize = this.collectionItemDo.getResource().getAnswers().size();
		for(int i = 0; i < fibArray.length; i++) {
			fibQuestionTxt = fibQuestionTxt + fibArray[i];
			if(i<answerArraySize) {
				String correctAnswer=getQuestionAnswerDo(j)!=null?getQuestionAnswerDo(j).getAnswerText():"";
				String enteredAnswer=attemptedAnswersDo.getFibAnswersList()[j];
				if(correctAnswer.equalsIgnoreCase(enteredAnswer)){
					fibQuestionTxt = fibQuestionTxt + "<span style=\"border-bottom:1px solid #515151\">"+enteredAnswer+"</span>";
				}else{
					fibAnsIsCorrect=false;
					fibQuestionTxt = fibQuestionTxt + "<span style=\"border-bottom:1px solid #515151;text-decoration: line-through;padding-right:10px\">"+enteredAnswer+"</span><span style=\"border-bottom:1px solid #515151\">"+correctAnswer+"</span>";
				}
				j++;
			}
		}
		return fibQuestionTxt;
//		questionText.setHTML(fibQuestionTxt);
	}

	@UiHandler("questionThumbnail")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		questionThumbnail.setUrl("images/resource_trans.png");
		questionThumbnail.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault());
		questionThumbnail.getElement().getStyle().setFloat(Float.LEFT);
	}

	@Override
	public void onLoad(){
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
			questionThumbnail.setUrl(getQuestionImage());
		}
	}
	private String getQuestionImage(){
		String thumbnailImage="images/questiondefault.png";
		String assetName="";
		try{
			if(collectionItemDo.getResource().getAssets()!=null&&collectionItemDo.getResource().getAssets().size()>0){
				assetName=collectionItemDo.getResource().getAssets().get(0).getAsset().getName();
				thumbnailImage=collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+assetName;
			}else{
				if(collectionItemDo.getResource().getThumbnails().getUrl()!=null)
				thumbnailImage=collectionItemDo.getResource().getThumbnails().getUrl();
			}
		}catch(Exception e){
			AppClientFactory.printSevereLogger("AssessmentsSummaryQuestionView : getQuestionImage : "+e.getMessage());
		}
		return thumbnailImage!=null?thumbnailImage:"images/questiondefault.png";
	}
	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}

	private QuestionAnswerDo getQuestionAnswerDo(int index){
		TreeSet<QuestionAnswerDo> answersList=this.collectionItemDo.getResource().getAnswers();
		Iterator<QuestionAnswerDo> answersIterator=answersList.iterator();
		QuestionAnswerDo questionAnswerDo=null;
		int i=0;
		while(answersIterator.hasNext()){
			questionAnswerDo=answersIterator.next();
			if(index==i){
				return questionAnswerDo;
			}
			i++;
		}
		return questionAnswerDo;
	}

	public void setId(){
		questionSerialNum.getElement().setId("lblQuestionSerialNum");
		questionThumbnail.getElement().setId("imgQuestionThumbnail");
		questionText.getElement().setId("htmlQuestionText");
		questionAnswerContainer.getElement().setId("pnlQuestionAnswerContainer");
		questionExplanation.getElement().setId("htmlQuestionExplanation");
	}
}
