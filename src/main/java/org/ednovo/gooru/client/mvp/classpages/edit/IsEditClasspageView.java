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
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
/**
 * 
 * @fileName : IsEditClasspageView.java
 *
 * @description : Acts as a bridge between the Presenter and view.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface IsEditClasspageView extends IsViewWithHandlers<EditClasspageUiHandlers>{
	
	void setData(CollectionDo collectionDo);     
	
	void setShareUrl(Map<String, String> shortenUrl);
	
	void setAssignmentData(AssignmentsSearchDo assignmentsSearchDo,boolean isExpandable);
		
	void setClasspageId(String classpageId);
	
	void getAssignemntsByClasspageId(String classpageId, String pageSize, String pageNum);

	void listAssignments(AssignmentsListDo result);
	
	List<CollectionItemDo> getCollectionItemList();
	
	void clearPanel();
	
	void onDeleteAssignment(boolean isPostDeleteAssignment);
	
	void onPostClassPageUpdate();

	void getClasspageById(String classpageId, String pageSize, String pageNum, String pos);
	
	public void setUploadedImageToClassPage(String url);

	void closeAllOpenedPopUp();
}
