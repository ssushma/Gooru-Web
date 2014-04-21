/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class SetFolderParentNameEvent extends GwtEvent<SetFolderParentNameHandler> {

	public static final Type<SetFolderParentNameHandler> TYPE = new Type<SetFolderParentNameHandler>();
	private String folderName;
	
	public SetFolderParentNameEvent(String folderName){
		this.folderName=folderName;	
	}
	
	
	@Override
	public Type<SetFolderParentNameHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetFolderParentNameHandler handler) {
		handler.setFolderParentName(folderName);
	}

}
