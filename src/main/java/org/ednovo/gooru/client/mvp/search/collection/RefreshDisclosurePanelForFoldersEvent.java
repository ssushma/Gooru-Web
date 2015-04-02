package org.ednovo.gooru.client.mvp.search.collection;

import com.google.gwt.event.shared.GwtEvent;

public class RefreshDisclosurePanelForFoldersEvent extends GwtEvent<RefreshDisclosurePanelForFoldersEventHandler> {


	public static final Type<RefreshDisclosurePanelForFoldersEventHandler> TYPE = new Type<RefreshDisclosurePanelForFoldersEventHandler>();


	private String collectionId=null;

	/**
	 * Class constructor , assign  collection object and refresh type
	 */
	public RefreshDisclosurePanelForFoldersEvent(String collectionId) {
		this.collectionId=collectionId;
	}

	@Override
	public Type<RefreshDisclosurePanelForFoldersEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RefreshDisclosurePanelForFoldersEventHandler handler) {
		handler.refreshDisclosurePanelForFoldersinSearch(collectionId);
	}


}
