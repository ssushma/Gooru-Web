package org.ednovo.gooru.client.mvp.rating.events;

import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateRatingsInSearchEvent extends GwtEvent<UpdateRatingsInSearchHandler> {

	public static final Type<UpdateRatingsInSearchHandler> TYPE = new Type<UpdateRatingsInSearchHandler>();
	
	ResourceSearchResultDo searchResultDo;
	
	public UpdateRatingsInSearchEvent(ResourceSearchResultDo searchResultDo){
		this.searchResultDo = searchResultDo;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UpdateRatingsInSearchHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateRatingsInSearchHandler handler) {
		handler.updateRatingInSearch(searchResultDo);
	}

}
