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
import java.util.Map;
import java.util.TreeSet;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract  class HotTextAnswersQuestionView extends Composite{
	
	@UiField Button checkAnswer;
	@UiField FlowPanel optionsContainerFpnl;
	 HTAnswerDragPanelVc optionsContainer;
	@UiField QuestionStyleResource oeStyle;
	@UiField Label messageBodyText;
	@UiField HTMLPanel answerText,answerContainer;
	private boolean isCheckButtonEnabled=true;
	
	private boolean isChekcAnswerButtonClicked=false;
	
	private CollectionItemDo collectionItemDo;
	
	private AttemptedAnswersDo attemptedAnswerDo=null;
	
	 String regex = "["; 
	
	private static HotTextAnswersQuestionViewUiBinder uiBinder = GWT.create(HotTextAnswersQuestionViewUiBinder.class);

	interface HotTextAnswersQuestionViewUiBinder extends UiBinder<Widget, HotTextAnswersQuestionView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public HotTextAnswersQuestionView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public HotTextAnswersQuestionView(CollectionItemDo collectionItemDo,AttemptedAnswersDo attemptedAnswerDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		this.collectionItemDo=collectionItemDo;
		this.attemptedAnswerDo=attemptedAnswerDo;
		setQuestionTypeCaption();
		
		answerText.getElement().setInnerHTML(i18n.GL0665());
		checkAnswer.setText(i18n.GL0666());
	}
	
	private void setQuestionTypeCaption(){
		messageBodyText.setText(i18n.GL1457()+i18n.GL_SPL_FULLSTOP());
		answerContainer.getElement().setId("answerContainerPnl");
		optionsContainerFpnl.clear();
		if(collectionItemDo!=null && collectionItemDo.getResource()!=null && collectionItemDo.getResource().getAnswers()!=null && collectionItemDo.getResource().getType()==9){
		optionsContainer=new HTAnswerDragPanelVc();
		optionsContainerFpnl.add(optionsContainer);
		Label label = new Label("");
		label.setStyleName("dragDropSpacer");
		optionsContainer.superAdd(label);
		Label toplabel = new Label("");
		toplabel.setStyleName("dragDropSpacer");
		optionsContainer.add(toplabel);
		}
		renderQuestionAnswerOptions();
	}
	
	private void renderQuestionAnswerOptions(){
		
		if(collectionItemDo!=null && collectionItemDo.getResource()!=null && collectionItemDo.getResource().getAnswers()!=null){
			TreeSet<QuestionAnswerDo> answersSet=collectionItemDo.getResource().getAnswers();
			Iterator<QuestionAnswerDo> answersList=answersSet.iterator();
			int i=0;
			while (answersList.hasNext()) {
				
				if(collectionItemDo.getResource().getType()==8){
					QuestionAnswerDo questionAnswerDo=answersList.next();
					String text=questionAnswerDo.getAnswerText();
					if(text.contains("[")){
						text=text.replaceAll("\\[", "").replaceAll("\\]","");
				}
					String[] temp;
					 temp = text.split(" ");
					for(int k=0;k<temp.length;k++){
						final HTML lbl=new HTML(temp[k]+" ");
						lbl.addStyleName("htPlayerAns");
						lbl.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								
								if(lbl.getElement().getStyle().getBackgroundColor().equalsIgnoreCase("rgb(142, 204, 142)")){
									lbl.getElement().getStyle().clearBackgroundColor();
								}else{
								
								lbl.getElement().getStyle().setBackgroundColor("#8ecc8e");
								}
								enableCheckAnswerButton();
							}
						});
						
						
						optionsContainerFpnl.add(lbl);
					}
				}else{
					QuestionAnswerDo questionAnswerDo=answersList.next();
					
					HTAnswerChoiceOptionView htAnswerOptionView=new HTAnswerChoiceOptionView(questionAnswerDo.getAnswerText(),("(" + (char) (65 + i) + ") "));
				    /*htAnswerOptionView.setAnswerId(questionAnswerDo.getAnswerId());
					htAnswerOptionView.setAnswerCorrect(questionAnswerDo.isIsCorrect());*/
					int k=i+1;
					optionsContainer.addDraggable(htAnswerOptionView,k);
					//showPreviousResult(questionAnswerDo.getAnswerId(),htAnswerOptionView);
					i++;
				}
			}
		}
		
	}
	public void showPreviousResult(int answerId,HTAnswerChoiceOptionView htAnswerOptionView){
		if(attemptedAnswerDo!=null){
		 Map<Integer,Boolean> answerOptionCount=attemptedAnswerDo.getAnswerOptionResult();
			 if(answerOptionCount.containsKey(answerId) && answerOptionCount.get(answerId)!=null){
					if(answerOptionCount.get(answerId)){
						if(htAnswerOptionView.isAnswerCorrect()){
							htAnswerOptionView.getElement().getStyle().setBackgroundColor("#ddd");
						}else{
							htAnswerOptionView.getElement().getStyle().setBackgroundColor("red");
						}
					}else{
						if(!htAnswerOptionView.isAnswerCorrect()){
							htAnswerOptionView.getElement().getStyle().setBackgroundColor("#ddd");
						}else{
							htAnswerOptionView.getElement().getStyle().setBackgroundColor("red");
						}
					}
			 }
		}
	}
	
	
	@UiHandler("checkAnswer")
	public void checkButtonClickEvent(ClickEvent event){
		if(isCheckButtonEnabled){
			//showCorrectResult();
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName("primary");
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}
	}
	
	private void enableCheckAnswerButton(){
		boolean isOptionSelected=false;
		
		for(int i=0;i<optionsContainerFpnl.getWidgetCount();i++){
			
			HTML widget=(HTML) optionsContainerFpnl.getWidget(i);
			
			if(widget.getElement().getStyle().getBackgroundColor().equalsIgnoreCase("rgb(142, 204, 142)")){
				isOptionSelected=true;
			}
		}
			
			
		if(isOptionSelected){
			isCheckButtonEnabled=true;
			checkAnswer.removeStyleName(oeStyle.hintsInActiveButton());
			checkAnswer.addStyleName("primary");
		}else{
			isCheckButtonEnabled=false;
			checkAnswer.removeStyleName("primary");
			checkAnswer.addStyleName(oeStyle.hintsInActiveButton());
		}
	}
	
	
	
}
