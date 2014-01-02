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

import java.util.Map;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.share.SocialShareWidget;
import org.ednovo.gooru.client.mvp.play.collection.share.email.CollectionEmailShareView;
import org.ednovo.gooru.client.mvp.play.collection.share.email.PrintSummaryPage;
import org.ednovo.gooru.client.mvp.play.collection.share.email.SentEmailSuccessVc;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import br.com.freller.tool.client.Print;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class CollectionEndView extends BaseViewWithHandlers<CollectionEndUiHandlers> implements IsCollectionEndView{
	
	@UiField HTMLPanel summaryQuestionsContainer,ftmSummaryPageContainer;
	
	@UiField Label emailButton, printButton;
	
	@UiField TextBox collectionPlayerSummaryShareTextBox;
	
	private String originalUrl=null,shareBitlyUrl=null;
	
	private CollectionDo collectionDo=null;
	
	private Map<String,AttemptedAnswersDo> attemptedAnswerMap=null;
	
	private CollectionEmailShareView emailShareView;
	
	private static CollectionEndViewUiBinder uiBinder = GWT.create(CollectionEndViewUiBinder.class);

	interface CollectionEndViewUiBinder extends UiBinder<Widget, CollectionEndView> {
		
	}
	
	@Inject
	public CollectionEndView(){
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("printButton")
	public void printSummaryPage(ClickEvent event){
		PrintSummaryPage printSummarayPageView=new PrintSummaryPage(collectionDo, "", shareBitlyUrl, attemptedAnswerMap, "");
		Print.it(printSummarayPageView.getElement().getInnerHTML());
	}
		
	public void showSummaryQuestionView(CollectionDo collectionDo,Map<String,AttemptedAnswersDo> attemptedAnswerMap){
		ftmSummaryPageContainer.clear();
		if(collectionDo!=null){
			this.collectionDo=collectionDo;
			this.attemptedAnswerMap=attemptedAnswerMap;
			summaryQuestionsContainer.clear();
			for(int i=0;i<collectionDo.getCollectionItems().size();i++){
				CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
				if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
					AttemptedAnswersDo attemptedAnswersDo=attemptedAnswerMap.get(collectionItemDo.getCollectionItemId());
					SummaryQuestionView summaryQuestionView=new SummaryQuestionView(collectionItemDo,attemptedAnswersDo);
					summaryQuestionsContainer.add(summaryQuestionView);
				}
			}
		}
	}
	
	@Override
	public void showShareWidget(final CollectionDo collectionDo,Map<String, String> collectionShare) {
		shareBitlyUrl=collectionShare.get("sharebitlyurl");
		originalUrl=collectionShare.get("shareurl");
		SocialShareWidget swidget= new SocialShareWidget() {
			@Override
			public void onTwitter() {
				Window.open("http://twitter.com/intent/tweet?text=" + "Gooru - "+collectionDo.getTitle().replaceAll("\\+", "%2B") +": " + shareBitlyUrl, "_blank", "width=600,height=300");
			}
			
			@Override
			public void onFacebook() {
				Window.open(
						"http://www.facebook.com/sharer/sharer.php?s=100&p[url]="
								+ originalUrl + "&p[images][0]="
								+collectionDo.getThumbnailUrl() + "&p[title]="
								+collectionDo.getTitle().replaceAll("\\+", "%2B")+ "&p[summary]=" +collectionDo.getGoals(),
								"_blank", "width=626,height=436");
			}

			@Override
			public void onEmail() {
				String emailSubject="Gooru - "+collectionDo.getTitle();
				String emailDescription= collectionDo.getTitle()+"<div><br/></div><div>"+shareBitlyUrl+"</div><div><br/></div><div>Sent using Gooru. Visit http://www.goorulearning.org/ for more great resources and collections. It's free!</div>";
				 emailShareView=new CollectionEmailShareView(emailSubject, emailDescription){
					@Override
					public void sendEmail(String fromEmail, String toEmail,
							String copyEmail, String subject, String message) {
						getUiHandlers().sendEmail( fromEmail,  toEmail, copyEmail,  subject,  message);
					}
				};
				emailShareView.show();
			}
		};
		collectionPlayerSummaryShareTextBox.setText(originalUrl);
		ftmSummaryPageContainer.add(swidget);
		
	}
	@Override
	public void hideSendEmailPopup(String toEmail){
		emailShareView.hide();
		new SentEmailSuccessVc(toEmail);
	}	

}
