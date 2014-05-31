package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateRatingsInRealTimeHandler extends EventHandler {

	void updateRatingInRealTime(String gooruOid, double average, Integer count); 

}
