package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

public class ActivateCollectionStyleEvent extends GwtEvent<ActivateCollectionStyleHandler> {

	public static final Type<ActivateCollectionStyleHandler> TYPE = new Type<ActivateCollectionStyleHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ActivateCollectionStyleHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ActivateCollectionStyleHandler handler) {
		handler.activecollectionStyle();
	}

}
