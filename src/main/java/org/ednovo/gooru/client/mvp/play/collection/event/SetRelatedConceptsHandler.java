package org.ednovo.gooru.client.mvp.play.collection.event;
import com.google.gwt.event.shared.EventHandler;
/**
 * @fileName : SetRelatedConceptsHandler.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 06-Jan-2014
 *
 * @Author: Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface SetRelatedConceptsHandler extends EventHandler {

	/**
	 * @function setRelatedConcepts 
	 * 
	 * @created_date : 07-Jan-2014
	 * 
	 * @parm(s) : @param coursePage
	 * @parm(s) : @param subject
	 * @parm(s) : @param courseId
	 * @parm(s) : @param unitId
	 * @parm(s) : @param lessonId
	 * @parm(s) : @param libraryName
	 * 
	 */
	void setRelatedConcepts(String coursePage, String subject, String courseId, String unitId, String lessonId, String libraryName);
}
