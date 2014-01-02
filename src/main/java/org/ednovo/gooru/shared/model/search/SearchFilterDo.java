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
/**
 * 
 */
package org.ednovo.gooru.shared.model.search;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @fileName : SearchFilterDo.java
 *
 * @description : This class is used as data object.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SearchFilterDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3932032047012758170L;

	private Map<String, String> categories;

	private List<String> subjects;

	private Map<String, String> gradeLevels;

	/** 
	 * This method is to get the categories
	 */
	public Map<String, String> getCategories() {
		return categories;
	}

	/** 
	 * This method is to set the categories
	 */
	public void setCategories(Map<String, String> categories) {
		this.categories = categories;
	}

	/** 
	 * This method is to get the subjects
	 */
	public List<String> getSubjects() {
		return subjects;
	}

	/** 
	 * This method is to set the subjects
	 */
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	/** 
	 * This method is to get the gradeLevels
	 */
	public Map<String, String> getGradeLevels() {
		return gradeLevels;
	}

	/** 
	 * This method is to set the gradeLevels
	 */
	public void setGradeLevels(Map<String, String> gradeLevels) {
		this.gradeLevels = gradeLevels;
	}

}
