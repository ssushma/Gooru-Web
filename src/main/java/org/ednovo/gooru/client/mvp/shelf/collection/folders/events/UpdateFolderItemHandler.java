package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateFolderItemHandler extends EventHandler {
	void updateFolderItem(FolderDo folderDo, String parentId, HashMap<String,String> params);
}
