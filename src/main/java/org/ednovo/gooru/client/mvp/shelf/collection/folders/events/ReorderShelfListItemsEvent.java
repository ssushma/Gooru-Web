package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.GwtEvent;

public class ReorderShelfListItemsEvent extends GwtEvent<ReorderShelfListItemsEventHandler> {

	public static final Type<ReorderShelfListItemsEventHandler> TYPE = new Type<ReorderShelfListItemsEventHandler>();
	
	private String itemId,direction;
	private int toBeMovedPos;
	private HashMap<String, String> params;
	private FolderDo folderDo;
	private String itemSeqNumb;
	
	public ReorderShelfListItemsEvent(String itemId, int toBeMovedPos, String direction, HashMap<String, String> params, FolderDo folderDo, String itemSeqNumb){ 
		this.itemId = itemId;
		this.toBeMovedPos = toBeMovedPos;
		this.direction = direction;
		this.params = params;
		this.folderDo = folderDo;
		this.itemSeqNumb = itemSeqNumb;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ReorderShelfListItemsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ReorderShelfListItemsEventHandler handler) {
		handler.reorderShelfListItems(itemId,toBeMovedPos,direction, params, folderDo, itemSeqNumb); 
	}

}
