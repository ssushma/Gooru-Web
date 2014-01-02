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
import java.util.HashMap;

import org.ednovo.gooru.client.service.LibraryService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LessonDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;
import org.ednovo.gooru.shared.model.library.SubjectDo;
import org.ednovo.gooru.shared.model.library.TopicDo;
import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
/**
 * @fileName : LibraryServiceImpl.java
 *
 * @description : This is the implementation of the library service.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Service("libraryService")
@ServiceURL("/libraryService")
public class LibraryServiceImpl extends BaseServiceImpl implements LibraryService {

	private static final long serialVersionUID = 1L;
	private static final String COURSE = "data";
	
	/**
	 * This method is used to get courses list.
	 */
	@Override
	public ArrayList<CourseDo> getCourses(String subjectName) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_LIBRARY_COURSES, subjectName, getLoggedInSessionToken());
		JsonRepresentation json = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCourses(json, subjectName);
	}
	
	/**
	 * This method is used for lessons pagination.
	 */
	@Override
	public ArrayList<LessonDo> getLessonsOnPagination(String subjectName, String topicId, int offset, int limit) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_LIBRARY_TOPIC_OFFSET, subjectName, topicId, getLoggedInSessionToken(), ""+offset, ""+limit);
		JsonRepresentation json = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeLessons(json);
	}
	
	/**
	 * This method is used to get featured library users.
	 */
	@Override
	public ArrayList<LibraryUserDo> getLibraryFeaturedUsers() throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_LIBRARY_FEATURED_USERS, getLoggedInSessionToken());
		JsonRepresentation json = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeCollaborators(json);
	}
	/**
	 * This method is used to get the subjects.
	 */
	@Override
	public HashMap<String, SubjectDo> getSubjects(String subjectId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_LIBRARY_COURSES, subjectId, getLoggedInSessionToken());
		JsonRepresentation json = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		return deserializeSubjects(json,subjectId);
	}

	/**
	 * This method is used to get the concepts.
	 */
	@Override
	public ConceptDo getConcept(String gooruOid, boolean skipCollectionItems) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_LIBRARY_CONCEPT, gooruOid, getLoggedInSessionToken());
		return deserializeConcept(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}

	/**
	 * This method is used to get the topics on pagination.
	 */
	@Override
	public ArrayList<TopicDo> getTopicsOnPagination(String subjectId, String unitId) throws GwtException {
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_GET_LIBRARY_UNIT_OFFSET, subjectId, unitId, getLoggedInSessionToken());
		return deserializeTopicList(ServiceProcessor.get(url, getRestUsername(), getRestPassword()));
	}
	
	/**
	 * 
	 * @function deserializeCollaborators 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description : This method is used to deserialize collaborators.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<LibraryUserDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ArrayList<LibraryUserDo> deserializeCollaborators(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<ArrayList<LibraryUserDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<LibraryUserDo>();
	}
	
	/**
	 * 
	 * @function deserializeCourses 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description : This method is used to deserialize the courses.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @param subjectName
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<CourseDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ArrayList<CourseDo> deserializeCourses(JsonRepresentation jsonRep, String subjectName) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				String jsonRep1 = jsonRep.getJsonObject().getJSONObject(subjectName).getJSONArray(COURSE).toString();
				return JsonDeserializer.deserialize(jsonRep1, new TypeReference<ArrayList<CourseDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<CourseDo>();
	}

	/**
	 * 
	 * @function deserializeLessons 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description :  This method is used to deserialize the lessons.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<LessonDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public ArrayList<LessonDo> deserializeLessons(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				String jsonRep1 = jsonRep.getJsonArray().toString();
				return JsonDeserializer.deserialize(jsonRep1, new TypeReference<ArrayList<LessonDo>>() {
				});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<LessonDo>();
	}

	/**
	 * @function deserializeSubjects 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description : This method is used to deserialize the subjects.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @param subjectName
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<CourseDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public HashMap<String,SubjectDo> deserializeSubjects(JsonRepresentation jsonRep, String subjectName) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				String jsonRepStr = jsonRep.getJsonObject().toString();
				return JsonDeserializer.deserialize(jsonRepStr, new TypeReference<HashMap<String, SubjectDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new HashMap<String,SubjectDo>();
	}
	
	/**
	 * 
	 * @function deserializeConcept 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description :This method is used to deserialize the concept.
	 * 
	 * @parm(s) : @param jsonRep
	 * @parm(s) : @return
	 * 
	 * @return : ConceptDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public ConceptDo deserializeConcept(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ConceptDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ConceptDo();
	}

	/**
	 * @function deserializeTopicList 
	 * 
	 * @created_date : 18-Dec-2013
	 * 
	 * @description :This method is used to deserialize the topics list.
	 * 
	 * @parm(s) : @param jsonRepresentation
	 * @parm(s) : @return
	 * 
	 * @return : ArrayList<TopicDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 * 
	*/
	
	private ArrayList<TopicDo> deserializeTopicList(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonArray().toString(), new TypeReference<ArrayList<TopicDo>>() {});
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<TopicDo>();
	}
}
