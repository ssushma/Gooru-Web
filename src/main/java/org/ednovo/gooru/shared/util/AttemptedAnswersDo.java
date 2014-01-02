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
package org.ednovo.gooru.shared.util;

import java.io.Serializable;
/**
 * @fileName : AttemptedAnswersDo.java
 *
 * @description : This class is used to set and get data of AttemptedAnswersDo model type.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AttemptedAnswersDo implements Serializable{
	
	private static final long serialVersionUID = 4393225749052874789L;
	
	private int questionType;
	private boolean attemptResult;
	private String answersText;
	private int answerId;
	/** 
	 * This method is to get the questionType
	 */
	public int getQuestionType() {
		return questionType;
	}
	/** 
	 * This method is to set the questionType
	 */
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}
	/** 
	 * This method is to get the attemptResult
	 */
	public boolean isAttemptResult() {
		return attemptResult;
	}
	/** 
	 * This method is to set the attemptResult
	 */
	public void setAttemptResult(boolean attemptResult) {
		this.attemptResult = attemptResult;
	}
	/** 
	 * This method is to get the answersText
	 */
	public String getAnswersText() {
		return answersText;
	}
	/** 
	 * This method is to set the answersText
	 */
	public void setAnswersText(String answersText) {
		this.answersText = answersText;
	}
	/** 
	 * This method is to get the answerId
	 */
	public int getAnswerId() {
		return answerId;
	}
	/** 
	 * This method is to set the answerId
	 */
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

}
