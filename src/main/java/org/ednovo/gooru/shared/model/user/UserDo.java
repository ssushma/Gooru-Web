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
import java.util.List;
import java.util.Set;

import org.ednovo.gooru.shared.model.featured.CollectionFilterProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @fileName : UserDo.java
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
public class UserDo extends ResponseStatusDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351101332489190167L;

	@JsonProperty("partyUid")
	private String userUid;
	private String firstName;
	private String lastName;
	private String username;
	private String emailId = "";
	private Integer confirmStatus;
	private String registerToken;
	private Set<UserRoleAssocDo> userRoleSet;
	private String userRoleSetString;
	private UserGroupDo userGroup;
	private String importCode;
	private Integer addedBySystem;
	private Integer accountTypeId;
	private String profileImageUrl;
	private OrganizationDo organization;
	private String token;
	private boolean availability;
	private String gooruUId;
	private boolean collaboratorCheck;
	private String externalId;
	private FilterSettings settings;
	private Integer viewFlag;
	private String loginType;
	private String usernameDisplay;
	private List<CustomFieldDo> customFields;
	
	private String createdOn;
	
	private boolean isBeforeProductionSwitch=false;
	
	private boolean profileUserVisibility; 

	private CollectionFilterProperties collectionFilterProperties;
	
	private String dateOfBirth;
	
	private String accountCreatedType;
	
	public UserDo(){}

	/** 
	 * This method is to get the userUid
	 */
	public String getUserUid() {
		return userUid;
	}

	/** 
	 * This method is to set the userUid
	 */
	public void setUserUid(String userUid) {
		this.userUid = userUid;
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
	 * This method is to get the username
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 * This method is to set the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** 
	 * This method is to get the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/** 
	 * This method is to set the emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/** 
	 * This method is to get the confirmStatus
	 */
	public Integer getConfirmStatus() {
		return confirmStatus;
	}

	/** 
	 * This method is to set the confirmStatus
	 */
	public void setConfirmStatus(Integer confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	/** 
	 * This method is to get the registerToken
	 */
	public String getRegisterToken() {
		return registerToken;
	}

	/** 
	 * This method is to set the registerToken
	 */
	public void setRegisterToken(String registerToken) {
		this.registerToken = registerToken;
	}

	/** 
	 * This method is to get the userRoleSet
	 */
	public Set<UserRoleAssocDo> getUserRoleSet() {
		return userRoleSet;
	}

	/** 
	 * This method is to set the userRoleSet
	 */
	public void setUserRoleSet(Set<UserRoleAssocDo> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}

	/** 
	 * This method is to get the userRoleSetString
	 */
	public String getUserRoleSetString() {
		return userRoleSetString;
	}

	/** 
	 * This method is to set the userRoleSetString
	 */
	public void setUserRoleSetString(String userRoleSetString) {
		this.userRoleSetString = userRoleSetString;
	}

	/** 
	 * This method is to get the userGroup
	 */
	public UserGroupDo getUserGroup() {
		return userGroup;
	}

	/** 
	 * This method is to set the userGroup
	 */
	public void setUserGroup(UserGroupDo userGroup) {
		this.userGroup = userGroup;
	}

	/** 
	 * This method is to get the importCode
	 */
	public String getImportCode() {
		return importCode;
	}

	/** 
	 * This method is to set the importCode
	 */
	public void setImportCode(String importCode) {
		this.importCode = importCode;
	}

	/** 
	 * This method is to get the addedBySystem
	 */
	public Integer getAddedBySystem() {
		return addedBySystem;
	}

	/** 
	 * This method is to set the addedBySystem
	 */
	public void setAddedBySystem(Integer addedBySystem) {
		this.addedBySystem = addedBySystem;
	}

	/** 
	 * This method is to get the accountTypeId
	 */
	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	/** 
	 * This method is to set the accountTypeId
	 */
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	/** 
	 * This method is to get the profileImageUrl
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	/** 
	 * This method is to set the profileImageUrl
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	/** 
	 * This method is to get the organization
	 */
	public OrganizationDo getOrganization() {
		return organization;
	}

	/** 
	 * This method is to set the organization
	 */
	public void setOrganization(OrganizationDo organization) {
		this.organization = organization;
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
	 * This method is to get the availability
	 */
	public boolean isAvailability() {
		return availability;
	}

	/** 
	 * This method is to set the availability
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	/** 
	 * This method is to get the gooruUId
	 */
	public String getGooruUId() {
		return gooruUId;
	}

	/** 
	 * This method is to set the gooruUId
	 */
	public void setGooruUId(String gooruUId) {
		this.gooruUId = gooruUId;
	}

	/** 
	 * This method is to get the collaboratorCheck
	 */
	public boolean isCollaboratorCheck() {
		return collaboratorCheck;
	}

	/** 
	 * This method is to set the collaboratorCheck
	 */
	public void setCollaboratorCheck(boolean collaboratorCheck) {
		this.collaboratorCheck = collaboratorCheck;
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
	 * This method is to get the settings
	 */
	public FilterSettings getSettings() {
		return settings;
	}

	/** 
	 * This method is to set the settings
	 */
	public void setSettings(FilterSettings settings) {
		this.settings = settings;
	}

	/** 
	 * This method is to get the viewFlag
	 */
	public Integer getViewFlag() {
		return viewFlag;
	}

	/** 
	 * This method is to set the viewFlag
	 */
	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
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
	 * This method is to get the usernameDisplay
	 */
	public String getUsernameDisplay() {
		return usernameDisplay;
	}

	/** 
	 * This method is to set the usernameDisplay
	 */
	public void setUsernameDisplay(String usernameDisplay) {
		this.usernameDisplay = usernameDisplay;
	}

	/** 
	 * This method is to get the customFields
	 */
	public List<CustomFieldDo> getCustomFields() {
		return customFields;
	}

	/** 
	 * This method is to set the customFields
	 */
	public void setCustomFields(List<CustomFieldDo> customFields) {
		this.customFields = customFields;
	}

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
	 * This method is to get the isBeforeProductionSwitch
	 */
	public boolean isBeforeProductionSwitch() {
		return isBeforeProductionSwitch;
	}

	/** 
	 * This method is to set the isBeforeProductionSwitch
	 */
	public void setBeforeProductionSwitch(boolean isBeforeProductionSwitch) {
		this.isBeforeProductionSwitch = isBeforeProductionSwitch;
	}

	/** 
	 * This method is to get the profileUserVisibility
	 */
	public boolean isProfileUserVisibility() {
		return profileUserVisibility;
	}

	/** 
	 * This method is to set the profileUserVisibility
	 */
	public void setProfileUserVisibility(boolean profileUserVisibility) {
		this.profileUserVisibility = profileUserVisibility;
	}

	/** 
	 * This method is to get the collectionFilterProperties
	 */
	public CollectionFilterProperties getCollectionFilterProperties() {
		return collectionFilterProperties;
	}

	/** 
	 * This method is to set the collectionFilterProperties
	 */
	public void setCollectionFilterProperties(
			CollectionFilterProperties collectionFilterProperties) {
		this.collectionFilterProperties = collectionFilterProperties;
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
	 * This method is to get the accountCreatedType
	 */
	public String getAccountCreatedType() {
		return accountCreatedType;
	}

	/** 
	 * This method is to set the accountCreatedType
	 */
	public void setAccountCreatedType(String accountCreatedType) {
		this.accountCreatedType = accountCreatedType;
	}
}
