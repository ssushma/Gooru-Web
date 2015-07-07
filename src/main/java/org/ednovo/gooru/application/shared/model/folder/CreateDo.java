package org.ednovo.gooru.application.shared.model.folder;

import java.io.Serializable;
import java.util.List;

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
	private List<Integer> taxonomyCourseIds;
	private List<Integer> audienceIds;
	private List<Integer> domainIds;
	private List<Integer> standardIds;
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
	
}
