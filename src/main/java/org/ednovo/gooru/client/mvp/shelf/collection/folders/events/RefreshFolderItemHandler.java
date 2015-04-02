/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Search Team
 * 
 */
public interface RefreshFolderItemHandler extends EventHandler {

	void refreshFolderItem(FolderDo folderDo, RefreshFolderType refreshFolderType, HashMap<String,String> params, CollectionDo collDo);

}
