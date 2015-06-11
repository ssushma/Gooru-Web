package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateAssmntUrlOnMycollEvent extends GwtEvent<UpdateAssmntUrlOnMycollEventHandler> {
	
	public static final Type<UpdateAssmntUrlOnMycollEventHandler> TYPE = new Type<UpdateAssmntUrlOnMycollEventHandler>();

	private FolderDo folderDo;
	
	public UpdateAssmntUrlOnMycollEvent(FolderDo folderDo){
		this.folderDo = folderDo;
	}
	
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateAssmntUrlOnMycollEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateAssmntUrlOnMycollEventHandler handler) {
		handler.updateMyCollAssmntUrl(folderDo);
	}

	

}
