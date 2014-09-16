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
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AssignmentInsightsDo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7186349946081220989L;
	
	
	private String title=null;
	private Integer status=null;
	private Integer itemSequence=null;
	private String resourceGooruOId=null;
	
	private ArrayList<InsightsUserDataDo> userData=null;
	
	public AssignmentInsightsDo(){}

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
	 * This method is to get the itemSequence
	 */
	public Integer getItemSequence() {
		return itemSequence;
	}

	/** 
	 * This method is to set the itemSequence
	 */
	public void setItemSequence(Integer itemSequence) {
		this.itemSequence = itemSequence;
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

	/** 
	 * This method is to get the userData
	 */
	public ArrayList<InsightsUserDataDo> getUserData() {
		return userData;
	}

	/** 
	 * This method is to set the userData
	 */
	public void setUserData(ArrayList<InsightsUserDataDo> userData) {
		this.userData = userData;
	}

	
}
