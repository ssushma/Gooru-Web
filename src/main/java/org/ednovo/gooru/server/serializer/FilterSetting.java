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
/**
 * 
 */
package org.ednovo.gooru.server.serializer;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @fileName : FilterSetting.java
 *
 * @description :  Acts as a container for ObjectWriter filter provider.
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
public final class FilterSetting implements Cloneable {

	private Map<String, String[]> includes;

	private Map<String, String[]> excludes;
	/**
	 * Class constructor.
	 */
	private FilterSetting() {
		includes = new HashMap<String, String[]>();
		excludes = new HashMap<String, String[]>();
	}
	/**
	 * @function include 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method will include the filters.
	 * 
	 * @parm(s) : @param filterName
	 * @parm(s) : @param properties
	 * @parm(s) : @return
	 * 
	 * @return : FilterSetting
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public FilterSetting include(String filterName, String[] properties) {
		getIncludes().put(filterName, properties);
		return this;
	}
	/**
	 * @function exclude 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method will exclude the filters.
	 * 
	 * 
	 * @parm(s) : @param filterName
	 * @parm(s) : @param properties
	 * @parm(s) : @return
	 * 
	 * @return : FilterSetting
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public FilterSetting exclude(String filterName, String[] properties) {
		getExcludes().put(filterName, properties);
		return this;
	}
	/**
	 * 
	 * @function getIncludes 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will return the all included filters.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Map<String,String[]>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Map<String, String[]> getIncludes() {
		return includes;
	}
	/**
	 * @function setIncludes 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will set the include filter.
	 * 
	 * 
	 * @parm(s) : @param includes
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setIncludes(HashMap<String, String[]> includes) {
		this.includes = includes;
	}
	/**
	 * 
	 * @function getExcludes 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method will return the all excluded filters.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Map<String,String[]>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Map<String, String[]> getExcludes() {
		return excludes;
	}
	/**
	 * @function setExcludes 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will set the excluded filter.
	 * 
	 * @parm(s) : @param excludes
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setExcludes(HashMap<String, String[]> excludes) {
		this.excludes = excludes;
	}
	/**
	 * @function copy 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will return the copy of the filter settings.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : FilterSetting
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public FilterSetting copy() {
		try {
			return (FilterSetting) super.clone();
		} catch (CloneNotSupportedException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	/**
	 * @function newInstance 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : It will create the new instance of the filter settings.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : FilterSetting
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static FilterSetting newInstance() {
		return new FilterSetting();
	}

}
