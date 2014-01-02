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


import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
/**
 * @fileName : PlayerDataLogEvents.java
 *
 * @description : This class is used for to log player events.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */


public class PlayerDataLogEvents {
	
	public static final String COLLECTION_PLAY_EVENT_NAME="collection-play-dots";
	public static final String COLLECTION_RESOUCE_PLAY_EVENT_NAME="collection-resource-play-dots";
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
	
	/**
	 * @function collectionPlayStartEvent 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will log the collection player start event.
	 * 
	 * @parm(s) : @param eventId
	 * @parm(s) : @param eventName
	 * @parm(s) : @param sessionId
	 * @parm(s) : @param sessionStaus
	 * @parm(s) : @param contentGooruId
	 * @parm(s) : @param type
	 * @parm(s) : @param startTime
	 * @parm(s) : @param endTime
	 * @parm(s) : @param timeSpentInMs
	 * @parm(s) : @param sessionToken
	 * @parm(s) : @param gooruUId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static  void collectionPlayStartEvent(String eventId,String eventName,
			String sessionId,String sessionStaus,String contentGooruId,String type,Long startTime,
			Long endTime,Long timeSpentInMs, String sessionToken,String gooruUId) {
			JSONObject eventJsonObject=new JSONObject();
			eventJsonObject.put("eventId", new JSONString(eventId));
			eventJsonObject.put("eventName", new JSONString(eventName));
			eventJsonObject.put("sessionId", new JSONString(sessionId));
			eventJsonObject.put("sessionStaus", new JSONString(sessionStaus));
			eventJsonObject.put("contentGooruId", new JSONString(contentGooruId));
			eventJsonObject.put("type", new JSONString(type));
			eventJsonObject.put("startTime", new JSONNumber(startTime));
			eventJsonObject.put("endTime", new JSONNumber(endTime));
			eventJsonObject.put("timeSpentInMs", new JSONNumber(timeSpentInMs));
			eventJsonObject.put("gooruUId", new JSONString(gooruUId));
			eventJsonObject.put("sessionToken", new JSONString(sessionToken));
			triggerDataLogCall(eventJsonObject);
 	};
 	/**
 	 * @function resourcePlayStartStopEvent 
 	 * 
 	 * @created_date : 31-Dec-2013
 	 * 
 	 * @description :This will log the collection player stop event.
 	 * 
 	 * @parm(s) : @param eventId
 	 * @parm(s) : @param eventName
 	 * @parm(s) : @param parentEventId
 	 * @parm(s) : @param contentGooruId
 	 * @parm(s) : @param parentGooruId
 	 * @parm(s) : @param type
 	 * @parm(s) : @param startTime
 	 * @parm(s) : @param endTime
 	 * @parm(s) : @param timeSpentInMs
 	 * @parm(s) : @param sessionToken
 	 * @parm(s) : @param gooruUId
 	 * @parm(s) : @param attemptTrySequence
 	 * @parm(s) : @param attemptStatus
 	 * @parm(s) : @param answerId
 	 * @parm(s) : @param openEndedText
 	 * @parm(s) : @param totalNoCharacters
 	 * 
 	 * @return : void
 	 *
 	 * @throws : <Mentioned if any exceptions>
 	 *
 	 */
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
		triggerDataLogCall(eventJsonObject);
	}
	/**
	 * 
	 * @function createJsniIntArray 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to create jsni array.
	 * 
	 * @parm(s) : @param attemptTrySequence
	 * @parm(s) : @return
	 * 
	 * @return : JSONArray
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static JSONArray createJsniIntArray(List<Integer> attemptTrySequence){
		JSONArray attemptTrySequenceArray=new JSONArray();
		if(attemptTrySequence!=null&&attemptTrySequence.size()>0){
			for(int i=0;i<attemptTrySequence.size();i++){
				attemptTrySequenceArray.set(i, new JSONNumber(attemptTrySequence.get(i)));
			}
		}
		return attemptTrySequenceArray;	
	}
	/**
	 * @function createJsniStringArray 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to create jsni array string
	 * 
	 * 
	 * @parm(s) : @param attemptTrySequence
	 * @parm(s) : @return
	 * 
	 * @return : JSONArray
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
	
	/**
	 * @function explanationButtonDataLogEvent 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This will log the explanation start event.
	 * 
	 * 
	 * @parm(s) : @param eventId
	 * @parm(s) : @param eventName
	 * @parm(s) : @param parentEventId
	 * @parm(s) : @param contentGooruId
	 * @parm(s) : @param parentGooruId
	 * @parm(s) : @param type
	 * @parm(s) : @param startTime
	 * @parm(s) : @param endTime
	 * @parm(s) : @param timeSpentInMs
	 * @parm(s) : @param sessionToken
	 * @parm(s) : @param gooruUId
	 * @parm(s) : @param isExplanationUsed
	 * @parm(s) : @param attemptTrySequence
	 * @parm(s) : @param attemptStatus
	 * @parm(s) : @param answerId
	 * @parm(s) : @param openEndedText
	 * @parm(s) : @param totalNoCharacters
	 * @parm(s) : @param hintId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
		triggerDataLogCall(eventJsonObject);
 	};
	
	/**
	 * @function hintsButtonDataLogEvent 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This will log the hints start event.
	 * 
	 * 
	 * @parm(s) : @param eventId
	 * @parm(s) : @param eventName
	 * @parm(s) : @param parentEventId
	 * @parm(s) : @param contentGooruId
	 * @parm(s) : @param parentGooruId
	 * @parm(s) : @param type
	 * @parm(s) : @param startTime
	 * @parm(s) : @param endTime
	 * @parm(s) : @param timeSpentInMs
	 * @parm(s) : @param sessionToken
	 * @parm(s) : @param gooruUId
	 * @parm(s) : @param attemptTrySequence
	 * @parm(s) : @param hintId
	 * @parm(s) : @param answerAttemptTrySequence
	 * @parm(s) : @param attemptStatus
	 * @parm(s) : @param answerId
	 * @parm(s) : @param openEndedText
	 * @parm(s) : @param totalNoCharacters
	 * @parm(s) : @param isExplanationUsed
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
		triggerDataLogCall(eventJsonObject);
 	};
 	/**
 	 * @function submitOeAnswerDataLogEvent 
 	 * 
 	 * @created_date : 31-Dec-2013
 	 * 
 	 * @description :This will log the submitOeAnswer start event.
 	 * 
 	 * @parm(s) : @param eventId
 	 * @parm(s) : @param eventName
 	 * @parm(s) : @param parentEventId
 	 * @parm(s) : @param contentGooruId
 	 * @parm(s) : @param startTime
 	 * @parm(s) : @param endTime
 	 * @parm(s) : @param timeSpentInMs
 	 * @parm(s) : @param sessionToken
 	 * @parm(s) : @param gooruUId
 	 * @parm(s) : @param attemptTrySequence
 	 * @parm(s) : @param attemptStatus
 	 * @parm(s) : @param answerId
 	 * @parm(s) : @param openEndedText
 	 * @parm(s) : @param totalNoCharacters
 	 * @parm(s) : @param parentGooruOid
 	 * 
 	 * @return : void
 	 *
 	 * @throws : <Mentioned if any exceptions>
 	 *
 	 */
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
		triggerDataLogCall(eventJsonObject);
	}
	
}
