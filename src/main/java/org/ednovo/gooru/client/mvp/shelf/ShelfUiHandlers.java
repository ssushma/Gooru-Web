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
package org.ednovo.gooru.client.mvp.shelf;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEventHandler;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateResourceCountEventHandler;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 * 
 * @fileName : ShelfUiHandlers.java
 *
 * @description : This interface is UIHandler file for ShelfView.java
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface ShelfUiHandlers extends BaseUiHandlers,GetEditPageHeightEventHandler,UpdateResourceCountEventHandler{

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SHELF_TAB = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_COLLECTION_RESOURCE_TAB = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_COLLECTION_INFO_TAB = new Type<RevealContentHandler<?>>();
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_ASSIGN_INFO_TAB = new Type<RevealContentHandler<?>>();

	void deleteCollection(String collectionId);

	void revealTab(Type<RevealContentHandler<?>> tabType, CollectionDo collectionDo);

	void clearTabSlot();

	void imageUpload();

	void updateCollectionInfo(String collectionId, String title, String description);
	
	void copyCollection(String collectionUid);

}
