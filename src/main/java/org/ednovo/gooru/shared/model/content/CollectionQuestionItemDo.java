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
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : CollectionQuestionItemDo.java
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
public class CollectionQuestionItemDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sharing;
	private String title;
	private String isLive;
	private String label;
	private String questionText;
	private String explanation;
	private String description;
	private String difficultyLevel;
	private String concept;
	private String typeName;
	private String gooruOid;
	private int timeToCompleteInSecs;
	private HashMap<String,ArrayList<QuestionHintsDo>> hints;
	private HashMap<String,ArrayList<QuestionAnswerDo>> answers;
	/** 
	 * This method is to get the sharing
	 */
	public String getSharing() {
		return sharing;
	}
	/** 
	 * This method is to set the sharing
	 */
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
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
	 * This method is to get the isLive
	 */
	public String getIsLive() {
		return isLive;
	}
	/** 
	 * This method is to set the isLive
	 */
	public void setIsLive(String isLive) {
		this.isLive = isLive;
	}
	/** 
	 * This method is to get the label
	 */
	public String getLabel() {
		return label;
	}
	/** 
	 * This method is to set the label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/** 
	 * This method is to get the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}
	/** 
	 * This method is to set the questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	/** 
	 * This method is to get the explanation
	 */
	public String getExplanation() {
		return explanation;
	}
	/** 
	 * This method is to set the explanation
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	/** 
	 * This method is to get the description
	 */
	public String getDescription() {
		return description;
	}
	/** 
	 * This method is to set the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/** 
	 * This method is to get the difficultyLevel
	 */
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	/** 
	 * This method is to set the difficultyLevel
	 */
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	/** 
	 * This method is to get the concept
	 */
	public String getConcept() {
		return concept;
	}
	/** 
	 * This method is to set the concept
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}
	/** 
	 * This method is to get the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	/** 
	 * This method is to set the typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/** 
	 * This method is to get the gooruOid
	 */
	public String getGooruOid() {
		return gooruOid;
	}
	/** 
	 * This method is to set the gooruOid
	 */
	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
	}
	/** 
	 * This method is to get the timeToCompleteInSecs
	 */
	public int getTimeToCompleteInSecs() {
		return timeToCompleteInSecs;
	}
	/** 
	 * This method is to set the timeToCompleteInSecs
	 */
	public void setTimeToCompleteInSecs(int timeToCompleteInSecs) {
		this.timeToCompleteInSecs = timeToCompleteInSecs;
	}
	/** 
	 * This method is to get the hints
	 */
	public HashMap<String, ArrayList<QuestionHintsDo>> getHints() {
		return hints;
	}
	/** 
	 * This method is to set the hints
	 */
	public void setHints(HashMap<String, ArrayList<QuestionHintsDo>> hints) {
		this.hints = hints;
	}
	/** 
	 * This method is to get the answers
	 */
	public HashMap<String, ArrayList<QuestionAnswerDo>> getAnswers() {
		return answers;
	}
	/** 
	 * This method is to set the answers
	 */
	public void setAnswers(HashMap<String, ArrayList<QuestionAnswerDo>> answers) {
		this.answers = answers;
	}
}
