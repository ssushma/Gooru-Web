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

import java.util.ArrayList;
import java.util.TreeSet;

import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : ResourceDo.java
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
public class ResourceDo extends ContentDo { 
    private static final long serialVersionUID = 3421728485329612613L;
    private String assetURI;
    private String title;
    private String description;
    private String folder;
    private String category;
    private String explanation;
    private ThumbnailDo thumbnails;
    private ResourceTypeDo resourceType;
    private ResourceSourceDo resourceSource;
	private String views;
    private Integer votesUp;
    private LicenseDo license;
    private String grade;
    private String mediaType;
    
 
    private TreeSet<QuestionAnswerDo> answers;
    
    private ArrayList<AssetsDo> assets;
    
    private TrackActivityDo trackActivity;

	private TreeSet<QuestionHintsDo> hints;
    private Integer type;
    private String label;        //Some api's give title in label key
    private String nativeurl;    //Some api's give url in nativeUrl key
    private String id;
    private String url;
    private String goals;
    
    private Boolean hasFrameBreaker;
    
    private String questionText;
    
    private Integer userRating;
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



	/** 
	 * This method is to get the answers
	 */
	public TreeSet<QuestionAnswerDo> getAnswers() {
		return answers;
	}



	/** 
	 * This method is to set the answers
	 */
	public void setAnswers(TreeSet<QuestionAnswerDo> answers) {
		this.answers = answers;
	}



	/** 
	 * This method is to get the assets
	 */
	public ArrayList<AssetsDo> getAssets() {
		return assets;
	}



	/** 
	 * This method is to set the assets
	 */
	public void setAssets(ArrayList<AssetsDo> assets) {
		this.assets = assets;
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
	 * This method is to get the hints
	 */
	public TreeSet<QuestionHintsDo> getHints() {
		return hints;
	}



	/** 
	 * This method is to set the hints
	 */
	public void setHints(TreeSet<QuestionHintsDo> hints) {
		this.hints = hints;
	}



	/** 
	 * This method is to get the type
	 */
	public Integer getType() {
		return type;
	}



	/** 
	 * This method is to set the type
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * This method is to get the hasFrameBreaker
	 */
	public Boolean getHasFrameBreaker() {
		return hasFrameBreaker;
	}



	/** 
	 * This method is to set the hasFrameBreaker
	 */
	public void setHasFrameBreaker(Boolean hasFrameBreaker) {
		this.hasFrameBreaker = hasFrameBreaker;
	}



	/** 
	 * This method is to get the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}



	/** 
	 * This method is to set the questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}



	/** 
	 * This method is to get the userRating
	 */
	public Integer getUserRating() {
		return userRating;
	}



	/** 
	 * This method is to set the userRating
	 */
	public void setUserRating(Integer userRating) {
		this.userRating = userRating;
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
