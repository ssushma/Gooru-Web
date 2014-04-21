package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import java.util.HashMap;

import com.google.gwt.event.shared.EventHandler;

public interface SetFolderCollectionStyleHandler extends EventHandler {

	void setChildFolderCollectionStyle(HashMap<String, String> params, String clickType);  

}
