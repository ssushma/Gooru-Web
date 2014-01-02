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
 * @fileName : StandardFo.java
 *
 * @description : This class is used as data object.
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
public class StandardFo implements Serializable {
	private static final long serialVersionUID = 161874649372844127L;
	private Integer codeId;
	private String code;
	private String description;
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
	 * This method is to get the code
	 */
	public String getCode() {
		return code;
	}
	/** 
	 * This method is to set the code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/** 
	 * This method is to get the description
	 */
	public String getDescription() {
		return description;
	}
	/** 
	 * This method is to set the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	
}
