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
package org.ednovo.gooru.client.mvp.classpage.teach.edit.content;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.UrlNavigationTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


/**
 * @fileName : EditClassContentPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassContentPresenter extends PresenterWidget<IsEditClassContentView> implements EditClassContentViewUiHandler {
	
	ClasspageDo classpageDo;
	
	@Inject
	public EditClassContentPresenter(EventBus eventBus,IsEditClassContentView view){
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
		
	}

	@Override
	public void onReveal() {
		super.onReveal();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		getView().setNavigationTab();
	}

	public void setClassData(ClasspageDo classpageDo) {
		this.classpageDo=classpageDo;
		getView().setClassData(classpageDo);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.EditClassContentViewUiHandler#updateClass(org.ednovo.gooru.application.shared.model.content.ClasspageDo)
	 */
	@Override
	public void updateClass(ClasspageDo classpageDo) {
		String classId = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.CLASSPAGEID,"");
		if(!classId.isEmpty()){
			AppClientFactory.getInjector().getClasspageService().v3UpdateClass(classId, classpageDo, new AsyncCallback<ClasspageDo>() {
				
				@Override
				public void onSuccess(ClasspageDo result) {
					getView().setUpdateClass(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		}
	}

}
