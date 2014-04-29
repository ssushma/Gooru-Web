package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FolderItemMetaDataUc extends Composite {

	private static FolderItemMetaDataUcUiBinder uiBinder = GWT
			.create(FolderItemMetaDataUcUiBinder.class);

	interface FolderItemMetaDataUcUiBinder extends
			UiBinder<Widget, FolderItemMetaDataUc> {
	}

	public FolderItemMetaDataUc() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}