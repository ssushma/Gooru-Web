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
package org.ednovo.gooru.server.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ednovo.gooru.client.service.ClasspageService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.PermissionsDO;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.model.content.TaskResourceAssocDo;
import org.ednovo.gooru.shared.model.social.SocialShareDo;
import org.ednovo.gooru.shared.model.user.BitlyUrlDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.StringRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
/**
 * @fileName : ClasspageServiceImpl.java
 *
 * @description : This is the implementation of the class page service 
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Service("classpageService")
@ServiceURL("/classpageService")
public class ClasspageServiceImpl extends BaseServiceImpl implements
		ClasspageService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3513384975044132831L;

	private static final String ADD_TO_USER_CLASSPAGE = "addToUserClasspage";

	private static final String TRUE = "true";

	private static final String CLASSPAGE = "classpage";

	private static final String ASSIGNMENT = "assignment";
	
//	private static final String COLLECTIONITEM = "collectionItem";
	
	private static final String TASKRESOURCEASSOC = "taskResourceAssoc";
	
//	private static final String ITEMTYPE = "itemType";
	
//	private static final String TASK = "task";

	@Autowired
	ResourceDeserializer resourceDeserializer;
	/**
	 * Create new Classpage
	 * @param collectionDo instance of {@link CollectionDo} has collection meta info
	 * @return serialized created {@link CollectionDo}
	 * @throws GwtException
	 */
	@Override
	public CollectionDo createClasspage(CollectionDo collectionDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.CREATE_CLASSPAGE, getLoggedInSessionToken());
		
		Form form = ResourceFormFactory.generateDataForm(collectionDo,
				CLASSPAGE);
		form.add(ADD_TO_USER_CLASSPAGE, TRUE);

		jsonRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), form);
		return deserializeCollection(jsonRep);

	}
	/**
	 * @function deserializeCollection 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to deserialize collection.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionDo deserializeCollection(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject()
						.toString(), CollectionDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}
	/**
	 * @function deserializeAssignmentsCollection 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the assignments.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionDo deserializeAssignmentsCollection(
			JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				CollectionDo collectionDo = JsonDeserializer.deserialize(
						jsonRep.getJsonObject().toString(), CollectionDo.class);
				return collectionDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}
//	Version 1 API
	/*@Override
	public CollectionDo getClasspageById(String classpageId)
			throws GwtException {

		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.GET_CLASSPAGE_BY_ID, classpageId,
				getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(),
				getRestPassword());
		
		return deserializeClasspage(jsonRep);
	}*/
	/**
	 * @function deserializeClasspage 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to seserialize class pages.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionDo deserializeClasspage(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				CollectionDo collectionDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionDo.class);

				List<CollectionItemDo> collectionItemDo = collectionDo.getCollectionItems();
				for (int i=0; i<collectionItemDo.size();i++){
					long milliseconds = Long.parseLong(collectionItemDo.get(i).getResource().getTrackActivity().getEndTime());
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date resultdate = new Date(milliseconds);
					collectionItemDo.get(i).getResource().getTrackActivity().setEndTime(sdf.format(resultdate));
				}
				return collectionDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionDo();
	}
//	Version 1 API
	/*@Override
	public List<CollectionDo> getAllClasspages() throws GwtException {

		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.LIST_MY_CLASSPAGES, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(),
				getRestPassword());

		return deserializeCollections(jsonRep);
	}
*/
	/**
	 * @function deserializeCollections 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will deserialize the collections.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<CollectionDo> deserializeCollections(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray()
						.toString(), new TypeReference<List<CollectionDo>>() {
				});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ArrayList<CollectionDo>();
	}
	/**
	 * This method is usedt create assignment.
	 */
	@Override
	public CollectionDo createAssignment(CollectionDo collectionDo, String gooruContentId, String dueDate) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CREATE_ASSIGNMENT, getLoggedInSessionToken(), gooruContentId, dueDate);
		Form form = ResourceFormFactory.generateDataForm(collectionDo,ASSIGNMENT);
		form.add(ADD_TO_USER_CLASSPAGE, TRUE);

		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		
		return deserializeAssignmentsCollection(jsonRep);
	}
//	Version 1 API
	/*@Override
	public void deleteAssignment(String assignmentId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.DELETE_ASSIGNMENT, assignmentId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}*/
//	Version 1 API
	/*@Override
	public CollectionDo updateAssignment(CollectionDo collectionDo,
			String updateDueDate) throws GwtException {
		JsonRepresentation jsonRep = null;

		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.UPDATE_ASSIGNMENT, collectionDo.getGooruOid(),
				getLoggedInSessionToken(), updateDueDate);
		Form form = ResourceFormFactory.generateDataForm(collectionDo,
				ASSIGNMENT);
		form.add(ADD_TO_USER_CLASSPAGE, TRUE);

		jsonRep = ServiceProcessor.put(url, getRestUsername(),
				getRestPassword(), form);
		return deserializeAssignmentsCollection(jsonRep);
	}*/
//	Version 1 API
	/*@Override
	public CollectionDo getClasspageByCode(String classpageCode)throws GwtException {
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_CLASSPAGE_BY_CODE, classpageCode, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		return deserializeCollection(jsonRep);
	}

	@Override
	public CollectionItemDo addCollectionToAssignment(String collectionId,
			String assignmentId, CollectionDo collectionDo) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.ADD_COLLECTIONS_TO_ASSIGNMENT, collectionId, assignmentId, getLoggedInSessionToken());

		Form form = ResourceFormFactory.generateDataForm(collectionDo, COLLECTIONITEM);
		form.add(ITEMTYPE, "added");

		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), form);
		return deserializeCollectionItem(jsonRep);
	}*/
	/**
	 * @function deserializeCollectionItem 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize collection items.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionItemDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionItemDo deserializeCollectionItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionItemDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionItemDo();
	}
//	Version 1 API
	/*@Override
	public List<CollectionItemDo> getAssignmentCollectionsById(String assignmentId) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_ASSIGNMENT_COLLECTIONS, assignmentId, getLoggedInSessionToken());
		return deserializeCollectionItems(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
	public List<CollectionItemDo> deserializeCollectionItems(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<CollectionItemDo>();
	}

	@Override
	public void removeCollectionFromAssignment(String collectionId)
			throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.DELETE_ASSIGNMENT_COLLECION_ITEM, collectionId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}

	@Override
	public AssignmentsListDo getAssignemtsByClasspageId(String classpageId,String pageSize, String pageNum)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_CLASSPAGE_ASSIGNMENTS, classpageId, getLoggedInSessionToken(), pageSize, pageNum);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeAssignmentsList(jsonRep);
	}	*/
		/**
		 * @function deserializeAssignmentsList 
		 * 
		 * @created_date : 31-Dec-2013
		 * 
		 * @description : This method is used to deserialize assignments list.
		 * 
		 * 
		 * @parm(s) : @param jsonRep
		 * @parm(s) : @return
		 * 
		 * @return : AssignmentsListDo
		 *
		 * @throws : <Mentioned if any exceptions>
		 *
		 */
	public AssignmentsListDo deserializeAssignmentsList(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				AssignmentsListDo assignmentList = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), AssignmentsListDo.class);
				
//				List<CollectionItemDo> collectionItemDo = assignmentList.getSearchResults();
//				for (int i=0; i<collectionItemDo.size();i++){
//					long milliseconds = Long.parseLong(collectionItemDo.get(i).getResource().getTrackActivity().getEndTime());
//					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//					Date resultdate = new Date(milliseconds);
//					collectionItemDo.get(i).getResource().getTrackActivity().setEndTime(sdf.format(resultdate));
//				}
				
				return assignmentList;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new AssignmentsListDo();
	}
//	Version 1 API
	/*@Override
	public CollectionDo updateClassPageByid(String classpageId,
			String CollectionType, String title) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_CLASSPAGE, classpageId,getLoggedInSessionToken());
		CollectionDo collectionDo = new CollectionDo();
		collectionDo.setTitle(title);
		Form form = ResourceFormFactory.generateDataForm(collectionDo,
				CLASSPAGE);
		form.add("CollectionType", CollectionType);

		jsonRep = ServiceProcessor.put(url, getRestUsername(),
				getRestPassword(), form);
		return deserializeCollection(jsonRep);
	}
	*/
	/*
	 * Version 2 Api Implementation...
	 * 
	 */
	/**
	 * This method is used to create class page.
	 */
	@Override
	public CollectionDo v2CreateClasspage(CollectionDo collectionDo) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.V2_CREATE_CLASSPAGE, getLoggedInSessionToken());
		ClasspageDo classpageDo = new ClasspageDo();
		classpageDo.setCollectionType(collectionDo.getCollectionType());
		classpageDo.setTitle(collectionDo.getTitle());
		classpageDo.setTaxonomySet(null);
		
		String formData = ResourceFormFactory.generateStringDataForm(classpageDo,
				CLASSPAGE);

		jsonRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword(), formData);
		return deserializeCollection(jsonRep);

	}
	/**
	 * This method is used to update the class page by id.
	 */
	@Override
	public CollectionDo v2UpdateClassPageByid(String classpageId,
			String CollectionType, String title) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_CLASSPAGE, classpageId,getLoggedInSessionToken());

		ClasspageDo classpageDo = new ClasspageDo();
		classpageDo.setCollectionType(CollectionType);
		classpageDo.setTitle(title);
		classpageDo.setTaxonomySet(null);
		
		String formData = ResourceFormFactory.generateStringDataForm(classpageDo,
				CLASSPAGE);

		jsonRep = ServiceProcessor.put(url, getRestUsername(),
				getRestPassword(), formData);
		return deserializeCollection(jsonRep);
	}
	/**
	 * This method is used to get the assignments by class page id.
	 */
	@Override
	public AssignmentsListDo v2GetAssignemtsByClasspageId(String classpageId,String pageSize, String pageNum)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_CLASSPAGE_ASSIGNMENTS, classpageId, getLoggedInSessionToken(), pageSize, pageNum);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeV2AssignmentsList(jsonRep);
	}
	/**
	 * This method is used to get all class pages.
	 */
	@Override
	public ClasspageListDo v2GetAllClasspages(String limit, String offSet) throws GwtException {

		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.V2_LIST_MY_CLASSPAGES, getLoggedInSessionToken(), limit, offSet);
		jsonRep = ServiceProcessor.get(url, getRestUsername(),
				getRestPassword());

		return deserializeClasspageList(jsonRep);
	}
	/**
	 * @function deserializeClasspageList 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize class page list.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ClasspageListDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ClasspageListDo deserializeClasspageList(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				ClasspageListDo classpageList = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ClasspageListDo.class);				
//				List<CollectionDo> collectionDo = classpageList.getSearchResults();
//				for (int i=0; i<collectionDo.size();i++){
//					long milliseconds = Long.parseLong(collectionDo.get(i).getTrackActivity().getEndTime());
//					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//					Date resultdate = new Date(milliseconds);
//					collectionDo.get(i).getTrackActivity().setEndTime(sdf.format(resultdate));
//				}
				
				return classpageList;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ClasspageListDo();
	}
	/**
	 * this method is used to delete the class page.
	 */
	@Override
	public void deleteClasspage(String classpageId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.V2_CLASSPAGE_DELETE, classpageId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
	/**
	 * This method is used to create assignment.
	 */
	@Override
	public AssignmentDo v2CreateAssignment(AssignmentDo assignmentDo) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_ASSIGNMENT, getLoggedInSessionToken());
		String formData = ResourceFormFactory.generateStringDataForm(assignmentDo,null);
		
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
		return deserializeAssignments(jsonRep);
	}
	/**
	 * @function deserializeAssignments 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize assignments.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : AssignmentDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public AssignmentDo deserializeAssignments(
			JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				AssignmentDo assignmentDo = JsonDeserializer.deserialize(
						jsonRep.getJsonObject().toString(), AssignmentDo.class);
				return assignmentDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new AssignmentDo();
	}
	/**
	 * This method is used to get class page by id.
	 */
	@Override
	public CollectionDo v2GetClasspageById(String classpageId)
			throws GwtException {

		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.V2_GET_CLASSPAGE_BY_ID, classpageId,
				getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(),
				getRestPassword());
		
		return deserializeV2Classpage(jsonRep);
	}
	/**
	 * This method is used to get collection page by id.
	 */
	@Override
	public CollectionDo getSCollIdClasspageById(String classpageId)
			throws GwtException {

		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.SIMPLE_COLL_GETAPI, classpageId,
				getLoggedInSessionToken());
		
		try{
		jsonRep = ServiceProcessor.get(url, getRestUsername(),
				getRestPassword());
		}
		catch(Exception e)
		{
			
		}
		
		return deserializeV2Classpage(jsonRep);
	}
	/**
	 * @function deserializeV2Classpage 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize class pages.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : CollectionDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public CollectionDo deserializeV2Classpage(JsonRepresentation jsonRep) {
		CollectionDo collectionDo = new CollectionDo();
		try {
			if (jsonRep.getText() != null && jsonRep.getSize() != -1) {
				try {
					collectionDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionDo.class);
					return collectionDo;
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return collectionDo;
	}

	/**
	 * @function deserializeV2AssignmentsList 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize assignments list.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : AssignmentsListDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public AssignmentsListDo deserializeV2AssignmentsList(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				AssignmentsListDo assignmentList = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), AssignmentsListDo.class);
				
				List<AssignmentsSearchDo> assignmentsSearchDo = assignmentList.getSearchResults();
				for (int i=0; i<assignmentsSearchDo.size();i++){
					if (assignmentsSearchDo.get(i).getTask().getPlannedEndDate()!=null && !assignmentsSearchDo.get(i).getTask().getPlannedEndDate().equalsIgnoreCase("")){
						long milliseconds = Long.parseLong(assignmentsSearchDo.get(i).getTask().getPlannedEndDate());
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						Date resultdate = new Date(milliseconds);
						assignmentsSearchDo.get(i).getTask().setPlannedEndDate(sdf.format(resultdate));
					}
				}
				
				return assignmentList;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new AssignmentsListDo();
	}
	/**
	 * This method is used to set the social share email.
	 */
	@Override
	public void socialShareEmail(String fromTxt, String toTxt,String cfm, String subTxt,
		String msgTxt) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_SOCIAL_SHARE, getLoggedInSessionToken());
		SocialShareDo socialShareDo = new SocialShareDo();
		socialShareDo.setTo(toTxt);
		socialShareDo.setFrom(fromTxt);
		socialShareDo.setCfm(cfm);
		socialShareDo.setSubject(subTxt);
		socialShareDo.setMessage(msgTxt);
		
		socialShareDo.setGooruOid(null);
		socialShareDo.setBitlylink(null);
		socialShareDo.setTitle(null);
		socialShareDo.setDescription(null);
		socialShareDo.setThumbnailurl(null);
		
		
		String formData = ResourceFormFactory.generateStringDataForm(socialShareDo, null);
		jsonRep = ServiceProcessor.post(url, getRestUsername(),	getRestPassword(), formData);
	}
	/**
	 * This method is used to update the assignments.
	 */
	@Override
	public TaskDo v2UpdateAssignment(AssignmentDo assignmentDo, String assignmentId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.V2_UPDATE_ASSIGNMENT, assignmentId, getLoggedInSessionToken());
		String formData = ResourceFormFactory.generateStringDataForm(assignmentDo,null);
		jsonRep = ServiceProcessor.put(url, getRestUsername(),getRestPassword(), formData);
		
		return deserializeTask(jsonRep);
		
	}
	/**
	 * @function deserializeTask 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the task.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : TaskDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public TaskDo deserializeTask(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				TaskDo taskDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), TaskDo.class);
				
				return taskDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new TaskDo();
	}
	/**
	 * This method is used to delete the assignment.
	 */
	@Override
	public void v2DeleteAssignment(String assignmentId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.V2_DELETE_ASSIGNMENT, assignmentId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
	/**
	 * This method is used to add the collection to assignments.
	 */
	@Override
	public TaskResourceAssocDo v2AddCollectionToAssignment(String assignmentId,
			TaskResourceAssocDo taskResourceAssocDo) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.V2_ADD_COLLECTIONS_TO_ASSIGNMENT, assignmentId, getLoggedInSessionToken());
		String formData = ResourceFormFactory.generateStringDataForm(taskResourceAssocDo, TASKRESOURCEASSOC);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(), formData);
		return deserializeTaskResourceAssoc(jsonRep);
	}
	/**
	 * @function deserializeTaskResourceAssoc 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the task resource.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : TaskResourceAssocDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public TaskResourceAssocDo deserializeTaskResourceAssoc(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				TaskResourceAssocDo taskResourceAssocDo = JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), TaskResourceAssocDo.class);
				
				return taskResourceAssocDo;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new TaskResourceAssocDo();
	}
	/**
	 * This method is used to get the assignment collection by id.
	 */
	@Override
	public List<ResourceDo> v2GetAssignmentCollectionsById(String assignmentId)
			throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_ASSIGNMENT_COLLECTIONS, assignmentId, getLoggedInSessionToken());
		return deserializeTaskResourceSearch(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
	/**
	 * @function deserializeTaskResourceSearch 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the task resoruce.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<ResourceDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<ResourceDo> deserializeTaskResourceSearch(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray()
						.toString(), new TypeReference<List<ResourceDo>>() {
				});
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new  ArrayList<ResourceDo>();
	}
	/**
	 * This method is used to remove the collections form the assignment.
	 */
	@Override
	public void v2RemoveCollectionFromAssignment(String collectionId, String assignmentId)
			throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.V2_DELETE_ASSIGNMENT_COLLECION_ITEM, assignmentId, collectionId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
	/**
	 * This method is used to get the class oage by code.
	 */
	@Override
	public CollectionDo v2getClasspageByCode(String classpageCode) throws GwtException{
		
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_CLASSPAGE_BY_CODE, classpageCode, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		return deserializeCollection(jsonRep);
	}
	/**
	 * This method is used get shoten url.
	 */
	@Override
	public List<String> ShotenUrl(String url){
		
		String httpUrl = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GENERATE_BITLY_LINK, getLoggedInSessionToken());
		StringRepresentation strRep = null;
		
		BitlyUrlDo bitlyUrlDo = new BitlyUrlDo();
		bitlyUrlDo.setFullUrl(getHomeEndPoint() +"/#"+ url);
		String formData = ResourceFormFactory.generateStringDataForm(bitlyUrlDo, null);
		strRep = ServiceProcessor.postString(httpUrl, getRestUsername(), getRestPassword(), formData);
		List<String> listUrl=new ArrayList<String>();
		String bitlyLink=strRep.getText().toString();
		String rawUrl=bitlyUrlDo.getFullUrl();
		String originalUrl=bitlyUrlDo.getFullUrl();
		try {
			rawUrl=URLEncoder.encode(rawUrl, "UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(getHttpRequest().getScheme().equalsIgnoreCase(MessageProperties.HTTPS)) {
			bitlyLink = bitlyLink.replaceAll(MessageProperties.HTTP, MessageProperties.HTTPS);
		}
		
		listUrl.add(bitlyLink);
		listUrl.add(rawUrl);
		listUrl.add(originalUrl);
		/*return strRep.getText().toString();*/
		return listUrl;
	}
	/**
	 * @function deserializeBitlyDo 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the bitly.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : BitlyUrlDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public BitlyUrlDo deserializeBitlyDo(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject()
						.toString(), BitlyUrlDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new BitlyUrlDo();
	}
	/**
	 * This method is used to check the permissions for class oage.
	 */
	@Override
	public PermissionsDO checkPermissionsForClasspage(String classpageId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.CHECK_CLASSPAGE_PERMISSIONS_BY_ID, classpageId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		return deserializePermissions(jsonRep);
	}
	/**
	 * @function deserializePermissions 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the permissions.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : PermissionsDO
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private PermissionsDO deserializePermissions(JsonRepresentation jsonRep) {
		if (jsonRep !=null && jsonRep.getSize() != -1){
			try{
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), PermissionsDO.class);
			}catch(JSONException e){
				
			}
		}
		return new PermissionsDO();
	}
	
	/**
	 * This method is used to get the collection class pages.
	 */
	@Override
	public List<ClassPageCollectionDo> getCollectionClasspageAssoc(String collectionId)
			throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_CLASSPAGE_TITLES, collectionId, getLoggedInSessionToken());
		return deserializeClasses(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
	/**
	 * @function deserializeClasses 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to deserialize the classes.
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<ClassPageCollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public List<ClassPageCollectionDo> deserializeClasses(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray()
						.toString(), new TypeReference<List<ClassPageCollectionDo>>() {
				});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return new ArrayList<ClassPageCollectionDo>();
	}
	/**
	 * This method is used to delete the collection associated assignments.
	 */
	@Override
	public void deleteCollectionAssocInAssignment(String collectionId)
			throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_DELETE_COLLECTION, collectionId,
				getLoggedInSessionToken());
		ServiceProcessor.delete(url, getRestUsername(), getRestPassword());
	}
	
}
