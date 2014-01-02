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

import java.util.Map;

import com.google.gwt.event.shared.GwtEvent;

	/**
	 * 
	 * @fileName : RequestFolderEvent.java
	 *
	 * @description : Events for RequestFolderEvent.
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
public class RequestFolderEvent extends GwtEvent<RequestFolderHandler> {

	private String collectionId;
	private Map<String, String> params;
	private Boolean refreshType;

	public static final Type<RequestFolderHandler> TYPE = new Type<RequestFolderHandler>();
	
	/**
	 * Class constructor , assign collection id
	 */
	public RequestFolderEvent(String collectionId, Map<String, String> params, Boolean refreshType) {
		setCollectionId(collectionId);
		setParams(params);
		setRefreshType(refreshType);
	}
	/**
	 * Returns the Event.Type used to register this event, allowing an EventBus to find handlers of the appropriate class.
	 */
	@Override
	public Type<RequestFolderHandler> getAssociatedType() {
		return TYPE;
	}
	/**
	 * This method will be  called by HandlerManager and it will be used to invoke register original handler event.
	 */
	@Override
	protected void dispatch(RequestFolderHandler handler) {
		handler.requestFolderView(getCollectionId(), getParams(),getRefreshType());
	}
	/**
	 * 
	 * @function getCollectionId 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :getters and setters for collectionId,params and refreshType.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}	
	
	public Boolean getRefreshType() {
		return refreshType;
	}

	public void setRefreshType(Boolean refreshType) {
		this.refreshType = refreshType;
	}
}
