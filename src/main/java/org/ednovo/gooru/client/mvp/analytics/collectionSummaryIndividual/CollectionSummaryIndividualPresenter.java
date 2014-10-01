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
import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class CollectionSummaryIndividualPresenter extends PresenterWidget<IsCollectionSummaryIndividualView> implements CollectionSummaryIndividualUiHandlers{
	@Inject
	private  AnalyticsServiceAsync analyticService;
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
	public void setIndividualData(String collectionId,String classpageId,String userId,String sessionId,String pathwayId) {
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
				getView().setIndividualData(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}

	@Override
	public void setHtmltopdf(String htmlString) {
		this.analyticService.setHTMLtoPDF(htmlString, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
}
