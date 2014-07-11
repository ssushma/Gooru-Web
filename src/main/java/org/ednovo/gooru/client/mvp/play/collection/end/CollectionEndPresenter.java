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



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.share.email.SummaryPageEmailShareUc;
import org.ednovo.gooru.client.service.PlayerAppServiceAsync;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.ContentReportDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class CollectionEndPresenter extends PresenterWidget<IsCollectionEndView> implements CollectionEndUiHandlers{
	@Inject
	private PlayerAppServiceAsync playerAppService;
	
    private CollectionDo collectionDo=null;
    
    private CollectionPlayerPresenter collectionPlayerPresenter=null;
	
    /**
	 * @return the collectionPlayerPresenter
	 */
	public CollectionPlayerPresenter getCollectionPlayerPresenter() {
		return collectionPlayerPresenter;
	}

	/**
	 * @param collectionPlayerPresenter the collectionPlayerPresenter to set
	 */
	public void setCollectionPlayerPresenter(
			CollectionPlayerPresenter collectionPlayerPresenter) {
		this.collectionPlayerPresenter = collectionPlayerPresenter;
	}
	
	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);

	@Inject
	public CollectionEndPresenter(EventBus eventBus, IsCollectionEndView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	public void showCollectionEndPreview(CollectionDo collectionDo,Map<String,AttemptedAnswersDo> attemptedAnswerMap){
		  this.collectionDo=collectionDo;
		showShareWidget(collectionDo,collectionDo.getGooruOid());
		getView().showSummaryQuestionView(collectionDo,attemptedAnswerMap);
		getView().setCollectionEndTime(getCollectionEndDate(),getUserSpentTimeOnCollection());
		if(!AppClientFactory.isAnonymous()){
			getContentReport(collectionDo.getGooruOid());
		}
	}
	
	public void showShareWidget(final CollectionDo collectionDo,String collectionId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", AppClientFactory.getPlaceManager()
				.getCurrentPlaceRequest().getNameToken());
		params.put("shareType", "share");
		 AppClientFactory.getInjector().getSearchService().getShortenShareUrl(collectionId,params, new SimpleAsyncCallback<Map<String,String>>() {
				@Override
				public void onSuccess(Map<String, String> result) {
					getView().showShareWidget(collectionDo,result);
				}
			});
	}
	@Override
	public void sendEmail(String fromEmail, final String toEmail, String copyEmail,String subject, String message) {
		AppClientFactory.getInjector().getPlayerAppService().sendEmail(fromEmail, toEmail, copyEmail, subject, message, new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				getView().hideSendEmailPopup(toEmail);
			}
		});
		
	}
	
	@Override
	public void generatePdf(String innerHtml, String completedDateTime,final String fromEmail) {
		AppClientFactory.getInjector().getPlayerAppService().generatePdf(innerHtml,completedDateTime,new SimpleAsyncCallback<String>(){
			@Override
			public void onSuccess(String result) {
				String pdfUrl= result!=null?result:"";
				SummaryPageEmailShareUc summaryPageEmailShareUc = new SummaryPageEmailShareUc(fromEmail,pdfUrl);
				summaryPageEmailShareUc.show();
				summaryPageEmailShareUc.center();
			}
		});
	}
	
	public void updateFlagImageOnEndView(){
		getContentReport(collectionDo.getGooruOid());
	}

	@Override
	public void getContentReport(String collectionId) {
		playerAppService.getContentReport(collectionId, AppClientFactory.getGooruUid(), new SimpleAsyncCallback<ArrayList<ContentReportDo>>() {
			@Override
			public void onSuccess(ArrayList<ContentReportDo> result) {
				if(result.size()==0){
					getView().getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagBlackImage());
					getView().getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagOrange());
					getView().getFlagButton().setText(i18n.GL0556());
					
				}else{
					getView().getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagBlackImage());
					getView().getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionplayerEndFlagOrange());
					getView().getFlagButton().setText(i18n.GL0557());
				}
			}
		});
	}
	
	
	public String getCollectionEndDate(){
		return collectionPlayerPresenter!=null?collectionPlayerPresenter.getCollectionEndDate():"";
	}
	
	public String getUserSpentTimeOnCollection(){
		return collectionPlayerPresenter!=null?collectionPlayerPresenter.getUserSpentTimeOnCollection():"";
	}
	
	
}
