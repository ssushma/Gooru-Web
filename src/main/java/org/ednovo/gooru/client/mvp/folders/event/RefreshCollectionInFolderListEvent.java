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
/**
 * 
 */
package org.ednovo.gooru.client.mvp.folders.event;

import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @fileName : RefreshCollectionInFolderListEvent.java
 *
 * @description : This file is related to events for RefreshCollectionInFolderListEvent.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class RefreshCollectionInFolderListEvent extends GwtEvent<RefreshCollectionInFolderListHandler> {

	public static final Type<RefreshCollectionInFolderListHandler> TYPE = new Type<RefreshCollectionInFolderListHandler>();

	private CollectionDo collectionDo;
	
	private RefreshFolderType refreshFolderType;
	

	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public RefreshCollectionInFolderListEvent(CollectionDo collectionDo, RefreshFolderType refreshFolderType) {
		this.collectionDo = collectionDo;
		this.refreshFolderType = refreshFolderType;
	}
	/**
	 * Returns the Event.Type used to register this event, allowing an EventBus to find handlers of the appropriate class.
	 */
	@Override
	public Type<RefreshCollectionInFolderListHandler> getAssociatedType() {
		return TYPE;
	}
	/**
	 * This method will be  called by HandlerManager and it will be used to invoke register original handler event.
	 */
	@Override
	protected void dispatch(RefreshCollectionInFolderListHandler handler) {
		handler.refreshCollectionInFolderList(collectionDo, refreshFolderType);
	}

}
