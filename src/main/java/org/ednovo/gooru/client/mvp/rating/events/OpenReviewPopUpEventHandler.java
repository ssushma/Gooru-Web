package org.ednovo.gooru.client.mvp.rating.events;

import com.google.gwt.event.shared.EventHandler;

public interface OpenReviewPopUpEventHandler extends EventHandler {
	/**
	 * @function openReviewPopUp 
	 * 
	 * @created_date : May 27, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param assocGooruOId
	 * @param title
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	void openReviewPopUp(String assocGooruOId, String title,String createrName); 

}
