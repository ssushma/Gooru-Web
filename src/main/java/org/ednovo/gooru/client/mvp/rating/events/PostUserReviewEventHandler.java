package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface PostUserReviewEventHandler extends EventHandler {

	void postReview(String assocGooruOId, String userReview, Integer score, boolean isUpdate);   

}
