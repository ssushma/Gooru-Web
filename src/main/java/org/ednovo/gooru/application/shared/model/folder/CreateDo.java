package org.ednovo.gooru.application.shared.model.folder;

import java.io.Serializable;
import java.util.List;

import org.ednovo.gooru.application.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CreateDo implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String ideas;
	private String description;
	private String questions;
	private String collectionType;
	private List<Integer> taxonomyCourseIds;
	private List<Integer> audienceIds;
	private List<Integer> domainIds;
	private List<Integer> standardIds;
	private String url;
	private String goals;
	private String sharing;
	private String isLoginRequired;
	private String mediaFilename;
	private ThumbnailDo thumbnails;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIdeas() {
		return ideas;
	}
	public void setIdeas(String ideas) {
		this.ideas = ideas;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public List<Integer> getTaxonomyCourseIds() {
		return taxonomyCourseIds;
	}
	public void setTaxonomyCourseIds(List<Integer> taxonomyCourseIds) {
		this.taxonomyCourseIds = taxonomyCourseIds;
	}
	public List<Integer> getAudienceIds() {
		return audienceIds;
	}
	public void setAudienceIds(List<Integer> audienceIds) {
		this.audienceIds = audienceIds;
	}
	public List<Integer> getDomainIds() {
		return domainIds;
	}
	public void setDomainIds(List<Integer> domainIds) {
		this.domainIds = domainIds;
	}
	public List<Integer> getStandardIds() {
		return standardIds;
	}
	public void setStandardIds(List<Integer> standardIds) {
		this.standardIds = standardIds;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getSharing() {
		return sharing;
	}
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
	public String getIsLoginRequired() {
		return isLoginRequired;
	}
	public void setIsLoginRequired(String isLoginRequired) {
		this.isLoginRequired = isLoginRequired;
	}
	public String getMediaFilename() {
		return mediaFilename;
	}
	public void setMediaFilename(String mediaFilename) {
		this.mediaFilename = mediaFilename;
	}
	public ThumbnailDo getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(ThumbnailDo thumbnails) {
		this.thumbnails = thumbnails;
	}
	
	
}
