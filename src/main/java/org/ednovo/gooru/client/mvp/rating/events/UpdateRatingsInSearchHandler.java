package org.ednovo.gooru.client.mvp.rating.events;

import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateRatingsInSearchHandler extends EventHandler {

	void updateRatingInSearch(ResourceSearchResultDo searchResultDo); 

}
