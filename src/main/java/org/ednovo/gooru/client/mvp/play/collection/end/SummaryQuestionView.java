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


import java.util.Iterator;
import java.util.TreeSet;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
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

public class SummaryQuestionView extends Composite{
	
	@UiField HTML questionText,questionExplanation;
	@UiField HTMLPanel questionAnswerContainer;
	@UiField Label questionSerialNum;
	@UiField Image questionThumbnail;
	private CollectionItemDo collectionItemDo=null;
	private AttemptedAnswersDo attemptedAnswersDo=null;
	
	private static SummaryQuestionViewUiBinder uiBinder = GWT.create(SummaryQuestionViewUiBinder.class);

	interface SummaryQuestionViewUiBinder extends UiBinder<Widget, SummaryQuestionView> {
		
	}
	
	public SummaryQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public SummaryQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswersDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.collectionItemDo=collectionItemDo;
		this.attemptedAnswersDo=attemptedAnswersDo;
		renderSummaryQuestionView();
	}
	
	protected void renderSummaryQuestionView(){
		questionText.setHTML("Q:"+removeHtmlTags(collectionItemDo.getResource().getQuestionText()));
		questionExplanation.setHTML(removeHtmlTags(collectionItemDo.getResource().getExplanation()));
		questionSerialNum.setText(""+collectionItemDo.getItemSequence());
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
					SummaryAnswerView summaryAnwerView=new SummaryAnswerView(questionAnserDo,sequenceNum,isUserAttempted);
					questionAnswerContainer.add(summaryAnwerView);
					sequenceNum++;
				}
			}
		}
	}
	
	@UiHandler("questionThumbnail")
	public void onErrorResourceImage(ErrorEvent errorEvent){
		questionThumbnail.setUrl("images/resource_trans.png");
		questionThumbnail.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault());
	}
	
	@Override
	public void onLoad(){
		questionThumbnail.setUrl(getQuestionImage());
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
	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}
		
}
