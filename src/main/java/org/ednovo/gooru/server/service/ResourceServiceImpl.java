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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.service.ResourceService;
import org.ednovo.gooru.player.resource.server.CreateContentReportController;
import org.ednovo.gooru.player.resource.shared.GetFlagContentDO;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.content.CollectionAddQuestionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsListDo;
import org.ednovo.gooru.shared.model.content.CollectionProfileItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.NewResourceDo;
import org.ednovo.gooru.shared.model.content.PermissionsDO;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
/**
 * 
 * @fileName : ResourceServiceImpl.java
 *
 * @description : This method is used to get Resource data through service.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
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
	
	private static final String NEW_RESOURCE = "newResource";
	
	@Autowired
	ResourceDeserializer resourceDeserializer;

/**
 * @description : This method is used to create collection.
 */
	@Override
	public CollectionDo createCollection(CollectionDo collectionDo, String codeId) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, TRUE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		return deserializeCollection(jsonRep);

	}
/**
 * @description : This method is used to create collection in parent .
 */
	@Override
	public CollectionDo createCollectionInParent(CollectionDo collectionDo, String codeId, String parentId) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, FALSE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}
		form.add(PARENT_ID, parentId);
		
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		return deserializeCollection(jsonRep);

	}

	/*@Override
	public CollectionDo updateCollection(CollectionDo collectionDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION, collectionDo.getGooruOid(), getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionDo, COLLECTION));
		return deserializeCollection(jsonRep);
	}*/
/**
 * @description : This method is used to delete collection.
 */
	@Override
	public void deleteCollection(String collectionId) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLECTION, collectionId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
/**
 * @description : This method is used to create collection item.
 */
	@Override
	public CollectionItemDo createCollectionItem(String collectionId, String resourceId) {
		JsonRepresentation jsonRep = null;
		CollectionProfileItemDo collectionItemDo = new CollectionProfileItemDo();
		collectionItemDo.setItemType(ADDED);

		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLECTION_ITEM, getLoggedInSessionToken(), resourceId, collectionId);
//		String url = null;
//		
//		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLLECTION_ITEM, resourceId,getLoggedInSessionToken(), collectionId);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionItemDo, "collectionItem"));		
		
		return deserializeCollectionItem(jsonRep);
	}

	/*@Override
	public CollectionItemDo updateCollectionItem(CollectionItemDo collectionItemDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLECTION_ITEM, collectionItemDo.getCollectionItemId(), getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionItemDo, "collectionItem"));
		return deserializeCollectionItem(jsonRep);
	}*/
/**
 * @description : This method is used to delete collection item.
 */
	@Override
	public void deleteCollectionItem(String collectionItemId) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLECTION_ITEM, collectionItemId, getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
 /**
  * @description : This method is used to re order collection Item.
  */
	@Override
	public CollectionItemDo reorderCollectionItem(CollectionItemDo collectionItemDo) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.REORDER_COLLECTION_ITEM, collectionItemDo.getCollectionItemId(), getLoggedInSessionToken(), collectionItemDo.getItemSequence() + "");
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		return deserializeCollectionItem(jsonRep);
	}
/**
 * @description : This method is used to copy collection.
 */
	@Override
	public CollectionDo copyCollection(CollectionDo collectionDo, String addToShelf, String taxonomyCode) {
		Map<String,String> params = new HashMap<String, String>();
		if(collectionDo.getGrade() != null) {
			params.put(GRADE, collectionDo.getGrade());
		}
		if(collectionDo.getTitle() != null) {
			params.put(TITLE, collectionDo.getTitle());
		}
		if(taxonomyCode != null) {
			params.put(TAXONOMY_CODE, taxonomyCode);
		}
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLECTION, params, collectionDo.getGooruOid(), getLoggedInSessionToken(), FALSE, addToShelf);
		
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		return deserializeCollection(jsonRep);
	}

	/*@Override
	public List<CollectionItemDo> getCollectionItems(CollectionDo collectionDo) {
		String pageNum = "1";
		String pageSize = "10";
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION_ITEMS, collectionDo.getGooruOid(), getLoggedInSessionToken(), pageSize, pageNum);
		return deserializeCollectionItems(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));

	}*/
	
	
/**
 * @description : This method is used to get collection.
 */
	@Override
	public CollectionDo getCollection(String collectionGooruOid, boolean skipCollectionItem) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION, collectionGooruOid, getLoggedInSessionToken(), skipCollectionItem + "");
		return deserializeCollection(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));

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
/**
 * @description : This method is used for getting user collection.
 */
	@Override
	public List<CollectionDo> getUserCollection() {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_COLLECTION, JSON, getLoggedInSessionToken());
		return deserializeCollections(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
/**
 * 
 * @function deserializeResourceMetaInfo 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to deserialize Resource Meta Info
 * 
 * 
 * @parm(s) : @param jsonRep
 * @parm(s) : @return
 * 
 * @return : ResourceMetaInfoDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
	/**
	 * 
	 * @function deserializeCollection 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to deserialize collection.
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
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}
	/**
	 * 
	 * @function deserializeCollectionItem 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to deserialize collection item.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionItemDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */

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
	/**
	 * 
	 * @function deserializeCollectionQuestionItemDo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize collection Question item 
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionQuestionItemDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */

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
	/**
	 * 
	 * @function deserializePermissions 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : PermissionsDO
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public PermissionsDO  deserializePermissions(JsonRepresentation jsonRep){
		if(jsonRep !=null && jsonRep.getSize() !=-1){
			try{
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), PermissionsDO.class);
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new PermissionsDO();
	}
	/**
	 * 
	 * @function deserializeCollections 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize collections.
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
/**
 * 
 * @function deserializeMyUserCollections 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to deserialize User collections.
 * 
 * 
 * @parm(s) : @param jsonRep
 * @parm(s) : @return
 * 
 * @return : List<CollectionItemsListDo>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
/**
 * 
 * @function deserializeCollectionItems 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to deserialize Collection items.
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
	/**
	 * 
	 * @function deserializeCollaborators 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize collaborators.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<UserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
	

	/**
	 * This method is used to create collection with item.
	 */
	@Override
	public CollectionDo createCollectionWithItem(CollectionDo collectionDo, String codeId, String resourceId) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_COLLLECTION, getLoggedInSessionToken());
		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTION);
		form.add(ADD_TO_SHELF, TRUE);
		if (codeId != null) {
			form.add(TAXONOMY_CODE, codeId);
		}
		if (resourceId != null) {
			form.add(RESOURCE_ID, resourceId);
		}
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		return deserializeCollection(jsonRep);
	}
/**
 * This method is used to update collection meta data .
 * 
 */
	@Override
	public CollectionDo updateCollectionMetadata(String collectionId, String title, String description, String grade, String sharing, String vocabulary, String taxonomyCode, String updateTaxonomyByCode, String mediaType,String action) {
		JsonRepresentation jsonRep = null;
	    String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION_METADATA, collectionId, getLoggedInSessionToken());
	    jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollection(title, description, grade, sharing, vocabulary, taxonomyCode, updateTaxonomyByCode,mediaType, action));
//	    try {
//			//System.out.println("updateCollectionMetadata::::"+jsonRep.getText());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    return deserializeCollection(jsonRep);
	}
/**
 * This method is used to deserialize update collection Item meta data 
 */
	@Override
	public CollectionItemDo updateCollectionItemMetadata(String collectionItemId, String narration, String narrationType, String start, String stop) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION_ITEM_METADATA, collectionItemId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateCollectionItem(narration, narrationType, start, stop));
		return deserializeCollectionItem(jsonRep);

	}
	/**
	 * This method is used to add Collaborator .
	 */
	
	@Override
	public UserDo addCollaborator(String gooruOid,String collaboratorId){
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ADD_COLLABORATOR, gooruOid, collaboratorId, getLoggedInSessionToken());
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), new Form());
		try {
			userDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), UserDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return userDo;
	}
	/**
	 * This method is used to get Collaborators
	 */
	@Override
	public List<UserDo> getCollaborators(String gooruOid){
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLABORATOR, gooruOid, getLoggedInSessionToken());
		JsonRepresentation json = ServiceProcessor.get(url,getRestUsername(), getRestPassword());
		return deserializeCollaborators(json);
	}
	/**
	 * This method is used to delete collaborators.
	 */
	@Override
	public UserDo deleteCollaborators(String gooruOid,String collaboratorId){
		UserDo userDo = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_COLLABORATOR, gooruOid, collaboratorId, getLoggedInSessionToken());
		JsonRepresentation jsonRep = ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
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
	/**
	 * This method is used to get youtube duration.
	 */
	@Override
	public String getYoutubeDuration(String videoId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = YOUTUBE_BEGIN_URL+videoId+YOUTUBE_END_URL;
		jsonRep = ServiceProcessor.get(url);
		return resourceDeserializer.serializeYoutubeInfo(jsonRep);
	}

	/*@Override
	public List<CollectionItemsListDo> getMyUserCollections() throws GwtException{
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_COLLECTIONS, getLoggedInSessionToken());
		return deserializeMyUserCollections(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}*/
/**
 * This method is used to add New Resource.
 */
	public CollectionItemDo addNewResource(String gooruOid, String idStr,
			String urlStr, String titleStr, String descriptionStr,
			String categoryStr, String thumbnailImgSrcStr, Integer endTime) throws GwtException {
		
		NewResourceDo newResourceDo = new NewResourceDo();
		
		newResourceDo.setId(idStr);
		newResourceDo.setUrl(urlStr);
		newResourceDo.setTitle(titleStr);
		newResourceDo.setDescription(descriptionStr);
		newResourceDo.setCategory(categoryStr);
		newResourceDo.setStop(endTime);
		
		if (thumbnailImgSrcStr==null){
			thumbnailImgSrcStr="";
		}
		
		if (urlStr.indexOf("youtube") > 0){
			newResourceDo.setThumbnailImgUrl("");
		}else{
			newResourceDo.setThumbnailImgUrl(thumbnailImgSrcStr);
		}
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ADD_NEW_RESOURCE, idStr,getLoggedInSessionToken(),  URLEncoder.encode(titleStr).toString(), urlStr, categoryStr, URLEncoder.encode(descriptionStr).toString(), thumbnailImgSrcStr, String.valueOf(endTime));
		
		Form form = ResourceFormFactory.generateDataForm(newResourceDo, RESOURCE);
		form.add(NEW_RESOURCE, TRUE);

		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		return deserializeCollectionItem(jsonRep);
	}
/**
 * This method is used to Get Resource meta data information.
 */
	@Override
	public ResourceMetaInfoDo getResourceMetaInfo(String url) throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String urlStr = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_RESOURCE_INFO, getLoggedInSessionToken(), url);
		jsonRep = ServiceProcessor.get(urlStr);
		return deserializeResourceMetaInfo(jsonRep);
	}
	/**
	 * This method is used to Check If resources exits.
	 */
	@Override
	public ExistsResourceDo checkResourceExists(String url) throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String urlStr = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CHECK_RESOURCE_EXISTS, url, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(urlStr);
		return deserializeResourceItem(jsonRep);
	}
	/**
	 * 
	 * @function deserializeResourceItem 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to deserialize Resource item.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ExistsResourceDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
/**
 * 
 * @function deserializeResourceDoItem 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to deserialize Resource Item.
 * 
 * 
 * @parm(s) : @param jsonRep
 * @parm(s) : @return
 * 
 * @return : ResourceDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
	
/**
 * This method is used to add question resources.
 */
	@Override
	public CollectionItemDo addQuestionResource(String collectionId, String mediafileName, CollectionQuestionItemDo collectionQuestionItemDo) throws GwtException {
		JsonRepresentation jsonRep = null;
		//String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ADD_QUESTION_ITEM, collectionId, getLoggedInSessionToken());
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_ADD_QUESTION_ITEM, collectionId, getLoggedInSessionToken());
//		Form collectionQuestionForm=ResourceFormFactory.generateDataForm(collectionQuestionItemDo, "question");
//		collectionQuestionForm.add("mediaFileName", mediafileName);
//		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), collectionQuestionForm);
		CollectionAddQuestionItemDo collectionAddQuestionItemDo=new CollectionAddQuestionItemDo();
		collectionAddQuestionItemDo.setQuestion(collectionQuestionItemDo);
		collectionAddQuestionItemDo.setMediaFileName(mediafileName);
		String collectionQuestionData=ResourceFormFactory.generateStringDataForm(collectionAddQuestionItemDo, null);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), collectionQuestionData);
		return deserializeCollectionItem(jsonRep);
	}
/**
 * This method is used to Update Question Resources.
 */
	@Override
	public CollectionItemDo updateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_QUESTION_ITEM, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken());
		if(thumbnailUrl!=null){
			updateQuestionImage(collectionItemDo.getResource().getGooruOid(),thumbnailUrl);
		}
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionQuestionItemDo, "question"));
		ResourceDo resourceDo=deserializeResourceDoItem(jsonRep);
		return convertResourceToCollectionItemDo(resourceDo,collectionItemDo);
	}
/**
 * This method is used to Update Resources Information.
 */
	@Override
	public CollectionItemDo updateResourceInfo(CollectionItemDo collectionItemDo)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url =null;
		
		if (collectionItemDo.getResource().getThumbnails().getUrl() == null){ 
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_RESOURCE_INFO_NO_MEDIA, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken(), collectionItemDo.getResource().getTitle(), collectionItemDo.getResource().getDescription(), collectionItemDo.getResource().getCategory());
		}else{
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_RESOURCE_INFO, collectionItemDo.getResource().getGooruOid(), getLoggedInSessionToken(), collectionItemDo.getResource().getTitle(), collectionItemDo.getResource().getDescription(), collectionItemDo.getResource().getCategory(), collectionItemDo.getResource().getThumbnails().getUrl());
		}
				
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		return deserializeCollectionItem(jsonRep);
	}
	/**
	 * This method is used to remove question Image.
	 */
	public void removeQuestionImage(String collectionQuestionId) throws GwtException{
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.REMOVE_QUESTION_IMAGE, collectionQuestionId, getLoggedInSessionToken());
		jsonRep=ServiceProcessor.delete(url, getRestUsername(), getRestPassword());  
	}
/**
 * This method is used to Update Question Image.
 */
	@Override
	public void updateQuestionImage(String collectionItemId, String fileName) throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.ATTACH_IMAGE_TO_QUESTION, collectionItemId, getLoggedInSessionToken(),fileName);
		jsonRep=ServiceProcessor.post(url, getRestUsername(), getRestPassword());  
//		try {
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
/**
 * This method is used to Copy collection Item.
 */
	@Override
	public CollectionItemDo copyCollectionItem(String collectionId, String resourceId) {
		JsonRepresentation jsonRep = null;
		CollectionProfileItemDo collectionItemDo = new CollectionProfileItemDo();
		collectionItemDo.setItemType(ADDED);

		String url = null;		
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLLECTION_ITEM, resourceId,getLoggedInSessionToken(), collectionId);
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.generateDataForm(collectionItemDo, "collectionItem"));
		return deserializeCollectionItem(jsonRep);
	}
/**
 * This method is used to Get User Collection List.
 */
	@Override
	public List<CollectionDo> getUserCollectionList(Integer pageSize,
			Integer pageNum, boolean isSharable) throws GwtException {
		String pageNum1 =Integer.toString(pageNum);
		String pageSize1 = Integer.toString(pageSize);
		String url = null;

		if (isSharable){
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SHARABLE_USER_COLLECTION, JSON, getLoggedInSessionToken()+"&pageSize="+pageSize1+"&pageNum="+pageNum1);
		}else{
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.USER_COLLECTION, JSON, getLoggedInSessionToken()+"&pageSize="+pageSize1+"&pageNum="+pageNum1);
		}
		return deserializeCollections(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));

	}

	/**
	 * This method is used to Get Permissions.
	 */
	
	@Override
	public PermissionsDO getPermissions(String collectionId)throws GwtException {
		String url=null;
		JsonRepresentation jsonRep = null;
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.PERMISSION_COLLECTION, collectionId,getLoggedInSessionToken());
	    jsonRep = ServiceProcessor.get(url);
		return deserializePermissions(jsonRep);
	}

	/**
	 * This method is used to Check url shorten.
	 */
	@Override
	public String checkShortenUrl(String shortenUrl) throws GwtException { 
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CHECK_SHORTEN_URL,shortenUrl,getLoggedInSessionToken()); 
		jsonRep = ServiceProcessor.get(url);
		boolean isShortenUrl=false;
		try {
			
			isShortenUrl=jsonRep.getJsonObject().getJSONObject("resource").getBoolean("shortenedUrlStatus");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isShortenUrl ? "true" : "false";
		
		
	}
/**
 * 
 * @function getCollection 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get collection
 * 
 * 
 * @parm(s) : @param collectionGooruOid
 * @parm(s) : @return
 * 
 * @return : CollectionDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public CollectionDo getCollection(String collectionGooruOid){
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION, collectionGooruOid, getGuestSessionToken(""), "true");
		return deserializeCollection(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
/**
 * 
 * @function getCollectionFromEmbed 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description : This method is used to Get Collection from embed.
 * 
 * 
 * @parm(s) : @param collectionGooruOid
 * @parm(s) : @param restEndPointFromEmbed
 * @parm(s) : @return
 * 
 * @return : CollectionDo
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public CollectionDo getCollectionFromEmbed(String collectionGooruOid, String restEndPointFromEmbed){
		String url = UrlGenerator.generateUrl(restEndPointFromEmbed, UrlToken.GET_COLLECTION, collectionGooruOid, getGuestSessionToken(restEndPointFromEmbed), "true");
		return deserializeCollection(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
/**
 * This method is used to Add new user Resource .
 */
	@Override
	public CollectionItemDo addNewUserResource(	String jsonString,String gooruOid)throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_ADD_NEW_USER_RESOURCE, gooruOid, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), jsonString);
		
		
		return deserializeCollectionItem(jsonRep);
	}
/**
 * This method is used to Save User Own Resources.
 */
	@Override
	public MediaUploadDo saveUserOwnResource(String fileName) throws GwtException {
		MediaUploadDo mediaUploadDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_USER_RESOURCE_MEDIA_FILE_SAVE, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.post(url, getRestUsername(),	getRestPassword(),fileName);
		mediaUploadDo = JsonDeserializer.deserialize(jsonRep.toString(), MediaUploadDo.class);
		
		return mediaUploadDo;
	}
	/**
	 * 
	 * @function convertResourceToCollectionItemDo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to convert resource to collection item .
	 * 
	 * 
	 * @parm(s) : @param resourceDo
	 * @parm(s) : @param collectionItemDo
	 * @parm(s) : @return
	 * 
	 * @return : CollectionItemDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionItemDo convertResourceToCollectionItemDo(ResourceDo resourceDo,CollectionItemDo collectionItemDo){	
		
		collectionItemDo.setResource(resourceDo);// replacing the update question details Do
		collectionItemDo.setCollectionQuestionItemDo(null);// removing existing collection item object details.
		
		return collectionItemDo;
	}
/**
 * This method is used to Update user own Resources.
 */
	@Override
	public CollectionItemDo updateUserOwnResource(String jsonString,String gooruOid) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_USER_RESOURCE, gooruOid, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), jsonString);
		
		return deserializeCollectionItem(jsonRep);
	}
/**
 * This method is used to Update Narration Meta data
 */
	@Override
	public CollectionItemDo updateNarrationMetadata(String collectionItemId,
			String narration, String narrationType) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_COLLLECTION_ITEM_METADATA, collectionItemId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), ResourceFormFactory.updateNarrationItem(narration, narrationType));
		return deserializeCollectionItem(jsonRep);

	}
/**
 * This method is used to Create content Report.
 */
	@Override
	public void createContentReport(String assocGooruOid, String targetValue, String typesvalue1,
			String typesvalue2, String typesvalue3, String typesvalue4,
			String otherDescription) {
		new CreateContentReportController().createCollectionContentreport(getRestEndPoint(), getLoggedInSessionToken(), assocGooruOid, targetValue,typesvalue1,typesvalue2,typesvalue3, typesvalue4,otherDescription);
	}
/**
 * This method is used to Update Report.
 */
	@Override
	public String updateReport(String gooruOid, String freeText) {
		new CreateContentReportController().updateReport(getRestEndPoint(), getLoggedInSessionToken(), gooruOid, freeText);
		return freeText;
	}
/**
 * This method is used to get Content Report.
 */
	@Override
	public GetFlagContentDO getContentReport(String assocGooruOid) {
		return new CreateContentReportController().getContentReport(getRestEndPoint(),getLoggedInSessionToken(),assocGooruOid);
	}
/**
 * This method is used to Delete Content Report.
 */
	@Override
	public String deleteContentReport(String gooruOid) {
		return new CreateContentReportController().deleteContentReport(getRestEndPoint(),getLoggedInSessionToken(),gooruOid);
	}

	
	
}
