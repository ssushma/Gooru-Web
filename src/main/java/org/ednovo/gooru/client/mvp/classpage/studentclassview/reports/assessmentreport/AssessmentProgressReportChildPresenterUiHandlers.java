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
package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.assessmentreport;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.gin.BaseUiHandlers;
import org.ednovo.gooru.application.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.application.shared.model.analytics.UserDataDo;

public interface AssessmentProgressReportChildPresenterUiHandlers extends BaseUiHandlers{

	public void getSessionsDataByUser(String collectionId, String classId, String courseId, String unitId, String lessonId, String userId);

	public void getCollectionMetaDataByUserAndSession(String collectionId, String classId, String courseId, String unitId, String lessonId, String userId, String sessionId,PrintUserDataDO printData);

	public void setCollectionSummaryData(String collectionId,String classpageId,String userId,String sessionId,PrintUserDataDO printData, String type);

	public void clearslot();

	public void setHtmltopdf(String string, String collectionTitle,boolean isClickedOnEmail);
	
	public void getContentPlayAllSessions(String gooruUid, String collectionType, String classGooruId, String lessonGooruId, String unitGooruId, String courseGooruId, String assessmentId, String sessionId);

	public void getCollectionScoreForSession(String collectionId, String classId, String userId, String sessionId, PrintUserDataDO printData);
	
	public ArrayList<UserDataDo> getPrintDataDo();

}
