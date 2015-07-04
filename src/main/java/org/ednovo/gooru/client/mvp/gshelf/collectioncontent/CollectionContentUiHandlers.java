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
package org.ednovo.gooru.client.mvp.gshelf.collectioncontent;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;

/**
 * @author Search Team
 *
 */
public interface CollectionContentUiHandlers extends BaseUiHandlers {
	/**
	 * This method is used to set the folderdo object
	 * @param folderDo
	 */
	public void setData(FolderDo folderDo);
	/**
	 * This method is used to reorder positions of the widgets
	 * @param idToMove
	 * @param itemSeqToAPI
	 */
	public void reorderWidgetPositions(String idToMove,int itemSeqToAPI) ;
	/**
	 * This method is used to update narration.
	 * @param collectionItemId
	 * @param narration
	 */
	public void updateNarrationItem(CollectionItemDo collectionItem, String narration);
	/**
	 * This method is used to delete resoruce
	 * @param collectionItemId
	 */
	public void deleteCollectionItem(String collectionItemId, int itemSequence);
	/**
	 * This method is used to update the pdf pages
	 * @param collectionItem
	 * @param narration
	 * @param start
	 * @param stop
	 */
	public void updateCollectionItem(final CollectionItemDo collectionItem, String narration, String start, String stop);

	/**
	 *
	 * @function addResourcePopup
	 *
	 * @created_date : 03-Jul-2015
	 *
	 * @description
	 *
	 *
	 * @parm(s) : @param collectionDo
	 * @parm(s) : @param clickType
	 *
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 *
	 *
	 */
	void addResourcePopup(CollectionDo collectionDo, String clickType);

}
