package org.ednovo.gooru.application.shared.model.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.application.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class DomainStandardsDo implements Serializable {

	private static final long serialVersionUID = 2411080367742513414L;
	private Integer codeId;
	private String label;
	private String code;
	private Integer typeId;
	private List<SubDomainStandardsDo> node;

	public DomainStandardsDo(){}

	public Integer getCodeId() {
		return codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<SubDomainStandardsDo> getNode() {
		return node;
	}

	public void setNode(List<SubDomainStandardsDo> node) {
		this.node = node;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}




}