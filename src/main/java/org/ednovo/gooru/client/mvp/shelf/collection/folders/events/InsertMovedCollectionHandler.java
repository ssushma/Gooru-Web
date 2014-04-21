package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.EventHandler;

public interface InsertMovedCollectionHandler extends EventHandler {

	void insertMovedCollection(FolderDo folderDo,RefreshFolderType refreshFolderType, HashMap<String, String> params);

	
}
