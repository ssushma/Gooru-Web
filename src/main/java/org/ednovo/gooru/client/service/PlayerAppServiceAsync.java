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

import java.util.ArrayList;
import java.util.Map;

import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlayerAppServiceAsync extends BaseServiceAsync {

	
	public void getSimpleCollectionDetils(String simpleCollectionId,String resourceId,String tabView,AsyncCallback<CollectionDo> callback);
	
	public void getSimpleCollectionDetils(String apikey,String simpleCollectionId,String resourceId,String tabView,AsyncCallback<CollectionDo> callback);
	
	public void getResourceCollectionsList(String resourceGooruOid,String pageNum,String pageSize,AsyncCallback<ResoruceCollectionDo> callback);
	
	public void getResourceCollectionItem(String apiKey,String resourceId,String tabView,AsyncCallback<CollectionItemDo> callback);
	
	public void getShortenShareUrl(String contentGooruOid,  AsyncCallback<Map<String, String>> callback);
	
	public void updateViewCount(String gooruid,String viewCount,String resourceType,AsyncCallback<String> callback);
	
	public void startActivityPlayerLog(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,String context,String userAgent,AsyncCallback<String> callback);
	
	public void stopActivityPlayerLog(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,String context,String userAgent,AsyncCallback<String> callback);
	
	public void createSessionTracker(String collectionGooruOid,AsyncCallback<String> callback);
	
	public void updateSessionInCollection(String sessionTrackerId,AsyncCallback<String> callback);
	
	public void createSessionItemInCollection(String sessionTrackerId,String collectionItemId, String resourceGooruOid,AsyncCallback<String> callback);
	
	public void createSessionItemAttemptTry(String sessionTrackerId,String sessionItemTrackerId, Integer answerId, String attemptResult,AsyncCallback<String> callback);
	
	public void createSessionItemAttemptTryForOe(String sessionTrackerId,String sessionItemTrackerId, String attemptAnswerResult,AsyncCallback<String> callback);
	
	public void sendEmail(String fromEmail,String toEmail,String copyEmail,String subject,String message,AsyncCallback<String> callback);
	
	public void getUserProfileVisibility(String gooruUid,AsyncCallback<Boolean> callback);
	
	public void copyCollection(String collectionId,String collectionTile,AsyncCallback<String> callback);
	
	public void copyCollectionItem(String collectionItemId,String collectionId,AsyncCallback<String> callback);
	
	public void getWorkspaceCollections(String userId,String offset,String limit,AsyncCallback<ArrayList<CollectionItemsList>> callback);
	
	public void updateContentThumbsRating(String resourceGooruOid,int userThumbsRataing,AsyncCallback<String> callback);
	
}
