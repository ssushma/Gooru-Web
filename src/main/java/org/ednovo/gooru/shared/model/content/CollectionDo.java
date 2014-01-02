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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : CollectionDo.java
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
@JsonInclude(Include.NON_NULL)
public class CollectionDo extends ResourceDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3298220423508874309L;

	private String collectionType;
	private String narrationLink;
	private String notes;
	private String keyPoints;
	private String language;
	private String goals;
	private String grade;
	private String adds;
	private String views;
	private String shares;
	private String likes;
	private String estimatedTime;
	private List<CollectionItemDo> collectionItems;
	private CollectionMetaInfoDo metaInfo;
	private PermissionsDO meta;
	
	private String classpageCode;
	
	private TrackActivityDo trackActivity;

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
	 * This method is to get the narrationLink
	 */
	public String getNarrationLink() {
		return narrationLink;
	}

	/** 
	 * This method is to set the narrationLink
	 */
	public void setNarrationLink(String narrationLink) {
		this.narrationLink = narrationLink;
	}

	/** 
	 * This method is to get the notes
	 */
	public String getNotes() {
		return notes;
	}

	/** 
	 * This method is to set the notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/** 
	 * This method is to get the keyPoints
	 */
	public String getKeyPoints() {
		return keyPoints;
	}

	/** 
	 * This method is to set the keyPoints
	 */
	public void setKeyPoints(String keyPoints) {
		this.keyPoints = keyPoints;
	}

	/** 
	 * This method is to get the language
	 */
	public String getLanguage() {
		return language;
	}

	/** 
	 * This method is to set the language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/** 
	 * This method is to get the goals
	 */
	public String getGoals() {
		return goals;
	}

	/** 
	 * This method is to set the goals
	 */
	public void setGoals(String goals) {
		this.goals = goals;
	}

	/** 
	 * This method is to get the grade
	 */
	public String getGrade() {
		return grade;
	}

	/** 
	 * This method is to set the grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/** 
	 * This method is to get the adds
	 */
	public String getAdds() {
		return adds;
	}

	/** 
	 * This method is to set the adds
	 */
	public void setAdds(String adds) {
		this.adds = adds;
	}

	/** 
	 * This method is to get the views
	 */
	public String getViews() {
		return views;
	}

	/** 
	 * This method is to set the views
	 */
	public void setViews(String views) {
		this.views = views;
	}

	/** 
	 * This method is to get the shares
	 */
	public String getShares() {
		return shares;
	}

	/** 
	 * This method is to set the shares
	 */
	public void setShares(String shares) {
		this.shares = shares;
	}

	/** 
	 * This method is to get the likes
	 */
	public String getLikes() {
		return likes;
	}

	/** 
	 * This method is to set the likes
	 */
	public void setLikes(String likes) {
		this.likes = likes;
	}

	/** 
	 * This method is to get the estimatedTime
	 */
	public String getEstimatedTime() {
		return estimatedTime;
	}

	/** 
	 * This method is to set the estimatedTime
	 */
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/** 
	 * This method is to get the collectionItems
	 */
	public List<CollectionItemDo> getCollectionItems() {
		return collectionItems;
	}

	/** 
	 * This method is to set the collectionItems
	 */
	public void setCollectionItems(List<CollectionItemDo> collectionItems) {
		this.collectionItems = collectionItems;
	}

	/** 
	 * This method is to get the metaInfo
	 */
	public CollectionMetaInfoDo getMetaInfo() {
		return metaInfo;
	}

	/** 
	 * This method is to set the metaInfo
	 */
	public void setMetaInfo(CollectionMetaInfoDo metaInfo) {
		this.metaInfo = metaInfo;
	}

	/** 
	 * This method is to get the meta
	 */
	public PermissionsDO getMeta() {
		return meta;
	}

	/** 
	 * This method is to set the meta
	 */
	public void setMeta(PermissionsDO meta) {
		this.meta = meta;
	}

	/** 
	 * This method is to get the classpageCode
	 */
	public String getClasspageCode() {
		return classpageCode;
	}

	/** 
	 * This method is to set the classpageCode
	 */
	public void setClasspageCode(String classpageCode) {
		this.classpageCode = classpageCode;
	}

	/** 
	 * This method is to get the trackActivity
	 */
	public TrackActivityDo getTrackActivity() {
		return trackActivity;
	}

	/** 
	 * This method is to set the trackActivity
	 */
	public void setTrackActivity(TrackActivityDo trackActivity) {
		this.trackActivity = trackActivity;
	}
}
