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
/**
 * 
 * @fileName : MediaUploadDo.java
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
public class MediaUploadDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4968852767614166770L;
	private String deleteType;
	private String deleteUrl;
	private String imageValidationMsg;
	private String name;
	private String originalFilename;
	private Long size;
	private Integer statusCode;
	private String uploadImageSource;
	private String url;
	/** 
	 * This method is to get the deleteType
	 */
	public String getDeleteType() {
		return deleteType;
	}
	/** 
	 * This method is to set the deleteType
	 */
	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}
	/** 
	 * This method is to get the deleteUrl
	 */
	public String getDeleteUrl() {
		return deleteUrl;
	}
	/** 
	 * This method is to set the deleteUrl
	 */
	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}
	/** 
	 * This method is to get the imageValidationMsg
	 */
	public String getImageValidationMsg() {
		return imageValidationMsg;
	}
	/** 
	 * This method is to set the imageValidationMsg
	 */
	public void setImageValidationMsg(String imageValidationMsg) {
		this.imageValidationMsg = imageValidationMsg;
	}
	/** 
	 * This method is to get the name
	 */
	public String getName() {
		return name;
	}
	/** 
	 * This method is to set the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** 
	 * This method is to get the originalFilename
	 */
	public String getOriginalFilename() {
		return originalFilename;
	}
	/** 
	 * This method is to set the originalFilename
	 */
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	/** 
	 * This method is to get the size
	 */
	public Long getSize() {
		return size;
	}
	/** 
	 * This method is to set the size
	 */
	public void setSize(Long size) {
		this.size = size;
	}
	/** 
	 * This method is to get the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}
	/** 
	 * This method is to set the statusCode
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	/** 
	 * This method is to get the uploadImageSource
	 */
	public String getUploadImageSource() {
		return uploadImageSource;
	}
	/** 
	 * This method is to set the uploadImageSource
	 */
	public void setUploadImageSource(String uploadImageSource) {
		this.uploadImageSource = uploadImageSource;
	}
	/** 
	 * This method is to get the url
	 */
	public String getUrl() {
		return url;
	}
	/** 
	 * This method is to set the url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
