package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenReviewPopUpEvent extends GwtEvent<OpenReviewPopUpEventHandler> {
	
	public static final Type<OpenReviewPopUpEventHandler> TYPE = new Type<OpenReviewPopUpEventHandler>();
	
	String assocGooruOId;
	String title;
	
	public OpenReviewPopUpEvent(String assocGooruOId, String title){ 
		this.assocGooruOId=assocGooruOId;
		this.title = title;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<OpenReviewPopUpEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OpenReviewPopUpEventHandler handler) {
		handler.openReviewPopUp(assocGooruOId, title);
	} 

}
