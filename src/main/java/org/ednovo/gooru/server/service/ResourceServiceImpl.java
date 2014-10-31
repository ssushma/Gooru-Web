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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.ednovo.gooru.client.service.ResourceService;
import org.ednovo.gooru.player.resource.server.CreateContentReportController;
import org.ednovo.gooru.player.resource.shared.GetFlagContentDO;
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
import org.ednovo.gooru.shared.model.content.CollectionAddQuestionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsListDo;
import org.ednovo.gooru.shared.model.content.CollectionProfileItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.MetaDO;
import org.ednovo.gooru.shared.model.content.NewResourceDo;
import org.ednovo.gooru.shared.model.content.ProfanityCheckDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.model.content.checkboxSelectedDo;
import org.ednovo.gooru.shared.model.drive.ErrorDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.model.library.ProfanityDo;
import org.ednovo.gooru.shared.model.user.GoogleToken;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;


@Service("resourceService")
@ServiceURL("/resourceService")
public class ResourceServiceImpl extends BaseServiceImpl implements ResourceService {

	
	private static final long serialVersionUID = 3247182821197046755L;
	
	private static final String ADD_TO_SHELF = "addToShelf";
	
	private static final String TAXONOMY_CODE = "taxonomyCode";
	
	private static final String PARENT_ID = "parentId";
	
	private static final String YOUTUBE_BEGIN_URL = "http://gdata.youtube.com/feeds/api/videos/";
	
	private static final String YOUTUBE_END_URL = "?v=2&alt=jsonc";
	
	private static final String RESOURCE_ID = "resourceId";
	
	private static final String COLLECTION = "collection";
	
	private static final String GRADE = "grade";
	
	private static final String TITLE = "title";
	
	private static final String TRUE = "true";
	
	private static final String ADDED = "added";
	
	private static final String JSON = "json";
	
	private static final String FALSE = "false";
	
	private static final String RESOURCE = "resource";
	
	private static final String GOOGLE_DRIVE = "Google Drive";
	
	private static final String NEW_RESOURCE = "newResource";
	
	private static final String TAXONOMY_SET = "taxonomySet";
	
	private static final String RESOURCE_TAGS = "resourceTags";
	
	private static final String CHOOSE = "Please choose one of the following...";
	
	@Autowired
	ResourceDeserializer resourceDeserializer;

	@Override
	public CollectionDo createCollection(CollectionDo collectionDo, String codeId) {
		CollectionDo collectionDoObj=new CollectionDo();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, TRUE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		jsonRep = jsonResponseRep.getJsonRepresentation(); 
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		return collectionDoObj;
	}

	/*@Override
	public CollectionDo createCollectionInParent(CollectionDo collectionDo, String codeId, String parentId) {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionDoObj=new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, FALSE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}
		form.add(PARENT_ID, parentId);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		return collectionDoObj;

	}*/

	/*@Override
	public CollectionDo updateCollection(CollectionDo collectionDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionDo, COLLECTION));
		return deserializeCollection(jsonRep);
	}*/

	@Override
	public void deleteCollection(String collectionId) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLECTION, collectionId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}

	@Override
	public CollectionItemDo createCollectionItem(String collectionId, String resourceId) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_COLLECTION_ITEM,collectionId, getLoggedInSessionToken());
		try{
		JSONObject createCollectionJsonObject=new JSONObject();
		JSONObject itemTypeJsonObject=new JSONObject();
		itemTypeJsonObject.put("itemType", ADDED);
		createCollectionJsonObject.put("collectionItem", itemTypeJsonObject);
		if (resourceId != null) {
			createCollectionJsonObject.put("resourceId", resourceId);
		}
		
//		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLLECTION_ITEM, resourceId,getLoggedInSessionToken(), collectionId);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),createCollectionJsonObject.toString());		
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}catch(Exception e){}
		return deserializeCollectionItem(jsonRep);
	}

	/*@Override
	public CollectionItemDo updateCollectionItem(CollectionItemDo collectionItemDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLECTION_ITEM, collectionItemDo.getCollectionItemId(), getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionItemDo, "collectionItem"));
		return deserializeCollectionItem(jsonRep);
	}*/

	@Override
	public void deleteCollectionItem(String collectionItemId) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_DELETE_COLLECTION_ITEM, collectionItemId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}

	@Override
	public CollectionItemDo reorderCollectionItem(CollectionItemDo collectionItemDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_REORDER_COLLECTION_ITEM_SEQUENCE, collectionItemDo.getCollectionItemId(), collectionItemDo.getItemSequence() + "", getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public CollectionDo copyCollection(CollectionDo collectionDo, String addToShelf, String taxonomyCode) {
		CollectionDo collectionDoObj=new CollectionDo();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_COPY_COLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		try{
			JSONObject copyCollectionJsonObject=new JSONObject();
			JSONObject itemTypeJsonObject=new JSONObject();
				itemTypeJsonObject.put("collectionType", "collection");
				itemTypeJsonObject.put("title", collectionDo.getTitle());
				if(taxonomyCode != null) {
					itemTypeJsonObject.put(TAXONOMY_SET, taxonomyCode);
				}
			copyCollectionJsonObject.put("collection", itemTypeJsonObject);
			copyCollectionJsonObject.put("addToShelf", "true");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), copyCollectionJsonObject.toString());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		}
		catch(Exception ex){}
		return collectionDoObj;
	}

	/*@Override
	public List<CollectionItemDo> getCollectionItems(CollectionDo collectionDo) {
		String pageNum = "1";
		String pageSize = "10";
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION_ITEMS, collectionDo.getGooruOid(), getLoggedInSessionToken(), pageSize, pageNum);
		return deserializeCollectionItems(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));

	}*/
	
	

	@Override
	public CollectionDo getCollection(String collectionGooruOid, boolean skipCollectionItem) {
		CollectionDo collectionDoObj=new CollectionDo();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_COLLECTION, collectionGooruOid, getLoggedInSessionToken(), skipCollectionItem + "");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
	
		try {  
			if(collectionDoObj.getLanguageObjective() != null)
			{
			collectionDoObj.setLanguageObjective(URLDecoder.decode(collectionDoObj.getLanguageObjective(), "UTF-8"));
			}
			if(collectionDoObj.getKeyPoints() != null)
			{
			collectionDoObj.setKeyPoints(URLDecoder.decode(collectionDoObj.getKeyPoints(), "UTF-8")); 
			}

        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
		
		return collectionDoObj;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.ednovo.gooru.client.mvp.search.ResourceService#listCollections(java
	 * .lang.Integer, java.lang.Integer)
	 */
	/*@Override
	public List<CollectionDo> listCollections(Integer pageSize, Integer pageNum, String scollection) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.LIST_COLLECTION, getLoggedInSessionToken(), pageSize + "", pageNum + "", scollection);
		return deserializeCollections(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));

	}*/

	@Override
	public List<CollectionDo> getUserCollection() {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_COLLECTION, JSON, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollections(jsonRep);
	}

	public ResourceMetaInfoDo deserializeResourceMetaInfo(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ResourceMetaInfoDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ResourceMetaInfoDo();
	}
	
	public CollectionDo deserializeCollection(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}

	public CollectionItemDo deserializeCollectionItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionItemDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionItemDo();
	}

	public CollectionQuestionItemDo deserializeCollectionQuestionItemDo(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionQuestionItemDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionQuestionItemDo();
	}
	public MetaDO  deserializePermissions(JsonRepresentation jsonRep){
		if(jsonRep !=null && jsonRep.getSize() !=-1){
			try{
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), MetaDO.class);
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new MetaDO();
	}
	public List<CollectionDo> deserializeCollections(JsonRepresentation jsonRep) {
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

	public List<CollectionItemsListDo> deserializeMyUserCollections(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {

				
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemsListDo>>() {});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ArrayList<CollectionItemsListDo>();
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
	
	public List<UserDo> deserializeCollaborators(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<UserDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<UserDo>();
	}
	

	
	@Override
	public CollectionDo createCollectionWithItem(CollectionDo collectionDo, String codeId, String resourceId) {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionDoObj= new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, TRUE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}
		if (resourceId != null) {
			form.add(RESOURCE_ID, resourceId);
		}

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		return collectionDoObj;
	}

	@Override
	public CollectionDo updateCollectionMetadata(String collectionId, String title, String description, String grade, String sharing, String vocabulary, String taxonomyCode, String updateTaxonomyByCode, String mediaType,String action) {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionDoObj= new CollectionDo();
	    String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionId, getLoggedInSessionToken());
	    JSONObject classPageJsonObject=new JSONObject();
		JSONObject collectionTypeJsonObject=new JSONObject();
		try{
			if(title!=null){
				collectionTypeJsonObject.put(TITLE, title);
			}
			if(description != null){
				collectionTypeJsonObject.put("goals", description);
			}
			if(grade!=null){
				collectionTypeJsonObject.put(GRADE, grade);
			}
			if(sharing!=null){
				collectionTypeJsonObject.put("sharing", sharing);
			}
			if(vocabulary!=null){
				collectionTypeJsonObject.put("vocabulary", vocabulary);
			}
			if(taxonomyCode!=null){
				JSONArray taxonomySet = new JSONArray();
				JSONObject code = new JSONObject();
				code.put("codeId", taxonomyCode);
				taxonomySet.put(code);
				collectionTypeJsonObject.put("taxonomySet", taxonomySet);

			}
			if(mediaType!=null){
				collectionTypeJsonObject.put("mediaType", mediaType);
			}
			if(action!=null){
				collectionTypeJsonObject.put("action", action);
			}
			classPageJsonObject.put("collection", collectionTypeJsonObject);
			  
			
		}catch(Exception e){
			
		}
		
	    JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), classPageJsonObject.toString());
	    jsonRep = jsonResponseRep.getJsonRepresentation();
	    if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
	    return collectionDoObj;
	}

	@Override
	public CollectionItemDo updateCollectionItemMetadata(String collectionItemId, String narration, String narrationType, String start, String stop) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION_ITEM_METADATA, collectionItemId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionItem(narration, narrationType, start, stop));
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);

	}
	
	
	@Override
	public UserDo addCollaborator(String gooruOid,String collaboratorId){
		UserDo userDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ADD_COLLABORATOR, gooruOid, collaboratorId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}
	
	@Override
	public List<UserDo> getCollaborators(String gooruOid){
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLABORATOR, gooruOid, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url,getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollaborators(jsonRep);
	}
	
	@Override
	public UserDo deleteCollaborators(String gooruOid,String collaboratorId){
		UserDo userDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLABORATOR, gooruOid, collaboratorId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}
	
	/*@Override
	public CollectionItemDo copyCollectionItem(String collectionItemId) {
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLLECTION_ITEM, collectionItemId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		return deserializeCollectionItem(jsonRep);
	}*/

	@Override
	public String getYoutubeDuration(String videoId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String youtubeDuration = "0";
		String url = YOUTUBE_BEGIN_URL+videoId+YOUTUBE_END_URL;
		try {
			JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url);
			jsonRep = jsonResponseRep.getJsonRepresentation();
			return resourceDeserializer.serializeYoutubeInfo(jsonRep);
		} catch(Exception e) {}
		
		return youtubeDuration;
	}

	/*@Override
	public List<CollectionItemsListDo> getMyUserCollections() throws GwtException{
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_COLLECTIONS, getLoggedInSessionToken());
		return deserializeMyUserCollections(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}*/

	public CollectionItemDo addNewResource(String gooruOid, String idStr,
			String urlStr, String titleStr, String descriptionStr,
			String categoryStr, String thumbnailImgSrcStr, Integer endTime,String edcuationalUse,String momentsOfLearning,List<CodeDo> standards,String hostName, List<String> tagList) throws GwtException {
		categoryStr = categoryStr.trim();
		NewResourceDo newResourceDo = new NewResourceDo();		
		newResourceDo.setId(idStr);
		newResourceDo.setUrl(URLDecoder.decode(urlStr));
	
		newResourceDo.setTitle(titleStr);
		
		Set<CodeDo> standardsDo=new HashSet<CodeDo>();
		for(CodeDo item:standards)
		{
			 CodeDo codeObj=new CodeDo();
			 codeObj.setCode(item.getCode());
			 codeObj.setCodeId(item.getCodeId());
			 standardsDo.add(codeObj);
		}
		
		newResourceDo.setTaxonomySet(standardsDo);
		newResourceDo.setDescription(descriptionStr);
		newResourceDo.setCategory(categoryStr);
		newResourceDo.setStop(endTime);
		
		ArrayList<checkboxSelectedDo> arrayOfEducational=new ArrayList<checkboxSelectedDo>();
		checkboxSelectedDo educationalOfObj=new checkboxSelectedDo();
		educationalOfObj.setSelected(true);
		educationalOfObj.setValue(edcuationalUse);
		arrayOfEducational.add(educationalOfObj);
		if(!edcuationalUse.equalsIgnoreCase(CHOOSE))
		newResourceDo.setEducationalUse(arrayOfEducational);
		
		ArrayList<checkboxSelectedDo> arrayOfMoments=new ArrayList<checkboxSelectedDo>();
		checkboxSelectedDo momentsOfObj=new checkboxSelectedDo();
		momentsOfObj.setSelected(true);
		momentsOfObj.setValue(momentsOfLearning);
		arrayOfMoments.add(momentsOfObj);
		if(!momentsOfLearning.equalsIgnoreCase(CHOOSE))
		newResourceDo.setMomentsOfLearning(arrayOfMoments);
		
				
		ResourceFormatDo resourceFormat = new ResourceFormatDo();
		resourceFormat.setValue(categoryStr);
		
		newResourceDo.setResourceFormat(resourceFormat);
		
		if (thumbnailImgSrcStr==null){
			thumbnailImgSrcStr="";
		}
		
		if (urlStr.indexOf("youtube") > 0){
			newResourceDo.setThumbnail("");
		}else{
			newResourceDo.setThumbnail(thumbnailImgSrcStr);
		}
		if(hostName!=null){
			ArrayList<String> hostArray= new ArrayList<String>();
			hostArray.add(GOOGLE_DRIVE);
			newResourceDo.setHost(hostArray);
		}
		Map<String,Object> resourceMap=new HashMap<String,Object>();
		resourceMap.put(RESOURCE, newResourceDo);
		
		if(tagList!=null && tagList.size()!=0 ){
			resourceMap.put(RESOURCE_TAGS, tagList);
		}
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ADD_NEW_RESOURCE, idStr,getLoggedInSessionToken(),  URLEncoder.encode(titleStr).toString(), urlStr, categoryStr, URLEncoder.encode(descriptionStr).toString(), thumbnailImgSrcStr, String.valueOf(endTime));
		
		String form = ResourceFormFactory.generateStringDataForm(resourceMap, null);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public ResourceMetaInfoDo getResourceMetaInfo(String url) throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String urlStr = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_RESOURCE_INFO, getLoggedInSessionToken(), url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(urlStr);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeResourceMetaInfo(jsonRep);
	}
	
	@Override
	public ExistsResourceDo checkResourceExists(String url) throws GwtException {
		try {
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
	
		JsonRepresentation jsonRep = null;
		String urlStr = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CHECK_RESOURCE_EXISTS, url, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(urlStr);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeResourceItem(jsonRep);
	}
	
	public ExistsResourceDo deserializeResourceItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONObject("resource").toString(), ExistsResourceDo.class);
				} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ExistsResourceDo();
	}

	public ResourceDo deserializeResourceDoItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ResourceDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	@Override
	public CollectionItemDo addQuestionResource(String collectionId, String mediafileName, CollectionQuestionItemDo collectionQuestionItemDo) throws GwtException {
		JsonRepresentation jsonRep = null;

		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_ADD_QUESTION_ITEM, collectionId, getLoggedInSessionToken());
		CollectionAddQuestionItemDo collectionAddQuestionItemDo=new CollectionAddQuestionItemDo();
		collectionAddQuestionItemDo.setQuestion(collectionQuestionItemDo);
		collectionAddQuestionItemDo.setMediaFileName(mediafileName);
		String collectionQuestionData=ResourceFormFactory.generateStringDataForm(collectionAddQuestionItemDo, null);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), collectionQuestionData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public CollectionItemDo updateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_QUESTION_ITEM, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken());
		if(thumbnailUrl!=null){
			updateQuestionImage(collectionItemDo.getResource().getGooruOid(),thumbnailUrl);
		}
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionQuestionItemDo, "question"));
//		try {
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		jsonRep = jsonResponseRep.getJsonRepresentation();
		ResourceDo resourceDo=deserializeResourceDoItem(jsonRep);
		return convertResourceToCollectionItemDo(resourceDo,collectionItemDo);
	}

	@Override
	public CollectionItemDo updateResourceInfo(CollectionItemDo collectionItemDo,List<String> tagList)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url =null;
		
		/*if (collectionItemDo.getResource().getThumbnails().getUrl() == null){ 
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_RESOURCE_INFO_NO_MEDIA, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken(), collectionItemDo.getResource().getTitle(), collectionItemDo.getResource().getDescription(), collectionItemDo.getResource().getCategory());
		}else{
	*/		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_RESOURCE_INFO, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken());
		//}
		NewResourceDo newResourceDo = new NewResourceDo();
			
		String urlStr=collectionItemDo.getResource().getUrl();
		
		newResourceDo.setUrl(urlStr);
		newResourceDo.setTitle(collectionItemDo.getResource().getTitle());
		newResourceDo.setDescription(collectionItemDo.getResource().getDescription());
		newResourceDo.setCategory(collectionItemDo.getResource().getCategory());
			
		ResourceFormatDo resourceFormat = new ResourceFormatDo();
		resourceFormat.setValue(collectionItemDo.getResource().getCategory());
		
		String thumbnailImgSrcStr=collectionItemDo.getResource().getThumbnails().getUrl();
		if (thumbnailImgSrcStr==null){
			thumbnailImgSrcStr="";
		}
		
		if (urlStr.indexOf("youtube") > 0){
			newResourceDo.setThumbnail("");
		}else{
			newResourceDo.setThumbnail(thumbnailImgSrcStr);
		}
		
		newResourceDo.setResourceFormat(resourceFormat);
		newResourceDo.setEducationalUse(collectionItemDo.getResource().getEducationalUse());
		newResourceDo.setTaxonomySet(collectionItemDo.getResource().getTaxonomySet());
		newResourceDo.setMomentsOfLearning(collectionItemDo.getResource().getMomentsOfLearning());
		
		Map<String,Object> resourceMap=new HashMap<String,Object>();
		resourceMap.put(RESOURCE, newResourceDo);
		
		if(tagList!=null && tagList.size()!=0 ){
			resourceMap.put(RESOURCE_TAGS, tagList);
		}
		
		String form = ResourceFormFactory.generateStringDataForm(resourceMap, null);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(),form);
		//JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}
	
	public void removeQuestionImage(String collectionQuestionId) throws GwtException{
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.REMOVE_QUESTION_IMAGE, collectionQuestionId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep=ServiceProcessor.delete(url, getRestUsername(), getRestPassword());  
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}

	@Override
	public void updateQuestionImage(String collectionItemId, String fileName) throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ATTACH_IMAGE_TO_QUESTION, collectionItemId, getLoggedInSessionToken(),fileName);
		JsonResponseRepresentation jsonResponseRep=ServiceProcessor.post(url, getRestUsername(), getRestPassword());  
		jsonRep = jsonResponseRep.getJsonRepresentation();
//		try {
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	@Override
	public CollectionItemDo copyCollectionItem(String collectionId, String resourceId) {
		JsonRepresentation jsonRep = null;
		CollectionProfileItemDo collectionItemDo = new CollectionProfileItemDo();
		//collectionItemDo.setItemType(ADDED);
		String url = null;		
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_COPY_COLLLECTION_ITEM, resourceId, collectionId,getLoggedInSessionToken());

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(),new Form());

		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public List<CollectionDo> getUserCollectionList(Integer pageSize,
			Integer pageNum, boolean isSharable) throws GwtException {
		String pageNum1 =Integer.toString(pageNum);
		String pageSize1 = Integer.toString(pageSize);
		JsonRepresentation jsonRep = null;
		String url = null;

		if (isSharable){
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SHARABLE_USER_COLLECTION, JSON, getLoggedInSessionToken()+"&pageSize="+pageSize1+"&pageNum="+pageNum1);
		}else{
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_COLLECTION, JSON, getLoggedInSessionToken()+"&pageSize="+pageSize1+"&pageNum="+pageNum1);
		}
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollections(jsonRep);

	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.service.ResourceService#getPermissions(java.lang.String)
	 */
	@Override
	public MetaDO getPermissions(String collectionId)throws GwtException {
		String url=null;
		JsonRepresentation jsonRep = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.PERMISSION_COLLECTION, collectionId,getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializePermissions(jsonRep);
	}

	@Override
	public String checkShortenUrl(String shortenUrl) throws GwtException { 
		JsonRepresentation jsonRep = null;
		try {
			shortenUrl = URLEncoder.encode(shortenUrl, "UTF-8");
		} catch (UnsupportedEncodingException ex) {}
	
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CHECK_SHORTEN_URL,shortenUrl,getLoggedInSessionToken()); 
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		boolean isShortenUrl=false;
		try {
			
			isShortenUrl=jsonRep.getJsonObject().getBoolean("shortenedUrlStatus");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isShortenUrl ? "true" : "false";
		
		
	}

	public CollectionDo getCollection(String collectionGooruOid){
		JsonRepresentation jsonRep = null;
		CollectionDo collectionDoObj=new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_COLLECTION, collectionGooruOid, getGuestSessionToken(""), "true");
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		try {  
		
			if(collectionDoObj.getLanguageObjective() != null)
			{
				collectionDoObj.setLanguageObjective(URLDecoder.decode(collectionDoObj.getLanguageObjective(), "UTF-8"));
			}
			if(collectionDoObj.getKeyPoints() != null)
			{
				collectionDoObj.setKeyPoints(URLDecoder.decode(collectionDoObj.getKeyPoints(), "UTF-8")); 
			}

        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }	
		
		return collectionDoObj;
	}

	public CollectionDo getCollectionFromEmbed(String collectionGooruOid, String restEndPointFromEmbed){
		JsonRepresentation jsonRep = null;
		CollectionDo collectionDoObj=new CollectionDo();
		String url = UrlGenerator.generateUrl(restEndPointFromEmbed, UrlToken.V2_GET_COLLECTION, collectionGooruOid, getGuestSessionToken(restEndPointFromEmbed), "true");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			collectionDoObj = deserializeCollection(jsonRep);
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}else{
			collectionDoObj=new CollectionDo();
			collectionDoObj.setStatusCode(jsonResponseRep.getStatusCode());
		}
		
		try {  
			
			if(collectionDoObj.getLanguageObjective() != null)
			{
				collectionDoObj.setLanguageObjective(URLDecoder.decode(collectionDoObj.getLanguageObjective(), "UTF-8"));
			}
			if(collectionDoObj.getKeyPoints() != null)
			{
				collectionDoObj.setKeyPoints(URLDecoder.decode(collectionDoObj.getKeyPoints(), "UTF-8")); 
			}

        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }	
		
		return collectionDoObj;
	}

	@Override
	public CollectionItemDo addNewUserResource(	String jsonString,String gooruOid)throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_ADD_NEW_USER_RESOURCE, gooruOid, getLoggedInSessionToken());

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), jsonString);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public MediaUploadDo saveUserOwnResource(String fileName) throws GwtException {
		MediaUploadDo mediaUploadDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_USER_RESOURCE_MEDIA_FILE_SAVE, getLoggedInSessionToken());
	
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),	getRestPassword(),fileName);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		mediaUploadDo = JsonDeserializer.deserialize(jsonRep.toString(), MediaUploadDo.class);
		
		return mediaUploadDo;
	}
	
	public CollectionItemDo convertResourceToCollectionItemDo(ResourceDo resourceDo,CollectionItemDo collectionItemDo){	
		
		collectionItemDo.setResource(resourceDo);// replacing the update question details Do
		collectionItemDo.setCollectionQuestionItemDo(null);// removing existing collection item object details.
		
		return collectionItemDo;
	}

	@Override
	public CollectionItemDo updateUserOwnResource(String jsonString,String gooruOid) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_USER_RESOURCE, gooruOid, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), jsonString);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}

	@Override
	public CollectionItemDo updateNarrationMetadata(String collectionItemId,
			String narration, String narrationType) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION_ITEM_METADATA, collectionItemId, getLoggedInSessionToken());
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateNarrationItem(narration, narrationType));
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);

	}

	@Override
	public void createContentReport(String assocGooruOid, String targetValue, String typesvalue1,
			String typesvalue2, String typesvalue3, String typesvalue4,
			String otherDescription) {
		new CreateContentReportController().createCollectionContentreport(getRestEndPoint(), getLoggedInSessionToken(), assocGooruOid, targetValue,typesvalue1,typesvalue2,typesvalue3, typesvalue4,otherDescription);
	}

	@Override
	public String updateReport(String gooruOid, String freeText) {
		new CreateContentReportController().updateReport(getRestEndPoint(), getLoggedInSessionToken(), gooruOid, freeText);
		return freeText;
	}

	@Override
	public GetFlagContentDO getContentReport(String assocGooruOid) {
		return new CreateContentReportController().getContentReport(getRestEndPoint(),getLoggedInSessionToken(),assocGooruOid);
	}

	@Override
	public String deleteContentReport(String gooruOid) {
		return new CreateContentReportController().deleteContentReport(getRestEndPoint(),getLoggedInSessionToken(),gooruOid);
	}

	
	/**
	 * 
	 */
	@Override
	public Boolean checkProfanity(Map<String, String> parms){
		boolean value=false;
		JsonRepresentation jsonRep = null;
		ProfanityDo profanityDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.PROFANITY_CHECK, getLoggedInSessionToken());
		String formData = ResourceFormFactory.generateStringDataForm(parms, null);
		formData = formData.replaceAll("&", "%26").replaceAll("#", "%23");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				profanityDo =  JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfanityDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (profanityDo!=null){
			value = profanityDo.isFound();
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.service.ResourceService#checkProfanityForList(java.util.ArrayList)
	 */
	@Override
	public List<ProfanityCheckDo> checkProfanityForList(
			List<ProfanityCheckDo> profanityList) {
		Map<String, String> parms = new HashMap<String, String>();
		for (int i = 0; i < profanityList.size(); i++) {
			parms.put("text", profanityList.get(i).getQuestionText());
			profanityList.get(i).setQuestionValue(checkProfanityForLsit(parms));
		}
		return profanityList;
	}
	public Boolean checkProfanityForLsit(Map<String, String> parms){
		boolean value=false;
		JsonRepresentation jsonRep = null;
		ProfanityDo profanityDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.PROFANITY_CHECK, getLoggedInSessionToken());
		
		String formData = ResourceFormFactory.generateStringDataForm(parms, null);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				profanityDo =  JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfanityDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (profanityDo!=null){
			value = profanityDo.isFound();
		}
		return value;
	}

	@Override
	public FolderListDo getFolderWorkspace(int offset, int limit,String sharingType, String collectionType) throws GwtException {
		String offsetSize =Integer.toString(offset);
		String limitSize = Integer.toString(limit);
		if(sharingType!=null){
			limitSize=limitSize+"&sharing="+sharingType;
		}
		if(collectionType!=null){
			limitSize=limitSize+"&collectionType="+collectionType;
		}
		JsonRepresentation jsonRep = null;
		String url = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_WORKSPACE_FOLDER_LIST, getLoggedInSessionToken(), offsetSize, limitSize);
		getLogger().info("---- getFolderWorkspace ---  "+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeWorkspaceFolderList(jsonRep);
	}
	
	public FolderListDo deserializeWorkspaceFolderList(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), new TypeReference<FolderListDo>() {});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new FolderListDo();
	}
	
	@Override
	public CollectionDo updateCollectionInfo(CollectionDo collectionDo, String teacherTips) throws GwtException {
		CollectionDo collectionDoObj = new CollectionDo();
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionInfo(collectionDo.getTitle(), teacherTips).getValuesArray("data").length>0)
		{
			if(teacherTips != null)
			{
				try {  
					teacherTips = URLEncoder.encode(teacherTips, "UTF-8");  

	            } catch (UnsupportedEncodingException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }
			}
			
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionInfo(collectionDo.getTitle(), teacherTips).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		
		collectionDoObj = deserializeCollection(jsonRep);
		
		}
		try {  
		
			if(collectionDoObj.getLanguageObjective() != null)
			{
				collectionDoObj.setLanguageObjective(URLDecoder.decode(collectionDoObj.getLanguageObjective(), "UTF-8"));
			}
			if(collectionDoObj.getKeyPoints() != null)
			{
				collectionDoObj.setKeyPoints(URLDecoder.decode(collectionDoObj.getKeyPoints(), "UTF-8")); 
			}


        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }	
		return collectionDoObj;

	}
	
	@Override
	public CollectionDo updateCollectionLanguageObjective(CollectionDo collectionDo, String languageObjective) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionLanguageObjective(collectionDo.getTitle(), languageObjective).getValuesArray("data").length>0)
		{		
			if(languageObjective != null)
			{
				try {  
					languageObjective = URLEncoder.encode(languageObjective, "UTF-8");  

	            } catch (UnsupportedEncodingException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }
			}

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionLanguageObjective(collectionDo.getTitle(), languageObjective).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		collectionObjectDo = deserializeCollection(jsonRep);
		try
		{
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		return collectionObjectDo;

	}
	
	@Override
	public CollectionDo updateCollectionInstructionalMethod(CollectionDo collectionDo, String instructionalMethod, Boolean selectedVal) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionInstructionalMethod(collectionDo.getTitle(), instructionalMethod,selectedVal).getValuesArray("data").length>0)
		{
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionInstructionalMethod(collectionDo.getTitle(), instructionalMethod,selectedVal).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		collectionObjectDo = deserializeCollection(jsonRep);
		try
		{
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		return collectionObjectDo;

	}
	
	@Override
	public CollectionDo updateCollectionAudience(CollectionDo collectionDo, String audience, Boolean selectedVal) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionAudience(collectionDo.getTitle(), audience,selectedVal).getValuesArray("data").length>0)
		{
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionAudience(collectionDo.getTitle(), audience,selectedVal).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		collectionObjectDo = deserializeCollection(jsonRep);
		try
		{
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		return collectionObjectDo;

	}
	
	@Override
	public CollectionDo updateCollectionDepthOfKnowledge(CollectionDo collectionDo, String depthOfKnowlwedgevalues, Boolean selectedVal) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionDepthOfKnowledge(collectionDo.getTitle(), depthOfKnowlwedgevalues,selectedVal).getValuesArray("data").length>0)
		{
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionDepthOfKnowledge(collectionDo.getTitle(), depthOfKnowlwedgevalues,selectedVal).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		try
		{
			collectionObjectDo = deserializeCollection(jsonRep);
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		return collectionObjectDo;

	}
	
	@Override
	public CollectionDo updateCollectionLearningSkills(CollectionDo collectionDo, String learningSkillsvalues, Boolean selectedVal) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		if(ResourceFormFactory.updateCollectionLearningSkills(collectionDo.getTitle(), learningSkillsvalues,selectedVal).getValuesArray("data").length>0)
		{
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionLearningSkills(collectionDo.getTitle(), learningSkillsvalues,selectedVal).getValuesArray("data")[0]);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}
		try
		{
			collectionObjectDo = deserializeCollection(jsonRep);
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		return collectionObjectDo;

	}
	
	
	@Override
	public CollectionDo getCollectionInfoV2API(String collectionId) throws GwtException {
		JsonRepresentation jsonRep = null;
		CollectionDo collectionObjectDo = new CollectionDo();
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_V2_COLLLECTION, collectionId, getLoggedInSessionToken());

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		
		try
		{
			collectionObjectDo = deserializeCollection(jsonRep);
		
			if(collectionObjectDo.getLanguageObjective() != null)
			{
				String correctDecoded = URLDecoder.decode(collectionObjectDo.getLanguageObjective(), "UTF-8"); 
				collectionObjectDo.setLanguageObjective(correctDecoded);
			}
			if(collectionObjectDo.getKeyPoints() != null)
			{
				collectionObjectDo.setKeyPoints(URLDecoder.decode(collectionObjectDo.getKeyPoints(), "UTF-8")); 
			}
		
		  } catch (UnsupportedEncodingException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }
		
		return collectionObjectDo;

	}

	@Override
	public void deleteTaxonomyResource(String resourceId, Integer codeId)
			throws GwtException {
		JsonRepresentation jsonRep = null;

		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.DELETE_TAXONOMY_RESOURCE, resourceId,
				getLoggedInSessionToken());
		
		try {
			JSONObject taxonomyObject = new JSONObject();
			JSONObject taxonomySetObj = new JSONObject();

			JSONArray codeIdJsonArray = new JSONArray();
			codeIdJsonArray.put(new JSONObject().put("codeId", codeId));

			taxonomySetObj.put("taxonomySet", codeIdJsonArray);
			taxonomyObject.put("resource", taxonomySetObj);
			JsonResponseRepresentation jsonResponseRep = ServiceProcessor
					.put(url, getRestUsername(), getRestPassword(),
							taxonomyObject.toString());
			
		} catch (Exception ex) {
			
		}
		// return null;

	}

	@Override
	public void UpdateResourceTaxonomy(String resourceId,Set<CodeDo> taxonomyObj) throws GwtException {
		JsonRepresentation jsonRep = null;

		for (CodeDo codeDo : taxonomyObj) {
			String url = UrlGenerator.generateUrl(getRestEndPoint(),
					UrlToken.UPDATE_TAXONOMY_RESOURCE, resourceId,
					getLoggedInSessionToken());
			
			try {
				JSONObject taxonomyObject = new JSONObject();
				JSONObject taxonomySetObj = new JSONObject();

				JSONArray codeIdJsonArray = new JSONArray();
				codeIdJsonArray.put(new JSONObject().put("codeId", codeDo.getCodeId()));

				taxonomySetObj.put("taxonomySet", codeIdJsonArray);
				taxonomyObject.put("resource", taxonomySetObj);
				JsonResponseRepresentation jsonResponseRep = ServiceProcessor
						.put(url, getRestUsername(), getRestPassword(),
								taxonomyObject.toString());
				jsonRep = jsonResponseRep.getJsonRepresentation();
				
			} catch (Exception ex) {
				
			}
		}
	}
	
	@Override
	public List<ResourceTagsDo> addTagsToResource(String resourceId, String addedTags)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.ADD_TAGS, resourceId, getLoggedInSessionToken());
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), ResourceFormFactory.frameTagObject(addedTags).getValuesArray("data")[0]);
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeResourceTags(jsonRep);
	}
	
	@Override
	public List<ResourceTagsDo> getTagsToResource(String resourceId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.GET_TAGS, resourceId, getLoggedInSessionToken());
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(),getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
		return deserializeResourceTags(jsonRep);
	}
	
	public List<ResourceTagsDo> deserializeResourceTags(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray()
						.toString(), new TypeReference<List<ResourceTagsDo>>() {
				});
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new  ArrayList<ResourceTagsDo>();
	}

	@Override
	public void deleteTagsServiceRequest(String resourceId, String addedTags)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.DELETE_TAGS, resourceId, getLoggedInSessionToken(),addedTags);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.delete(url, getRestUsername(),getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
	}
	
	@Override
	public GoogleDriveDo getGoogleDriveFilesList(String folderId,String nextPageToken) {
		GoogleDriveDo googleDriveDo=new GoogleDriveDo();
		String contentType="application/json";
		String access_token = getLoggedInAccessToken() != null ? getLoggedInAccessToken() : null;
		String enocodedString="";
		try {
			enocodedString = URLEncoder.encode("(mimeType = 'application/vnd.google-apps.document' or mimeType = 'application/vnd.google-apps.spreadsheet' or mimeType = 'application/vnd.google-apps.folder' or mimeType='application/vnd.google-apps.form' or mimeType='application/vnd.google-apps.presentation' or mimeType='application/vnd.google-apps.drawing')","UTF-8");
			folderId = folderId != null ? folderId : "root";
			enocodedString=enocodedString+URLEncoder.encode(" and '"+folderId+"' in parents and trashed!=true","UTF-8");
			if(nextPageToken!=null){
				enocodedString=enocodedString+"&pageToken="+nextPageToken;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = UrlGenerator.generateUrl(getGoogleRestEndPoint(), UrlToken.GET_GOOGLEDRIVE_FIlES, enocodedString);
		
		String response=new WebService(url,false).webInvokeforget("GET", "", contentType, access_token);
		if (response!=null){
			googleDriveDo=deserializeGoogleDriveFilesList(response);
		}else{
			googleDriveDo.setError(new ErrorDo());
			googleDriveDo.getError().setCode(401);
		}
		return googleDriveDo;
	}
	
	
	public GoogleDriveDo updateFileShareToAnyoneWithLink(String driveFileId){
		GoogleDriveDo googleDriveDo=new GoogleDriveDo();
		String contentType="application/json";
		String access_token = getLoggedInAccessToken() != null ? getLoggedInAccessToken() : null;
		JSONObject premissonJsonObject=new JSONObject();
		try {
			premissonJsonObject.put("role", "reader");
			premissonJsonObject.put("type", "anyone");
			premissonJsonObject.put("withLink", true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String url = UrlGenerator.generateUrl(getGoogleRestEndPoint(), UrlToken.UPDATE_FILE_PERMISSION, driveFileId);
		String response=new WebService(url,false).postWebservice("POST",premissonJsonObject.toString(),contentType,access_token);

		if (response!=null){
			googleDriveDo=deserializeGoogleDriveFilesList(response);
		}
		return googleDriveDo;
	}

	public GoogleDriveDo deserializeGoogleDriveFilesList(String jsonRep) {
		GoogleDriveDo googleDriveDo=null;
		if (jsonRep != null) {
			googleDriveDo=JsonDeserializer.deserialize(jsonRep, new TypeReference<GoogleDriveDo>() {
			});
		}
		return googleDriveDo;
	}
	public List<GoogleDriveItemDo> deserializegetGoogleDriveContent(JSONArray GoogleDriveJsonArray){
		GoogleDriveItemDo driveObj=new GoogleDriveItemDo();
		List<GoogleDriveItemDo> googleResult=new ArrayList<GoogleDriveItemDo>();
		for (int pointer = 0; pointer < GoogleDriveJsonArray.length(); pointer++) {
		try {
		driveObj = deserializeDriveDetails(GoogleDriveJsonArray.getJSONObject(pointer));
		if (driveObj != null) {
		googleResult.add(driveObj);
		}

		} catch (JSONException e) {
		throw new RuntimeException("message", e); 
		}

		}

		return googleResult;

		}
	public GoogleDriveItemDo deserializeDriveDetails(JSONObject jsonRep) {
        if (jsonRep != null) {
                return (GoogleDriveItemDo) JsonDeserializer.deserialize(jsonRep.toString(), new TypeReference<GoogleDriveItemDo>() {
                });
        }
        return new GoogleDriveItemDo();
}


	public List<GoogleDriveItemDo> deserializeFolderContent(JSONArray FolderContentJsonArray){
		GoogleDriveItemDo driveObj=new GoogleDriveItemDo();
		List<GoogleDriveItemDo> folderResult=new ArrayList<GoogleDriveItemDo>();
		for (int pointer = 0; pointer < FolderContentJsonArray.length(); pointer++) {
		try {
		driveObj = deserializeFolderDetails(FolderContentJsonArray.getJSONObject(pointer));
		if (driveObj != null) {
			folderResult.add(driveObj);
		}

		} catch (JSONException e) {
		throw new RuntimeException("message", e); 
		}

		}

		return folderResult;

		}
	public GoogleDriveItemDo deserializeFolderDetails(JSONObject jsonRep) {
        if (jsonRep != null) {
                return (GoogleDriveItemDo) JsonDeserializer.deserialize(jsonRep.toString(), new TypeReference<GoogleDriveItemDo>() {
                });
        }
        return new GoogleDriveItemDo();
	}

	@Override
	public GoogleToken refreshGoogleAccessToken(String refreshToken) throws GwtException {
		JsonRepresentation jsonRep = null;
		GoogleToken token = null;
		String url = UrlGenerator.generateUrl(getHomeEndPoint(),
				UrlToken.REFRESH_TOKEN, refreshToken);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(),getRestPassword());
		jsonRep =jsonResponseRep.getJsonRepresentation();
		String str = null;
		try {
			str = jsonRep.getJsonObject().toString();
			token =  deserializeGoogleToken(str);
			setLoggedInAccessToken(token != null && token.getAccess_token() != null ? token.getAccess_token() : null);
		} catch (JSONException eJson) {
			eJson.printStackTrace(); 
		}
		
		
		
		return token;
	}
	
	public GoogleToken deserializeGoogleToken(String jsonRep) {
        if (jsonRep != null) {
                return (GoogleToken) JsonDeserializer.deserialize(jsonRep, new TypeReference<GoogleToken>() {
                });
        }
        return new GoogleToken();
	}

	@Override
	public CollectionItemDo v2UpdateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) throws GwtException, ServerDownException {
		CollectionItemDo collItemDo = collectionItemDo;
		JsonRepresentation jsonRep = null;

	
		CollectionItemDo collectionItemDoNew=new CollectionItemDo();
		

		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_QUESTION_ITEM, collItemDo.getCollectionItemId(), getLoggedInSessionToken());

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateStringDataForm(collectionQuestionItemDo, "question"));
		jsonRep = jsonResponseRep.getJsonRepresentation();
		collectionItemDoNew=deserializeCollectionItem(jsonRep);
		collItemDo.setResource(collectionItemDoNew.getQuestionInfo());
		collItemDo.setStandards(collectionItemDoNew.getStandards());
		return collectionItemDoNew;
	}
}
