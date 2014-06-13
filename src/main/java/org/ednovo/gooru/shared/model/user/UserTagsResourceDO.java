package org.ednovo.gooru.shared.model.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserTagsResourceDO implements Serializable{
	private static final long serialVersionUID = 6752607500919973286L;
	public UserTagsResourceDO(){}
}
