package org.ednovo.gooru.server.request;

import java.io.Serializable;

import org.restlet.ext.json.JsonRepresentation;

/**
* @fileName : JsonResponseRepresentation.java
*
* @description : This class used for to set and get status code.
* 
* @version : 1.0
*
* @date:  December, 2013.
*
* @Author: Gooru Team.
* 
* @Reviewer: Gooru Team.
*/
public class JsonResponseRepresentation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer statusCode=200;
	
	private String errorMessage;
	
	private JsonRepresentation jsonRepresentation;

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the jsonRepresentation
	 */
	public JsonRepresentation getJsonRepresentation() {
		return jsonRepresentation;
	}
	/**
	 * @param jsonRepresentation the jsonRepresentation to set
	 */
	public void setJsonRepresentation(JsonRepresentation jsonRepresentation) {
		this.jsonRepresentation = jsonRepresentation;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
