package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import com.google.gwt.event.shared.GwtEvent;

public class SetFolderCollectionStyleEvent extends GwtEvent<SetFolderCollectionStyleHandler>{

	HashMap<String,String> params = new HashMap<String,String>();
	
	private String clickType="";
	
	public static final Type<SetFolderCollectionStyleHandler> TYPE = new Type<SetFolderCollectionStyleHandler>();
	
	public SetFolderCollectionStyleEvent(HashMap<String, String> params, String clickType){  
		this.params=params;
		this.clickType=clickType;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetFolderCollectionStyleHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetFolderCollectionStyleHandler handler) {
		handler.setChildFolderCollectionStyle(params,clickType);
	}

}
