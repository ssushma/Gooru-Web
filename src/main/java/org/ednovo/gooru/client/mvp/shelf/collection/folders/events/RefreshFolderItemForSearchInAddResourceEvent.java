/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class RefreshFolderItemForSearchInAddResourceEvent extends GwtEvent<RefreshFolderItemEventForSearchInAddResourceHandler> {

	public static final Type<RefreshFolderItemEventForSearchInAddResourceHandler> TYPE = new Type<RefreshFolderItemEventForSearchInAddResourceHandler>();

	private FolderDo folderDo;
	
	private RefreshFolderType refreshFolderType;
	
	private HashMap<String,String> params;
	
	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public RefreshFolderItemForSearchInAddResourceEvent(FolderDo folderDo, RefreshFolderType refreshFolderType, HashMap<String,String> params) {
		this.folderDo = folderDo;
		this.refreshFolderType = refreshFolderType;
		this.params = params;
	}

	@Override
	public Type<RefreshFolderItemEventForSearchInAddResourceHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RefreshFolderItemEventForSearchInAddResourceHandler handler) {
		handler.refreshFolderItemInSearch(folderDo, refreshFolderType, params);
	}
}