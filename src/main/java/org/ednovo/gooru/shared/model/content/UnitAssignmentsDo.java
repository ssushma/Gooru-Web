package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;
import java.util.ArrayList;

import org.ednovo.gooru.shared.model.user.UserDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UnitAssignmentsDo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public UnitAssignmentsDo(){}
	
	private Integer totalHitCount;
	
	private String title;
	
	
	private ArrayList<ClasspageItemDo> searchResults;

	/**
	 * @return the totalHitCount
	 */
	public Integer getTotalHitCount() {
		return totalHitCount;
	}


	/**
	 * @param totalHitCount the totalHitCount to set
	 */
	public void setTotalHitCount(Integer totalHitCount) {
		this.totalHitCount = totalHitCount;
	}


	/**
	 * @return the searchResults
	 */
	public ArrayList<ClasspageItemDo> getSearchResults() {
		return searchResults;
	}


	/**
	 * @param searchResults the searchResults to set
	 */
	public void setSearchResults(ArrayList<ClasspageItemDo> searchResults) {
		this.searchResults = searchResults;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
