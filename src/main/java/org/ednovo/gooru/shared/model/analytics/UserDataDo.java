package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;
import java.util.ArrayList;

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
	private int itemSequence;
	private String gooruUId;
	private int score;
	private int totalAttemptUserCount;
	private String type;
	private long timeSpent;
	private int totalInCorrectCount;
	private int totalCorrectCount;
	private int skip;
	private long avgTimeSpent;
	private int views;
	private int attempts;
	private String userName;
	private String questionType;
	private String resourceGooruOId;
	private String feedbackStatus;
	private String answerObject;
	private String options;
	private ArrayList<MetaDataDo> metaData;
	private String gradeInPercentage;
	private String firstName;
	private String lastName;
	private String emailId;
	private String profileImageUrl;

	
	//This are add for getting the resource data in the teacher summary
	private String category;
	private String title;
	
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
	public ArrayList<MetaDataDo> getMetaData() {
		return metaData;
	}
	public void setMetaData(ArrayList<MetaDataDo> metaData) {
		this.metaData = metaData;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalCorrectCount() {
		return totalCorrectCount;
	}
	public void setTotalCorrectCount(int totalCorrectCount) {
		this.totalCorrectCount = totalCorrectCount;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public String getGradeInPercentage() {
		return gradeInPercentage;
	}
	public void setGradeInPercentage(String gradeInPercentage) {
		this.gradeInPercentage = gradeInPercentage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public int getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(int itemSequence) {
		this.itemSequence = itemSequence;
	}
}
