package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateAssmntUrlOnMycollEventHandler extends EventHandler {

	void updateMyCollAssmntUrl(FolderDo folderDo);

}
