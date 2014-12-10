package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OetextDataDO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String OEText;
	private String gooruUId;
	private String organizationUId;
	private String userName;
	private String userGroupUId;
	private String feedbackStatus;
	private String feedbackText;
	private long feedbackTimestamp;
	private String feedbackProviderUId;
	private String answerObject;
	private int status;
	public String getOEText() {
		return OEText;
	}
	public void setOEText(String oEText) {
		OEText = oEText;
	}
	public String getGooruUId() {
		return gooruUId;
	}
	public void setGooruUId(String gooruUId) {
		this.gooruUId = gooruUId;
	}
	public String getOrganizationUId() {
		return organizationUId;
	}
	public void setOrganizationUId(String organizationUId) {
		this.organizationUId = organizationUId;
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
	public String getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public String getAnswerObject() {
		return answerObject;
	}
	public void setAnswerObject(String answerObject) {
		this.answerObject = answerObject;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFeedbackText() {
		return feedbackText;
	}
	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}
	public long getFeedbackTimestamp() {
		return feedbackTimestamp;
	}
	public void setFeedbackTimestamp(long feedbackTimestamp) {
		this.feedbackTimestamp = feedbackTimestamp;
	}
	public String getFeedbackProviderUId() {
		return feedbackProviderUId;
	}
	public void setFeedbackProviderUId(String feedbackProviderUId) {
		this.feedbackProviderUId = feedbackProviderUId;
	}
}
