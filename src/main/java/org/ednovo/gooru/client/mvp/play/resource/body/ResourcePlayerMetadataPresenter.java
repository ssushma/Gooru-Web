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
package org.ednovo.gooru.client.mvp.play.resource.body;


import org.ednovo.gooru.client.mvp.play.collection.CollectionPlayerPresenter;
import org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter;
import org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerPresenter;
import org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourcePlayerMetadataPresenter extends PresenterWidget<IsResourcePlayerMetadataView> implements ResourcePlayerMetadataUiHandlers{
	
	private QuestionResourcePresenter questionResourcePresenter;
	
	private CollectionEndPresenter collectionEndPresenter;
	
	private CollectionPlayerPresenter collectionPlayerPresenter;
	
	private ResourcePlayerPresenter resourcePlayerPresenter;
	
	private boolean isCollectionPlayer=false;
	
	@Inject
	public ResourcePlayerMetadataPresenter(EventBus eventBus, IsResourcePlayerMetadataView view,QuestionResourcePresenter questionResourcePresenter,CollectionEndPresenter collectionEndPresenter) {
		super(eventBus, view);
		this.questionResourcePresenter=questionResourcePresenter;
		this.collectionEndPresenter=collectionEndPresenter;
		getView().setUiHandlers(this);
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo){
		getView().showResourceWidget(collectionItemDo);
	}
	
	public void showResourceWidget(CollectionItemDo collectionItemDo,PlaceRequest nextResoruceRequest,PlaceRequest previousResourceRequest){
		getView().showResourceWidget(collectionItemDo,nextResoruceRequest,previousResourceRequest);
	}
	
	public void showResourceWidget(CollectionDo collectionDo,PlaceRequest previousResourceRequest){
		getView().showResourceWidget(previousResourceRequest);
		collectionEndPresenter.showCollectionEndPreview(collectionDo,collectionPlayerPresenter.getAttemptAnswersMap());
		getView().getResourceWidgetContainer().clear();
		getView().getResourceWidgetContainer().add(collectionEndPresenter.getWidget());
	}

	@Override
	public void showQuestionView(CollectionItemDo collectionItemDo) {
		questionResourcePresenter.setCollectionPlayer(isCollectionPlayer);
		questionResourcePresenter.setCollectionPlayerPresnter(collectionPlayerPresenter);
		questionResourcePresenter.setResourcePlayerPresenter(resourcePlayerPresenter);
		questionResourcePresenter.showQuestionPreview(collectionItemDo);
		removeUserAttemptResult();
		getView().getResourceWidgetContainer().add(questionResourcePresenter.getWidget());
	}
	
	public void setCollectionPlayerPresnter(CollectionPlayerPresenter collectionPlayerPresenter,boolean isCollectionPlayer){
		this.collectionPlayerPresenter=collectionPlayerPresenter;
		this.isCollectionPlayer=isCollectionPlayer;
	}
	
	public void setResourcePlayerPresenter(ResourcePlayerPresenter resourcePlayerPresenter,boolean isCollectionPlayer){
		this.resourcePlayerPresenter=resourcePlayerPresenter;
		this.isCollectionPlayer=isCollectionPlayer;
	}
	
	public void removeUserAttemptResult(){
		if(isCollectionPlayer){
			collectionPlayerPresenter.removeUserAttemptResult();
		}else{
			resourcePlayerPresenter.removeUserAttemptResult();
		}
	}
	
	public void resetResourceMetaData(){
		getView().getResourceWidgetContainer().clear();
	}
}
