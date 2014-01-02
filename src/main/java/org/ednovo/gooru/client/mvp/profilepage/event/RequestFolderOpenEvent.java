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
package org.ednovo.gooru.client.mvp.profilepage.event;

import java.util.Map;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @fileName : RequestFolderOpenEvent.java
 *
 * @description : RequestFolder Open Event
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class RequestFolderOpenEvent extends GwtEvent<RequestFolderOpenHandler> {

	private String collectionId;
	private Map<String, String> params;

	public static final Type<RequestFolderOpenHandler> TYPE = new Type<RequestFolderOpenHandler>();
	
	/**
	 * Class constructor , assign collection id
	 */
	public RequestFolderOpenEvent(String collectionId, Map<String, String> params) {
		setCollectionId(collectionId);
		setParams(params);
	}
	/**
	 * Returns the Event.Type used to register this event, allowing an EventBus to find handlers of the appropriate class.
	 */
	@Override
	public Type<RequestFolderOpenHandler> getAssociatedType() {
		return TYPE;
	}
	/**
	 * This method will be  called by HandlerManager and it will be used to invoke register original handler event.
	 */
	@Override
	protected void dispatch(RequestFolderOpenHandler handler) {
		handler.requestFolderView(getCollectionId(), getParams());
	}
	/**
	 * 
	 * @function getCollectionId 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns collectionId
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
	/**
	 * 
	 * @function setCollectionId 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To set CollectionId
	 * 
	 * 
	 * @parm(s) : @param collectionId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	/**
	 * 
	 * @function getParams 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :Return params.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Map<String,String>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public Map<String, String> getParams() {
		return params;
	}
	/**
	 * 
	 * @function setParams 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To set Params.
	 * 
	 * 
	 * @parm(s) : @param params
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}	
}
