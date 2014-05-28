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
package org.ednovo.gooru.client.util;

import java.util.List;
import org.ednovo.gooru.client.gin.AppClientFactory;


import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;



public class PlayerDataLogEvents {
	
	public static final String COLLECTION_PLAY_EVENT_NAME="collection-play-dots";
	public static final String COLLECTION_RESOUCE_PLAY_EVENT_NAME="collection-resource-play-dots";
	public static final String COLLECTION_QUESTION_PLAY_EVENT_NAME="collection-question-resource-play-dots";
	public static final String COLLECTION_RESOURCE_HINT_EVENT_NAME="collection-resource-hint-play-dots";
	public static final String COLLECTION_RESOURCE_EXPLANATION_EVENT_NAME="collection-resource-explanation-play-dots";
	public static final String COLLECTION_RESOURCE_OE_EVENT_NAME="collection-resource-oe-play-dots";
	public static final String COLLECTION_RESOURCE_OE_HINT_EVENT_NAME="collection-resource-oe-hint-play-dots";
	public static final String COLLECTION_RESOURCE_OE_EXPLANATION_EVENT_NAME="collection-resource-oe-explanation-play-dots";
	public static final String COLLECTION_RESOURCE_OE_SUBMIT_EVENT_NAME="collection-resource-oe-save-dots";
	public static final String RESOUCE_PLAY_EVENT_NAME="resource-play-dots";
	public static final String QUESTION_RESOUCE_PLAY_EVENT_NAME="question-play-dots";
	public static final String QUESTION_RESOURCE_OE_EVENT_NAME="question-oe-play-dots";
	public static final String QUESTION_RESOURCE_HINT_EVENT_NAME="question-hint-play-dots";
	public static final String QUESTION_RESOURCE_EXPLANATION_EVENT_NAME="question-explanation-play-dots";
	public static final String QUESTION_OE_HINT_EVENT_NAME="question-oe-hint-play-dots";
	public static final String QUESTION_OE_EXPLANATION_EVENT_NAME="question-oe-explanation-play-dots";
	public static final String QUESTION_OE_SAVE_EVENT_NAME="question-oe-save-dots";
	public static final String OPEN_SESSION_STATUS="open";
	public static final String CLOSE_SESSION_STATUS="close";
	public static final String START_EVENT_TYPE="start";
	public static final String STOP_EVENT_TYPE="stop";
	
	// new events implementation text
	// Event Names 
	public static final String COLLECTION_PLAY="collection.play";
	public static final String COLLECTION_RESOURCE_PLAY="collection.resource.play";
	public static final String RESOURCE_PLAY="resource.play";
	public static final String CLASSPAGE_VIEW="classpage.view";
	public static final String REACTION_CREATE="reaction.create";
	public static final String REACTION_DELETE="reaction.delete";
	public static final String COLLECTION_RESOURCE_SAVE="collection.resource.save";
	public static final String RESOURCE_SAVE="resource.save";
	
	//event keys
	public static final String EVENTID="eventId";
	public static final String EVENTNAME="eventName";
	public static final String SESSION="session";
	public static final String APIKEY="apiKey";
	public static final String ORGANIZATIONUID="organizationUId";
	public static final String SESSIONTOKEN="sessionToken";
	public static final String USER="user";
	public static final String GOORUUID="gooruUId";
	public static final String STARTTIME="startTime";
	public static final String ENDTIME="endTime";
	public static final String CONTEXT="context";
	public static final String CONTENTGOORUID="contentGooruId";
	public static final String PARENTGOORUID="parentGooruId";
	public static final String PARENTEVENTID="parentEventId";
	public static final String TYPE="type";
	public static final String CLIENTSOURCE="clientSource";
	public static final String PATH="path";
	public static final String PAGELOCATION="pageLocation";
	public static final String MODE="mode";
	public static final String VERSION="version";
	public static final String LOGAPI="logApi";
	public static final String METRICS="metrics";
	public static final String TOTALTIMESPENTINMS="totalTimeSpentInMs";
	public static final String SCORE="score";
	public static final String RESOURCETYPE="resourceType";
	public static final String PAYLOADOBJECT="payLoadObject";
	public static final String QUESTIONTYPE="questionType";
	public static final String TOTALNOOFCHARACTER="totalNoOfCharacter";
	public static final String TEXT="text";
	public static final String ATTEMPTSTATUS="attemptStatus";
	public static final String ATTEMPTTRYSEQUENCE="attemptTrySequence";
	public static final String ANSWERS="answers";
	public static final String HINTS="hints";
	public static final String EXPLANATION="explanation";
	public static final String CODEID="codeId";
	public static final String REACTIONTYPE="reactionType";
	public static final String WEB="web";
	public static final String PREVIEW="preview";
	public static final String STUDY="study";
	public static final String SESSIONID="sessionId";
	public static final String ATTEMPTCOUNT="attemptCount";
	public static final String ANSWEROBJECT="answerObject";
	public static final String STATUS="status";
	public static final String ORDER="order";
	public static final String ANSWERID="answerId";
	public static final String TIMESTAMP="timeStamp";
	public static final String SKIP="skip";
	
	
	
	public static void collectionStartStopEvent(JSONObject collectionDataLogEventMap){
		triggerDataLogCall(collectionDataLogEventMap);
	}
	public static void collectionItemStartStopEvent(){
		
	}
	public static void resourceStartStopEvent(){
		
	}
	public static void saveOeAnswerEvent(){
		
	}
	public static void visitingClasspageEvent(){
		
	}
	
	public static JSONString getDataLogSessionObject(String sessionId){
		JSONObject eventJsonObject=new JSONObject();
		try{
			eventJsonObject.put(APIKEY, new JSONString(AppClientFactory.getLoggedInUser().getSettings().getApiKeyPoint()));
			eventJsonObject.put(ORGANIZATIONUID, new JSONString(""));
			eventJsonObject.put(SESSIONTOKEN, new JSONString(AppClientFactory.getLoggedInUser().getToken()));
			if(sessionId!=null){
				eventJsonObject.put(SESSIONID, new JSONString(sessionId));
			}
		}catch(Exception e){
			
		}
		return new JSONString(eventJsonObject.toString());
	}
	
	public static JSONString getDataLogUserObject(){
		JSONObject eventJsonObject=new JSONObject();
		try{
			eventJsonObject.put(GOORUUID, new JSONString(AppClientFactory.getLoggedInUser().getGooruUId()));
		}catch(Exception e){
			
		}
		return new JSONString(eventJsonObject.toString());
	}
	
	public static JSONString getDataLogContextObject(String collectionId,String parentGooruId,String parentEventId,String eventType,String mode,
							String resourceType,String reactionType,String path,String pageLocation){
		JSONObject contextMap=new JSONObject();
		try{
			contextMap.put(CONTENTGOORUID, new JSONString(collectionId));
			parentGooruId=parentGooruId==null?"":parentGooruId;
			contextMap.put(PARENTGOORUID, new JSONString(parentGooruId));
			contextMap.put(PARENTEVENTID, new JSONString(parentEventId));
			contextMap.put(TYPE, new JSONString(eventType));
			contextMap.put(RESOURCETYPE, new JSONString(resourceType));
			contextMap.put(CLIENTSOURCE, new JSONString(WEB));
			if(reactionType!=null){
				contextMap.put(REACTIONTYPE, new JSONString(reactionType));
			}
			contextMap.put(PATH, new JSONString(path));
			if(pageLocation!=null){
				contextMap.put(PAGELOCATION, new JSONString(pageLocation)); //TODO
			}else{
				contextMap.put(PAGELOCATION, new JSONString(AppClientFactory.getPlaceManager().getPageLocation())); //TODO
			}
			contextMap.put(MODE, new JSONString(mode));
		}catch(Exception e){
			
		}
		return new JSONString(contextMap.toString());
	}
	
	public static  JSONString getDataLogVersionObject(){
		JSONObject versionMap=new JSONObject();
		try{
			versionMap.put(LOGAPI, new JSONString("0.1")); //TODO need to implement version
		}catch(Exception e){
			
		}
		return new JSONString(versionMap.toString());
	}
	public static  JSONString getDataLogMetricsObject(Long totalTimesInSec,Integer score){
		JSONObject metricsMap=new JSONObject();
		try{
			metricsMap.put(TOTALTIMESPENTINMS, new JSONNumber(totalTimesInSec));
			metricsMap.put(SCORE,new JSONNumber(score));
		}catch(Exception e){
			
		}
		return new JSONString(metricsMap.toString());
	}
	
	public static  JSONString getDataLogPayLoadObject(String questionType,String oeAnswerText, List<Integer> attemptStatus, List<Integer> attemptTrySequence,
										JSONObject answerIdsObject, JSONObject hintIdsObject,JSONObject explanationIdsObject,Integer attemptCount,List<List<JSONObject>> answerObjectArray){
		JSONObject payLoadMap=new JSONObject();
		try{
			payLoadMap.put(QUESTIONTYPE, new JSONString(questionType));
			payLoadMap.put(TOTALNOOFCHARACTER,new JSONNumber(oeAnswerText.length()));
			payLoadMap.put(TEXT,new JSONString(oeAnswerText));
			payLoadMap.put(ATTEMPTSTATUS, new JSONString(createJsniIntArray(attemptStatus).toString()));
			payLoadMap.put(ATTEMPTTRYSEQUENCE, new JSONString(createJsniIntArray(attemptTrySequence).toString()));
			payLoadMap.put(ANSWERS, new JSONString(answerIdsObject.toString()));
			payLoadMap.put(ATTEMPTCOUNT,new JSONNumber(attemptCount));
			payLoadMap.put(HINTS, new JSONString(hintIdsObject.toString()));
			payLoadMap.put(EXPLANATION, new JSONString(explanationIdsObject.toString()));
			payLoadMap.put(ANSWEROBJECT, new JSONString(getAnswerObjectArrayInString(answerObjectArray)));
		}catch(Exception e){
			
		}
		return new JSONString(payLoadMap.toString());
	}
	
	public static  JSONString getDataLogPayLoadObject(String reactionType){
		JSONObject payLoadMap=new JSONObject();
		try{
			//payLoadMap.put(REACTIONTYPE, new JSONString(reactionType));
		}catch(Exception e){
		
		}
		return new JSONString(payLoadMap.toString());
	}
	
	public static String getAnswerObjectArrayInString(List<List<JSONObject>> answerObjectArray){
		JSONObject attemptedAnswersArray=new JSONObject();
		for(int i=0;i<answerObjectArray.size();i++){
			List<JSONObject> jsonArray=answerObjectArray.get(i);
			attemptedAnswersArray.put("attempt"+(i+1), new JSONString(jsonArray+""));
		}
		String tempArray = attemptedAnswersArray+"";
		tempArray = tempArray.replaceAll("\\\\", "");
		return tempArray;
	}
	
	public static JSONArray createJsniIntArray(List<Integer> attemptTrySequence){
		JSONArray attemptTrySequenceArray=new JSONArray();
		if(attemptTrySequence!=null&&attemptTrySequence.size()>0){
			for(int i=0;i<attemptTrySequence.size();i++){
				attemptTrySequenceArray.set(i, new JSONNumber(attemptTrySequence.get(i)));
			}
		}
		return attemptTrySequenceArray;	
	}
	public static JSONArray createJsniStringArray(List<String> attemptTrySequence){
		JSONArray attemptTrySequenceArray=new JSONArray();
		if(attemptTrySequence!=null&&attemptTrySequence.size()>0){
			for(int i=0;i<attemptTrySequence.size();i++){
				attemptTrySequenceArray.set(i, new JSONString(attemptTrySequence.get(i)));
			}
		}
		return attemptTrySequenceArray;	
	}
	public static native void triggerDataLogCall(JSONObject eventJsonObject) /*-{
		$wnd._et.data.push(eventJsonObject);
 	}-*/;
	
	public static void collectionPlayStartEvent(String eventId,String eventName,
			String sessionId,String sessionStaus,String contentGooruId,String type,Long startTime,
			Long endTime,Long timeSpentInMs, String sessionToken,String gooruUId) {
			JSONObject eventJsonObject=new JSONObject();
			eventJsonObject.put("eventId", new JSONString(eventId));
			eventJsonObject.put("eventName", new JSONString(eventName));
			eventJsonObject.put("sessionId", new JSONString(sessionId));
			eventJsonObject.put("sessionStatus", new JSONString(sessionStaus));
			eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
			eventJsonObject.put("type", new JSONString(type));
			eventJsonObject.put("startTime", new JSONNumber(startTime));
			eventJsonObject.put("endTime", new JSONNumber(endTime));
			eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
			eventJsonObject.put("gooruUId", new JSONString(gooruUId));
			eventJsonObject.put("sessionToken", new JSONString(sessionToken));
			//triggerDataLogCall(eventJsonObject);
 	}
	
	public static void resourcePlayStartStopEvent(String eventId,String eventName,String parentEventId,
			String contentGooruId,String parentGooruId,String type,Long startTime,
			Long endTime, Long timeSpentInMs,String sessionToken,String gooruUId,List<Integer> attemptTrySequence,
			List<Integer> attemptStatus,List<Integer> answerId,String openEndedText,int totalNoCharacters){
		JSONObject eventJsonObject=new JSONObject();
		eventJsonObject.put("eventId", new JSONString(eventId));
		eventJsonObject.put("eventName", new JSONString(eventName));
		eventJsonObject.put("parentEventId", new JSONString(parentEventId));
		eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
		eventJsonObject.put("parentGooruId", new JSONString(parentGooruId));
		eventJsonObject.put("type", new JSONString(type));
		eventJsonObject.put("startTime", new JSONNumber(startTime));
		eventJsonObject.put("endTime", new JSONNumber(endTime));
		eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
		eventJsonObject.put("sessionToken", new JSONString(sessionToken));
		eventJsonObject.put("gooruUId", new JSONString(gooruUId));
		eventJsonObject.put("attemptTrySequence", createJsniIntArray(attemptTrySequence));
		eventJsonObject.put("attemptStatus", createJsniIntArray(attemptStatus));
		eventJsonObject.put("answerId", createJsniIntArray(answerId));
		eventJsonObject.put("openEndedText", new JSONString(openEndedText));
		eventJsonObject.put("totalNoCharacters", new JSONNumber(totalNoCharacters));
		//triggerDataLogCall(eventJsonObject);
	}
	
	public static  void explanationButtonDataLogEvent(String eventId,String eventName,String parentEventId,String contentGooruId,String parentGooruId,String type,Long startTime,
			Long endTime,Long timeSpentInMs,String sessionToken,String gooruUId,boolean isExplanationUsed,List<Integer> attemptTrySequence,
			List<Integer> attemptStatus,List<Integer> answerId,String openEndedText,int totalNoCharacters,int hintId) {
		JSONObject eventJsonObject=new JSONObject();
		eventJsonObject.put("eventId", new JSONString(eventId));
		eventJsonObject.put("eventName", new JSONString(eventName));
		eventJsonObject.put("parentEventId", new JSONString(parentEventId));
		eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
		eventJsonObject.put("parentGooruId", new JSONString(parentGooruId));
		eventJsonObject.put("type", new JSONString(type));
		eventJsonObject.put("startTime", new JSONNumber(startTime));
		eventJsonObject.put("endTime", new JSONNumber(endTime));
		eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
		eventJsonObject.put("sessionToken", new JSONString(sessionToken));
		eventJsonObject.put("gooruUId", new JSONString(gooruUId));
		eventJsonObject.put("isExplanationUsed", JSONBoolean.getInstance(isExplanationUsed));
		eventJsonObject.put("attemptTrySequence", createJsniIntArray(attemptTrySequence));
		eventJsonObject.put("attemptStatus", createJsniIntArray(attemptStatus));
		eventJsonObject.put("answerId", createJsniIntArray(answerId));
		eventJsonObject.put("totalNoCharacters", new JSONNumber(totalNoCharacters));
		eventJsonObject.put("openEndedText", new JSONString(openEndedText));
		eventJsonObject.put("hintId", new JSONNumber(hintId));
		//triggerDataLogCall(eventJsonObject);
 	}
	
	public static  void hintsButtonDataLogEvent(String eventId,String eventName,String parentEventId,
			String contentGooruId,String parentGooruId,String type,Long startTime,
			Long endTime,Long timeSpentInMs,String sessionToken,String gooruUId,int attemptTrySequence,int hintId,List<Integer> answerAttemptTrySequence,
			List<Integer> attemptStatus,List<Integer> answerId,String openEndedText,int totalNoCharacters,boolean isExplanationUsed) {
		JSONObject eventJsonObject=new JSONObject();
		eventJsonObject.put("eventId", new JSONString(eventId));
		eventJsonObject.put("eventName", new JSONString(eventName));
		eventJsonObject.put("parentEventId", new JSONString(parentEventId));
		eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
		eventJsonObject.put("parentGooruId", new JSONString(parentGooruId));
		eventJsonObject.put("type", new JSONString(type));
		eventJsonObject.put("startTime", new JSONNumber(startTime));
		eventJsonObject.put("endTime", new JSONNumber(endTime));
		eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
		eventJsonObject.put("sessionToken", new JSONString(sessionToken));
		eventJsonObject.put("gooruUId", new JSONString(gooruUId));
		//eventJsonObject.put("attemptTrySequence", new JSONNumber(attemptTrySequence));
		eventJsonObject.put("isExplanationUsed", JSONBoolean.getInstance(isExplanationUsed));
		eventJsonObject.put("hintId", new JSONNumber(hintId));
		eventJsonObject.put("attemptTrySequence", createJsniIntArray(answerAttemptTrySequence));
		eventJsonObject.put("attemptStatus", createJsniIntArray(attemptStatus));
		eventJsonObject.put("answerId", createJsniIntArray(answerId));
		eventJsonObject.put("totalNoCharacters", new JSONNumber(totalNoCharacters));
		eventJsonObject.put("openEndedText", new JSONString(openEndedText));
		//triggerDataLogCall(eventJsonObject);
 	}
	
 	public static void submitOeAnswerDataLogEvent(String eventId,String eventName,String parentEventId,
			String contentGooruId,Long startTime,
			Long endTime, Long timeSpentInMs,String sessionToken,String gooruUId,List<Integer> attemptTrySequence,
			List<Integer> attemptStatus,List<Integer> answerId,String openEndedText,int totalNoCharacters,String parentGooruOid){
		JSONObject eventJsonObject=new JSONObject();
		eventJsonObject.put("eventId", new JSONString(eventId));
		eventJsonObject.put("eventName", new JSONString(eventName));
		eventJsonObject.put("parentEventId", new JSONString(parentEventId));
		eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
		eventJsonObject.put("startTime", new JSONNumber(startTime));
		eventJsonObject.put("endTime", new JSONNumber(endTime));
		eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
		eventJsonObject.put("sessionToken", new JSONString(sessionToken));
		eventJsonObject.put("gooruUId", new JSONString(gooruUId));
/*		eventJsonObject.put("attemptTrySequence", createJsniIntArray(attemptTrySequence));
		eventJsonObject.put("attemptStatus", createJsniIntArray(attemptStatus));
		eventJsonObject.put("answerId", createJsniIntArray(answerId));*/
		eventJsonObject.put("openEndedText", new JSONString(openEndedText));
		eventJsonObject.put("totalNoCharacters", new JSONNumber(totalNoCharacters));
		eventJsonObject.put("parentGooruId", new JSONString(parentGooruOid));
		//triggerDataLogCall(eventJsonObject);
	}
 	public static String getQuestionType(int questionType){
		switch (questionType) {
			case 1:
				return "MC";
			case 3:
				return "TF";
			case 4:
				return "FIB";
			case 6:
				return "OE";
			case 7:
				return "MA";
			default:
				return "RES";
		}
	}
	
	public static JSONString getClassPagePayLoadObject(String codeId){
		JSONObject payLoadMap=new JSONObject();
		try{
			payLoadMap.put(CODEID, new JSONString(codeId));
		}catch(Exception e){
			
		}
		return new JSONString(payLoadMap.toString());
	}

}
