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
import java.util.ArrayList;

import org.ednovo.gooru.shared.model.user.CreatorDo;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClasspageDo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3908153364905905237L;
	
	private String collectionType;
	private String title;
	private String classpageId;
	private String thumbnailUrl;
	private String classpageCode;
	private ArrayList<String> permissions;
	private int totalHitCount;
	private Integer statusCode;
	private String sharing;
	private String status;
	private String creatorId;
	private String creatorUsername;
	private String creatorProfileImage;
	private String itemCount;
	private String memberCount;
	
	public ClasspageDo(){}
	
	/** 
	 * This method is to get the collectionType
	 */
	public String getCollectionType() {
		return collectionType;
	}
	/** 
	 * This method is to set the collectionType
	 */
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	/** 
	 * This method is to get the title
	 */
	public String getTitle() {
		return title;
	}
	/** 
	 * This method is to set the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the classpageId
	 */
	public String getClasspageId() {
		return classpageId;
	}

	/**
	 * @param classpageId the classpageId to set
	 */
	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}

	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * @return the classpageCode
	 */
	public String getClasspageCode() {
		return classpageCode;
	}

	/**
	 * @param classpageCode the classpageCode to set
	 */
	public void setClasspageCode(String classpageCode) {
		this.classpageCode = classpageCode;
	}

	/**
	 * @return the permissions
	 */
	public ArrayList<String> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	public int getTotalHitCount() {
		return totalHitCount;
	}

	public void setTotalHitCount(int totalHitCount) {
		this.totalHitCount = totalHitCount;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/** 
	 * This method is to get the sharing
	 */
	public String getSharing() {
		return sharing;
	}

	/** 
	 * This method is to set the sharing
	 */
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorUsername() {
		return creatorUsername;
	}

	public void setCreatorUsername(String creatorUsername) {
		this.creatorUsername = creatorUsername;
	}

	public String getCreatorProfileImage() {
		return creatorProfileImage;
	}

	public void setCreatorProfileImage(String creatorProfileImage) {
		this.creatorProfileImage = creatorProfileImage;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(String memberCount) {
		this.memberCount = memberCount;
	}





	
	
	
}
