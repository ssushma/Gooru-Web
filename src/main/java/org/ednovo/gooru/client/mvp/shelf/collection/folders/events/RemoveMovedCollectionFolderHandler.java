package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.EventHandler;

public interface RemoveMovedCollectionFolderHandler extends EventHandler {

	void removeMovedCollectionFromShelf(String sourceId); 

}
