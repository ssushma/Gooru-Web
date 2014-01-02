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
import java.util.Date;

import org.ednovo.gooru.shared.model.user.UserDo;
/**
 * 
 * @fileName : TagDo.java
 *
 * @description : This class is used as data object.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class TagDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 458264636820101662L;

	private String tagUid;

	private ContentDo content;

	private String label;

	private String type;

	private UserDo user;

	private boolean activeFlag;

	private Date createdOn;

	/** 
	 * This method is to get the tagUid
	 */
	public String getTagUid() {
		return tagUid;
	}

	/** 
	 * This method is to set the tagUid
	 */
	public void setTagUid(String tagUid) {
		this.tagUid = tagUid;
	}

	/** 
	 * This method is to get the content
	 */
	public ContentDo getContent() {
		return content;
	}

	/** 
	 * This method is to set the content
	 */
	public void setContent(ContentDo content) {
		this.content = content;
	}

	/** 
	 * This method is to get the label
	 */
	public String getLabel() {
		return label;
	}

	/** 
	 * This method is to set the label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/** 
	 * This method is to get the type
	 */
	public String getType() {
		return type;
	}

	/** 
	 * This method is to set the type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * This method is to get the activeFlag
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/** 
	 * This method is to set the activeFlag
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/** 
	 * This method is to get the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/** 
	 * This method is to set the createdOn
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
