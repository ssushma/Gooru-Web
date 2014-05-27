package org.ednovo.gooru.client.mvp.rating.events;

import java.util.ArrayList;

import org.ednovo.gooru.shared.model.content.StarRatingsDo;

import com.google.gwt.event.shared.EventHandler;

public interface UpdateUserStarReviewEventHandler extends EventHandler {

	void updateStarRatingAndreviews(ArrayList<StarRatingsDo> starRatingsDo);   

}
