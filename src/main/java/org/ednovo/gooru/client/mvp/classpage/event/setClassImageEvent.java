package org.ednovo.gooru.client.mvp.classpage.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;

public class setClassImageEvent extends GwtEvent<setClassImageHandler> {
	
	String fileName;
	
	public static Type<setClassImageHandler> TYPE = new Type<setClassImageHandler>();

	public setClassImageEvent(String fileName){
		this.fileName=fileName;
	}
	
	@Override
	protected void dispatch(setClassImageHandler handler) {
		handler.setImage(fileName);
	}

	@Override
	public Type<setClassImageHandler> getAssociatedType() {
		return TYPE;
	}

}
