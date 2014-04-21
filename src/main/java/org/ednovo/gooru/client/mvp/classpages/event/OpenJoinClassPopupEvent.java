package org.ednovo.gooru.client.mvp.classpages.event;

import com.google.gwt.event.shared.GwtEvent;

public class OpenJoinClassPopupEvent extends
		GwtEvent<OpenJoinClassPopupHandler> {

	public static Type<OpenJoinClassPopupHandler> TYPE = new Type<OpenJoinClassPopupHandler>();


	public OpenJoinClassPopupEvent() {
	}


	@Override
	public Type<OpenJoinClassPopupHandler> getAssociatedType() {
		return TYPE;
	}


	@Override
	protected void dispatch(OpenJoinClassPopupHandler handler) {
		handler.openJoinClassPopup();
	}

}
