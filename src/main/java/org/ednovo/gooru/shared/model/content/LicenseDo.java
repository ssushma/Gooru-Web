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
 * @fileName : LicenseDo.java
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
public class LicenseDo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9160398651819403546L;
	private String name;
	private String code;
	private String icon;
	private String definition;
	private String url;
	private String tag;
	/** 
	 * This method is to get the name
	 */
	public String getName() {
		return name;
	}
	/** 
	 * This method is to set the name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * This method is to get the icon
	 */
	public String getIcon() {
		return icon;
	}
	/** 
	 * This method is to set the icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/** 
	 * This method is to get the definition
	 */
	public String getDefinition() {
		return definition;
	}
	/** 
	 * This method is to set the definition
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	/** 
	 * This method is to get the url
	 */
	public String getUrl() {
		return url;
	}
	/** 
	 * This method is to set the url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/** 
	 * This method is to get the tag
	 */
	public String getTag() {
		return tag;
	}
	/** 
	 * This method is to set the tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
}
