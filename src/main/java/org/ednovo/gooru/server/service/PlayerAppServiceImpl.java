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

import org.ednovo.gooru.client.service.PlayerAppService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceCollectionDeSerializer;
import org.ednovo.gooru.server.deserializer.ShareDeSerializer;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @fileName : PlayerAppServiceImpl.java
 *
 * @description : This is the implementation of the player services.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */

@Service("playerService")
@ServiceURL("/playerService")
public class PlayerAppServiceImpl extends BaseServiceImpl implements PlayerAppService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ShareDeSerializer shareDeSerializer;
	
	private static final String REAL_URL = "realUrl";

	/**
	 * This method is used to get simple collection details.
	 */
	@Override
	public CollectionDo getSimpleCollectionDetils(String simpleCollectionId,String resourceId,String tabview) {
		return null;
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
		CollectionDo collectionDo=new CollectionDo();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				collectionDo=JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return collectionDo;
	}
	/**
	 * @function deserializeResourceCollection 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to deserialize collection resources.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ResoruceCollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ResoruceCollectionDo deserializeResourceCollection(JsonRepresentation jsonRep) {
		ResoruceCollectionDo resourceCollectionDo=new ResoruceCollectionDo();
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				JSONObject resourceCollectionObject=jsonRep.getJsonObject();
				JSONArray collectionList=resourceCollectionObject.getJSONArray("searchResults");
				resourceCollectionDo.setTotalHitCount(resourceCollectionObject.getInt("totalHitCount"));
				List<ResourceSearchResultDo> resourceSearchResultList=new ArrayList<ResourceSearchResultDo>();
				for(int i=0;i<collectionList.length();i++){
					resourceSearchResultList.add(ResourceCollectionDeSerializer.deserializeRecord(collectionList.getJSONObject(i)));
				}
				resourceCollectionDo.setSearchResults(resourceSearchResultList);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return resourceCollectionDo;
	}

	/**
	 * This method is used to get simple collection details.
	 */
	@Override
	public CollectionDo getSimpleCollectionDetils(String apiKey,String simpleCollectionId, String resourceId, String tabView) {
		JsonRepresentation jsonRepresentation = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.GET_COLLECTION,simpleCollectionId,getLoggedInSessionToken());
		jsonRepresentation=ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCollection(jsonRepresentation);
	}
	
	/**
	 * This method is used to get resource collection list.
	 */
	public ResoruceCollectionDo getResourceCollectionsList(String gooruOid,String pageNum,String pageSize) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.RESOURCE_COLLECTION_LIST, getLoggedInSessionToken(),pageNum, pageSize, gooruOid);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getSearchUsername(), getSearchPassword());
		return deserializeResourceCollection(jsonRep);
	}
	/**
	 * This method is used to get the resoruce collection item.
	 */
	@Override
	public CollectionItemDo getResourceCollectionItem(String apiKey,String resourceId, String tabView) {
		JsonRepresentation jsonRepresentation = null;
		CollectionItemDo collectionItemDo=null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_RESOURCE_DETAILS,resourceId, getLoggedInSessionToken());
		jsonRepresentation=ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		try {
			collectionItemDo=ResourceCollectionDeSerializer.deserializeCollectionItemDo(jsonRepresentation.getJsonObject());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return collectionItemDo;
	}
	/**
	 * This method is used to get the share shorten url.
	 */
	@Override
	public Map<String, String> getShortenShareUrl(String contentGooruOid) {
		Map<String, String> shareUrls=new HashMap<String, String>();
		String embededShortenUrl= UrlGenerator.generateUrl(getHomeEndPoint()+"/" + UrlToken.COLLECTION_PLAY_EMBEDED_URL.getUrl(), contentGooruOid);
		String collectionShareUrl= UrlGenerator.generateUrl(getHomeEndPoint() +"/" + UrlToken.COLLECTION_PLAY_URL.getUrl()+"%26share=true", contentGooruOid);
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SHARE_SHORTEN_URL_PLAY, contentGooruOid, getLoggedInSessionToken(),embededShortenUrl);
		JsonRepresentation jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		String shortenUrl=shareDeSerializer.deserializeShortenUrlFromJson(jsonRep);
		shareUrls.put("embedbitlyurl", shortenUrl);
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.SHARE_SHORTEN_URL_PLAY, contentGooruOid, getLoggedInSessionToken(),collectionShareUrl);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		shortenUrl=shareDeSerializer.deserializeShortenUrlFromJson(jsonRep);
		shareUrls.put("sharebitlyurl", shortenUrl);
		shareUrls.put("shareurl", collectionShareUrl);
		return shareUrls;
	}
	/**
	 * This method is used to update the view count.
	 */
	@Override
	public String updateViewCount(String gooruid, String viewCount,String resourceType) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_VIEW_COUNT,gooruid, getLoggedInSessionToken());
		Form form=new Form();
		form.add("resourceViews", viewCount);
		form.add("sessionToken", getLoggedInSessionToken());
		ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
		return resourceType;
	}
	/**
	 * This method is used to start the player log activity.
	 */
	@Override
	public String startActivityPlayerLog(String activityEventId,String activityParentEventId, String eventName, String gooruOid,
			String resourceGooruOid, String context, String userAgent) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.START_ACTIVITY_LOG,activityEventId, getLoggedInSessionToken());
		
		Form form=new Form();
		form.add("sessionToken", getLoggedInSessionToken());
		form.add("contentGooruOid", resourceGooruOid);
		form.add("parentGooruOid", gooruOid);
		form.add("context", getLoggedInSessionToken());
		form.add("parentEventId", activityParentEventId);
		form.add("userAgent", userAgent);
		form.add("eventName", eventName);
		
		ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
		return activityEventId;
	}
	/**
	 * This method is used to stop the player log activity.
	 */
	@Override
	public String stopActivityPlayerLog(String activityEventId,String activityParentEventId, String eventName, String gooruOid,
			String resourceGooruOid, String context, String userAgent) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.STOP_ACTIVITY_LOG,activityEventId, getLoggedInSessionToken());
		
		Form form=new Form();
		form.add("sessionToken", getLoggedInSessionToken());
		form.add("contentGooruOid", resourceGooruOid);
		form.add("parentGooruOid", gooruOid);
		form.add("context", getLoggedInSessionToken());
		form.add("parentEventId", activityParentEventId);
		form.add("userAgent", userAgent);
		form.add("eventName", eventName);
		
		ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
		return activityEventId;
	}
	/**
	 * This method is used to create the session tracker.
	 */
	public String createSessionTracker(String collectionGooruOid){
		String seesionId="";
		JSONObject createSessionObject=new JSONObject();
		JSONObject sessionObject=new JSONObject();
		JSONObject collectionObject=new JSONObject();
		JsonRepresentation jsonRepresentation = null;
		try {
			collectionObject.put("gooruOid", collectionGooruOid);
			sessionObject.put("resource", collectionObject);
			sessionObject.put("mode", "test");
			createSessionObject.put("session", sessionObject);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_SESSION, getLoggedInSessionToken());
			jsonRepresentation = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),createSessionObject.toString());
			JSONObject createSessionResponse=jsonRepresentation.getJsonObject();
			seesionId=createSessionResponse.getString("sessionId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return seesionId;
	}
	
	/**
	 * This method is used to update the sessions in the collection.
	 */
	public String updateSessionInCollection(String sessionTrackerId) {
		String sessionItemId="";
		JSONObject updateSessionObject=new JSONObject();
		JSONObject sessionStatus=new JSONObject();
		JsonRepresentation jsonRepresentation = null;
		try {
			sessionStatus.put("status", "archive");
			updateSessionObject.put("session",sessionStatus);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_SESSION, sessionTrackerId,getLoggedInSessionToken());
			jsonRepresentation = ServiceProcessor.put(url, getRestUsername(), getRestPassword(),updateSessionObject.toString());
			JSONObject createSessionResponse=jsonRepresentation.getJsonObject();
			sessionItemId=createSessionResponse.getString("sessionId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sessionItemId;
	}

	public void getSessionInCollection(String sessionTrackerId) {
		
	}
	/**
	 * This method is used to create the session item in collection.
	 */
	public String createSessionItemInCollection(String sessionTrackerId,String collectionItemId, String resourceGooruOid) {
		String sessionItemId="";
		JSONObject resource=new JSONObject();
		JSONObject collectionItem=new JSONObject();
		JSONObject sessionItem=new JSONObject();
		JSONObject sessionItemObj=new JSONObject();
		JsonRepresentation jsonRepresentation = null;
		try {
			resource.put("gooruOid",resourceGooruOid);
			collectionItem.put("collectionItemId",collectionItemId);
			sessionItem.put("resource",resource);
			sessionItem.put("collectionItem",collectionItem);
			sessionItemObj.put("sessionItem",sessionItem);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_SESSION_ITEM, sessionTrackerId,getLoggedInSessionToken());
			jsonRepresentation = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),sessionItemObj.toString());
			JSONObject createSessionResponse=jsonRepresentation.getJsonObject();
			sessionItemId=createSessionResponse.getString("sessionItemId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sessionItemId;
	}
	/**
	 * This method is used to create session item attemp try.
	 */
	public String createSessionItemAttemptTry(String sessionTrackerId,String sessionItemTrackerId, Integer answerId, String attemptResult) {
		JSONObject sessionItemAttemptTry=new JSONObject();
		JSONObject assessmentAnswer=new JSONObject();
		JSONObject jsonanswerId=new JSONObject();
		try {
			jsonanswerId.put("answerId",answerId);
			assessmentAnswer.put("assessmentAnswer",jsonanswerId);
			assessmentAnswer.put("attemptItemTryStatus",attemptResult);
			sessionItemAttemptTry.put("sessionItemAttemptTry",assessmentAnswer);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_SESSION_ITEM_ATTEMPT, sessionTrackerId,sessionItemTrackerId,getLoggedInSessionToken());
			ServiceProcessor.post(url, getRestUsername(), getRestPassword(),sessionItemAttemptTry.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * This method is used to create session item attempt try for oe.
	 */
	public String createSessionItemAttemptTryForOe(String sessionTrackerId,String sessionItemTrackerId, String attemptAnswerResult) {
		JSONObject sessionItemAttemptTry=new JSONObject();
		JSONObject assessmentAnswer=new JSONObject();
		try {
			assessmentAnswer.put("answerText",attemptAnswerResult);
			sessionItemAttemptTry.put("sessionItemAttemptTry",assessmentAnswer);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_SESSION_ITEM_ATTEMPT, sessionTrackerId,sessionItemTrackerId,getLoggedInSessionToken());
			ServiceProcessor.post(url, getRestUsername(), getRestPassword(),sessionItemAttemptTry.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * This method is used to send email.
	 */
	@Override
	public String sendEmail(String fromEmail, String toEmail, String copyEmail,String subject, String message) {
		JSONObject mailJsonObject=new JSONObject();
		try {
			mailJsonObject.put("from", fromEmail);
			mailJsonObject.put("to", toEmail);
			mailJsonObject.put("cfm", copyEmail);
			mailJsonObject.put("subject", subject);
			mailJsonObject.put("message", message);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_SOCIAL_EMAIL,getLoggedInSessionToken());
			ServiceProcessor.post(url, getRestUsername(), getRestPassword(),mailJsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * This method is used to get the user profile visiblity.
	 */
	public boolean getUserProfileVisibility(String gooruUid){
		boolean userProfileVisibility=true;
		JsonRepresentation jsonRep =null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_PROFILE,gooruUid,getLoggedInSessionToken());
		jsonRep =ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return userProfileVisibility;
	}
	/**
	 * This method is used to copy the collection.
	 */
	@Override
	public String copyCollection(String collectionId, String collectionTitle) {
		String copiedCollectionId="";
//		JSONObject copyCollectionObj=new JSONObject();
//		JSONObject collection=new JSONObject();
		try {
//			collection.put("collectionType", "collection");
//			collection.put("title", collectionTitle);
//			copyCollectionObj.put("collection", collection);
//			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_COPY_COLLECTION, collectionId,getLoggedInSessionToken());
//			System.out.println("V2_COPY_COLLECTIONurl===>"+url);
//			System.out.println("form data json===>"+copyCollectionObj.toString());
//			JsonRepresentation jsonRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword(),copyCollectionObj.toString());
//			if(jsonRep!=null){
//				JSONObject copiedCollectionObj=new JSONObject(jsonRep);
//				copiedCollectionId=copiedCollectionObj.getString("gooruOid");
//			}
			collectionTitle = collectionTitle.trim();
			collectionTitle=URLEncoder.encode(collectionTitle);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_RENAME_COLLECTION, collectionId,getLoggedInSessionToken(),"true",collectionTitle);
			System.out.println("COPY_COLLECTIONurl===>"+url);
			JsonRepresentation jsonRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword());
			if(jsonRep!=null){
				JSONObject copiedCollectionObj=jsonRep.getJsonObject();
				copiedCollectionId=copiedCollectionObj.getString("gooruOid");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return copiedCollectionId;
	}
	/**
	 * This method is used to copy collection items.
	 */
	@Override
	public String copyCollectionItem(String collectionItemId, String collectionId) {
		String copiedCollectionItemId="";
		try {
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_RESOURCCE,getLoggedInSessionToken());
			Form form=new Form();
			form.add("sessionToken", getLoggedInSessionToken());
			form.add("resourceId=",collectionItemId);
			form.add("collectionId",collectionId);
			form.add("data","{\"collectionItem\":{\"itemType\":\"subscribed\"}}");
			System.out.println(" cpy resource url===>"+url);
			System.out.println(" form data...===>"+form.toString());
			JsonRepresentation jsonRep=ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
			if(jsonRep!=null){
				JSONObject copiedCollectionObj=jsonRep.getJsonObject();
				//copiedCollectionItemId=copiedCollectionObj.getString("collectionItemId");
			}
			
//			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_COPY_COLLECTION_ITEM,collectionItemId, collectionId,getLoggedInSessionToken());
//			System.out.println("V2_COPY_COLLECTIONurl===>"+url);
//			JsonRepresentation jsonRep=ServiceProcessor.put(url, getRestUsername(), getRestPassword());
//			if(jsonRep!=null){
//				JSONObject copiedCollectionObj=jsonRep.getJsonObject();
//				copiedCollectionItemId=copiedCollectionObj.getString("collectionItemId");
//			}
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		return copiedCollectionItemId;
	}
	/**
	 * This method is used to get the workspace collections.
	 */
	@Override
	public ArrayList<CollectionItemsList> getWorkspaceCollections(String userId,String offset,String limit) {
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_USER_WORKSPACE,getLoggedInSessionToken(),offset,limit);
			System.out.println("V2_GET_USER_WORKSPACE url===>"+url);
			JsonRepresentation jsonRep=ServiceProcessor.get(url, getRestUsername(), getRestPassword());
			return deserializeUserCollections(jsonRep);
	}
	
	/**
	 * @function deserializeUserCollections 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to deserialize the user collections.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<CollectionItemsList>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ArrayList<CollectionItemsList> deserializeUserCollections(JsonRepresentation jsonRep){
		ArrayList<CollectionItemsList> resourceModelList=new ArrayList<CollectionItemsList>();
		try {
			if(jsonRep!=null){
				JSONArray myCollectionArryObj=jsonRep.getJsonArray();
				for(int i=0;i<myCollectionArryObj.length();i++){
					JSONObject myCollectionObj=myCollectionArryObj.getJSONObject(i);
					String myCollectionTitle=myCollectionObj.isNull("title")?"":myCollectionObj.getString("title").toString();
					String mycollectionGid=myCollectionObj.isNull("gooruOid")?"":myCollectionObj.getString("gooruOid").toString();
					String myCollectionType=myCollectionObj.isNull("collectionType")?"":myCollectionObj.getString("collectionType").toString();
					int collectionItemsListSize = 0;
					if(!myCollectionObj.isNull("collectionItems")){
						JSONArray collectionInfo=myCollectionObj.getJSONArray("collectionItems");
						collectionItemsListSize = collectionInfo.length();
					}
					CollectionItemsList collectionDetails=new CollectionItemsList();
					collectionDetails.setCollectionTitle(myCollectionTitle);
					collectionDetails.setCollectionId(mycollectionGid);
					collectionDetails.setCollectionType(myCollectionType);
					collectionDetails.setCollectionItemsListSize(collectionItemsListSize);
					resourceModelList.add(collectionDetails);
				}//main for loop
			}			
		}//try end
		catch (JSONException e) {
			e.printStackTrace();
		}
		return resourceModelList;
	}
	/**
	 * This method is used to update content thumbs rating.
	 */
	@Override
	public String updateContentThumbsRating(String resourceGooruOid,int userThumbsRataing) {
		JSONObject scoreObject=new JSONObject();
		try {
			scoreObject.put("score",userThumbsRataing);
			String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CONTENT_THUMBS_RATING,resourceGooruOid,getLoggedInSessionToken());
			System.out.println("thumbsratng---====>"+url);
			Form form=new Form();
			form.add("score",""+userThumbsRataing);
			form.add("sessionToken",getLoggedInSessionToken());
			//ServiceProcessor.put(url, getRestUsername(), getRestPassword(),scoreObject.toString());
			ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
