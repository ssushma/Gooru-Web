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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

import org.ednovo.gooru.client.gin.BaseUiHandlers;

/**
 * 
 * @fileName : CollectionAssignTabUiHandlers.java
 *
 * @description : This is related to get the class pages and to get assignments based on classpage id.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface CollectionAssignTabUiHandlers extends BaseUiHandlers {
	/**
	 * 
	 * @function getNextClasspages 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description   : To get the next class pages.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	void getNextClasspages();
	/**
	 * 
	 * @function getAllClasspages 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description  : To get all the class pages.
	 * 
	 * 
	 * @parm(s) : @param limit
	 * @parm(s) : @param offSet
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	void getAllClasspages(String limit, String offSet);
	/**
	 * 
	 * @function getAssignmentsByClasspageId 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description   : To get assignments by classpage id.
	 * 
	 * 
	 * @parm(s) : @param classpageId
	 * @parm(s) : @param pageSize
	 * @parm(s) : @param pageNum
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	void getAssignmentsByClasspageId(String classpageId, String pageSize, String pageNum);
	
	/**
	 * 
	 * @function getNextAssignments 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description   : To get next assignments.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	void getNextAssignments();
	
	/**
	 * 
	 * @function setAssignmentOffSet 
	 * 
	 * @created_date : Aug 1, 2013
	 * 
	 * @description   : To set assignment offset.
	 * 
	 * 
	 * @parm(s) : @param assignmentOffSet
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	
	void setAssignmentOffSet(int assignmentOffSet);
	
	/**
	 * 
	 * @function setShareType 
	 * 
	 * @created_date : Aug 9, 2013
	 * 
	 * @description   : To set the sharetype.
	 * 
	 * 
	 * @parm(s) : @param shareType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	
	void setShareType(String shareType);
}
