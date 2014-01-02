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
package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildPresenter;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.service.ClasspageService;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.dom.client.Style.Display;


/**
 * 
 * @fileName : CollectionsPresenter.java
 *
 * @description : This is presenter class for CollectionsView.java
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionsPresenter extends ChildPresenter<CollectionsPresenter, IsCollectionsView> implements CollectionsUiHandlers {

	CollectionItemDo collectionItemDo = null;
	ClasspageService classpageService=null;
		
	/**
	 * Class constructor
	 * 
	 * @param childView 
	 */
	public CollectionsPresenter(IsCollectionsView childView) {
		super(childView);
	}

	/**
	 * @description : this is used to remove collection from assignments.
	 * @param : collectionId
	 * @param : assignmentId
	 * 
	 * @return : onSuccess removing the collection from an Assignment
	 */
	public void RemoveCollectionFormAssignemnt(String collectionId, String assignmentId){
		AppClientFactory.getInjector().getClasspageService().v2RemoveCollectionFromAssignment(collectionId, assignmentId, new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				if(getView().asWidget().getParent().getElement().getChildCount()-1>=10){
					getView().asWidget().getParent().getParent().getParent().getElement().getFirstChildElement().getStyle().setDisplay(Display.NONE);
				}else{
					getView().asWidget().getParent().getParent().getParent().getElement().getFirstChildElement().getStyle().setDisplay(Display.BLOCK);
				}
				getView().asWidget().removeFromParent();
				getView().hideWaitPopup();
				
			}
		});
	}
	
	
	/** 
	 * This method is to get the classpageService
	 */
	public ClasspageService getClasspageService() {
		return classpageService;
	}


	/** 
	 * This method is to set the classpageService
	 */
	public void setClasspageService(ClasspageService classpageService) {
		this.classpageService = classpageService;
	}
	/**
	 * 
	 * @function onBind 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This is called when the presenter is instantiated.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void onBind() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * 
	 * @function onLoad 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is called immediately before a widget will be detached from the browser's document.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	
	private void onLoad() {
		throw new RuntimeException("Not implemented");
	}


}
