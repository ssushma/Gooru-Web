package org.ednovo.gooru.client.mvp.shelf.event;

import com.google.gwt.event.shared.EventHandler;

public interface DragOverOpenFolderHandler extends EventHandler {

	void onDragOverOpenFolder(String folderId,boolean showCollectionFormView);
 
}
