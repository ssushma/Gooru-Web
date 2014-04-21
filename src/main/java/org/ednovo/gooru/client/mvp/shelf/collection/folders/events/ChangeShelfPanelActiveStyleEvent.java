package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

public class ChangeShelfPanelActiveStyleEvent extends GwtEvent<ChangeShelfPanelActiveStyleHandler> {

	public static final Type<ChangeShelfPanelActiveStyleHandler> TYPE = new Type<ChangeShelfPanelActiveStyleHandler>();
	
	public ChangeShelfPanelActiveStyleEvent(){}
	
	@Override
	public Type<ChangeShelfPanelActiveStyleHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ChangeShelfPanelActiveStyleHandler handler) {
		handler.changeShelfPanelActiveStyle();
	}
}