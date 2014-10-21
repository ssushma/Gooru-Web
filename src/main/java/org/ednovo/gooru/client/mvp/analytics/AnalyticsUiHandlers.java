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
package org.ednovo.gooru.client.mvp.analytics;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

public interface AnalyticsUiHandlers extends BaseUiHandlers{
	void getPathwayItems(String classpageId,String pathwayGooruOid,String sequence,int limit,int offSet);
	
	void getUnitAssignments(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet);
	
	void getPathwayUnits(String classId,int limit, int offset ,boolean clearPanel);
	
	void setClickedTabPresenter(String clickedTab,String collectionId);
	
	void getBottomStudentsData(String classpageId, String pathwayId,String collectionId,String sortOrder);
	
	void getTopStudentsData(String classpageId, String pathwayId,String collectionId,String sortOrder);
	
	void getGradeCollectionJson(String classpageId,String pathwayId);
	
	void exportOEPathway(String classpageId,String pathwayId);
	
	void getUnitAssignments();
	
	void setAnalyticsAssignmentsPresenter(UnitAssignmentsDo result,String classpageId,String pathwayId);
	
	void setPersonalizeData();
}
