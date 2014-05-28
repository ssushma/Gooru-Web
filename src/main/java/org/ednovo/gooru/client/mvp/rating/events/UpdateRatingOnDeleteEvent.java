package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;


public class UpdateRatingOnDeleteEvent extends GwtEvent<UpdateRatingOnDeleteHandler>{
	public static final Type<UpdateRatingOnDeleteHandler>TYPE = new Type<UpdateRatingOnDeleteHandler>();
	private boolean isDeleted;

	public UpdateRatingOnDeleteEvent(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateRatingOnDeleteHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateRatingOnDeleteHandler handler) {
		handler.updateRating(isDeleted);
		
	}

}
