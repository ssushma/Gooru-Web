package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenReviewPopUpEvent extends GwtEvent<OpenReviewPopUpEventHandler> {
	
	public static final Type<OpenReviewPopUpEventHandler> TYPE = new Type<OpenReviewPopUpEventHandler>();
	
	String assocGooruOId;
	String title;
	String createrName;
	public OpenReviewPopUpEvent(String assocGooruOId, String title, String createrName){ 
		this.assocGooruOId=assocGooruOId;
		this.title = title;
		this.createrName = createrName;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<OpenReviewPopUpEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OpenReviewPopUpEventHandler handler) {
		handler.openReviewPopUp(assocGooruOId, title,createrName);
	} 

}
