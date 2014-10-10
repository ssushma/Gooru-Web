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

import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.shared.model.analytics.FeedBackResponseDataDO;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.ednovo.gooru.shared.model.analytics.OetextDataDO;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface AnalyticsServiceAsync extends BaseServiceAsync {
	
	void getCollectionProgressData(String collectionId,String classPageId,String pathwayId,AsyncCallback<ArrayList<CollectionProgressDataDo>> callback);
	
	void getCollectionSummaryUsersData(String classpageId,AsyncCallback<ArrayList<CollectionSummaryUsersDataDo>> callback);
	
	void getCollectionMetaData(String collectionId,String classpageId,AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>> callback);
	
	void getCollectionMetaDataByUserAndSession(String collectionId,String classId,String userId,String sessionId,AsyncCallback<ArrayList<CollectionSummaryMetaDataDo>> callback);
	
	void getCollectionResourceData(String collectionId,String classpageId,String pathwayId,AsyncCallback<ArrayList<UserDataDo>> callback);
	
	void getSessionsDataByUser(String collectionId,String classId,String userId,AsyncCallback<ArrayList<CollectionSummaryUsersDataDo>> callback);
	
	void getUserSessionDataByUser(String collectionId,String classId,String userId,String sessionId,String pathwayId,AsyncCallback<ArrayList<UserDataDo>> callback);
   
	void getBottomAndTopScoresData(String collectionId,String classId,String score,AsyncCallback<ArrayList<GradeJsonData>> callback);
   
    void setHTMLtoPDF(String htmlString,AsyncCallback<Void> callback);
   
    void getAnalyticsGradeData(String classpageId,String pathwayId,AsyncCallback<ArrayList<GradeJsonData>> AsyncCallback);
   
    void exportPathwayOE(String classpageId,String pathwayId,AsyncCallback<String> AsyncCallback);
   
    void getAssignmentAverageData(String classId,String unitId,String collectionId,AsyncCallback<CollectionSummaryMetaDataDo> callback);
    
    void getOETextData(String resourceId,String collectionId,String classpageId,String pathwayId,String session,String sessionId,String userUId,AsyncCallback<ArrayList<OetextDataDO>> callback);
    
    void postTeacherFeedBackToStudent(String freeText,String resourceId,String collectionId,String classpageId,String pathwayId,String userId,String session,AsyncCallback<FeedBackResponseDataDO> callback);
}
