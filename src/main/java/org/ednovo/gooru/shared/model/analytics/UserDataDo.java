package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserDataDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int reaction;
	private String text;
	private int attemptStatus;
	private int avgReaction;
	private int status;
	private String gooruUId;
	private int score;
	private int totalAttemptUserCount;
	private String type;
	private long timeSpent;
	private int totalInCorrectCount;
	private long avgTimeSpent;
	private int views;
	private int attempts;
	private String userName;
	private String questionType;
	private String resourceGooruOId;
	private String feedbackStatus;
	private String answerObject;
	private String options;
	
	
	public int getReaction() {
		return reaction;
	}
	public void setReaction(int reaction) {
		this.reaction = reaction;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAttemptStatus() {
		return attemptStatus;
	}
	public void setAttemptStatus(int attemptStatus) {
		this.attemptStatus = attemptStatus;
	}
	public int getAvgReaction() {
		return avgReaction;
	}
	public void setAvgReaction(int avgReaction) {
		this.avgReaction = avgReaction;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getGooruUId() {
		return gooruUId;
	}
	public void setGooruUId(String gooruUId) {
		this.gooruUId = gooruUId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalAttemptUserCount() {
		return totalAttemptUserCount;
	}
	public void setTotalAttemptUserCount(int totalAttemptUserCount) {
		this.totalAttemptUserCount = totalAttemptUserCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}
	public int getTotalInCorrectCount() {
		return totalInCorrectCount;
	}
	public void setTotalInCorrectCount(int totalInCorrectCount) {
		this.totalInCorrectCount = totalInCorrectCount;
	}
	public long getAvgTimeSpent() {
		return avgTimeSpent;
	}
	public void setAvgTimeSpent(long avgTimeSpent) {
		this.avgTimeSpent = avgTimeSpent;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getResourceGooruOId() {
		return resourceGooruOId;
	}
	public void setResourceGooruOId(String resourceGooruOId) {
		this.resourceGooruOId = resourceGooruOId;
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
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
}
