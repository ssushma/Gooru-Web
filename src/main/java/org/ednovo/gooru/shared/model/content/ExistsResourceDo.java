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

import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : ExistsResourceDo.java
 *
 * @description :  This class is used as data object.
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
@JsonInclude(Include.NON_NULL)
public class ExistsResourceDo extends ContentDo {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7516412172345732958L;
	private String assetURI;
    private String title;
    private String description;
    private String folder;
    private String category;
    private String explanation;
    private ThumbnailDo thumbnails;
    private ResourceTypeDo resourceType;
    private String shortenedUrlStatus;
    private String label;        //Some api's give title in label key
    private String nativeurl;    //Some api's give url in nativeUrl key
    private String id;
    private String url;

    /** 
	 * This method is to get the assetURI
	 */
	public String getAssetURI() {
		return assetURI;
	}


	/** 
	 * This method is to set the assetURI
	 */
	public void setAssetURI(String assetURI) {
		this.assetURI = assetURI;
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
	 * This method is to get the folder
	 */
	public String getFolder() {
		return folder;
	}


	/** 
	 * This method is to set the folder
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}


	/** 
	 * This method is to get the category
	 */
	public String getCategory() {
		return category;
	}


	/** 
	 * This method is to set the category
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/** 
	 * This method is to get the explanation
	 */
	public String getExplanation() {
		return explanation;
	}


	/** 
	 * This method is to set the explanation
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
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
	 * This method is to get the resourceType
	 */
	public ResourceTypeDo getResourceType() {
		return resourceType;
	}


	/** 
	 * This method is to set the resourceType
	 */
	public void setResourceType(ResourceTypeDo resourceType) {
		this.resourceType = resourceType;
	}


	/** 
	 * This method is to get the shortenedUrlStatus
	 */
	public String getShortenedUrlStatus() {
		return shortenedUrlStatus;
	}


	/** 
	 * This method is to set the shortenedUrlStatus
	 */
	public void setShortenedUrlStatus(String shortenedUrlStatus) {
		this.shortenedUrlStatus = shortenedUrlStatus;
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
	 * This method is to get the nativeurl
	 */
	public String getNativeurl() {
		return nativeurl;
	}


	/** 
	 * This method is to set the nativeurl
	 */
	public void setNativeurl(String nativeurl) {
		this.nativeurl = nativeurl;
	}


	/** 
	 * This method is to get the id
	 */
	public String getId() {
		return id;
	}


	/** 
	 * This method is to set the id
	 */
	public void setId(String id) {
		this.id = id;
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


	public String getThumbnailUrl() {
        if (getCategory() != null && getCategory().equalsIgnoreCase("Video")) {
            return ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(getUrl()));
        } else if (getThumbnails() != null) {
            return getThumbnails().getUrl();
        }
        return null;
    }
}    
