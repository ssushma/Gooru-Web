package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

public class ReorderShelfListItemsEvent extends GwtEvent<ReorderShelfListItemsEventHandler> {

	public static final Type<ReorderShelfListItemsEventHandler> TYPE = new Type<ReorderShelfListItemsEventHandler>();
	
	private String itemId,direction;
	private int toBeMovedPos;
	
	public ReorderShelfListItemsEvent(String itemId, int toBeMovedPos, String direction){
		this.itemId = itemId;
		this.toBeMovedPos = toBeMovedPos;
		this.direction = direction;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ReorderShelfListItemsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReorderShelfListItemsEventHandler handler) {
		handler.reorderShelfListItems(itemId,toBeMovedPos,direction); 
	}

}
