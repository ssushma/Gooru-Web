package org.ednovo.gooru.shared.model.drive;

import java.io.Serializable;
import java.util.List;

public class DriveDo implements Serializable {
	
	String title;
	String description;
	String createdDate;
	String id;
	String alternateLink;
	String kind;
	String mimeType;
	String modifiedByMeDate;
	String modifiedDate;
	String parentId;
	String role;
	String type;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlternateLink() {
		return alternateLink;
	}
	public void setAlternateLink(String alternateLink) {
		this.alternateLink = alternateLink;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getModifiedByMeDate() {
		return modifiedByMeDate;
	}
	public void setModifiedByMeDate(String modifiedByMeDate) {
		this.modifiedByMeDate = modifiedByMeDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
