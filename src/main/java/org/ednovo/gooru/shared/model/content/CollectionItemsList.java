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
/**
 * 
 * @fileName : CollectionItemsList.java
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
public class CollectionItemsList implements Serializable {
	
	/**
	 * This file
	 */
	
	private String collectionTitle;
	private String collectionId;
	private String collectionType;
	private Integer collectionItemsListSize;
	
	
	private static final long serialVersionUID = 1L;


	/** 
	 * This method is to get the collectionTitle
	 */
	public String getCollectionTitle() {
		return collectionTitle;
	}


	/** 
	 * This method is to set the collectionTitle
	 */
	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}


	/** 
	 * This method is to get the collectionId
	 */
	public String getCollectionId() {
		return collectionId;
	}


	/** 
	 * This method is to set the collectionId
	 */
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}


	/** 
	 * This method is to get the collectionType
	 */
	public String getCollectionType() {
		return collectionType;
	}


	/** 
	 * This method is to set the collectionType
	 */
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}


	/** 
	 * This method is to get the collectionItemsListSize
	 */
	public Integer getCollectionItemsListSize() {
		return collectionItemsListSize;
	}


	/** 
	 * This method is to set the collectionItemsListSize
	 */
	public void setCollectionItemsListSize(Integer collectionItemsListSize) {
		this.collectionItemsListSize = collectionItemsListSize;
	}
}
