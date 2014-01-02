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
 * @fileName : QuestionAnswerDo.java
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
public class QuestionAnswerDo implements Serializable,Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String answerText;
	private String answerType;
	private int sequence;
	private boolean isCorrect;
	private Integer answerId;
	/** 
	 * This method is to get the answer text
	 */
	public String getAnswerText() {
		return answerText;
	}
	/** 
	 * This method is to get the answer type
	 */
	public String getAnswerType() {
		return answerType;
	}
	/** 
	 * This method is to get the answer sequence
	 */
	public int getSequence() {
		return sequence;
	}
	/** 
	 * This method will check is correct or not
	 */
	public boolean isIsCorrect() {
		return isCorrect;
	}
	/** 
	 * This method is to set the answer text
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	/** 
	 * This method is to set the answer type
	 */
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	/** 
	 * This method is to set the sequence
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	/** 
	 * This method is to set the boolean value
	 */
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
	@Override
	public int compareTo(Object o) {
		
		 if (this.sequence == ((QuestionAnswerDo) o).sequence)
	           return 0;
	       else if ((this.sequence) > ((QuestionAnswerDo) o).sequence)
	           return 1;
	       else
	           return -1;
	}
	/** 
	 * This method is to get the answer id
	 */
	public Integer getAnswerId() {
		return answerId;
	}
	/** 
	 * This method is to set the answer id
	 */
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

}
