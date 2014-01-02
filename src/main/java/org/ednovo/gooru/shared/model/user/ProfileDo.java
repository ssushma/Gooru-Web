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
import java.util.HashSet;
import java.util.Set;

import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
/**
 * 
 * @fileName : ProfileDo.java
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
public class ProfileDo implements Serializable {

	private static final long serialVersionUID = -2570709586812060758L;
	private UserDo user;
	private String grade;
	private String subject;
	private Integer birthDate;
	private Integer birthMonth;
	private Integer birthYear;
	private String aboutMe;
	private String teachingExperience;
	private String teachingIn;
	private String teachingMethodology;	
	private String highestDegree;
	private String postGraduation;
	private String graduation;
	private String highSchool;
	private byte[] pictureBlob;
	private byte[] thumbnailBlob;
	private Integer isPublisherRequestPending;
	private String pictureFormat;
	private Date dateOfBirth;
	private Date childDateOfBirth;
	private String website;
	private String facebook;
	private String twitter;
	private String userType;
	private CityDo city;
	private CountryDo country;
	private ProvinceDo province;
	private String school;
	private String profileId;
	private String externalId;
	private GenderDo gender;
	private Set<ProfileCodeDo> courses = new HashSet<ProfileCodeDo>();
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
	 * This method is to get the grade
	 */
	public String getGrade() {
		return grade;
	}
	/** 
	 * This method is to set the grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
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
	 * This method is to get the birthDate
	 */
	public Integer getBirthDate() {
		return birthDate;
	}
	/** 
	 * This method is to set the birthDate
	 */
	public void setBirthDate(Integer birthDate) {
		this.birthDate = birthDate;
	}
	/** 
	 * This method is to get the birthMonth
	 */
	public Integer getBirthMonth() {
		return birthMonth;
	}
	/** 
	 * This method is to set the birthMonth
	 */
	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}
	/** 
	 * This method is to get the birthYear
	 */
	public Integer getBirthYear() {
		return birthYear;
	}
	/** 
	 * This method is to set the birthYear
	 */
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
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
	 * This method is to get the teachingExperience
	 */
	public String getTeachingExperience() {
		return teachingExperience;
	}
	/** 
	 * This method is to set the teachingExperience
	 */
	public void setTeachingExperience(String teachingExperience) {
		this.teachingExperience = teachingExperience;
	}
	/** 
	 * This method is to get the teachingIn
	 */
	public String getTeachingIn() {
		return teachingIn;
	}
	/** 
	 * This method is to set the teachingIn
	 */
	public void setTeachingIn(String teachingIn) {
		this.teachingIn = teachingIn;
	}
	/** 
	 * This method is to get the teachingMethodology
	 */
	public String getTeachingMethodology() {
		return teachingMethodology;
	}
	/** 
	 * This method is to set the teachingMethodology
	 */
	public void setTeachingMethodology(String teachingMethodology) {
		this.teachingMethodology = teachingMethodology;
	}
	/** 
	 * This method is to get the highestDegree
	 */
	public String getHighestDegree() {
		return highestDegree;
	}
	/** 
	 * This method is to set the highestDegree
	 */
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	/** 
	 * This method is to get the postGraduation
	 */
	public String getPostGraduation() {
		return postGraduation;
	}
	/** 
	 * This method is to set the postGraduation
	 */
	public void setPostGraduation(String postGraduation) {
		this.postGraduation = postGraduation;
	}
	/** 
	 * This method is to get the graduation
	 */
	public String getGraduation() {
		return graduation;
	}
	/** 
	 * This method is to set the graduation
	 */
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	/** 
	 * This method is to get the highSchool
	 */
	public String getHighSchool() {
		return highSchool;
	}
	/** 
	 * This method is to set the highSchool
	 */
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	/** 
	 * This method is to get the pictureBlob
	 */
	public byte[] getPictureBlob() {
		return pictureBlob;
	}
	/** 
	 * This method is to set the pictureBlob
	 */
	public void setPictureBlob(byte[] pictureBlob) {
		this.pictureBlob = pictureBlob;
	}
	/** 
	 * This method is to get the thumbnailBlob
	 */
	public byte[] getThumbnailBlob() {
		return thumbnailBlob;
	}
	/** 
	 * This method is to set the thumbnailBlob
	 */
	public void setThumbnailBlob(byte[] thumbnailBlob) {
		this.thumbnailBlob = thumbnailBlob;
	}
	/** 
	 * This method is to get the isPublisherRequestPending
	 */
	public Integer getIsPublisherRequestPending() {
		return isPublisherRequestPending;
	}
	/** 
	 * This method is to set the isPublisherRequestPending
	 */
	public void setIsPublisherRequestPending(Integer isPublisherRequestPending) {
		this.isPublisherRequestPending = isPublisherRequestPending;
	}
	/** 
	 * This method is to get the pictureFormat
	 */
	public String getPictureFormat() {
		return pictureFormat;
	}
	/** 
	 * This method is to set the pictureFormat
	 */
	public void setPictureFormat(String pictureFormat) {
		this.pictureFormat = pictureFormat;
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
	/** 
	 * This method is to get the childDateOfBirth
	 */
	public Date getChildDateOfBirth() {
		return childDateOfBirth;
	}
	/** 
	 * This method is to set the childDateOfBirth
	 */
	public void setChildDateOfBirth(Date childDateOfBirth) {
		this.childDateOfBirth = childDateOfBirth;
	}
	/** 
	 * This method is to get the website
	 */
	public String getWebsite() {
		return website;
	}
	/** 
	 * This method is to set the website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/** 
	 * This method is to get the facebook
	 */
	public String getFacebook() {
		return facebook;
	}
	/** 
	 * This method is to set the facebook
	 */
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	/** 
	 * This method is to get the twitter
	 */
	public String getTwitter() {
		return twitter;
	}
	/** 
	 * This method is to set the twitter
	 */
	public void setTwitter(String twitter) {
		this.twitter = twitter;
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
	 * This method is to get the school
	 */
	public String getSchool() {
		return school;
	}
	/** 
	 * This method is to set the school
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/** 
	 * This method is to get the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	/** 
	 * This method is to set the profileId
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
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
	 * This method is to get the courses
	 */
	public Set<ProfileCodeDo> getCourses() {
		return courses;
	}
	/** 
	 * This method is to set the courses
	 */
	public void setCourses(Set<ProfileCodeDo> courses) {
		this.courses = courses;
	}
}
