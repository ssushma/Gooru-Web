package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.EventHandler;

public interface ReorderShelfListItemsEventHandler extends EventHandler {

	void reorderShelfListItems(String itemId, int toBeMovedPos,String direction); 

}
