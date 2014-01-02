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
package org.ednovo.gooru.server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.client.service.FolderService;
import org.ednovo.gooru.server.ArrayListSorter;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
/**
 * @fileName : FolderServiceImpl.java
 *
 * @description : This is the implementation of the folder service.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Service("folderService")
@ServiceURL("/folderService")
public class FolderServiceImpl extends BaseServiceImpl implements FolderService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3513384975044132831L;

	private static final String FOLDER = "collection";
	private static final String ADD_TO_SHELF = "addToShelf";
	private static final String TAXONOMY_CODE = "taxonomyCode";
	private static final String PARENT_ID = "parentId";
	private static final String WORKSPACE_PAGE_SIZE = "50";
	private static final String ORDER_BY="sequence";

	
	private String parentId = "";
	
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	@Autowired
	ResourceDeserializer resourceDeserializer;
	/**
	 * This method is used to create a new folder.
	 */
	@Override
	public CollectionDo createFolder(CollectionDo collectionDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.CREATE_FOLDER, getLoggedInSessionToken());
		Iterator it = collectionDo.getTaxonomySet().iterator();
		String taxonomyId = "";
		while(it.hasNext()){
			CodeDo codeDo = (CodeDo) it.next();
			if(codeDo.getCodeId()!=null){
				taxonomyId = codeDo.getCodeId().toString();
			}
		}
		
		collectionDo.getTaxonomySet().clear();
		Form form = ResourceFormFactory.generateDataForm(collectionDo, FOLDER);
		form.add(ADD_TO_SHELF, TRUE);
		if(!taxonomyId.isEmpty()){
			form.add(TAXONOMY_CODE, taxonomyId);
		}

		
		jsonRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), form);
		
		return deserializeCollection(jsonRep);

	}
	/**
	 * This method is used to create a new folder in the parent folder. 
	 */
	@Override
	public CollectionDo createFolderToParentFolder(CollectionDo collectionDo,
			String parentId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.CREATE_FOLDER, getLoggedInSessionToken());

		Iterator it = collectionDo.getTaxonomySet().iterator();
		String taxonomyId = "";
		while(it.hasNext()){
			CodeDo codeDo = (CodeDo) it.next();
			if(codeDo.getCodeId()!=null){
				taxonomyId = codeDo.getCodeId().toString();
			}
		}
		this.parentId = parentId;
		collectionDo.getTaxonomySet().clear();
		Form form = ResourceFormFactory.generateDataForm(collectionDo, FOLDER);
		form.add(ADD_TO_SHELF, FALSE);
		if(!taxonomyId.isEmpty()){
			form.add(TAXONOMY_CODE, taxonomyId);
		}
		form.add(PARENT_ID, this.parentId);

		jsonRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), form);
		return deserializeCollection(jsonRep);
	}
	/**
	 * @function deserializeCollection 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize the collection.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionDo deserializeCollection(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject()
						.toString(), CollectionDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}
	/**
	 * This method is used to get the all folders. 
	 */
	@Override
	public List<CollectionItemDo> getAllFolders() throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_MY_FOLDERS, getLoggedInSessionToken(), WORKSPACE_PAGE_SIZE, ORDER_BY);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		List<CollectionItemDo> collectionItemDo = deserializeWorkspace(jsonRep);
		
		Collections.sort(collectionItemDo, new ArrayListSorter("itemSequence", true));
		return collectionItemDo;
	}
	/**
	 * @function deserializeWorkspace 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize the work spaces.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<CollectionItemDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<CollectionItemDo> deserializeWorkspace(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ArrayList<CollectionItemDo>();
	}
	/**
	 * This method is used to delete the folder.
	 */
	@Override
	public void deleteFolder(String collectionId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLECTION, collectionId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}

	/*@Override
	public List<CollectionDo> getFoldersAndCollections(String folderId) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_MY_FOLDERS_COLLECTIONS, folderId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeFoldersAndCollections(jsonRep);
	}*/
	/**
	 * This method is used to get the folder information.
	 */
	@Override
	public CollectionDo getFolderInformation(String folderId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_A_FOLDER_INFORMATION, folderId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCollection(jsonRep);
	}
	/**
	 * @function deserializeFoldersAndCollections 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize the folders and collections.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<CollectionDo> deserializeFoldersAndCollections(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionDo>>() {
				});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ArrayList<CollectionDo>();
	}
	/**
	 * This method is used to get the folders.
	 */
	@Override
	public List<CollectionItemDo> getFolders(String collectionId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_MY_FOLDER_LEVELS, collectionId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCollectionItems(jsonRep);
	}
	/**
	 * @function deserializeCollectionItems 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize the collection items.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<CollectionItemDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<CollectionItemDo> deserializeCollectionItems(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<CollectionItemDo>();
	}

}
