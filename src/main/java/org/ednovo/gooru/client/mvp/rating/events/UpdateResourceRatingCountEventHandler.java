package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateResourceRatingCountEventHandler extends EventHandler {

	void setResourceRatingCount(String resourceId); 
 
}
