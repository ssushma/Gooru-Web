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
import java.util.Date;
/**
 * 
 * @fileName : SettingDo.java
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
public class SettingDo implements Serializable {

	private static final long serialVersionUID = -2570709586812060758L;
	
	private UserDo user;
	private CityDo city;
	private CountryDo country;
	private ProvinceDo province;
	private GenderDo gender;
	private String externalId;
	private String userType;
	private String loginType;
	private String aboutMe;
	private Date dateOfBirth;
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
	 * This method is to get the city
	 */
	public CityDo getCity() {
		return city;
	}
	/** 
	 * This method is to set the city
	 */
	public void setCity(CityDo city) {
		this.city = city;
	}
	/** 
	 * This method is to get the country
	 */
	public CountryDo getCountry() {
		return country;
	}
	/** 
	 * This method is to set the country
	 */
	public void setCountry(CountryDo country) {
		this.country = country;
	}
	/** 
	 * This method is to get the province
	 */
	public ProvinceDo getProvince() {
		return province;
	}
	/** 
	 * This method is to set the province
	 */
	public void setProvince(ProvinceDo province) {
		this.province = province;
	}
	/** 
	 * This method is to get the gender
	 */
	public GenderDo getGender() {
		return gender;
	}
	/** 
	 * This method is to set the gender
	 */
	public void setGender(GenderDo gender) {
		this.gender = gender;
	}
	/** 
	 * This method is to get the externalId
	 */
	public String getExternalId() {
		return externalId;
	}
	/** 
	 * This method is to set the externalId
	 */
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	/** 
	 * This method is to get the userType
	 */
	public String getUserType() {
		return userType;
	}
	/** 
	 * This method is to set the userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/** 
	 * This method is to get the loginType
	 */
	public String getLoginType() {
		return loginType;
	}
	/** 
	 * This method is to set the loginType
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
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
	 * This method is to get the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/** 
	 * This method is to set the dateOfBirth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
