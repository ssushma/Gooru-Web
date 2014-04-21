/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Search Team
 * 
 */
public interface SetFolderParentNameHandler extends EventHandler {

	/**
	 * Refresh search view
	 */
	void setFolderParentName(String folderName);

}
