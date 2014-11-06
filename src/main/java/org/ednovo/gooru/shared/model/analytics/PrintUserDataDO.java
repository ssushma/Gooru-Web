package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PrintUserDataDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String session;
	private String sessionStartTime;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getSessionStartTime() {
		return sessionStartTime;
	}
	public void setSessionStartTime(String sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}
}
