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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.ednovo.gooru.client.service.ProfilePageService;
import org.ednovo.gooru.server.ArrayListSorter;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
/**
 * 
 * @fileName : ProfilePageServiceImpl.java
 *
 * @description : This Class is used to provide services for profile page.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Service("profilePageService")
@ServiceURL("/profilePageService")
public class ProfilePageServiceImpl extends BaseServiceImpl implements ProfilePageService {

	private static final long serialVersionUID = -3513384975044132831L;
	private String pageNum = "1";
	private String pageSize = "50";

	private static final String PROFILE = "profile";
	
	private static final String COURSES = "courses";
	
	@Autowired
	ResourceDeserializer resourceDeserializer;

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
 * This method is used to Get user work Space .
 * 
 */
	@Override
	public List<CollectionItemDo> getUserWorkSpace(String userId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_PROFILE_WORKSPACE, userId, getLoggedInSessionToken(), pageNum, pageSize);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		
		List<CollectionItemDo> collectionItemDo = deserializeWorkspace(jsonRep);
		
		Collections.sort(collectionItemDo, new ArrayListSorter("itemSequence", true));
		return collectionItemDo;
	}
/**
 * 
 * @function deserializeWorkspace 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to deserialize Workspace.
 * 
 * 
 * @parm(s) : @param jsonRep
 * @parm(s) : @return
 * 
 * @return : List<CollectionItemDo>
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public List<CollectionItemDo> deserializeWorkspace(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ArrayList<CollectionItemDo>();
	}

	/*@Override
	public CollectionDo getFolderInformation(String folderId)
			throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_A_FOLDER_INFORMATION, folderId, getLoggedInSessionToken());
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCollection(jsonRep);
	}*/
/**
 This method is used to Get Folders
 */
	@Override
	public List<CollectionItemDo> getFolders(String collectionId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION_ITEMS, collectionId, getLoggedInSessionToken(), pageNum, pageSize);
		jsonRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		List<CollectionItemDo> collectionItemDo = deserializeCollectionItems(jsonRep);
		Collections.sort(collectionItemDo, new ArrayListSorter("itemSequence", true));
		return collectionItemDo;
	}
	/**
	 * 
	 * @function deserializeCollectionItems 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to deserialize collection Items .
	 * 
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : List<CollectionItemDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
/**
 * This method is used for Profile Visit Event.
 */
	@Override
	public void profileVisitEvent(String visitorUid) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.PROFILE_PAGE_EVENT, getUUID(),getLoggedInSessionToken());
		Form form=new Form();
		form.add("eventName", "profile-visit");
		form.add("sessionToken", getLoggedInSessionToken());
		form.add("visitorUid", visitorUid);
		jsonRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),form);
	}
	/**
	 * 
	 * @function getUUID 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to get UUID.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	 public String getUUID(){
	        return String.valueOf(UUID.randomUUID());
	 }
/**
 * This method is used to Add Grade for User Profile .
 */
	@Override
	public void addGradeUserProfile(String grade, String userLevel) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		ProfileDo profileDo = new ProfileDo();
		profileDo.setGrade(grade);
		String formData = ResourceFormFactory.generateStringDataForm(profileDo,PROFILE);
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":{\"grade\":\""+grade+"\"}, \"userMetaActiveFlag\" : \"1\"}";
		}
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
	}
/**
 * This method is used to delete Grade User Profile.
 */
	@Override
	public void deleteGradeUserProfile(String grade, String userLevel) throws GwtException {
		String formData = "";
		String url = "";
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":{\"grade\":\""+grade+"\"}, \"userMetaActiveFlag\" : \"0\"}";
		} else if(userLevel.equalsIgnoreCase("settings")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"grade\":\""+grade+"\"}";
		}
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
	}
/**
 * This method is used to Add CourseUser Profile
 */
	@Override
	public void addCourseUserProfile(Set<ProfileCodeDo> profileCodeDo, String userLevel) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		ProfileDo profileDo = new ProfileDo();
		profileDo.setCourses(profileCodeDo);
		String formData = ResourceFormFactory.generateStringDataForm(profileDo,PROFILE);
		if(userLevel.equalsIgnoreCase("profilePage")) {
			
			Iterator codeDoList = profileCodeDo.iterator();
			while(codeDoList.hasNext()) {
				formData = ResourceFormFactory.generateStringMultiDataForm(codeDoList.next(),COURSES);
			}
			
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":" +formData+ ", \"userMetaActiveFlag\" : \"1\"}";
		}
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
	}
	/**
	 * This method is used to Delete CourseUser Profile
	 */
	@Override
	public void deleteCourseUserProfile(CodeDo codeDo, String userLevel) throws GwtException {
		ProfileCodeDo profileCodeDo = new ProfileCodeDo();
		profileCodeDo.setCode(codeDo);
		String formData = ResourceFormFactory.generateStringMultiDataForm(profileCodeDo,COURSES);
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":" +formData+ ", \"userMetaActiveFlag\" : \"0\"}";
		}
		JsonRepresentation jsonRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
	}
}
