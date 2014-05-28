package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateRatingsGraphEventHandler extends EventHandler {

	void updateRatingGraph(String gooruOId);

}
