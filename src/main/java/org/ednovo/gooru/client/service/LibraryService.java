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
import java.util.HashMap;

import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LessonDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;
import org.ednovo.gooru.shared.model.library.SubjectDo;
import org.ednovo.gooru.shared.model.library.TopicDo;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwt-service/libraryService")
public interface LibraryService extends BaseService {
	
	/**
	 * @function getCourses 
	 * @return : ArrayList<CourseDo>
	 * @description: Get the list of courses of a user
	 * @param: subjectName
	 * @throws : GwtException
	 */
	public ArrayList<CourseDo> getCourses(String subjectName) throws GwtException;
	
	/**
	 * @function getLibraryFeaturedUsers 
	 * @return : ArrayList<LibraryUserDo>
	 * @description: Get the list of featured users for the library
	 * @throws : GwtException
	 */
	public ArrayList<LibraryUserDo> getLibraryFeaturedUsers() throws GwtException;
	
	/**
	 * @function getLessonsOnPagination 
	 * @return : ArrayList<LessonDo>
	 * @description: Get the list of Lesson based on the subject name and the topic id
	 * @param: subjectName
	 * @param: topicId
	 * @param: offset
	 * @param: limit
	 * @throws : GwtException
	 */
	public ArrayList<LessonDo> getLessonsOnPagination(String subjectName, String topicId, int offset, int limit) throws GwtException;
	/**
	 * @function getSubjects 
	 * @return : HashMap<String,SubjectDo>
	 * @description: Get the list of subjects in the taxonomy list
	 * @param: subjectId
	 * @throws : GwtException
	 */
	public HashMap<String,SubjectDo> getSubjects(String subjectId) throws GwtException;
	/**
	 * @function getConcept 
	 * @return : ConceptDo
	 * @description: Get the Collection data for a concept
	 * @param: gooruOid
	 * @param: skipCollectionItems
	 * @throws : GwtException
	 */
	public ConceptDo getConcept(String gooruOid, boolean skipCollectionItems) throws GwtException;
	
	/**
	 * @function getTopicsOnPagination 
	 * @return : ArrayList<TopicDo>
	 * @description: Get the list of the topics based on the unitId
	 * @parm(s) : @param unitId
	 * @parm(s) : @throws GwtException
	 * @throws : GwtException
	 */
	public ArrayList<TopicDo> getTopicsOnPagination(String subjectId, String unitId) throws GwtException;
}
