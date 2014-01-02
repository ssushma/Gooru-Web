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
/**
 * 
 * @fileName : ResourceSourceDo.java
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
public class ResourceSourceDo implements Serializable {
	
	private static final long serialVersionUID = -6528540769336671670L;
	
	private String activeStatus;
	private String attribution;
	private String resourceSourceId;
	private String sourceName;
	private String domainName;
	private Integer frameBreaker;
	private String type;
	/** 
	 * This method is to get the activeStatus
	 */
	public String getActiveStatus() {
		return activeStatus;
	}
	/** 
	 * This method is to set the activeStatus
	 */
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	/** 
	 * This method is to get the attribution
	 */
	public String getAttribution() {
		return attribution;
	}
	/** 
	 * This method is to set the attribution
	 */
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	/** 
	 * This method is to get the resourceSourceId
	 */
	public String getResourceSourceId() {
		return resourceSourceId;
	}
	/** 
	 * This method is to set the resourceSourceId
	 */
	public void setResourceSourceId(String resourceSourceId) {
		this.resourceSourceId = resourceSourceId;
	}
	/** 
	 * This method is to get the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}
	/** 
	 * This method is to set the sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/** 
	 * This method is to get the domainName
	 */
	public String getDomainName() {
		return domainName;
	}
	/** 
	 * This method is to set the domainName
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	/** 
	 * This method is to get the frameBreaker
	 */
	public Integer getFrameBreaker() {
		return frameBreaker;
	}
	/** 
	 * This method is to set the frameBreaker
	 */
	public void setFrameBreaker(Integer frameBreaker) {
		this.frameBreaker = frameBreaker;
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
}
