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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : CollectionItemsListDo.java
 *
 * @description :  This class is used as data object.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@JsonInclude(Include.NON_NULL)
public class CollectionItemsListDo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058428216095080308L;
	private String myCollectionTitle;
	private String myCollectionGid;
	private String myCollectionType;
	/** 
	 * This method is to get the myCollectionTitle
	 */
	public String getMyCollectionTitle() {
		return myCollectionTitle;
	}
	/** 
	 * This method is to set the myCollectionTitle
	 */
	public void setMyCollectionTitle(String myCollectionTitle) {
		this.myCollectionTitle = myCollectionTitle;
	}
	/** 
	 * This method is to get the myCollectionGid
	 */
	public String getMyCollectionGid() {
		return myCollectionGid;
	}
	/** 
	 * This method is to set the myCollectionGid
	 */
	public void setMyCollectionGid(String myCollectionGid) {
		this.myCollectionGid = myCollectionGid;
	}
	/** 
	 * This method is to get the myCollectionType
	 */
	public String getMyCollectionType() {
		return myCollectionType;
	}
	/** 
	 * This method is to set the myCollectionType
	 */
	public void setMyCollectionType(String myCollectionType) {
		this.myCollectionType = myCollectionType;
	}
	
}
