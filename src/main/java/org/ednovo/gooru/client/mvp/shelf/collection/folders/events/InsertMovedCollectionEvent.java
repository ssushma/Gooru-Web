package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;

import com.google.gwt.event.shared.GwtEvent;

public class InsertMovedCollectionEvent extends GwtEvent<InsertMovedCollectionHandler> {

	public static final Type<InsertMovedCollectionHandler> TYPE = new Type<InsertMovedCollectionHandler>();

	private FolderDo folderDo;
	
	private RefreshFolderType refreshFolderType;
	
	private HashMap<String,String> params;
	
	public InsertMovedCollectionEvent(FolderDo folderDo, RefreshFolderType refreshFolderType, HashMap<String,String> params) {
		this.folderDo = folderDo;
		this.refreshFolderType = refreshFolderType;
		this.params = params;
	}
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<InsertMovedCollectionHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(InsertMovedCollectionHandler handler) {
		handler.insertMovedCollection(folderDo, refreshFolderType, params);
	}

}
