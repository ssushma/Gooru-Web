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
 *
 */
package org.ednovo.gooru.shared.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.resource.style.PlayerStyleBundle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.dom.client.Element;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.gwt.crypto.client.TripleDesCipher;


/**
 * @author Search Team
 * 
 */
public class StringUtil implements ClientConstants {



	
	 public static final int INDEX_NOT_FOUND = -1;
	 
	 public static final String EMPTY = "";
	 
	 public static boolean IPAD_MESSAGE_Close_Click = false;
	 
	 private static final String ASSESSMENT_URL = "assessment/url";
		
     private static final String ASSESSMENT = "assessment";
     
     private static final String DEFULT_COLLECTION = "images/default-collection-image-160x120.png";
 	
 	 private static final String DEFULT_ASSESSMENT = "images/default-assessment-image -160x120.png";

 	 public static Map<String, String> categoryMap =null;
	
	private final static byte[] key = CRYPTO_KEY.getBytes();
	

	static{
		addAllCategories();
	}


	public static boolean hasValidString(String string) {
		return string != null && string.length() > 0 && !string.equalsIgnoreCase("null");
	}

	public static String getValidString(String string, String defaultString) {
		return hasValidString(string) ? string : defaultString;
	}

	public static String getValidStringWithPrefix(String string, String defaultString, String prefix) {
		return hasValidString(string) ? prefix + string : prefix + defaultString;
	}

	public static String getValidStringWithSuffix(String string, String defaultString, String suffix) {
		return hasValidString(string) ? string + suffix : defaultString + suffix;
	}

	public static String truncateText(String text, int maxCharLength) {
		return truncateText(text, maxCharLength, "...");
	}

	public static String truncateText(String text, int maxCharLength, String suffix) {	
		if (text != null && text.trim().length() > maxCharLength && !text.equalsIgnoreCase("multiple sources"))
		{
			text = text.trim().substring(0, maxCharLength) + suffix;
		}
		return text != null ? text : "";

	}
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

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

	public static String generateMessage(String text, String... params) {
		if (params != null) {
			for (int index = 0; index < params.length; index++) {
				text = text.replace("{" + index + "}", params[index]);
			}
		}
		return  text;
	}

	public static String generateMessage(String text, Map<String, String> params) {
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				text = text + "%26" + entry.getKey() + "=" + entry.getValue();
			}
		}
		return  text;
	}

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
	 * @description
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @return
	 * 
	 * @return : Map<String,String>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static Map<String, String> splitQuery(String url)  {
		Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		try {
			if(url.contains("#")) {
				String[] query = url.split("#");
				if(query[1].contains("&")) {
					String[] pairs = query[1].split("&");
					for (String pair : pairs) {
						if (pair.indexOf("=")>0){
							int idx = pair.indexOf("=");
							query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
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

	public static String getRefinedQuestionText(String questionTxt) {
		questionTxt = questionTxt.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return questionTxt;
	}

	public static List<String> getUserTaxPreferences() {
		String taxonomyPrefStr = AppClientFactory.getLoggedInUser().getSettings().getTaxonomyPreferences();

		List<String> preferences = new ArrayList<String>();
		if(AppClientFactory.isAnonymous()) {
			preferences.add("CC");
			preferences.add("CA");
		} else {

		}
		return preferences;
	}

	public static boolean isPartnerUser(String userName) {
		boolean isPartner = false;
		if(AUTODESK.equalsIgnoreCase(userName) || LESSONOPOLOGY.equalsIgnoreCase(userName) || COMMONSENCEMEDIA.equalsIgnoreCase(userName) 
				|| FTE.equalsIgnoreCase(userName) || WSPWH.equalsIgnoreCase(userName) || LISANGC.equalsIgnoreCase(userName) || NGC.equalsIgnoreCase(userName)
				|| ONR.equalsIgnoreCase(userName) || PlaceTokens.FINCAPINC.equalsIgnoreCase(userName) || PlaceTokens.PSDPAL.equalsIgnoreCase(userName) 
				|| PlaceTokens.YOUTHVOICES.equalsIgnoreCase(userName) || PlaceTokens.GEOEDUCATION.equalsIgnoreCase(userName) || PlaceTokens.LPS.equalsIgnoreCase(userName) 
				|| PlaceTokens.CORE_LIBRARY.equalsIgnoreCase(userName) || PlaceTokens.ESYP.equalsIgnoreCase(userName) || PlaceTokens.CCST_Cal_TAC.equalsIgnoreCase(userName) || PlaceTokens.ASPIRE_EPACS.equalsIgnoreCase(userName) || PlaceTokens.TICAL.equalsIgnoreCase(userName)) {
			isPartner = true;
		}
		return isPartner;
	}

	public static String getPartnerName(String partnerName) {
		if(partnerName.equalsIgnoreCase("Autodesk")) {
			partnerName = "Autodesk®";
		} else if(partnerName.equalsIgnoreCase("Lessonopoly")) {
			partnerName = "SVEF's Lessonopoly";
		} else if(partnerName.equalsIgnoreCase("FTE")) {
			partnerName = "Foundation for Teaching Economics (FTE)";
		} else if(partnerName.equalsIgnoreCase("WSPWH")) {
			partnerName = "What So Proudly We Hail";
		} else if(partnerName.equalsIgnoreCase("NGC")) {
			partnerName = "New Global Citizens (NGC)";
		} else if(partnerName.equalsIgnoreCase("ONR")) {
			partnerName = "Office of Naval Research (ONR)";
		} else if(partnerName.equalsIgnoreCase(PlaceTokens.FINCAPINC)) {
			partnerName = "Next Gen Personal Finance";
		} else if(partnerName.equalsIgnoreCase(PlaceTokens.PSDPAL)) {
			partnerName = "Partners for Sustainable Development (PSD)";
		} else if(partnerName.equalsIgnoreCase(PlaceTokens.YOUTHVOICES)) {
			partnerName = "Youth Voices";
		} else if(partnerName.equalsIgnoreCase(PlaceTokens.GEOEDUCATION)) {
			partnerName = "National Geographic's Geo-Educator Community";
		}
		return partnerName;
	}

	public static Map<String,String> getFolderMetaData(FolderDo folderDo) {
		Map<String,String> folderMetaData = new HashMap<String,String>();
		if(folderDo.getIdeas()!=null) {
			folderMetaData.put("ideas", folderDo.getIdeas());
		}
		if(folderDo.getPerformanceTasks()!=null) {
			folderMetaData.put("performanceTasks", folderDo.getPerformanceTasks());
		}
		if(folderDo.getQuestions()!=null) {
			folderMetaData.put("questions", folderDo.getQuestions());
		}
		return folderMetaData;
	}

	public static String replaceSpecial(String originalString){
		String str = "";
		str = originalString.replaceAll("%", "%25");	
		str = str.replaceAll("\"", "%22").replaceAll("'", "%27");
		str = str.replaceAll("<", "%3C").replaceAll(">", "%3E");		
		return str;
	}

	public static String replaceQuotes(String originalString){
		String str = "";

		str = originalString.replaceAll("%22", "\"").replaceAll("%27", "'");

		return str;
	}
	public static native void consoleLog(String message) /*-{
		console.log(message );
	}-*/;

	public static native void clearCookes() /*-{
		$doc.cookie = "google-access-token=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
	}-*/;

	public static void clearCookies(String key, String path, String domain){
		Cookies.setCookie(key, "",  new Date(), "."+Window.Location.getHost(), path, false);
		Cookies.removeCookie(key, "/");
	}


	public static String getPublicLibraryName(String placeToken) {
		String libraryName = null;
		if(placeToken.equals(PlaceTokens.RUSD_LIBRARY)) {
			libraryName = "rusd";
		} else if(placeToken.equals(PlaceTokens.SAUSD_LIBRARY)) {
			libraryName = "sausd";
		} else {
			libraryName = "gooru";
		}
		return libraryName;
	}

	public static void setAttributes(TextBox txtBox, boolean isTrue){
		txtBox.getElement().setAttribute("spellcheck", isTrue+"");
	}
	public static void setAttributes(TextArea tatBox, boolean isTrue){
		tatBox.getElement().setAttribute("spellcheck", isTrue+"");
	}

	/**
	 * @function setAttributes 
	 * 
	 * @created_date : Jul 15, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param msgTxa
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	 */

	public static void setAttributes(RichTextArea rtatBox, boolean isTrue) {
		rtatBox.getElement().setAttribute("spellcheck", isTrue+"");
	}

	/**
	 * @function setAttributes 
	 * 
	 * @created_date : Jul 17, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param editSearchTxtBox
	 * @param isTrue
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	 */

	public static void setAttributes(AppSuggestBox editSearchTxtBox,
			boolean isTrue) {
		editSearchTxtBox.getElement().setAttribute("spellcheck", isTrue+"");
	}

	/**
	 * 
	 * @function setAttributes 
	 * 
	 * @created_date : Jul 26, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param object
	 * @param idValue
	 * @param altValue
	 * @param titleValue
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void setAttributes(Element object, String idValue, String altValue, String titleValue){
		object.setAttribute("id",idValue);
		if (!isEmpty(altValue) )
			object.setAttribute("alt",altValue);
		if (!isEmpty(titleValue) )
			object.setAttribute("title",titleValue);
	}

	/**
	 * Generalised method for converting object to toString (This will avoid NPE)
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString().trim();
	}

	/**
	 * A generic method to check for null
	 * @param e
	 * @return
	 */
	public static <T> boolean checkNull(T e){
		return e==null;
	}
	
	/**
	 * Adding all the categories with new category as a value.
	 * @return
	 */
	private static void addAllCategories() {
		categoryMap = new HashMap<String,String>();
		categoryMap.put(LESSON, TEXT);
		categoryMap.put(TEXTBOOK,TEXT); 
		categoryMap.put(HANDOUT, TEXT); 
		categoryMap.put(SLIDE, IMAGE);
		categoryMap.put(EXAM, WEBPAGE);
		categoryMap.put(WEBSITE,WEBPAGE);
		categoryMap.put(CHALLENGE, WEBPAGE); 
	}
	
	/**
	 * Returns the equivalent category.
	 * @param type
	 * @return
	 */
	public static String getEquivalentCategory(String type){
		return categoryMap.get(type)==null?type:categoryMap.get(type);
	}
	
	/**
	 * Encrypts the given string by using GWT crypto method.
	 * @param data {@link String}
	 * 
	 * @return encrypted {@link String}
	 */
	public static String getCryptoData(String data) {
		 String encrypted = null;
		try {
			TripleDesCipher cipher = new TripleDesCipher();
			cipher.setKey(key);
			encrypted = cipher.encrypt(data);
		} catch (Exception e) {
			AppClientFactory.printSevereLogger("Exception in crypto"+e.getMessage());
		}
		return encrypted;
	}
	
	
	/**
	 * Decrypts the crypto data and returns the plain text.
	 * 
	 * @param cryptoData {@link String}
	 * 
	 * @return plainText {@link String}
	 */
	public static String getDecryptedData(String cryptoData){
		String plainText=null;
		try {
			TripleDesCipher cipher = new TripleDesCipher();
			cipher.setKey(key);
			plainText = cipher.decrypt(cryptoData);
		} catch (Exception e) {
			AppClientFactory.printSevereLogger("Exception in crypto decrypt"+e.getMessage());
		}
		return plainText;
	}
	

	public static native String removeHtml(String htmText) /*-{
		var regex = /(<([^>]+)>)/ig;
		result = htmText.replace(regex, "");
		return result;
	}-*/;
	
	/**
	 * 
	 * @function SysOut 
	 * 
	 * @created_date : 24-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param message
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public static void SysOut(String message){
//		System.out.println(message);
	}
	/**
	 * To set the default image based on collectionType value
	 * @param collectionType {@link String}
	 */
	public static void setDefaultImages(String collectionType, Image imgField, String borderSize) {
		String borderColor="";
		if(collectionType!=null){
			if(collectionType.contains(ASSESSMENT)){
				borderColor= borderSize.equals("high")?"border-left: 10px solid #feae29;":(borderSize.equals("toc")?"border-left: 5px solid #feae29;":"border-left: 8px solid #feae29;");
				imgField.setUrl(DEFULT_ASSESSMENT);
		    }else{
		    	borderColor= borderSize.equals("high")?"border-left: 10px solid #1076bb;":(borderSize.equals("toc")?"border-left: 5px solid #1076bb;":"border-left: 8px solid #1076bb;");
		    	imgField.setUrl(DEFULT_COLLECTION);
		    }
			imgField.getElement().setAttribute("style", borderColor);
		}
	}
	
	private static RegExp urlValidator;
	private static RegExp urlPlusTldValidator;
	/**
	 * @function isValidUrl 
	 * 
	 * @description
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param topLevelDomainRequired
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public static boolean isValidUrl(String url, boolean topLevelDomainRequired) {
		int count = returnCount(url);
		 if(count > 2)
	         return false;
		if (urlValidator == null || urlPlusTldValidator == null) {
			urlValidator = RegExp
					.compile("^((ftp|http|https)://[\\w@.\\-\\_\\()]+(:\\d{1,5})?(/[\\?%&=]+)*)");
			
			urlPlusTldValidator = RegExp
					.compile("^((ftp|http|https)://[\\w@.\\-\\_\\()]+(:\\d{1,5})?(/[\\?%&=]+)*)");

					}
		return (topLevelDomainRequired ? urlPlusTldValidator : urlValidator)
				.exec(url) != null;
	}
	/**
	 * @function returnCount 
	 * 
	 * @description
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @return
	 * 
	 * @return : Integer
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public static Integer returnCount(String url) {
		String string = url;
		String substring1 = "http:";
		String substring2 = "https:";
		String substring3 = "ftp:";
		String substring4 = "www";
		Integer count = 0;
		Integer idx = 0;
		while ((idx = string.indexOf(substring1, idx)) != -1) {
			idx++;
			count++;
		}
		idx = 0;
		while ((idx = string.indexOf(substring2, idx)) != -1) {
			idx++;
			count++;
		}
		idx = 0;
		while ((idx = string.indexOf(substring3, idx)) != -1) {
			idx++;
			count++;
		}
		idx = 0;
		while ((idx = string.indexOf(substring4, idx)) != -1) {
			idx++;
			count++;
		}
		return count;
	}
	public static boolean checkUrlContainesGooruUrl(String url){
		if (url.contains("goorulearning.org")|| url.contains("support.goorulearning.org")|| url.contains("about.goorulearning.org")) {
			return true;
		} else {
			return false;
		 }
	}
}
