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
package org.ednovo.gooru.client.mvp.classpages.event;

import com.google.gwt.event.shared.GwtEvent;

	/**
	 * 
	 * @fileName : DeleteClasspageListEvent.java
	 *
	 * @description : This file is used to delete the ClasspageListEvents.
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
public class DeleteClasspageListEvent extends GwtEvent<DeleteClasspageListHandler> {

	public static final Type<DeleteClasspageListHandler> TYPE = new Type<DeleteClasspageListHandler>();

	private String classpageId;

	/**
	 * 
	 * @param classpageId
	 */
	public DeleteClasspageListEvent(String classpageId) {
		
		this.classpageId = classpageId;
	}
	/**
	 * Returns the Event.Type used to register this event, allowing an EventBus to find handlers of the appropriate class.
	 */
	@Override
	public Type<DeleteClasspageListHandler> getAssociatedType() {
		return TYPE;
	}
	/**
	 * This method will be  called by HandlerManager and it will be used to invoke lregisterogin handler event.
	 */
	@Override
	protected void dispatch(DeleteClasspageListHandler handler) {
		handler.deleteClasspage(classpageId);
	}

}
