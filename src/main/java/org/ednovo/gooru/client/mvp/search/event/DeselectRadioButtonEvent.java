/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.event;


import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Search Team
 * 
 */
public class DeselectRadioButtonEvent extends GwtEvent<DeselectRadioButtonHandler> {

	public static final Type<DeselectRadioButtonHandler> TYPE = new Type<DeselectRadioButtonHandler>();

	
	/**
	 * Class constructor
	 */
	public DeselectRadioButtonEvent() {

	}

	@Override
	public Type<DeselectRadioButtonHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeselectRadioButtonHandler handler) {
		handler.setDeSelection();
	}
}
