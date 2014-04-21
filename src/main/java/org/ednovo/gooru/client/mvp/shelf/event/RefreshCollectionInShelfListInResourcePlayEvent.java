/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class RefreshCollectionInShelfListInResourcePlayEvent extends GwtEvent<RefreshCollectionInShelfListInResourcePlayHandler> {

	public static final Type<RefreshCollectionInShelfListInResourcePlayHandler> TYPE = new Type<RefreshCollectionInShelfListInResourcePlayHandler>();


	private String collectionId=null;

	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public RefreshCollectionInShelfListInResourcePlayEvent(String collectionId) {
		this.collectionId=collectionId;
	}

	@Override
	public Type<RefreshCollectionInShelfListInResourcePlayHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RefreshCollectionInShelfListInResourcePlayHandler handler) {
		handler.refreshCollectionInShelfListInPlay(collectionId);
	}

}
