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
package org.ednovo.gooru.shared.model.search;

import java.io.Serializable;
/**
 * 
 * @fileName : CollectionItemSearchResultDo.java
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
public class CollectionItemSearchResultDo extends ResourceSearchResultDo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String collectionItemId;
	private Integer itemSequence;
	private String itemType;
	private String narration;
	/** 
	 * This method is to get the collectionItemId
	 */
	public String getCollectionItemId() {
		return collectionItemId;
	}
	/** 
	 * This method is to set the collectionItemId
	 */
	public void setCollectionItemId(String collectionItemId) {
		this.collectionItemId = collectionItemId;
	}
	/** 
	 * This method is to get the itemSequence
	 */
	public Integer getItemSequence() {
		return itemSequence;
	}
	/** 
	 * This method is to set the itemSequence
	 */
	public void setItemSequence(Integer itemSequence) {
		this.itemSequence = itemSequence;
	}
	/** 
	 * This method is to get the itemType
	 */
	public String getItemType() {
		return itemType;
	}
	/** 
	 * This method is to set the itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/** 
	 * This method is to get the narration
	 */
	public String getNarration() {
		return narration;
	}
	/** 
	 * This method is to set the narration
	 */
	public void setNarration(String narration) {
		this.narration = narration;
	}	
}
