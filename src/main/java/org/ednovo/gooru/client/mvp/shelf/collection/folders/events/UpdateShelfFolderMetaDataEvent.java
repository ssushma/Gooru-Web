/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class UpdateShelfFolderMetaDataEvent extends GwtEvent<UpdateShelfFolderMetaDataHandler> {

	public static final Type<UpdateShelfFolderMetaDataHandler> TYPE = new Type<UpdateShelfFolderMetaDataHandler>();
	private String ideas, performanceTasks, questions;
	
	public UpdateShelfFolderMetaDataEvent(String ideas, String performanceTasks, String questions){
		this.ideas=ideas;
		this.performanceTasks=performanceTasks;
		this.questions=questions;
	}
		
	@Override
	public Type<UpdateShelfFolderMetaDataHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateShelfFolderMetaDataHandler handler) {
		handler.updateShelfFolderMetaData(ideas,performanceTasks,questions);
	}
}