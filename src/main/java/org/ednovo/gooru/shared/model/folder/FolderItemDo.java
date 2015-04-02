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
package org.ednovo.gooru.shared.model.folder;

import java.io.Serializable;

import org.ednovo.gooru.shared.model.content.ResourceFormatDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FolderItemDo implements Serializable{

	private static final long serialVersionUID = -3298220423508874309L;

	private String gooruOid;
	private String title;
	private ResourceFormatDo resourceFormat;
	private String type;
	private String collectionItemId;
	private String description;
	private String collectionType;
	
	public FolderItemDo(){}

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
	 * This method is to get the resourceFormat
	 */
	public ResourceFormatDo getResourceFormat() {
		return resourceFormat;
	}

	/** 
	 * This method is to set the resourceFormat
	 */
	public void setResourceFormat(ResourceFormatDo resourceFormat) {
		this.resourceFormat = resourceFormat;
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
	 * @return the collectionItemId
	 */
	public String getCollectionItemId() {
		return collectionItemId;
	}

	/**
	 * @param collectionItemId the collectionItemId to set
	 */
	public void setCollectionItemId(String collectionItemId) {
		this.collectionItemId = collectionItemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the collectionType
	 */
	public String getCollectionType() {
		return collectionType;
	}

	/**
	 * @param collectionType the collectionType to set
	 */
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	
}