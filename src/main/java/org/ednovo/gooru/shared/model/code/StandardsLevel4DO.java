package org.ednovo.gooru.shared.model.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StandardsLevel4DO implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private String label;
	private Integer parentId;
	private Integer codeId;
	private String code;
	
	public StandardsLevel4DO(){}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
