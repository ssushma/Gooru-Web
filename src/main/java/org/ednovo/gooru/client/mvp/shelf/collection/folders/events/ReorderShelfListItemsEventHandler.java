package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.EventHandler;

public interface ReorderShelfListItemsEventHandler extends EventHandler {

	void reorderShelfListItems(String itemId, int toBeMovedPos,String direction, HashMap<String, String> params, FolderDo folderDo, String itemSeqNumb);   

}
