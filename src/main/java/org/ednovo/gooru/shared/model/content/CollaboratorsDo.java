
/**
 * 
*/
package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;


/**
 * 
 * @fileName : CollaboratorsDo.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jan 27, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class CollaboratorsDo implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = -6635116419130714954L;

	private String gooruUid;
	private String gooruOid;
	private String username;
	private String emailId;
	private String status;
	private String profileImageUrl;
	private String associatedDate;
	//Specific to invite students in Class.
	private String email;
	
	
	public CollaboratorsDo(){}
	
	/** 
	 * This method is to get the gooruUid
	 */
	public String getGooruUid() {
		return gooruUid;
	}

	/** 
	 * This method is to set the gooruUid
	 */
	public void setGooruUid(String gooruUid) {
		this.gooruUid = gooruUid;
	}

	/** 
	 * This method is to get the gooruOid
	 */
	public String getGooruOid() {
		return gooruOid;
	}

	/** 
	 * This method is to set the gooruOid
	 */
	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
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
	 * This method is to get the status
	 */
	public String getStatus() {
		return status;
	}

	/** 
	 * This method is to set the status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * This method is to get the associatedDate
	 */
	public String getAssociatedDate() {
		return associatedDate;
	}

	/** 
	 * This method is to set the associatedDate
	 */
	public void setAssociatedDate(String associatedDate) {
		this.associatedDate = associatedDate;
	}


	/** 
	 * This method is to get the email
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * This method is to set the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
