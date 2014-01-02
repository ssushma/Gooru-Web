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
package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : V2UserDo.java
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
@JsonInclude(Include.NON_NULL)
public class V2UserDo extends ResponseStatusDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4651422937333536440L;
	
	private String createdOn;
	private String restEndPoint;
	private String token;
	private UserDo user;
	private String dateOfBirth;
	private String emailConfirmStatus;
	private String accountType;
	private ProfileV2Do profile;
	private String password;
	/** 
	 * This method is to get the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}
	/** 
	 * This method is to set the createdOn
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	/** 
	 * This method is to get the restEndPoint
	 */
	public String getRestEndPoint() {
		return restEndPoint;
	}
	/** 
	 * This method is to set the restEndPoint
	 */
	public void setRestEndPoint(String restEndPoint) {
		this.restEndPoint = restEndPoint;
	}
	/** 
	 * This method is to get the token
	 */
	public String getToken() {
		return token;
	}
	/** 
	 * This method is to set the token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/** 
	 * This method is to get the user
	 */
	public UserDo getUser() {
		return user;
	}
	/** 
	 * This method is to set the user
	 */
	public void setUser(UserDo user) {
		this.user = user;
	}
	/** 
	 * This method is to get the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/** 
	 * This method is to set the dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/** 
	 * This method is to get the emailConfirmStatus
	 */
	public String getEmailConfirmStatus() {
		return emailConfirmStatus;
	}
	/** 
	 * This method is to set the emailConfirmStatus
	 */
	public void setEmailConfirmStatus(String emailConfirmStatus) {
		this.emailConfirmStatus = emailConfirmStatus;
	}
	/** 
	 * This method is to get the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/** 
	 * This method is to set the accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/** 
	 * This method is to get the profile
	 */
	public ProfileV2Do getProfile() {
		return profile;
	}
	/** 
	 * This method is to set the profile
	 */
	public void setProfile(ProfileV2Do profile) {
		this.profile = profile;
	}
	/** 
	 * This method is to get the password
	 */
	public String getPassword() {
		return password;
	}
	/** 
	 * This method is to set the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
