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
package org.ednovo.gooru.client.mvp.analytics.collectionProgress;
import java.util.ArrayList;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.service.AnalyticsServiceAsync;
import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class CollectionProgressPresenter extends PresenterWidget<IsCollectionProgressView> implements CollectionProgressUiHandlers{
	@Inject
	private  AnalyticsServiceAsync analyticService;
	@Inject
	public CollectionProgressPresenter(EventBus eventBus, IsCollectionProgressView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
	}

	@Override
	public void setCollectionProgressData(String collectionId,String pathwayId) {
		String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		this.analyticService.getCollectionProgressData(collectionId,classpageId,pathwayId,new AsyncCallback<ArrayList<CollectionProgressDataDo>>() {
					
					@Override
					public void onSuccess(ArrayList<CollectionProgressDataDo> result) {
						getView().setData(result);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						
					}
				});
	}

	public AnalyticsServiceAsync getAnalyticService() {
		return analyticService;
	}

	public void setAnalyticService(AnalyticsServiceAsync analyticService) {
		this.analyticService = analyticService;
	}
}
