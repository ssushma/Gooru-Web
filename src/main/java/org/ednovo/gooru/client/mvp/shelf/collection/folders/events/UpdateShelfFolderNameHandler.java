package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;
import com.google.gwt.event.shared.EventHandler;

public interface UpdateShelfFolderNameHandler extends EventHandler {

	void updateShelfFolderName(String folderName, String folderId); 

}
