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

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionHintsDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class QuestionResourceView extends BaseViewWithHandlers<QuestionResourceUiHandlers> implements IsQuestionResourceView{
	
	@UiField HTMLPanel openEndedQuestionText,explanationContainer;
	@UiField Image openEndedQuestionImage;
	@UiField Button hintsButton,explanaionButton;
	@UiField FlowPanel hintsContainer,answerOptionsContainer,questionContainer;
	@UiField QuestionStyleResource oeStyle;
	private CollectionItemDo collectionItemDo;
	private int hintsLength=0;
	
	private static QuestionResourceViewUiBinder uiBinder = GWT.create(QuestionResourceViewUiBinder.class);

	interface QuestionResourceViewUiBinder extends UiBinder<Widget, QuestionResourceView> {
		
	}
	
	@Inject
	public QuestionResourceView(){
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void showQuestionPreview(CollectionItemDo collectionItemDo){
		this.collectionItemDo=collectionItemDo;
		renderQuestionView();
		renderAnswerView();
	}
	
	private void renderQuestionView(){
		hintsLength=0;
		openEndedQuestionText.add(getHTML(collectionItemDo.getResource().getQuestionText()));
		if(collectionItemDo.getResource().getHints().size()>0){
			hintsButton.setText("Hints ("+collectionItemDo.getResource().getHints().size()+" Left)");
		}else{
			hintsButton.setStyleName(oeStyle.hintsInActiveButton());
		}
		if(collectionItemDo.getResource().getExplanation()!=null && collectionItemDo.getResource().getExplanation().trim().length()>0){
		}
		else{
			explanaionButton.setStyleName(oeStyle.hintsInActiveButton());
		}
		openEndedQuestionImage.setUrl(getQuestionImage());
	}
	private void renderAnswerView(){
		answerOptionsContainer.clear();
		if(collectionItemDo.getResource().getType()==1||collectionItemDo.getResource().getType()==3){
			answerOptionsContainer.add(new MultipleChoicesQuestionWidget(collectionItemDo));
		}else if(collectionItemDo.getResource().getType()==6){
			answerOptionsContainer.add(new OpendEndedQuestionWidget());
		}
		else if(collectionItemDo.getResource().getType()==4){
			answerOptionsContainer.add(new FillIntheBlankQuestionView(collectionItemDo));
		}
	}
	@UiHandler("hintsButton")
	public void ClickOnHintButton(ClickEvent clickEvent){
		if(hintsButton.getStyleName().equals(oeStyle.hintsActiveButton())){
			if(collectionItemDo.getResource().getHints().size()>hintsLength){
				startHintDataLogEvent(getQuestionHintsDo(hintsLength).getHintId());
				hintsContainer.add(getHTML(getQuestionHintsDo(hintsLength).getHintText(),oeStyle.hintsText()));
				hintsButton.setText("Hints ("+((collectionItemDo.getResource().getHints().size()-hintsLength)-1)+" Left)");
				hintsLength++;
				if(collectionItemDo.getResource().getHints().size()==hintsLength){
					hintsButton.setStyleName(oeStyle.hintsInActiveButton());
				}
			}else{
				hintsButton.setStyleName(oeStyle.hintsInActiveButton());
			}
		}
	}
	public QuestionHintsDo getQuestionHintsDo(int hintPosition){
		TreeSet<QuestionHintsDo> questionHintsList=collectionItemDo.getResource().getHints();
		Iterator<QuestionHintsDo> it = questionHintsList.iterator();
		int i = 0;
		QuestionHintsDo currentQuestionHintsDo= null;
		while(it.hasNext()) {
			if(i==hintPosition){
				currentQuestionHintsDo = it.next();
				return currentQuestionHintsDo;
			}
		   i++;
		}
		return currentQuestionHintsDo;
	}
	@UiHandler("explanaionButton")
	public void ClickOnExplanationButton(ClickEvent clickEvent){
		if(explanaionButton.getStyleName().equals(oeStyle.hintsActiveButton())){
			explanationContainer.add(getHTML(collectionItemDo.getResource().getExplanation()));
			explanationContainer.addStyleName(oeStyle.explanationTextBorder());
			explanaionButton.setStyleName(oeStyle.hintsInActiveButton());
			startExplanationDataLogEvent();
		}
	}
	@UiHandler("openEndedQuestionImage")
	public void defaultQuesoinImage(ErrorEvent event){
		openEndedQuestionImage.getElement().removeAttribute("src");
	}
	private HTML getHTML(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		HTML contentHtml=new HTML(html);
		contentHtml.setStyleName("");
		return contentHtml;
	}
	private HTML getHTML(String html,String styleName){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		HTML contentHtml=new HTML(html);
		contentHtml.setStyleName(styleName);
		return contentHtml;
	}
	
	@Override
	public void resetQuestionView() {
		openEndedQuestionText.clear();
		hintsButton.setText("Hints (0 Left)");
		hintsButton.setStyleName(oeStyle.hintsActiveButton());
		explanaionButton.setStyleName(oeStyle.hintsActiveButton());
		explanationContainer.removeStyleName(oeStyle.explanationTextBorder());
		hintsContainer.clear();
		explanationContainer.clear();
		answerOptionsContainer.clear();
		openEndedQuestionImage.getElement().removeAttribute("src");
	}
	private String getQuestionImage(){
		String thumbnailImage="";
		String assetName="";
		try{
			if(collectionItemDo.getResource().getAssets()!=null&&collectionItemDo.getResource().getAssets().size()>0){
				assetName=collectionItemDo.getResource().getAssets().get(0).getAsset().getName();
				thumbnailImage=collectionItemDo.getResource().getAssetURI()+collectionItemDo.getResource().getFolder()+assetName;
			}else{
				thumbnailImage=collectionItemDo.getResource().getThumbnails().getUrl();
			}
		}catch(Exception e){
			
		}
		return thumbnailImage;
	}
	
	public void startHintDataLogEvent(int hintId) {
		getUiHandlers().startHintDataLogEvent(hintId);
	}

	public void startExplanationDataLogEvent() {
		getUiHandlers().startExplanationDataLogEvent();
	}
	
	public class MultipleChoicesQuestionWidget extends MultipleChoicesQuestionView{
		
		public MultipleChoicesQuestionWidget(CollectionItemDo collectionItemDo){
			super(collectionItemDo);
		}
		@Override
		public void createSessionItemAttempt(int answerId,String answerAttemptStatus) {
			getUiHandlers().createSessionItemAttempt(answerId, answerAttemptStatus);	
		}
		public void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo){
			getUiHandlers().setAttemptStatus(collectionItemId, attemptAnswerDo);
		}
		public void setAnswerAttemptSequence(int attemptSequence,int attemptStatus, int answerId) {
			getUiHandlers().setAnswerAttemptSequence(attemptSequence, attemptStatus, answerId);
		}
	}
	
	public class OpendEndedQuestionWidget extends OpendEndedQuestionView{
		public OpendEndedQuestionWidget(){
			super();
		}
		public void createSesstionItemAttemptOe(String answerText){
			getUiHandlers().createSesstionItemAttemptOe(answerText);
		}
		public void setAttemptStatus(String collectionItemId,AttemptedAnswersDo attemptAnswerDo){
			attemptAnswerDo.setQuestionType(collectionItemDo.getResource().getType());
			getUiHandlers().setAttemptStatus(collectionItemDo.getCollectionItemId(), attemptAnswerDo);
		}
		public void setOeQuestionAnswerText(String answerText) {
			getUiHandlers().setOeQuestionAnswerText(answerText);
		}
		public void saveOeQuestionAnswerDataLogEvent() {
			getUiHandlers().saveOeQuestionAnswerDataLogEvent();
		}
	}
}
