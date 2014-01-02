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
import java.util.List;
/**
 * 
 * @fileName : CollectionMetaInfoDo.java
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
public class CollectionMetaInfoDo implements Serializable {

	private static final long serialVersionUID = 8598215298047619076L;
	private List<StandardFo> standards;
	private List<String> course;
	private List<String> acknowledgement;
	private RatingDo rating;
	/** 
	 * This method is to get the standards
	 */
	public List<StandardFo> getStandards() {
		return standards;
	}
	/** 
	 * This method is to set the standards
	 */
	public void setStandards(List<StandardFo> standards) {
		this.standards = standards;
	}
	/** 
	 * This method is to get the course
	 */
	public List<String> getCourse() {
		return course;
	}
	/** 
	 * This method is to set the course
	 */
	public void setCourse(List<String> course) {
		this.course = course;
	}
	/** 
	 * This method is to get the acknowledgement
	 */
	public List<String> getAcknowledgement() {
		return acknowledgement;
	}
	/** 
	 * This method is to set the acknowledgement
	 */
	public void setAcknowledgement(List<String> acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	/** 
	 * This method is to get the rating
	 */
	public RatingDo getRating() {
		return rating;
	}
	/** 
	 * This method is to set the rating
	 */
	public void setRating(RatingDo rating) {
		this.rating = rating;
	}

}
