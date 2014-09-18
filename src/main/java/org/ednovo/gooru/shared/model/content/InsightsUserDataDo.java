/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InsightsUserDataDo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1909303124373795643L;

	private String title;
	private Long avgTimeSpent=null;
	private Integer status=null;
	private String gooruUId=null;
	private Integer views=null;
	private Integer score=null;
	private String userName=null;
	private Long timeSpent=0L;
	private String resourceGooruOId=null;
	
	
	public InsightsUserDataDo(){}


	/** 
	 * This method is to get the title
	 */
	public String getTitle() {
		return title;
	}


	/** 
	 * This method is to set the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/** 
	 * This method is to get the avgTimeSpent
	 */
	public long getAvgTimeSpent() {
		return avgTimeSpent;
	}


	/** 
	 * This method is to set the avgTimeSpent
	 */
	public void setAvgTimeSpent(long avgTimeSpent) {
		this.avgTimeSpent = avgTimeSpent;
	}


	/** 
	 * This method is to get the status
	 */
	public Integer getStatus() {
		return status;
	}


	/** 
	 * This method is to set the status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


	/** 
	 * This method is to get the gooruUId
	 */
	public String getGooruUId() {
		return gooruUId;
	}


	/** 
	 * This method is to set the gooruUId
	 */
	public void setGooruUId(String gooruUId) {
		this.gooruUId = gooruUId;
	}


	/** 
	 * This method is to get the views
	 */
	public Integer getViews() {
		return views;
	}


	/** 
	 * This method is to set the views
	 */
	public void setViews(Integer views) {
		this.views = views;
	}


	/** 
	 * This method is to get the score
	 */
	public Integer getScore() {
		return score;
	}


	/** 
	 * This method is to set the score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}


	/** 
	 * This method is to get the userName
	 */
	public String getUserName() {
		return userName;
	}


	/** 
	 * This method is to set the userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/** 
	 * This method is to get the timeSpent
	 */
	public Long getTimeSpent() {
		return timeSpent;
	}


	/** 
	 * This method is to set the timeSpent
	 */
	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}


	/** 
	 * This method is to get the resourceGooruOId
	 */
	public String getResourceGooruOId() {
		return resourceGooruOId;
	}


	/** 
	 * This method is to set the resourceGooruOId
	 */
	public void setResourceGooruOId(String resourceGooruOId) {
		this.resourceGooruOId = resourceGooruOId;
	}
	
	

}
