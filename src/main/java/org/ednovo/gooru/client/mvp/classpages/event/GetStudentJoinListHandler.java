package org.ednovo.gooru.client.mvp.classpages.event;

import com.google.gwt.event.shared.EventHandler;

public interface GetStudentJoinListHandler extends EventHandler{
	void getStudentJoinList(int joinClassList);
}
