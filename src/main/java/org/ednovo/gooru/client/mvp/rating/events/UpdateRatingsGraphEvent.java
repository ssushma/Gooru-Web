package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateRatingsGraphEvent extends GwtEvent<UpdateRatingsGraphEventHandler> {

	public static final Type<UpdateRatingsGraphEventHandler>TYPE = new Type<UpdateRatingsGraphEventHandler>();
	String gooruOId;
	
	public UpdateRatingsGraphEvent(String gooruOId){
		this.gooruOId = gooruOId;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateRatingsGraphEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateRatingsGraphEventHandler handler) {
		handler.updateRatingGraph(gooruOId);
	}

}
