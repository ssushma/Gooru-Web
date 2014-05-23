package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ContentStarRatingsDistributionDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;
	public Integer getOne() {
		return one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	public Integer getTwo() {
		return two;
	}
	public void setTwo(Integer two) {
		this.two = two;
	}
	public Integer getThree() {
		return three;
	}
	public void setThree(Integer three) {
		this.three = three;
	}
	public Integer getFour() {
		return four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	public Integer getFive() {
		return five;
	}
	public void setFive(Integer five) {
		this.five = five;
	}
	
	
	/**
	 * @return the count
	 */
	
}
