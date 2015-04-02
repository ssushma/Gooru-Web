package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetCollectionMovedStyleEvent extends GwtEvent<SetCollectionMovedStyleHandler> {

	String gooruOId ="";
	public static final Type<SetCollectionMovedStyleHandler> TYPE = new Type<SetCollectionMovedStyleHandler>();
	
	public  SetCollectionMovedStyleEvent(String gooruOId){
		this.gooruOId = gooruOId;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetCollectionMovedStyleHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetCollectionMovedStyleHandler handler) {
		handler.setCollectionMovedStyle(gooruOId);
	}

}
