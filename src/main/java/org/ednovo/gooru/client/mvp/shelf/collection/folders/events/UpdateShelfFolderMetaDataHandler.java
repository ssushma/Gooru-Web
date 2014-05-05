package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;
import com.google.gwt.event.shared.EventHandler;

public interface UpdateShelfFolderMetaDataHandler extends EventHandler {

	void updateShelfFolderMetaData(String ideas, String performanceTasks, String questions);

}
