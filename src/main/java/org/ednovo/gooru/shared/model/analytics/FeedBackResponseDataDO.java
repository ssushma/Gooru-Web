package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FeedBackResponseDataDO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String contentGooruOId;
	private String contentItemId;
	private long createdOn;
	private String feedbackProvidedByGooruId;
	private String freeText;
	private String parentGooruOId;
	private String sessionId;
	private String sessionItemFeedbackUid;
	private String userGooruId;
	public String getContentGooruOId() {
		return contentGooruOId;
	}
	public void setContentGooruOId(String contentGooruOId) {
		this.contentGooruOId = contentGooruOId;
	}
	public String getContentItemId() {
		return contentItemId;
	}
	public void setContentItemId(String contentItemId) {
		this.contentItemId = contentItemId;
	}
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	public String getFeedbackProvidedByGooruId() {
		return feedbackProvidedByGooruId;
	}
	public void setFeedbackProvidedByGooruId(String feedbackProvidedByGooruId) {
		this.feedbackProvidedByGooruId = feedbackProvidedByGooruId;
	}
	public String getFreeText() {
		return freeText;
	}
	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}
	public String getParentGooruOId() {
		return parentGooruOId;
	}
	public void setParentGooruOId(String parentGooruOId) {
		this.parentGooruOId = parentGooruOId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionItemFeedbackUid() {
		return sessionItemFeedbackUid;
	}
	public void setSessionItemFeedbackUid(String sessionItemFeedbackUid) {
		this.sessionItemFeedbackUid = sessionItemFeedbackUid;
	}
	public String getUserGooruId() {
		return userGooruId;
	}
	public void setUserGooruId(String userGooruId) {
		this.userGooruId = userGooruId;
	}
}
