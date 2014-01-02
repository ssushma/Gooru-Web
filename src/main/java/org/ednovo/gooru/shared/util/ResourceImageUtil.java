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
package org.ednovo.gooru.shared.util;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
/**
* @fileName : ResourceImageUtil.java
*
* @description : This class is used to get the youtube images.
*
* @version : 1.0
*
* @date: 30-Dec-2013
*
* @Author Gooru Team
*
* @Reviewer: Gooru Team
*/
public class ResourceImageUtil {
	public static String protocol="http";
	/**
	 * This method is used to get the youtube id based on the passed youtube url.
	 */
	public static String getYoutubeVideoId(String url) { 
		String pattern = "youtu(?:\\.be|be\\.com)/(?:.*v(?:/|=)|(?:.*/)?)([a-zA-Z0-9-_]+)";
		String videoId = null; 
	    try {
	    	RegExp reg = RegExp.compile(pattern, "gi");
	    	MatchResult res = reg.exec(url);
	    	videoId = res.getGroup(1);
	    } catch (Exception e) {
	    	
		}
		return videoId;
	}
	/**
	 * @function youtubeImageLink 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method will return the youtube image url.
	 * 
	 * @parm(s) : @param videoId
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static String  youtubeImageLink(String videoId) {
		return protocol+"://img.youtube.com/vi/"+videoId+"/1.jpg";
	}
	/**
	 * @function youtubeImageLink 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method will return the youtube image url.
	 * 
	 * @parm(s) : @param videoId
	 * @parm(s) : @param protocol
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public static String youtubeImageLink(String videoId, String protocol) {
		return protocol+"://img.youtube.com/vi/"+videoId+"/1.jpg";
	}
}
