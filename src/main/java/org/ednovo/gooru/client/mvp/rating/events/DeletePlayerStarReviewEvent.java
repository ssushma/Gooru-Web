package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

public class DeletePlayerStarReviewEvent extends GwtEvent<DeletePlayerStarReviewHandler> {
	
	public static final Type<DeletePlayerStarReviewHandler> TYPE = new Type<DeletePlayerStarReviewHandler>();
	
	public DeletePlayerStarReviewEvent(){
		
	}
	
	

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeletePlayerStarReviewHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeletePlayerStarReviewHandler handler) {
		handler.deleteStarRatings();
	} 

}
