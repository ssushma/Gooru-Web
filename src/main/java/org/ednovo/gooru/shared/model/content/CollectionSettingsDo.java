package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class CollectionSettingsDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String comment;

	
	public CollectionSettingsDo(){
		
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	

	
	
	
	
}
