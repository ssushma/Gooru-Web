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
/**
 * 
 * @fileName : QuestionHintsDo.java
 *
 * @description :  This class is used as data object.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@JsonInclude(Include.NON_NULL)
public class QuestionHintsDo implements Serializable,Comparable{

	/**
	 * 
	 */
	private String hintText;
	private int sequence;
	private Integer hintId;
	
	private static final long serialVersionUID = 1L;
	
	/** 
	 * This method is to get the hintText
	 */
	public String getHintText() {
		return hintText;
	}


	/** 
	 * This method is to set the hintText
	 */
	public void setHintText(String hintText) {
		this.hintText = hintText;
	}


	/** 
	 * This method is to get the sequence
	 */
	public int getSequence() {
		return sequence;
	}


	/** 
	 * This method is to set the sequence
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}


	/** 
	 * This method is to get the hintId
	 */
	public Integer getHintId() {
		return hintId;
	}


	/** 
	 * This method is to set the hintId
	 */
	public void setHintId(Integer hintId) {
		this.hintId = hintId;
	}


	@Override
	public int compareTo(Object o) {
		 if (this.sequence == ((QuestionHintsDo) o).sequence)
	           return 0;
	       else if ((this.sequence) > ((QuestionHintsDo) o).sequence)
	           return 1;
	       else
	           return -1;
	}
	
}
