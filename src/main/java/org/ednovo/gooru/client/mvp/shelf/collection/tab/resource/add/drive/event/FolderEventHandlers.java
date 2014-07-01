package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.event;

import java.util.List;

import org.ednovo.gooru.shared.model.drive.DriveDo;

import com.google.gwt.event.shared.EventHandler;

public interface FolderEventHandlers extends EventHandler {


	void clearFolderpage(String title, String id, List<DriveDo> result);

}
