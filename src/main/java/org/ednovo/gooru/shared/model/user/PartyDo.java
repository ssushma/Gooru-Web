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
 * @fileName : PartyDo.java
 *
 * @description : This class is used as data object.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class PartyDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4795991586707598436L;
	private String partyUid;
	private String partyName;
	private String partyType;
	private Date createdOn;
	private Date lastModifiedOn;
	private String userUid;
	private String lastModifiedUserUid;

	public static enum TYPE {

		NETWORK("network"), ORGANIZATION("organization"), USER("user"), GROUP("group");

		private String name;

		TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	/** 
	 * This method is to get the partyUid
	 */
	public String getPartyUid() {
		return partyUid;
	}

	/** 
	 * This method is to set the partyUid
	 */
	public void setPartyUid(String partyUid) {
		this.partyUid = partyUid;
	}

	/** 
	 * This method is to get the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/** 
	 * This method is to set the partyName
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/** 
	 * This method is to get the partyType
	 */
	public String getPartyType() {
		return partyType;
	}

	/** 
	 * This method is to set the partyType
	 */
	public void setPartyType(String partyType) {
		this.partyType = partyType;
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

	/** 
	 * This method is to get the lastModifiedOn
	 */
	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	/** 
	 * This method is to set the lastModifiedOn
	 */
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

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
	 * This method is to get the lastModifiedUserUid
	 */
	public String getLastModifiedUserUid() {
		return lastModifiedUserUid;
	}

	/** 
	 * This method is to set the lastModifiedUserUid
	 */
	public void setLastModifiedUserUid(String lastModifiedUserUid) {
		this.lastModifiedUserUid = lastModifiedUserUid;
	}

}
