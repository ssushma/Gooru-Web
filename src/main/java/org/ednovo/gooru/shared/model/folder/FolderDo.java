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
import java.util.List;

import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FolderDo implements Serializable{

	private static final long serialVersionUID = -3298220423508874309L;

	private String collectionType;
	private String gooruOid;
	private String title;
	private String sharing;
	private Integer itemCount;
	private String type;
	private ThumbnailDo thumbnails;
	private List<FolderItemDo> collectionItems;
	private ResourceFormatDo resourceFormat;
	private ResourceTypeDo resourceTypeDo;
	private String ideas;
	private String performanceTasks;
	private String questions;
	private String collectionItemId;
	private String description;
	private String url;

	public FolderDo(){}
	
	

	public String getCollectionType() {
		return collectionType;
	}



	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
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
	 * This method is to get the itemCount
	 */
	public Integer getItemCount() {
		return itemCount;
	}

	/** 
	 * This method is to set the itemCount
	 */
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
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
	 * This method is to get the thumbnails
	 */
	public ThumbnailDo getThumbnails() {
		return thumbnails;
	}

	/** 
	 * This method is to set the thumbnails
	 */
	public void setThumbnails(ThumbnailDo thumbnails) {
		this.thumbnails = thumbnails;
	}

	/** 
	 * This method is to get the collectionItems
	 */
	public List<FolderItemDo> getCollectionItems() {
		return collectionItems;
	}

	/** 
	 * This method is to set the collectionItems
	 */
	public void setCollectionItems(List<FolderItemDo> collectionItems) {
		this.collectionItems = collectionItems;
	}

	/**
	 * @return the resourceFormat
	 */
	public ResourceFormatDo getResourceFormat() {
		return resourceFormat;
	}

	/**
	 * @param resourceFormat the resourceFormat to set
	 */
	public void setResourceFormat(ResourceFormatDo resourceFormat) {
		this.resourceFormat = resourceFormat;
	}

	/** 
	 * This method is to get the resourceTypeDo
	 */
	public ResourceTypeDo getResourceTypeDo() {
		return resourceTypeDo;
	}

	/** 
	 * This method is to set the resourceTypeDo
	 */
	public void setResourceTypeDo(ResourceTypeDo resourceTypeDo) {
		this.resourceTypeDo = resourceTypeDo;
	}

	public String getIdeas() {
		return ideas;
	}

	public void setIdeas(String ideas) {
		this.ideas = ideas;
	}

	public String getPerformanceTasks() {
		return performanceTasks;
	}

	public void setPerformanceTasks(String performanceTasks) {
		this.performanceTasks = performanceTasks;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}