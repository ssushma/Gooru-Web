package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface OpenReviewPopUpEventHandler extends EventHandler {

	void openReviewPopUp(String assocGooruOId,String createrName); 

}
