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
package org.ednovo.gooru.client.mvp.shelf.event;

import com.google.gwt.event.shared.GwtEvent;

public class HighlightAssignmentToEditEvent extends GwtEvent<HighlightAssignmentToEditEventHandler> {

	public static final Type<HighlightAssignmentToEditEventHandler> TYPE = new Type<HighlightAssignmentToEditEventHandler>();
	
	private String o1,o2,o3,collectionId;
	
	public HighlightAssignmentToEditEvent(String o1,String o2,String o3,String collectionId){
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.collectionId = collectionId;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<HighlightAssignmentToEditEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(HighlightAssignmentToEditEventHandler handler) {
		handler.highlightAssignmentToEdit(o1,o2,o3,collectionId);
	}

}
