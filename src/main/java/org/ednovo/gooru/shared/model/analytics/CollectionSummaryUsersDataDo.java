package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CollectionSummaryUsersDataDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gooruUId;
	private String userName;
	private String userGroupUId;
	
	//Used this fields in the get sessions api
	private long timeStamp;
	private String sessionId;
	private int frequency;
	
	public String getGooruUId() {
		return gooruUId;
	}
	public void setGooruUId(String gooruUId) {
		this.gooruUId = gooruUId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGroupUId() {
		return userGroupUId;
	}
	public void setUserGroupUId(String userGroupUId) {
		this.userGroupUId = userGroupUId;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
}
