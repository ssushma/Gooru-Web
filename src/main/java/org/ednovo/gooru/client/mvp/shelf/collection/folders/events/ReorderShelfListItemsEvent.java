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
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.GwtEvent;

public class ReorderShelfListItemsEvent extends GwtEvent<ReorderShelfListItemsEventHandler> {

	public static final Type<ReorderShelfListItemsEventHandler> TYPE = new Type<ReorderShelfListItemsEventHandler>();
	
	private String itemId,direction;
	private int toBeMovedPos;
	private HashMap<String, String> params;
	private FolderDo folderDo;
	private String itemSeqNumb;
	
	public ReorderShelfListItemsEvent(String itemId, int toBeMovedPos, String direction, HashMap<String, String> params, FolderDo folderDo, String itemSeqNumb){ 
		this.itemId = itemId;
		this.toBeMovedPos = toBeMovedPos;
		this.direction = direction;
		this.params = params;
		this.folderDo = folderDo;
		this.itemSeqNumb = itemSeqNumb;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ReorderShelfListItemsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReorderShelfListItemsEventHandler handler) {
		handler.reorderShelfListItems(itemId,toBeMovedPos,direction, params, folderDo, itemSeqNumb); 
	}

}
