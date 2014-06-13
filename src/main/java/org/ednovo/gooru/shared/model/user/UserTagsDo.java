package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserTagsDo implements Serializable{
	private static final long serialVersionUID = 6752607500919973286L;
	private String tagGooruOid;
	private int count;
	private String label;
	
	public String getTagGooruOid() {
		return tagGooruOid;
	}

	public void setTagGooruOid(String tagGooruOid) {
		this.tagGooruOid = tagGooruOid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public UserTagsDo(){}
	
	
}
