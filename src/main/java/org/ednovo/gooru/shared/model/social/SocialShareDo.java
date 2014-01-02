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
package org.ednovo.gooru.shared.model.social;
/**
 * 
 * @fileName : SocialShareDo.java
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
public class SocialShareDo {
	
	private String gooruOid;
	
	private String description;
	
	private String title;
	
	private String thumbnailurl;
	
	private String categoryType;
	
	private boolean isOnlyIcon;
	
	private String bitlylink;
	
	private String to;
	
	private String from;
	
	private String cfm;
	
	private String subject;
	
	private String message;
	
	private String emailId;
	
	private String shareType;
	
	private Boolean isSearchShare;
	
	private String pppBitlylink;
	
	private String rawUrl;

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
	 * This method is to get the description
	 */
	public String getDescription() {
		return description;
	}

	/** 
	 * This method is to set the description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * This method is to get the thumbnailurl
	 */
	public String getThumbnailurl() {
		return thumbnailurl;
	}

	/** 
	 * This method is to set the thumbnailurl
	 */
	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}

	/** 
	 * This method is to get the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/** 
	 * This method is to set the categoryType
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	/** 
	 * This method is to get the isOnlyIcon
	 */
	public boolean isOnlyIcon() {
		return isOnlyIcon;
	}

	/** 
	 * This method is to set the isOnlyIcon
	 */
	public void setOnlyIcon(boolean isOnlyIcon) {
		this.isOnlyIcon = isOnlyIcon;
	}

	/** 
	 * This method is to get the bitlylink
	 */
	public String getBitlylink() {
		return bitlylink;
	}

	/** 
	 * This method is to set the bitlylink
	 */
	public void setBitlylink(String bitlylink) {
		this.bitlylink = bitlylink;
	}

	/** 
	 * This method is to get the to
	 */
	public String getTo() {
		return to;
	}

	/** 
	 * This method is to set the to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/** 
	 * This method is to get the from
	 */
	public String getFrom() {
		return from;
	}

	/** 
	 * This method is to set the from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/** 
	 * This method is to get the cfm
	 */
	public String getCfm() {
		return cfm;
	}

	/** 
	 * This method is to set the cfm
	 */
	public void setCfm(String cfm) {
		this.cfm = cfm;
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
	 * This method is to get the message
	 */
	public String getMessage() {
		return message;
	}

	/** 
	 * This method is to set the message
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * This method is to get the shareType
	 */
	public String getShareType() {
		return shareType;
	}

	/** 
	 * This method is to set the shareType
	 */
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	/** 
	 * This method is to get the isSearchShare
	 */
	public Boolean getIsSearchShare() {
		return isSearchShare;
	}

	/** 
	 * This method is to set the isSearchShare
	 */
	public void setIsSearchShare(Boolean isSearchShare) {
		this.isSearchShare = isSearchShare;
	}

	/** 
	 * This method is to get the pppBitlylink
	 */
	public String getPppBitlylink() {
		return pppBitlylink;
	}

	/** 
	 * This method is to set the pppBitlylink
	 */
	public void setPppBitlylink(String pppBitlylink) {
		this.pppBitlylink = pppBitlylink;
	}

	/** 
	 * This method is to get the rawUrl
	 */
	public String getRawUrl() {
		return rawUrl;
	}

	/** 
	 * This method is to set the rawUrl
	 */
	public void setRawUrl(String rawUrl) {
		this.rawUrl = rawUrl;
	}
}
