package org.ednovo.gooru.shared.model.folder;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FolderListDo implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<FolderDo> searchResult;
	private Integer count;
	
	public FolderListDo() {}

	/** 
	 * This method is to get the searchResult
	 */
	public List<FolderDo> getSearchResult() {
		return searchResult;
	}

	/** 
	 * This method is to set the searchResult
	 */
	public void setSearchResult(List<FolderDo> searchResult) {
		this.searchResult = searchResult;
	}

	/** 
	 * This method is to get the count
	 */
	public Integer getCount() {
		return count;
	}

	/** 
	 * This method is to set the count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}