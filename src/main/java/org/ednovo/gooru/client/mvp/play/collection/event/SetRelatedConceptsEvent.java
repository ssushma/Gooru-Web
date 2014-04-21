package org.ednovo.gooru.client.mvp.play.collection.event;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @fileName : SetRelatedConceptsEvent.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SetRelatedConceptsEvent extends GwtEvent<SetRelatedConceptsHandler> {
	private String coursePage;
	private String subject;
	private String courseId;
	private String unitId;
	private String lessonId;
	private String libraryName;
	
	public static final Type<SetRelatedConceptsHandler> TYPE = new Type<SetRelatedConceptsHandler>();
	
	public SetRelatedConceptsEvent(String coursePage, String subject, String courseId, String unitId, String lessonId, String libraryName) {
		this.coursePage = coursePage;
		this.subject = subject;
		this.courseId = courseId;
		this.unitId = unitId;
		this.lessonId = lessonId;
		this.libraryName = libraryName;
	}
	
	@Override
	public Type<SetRelatedConceptsHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetRelatedConceptsHandler handler) {
		handler.setRelatedConcepts(coursePage, subject, courseId, unitId, lessonId, libraryName);
	}
}