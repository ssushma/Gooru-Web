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
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemsList;
import org.ednovo.gooru.shared.model.content.ContentReportDo;
import org.ednovo.gooru.shared.model.content.ContentStarRatingsDo;
import org.ednovo.gooru.shared.model.content.ReactionDo;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.model.content.UserStarRatingsDo;
import org.ednovo.gooru.shared.model.player.CommentsDo;
import org.ednovo.gooru.shared.model.player.CommentsListDo;
import org.ednovo.gooru.shared.model.player.FeaturedContentDo;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwt-service/playerService")
public interface PlayerAppService extends BaseService {
	
	
	public CollectionDo getSimpleCollectionDetils(String simpleCollectionId,String resourceId,String tabView,String rootNodeId);
	
	public CollectionDo getSimpleCollectionDetils(String apiKey,String simpleCollectionId,String resourceId,String tabView,String rootNodeId);
	
	public ResoruceCollectionDo getResourceCollectionsList(String resourceGooruOid,String pageNum,String pageSize);
	
	public CollectionItemDo getResourceCollectionItem(String apiKey,String resourceId,String tabView);
	
	public CollectionItemDo getResourceObj(String resourceId);
	
	
	
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
	
	public String createSessionItemAttemptTryForOe(String sessionTrackerId,String sessionItemTrackerId, String answerId,String attemptStatus,String attemptAnswerResult);
	
	public String sendEmail(String fromEmail,String toEmail,String copyEmail,String subject,String message);
	
	public boolean getUserProfileVisibility(String gooruUid);
	
	public String copyCollection(String collectionId,String collectionTile);
	
	public String copyCollectionItem(String collectionItemId,String collectionId);
	
	public ArrayList<CollectionItemsList> getWorkspaceCollections(String userId,String offset,String limit);
	
	public String updateContentThumbsRating(String resourceGooruOid,int userThumbsRataing);
	
	public ArrayList<ContentReportDo> getContentReport(String associatedGooruOid,String gooruUid);
	
	public ContentReportDo createContentReport(String associatedGooruOid,String freeText,ArrayList<String> contentReportList,String deleteContentReportGooruOids);
	
	public void deleteContentReport(String associatedGooruOid);
	
	public CommentsDo createCommentForCollection(String gooruCollectionId, String userCommentsEntered);
	
	public CommentsListDo getCollectionCommentsList(String gooruOid,String offset, String pageLimit);
	
	public void deleteCollectionCommentbyCommentUid(String commentUid);
	
	public CommentsDo updateCollectionCommentbyCommentUid(String commentUid, String commentsUpdatedByUser);
	
	public ReactionDo createReaction(String resourceId, String reactionText,String gooruReactionId,String collectionId, String createStudyPlayerReaction);
	
	public ArrayList<ReactionDo> getResourceReaction(String resourceId, String gooruUid);
	
	public String generatePdf(String innerHtml,String completedDateTime);
	
	public String sendEmailWithPdf(String toAddress, String fromAddress, String cfm, String subject, String message, String Url, String FileName);

	public ArrayList<FeaturedContentDo> getFeaturedContent();
	
	public void deleteReaction(String gooruReactionId);
	
	/**
	 * Creates the star rating by calling an API.
	 * 
	 * @param associateGooruOid {@link String}
	 * @param starRatingValue {@link Integer} Input given by the user i.e score out of 5
	 * @param callback {@link AsyncCallback}  The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method. 
	 */
	public StarRatingsDo createStarRatings(String associateGooruOid,int starRatingValue,String userReview);
	
	/**
	 * Gets the resource star ratings.
	 * 
	 * @param gooruOid {@link String}
	 * @param gooruUid {@link String}
	 * @param callback {@link AsyncCallback} The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method. 
	 */
	public StarRatingsDo getResourceStarRatings(String gooruOid, String gooruUid);
	

	/**
	 * Gets content Star ratings.
	 * @param gooruOid {@link String}
	 * @param callback {@link AsyncCallback} The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method.
	 */
	public ContentStarRatingsDo getContentStarRatings(String gooruOid);
	
	/**
	 * Updates the resource ratings.
	 * @param gooruOid {@link String}
	 * @param score {@link Integer}
	 * @param callback {@link AsyncCallback} The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method.
	 */
	public ArrayList<StarRatingsDo> updateResourceStarRatings(String gooruOid, int score);
	

	/**
	 * Gets the user star ratings.
	 * @param gooruUid {@link String}
	 * @param callback {@link AsyncCallback} The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method.
	 */
	public UserStarRatingsDo getUserStarRatings(String gooruOid); 
	
	/**
	 * Gets the resource star ratings and reviews.
	 * @param gooruOid {@link String}
	 * @param gooruUid {@link String}
	 * @param callback {@link AsyncCallback} The asynchronous method always takes an AsyncCallback<T> as its last parameter, where T is the return type of the correlated synchronous method.
	 */
	public ArrayList<StarRatingsDo> getResourceRatingWithReviews(String resourceId, String gooruUid,int offSet);
	
	public ArrayList<StarRatingsDo> updateResourceStarReviews(String deleteRatingGooruOid,Integer score, String userReview);
	
	public void deleteRating(String deleteRatingGooruOid);
	
}
