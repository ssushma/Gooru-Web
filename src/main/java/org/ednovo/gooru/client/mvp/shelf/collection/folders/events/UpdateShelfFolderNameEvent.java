/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class UpdateShelfFolderNameEvent extends GwtEvent<UpdateShelfFolderNameHandler> {

	public static final Type<UpdateShelfFolderNameHandler> TYPE = new Type<UpdateShelfFolderNameHandler>();
	private String folderName;
	private String folderId;
	
	public UpdateShelfFolderNameEvent(String folderName, String folderId){ 
		this.folderName=folderName;	
		this.folderId =folderId; 
	}
	
	
	@Override
	public Type<UpdateShelfFolderNameHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateShelfFolderNameHandler handler) {
		handler.updateShelfFolderName(folderName,folderId);
	}

}
