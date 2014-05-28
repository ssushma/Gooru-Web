package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateRatingOnDeleteHandler extends EventHandler {
	public void updateRating(boolean isDeleted);

}
