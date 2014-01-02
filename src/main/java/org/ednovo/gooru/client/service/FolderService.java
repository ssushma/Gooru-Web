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
package org.ednovo.gooru.client.service;

import java.util.List;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwt-service/folderService")
public interface FolderService extends BaseService {
	
	/**
	 * Create new FOLDER
	 * @param collectionDo instance of {@link CollectionDo} has collection meta info
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 */
	public CollectionDo createFolder(CollectionDo collectionDo)  throws GwtException;
	
	/**
	 * Create new FOLDER
	 * @param collectionDo instance of {@link CollectionDo} has collection meta info
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 */
	public CollectionDo createFolderToParentFolder(CollectionDo collectionDo, String parentId)  throws GwtException;

	/**
	 * Get All Folders by User
	 * @return serialized created {@link List<CollectionItemDo>}
	 * @throws GwtException
	 */
	public List<CollectionItemDo> getAllFolders() throws GwtException;
	/**
	 * Delete new FOLDER by collectionId
	 * @param collectionId of the folder 
	 * @throws GwtException
	 
	 */

	public void deleteFolder(String collectionId)  throws GwtException;

	/**
	 * Get all folders and collections inside a folder
	 * @return serialized created {@link List<CollectionDo>}
	 * @throws GwtException
	 */
//	public List<CollectionDo> getFoldersAndCollections(String folderId) throws GwtException;
	
	/**
	 * Get a folder information
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 */
	public CollectionDo getFolderInformation(String folderId) throws GwtException;

	/**
	 * Get Folders of the second level and third level by User
	 * @return serialized created {@link List<CollectionDo>}
	 * @throws GwtException
	 */
	public List<CollectionItemDo> getFolders(String collectionId) throws GwtException;
}
