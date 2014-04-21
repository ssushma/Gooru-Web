package org.ednovo.gooru.client.mvp.home.library.events;

import java.util.List;

import com.google.gwt.event.shared.EventHandler;

public interface StandardPreferenceSettingHandler extends EventHandler {
	
	public List<String> getCode(List<String> code);

}
