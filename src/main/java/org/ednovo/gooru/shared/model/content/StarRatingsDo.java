package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StarRatingsDo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String assocGooruOid;
	private String deleteReactionGooruOid=null;
	private Integer score;
	
	public StarRatingsDo(){}
	
	/**
	 * @return the assocGooruOid
	 */
	public String getAssocGooruOid() {
		return assocGooruOid;
	}
	/**
	 * @param assocGooruOid the assocGooruOid to set
	 */
	public void setAssocGooruOid(String assocGooruOid) {
		this.assocGooruOid = assocGooruOid;
	}
	/**
	 * @return the deleteReactionGooruOid
	 */
	public String getDeleteReactionGooruOid() {
		return deleteReactionGooruOid;
	}
	/**
	 * @param deleteReactionGooruOid the deleteReactionGooruOid to set
	 */
	public void setDeleteReactionGooruOid(String deleteReactionGooruOid) {
		this.deleteReactionGooruOid = deleteReactionGooruOid;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}


}
