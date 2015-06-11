package org.ednovo.gooru.application.shared.model.player;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CommentsListDo implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<CommentsDo> searchResults;
	private int totalHitCount;
	public CommentsListDo(){}
	public ArrayList<CommentsDo> getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(ArrayList<CommentsDo> searchResults) {
		this.searchResults = searchResults;
	}
	public int getTotalHitCount() {
		return totalHitCount;
	}
	public void setTotalHitCount(int totalHitCount) {
		this.totalHitCount = totalHitCount;
	}
	
	


}
