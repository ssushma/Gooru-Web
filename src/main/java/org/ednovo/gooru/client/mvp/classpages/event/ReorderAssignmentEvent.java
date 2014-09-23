package org.ednovo.gooru.client.mvp.classpages.event;

import com.google.gwt.event.shared.GwtEvent;


public class ReorderAssignmentEvent extends GwtEvent<ReorderAssignmentEventHandler>{
	private int pageNumber;
	public ReorderAssignmentEvent(int pageNumber){
		this.pageNumber = pageNumber;
	}
	public static final Type<ReorderAssignmentEventHandler> TYPE = new Type<ReorderAssignmentEventHandler>();
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ReorderAssignmentEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReorderAssignmentEventHandler handler) {
		handler.reorderAssignment(pageNumber);
		
	}

}
