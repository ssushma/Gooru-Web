package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import com.google.gwt.event.shared.GwtEvent;

public class ReorderShelfListItemsEvent extends GwtEvent<ReorderShelfListItemsEventHandler> {

	public static final Type<ReorderShelfListItemsEventHandler> TYPE = new Type<ReorderShelfListItemsEventHandler>();
	
	private String itemId,direction;
	private int toBeMovedPos;
	private HashMap<String, String> params;
	
	public ReorderShelfListItemsEvent(String itemId, int toBeMovedPos, String direction, HashMap<String, String> params){ 
		this.itemId = itemId;
		this.toBeMovedPos = toBeMovedPos;
		this.direction = direction;
		this.params = params;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ReorderShelfListItemsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReorderShelfListItemsEventHandler handler) {
		handler.reorderShelfListItems(itemId,toBeMovedPos,direction, params); 
	}

}
