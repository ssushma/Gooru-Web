/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class RefreshCollectionInShelfListInPreviewPlayEvent extends GwtEvent<RefreshCollectionInShelfListInPreviewPlayHandler> {

	public static final Type<RefreshCollectionInShelfListInPreviewPlayHandler> TYPE = new Type<RefreshCollectionInShelfListInPreviewPlayHandler>();


	private String collectionId=null;

	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public RefreshCollectionInShelfListInPreviewPlayEvent(String collectionId) {
		this.collectionId=collectionId;
	}

	@Override
	public Type<RefreshCollectionInShelfListInPreviewPlayHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RefreshCollectionInShelfListInPreviewPlayHandler handler) {
		handler.refreshCollectionInShelfListInPlay(collectionId);
	}

}
