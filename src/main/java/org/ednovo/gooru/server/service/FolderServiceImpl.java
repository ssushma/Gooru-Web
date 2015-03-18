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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.service.FolderService;
import org.ednovo.gooru.server.ArrayListSorter;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.exception.ServerDownException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.checkboxSelectedDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.folder.FolderTocDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.itextpdf.text.log.SysoCounter;

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
	private static final String TITLE = "title";
	private static final String SOURCE_ID = "sourceId";
	private static final String TARGET_ID = "targetId";
	private static final String IDEAS = "ideas";
	private static final String QUESTIONS = "questions";
	private static final String PERFORMANCE_TASKS = "performanceTasks";
	
	private String parentId = "";
	
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	
	private static final Logger logger = LoggerFactory.getLogger(FolderServiceImpl.class);
	
	@Autowired
	ResourceDeserializer resourceDeserializer;

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

		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), form);
		logger.info("CreteFolder Url : "+url);
		logger.info("form : "+form);
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeCollection(jsonRep);

	}
	
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

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), form);
		logger.info("createFolderToParentFolder : "+url);
		logger.info("form : "+form);
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeCollection(jsonRep);
	}

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

	@Override
	public List<CollectionItemDo> getAllFolders() throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_MY_FOLDERS, getLoggedInSessionToken(), WORKSPACE_PAGE_SIZE, ORDER_BY);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
		List<CollectionItemDo> collectionItemDo = deserializeWorkspace(jsonRep);
		
		Collections.sort(collectionItemDo, new ArrayListSorter("itemSequence", true));
		return collectionItemDo;
	}

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

	@Override
	public CollectionDo getFolderInformation(String folderId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_A_FOLDER_INFORMATION, folderId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeCollection(jsonRep);
	}

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

	@Override
	public List<CollectionItemDo> getFolders(String collectionId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_MY_FOLDER_LEVELS, collectionId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItems(jsonRep);
	}
	
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

	@Override
	public FolderListDo getChildFolders(int offset, int limit, String parentId,String sharingType, String collectionType,boolean isExcludeAssessment) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		String sessionToken=getLoggedInSessionToken();
		if(sharingType!=null){
			sessionToken=sessionToken+"&sharing="+sharingType;
		}
		if(collectionType!=null){
			sessionToken=sessionToken+"&collectionType="+collectionType;
		}
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_CHILD_FOLDER_LIST, parentId, sessionToken, offset+"", limit+"");
		if(isExcludeAssessment){
			url=url+"&excludeType=assessment/url";
		}
		logger.info("getChildFolders folder service : "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeFolderList(jsonRep);
	}

	public FolderListDo deserializeFolderList(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<FolderListDo>() {});
			}
		} catch (Exception e) {}
		return new FolderListDo();
	}

	@Override
	public FolderDo createFolder(String folderName, String parentId, boolean addToShelf) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		FolderDo folderDo = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_FOLDER, getLoggedInSessionToken());
		JSONObject folderObject=new JSONObject();
		try {
			folderObject.put(TITLE, folderName);
			if(!parentId.isEmpty()) {
				folderObject.put(PARENT_ID, parentId);
			}
			if(addToShelf) {
				folderObject.put(ADD_TO_SHELF, addToShelf);
			}
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.post(url, getRestUsername(), getRestPassword(),folderObject.toString());
			
			logger.info("createFolderToParentFolder : "+url);
			logger.info("folderObject : "+folderObject.toString());
			
			jsonRep=jsonResponseRep.getJsonRepresentation();
			folderDo = deserializeCreatedFolder(jsonRep);
		} catch (JSONException e) {
		} catch (Exception e) {
		}
		return folderDo;
	}

	public FolderDo deserializeCreatedFolder(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<FolderDo>() {});
			}
		} catch (Exception e) {}
		return new FolderDo();
	}

	@Override
	public void deleteCollectionsFolder(String folderId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_DELETE_FOLDER, folderId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}

	@Override
	public void moveCollectionIntoFolder(String sourceId, String targetId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_MOVE_COLLECTION, getLoggedInSessionToken());
		JSONObject folderObject=new JSONObject();
		try {
			folderObject.put(SOURCE_ID, sourceId);
			if(targetId!=null && !targetId.equalsIgnoreCase("")){
				folderObject.put(TARGET_ID, targetId);
			}
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword(),folderObject.toString());
			logger.info("moveCollectionIntoFolder : "+url);
			logger.info("folderObject 1 :" +folderObject.toString() );
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public CollectionDo createCollectionInParent(CollectionDo data,String courseCodeId, String folderId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		CollectionDo collectionDo = null;
		JSONObject collectionDataObject=new JSONObject();
		JSONObject courseIdObj=new JSONObject();
		JSONObject FolderDataObject=new JSONObject();
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_COLLECTION_IN_FOLDER, getLoggedInSessionToken());
		try {
			collectionDataObject.put("collectionType", data.getCollectionType());
			collectionDataObject.put("title", data.getTitle());
			collectionDataObject.put("sharing", data.getSharing());
			collectionDataObject.put("grade", data.getGrade());
			collectionDataObject.put("mediaType", data.getMediaType());
			collectionDataObject.put("url", data.getUrl());
			if (courseCodeId != null) {
				courseIdObj.put("codeId", courseCodeId);
				ArrayList<JSONObject> taxonomyArray= new ArrayList<JSONObject>();
				taxonomyArray.add(courseIdObj);
				collectionDataObject.put("taxonomySet", taxonomyArray);
			}
			FolderDataObject.put("collection", collectionDataObject);
			FolderDataObject.put("parentId", folderId);
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.post(url, getRestUsername(), getRestPassword(),FolderDataObject.toString());
			logger.info("FolderDataObject.toString() : "+FolderDataObject.toString());
			logger.info("createCollectionInParent : "+url);
			jsonRep=jsonResponseRep.getJsonRepresentation();
			collectionDo = deserializeCreatedCollInFolder(jsonRep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectionDo;
	}
	
	public CollectionDo deserializeCreatedCollInFolder(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<CollectionDo>() {});
			}
		} catch (Exception e) {}
		return new CollectionDo();
	}

	@Override
	public void updateFolder(String folderId, String title, String ideas, String questions, String performance) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_FOLDER_METADATA, folderId, getLoggedInSessionToken());
		JSONObject folderObject=new JSONObject();
		try {
			folderObject.put(TITLE, title);
			if(ideas!=null) {
				if(ideas.length()>1000) {
					ideas = ideas.substring(0, 1000);
				}
				folderObject.put(IDEAS, ideas);
			}
			if(questions!=null) {
				if(questions.length()>1000) {
					questions = questions.substring(0, 1000);
				}
				folderObject.put(QUESTIONS, questions);
			}
			if(performance!=null) {
				if(performance.length()>1000) {
					performance = performance.substring(0, 1000);
				}
				folderObject.put(PERFORMANCE_TASKS, performance);
			}
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword(),folderObject.toString());
		} catch (Exception e) {}
	}

	@Override
	public CollectionDo copyDraggedCollectionIntoFolder(CollectionDo data,String courseCodeId,String parentId,boolean addToShelf) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		CollectionDo collectionDo = null;
		JSONObject collectionDataObject=new JSONObject();
		JSONObject FolderDataObject=new JSONObject();
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_COPY_COLLECTION_IN_FOLDER,data.getGooruOid(), getLoggedInSessionToken()); 
		try {
			collectionDataObject.put("collectionType", "collection");
			collectionDataObject.put("title", data.getTitle());
			collectionDataObject.put("sharing", data.getSharing());
			collectionDataObject.put("grade", data.getGrade());
			collectionDataObject.put("mediaType", data.getMediaType());
			if (courseCodeId != null) {
				collectionDataObject.put("taxonomyCode", courseCodeId);

			}
			FolderDataObject.put("collection", collectionDataObject);
			FolderDataObject.put("parentId", parentId);
			FolderDataObject.put("addToShelf", addToShelf);
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword(),FolderDataObject.toString());
			jsonRep=jsonResponseRep.getJsonRepresentation();
			collectionDo = deserializeCreatedCollInFolder(jsonRep);
		} catch (Exception e) {
		}
		return collectionDo;
	}

	@Override
	public FolderListDo getCollectionResources(String parentId,	String sharingType, String collectionType) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = null;
		String sessionToken=getLoggedInSessionToken();
		if(sharingType!=null){
			sessionToken=sessionToken+"&sharing="+sharingType;
		}
		if(collectionType!=null){
			sessionToken=sessionToken+"&collectionType="+collectionType;
		}
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_COLLECTION_RESOURCE_LIST, parentId, sessionToken);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeFolderList(jsonRep);
	}

	@Override
	public void reorderFoldersOrCollections(int itemToBeMovedPosSeqNumb, String collectionItemId) throws GwtException, ServerDownException {

		JsonRepresentation jsonRep = null;
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_REORDER_FOLDER_COLLECTION,collectionItemId, itemToBeMovedPosSeqNumb+"", getLoggedInSessionToken());
		getLogger().info("-- Folder Re-order API - - - - "+url);
		try {
			JsonResponseRepresentation jsonResponseRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword(),new Form());
		}catch (Exception e) {
		}
	}

	@Override
	public FolderTocDo getTocFolders(String folderId,boolean fromPPP) throws GwtException,ServerDownException {
		JsonRepresentation jsonRep = null;
		FolderTocDo folderTocDo = new FolderTocDo();
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GETTOCFOLDERSANDCOLLECTIONS, folderId, getLoggedInSessionToken());
		if(fromPPP){
			url=url+"&sharing=public";
		}
		getLogger().info("-- Folder toc API - - - - "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		folderTocDo =deserializeFolderTocList(jsonRep);
		folderTocDo.setStatusCode(jsonResponseRep.getStatusCode());
		return folderTocDo;
	}
	public FolderTocDo deserializeFolderTocList(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<FolderTocDo>() {});
			}
		} catch (Exception e) {}
		return new FolderTocDo();
	}
	
	@Override
	public FolderDo getFolderMetaData(String folderId) throws GwtException,ServerDownException {
		JsonRepresentation jsonRep = null;
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_FOLDER_META_DATA, folderId, getLoggedInSessionToken());
		getLogger().info("-- getFolderMetaData - - - - "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCreatedFolder(jsonRep);
	}

	@Override
	public Map<String,String> getFolderRouteNodes(String folderId)
			throws GwtException, ServerDownException {
		Map<String,String> folderList=new LinkedHashMap<String, String>();
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.V2_FOLDER_ROUTE_NODES, folderId,getLoggedInSessionToken());
		getLogger().info("getFolderRouteNodes:"+url);
		JsonResponseRepresentation jsonResponseRep =ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		if(jsonResponseRep.getStatusCode()==200){
			JsonRepresentation jsonRepresentation=jsonResponseRep.getJsonRepresentation();
			try{
				JSONArray foldersArray=jsonRepresentation.getJsonArray();
				if(foldersArray!=null&&foldersArray.length()>0){
					for(int i=0;i<foldersArray.length();i++){
						JSONObject jsonObj=foldersArray.getJSONObject(i);
						folderList.put(jsonObj.getString("gooruOid"), jsonObj.getString("title"));
					}
				}
				return folderList;
			}catch(Exception e){

			}
		}
		return folderList;
	}
}
