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
package org.ednovo.gooru.shared.util;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @fileName : StringUtil.java
 *
 * @description : This class contains all the string operations.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class StringUtil {
	
	 public static final int INDEX_NOT_FOUND = -1;
	 
	 public static final String EMPTY = "";
	 /**
	  * This method will check the given string is valid string or not.
	  */
	public static boolean hasValidString(String string) {
		return string != null && string.length() > 0 && !string.equalsIgnoreCase("null");
	}
	/**
	 * This method will the return the valid string.
	 */
	public static String getValidString(String string, String defaultString) {
		return hasValidString(string) ? string : defaultString;
	}
	/**
	 * This method will return the valid string with prefix.
	 */
	public static String getValidStringWithPrefix(String string, String defaultString, String prefix) {
		return hasValidString(string) ? prefix + string : prefix + defaultString;
	}
	/**
	 * This method will return the valid string with the suffix.
	 */
	public static String getValidStringWithSuffix(String string, String defaultString, String suffix) {
		return hasValidString(string) ? string + suffix : defaultString + suffix;
	}
	/**
	 * This method will truncate the text based on the passed max character length.
	 */
	public static String truncateText(String text, int maxCharLength) {
		return truncateText(text, maxCharLength, "...");
	}
	/**
	 * This will truncate the text.
	 */
	public static String truncateText(String text, int maxCharLength, String suffix) {	
		 if (text != null && text.trim().length() > maxCharLength && !text.equalsIgnoreCase("multiple sources"))
		 {
			text = text.trim().substring(0, maxCharLength) + suffix;
			}
		return text != null ? text : "";

	}
	/**
	 * This method will check is passed string is empty or not.
	 */
	public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
	/**
	 * This will convert the string to time.
	 */
	public static String stringToTime(String data) {
		if (StringUtil.hasValidString(data) && data.length() > 0 && !data.equalsIgnoreCase("0")) {
			long totalSecs = Long.valueOf(data);
			long hours = (totalSecs / 3600);
			long mins = ((totalSecs % 3600) / 60);
			long secs = (totalSecs % 60);
			return (hours > 0 ? hours + ":" : "") + (mins > 0 ? (mins<10 ? "0" : "")+mins + ":" : "00:") +(secs<10 ? "0" : "")+ secs + " min";
		} else {
			return null;
		}
	}
	/**
	 * This will return the question type.
	 */
	public static String getQuestionType(String type){
		//MULTIPLE_CHOICE("MC", 1), SHORT_ANSWER("SA", 2), TRUE_OR_FALSE("T/F", 3), FILL_IN_BLANKS("FIB", 4);
		if(type.equalsIgnoreCase("MC")){
			return "Multiple Choice";
		}else if(type.equalsIgnoreCase("SA")){
			return "Short Answer";
		}else if(type.equalsIgnoreCase("T/F")){
			return "True Or False";
		}else if(type.equalsIgnoreCase("FIB")){
			return "Fill In Blanks";
		}
		return "";
	}
	/**
	 * This will generate the message.
	 */
	public static String generateMessage(String text, String... params) {
		if (params != null) {
			for (int index = 0; index < params.length; index++) {
				text = text.replace("{" + index + "}", params[index]);
			}
		}
		return  text;
	}
	/**
	 * This will generate the message.
	 */
	public static String generateMessage(String text, Map<String, String> params) {
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				text = text + "%26" + entry.getKey() + "=" + entry.getValue();
			}
		}
		return  text;
	}
	/**
	 * This will give the substring before the last position.
	 */
	public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }
	/**
	 * This will return the substring after the last.
	 */
	public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }
	/**
	 * This method will return the thumbnail name.
	 */
	public static String formThumbnailName(String thumbnailName, String thumbnailSuffix){
		String  thumbnailFilename = null;
    	if (thumbnailName != null) {
			String  fileExtension =  StringUtil.substringAfterLast(thumbnailName, ".");
			if (fileExtension != null) { 
				thumbnailFilename = StringUtil.substringBeforeLast(thumbnailName, "." + fileExtension) + thumbnailSuffix + fileExtension;
			}
		}
		return thumbnailFilename;
	}
	/**
	 * 
	 * @function splitQuery 
	 * 
	 * @created_date : Dec 5, 2013
	 * 
	 * @description: This method will give all the query parameters in the passed url.
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @return
	 * 
	 * @return : Map<String,String>
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public static Map<String, String> splitQuery(String url)  {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String[] query = url.split("#");
	    String[] pairs = query[1].split("&");
	    for (String pair : pairs) {
	    	if (pair.indexOf("=")>0){
	    		int idx = pair.indexOf("=");
	    		query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
	    	}
	    }
	    return query_pairs;
	}
	
//	public static String milliSecondsToDateString(String milliseconds){
//
//		long dateMilliseconds = Long.parseLong(milliseconds);
//
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//		Date resultdate = new Date(dateMilliseconds);
//		
//		return sdf.format(resultdate);
//	}
	
}
