/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.shared.model.content;

import java.io.Serializable;

import org.ednovo.gooru.shared.model.user.UserDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResourceCollDo extends ResourceDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3298220423508874309L;

	private String collectionType;
	private ThumbnailDo thumbnails;
	private String title;
	private String description;
	private String gooruOid;
	private UserDo user;
	private String grade;
	
	
	public ResourceCollDo(){
		
	}


	public String getCollectionType() {
		return collectionType;
	}


	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}


	public ThumbnailDo getThumbnails() {
		return thumbnails;
	}


	public void setThumbnails(ThumbnailDo thumbnails) {
		this.thumbnails = thumbnails;
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


	public String getGooruOid() {
		return gooruOid;
	}


	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
	}


	public UserDo getUser() {
		return user;
	}


	public void setUser(UserDo user) {
		this.user = user;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
	

}
