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

import java.util.Date;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.share.SocialShareWidget;
import org.ednovo.gooru.client.mvp.play.collection.share.email.CollectionEmailShareView;
import org.ednovo.gooru.client.mvp.play.collection.share.email.PrintSummaryPage;
import org.ednovo.gooru.client.mvp.play.collection.share.email.SentEmailSuccessVc;
import org.ednovo.gooru.client.mvp.socialshare.SocialShareView;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import br.com.freller.tool.client.Print;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionEndView extends BaseViewWithHandlers<CollectionEndUiHandlers> implements IsCollectionEndView{
	
	@UiField HTMLPanel summaryQuestionsContainer,ftmSummaryPageContainer,collectionSummaryShareButtonImage;
	
	@UiField Label emailButton, printButton,flagButton,endLabelText,replayText,shareCollectionText,saveSummaryText;
	
	@UiField TextBox collectionPlayerSummaryShareTextBox;
	
	@UiField HTML resourceInfoSeparator;
	
	private String originalUrl=null,shareBitlyUrl=null,collectionEndDate="",userSpentTime="";
	
	private String encodeUrl;
	
	private CollectionDo collectionDo=null;
	
	private Map<String,AttemptedAnswersDo> attemptedAnswerMap=null;
	
	private CollectionEmailShareView emailShareView;
	
	private boolean enableSummuryContainer=false;
	
	@UiField HTMLEventPanel collectionReplayButtonImage,printElementContainer;
	
	private static final String SEPARATOR="|";
	
	private static CollectionEndViewUiBinder uiBinder = GWT.create(CollectionEndViewUiBinder.class);

	interface CollectionEndViewUiBinder extends UiBinder<Widget, CollectionEndView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@Inject
	public CollectionEndView(){
		setWidget(uiBinder.createAndBindUi(this));
		printElementContainer.setVisible(false);
		resourceInfoSeparator.setHTML(SEPARATOR);
		resourceInfoSeparator.getElement().setId("htmlResourceInfoSeparator");
		resourceInfoSeparator.getElement().setAttribute("alt",SEPARATOR);
		resourceInfoSeparator.getElement().setAttribute("title",SEPARATOR);
		  
		resourceInfoSeparator.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sourceSepartor());
		
		flagButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagBlackImage());
		flagButton.removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagOrange());
		flagButton.setText(i18n.GL0556());
		flagButton.getElement().setId("btnFlagButton");
		flagButton.getElement().setAttribute("alt",i18n.GL0556());
		flagButton.getElement().setAttribute("title",i18n.GL0556());
		
		endLabelText.setText(i18n.GL0596());
		endLabelText.getElement().setId("lblEndLabelText");
		endLabelText.getElement().setAttribute("alt",i18n.GL0596());
		endLabelText.getElement().setAttribute("title",i18n.GL0596());
		
		replayText.setText(i18n.GL0597());
		replayText.getElement().setId("lblReplayText");
		replayText.getElement().setAttribute("alt",i18n.GL0597());
		replayText.getElement().setAttribute("title",i18n.GL0597());
		
		shareCollectionText.setText(i18n.GL0598());
		shareCollectionText.getElement().setId("lblShareCollectionText");
		shareCollectionText.getElement().setAttribute("alt",i18n.GL0598());
		shareCollectionText.getElement().setAttribute("title",i18n.GL0598());
		
		saveSummaryText.setText(i18n.GL0599());
		saveSummaryText.getElement().setId("lblSaveSummaryText");
		saveSummaryText.getElement().setAttribute("alt",i18n.GL0599());
		saveSummaryText.getElement().setAttribute("title",i18n.GL0599());
		
		collectionReplayButtonImage.getElement().setId("epnlCollectionReplayButtonImage");
		collectionSummaryShareButtonImage.getElement().setId("pnlCollectionSummaryShareButtonImage");
		collectionPlayerSummaryShareTextBox.getElement().setId("txtCollectionPlayerSummaryShareTextBox");
		ftmSummaryPageContainer.getElement().setId("pnlFtmSummaryPageContainer");
		printElementContainer.getElement().setId("epnlPrintElementContainer");
		emailButton.getElement().setId("lblEmailButton");
		printButton.getElement().setId("lblPrintButton");
		summaryQuestionsContainer.getElement().setId("pnlSummaryQuestionsContainer");
	}
	
	@UiHandler("collectionReplayButtonImage")
	public void onClickReplay(ClickEvent clickEvent){ 
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid());
		AppClientFactory.getPlaceManager().revealPlace(false,request);
	}
	
	@UiHandler("emailButton")

	public void onClickEmailButton(ClickEvent clickEvent){
		MixpanelUtil.ClickEmailButtonFromSummaryPageInCollectionPlayer();
		PrintSummaryPage printSummarayPageView=new PrintSummaryPage(collectionDo, userSpentTime, shareBitlyUrl, attemptedAnswerMap, this.collectionEndDate);
		String innerHtml = printSummarayPageView.getElement().getInnerHTML();
		String fromEmail="";
		//innerHtml = innerHtml.replaceAll("\"", "\\\\\"");
		String pdfTitle = collectionDo.getTitle().replaceAll(" ", "");
		if(pdfTitle.length()>15) {
			pdfTitle = pdfTitle.substring(0, 14);
		}
		Date emailSentDate = new Date();
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("MM/dd/yyyy hh:mm a");
		String completedDateTime = dateTimeFormat.format(emailSentDate).toString();
		String[] splitDateTime = completedDateTime.split(" ");
		completedDateTime = pdfTitle+"_"+splitDateTime[0] +"_"+splitDateTime[1]+splitDateTime[2];
		completedDateTime = completedDateTime.replaceAll("/", ".");
		if(AppClientFactory.isAnonymous()){ 
			fromEmail="";
		}else{
			fromEmail=AppClientFactory.getLoggedInUser().getEmailId();
		}
		getUiHandlers().generatePdf(innerHtml, completedDateTime,fromEmail);
	}
	
	@UiHandler("printButton")
	public void printSummaryPage(ClickEvent event){
		MixpanelUtil.ClickPrintButtonFromSummaryPageInCollectionPlayer();
		PrintSummaryPage printSummarayPageView=new PrintSummaryPage(collectionDo, userSpentTime, shareBitlyUrl, attemptedAnswerMap, this.collectionEndDate);
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
					enableSummuryContainer=true;
				}
			}
		}
		if(enableSummuryContainer){
			printElementContainer.setVisible(true);

		}
	}
	
	@Override
	public void showShareWidget(final CollectionDo collectionDo,Map<String, String> collectionShare) {
		shareBitlyUrl=collectionShare.get("shortenUrl");
		originalUrl=collectionShare.get("decodeRawUrl");
		encodeUrl=collectionShare.get("rawUrl");
		SocialShareWidget swidget= new SocialShareWidget(collectionDo.getGoals(),collectionDo.getThumbnails().getUrl(),"collection") {
			@Override
			public void onTwitter() {
				Window.open("http://twitter.com/intent/tweet?text=" +i18n.GL0733()+" "+i18n.GL_GRR_Hyphen()+" "+collectionDo.getTitle().replaceAll("\\+", "%2B") +": " +URL.encodeComponent(originalUrl,true), "_blank", "width=600,height=300");
			}
			
			@Override
			public void onFacebook() {
				 SocialShareView.postOnFacebook(collectionDo.getTitle(),encodeUrl,getResourceDescription(),getThumbnailUrl());
			}

			@Override
			public void onEmail() {
				String emailSubject="Gooru - "+collectionDo.getTitle();
				String emailDescription= collectionDo.getTitle()+"<div><br/></div><div>"+originalUrl+"</div><div><br/></div><div>"+i18n.GL1429()+"</div>";
				 emailShareView=new CollectionEmailShareView(emailSubject, emailDescription){
					@Override
					public void sendEmail(String fromEmail, String toEmail,String copyEmail, String subject, String message) {
						getUiHandlers().sendEmail( fromEmail,  toEmail, copyEmail,  subject,  message);
					}

					@Override
					public void closeEmailPopup() {
						// TODO Auto-generated method stub
						
					}
				};
				emailShareView.show();
				
			
			}
		};
		
		collectionPlayerSummaryShareTextBox.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				collectionPlayerSummaryShareTextBox.setFocus(true);
				collectionPlayerSummaryShareTextBox.selectAll();
			}
		});
		
		collectionPlayerSummaryShareTextBox.setReadOnly(true);
		collectionPlayerSummaryShareTextBox.getElement().setAttribute("readOnly", "");
		collectionPlayerSummaryShareTextBox.setText(originalUrl);
		ftmSummaryPageContainer.add(swidget);
		
	}
	@Override
	public void hideSendEmailPopup(String toEmail){
		emailShareView.hide();
		new SentEmailSuccessVc(toEmail);
	}

	@Override
	public Label getFlagButton() {
		return flagButton;
	}
   @UiHandler("flagButton")
   public void onClickFlagButton(ClickEvent event)
   {
	   PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid()).with("view", "end").with("tab", "flag");
	    AppClientFactory.getPlaceManager().revealPlace(false,request,true);
   }

	@Override
	public void setCollectionEndTime(String collectionEndDate, String userSpentTime) {
		this.collectionEndDate=collectionEndDate;
		this.userSpentTime=userSpentTime;
	}
	

}
