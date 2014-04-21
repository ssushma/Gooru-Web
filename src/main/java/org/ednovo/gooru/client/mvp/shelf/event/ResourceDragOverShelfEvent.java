package org.ednovo.gooru.client.mvp.shelf.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ResourceDragOverShelfEvent extends GwtEvent<ResourceDragOverShelfHandler> { 
	
	public static final Type<ResourceDragOverShelfHandler>  TYPE = new Type<ResourceDragOverShelfHandler>();
	
	private String collectionId="";
	
	public ResourceDragOverShelfEvent(String collectionId){
		this.collectionId=collectionId;
	}
	

	@Override
	public Type<ResourceDragOverShelfHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ResourceDragOverShelfHandler handler) {
		handler.getCollectionItems(collectionId);
	} 

}
