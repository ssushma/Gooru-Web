package org.ednovo.gooru.client.mvp.home.library.events;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;


public class StandardPreferenceSettingEvent extends GwtEvent<StandardPreferenceSettingHandler>{

	public static final Type<StandardPreferenceSettingHandler> TYPE = new Type<StandardPreferenceSettingHandler>();
	
	List<String> standCode;
	
	public StandardPreferenceSettingEvent(List<String> standCode){
		this.standCode = standCode;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<StandardPreferenceSettingHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(StandardPreferenceSettingHandler handler) {
		handler.getCode(standCode);
		
	}

}
