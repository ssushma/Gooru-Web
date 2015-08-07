package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;

import com.google.gwt.event.shared.EventHandler;

public interface InsertMovedCollectionHandler extends EventHandler {

	void insertMovedCollection(FolderDo folderDo,RefreshFolderType refreshFolderType, HashMap<String, String> params);

	
}
