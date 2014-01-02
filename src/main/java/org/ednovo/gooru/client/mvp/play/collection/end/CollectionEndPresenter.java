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

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class CollectionEndPresenter extends PresenterWidget<IsCollectionEndView> implements CollectionEndUiHandlers{
	
	@Inject
	public CollectionEndPresenter(EventBus eventBus, IsCollectionEndView view) {
		super(eventBus, view);
	}
	
	public void showCollectionEndPreview(CollectionDo collectionDo,Map<String,AttemptedAnswersDo> attemptedAnswerMap){
		showShareWidget(collectionDo,collectionDo.getGooruOid());
		getView().showSummaryQuestionView(collectionDo,attemptedAnswerMap);
	}
	
	public void showShareWidget(final CollectionDo collectionDo,String collectionId){
		 AppClientFactory.getInjector().getPlayerAppService().getShortenShareUrl(collectionId, new SimpleAsyncCallback<Map<String,String>>() {
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
}
