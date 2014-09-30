package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GradeJsonData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estimatedTime;
	private String title;
	private int status;
	private int itemSequence;
	private ArrayList<UserDataDo> userData;
	private String resourceGooruOId;
	private String minimumScore;
	private long avgTimeSpent;
	private long timeSpent;
	
	public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(int itemSequence) {
		this.itemSequence = itemSequence;
	}
	public ArrayList<UserDataDo> getUserData() {
		return userData;
	}
	public void setUserData(ArrayList<UserDataDo> userData) {
		this.userData = userData;
	}
	public String getResourceGooruOId() {
		return resourceGooruOId;
	}
	public void setResourceGooruOId(String resourceGooruOId) {
		this.resourceGooruOId = resourceGooruOId;
	}
	public String getMinimumScore() {
		return minimumScore;
	}
	public void setMinimumScore(String minimumScore) {
		this.minimumScore = minimumScore;
	}
	public long getAvgTimeSpent() {
		return avgTimeSpent;
	}
	public void setAvgTimeSpent(long avgTimeSpent) {
		this.avgTimeSpent = avgTimeSpent;
	}
	public long getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}
}
