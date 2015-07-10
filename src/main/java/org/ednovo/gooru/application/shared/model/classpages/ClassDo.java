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
package org.ednovo.gooru.application.shared.model.classpages;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @fileName : AssessmentSummaryStatusDo.java
 * 
 * @Author :Gooru Team
 * 
 * @Reviewer:
 */
@JsonInclude(Include.NON_NULL)
public class ClassDo implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String classId;
	private String course;
	private String unit;
	private String lesson;
	private String assessment;
	public String getClassId() {
		return classId;
	}
	public String getCourse() {
		return course;
	}
	public String getUnit() {
		return unit;
	}
	public String getLesson() {
		return lesson;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	
}
