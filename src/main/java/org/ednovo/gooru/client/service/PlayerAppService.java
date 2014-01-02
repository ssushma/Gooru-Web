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

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwt-service/playerService")
public interface PlayerAppService extends BaseService {
	
	
	public CollectionDo getSimpleCollectionDetils(String simpleCollectionId,String resourceId,String tabView);
	
	public CollectionDo getSimpleCollectionDetils(String apiKey,String simpleCollectionId,String resourceId,String tabView);
	
	public ResoruceCollectionDo getResourceCollectionsList(String resourceGooruOid,String pageNum,String pageSize);
	
	public CollectionItemDo getResourceCollectionItem(String apiKey,String resourceId,String tabView);
	
	/**
	 * Get shorten collection url
	 * @param contentGooruOid of collection
	 * @param params set values url,type
	 * @return shrotenUrl, rawUrl
	 * @throws GwtException
	 */
	Map<String, String> getShortenShareUrl(String contentGooruOid);
	
	public String updateViewCount(String gooruid,String viewCount,String resourceType);
	
	
	public String startActivityPlayerLog(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,String context,String userAgent);
	
	public String stopActivityPlayerLog(String activityEventId,String activityParentEventId,String eventName,String gooruOid,String resourceGooruOid,String context,String userAgent);
	
	public String createSessionTracker(String collectionGooruOid);
	
	public String updateSessionInCollection(String sessionTrackerId);
	
	public String createSessionItemInCollection(String sessionTrackerId,String collectionItemId, String resourceGooruOid);
	
	public String createSessionItemAttemptTry(String sessionTrackerId,String sessionItemTrackerId, Integer answerId, String attemptResult);
	
	public String createSessionItemAttemptTryForOe(String sessionTrackerId,String sessionItemTrackerId, String attemptAnswerResult);
	
	public String sendEmail(String fromEmail,String toEmail,String copyEmail,String subject,String message);
	
	public boolean getUserProfileVisibility(String gooruUid);
	
	public String copyCollection(String collectionId,String collectionTile);
	
	public String copyCollectionItem(String collectionItemId,String collectionId);
	
	public ArrayList<CollectionItemsList> getWorkspaceCollections(String userId,String offset,String limit);
	
	public String updateContentThumbsRating(String resourceGooruOid,int userThumbsRataing);
	

}
