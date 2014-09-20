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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter;
import org.ednovo.gooru.client.uc.AssignmentEditLabelUc;
import org.ednovo.gooru.shared.model.analytics.CollectionProgressDataDo;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.user.client.ui.FlowPanel;


/**
 * @fileName : IsClasspageView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Apr 17, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
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
	
	public void setClasspageData(ClasspageDo classpageDo);
	
	
	public void showClasspageItems(ArrayList<ClasspageItemDo> classpageItemsList, String tab, String analyticsId, String monitorId,ClassListPresenter classListPresenter,int assignmentsCount);
	
	public void resetEditClasspageView();
	
	public void setClasspageItemOnTop(ClasspageItemDo classpageItemDo);
	
	public AssignmentEditLabelUc getCollectionTitleUc();

	/**
	 * @function callAssignmentAPI 
	 * 
	 * @created_date : Jun 11, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param classpageId
	 * @param offsetProgress
	 * @param limitProgress
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void callAssignmentAPI(String classpageId, String offsetProgress,
			String limitProgress);

	/**
	 * @function getGlobalClasspageProcess 
	 * 
	 * @created_date : Jun 12, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @return
	 * 
	 * @return : ArrayList<ClasspageItemDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	ArrayList<ClasspageItemDo> getGlobalClasspageProcess();


	/**
	 * @function hideNoAssignmentsMessagePanel 
	 * 
	 * @created_date : Jun 16, 2014
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
	
	void hideNoAssignmentsMessagePanel();
	
	public void highlightTab(String tabValue);
}
