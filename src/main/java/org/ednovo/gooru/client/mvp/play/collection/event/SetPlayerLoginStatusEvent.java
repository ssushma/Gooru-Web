package org.ednovo.gooru.client.mvp.play.collection.event;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @fileName : SetPlayerLoginStatusEvent.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class SetPlayerLoginStatusEvent extends GwtEvent<SetPlayerLoginStatusHandler> {
	private boolean isLoggedIn;
	public static final Type<SetPlayerLoginStatusHandler> TYPE = new Type<SetPlayerLoginStatusHandler>();
	
	public SetPlayerLoginStatusEvent(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	@Override
	public Type<SetPlayerLoginStatusHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetPlayerLoginStatusHandler handler) {
		handler.setPlayerLoginStatusHandler(isLoggedIn);
	}
}