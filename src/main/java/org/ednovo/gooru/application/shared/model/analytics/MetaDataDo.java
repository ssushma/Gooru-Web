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
package org.ednovo.gooru.application.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @fileName : MetaDataDo.java
 *
 * @Author :Gooru Team
 *
 * @Reviewer:
 */
@JsonInclude(Include.NON_NULL)
public class MetaDataDo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String collectionGooruOId;
	private String result;
	private String questionType;
	private int sequence;
	private long answerId;
	private String type;
	private int isCorrect;
	private long questionId;
	private String endTime;
	private String answerText;
	public String getCollection_gooru_oid() {
		return collectionGooruOId;
	}
	public void setCollection_gooru_oid(String collection_gooru_oid) {
		this.collectionGooruOId = collection_gooru_oid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getQuestion_type() {
		return questionType;
	}
	public void setQuestion_type(String question_type) {
		this.questionType = question_type;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public long getAnswer_id() {
		return answerId;
	}
	public void setAnswer_id(long answer_id) {
		this.answerId = answer_id;
	}
	public String getType_name() {
		return type;
	}
	public void setType_name(String type_name) {
		this.type = type_name;
	}
	public int getIs_correct() {
		return isCorrect;
	}
	public void setIs_correct(int is_correct) {
		this.isCorrect = is_correct;
	}
	public long getQuestion_id() {
		return questionId;
	}
	public void setQuestion_id(long question_id) {
		this.questionId = question_id;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Long getQuestion_gooru_oid() {
		return questionId;
	}
	public void setQuestion_gooru_oid(Long question_gooru_oid) {
		this.questionId = question_gooru_oid;
	}
	public String getAnswer_text() {
		return answerText;
	}
	public void setAnswer_text(String answer_text) {
		this.answerText = answer_text;
	}
}
