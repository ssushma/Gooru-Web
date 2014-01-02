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
package org.ednovo.gooru.shared.model.featured;

import java.io.Serializable;
/**
 * @fileName : CollectionFilterProperties.java
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

public class CollectionFilterProperties implements Serializable {
	private static final long serialVersionUID = -8046999602373721761L;
	private String mathCollection;
	private String scienceCollection;
	private String socialCollection;
	private String languageCollection;
	private String classroomUseCases;
	private String classroomHowToUse;
	/**
	 * @return the mathCollection
	 */
	public String getMathCollection() {
		return mathCollection;
	}
	/**
	 * @param mathCollection the mathCollection to set
	 */
	public void setMathCollection(String mathCollection) {
		this.mathCollection = mathCollection;
	}
	/**
	 * @return the scienceCollection
	 */
	public String getScienceCollection() {
		return scienceCollection;
	}
	/**
	 * @param scienceCollection the scienceCollection to set
	 */
	public void setScienceCollection(String scienceCollection) {
		this.scienceCollection = scienceCollection;
	}
	/**
	 * @return the socialCollection
	 */
	public String getSocialCollection() {
		return socialCollection;
	}
	/**
	 * @param socialCollection the socialCollection to set
	 */
	public void setSocialCollection(String socialCollection) {
		this.socialCollection = socialCollection;
	}
	/**
	 * @return the languageCollection
	 */
	public String getLanguageCollection() {
		return languageCollection;
	}
	/**
	 * @param languageCollection the languageCollection to set
	 */
	public void setLanguageCollection(String languageCollection) {
		this.languageCollection = languageCollection;
	}
	
	/**
	 * @return the classroomUseCases
	 */
	public String getClassroomUseCases() {
		return classroomUseCases;
	}
	/**
	 * @param classroomUseCases the classroomUseCases to set
	 */
	public void setClassroomUseCases(String classroomUseCases) {
		this.classroomUseCases = classroomUseCases;
	}
	
	/**
	 * @return the classroomHowToUse
	 */
	public String getClassroomHowToUse() {
		return classroomHowToUse;
	}
	/**
	 * @param classroomHowToUse the classroomHowToUse to set
	 */
	public void setClassroomHowToUse(String classroomHowToUse) {
		this.classroomHowToUse = classroomHowToUse;
	}

}
