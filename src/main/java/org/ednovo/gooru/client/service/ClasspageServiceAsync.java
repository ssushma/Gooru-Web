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
import java.util.List;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollaboratorsDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.model.content.TaskResourceAssocDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;

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
	
	/*void createAssignment(CollectionDo collectionDo, String gooruContentId,  String dueDate, AsyncCallback<CollectionDo> callback);*/
	
//	Version 2 APIs
	void v2CreateClasspage(CollectionDo collectionDo, AsyncCallback<CollectionDo> callback);
	
	void v2UpdateClassPageByid(String classpageId, String CollectionType, String title, String shareType, AsyncCallback<CollectionDo> callback);
	
	void v2GetAssignemtsByClasspageId(String classpageId, String pageSize, String pageNum, AsyncCallback<AssignmentsListDo> callback);
	
	void v2GetAllClasspages(String limit, String offSet, AsyncCallback<ClasspageListDo> callback);
	
	void v2GetUserClasses(String limit, String offSet,String randomId, AsyncCallback<ClasspageListDo> callback);
	
	void v2GetUserStudyClasses(String limit, String offSet,String randomId, AsyncCallback<ClasspageListDo> callback);

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
	
	/*void checkPermissionsForClasspage(String classpageId, AsyncCallback<MetaDO> callback);*/
	
	void getCollectionClasspageAssoc(String collectionId, AsyncCallback<List<ClassPageCollectionDo>> callback);
	
	void deleteCollectionAssocInAssignment(String collectionId, AsyncCallback<Void> callback);
	
	public void getMyClassPages(String limit, String offset, AsyncCallback<ArrayList<ClasspageDo> > callback);
	
	public void createClassPage(String classPageTitle, AsyncCallback<CollectionDo> callback);
	
	public void getClasspage(String classpageId, AsyncCallback<ClasspageDo> callback);
	
	public void createClassPageItem(String classpageId,String collectionId,String dueDate,String direction, AsyncCallback<ClasspageItemDo> callback);
	
	public void assignItemToClass(String classpageId,String itemId,String dueDate,String direction,AsyncCallback<ArrayList<ClasspageItemDo>> callback);
	
	public void getClassPageItems(String classpageId,String offset,String limit,String sortingOrder,String studyStatus, AsyncCallback<ArrayList<ClasspageItemDo>> callback);
	
	public void updateClasspageItem(String classpageItemId,String direction,String dueDate,String readStatus, AsyncCallback<String> callback);
	
	public void deleteClassPageItem(String classPageId,String pathwayId,String collectionId, AsyncCallback<String> callback);
	
	public void getCollectionUsedCount(String collectionId, AsyncCallback<Integer> callback);
	
	/**
	 * @function getClasspagesListByCollectionId 
	 * 
	 * @created_date : Feb 4, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param gooruOid
	 * @param gooruOid2
	 * @param simpleAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void getClasspagesListByCollectionId(
			String collectionId,
			String collabUId,
			AsyncCallback<ArrayList<ClassPageCollectionDo>> simpleAsyncCallback);
	public void  getCollectionParentFolders(String collectionId,AsyncCallback<ArrayList<String>> simpleAsyncCallback);

	
	public void inviteStudentToClass(String classId,List<String> lstEmailId, AsyncCallback<ArrayList<CollaboratorsDo>> simpleAsyncCallback);

	public void getAssociatedStudentListByCode(String classCode, int offSet, int pageSize, String statusType, AsyncCallback<StudentsAssociatedListDo> simpleAsyncCallback);
	
	public void removeStudentFromClass(String classCode, String type, String emailIds, AsyncCallback<Void> simpleAsyncCallback);
	
	public void studentJoinIntoClass(String classCode, String emailId, AsyncCallback<ClasspageDo> simpleAsyncCallback);
	
	public void getSuggestionByName(String emailId, AsyncCallback<List<String>> simpleAsyncCallback);
	
	public void getClassPageItem(String classItemId, AsyncCallback<ClasspageItemDo> simpleAsyncCallback);
	
	public void v2GetClassPartyCustomField(String gooruUid, AsyncCallback<ProfilePageDo> simpleAsyncCallback);
	
	public void getActiveAssociatedStudentListByCode(String classCode, int offSet, int pageSize, String statusType, AsyncCallback<StudentsAssociatedListDo> simpleAsyncCallback);
	
	public void v2GetAllClass(String limit, String offSet, AsyncCallback<ClasspageListDo> callback);
	
	public void v2ChangeAssignmentSequence(String classpageId, String classpageAssignmentId, int sequence, AsyncCallback<Void> callback);

	public void v2GetPathwayItems(String classpageId,
			String pathwayGooruOid,String sequence,int limit,int offSet,AsyncCallback<UnitAssignmentsDo> callback);
	
	public void v2ReorderPathwaySequence(String classpageId,String pathwayItemId,int sequence, AsyncCallback<Void> callback);

	public void v2GetPathwaysOptimized(String classpageId, String limit,
			String offSet, AsyncCallback<ClassDo> callback);
	
	public void v2GetPathwaysCompleteDetails(String classpageId, String limit,
			String offSet, AsyncCallback<ClassDo> callback);
	
	public void reOrderPathwaysInaClass(String pathwayId, int newPosSequence, AsyncCallback<ClasspageListDo> callback);
	
	void v2CreatePathwayForAClass(String classpageId,
			String pathwayTitle, AsyncCallback<CollectionDo> callback);
	
	void v2CreatePathwayForAClassWithAssignmentItem(String classpageId,
			String pathwayTitle, String collectionId,
			CollectionItemDo collectionItemObject,AsyncCallback<AssignmentDo> callback);
	
	void v2UpdatePathwayById(String classpageId, String pathwayId,
			String pathwayTitle, AsyncCallback<CollectionDo> callback);
	
	public void deletePathway(String classpageId, String pathwayId, AsyncCallback<Void> simpleAsyncCallback);
	
	public void v2AssignCollectionTOPathway(String classpageId,String pathwayId,String collectionId,String suggestTime,String minScore,String duedate,String directions, AsyncCallback<ArrayList<ClasspageItemDo>> callback);
	
	void updateAssignmentDetails(String collectionItemId,String direction,String dueDate,String readStatus,String minimumScore,String suggestedTime, Boolean isRequiredStatus, AsyncCallback<ClasspageItemDo> callback);
	
	public void getAssignemntDetails(String assingmentId,AsyncCallback<ClasspageItemDo> callback);


	void getAssignmentData(String gooruUId, String classpageId, int pageSize, int pageNum, AsyncCallback<List<InsightsUserDataDo>> simpleAsyncCallback);
	
	void updateAssignmentStatus(String collectionItemId,
			boolean isRequiredStatus, AsyncCallback<CollectionDo> callback);
	
}
