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
package org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual;
import java.util.ArrayList;

import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.OetextDataDO;
import org.ednovo.gooru.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class CollectionSummaryIndividualPresenter extends PresenterWidget<IsCollectionSummaryIndividualView> implements CollectionSummaryIndividualUiHandlers{
	@Inject
	private  AnalyticsServiceAsync analyticService;
	
	private String collectionId,classpageId,pathwayId,userId,sessionId;
	private boolean isSummary;
	ClasspageItemDo classpageItemDo=null;
	
	@Inject
	public CollectionSummaryIndividualPresenter(EventBus eventBus, IsCollectionSummaryIndividualView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}

	@Override
	public void setIndividualData(String collectionId,String classpageId,String userId,String sessionId,String pathwayId,boolean isSummary,final HTMLPanel loadingImage,final PrintUserDataDO printUserDataDO) {
		this.pathwayId=pathwayId;
		this.classpageId=classpageId;
		this.collectionId=collectionId;
		this.userId=userId;
		this.sessionId=sessionId;
		this.isSummary=isSummary;
		this.analyticService.getCollectionMetaDataByUserAndSession(collectionId, classpageId,userId, sessionId, new AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>>() {
			
			@Override
			public void onSuccess(ArrayList<CollectionSummaryMetaDataDo> result) {
				getView().setIndividualCollectionMetaData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			
			}
		});
		this.analyticService.getUserSessionDataByUser(collectionId, classpageId,userId, sessionId, pathwayId,new AsyncCallback<ArrayList<UserDataDo>>() {
			
			@Override
			public void onSuccess(ArrayList<UserDataDo> result) {
				getView().setIndividualData(result,loadingImage);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualUiHandlers#setHtmltopdf(java.lang.String, boolean)
	 */
	@Override
	public void setHtmltopdf(String htmlString,String fileName,final boolean isClickedOnEmail) {
		this.analyticService.setHTMLtoPDF(htmlString,fileName,isClickedOnEmail, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {

	
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	@Override
	public void setOEtextData(final String resourceGooruId, final String questionType) {
		this.analyticService.getOETextData(resourceGooruId, collectionId, classpageId, pathwayId,"CS",sessionId,userId, new AsyncCallback<ArrayList<OetextDataDO>>() {
			@Override
			public void onSuccess(ArrayList<OetextDataDO> result) {
				getView().setViewResponseData(result,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary,sessionId);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	@Override
	public void setTeacherImage(ClasspageItemDo classpageItemDo){
      this.classpageItemDo=classpageItemDo;
	}
	@Override
	public void clearFrame(){
		//getView().getFrame().setUrl("");
	}
	@Override
	public void setNoDataMessage(HTMLPanel loadingImage) {
		loadingImage.setVisible(false);
	//	getView().setErrorMessage();
	}
}
