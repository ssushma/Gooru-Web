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
import java.util.List;

import org.ednovo.gooru.client.service.AnalyticsService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;


@Service("analyticsService")
@ServiceURL("/analyticsService")
public class AnalyticsServiceImpl extends BaseServiceImpl implements AnalyticsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<CollectionProgressDataDo> getCollectionProgressData(String collectionId,String classPageId) {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionProgressDataDo> collectionProgressDataList=new ArrayList<CollectionProgressDataDo>();
		String dataPassing="{%22fields%22:%22timeSpent,avgTimeSpent,resourceGooruOId,OE,questionType,category,gooruUId,userName,userData,metaData,reaction,gooruOId,title,description,options,skip%22,%22filters%22:{%22session%22:%22FS%22,%22classId%22:%22"+classPageId+"%22},%22paginate%22:{%22sortBy%22:%22itemSequence%22,%22sortOrder%22:%22ASC%22}}";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_COLLECTIONPROGRESSDATA, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionProgressDataList= (ArrayList<CollectionProgressDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionProgressDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionProgressDataList;
	}

	@Override
	public ArrayList<CollectionSummaryUsersDataDo> getCollectionSummaryUsersData(String classpageId) {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionSummaryUsersDataDo> collectionSummaryUsersDataDoList=new ArrayList<CollectionSummaryUsersDataDo>();
		String dataPassing="{%22fields%22:%22userGroupUId,userName,gooruUId%22}";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETUSERSFORPATHWAY, classpageId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionSummaryUsersDataDoList= (ArrayList<CollectionSummaryUsersDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionSummaryUsersDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionSummaryUsersDataDoList;
	}

	@Override
	public ArrayList<CollectionSummaryMetaDataDo> getCollectionMetaData(String collectionId,String classpageId) {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionSummaryMetaDataDo> collectionSummaryMetaDataDoList=new ArrayList<CollectionSummaryMetaDataDo>();
		
		String dataPassing="{%22fields%22:%22thumbnail,userCount,lastModified,timeSpent,views,avgTimeSpent,OE,gooruOId,title,description,options,skip,score,avgReaction,totalQuestionCount,gradeInPercentage%22,%22filters%22:{%22userUId%22:%22%22,%22session%22:%22AS%22,%22sessionId%22:%22%22,%22classId%22:%22"+classpageId+"%22}}";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETCOLLECTIONMETADATA, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionSummaryMetaDataDoList= (ArrayList<CollectionSummaryMetaDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionSummaryMetaDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionSummaryMetaDataDoList;
	}

	@Override
	public ArrayList<UserDataDo> getCollectionResourceData(String collectionId,String classpageId) {
		JsonRepresentation jsonRep = null;
		ArrayList<UserDataDo> collectionResourcesList=new ArrayList<UserDataDo>();
		
		String dataPassing="{%22fields%22:%22answerObject,score,totalAttemptUserCount,timeSpent,views,avgTimeSpent,OE,collectionGooruOId,category,resourceGooruOId,metaData,title,questionType,options,description,options,skip,totalInCorrectCount,avgReaction,reaction,attempts,text,totalCorrectCount,itemSequence%22,%22filters%22:{%22userUId%22:%22%22,%22session%22:%22AS%22,%22sessionId%22:%22%22,%22classId%22:%22"+classpageId+"%22},%22paginate%22:{%22sortBy%22:%22itemSequence%22,%22sortOrder%22:%22ASC%22}}";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETCOLLECTIONRESOURCEDATA, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionResourcesList= (ArrayList<UserDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<UserDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionResourcesList;
	}

	@Override
	public ArrayList<CollectionSummaryUsersDataDo> getSessionsDataByUser(
			String collectionId, String classId, String userId) {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionSummaryUsersDataDo> sessionDataList=new ArrayList<CollectionSummaryUsersDataDo>();
		//String url ="http://www.goorulearning.org/insights/api/v1/classpage/fe78faa5-f7f0-4927-9282-a58a4e3deb5d/sessions.json?sessionToken=959afdf0-39a3-11e4-8d6c-123141016e2a&data={%22fields%22:%22%22,%22filters%22:{%22userUId%22:\""+userId+"\",%22classId%22:\""+classId+"\"},%22paginate%22:{%22sortBy%22:%22timeStamp%22,%22sortOrder%22:%22ASC%22}}&timestamp=1410441363771";
		String dataPassing ="{%22fields%22:%22%22,%22filters%22:{%22userUId%22:\""+userId+"\",%22classId%22:%22"+classId+"%22},%22paginate%22:{%22sortBy%22:%22timeStamp%22,%22sortOrder%22:%22ASC%22}}&";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETSESSIONSDATABYUSER, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				sessionDataList= (ArrayList<CollectionSummaryUsersDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionSummaryUsersDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return sessionDataList;
	}

	@Override
	public ArrayList<UserDataDo> getUserSessionDataByUser(String collectionId,
			String classId, String userId,String sessionId) {
		JsonRepresentation jsonRep = null;
		ArrayList<UserDataDo> collectionResourcesList=new ArrayList<UserDataDo>();
		String dataPassing ="{%22fields%22:%22answerObject,score,totalAttemptUserCount,timeSpent,views,avgTimeSpent,OE,collectionGooruOId,category,resourceGooruOId,metaData,title,questionType,options,description,options,skip,totalInCorrectCount,avgReaction,reaction,attempts,text,totalCorrectCount,itemSequence%22,%22filters%22:{%22userUId%22:%22"+userId+"%22,%22session%22:%22CS%22,%22sessionId%22:%22"+sessionId+"%22,%22classId%22:%22"+classId+"%22},%22paginate%22:{%22sortBy%22:%22itemSequence%22,%22sortOrder%22:%22ASC%22}}&timestamp=1410757700537";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETSESSIONDATABYUSERSESSION, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionResourcesList= (ArrayList<UserDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<UserDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionResourcesList;
	}

	@Override
	public ArrayList<CollectionSummaryMetaDataDo> getCollectionMetaDataByUserAndSession(
			String collectionId, String classId, String userId, String sessionId) {
		JsonRepresentation jsonRep = null;
		ArrayList<CollectionSummaryMetaDataDo> collectionSummaryMetaDataDoList=new ArrayList<CollectionSummaryMetaDataDo>();
		String dataPassing="{%22fields%22:%22thumbnail,userCount,lastModified,timeSpent,views,avgTimeSpent,OE,gooruOId,title,description,options,skip,score,avgReaction,totalQuestionCount,gradeInPercentage%22,%22filters%22:{%22userUId%22:%22"+userId+"%22,%22session%22:%22CS%22,%22sessionId%22:%22"+sessionId+"%22,%22classId%22:%22"+classId+"%22}}";
		String url = UrlGenerator.generateUrl(getAnalyticsEndPoint(), UrlToken.V1_GETCOLLECTIONMETADATA, collectionId,"64daf466-3711-11e4-8d6c-123141016e2a",dataPassing);
		System.out.println("url:+"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		if(jsonResponseRep.getStatusCode()==200){
			try {
				collectionSummaryMetaDataDoList= (ArrayList<CollectionSummaryMetaDataDo>) JsonDeserializer.deserialize(jsonRep.getJsonObject().getJSONArray("content").toString(),new TypeReference<List<CollectionSummaryMetaDataDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
		}
		return collectionSummaryMetaDataDoList;
	}

	@Override
	public void getMinimumScoredBelowData(String collectionId, String classId,
			String score) {
		
	}

	@Override
	public void getMinimumScoredAboveData(String collectionId, String classId,
			String score) {
		
	}

	@Override
	public void setHTMLtoPDF(String htmlString) {
		String url = "http://www.goorulearning.org/gooruapi/rest/v2/media/htmltopdf?sessionToken=aec96f9c-42df-11e4-8d6c-123141016e2a";
		JsonRepresentation jsonRep = null;
		String dataPassing="{%22fileName%22:%22Mymedia%22,%22html%22:%22"+htmlString+"%22}";
		System.out.println(dataPassing);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), dataPassing);
		jsonRep = jsonResponseRep.getJsonRepresentation(); 
		System.out.println(jsonResponseRep.getStatusCode());
		if(jsonResponseRep.getStatusCode()==200){
			
		}else{
			
		}		
	}
}
