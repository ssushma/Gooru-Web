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
package org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;
/**
 * 
 * @fileName : IsPersonalizeUnitView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 09-Sep-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public interface IsPersonalizeUnitView extends
		IsViewWithHandlers<PersonalizeUnitUiHandlers> {

	/**
	 * @param result 
	 * @function displayAssignmentsGoals 
	 * 
	 * @created_date : 09-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void displayAssignmentsGoals(StudentsAssociatedListDo result);

	/**
	 * 
	 * @function displayPagination 
	 * 
	 * @created_date : 18-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * @param result
	 * @param pageNum
	 * @param pageOffset
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	
	void displayPagination(StudentsAssociatedListDo result, int offSet, int limit);

}
