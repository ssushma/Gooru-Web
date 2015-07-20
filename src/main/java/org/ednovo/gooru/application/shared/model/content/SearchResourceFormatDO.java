package org.ednovo.gooru.application.shared.model.content;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class SearchResourceFormatDO implements Serializable {
	
	private static final long serialVersionUID = -6528540769336671670L;
	
	private String value;
	
	public SearchResourceFormatDO(){}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
