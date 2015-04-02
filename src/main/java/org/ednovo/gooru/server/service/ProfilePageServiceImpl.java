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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.service.ProfilePageService;
import org.ednovo.gooru.server.ArrayListSorter;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.deserializer.ProfileLibraryDeserializer;
import org.ednovo.gooru.server.deserializer.ResourceDeserializer;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.PartnerFolderListDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryDo;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

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
	private static Logger logger=LoggerFactory.getLogger(ProfilePageServiceImpl.class);
	public CollectionDo deserializeCollection(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject()
						.toString(), CollectionDo.class);
			} catch (JSONException e) {
				logger.error(e.getMessage());
			}
		}
		return new CollectionDo();
	}


	public List<CollectionItemDo> deserializeWorkspace(JsonRepresentation jsonRep) {
		try {
			if (jsonRep != null && jsonRep.getSize() != -1) {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			}
		} catch (JSONException e) {
			logger.error(e.getMessage());
		}
		return new ArrayList<CollectionItemDo>();
	}

	@Override
	public List<CollectionItemDo> getFolders(String collectionId) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLECTION_ITEMS, collectionId, getLoggedInSessionToken(), pageNum, pageSize);
		url+="&sharing=public";
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		getLogger().info("getFolders:"+url);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		List<CollectionItemDo> collectionItemDo = deserializeCollectionItems(jsonRep);
		//Collections.sort(collectionItemDo, new ArrayListSorter("itemSequence", true));
		return collectionItemDo;
	}
	
	public List<CollectionItemDo> deserializeCollectionItems(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<List<CollectionItemDo>>() {
				});
			} catch (JSONException e) {
				logger.error(e.getMessage());
			}
		}
		return new ArrayList<CollectionItemDo>();
	}
	
	 public String getUUID(){
	        return String.valueOf(UUID.randomUUID());
	 }

	@Override
	public void addGradeUserProfile(String grade, String userLevel) throws GwtException {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		ProfileDo profileDo = new ProfileDo();
		profileDo.setGrade(grade);
		String formData = ResourceFormFactory.generateStringDataForm(profileDo,PROFILE);
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":{\"grade\":\""+grade+"\"}, \"userMetaActiveFlag\" : \"1\"}";
		}
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}

	@Override
	public void deleteGradeUserProfile(String grade, String userLevel) throws GwtException {
		String formData = "";
		String url = "";
		JsonRepresentation jsonRep = null;
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":{\"grade\":\""+grade+"\"}, \"userMetaActiveFlag\" : \"0\"}";
		} else if(userLevel.equalsIgnoreCase("settings")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"grade\":\""+grade+"\"}";
		}
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}

	@Override
	public void addCourseUserProfile(Set<ProfileCodeDo> profileCodeDo, String userLevel) throws GwtException {
		JsonRepresentation jsonRep = null;
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
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}
	
	@Override
	public void deleteCourseUserProfile(CodeDo codeDo, String userLevel) throws GwtException {
		JsonRepresentation jsonRep = null;
		ProfileCodeDo profileCodeDo = new ProfileCodeDo();
		profileCodeDo.setCode(codeDo);
		String formData = ResourceFormFactory.generateStringMultiDataForm(profileCodeDo,COURSES);
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.DELETE_USER_BIOGRAPHY, getLoggedInUserUid(), getLoggedInSessionToken());
		if(userLevel.equalsIgnoreCase("profilePage")) {
			url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_USER_GRADE_COURSE, getLoggedInUserUid(), getLoggedInSessionToken());
			formData = "{\"profile\":" +formData+ ", \"userMetaActiveFlag\" : \"0\"}";
		}
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), formData);
		jsonRep = jsonResponseRep.getJsonRepresentation();
	}

	@Override
	public ProfileLibraryListDo getProfileLibraryWorkspace(String gooruUid, int limit, String sharingType, String collectionType, String placeToken, int offset) throws GwtException {
		ProfileLibraryListDo profileLibraryListDo = new ProfileLibraryListDo();
		JsonRepresentation jsonRep = null;
		String url = null;
		String sessionToken = getLoggedInSessionToken();
		
		if(sharingType!=null){
			sessionToken=sessionToken+"&sharing="+sharingType;
		}
		if(collectionType!=null){
			sessionToken=sessionToken+"&collectionType="+collectionType;
		}
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_PROFILE_WORKSPACE, gooruUid, sessionToken, limit+"",offset+"","20");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		profileLibraryListDo = new ProfileLibraryDeserializer().deserializeFolderList(jsonRep);
		return profileLibraryListDo;
	}

	@Override
	public ProfileLibraryListDo getProfilePaginationWorkspace(String parentId, String sharingType, int limit) throws GwtException {
		ProfileLibraryListDo profileLibraryListDo = new ProfileLibraryListDo();
		JsonRepresentation jsonRep = null;
		String url = null;
		String sessionToken = getLoggedInSessionToken();
		
		if(sharingType!=null){
			sessionToken=sessionToken+"&sharing="+sharingType;
		}
		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_PARTNER_CHILD_FOLDER_LIST, parentId, sessionToken, limit+"","0");
		getLogger().info("getProfilePaginationWorkspace:"+url);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		profileLibraryListDo = new ProfileLibraryDeserializer().deserializeFolderList(jsonRep);
		return profileLibraryListDo;
	}

	@Override
	public ProfileLibraryDo getProfileLibraryCollection(String gooruOid, boolean skipCollectionItems) throws GwtException {
		JsonRepresentation jsonRepresentation = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_COLLECTION, gooruOid, getLoggedInSessionToken(), skipCollectionItems + "");
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		getLogger().info("getProfileLibraryCollection:"+url);
		jsonRepresentation=jsonResponseRep.getJsonRepresentation();
		return deserializeConcept(jsonRepresentation);
	}

	public ProfileLibraryDo deserializeConcept(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ProfileLibraryDo.class);
			} catch (JSONException e) {
				logger.error(e.getMessage());
			}
		}
		return new ProfileLibraryDo();
	}

}
