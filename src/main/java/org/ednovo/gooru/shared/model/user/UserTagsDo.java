package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserTagsDo implements Serializable{
	private static final long serialVersionUID = 6752607500919973286L;
	private String tagGooruOid;
	private String count;
	private String label;
	private int totalHitCount;
	
	public String getTagGooruOid() {
		return tagGooruOid;
	}

	public void setTagGooruOid(String tagGooruOid) {
		this.tagGooruOid = tagGooruOid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getTotalHitCount() {
		return totalHitCount;
	}

	public void setTotalHitCount(int totalHitCount) {
		this.totalHitCount = totalHitCount;
	}

	public UserTagsDo(){}
	
	
}
