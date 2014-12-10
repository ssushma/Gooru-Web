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

public interface AnalyticsUiHandlers extends BaseUiHandlers{
	
	/**
	 * This method is used to get the pathway items.
	 * @param classpageId
	 * @param pathwayGooruOid
	 * @param sequence
	 * @param limit
	 * @param offSet
	 */
	void getPathwayItems(String classpageId,String pathwayGooruOid,String sequence,int limit,int offSet);
	
	/**
	 * This method is used to get unit assignments items.
	 * @param classpageId
	 * @param pathwayGooruOid
	 * @param sequence
	 * @param limit
	 * @param offSet
	 */
	void getUnitAssignments(final String classpageId, final String pathwayGooruOid,String sequence,int limit,int offSet);
	
	/**
	 * This method is used to get the pathway units
	 * @param classId
	 * @param limit
	 * @param offset
	 * @param clearPanel
	 */
	void getPathwayUnits(String classId,int limit, int offset ,boolean clearPanel);
	
	/**
	 * This method is used to set the clicked tab presenter on the slot.
	 * @param clickedTab
	 * @param collectionId
	 * @param selectedCollectionTitle
	 */
	void setClickedTabPresenter(String clickedTab,String collectionId,String selectedCollectionTitle);
	
	/**
	 * This method is used to get the bottom scored students data.
	 * @param classpageId
	 * @param pathwayId
	 * @param collectionId
	 * @param sortOrder
	 */
	void getBottomStudentsData(String classpageId, String pathwayId,String collectionId,String sortOrder);
	
	/**
	 * This method is used to get the top scored students data
	 * @param classpageId
	 * @param pathwayId
	 * @param collectionId
	 * @param sortOrder
	 */
	void getTopStudentsData(String classpageId, String pathwayId,String collectionId,String sortOrder);
	
	/**
	 * This method is used to get the collections.
	 * @param classpageId
	 * @param pathwayId
	 */
	void getGradeCollectionJson(String classpageId,String pathwayId);
	
	/**
	 * This method is used to export the OE responses.
	 * @param classpageId
	 * @param pathwayId
	 * @param timeZone
	 */
	void exportOEPathway(String classpageId,String pathwayId,String timeZone);
	
	/**
	 * This method is used to get the unit Assignments.
	 */
	void getUnitAssignments();
	
	/**
	 * This method is used to set the clicked unit assignment details in the slot.
	 * @param result
	 * @param classpageId
	 * @param pathwayId
	 */
	//void setAnalyticsAssignmentsPresenter(UnitAssignmentsDo result,String classpageId,String pathwayId);
	
	/**
	 * This method is used to set the personalize data.
	 */
	//void setPersonalizeData();
}
