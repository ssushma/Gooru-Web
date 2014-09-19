package org.ednovo.gooru.client.mvp.analytics.util;

import java.util.Date;
import java.util.List;

import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;

public class AnalyticsUtil {
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String DATE_FORMAT="MM/dd/yyyy hh:mm:ss aaa";
	
	public static String getOrdinalSuffix(int value) {
		int hunRem = value % 100;
		int tenRem = value % 10;
		if (hunRem - tenRem == 10) {
			return "th";
		}
		switch (tenRem) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}
	/**
	 * This is used to convert list integer to int[]
	 * @param integerList
	 * @return
	 */
	public static int[] toIntArray(List<Integer> integerList) {  
        int[] intArray = new int[integerList.size()];  
        for (int i = 0; i < integerList.size(); i++) {  
            intArray[i] = integerList.get(i);  
        }  
        return intArray;  
    }
	/**
	 * To remove html tags in a string
	 * @param html
	 * @return
	 */
	public static String html2text(String html) {
		String text = html.replaceAll("\\<.*?\\>", "");
	    return text;
	}
	/**
	 * @function getCreatedTime 
	 * 
	 * @created_date : 06-Jan-2014
	 * 
	 * @description
	 * 
	 * @parm(s) : @param commentCreatedTime
	 * 
	 * @return : String
	 */
	public static String getCreatedTime(String commentCreatedTime) {
		String createdTime = null;
		Long currentTime = System.currentTimeMillis();
		Long commentTime = Long.parseLong(commentCreatedTime);
		Long elapsedTime = (currentTime - commentTime);
		int seconds = (int) (elapsedTime / 1000) % 60 ;
		int minutes = (int) ((elapsedTime / (1000*60)) % 60);
		int hours   = (int) ((elapsedTime / (1000*60*60)) % 24);
		int days = (int) (elapsedTime / (1000*60*60*24));
		Date currentDate = new Date(commentTime);
		DateTimeFormat fmt = DateTimeFormat.getFormat (DATE_FORMAT);
		if(days>6){
			createdTime = fmt.format (currentDate);
		}
		else if(days>0&&days<=6) {
			createdTime = days + getTimePrefix(days," "+i18n.GL0562(), i18n.GL0579(), i18n.GL0580());
		} else if(hours>0&&hours<24) {
			createdTime = hours + getTimePrefix(hours," "+i18n.GL0563(), i18n.GL1435(), i18n.GL1436());
		} else if(minutes>0&&minutes<60) {
			createdTime = minutes + getTimePrefix(minutes," "+i18n.GL0564(), i18n.GL1437(), i18n.GL1438());
		} else if(seconds<=60) {
			createdTime = i18n.GL0561();
		}
		return createdTime;
	}
	/**
	 * @function getTimePrefix 
	 * 
	 * @created_date : 06-Jan-2014
	 * 
	 * @description
	 * 
	 * @parm(s) : @param count
	 * @parm(s) : @param msg
	 * @parm(s) : @param regex
	 * @parm(s) : @param replacement
	 * 
	 * @return : String
	 *
	 */
	public static String getTimePrefix(int count, String msg, String regex, String replacement) {
		if(count==1) {
			msg = msg.replaceAll(regex, replacement);
		}
		return msg;
	}	
	/**
	 * This is used to convert long time format
	 * @param commentCreatedTime
	 * @return
	 */
	public static String getTimeSpent(Long commentCreatedTime) {
		String createdTime = null;
		int seconds = (int) (commentCreatedTime / 1000) % 60 ;
		int minutes = (int) ((commentCreatedTime / (1000*60)) % 60);
		int hours   = (int) ((commentCreatedTime / (1000*60*60)) % 24);
		int days = (int) (commentCreatedTime / (1000*60*60*24));
		if(days!=0){
			createdTime=days+":";
		}
		if(hours!=0){
			if(createdTime!=null){
				createdTime=createdTime+hours+" ";
			}else{
				createdTime=hours+" ";
			}
		}
		if(minutes!=0){
			if(createdTime!=null){
				createdTime=createdTime+((minutes<10)?"0"+minutes+"min":minutes+"min")+" ";
			}else{
				createdTime=((minutes<10)?"0"+minutes+"min":minutes+"min")+" ";
			}
		}
		if(seconds!=0){
			if(createdTime!=null){
				createdTime=createdTime+((seconds<10)?"0"+seconds+"sec":seconds+"sec")+"";
			}else{
				createdTime="0min"+" "+((seconds<10)?"0"+seconds+"sec":seconds+"sec")+"";
			}
		}
		return createdTime;
	}
	/**
	 * This will return the char based on the passed integer.
	 * @param i
	 * @return
	 */
	public static String getCharForNumber(int i) {
	    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    if (i > 25) {
	        return null;
	    }
	    return Character.toString(alphabet[i]);
	}

	
}
