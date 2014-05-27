package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

import com.google.gwt.event.shared.GwtEvent.Type;

public class UpdateResourceRatingCountEvent extends GwtEvent<UpdateResourceRatingCountEventHandler> {
	
	public static final Type<UpdateResourceRatingCountEventHandler> TYPE = new Type<UpdateResourceRatingCountEventHandler>();
	
	Integer score;
	private String resourceId;
	public UpdateResourceRatingCountEvent(String resourceId){ 
		this.score=score;
		this.resourceId=resourceId;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateResourceRatingCountEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateResourceRatingCountEventHandler handler) {
		handler.setResourceRatingCount(resourceId);
	}

}
