/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Search Team
 * 
 */
public interface RefreshCollectionInShelfListInResourcePlayHandler extends EventHandler {

	/**
	 * Refresh user shelf collection list 
	 * @param collection instance of the collection
	 * @param refreshType instance of {@link RefreshType}
	 */
	void refreshCollectionInShelfListInPlay(String collectionId);

}
