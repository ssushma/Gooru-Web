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
package org.ednovo.gooru.shared.model.search;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.shared.model.content.LicenseDo;
import org.ednovo.gooru.shared.model.content.ResourceSourceDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;
import org.ednovo.gooru.shared.model.content.TagDo;
import org.ednovo.gooru.shared.model.user.UserDo;
/**
 * @fileName : ResourceSearchResultDo.java
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
public class ResourceSearchResultDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634893604641263955L;

	private String gooruOid;

	private long entryId;

	private String url;

	private String resourceTitle;

	private String resourceTypeString;

	private String category;

	private String description;

	private int totalViews;

	private List<String> subjectNames;

	private List<String> courseNames;

	private List<String> unitNames;

	private List<String> topicNames;

	private List<String> lessonNames;

	private UserDo owner;

	private String attribution;

	private List<Map<String, String>> standards;

	private String grade;

	private String tags;

	private String averageTime;

	private int sharedCount = 0;

	private String numOfPages;

	private String durationInSec;

	private LicenseDo license;

	private Integer votesUp;

	private Integer votesDown;

	private Set<TagDo> tagSet;

	private String assetURI;
	
	private ResourceTypeDo resourceType;
	
	private ResourceSourceDo  resourceSource;
	
	private String questionType;
	
	private String mediaType;
	
	private int noOfResources;

	/** 
	 * This method is to get the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/** 
	 * This method is to set the mediaType
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public ResourceSearchResultDo() {

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
	 * This method is to get the entryId
	 */
	public long getEntryId() {
		return entryId;
	}

	/** 
	 * This method is to set the entryId
	 */
	public void setEntryId(long entryId) {
		this.entryId = entryId;
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

	/** 
	 * This method is to get the resourceTitle
	 */
	public String getResourceTitle() {
		return resourceTitle;
	}

	/** 
	 * This method is to set the resourceTitle
	 */
	public void setResourceTitle(String resourceTitle) {
		this.resourceTitle = resourceTitle;
	}

	/** 
	 * This method is to get the resourceTypeString
	 */
	public String getResourceTypeString() {
		return resourceTypeString;
	}

	/** 
	 * This method is to set the resourceTypeString
	 */
	public void setResourceTypeString(String resourceTypeString) {
		this.resourceTypeString = resourceTypeString;
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
	 * This method is to get the totalViews
	 */
	public int getTotalViews() {
		return totalViews;
	}

	/** 
	 * This method is to set the totalViews
	 */
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}

	/** 
	 * This method is to get the subjectNames
	 */
	public List<String> getSubjectNames() {
		return subjectNames;
	}

	/** 
	 * This method is to set the subjectNames
	 */
	public void setSubjectNames(List<String> subjectNames) {
		this.subjectNames = subjectNames;
	}

	/** 
	 * This method is to get the courseNames
	 */
	public List<String> getCourseNames() {
		return courseNames;
	}

	/** 
	 * This method is to set the courseNames
	 */
	public void setCourseNames(List<String> courseNames) {
		this.courseNames = courseNames;
	}

	/** 
	 * This method is to get the unitNames
	 */
	public List<String> getUnitNames() {
		return unitNames;
	}

	/** 
	 * This method is to set the unitNames
	 */
	public void setUnitNames(List<String> unitNames) {
		this.unitNames = unitNames;
	}

	/** 
	 * This method is to get the topicNames
	 */
	public List<String> getTopicNames() {
		return topicNames;
	}

	/** 
	 * This method is to set the topicNames
	 */
	public void setTopicNames(List<String> topicNames) {
		this.topicNames = topicNames;
	}

	/** 
	 * This method is to get the lessonNames
	 */
	public List<String> getLessonNames() {
		return lessonNames;
	}

	/** 
	 * This method is to set the lessonNames
	 */
	public void setLessonNames(List<String> lessonNames) {
		this.lessonNames = lessonNames;
	}

	/** 
	 * This method is to get the owner
	 */
	public UserDo getOwner() {
		return owner;
	}

	/** 
	 * This method is to set the owner
	 */
	public void setOwner(UserDo owner) {
		this.owner = owner;
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
	 * This method is to get the standards
	 */
	public List<Map<String, String>> getStandards() {
		return standards;
	}

	/** 
	 * This method is to set the standards
	 */
	public void setStandards(List<Map<String, String>> standards) {
		this.standards = standards;
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
	 * This method is to get the tags
	 */
	public String getTags() {
		return tags;
	}

	/** 
	 * This method is to set the tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/** 
	 * This method is to get the averageTime
	 */
	public String getAverageTime() {
		return averageTime;
	}

	/** 
	 * This method is to set the averageTime
	 */
	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}

	/** 
	 * This method is to get the sharedCount
	 */
	public int getSharedCount() {
		return sharedCount;
	}

	/** 
	 * This method is to set the sharedCount
	 */
	public void setSharedCount(int sharedCount) {
		this.sharedCount = sharedCount;
	}

	/** 
	 * This method is to get the numOfPages
	 */
	public String getNumOfPages() {
		return numOfPages;
	}

	/** 
	 * This method is to set the numOfPages
	 */
	public void setNumOfPages(String numOfPages) {
		this.numOfPages = numOfPages;
	}

	/** 
	 * This method is to get the durationInSec
	 */
	public String getDurationInSec() {
		return durationInSec;
	}

	/** 
	 * This method is to set the durationInSec
	 */
	public void setDurationInSec(String durationInSec) {
		this.durationInSec = durationInSec;
	}

	/** 
	 * This method is to get the license
	 */
	public LicenseDo getLicense() {
		return license;
	}

	/** 
	 * This method is to set the license
	 */
	public void setLicense(LicenseDo license) {
		this.license = license;
	}

	/** 
	 * This method is to get the votesUp
	 */
	public Integer getVotesUp() {
		return votesUp;
	}

	/** 
	 * This method is to set the votesUp
	 */
	public void setVotesUp(Integer votesUp) {
		this.votesUp = votesUp;
	}

	/** 
	 * This method is to get the votesDown
	 */
	public Integer getVotesDown() {
		return votesDown;
	}

	/** 
	 * This method is to set the votesDown
	 */
	public void setVotesDown(Integer votesDown) {
		this.votesDown = votesDown;
	}

	/** 
	 * This method is to get the tagSet
	 */
	public Set<TagDo> getTagSet() {
		return tagSet;
	}

	/** 
	 * This method is to set the tagSet
	 */
	public void setTagSet(Set<TagDo> tagSet) {
		this.tagSet = tagSet;
	}

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
	 * This method is to get the resourceSource
	 */
	public ResourceSourceDo getResourceSource() {
		return resourceSource;
	}

	/** 
	 * This method is to set the resourceSource
	 */
	public void setResourceSource(ResourceSourceDo resourceSource) {
		this.resourceSource = resourceSource;
	}

	/** 
	 * This method is to get the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}

	/** 
	 * This method is to set the questionType
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/** 
	 * This method is to get the noOfResources
	 */
	public int getNoOfResources() {
		return noOfResources;
	}

	/** 
	 * This method is to set the noOfResources
	 */
	public void setNoOfResources(int noOfResources) {
		this.noOfResources = noOfResources;
	}



}
