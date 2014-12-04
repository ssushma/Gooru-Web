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
import java.util.List;

import org.ednovo.gooru.shared.model.user.UserDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CollectionDo extends ResourceDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3298220423508874309L;

	private String collectionType;
	private String narrationLink;
	private String notes;
	private String keyPoints;
	private String languageObjective;
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
	private MetaDO meta;
	private Integer statusCode;
	private Integer itemCount;
	private String classpageCode;
	private Date lastModified;
	private UserDo lastModifiedUser;
	private UserDo user;
	private Integer memberCount;
	private TrackActivityDo trackActivity;
	private String sharing;
	private PublishDo publishStatus;
	private String status;
	private String action;
	private List<checkboxSelectedDo> depthOfKnowledges;
	private List<checkboxSelectedDo> instructionalMethod;
	private List<checkboxSelectedDo> audience;
	private List<checkboxSelectedDo> learningSkills;
	private CollectionSettingsDo settings;
	
	public CollectionDo(){
		
	}

	public String getAdds() {
		return adds;
	}

	public List<checkboxSelectedDo> getDepthOfKnowledges() {
		return depthOfKnowledges;
	}

	public void setDepthOfKnowledges(List<checkboxSelectedDo> depthOfKnowledges) {
		this.depthOfKnowledges = depthOfKnowledges;
	}

	public List<checkboxSelectedDo> getInstructionalMethod() {
		return instructionalMethod;
	}

	public void setInstructionalMethod(List<checkboxSelectedDo> instructionalMethod) {
		this.instructionalMethod = instructionalMethod;
	}

	public List<checkboxSelectedDo> getAudience() {
		return audience;
	}

	public void setAudience(List<checkboxSelectedDo> audience) {
		this.audience = audience;
	}

	public List<checkboxSelectedDo> getLearningSkills() {
		return learningSkills;
	}

	public void setLearningSkills(List<checkboxSelectedDo> learningSkills) {
		this.learningSkills = learningSkills;
	}

	public void setAdds(String adds) {
		this.adds = adds;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = views;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = views;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getNarrationLink() {
		return narrationLink;
	}

	public void setNarrationLink(String narrationLink) {
		this.narrationLink = narrationLink;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getKeyPoints() {
		return keyPoints;
	}

	public void setKeyPoints(String keyPoints) {
		this.keyPoints = keyPoints;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public List<CollectionItemDo> getCollectionItems() {
		return collectionItems;
	}

	public void setCollectionItems(List<CollectionItemDo> collectionItems) {
		this.collectionItems = collectionItems;
	}

	public CollectionMetaInfoDo getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(CollectionMetaInfoDo metaInfo) {
		this.metaInfo = metaInfo;
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
	 * This method is to get the meta
	 */
	public MetaDO getMeta() {
		return meta;
	}

	/** 
	 * This method is to set the meta
	 */
	public void setMeta(MetaDO meta) {
		this.meta = meta;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/** 
	 * This method is to get the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/** 
	 * This method is to set the lastModified
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	/** 
	 * This method is to get the lastModifiedUser
	 */
	public UserDo getLastModifiedUser() {
		return lastModifiedUser;
	}

	/** 
	 * This method is to set the lastModifiedUser
	 */
	public void setLastModifiedUser(UserDo lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public String getSharing() {
		return sharing;
	}

	public void setSharing(String sharing) {
		this.sharing = sharing;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLanguageObjective() {
		return languageObjective;
	}

	public void setLanguageObjective(String languageObjective) {
		this.languageObjective = languageObjective;
	}

	/**
	 * @return the publishStatus
	 */
	public PublishDo getPublishStatus() {
		return publishStatus;
	}

	/**
	 * @param publishStatus the publishStatus to set
	 */
	public void setPublishStatus(PublishDo publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public UserDo getUser() {
		return user;
	}

	public void setUser(UserDo user) {
		this.user = user;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public CollectionSettingsDo getSettings() {
		return settings;
	}

	public void setSettings(CollectionSettingsDo settings) {
		this.settings = settings;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	

}
