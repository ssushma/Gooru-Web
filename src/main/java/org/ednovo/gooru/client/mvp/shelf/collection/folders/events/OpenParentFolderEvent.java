package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

public class OpenParentFolderEvent extends GwtEvent<OpenParentFolderHandler> {
	
	public static final Type<OpenParentFolderHandler> TYPE = new Type<OpenParentFolderHandler>();

	public OpenParentFolderEvent(){
		
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<OpenParentFolderHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OpenParentFolderHandler handler) {
		handler.openParentFolderEvent();
	} 

}
