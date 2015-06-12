package org.ednovo.gooru.application.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ContentStarRatingsDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private Integer count;
	private double average;
	private ContentStarRatingsDistributionDo scores;
	
	
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}
	public ContentStarRatingsDistributionDo getScores() {
		return scores;
	}
	public void setScores(ContentStarRatingsDistributionDo scores) {
		this.scores = scores;
	}
	
	
}
