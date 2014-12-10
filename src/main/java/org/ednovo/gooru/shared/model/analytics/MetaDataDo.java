package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MetaDataDo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String collection_gooru_oid;
	private String result;
	private String question_type;
	private int sequence;
	private long answer_id;
	private String type_name;
	private int is_correct;
	private long question_id;
	private String endTime;
	private String question_gooru_oid;
	private String answer_text;
	public String getCollection_gooru_oid() {
		return collection_gooru_oid;
	}
	public void setCollection_gooru_oid(String collection_gooru_oid) {
		this.collection_gooru_oid = collection_gooru_oid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(long answer_id) {
		this.answer_id = answer_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getIs_correct() {
		return is_correct;
	}
	public void setIs_correct(int is_correct) {
		this.is_correct = is_correct;
	}
	public long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getQuestion_gooru_oid() {
		return question_gooru_oid;
	}
	public void setQuestion_gooru_oid(String question_gooru_oid) {
		this.question_gooru_oid = question_gooru_oid;
	}
	public String getAnswer_text() {
		return answer_text;
	}
	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}
}
