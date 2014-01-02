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
package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;
/**
 * @fileName : BiographyDo.java
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
public class BiographyDo implements Serializable{
	
	private static final long serialVersionUID = -2570709586812060758L;
	
	private String aboutMe;
	
	private String subject;
	
	private String firstName;
	private String lastName;
	private String genderId;
	/** 
	 * This method is to get the aboutMe
	 */
	public String getAboutMe() {
		return aboutMe;
	}
	/** 
	 * This method is to set the aboutMe
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	/** 
	 * This method is to get the subject
	 */
	public String getSubject() {
		return subject;
	}
	/** 
	 * This method is to set the subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/** 
	 * This method is to get the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/** 
	 * This method is to set the firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** 
	 * This method is to get the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/** 
	 * This method is to set the lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** 
	 * This method is to get the genderId
	 */
	public String getGenderId() {
		return genderId;
	}
	/** 
	 * This method is to set the genderId
	 */
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	
}
