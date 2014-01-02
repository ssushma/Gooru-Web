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
package org.ednovo.gooru.shared.model.library;

import java.io.Serializable;
import java.util.ArrayList;

import org.ednovo.gooru.shared.model.content.CollectionMetaInfoDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @fileName : ConceptDo.java
 *
 * @description : This class is used as data object.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@JsonInclude(Include.NON_NULL)
public class ConceptDo implements Serializable {
	
	private static final long serialVersionUID = 2411080367742513414L;
	private String goals;
	private String title;
	private String gooruOid;
	private ArrayList<LibraryCollectionItemDo> collectionItems;
	private LibraryUserDo user;
	private ThumbnailDo thumbnails;
	private CollectionMetaInfoDo metaInfo;
	/** 
	 * This method is to get goals
	 */
	public String getGoals() {
		return goals;
	}
	/** 
	 * This method is to set goals
	 */
	public void setGoals(String goals) {
		this.goals = goals;
	}
	/** 
	 * This method is to get title
	 */
	public String getTitle() {
		return title;
	}
	/** 
	 * This method is to set title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/** 
	 * This method is to get gooruOid
	 */
	public String getGooruOid() {
		return gooruOid;
	}
	/** 
	 * This method is to set gooruOid.
	 */
	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
	}
	/** 
	 * This method is to get the collectionItems
	 */
	public ArrayList<LibraryCollectionItemDo> getCollectionItems() {
		return collectionItems;
	}
	/** 
	 * This method is to set the collectionItems
	 */
	public void setCollectionItems(ArrayList<LibraryCollectionItemDo> collectionItems) {
		this.collectionItems = collectionItems;
	}
	/** 
	 * This method is to get the user
	 */
	public LibraryUserDo getUser() {
		return user;
	}
	/** 
	 * This method is to set the user
	 */
	public void setUser(LibraryUserDo user) {
		this.user = user;
	}
	/** 
	 * This method is to get the thumbnails
	 */
	public ThumbnailDo getThumbnails() {
		return thumbnails;
	}
	/** 
	 * This method is to set the thumbnails
	 */
	public void setThumbnails(ThumbnailDo thumbnails) {
		this.thumbnails = thumbnails;
	}
	/** 
	 * This method is to get the metaInfo
	 */
	public CollectionMetaInfoDo getMetaInfo() {
		return metaInfo;
	}
	/** 
	 * This method is to set the metaInfo
	 */
	public void setMetaInfo(CollectionMetaInfoDo metaInfo) {
		this.metaInfo = metaInfo;
	}	
}
