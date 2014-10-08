package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CollectionProgressDataDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	private String title;
	private int status;
	private String description;
	private int itemSequence;
	private String type;
	private int apiStatusCode;
	private ArrayList<UserDataDo> userData;
	private ArrayList<MetaDataDo> metaData;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(int itemSequence) {
		this.itemSequence = itemSequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getApiStatusCode() {
		return apiStatusCode;
	}
	public void setApiStatusCode(int apiStatusCode) {
		this.apiStatusCode = apiStatusCode;
	}
	public ArrayList<UserDataDo> getUserData() {
		return userData;
	}
	public void setUserData(ArrayList<UserDataDo> userData) {
		this.userData = userData;
	}
	public ArrayList<MetaDataDo> getMetaData() {
		return metaData;
	}
	public void setMetaData(ArrayList<MetaDataDo> metaData) {
		this.metaData = metaData;
	}
	
}
