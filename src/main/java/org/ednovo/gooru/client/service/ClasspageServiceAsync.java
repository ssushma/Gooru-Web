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

import java.util.List;

import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.PermissionsDO;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.model.content.TaskResourceAssocDo;

import com.google.gwt.user.client.rpc.AsyncCallback;
//import org.ednovo.gooru.shared.model.content.ResourceItemDo;

public interface ClasspageServiceAsync extends BaseServiceAsync {

	void createClasspage(CollectionDo collectionDo, AsyncCallback<CollectionDo> callback);
//	Version 1 APIs
//	void getClasspageById(String classpageId, AsyncCallback<CollectionDo> callback);
	
//	void getAllClasspages(AsyncCallback<List<CollectionDo>> callback);
	
//	void deleteAssignment(String assignmentId, AsyncCallback<Void> callback);
	
//	void updateAssignment(CollectionDo collectionDo, String dueDate, AsyncCallback<CollectionDo> callback);
	
//	void getClasspageByCode(String classpageCode, AsyncCallback<CollectionDo> callback);

//	void addCollectionToAssignment(String collectionId, String assignmentId, CollectionDo collectionDo, AsyncCallback<CollectionItemDo> callback);
	
//	void getAssignmentCollectionsById(String assignmentId, AsyncCallback<List<CollectionItemDo>> callback);
	
//	void removeCollectionFromAssignment(String collectionId, AsyncCallback<Void> callback);
	
//	void getAssignemtsByClasspageId(String classpageId, String pageSize, String pageNum, AsyncCallback<AssignmentsListDo> callback);
	
//	void updateClassPageByid(String classpageId,String CollectionType,String title,AsyncCallback<CollectionDo> callback);
	
	void deleteClasspage(String classpageId, AsyncCallback<Void> callback);
	
	void createAssignment(CollectionDo collectionDo, String gooruContentId,  String dueDate, AsyncCallback<CollectionDo> callback);
	
//	Version 2 APIs
	void v2CreateClasspage(CollectionDo collectionDo, AsyncCallback<CollectionDo> callback);
	
	void v2UpdateClassPageByid(String classpageId, String CollectionType, String title, AsyncCallback<CollectionDo> callback);
	
	void v2GetAssignemtsByClasspageId(String classpageId, String pageSize, String pageNum, AsyncCallback<AssignmentsListDo> callback);
	
	void v2GetAllClasspages(String limit, String offSet, AsyncCallback<ClasspageListDo> callback);

	void v2CreateAssignment(AssignmentDo assignmentDo,AsyncCallback<AssignmentDo> callback);
	
	void v2GetClasspageById(String classpageId, AsyncCallback<CollectionDo> callback);
	
	void getSCollIdClasspageById(String classpageId, AsyncCallback<CollectionDo> callback);
	
	void v2getClasspageByCode(String classpageCode, AsyncCallback<CollectionDo> callback);
	
	void v2UpdateAssignment(AssignmentDo assignmentDo,  String assignmentId, AsyncCallback<TaskDo> callback);
	
	void v2DeleteAssignment(String assignmentId, AsyncCallback<Void> callback);
	
	void v2AddCollectionToAssignment(String assignmentId, TaskResourceAssocDo taskResourceAssocDo, AsyncCallback<TaskResourceAssocDo> callback);
	
	void v2GetAssignmentCollectionsById(String assignmentId, AsyncCallback<List<ResourceDo>> callback);
	
	void v2RemoveCollectionFromAssignment(String collectionId, String assignmentId, AsyncCallback<Void> callback);

	void socialShareEmail(String fromTxt, String toTxt,String cfm, String subtxt,String msgTxt, AsyncCallback<Void> callback);
	
	void ShotenUrl(String url, AsyncCallback<List<String>> callback);
	
	void checkPermissionsForClasspage(String classpageId, AsyncCallback<PermissionsDO> callback);
	
	void getCollectionClasspageAssoc(String collectionId, AsyncCallback<List<ClassPageCollectionDo>> callback);
	
	void deleteCollectionAssocInAssignment(String collectionId, AsyncCallback<Void> callback);
}
