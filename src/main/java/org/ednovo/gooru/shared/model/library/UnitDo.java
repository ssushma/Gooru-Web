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

import org.ednovo.gooru.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @fileName : UnitDo.java
 *
 * @description :  This class is used as data object.
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
public class UnitDo implements Serializable {
	
	private static final long serialVersionUID = 2411080367742513414L;
	private Integer codeId;
	private String label;
	private ThumbnailDo thumbnails;
	private ArrayList<TopicDo> topic;
	
	public UnitDo(){}

	/** 
	 * This method is to get the codeId
	 */
	public Integer getCodeId() {
		return codeId;
	}

	/** 
	 * This method is to set the codeId
	 */
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	/** 
	 * This method is to get the label
	 */
	public String getLabel() {
		return label;
	}

	/** 
	 * This method is to set the label
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * This method is to get the topic
	 */
	public ArrayList<TopicDo> getTopic() {
		return topic;
	}

	/** 
	 * This method is to set the topic
	 */
	public void setTopic(ArrayList<TopicDo> topic) {
		this.topic = topic;
	}
}
