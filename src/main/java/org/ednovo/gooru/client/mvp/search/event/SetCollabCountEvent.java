/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class SetCollabCountEvent extends GwtEvent<SetCollabCountHandler> {

	public static final Type<SetCollabCountHandler> TYPE = new Type<SetCollabCountHandler>();

	String type = null; 
	Integer count = 0;
	
	/**
	 * Class constructor
	 */
	public SetCollabCountEvent(String type, Integer count) {
		this.type = type;
		this.count  = count;
	}

	@Override
	public Type<SetCollabCountHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetCollabCountHandler handler) {
		handler.setCollabCountBy(type, count);
	}
}
