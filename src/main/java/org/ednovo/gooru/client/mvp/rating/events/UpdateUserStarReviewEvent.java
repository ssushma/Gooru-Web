package org.ednovo.gooru.client.mvp.rating.events;


import java.util.ArrayList;

import org.ednovo.gooru.shared.model.content.StarRatingsDo;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateUserStarReviewEvent extends GwtEvent<UpdateUserStarReviewEventHandler> {

	public static final Type<UpdateUserStarReviewEventHandler> TYPE = new Type<UpdateUserStarReviewEventHandler>();
	
	ArrayList<StarRatingsDo> starRatingsDo;
	 
	public UpdateUserStarReviewEvent(ArrayList<StarRatingsDo> starRatingsDoUpdated){ 
		this.starRatingsDo = starRatingsDoUpdated;
	}

	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateUserStarReviewEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateUserStarReviewEventHandler handler) {
		handler.updateStarRatingAndreviews(starRatingsDo);
	}

}
