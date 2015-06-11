package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateFolderItemEvent extends GwtEvent<UpdateFolderItemHandler> {

	public static final Type<UpdateFolderItemHandler> TYPE = new Type<UpdateFolderItemHandler>();

	private FolderDo folderDo;
	
	private String parentId;
	
	private HashMap<String,String> params;
	
	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public UpdateFolderItemEvent(FolderDo folderDo, String parentId, HashMap<String,String> params) {
		this.folderDo = folderDo;
		this.parentId = parentId;
		this.params = params;
	}

	@Override
	public Type<UpdateFolderItemHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateFolderItemHandler handler) {
		handler.updateFolderItem(folderDo, parentId, params);
	}
}