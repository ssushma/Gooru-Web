package org.ednovo.gooru.application.shared.model.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class IsFollowDo implements Serializable {

	private static final long serialVersionUID = 5884693288921720922L;

	private String isFollow;
	public IsFollowDo(){}
	public String getIsFollow() {
		return isFollow;
	}
	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}
	
	
}
