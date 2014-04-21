/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @fileName : RemoveCollaboratorObjectEvent.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jan 31, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class RemoveCollaboratorObjectEvent extends GwtEvent<RemoveCollaboratorObjectHandler> {

	public static final Type<RemoveCollaboratorObjectHandler> TYPE = new Type<RemoveCollaboratorObjectHandler>();

	String emailId=null;
	/**
	 * Class constructor
	 */
	public RemoveCollaboratorObjectEvent(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public Type<RemoveCollaboratorObjectHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RemoveCollaboratorObjectHandler handler) {
		handler.removeFromParentByEmailId(emailId);
	}
}
