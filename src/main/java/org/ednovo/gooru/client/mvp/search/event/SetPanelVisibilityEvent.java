/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class SetPanelVisibilityEvent extends GwtEvent<SetPanelVisibilityHandler> {

	public static final Type<SetPanelVisibilityHandler> TYPE = new Type<SetPanelVisibilityHandler>();
	
	/**
	 * Class constructor
	 */
	public SetPanelVisibilityEvent() {
	}

	@Override
	public Type<SetPanelVisibilityHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SetPanelVisibilityHandler handler) {
		handler.setPendingActiveVisibility();
	}
}
